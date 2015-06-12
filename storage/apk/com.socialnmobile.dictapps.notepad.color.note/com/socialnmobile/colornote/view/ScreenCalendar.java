// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.text.format.DateUtils;
import android.os.Bundle;
import android.database.Cursor;
import com.socialnmobile.colornote.ColorNote;
import android.text.format.Time;
import android.database.ContentObserver;
import android.view.animation.AnimationUtils;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.view.animation.LayoutAnimationController;
import android.widget.FrameLayout;

public class ScreenCalendar extends FrameLayout implements w
{
    static boolean h;
    private static LayoutAnimationController j;
    public NoteListFragment a;
    abh b;
    public aay c;
    MonthView d;
    ArrayList[] e;
    public pg f;
    Handler g;
    zo i;
    private int k;
    
    static {
        ScreenCalendar.h = true;
    }
    
    public ScreenCalendar(final Context context) {
        this(context, null);
    }
    
    public ScreenCalendar(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ScreenCalendar(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.g = new Handler();
        this.k = 0;
        this.i = new aav(this);
        if (ScreenCalendar.j == null) {
            ScreenCalendar.j = AnimationUtils.loadLayoutAnimation(context, 2130968578);
        }
        this.setAlwaysDrawnWithCacheEnabled(false);
    }
    
    private void j() {
        final ArrayList[] e = this.e;
        for (int length = e.length, i = 0; i < length; ++i) {
            e[i].clear();
        }
    }
    
    private void k() {
        final ArrayList[] e = this.e;
        for (int length = e.length, i = 0; i < length; ++i) {
            gw.b(e[i]);
        }
    }
    
    public final ArrayList a(final int n) {
        return this.e[n];
    }
    
    public final void a() {
        this.setBackgroundColor(gr.a(this.getContext()).n(3));
        this.d.c();
    }
    
    public final void a(final ae ae) {
        this.f.a = null;
    }
    
    public final void a(final Time time) {
        this.c.a(time);
    }
    
    public final void a(final NoteListFragment a, final aay c, final pg f) {
        this.a = a;
        (this.b = a.ad()).a(3);
        this.c = c;
        (this.d = (MonthView)this.findViewById(2131624129)).setOnDayClickListener(this.i);
        this.d.setParent(this);
        this.f = f;
        this.f.f = 16;
        this.e = new ArrayList[32];
        for (int i = 0; i < this.e.length; ++i) {
            this.e[i] = new ArrayList();
        }
        this.d.setMonthNotes(this.e);
    }
    
    public final ae a_(final Bundle bundle) {
        return new aaz(this.getContext(), this);
    }
    
    public final void b(final int c) {
        this.f.c = c;
        this.c();
        this.setMainTitle();
    }
    
    public final boolean b() {
        return this.f.a != null;
    }
    
    public final void c() {
        this.j();
        if (this.a.l()) {
            this.a.q().a(2, null, this);
        }
    }
    
    public final void d() {
        this.d.b();
        this.d.f();
    }
    
    public final Time e() {
        return this.d.e();
    }
    
    public final boolean f() {
        final Time time = new Time();
        time.set(System.currentTimeMillis());
        time.monthDay = 1;
        jk.a(time);
        final Time e = this.d.e();
        return e.year == time.year && e.month == time.month;
    }
    
    public final Time g() {
        final Time time = new Time();
        time.set(System.currentTimeMillis());
        time.monthDay = 1;
        time.hour = 0;
        time.minute = 0;
        time.second = 0;
        jk.a(time);
        this.d.a(time);
        this.setMainTitle();
        return time;
    }
    
    public final Time h() {
        final Time time = new Time();
        time.set(this.d.e());
        ++time.month;
        time.monthDay = 1;
        jk.a(time);
        this.d.a(time);
        this.setMainTitle();
        return time;
    }
    
    public final Time i() {
        final Time time = new Time();
        time.set(this.d.e());
        --time.month;
        time.monthDay = 1;
        jk.a(time);
        this.d.a(time);
        this.setMainTitle();
        return time;
    }
    
    public void setMainTitle() {
        this.b.a();
        this.b.c(this.f.c);
        this.b.a(DateUtils.formatDateTime(this.getContext(), jk.a(this.d.e(), true), 52));
        this.b.e.setText((CharSequence)"\u25b2");
        this.b.g.setText((CharSequence)"\u25bc");
    }
    
    public void setMonth(final Time time) {
        this.d.a(time);
        this.setMainTitle();
    }
    
    public void setTime(final Time time) {
        this.d.a(time);
    }
}
