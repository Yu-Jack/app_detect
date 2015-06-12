// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

@Deprecated
public class JSONUtils
{
    public static List<String> toStringList(final JSONArray jsonArray) throws JSONException {
        List<String> list;
        if (jsonArray == null) {
            list = null;
        }
        else {
            list = new ArrayList<String>();
            for (int i = 0; i < jsonArray.length(); ++i) {
                list.add(jsonArray.get(i).toString());
            }
        }
        return list;
    }
}
