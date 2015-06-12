// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.d;
import com.google.android.gms.common.c;
import android.content.Context;

public class di extends fy<dm>
{
    final int a;
    
    public di(final Context context, final c c, final d d, final int a) {
        super(context, c, d, new String[0]);
        this.a = a;
    }
    
    protected dm a(final IBinder binder) {
        return dn.a(binder);
    }
    
    @Override
    protected String a() {
        return "com.google.android.gms.ads.service.START";
    }
    
    @Override
    protected void a(final gt gt, final ge ge) {
        gt.g(ge, this.a, this.j().getPackageName(), new Bundle());
    }
    
    @Override
    protected String b() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }
    
    public dm c() {
        return super.m();
    }
}
