// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads;

import org.json.JSONObject;

public final class o
{
    private final double a;
    private final double b;
    
    private o(final double a, final double b) {
        this.a = a;
        this.b = b;
    }
    
    public static o a(final JSONObject jsonObject) {
        if (jsonObject != null) {
            final double optDouble = jsonObject.optDouble("value", 0.0);
            final double optDouble2 = jsonObject.optDouble("scale", 0.0);
            if (optDouble != 0.0 && optDouble2 != 0.0) {
                return new o(optDouble, optDouble2);
            }
        }
        return null;
    }
}
