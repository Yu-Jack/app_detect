// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Map;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.analytics.containertag.common.Key;
import org.json.JSONObject;

class JsonUtils
{
    public static ResourceUtil.ExpandedResource expandedResourceFromJsonString(final String s) throws JSONException {
        final TypeSystem.Value jsonObjectToValue = jsonObjectToValue(new JSONObject(s));
        final ResourceUtil.ExpandedResourceBuilder builder = ResourceUtil.ExpandedResource.newBuilder();
        for (int i = 0; i < jsonObjectToValue.mapKey.length; ++i) {
            builder.addMacro(ResourceUtil.ExpandedFunctionCall.newBuilder().addProperty(Key.INSTANCE_NAME.toString(), jsonObjectToValue.mapKey[i]).addProperty(Key.FUNCTION.toString(), Types.functionIdToValue(ConstantMacro.getFunctionId())).addProperty(ConstantMacro.getValueKey(), jsonObjectToValue.mapValue[i]).build());
        }
        return builder.build();
    }
    
    @VisibleForTesting
    static Object jsonObjectToObject(final Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        }
        if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        }
        Object o;
        if (obj instanceof JSONObject) {
            final JSONObject jsonObject = (JSONObject)obj;
            o = new HashMap<String, Object>();
            final Iterator keys = jsonObject.keys();
            while (keys.hasNext()) {
                final String s = keys.next();
                ((Map<String, Object>)o).put(s, jsonObjectToObject(jsonObject.get(s)));
            }
        }
        else {
            o = obj;
        }
        return o;
    }
    
    private static TypeSystem.Value jsonObjectToValue(final Object o) throws JSONException {
        return Types.objectToValue(jsonObjectToObject(o));
    }
}
