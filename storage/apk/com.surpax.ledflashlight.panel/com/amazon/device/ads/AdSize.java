// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Locale;

public class AdSize
{
    private static final String LOG_TAG = "AdSize";
    public static final AdSize SIZE_1024x50;
    public static final AdSize SIZE_300x250;
    public static final AdSize SIZE_300x50;
    public static final AdSize SIZE_320x50;
    public static final AdSize SIZE_600x90;
    public static final AdSize SIZE_728x90;
    public static final AdSize SIZE_AUTO;
    static final AdSize SIZE_INTERSTITIAL;
    private int height;
    private AdSize$SizeType type;
    private int width;
    
    static {
        SIZE_300x50 = new AdSize(300, 50);
        SIZE_320x50 = new AdSize(320, 50);
        SIZE_300x250 = new AdSize(300, 250);
        SIZE_600x90 = new AdSize(600, 90);
        SIZE_728x90 = new AdSize(728, 90);
        SIZE_1024x50 = new AdSize(1024, 50);
        SIZE_AUTO = new AdSize(AdSize$SizeType.AUTO);
        SIZE_INTERSTITIAL = new AdSize(AdSize$SizeType.INTERSTITIAL);
    }
    
    public AdSize(final int n, final int n2) {
        this.initialize(n, n2);
    }
    
    AdSize(final AdSize$SizeType type) {
        this.type = type;
    }
    
    AdSize(final String s, final String s2) {
        this.initialize(Utils.parseInt(s, 0), Utils.parseInt(s2, 0));
    }
    
    private void initialize(final int width, final int height) {
        if (width <= 0 || height <= 0) {
            Log.e("AdSize", "The width and height must be positive integers.");
            throw new IllegalArgumentException("The width and height must be positive integers.");
        }
        this.width = width;
        this.height = height;
        this.type = AdSize$SizeType.EXPLICIT;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public boolean isAuto() {
        return this.type == AdSize$SizeType.AUTO;
    }
    
    @Override
    public String toString() {
        switch (this.type) {
            default: {
                return null;
            }
            case EXPLICIT: {
                return String.format(Locale.US, "%dx%d", this.width, this.height);
            }
            case AUTO: {
                return "auto";
            }
            case INTERSTITIAL: {
                return "interstitial";
            }
        }
    }
}
