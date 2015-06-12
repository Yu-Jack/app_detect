// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import android.content.res.Configuration;
import com.socialnmobile.colornote.dialog.DialogFactory$ConfirmDialogFragment;
import com.socialnmobile.colornote.dialog.DialogFactory$EnterPasswordDialogFragment;
import com.socialnmobile.colornote.dialog.DialogFactory$ColorSelectorDialogFragment;
import android.content.DialogInterface$OnClickListener;
import com.socialnmobile.colornote.dialog.DialogFactory;
import com.socialnmobile.colornote.dialog.DialogFactory$DownloadColorDictDialogFragment;
import android.support.v4.app.DialogFragment;
import android.view.MenuItem;
import android.graphics.drawable.GradientDrawable;
import android.view.View$OnTouchListener;
import android.view.GestureDetector$OnGestureListener;
import android.view.GestureDetector;
import android.view.Menu;
import android.database.DataSetObserver;
import android.database.ContentObserver;
import android.os.Build$VERSION;
import java.util.Map;
import com.socialnmobile.colornote.ColorNote;
import java.util.HashMap;
import android.app.Activity;
import android.widget.Toast;
import com.socialnmobile.colornote.activity.PasswordSetting;
import android.content.Intent;
import com.socialnmobile.colornote.activity.ReminderSettings;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff$Mode;
import android.support.v4.app.FragmentActivity;
import android.content.Context;
import android.content.ContentValues;
import android.os.Parcelable;
import android.os.Bundle;
import android.net.Uri;
import android.view.View$OnClickListener;
import android.content.DialogInterface$OnCancelListener;
import android.view.View;
import android.os.Handler;
import android.database.Cursor;
import android.support.v4.app.Fragment;

public abstract class AbstractEditorViewer extends Fragment implements ra
{
    public Cursor Y;
    public kh Z;
    public Handler a;
    public boolean aa;
    rc ab;
    public zg ac;
    protected za ad;
    protected View ae;
    public String af;
    public boolean ag;
    public boolean ah;
    protected boolean ai;
    protected boolean aj;
    lh ak;
    DialogInterface$OnCancelListener al;
    View$OnClickListener am;
    View$OnClickListener an;
    protected kz ao;
    private boolean ap;
    private boolean aq;
    private boolean ar;
    private int as;
    private boolean at;
    public int b;
    public Uri c;
    protected String d;
    protected String e;
    protected int f;
    protected String g;
    protected String h;
    protected int i;
    
    public AbstractEditorViewer() {
        this.a = new Handler();
        this.b = 0;
        this.aa = false;
        this.af = null;
        this.ah = false;
        this.ai = true;
        this.aj = false;
        this.ap = true;
        this.aq = false;
        this.ar = false;
        this.as = -1;
        this.at = false;
        this.ak = new mc(this);
        this.al = (DialogInterface$OnCancelListener)new mo(this);
        this.am = (View$OnClickListener)new mq(this);
        this.an = (View$OnClickListener)new mr(this);
        this.ao = new ms(this);
    }
    
    public static final AbstractEditorViewer a(final int n, final String s, final Uri uri, final String s2) {
        Fragment fragment = null;
        switch (n) {
            case 0: {
                fragment = new TextEditor();
                break;
            }
            case 16: {
                fragment = new ListEditor();
                break;
            }
        }
        if (fragment != null) {
            final Bundle bundle = new Bundle();
            bundle.putString("action", s);
            bundle.putParcelable("data", (Parcelable)uri);
            bundle.putString("viewFrom", s2);
            fragment.e(bundle);
        }
        return (AbstractEditorViewer)fragment;
    }
    
    protected static void a(final rc rc, final boolean b, final int n, final int n2, final int n3) {
        if (b) {
            rc.a(n, n2, n3);
        }
    }
    
    private boolean an() {
        return this.g != null && this.h != null && this.ai;
    }
    
    protected static void b(final rc rc, final boolean b, final int n, final int n2, final int n3) {
        if (b) {
            rc.a(n, n2, n3);
            return;
        }
        rc.c(n, n2, n3);
    }
    
    private void c(final rc rc) {
        final zg ac = this.ac;
        if (rc.c.size() == 0) {
            ac.f.setVisibility(8);
            return;
        }
        ac.f.setVisibility(0);
        ac.f.setOnClickListener(rc.i);
    }
    
