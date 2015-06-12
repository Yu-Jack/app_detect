// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.common.FunctionType;
import android.content.Context;

class InstallReferrerMacro extends FunctionCallImplementation
{
    private static final String COMPONENT;
    private static final String ID;
    private final Context context;
    
    static {
        ID = FunctionType.INSTALL_REFERRER.toString();
        COMPONENT = Key.COMPONENT.toString();
    }
    
    public InstallReferrerMacro(final Context context) {
        super(InstallReferrerMacro.ID, new String[0]);
        this.context = context;
    }
    
    public static String getFunctionId() {
        return InstallReferrerMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        String valueToString;
        if (map.get(InstallReferrerMacro.COMPONENT) != null) {
            valueToString = Types.valueToString(map.get(InstallReferrerMacro.COMPONENT));
        }
        else {
            valueToString = null;
        }
        final String installReferrer = InstallReferrerUtil.getInstallReferrer(this.context, valueToString);
        if (installReferrer != null) {
            return Types.objectToValue(installReferrer);
        }
        return Types.getDefaultValue();
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
