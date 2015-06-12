// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.content.pm.PackageManager$NameNotFoundException;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;
import android.content.Context;

class AppVersionMacro extends FunctionCallImplementation
{
    private static final String ID;
    private final Context mContext;
    
    static {
        ID = FunctionType.APP_VERSION.toString();
    }
    
    public AppVersionMacro(final Context mContext) {
        super(AppVersionMacro.ID, new String[0]);
        this.mContext = mContext;
    }
    
    public static String getFunctionId() {
        return AppVersionMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        try {
            return Types.objectToValue(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode);
        }
        catch (PackageManager$NameNotFoundException ex) {
            Log.e("Package name " + this.mContext.getPackageName() + " not found. " + ex.getMessage());
            return Types.getDefaultValue();
        }
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
