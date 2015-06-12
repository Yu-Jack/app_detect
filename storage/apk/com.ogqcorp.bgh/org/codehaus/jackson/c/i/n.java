// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

import java.lang.reflect.Array;

public class n
{
    public static Object a(final Object o) {
        return new Object() {
            final /* synthetic */ int b = Array.getLength(o);
            
            @Override
            public boolean equals(final Object o) {
                boolean b;
                if (o == this) {
                    b = true;
                }
                else {
                    b = false;
                    if (o != null) {
                        final Class<?> class1 = o.getClass();
                        final Class<?> class2 = o.getClass();
                        b = false;
                        if (class1 == class2) {
                            final int length = Array.getLength(o);
                            final int b2 = this.b;
                            b = false;
                            if (length == b2) {
                                for (int i = 0; i < this.b; ++i) {
                                    final Object value = Array.get(o, i);
                                    final Object value2 = Array.get(o, i);
                                    if (value != value2 && value != null && !value.equals(value2)) {
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }
                    }
                }
                return b;
            }
        };
    }
}
