// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public class ReflectionUtils
{
    public static boolean isClassAvailable(final String className) {
        try {
            Class.forName(className);
            return true;
        }
        catch (ClassNotFoundException ex) {
            return false;
        }
    }
}
