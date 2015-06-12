// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.annotate;

import java.lang.reflect.Modifier;
import java.lang.reflect.Member;

public enum JsonAutoDetect$Visibility
{
    ANY, 
    DEFAULT, 
    NONE, 
    NON_PRIVATE, 
    PROTECTED_AND_PUBLIC, 
    PUBLIC_ONLY;
    
    public boolean isVisible(final Member member) {
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
