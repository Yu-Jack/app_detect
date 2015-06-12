// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.content.ComponentName;
import android.os.SystemClock;
import java.util.ArrayList;
import android.os.Bundle;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.content.Intent;

class cs$1 implements Runnable
{
    final /* synthetic */ cv pc;
    final /* synthetic */ Intent pd;
    final /* synthetic */ cs pe;
    
    cs$1(final cs pe, final cv pc, final Intent pd) {
        this.pe = pe;
        this.pc = pc;
        this.pd = pd;
    }
    
    @Override
    public void run() {
        try {
            if (this.pe.pb.a(this.pc.pm, -1, this.pd)) {
                this.pe.oX.a(new cw(this.pe.mContext, this.pc.pn, true, -1, this.pd, this.pc));
                return;
            }
            this.pe.oX.a(new cw(this.pe.mContext, this.pc.pn, false, -1, this.pd, this.pc));
        }
        catch (RemoteException ex) {
            eu.D("Fail to verify and dispatch pending transaction");
        }
    }
}
