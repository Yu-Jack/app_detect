// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

abstract class MraidProperty
{
    private String sanitize(final String s) {
        if (s != null) {
            return s.replaceAll("[^a-zA-Z0-9_,:\\s\\{\\}\\'\\\"]", "");
        }
        return "";
    }
    
    public abstract String toJsonPair();
    
    @Override
    public String toString() {
        return this.sanitize(this.toJsonPair());
    }
}
