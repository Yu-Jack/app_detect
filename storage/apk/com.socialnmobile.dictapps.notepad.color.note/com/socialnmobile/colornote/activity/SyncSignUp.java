// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import com.socialnmobile.colornote.ColorNote;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Context;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleSignupListener;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookSignupListener;
import android.view.View$OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SyncSignUp extends SyncActivity
{
    TextView f;
    Button g;
    Button h;
    public ur i;
    public uu j;
    View$OnClickListener k;
    private final FacebookSignupListener l;
    private final GoogleSignupListener m;
    
    public SyncSignUp() {
        this.k = (View$OnClickListener)new it(this);
        this.l = new SyncSignUp$2(this);
        this.m = new SyncSignUp$3(this);
    }
    
    private void a(final String text, final boolean b, final boolean b2) {
        this.f.setVisibility(0);
        if (b2) {
            this.f.setTextColor(-2293760);
        }
        else {
            this.f.setTextColor(-1);
        }
        this.f.setText((CharSequence)text);
        if (b) {
            Toast.makeText((Context)this, (CharSequence)text, 1).show();
        }
    }
    
    protected final void a(final ur ur) {
        new iu(this, ur).execute((Object[])new String[0]);
    }
    
    protected final void a(final uu uu) {
        new iu(this, uu).execute((Object[])new String[0]);
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903049);
        this.g = (Button)this.findViewById(2131624005);
        this.h = (Button)this.findViewById(2131624006);
        this.f = (TextView)this.findViewById(2131623990);
        this.g.setOnClickListener(this.k);
        this.h.setOnClickListener(this.k);
        this.findViewById(2131624004).setOnClickListener(this.k);
        while (true) {
            Label_0302: {
                if (this.getIntent() == null) {
                    break Label_0302;
                }
                final int intExtra = this.getIntent().getIntExtra("EXTRA_MODE", 0);
                switch (intExtra) {
                    case 3: {
                        while (true) {
                            try {
                                if (this.getIntent().hasExtra("EXTRA_GOOGLE_TOKEN")) {
                                    this.j = (uu)uv.a.a(this.getIntent().getStringExtra("EXTRA_GOOGLE_TOKEN"));
                                }
                                this.a(this.getString(2131231011), false, false);
                                this.h.setVisibility(0);
                                this.g.setVisibility(8);
                                break;
                            }
                            catch (ux ux) {
                                ColorNote.a("google token exception");
                                continue;
                            }
                            break;
                        }
                    }
                    case 2: {
                        while (true) {
                            try {
                                if (this.getIntent().hasExtra("EXTRA_FACEBOOK_TOKEN")) {
                                    this.i = (ur)us.a.a(this.getIntent().getStringExtra("EXTRA_FACEBOOK_TOKEN"));
                                }
                                this.a(this.getString(2131231010), false, false);
                                this.h.setVisibility(8);
                                this.g.setVisibility(0);
                                break;
                            }
                            catch (ux ux2) {
                                ColorNote.a("facebook token exception");
                                continue;
                            }
                            break;
                        }
                        break Label_0302;
                    }
                }
                if (gw.c()) {
                    this.g.setEnabled(false);
                }
                return;
            }
            final int intExtra = 0;
            continue;
        }
    }
}
