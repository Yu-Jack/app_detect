// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import java.util.Iterator;
import com.socialnmobile.colornote.activity.SyncLogIn;
import com.socialnmobile.colornote.activity.Main;
import android.content.Intent;
import com.socialnmobile.colornote.activity.Settings;
import com.socialnmobile.colornote.ColorNote;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.socialnmobile.colornote.data.NoteProvider;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.net.Uri;
import android.view.View;
import android.content.Context;
import com.socialnmobile.colornote.view.ScreenGridList;

public class NotesFragment extends NoteListFragment implements km
{
    String a;
    ScreenGridList b;
    public int c;
    
    private void b() {
        if (super.ap.g == 2 || super.ap.g == 3) {
            rf rf = super.ap.a(2131624155);
            if (rf == null) {
                rf = super.ap.a(2131624157);
            }
            rf.a = 2131624155;
            rf.b = 2130837613;
            rf.c = 2131230781;
        }
        this.aq.a(super.ap);
    }
    
    private void b(final Context context) {
        final String h = jp.h(context);
        if (this.a != null && this.a.equals(h)) {
            return;
        }
        this.a = h;
        final View r = super.R;
        gr.a(context);
        this.Z.b();
        this.b.b();
    }
    
    @Override
    public final int I() {
        return 1;
    }
    
    @Override
    public final void J() {
        this.b((Context)super.C);
    }
    
    @Override
    public final void K() {
        if (this.l()) {
            this.b.b(false);
        }
    }
    
