// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Collections;
import org.json.JSONObject;
import java.util.List;

public final class ef
{
    public final int errorCode;
    public final bl nM;
    public final bu nN;
    public final String nO;
    public final bo nP;
    public final List nt;
    public final List nu;
    public final long nx;
    public final int orientation;
    public final ex oy;
    public final ai pX;
    public final String qa;
    public final long qf;
    public final boolean qg;
    public final long qh;
    public final List qi;
    public final String ql;
    public final al rA;
    public final long rB;
    public final long rC;
    public final JSONObject ry;
    public final bm rz;
    
    public ef(final ai px, final ex oy, final List list, final int errorCode, final List list2, final List list3, final int orientation, final long nx, final String qa, final boolean qg, final bl nm, final bu nn, final String no, final bm rz, final bo np, final long qh, final al ra, final long qf, final long rb, final long rc, final String ql, final JSONObject ry) {
        this.pX = px;
        this.oy = oy;
        List<Object> unmodifiableList;
        if (list != null) {
            unmodifiableList = Collections.unmodifiableList((List<?>)list);
        }
        else {
            unmodifiableList = null;
        }
        this.nt = unmodifiableList;
        this.errorCode = errorCode;
        List<Object> unmodifiableList2;
        if (list2 != null) {
            unmodifiableList2 = Collections.unmodifiableList((List<?>)list2);
        }
        else {
            unmodifiableList2 = null;
        }
        this.nu = unmodifiableList2;
        List<Object> unmodifiableList3;
        if (list3 != null) {
            unmodifiableList3 = Collections.unmodifiableList((List<?>)list3);
        }
        else {
            unmodifiableList3 = null;
        }
        this.qi = unmodifiableList3;
        this.orientation = orientation;
        this.nx = nx;
        this.qa = qa;
        this.qg = qg;
        this.nM = nm;
        this.nN = nn;
        this.nO = no;
        this.rz = rz;
        this.nP = np;
        this.qh = qh;
        this.rA = ra;
        this.qf = qf;
        this.rB = rb;
        this.rC = rc;
        this.ql = ql;
        this.ry = ry;
    }
}
