// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

public final class kt
{
    public static <T extends ks> String a(final T t) {
        if (t == null) {
            return "";
        }
        final StringBuffer sb = new StringBuffer();
        try {
            a(null, t, new StringBuffer(), sb);
            return sb.toString();
        }
        catch (IllegalAccessException ex) {
            return "Error printing proto: " + ex.getMessage();
        }
        catch (InvocationTargetException ex2) {
            return "Error printing proto: " + ex2.getMessage();
        }
    }
    
    private static String a(final String s) {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (i == 0) {
                sb.append(Character.toLowerCase(char1));
            }
            else if (Character.isUpperCase(char1)) {
                sb.append('_').append(Character.toLowerCase(char1));
            }
            else {
                sb.append(char1);
            }
        }
        return sb.toString();
    }
    
    private static void a(final String s, final Object o, final StringBuffer sb, final StringBuffer sb2) {
        if (o != null) {
            Label_0422: {
                if (!(o instanceof ks)) {
                    break Label_0422;
                }
                final int length = sb.length();
                if (s != null) {
                    sb2.append(sb).append(a(s)).append(" <\n");
                    sb.append("  ");
                }
                final Class<?> class1 = o.getClass();
                for (final Field field : class1.getFields()) {
                    final int modifiers = field.getModifiers();
                    final String name = field.getName();
                    if ((modifiers & 0x1) == 0x1 && (modifiers & 0x8) != 0x8 && !name.startsWith("_") && !name.endsWith("_")) {
                        final Class<?> type = field.getType();
                        final Object value = field.get(o);
                        if (type.isArray()) {
                            if (type.getComponentType() == Byte.TYPE) {
                                a(name, value, sb, sb2);
                            }
                            else {
                                int length3;
                                if (value == null) {
                                    length3 = 0;
                                }
                                else {
                                    length3 = Array.getLength(value);
                                }
                                for (int j = 0; j < length3; ++j) {
                                    a(name, Array.get(value, j), sb, sb2);
                                }
                            }
                        }
                        else {
                            a(name, value, sb, sb2);
                        }
                    }
                }
                final Method[] methods = class1.getMethods();
                final int length4 = methods.length;
                int n = 0;
            Label_0343_Outer:
                while (true) {
                    Label_0400: {
                        if (n >= length4) {
                            break Label_0400;
                        }
                        final String name2 = methods[n].getName();
                        while (true) {
                            if (!name2.startsWith("set")) {
                                break Label_0343;
                            }
                            final String substring = name2.substring(3);
                            try {
                                if (class1.getMethod("has" + substring, (Class<?>[])new Class[0]).invoke(o, new Object[0])) {
                                    try {
                                        a(substring, class1.getMethod("get" + substring, (Class<?>[])new Class[0]).invoke(o, new Object[0]), sb, sb2);
                                        break Label_0343;
                                        // iftrue(Label_0485:, !o instanceof String)
                                        // iftrue(Label_0004:, s == null)
                                        // iftrue(Label_0506:, !o instanceof byte[])
                                        Label_0477: {
                                            Block_18:Block_17_Outer:
                                            while (true) {
                                                a((byte[])o, sb2);
                                                break Label_0477;
                                                sb2.append(sb).append(a(s)).append(": ");
                                                break Block_18;
                                                while (true) {
                                                    sb.setLength(length);
                                                    sb2.append(sb).append(">\n");
                                                    return;
                                                    continue;
                                                }
                                                Label_0506: {
                                                    sb2.append(o);
                                                }
                                                break Label_0477;
                                                Label_0485:
                                                continue Block_17_Outer;
                                            }
                                            sb2.append("\"").append(b((String)o)).append("\"");
                                        }
                                        sb2.append("\n");
                                        return;
                                    }
                                    catch (NoSuchMethodException ex) {}
                                }
                                ++n;
                                continue Label_0343_Outer;
                            }
                            catch (NoSuchMethodException ex2) {
                                continue;
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }
        Label_0004:;
    }
    
    private static void a(final byte[] array, final StringBuffer sb) {
        if (array == null) {
            sb.append("\"\"");
            return;
        }
        sb.append('\"');
        for (int i = 0; i < array.length; ++i) {
            final byte j = array[i];
            if (j == 92 || j == 34) {
                sb.append('\\').append((char)j);
            }
            else if (j >= 32 && j < 127) {
                sb.append((char)j);
            }
            else {
                sb.append(String.format("\\%03o", j));
            }
        }
        sb.append('\"');
    }
    
    private static String b(String string) {
        if (!string.startsWith("http") && string.length() > 200) {
            string = string.substring(0, 200) + "[...]";
        }
        return c(string);
    }
    
    private static String c(final String s) {
        final int length = s.length();
        final StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            final char char1 = s.charAt(i);
            if (char1 >= ' ' && char1 <= '~' && char1 != '\"' && char1 != '\'') {
                sb.append(char1);
            }
            else {
                sb.append(String.format("\\u%04x", (int)char1));
            }
        }
        return sb.toString();
    }
}
