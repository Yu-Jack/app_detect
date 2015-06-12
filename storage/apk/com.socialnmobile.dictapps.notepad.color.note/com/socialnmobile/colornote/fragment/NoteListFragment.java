// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.ColorNote;
import android.database.Cursor;
import android.widget.AdapterView;
import android.widget.AdapterView$AdapterContextMenuInfo;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import android.content.res.Configuration;
import com.socialnmobile.colornote.dialog.DialogFactory$TextInputDialogFragment;
import android.content.DialogInterface$OnClickListener;
import com.socialnmobile.colornote.dialog.DialogFactory;
import com.socialnmobile.colornote.dialog.DialogFactory$ColorListSelectionDialogFragment;
import com.socialnmobile.colornote.dialog.DialogFactory$NotesOptionsDialogFragment;
import android.support.v4.app.DialogFragment;
import android.content.ContentUris;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.support.v4.app.Fragment;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo;
import android.support.v4.app.FragmentActivity;
import com.socialnmobile.colornote.activity.Main;
import android.content.Intent;
import com.socialnmobile.colornote.view.ScreenGridList;
import android.content.Context;
import android.widget.Toast;
import android.os.Handler;
import android.view.View$OnClickListener;
import android.widget.AdapterView$OnItemClickListener;
import android.view.MenuItem$OnMenuItemClickListener;
import android.text.format.Time;
import android.net.Uri;
import java.util.HashMap;

public abstract class NoteListFragment extends ScreenFragment
{
    public pf Y;
    abh Z;
    private HashMap a;
    protected pg aa;
    public kh ab;
    public Uri ac;
    public int ad;
    public int ae;
    protected Time af;
    public int ag;
    MenuItem$OnMenuItemClickListener ah;
    AdapterView$OnItemClickListener ai;
    lh aj;
    lh ak;
    lh al;
    lh am;
    lh an;
    View$OnClickListener ao;
    public Handler i;
    
    public NoteListFragment() {
        this.a = new HashMap();
        this.i = new Handler();
        this.Z = new abh();
        this.aa = new pg();
        this.ah = (MenuItem$OnMenuItemClickListener)new ok(this);
        this.ai = (AdapterView$OnItemClickListener)new ov(this);
        this.aj = new oy(this);
        this.ak = new oz(this);
        this.al = new pa(this);
        this.am = new pb(this);
        this.an = new pc(this);
        this.ao = (View$OnClickListener)new pd(this);
    }
    
    private void a(final RuntimeException ex, final String s) {
        Toast.makeText((Context)super.C, 2131230845, 1).show();
        adl.a.a((Context)super.C, ex, s);
    }
    
    public abstract Uri O();
    
    public abstract ScreenGridList P();
    
    public abstract void Q();
    
    public abstract String R();
    
    public final pg W() {
        return this.aa;
    }
    
    protected final void X() {
        this.ag = 1;
    }
    
    public final int Y() {
        return this.ag;
    }
    
    public final void Z() {
        kg.b((Context)super.C, this.ac);
        Toast.makeText((Context)super.C, 2131230835, 0).show();
    }
    
    public final void a(final int ae, final int ad) {
        this.ae = ae;
        this.ad = ad;
        this.e(1015);
    }
    
    @Override
    public final void a(final int n, final int n2, final Intent intent) {
        super.a(n, n2, intent);
        if (n == 1001 && n2 == -1) {
            this.e(1013);
        }
        else if (n == 2000 && n2 == 5000 && super.C != null && super.C instanceof Main) {
            final Main main = (Main)super.C;
            final FragmentActivity c = super.C;
            main.k();
        }
    }
    
    void a(final int n, final boolean b) {
        TopBarSubMenuInfo topBarSubMenuInfo = null;
        switch (n) {
            default: {
                topBarSubMenuInfo = null;
                break;
            }
            case 2005: {
                topBarSubMenuInfo = rh.a((Context)super.C, new ot(this), null);
                break;
            }
            case 2001: {
                topBarSubMenuInfo = rh.a(this, this.c("MENU"));
                break;
            }
            case 2004: {
                final FragmentActivity c = super.C;
                topBarSubMenuInfo = new TopBarSubMenuInfo((Context)c, ((Context)c).getString(2131230814), new ou(this));
                topBarSubMenuInfo.a(-1, 2130837588, 2131230767);
                topBarSubMenuInfo.a(0, 2130837593, 2131230774);
                topBarSubMenuInfo.a(16, 2130837604, 2131230775);
                break;
            }
        }
        if (b || this.aq.e() == null) {
            topBarSubMenuInfo.a(this, super.B, null, true);
            return;
        }
        topBarSubMenuInfo.a(this, super.B, (View)this.aq.e().f[0], false);
    }
    
    @Override
    public void a(final Activity activity) {
        super.a(activity);
        final String action = activity.getIntent().getAction();
        if ("android.intent.action.PICK".equals(action) || "android.intent.action.GET_CONTENT".equals(action)) {
            this.ag = 1;
            return;
        }
        this.ag = 0;
    }
    
