// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import android.os.Bundle;
import android.content.Context;
import java.util.HashMap;
import java.util.HashSet;
import java.math.BigInteger;

public class eh
{
    private static final eh rP;
    public static final String rQ;
    private final Object ls;
    public final String rR;
    private final ei rS;
    private BigInteger rT;
    private final HashSet rU;
    private final HashMap rV;
    private boolean rW;
    
    static {
        rP = new eh();
        rQ = eh.rP.rR;
    }
    
    private eh() {
        this.ls = new Object();
        this.rT = BigInteger.ONE;
        this.rU = new HashSet();
        this.rV = new HashMap();
        this.rW = false;
        this.rR = eo.bT();
        this.rS = new ei(this.rR);
    }
    
    public static Bundle a(final Context context, final ej ej, final String s) {
        return eh.rP.b(context, ej, s);
    }
    
    public static void b(final HashSet set) {
        eh.rP.c(set);
    }
    
    public static eh bH() {
        return eh.rP;
    }
    
    public static String bI() {
        return eh.rP.bJ();
    }
    
    public static ei bK() {
        return eh.rP.bL();
    }
    
    public static boolean bM() {
        return eh.rP.bN();
    }
    
    public void a(final eg e) {
        synchronized (this.ls) {
            this.rU.add(e);
        }
    }
    
    public void a(final String key, final ek value) {
        synchronized (this.ls) {
            this.rV.put(key, value);
        }
    }
    
    public Bundle b(final Context context, final ej ej, final String s) {
        final Bundle bundle;
        final Bundle bundle2;
        synchronized (this.ls) {
            bundle = new Bundle();
            bundle.putBundle("app", this.rS.b(context, s));
            bundle2 = new Bundle();
            for (final String key : this.rV.keySet()) {
                bundle2.putBundle(key, ((ek)this.rV.get(key)).toBundle());
            }
        }
        bundle.putBundle("slots", bundle2);
        final ArrayList<Bundle> list = new ArrayList<Bundle>();
        final Iterator<eg> iterator2 = this.rU.iterator();
        while (iterator2.hasNext()) {
            list.add(iterator2.next().toBundle());
        }
        bundle.putParcelableArrayList("ads", (ArrayList)list);
        ej.a(this.rU);
        this.rU.clear();
        // monitorexit(o)
        return bundle;
    }
    
    public String bJ() {
        synchronized (this.ls) {
            final String string = this.rT.toString();
            this.rT = this.rT.add(BigInteger.ONE);
            return string;
        }
    }
    
    public ei bL() {
        synchronized (this.ls) {
            return this.rS;
        }
    }
    
    public boolean bN() {
        synchronized (this.ls) {
            final boolean rw = this.rW;
            this.rW = true;
            return rw;
        }
    }
    
    public void c(final HashSet c) {
        synchronized (this.ls) {
            this.rU.addAll(c);
        }
    }
}
