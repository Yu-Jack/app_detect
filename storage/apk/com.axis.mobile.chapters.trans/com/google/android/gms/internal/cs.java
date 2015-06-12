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
import android.content.Intent;
import java.util.List;
import android.content.Context;
import android.content.ServiceConnection;

public class cs extends em implements ServiceConnection
{
    private final Object ls;
    private Context mContext;
    private boolean oW;
    private dg oX;
    private cr oY;
    private cx oZ;
    private List pa;
    private cz pb;
    
    public cs(final Context mContext, final dg ox, final cz pb) {
        this.ls = new Object();
        this.oW = false;
        this.pa = null;
        this.mContext = mContext;
        this.oX = ox;
        this.pb = pb;
        this.oY = new cr(mContext);
        this.oZ = cx.k(this.mContext);
        this.pa = this.oZ.d(10L);
    }
    
    private void a(final cv cv, final String s, final String s2) {
        final Intent intent = new Intent();
        intent.putExtra("RESPONSE_CODE", 0);
        intent.putExtra("INAPP_PURCHASE_DATA", s);
        intent.putExtra("INAPP_DATA_SIGNATURE", s2);
        et.sv.post((Runnable)new cs$1(this, cv, intent));
    }
    
    private void b(final long n) {
        do {
            if (!this.c(n)) {
                eu.D("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.oW);
    }
    
    private void bi() {
        if (!this.pa.isEmpty()) {
            final HashMap<String, cv> hashMap = new HashMap<String, cv>();
            for (final cv value : this.pa) {
                hashMap.put(value.pn, value);
            }
            String s = null;
            while (true) {
                final Bundle b = this.oY.b(this.mContext.getPackageName(), s);
                if (b == null || cy.a(b) != 0) {
                    break;
                }
                final ArrayList stringArrayList = b.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                final ArrayList stringArrayList2 = b.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                final ArrayList stringArrayList3 = b.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                final String string = b.getString("INAPP_CONTINUATION_TOKEN");
                for (int i = 0; i < stringArrayList.size(); ++i) {
                    if (hashMap.containsKey(stringArrayList.get(i))) {
                        final String s2 = stringArrayList.get(i);
                        final String s3 = stringArrayList2.get(i);
                        final String s4 = stringArrayList3.get(i);
                        final cv cv = hashMap.get(s2);
                        if (cv.pm.equals(cy.p(s3))) {
                            this.a(cv, s3, s4);
                            hashMap.remove(s2);
                        }
                    }
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                s = string;
            }
            final Iterator<String> iterator2 = hashMap.keySet().iterator();
            while (iterator2.hasNext()) {
                this.oZ.a(hashMap.get(iterator2.next()));
            }
        }
    }
    
    private boolean c(final long n) {
        final long n2 = 60000L - (SystemClock.elapsedRealtime() - n);
        if (n2 <= 0L) {
            return false;
        }
        try {
            this.ls.wait(n2);
            return true;
        }
        catch (InterruptedException ex) {
            eu.D("waitWithTimeout_lock interrupted");
            return true;
        }
    }
    
    @Override
    public void bh() {
        synchronized (this.ls) {
            final Context mContext = this.mContext;
            final Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            final Context mContext2 = this.mContext;
            mContext.bindService(intent, (ServiceConnection)this, 1);
            this.b(SystemClock.elapsedRealtime());
            this.mContext.unbindService((ServiceConnection)this);
            this.oY.destroy();
        }
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        synchronized (this.ls) {
            this.oY.o(binder);
            this.bi();
            this.oW = true;
            this.ls.notify();
        }
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
        eu.B("In-app billing service disconnected.");
        this.oY.destroy();
    }
    
    @Override
    public void onStop() {
        synchronized (this.ls) {
            this.mContext.unbindService((ServiceConnection)this);
            this.oY.destroy();
        }
    }
}
