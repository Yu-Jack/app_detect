// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ap extends aq
{
    @Override
    public String a(final String s) {
        if (s != null) {
            final int length = s.length();
            final StringBuilder sb = new StringBuilder(length * 2);
            int i = 0;
            int n = 0;
            int n2 = 0;
            while (i < length) {
                final char char1 = s.charAt(i);
                int n3;
                if (i > 0 || char1 != '_') {
                    int n4;
                    char c;
                    if (Character.isUpperCase(char1)) {
                        if (n == 0 && n2 > 0 && sb.charAt(n2 - 1) != '_') {
                            sb.append('_');
                            ++n2;
                        }
                        final char lowerCase = Character.toLowerCase(char1);
                        n3 = 1;
                        n4 = n2;
                        c = lowerCase;
                    }
                    else {
                        n4 = n2;
                        c = char1;
                        n3 = 0;
                    }
                    sb.append(c);
                    n2 = n4 + 1;
                }
                else {
                    n3 = n;
                }
                ++i;
                n = n3;
            }
            if (n2 > 0) {
                return sb.toString();
            }
        }
        return s;
    }
}
