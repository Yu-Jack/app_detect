// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.lang.reflect.Method;
import java.lang.reflect.Member;
import java.lang.reflect.Field;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonAutoDetect$Visibility;
import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect(creatorVisibility = JsonAutoDetect$Visibility.ANY, fieldVisibility = JsonAutoDetect$Visibility.PUBLIC_ONLY, getterVisibility = JsonAutoDetect$Visibility.PUBLIC_ONLY, isGetterVisibility = JsonAutoDetect$Visibility.PUBLIC_ONLY, setterVisibility = JsonAutoDetect$Visibility.ANY)
public class y implements x<y>
{
    protected static final y a;
    protected final JsonAutoDetect$Visibility b;
    protected final JsonAutoDetect$Visibility c;
    protected final JsonAutoDetect$Visibility d;
    protected final JsonAutoDetect$Visibility e;
    protected final JsonAutoDetect$Visibility f;
    
    static {
        a = new y(y.class.getAnnotation(JsonAutoDetect.class));
    }
    
    public y(final JsonAutoDetect$Visibility b, final JsonAutoDetect$Visibility c, final JsonAutoDetect$Visibility d, final JsonAutoDetect$Visibility e, final JsonAutoDetect$Visibility f) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public y(final JsonAutoDetect jsonAutoDetect) {
        final JsonMethod[] value = jsonAutoDetect.value();
        JsonAutoDetect$Visibility b;
        if (a(value, JsonMethod.GETTER)) {
            b = jsonAutoDetect.getterVisibility();
        }
        else {
            b = JsonAutoDetect$Visibility.NONE;
        }
        this.b = b;
        JsonAutoDetect$Visibility c;
        if (a(value, JsonMethod.IS_GETTER)) {
            c = jsonAutoDetect.isGetterVisibility();
        }
        else {
            c = JsonAutoDetect$Visibility.NONE;
        }
        this.c = c;
        JsonAutoDetect$Visibility d;
        if (a(value, JsonMethod.SETTER)) {
            d = jsonAutoDetect.setterVisibility();
        }
        else {
            d = JsonAutoDetect$Visibility.NONE;
        }
        this.d = d;
        JsonAutoDetect$Visibility e;
        if (a(value, JsonMethod.CREATOR)) {
            e = jsonAutoDetect.creatorVisibility();
        }
        else {
            e = JsonAutoDetect$Visibility.NONE;
        }
        this.e = e;
        JsonAutoDetect$Visibility f;
        if (a(value, JsonMethod.FIELD)) {
            f = jsonAutoDetect.fieldVisibility();
        }
        else {
            f = JsonAutoDetect$Visibility.NONE;
        }
        this.f = f;
    }
    
    public static y a() {
        return y.a;
    }
    
    private static boolean a(final JsonMethod[] array, final JsonMethod jsonMethod) {
        final int length = array.length;
        int n = 0;
        boolean b;
        while (true) {
            b = false;
            if (n >= length) {
                break;
            }
            final JsonMethod jsonMethod2 = array[n];
            if (jsonMethod2 == jsonMethod || jsonMethod2 == JsonMethod.ALL) {
                b = true;
                break;
            }
            ++n;
        }
        return b;
    }
    
    public boolean a(final Field field) {
        return this.f.isVisible(field);
    }
    
    public boolean a(final Member member) {
        return this.e.isVisible(member);
    }
    
    public boolean a(final Method method) {
        return this.b.isVisible(method);
    }
    
    @Override
    public boolean a(final d d) {
        return this.a(d.e());
    }
    
    @Override
    public boolean a(final e e) {
        return this.a(e.i());
    }
    
    @Override
    public boolean a(final f f) {
        return this.a(f.e());
    }
    
