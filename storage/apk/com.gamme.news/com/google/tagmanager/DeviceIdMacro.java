// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import android.provider.Settings$Secure;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;
import android.content.Context;

class DeviceIdMacro extends FunctionCallImplementation
{
    private static final String ID;
    private final Context mContext;
    
    static {
        ID = FunctionType.DEVICE_ID.toString();
    }
    
    public DeviceIdMacro(final Context mContext) {
        super(DeviceIdMacro.ID, new String[0]);
        this.mContext = mContext;
    }
    
    public static String getFunctionId() {
        return DeviceIdMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        final String androidId = this.getAndroidId(this.mContext);
        if (androidId == null) {
            return Types.getDefaultValue();
        }
        return Types.objectToValue(androidId);
    }
    
    @VisibleForTesting
    protected String getAndroidId(final Context context) {
        return Settings$Secure.getString(context.getContentResolver(), "android_id");
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
