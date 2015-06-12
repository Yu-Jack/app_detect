// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import android.content.Context;
import org.json.JSONArray;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class az
{
    public static List<String> a(final JSONObject jsonObject, final String s) {
        final JSONArray optJSONArray = jsonObject.optJSONArray(s);
        if (optJSONArray != null) {
            final ArrayList<String> list = new ArrayList<String>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); ++i) {
                list.add(optJSONArray.getString(i));
            }
            return (List<String>)Collections.unmodifiableList((List<?>)list);
        }
        return null;
    }
    
    public static void a(final Context context, final String replacement, final du du, final String replacement2, final boolean b, final List<String> list) {
        String replacement3;
        if (b) {
            replacement3 = "1";
        }
        else {
            replacement3 = "0";
        }
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next().replaceAll("@gw_adlocid@", replacement2).replaceAll("@gw_adnetrefresh@", replacement3).replaceAll("@gw_qdata@", du.o.f).replaceAll("@gw_sdkver@", replacement).replaceAll("@gw_sessid@", dy.a).replaceAll("@gw_seqnum@", du.i);
            if (du.l != null) {
                s = s.replaceAll("@gw_adnetid@", du.l.b).replaceAll("@gw_allocid@", du.l.d);
            }
            new el(context, replacement, s).e();
        }
    }
}
