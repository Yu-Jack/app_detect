// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.view.KeyEvent;
import android.app.Dialog;
import android.content.ContentUris;
import android.widget.AdapterView$OnItemSelectedListener;
import android.os.Bundle;
import android.content.res.Resources;
import android.widget.SpinnerAdapter;
import java.util.List;
import android.widget.ArrayAdapter;
import android.text.format.DateFormat;
import android.widget.Toast;
import android.text.format.DateUtils;
import java.util.Calendar;
import android.content.Context;
import android.app.DatePickerDialog;
import android.widget.Spinner;
import android.widget.Button;
import android.text.format.Time;
import java.util.ArrayList;
import android.content.DialogInterface$OnClickListener;
import android.app.DatePickerDialog$OnDateSetListener;
import android.app.TimePickerDialog$OnTimeSetListener;
import android.view.View$OnClickListener;
import android.net.Uri;
import android.view.View;
import android.app.Activity;

public class ReminderSettings extends Activity
{
    public View A;
    public int B;
    public int C;
    public long D;
    public long E;
    public long F;
    long G;
    long H;
    int I;
    public Uri J;
    public boolean K;
    boolean L;
    View$OnClickListener M;
    public TimePickerDialog$OnTimeSetListener N;
    DatePickerDialog$OnDateSetListener O;
    DatePickerDialog$OnDateSetListener P;
    public DialogInterface$OnClickListener Q;
    public DialogInterface$OnClickListener R;
    private ArrayList S;
    public int a;
    int b;
    public Time c;
    public long d;
    public Time e;
    public long f;
    boolean g;
    boolean h;
    public boolean i;
    public boolean j;
    public ArrayList k;
    public ArrayList l;
    public String[] m;
    public int[] n;
    View o;
    View p;
    View q;
    View r;
    public View s;
    public Button t;
    public Button u;
    public Button v;
    Button w;
    public Spinner x;
    public Spinner y;
    public View z;
    
    public ReminderSettings() {
        this.j = false;
        this.K = true;
        this.L = true;
        this.M = (View$OnClickListener)new id(this);
        this.N = (TimePickerDialog$OnTimeSetListener)new ie(this);
        this.O = (DatePickerDialog$OnDateSetListener)new if(this);
        this.P = (DatePickerDialog$OnDateSetListener)new ig(this);
        this.Q = (DialogInterface$OnClickListener)new ih(this);
        this.R = (DialogInterface$OnClickListener)new ii(this);
    }
    
    private void a(final Calendar calendar) {
        calendar.add(5, 1);
        this.l.add(DateUtils.getDayOfWeekString(calendar.get(7), 10));
        this.k.add(calendar.getTimeInMillis());
    }
    
    private void a(final boolean b) {
        if (this.b(b)) {
            this.K = false;
            this.setResult(-1);
            this.finish();
        }
    }
    
    private void b() {
        if (this.a == 16 && this.d == -1L) {
            this.t.setVisibility(0);
            this.u.setVisibility(8);
            this.q.setVisibility(8);
            this.s.setVisibility(8);
        }
        else {
            if (this.a == 16) {
                this.q.setVisibility(0);
                this.s.setVisibility(0);
                this.u.setVisibility(8);
                this.t.setVisibility(0);
                return;
            }
            if (this.a == 32) {
                this.q.setVisibility(0);
                this.s.setVisibility(0);
                this.u.setVisibility(0);
                this.t.setVisibility(0);
            }
        }
    }
    
    private void b(final long d) {
        this.d = d;
        this.c.set(this.d);
        this.b();
        this.d();
    }
    
