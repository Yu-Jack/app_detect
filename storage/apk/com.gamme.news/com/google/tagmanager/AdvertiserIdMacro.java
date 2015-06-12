// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;
import android.content.Context;

class AdvertiserIdMacro extends FunctionCallImplementation
{
    private static final String ID;
    private final Context mContext;
    
    static {
        ID = FunctionType.ADVERTISER_ID.toString();
    }
    
    public AdvertiserIdMacro(final Context mContext) {
        super(AdvertiserIdMacro.ID, new String[0]);
        this.mContext = mContext;
    }
    
    public static String getFunctionId() {
        return AdvertiserIdMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        return Types.getDefaultValue();
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
