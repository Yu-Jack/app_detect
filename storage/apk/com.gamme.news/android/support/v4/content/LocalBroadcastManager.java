// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.content;

import java.util.Set;
import android.net.Uri;
import android.util.Log;
import android.content.Intent;
import android.os.Message;
import android.os.Looper;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.os.Handler;
import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;

public class LocalBroadcastManager
{
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock;
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers;
    
    static {
        mLock = new Object();
    }
    
    private LocalBroadcastManager(final Context mAppContext) {
        this.mReceivers = new HashMap<BroadcastReceiver, ArrayList<IntentFilter>>();
        this.mActions = new HashMap<String, ArrayList<ReceiverRecord>>();
        this.mPendingBroadcasts = new ArrayList<BroadcastRecord>();
        this.mAppContext = mAppContext;
        this.mHandler = new Handler(mAppContext.getMainLooper()) {
            public void handleMessage(final Message message) {
                switch (message.what) {
                    default: {
                        super.handleMessage(message);
                    }
                    case 1: {
                        LocalBroadcastManager.this.executePendingBroadcasts();
                    }
                }
            }
        };
    }
    
    private void executePendingBroadcasts() {
    Label_0050_Outer:
        while (true) {
            while (true) {
                int n;
                synchronized (this.mReceivers) {
                    final int size = this.mPendingBroadcasts.size();
                    if (size <= 0) {
                        return;
                    }
                    final BroadcastRecord[] a = new BroadcastRecord[size];
                    this.mPendingBroadcasts.toArray(a);
                    this.mPendingBroadcasts.clear();
                    // monitorexit(this.mReceivers)
                    n = 0;
                    if (n >= a.length) {
                        continue Label_0050_Outer;
                    }
                    final BroadcastRecord broadcastRecord = a[n];
                    for (int i = 0; i < broadcastRecord.receivers.size(); ++i) {
                        ((ReceiverRecord)broadcastRecord.receivers.get(i)).receiver.onReceive(this.mAppContext, broadcastRecord.intent);
                    }
                }
                ++n;
                continue;
            }
        }
    }
    
    public static LocalBroadcastManager getInstance(final Context context) {
        synchronized (LocalBroadcastManager.mLock) {
            if (LocalBroadcastManager.mInstance == null) {
                LocalBroadcastManager.mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            return LocalBroadcastManager.mInstance;
        }
    }
    
    public void registerReceiver(final BroadcastReceiver broadcastReceiver, final IntentFilter e) {
        synchronized (this.mReceivers) {
            final ReceiverRecord e2 = new ReceiverRecord(e, broadcastReceiver);
            ArrayList<IntentFilter> value = this.mReceivers.get(broadcastReceiver);
            if (value == null) {
                value = new ArrayList<IntentFilter>(1);
                this.mReceivers.put(broadcastReceiver, value);
            }
            value.add(e);
            for (int i = 0; i < e.countActions(); ++i) {
                final String action = e.getAction(i);
                ArrayList<ReceiverRecord> value2 = this.mActions.get(action);
                if (value2 == null) {
                    value2 = new ArrayList<ReceiverRecord>(1);
                    this.mActions.put(action, value2);
                }
                value2.add(e2);
            }
        }
    }
    
    public boolean sendBroadcast(final Intent obj) {
        // monitorexit(hashMap)
        while (true) {
            while (true) {
                String action;
                String resolveTypeIfNeeded;
                Uri data;
                String scheme;
                Set categories;
                int n;
                ArrayList<ReceiverRecord> obj2;
                int match;
                ArrayList<ReceiverRecord> list = null;
                ReceiverRecord e;
                int index = 0;
                String str;
                int i;
                Label_0477_Outer:Block_4_Outer:
                while (true) {
                Label_0162_Outer:
                    while (true) {
                        Label_0500: {
                            while (true) {
                                Label_0494: {
                                    Label_0485: {
                                        synchronized (this.mReceivers) {
                                            action = obj.getAction();
                                            resolveTypeIfNeeded = obj.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
                                            data = obj.getData();
                                            scheme = obj.getScheme();
                                            categories = obj.getCategories();
                                            if ((0x8 & obj.getFlags()) == 0x0) {
                                                break Label_0500;
                                            }
                                            n = 1;
                                            if (n != 0) {
                                                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + obj);
                                            }
                                            obj2 = this.mActions.get(obj.getAction());
                                            if (obj2 == null) {
                                                break;
                                            }
                                            if (n != 0) {
                                                Log.v("LocalBroadcastManager", "Action list: " + obj2);
                                            }
                                            break Label_0485;
                                            // iftrue(Label_0317:, list != null)
                                            // iftrue(Label_0339:, match < 0)
                                            // iftrue(Label_0494:, n == 0)
                                            // iftrue(Label_0242:, !e.broadcasting)
                                            // iftrue(Label_0218:, n == 0)
                                            // iftrue(Label_0534:, index >= obj2.size())
                                            // iftrue(Label_0303:, n == 0)
                                            while (true) {
                                                Block_17: {
                                                    Block_14_Outer:Block_12_Outer:Block_11_Outer:
                                                    while (true) {
                                                        Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                                                        Block_15: {
                                                            while (true) {
                                                            Block_13_Outer:
                                                                while (true) {
                                                                    while (true) {
                                                                    Label_0218:
                                                                        while (true) {
                                                                            Label_0303: {
                                                                                break Label_0303;
                                                                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                                                                                break Label_0494;
                                                                            }
                                                                            break Block_17;
                                                                            Log.v("LocalBroadcastManager", "Matching against filter " + e.filter);
                                                                            break Label_0218;
                                                                            Label_0242: {
                                                                                match = e.filter.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                                                                            }
                                                                            break Block_15;
                                                                            continue Block_12_Outer;
                                                                        }
                                                                        continue Block_11_Outer;
                                                                    }
                                                                    e = obj2.get(index);
                                                                    continue Block_13_Outer;
                                                                }
                                                                continue Label_0162_Outer;
                                                            }
                                                        }
                                                        continue Block_14_Outer;
                                                    }
                                                    list.add(e);
                                                    e.broadcasting = true;
                                                    break Label_0494;
                                                }
                                                list = new ArrayList<ReceiverRecord>();
                                                continue Label_0477_Outer;
                                            }
                                        }
                                        Label_0339: {
                                            if (n != 0) {
                                                switch (match) {
                                                    default: {
                                                        str = "unknown reason";
                                                        break;
                                                    }
                                                    case -3: {
                                                        str = "action";
                                                        break;
                                                    }
                                                    case -4: {
                                                        str = "category";
                                                        break;
                                                    }
                                                    case -2: {
                                                        str = "data";
                                                        break;
                                                    }
                                                    case -1: {
                                                        str = "type";
                                                        break;
                                                    }
                                                }
                                                Log.v("LocalBroadcastManager", "  Filter did not match: " + str);
                                            }
                                        }
                                        break Label_0494;
                                    }
                                    index = 0;
                                    list = null;
                                    continue Label_0477_Outer;
                                }
                                ++index;
                                continue Label_0477_Outer;
                            }
                        }
                        n = 0;
                        continue Label_0477_Outer;
                    }
                    // monitorexit(hashMap)
                    while (true) {
                    Label_0439:
                        while (true) {
                            return true;
                            while (i < list.size()) {
                                list.get(i).broadcasting = false;
                                ++i;
                            }
                            break Label_0439;
                            this.mHandler.sendEmptyMessage(1);
                            continue Block_4_Outer;
                        }
                        this.mPendingBroadcasts.add(new BroadcastRecord(obj, list));
                        continue;
                    }
                }
                // iftrue(Label_0477:, this.mHandler.hasMessages(1))
                return false;
                Label_0534: {
                    if (list != null) {
                        i = 0;
                        continue;
                    }
                }
                break;
            }
            continue;
        }
    }
    