    @Override
    public final void L() {
        if (this.l()) {
            super.a((Context)super.C);
            this.b();
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
        return kf.a;
    }
    
    @Override
    public final ScreenGridList P() {
        return this.b;
    }
    
    @Override
    public final void Q() {
    }
    
    @Override
    public final String R() {
        return "LIST";
    }
    
    @Override
    public final View a(final LayoutInflater layoutInflater, final Bundle bundle) {
        final View inflate = layoutInflater.inflate(2130903063, (ViewGroup)null);
        this.b = (ScreenGridList)inflate.findViewById(2131624043);
        this.a(inflate);
        final ScreenGridList b = this.b;
        b.a(this, false, this.aa);
        b.setListener(this.ai);
        final FragmentActivity c = super.C;
        int n = Integer.valueOf(jp.a((Context)c, "pref_default_sort_option", ((Context)c).getString(2131230722)));
        if (n == 0) {
            n = jp.a((Context)super.C, "LAST_SAVED_SORT_ORDER", 1);
        }
        b.setGridListViewOptions(n, 0, -1, 0, 0, jp.a((Context)super.C, "LIST_VIEW_TYPE", 1), false, true);
        b.setMainTitle();
        this.b.a((View$OnClickListener)new pi(this));
        this.a = null;
        if (NoteProvider.a((Context)super.C) != null) {
            NoteProvider.a((Context)super.C).a(this);
        }
        return inflate;
    }
    
    @Override
    public final void a() {
        this.b.a(false);
    }
    
    public final void a(final int n, final boolean b) {
        switch (n) {
            default: {
                super.a(n, b);
            }
            case 2: {
                rh.a((Context)super.C, this.d("MENU")).a(this, super.B, (View)this.aq.e().f[0], b);
            }
        }
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
    public final void a(final String s) {
        ColorNote.a((Context)super.C, "LIST", "SORT_CHANGED", "Option", new StringBuilder().append(this.aa.b).toString(), "FROM", s);
    }
    
    @Override
    public final void a(final rc rc) {
        final int g = rc.g;
        rc.f = this.a(2131230728);
        if (g == 2) {
            rc.b(2131624182, 2130837587, 2131230806);
            rc.b(2131624155, 2130837613, 2131230781);
            rc.a(2131624092, 2130837592, 2131230803);
            rc.a(2131624180, 2130837616, 2131230737);
            rc.a(2131624181, 2130837625, 2131230804);
            rc.a(2131624182, 2130837587, 2131230806);
            rc.a(2131624183, 2130837612, 2131230734);
            rc.a(2131624184, 2130837609, 2131230735);
            rc.a(2131624185, 2130837608, 2131230933);
        }
        else {
            if (g == 1) {
                rc.b(2131624182, 2130837587, 2131230806);
                rc.c(2131624092, 2130837592, 2131230803);
                rc.c(2131624180, 2130837616, 2131230737);
                rc.c(2131624181, 2130837625, 2131230804);
                rc.c(2131624155, 2130837613, 2131230781);
                rc.c(2131624183, 2130837612, 2131230734);
                rc.c(2131624184, 2130837609, 2131230735);
                rc.c(2131624185, 2130837608, 2131230933);
                return;
            }
            if (g == 3) {
                rc.b(2131624182, 2130837587, 2131230806);
                rc.b(2131624155, 2130837613, 2131230781);
                rc.c(2131624092, 2130837592, 2131230803);
                rc.c(2131624180, 2130837616, 2131230737);
                rc.c(2131624181, 2130837625, 2131230804);
                rc.c(2131624155, 2130837613, 2131230781);
                rc.c(2131624183, 2130837612, 2131230734);
                rc.c(2131624184, 2130837609, 2131230735);
                rc.c(2131624185, 2130837608, 2131230933);
            }
        }
    }
    
    public final boolean a(final int n, final String s) {
        switch (n) {
            default: {
                return false;
            }
            case 2131624155: {
                super.C.onSearchRequested();
                return true;
            }
            case 2131624157: {
                this.b.d();
                this.b();
                return true;
            }
            case 2131624180: {
                this.a(2001, false);
                return true;
            }
            case 2131624181: {
                this.a(2, false);
                return true;
            }
            case 2131624092: {
                this.e(1020);
                return true;
            }
            case 2131624182: {
                this.a(2005, false);
                return true;
            }
            case 2131624185: {
                this.a(new Intent((Context)super.C, (Class)Settings.class));
                return true;
            }
            case 2131624184: {
                if (rt.a((Context)super.C)) {
                    ((Main)super.C).a(true, true, "MENU");
                }
                else {
                    this.a(new Intent((Context)super.C, (Class)SyncLogIn.class));
                }
                return true;
            }
            case 2131624183: {
                this.a(new Intent((Context)super.C, (Class)SyncLogIn.class));
                return true;
            }
        }
    }
    
    @Override
    public final void b(final int i) {
        this.b.c(i);
        ColorNote.a((Context)super.C, "LIST", "COLOR_FILTER", "COLOR", new StringBuilder().append(i).toString(), "FROM", "LIST");
    }
    
    @Override
    public final void b(final String s) {
        ColorNote.a((Context)super.C, "LIST", "VIEW_CHANGED", "ViewType", new StringBuilder().append(this.aa.d).toString(), "FROM", s);
    }
    
    @Override
    public final void b(final rc rc) {
        for (final rf rf : rc.b(2131624181)) {
            switch (this.aa.d) {
                case 1: {
                    rf.a(2130837625);
                    break;
                }
                case 3: {
                    rf.a(2130837622);
                    break;
                }
                case 2: {
                    rf.a(2130837623);
                    break;
                }
                case 4: {
                    rf.a(2130837624);
                    break;
                }
            }
            rf.i = true;
        }
        for (final rf rf2 : rc.b(2131624180)) {
            final FragmentActivity c = super.C;
            rf2.a(gw.a(this.aa.b));
            rf2.i = true;
        }
        final Iterator<rf> iterator3 = rc.b(2131624092).iterator();
        while (iterator3.hasNext()) {
            iterator3.next().a(gw.a((Context)super.C, this.aa.c));
        }
        final boolean a = rt.a((Context)super.C);
        final Iterator<rf> iterator4 = rc.b(2131624184).iterator();
        while (iterator4.hasNext()) {
            iterator4.next().h = a;
        }
        final Iterator<rf> iterator5 = (Iterator<rf>)rc.b(2131624183).iterator();
        while (iterator5.hasNext()) {
            iterator5.next().h = !a;
        }
    }
    
    @Override
    public final void c(final int n) {
        this.e(1021);
    }
    
    @Override
    public final void c(final Bundle bundle) {
        super.c(bundle);
    }
    
    @Override
    public final void d(final Bundle bundle) {
        super.d(bundle);
    }
    
    @Override
    public final void e() {
        super.e();
    }
    
    final void e(final int n) {
        this.i.post((Runnable)new pj(this, this.d(n)));
    }
    
    @Override
    public final void v() {
        int i = 0;
        super.v();
        if (this.aq.a(this)) {
            this.b();
        }
        this.b((Context)super.C);
        this.b.b(false);
        int n;
        if (jo.a((Context)super.C, "ADD_NEW_CLICKED") != 0) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n == 0) {
            final abi e = this.aq.e();
            while (true) {
                while (i < 3) {
                    if (e.g[i] == 2131624182) {
                        final Object o = e.f[i];
                        if (o != null && kg.a((Context)super.C) == 0) {
                            this.c = 5;
                            this.i.post((Runnable)new ph(this, (View)o));
                        }
                        return;
                    }
                    else {
                        ++i;
                    }
                }
                final Object o = null;
                continue;
            }
        }
    }
    
    @Override
    public final void w() {
        super.w();
    }
    
    @Override
    public final void x() {
        super.x();
        if (NoteProvider.a((Context)super.C) != null) {
            NoteProvider.a((Context)super.C).b(this);
        }
    }
}
