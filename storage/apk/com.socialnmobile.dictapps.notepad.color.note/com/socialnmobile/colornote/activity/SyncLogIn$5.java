// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.os.Bundle;
import com.socialnmobile.colornote.sync.errors.UnexpectedLocalAccountException;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookLoginListener;
import com.socialnmobile.colornote.ColorNote;
import android.widget.Toast;
import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;
import com.socialnmobile.colornote.sync.jobs.listeners.EmailLoginListener;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Context;
import android.content.Intent;
import com.socialnmobile.colornote.sync.errors.UserNotFound;
import com.socialnmobile.colornote.sync.errors.ExternalAuthFailed;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleLoginListener;

class SyncLogIn$5 implements GoogleLoginListener
{
    final /* synthetic */ SyncLogIn this$0;
    private final /* synthetic */ uu val$token;
    
    SyncLogIn$5(final SyncLogIn this$0, final uu val$token) {
        this.this$0 = this$0;
        this.val$token = val$token;
    }
    
    @Override
    public void onError(final ExternalAuthFailed externalAuthFailed) {
        SyncLogIn.a(this.this$0, externalAuthFailed);
    }
    
    @Override
    public void onError(final UserNotFound userNotFound) {
        final Intent intent = new Intent((Context)this.this$0, (Class)SyncSignUp.class);
        intent.putExtra("EXTRA_MODE", 3);
        intent.putExtra("EXTRA_GOOGLE_TOKEN", this.val$token.toString());
        this.this$0.startActivityForResult(intent, 1);
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
