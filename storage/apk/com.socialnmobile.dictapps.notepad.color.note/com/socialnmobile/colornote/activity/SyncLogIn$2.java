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
import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;
import android.content.Context;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import com.socialnmobile.colornote.sync.errors.UserNotFound;
import com.socialnmobile.colornote.sync.errors.PasswordNotMatch;
import com.socialnmobile.colornote.sync.jobs.listeners.EmailLoginListener;

class SyncLogIn$2 implements EmailLoginListener
{
    final /* synthetic */ SyncLogIn this$0;
    
    SyncLogIn$2(final SyncLogIn this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void onError(final PasswordNotMatch passwordNotMatch) {
        final sl authSuggest = passwordNotMatch.getAuthSuggest();
        if (authSuggest == sl.b) {
            this.this$0.c(this.this$0.getString(2131231054));
            return;
        }
        if (authSuggest == sl.c) {
            this.this$0.c(this.this$0.getString(2131231055));
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
        SyncLogIn.a(this.this$0, ex);
    }
    
    @Override
    public void onFinalize() {
        this.this$0.e();
    }
    
    @Override
    public void onFinished(final Object o) {
        SyncLogIn.b(this.this$0);
    }
    
    @Override
    public void onInit() {
        SyncLogIn.a(this.this$0);
        this.this$0.b(this.this$0.getString(2131231032));
    }
}
