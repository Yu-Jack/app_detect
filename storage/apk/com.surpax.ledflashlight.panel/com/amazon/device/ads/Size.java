// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class Size
{
    private final int height;
    private final int width;
    
    public Size(final int width, final int height) {
        this.width = width;
        this.height = height;
    }
    
    public Size(final String s) {
        while (true) {
            Label_0065: {
                if (s == null) {
                    break Label_0065;
                }
                final String[] split = s.split("x");
                if (split == null || split.length != 2) {
                    break Label_0065;
                }
                final int max = Math.max(parseInt(split[0], 0), 0);
                final int max2 = Math.max(parseInt(split[1], 0), 0);
                this.width = max;
                this.height = max2;
                return;
            }
            final int max2 = 0;
            final int max = 0;
            continue;
        }
    }
    
    private static int parseInt(final String s, final int n) {
        try {
            return Integer.parseInt(s);
        }
        catch (NumberFormatException ex) {
            return n;
        }
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    @Override
    public String toString() {
        return this.width + "x" + this.height;
    }
}
