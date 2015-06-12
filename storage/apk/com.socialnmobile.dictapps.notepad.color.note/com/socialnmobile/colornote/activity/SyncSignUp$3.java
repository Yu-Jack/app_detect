// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import com.socialnmobile.colornote.ColorNote;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Context;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookSignupListener;
import android.view.View$OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.socialnmobile.colornote.sync.errors.ExternalAuthFailed;
import com.socialnmobile.colornote.sync.errors.AlreadyInUse;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleSignupListener;

class SyncSignUp$3 implements GoogleSignupListener
{
    final /* synthetic */ SyncSignUp this$0;
    
    SyncSignUp$3(final SyncSignUp this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void onError(final AlreadyInUse alreadyInUse) {
        SyncSignUp.a(this.this$0, this.this$0.getString(2131231042));
    }
    
    @Override
    public void onError(final ExternalAuthFailed externalAuthFailed) {
        SyncSignUp.a(this.this$0, externalAuthFailed);
    }
    
    @Override
    public void onException(final Exception ex) {
        SyncSignUp.a(this.this$0, ex);
    }
    
    @Override
    public void onFinalize() {
        this.this$0.e();
    }
    
    @Override
    public void onFinished(final Object o) {
        this.this$0.c.a();
        this.this$0.setResult(-1);
        this.this$0.finish();
    }
    
    @Override
    public void onInit() {
        this.this$0.b(this.this$0.getString(2131231019));
        SyncSignUp.a(this.this$0);
    }
}
