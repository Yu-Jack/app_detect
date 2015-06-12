// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Iterator;
import java.util.HashMap;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.common.FunctionType;

class CustomFunctionCall extends FunctionCallImplementation
{
    private static final String ADDITIONAL_PARAMS;
    private static final String FUNCTION_CALL_NAME;
    private static final String ID;
    private final CustomEvaluator mFunctionCallEvaluator;
    
    static {
        ID = FunctionType.FUNCTION_CALL.toString();
        FUNCTION_CALL_NAME = Key.FUNCTION_CALL_NAME.toString();
        ADDITIONAL_PARAMS = Key.ADDITIONAL_PARAMS.toString();
    }
    
    public CustomFunctionCall(final CustomEvaluator mFunctionCallEvaluator) {
        super(CustomFunctionCall.ID, new String[] { CustomFunctionCall.FUNCTION_CALL_NAME });
        this.mFunctionCallEvaluator = mFunctionCallEvaluator;
    }
    
    public static String getAdditionalParamsKey() {
        return CustomFunctionCall.ADDITIONAL_PARAMS;
    }
    
    public static String getFunctionCallNameKey() {
        return CustomFunctionCall.FUNCTION_CALL_NAME;
    }
    
    public static String getFunctionId() {
        return CustomFunctionCall.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        final String valueToString = Types.valueToString(map.get(CustomFunctionCall.FUNCTION_CALL_NAME));
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        final TypeSystem.Value value = map.get(CustomFunctionCall.ADDITIONAL_PARAMS);
        if (value != null) {
            final Object valueToObject = Types.valueToObject(value);
            if (!(valueToObject instanceof Map)) {
                Log.w("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return Types.getDefaultValue();
            }
            for (final Map.Entry<Object, V> entry : ((Map<Object, V>)valueToObject).entrySet()) {
                hashMap.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return Types.objectToValue(this.mFunctionCallEvaluator.evaluate(valueToString, hashMap));
        }
        catch (Exception ex) {
            Log.w("Custom macro/tag " + valueToString + " threw exception " + ex.getMessage());
            return Types.getDefaultValue();
        }
    }
    
    @Override
    public boolean isCacheable() {
        return false;
    }
    
    public interface CustomEvaluator
    {
        Object evaluate(String p0, Map<String, Object> p1);
    }
}
