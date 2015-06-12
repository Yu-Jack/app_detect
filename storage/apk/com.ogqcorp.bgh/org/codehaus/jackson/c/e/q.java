// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.c.y;
import org.codehaus.jackson.c.ag;
import org.codehaus.jackson.c.af;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.c.a.i;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnoreType;
import org.codehaus.jackson.annotate.JsonSetter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.c.f.a.l;
import org.codehaus.jackson.annotate.JsonGetter;
import org.codehaus.jackson.c.a.m;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.g.b.r;
import org.codehaus.jackson.annotate.JsonRawValue;
import org.codehaus.jackson.c.ae;
import org.codehaus.jackson.annotate.JsonUnwrapped;
import org.codehaus.jackson.annotate.JacksonAnnotation;
import java.lang.annotation.Annotation;
import org.codehaus.jackson.annotate.JsonTypeInfo$None;
import org.codehaus.jackson.annotate.JsonTypeInfo$As;
import org.codehaus.jackson.c.a.j;
import org.codehaus.jackson.annotate.JsonTypeInfo$Id;
import org.codehaus.jackson.c.a.k;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.c.ai;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonWriteNullProperties;
import org.codehaus.jackson.annotate.JsonSubTypes$Type;
import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonSubTypes;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.c.a.d;
import org.codehaus.jackson.c.a.n;
import org.codehaus.jackson.c.a.g;
import org.codehaus.jackson.c.a.c;
import org.codehaus.jackson.c.b;

