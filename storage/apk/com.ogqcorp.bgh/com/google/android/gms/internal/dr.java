// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Map;

public final class dr
{
    public final aj a;
    public final aj b;
    private final Object c;
    private ep d;
    private String e;
    private int f;
    private String g;
    
    public dr(final String e) {
        this.c = new Object();
        this.f = -2;
        this.a = new aj() {
            @Override
            public void a(final ep ep, final Map<String, String> map) {
                synchronized (dr.this.c) {
                    en.e("Invalid " + map.get("type") + " request error: " + map.get("errors"));
                    dr.this.f = 1;
                    dr.this.c.notify();
                }
            }
        };
        this.b = new aj() {
            @Override
            public void a(final ep ep, final Map<String, String> map) {
                synchronized (dr.this.c) {
                    String replaceAll = map.get("url");
                    if (replaceAll == null) {
                        en.e("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (replaceAll.contains("%40mediation_adapters%40")) {
                        replaceAll = replaceAll.replaceAll("%40mediation_adapters%40", ec.a(ep.getContext(), map.get("check_adapters"), dr.this.e));
                        en.d("Ad request URL modified to " + replaceAll);
                    }
                    dr.this.g = replaceAll;
                    dr.this.c.notify();
                }
            }
        };
        this.e = e;
    }
    
    public int a() {
        synchronized (this.c) {
            return this.f;
        }
    }
    
    public void a(final ep d) {
        synchronized (this.c) {
            this.d = d;
        }
    }
    
    public String b() {
        synchronized (this.c) {
            while (this.g == null && this.f == -2) {
                try {
                    this.c.wait();
                    continue;
                }
                catch (InterruptedException ex) {
                    en.e("Ad request service was interrupted.");
                    return null;
                }
                break;
            }
            return this.g;
        }
    }
}
