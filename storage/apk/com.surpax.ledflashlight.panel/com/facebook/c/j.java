// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.c;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONException;
import java.util.Map;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

final class j
{
    static Set a(final JSONObject jsonObject) {
        final HashSet<String> set = new HashSet<String>();
        final Iterator keys = jsonObject.keys();
        while (keys.hasNext()) {
            set.add(keys.next());
        }
        return set;
    }
    
    static void a(final JSONObject jsonObject, final Map map) {
        for (final Map.Entry<String, V> entry : map.entrySet()) {
            try {
                jsonObject.putOpt((String)entry.getKey(), (Object)entry.getValue());
            }
            catch (JSONException cause) {
                throw new IllegalArgumentException((Throwable)cause);
            }
        }
    }
    
    static Collection b(final JSONObject jsonObject) {
        final ArrayList<Object> list = new ArrayList<Object>();
        final Iterator keys = jsonObject.keys();
        while (keys.hasNext()) {
            list.add(jsonObject.opt((String)keys.next()));
        }
        return list;
    }
}
