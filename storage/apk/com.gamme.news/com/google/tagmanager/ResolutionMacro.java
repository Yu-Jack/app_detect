// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.view.WindowManager;
import android.util.DisplayMetrics;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;
import android.content.Context;

class ResolutionMacro extends FunctionCallImplementation
{
    private static final String ID;
    private final Context mContext;
    
    static {
        ID = FunctionType.RESOLUTION.toString();
    }
    
    public ResolutionMacro(final Context mContext) {
        super(ResolutionMacro.ID, new String[0]);
        this.mContext = mContext;
    }
    
    public static String getFunctionId() {
        return ResolutionMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return Types.objectToValue(displayMetrics.widthPixels + "x" + displayMetrics.heightPixels);
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
