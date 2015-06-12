// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.AbstractList;

public class aw extends AbstractList
{
    private static AtomicInteger a;
    private Handler b;
    private List c;
    private int d;
    private final String e;
    private List f;
    private String g;
    
    static {
        aw.a = new AtomicInteger();
    }
    
    public aw() {
        this.c = new ArrayList();
        this.d = 0;
        this.e = Integer.valueOf(aw.a.incrementAndGet()).toString();
        this.f = new ArrayList();
        this.c = new ArrayList();
    }
    
    public aw(final Collection c) {
        this.c = new ArrayList();
        this.d = 0;
        this.e = Integer.valueOf(aw.a.incrementAndGet()).toString();
        this.f = new ArrayList();
        this.c = new ArrayList(c);
    }
    
    public aw(final Request... a) {
        this.c = new ArrayList();
        this.d = 0;
        this.e = Integer.valueOf(aw.a.incrementAndGet()).toString();
        this.f = new ArrayList();
        this.c = Arrays.asList(a);
    }
    
    public final int a() {
        return this.d;
    }
    
    public final Request a(final int n) {
        return this.c.get(n);
    }
    
    final void a(final Handler b) {
        this.b = b;
    }
    
    public final void a(final ax ax) {
        if (!this.f.contains(ax)) {
            this.f.add(ax);
        }
    }
    
    final void a(final String g) {
        this.g = g;
    }
    
    final String b() {
        return this.e;
    }
    
    final Handler c() {
        return this.b;
    }
    
    @Override
    public final void clear() {
        this.c.clear();
    }
    
    final List d() {
        return this.c;
    }
    
    final List e() {
        return this.f;
    }
    
    final String f() {
        return this.g;
    }
    
    public final List g() {
        return Request.a(this);
    }
    
    public final av h() {
        return Request.b(this);
    }
    
    @Override
    public final int size() {
        return this.c.size();
    }
}
