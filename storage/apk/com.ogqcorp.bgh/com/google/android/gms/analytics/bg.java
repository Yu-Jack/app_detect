// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

class bg implements ap<bh>
{
    private final bh a;
    
    public bg() {
        this.a = new bh();
    }
    
    public bh a() {
        return this.a;
    }
    
    @Override
    public void a(final String s, final int d) {
        if ("ga_dispatchPeriod".equals(s)) {
            this.a.d = d;
            return;
        }
        p.d("int configuration name not recognized:  " + s);
    }
    
    @Override
    public void a(final String s, final String s2) {
    }
    
    @Override
    public void a(final String s, final boolean b) {
        if ("ga_dryRun".equals(s)) {
            final bh a = this.a;
            int e;
            if (b) {
                e = 1;
            }
            else {
                e = 0;
            }
            a.e = e;
            return;
        }
        p.d("bool configuration name not recognized:  " + s);
    }
    
    @Override
    public void b(final String s, final String c) {
        if ("ga_appName".equals(s)) {
            this.a.a = c;
            return;
        }
        if ("ga_appVersion".equals(s)) {
            this.a.b = c;
            return;
        }
        if ("ga_logLevel".equals(s)) {
            this.a.c = c;
            return;
        }
        p.d("string configuration name not recognized:  " + s);
    }
}
