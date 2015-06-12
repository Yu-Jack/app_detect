// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.content;

import java.util.Set;
import android.net.Uri;
import android.util.Log;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import android.content.Context;

public final class e
{
    private static final Object f;
    private static e g;
    private final Context a;
    private final HashMap b;
    private final HashMap c;
    private final ArrayList d;
    private final Handler e;
    
    static {
        f = new Object();
    }
    
    private e(final Context a) {
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new ArrayList();
        this.a = a;
        this.e = new Handler(a.getMainLooper()) {
            public final void handleMessage(final Message message) {
                switch (message.what) {
                    default: {
                        super.handleMessage(message);
                    }
                    case 1: {
                        android.support.v4.content.e.a(android.support.v4.content.e.this);
                    }
                }
            }
        };
    }
    
    public static e a(final Context context) {
        synchronized (e.f) {
            if (e.g == null) {
                e.g = new e(context.getApplicationContext());
            }
            return e.g;
        }
    }
    
    static /* synthetic */ void a(final e e) {
    Label_0050_Outer:
        while (true) {
            while (true) {
                int n;
                synchronized (e.b) {
                    final int size = e.d.size();
                    if (size <= 0) {
                        return;
                    }
                    final f[] a = new f[size];
                    e.d.toArray(a);
                    e.d.clear();
                    // monitorexit(e.b)
                    n = 0;
                    if (n >= a.length) {
                        continue Label_0050_Outer;
                    }
                    final f f = a[n];
                    for (int i = 0; i < f.b.size(); ++i) {
                        ((g)f.b.get(i)).b.onReceive(e.a, f.a);
                    }
                }
                ++n;
                continue;
            }
        }
    }
    
    public final void a(final BroadcastReceiver key) {
    Label_0028_Outer:
        while (true) {
            ArrayList<IntentFilter> list;
            ArrayList<g> list2;
            int n;
            IntentFilter intentFilter;
            int n2 = 0;
            String action;
            int index = 0;
            int n3 = 0;
            Label_0094_Outer:Label_0053_Outer:
            while (true) {
            Label_0053:
                while (true) {
                Label_0094:
                    while (true) {
                        Label_0180: {
                            Label_0174: {
                                synchronized (this.b) {
                                    list = this.b.remove(key);
                                    if (list == null) {
                                        return;
                                    }
                                    break Label_0174;
                                    // iftrue(Label_0167:, (g)list2.get(n).b != key)
                                    // iftrue(Label_0189:, list2 == null)
                                    // iftrue(Label_0159:, index >= list.size())
                                    // iftrue(Label_0195:, n2 >= intentFilter.countActions())
                                    // iftrue(Label_0189:, list2.size() > 0)
                                    // iftrue(Label_0138:, n >= list2.size())
                                Block_5_Outer:
                                    while (true) {
                                        while (true) {
                                            while (true) {
                                                Block_8: {
                                                    break Block_8;
                                                    action = intentFilter.getAction(n2);
                                                    list2 = (ArrayList<g>)this.c.get(action);
                                                    Block_6: {
                                                        break Block_6;
                                                        break Block_5_Outer;
                                                    }
                                                    n = 0;
                                                    break Label_0094;
                                                    this.c.remove(action);
                                                    break Label_0094;
                                                    Label_0159: {
                                                        return;
                                                    }
                                                }
                                                list2.remove(n);
                                                n3 = n - 1;
                                                break Label_0180;
                                                continue Label_0028_Outer;
                                            }
                                            Label_0138: {
                                                continue Label_0053_Outer;
                                            }
                                        }
                                        continue Block_5_Outer;
                                    }
                                    intentFilter = list.get(index);
                                    n2 = 0;
                                    continue Label_0053;
                                }
                                Label_0167: {
                                    n3 = n;
                                }
                                break Label_0180;
                            }
                            index = 0;
                            continue Label_0094_Outer;
                        }
                        n = n3 + 1;
                        continue Label_0094;
                    }
                    ++n2;
                    continue Label_0053;
                }
                Label_0195: {
                    ++index;
                }
                continue Label_0094_Outer;
            }
        }
    }
    
