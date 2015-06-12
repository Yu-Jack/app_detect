import android.content.SharedPreferences$Editor;
import android.widget.Toast;
import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.view.MenuItem;
import android.view.Menu;
import android.content.DialogInterface$OnClickListener;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

public final class ib implements View$OnClickListener
{
    final /* synthetic */ PasswordSetting a;
    
    public ib(final PasswordSetting a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        final String trim = this.a.c.getText().toString().trim();
        final String trim2 = this.a.d.getText().toString().trim();
        if (this.a.f == 2 && !jq.a((Context)this.a, this.a.a.getText().toString().trim())) {
            Toast.makeText((Context)this.a, 2131230984, 1).show();
            return;
        }
        if (trim.length() < 4) {
            Toast.makeText((Context)this.a, 2131230982, 1).show();
            return;
        }
        if (!trim.equals(trim2)) {
            Toast.makeText((Context)this.a, 2131230981, 1).show();
            return;
        }
        if (this.a.f == 2) {
            final boolean d = jq.d((Context)this.a);
            String c = null;
            if (d) {
                c = jq.c((Context)this.a);
            }
            PasswordSetting.a(this.a, trim);
            if (c != null) {
                final PasswordSetting a = this.a;
                final String b = jq.b((Context)a);
                if (b != null) {
                    final jz b2 = jz.b(30);
                    b2.b(b);
                    b2.c(1);
                    final String c2 = b2.c(c);
                    final SharedPreferences$Editor edit = kr.a((Context)a, "name_master_password").edit();
                    edit.putString("CRYPTO_ENCRYPTED_USER_KEY", c2);
                    edit.commit();
                }
            }
            this.a.setResult(-1);
            this.a.finish();
            return;
        }
        PasswordSetting.a(this.a, trim);
        this.a.setResult(-1);
        this.a.finish();
    }
}
