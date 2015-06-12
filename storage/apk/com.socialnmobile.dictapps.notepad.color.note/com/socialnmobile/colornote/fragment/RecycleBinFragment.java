// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import android.view.Menu;
import android.widget.AdapterView;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import com.socialnmobile.colornote.ColorNote;
import android.content.ContentUris;
import android.widget.AdapterView$AdapterContextMenuInfo;
import android.view.MenuItem;
import android.support.v4.app.FragmentActivity;
import java.util.Iterator;
import android.app.Activity;
import android.widget.ListAdapter;
import android.database.Cursor;
import android.view.View$OnCreateContextMenuListener;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface$OnClickListener;
import com.socialnmobile.colornote.dialog.DialogFactory;
import android.os.Bundle;
import android.content.Context;
import android.net.Uri;
import android.widget.ListView;
import android.os.Handler;
import android.widget.AdapterView$OnItemClickListener;
import android.view.View$OnClickListener;

public class RecycleBinFragment extends ScreenFragment implements w
{
    View$OnClickListener a;
    AdapterView$OnItemClickListener b;
    private Handler c;
    private ListView d;
    private abh e;
    private String f;
    private int g;
    private Uri h;
    private kh i;
    
    public RecycleBinFragment() {
        this.c = new Handler();
        this.e = new abh();
        this.a = (View$OnClickListener)new pk(this);
        this.b = (AdapterView$OnItemClickListener)new pl(this);
    }
    
    private void O() {
        final int g = this.g;
        int n = 0;
        switch (g) {
            case 6: {
                n = 2130837597;
                break;
            }
            case 5: {
                n = 2130837594;
                break;
            }
            case 2: {
                n = 2130837616;
                break;
            }
            case 3: {
                n = 2130837617;
                break;
            }
        }
        final rf a = super.ap.a(2131624157);
        if (a != null) {
            a.a(n);
        }
    }
    
    private void b() {
        this.O();
        this.aq.a(super.ap);
    }
    
    private void b(final Context context) {
        final String h = jp.h(context);
        if (this.f != null && this.f.equals(h)) {
            return;
        }
        this.f = h;
        final yc a = gr.a(context);
        this.d.setBackgroundColor(a.n(3));
        this.d.setCacheColorHint(a.n(3));
        this.e.b();
        this.d.invalidateViews();
    }
    
    private void c(final int g) {
        if (this.l()) {
            final Bundle bundle = new Bundle();
            bundle.putInt("SORT", g);
            this.q().a(0, bundle, this);
            int n = 0;
            switch (g) {
                default: {
                    n = 0;
                    break;
                }
                case 6: {
                    n = 2131231002;
                    break;
                }
                case 5: {
                    n = 2131230997;
                    break;
                }
                case 2: {
                    n = 2131230999;
                    break;
                }
                case 3: {
                    n = 2131231000;
                    break;
                }
            }
            this.g = g;
            this.e.a(this.i().getString(2131230996, new Object[] { this.a(n) }));
        }
    }
    
    private void d(final int n) {
        DialogFragment dialogFragment = null;
        switch (n) {
            case 2: {
                dialogFragment = DialogFactory.a(2131230796, 2131230926, (DialogInterface$OnClickListener)new pm(this));
                break;
            }
            case 3: {
                dialogFragment = DialogFactory.a(2131230797, 2131230922, (DialogInterface$OnClickListener)new pn(this));
                break;
            }
        }
        this.c.post((Runnable)new po(this, dialogFragment));
    }
    
    @Override
    public final int I() {
        return 3;
    }
    
    @Override
    public final void J() {
        this.b((Context)super.C);
    }
    
    @Override
    public final void K() {
    }
    
    @Override
    public final void L() {
        if (this.l()) {
            super.a((Context)super.C);
            this.b();
        }
    }
    
    @Override
    public final View a(final LayoutInflater layoutInflater, final Bundle bundle) {
        final View inflate = layoutInflater.inflate(2130903064, (ViewGroup)null);
        this.d = (ListView)inflate.findViewById(2131623939);
        this.e.a(inflate, this);
        this.e.a(1);
        this.e.a(this.a);
        this.f = null;
        this.c(6);
        this.d.setOnItemClickListener(this.b);
        this.d.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)this);
        return inflate;
    }
    
    @Override
    public final void a(final ae ae) {
    }
    
    @Override
    public final void a(final Activity activity) {
        super.a(activity);
    }
    
    @Override
    public final void a(final Bundle bundle) {
        super.a(bundle);
        this.p();
    }
    
    @Override
    public final void a(final rc rc) {
        final int g = rc.g;
        rc.f = this.a(2131230777);
        if (g == 2) {
            rc.b(2131624132, 2130837596, 2131230824);
            rc.a(2131624157, 2130837597, 2131230737);
            rc.a(2131624132, 2130837596, 2131230824);
        }
        else if (g == 1) {
            rc.b(2131624132, 2130837596, 2131230824);
            rc.c(2131624157, 2130837597, 2131230737);
        }
        else if (g == 3) {
            rc.b(2131624132, 2130837596, 2131230824);
            rc.c(2131624157, 2130837597, 2131230737);
        }
        this.O();
    }
    
    public final void a(final boolean b) {
        rh.a(this, new pp(this)).a(this, super.B, (View)this.aq.e().f[0], b);
    }
    
    public final boolean a(final int n, final String s) {
        switch (n) {
            default: {
                return false;
            }
            case 2131624157: {
                this.a(false);
                return true;
            }
            case 2131624132: {
                this.d(2);
                return true;
            }
        }
    }
    
    @Override
    public final ae a_(final Bundle bundle) {
        return new pq((Context)super.C, bundle.getInt("SORT"));
    }
    
    public final void b(final int n) {
        this.c(n);
        this.b();
    }
    
    @Override
    public final void b(final rc rc) {
        for (final rf rf : rc.b(2131624157)) {
            final FragmentActivity c = super.C;
            rf.a(gw.a(this.g));
        }
    }
    
    @Override
    public final boolean b(final MenuItem menuItem) {
        Label_0078: {
            try {
                this.h = ContentUris.withAppendedId(kf.a, ((AdapterView$AdapterContextMenuInfo)menuItem.getMenuInfo()).id);
                switch (menuItem.getItemId()) {
                    default: {
                        return super.b(menuItem);
                    }
                    case 2131624169: {
                        break;
                    }
                    case 2131624186: {
                        break Label_0078;
                    }
                }
            }
            catch (ClassCastException ex) {
                ColorNote.a("bad menuInfo");
                return false;
            }
            this.d(3);
            return true;
        }
        kg.a((Context)super.C, this.h);
        return true;
    }
    
    @Override
    public void onCreateContextMenu(final ContextMenu contextMenu, final View view, final ContextMenu$ContextMenuInfo contextMenu$ContextMenuInfo) {
        Cursor cursor;
        try {
            cursor = (Cursor)((AdapterView)view).getAdapter().getItem(((AdapterView$AdapterContextMenuInfo)contextMenu$ContextMenuInfo).position);
            if (cursor == null) {
                return;
            }
        }
        catch (ClassCastException ex) {
            ColorNote.a("bad menuInfo");
            return;
        }
        final kh i = new kh(cursor);
        this.i = i;
        contextMenu.setHeaderTitle((CharSequence)i.g);
        super.C.getMenuInflater().inflate(2131558410, (Menu)contextMenu);
    }
    
    @Override
    public final void v() {
        super.v();
        this.b((Context)super.C);
        if (this.aq.a(this)) {
            this.b();
        }
    }
}