    private boolean c(final boolean b) {
        final boolean an = this.an();
        boolean b2 = false;
        if (an) {
            final boolean aa = this.aa;
            b2 = false;
            if (!aa) {
                while (true) {
                    Label_0115: {
                        if (this.d.length() == 0 && this.e.length() == 0 && this.am()) {
                            break Label_0115;
                        }
                        int n;
                        if (!this.d.equals(this.ac())) {
                            n = 1;
                        }
                        else if (!this.e.equals(this.ad())) {
                            n = 1;
                        }
                        else {
                            if (!this.ah) {
                                break Label_0115;
                            }
                            n = 1;
                        }
                        if (n != 0) {
                            this.a(b);
                        }
                        else {
                            int n2;
                            if (this.f != this.Z.j) {
                                n2 = 1;
                            }
                            else {
                                n2 = 0;
                            }
                            b2 = false;
                            if (n2 == 0) {
                                return b2;
                            }
                            final int j = this.Z.j;
                            this.f = j;
                            final FragmentActivity c = super.C;
                            final Uri c2 = this.c;
                            final int m = this.Z.m;
                            final ContentValues contentValues = new ContentValues();
                            contentValues.put("color_index", j);
                            ((Context)c).getContentResolver().update(c2, contentValues, (String)null, (String[])null);
                            rq.a((Context)c, c2);
                            if (m == 16) {
                                rq.b((Context)c);
                            }
                        }
                        b2 = true;
                        return b2;
                    }
                    int n = 0;
                    continue;
                }
            }
        }
        return b2;
    }
    
    private void d(final boolean b) {
        if (!b && this.Z.b()) {
            this.ae.setVisibility(0);
            return;
        }
        this.ae.setVisibility(8);
    }
    
