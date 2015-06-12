// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.view.MenuItem;
import android.view.Menu;
import android.content.DialogInterface$OnClickListener;
import com.socialnmobile.colornote.dialog.DialogFactory;
import com.socialnmobile.colornote.dialog.DialogFactory$ConfirmDialogFragment;
import android.app.Dialog;
import android.view.View$OnClickListener;
import android.os.Bundle;
import com.socialnmobile.colornote.ColorNote;
import android.widget.Toast;
import android.widget.TextView;
import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion;
import android.content.Intent;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import android.content.Context;
import java.lang.ref.WeakReference;
import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;

public class SyncStatus$SyncListener implements SyncJob$Listener
{
    WeakReference mActivityReference;
    Context mContext;
    boolean mSignOut;
    
    public SyncStatus$SyncListener(final SyncStatus referent, final boolean mSignOut) {
        this.mActivityReference = new WeakReference((T)referent);
        this.mContext = (Context)referent.getApplication();
        this.mSignOut = mSignOut;
    }
    
    @Override
    public void onError(final AuthRequired authRequired) {
        final SyncStatus syncStatus = (SyncStatus)this.mActivityReference.get();
        if (syncStatus == null) {
            return;
        }
        if (this.mSignOut) {
            syncStatus.k = 1;
        }
        else {
            syncStatus.k = 2;
        }
        syncStatus.startActivityForResult(new Intent(this.mContext, (Class)SyncRelogin.class), 1);
    }
    
    @Override
    public void onError(final UnsupportedClientVersion unsupportedClientVersion) {
        final SyncStatus syncStatus = (SyncStatus)this.mActivityReference.get();
        if (syncStatus == null) {
            return;
        }
        syncStatus.showDialog(3);
    }
    
    @Override
    public void onException(final Exception ex) {
        final SyncStatus syncStatus = (SyncStatus)this.mActivityReference.get();
        if (syncStatus == null) {
            return;
        }
        SyncStatus.a(syncStatus, ex);
    }
    
    @Override
    public void onFinalize() {
        gw.b();
        final SyncStatus syncStatus = (SyncStatus)this.mActivityReference.get();
        if (syncStatus == null) {
            return;
        }
        syncStatus.d();
    }
    
    @Override
    public void onFinished(final Object o) {
        final SyncStatus syncStatus = (SyncStatus)this.mActivityReference.get();
        if (syncStatus == null) {
            return;
        }
        syncStatus.a(100);
        if (this.mSignOut) {
            kg.b(this.mContext);
            jp.a(this.mContext);
            final Context mContext = this.mContext;
            syncStatus.finish();
            return;
        }
        syncStatus.f();
    }
    
    @Override
    public void onInit() {
        gw.a(this.mContext);
        final SyncStatus syncStatus = (SyncStatus)this.mActivityReference.get();
        if (syncStatus == null) {
            return;
        }
        SyncStatus.a(syncStatus);
        syncStatus.a(syncStatus.getString(2131231017));
        syncStatus.a(0);
    }
    
    @Override
    public void onProgress(final int n, final int n2) {
        final SyncStatus syncStatus = (SyncStatus)this.mActivityReference.get();
        if (syncStatus == null) {
            return;
        }
        if (n2 == 0) {
            syncStatus.a(0);
            return;
        }
        syncStatus.a(n * 100 / n2);
    }
}
