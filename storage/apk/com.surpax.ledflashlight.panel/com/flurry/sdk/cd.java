// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import com.flurry.android.impl.ads.avro.protocol.v10.SdkAdEvent;
import com.flurry.android.impl.ads.avro.protocol.v10.SdkAdLog;
import java.util.ArrayList;
import java.util.List;

public final class cd
{
    public static List a(final List list) {
        final ArrayList<SdkAdLog> list2 = new ArrayList<SdkAdLog>();
        if (list == null) {
            return list2;
        }
    Label_0072_Outer:
        for (final e e : list) {
            final SdkAdLog sdkAdLog = new SdkAdLog();
            sdkAdLog.a(Long.valueOf(e.c()));
            while (true) {
                Label_0247: {
                    if (e.b() != null) {
                        break Label_0247;
                    }
                    final String b = "";
                    ArrayList<SdkAdEvent> list3;
                    while (true) {
                        sdkAdLog.a(b);
                        list3 = new ArrayList<SdkAdEvent>();
                        while (true) {
                            final SdkAdEvent sdkAdEvent;
                            final HashMap<Object, Object> hashMap;
                            Label_0256: {
                                synchronized (e) {
                                    Block_7: {
                                        for (final c c : e.d()) {
                                            if (c.b()) {
                                                break Block_7;
                                            }
                                        }
                                        break;
                                    }
                                    sdkAdEvent = new SdkAdEvent();
                                    final c c;
                                    sdkAdEvent.a(c.a());
                                    sdkAdEvent.a(Long.valueOf(c.c()));
                                    final Map d = c.d();
                                    hashMap = new HashMap<Object, Object>();
                                    for (final Map.Entry<Object, V> entry : d.entrySet()) {
                                        hashMap.put(entry.getKey(), entry.getValue());
                                    }
                                    break Label_0256;
                                }
                                break Label_0247;
                            }
                            sdkAdEvent.a(hashMap);
                            list3.add(sdkAdEvent);
                            continue;
                        }
                    }
                    sdkAdLog.a(list3);
                    list2.add(sdkAdLog);
                    continue Label_0072_Outer;
                }
                final String b = e.b();
                continue;
            }
        }
        return list2;
    }
}
