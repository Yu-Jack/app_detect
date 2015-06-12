// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.common.FunctionType;
import android.content.Context;

class AdwordsClickReferrerMacro extends FunctionCallImplementation
{
    private static final String COMPONENT;
    private static final String CONVERSION_ID;
    private static final String ID;
    private final Context context;
    
    static {
        ID = FunctionType.ADWORDS_CLICK_REFERRER.toString();
        COMPONENT = Key.COMPONENT.toString();
        CONVERSION_ID = Key.CONVERSION_ID.toString();
    }
    
    public AdwordsClickReferrerMacro(final Context context) {
        super(AdwordsClickReferrerMacro.ID, new String[] { AdwordsClickReferrerMacro.CONVERSION_ID });
        this.context = context;
    }
    
    public static String getFunctionId() {
        return AdwordsClickReferrerMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        final TypeSystem.Value value = map.get(AdwordsClickReferrerMacro.CONVERSION_ID);
        if (value == null) {
            return Types.getDefaultValue();
        }
        final String valueToString = Types.valueToString(value);
        final TypeSystem.Value value2 = map.get(AdwordsClickReferrerMacro.COMPONENT);
        String valueToString2;
        if (value2 != null) {
            valueToString2 = Types.valueToString(value2);
        }
        else {
            valueToString2 = null;
        }
        final String clickReferrer = InstallReferrerUtil.getClickReferrer(this.context, valueToString, valueToString2);
        if (clickReferrer != null) {
            return Types.objectToValue(clickReferrer);
        }
        return Types.getDefaultValue();
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