    public final void a(final BroadcastReceiver broadcastReceiver, final IntentFilter e) {
        synchronized (this.b) {
            final g e2 = new g(e, broadcastReceiver);
            ArrayList<IntentFilter> value = this.b.get(broadcastReceiver);
            if (value == null) {
                value = new ArrayList<IntentFilter>(1);
                this.b.put(broadcastReceiver, value);
            }
            value.add(e);
            for (int i = 0; i < e.countActions(); ++i) {
                final String action = e.getAction(i);
                ArrayList<?> value2 = this.c.get(action);
                if (value2 == null) {
                    value2 = new ArrayList<Object>(1);
                    this.c.put(action, value2);
                }
                value2.add(e2);
            }
        }
    }
    
    public final boolean a(final Intent obj) {
        // monitorexit(hashMap)
        while (true) {
            while (true) {
                String action;
                String resolveTypeIfNeeded;
                Uri data;
                String scheme;
                Set categories;
                int n;
                ArrayList<g> obj2;
                ArrayList<g> list;
                g e;
                int match;
                int index;
                ArrayList<g> list2 = null;
                String str;
                int i;
                Label_0490_Outer:Label_0466_Outer:Block_4_Outer:
                while (true) {
                Label_0490:
                    while (true) {
                        Label_0309_Outer:Label_0156_Outer:
                        while (true) {
                            Label_0500: {
                                while (true) {
                                Label_0309:
                                    while (true) {
                                        synchronized (this.b) {
                                            action = obj.getAction();
                                            resolveTypeIfNeeded = obj.resolveTypeIfNeeded(this.a.getContentResolver());
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
                                            obj2 = this.c.get(obj.getAction());
                                            if (obj2 == null) {
                                                break;
                                            }
                                            if (n != 0) {
                                                Log.v("LocalBroadcastManager", "Action list: " + obj2);
                                            }
                                            break Label_0309;
                                            Block_12_Outer:Block_13_Outer:
                                            while (true) {
                                                list = new ArrayList<g>();
                                                break Label_0309;
                                                Label_0237: {
                                                    match = e.a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                                                }
                                                Label_0295: {
                                                    while (true) {
                                                        Label_0209: {
                                                            while (true) {
                                                            Block_11:
                                                                while (true) {
                                                                    Block_15: {
                                                                        break Block_15;
                                                                        Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                                                                        break Label_0295;
                                                                        Log.v("LocalBroadcastManager", "Matching against filter " + e.a);
                                                                        break Label_0209;
                                                                        break Block_11;
                                                                        list.add(e);
                                                                        e.c = true;
                                                                        break Label_0490;
                                                                    }
                                                                    continue Block_12_Outer;
                                                                }
                                                                e = obj2.get(index);
                                                                continue Label_0156_Outer;
                                                            }
                                                            while (true) {
                                                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                                                                list = list2;
                                                                break Label_0490;
                                                                continue Block_13_Outer;
                                                            }
                                                        }
                                                        continue Label_0466_Outer;
                                                    }
                                                }
                                                continue Label_0309_Outer;
                                            }
                                        }
                                        // iftrue(Label_0331:, match < 0)
                                        // iftrue(Label_0541:, index >= obj2.size())
                                        // iftrue(Label_0295:, n == 0)
                                        // iftrue(Label_0209:, n == 0)
                                        // iftrue(Label_0506:, n == 0)
                                        // iftrue(Label_0237:, !e.c)
                                        // iftrue(Label_0474:, list2 != null)
                                        Label_0331: {
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
                                        break Label_0309_Outer;
                                        Label_0474:
                                        list = list2;
                                        continue Label_0309;
                                    }
                                    list2 = null;
                                    index = 0;
                                    continue Label_0490_Outer;
                                    ++index;
                                    list2 = list;
                                    continue Label_0490_Outer;
                                }
                            }
                            n = 0;
                            continue Label_0490_Outer;
                        }
                        list = list2;
                        continue Label_0490;
                    }
                    // monitorexit(hashMap)
                    while (true) {
                        while (true) {
                            return true;
                            this.e.sendEmptyMessage(1);
                            continue Block_4_Outer;
                        }
                        while (i < list2.size()) {
                            list2.get(i).c = false;
                            ++i;
                        }
                        this.d.add(new f(obj, list2));
                        continue;
                    }
                }
                // iftrue(Label_0466:, this.e.hasMessages(1))
                return false;
                Label_0541: {
                    if (list2 != null) {
                        i = 0;
                        continue;
                    }
                }
                break;
            }
            continue;
        }
    }
}
