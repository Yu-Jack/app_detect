// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android;

public class AdCreative
{
    public static final String kAlignmentBottom = "bottom";
    public static final String kAlignmentCenter = "center";
    public static final String kAlignmentLeft = "left";
    public static final String kAlignmentMiddle = "middle";
    public static final String kAlignmentRight = "right";
    public static final String kAlignmentTop = "top";
    public static final String kFixBoth = "both";
    public static final String kFixHeight = "height";
    public static final String kFixNone = "none";
    public static final String kFixWidth = "width";
    public static final String kFormatBanner = "banner";
    public static final String kFormatCustom = "custom";
    public static final String kFormatTakeover = "takeover";
    private int a;
    private int b;
    private String c;
    private String d;
    private String e;
    
    public AdCreative(final int a, final int b, final String c, final String d, final String e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public String getAlignment() {
        return this.e;
    }
    
    public String getFix() {
        return this.d;
    }
    
    public String getFormat() {
        return this.c;
    }
    
    public int getHeight() {
        return this.a;
    }
    
    public int getWidth() {
        return this.b;
    }
}
