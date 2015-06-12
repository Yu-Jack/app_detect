// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.os.IBinder;
import android.content.ComponentName;
import android.app.Dialog;
import com.socialnmobile.colornote.ColorNote;
import android.net.Uri;
import android.content.Intent;
import android.content.Context;
import android.webkit.CookieSyncManager;
import android.text.TextUtils;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.view.View;
import android.view.View$OnClickListener;
import android.app.ProgressDialog;
import com.socialnmobile.colornote.sync.SyncService;
import android.content.ServiceConnection;
import android.app.Activity;

public abstract class SyncActivity extends Activity implements ServiceConnection
{
    final dy a;
    final ro b;
    public SyncService c;
    String d;
    ProgressDialog e;
    private boolean f;
    private ea g;
    private ea h;
    
    public SyncActivity() {
        this.a = new dy("119344318128492");
        this.b = new ro("908669027715.apps.googleusercontent.com", "SNZBS6UfQj4_DJSY1K6S3naw");
        this.g = new io(this);
        this.h = new ip(this);
    }
    
    protected final void a(final int progress) {
        this.e.setProgress(progress);
    }
    
    protected final void a(final String message) {
        this.e.setMessage((CharSequence)message);
        if (!this.a()) {
            this.showDialog(1002);
        }
    }
    
    public abstract void a(final ur p0);
    
    public abstract void a(final uu p0);
    
    public final boolean a() {
        return this.isFinishing() || this.f;
    }
    
    public final boolean a(final View$OnClickListener view$OnClickListener, final View view) {
        if (this.c == null) {
            view.postDelayed((Runnable)new iq(this, view$OnClickListener, view), 100L);
            return false;
        }
        return true;
    }
    
    public final void b() {
        CookieManager.getInstance().removeAllCookie();
        this.a.a(this, new String[] { "email" }, this.h);
    }
    
    public final void b(final String d) {
        this.d = d;
        if (!this.a()) {
            this.showDialog(1001);
        }
    }
    
    public final void c() {
        CookieManager.getInstance().removeAllCookie();
        final ro b = this.b;
        final String[] array = { "email profile" };
        b.a = this.g;
        final Bundle bundle = new Bundle();
        if (array.length > 0) {
            bundle.putString("scope", TextUtils.join((CharSequence)" ", (Object[])array));
        }
        bundle.putString("client_id", b.b);
        bundle.putString("redirect_uri", "urn:ietf:wg:oauth:2.0:oob");
        bundle.putString("response_type", "code");
        final String string = "https://accounts.google.com/o/oauth2/auth?" + ef.a(bundle);
        CookieSyncManager.createInstance((Context)this);
        new rj(this, string, new rp(b)).show();
    }
    
    protected final void d() {
        if (!this.a()) {
            this.dismissDialog(1002);
        }
    }
    
    public final void e() {
        if (!this.a()) {
            this.dismissDialog(1001);
        }
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        this.a.a(n, n2, intent);
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (!this.bindService(new Intent("UI_FOREGROUND", (Uri)null, (Context)this, (Class)SyncService.class), (ServiceConnection)this, 1)) {
            ColorNote.a("bind SyncService FAILED");
        }
        CookieSyncManager.createInstance((Context)this);
        (this.e = new ProgressDialog((Context)this)).setProgressStyle(1);
        this.e.setCancelable(false);
        this.e.setProgress(0);
        this.e.setMax(100);
    }
    
    protected Dialog onCreateDialog(final int n) {
        switch (n) {
            default: {
                return super.onCreateDialog(n);
            }
            case 1001: {
                final ProgressDialog progressDialog = new ProgressDialog((Context)this);
                progressDialog.setCancelable(false);
                return (Dialog)progressDialog;
            }
            case 1002: {
                return (Dialog)this.e;
            }
        }
    }
    
    protected void onDestroy() {
        this.unbindService((ServiceConnection)this);
        this.f = true;
        super.onDestroy();
    }
    
    protected void onPrepareDialog(final int n, final Dialog dialog) {
        super.onPrepareDialog(n, dialog);
        switch (n) {
            default: {}
            case 1001: {
                ((ProgressDialog)dialog).setMessage((CharSequence)this.d);
            }
        }
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        this.c = ((wc)binder).a();
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
        if (this.c != null) {
            this.c = null;
        }
    }
    
    protected void onStart() {
        super.onStart();
        eg.a((Context)this, "7WTGHNWSX5PSDGSHN65D");
    }
    
    protected void onStop() {
        super.onStop();
        eg.a((Context)this);
    }
}
