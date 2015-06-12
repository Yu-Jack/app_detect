// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;

final class bg extends bc
{
    bg() {
        super(Character.class);
    }
    
    public Character c(final String s, final p p2) {
        if (s.length() == 1) {
            return s.charAt(0);
        }
        throw p2.a(this.a, s, "can only convert 1-character Strings");
    }
}
