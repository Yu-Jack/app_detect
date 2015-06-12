// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.os.Bundle;
import android.content.Intent;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleLoginListener;
import com.socialnmobile.colornote.sync.errors.UnexpectedLocalAccountException;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookLoginListener;
import com.socialnmobile.colornote.ColorNote;
import android.widget.Toast;
import com.socialnmobile.colornote.sync.jobs.listeners.EmailLoginListener;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Context;
import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;

class SyncLogIn$3 implements SyncJob$Listener
{
    final /* synthetic */ SyncLogIn this$0;
    
    SyncLogIn$3(final SyncLogIn this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void onError(final AuthRequired authRequired) {
    }
    
    @Override
    public void onError(final UnsupportedClientVersion unsupportedClientVersion) {
    }
    
    @Override
    public void onException(final Exception ex) {
        SyncLogIn.a(this.this$0, ex);
        this.this$0.finish();
    }
    
    @Override
    public void onFinalize() {
        gw.b();
        this.this$0.d();
    }
    
    @Override
    public void onFinished(final Object o) {
        this.this$0.a(100);
        this.this$0.finish();
    }
    
    @Override
    public void onInit() {
        SyncLogIn.a(this.this$0);
        this.this$0.a(this.this$0.getString(2131231017));
        gw.a((Context)this.this$0);
    }
    
    @Override
    public void onProgress(final int n, final int n2) {
        if (n2 == 0) {
            this.this$0.a(0);
            return;
        }
        this.this$0.a(n * 100 / n2);
    }
}
