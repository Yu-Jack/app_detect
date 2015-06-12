// 
// Decompiled by Procyon v0.5.29
// 

package org.a.a.a;

import java.io.File;

public class c
{
    public static final String a;
    private static final char b;
    private static final char c;
    
    static {
        a = Character.toString('.');
        b = File.separatorChar;
        if (a()) {
            c = '/';
            return;
        }
        c = '\\';
    }
    
    static boolean a() {
        return org.a.a.a.c.b == '\\';
    }
}
