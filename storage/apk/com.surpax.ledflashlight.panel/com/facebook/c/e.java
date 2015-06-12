// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.c;

import java.util.Map;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import com.facebook.b.aj;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import com.facebook.ac;
import java.util.Iterator;
import org.json.JSONObject;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Collection;
import java.lang.reflect.ParameterizedType;
import org.json.JSONException;
import com.facebook.b.al;
import org.json.JSONArray;
import java.util.AbstractList;

final class e extends AbstractList implements h
{
    private final JSONArray a;
    private final Class b;
    
    public e(final JSONArray a, final Class b) {
        al.a(a, "state");
        al.a(b, "itemType");
        this.a = a;
        this.b = b;
    }
    
    private void a(final int n) {
        if (n < 0 || n >= this.a.length()) {
            throw new IndexOutOfBoundsException();
        }
    }
    
    private void a(final int n, final Object o) {
        final Object a = d.a(o);
        try {
            this.a.put(n, a);
        }
        catch (JSONException cause) {
            throw new IllegalArgumentException((Throwable)cause);
        }
    }
    
    @Override
    public final JSONArray a() {
        return this.a;
    }
    
    @Override
    public final void add(final int n, final Object o) {
        if (n < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (n < this.size()) {
            throw new UnsupportedOperationException("Only adding items at the end of the list is supported.");
        }
        this.a(n, o);
    }
    
    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != null) {
            if (this == o) {
                return true;
            }
            if (this.getClass() == o.getClass()) {
                return this.a.equals((Object)((e)o).a);
            }
        }
        return false;
    }
    
    @Override
    public final Object get(final int n) {
        this.a(n);
        return d.a(this.a.opt(n), this.b, null);
    }
    
    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public final boolean remove(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final boolean removeAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final boolean retainAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final Object set(final int n, final Object o) {
        this.a(n);
        final Object value = this.get(n);
        this.a(n, o);
        return value;
    }
    
    @Override
    public final int size() {
        return this.a.length();
    }
    
    @Override
    public final String toString() {
        return String.format("GraphObjectList{itemType=%s, state=%s}", this.b.getSimpleName(), this.a);
    }
}
