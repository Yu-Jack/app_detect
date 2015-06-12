// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager.protobuf.nano;

import java.lang.reflect.Field;
import java.lang.reflect.Array;

public final class MessageNanoPrinter
{
    private static final String INDENT = "  ";
    private static final int MAX_STRING_LEN = 200;
    
    private static String deCamelCaseify(final String s) {
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
    
    private static String escapeString(final String s) {
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
    
    public static <T extends MessageNano> String print(final T t) {
        if (t == null) {
            return "null";
        }
        final StringBuffer sb = new StringBuffer();
        try {
            print(t.getClass().getSimpleName(), t.getClass(), t, new StringBuffer(), sb);
            return sb.toString();
        }
        catch (IllegalAccessException ex) {
            return "Error printing proto: " + ex.getMessage();
        }
    }
    
    private static void print(final String str, final Class<?> clazz, final Object o, final StringBuffer sb, final StringBuffer sb2) throws IllegalAccessException {
        if (MessageNano.class.isAssignableFrom(clazz)) {
            if (o != null) {
                sb2.append(sb).append(str);
                sb.append("  ");
                sb2.append(" <\n");
                for (final Field field : clazz.getFields()) {
                    final int modifiers = field.getModifiers();
                    final String name = field.getName();
                    if ((modifiers & 0x1) == 0x1 && (modifiers & 0x8) != 0x8 && !name.startsWith("_") && !name.endsWith("_")) {
                        final Class<?> type = field.getType();
                        final Object value = field.get(o);
                        if (type.isArray()) {
                            final Class componentType = type.getComponentType();
                            if (componentType == Byte.TYPE) {
                                print(name, type, value, sb, sb2);
                            }
                            else {
                                int length2;
                                if (value == null) {
                                    length2 = 0;
                                }
                                else {
                                    length2 = Array.getLength(value);
                                }
                                for (int j = 0; j < length2; ++j) {
                                    print(name, componentType, Array.get(value, j), sb, sb2);
                                }
                            }
                        }
                        else {
                            print(name, type, value, sb, sb2);
                        }
                    }
                }
                sb.delete(sb.length() - "  ".length(), sb.length());
                sb2.append(sb).append(">\n");
            }
        }
        else if (o != null) {
            sb2.append(sb).append(deCamelCaseify(str)).append(": ");
            if (o instanceof String) {
                sb2.append("\"").append(sanitizeString((String)o)).append("\"");
            }
            else {
                sb2.append(o);
            }
            sb2.append("\n");
        }
    }
    
    private static String sanitizeString(String string) {
        if (!string.startsWith("http") && string.length() > 200) {
            string = string.substring(0, 200) + "[...]";
        }
        return escapeString(string);
    }
}