    private boolean b(final boolean b) {
        final int selectedItemPosition = this.x.getSelectedItemPosition();
        final int selectedItemPosition2 = this.y.getSelectedItemPosition();
        long d = this.d;
        long f = this.f;
        final ArrayList s = this.S;
        int intValue = 0;
        if (s != null) {
            intValue = this.S.get(selectedItemPosition2);
        }
        final int a = this.a(selectedItemPosition);
        int n = 0;
        int n2 = 0;
        switch (a) {
            default: {
                n = intValue;
                n2 = 0;
                break;
            }
            case 32: {
                int n3;
                if (this.B == a && this.C == intValue && this.F == d && this.G == f) {
                    n3 = 0;
                }
                else {
                    n3 = 1;
                }
                n = intValue;
                n2 = n3;
                break;
            }
            case 16: {
                if (this.d != -1L) {
                    int n4;
                    if (this.B == a && this.C == intValue && this.F == d && this.G == f) {
                        n4 = 0;
                    }
                    else {
                        n4 = 1;
                    }
                    n = intValue;
                    n2 = n4;
                    break;
                }
                n = 144;
                d = 0L;
                f = 0L;
                if (this.B == a && this.C == 144) {
                    n2 = 0;
                    break;
                }
                n2 = 1;
                break;
            }
            case 0: {
                d = 0L;
                f = 0L;
                if (this.B != a) {
                    n2 = 1;
                    n = 0;
                    break;
                }
                n2 = 0;
                n = 0;
                break;
            }
            case 128: {
                d = -1L;
                f = 0L;
                if (this.B != a) {
                    n2 = 1;
                    n = 0;
                    break;
                }
                n2 = 0;
                n = 0;
                break;
            }
        }
        if (n == 0) {
            f = 0L;
        }
        if (n2 == 0 && !this.i) {
            return true;
        }
        final boolean a2 = kg.a((Context)this, this.J, d, a, n, f, b);
        if (a2) {
            if (a == 0) {
                Toast.makeText((Context)this, 2131230867, 1).show();
            }
            else {
                Toast.makeText((Context)this, 2131230866, 1).show();
            }
            this.setResult(-1);
            return a2;
        }
        if (a == 16 && !b) {
            this.showDialog(1);
            return a2;
        }
        Toast.makeText((Context)this, 2131230853, 1).show();
        return a2;
    }
    
    private void c() {
        if (this.a == 16) {
            final long d = this.d;
            if (d == -1L) {
                this.t.setText(2131230887);
            }
            else {
                this.t.setText((CharSequence)DateUtils.formatDateTime((Context)this, d, 22));
            }
            final long d2 = this.d;
            if (d2 != -1L) {
                String text = gw.b((Context)this, d2);
                if (text == null) {
                    text = DateUtils.formatDateTime((Context)this, d2, 22);
                }
                this.v.setText((CharSequence)text);
                return;
            }
            this.v.setText(2131230887);
        }
        else if (this.a == 32) {
            this.t.setText((CharSequence)DateUtils.formatDateTime((Context)this, this.d, 98326));
            final long d3 = this.d;
            int n = 1;
            if (DateFormat.is24HourFormat((Context)this)) {
                n = 129;
            }
            this.u.setText((CharSequence)DateUtils.formatDateTime((Context)this, d3, n));
            this.v.setText((CharSequence)DateUtils.getRelativeTimeSpanString(this.d, System.currentTimeMillis(), 0L, 0).toString());
        }
    }
    
