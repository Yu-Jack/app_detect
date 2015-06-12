import com.socialnmobile.colornote.sync.errors.UnexpectedLocalAccountException;
import android.view.View;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Context;
import com.socialnmobile.colornote.sync.jobs.listeners.EmailReloginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleReloginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookReloginListener;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Handler;

public final class is implements View$OnClickListener
{
    final /* synthetic */ SyncRelogin a;
    
    public is(final SyncRelogin a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        if (!this.a.a((View$OnClickListener)this, view)) {
            return;
        }
        switch (view.getId()) {
            default: {}
            case 2131623991: {
                this.a.b();
            }
            case 2131623992: {
                this.a.c();
            }
            case 2131623997: {
                final String trim = this.a.l.getText().toString().trim();
                if (trim.length() == 0) {
                    this.a.c(this.a.getString(2131231037));
                    return;
                }
                try {
                    this.a.c.a(trim, SyncRelogin.a(this.a));
                    return;
                }
                catch (UnexpectedLocalAccountException cause) {
                    throw new IllegalStateException(cause);
                }
                break;
            }
        }
    }
}
