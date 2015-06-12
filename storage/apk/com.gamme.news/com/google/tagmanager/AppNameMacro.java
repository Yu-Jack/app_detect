// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;
import android.content.Context;

class AppNameMacro extends FunctionCallImplementation
{
    private static final String ID;
    private final Context mContext;
    
    static {
        ID = FunctionType.APP_NAME.toString();
    }
    
    public AppNameMacro(final Context mContext) {
        super(AppNameMacro.ID, new String[0]);
        this.mContext = mContext;
    }
    
    public static String getFunctionId() {
        return AppNameMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        try {
            final PackageManager packageManager = this.mContext.getPackageManager();
            return Types.objectToValue(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        }
        catch (PackageManager$NameNotFoundException ex) {
            Log.e("App name is not found.", (Throwable)ex);
            return Types.getDefaultValue();
        }
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
