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
import com.socialnmobile.colornote.sync.jobs.listeners.EmailLoginListener;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class SyncLogIn extends SyncActivity
{
    public EditText f;
    public EditText g;
    TextView h;
    public View i;
    View$OnClickListener j;
    public EmailLoginListener k;
    
    public SyncLogIn() {
        this.j = (View$OnClickListener)new ir(this);
        this.k = new SyncLogIn$2(this);
    }
    
    private void c(final String text) {
        this.h.setVisibility(0);
        this.h.setText((CharSequence)text);
        Toast.makeText((Context)this, (CharSequence)text, 1).show();
    }
    
    protected final void a(final ur ur) {
        try {
            ColorNote.a(this.getApplicationContext(), "SYNC", "SIGNIN", "Method", "Facebook");
            this.c.a(ur, new SyncLogIn$4(this, ur));
        }
        catch (UnexpectedLocalAccountException ex) {
            this.c.a();
            this.setResult(-1);
            this.finish();
        }
    }
    
    protected final void a(final uu uu) {
        try {
            ColorNote.a(this.getApplicationContext(), "SYNC", "SIGNIN", "Method", "Google");
            this.c.a(uu, new SyncLogIn$5(this, uu));
        }
        catch (UnexpectedLocalAccountException ex) {
            this.c.a();
            this.setResult(-1);
            this.finish();
        }
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n == 1) {
            if (n2 == -1) {
                this.finish();
            }
            return;
        }
        super.onActivityResult(n, n2, intent);
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903047);
        final boolean booleanExtra = this.getIntent().getBooleanExtra("SYNC_ONLY", false);
        this.f = (EditText)this.findViewById(2131623995);
        this.g = (EditText)this.findViewById(2131623996);
        this.h = (TextView)this.findViewById(2131623990);
        this.i = this.findViewById(2131623994);
        this.findViewById(2131623991).setOnClickListener(this.j);
        this.findViewById(2131623992).setOnClickListener(this.j);
        this.findViewById(2131623997).setOnClickListener(this.j);
        this.findViewById(2131623993).setOnClickListener(this.j);
        this.findViewById(2131624000).setOnClickListener(this.j);
        this.findViewById(2131623998).setOnClickListener(this.j);
        if (gw.c()) {
            this.findViewById(2131623991).setEnabled(false);
        }
        if (booleanExtra) {
            this.setTitle(2131230987);
            this.findViewById(2131623989).setVisibility(8);
            this.findViewById(2131623999).setVisibility(8);
            this.findViewById(2131624000).setVisibility(8);
        }
    }
    
    protected void onResume() {
        super.onResume();
        this.h.setVisibility(8);
    }
}
