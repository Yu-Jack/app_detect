// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.NoteProvider;
import android.support.v4.app.Fragment;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import android.support.v4.app.FragmentActivity;
import java.util.Iterator;
import com.socialnmobile.colornote.ColorNote;
import android.app.Activity;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.SpinnerAdapter;
import android.widget.ArrayAdapter;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.net.Uri;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import com.socialnmobile.colornote.view.ScreenGridList;

public class ArchiveFragment extends NoteListFragment
{
    boolean a;
    long b;
    int c;
    public ScreenGridList d;
    Spinner e;
    Spinner f;
    View g;
    String h;
    
    public ArchiveFragment() {
        this.a = false;
        this.b = 0L;
        this.c = 16;
    }
    
    private void S() {
        int n = 0;
        switch (this.aa.e) {
            default: {
                n = 0;
                break;
            }
            case -1: {
                n = 2130837588;
                break;
            }
            case 0: {
                n = 2130837593;
                break;
            }
            case 16: {
                n = 2130837604;
                break;
            }
        }
        final rf a = super.ap.a(2131624156);
        if (a != null) {
            a.a(n);
        }
        final rf a2 = super.ap.a(2131624157);
        if (a2 != null) {
            final int b = this.aa.b;
            int n2 = 0;
            switch (b) {
                case 5: {
                    n2 = 2130837594;
                    break;
                }
                case 1: {
                    n2 = 2130837597;
                    break;
                }
                case 4: {
                    n2 = 2130837610;
                    break;
                }
                case 3: {
                    n2 = 2130837592;
                    break;
                }
                case 2: {
                    n2 = 2130837616;
                    break;
                }
                case 7: {
                    n2 = 2130837605;
                    break;
                }
            }
            a2.a(n2);
        }
    }
    
    private void T() {
        this.S();
        this.aq.a(super.ap);
    }
    
    public static ArchiveFragment a(final long n) {
        final ArchiveFragment archiveFragment = new ArchiveFragment();
        final Bundle bundle = new Bundle();
        bundle.putLong("archive_time", n);
        archiveFragment.e(bundle);
        return archiveFragment;
    }
    
    public static ArchiveFragment b() {
        final ArchiveFragment archiveFragment = new ArchiveFragment();
        final Bundle bundle = new Bundle();
        bundle.putInt("archive_mode", 1);
        archiveFragment.e(bundle);
        return archiveFragment;
    }
    
    private void b(final Context context) {
        final String h = jp.h(context);
        if (this.h != null && this.h.equals(h)) {
            return;
        }
        this.h = h;
        this.g.setBackgroundColor(gr.a(context).n(5));
        this.Z.b();
        this.d.b();
    }
    
