// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.app.NotificationManager;
import android.os.Bundle;
import com.socialnmobile.colornote.sync.errors.UnexpectedLocalAccountException;
import android.widget.Toast;
import android.content.Context;
import com.socialnmobile.colornote.sync.jobs.listeners.EmailReloginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleReloginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookReloginListener;
import android.view.View$OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.os.Handler;

public class SyncRelogin extends SyncActivity
{
    Handler f;
    View g;
    View h;
    View i;
    TextView j;
    TextView k;
    public EditText l;
    View m;
    TextView n;
    int o;
    View$OnClickListener p;
    private final FacebookReloginListener q;
    private final GoogleReloginListener r;
    private final EmailReloginListener s;
    
    public SyncRelogin() {
        this.f = new Handler();
        this.p = (View$OnClickListener)new is(this);
        this.q = new SyncRelogin$2(this);
        this.r = new SyncRelogin$3(this);
        this.s = new SyncRelogin$4(this);
    }
    
    private void a(final sl sl, final String text) {
        if (text != null) {
            this.k.setText((CharSequence)text);
        }
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.m.setVisibility(8);
        if (sl == sl.b) {
            this.g.setVisibility(0);
            this.j.setCompoundDrawablesWithIntrinsicBounds(2130837561, 0, 0, 0);
            this.j.setText(2131231024);
            return;
        }
        if (sl == sl.c) {
            this.h.setVisibility(0);
            this.j.setCompoundDrawablesWithIntrinsicBounds(2130837562, 0, 0, 0);
            this.j.setText(2131231025);
            return;
        }
        if (sl == sl.a) {
            this.m.setVisibility(0);
            this.j.setText(2131231013);
            return;
        }
        throw new RuntimeException("not reachable");
    }
    
    private void c(final String text) {
        this.n.setVisibility(0);
        this.n.setTextColor(-2293760);
        this.n.setText((CharSequence)text);
        Toast.makeText((Context)this, (CharSequence)text, 1).show();
    }
    
    protected final void a(final ur ur) {
        try {
            this.c.a(ur, this.q);
        }
        catch (UnexpectedLocalAccountException cause) {
            throw new IllegalStateException(cause);
        }
    }
    
    protected final void a(final uu uu) {
        try {
            this.c.a(uu, this.r);
        }
        catch (UnexpectedLocalAccountException cause) {
            throw new IllegalStateException(cause);
        }
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.o = this.getIntent().getIntExtra("EXTRA_PROCEED", 0);
        this.setContentView(2130903048);
        this.g = this.findViewById(2131623991);
        this.h = this.findViewById(2131623992);
        this.i = this.findViewById(2131623997);
        this.k = (TextView)this.findViewById(2131624002);
        this.j = (TextView)this.findViewById(2131624001);
        this.l = (EditText)this.findViewById(2131623996);
        this.m = this.findViewById(2131624003);
        this.n = (TextView)this.findViewById(2131623990);
        final rt c = rt.c((Context)this);
        if (c != null) {
            this.a(c.j(), sl.a(c));
            this.g.setOnClickListener(this.p);
            this.h.setOnClickListener(this.p);
            this.i.setOnClickListener(this.p);
            return;
        }
        throw new RuntimeException("not reachable");
    }
    
    protected void onResume() {
        super.onResume();
        ((NotificationManager)this.getSystemService("notification")).cancel(21);
    }
}
