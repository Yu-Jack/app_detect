// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads;

import org.json.JSONObject;

public final class n
{
    private final String a;
    private final int b;
    private final int c;
    
    private n(final String a, final int b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static n a(final JSONObject jsonObject) {
        if (jsonObject != null) {
            final String optString = jsonObject.optString("url");
            if (optString != null) {
                return new n(optString, jsonObject.optInt("width", 0), jsonObject.optInt("height", 0));
            }
        }
        return null;
    }
}
