// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.dialog.DialogFactory$DatePickerDialogFragment;
import android.support.v4.app.DialogFragment;
import java.util.Iterator;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.activity.SyncLogIn;
import com.socialnmobile.colornote.activity.Main;
import android.content.Intent;
import com.socialnmobile.colornote.activity.Settings;
import android.widget.Toast;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import com.socialnmobile.colornote.data.NoteProvider;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.socialnmobile.colornote.view.ScreenGridList;
import android.net.Uri;
import android.view.View;
import android.content.Context;
import android.app.DatePickerDialog$OnDateSetListener;
import com.socialnmobile.colornote.dialog.DialogFactory$MonthDayDialogFragment;
import android.text.format.Time;
import com.socialnmobile.colornote.view.ScreenCalendar;

public class CalendarFragment extends NoteListFragment implements aay, km
{
    private static final Object g;
    String a;
    ScreenCalendar b;
    public Time c;
    boolean d;
    DialogFactory$MonthDayDialogFragment e;
    DatePickerDialog$OnDateSetListener f;
    
    static {
        g = new Object();
    }
    
    public CalendarFragment() {
        this.f = (DatePickerDialog$OnDateSetListener)new mz(this);
    }
    
    private void af() {
        this.aq.a(super.ap);
    }
    
    private void ag() {
        if (!this.b.b() || !this.b.f()) {
            this.c = this.b.g();
            this.b.c();
        }
    }
    
    private void ah() {
        final ScreenCalendar b = this.b;
        this.c = b.h();
        b.c();
    }
    
    private void ai() {
        final ScreenCalendar b = this.b;
        this.c = b.i();
        b.c();
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
        this.b.a();
    }
    
    @Override
    public final int I() {
        return 2;
    }
    
    @Override
    public final void J() {
        this.b((Context)super.C);
    }
    
    @Override
    public final void K() {
        if (this.l()) {
            this.ag();
        }
    }
    
