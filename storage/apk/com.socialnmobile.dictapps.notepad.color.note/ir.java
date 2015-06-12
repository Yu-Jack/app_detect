import com.socialnmobile.colornote.sync.errors.UnexpectedLocalAccountException;
import com.socialnmobile.colornote.ColorNote;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.os.Bundle;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleLoginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookLoginListener;
import android.widget.Toast;
import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;
import com.socialnmobile.colornote.sync.jobs.listeners.EmailLoginListener;
import android.widget.TextView;
import android.widget.EditText;

public final class ir implements View$OnClickListener
{
    final /* synthetic */ SyncLogIn a;
    
    public ir(final SyncLogIn a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        if (!this.a.a((View$OnClickListener)this, view)) {
            return;
        }
        SyncLogIn.a(this.a);
        switch (view.getId()) {
            default: {}
            case 2131623991: {
                this.a.b();
            }
            case 2131623998: {
                this.a.startActivityForResult(new Intent((Context)this.a, (Class)SyncSignUp.class), 1);
            }
            case 2131624000: {
                this.a.startActivity(new Intent((Context)this.a, (Class)BackupLocal.class));
            }
            case 2131623992: {
                this.a.c();
            }
            case 2131623993: {
                if (this.a.i.getVisibility() == 0) {
                    this.a.i.setVisibility(8);
                    this.a.findViewById(2131623991).setVisibility(0);
                    this.a.findViewById(2131623992).setVisibility(0);
                    return;
                }
                this.a.i.setVisibility(0);
                this.a.findViewById(2131623991).setVisibility(8);
                this.a.findViewById(2131623992).setVisibility(8);
            }
            case 2131623997: {
                final String string = this.a.f.getText().toString();
                final String string2 = this.a.g.getText().toString();
                if (string.length() == 0 || string2.length() == 0) {
                    this.a.c(this.a.getString(2131231036));
                    return;
                }
                if (!gw.c(string)) {
                    this.a.c(this.a.getString(2131231051));
                    return;
                }
                try {
                    ColorNote.a(this.a.getApplicationContext(), "SYNC", "SIGNIN", "Method", "Email");
                    this.a.c.a(string, string2, this.a.k);
                    return;
                }
                catch (UnexpectedLocalAccountException ex) {
                    this.a.c.a();
                    this.a.setResult(-1);
                    this.a.finish();
                    return;
                }
                break;
            }
        }
    }
}
