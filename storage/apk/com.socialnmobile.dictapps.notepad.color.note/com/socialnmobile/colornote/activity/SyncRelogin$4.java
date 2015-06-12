// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.app.NotificationManager;
import android.os.Bundle;
import com.socialnmobile.colornote.sync.errors.UnexpectedLocalAccountException;
import android.widget.Toast;
import android.content.Context;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleReloginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookReloginListener;
import android.view.View$OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.os.Handler;
import com.socialnmobile.colornote.sync.errors.UserNotFound;
import com.socialnmobile.colornote.sync.errors.PasswordNotMatch;
import com.socialnmobile.colornote.sync.errors.AccountNotMatch;
import com.socialnmobile.colornote.sync.jobs.listeners.EmailReloginListener;

class SyncRelogin$4 implements EmailReloginListener
{
    final /* synthetic */ SyncRelogin this$0;
    
    SyncRelogin$4(final SyncRelogin this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void onError(final AccountNotMatch accountNotMatch) {
        SyncRelogin.a(this.this$0, accountNotMatch);
    }
    
    @Override
    public void onError(final PasswordNotMatch passwordNotMatch) {
        final sl authSuggest = passwordNotMatch.getAuthSuggest();
        if (authSuggest == sl.b) {
            SyncRelogin.a(this.this$0, sl.b);
            return;
        }
        if (authSuggest == sl.c) {
            SyncRelogin.a(this.this$0, sl.c);
            return;
        }
        this.this$0.c(this.this$0.getString(2131231047));
    }
    
    @Override
    public void onError(final UserNotFound userNotFound) {
        this.this$0.c(this.this$0.getString(2131231046));
    }
    
    @Override
    public void onException(final Exception ex) {
        SyncRelogin.a(this.this$0, ex);
    }
    
    @Override
    public void onFinalize() {
        this.this$0.e();
    }
    
    @Override
    public void onFinished(final Object o) {
        if (this.this$0.o == 1) {
            this.this$0.c.a();
            this.this$0.finish();
            return;
        }
        this.this$0.setResult(-1);
        this.this$0.finish();
    }
    
    @Override
    public void onInit() {
        SyncRelogin.b(this.this$0);
        this.this$0.b(this.this$0.getString(2131231032));
    }
}
