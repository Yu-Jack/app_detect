// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.support.v4.app.Fragment;
import android.content.Intent;
import java.util.HashMap;
import java.util.UUID;
import java.util.Collections;
import android.app.Activity;
import java.util.Map;
import java.util.List;
import java.io.Serializable;

public class bd implements Serializable
{
    private final bi a;
    private bn b;
    private int c;
    private bj d;
    private boolean e;
    private List f;
    private bm g;
    private String h;
    private String i;
    private final String j;
    private final Map k;
    
    bd(final Activity activity) {
        this.b = bn.a;
        this.c = 64206;
        this.e = false;
        this.f = Collections.emptyList();
        this.g = bm.c;
        this.j = UUID.randomUUID().toString();
        this.k = new HashMap();
        this.a = new bi() {
            @Override
            public final Activity a() {
                return activity;
            }
            
            @Override
            public final void a(final Intent intent, final int n) {
                activity.startActivityForResult(intent, n);
            }
        };
    }
    
    bd(final Fragment fragment) {
        this.b = bn.a;
        this.c = 64206;
        this.e = false;
        this.f = Collections.emptyList();
        this.g = bm.c;
        this.j = UUID.randomUUID().toString();
        this.k = new HashMap();
        this.a = new bi() {
            @Override
            public final Activity a() {
                return fragment.getActivity();
            }
            
            @Override
            public final void a(final Intent intent, final int n) {
                fragment.startActivityForResult(intent, n);
            }
        };
    }
    
    bd a(final bm g) {
        if (g != null) {
            this.g = g;
        }
        return this;
    }
    
    bd a(final bn b) {
        if (b != null) {
            this.b = b;
        }
        return this;
    }
    
    bd a(final List f) {
        if (f != null) {
            this.f = f;
        }
        return this;
    }
    
    final bj a() {
        return this.d;
    }
    
    final void a(final String h) {
        this.h = h;
    }
    
    final bn b() {
        return this.b;
    }
    
    final int c() {
        return this.c;
    }
    
    final List d() {
        return this.f;
    }
    
    final bi e() {
        return this.a;
    }
    
    final String f() {
        return this.j;
    }
    
    final p g() {
        return new p(this.b, this.c, this.e, this.f, this.g, this.h, this.i, new x() {
            @Override
            public final Activity a() {
                return bd.this.a.a();
            }
            
            @Override
            public final void a(final Intent intent, final int n) {
                bd.this.a.a(intent, n);
            }
        }, this.j);
    }
}
