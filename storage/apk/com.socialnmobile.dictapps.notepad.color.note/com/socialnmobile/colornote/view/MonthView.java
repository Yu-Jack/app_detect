// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.view.MotionEvent;
import android.view.KeyEvent;
import android.text.format.DateUtils;
import android.graphics.Paint$Align;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import java.util.Calendar;
import android.preference.PreferenceManager;
import java.util.Iterator;
import android.graphics.ColorFilter;
import android.graphics.PathEffect;
import android.graphics.Typeface;
import android.graphics.Paint$Style;
import android.graphics.Bitmap$Config;
import android.view.GestureDetector$OnGestureListener;
import android.util.AttributeSet;
import android.content.Context;
import android.util.SparseArray;
import android.graphics.RectF;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.widget.PopupWindow;
import java.util.ArrayList;
import android.graphics.Rect;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.format.Time;
import android.view.GestureDetector;
import android.graphics.Path;
import android.graphics.Paint;
import android.view.View$OnCreateContextMenuListener;
import android.view.View;

public class MonthView extends View implements View$OnCreateContextMenuListener
{
    private static float a;
    private static int b;
    private static int c;
    private static int d;
    private static float e;
    private static float f;
    private static int g;
    private static int h;
    private static int i;
    private static int j;
    private static int k;
    private static int l;
    private static int m;
    private static int n;
    private static int o;
    private static int p;
    private static int q;
    private static int r;
    private static int s;
    private static int t;
    private static int u;
    private static int v;
    private static int w;
    private static int x;
    private static int y;
    private static int z;
    private zo A;
    private ScreenCalendar B;
    private int C;
    private int D;
    private boolean E;
    private Paint F;
    private Paint G;
    private Path H;
    private GestureDetector I;
    private Time J;
    private Time K;
    private Time L;
    private String M;
    private Time N;
    private Time O;
    private Time P;
    private Time Q;
    private zb R;
    private Drawable S;
    private Drawable T;
    private Drawable U;
    private int V;
    private Resources W;
    private Rect Z;
    private int aA;
    private ArrayList[] aB;
    private String[] aC;
    private boolean aD;
    private boolean[] aa;
    private PopupWindow ab;
    private zn ac;
    private Bitmap ad;
    private Canvas ae;
    private int af;
    private Rect ag;
    private RectF ah;
    private boolean ai;
    private boolean aj;
    private SparseArray ak;
    private int al;
    private int am;
    private int an;
    private Drawable ao;
    private int ap;
    private int aq;
    private int ar;
    private int as;
    private int at;
    private int au;
    private int av;
    private int aw;
    private int ax;
    private int ay;
    private int az;
    
    static {
        MonthView.a = 0.0f;
        MonthView.b = 24;
        MonthView.c = 0;
        MonthView.d = 0;
        MonthView.e = 0.0f;
        MonthView.f = 4.0f;
        MonthView.g = 15;
        MonthView.h = 18;
        MonthView.i = 10;
        MonthView.j = 12;
        MonthView.k = 17;
        MonthView.l = 15;
        MonthView.m = 3;
        MonthView.n = 31;
        MonthView.o = 1;
        MonthView.p = 0;
        MonthView.q = 3;
        MonthView.r = 6;
        MonthView.s = 4;
        MonthView.t = 4;
        MonthView.u = 4;
        MonthView.v = 0;
        MonthView.w = 0;
        MonthView.x = 8;
        MonthView.y = 10;
        MonthView.z = 50;
    }
    
