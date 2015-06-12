// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.d;

import org.codehaus.jackson.c.b.b.an;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.t;
import org.codehaus.jackson.c.n;
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.c.i.w;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.at;

public class a
{
    public static final a a;
    
    static {
        a = new a();
    }
    
    private Object a(final String className) {
        try {
            return Class.forName(className).newInstance();
        }
        catch (Exception ex) {}
        catch (LinkageError linkageError) {
            goto Label_0013;
        }
    }
    
    private boolean a(Class<?> superclass, final String anObject) {
        while (superclass != null) {
            if (superclass.getName().equals(anObject) || this.b(superclass, anObject)) {
                return true;
            }
            superclass = superclass.getSuperclass();
        }
        return false;
    }
    
    private boolean b(final Class<?> clazz, final String anObject) {
        final Class[] interfaces = clazz.getInterfaces();
        for (int length = interfaces.length, i = 0; i < length; ++i) {
            if (interfaces[i].getName().equals(anObject)) {
                return true;
            }
        }
        for (int length2 = interfaces.length, j = 0; j < length2; ++j) {
            if (this.b(interfaces[j], anObject)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean c(Class<?> superclass, final String prefix) {
        for (Class<?> clazz = superclass.getSuperclass(); clazz != null; clazz = clazz.getSuperclass()) {
            if (clazz.getName().startsWith(prefix)) {
                return true;
            }
        }
        while (superclass != null) {
            if (this.d(superclass, prefix)) {
                return true;
            }
            superclass = superclass.getSuperclass();
        }
        return false;
    }
    
    private boolean d(final Class<?> clazz, final String prefix) {
        final Class[] interfaces = clazz.getInterfaces();
        for (int length = interfaces.length, i = 0; i < length; ++i) {
            if (interfaces[i].getName().startsWith(prefix)) {
                return true;
            }
        }
        for (int length2 = interfaces.length, j = 0; j < length2; ++j) {
            if (this.d(interfaces[j], prefix)) {
                return true;
            }
        }
        return false;
    }
    
    public ad<?> a(final at at, final org.codehaus.jackson.f.a a) {
        final Class<?> p2 = a.p();
        final String name = p2.getName();
        String s;
        if (name.startsWith("org.joda.time.")) {
            s = "org.codehaus.jackson.map.ext.JodaSerializers";
        }
        else if (name.startsWith("javax.xml.") || this.c(p2, "javax.xml.")) {
            s = "org.codehaus.jackson.map.ext.CoreXMLSerializers";
        }
        else {
            if (this.a(p2, "org.w3c.dom.Node")) {
                return (ad<?>)this.a("org.codehaus.jackson.map.ext.DOMSerializer");
            }
            return null;
        }
        final Object a2 = this.a(s);
        if (a2 == null) {
            return null;
        }
        final Collection<Map.Entry<Class<?>, V>> a3 = ((w<Map.Entry<Class<?>, V>>)a2).a();
        for (final Map.Entry<Class<?>, V> entry : a3) {
            if (p2 == entry.getKey()) {
                return (ad<?>)entry.getValue();
            }
        }
        for (final Map.Entry<Class<?>, V> entry2 : a3) {
            if (entry2.getKey().isAssignableFrom(p2)) {
                return (ad<?>)entry2.getValue();
            }
        }
        return null;
    }
    
    public x<?> a(final org.codehaus.jackson.f.a a, final n n, final t t) {
        final Class<?> p3 = a.p();
        final String name = p3.getName();
        String s;
        if (name.startsWith("org.joda.time.")) {
            s = "org.codehaus.jackson.map.ext.JodaDeserializers";
        }
        else if (name.startsWith("javax.xml.") || this.c(p3, "javax.xml.")) {
            s = "org.codehaus.jackson.map.ext.CoreXMLDeserializers";
        }
        else {
            if (this.a(p3, "org.w3c.dom.Node")) {
                return (x<?>)this.a("org.codehaus.jackson.map.ext.DOMDeserializer$DocumentDeserializer");
            }
            if (this.a(p3, "org.w3c.dom.Node")) {
                return (x<?>)this.a("org.codehaus.jackson.map.ext.DOMDeserializer$NodeDeserializer");
            }
            return null;
        }
        final Object a2 = this.a(s);
        if (a2 == null) {
            return null;
        }
        final Collection<an> a3 = ((w<an>)a2).a();
        for (final an<?> an : a3) {
            if (p3 == an.f()) {
                return an;
            }
        }
        for (final an<?> an2 : a3) {
            if (an2.f().isAssignableFrom(p3)) {
                return an2;
            }
        }
        return null;
    }
}