    public final void I() {
        final za ad = this.ad;
        final boolean b = this.b();
        int n;
        if (this.af != null) {
            n = 1;
        }
        else {
            n = 0;
        }
        final kh z = this.Z;
        final int c = z.c;
        final long i = z.i;
        final long g = z.g();
        z.f();
        final long h = z.h();
        final int m = z.m;
        final int n2 = z.n;
        final int h2 = gr.a(ad.a).h(z.j);
        ad.f.setVisibility(8);
        if (z.m != 0 && g == 0L) {
            ad.f.setVisibility(0);
            ad.f.setImageResource(2130837661);
        }
        ad.b.setText((CharSequence)gw.a(ad.a, i));
        if (c == 16) {
            ad.b.setText(2131230777);
            final Drawable drawable = ad.a.getResources().getDrawable(2130837577);
            drawable.setColorFilter(h2, PorterDuff$Mode.MULTIPLY);
            ad.c.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable)null, (Drawable)null, (Drawable)null);
            ad.c.setTypeface(Typeface.DEFAULT, 0);
            ad.c.setText((CharSequence)gs.b(ad.a, i));
        }
        else if (m == 32 && h != 0L) {
            ad.c.setTypeface(Typeface.DEFAULT, 0);
            if (g > System.currentTimeMillis()) {
                ad.c.setText((CharSequence)gs.b(ad.a, g));
            }
            else {
                ad.c.setText((CharSequence)gs.b(ad.a, h));
            }
            final Drawable drawable2 = ad.a.getResources().getDrawable(2130837580);
            drawable2.setColorFilter(h2, PorterDuff$Mode.MULTIPLY);
            ad.c.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable)null, (Drawable)null, (Drawable)null);
        }
        else if (m == 16 && h != 0L) {
            ad.c.setTypeface(Typeface.DEFAULT, 0);
            if (n2 == 144 && g != 0L) {
                ad.c.setText(2131230887);
            }
            else if (g > System.currentTimeMillis()) {
                ad.c.setText((CharSequence)gs.a(ad.a, g));
            }
            else {
                ad.c.setText((CharSequence)gs.a(ad.a, h));
            }
            final Drawable drawable3 = ad.a.getResources().getDrawable(2130837575);
            drawable3.setColorFilter(h2, PorterDuff$Mode.MULTIPLY);
            ad.c.setCompoundDrawablesWithIntrinsicBounds(drawable3, (Drawable)null, (Drawable)null, (Drawable)null);
        }
        else if (m == 128) {
            final Drawable drawable4 = ad.a.getResources().getDrawable(2130837579);
            drawable4.setColorFilter(h2, PorterDuff$Mode.MULTIPLY);
            ad.c.setCompoundDrawablesWithIntrinsicBounds(drawable4, (Drawable)null, (Drawable)null, (Drawable)null);
            ad.c.setTypeface(Typeface.DEFAULT, 0);
            ad.c.setText((CharSequence)gs.a(ad.a, i));
        }
        else {
            ad.c.setTypeface(Typeface.DEFAULT, 0);
            ad.c.setText((CharSequence)gs.b(ad.a, i));
            ad.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        if (b) {
            ad.b.setText(2131230846);
        }
        if (n2 != 0 && g != 0L) {
            ad.d.setVisibility(0);
        }
        else {
            ad.d.setVisibility(8);
        }
        if (n != 0) {
            ad.e.setVisibility(0);
            return;
        }
        ad.e.setVisibility(8);
    }
    
    protected final void J() {
        if (this.Y != null) {
            final Intent intent = new Intent((Context)super.C, (Class)ReminderSettings.class);
            intent.putExtra("_id", this.Z.a);
            intent.putExtra("folder_id", this.Z.b);
            intent.putExtra("reminder_type", this.Z.m);
            intent.putExtra("reminder_repeat", this.Z.n);
            intent.putExtra("reminder_base", this.Z.f());
            intent.putExtra("reminder_date", this.Z.g());
            intent.putExtra("reminder_repeat_ends", this.Z.i());
            this.aj = true;
            this.a(intent, 2);
        }
    }
    
    public final void K() {
        if (this.Y != null) {
            this.Y.close();
            this.Y = null;
            kg.a((Context)super.C, this.c, "EDITOR");
        }
    }
    
    public final void L() {
        if (this.Y != null && this.an() && !this.aa) {
            this.Y.close();
            this.Y = null;
            kg.d((Context)super.C, this.c);
        }
    }
    
    protected final void M() {
        if (this.Y != null) {
            this.Y.close();
            this.Y = null;
            final FragmentActivity c = super.C;
            final Uri c2 = this.c;
            ((Context)c).getContentResolver().delete(c2, (String)null, (String[])null);
            rq.a((Context)c, c2);
            gu.b((Context)c, System.currentTimeMillis());
        }
    }
    
    public final void N() {
        this.ah = true;
        this.af = null;
        this.I();
    }
    
    protected final void O() {
        if (!jq.a((Context)super.C)) {
            this.a(new Intent((Context)super.C, (Class)PasswordSetting.class), 1);
            return;
        }
        this.ag = true;
        this.d(100);
    }
    
    public final void P() {
        if (this.c(false)) {
            Toast.makeText((Context)super.C, 2131230908, 0).show();
            this.at = true;
        }
        this.g = null;
        this.h = null;
        this.i = 0;
        this.d = null;
        this.e = null;
        this.f = 0;
        if (this.Y != null) {
            this.Y.requery();
            return;
        }
        this.b(0);
    }
    
    public final void Q() {
        kg.b((Context)super.C, this.c);
        Toast.makeText((Context)super.C, 2131230835, 0).show();
        this.b(-1);
    }
    
    protected final void R() {
        kg.c((Context)super.C, this.c);
        Toast.makeText((Context)super.C, 2131230836, 0).show();
        this.b(-1);
    }
    
    public final boolean S() {
        if (!this.am()) {
            this.P();
            this.Y();
            return true;
        }
        if (this.b == 1) {
            this.L();
            this.b(0);
            return true;
        }
        if (this.b == 2) {
            this.M();
            this.b(0);
            return true;
        }
        return false;
    }
    
    public boolean T() {
        return true;
    }
    
    public boolean U() {
        return this.b();
    }
    
    public boolean V() {
        return this.b() && this.S();
    }
    
    protected final void W() {
        gw.a(super.C, this.ad(), this.ac());
    }
    
    public final void X() {
        if (this.Y == null) {
            this.ah();
            return;
        }
        if (this.Y.moveToFirst()) {
            this.Z.a(this.Y);
            if (this.ap) {
                final Bundle q = super.q;
                final String string = q.getString("action");
                String string2 = q.getString("viewFrom");
                if (string2 == null) {
                    string2 = "";
                }
                final HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("Folder", new StringBuilder().append(this.Z.b).toString());
                hashMap.put("Type", new StringBuilder().append(this.Z.f).toString());
                if ("android.intent.action.VIEW".equals(string)) {
                    int n;
                    if ((0x4000 & this.Z.d) == 0x0) {
                        n = 1;
                    }
                    else {
                        n = 0;
                    }
                    if (n == 0) {
                        hashMap.put("Type", "SAMPLE " + this.Z.f);
                    }
                    hashMap.put("Source", string2);
                    ColorNote.a((Context)super.C, "NOTE", "VIEW", hashMap);
                }
                else if ("android.intent.action.INSERT".equals(string)) {
                    ColorNote.a((Context)super.C, "NOTE", "INSERT", hashMap);
                }
                else {
                    "android.intent.action.EDIT".equals(string);
                }
                this.ap = false;
            }
            this.f(this.Z.j);
            this.ac.a(this.Z.g);
            this.I();
            if (this.Z.m == 32) {
                gu.a((Context)super.C, this.c);
            }
            if (Build$VERSION.SDK_INT >= 11) {
                if (this.Z.e()) {
                    super.C.getWindow().setFlags(8192, 8192);
                }
                else {
                    super.C.getWindow().clearFlags(8192);
                }
            }
            if (this.Z.e() && this.af == null) {
                if (!jq.a((Context)super.C)) {
                    this.a(new Intent((Context)super.C, (Class)PasswordSetting.class), 1);
                    this.b(-1);
                    return;
                }
                this.ai = false;
                this.ag = false;
                this.d(100);
                this.ae();
            }
            else {
                this.ai = true;
                final String a = this.Z.a((Context)super.C);
                this.a(a);
                if (this.g == null) {
                    this.d = a;
                    this.g = a;
                    final String g = this.Z.g;
                    this.e = g;
                    this.h = g;
                    final int j = this.Z.j;
                    this.f = j;
                    this.i = j;
                }
            }
            this.ag();
            this.d(false);
            this.af();
            return;
        }
        this.ah();
    }
    
    protected final void Y() {
        this.e(3);
        final zg ac = this.ac;
        ac.l = 2;
        ac.k = true;
        ac.c.setSelected(false);
        ac.c.setFocusable(false);
        ac.c.setFocusableInTouchMode(false);
        ac.c.setEnabled(true);
        ac.d.setImageResource(2130837568);
        ac.d.setEnabled(true);
        ac.d.setVisibility(0);
        ac.e.setVisibility(8);
        ac.b.setDescendantFocusability(393216);
        ac.b.requestFocus();
        ac.a();
        this.I();
        this.ag();
        this.d(false);
        this.aj();
    }
    
    public final String Z() {
        return "(" + gs.a((Context)super.C, System.currentTimeMillis()) + ")";
    }
    
    @Override
    public final void a(final int n, final int n2, final Intent intent) {
        if (n == 1 && n2 == -1) {
            this.O();
        }
    }
    
    @Override
    public final void a(final Context context) {
        if (this.l()) {
            final int c = gv.c(context);
            if (this.ab == null || this.ab.g != c) {
                if (this.ab != null) {
                    this.ab.c();
                }
                this.a(this.ab = new rc(this, c));
            }
        }
    }
    
    @Override
    public void a(final Bundle bundle) {
        super.a(bundle);
        this.a((Context)super.C);
        if ("WIDGET".equals(super.q.getString("viewFrom")) && super.C != null) {
            rt.b(super.C.getApplicationContext());
        }
        final Cursor i = ((EditorContainer)super.r).I();
        i.registerContentObserver((ContentObserver)new mw(this, new Handler(), i));
        i.registerDataSetObserver((DataSetObserver)new md(this));
        this.Y = i;
    }
    
    @Override
    public final void a(final Menu menu) {
        this.b(this.ab);
        this.ab.a(menu);
    }
    
    protected final void a(final View view) {
        this.ac = new zg(view.findViewById(2131624046));
        this.ae = view.findViewById(2131624047);
        this.ad = new za(view.findViewById(2131624048));
        final zg ac = this.ac;
        ac.h = new GestureDetector(ac.a, (GestureDetector$OnGestureListener)new mt(this));
        ac.c.setOnTouchListener((View$OnTouchListener)new zh(ac));
        this.ac.g.setOnClickListener((View$OnClickListener)new mu(this));
        view.findViewById(2131624064).setOnClickListener((View$OnClickListener)new mv(this));
    }
    
    public final void a(final Runnable runnable) {
        super.C.runOnUiThread(runnable);
    }
    
    protected abstract void a(final String p0);
    
    protected final void a(final String e, final String d, final int n, final int f, final int n2) {
        this.d = d;
        this.e = e;
        this.f = f;
        if (this.af != null) {
            final jz a = jz.a((Context)super.C);
            kg.a((Context)super.C, this.c, n, a.c(d), e, f, a.a, n2);
            return;
        }
        kg.a((Context)super.C, this.c, n, d, e, f, 0, n2);
    }
    
    protected abstract void a(final boolean p0);
    
    public final void a(final boolean b, final String obj) {
        if (!b) {
            this.e(1);
        }
        final zg ac = this.ac;
        final boolean ai = this.ai();
        final int j = this.Z.j;
        ac.l = 1;
        ac.k = false;
        if (ai) {
            ac.c.setSelected(true);
            ac.c.setFocusable(true);
            ac.c.setFocusableInTouchMode(true);
            ac.c.setEnabled(true);
        }
        else {
            ac.c.setEnabled(false);
            ac.c.setSelected(true);
        }
        final GradientDrawable imageDrawable = (GradientDrawable)ac.a.getResources().getDrawable(2130837530);
        imageDrawable.setColor(gr.a(ac.a).e(j));
        ac.e.setImageDrawable((Drawable)imageDrawable);
        ac.e.setVisibility(0);
        ac.d.setImageResource(2130837571);
        ac.d.setEnabled(true);
        ac.d.setVisibility(8);
        ac.b.setDescendantFocusability(262144);
        ac.a();
        this.I();
        this.ag();
        this.d(true);
        if (!this.ar && !b) {
            this.ar = true;
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("Folder", new StringBuilder().append(this.Z.b).toString());
            hashMap.put("Type", new StringBuilder().append(this.Z.f).toString());
            hashMap.put("FROM", String.valueOf(obj) + " " + this.Z.f);
            ColorNote.a((Context)super.C, "NOTE", "EDIT", hashMap);
        }
        this.ak();
    }
    
    @Override
    public final boolean a(final MenuItem menuItem) {
        return this.a(menuItem.getItemId(), null) || super.a(menuItem);
    }
    
    public final boolean aa() {
        return !this.aa && this.Z.c == 0 && this.Y != null;
    }
    
    @Override
    public final rc ab() {
        return this.ab;
    }
    
    protected abstract String ac();
    
    protected abstract String ad();
    
    protected abstract void ae();
    
    protected abstract void af();
    
    protected abstract void ag();
    
    protected abstract void ah();
    
    protected abstract boolean ai();
    
    protected abstract void aj();
    
    protected abstract void ak();
    
    public abstract void al();
    
    protected abstract boolean am();
    
    public final void b(final int n) {
        if (this.c != null) {
            ((EditorContainer)super.r).a(n, new Intent().setAction(this.c.toString()));
            return;
        }
        ((EditorContainer)super.r).b(n);
    }
    
    public final boolean b() {
        boolean b = true;
        if (this.b != (b ? 1 : 0) && this.b != 2) {
            b = false;
        }
        return b;
    }
    
    public DialogFragment c(final int n) {
        switch (n) {
            default: {
                return null;
            }
            case 112: {
                return new DialogFactory$DownloadColorDictDialogFragment();
            }
            case 103: {
                return DialogFactory.a(2131230796, 2131230913, (DialogInterface$OnClickListener)new mj(this));
            }
            case 102: {
                return DialogFactory.b(2131230736, 2131230921, (DialogInterface$OnClickListener)new mi(this));
            }
            case 106: {
                return DialogFactory.a(2131230797, 2131230922, (DialogInterface$OnClickListener)new mh(this));
            }
            case 104: {
                return DialogFactory.a(2131230798, 2131230914, (DialogInterface$OnClickListener)new mg(this));
            }
            case 105: {
                return DialogFactory.b(2131230816, 2131230920, (DialogInterface$OnClickListener)new mf(this));
            }
            case 107: {
                return DialogFactory.a(2131230821, 2131230927, (DialogInterface$OnClickListener)new mk(this));
            }
            case 108: {
                return DialogFactory.a(2131230821, 2131230928, (DialogInterface$OnClickListener)new ml(this));
            }
            case 101: {
                return new DialogFactory$ColorSelectorDialogFragment(this.Z.b, this.Z.j, this.ao);
            }
            case 100: {
                return new DialogFactory$EnterPasswordDialogFragment(this.ak, this.al);
            }
            case 109: {
                return DialogFactory.a(2131230807, 2131230932, (DialogInterface$OnClickListener)new mm(this));
            }
            case 110: {
                return new DialogFactory$ConfirmDialogFragment(0, 2131231060, 2131231061, false, (DialogInterface$OnClickListener)new mn(this));
            }
        }
    }
    
    @Override
    public final void c() {
        super.c();
        this.at = false;
    }
    
    @Override
    public final void d() {
        super.d();
        final boolean b = this.Y != null && this.c(false);
        if (this.aq || b) {
            Toast.makeText((Context)super.C, 2131230908, 0).show();
            this.at = true;
        }
        if (this.aj) {
            this.aj = false;
        }
        else {
            this.af = null;
        }
        this.as = -1;
        if (this.at && super.C != null) {
            rt.b(super.C.getApplicationContext());
        }
    }
    
    public void d(final int n) {
        this.a.post((Runnable)new mp(this, n));
    }
    
    @Override
    public void d(final Bundle bundle) {
        super.d(bundle);
        bundle.putInt("state", this.b);
        bundle.putString("uri", this.c.toString());
        bundle.putString("origNote", this.g);
        bundle.putString("origTitle", this.h);
        bundle.putInt("origColor", this.i);
        bundle.putString("savedNote", this.d);
        bundle.putString("savedTitle", this.e);
        bundle.putInt("savedColor", this.f);
    }
    
    protected final void e(final int b) {
        this.b = b;
        this.ab = null;
        this.a((Context)super.C);
        this.c(this.ab);
    }
    
    public abstract void f(final int p0);
    
    protected final void i(final Bundle bundle) {
        this.Z = new kh();
        if (bundle != null) {
            this.e(bundle.getInt("state"));
            this.c = Uri.parse(bundle.getString("uri"));
            this.g = bundle.getString("origNote");
            this.h = bundle.getString("origTitle");
            this.i = bundle.getInt("origColor");
            this.d = bundle.getString("savedNote");
            this.e = bundle.getString("savedTitle");
            this.f = bundle.getInt("savedColor");
        }
        else if (this.b != 0 && this.c != null && this.g != null && this.h != null && this.i != 0) {
            this.e(this.b);
        }
        else {
            final Bundle q = super.q;
            final String string = q.getString("action");
            this.c = (Uri)q.getParcelable("data");
            if ("android.intent.action.EDIT".equals(string)) {
                this.e(1);
            }
            else if ("android.intent.action.VIEW".equals(string)) {
                this.e(3);
            }
            else if ("android.intent.action.INSERT".equals(string)) {
                this.e(2);
            }
        }
        if (this.c == null) {
            ColorNote.a("Failed to insert new note into ");
            this.b(0);
            return;
        }
        if (this.c.getPath().startsWith("/tempnotes")) {
            this.aa = true;
        }
        switch (this.b) {
            default: {
                ColorNote.a("Unknown state, exiting");
                this.b(0);
            }
            case 2: {
                if (this.c != null) {
                    super.C.setResult(-1, new Intent().setAction(this.c.toString()));
                }
                this.a(true, "INIT");
            }
            case 1: {
                this.a(false, "INIT");
            }
            case 3: {
                this.X();
            }
        }
    }
    
    @Override
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.a((Context)super.C);
        this.c(this.ab);
        this.ac.a();
    }
    
    @Override
    public void v() {
        super.v();
        if (this.as > 0) {
            this.d(this.as);
            this.as = -1;
        }
    }
    
    @Override
    public void w() {
        super.w();
        if (this.ab != null) {
            this.ab.c();
        }
        this.aq = false;
        if (this.Y != null && Build$VERSION.SDK_INT < 11) {
            this.aq = this.c(true);
        }
    }
}
