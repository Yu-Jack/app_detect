// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.view.MenuItem;
import android.view.Menu;
import android.content.DialogInterface$OnClickListener;
import android.app.Dialog;
import android.os.Bundle;
import android.content.SharedPreferences$Editor;
import android.widget.Toast;
import android.content.Context;
import android.view.View$OnClickListener;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;

public class PasswordSetting extends Activity
{
    public EditText a;
    View b;
    public EditText c;
    public EditText d;
    Button e;
    public int f;
    View$OnClickListener g;
    
    public PasswordSetting() {
        this.g = (View$OnClickListener)new ib(this);
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903044);
        this.a = (EditText)this.findViewById(2131623955);
        this.b = this.findViewById(2131623954);
        this.c = (EditText)this.findViewById(2131623956);
        this.d = (EditText)this.findViewById(2131623957);
        this.e = (Button)this.findViewById(2131623958);
        if ("note.socialnmobile.intent.action.CHANGE_MASTER_PASSWORD".equalsIgnoreCase(this.getIntent().getAction()) && jq.a((Context)this)) {
            this.f = 2;
            this.a.setVisibility(0);
            this.b.setVisibility(0);
            this.e.setText(2131230973);
        }
        else {
            this.f = 1;
        }
        this.e.setOnClickListener(this.g);
    }
    
    protected Dialog onCreateDialog(final int n) {
        switch (n) {
            default: {
                return super.onCreateDialog(n);
            }
            case 1: {
                return gw.a((Context)this, 2130837583, 2131230974, 2131230923, (DialogInterface$OnClickListener)new ic(this));
            }
        }
    }
    
    public boolean onCreateOptionsMenu(final Menu menu) {
        if (this.f == 2) {
            this.getMenuInflater().inflate(2131558409, menu);
            return true;
        }
        return false;
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            default: {
                return super.onOptionsItemSelected(menuItem);
            }
            case 2131624188: {
                this.showDialog(1);
                return true;
            }
        }
    }
}
