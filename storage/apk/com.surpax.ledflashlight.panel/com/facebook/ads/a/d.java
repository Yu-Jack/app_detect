// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import java.util.Iterator;
import org.json.JSONArray;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public final class d
{
    private static List a;
    
    static {
        d.a = new ArrayList();
    }
    
    public static String a() {
        final JSONArray jsonArray;
        synchronized (d.a) {
            if (d.a.isEmpty()) {
                return "";
            }
            final ArrayList<c> list = (ArrayList<c>)new ArrayList<Object>(d.a);
            d.a.clear();
            // monitorexit(d.a)
            jsonArray = new JSONArray();
            final Iterator<Object> iterator = list.iterator();
            while (iterator.hasNext()) {
                jsonArray.put((Object)iterator.next().a());
            }
        }
        return jsonArray.toString();
    }
    
    public static void a(final c c) {
        synchronized (d.a) {
            d.a.add(c);
        }
    }
}