    public void sendBroadcastSync(final Intent intent) {
        if (this.sendBroadcast(intent)) {
            this.executePendingBroadcasts();
        }
    }
    
    public void unregisterReceiver(final BroadcastReceiver key) {
    Label_0053_Outer:
        while (true) {
        Label_0028:
            while (true) {
                int index = 0;
            Label_0053:
                while (true) {
                    ArrayList<IntentFilter> list;
                    int n = 0;
                    ArrayList<ReceiverRecord> list2;
                    IntentFilter intentFilter;
                    int n2 = 0;
                    String action;
                    Block_6_Outer:Block_5_Outer:Block_8_Outer:
                    while (true) {
                        Label_0170: {
                            Label_0164: {
                                synchronized (this.mReceivers) {
                                    list = this.mReceivers.remove(key);
                                    if (list == null) {
                                        return;
                                    }
                                    break Label_0164;
                                    // iftrue(Label_0135:, n >= list2.size())
                                    // iftrue(Label_0176:, list2 == null)
                                    // iftrue(Label_0156:, index >= list.size())
                                    // iftrue(Label_0182:, n2 >= intentFilter.countActions())
                                    // iftrue(Label_0176:, list2.size() > 0)
                                    while (true) {
                                        Block_7: {
                                            break Block_7;
                                            while (true) {
                                            Block_4_Outer:
                                                while (true) {
                                                    while (true) {
                                                        n = 0;
                                                        continue Block_6_Outer;
                                                        action = intentFilter.getAction(n2);
                                                        list2 = this.mActions.get(action);
                                                        continue Block_5_Outer;
                                                    }
                                                    Label_0156: {
                                                        return;
                                                    }
                                                    while (true) {
                                                        intentFilter = list.get(index);
                                                        n2 = 0;
                                                        break Label_0053;
                                                        continue Label_0053_Outer;
                                                    }
                                                    this.mActions.remove(action);
                                                    break Block_6_Outer;
                                                    list2.remove(n);
                                                    --n;
                                                    break Label_0170;
                                                    continue Block_4_Outer;
                                                }
                                                Label_0135: {
                                                    continue Block_8_Outer;
                                                }
                                            }
                                        }
                                        continue;
                                    }
                                }
                                // iftrue(Label_0170:, (ReceiverRecord)list2.get(n).receiver != key)
                            }
                            index = 0;
                            continue Label_0028;
                        }
                        ++n;
                        continue Label_0053_Outer;
                    }
                    ++n2;
                    continue Label_0053;
                }
                Label_0182: {
                    ++index;
                }
                continue Label_0028;
            }
        }
    }
    
    private static class BroadcastRecord
    {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;
        
        BroadcastRecord(final Intent intent, final ArrayList<ReceiverRecord> receivers) {
            this.intent = intent;
            this.receivers = receivers;
        }
    }
    
    private static class ReceiverRecord
    {
        boolean broadcasting;
        final IntentFilter filter;
        final BroadcastReceiver receiver;
        
        ReceiverRecord(final IntentFilter filter, final BroadcastReceiver receiver) {
            this.filter = filter;
            this.receiver = receiver;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.receiver);
            sb.append(" filter=");
            sb.append(this.filter);
            sb.append("}");
            return sb.toString();
        }
    }
}