    public y b(final JsonAutoDetect jsonAutoDetect) {
        if (jsonAutoDetect == null) {
            return this;
        }
        final JsonMethod[] value = jsonAutoDetect.value();
        JsonAutoDetect$Visibility jsonAutoDetect$Visibility;
        if (a(value, JsonMethod.GETTER)) {
            jsonAutoDetect$Visibility = jsonAutoDetect.getterVisibility();
        }
        else {
            jsonAutoDetect$Visibility = JsonAutoDetect$Visibility.NONE;
        }
        final y f = this.f(jsonAutoDetect$Visibility);
        JsonAutoDetect$Visibility jsonAutoDetect$Visibility2;
        if (a(value, JsonMethod.IS_GETTER)) {
            jsonAutoDetect$Visibility2 = jsonAutoDetect.isGetterVisibility();
        }
        else {
            jsonAutoDetect$Visibility2 = JsonAutoDetect$Visibility.NONE;
        }
        final y g = f.g(jsonAutoDetect$Visibility2);
        JsonAutoDetect$Visibility jsonAutoDetect$Visibility3;
        if (a(value, JsonMethod.SETTER)) {
            jsonAutoDetect$Visibility3 = jsonAutoDetect.setterVisibility();
        }
        else {
            jsonAutoDetect$Visibility3 = JsonAutoDetect$Visibility.NONE;
        }
        final y h = g.h(jsonAutoDetect$Visibility3);
        JsonAutoDetect$Visibility jsonAutoDetect$Visibility4;
        if (a(value, JsonMethod.CREATOR)) {
            jsonAutoDetect$Visibility4 = jsonAutoDetect.creatorVisibility();
        }
        else {
            jsonAutoDetect$Visibility4 = JsonAutoDetect$Visibility.NONE;
        }
        final y i = h.i(jsonAutoDetect$Visibility4);
        JsonAutoDetect$Visibility jsonAutoDetect$Visibility5;
        if (a(value, JsonMethod.FIELD)) {
            jsonAutoDetect$Visibility5 = jsonAutoDetect.fieldVisibility();
        }
        else {
            jsonAutoDetect$Visibility5 = JsonAutoDetect$Visibility.NONE;
        }
        return i.j(jsonAutoDetect$Visibility5);
    }
    
    public boolean b(final Method method) {
        return this.c.isVisible(method);
    }
    
    @Override
    public boolean b(final f f) {
        return this.b(f.e());
    }
    
    public boolean c(final Method method) {
        return this.d.isVisible(method);
    }
    
    @Override
    public boolean c(final f f) {
        return this.c(f.e());
    }
    
    public y f(final JsonAutoDetect$Visibility jsonAutoDetect$Visibility) {
        JsonAutoDetect$Visibility b;
        if (jsonAutoDetect$Visibility == JsonAutoDetect$Visibility.DEFAULT) {
            b = y.a.b;
        }
        else {
            b = jsonAutoDetect$Visibility;
        }
        if (this.b == b) {
            return this;
        }
        return new y(b, this.c, this.d, this.e, this.f);
    }
    
    public y g(final JsonAutoDetect$Visibility jsonAutoDetect$Visibility) {
        JsonAutoDetect$Visibility c;
        if (jsonAutoDetect$Visibility == JsonAutoDetect$Visibility.DEFAULT) {
            c = y.a.c;
        }
        else {
            c = jsonAutoDetect$Visibility;
        }
        if (this.c == c) {
            return this;
        }
        return new y(this.b, c, this.d, this.e, this.f);
    }
    
    public y h(final JsonAutoDetect$Visibility jsonAutoDetect$Visibility) {
        JsonAutoDetect$Visibility d;
        if (jsonAutoDetect$Visibility == JsonAutoDetect$Visibility.DEFAULT) {
            d = y.a.d;
        }
        else {
            d = jsonAutoDetect$Visibility;
        }
        if (this.d == d) {
            return this;
        }
        return new y(this.b, this.c, d, this.e, this.f);
    }
    
    public y i(final JsonAutoDetect$Visibility jsonAutoDetect$Visibility) {
        JsonAutoDetect$Visibility e;
        if (jsonAutoDetect$Visibility == JsonAutoDetect$Visibility.DEFAULT) {
            e = y.a.e;
        }
        else {
            e = jsonAutoDetect$Visibility;
        }
        if (this.e == e) {
            return this;
        }
        return new y(this.b, this.c, this.d, e, this.f);
    }
    
    public y j(final JsonAutoDetect$Visibility jsonAutoDetect$Visibility) {
        JsonAutoDetect$Visibility f;
        if (jsonAutoDetect$Visibility == JsonAutoDetect$Visibility.DEFAULT) {
            f = y.a.f;
        }
        else {
            f = jsonAutoDetect$Visibility;
        }
        if (this.f == f) {
            return this;
        }
        return new y(this.b, this.c, this.d, this.e, f);
    }
    
    @Override
    public String toString() {
        return "[Visibility:" + " getter: " + this.b + ", isGetter: " + this.c + ", setter: " + this.d + ", creator: " + this.e + ", field: " + this.f + "]";
    }
}
