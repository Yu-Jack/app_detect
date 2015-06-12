// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Arrays;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.regex.Matcher;
import java.util.Iterator;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.CountDownLatch;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class DataLayer
{
    static final String LIFETIME_KEY = "gtm.lifetime";
    static final String[] LIFETIME_KEY_COMPONENTS;
    private static final Pattern LIFETIME_PATTERN;
    static final int MAX_QUEUE_DEPTH = 500;
    public static final Object OBJECT_NOT_PRESENT;
    private final ConcurrentHashMap<Listener, Integer> mListeners;
    private final Map<Object, Object> mModel;
    private final PersistentStore mPersistentStore;
    private final CountDownLatch mPersistentStoreLoaded;
    private final ReentrantLock mPushLock;
    private final LinkedList<Map<Object, Object>> mUpdateQueue;
    
    static {
        OBJECT_NOT_PRESENT = new Object();
        LIFETIME_KEY_COMPONENTS = "gtm.lifetime".toString().split("\\.");
        LIFETIME_PATTERN = Pattern.compile("(\\d+)\\s*([smhd]?)");
    }
    
    DataLayer() {
        this((PersistentStore)new PersistentStore() {
            @Override
            public void clearKeysWithPrefix(final String s) {
            }
            
            @Override
            public void loadSaved(final Callback callback) {
                callback.onKeyValuesLoaded(new ArrayList<KeyValue>());
            }
            
            @Override
            public void saveKeyValues(final List<KeyValue> list, final long n) {
            }
        });
    }
    
    DataLayer(final PersistentStore mPersistentStore) {
        this.mPersistentStore = mPersistentStore;
        this.mListeners = new ConcurrentHashMap<Listener, Integer>();
        this.mModel = new HashMap<Object, Object>();
        this.mPushLock = new ReentrantLock();
        this.mUpdateQueue = new LinkedList<Map<Object, Object>>();
        this.mPersistentStoreLoaded = new CountDownLatch(1);
        this.loadSavedMaps();
    }
    
    private List<KeyValue> flattenMap(final Map<Object, Object> map) {
        final ArrayList<KeyValue> list = new ArrayList<KeyValue>();
        this.flattenMapHelper(map, "", list);
        return list;
    }
    
    private void flattenMapHelper(final Map<Object, Object> map, final String str, final Collection<KeyValue> collection) {
        for (final Map.Entry<Object, Object> entry : map.entrySet()) {
            final StringBuilder append = new StringBuilder().append(str);
            String str2;
            if (str.length() == 0) {
                str2 = "";
            }
            else {
                str2 = ".";
            }
            final String string = append.append(str2).append(entry.getKey()).toString();
            if (entry.getValue() instanceof Map) {
                this.flattenMapHelper(entry.getValue(), string, collection);
            }
            else {
                if (string.equals("gtm.lifetime")) {
                    continue;
                }
                collection.add(new KeyValue(string, entry.getValue()));
            }
        }
    }
    
    private Object getLifetimeObject(final Map<Object, Object> map) {
        Object value = map;
        for (final String s : DataLayer.LIFETIME_KEY_COMPONENTS) {
            if (!(value instanceof Map)) {
                value = null;
                break;
            }
            value = ((Map<K, Object>)value).get(s);
        }
        return value;
    }
    
    private Long getLifetimeValue(final Map<Object, Object> map) {
        final Object lifetimeObject = this.getLifetimeObject(map);
        if (lifetimeObject == null) {
            return null;
        }
        return parseLifetime(lifetimeObject.toString());
    }
    
    public static List<Object> listOf(final Object... array) {
        final ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 0; i < array.length; ++i) {
            list.add(array[i]);
        }
        return list;
    }
    
    private void loadSavedMaps() {
        this.mPersistentStore.loadSaved((Callback)new Callback() {
            @Override
            public void onKeyValuesLoaded(final List<KeyValue> list) {
                for (final KeyValue keyValue : list) {
                    DataLayer.this.pushWithoutWaitingForSaved(DataLayer.this.expandKeyValue(keyValue.mKey, keyValue.mValue));
                }
                DataLayer.this.mPersistentStoreLoaded.countDown();
            }
        });
    }
    
    public static Map<Object, Object> mapOf(final Object... array) {
        if (array.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        for (int i = 0; i < array.length; i += 2) {
            hashMap.put(array[i], array[i + 1]);
        }
        return hashMap;
    }
    
    private void notifyListeners(final Map<Object, Object> map) {
        final Iterator<Listener> iterator = this.mListeners.keySet().iterator();
        while (iterator.hasNext()) {
            iterator.next().changed(map);
        }
    }
    
    @VisibleForTesting
    static Long parseLifetime(final String str) {
        final Matcher matcher = DataLayer.LIFETIME_PATTERN.matcher(str);
        if (!matcher.matches()) {
            Log.i("unknown _lifetime: " + str);
            return null;
        }
        long long1 = 0L;
        while (true) {
            try {
                long1 = Long.parseLong(matcher.group(1));
                if (long1 <= 0L) {
                    Log.i("non-positive _lifetime: " + str);
                    return null;
                }
            }
            catch (NumberFormatException ex) {
                Log.w("illegal number in _lifetime value: " + str);
                continue;
            }
            break;
        }
        final String group = matcher.group(2);
        if (group.length() == 0) {
            return long1;
        }
        switch (group.charAt(0)) {
            default: {
                Log.w("unknown units in _lifetime: " + str);
                return null;
            }
            case 's': {
                return long1 * 1000L;
            }
            case 'm': {
                return 60L * (long1 * 1000L);
            }
            case 'h': {
                return 60L * (60L * (long1 * 1000L));
            }
            case 'd': {
                return 24L * (60L * (60L * (long1 * 1000L)));
            }
        }
    }
    
    private void processQueuedUpdates() {
        int n = 0;
        do {
            final Map<Object, Object> map = this.mUpdateQueue.poll();
            if (map == null) {
                return;
            }
            this.processUpdate(map);
        } while (++n <= 500);
        this.mUpdateQueue.clear();
        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
    }
    
    private void processUpdate(final Map<Object, Object> map) {
        synchronized (this.mModel) {
            for (final Object next : map.keySet()) {
                this.mergeMap(this.expandKeyValue(next, map.get(next)), this.mModel);
            }
        }
        // monitorexit(map2)
        this.notifyListeners(map);
    }
    
    private void pushWithoutWaitingForSaved(final Map<Object, Object> e) {
        this.mPushLock.lock();
        try {
            this.mUpdateQueue.offer(e);
            if (this.mPushLock.getHoldCount() == 1) {
                this.processQueuedUpdates();
            }
            this.savePersistentlyIfNeeded(e);
        }
        finally {
            this.mPushLock.unlock();
        }
    }
    
    private void savePersistentlyIfNeeded(final Map<Object, Object> map) {
        final Long lifetimeValue = this.getLifetimeValue(map);
        if (lifetimeValue == null) {
            return;
        }
        final List<KeyValue> flattenMap = this.flattenMap(map);
        flattenMap.remove("gtm.lifetime");
        this.mPersistentStore.saveKeyValues(flattenMap, lifetimeValue);
    }
    
    void clearPersistentKeysWithPrefix(final String s) {
        this.push(s, null);
        this.mPersistentStore.clearKeysWithPrefix(s);
    }
    
    Map<Object, Object> expandKeyValue(final Object o, final Object o2) {
        Map<K, V> map;
        final HashMap hashMap = (HashMap)(map = (Map<K, V>)new HashMap<String, Object>());
        final String[] split = o.toString().split("\\.");
        for (int i = 0; i < -1 + split.length; ++i) {
            final HashMap hashMap2 = new HashMap<String, HashMap<String, Object>>();
            map.put((K)split[i], (V)hashMap2);
            map = hashMap2;
        }
        map.put((K)split[-1 + split.length], (V)o2);
        return (Map<Object, Object>)hashMap;
    }
    
    public Object get(final String s) {
        while (true) {
            while (true) {
                int n;
                final Object value;
                synchronized (this.mModel) {
                    final Object mModel = this.mModel;
                    final String[] split = s.split("\\.");
                    final int length = split.length;
                    n = 0;
                    if (n >= length) {
                        return mModel;
                    }
                    final String s2 = split[n];
                    if (!(mModel instanceof Map)) {
                        return null;
                    }
                    value = ((Map<Object, Object>)mModel).get(s2);
                    if (value == null) {
                        return null;
                    }
                }
                final Object mModel = value;
                ++n;
                continue;
            }
        }
    }
    
    @VisibleForTesting
    void mergeList(final List<Object> list, final List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); ++i) {
            final ArrayList<Object> value = list.get(i);
            if (value instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList<Object>());
                }
                this.mergeList(value, list2.get(i));
            }
            else if (value instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                this.mergeMap((Map<Object, Object>)value, (Map)list2.get(i));
            }
            else if (value != DataLayer.OBJECT_NOT_PRESENT) {
                list2.set(i, value);
            }
        }
    }
    
    @VisibleForTesting
    void mergeMap(final Map<Object, Object> map, final Map<Object, Object> map2) {
        for (final Object next : map.keySet()) {
            final ArrayList<Object> value = map.get(next);
            if (value instanceof List) {
                if (!(map2.get(next) instanceof List)) {
                    map2.put(next, new ArrayList<Object>());
                }
                this.mergeList(value, map2.get(next));
            }
            else if (value instanceof Map) {
                if (!(map2.get(next) instanceof Map)) {
                    map2.put(next, new HashMap());
                }
                this.mergeMap((Map<Object, Object>)value, (Map)map2.get(next));
            }
            else {
                map2.put(next, value);
            }
        }
    }
    
    public void push(final Object o, final Object o2) {
        this.push(this.expandKeyValue(o, o2));
    }
    
    public void push(final Map<Object, Object> map) {
        while (true) {
            try {
                this.mPersistentStoreLoaded.await();
                this.pushWithoutWaitingForSaved(map);
            }
            catch (InterruptedException ex) {
                Log.w("DataLayer.push: unexpected InterruptedException");
                continue;
            }
            break;
        }
    }
    
    void registerListener(final Listener key) {
        this.mListeners.put(key, 0);
    }
    
    void unregisterListener(final Listener key) {
        this.mListeners.remove(key);
    }
    
    static final class KeyValue
    {
        public final String mKey;
        public final Object mValue;
        
        KeyValue(final String mKey, final Object mValue) {
            this.mKey = mKey;
            this.mValue = mValue;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (o instanceof KeyValue) {
                final KeyValue keyValue = (KeyValue)o;
                if (this.mKey.equals(keyValue.mKey) && this.mValue.equals(keyValue.mValue)) {
                    return true;
                }
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return Arrays.hashCode(new Integer[] { this.mKey.hashCode(), this.mValue.hashCode() });
        }
        
        @Override
        public String toString() {
            return "Key: " + this.mKey + " value: " + this.mValue.toString();
        }
    }
    
    interface Listener
    {
        void changed(Map<Object, Object> p0);
    }
    
    interface PersistentStore
    {
        void clearKeysWithPrefix(String p0);
        
        void loadSaved(Callback p0);
        
        void saveKeyValues(List<KeyValue> p0, long p1);
        
        public interface Callback
        {
            void onKeyValuesLoaded(List<KeyValue> p0);
        }
    }
}
