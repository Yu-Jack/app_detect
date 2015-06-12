// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

class z implements ap<aa>
{
    private final aa a;
    
    public z() {
        this.a = new aa();
    }
    
    public aa a() {
        return this.a;
    }
    
    @Override
    public void a(final String s, final int c) {
        if ("ga_sessionTimeout".equals(s)) {
            this.a.c = c;
            return;
        }
        p.d("int configuration name not recognized:  " + s);
    }
    
    @Override
    public void a(final String s, final String s2) {
        this.a.g.put(s, s2);
    }
    
    @Override
    public void a(final String s, final boolean b) {
        int f = 1;
        if ("ga_autoActivityTracking".equals(s)) {
            final aa a = this.a;
            if (!b) {
                f = 0;
            }
            a.d = f;
            return;
        }
        if ("ga_anonymizeIp".equals(s)) {
            final aa a2 = this.a;
            if (!b) {
                f = 0;
            }
            a2.e = f;
            return;
        }
        if ("ga_reportUncaughtExceptions".equals(s)) {
            final aa a3 = this.a;
            if (!b) {
                f = 0;
            }
            a3.f = f;
            return;
        }
        p.d("bool configuration name not recognized:  " + s);
    }
    
    @Override
    public void b(final String str, final String str2) {
        if ("ga_trackingId".equals(str)) {
            this.a.a = str2;
            return;
        }
        if ("ga_sampleFrequency".equals(str)) {
            try {
                this.a.b = Double.parseDouble(str2);
                return;
            }
            catch (NumberFormatException ex) {
                p.a("Error parsing ga_sampleFrequency value: " + str2);
                return;
            }
        }
        p.d("string configuration name not recognized:  " + str);
    }
}