    @Override
    public void a(final Bundle bundle) {
        super.a(bundle);
    }
    
    protected final void a(final View view) {
        this.Z.a(view, this);
        this.Z.a(this.ao);
    }
    
    public abstract void a(final String p0);
    
    public final void a(final pf y) {
        this.Y = y;
    }
    
    public final void aa() {
        kg.c((Context)super.C, this.ac);
        Toast.makeText((Context)super.C, 2131230836, 0).show();
    }
    
    public final HashMap ac() {
        if (this.a.size() == 0) {
            final String[] stringArray = this.i().getStringArray(2131099652);
            final String[] stringArray2 = this.i().getStringArray(2131099651);
            for (int i = 0; i < stringArray2.length; ++i) {
                this.a.put(Integer.valueOf(stringArray2[i]), stringArray[i]);
            }
            this.a.put(7, this.a(2131231003));
        }
        return this.a;
    }
    
    public final abh ad() {
        return this.Z;
    }
    
    public abstract void b(final int p0);
    
    public final void b(final long n) {
        final Intent intent = new Intent("android.intent.action.VIEW", ContentUris.withAppendedId(this.O(), n));
        intent.putExtra("EXTRA_VIEW_FROM", this.R());
        try {
            this.a(intent, 2000);
        }
        catch (NullPointerException ex2) {
            try {
                if (super.C != null) {
                    super.C.startActivityForResult(intent, 2000);
                    return;
                }
            }
            catch (NullPointerException ex) {
                this.a(ex, "UI:View:Level 2");
                return;
            }
            this.a(ex2, "UI:View:Level 1");
        }
    }
    
    public abstract void b(final String p0);
    
    public final void b(final pf pf) {
        if (this.Y == pf) {
            this.Y = null;
        }
    }
    
    public final rg c(final String s) {
        return new ow(this, s);
    }
    
    @Override
    public final void c() {
        super.c();
        if (this.aa.a != null && !this.aa.a.isClosed()) {
            this.aa.a.requery();
        }
    }
    
    public abstract void c(final int p0);
    
    DialogFragment d(final int n) {
        DialogFragment dialogFragment = null;
        switch (n) {
            case 1021: {
                dialogFragment = new DialogFactory$NotesOptionsDialogFragment(this);
                break;
            }
            case 1020: {
                dialogFragment = new DialogFactory$ColorListSelectionDialogFragment(this);
                break;
            }
            case 1016: {
                dialogFragment = DialogFactory.a(2131230821, 2131230927, (DialogInterface$OnClickListener)new pe(this));
                break;
            }
            case 1017: {
                dialogFragment = DialogFactory.a(2131230821, 2131230928, (DialogInterface$OnClickListener)new ol(this));
                break;
            }
            case 1004: {
                dialogFragment = DialogFactory.a(2131230796, 2131230913, (DialogInterface$OnClickListener)new om(this));
                break;
            }
            case 1005: {
                dialogFragment = DialogFactory.a(2131230796, 2131230913, (DialogInterface$OnClickListener)new on(this));
                break;
            }
            case 1006: {
                dialogFragment = DialogFactory.a(this.al);
                break;
            }
            case 1011: {
                dialogFragment = DialogFactory.a(this.am);
                break;
            }
            case 1012: {
                dialogFragment = DialogFactory.a(this.an);
                break;
            }
            case 1009: {
                dialogFragment = DialogFactory.b(2131230809, 2131230916, (DialogInterface$OnClickListener)new oo(this));
                break;
            }
            case 1010: {
                dialogFragment = DialogFactory.b(2131230811, 2131230915, (DialogInterface$OnClickListener)new op(this));
                break;
            }
            case 1013: {
                dialogFragment = DialogFactory.a(this.aj);
                break;
            }
            case 1014: {
                dialogFragment = DialogFactory.a(this.ak);
                break;
            }
            case 1015: {
                dialogFragment = new DialogFactory$TextInputDialogFragment((Context)super.C, new oq(this));
                break;
            }
            case 1018: {
                dialogFragment = DialogFactory.a(2131230807, 2131230932, (DialogInterface$OnClickListener)new or(this));
                break;
            }
        }
        switch (n) {
            default: {
                return dialogFragment;
            }
            case 1015: {
                ((DialogFactory$TextInputDialogFragment)dialogFragment).a(jq.a((Context)super.C, this.ae, this.ad));
                return dialogFragment;
            }
        }
    }
    
    public final rg d(final String s) {
        return new ox(this, s);
    }
    
    @Override
    public final void d() {
        super.d();
    }
    
    public void e(final int n) {
        this.i.post((Runnable)new os(this, this.d(n)));
    }
    
