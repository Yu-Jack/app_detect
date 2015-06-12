// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.view.MenuItem;
import android.view.Menu;
import android.content.DialogInterface$OnClickListener;
import com.socialnmobile.colornote.dialog.DialogFactory;
import com.socialnmobile.colornote.dialog.DialogFactory$ConfirmDialogFragment;
import android.app.Dialog;
import android.view.View$OnClickListener;
import android.os.Bundle;
import android.content.Intent;
import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;
import com.socialnmobile.colornote.ColorNote;
import android.widget.Toast;
import android.content.Context;
import android.widget.TextView;

public class SyncStatus extends SyncActivity
{
    TextView f;
    TextView g;
    TextView h;
    TextView i;
    TextView j;
    int k;
    
    public static String a(final rt rt) {
        return rt.i();
    }
    
    private void a(final CharSequence text, final boolean b) {
        this.i.setVisibility(0);
        this.i.setTextColor(-2293760);
        this.i.setText(text);
        if (b) {
            Toast.makeText((Context)this, text, 1).show();
        }
    }
    
    private void f() {
        final long a = jp.a((Context)this, "LAST_SYNC_TIME_MILLIS");
        if (a != 0L) {
            this.h.setText((CharSequence)gw.a((Context)this, a));
        }
        this.j.setText((CharSequence)new StringBuilder().append(jp.a((Context)this, "SYNC_NOTE_COUNT", 0)).toString());
    }
    
    private void g() {
        if (this.c == null) {
            return;
        }
        ColorNote.a(this.getApplicationContext(), "SYNC", "MANUAL_SYNC", "Source", "SyncStatus");
        this.c.a(new SyncStatus$SyncListener(this, false));
    }
    
    private void h() {
        if (this.c == null) {
            return;
        }
        ColorNote.a(this.getApplicationContext(), "SYNC", "SIGNOUT");
        this.c.a(new SyncStatus$SyncListener(this, true));
    }
    
    protected final void a(final ur ur) {
    }
    
    protected final void a(final uu uu) {
    }
    
    @Override
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 1 && n2 == -1) {
            if (this.k != 1) {
                this.g();
                return;
            }
            this.h();
        }
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903050);
        this.f = (TextView)this.findViewById(2131624002);
        this.g = (TextView)this.findViewById(2131624001);
        this.h = (TextView)this.findViewById(2131624007);
        this.j = (TextView)this.findViewById(2131624008);
        this.i = (TextView)this.findViewById(2131623990);
        final rt c = rt.c((Context)this);
        if (c != null) {
            final sl j = c.j();
            this.f.setText((CharSequence)c.i());
            if (j == sl.b) {
                this.g.setCompoundDrawablesWithIntrinsicBounds(2130837561, 0, 0, 0);
                this.g.setText(2131231024);
            }
            else if (j == sl.c) {
                this.g.setCompoundDrawablesWithIntrinsicBounds(2130837562, 0, 0, 0);
                this.g.setText(2131231025);
            }
            else if (j == sl.a) {
                this.g.setText(2131231013);
            }
            else {
                if (j != null) {
                    throw new RuntimeException("not reachable");
                }
                this.g.setText((CharSequence)"");
            }
        }
        else {
            final Intent intent = new Intent((Context)this, (Class)SyncLogIn.class);
            intent.putExtra("SYNC_ONLY", true);
            this.startActivity(intent);
            this.finish();
        }
        this.f();
        this.f.setOnClickListener((View$OnClickListener)new iv(this));
        this.findViewById(2131624009).setOnClickListener((View$OnClickListener)new iw(this));
        if (jp.m((Context)this)) {
            this.a(gt.a((Context)this), false);
        }
    }
    
    @Override
    protected Dialog onCreateDialog(final int n) {
        switch (n) {
            default: {
                return super.onCreateDialog(n);
            }
            case 3: {
                return ((DialogFactory$ConfirmDialogFragment)DialogFactory.a((DialogInterface$OnClickListener)new ix(this))).a((Context)this);
            }
            case 1: {
                return gw.a((Context)this, 2130837583, 2131230823, 2131230929, (DialogInterface$OnClickListener)new iy(this));
            }
            case 2: {
                return gw.a((Context)this, 2130837583, 2131231022, 2131230930, (DialogInterface$OnClickListener)new iz(this));
            }
        }
    }
    
    public boolean onCreateOptionsMenu(final Menu menu) {
        this.getMenuInflater().inflate(2131558413, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2131624184: {
                this.g();
                break;
            }
            case 2131624192: {
                this.showDialog(1);
                break;
            }
            case 2131624191: {
                this.showDialog(2);
                break;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }
    
    protected void onResume() {
        super.onResume();
    }
}
