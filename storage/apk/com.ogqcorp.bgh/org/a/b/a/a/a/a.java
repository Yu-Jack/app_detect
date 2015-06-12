// 
// Decompiled by Procyon v0.5.29
// 

package org.a.b.a.a.a;

public abstract class a implements b
{
    private final String a;
    private final String b;
    private final String c;
    
    public a(final String s) {
        if (s == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        this.a = s;
        final int index = s.indexOf(47);
        if (index != -1) {
            this.b = s.substring(0, index);
            this.c = s.substring(index + 1);
            return;
        }
        this.b = s;
        this.c = null;
    }
    
    @Override
    public String a() {
        return this.a;
    }
}
