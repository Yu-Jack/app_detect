// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

public enum co
{
    a("Unknown", 0, "unknown"), 
    b("CreativeView", 1, "creativeView"), 
    c("Start", 2, "start"), 
    d("Midpoint", 3, "midpoint"), 
    e("FirstQuartile", 4, "firstQuartile"), 
    f("ThirdQuartile", 5, "thirdQuartile"), 
    g("Complete", 6, "complete"), 
    h("Mute", 7, "mute"), 
    i("UnMute", 8, "unmute"), 
    j("Pause", 9, "pause"), 
    k("Rewind", 10, "rewind"), 
    l("Resume", 11, "resume"), 
    m("FullScreen", 12, "fullscreen"), 
    n("Expand", 13, "expand"), 
    o("Collapse", 14, "collapse"), 
    p("AcceptInvitation", 15, "acceptInvitation"), 
    q("Close", 16, "close");
    
    private String r;
    
    private co(final String name, final int ordinal, final String r) {
        this.r = r;
    }
    
    public static co a(final String s) {
        if (co.b.a().equals(s)) {
            return co.b;
        }
        if (co.c.a().equals(s)) {
            return co.c;
        }
        if (co.d.a().equals(s)) {
            return co.d;
        }
        if (co.e.a().equals(s)) {
            return co.e;
        }
        if (co.f.a().equals(s)) {
            return co.f;
        }
        if (co.g.a().equals(s)) {
            return co.g;
        }
        if (co.h.a().equals(s)) {
            return co.h;
        }
        if (co.i.a().equals(s)) {
            return co.i;
        }
        if (co.j.a().equals(s)) {
            return co.j;
        }
        if (co.k.a().equals(s)) {
            return co.k;
        }
        if (co.l.a().equals(s)) {
            return co.l;
        }
        if (co.m.a().equals(s)) {
            return co.m;
        }
        if (co.n.a().equals(s)) {
            return co.n;
        }
        if (co.o.a().equals(s)) {
            return co.o;
        }
        if (co.p.a().equals(s)) {
            return co.p;
        }
        if (co.q.a().equals(s)) {
            return co.q;
        }
        return co.a;
    }
    
    public final String a() {
        return this.r;
    }
}
