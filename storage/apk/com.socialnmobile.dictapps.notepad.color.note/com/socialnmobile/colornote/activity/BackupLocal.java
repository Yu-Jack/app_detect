// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnClickListener;
import android.os.Build$VERSION;
import android.view.Menu;
import android.widget.AdapterView$AdapterContextMenuInfo;
import android.widget.AdapterView;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.View;
import android.view.ContextMenu;
import android.view.View$OnCreateContextMenuListener;
import android.view.View$OnClickListener;
import android.os.Bundle;
import java.io.File;
import android.net.Uri;
import java.util.ArrayList;
import android.view.MenuItem;
import android.widget.ListAdapter;
import java.util.List;
import com.socialnmobile.colornote.ColorNote;
import android.content.ServiceConnection;
import android.content.Context;
import android.content.Intent;
import com.socialnmobile.colornote.sync.SyncService;
import android.widget.AdapterView$OnItemClickListener;
import android.app.Dialog;
import android.widget.ListView;
import android.widget.Button;
import android.app.Activity;

public class BackupLocal extends Activity
{
    Button a;
    public ListView b;
    public jr c;
    public jv d;
    public boolean e;
    Dialog f;
    boolean g;
    AdapterView$OnItemClickListener h;
    lh i;
    public lh j;
    lh k;
    
    public BackupLocal() {
        this.g = false;
        this.h = (AdapterView$OnItemClickListener)new ha(this);
        this.i = new hb(this);
        this.j = new hc(this);
        this.k = new hd(this);
    }
    
    private void c() {
        this.b.setAdapter((ListAdapter)new yp((Context)this, this.c, this.c.e()));
    }
    
    public final void a() {
        if (this.f == null) {
            this.f = new li((Context)this);
        }
        this.f.show();
    }
    
    public final void a(final int n, final lh lh) {
        if (!lh.a("0000")) {
            this.showDialog(n);
        }
    }
    
    public final boolean a(final String s, final String s2, final String s3) {
        this.c.a(s);
        return this.c.a(s2, s3, null, true);
    }
    
    public final void b() {
        this.f.dismiss();
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n == 1 && n2 == -1) {
            this.showDialog(4);
        }
    }
    
    public boolean onContextItemSelected(final MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2131624186: {
                this.showDialog(1);
                return true;
            }
            case 2131624189: {
                this.a(5, this.i);
                return true;
            }
            case 2131624169: {
                this.showDialog(7);
                return true;
            }
            case 2131624190: {
                final Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
                intent.setType("plain/text");
                intent.putExtra("android.intent.extra.SUBJECT", String.valueOf(this.getString(2131230728)) + " - " + this.getString(2131230985));
                intent.putExtra("android.intent.extra.TEXT", String.valueOf(this.getString(2131230728)) + " - " + this.getString(2131230985));
                final ArrayList<Uri> list = new ArrayList<Uri>();
                list.add(Uri.fromFile(new File(String.valueOf(this.d.e) + this.d.f + ".idx")));
                list.add(Uri.fromFile(new File(String.valueOf(this.d.e) + this.d.f + ".dat")));
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", (ArrayList)list);
                this.startActivity(Intent.createChooser(intent, (CharSequence)this.getString(2131230850)));
                break;
            }
        }
        return false;
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.c = new jr((Context)this);
        this.setContentView(2130903041);
        (this.a = (Button)this.findViewById(2131623938)).setOnClickListener((View$OnClickListener)new he(this));
        (this.b = (ListView)this.findViewById(2131623939)).setOnItemClickListener(this.h);
        this.b.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)this);
        this.c();
    }
    
    public void onCreateContextMenu(final ContextMenu contextMenu, final View view, final ContextMenu$ContextMenuInfo contextMenu$ContextMenuInfo) {
        while (true) {
            Object item;
            try {
                item = ((AdapterView)view).getAdapter().getItem(((AdapterView$AdapterContextMenuInfo)contextMenu$ContextMenuInfo).position);
                if (item == null) {
                    return;
                }
            }
            catch (ClassCastException ex) {
                ColorNote.a("bad menuInfo");
                return;
            }
            this.d = (jv)item;
            contextMenu.setHeaderTitle((CharSequence)gs.b((Context)this, this.d.c));
            this.getMenuInflater().inflate(2131558412, (Menu)contextMenu);
            if (this.d.a < 3) {
                contextMenu.findItem(2131624189).setVisible(false);
            }
            if (rt.a((Context)this)) {
                contextMenu.findItem(2131624186).setVisible(false);
            }
            if (Build$VERSION.SDK_INT < 19) {
                return;
            }
            final String e = this.d.e;
            final jr c = this.c;
            if (e.equals(jr.c())) {
                break;
            }
            return;
        }
        contextMenu.findItem(2131624169).setVisible(false);
    }
    
    protected Dialog onCreateDialog(final int n) {
        switch (n) {
            default: {
                return super.onCreateDialog(n);
            }
            case 1: {
                return gw.a((Context)this, 2131230736, 2131230917, (DialogInterface$OnClickListener)new hf(this));
            }
            case 7: {
                return gw.a((Context)this, 2131230796, 2131230925, (DialogInterface$OnClickListener)new hg(this));
            }
            case 5: {
                return new ld((Context)this, this.i, null, 2131230918);
            }
            case 3: {
                return new ld((Context)this, this.j, null, 2131230918);
            }
            case 4: {
                return new ld((Context)this, this.k, null, 0);
            }
            case 6: {
                return gw.a((Context)this, 2130837583, 2131230820, 2131230924, (DialogInterface$OnClickListener)new hh(this));
            }
        }
    }
    
    public boolean onCreateOptionsMenu(final Menu menu) {
        this.getMenuInflater().inflate(2131558402, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            default: {
                return super.onOptionsItemSelected(menuItem);
            }
            case 2131624161: {
                this.showDialog(6);
                return true;
            }
        }
    }
    
    protected void onStart() {
        super.onStart();
        eg.a((Context)this, "7WTGHNWSX5PSDGSHN65D");
    }
    
    protected void onStop() {
        super.onStop();
        eg.a((Context)this);
    }
}
