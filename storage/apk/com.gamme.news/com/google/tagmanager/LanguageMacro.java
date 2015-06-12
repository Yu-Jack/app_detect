// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Locale;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class LanguageMacro extends FunctionCallImplementation
{
    private static final String ID;
    
    static {
        ID = FunctionType.LANGUAGE.toString();
    }
    
    public LanguageMacro() {
        super(LanguageMacro.ID, new String[0]);
    }
    
    public static String getFunctionId() {
        return LanguageMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        final Locale default1 = Locale.getDefault();
        if (default1 == null) {
            return Types.getDefaultValue();
        }
        final String language = default1.getLanguage();
        if (language == null) {
            return Types.getDefaultValue();
        }
        return Types.objectToValue(language.toLowerCase());
    }
    
    @Override
    public boolean isCacheable() {
        return false;
    }
}