    public final void f(final int n) {
        jo.a((Context)super.C, "ADD_NEW_CLICKED", 1);
        final Intent intent = new Intent("android.intent.action.INSERT", this.O());
        intent.putExtra("socialnmobile.intent.extra.TYPE", n);
        intent.putExtra("socialnmobile.intent.extra.FOLDER", 0);
        if (this.aa.c != 0) {
            intent.putExtra("socialnmobile.intent.extra.COLOR", this.aa.c);
        }
        this.a(intent);
    }
    
    public final void g(final int n) {
        jo.a((Context)super.C, "ADD_NEW_CLICKED", 1);
        final Intent intent = new Intent("android.intent.action.INSERT", this.O());
        intent.putExtra("socialnmobile.intent.extra.TYPE", n);
        intent.putExtra("socialnmobile.intent.extra.FOLDER", 16);
        intent.putExtra("socialnmobile.intent.extra.REMINDER_TYPE", 16);
        intent.putExtra("socialnmobile.intent.extra.REMINDER_DATE", jk.a(this.af, true));
        if (this.aa.c != 0) {
            intent.putExtra("socialnmobile.intent.extra.COLOR", this.aa.c);
        }
        this.a(intent);
    }
    
    @Override
    public void onConfigurationChanged(final Configuration configuration) {
        if (this.P() != null) {
            this.P().a();
        }
    }
    
    @Override
    public void onCreateContextMenu(final ContextMenu contextMenu, final View view, final ContextMenu$ContextMenuInfo contextMenu$ContextMenuInfo) {
        if (this.ag != 1) {
            AdapterView$AdapterContextMenuInfo adapterView$AdapterContextMenuInfo;
            Object item;
            kh ab = null;
            Label_0123_Outer:Label_0155_Outer:Label_0205_Outer:
            while (true) {
                while (true) {
                    Label_0432: {
                        Label_0370: {
                        Label_0343:
                            while (true) {
                            Label_0318:
                                while (true) {
                                Label_0291:
                                    while (true) {
                                        try {
                                            adapterView$AdapterContextMenuInfo = (AdapterView$AdapterContextMenuInfo)contextMenu$ContextMenuInfo;
                                            if (((AdapterView)view).getAdapter() == null) {
                                                return;
                                            }
                                            item = ((AdapterView)view).getAdapter().getItem(adapterView$AdapterContextMenuInfo.position);
                                            if (item == null) {
                                                return;
                                            }
                                            if (item instanceof Cursor) {
                                                ab = new kh((Cursor)item);
                                                this.ab = ab;
                                                contextMenu.setHeaderTitle((CharSequence)ab.g);
                                                if (ab.e != 16) {
                                                    break Label_0291;
                                                }
                                                contextMenu.add(0, 1014, 0, 2131230822).setOnMenuItemClickListener(this.ah);
                                                if (!ab.e()) {
                                                    break Label_0318;
                                                }
                                                contextMenu.add(0, 1002, 0, 2131230796).setOnMenuItemClickListener(this.ah);
                                                if (ab.f != 16) {
                                                    break Label_0432;
                                                }
                                                if (!ab.a()) {
                                                    break Label_0370;
                                                }
                                                if (!ab.e()) {
                                                    break Label_0343;
                                                }
                                                contextMenu.add(0, 1009, 0, 2131230811).setOnMenuItemClickListener(this.ah);
                                                if (ab.e != 16) {
                                                    contextMenu.add(0, 1012, 0, 2131230807).setOnMenuItemClickListener(this.ah);
                                                }
                                                if (ab.e()) {
                                                    contextMenu.add(0, 1011, 0, 2131230816).setOnMenuItemClickListener(this.ah);
                                                    return;
                                                }
                                                break;
                                            }
                                        }
                                        catch (ClassCastException ex) {
                                            ColorNote.a("bad menuInfo");
                                            return;
                                        }
                                        ab = (kh)item;
                                        continue Label_0123_Outer;
                                    }
                                    contextMenu.add(0, 1013, 0, 2131230821).setOnMenuItemClickListener(this.ah);
                                    continue Label_0155_Outer;
                                }
                                contextMenu.add(0, 1, 0, 2131230796).setOnMenuItemClickListener(this.ah);
                                continue Label_0205_Outer;
                            }
                            contextMenu.add(0, 1007, 0, 2131230811).setOnMenuItemClickListener(this.ah);
                            continue;
                        }
                        if (ab.e()) {
                            contextMenu.add(0, 1008, 0, 2131230809).setOnMenuItemClickListener(this.ah);
                            continue;
                        }
                        contextMenu.add(0, 1006, 0, 2131230809).setOnMenuItemClickListener(this.ah);
                        continue;
                    }
                    if (ab.a()) {
                        contextMenu.add(0, 1005, 0, 2131230810).setOnMenuItemClickListener(this.ah);
                        continue;
                    }
                    contextMenu.add(0, 1004, 0, 2131230808).setOnMenuItemClickListener(this.ah);
                    continue;
                }
            }
            contextMenu.add(0, 1010, 0, 2131230815).setOnMenuItemClickListener(this.ah);
        }
    }
}
