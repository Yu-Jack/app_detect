// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

public class AdLoader$AdLoaderFactory
{
    public AdLoader createAdLoader(final AdRequest adRequest, final Map map) {
        return new AdLoader(adRequest, map);
    }
}
