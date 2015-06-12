// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.os.Build;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class DeviceNameMacro extends FunctionCallImplementation
{
    private static final String ID;
    
    static {
        ID = FunctionType.DEVICE_NAME.toString();
    }
    
    public DeviceNameMacro() {
        super(DeviceNameMacro.ID, new String[0]);
    }
    
    public static String getFunctionId() {
        return DeviceNameMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        final String manufacturer = Build.MANUFACTURER;
        String str = Build.MODEL;
        if (!str.startsWith(manufacturer) && !manufacturer.equals("unknown")) {
            str = manufacturer + " " + str;
        }
        return Types.objectToValue(str);
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