    @Override
    public final int I() {
        return 4;
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
            this.T();
        }
    }
    
    @Override
    public final boolean M() {
        return this.aa.c != 0;
    }
    
    @Override
    public final boolean N() {
        this.b(0);
        return true;
    }
    
    @Override
    public final Uri O() {
        if (this.a) {
            return kf.d;
        }
        return kf.a;
    }
    
    @Override
    public final ScreenGridList P() {
        return this.d;
    }
    
    @Override
    public final void Q() {
        this.T();
    }
    
    @Override
    public final String R() {
        return "ARCHIVE";
    }
    
    @Override
    public final View a(final LayoutInflater layoutInflater, final Bundle bundle) {
        View view;
        if (this.Y() == 0) {
            view = layoutInflater.inflate(2130903059, (ViewGroup)null);
        }
        else {
            view = layoutInflater.inflate(2130903060, (ViewGroup)null);
        }
        this.g = view.findViewById(2131623959);
        this.d = (ScreenGridList)view.findViewById(2131624043);
        this.e = (Spinner)view.findViewById(2131624041);
        this.f = (Spinner)view.findViewById(2131624042);
        this.a(view);
        this.aa = new pg();
        this.d.a(this, this.a, this.aa);
        this.d.setShowSpace(false);
        this.d.setListener(this.ai);
        final boolean a = this.a;
        this.d.setGridListViewOptions(1, 0, -1, 0, this.c, 1, false, true);
        final ArrayAdapter adapter = new ArrayAdapter((Context)super.C, 17367048, (Object[])this.i().getStringArray(2131099659));
        adapter.setDropDownViewResource(17367049);
        this.e.setAdapter((SpinnerAdapter)adapter);
        this.e.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)new mx(this));
        this.e.setSelection(1);
        final ArrayAdapter adapter2 = new ArrayAdapter((Context)super.C, 17367048, (Object[])this.i().getStringArray(2131099660));
        adapter2.setDropDownViewResource(17367049);
        this.f.setAdapter((SpinnerAdapter)adapter2);
        this.f.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)new my(this));
        if (this.c == 0) {
            this.f.setSelection(1);
        }
        else if (this.c == 16) {
            this.f.setSelection(2);
        }
        else {
            this.f.setSelection(0);
        }
        this.h = null;
        this.d.setMainTitle();
        return view;
    }
    
    @Override
    public final void a(final Activity activity) {
        super.a(activity);
        if (super.q != null) {
            if (super.q.containsKey("archive_mode") && super.q.getInt("archive_mode") == 1) {
                this.X();
                this.c = -1;
            }
            if (super.q.containsKey("archive_time")) {
                this.a = true;
                this.b = super.q.getLong("archive_time");
                this.c = 0;
            }
        }
    }
    
    @Override
    public final void a(final Bundle bundle) {
        super.a(bundle);
        this.p();
    }
    
    @Override
    public final void a(final String s) {
        this.T();
    }
    
    @Override
    public final void a(final rc rc) {
        final int g = rc.g;
        String f;
        if (this.a) {
            f = gs.a((Context)super.C, this.b);
        }
        else {
            f = this.a(2131230779);
        }
        rc.f = f;
        if (g == 2) {
            rc.b(2131624156, 2130837588, 2131230814);
            rc.a(2131624156, 2130837593, 2131230814);
            rc.a(2131624157, 2130837618, 2131230737);
            rc.a(2131624092, 2130837592, 2131230803);
        }
        else if (g == 1) {
            rc.b(2131624156, 2130837588, 2131230814);
            rc.c(2131624157, 2130837618, 2131230737);
            rc.c(2131624092, 2130837592, 2131230803);
        }
        else if (g == 3) {
            rc.b(2131624156, 2130837588, 2131230814);
            rc.c(2131624157, 2130837618, 2131230737);
            rc.c(2131624092, 2130837592, 2131230803);
        }
        this.S();
    }
    
    public final boolean a(final int n, final String s) {
        switch (n) {
            default: {
                return false;
            }
            case 2131624092: {
                this.e(1020);
                return true;
            }
            case 2131624157: {
                this.a(2001, false);
                return true;
            }
            case 2131624156: {
                this.a(2004, false);
                return true;
            }
        }
    }
    
    @Override
    public final void b(final int i) {
        this.d.c(i);
        ColorNote.a((Context)super.C, "LIST", "COLOR_FILTER", "COLOR", new StringBuilder().append(i).toString(), "FROM", "ARCHIVE");
    }
    
    @Override
    public final void b(final String s) {
    }
    
    @Override
    public final void b(final rc rc) {
        final Iterator<rf> iterator = (Iterator<rf>)rc.b(2131624092).iterator();
        while (iterator.hasNext()) {
            iterator.next().a(gw.a((Context)super.C, this.aa.c));
        }
        for (final rf rf : rc.b(2131624157)) {
            final FragmentActivity c = super.C;
            rf.a(gw.a(this.aa.b));
        }
        for (final rf rf2 : rc.b(2131624156)) {
            final FragmentActivity c2 = super.C;
            rf2.a(gw.b(this.aa.e));
        }
    }
    
    @Override
    public final void c(final int n) {
        this.a(2001, true);
    }
    
    @Override
    public void onCreateContextMenu(final ContextMenu contextMenu, final View view, final ContextMenu$ContextMenuInfo contextMenu$ContextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenu$ContextMenuInfo);
        if (this.a) {
            contextMenu.clear();
            contextMenu.add(0, 1015, 0, 2131230736).setOnMenuItemClickListener(this.ah);
        }
    }
    
    @Override
    public final void v() {
        super.v();
        this.b((Context)super.C);
        if (this.aq.a(this)) {
            this.T();
        }
    }
    
    @Override
    public final void x() {
        if (this.a) {
            final kt a = kt.a((Context)super.C);
            if (a.c != null) {
                NoteProvider.c(a.b());
                a.d = null;
                a.c.close();
                a.c = null;
                a.a();
            }
        }
        super.x();
    }
}
