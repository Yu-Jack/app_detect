// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.codehaus.jackson.c.e.f;

public class k
{
    protected static String a(String str) {
        StringBuilder sb = null;
        final int length = str.length();
        if (length == 0) {
            str = null;
        }
        else {
            for (int i = 0; i < length; ++i) {
                final char char1 = str.charAt(i);
                final char lowerCase = Character.toLowerCase(char1);
                if (char1 == lowerCase) {
                    break;
                }
                if (sb == null) {
                    sb = new StringBuilder(str);
                }
                sb.setCharAt(i, lowerCase);
            }
            if (sb != null) {
                return sb.toString();
            }
        }
        return str;
    }
    
    public static String a(final f f) {
        final String b = f.b();
        String s = b(f, b);
        if (s == null) {
            s = a(f, b);
        }
        return s;
    }
    
    public static String a(final f f, final String s) {
        if (s.startsWith("get")) {
            if ("getCallbacks".equals(s)) {
                if (c(f)) {
                    return null;
                }
            }
            else if ("getMetaClass".equals(s) && e(f)) {
                return null;
            }
            return a(s.substring(3));
        }
        return null;
    }
    
    public static String b(final f f) {
        final String b = f.b();
        if (b.startsWith("set")) {
            final String a = a(b.substring(3));
            if (a != null && (!"metaClass".equals(a) || !d(f))) {
                return a;
            }
        }
        return null;
    }
    
    public static String b(final f f, final String s) {
        if (s.startsWith("is")) {
            final Class<?> d = f.d();
            if (d == Boolean.class || d == Boolean.TYPE) {
                return a(s.substring(2));
            }
        }
        return null;
    }
    
    protected static boolean c(final f f) {
        final Class<?> d = f.d();
        if (d != null && d.isArray()) {
            final Package package1 = d.getComponentType().getPackage();
            if (package1 != null) {
                final String name = package1.getName();
                if (name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib")) {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected static boolean d(final f f) {
        final Package package1 = f.a(0).getPackage();
        boolean b = false;
        if (package1 != null) {
            final boolean startsWith = package1.getName().startsWith("groovy.lang");
            b = false;
            if (startsWith) {
                b = true;
            }
        }
        return b;
    }
    
    protected static boolean e(final f f) {
        final Class<?> d = f.d();
        if (d != null && !d.isArray()) {
            final Package package1 = d.getPackage();
            if (package1 != null && package1.getName().startsWith("groovy.lang")) {
                return true;
            }
        }
        return false;
    }
}
