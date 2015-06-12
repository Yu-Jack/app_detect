// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.metadata;

import java.util.HashSet;
import java.util.Collection;
import java.util.Collections;
import com.google.android.gms.internal.gz;
import java.util.Set;

public abstract class f<T> implements a<T>
{
    private final String a;
    private final Set<String> b;
    private final int c;
    
    protected f(final String o, final int c) {
        this.a = gz.a(o, "fieldName");
        this.b = Collections.singleton(o);
        this.c = c;
    }
    
    protected f(final String s, final Collection<String> c, final int c2) {
        this.a = gz.a(s, "fieldName");
        this.b = Collections.unmodifiableSet((Set<? extends String>)new HashSet<String>(c));
        this.c = c2;
    }
    
    @Override
    public final String a() {
        return this.a;
    }
    
    @Override
    public String toString() {
        return this.a;
    }
}
