// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

import java.io.Serializable;

public class aa implements Serializable
{
    protected Object a;
    protected String b;
    protected int c;
    
    protected aa() {
        this.c = -1;
    }
    
    public aa(final Object a, final int c) {
        this.c = -1;
        this.a = a;
        this.c = c;
    }
    
    public aa(final Object a, final String b) {
        this.c = -1;
        this.a = a;
        if (b == null) {
            throw new NullPointerException("Can not pass null fieldName");
        }
        this.b = b;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        Class<?> class1;
        if (this.a instanceof Class) {
            class1 = (Class<?>)this.a;
        }
        else {
            class1 = this.a.getClass();
        }
        final Package package1 = class1.getPackage();
        if (package1 != null) {
            sb.append(package1.getName());
            sb.append('.');
        }
        sb.append(class1.getSimpleName());
        sb.append('[');
        if (this.b != null) {
            sb.append('\"');
            sb.append(this.b);
            sb.append('\"');
        }
        else if (this.c >= 0) {
            sb.append(this.c);
        }
        else {
            sb.append('?');
        }
        sb.append(']');
        return sb.toString();
    }
}
