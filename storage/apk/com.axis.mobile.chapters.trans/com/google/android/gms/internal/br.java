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

public final class br
{
    public static List a(final JSONObject jsonObject, final String s) {
        final JSONArray optJSONArray = jsonObject.optJSONArray(s);
        if (optJSONArray != null) {
            final ArrayList<String> list = new ArrayList<String>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); ++i) {
                list.add(optJSONArray.getString(i));
            }
            return Collections.unmodifiableList((List<?>)list);
        }
        return null;
    }
    
    public static void a(final Context context, final String replacement, final ef ef, final String replacement2, final boolean b, final List list) {
        String replacement3;
        if (b) {
            replacement3 = "1";
        }
        else {
            replacement3 = "0";
        }
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next().replaceAll("@gw_adlocid@", replacement2).replaceAll("@gw_adnetrefresh@", replacement3).replaceAll("@gw_qdata@", ef.rz.nw).replaceAll("@gw_sdkver@", replacement).replaceAll("@gw_sessid@", eh.rQ).replaceAll("@gw_seqnum@", ef.qa);
            if (ef.nM != null) {
                s = s.replaceAll("@gw_adnetid@", ef.nM.nl).replaceAll("@gw_allocid@", ef.nM.nn);
            }
            new es(context, replacement, s).start();
        }
    }
}