    @Override
    public final void L() {
        if (this.l()) {
            super.a((Context)super.C);
            this.af();
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
        return null;
    }
    
    @Override
    public final void Q() {
    }
    
    @Override
    public final String R() {
        return "CALENDAR";
    }
    
    public final ScreenCalendar S() {
        return this.b;
    }
    
    public final void T() {
        this.a(10, true);
    }
    
    public final void U() {
        final int month = this.af.month;
        final Time af = this.af;
        ++af.monthDay;
        jk.a(this.af);
        if (this.af.month != month) {
            this.d = true;
            this.ah();
            return;
        }
        this.e(17);
    }
    
    public final void V() {
        final int month = this.af.month;
        final Time af = this.af;
        --af.monthDay;
        jk.a(this.af);
        if (this.af.month != month) {
            this.d = true;
            this.ai();
            return;
        }
        this.e(17);
    }
    
    @Override
    public final View a(final LayoutInflater layoutInflater, final Bundle bundle) {
        final View inflate = layoutInflater.inflate(2130903061, (ViewGroup)null);
        this.b = (ScreenCalendar)inflate.findViewById(2131624044);
        this.a(inflate);
        final ScreenCalendar b = this.b;
        b.a(this, this, this.aa);
        this.c = b.e();
        b.setMainTitle();
        this.ag();
        this.ag();
        this.a = null;
        if (NoteProvider.a((Context)super.C) != null) {
            NoteProvider.a((Context)super.C).a(this);
        }
        return inflate;
    }
    
    @Override
    public final void a() {
        this.b.c();
    }
    
    @Override
    final void a(final int n, final boolean b) {
        switch (n) {
            default: {
                super.a(n, b);
            }
            case 10: {
                rh.a((Context)super.C, new na(this), String.valueOf(this.a(2131230806)) + " [" + DateUtils.formatDateTime((Context)super.C, jk.a(this.af, true), 32786) + "]").a(this, super.B, (View)this.aq.e().f[0], b);
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
    public final void a(final Time time) {
        if (jk.a(time, true) < jk.a(this.c, true)) {
            this.ai();
            return;
        }
        this.ah();
    }
    
    @Override
    public final void a(final String s) {
    }
    
    @Override
    public final void a(final rc rc) {
        final int g = rc.g;
        rc.f = this.a(2131230786);
        if (g == 2) {
            rc.b(2131624182, 2130837587, 2131230806);
            rc.b(2131624155, 2130837613, 2131230781);
            rc.a(2131624092, 2130837592, 2131230803);
            rc.a(2131624180, 2130837616, 2131230737);
            rc.a(2131624159, 2130837605, 2131230874);
            rc.a(2131624182, 2130837587, 2131230806);
            rc.a(2131624183, 2130837612, 2131230734);
            rc.a(2131624184, 2130837609, 2131230735);
            rc.a(2131624185, 2130837608, 2131230933);
        }
        else {
            if (g == 1) {
                rc.b(2131624182, 2130837587, 2131230806);
                rc.c(2131624159, 2130837605, 2131230874);
                rc.c(2131624092, 2130837592, 2131230803);
                rc.c(2131624155, 2130837613, 2131230781);
                rc.c(2131624183, 2130837612, 2131230734);
                rc.c(2131624184, 2130837609, 2131230735);
                rc.c(2131624185, 2130837608, 2131230933);
                return;
            }
            if (g == 3) {
                rc.b(2131624182, 2130837587, 2131230806);
                rc.b(2131624155, 2130837613, 2131230781);
                rc.c(2131624159, 2130837605, 2131230874);
                rc.c(2131624092, 2130837592, 2131230803);
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
            case 2131624159: {
                this.ag();
                Toast.makeText((Context)super.C, (CharSequence)(String.valueOf(this.a(2131230874)) + " : " + DateUtils.formatDateTime((Context)super.C, System.currentTimeMillis(), 32786)), 1).show();
                return false;
            }
            case 2131624117: {
                this.e(19);
                return true;
            }
            case 2131624155: {
                super.C.onSearchRequested();
                return true;
            }
            case 2131624092: {
                this.e(1020);
                return true;
            }
            case 2131624182: {
                (this.af = new Time()).set(System.currentTimeMillis());
                this.a(10, false);
                return true;
            }
            case 2131624185: {
                this.a(new Intent((Context)super.C, (Class)Settings.class));
                return true;
            }
            case 2131624184: {
                ((Main)super.C).a(true, true, "MENU");
                return true;
            }
            case 2131624183: {
                this.a(new Intent((Context)super.C, (Class)SyncLogIn.class));
                return true;
            }
        }
    }
    
    @Override
    public final void b() {
        if (this.d) {
            this.d = false;
            if (this.af != null) {
                this.e(17);
            }
        }
        else if (this.e != null && this.af != null && this.e.l()) {
            this.e.a(this.b.a(this.af.monthDay), this.af);
        }
    }
    
    @Override
    public final void b(final int i) {
        this.b.b(i);
        ColorNote.a((Context)super.C, "LIST", "COLOR_FILTER", "COLOR", new StringBuilder().append(i).toString(), "FROM", "CALENDAR");
    }
    
    @Override
    public final void b(final Time af) {
        this.af = af;
        this.e(17);
    }
    
    @Override
    public final void b(final String s) {
    }
    
    @Override
    public final void b(final rc rc) {
        final Iterator<rf> iterator = rc.b(2131624180).iterator();
        while (iterator.hasNext()) {
            iterator.next().i = false;
        }
        final Iterator<rf> iterator2 = rc.b(2131624092).iterator();
        while (iterator2.hasNext()) {
            iterator2.next().a(gw.a((Context)super.C, this.aa.c));
        }
        final boolean a = rt.a((Context)super.C);
        final Iterator<rf> iterator3 = rc.b(2131624184).iterator();
        while (iterator3.hasNext()) {
            iterator3.next().h = a;
        }
        final Iterator<rf> iterator4 = (Iterator<rf>)rc.b(2131624183).iterator();
        while (iterator4.hasNext()) {
            iterator4.next().h = !a;
        }
    }
    
    @Override
    public final void c(final int n) {
        switch (n) {
            default: {}
            case 2131624078: {
                this.ai();
            }
            case 2131624080: {
                this.ah();
            }
            case 2131624079: {
                this.e(19);
            }
        }
    }
    
    @Override
    public final void c(final Bundle bundle) {
        super.c(bundle);
        if (bundle != null && bundle.containsKey("selected_time")) {
            (this.af = new Time()).set(bundle.getLong("selected_time"));
        }
    }
    
    @Override
    final DialogFragment d(final int n) {
        switch (n) {
            default: {
                return super.d(n);
            }
            case 19: {
                return new DialogFactory$DatePickerDialogFragment(this.f, this.c.year, this.c.month);
            }
            case 17: {
                return this.e = new DialogFactory$MonthDayDialogFragment(this, this.b.a(this.af.monthDay), this.af);
            }
        }
    }
    
    @Override
    public final void d(final Bundle bundle) {
        super.d(bundle);
        if (this.af != null) {
            bundle.putLong("selected_time", jk.a(this.af, true));
        }
    }
    
    @Override
    public final void e() {
        super.e();
    }
    
    final void e(final int n) {
        this.i.post((Runnable)new nb(this, this.d(n)));
    }
    
    @Override
    public final void v() {
        super.v();
        if (this.aq.a(this)) {
            this.af();
        }
        this.b((Context)super.C);
        this.b.d();
    }
    
    @Override
    public final void x() {
        super.x();
        if (NoteProvider.a((Context)super.C) != null) {
            NoteProvider.a((Context)super.C).b(this);
        }
    }
}
