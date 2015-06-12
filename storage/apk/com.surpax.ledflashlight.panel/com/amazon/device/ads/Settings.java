// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Iterator;
import java.util.Map;
import android.content.Context;
import android.os.Build$VERSION;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class Settings
{
    private static final String LOG_TAG;
    private static final String PREFS_NAME = "AmazonMobileAds";
    public static final String SETTING_ENABLE_WEBVIEW_PAUSE_LOGIC = "shouldPauseWebViewTimersInWebViewRelatedActivities";
    protected static final String SETTING_TESTING_ENABLED = "testingEnabled";
    protected static final String SETTING_TLS_ENABLED = "tlsEnabled";
    private static Settings instance;
    private final ConcurrentHashMap cache;
    private ArrayList listeners;
    private final ReentrantLock listenersLock;
    private final CountDownLatch settingsLoadedLatch;
    private SharedPreferences sharedPreferences;
    private final ReentrantLock writeToSharedPreferencesLock;
    
    static {
        LOG_TAG = Settings.class.getSimpleName();
        Settings.instance = new Settings();
    }
    
    protected Settings() {
        this.listeners = new ArrayList();
        this.listenersLock = new ReentrantLock();
        this.writeToSharedPreferencesLock = new ReentrantLock();
        this.settingsLoadedLatch = new CountDownLatch(1);
        this.cache = new ConcurrentHashMap();
    }
    
    private void commit(final SharedPreferences$Editor sharedPreferences$Editor) {
        if (ThreadUtils.isOnMainThread()) {
            Log.e(Settings.LOG_TAG, "Committing settings must be executed on a background thread.");
        }
        if (Build$VERSION.SDK_INT >= 9) {
            AndroidTargetUtils.editorApply(sharedPreferences$Editor);
            return;
        }
        sharedPreferences$Editor.commit();
    }
    
    public static Settings getInstance() {
        return Settings.instance;
    }
    
    private void putSetting(final String s, final Settings$Value settings$Value) {
        this.putSettingWithNoFlush(s, settings$Value);
        if (!settings$Value.isTransientData && this.isSettingsLoaded()) {
            this.flush();
        }
    }
    
    private void putSettingWithNoFlush(final String key, final Settings$Value value) {
        this.cache.put(key, value);
    }
    
    protected static void reset() {
        Settings.instance = new Settings();
    }
    
    protected static void setInstance(final Settings instance) {
        Settings.instance = instance;
    }
    
    private void writeCacheToSharedPreferences() {
        this.writeCacheToSharedPreferences(this.sharedPreferences);
    }
    
    protected void beginFetch(final Context context) {
        ThreadUtils.executeRunnable(new Runnable() {
            @Override
            public void run() {
                Settings.this.fetchSharedPreferences(context);
            }
        });
    }
    
    protected void cacheAdditionalEntries(final Map map) {
        for (final Map.Entry<String, V> entry : map.entrySet()) {
            final String s = entry.getKey();
            if (s != null && !this.cache.containsKey(s)) {
                final V value = entry.getValue();
                this.cache.put(s, new Settings$Value(this, value.getClass(), value));
            }
        }
    }
    
    public boolean containsKey(final String key) {
        return this.cache.containsKey(key);
    }
    
    public void contextReceived(final Context context) {
        if (context == null) {
            return;
        }
        this.beginFetch(context);
    }
    
    protected void fetchSharedPreferences(final Context context) {
        if (!this.isSettingsLoaded()) {
            final SharedPreferences sharedPreferencesFromContext = this.getSharedPreferencesFromContext(context);
            this.readSharedPreferencesIntoCache(sharedPreferencesFromContext);
            this.writeCacheToSharedPreferences(this.sharedPreferences = sharedPreferencesFromContext);
        }
        this.settingsLoadedLatch.countDown();
        this.notifySettingsListeners();
    }
    
    public void flush() {
        this.writeCacheToSharedPreferences();
    }
    
    public Boolean getBoolean(final String key, final Boolean b) {
        final Settings$Value settings$Value = this.cache.get(key);
        if (settings$Value == null) {
            return b;
        }
        return (Boolean)settings$Value.value;
    }
    
    public boolean getBoolean(final String s, final boolean b) {
        final Boolean boolean1 = this.getBoolean(s, null);
        if (boolean1 == null) {
            return b;
        }
        return boolean1;
    }
    
    protected ConcurrentHashMap getCache() {
        return this.cache;
    }
    
    public int getInt(final String key, final int n) {
        final Settings$Value settings$Value = this.cache.get(key);
        if (settings$Value == null) {
            return n;
        }
        return (int)settings$Value.value;
    }
    
    public long getLong(final String key, final long n) {
        final Settings$Value settings$Value = this.cache.get(key);
        if (settings$Value == null) {
            return n;
        }
        return (long)settings$Value.value;
    }
    
    protected SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }
    
    protected SharedPreferences getSharedPreferencesFromContext(final Context context) {
        return context.getSharedPreferences("AmazonMobileAds", 0);
    }
    
    public String getString(final String key, final String s) {
        final Settings$Value settings$Value = this.cache.get(key);
        if (settings$Value == null) {
            return s;
        }
        return (String)settings$Value.value;
    }
    
    public boolean isSettingsLoaded() {
        return this.sharedPreferences != null;
    }
    
    public void listenForSettings(final Settings$SettingsListener e) {
        this.listenersLock.lock();
        if (this.isSettingsLoaded()) {
            e.settingsLoaded();
        }
        else {
            this.listeners.add(e);
        }
        this.listenersLock.unlock();
    }
    
    protected void notifySettingsListeners() {
        this.listenersLock.lock();
        final Iterator<Settings$SettingsListener> iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().settingsLoaded();
        }
        this.listeners.clear();
        this.listeners = null;
        this.listenersLock.unlock();
    }
    
    public void putBoolean(final String s, final boolean b) {
        this.putSetting(s, new Settings$Value(this, Boolean.class, b));
    }
    
    public void putBooleanWithNoFlush(final String s, final boolean b) {
        this.putSettingWithNoFlush(s, new Settings$Value(this, Boolean.class, b));
    }
    
    public void putInt(final String s, final int i) {
        this.putSetting(s, new Settings$Value(this, Integer.class, i));
    }
    
    public void putIntWithNoFlush(final String s, final int i) {
        this.putSettingWithNoFlush(s, new Settings$Value(this, Integer.class, i));
    }
    
    public void putLong(final String s, final long l) {
        this.putSetting(s, new Settings$Value(this, Long.class, l));
    }
    
    public void putLongWithNoFlush(final String s, final long l) {
        this.putSettingWithNoFlush(s, new Settings$Value(this, Long.class, l));
    }
    
    public void putString(final String s, final String s2) {
        this.putSetting(s, new Settings$Value(this, String.class, s2));
    }
    
    public void putStringWithNoFlush(final String s, final String s2) {
        this.putSettingWithNoFlush(s, new Settings$Value(this, String.class, s2));
    }
    
    public void putTransientBoolean(final String s, final boolean b) {
        this.putSettingWithNoFlush(s, new Settings$TransientValue(this, Boolean.class, b));
    }
    
    public void putTransientInt(final String s, final int i) {
        this.putSettingWithNoFlush(s, new Settings$TransientValue(this, Integer.class, i));
    }
    
    public void putTransientLong(final String s, final long l) {
        this.putSettingWithNoFlush(s, new Settings$TransientValue(this, Long.class, l));
    }
    
    public void putTransientString(final String s, final String s2) {
        this.putSettingWithNoFlush(s, new Settings$TransientValue(this, String.class, s2));
    }
    
    protected void readSharedPreferencesIntoCache(final SharedPreferences sharedPreferences) {
        this.cacheAdditionalEntries(sharedPreferences.getAll());
    }
    
    public void remove(final String key) {
        final Settings$Value settings$Value = this.cache.remove(key);
        if (settings$Value != null && !settings$Value.isTransientData && this.isSettingsLoaded()) {
            this.flush();
        }
    }
    
    public void removeWithNoFlush(final String key) {
        this.cache.remove(key);
    }
    
    protected void writeCacheToSharedPreferences(final SharedPreferences sharedPreferences) {
        ThreadUtils.executeRunnable(new Runnable() {
            @Override
            public void run() {
                Settings.this.writeToSharedPreferencesLock.lock();
                final SharedPreferences$Editor edit = sharedPreferences.edit();
                edit.clear();
                for (final Map.Entry<K, Settings$Value> entry : Settings.this.cache.entrySet()) {
                    final Settings$Value settings$Value = entry.getValue();
                    if (!settings$Value.isTransientData) {
                        if (settings$Value.clazz == String.class) {
                            edit.putString((String)entry.getKey(), (String)settings$Value.value);
                        }
                        else if (settings$Value.clazz == Long.class) {
                            edit.putLong((String)entry.getKey(), (long)settings$Value.value);
                        }
                        else if (settings$Value.clazz == Integer.class) {
                            edit.putInt((String)entry.getKey(), (int)settings$Value.value);
                        }
                        else {
                            if (settings$Value.clazz != Boolean.class) {
                                continue;
                            }
                            edit.putBoolean((String)entry.getKey(), (boolean)settings$Value.value);
                        }
                    }
                }
                Settings.this.commit(edit);
                Settings.this.writeToSharedPreferencesLock.unlock();
            }
        });
    }
}