    public MonthView(final Context context, final AttributeSet set) {
        super(context, set);
        this.H = new Path();
        this.N = new Time();
        this.O = new Time();
        this.P = new Time();
        this.Q = new Time();
        this.Z = new Rect();
        this.aa = new boolean[31];
        this.ac = new zn(this);
        this.af = 1;
        this.ag = new Rect();
        this.ah = new RectF();
        this.ai = false;
        this.aj = false;
        this.ak = new SparseArray(4);
        this.al = 0;
        this.aC = new String[32];
        if (MonthView.a == 0.0f && (MonthView.a = this.getContext().getResources().getDisplayMetrics().density) != 1.0f) {
            MonthView.c *= (int)MonthView.a;
            MonthView.d *= (int)MonthView.a;
            MonthView.e *= MonthView.a;
            MonthView.g *= (int)MonthView.a;
            MonthView.h *= (int)MonthView.a;
            MonthView.i *= (int)MonthView.a;
            MonthView.j *= (int)MonthView.a;
            MonthView.k *= (int)MonthView.a;
            MonthView.l *= (int)MonthView.a;
            MonthView.m *= (int)MonthView.a;
            MonthView.o *= (int)MonthView.a;
            MonthView.p *= (int)MonthView.a;
            MonthView.q *= (int)MonthView.a;
            MonthView.z *= (int)MonthView.a;
            MonthView.f *= MonthView.a;
            MonthView.r *= (int)MonthView.a;
            MonthView.s *= (int)MonthView.a;
            MonthView.y *= (int)MonthView.a;
            MonthView.b *= (int)MonthView.a;
            MonthView.t *= (int)MonthView.a;
            MonthView.u *= (int)MonthView.a;
        }
        MonthView.w = (MonthView.v = this.getResources().getDimensionPixelSize(2131361799));
        this.setFocusable(true);
        this.setClickable(true);
        this.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)this);
        this.K = new Time();
        (this.J = new Time()).set(System.currentTimeMillis());
        this.b(this.J);
        this.b();
        this.W = context.getResources();
        this.S = this.W.getDrawable(2130837650);
        this.T = this.W.getDrawable(2130837652);
        this.U = this.W.getDrawable(2130837651);
        this.ao = this.W.getDrawable(2130837653);
        this.c();
        this.I = new GestureDetector(this.getContext(), (GestureDetector$OnGestureListener)new zl(this));
    }
    
    private void a(final int right, final int bottom) {
        this.C = (bottom - MonthView.b - 6 * MonthView.c) / 6;
        this.V = (right - 6 * MonthView.d) / 7;
        this.D = (right - 6 * (this.V + MonthView.d) - this.V) / 2;
        if ((this.ad == null || this.ad.isRecycled() || this.ad.getHeight() != bottom || this.ad.getWidth() != right) && right > 0 && bottom > 0) {
            if (this.ad != null) {
                this.ad.recycle();
            }
            this.ad = Bitmap.createBitmap(right, bottom, Bitmap$Config.ARGB_8888);
            this.ae = new Canvas(this.ad);
        }
        this.ag.top = 0;
        this.ag.bottom = bottom;
        this.ag.left = 0;
        this.ag.right = right;
    }
    
    private void a(final int n, final int n2, final int n3, final Canvas canvas, final Paint paint, final Rect bounds, final boolean b) {
        final int n4 = 1 + (n - this.am);
        final int al = this.al;
        boolean b2 = false;
        if (al != 0) {
            b2 = this.R.b(n2, n3);
        }
        final boolean withinCurrentMonth = this.R.isWithinCurrentMonth(n2, n3);
        final int day = this.R.getDayAt(n2, n3);
        final int monthDay = this.J.monthDay;
        boolean b3 = false;
        if (day == monthDay) {
            final int year = this.R.getYear();
            final int year2 = this.J.year;
            b3 = false;
            if (year == year2) {
                final int month = this.R.getMonth();
                final int month2 = this.J.month;
                b3 = false;
                if (month == month2) {
                    b3 = true;
                }
            }
        }
        final int top = MonthView.c + n2 * (MonthView.c + this.C) + MonthView.b;
        final int left = this.D + n3 * (MonthView.d + this.V);
        bounds.left = left;
        bounds.top = top;
        bounds.right = left + this.V;
        bounds.bottom = top + this.C;
        if (n3 == 0) {
            bounds.left = 1;
        }
        else if (n3 == 6) {
            bounds.right = -1 + this.getWidth();
        }
        if (n2 == 5) {
            bounds.bottom = this.getMeasuredHeight();
        }
        if (!withinCurrentMonth) {
            --bounds.top;
            if (n3 != 0) {
                --bounds.left;
            }
            paint.setStyle(Paint$Style.FILL);
            paint.setColor(this.aA);
            canvas.drawRect(bounds, paint);
        }
        else if (b2) {
            if (this.al == 2) {
                this.S.setBounds(bounds);
                this.S.draw(canvas);
            }
            else if (this.al == 1) {
                this.T.setBounds(bounds);
                this.T.draw(canvas);
            }
            else {
                this.U.setBounds(bounds);
                this.U.draw(canvas);
            }
            this.a(n4, canvas, bounds, paint);
        }
        else {
            if (c(n3, this.an)) {
                paint.setStyle(Paint$Style.FILL);
                paint.setColor(this.az);
                canvas.drawRect(bounds, paint);
            }
            else if (b(n3, this.an)) {
                paint.setStyle(Paint$Style.FILL);
                paint.setColor(this.ay);
                canvas.drawRect(bounds, paint);
            }
            else {
                paint.setStyle(Paint$Style.FILL);
                paint.setColor(this.ax);
                canvas.drawRect(bounds, paint);
            }
            if (b3) {
                final Drawable ao = this.ao;
                ao.setBounds(bounds.left, bounds.top, -1 + bounds.right, -1 + bounds.bottom);
                ao.draw(canvas);
            }
            this.a(n4, canvas, bounds, paint);
        }
        paint.setStyle(Paint$Style.FILL);
        paint.setAntiAlias(true);
        paint.setTypeface((Typeface)null);
        paint.setTextSize((float)MonthView.h);
        if (!withinCurrentMonth) {
            paint.setColor(this.as);
        }
        else {
            if (b3 && !b2) {
                paint.setColor(this.au);
            }
            else if (c(n3, this.an)) {
                paint.setColor(this.aw);
            }
            else if (b(n3, this.an)) {
                paint.setColor(this.av);
            }
            else {
                paint.setColor(this.at);
            }
            paint.setFakeBoldText(this.aa[n - this.am]);
        }
        final int n5 = bounds.left + MonthView.q;
        final int n6 = (int)(bounds.top + paint.getTextSize() + MonthView.p);
        canvas.drawText(String.valueOf(this.R.getDayAt(n2, n3)), (float)n5, (float)n6, paint);
        if (this.aD && withinCurrentMonth && this.aC[n4] != null) {
            int n7;
            if (b) {
                n7 = MonthView.i;
            }
            else {
                n7 = MonthView.j;
            }
            paint.setTextSize((float)n7);
            canvas.drawText(this.aC[n4], (float)n5, (float)(n7 + n6), paint);
        }
    }
    
    private void a(final int n, final Canvas canvas, final Rect rect, final Paint paint) {
        final Paint$Style style = paint.getStyle();
        final int color = paint.getColor();
        final ArrayList list = this.aB[n];
        final Iterator<kh> iterator = list.iterator();
        int n2 = 0;
    Label_0245_Outer:
        while (iterator.hasNext()) {
            final kh kh = iterator.next();
            final int size = list.size();
            final int n3 = n2 + 1;
            final int e = gr.a(this.getContext()).e(kh.j);
            final boolean a = kh.a();
            final int n4 = MonthView.x / 2;
            final int n5 = rect.bottom - MonthView.u - MonthView.v;
            final int n6 = rect.right - MonthView.t - n4 * (1 + MonthView.w);
            final int n7 = rect.right - MonthView.t;
            int n8 = -1 + (rect.bottom - MonthView.u);
            final int n9 = (n7 - n6 - 2 * (n4 - 1)) / n4;
            while (true) {
                Label_0697: {
                    if (size <= n4) {
                        break Label_0697;
                    }
                    int n11;
                    int n12;
                    if (n2 < n4) {
                        final int n10 = rect.bottom - 2 * MonthView.u - 2 * MonthView.v;
                        n8 = -1 + (rect.bottom - 2 * MonthView.u - MonthView.v);
                        n11 = n2;
                        n12 = n10;
                    }
                    else {
                        if (n2 < n4) {
                            break Label_0697;
                        }
                        n11 = n2 - n4;
                        n12 = n5;
                    }
                    paint.setColor(e);
                    paint.setStyle(Paint$Style.FILL);
                    final RectF ah = this.ah;
                    ah.left = 1 + (n6 + n11 * (n9 + 2));
                    ah.right = n6 + (n11 + 1) * (n9 + 2);
                    ah.bottom = n8;
                    ah.top = n12;
                    canvas.drawRect(ah, paint);
                    if (this.F == null) {
                        (this.F = new Paint()).setStyle(Paint$Style.STROKE);
                        this.F.setStrokeWidth(0.0f);
                        this.F.setPathEffect((PathEffect)null);
                        this.F.setColorFilter((ColorFilter)null);
                        this.F.setDither(false);
                    }
                    this.F.setColor(this.aq);
                    if (this.G == null) {
                        (this.G = new Paint()).setStyle(Paint$Style.STROKE);
                        this.G.setStrokeWidth(2.0f);
                        this.G.setPathEffect((PathEffect)null);
                        this.G.setColorFilter((ColorFilter)null);
                        this.G.setDither(false);
                    }
                    this.G.setColor(this.ar);
                    canvas.drawLine(ah.left, ah.top, ah.right, ah.top, this.F);
                    canvas.drawLine(ah.left, ah.bottom - 1.0f, ah.right, ah.bottom - 1.0f, this.F);
                    canvas.drawLine(ah.left, ah.top, ah.left, ah.bottom, this.F);
                    canvas.drawLine(ah.right - 1.0f, ah.top, ah.right - 1.0f, ah.bottom, this.F);
                    if (a) {
                        canvas.drawLine(ah.left, 1.0f + ah.top, ah.right, ah.bottom - 1.0f, this.G);
                        canvas.drawLine(ah.left, ah.bottom - 1.0f, ah.right, 1.0f + ah.top, this.G);
                    }
                    if (n3 < MonthView.x) {
                        n2 = n3;
                        continue Label_0245_Outer;
                    }
                    break;
                }
                int n11 = n2;
                int n12 = n5;
                continue;
            }
        }
        paint.setStyle(style);
        paint.setColor(color);
    }
    
    private void a(final Canvas canvas, final Paint paint) {
        paint.setColor(this.aq);
        paint.setAntiAlias(false);
        final int measuredWidth = this.getMeasuredWidth();
        final int measuredHeight = this.getMeasuredHeight();
        for (int i = 0; i < 6; ++i) {
            final int n = -1 + (MonthView.c + i * (MonthView.c + this.C)) + MonthView.b;
            canvas.drawLine(0.0f, (float)n, (float)measuredWidth, (float)n, paint);
        }
        canvas.drawLine(0.0f, (float)(measuredHeight - 1), (float)measuredWidth, (float)(measuredHeight - 1), paint);
        canvas.drawLine(0.0f, (float)(MonthView.c + MonthView.b), 0.0f, (float)measuredHeight, paint);
        canvas.drawLine((float)(measuredWidth - 1), (float)(MonthView.c + MonthView.b), (float)(measuredWidth - 1), (float)measuredHeight, paint);
        for (int j = 1; j < 7; ++j) {
            final int n2 = -1 + (this.D + j * (MonthView.d + this.V));
            canvas.drawLine((float)n2, (float)(MonthView.c + MonthView.b), (float)n2, (float)measuredHeight, paint);
        }
    }
    
    private void b(final Time time) {
        this.K.set(time);
        this.K.monthDay = 1;
        this.K.hour = 0;
        this.K.minute = 0;
        this.K.second = 0;
        this.am = Time.getJulianDay(jk.a(this.K), this.K.gmtoff);
    }
    
    private static boolean b(final int n, final int n2) {
        boolean b = true;
        if ((n2 != 0 || n != 6) && (n2 != (b ? 1 : 0) || n != 5) && (n2 != 6 || n != 0)) {
            b = false;
        }
        return b;
    }
    
    private static boolean c(final int n, final int n2) {
        boolean b = true;
        if ((n2 != 0 || n != 0) && (n2 != (b ? 1 : 0) || n != 6) && (n2 != 6 || n != (b ? 1 : 0))) {
            b = false;
        }
        return b;
    }
    
    private static int d(final int n, final int n2) {
        int n3;
        if (n2 == 0) {
            n3 = n + 1;
        }
        else if (n2 == 1) {
            n3 = n + 2;
        }
        else {
            n3 = 0;
            if (n2 == 6) {
                n3 = n + 7;
            }
        }
        if (n3 > 7) {
            n3 %= 7;
        }
        return n3;
    }
    
    private void h() {
        final SparseArray ak = this.ak;
        for (int size = ak.size(), i = 0; i < size; ++i) {
            ((Bitmap)ak.valueAt(i)).recycle();
        }
        ak.clear();
    }
    
    public final int a(final int n) {
        final int n2 = (n - MonthView.c - MonthView.b) / (MonthView.c + this.C);
        if (n2 > 5) {
            return 5;
        }
        return n2;
    }
    
    public final void a() {
        (this.J = new Time()).set(System.currentTimeMillis());
    }
    
    final void a(final Time time) {
        this.N.set(time);
        this.a();
        this.b(time);
        this.b();
        this.af = 1;
        this.invalidate();
    }
    
    public final int b(final int n) {
        final int n2 = (n - this.D) / (MonthView.d + this.V);
        if (n2 > 6) {
            return 6;
        }
        return n2;
    }
    
    public final void b() {
        final String string = PreferenceManager.getDefaultSharedPreferences(this.getContext()).getString("pref_first_day_of_week", (String)null);
        int intValue;
        if (string == null) {
            final int firstDayOfWeek = Calendar.getInstance().getFirstDayOfWeek();
            if (firstDayOfWeek == 7) {
                intValue = 6;
            }
            else if (firstDayOfWeek == 2) {
                intValue = 1;
            }
            else {
                intValue = 0;
            }
        }
        else {
            intValue = Integer.valueOf(string);
        }
        this.an = intValue;
        this.R = new zb(this.K.year, this.K.month, this.K.monthDay, d(0, this.an));
        final String i = jp.i(this.getContext());
        if ("".equals(i) || i == null) {
            this.aD = false;
        }
        else {
            this.aD = true;
        }
        if (this.aD) {
            final String j = jp.j(this.getContext());
            if (!j.equals(this.M) || this.K == null || this.L == null || jk.a(this.K, true) != jk.a(this.L, true)) {
                this.L = new Time(this.K);
                this.M = j;
                for (int k = 0; k < this.aC.length; ++k) {
                    this.aC[k] = null;
                }
                this.Q.set(this.K);
                this.Q.monthDay = 1;
                final yn yn = new yn(this.getContext(), jk.a(this.Q), 2);
                if (yn.c == 1) {
                    this.aC[1] = yn.b + "/1";
                }
                if (yn.c <= 15) {
                    this.aC[1 + (15 - yn.c)] = yn.b + "/15";
                }
                final Object[] a = new yn(this.getContext()).a(yn.a, yn.b, yn.d, new yn(this.getContext()).a(yn.a, yn.b, yn.d, 2));
                final int intValue2 = (int)a[0];
                final int intValue3 = (int)a[1];
                final boolean booleanValue = (boolean)a[2];
                final long longValue = (long)a[3];
                this.Q.set(longValue);
                if (this.Q.month == this.K.month && this.Q.monthDay < this.aC.length) {
                    this.aC[this.Q.monthDay] = intValue3 + "/1";
                }
                if (this.Q.month == this.K.month && 14 + this.Q.monthDay < this.aC.length) {
                    this.aC[14 + this.Q.monthDay] = intValue3 + "/15";
                }
                if (14 + this.Q.monthDay < 18) {
                    final Object[] a2 = new yn(this.getContext()).a(intValue2, intValue3, booleanValue, longValue);
                    (int)a2[0];
                    final int intValue4 = (int)a2[1];
                    (boolean)a2[2];
                    this.Q.set((long)a2[3]);
                    if (this.Q.year == this.K.year && this.Q.month == this.K.month && this.Q.monthDay < this.aC.length) {
                        this.aC[this.Q.monthDay] = intValue4 + "/1";
                    }
                }
            }
        }
    }
    
    public final void c() {
        final yc a = gr.a(this.getContext());
        this.ap = a.n(3);
        this.aq = a.m(0);
        this.ar = a.m(1);
        this.as = a.m(2);
        this.at = a.m(3);
        this.au = a.m(4);
        this.av = a.m(5);
        this.aw = a.m(6);
        this.aA = a.m(7);
        this.ax = a.m(8);
        this.ay = a.m(9);
        this.az = a.m(10);
        this.af = 1;
        this.invalidate();
    }
    
    public final Time d() {
        final Time p = this.P;
        p.set(this.K);
        p.month += this.R.b();
        p.monthDay = this.R.a();
        p.second = this.N.second;
        p.minute = this.N.minute;
        p.hour = this.N.hour;
        jk.a(p);
        return p;
    }
    
    final Time e() {
        return this.K;
    }
    
    public final void f() {
        this.af = 1;
        this.invalidate();
    }
    
    public void onCreateContextMenu(final ContextMenu contextMenu, final View view, final ContextMenu$ContextMenuInfo contextMenu$ContextMenuInfo) {
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.h();
        if (this.ad != null) {
            this.ad.recycle();
        }
    }
    
    protected void onDraw(final Canvas canvas) {
        if (this.af != 0) {
            if (this.ae == null) {
                this.a(this.getWidth(), this.getHeight());
            }
            if (this.ae != null) {
                final Canvas ae = this.ae;
                if (this.af == 1) {
                    ae.drawColor(this.ap);
                }
                final boolean b = this.getResources().getConfiguration().orientation == 2;
                final Paint paint = new Paint();
                final Rect z = this.Z;
                int n = this.am - this.R.getColumnOf(1);
                if (this.af == 1) {
                    for (int i = 0; i < 7; ++i) {
                        final int left = this.D + i * (MonthView.d + this.V);
                        z.left = left;
                        z.top = 0;
                        z.right = left + this.V;
                        z.bottom = 0 + this.C;
                        if (i == 0) {
                            z.left = 1;
                        }
                        else if (i == 6) {
                            z.right += 2 + this.D;
                        }
                        if (!c(i, this.an)) {
                            final int an = this.an;
                        }
                        paint.setStyle(Paint$Style.FILL);
                        paint.setColor(this.ap);
                        ae.drawRect(z, paint);
                        paint.setStyle(Paint$Style.FILL);
                        paint.setAntiAlias(true);
                        paint.setTypeface((Typeface)null);
                        paint.setTextSize((float)MonthView.g);
                        if (c(i, this.an)) {
                            paint.setColor(this.aw);
                        }
                        else if (b(i, this.an)) {
                            paint.setColor(this.av);
                        }
                        else {
                            paint.setColor(this.at);
                        }
                        paint.setTextAlign(Paint$Align.LEFT);
                        ae.drawText(DateUtils.getDayOfWeekString(d(i, this.an), 20).toUpperCase(), (float)(z.left + MonthView.q), (float)(int)(z.top + paint.getTextSize() + MonthView.o), paint);
                    }
                }
                final Paint paint2 = new Paint();
                for (int j = 0; j < 6; ++j) {
                    for (int k = 0; k < 7; ++k) {
                        if (this.af == 1) {
                            this.a(n, j, k, ae, paint2, z, b);
                        }
                        else if (this.af == 2 && this.R.b(j, k)) {
                            this.a(n, j, k, ae, paint2, z, b);
                        }
                        ++n;
                    }
                }
                this.a(ae, paint2);
                this.af = 0;
            }
        }
        if (this.ad != null) {
            canvas.drawBitmap(this.ad, this.ag, this.ag, (Paint)null);
        }
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        boolean b = false;
        if (this.al == 0 && (n == 66 || n == 22 || n == 21 || n == 19 || n == 20 || n == 23)) {
            this.al = 2;
            this.af = 1;
            this.invalidate();
            b = true;
        }
        else {
            this.al = 2;
            Time time = null;
            switch (n) {
                default: {
                    b = false;
                    time = null;
                    break;
                }
                case 23: {
                    this.al = 1;
                    this.af = 1;
                    this.invalidate();
                    return true;
                }
                case 66: {
                    if (this.A != null) {
                        this.A.a(this.d());
                    }
                    return true;
                }
                case 19: {
                    final boolean c = this.R.c();
                    Time o = null;
                    if (c) {
                        o = this.O;
                        o.set(this.K);
                        --o.month;
                        o.monthDay = this.R.a();
                        this.R.d();
                    }
                    time = o;
                    b = true;
                    break;
                }
                case 20: {
                    final boolean d = this.R.d();
                    Time o2 = null;
                    if (d) {
                        o2 = this.O;
                        o2.set(this.K);
                        ++o2.month;
                        o2.monthDay = this.R.a();
                        this.R.c();
                    }
                    time = o2;
                    b = true;
                    break;
                }
                case 21: {
                    final boolean e = this.R.e();
                    Time o3 = null;
                    if (e) {
                        o3 = this.O;
                        o3.set(this.K);
                        --o3.month;
                        o3.monthDay = this.R.a();
                        this.R.f();
                    }
                    time = o3;
                    b = true;
                    break;
                }
                case 22: {
                    final boolean f = this.R.f();
                    Time o4 = null;
                    if (f) {
                        o4 = this.O;
                        o4.set(this.K);
                        ++o4.month;
                        o4.monthDay = this.R.a();
                        this.R.e();
                    }
                    time = o4;
                    b = true;
                    break;
                }
            }
            if (time != null) {
                jk.a(time);
                this.B.a(time);
                return b;
            }
            if (b) {
                this.af = 1;
                this.invalidate();
                return b;
            }
        }
        return b;
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        switch (n) {
            case 23: {
                if (this.al == 1) {
                    if (this.A != null) {
                        this.A.a(this.d());
                    }
                    this.al = 0;
                    this.af = 2;
                    this.invalidate();
                    break;
                }
                break;
            }
        }
        return super.onKeyUp(n, keyEvent);
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        this.a(n, n2);
        this.h();
        this.af = 1;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.I.onTouchEvent(motionEvent)) {
            return true;
        }
        if (motionEvent.getAction() == 3) {
            this.E = false;
            if (this.al != 0) {
                this.al = 0;
                this.af = 1;
                this.invalidate();
            }
        }
        return super.onTouchEvent(motionEvent);
    }
    
    public void setMonthNotes(final ArrayList[] ab) {
        this.aB = ab;
    }
    
    public void setOnDayClickListener(final zo a) {
        this.A = a;
    }
    
    public void setParent(final ScreenCalendar b) {
        this.B = b;
    }
    
    public void setSelectionMode(final int al) {
        this.al = al;
    }
}
