// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.widget;

import java.util.Collections;
import com.facebook.bn;
import com.facebook.b.ae;
import java.util.List;
import com.facebook.bm;
import android.os.AsyncTask;
import android.graphics.Canvas;
import com.facebook.ab;
import com.facebook.bb;
import com.facebook.ar;
import com.facebook.Request;
import com.facebook.a.g;
import com.facebook.bj;
import com.facebook.b.aj;
import android.view.View;
import com.facebook.b.ak;
import android.content.res.TypedArray;
import com.facebook.a.d;
import android.graphics.Typeface;
import com.facebook.a.c;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View$OnClickListener;
import android.support.v4.app.Fragment;
import com.facebook.bc;
import com.facebook.c.i;
import com.facebook.b.af;
import android.widget.Button;

public class LoginButton extends Button
{
    private static final String a;
    private String b;
    private af c;
    private i d;
    private bc e;
    private boolean f;
    private boolean g;
    private String h;
    private String i;
    private f j;
    private Fragment k;
    private b l;
    private String m;
    private View$OnClickListener n;
    private boolean o;
    private j p;
    private e q;
    private long r;
    private h s;
    
    static {
        a = LoginButton.class.getName();
    }
    
    public LoginButton(final Context context) {
        super(context);
        this.b = null;
        this.d = null;
        this.e = null;
        this.l = new b();
        this.m = "fb_login_view_usage";
        this.p = com.facebook.widget.j.a;
        this.q = com.facebook.widget.e.a;
        this.r = 6000L;
        a(context);
        this.b();
    }
    
    public LoginButton(final Context context, final AttributeSet set) {
        super(context, set);
        this.b = null;
        this.d = null;
        this.e = null;
        this.l = new b();
        this.m = "fb_login_view_usage";
        this.p = com.facebook.widget.j.a;
        this.q = com.facebook.widget.e.a;
        this.r = 6000L;
        if (set.getStyleAttribute() == 0) {
            this.setGravity(17);
            this.setTextColor(this.getResources().getColor(com.facebook.a.b.b));
            this.setTextSize(0, this.getResources().getDimension(com.facebook.a.c.f));
            this.setTypeface(Typeface.DEFAULT_BOLD);
            if (this.isInEditMode()) {
                this.setBackgroundColor(this.getResources().getColor(com.facebook.a.b.a));
                this.h = "Log in with Facebook";
            }
            else {
                this.setBackgroundResource(com.facebook.a.d.a);
                this.setCompoundDrawablesWithIntrinsicBounds(com.facebook.a.d.c, 0, 0, 0);
                this.setCompoundDrawablePadding(this.getResources().getDimensionPixelSize(com.facebook.a.c.a));
                this.setPadding(this.getResources().getDimensionPixelSize(com.facebook.a.c.c), this.getResources().getDimensionPixelSize(com.facebook.a.c.e), this.getResources().getDimensionPixelSize(com.facebook.a.c.d), this.getResources().getDimensionPixelSize(com.facebook.a.c.b));
            }
        }
        this.a(set);
        if (!this.isInEditMode()) {
            a(context);
        }
    }
    
    public LoginButton(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.b = null;
        this.d = null;
        this.e = null;
        this.l = new b();
        this.m = "fb_login_view_usage";
        this.p = com.facebook.widget.j.a;
        this.q = com.facebook.widget.e.a;
        this.r = 6000L;
        this.a(set);
        a(context);
    }
    
    private void a() {
        if (this.s != null) {
            this.s.b();
            this.s = null;
        }
    }
    
    private void a(final AttributeSet set) {
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(set, com.facebook.a.h.b);
        this.f = obtainStyledAttributes.getBoolean(0, true);
        this.g = obtainStyledAttributes.getBoolean(1, true);
        this.h = obtainStyledAttributes.getString(2);
        this.i = obtainStyledAttributes.getString(3);
        obtainStyledAttributes.recycle();
    }
    
    static /* synthetic */ void a(final LoginButton loginButton, final i d) {
        loginButton.d = d;
    }
    
    private void a(final String s) {
        (this.s = new h(s, (View)this)).a(this.p);
        this.s.a(this.r);
        this.s.a();
    }
    
    private static boolean a(final Context context) {
        if (context != null) {
            final bc f = bc.f();
            if (f != null) {
                return f.a();
            }
            if (aj.a(context) != null && bc.a(context) != null) {
                return true;
            }
        }
        return false;
    }
    
    private void b() {
        super.setOnClickListener((View$OnClickListener)new com.facebook.widget.c(this, (byte)0));
        this.c();
        if (!this.isInEditMode()) {
            this.c = new af(this.getContext(), new a(this, (byte)0));
            this.d();
        }
    }
    
    private void c() {
        if (this.c != null && this.c.b() != null) {
            String text;
            if (this.i != null) {
                text = this.i;
            }
            else {
                text = this.getResources().getString(com.facebook.a.g.g);
            }
            this.setText((CharSequence)text);
            return;
        }
        String text2;
        if (this.h != null) {
            text2 = this.h;
        }
        else {
            text2 = this.getResources().getString(com.facebook.a.g.e);
        }
        this.setText((CharSequence)text2);
    }
    
    private void d() {
        if (this.g) {
            final bc b = this.c.b();
            if (b != null) {
                if (b != this.e) {
                    Request.a(new Request[] { Request.a(b, new ar() {
                            @Override
                            public final void a(final i i, final bb bb) {
                                if (b == LoginButton.this.c.b()) {
                                    LoginButton.a(LoginButton.this, i);
                                    if (LoginButton.this.j != null) {
                                        LoginButton.this.j;
                                        LoginButton.this.d;
                                    }
                                }
                                if (bb.a() != null) {
                                    LoginButton.this.a(bb.a().e());
                                }
                            }
                        }) });
                    this.e = b;
                }
            }
            else {
                this.d = null;
                if (this.j != null) {
                    final f j = this.j;
                    final i d = this.d;
                }
            }
        }
    }
    
    final void a(final Exception ex) {
        if (this.l.d != null) {
            if (!(ex instanceof ab)) {
                this.l.d;
                new ab(ex);
                return;
            }
            this.l.d;
        }
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c != null && !this.c.f()) {
            this.c.d();
            this.d();
            this.c();
        }
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.c != null) {
            this.c.e();
        }
        this.a();
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (!this.o && this.q != com.facebook.widget.e.c && !this.isInEditMode()) {
            this.o = true;
            if (this.q != com.facebook.widget.e.b) {
                new AsyncTask() {
                    private final /* synthetic */ String b = aj.a(LoginButton.this.getContext());
                }.execute((Object[])null);
                return;
            }
            this.a(this.getResources().getString(com.facebook.a.g.o));
        }
    }
    
    public void onFinishInflate() {
        super.onFinishInflate();
        this.b();
    }
    
    protected void onVisibilityChanged(final View view, final int n) {
        super.onVisibilityChanged(view, n);
        if (n != 0) {
            this.a();
        }
    }
    
    public void setOnClickListener(final View$OnClickListener n) {
        this.n = n;
    }
}
