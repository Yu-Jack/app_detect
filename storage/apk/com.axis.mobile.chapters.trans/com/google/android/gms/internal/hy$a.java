// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.HashMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hy$a implements SafeParcelable
{
    public static final hz CREATOR;
    protected final int Hb;
    protected final boolean Hc;
    protected final int Hd;
    protected final boolean He;
    protected final String Hf;
    protected final int Hg;
    protected final Class Hh;
    protected final String Hi;
    private ib Hj;
    private hy$b Hk;
    private final int xM;
    
    static {
        CREATOR = new hz();
    }
    
    hy$a(final int xm, final int hb, final boolean hc, final int hd, final boolean he, final String hf, final int hg, final String hi, final ht ht) {
        this.xM = xm;
        this.Hb = hb;
        this.Hc = hc;
        this.Hd = hd;
        this.He = he;
        this.Hf = hf;
        this.Hg = hg;
        if (hi == null) {
            this.Hh = null;
            this.Hi = null;
        }
        else {
            this.Hh = ie.class;
            this.Hi = hi;
        }
        if (ht == null) {
            this.Hk = null;
            return;
        }
        this.Hk = ht.fC();
    }
    
    protected hy$a(final int hb, final boolean hc, final int hd, final boolean he, final String hf, final int hg, final Class hh, final hy$b hk) {
        this.xM = 1;
        this.Hb = hb;
        this.Hc = hc;
        this.Hd = hd;
        this.He = he;
        this.Hf = hf;
        this.Hg = hg;
        this.Hh = hh;
        if (hh == null) {
            this.Hi = null;
        }
        else {
            this.Hi = hh.getCanonicalName();
        }
        this.Hk = hk;
    }
    
    public static hy$a a(final String s, final int n, final hy$b hy$b, final boolean b) {
        return new hy$a(hy$b.fE(), b, hy$b.fF(), false, s, n, null, hy$b);
    }
    
    public static hy$a a(final String s, final int n, final Class clazz) {
        return new hy$a(11, false, 11, false, s, n, clazz, null);
    }
    
    public static hy$a b(final String s, final int n, final Class clazz) {
        return new hy$a(11, true, 11, true, s, n, clazz, null);
    }
    
    public static hy$a g(final String s, final int n) {
        return new hy$a(0, false, 0, false, s, n, null, null);
    }
    
    public static hy$a h(final String s, final int n) {
        return new hy$a(4, false, 4, false, s, n, null, null);
    }
    
    public static hy$a i(final String s, final int n) {
        return new hy$a(6, false, 6, false, s, n, null, null);
    }
    
    public static hy$a j(final String s, final int n) {
        return new hy$a(7, false, 7, false, s, n, null, null);
    }
    
    public static hy$a k(final String s, final int n) {
        return new hy$a(7, true, 7, true, s, n, null, null);
    }
    
    public void a(final ib hj) {
        this.Hj = hj;
    }
    
    public int describeContents() {
        final hz creator = hy$a.CREATOR;
        return 0;
    }
    
    public int fE() {
        return this.Hb;
    }
    
    public int fF() {
        return this.Hd;
    }
    
    public hy$a fJ() {
        return new hy$a(this.xM, this.Hb, this.Hc, this.Hd, this.He, this.Hf, this.Hg, this.Hi, this.fR());
    }
    
    public boolean fK() {
        return this.Hc;
    }
    
    public boolean fL() {
        return this.He;
    }
    
    public String fM() {
        return this.Hf;
    }
    
    public int fN() {
        return this.Hg;
    }
    
    public Class fO() {
        return this.Hh;
    }
    
    String fP() {
        if (this.Hi == null) {
            return null;
        }
        return this.Hi;
    }
    
    public boolean fQ() {
        return this.Hk != null;
    }
    
    ht fR() {
        if (this.Hk == null) {
            return null;
        }
        return ht.a(this.Hk);
    }
    
    public HashMap fS() {
        hm.f(this.Hi);
        hm.f(this.Hj);
        return this.Hj.aJ(this.Hi);
    }
    
    public Object g(final Object o) {
        return this.Hk.g(o);
    }
    
    public int getVersionCode() {
        return this.xM;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Field\n");
        sb.append("            versionCode=").append(this.xM).append('\n');
        sb.append("                 typeIn=").append(this.Hb).append('\n');
        sb.append("            typeInArray=").append(this.Hc).append('\n');
        sb.append("                typeOut=").append(this.Hd).append('\n');
        sb.append("           typeOutArray=").append(this.He).append('\n');
        sb.append("        outputFieldName=").append(this.Hf).append('\n');
        sb.append("      safeParcelFieldId=").append(this.Hg).append('\n');
        sb.append("       concreteTypeName=").append(this.fP()).append('\n');
        if (this.fO() != null) {
            sb.append("     concreteType.class=").append(this.fO().getCanonicalName()).append('\n');
        }
        final StringBuilder append = sb.append("          converterName=");
        String canonicalName;
        if (this.Hk == null) {
            canonicalName = "null";
        }
        else {
            canonicalName = this.Hk.getClass().getCanonicalName();
        }
        append.append(canonicalName).append('\n');
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final hz creator = hy$a.CREATOR;
        hz.a(this, parcel, n);
    }
}
