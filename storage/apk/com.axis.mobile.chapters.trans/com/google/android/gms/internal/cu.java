// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.content.IntentSender$SendIntentException;
import android.app.PendingIntent;
import android.os.IBinder;
import android.content.ComponentName;
import android.os.RemoteException;
import android.content.Intent;
import android.content.Context;
import android.app.Activity;
import android.content.ServiceConnection;

public class cu extends dd$a implements ServiceConnection
{
    private dg oX;
    private cr oY;
    private final cx oZ;
    private final Activity og;
    private cz pb;
    private Context ph;
    private db pi;
    private cv pj;
    private String pk;
    
    public cu(final Activity og) {
        this.pk = null;
        this.og = og;
        this.oZ = cx.k(this.og.getApplicationContext());
    }
    
    public static void a(final Context context, final boolean b, final cq cq) {
        final Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", b);
        cq.a(intent, cq);
        context.startActivity(intent);
    }
    
    private void a(final String s, final boolean b, final int n, final Intent intent) {
        try {
            this.oX.a(new cw(this.ph, s, b, n, intent, this.pj));
        }
        catch (RemoteException ex) {
            eu.D("Fail to invoke PlayStorePurchaseListener.");
        }
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n != 1001) {
            return;
        }
        while (true) {
            Label_0118: {
                try {
                    final int c = cy.c(intent);
                    if (n2 == -1 && c == 0) {
                        if (this.pb.a(this.pk, n2, intent)) {
                            this.a(this.pi.getProductId(), true, n2, intent);
                        }
                        else {
                            this.a(this.pi.getProductId(), false, n2, intent);
                        }
                        this.pi.recordPlayBillingResolution(c);
                        return;
                    }
                    break Label_0118;
                }
                catch (RemoteException ex) {
                    eu.D("Fail to process purchase result.");
                    return;
                    this.oZ.a(this.pj);
                    this.a(this.pi.getProductId(), false, n2, intent);
                    continue;
                }
                finally {
                    this.pk = null;
                    this.og.finish();
                }
            }
            break;
        }
    }
    
    public void onCreate() {
        final cq b = cq.b(this.og.getIntent());
        this.oX = b.kX;
        this.pb = b.kZ;
        this.pi = b.oT;
        this.oY = new cr(this.og.getApplicationContext());
        this.ph = b.oU;
        final Activity og = this.og;
        final Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        this.og.getApplicationContext();
        og.bindService(intent, (ServiceConnection)this, 1);
    }
    
    public void onDestroy() {
        this.og.unbindService((ServiceConnection)this);
        this.oY.destroy();
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        this.oY.o(binder);
        try {
            this.pk = this.pb.bm();
            final Bundle a = this.oY.a(this.og.getPackageName(), this.pi.getProductId(), this.pk);
            final PendingIntent pendingIntent = (PendingIntent)a.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                final int a2 = cy.a(a);
                this.pi.recordPlayBillingResolution(a2);
                this.a(this.pi.getProductId(), false, a2, null);
                this.og.finish();
                return;
            }
            this.pj = new cv(this.pi.getProductId(), this.pk);
            this.oZ.b(this.pj);
            this.og.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), (int)Integer.valueOf(0), (int)Integer.valueOf(0), (int)Integer.valueOf(0));
        }
        catch (RemoteException | IntentSender$SendIntentException o) {
            eu.c("Error when connecting in-app billing service", (Throwable)o);
            this.og.finish();
        }
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
        eu.B("In-app billing service disconnected.");
        this.oY.destroy();
    }
}