    private void d() {
        final Time c = this.c;
        final Resources resources = this.getResources();
        final String[] array = { DateUtils.getDayOfWeekString(1, 10), DateUtils.getDayOfWeekString(2, 10), DateUtils.getDayOfWeekString(3, 10), DateUtils.getDayOfWeekString(4, 10), DateUtils.getDayOfWeekString(5, 10), DateUtils.getDayOfWeekString(6, 10), DateUtils.getDayOfWeekString(7, 10) };
        final String[] stringArray = resources.getStringArray(2131099672);
        int n;
        if (c.weekDay != 0 && c.weekDay != 6) {
            n = 1;
        }
        else {
            n = 0;
        }
        final ArrayList<String> list = new ArrayList<String>(0);
        final ArrayList<Integer> s = new ArrayList<Integer>(0);
        final ArrayList s2 = this.S;
        list.add(resources.getString(2131230899));
        s.add(0);
        list.add(resources.getString(2131230900));
        s.add(16);
        if (n != 0) {
            list.add(resources.getString(2131230901));
            s.add(32);
        }
        list.add(String.format(resources.getString(2131230902), c.format("%A")));
        s.add(48);
        list.add(String.format(resources.getString(2131230903), c.format("%A")));
        s.add(64);
        list.add(String.format(resources.getString(2131230904), stringArray[(-1 + c.monthDay) / 7], array[c.weekDay]));
        s.add(80);
        list.add(String.format(resources.getString(2131230905), c.monthDay));
        s.add(96);
        final long a = jk.a(c, false);
        final String string = resources.getString(2131230906);
        int n2;
        if (DateFormat.is24HourFormat((Context)this)) {
            n2 = 128;
        }
        else {
            n2 = 0;
        }
        list.add(String.format(string, DateUtils.formatDateTime((Context)this, a, n2)));
        s.add(112);
        final String string2 = resources.getString(2131230907);
        final yn yn = new yn((Context)this, jk.a(c, true), 2);
        list.add(String.format(string2, DateUtils.getMonthString(-1 + yn.b, 10), yn.c));
        s.add(128);
        int selection = s.indexOf(0);
        if (s2 == null) {
            if (this.C != 0) {
                selection = s.indexOf(this.C);
            }
        }
        else {
            final int selectedItemPosition = this.y.getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                selection = s.indexOf((int)s2.get(selectedItemPosition));
            }
        }
        if (selection < 0) {
            selection = s.indexOf(0);
        }
        this.S = s;
        final ArrayAdapter adapter = new ArrayAdapter((Context)this, 2130903073, (List)list);
        adapter.setDropDownViewResource(2130903074);
        this.y.setAdapter((SpinnerAdapter)adapter);
        this.y.setSelection(selection);
    }
    
    public final int a(final int i) {
        int n = 16;
        if (this.L) {
            switch (i) {
                case 1: {
                    n = 32;
                }
                case 0: {
                    return n;
                }
            }
        }
        else {
            switch (i) {
                case 1: {
                    return n;
                }
                case 0: {
                    return 0;
                }
                case 2: {
                    return 32;
                }
                case 3: {
                    return 128;
                }
            }
        }
        throw new RuntimeException("Not reachable1:" + i + "/" + this.L);
    }
    
    public final void a() {
        this.z.setVisibility(0);
        this.F = this.D;
        this.x.setEnabled(false);
        this.t.setEnabled(false);
        this.u.setEnabled(false);
        this.v.setEnabled(false);
        this.y.setEnabled(false);
    }
    
    public final void a(final long n) {
        if (n == 0L) {
            this.w.setText(2131230879);
            return;
        }
        this.w.setText((CharSequence)DateUtils.formatDateTime((Context)this, n, 22));
    }
    
    public final int b(final int i) {
        if (this.L) {
            int n = 0;
            switch (i) {
                case 32: {
                    n = 1;
                }
                case 16: {
                    return n;
                }
            }
        }
        else {
            final int n = 0;
            switch (i) {
                case 0: {
                    return n;
                }
                case 16: {
                    return 1;
                }
                case 32: {
                    return 2;
                }
                case 128: {
                    return 3;
                }
            }
        }
        throw new RuntimeException("Not reachable2:" + i + "/" + this.L);
    }
    
    public final void c(final int a) {
        this.b = this.a;
        switch (this.a = a) {
            default: {}
            case 0: {
                this.r.setVisibility(0);
                this.p.setVisibility(8);
                this.u.setVisibility(8);
                this.t.setVisibility(8);
                this.q.setVisibility(8);
                this.s.setVisibility(8);
            }
            case 32: {
                this.r.setVisibility(8);
                this.q.setVisibility(0);
                this.s.setVisibility(0);
                this.p.setVisibility(0);
                this.u.setVisibility(0);
                this.t.setVisibility(0);
                this.t.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                if (!this.j) {
                    if (this.B == 32) {
                        this.b(this.F);
                    }
                    else if (this.b == 16 && this.d != -1L && !DateUtils.isToday(this.d)) {
                        this.c.hour = 6;
                        this.c.minute = 0;
                        this.c.second = 0;
                        this.b(jk.a(this.c, true));
                    }
                    else {
                        this.b(910000L + System.currentTimeMillis());
                    }
                }
                else {
                    this.j = false;
                }
                this.c();
            }
            case 16: {
                this.r.setVisibility(8);
                this.q.setVisibility(0);
                this.s.setVisibility(0);
                this.p.setVisibility(0);
                this.u.setVisibility(8);
                this.t.setVisibility(0);
                this.t.setCompoundDrawablesWithIntrinsicBounds(2130837684, 0, 0, 0);
                this.b();
                if (!this.j) {
                    if (this.B == 16) {
                        if (this.C == 144) {
                            this.b(-1L);
                        }
                        else {
                            this.b(this.F);
                        }
                    }
                    else if (this.b == 32 && this.d != -1L) {
                        this.b(this.d);
                    }
                    else {
                        this.b(System.currentTimeMillis());
                    }
                }
                else {
                    this.j = false;
                }
                this.c();
            }
            case 128: {
                this.r.setVisibility(8);
                this.q.setVisibility(8);
                this.s.setVisibility(8);
                this.p.setVisibility(8);
                this.u.setVisibility(8);
                this.t.setVisibility(8);
            }
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903046);
        this.m = this.getResources().getStringArray(2131099670);
        this.n = this.getResources().getIntArray(2131099658);
        this.o = this.findViewById(2131623965);
        this.p = this.findViewById(2131623968);
        this.q = this.findViewById(2131623973);
        this.r = this.findViewById(2131623979);
        this.s = this.findViewById(2131623976);
        this.t = (Button)this.findViewById(2131623971);
        this.u = (Button)this.findViewById(2131623972);
        this.v = (Button)this.findViewById(2131623970);
        this.w = (Button)this.findViewById(2131623978);
        this.x = (Spinner)this.findViewById(2131623967);
        this.y = (Spinner)this.findViewById(2131623975);
        this.z = this.findViewById(2131623962);
        this.A = this.findViewById(2131623964);
        final Button button = (Button)this.findViewById(2131623986);
        final Button button2 = (Button)this.findViewById(2131623987);
        final Button button3 = (Button)this.findViewById(2131623988);
        button2.setText(2131230859);
        if (jn.a()) {
            button.setText(2131230858);
            button3.setText(2131230861);
        }
        else {
            button3.setText(2131230858);
            button.setText(2131230861);
        }
        this.H = this.getIntent().getLongExtra("_id", 0L);
        this.I = this.getIntent().getIntExtra("folder_id", -1);
        this.B = this.getIntent().getIntExtra("reminder_type", 0);
        this.C = this.getIntent().getIntExtra("reminder_repeat", 0);
        this.D = this.getIntent().getLongExtra("reminder_base", 0L);
        this.E = this.getIntent().getLongExtra("reminder_date", 0L);
        this.G = this.getIntent().getLongExtra("reminder_repeat_ends", 0L);
        if (this.I == 16 && this.B != 128) {
            this.L = true;
            this.findViewById(2131623987).setVisibility(8);
            this.setTitle(2131230786);
        }
        else {
            this.L = false;
            this.setTitle(2131230881);
        }
        ArrayAdapter adapter;
        if (this.L) {
            adapter = ArrayAdapter.createFromResource((Context)this, 2131099669, 2130903073);
        }
        else {
            adapter = ArrayAdapter.createFromResource((Context)this, 2131099668, 2130903073);
        }
        adapter.setDropDownViewResource(2130903074);
        this.x.setAdapter((SpinnerAdapter)adapter);
        this.t.setOnClickListener(this.M);
        this.u.setOnClickListener(this.M);
        this.v.setOnClickListener(this.M);
        this.w.setOnClickListener(this.M);
        this.x.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)new ij(this));
        this.y.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)new ik(this));
        this.findViewById(2131623986).setOnClickListener(this.M);
        this.findViewById(2131623987).setOnClickListener(this.M);
        this.findViewById(2131623988).setOnClickListener(this.M);
        this.findViewById(2131623963).setOnClickListener(this.M);
        this.findViewById(2131623981).setOnClickListener(this.M);
        this.findViewById(2131623982).setOnClickListener(this.M);
        this.findViewById(2131623983).setOnClickListener(this.M);
        this.findViewById(2131623984).setOnClickListener(this.M);
        this.findViewById(2131623985).setOnClickListener(this.M);
        this.A.setOnClickListener(this.M);
        this.m = this.getResources().getStringArray(2131099670);
        this.n = this.getResources().getIntArray(2131099658);
        this.c = new Time();
        this.e = new Time();
        this.h = false;
        this.g = false;
        this.i = false;
        this.a(this.f = this.G);
        if (this.E != 0L) {
            this.z.setVisibility(8);
            this.F = this.E;
            this.A.setVisibility(0);
        }
        else if (this.B != 0) {
            this.a();
        }
        else {
            this.z.setVisibility(8);
        }
        this.J = ContentUris.withAppendedId(kf.a, this.H);
        this.x.setSelection(this.b(this.B));
    }
    
    protected Dialog onCreateDialog(final int n) {
        switch (n) {
            default: {
                return super.onCreateDialog(n);
            }
            case 1: {
                int n2;
                if (this.L) {
                    n2 = 2131230786;
                }
                else {
                    n2 = 2131230881;
                }
                return gw.a((Context)this, 2130837583, n2, 2131230931, (DialogInterface$OnClickListener)new il(this));
            }
        }
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            return this.h = true;
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (n == 4 && this.h) {
            this.a(this.h = false);
            return true;
        }
        return super.onKeyUp(n, keyEvent);
    }
    
    protected void onPause() {
        if (this.K) {
            this.b(false);
        }
        super.onPause();
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
