// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.org.codehaus.jackson.annotate;

import java.lang.reflect.Modifier;
import java.lang.reflect.Member;

public enum JsonAutoDetect$Visibility
{
    ANY("ANY", 0), 
    DEFAULT("DEFAULT", 5), 
    NONE("NONE", 4), 
    NON_PRIVATE("NON_PRIVATE", 1), 
    PROTECTED_AND_PUBLIC("PROTECTED_AND_PUBLIC", 2), 
    PUBLIC_ONLY("PUBLIC_ONLY", 3);
    
    private JsonAutoDetect$Visibility(final String name, final int ordinal) {
    }
    
    public final boolean isVisible(final Member member) {
        boolean b = true;
        switch (this) {
            default: {
                b = false;
                return b;
            }
            case ANY: {
                return b;
            }
            case NONE: {
                return false;
            }
            case NON_PRIVATE: {
                if (Modifier.isPrivate(member.getModifiers())) {
                    return false;
                }
                return b;
            }
            case PROTECTED_AND_PUBLIC: {
                if (!Modifier.isProtected(member.getModifiers())) {
                    return Modifier.isPublic(member.getModifiers());
                }
                return b;
            }
            case PUBLIC_ONLY: {
                return Modifier.isPublic(member.getModifiers());
            }
        }
    }
}
