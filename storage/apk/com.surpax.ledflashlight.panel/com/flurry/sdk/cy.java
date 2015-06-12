// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Map;
import android.content.Context;
import java.io.File;

public class cy
{
    private static final String b;
    boolean a;
    private final cz c;
    private final File d;
    private String e;
    
    static {
        b = cy.class.getSimpleName();
    }
    
    public cy() {
        this(do.a().b());
    }
    
    public cy(final Context context) {
        this.c = new cz();
        this.d = context.getFileStreamPath(".flurryinstallreceiver.");
        eo.a(3, cy.b, "Referrer file name if it exists:  " + this.d);
    }
    
    private void b() {
        if (this.a) {
            return;
        }
        this.a = true;
        eo.a(4, cy.b, "Loading referrer info from file: " + this.d.getAbsolutePath());
        final String c = fd.c(this.d);
        eo.a(cy.b, "Referrer file contents: " + c);
        this.b(c);
    }
    
    private void b(final String e) {
        if (e == null) {
            return;
        }
        this.e = e;
    }
    
    private void c() {
        fd.a(this.d, this.e);
    }
    
    public Map a(final boolean b) {
        synchronized (this) {
            this.b();
            final Map a = this.c.a(this.e);
            if (b) {
                this.a();
            }
            return a;
        }
    }
    
    public void a() {
        synchronized (this) {
            this.d.delete();
            this.e = null;
            this.a = true;
        }
    }
    
    public void a(final String s) {
        synchronized (this) {
            this.a = true;
            this.b(s);
            this.c();
        }
    }
}