public class q extends b
{
    @Override
    public Boolean a(final org.codehaus.jackson.c.e.b b) {
        final c c = b.a(c.class);
        if (c == null) {
            return null;
        }
        if (c.a()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    
    @Override
    public Class<?> a(final a a, final org.codehaus.jackson.f.a a2) {
        final g g = a.a(g.class);
        if (g != null) {
            final Class<?> e = g.e();
            if (e != n.class) {
                return e;
            }
        }
        return null;
    }
    
    @Override
    public Class<?> a(final a a, final org.codehaus.jackson.f.a a2, final String s) {
        final d d = a.a(d.class);
        if (d != null) {
            final Class<?> d2 = d.d();
            if (d2 != n.class) {
                return d2;
            }
        }
        return null;
    }
    
    @Override
    public String a(final Enum<?> enum1) {
        return enum1.name();
    }
    
    @Override
    public String a(final h h) {
        if (h != null) {
            final JsonProperty jsonProperty = h.a(JsonProperty.class);
            if (jsonProperty != null) {
                return jsonProperty.value();
            }
        }
        return null;
    }
    
    @Override
    public List<org.codehaus.jackson.c.f.a> a(final a a) {
        final JsonSubTypes jsonSubTypes = a.a(JsonSubTypes.class);
        ArrayList<org.codehaus.jackson.c.f.a> list;
        if (jsonSubTypes == null) {
            list = null;
        }
        else {
            final JsonSubTypes$Type[] value = jsonSubTypes.value();
            list = new ArrayList<org.codehaus.jackson.c.f.a>(value.length);
            for (final JsonSubTypes$Type jsonSubTypes$Type : value) {
                list.add(new org.codehaus.jackson.c.f.a(jsonSubTypes$Type.value(), jsonSubTypes$Type.name()));
            }
        }
        return list;
    }
    
    @Override
    public org.codehaus.jackson.c.a.h a(final a a, final org.codehaus.jackson.c.a.h h) {
        final g g = a.a(g.class);
        if (g != null) {
            return g.h();
        }
        final JsonWriteNullProperties jsonWriteNullProperties = a.a(JsonWriteNullProperties.class);
        if (jsonWriteNullProperties == null) {
            return h;
        }
        if (jsonWriteNullProperties.value()) {
            return org.codehaus.jackson.c.a.h.a;
        }
        return org.codehaus.jackson.c.a.h.b;
    }
    
    @Override
    public org.codehaus.jackson.c.c a(final e e) {
        final JsonManagedReference jsonManagedReference = e.a(JsonManagedReference.class);
        if (jsonManagedReference != null) {
            return org.codehaus.jackson.c.c.a(jsonManagedReference.value());
        }
        final JsonBackReference jsonBackReference = e.a(JsonBackReference.class);
        if (jsonBackReference != null) {
            return org.codehaus.jackson.c.c.b(jsonBackReference.value());
        }
        return null;
    }
    
    @Override
    public x<?> a(final org.codehaus.jackson.c.e.b b, final x<?> x) {
        final JsonAutoDetect jsonAutoDetect = b.a(JsonAutoDetect.class);
        if (jsonAutoDetect == null) {
            return x;
        }
        return (x<?>)x.a(jsonAutoDetect);
    }
    
    protected org.codehaus.jackson.c.f.d<?> a(final ai<?> ai, final a a, final org.codehaus.jackson.f.a a2) {
        final JsonTypeInfo jsonTypeInfo = a.a(JsonTypeInfo.class);
        final k k = a.a(k.class);
        org.codehaus.jackson.c.f.d d;
        if (k != null) {
            if (jsonTypeInfo == null) {
                return null;
            }
            d = ai.d(a, k.a());
        }
        else {
            if (jsonTypeInfo == null) {
                return null;
            }
            if (jsonTypeInfo.use() == JsonTypeInfo$Id.NONE) {
                return this.c();
            }
            d = this.b();
        }
        final j j = a.a(j.class);
        org.codehaus.jackson.c.f.c e = null;
        if (j != null) {
            e = ai.e(a, j.a());
        }
        if (e != null) {
            e.a(a2);
        }
        final org.codehaus.jackson.c.f.d<org.codehaus.jackson.c.f.d> a3 = d.a(jsonTypeInfo.use(), e);
        JsonTypeInfo$As jsonTypeInfo$As = jsonTypeInfo.include();
        if (jsonTypeInfo$As == JsonTypeInfo$As.EXTERNAL_PROPERTY && a instanceof org.codehaus.jackson.c.e.b) {
            jsonTypeInfo$As = JsonTypeInfo$As.PROPERTY;
        }
        final org.codehaus.jackson.c.f.d<org.codehaus.jackson.c.f.d<?>> a4 = a3.a(jsonTypeInfo$As).a(jsonTypeInfo.property());
        final Class<?> defaultImpl = jsonTypeInfo.defaultImpl();
        if (defaultImpl != JsonTypeInfo$None.class) {
            return a4.a(defaultImpl);
        }
        return a4;
    }
    
    @Override
    public org.codehaus.jackson.c.f.d<?> a(final ai<?> ai, final org.codehaus.jackson.c.e.b b, final org.codehaus.jackson.f.a a) {
        return this.a(ai, (a)b, a);
    }
    
    @Override
    public org.codehaus.jackson.c.f.d<?> a(final ai<?> ai, final e e, final org.codehaus.jackson.f.a a) {
        if (a.f()) {
            return null;
        }
        return this.a(ai, (a)e, a);
    }
    
    @Override
    public boolean a(final Annotation annotation) {
        return annotation.annotationType().getAnnotation(JacksonAnnotation.class) != null;
    }
    
    @Override
    public boolean a(final org.codehaus.jackson.c.e.c c) {
        return this.m(c);
    }
    
    @Override
    public boolean a(final org.codehaus.jackson.c.e.d d) {
        return this.m(d);
    }
    
    @Override
    public boolean a(final f f) {
        return this.m(f);
    }
    
    @Override
    public Boolean b(final e e) {
        final JsonUnwrapped jsonUnwrapped = e.a(JsonUnwrapped.class);
        if (jsonUnwrapped != null && jsonUnwrapped.enabled()) {
            return Boolean.TRUE;
        }
        return null;
    }
    
    @Override
    public Class<?> b(final a a, final org.codehaus.jackson.f.a a2) {
        final g g = a.a(g.class);
        if (g != null) {
            final Class<?> f = g.f();
            if (f != n.class) {
                return f;
            }
        }
        return null;
    }
    
    @Override
    public Class<?> b(final a a, final org.codehaus.jackson.f.a a2, final String s) {
        final d d = a.a(d.class);
        if (d != null) {
            final Class<?> e = d.e();
            if (e != n.class) {
                return e;
            }
        }
        return null;
    }
    
    @Override
    public Object b(final a a) {
        final g g = a.a(g.class);
        if (g != null) {
            final Class<? extends ad<?>> a2 = g.a();
            if (a2 != ae.class) {
                return a2;
            }
        }
        final JsonRawValue jsonRawValue = a.a(JsonRawValue.class);
        if (jsonRawValue != null && jsonRawValue.value()) {
            return new r(a.d());
        }
        return null;
    }
    
    @Override
    public String b(final org.codehaus.jackson.c.e.b b) {
        final org.codehaus.jackson.c.a.f f = b.a(org.codehaus.jackson.c.a.f.class);
        if (f == null) {
            return null;
        }
        return f.a();
    }
    
    @Override
    public String b(final org.codehaus.jackson.c.e.d d) {
        final JsonProperty jsonProperty = d.a(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.value();
        }
        if (d.b(g.class) || d.b(m.class)) {
            return "";
        }
        return null;
    }
    
    @Override
    public String b(final f f) {
        final JsonProperty jsonProperty = f.a(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.value();
        }
        final JsonGetter jsonGetter = f.a(JsonGetter.class);
        if (jsonGetter != null) {
            return jsonGetter.value();
        }
        if (f.b(g.class) || f.b(m.class)) {
            return "";
        }
        return null;
    }
    
    protected l b() {
        return new l();
    }
    
    @Override
    public org.codehaus.jackson.c.f.d<?> b(final ai<?> ai, final e e, final org.codehaus.jackson.f.a obj) {
        if (!obj.f()) {
            throw new IllegalArgumentException("Must call method with a container type (got " + obj + ")");
        }
        return this.a(ai, (a)e, obj);
    }
    
    @Override
    public Class<? extends ad<?>> c(final a a) {
        final g g = a.a(g.class);
        if (g != null) {
            final Class<? extends ad<?>> c = g.c();
            if (c != ae.class) {
                return c;
            }
        }
        return null;
    }
    
    @Override
    public Class<?> c(final a a, final org.codehaus.jackson.f.a a2, final String s) {
        final d d = a.a(d.class);
        if (d != null) {
            final Class<?> f = d.f();
            if (f != n.class) {
                return f;
            }
        }
        return null;
    }
    
    @Override
    public String c(final org.codehaus.jackson.c.e.d d) {
        final JsonProperty jsonProperty = d.a(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.value();
        }
        if (d.b(d.class) || d.b(m.class) || d.b(JsonBackReference.class) || d.b(JsonManagedReference.class)) {
            return "";
        }
        return null;
    }
    
    protected l c() {
        return l.b();
    }
    
    @Override
    public boolean c(final e e) {
        return this.m(e);
    }
    
    @Override
    public boolean c(final f f) {
        final JsonValue jsonValue = f.a(JsonValue.class);
        return jsonValue != null && jsonValue.value();
    }
    
    @Override
    public String[] c(final org.codehaus.jackson.c.e.b b) {
        final JsonIgnoreProperties jsonIgnoreProperties = b.a(JsonIgnoreProperties.class);
        if (jsonIgnoreProperties == null) {
            return null;
        }
        return jsonIgnoreProperties.value();
    }
    
    @Override
    public Boolean d(final org.codehaus.jackson.c.e.b b) {
        final JsonIgnoreProperties jsonIgnoreProperties = b.a(JsonIgnoreProperties.class);
        if (jsonIgnoreProperties == null) {
            return null;
        }
        return jsonIgnoreProperties.ignoreUnknown();
    }
    
    @Override
    public Class<? extends ad<?>> d(final a a) {
        final g g = a.a(g.class);
        if (g != null) {
            final Class<? extends ad<?>> b = g.b();
            if (b != ae.class) {
                return b;
            }
        }
        return null;
    }
    
    @Override
    public Object d(final e e) {
        final org.codehaus.jackson.c.a.a a = e.a(org.codehaus.jackson.c.a.a.class);
        String a2;
        if (a == null) {
            a2 = null;
        }
        else {
            a2 = a.a();
            if (a2.length() == 0) {
                if (!(e instanceof f)) {
                    return e.d().getName();
                }
                final f f = (f)e;
                if (f.f() == 0) {
                    return e.d().getName();
                }
                return f.a(0).getName();
            }
        }
        return a2;
    }
    
    @Override
    public String d(final f f) {
        final JsonProperty jsonProperty = f.a(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.value();
        }
        final JsonSetter jsonSetter = f.a(JsonSetter.class);
        if (jsonSetter != null) {
            return jsonSetter.value();
        }
        if (f.b(d.class) || f.b(m.class) || f.b(JsonBackReference.class) || f.b(JsonManagedReference.class)) {
            return "";
        }
        return null;
    }
    
    @Override
    public Boolean e(final org.codehaus.jackson.c.e.b b) {
        final JsonIgnoreType jsonIgnoreType = b.a(JsonIgnoreType.class);
        if (jsonIgnoreType == null) {
            return null;
        }
        return jsonIgnoreType.value();
    }
    
    @Override
    public Class<?> e(final a a) {
        final g g = a.a(g.class);
        if (g != null) {
            final Class<?> d = g.d();
            if (d != n.class) {
                return d;
            }
        }
        return null;
    }
    
    @Override
    public boolean e(final f f) {
        return f.b(JsonAnySetter.class);
    }
    
    @Override
    public Object f(final org.codehaus.jackson.c.e.b b) {
        final org.codehaus.jackson.c.a.e e = b.a(org.codehaus.jackson.c.a.e.class);
        if (e != null) {
            final String a = e.a();
            if (a.length() > 0) {
                return a;
            }
        }
        return null;
    }
    
    @Override
    public i f(final a a) {
        final g g = a.a(g.class);
        if (g == null) {
            return null;
        }
        return g.g();
    }
    
    @Override
    public boolean f(final f f) {
        return f.b(JsonAnyGetter.class);
    }
    
    @Override
    public String g(final org.codehaus.jackson.c.e.b b) {
        final JsonTypeName jsonTypeName = b.a(JsonTypeName.class);
        if (jsonTypeName == null) {
            return null;
        }
        return jsonTypeName.value();
    }
    
    @Override
    public Class<?>[] g(final a a) {
        final m m = a.a(m.class);
        if (m == null) {
            return null;
        }
        return m.a();
    }
    
    @Override
    public String[] h(final org.codehaus.jackson.c.e.b b) {
        final JsonPropertyOrder jsonPropertyOrder = b.a(JsonPropertyOrder.class);
        if (jsonPropertyOrder == null) {
            return null;
        }
        return jsonPropertyOrder.value();
    }
    
    @Override
    public Boolean i(final org.codehaus.jackson.c.e.b b) {
        final JsonPropertyOrder jsonPropertyOrder = b.a(JsonPropertyOrder.class);
        if (jsonPropertyOrder == null) {
            return null;
        }
        return jsonPropertyOrder.alphabetic();
    }
    
    @Override
    public Class<? extends af> i(final a a) {
        final d d = a.a(d.class);
        if (d != null) {
            final Class<? extends af> c = d.c();
            if (c != ag.class) {
                return c;
            }
        }
        return null;
    }
    
    @Override
    public Class<? extends org.codehaus.jackson.c.x<?>> j(final a a) {
        final d d = a.a(d.class);
        if (d != null) {
            final Class<? extends org.codehaus.jackson.c.x<?>> b = d.b();
            if (b != y.class) {
                return b;
            }
        }
        return null;
    }
    
    @Override
    public Object j(final org.codehaus.jackson.c.e.b b) {
        final org.codehaus.jackson.c.a.l l = b.a(org.codehaus.jackson.c.a.l.class);
        if (l == null) {
            return null;
        }
        return l.a();
    }
    
    @Override
    public boolean k(final a a) {
        return a.b(JsonCreator.class);
    }
    
    public Class<? extends org.codehaus.jackson.c.x<?>> l(final a a) {
        final d d = a.a(d.class);
        if (d != null) {
            final Class<? extends org.codehaus.jackson.c.x<?>> a2 = d.a();
            if (a2 != y.class) {
                return a2;
            }
        }
        return null;
    }
    
    protected boolean m(final a a) {
        final JsonIgnore jsonIgnore = a.a(JsonIgnore.class);
        return jsonIgnore != null && jsonIgnore.value();
    }
}
