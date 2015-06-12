// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import android.content.res.Configuration;
import java.util.Iterator;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.widget.TextView$BufferType;
import android.text.method.LinkMovementMethod;
import android.os.Build$VERSION;
import com.socialnmobile.colornote.util.LinkText;
import android.app.Activity;
import android.widget.ListAdapter;
import android.widget.FilterQueryProvider;
import android.view.GestureDetector$OnDoubleTapListener;
import android.view.View$OnKeyListener;
import android.text.TextWatcher;
import android.widget.AdapterView$OnItemClickListener;
import android.view.View$OnFocusChangeListener;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.net.Uri;
import android.view.inputmethod.InputMethodManager;
import android.content.Intent;
import android.content.Context;
import android.widget.Filter$FilterListener;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.EditText;
import com.socialnmobile.colornote.view.LinedTextView;
import com.socialnmobile.colornote.view.LinedEditText;
import android.view.GestureDetector$SimpleOnGestureListener;
import android.os.Handler;
import android.widget.Toast;
import android.view.View;

public class TextEditor extends AbstractEditorViewer
{
    private View aA;
    private View aB;
    private boolean aC;
    private int aD;
    private int aE;
    private boolean aF;
    private boolean aG;
    private Toast aH;
    Handler ap;
    GestureDetector$SimpleOnGestureListener aq;
    GestureDetector$SimpleOnGestureListener ar;
    private View as;
    private LinedEditText at;
    private LinedTextView au;
    private EditText av;
    private ListView aw;
    private View ax;
    private View ay;
    private View az;
    
    public TextEditor() {
        this.ap = new Handler();
        this.aq = new pz(this);
        this.ar = new qi(this);
    }
    
    private void an() {
        if (jp.e((Context)super.C)) {
            gw.b(this.ay, gv.d((Context)super.C));
            gw.b(this.ax, gv.d((Context)super.C));
            gw.b(this.az, gv.d((Context)super.C));
        }
    }
    
    private String ao() {
        return gw.h(this.at.getText().toString());
    }
    
    @Override
    public final boolean T() {
        boolean b = true;
        if ((this.b == (b ? 1 : 0) || this.b == 2) && jp.e((Context)super.C)) {
            this.av.requestFocus();
            b = false;
        }
        return b;
    }
    
    @Override
    public final boolean U() {
        return this.aC || super.U();
    }
    
    @Override
    public final boolean V() {
        if (this.aC) {
            this.at.requestFocus();
            return true;
        }
        return super.V();
    }
    
    @Override
    public final View a(final LayoutInflater layoutInflater, final Bundle bundle) {
        final View inflate = layoutInflater.inflate(2130903067, (ViewGroup)null);
        if (!jp.q((Context)super.C)) {
            jk.a(inflate);
        }
        this.a(inflate);
        this.as = inflate.findViewById(2131623959);
        this.at = (LinedEditText)inflate.findViewById(2131624061);
        this.au = (LinedTextView)inflate.findViewById(2131624062);
        this.av = (EditText)inflate.findViewById(2131624057);
        this.aw = (ListView)inflate.findViewById(2131624063);
        this.ay = inflate.findViewById(2131624058);
        this.ax = inflate.findViewById(2131624059);
        this.az = inflate.findViewById(2131624060);
        this.aA = inflate.findViewById(2131624051);
        this.aB = inflate.findViewById(2131624056);
        this.av.setOnClickListener((View$OnClickListener)new ql(this));
        this.av.setOnFocusChangeListener((View$OnFocusChangeListener)new qm(this));
        this.at.setOnWordChangedListener(new qn(this));
        this.aw.setOnItemClickListener((AdapterView$OnItemClickListener)new qo(this));
        this.ax.setOnClickListener((View$OnClickListener)new qp(this));
        this.az.setOnClickListener((View$OnClickListener)new qa(this));
        this.av.addTextChangedListener((TextWatcher)new qb(this));
        this.at.addTextChangedListener((TextWatcher)new qc(this));
        this.ac.c.addTextChangedListener((TextWatcher)new qd(this));
        this.ay.setOnClickListener((View$OnClickListener)new qe(this));
        this.av.setOnKeyListener((View$OnKeyListener)new qf(this));
        this.ac.a(this.am);
        this.ac.b(this.an);
        this.au.setOnDoubleTapListener((GestureDetector$OnDoubleTapListener)this.aq);
        this.at.setOnDoubleTapListener((GestureDetector$OnDoubleTapListener)this.ar);
        this.aC = false;
        this.aF = false;
        this.at.requestFocus();
        this.i(bundle);
        final qj adapter = new qj(this, (Context)super.C, new String[] { "suggest_text_1" }, new int[] { 16908308 });
        ((CursorAdapter)adapter).setFilterQueryProvider((FilterQueryProvider)new qk(this));
        this.aw.setAdapter((ListAdapter)adapter);
        this.aE = 0;
        this.aD = 0;
        return inflate;
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
    protected final void a(final String textKeepState) {
        if (this.at.getText().length() == 0) {
            this.at.setTextKeepState((CharSequence)textKeepState);
            this.at.setSelection(this.at.getText().length());
        }
        else {
            this.at.setTextKeepState((CharSequence)textKeepState);
        }
        final SpannableString a = LinkText.a((Context)super.C, this.aa, textKeepState);
        if (a != null) {
            if (Build$VERSION.SDK_INT < 11) {
                this.au.setMovementMethod(LinkMovementMethod.getInstance());
            }
            this.au.setAutoLinkMask(0);
            this.au.setTextKeepState((CharSequence)a, TextView$BufferType.SPANNABLE);
            this.au.setAutoLinkMask(15);
            return;
        }
        this.au.setTextKeepState((CharSequence)textKeepState);
    }
    
    @Override
    public final void a(final rc rc) {
        final int g = rc.g;
        final boolean b = g != 1 && g != 3 && (g != 2 || true);
        if (this.aa) {
            AbstractEditorViewer.a(rc, b, 2131624186, 2130837611, 2131230736);
        }
        else {
            if (this.b == 1) {
                AbstractEditorViewer.a(rc, b, 2131624092, 2130837525, 2131230803);
                if (b) {
                    AbstractEditorViewer.b(rc, true, 2131624162, 2130837603, 2131230815);
                    AbstractEditorViewer.b(rc, true, 2131624163, 2130837621, 2131230816);
                    AbstractEditorViewer.b(rc, true, 2131624164, 2130837611, 2131230798);
                    AbstractEditorViewer.b(rc, true, 2131624165, 2130837610, 2131230807);
                    AbstractEditorViewer.b(rc, true, 2131624166, 2130837614, 2131230801);
                }
                else {
                    AbstractEditorViewer.b(rc, false, 2131624164, 2130837611, 2131230798);
                    AbstractEditorViewer.b(rc, false, 2131624162, 2130837603, 2131230815);
                    AbstractEditorViewer.b(rc, false, 2131624163, 2130837621, 2131230816);
                    AbstractEditorViewer.b(rc, false, 2131624166, 2130837614, 2131230801);
                    AbstractEditorViewer.b(rc, false, 2131624165, 2130837610, 2131230807);
                }
                AbstractEditorViewer.b(rc, b, 2131624167, 2130837589, 2131230821);
                AbstractEditorViewer.b(rc, b, 2131624168, 2130837619, 2131230822);
                AbstractEditorViewer.b(rc, b, 2131624169, 2130837595, 2131230796);
                return;
            }
            if (this.b == 3) {
                if (this.Z.c == 0) {
                    AbstractEditorViewer.a(rc, b, 2131624032, 2130837598, 2131230795);
                    if (b) {
                        AbstractEditorViewer.b(rc, true, 2131624166, 2130837614, 2131230801);
                        AbstractEditorViewer.b(rc, true, 2131624193, 2130837590, 2131230808);
                    }
                    else {
                        AbstractEditorViewer.b(rc, false, 2131624193, 2130837590, 2131230808);
                        AbstractEditorViewer.b(rc, false, 2131624166, 2130837614, 2131230801);
                    }
                    AbstractEditorViewer.b(rc, b, 2131624165, 2130837610, 2131230807);
                    AbstractEditorViewer.b(rc, b, 2131624167, 2130837589, 2131230821);
                    AbstractEditorViewer.b(rc, b, 2131624168, 2130837619, 2131230822);
                    AbstractEditorViewer.b(rc, b, 2131624169, 2130837595, 2131230796);
                    return;
                }
                if (this.Z.c == 16) {
                    AbstractEditorViewer.a(rc, b, 2131624186, 2130837611, 2131230736);
                    AbstractEditorViewer.b(rc, b, 2131624187, 2130837596, 2131230797);
                    return;
                }
                final int c = this.Z.c;
            }
            else if (this.b == 2) {
                AbstractEditorViewer.a(rc, b, 2131624092, 2130837525, 2131230803);
                if (b) {
                    AbstractEditorViewer.b(rc, true, 2131624162, 2130837603, 2131230815);
                    AbstractEditorViewer.b(rc, true, 2131624165, 2130837610, 2131230807);
                    AbstractEditorViewer.b(rc, true, 2131624166, 2130837614, 2131230801);
                    AbstractEditorViewer.b(rc, true, 2131624170, 2130837595, 2131230799);
                    return;
                }
                AbstractEditorViewer.b(rc, false, 2131624170, 2130837595, 2131230799);
                AbstractEditorViewer.b(rc, false, 2131624166, 2130837614, 2131230801);
                AbstractEditorViewer.b(rc, false, 2131624162, 2130837603, 2131230815);
                AbstractEditorViewer.b(rc, false, 2131624165, 2130837610, 2131230807);
            }
            else if (this.b == 4) {
                return;
            }
        }
    }
    
    @Override
    protected final void a(final boolean b) {
        this.ah = false;
        this.a(this.Z.g = this.ad(), this.ac(), kg.a(this.Z.d, 0, 16), this.Z.j, this.Z.m);
    }
    
    public final boolean a(final int n, final String s) {
        switch (n) {
            default: {
                return false;
            }
            case 2131624032: {
                this.a(false, "MENU");
                return false;
            }
            case 2131624169: {
                this.d(103);
                return false;
            }
            case 2131624187: {
                this.d(106);
                return false;
            }
            case 2131624186: {
                this.d(102);
                return false;
            }
            case 2131624164: {
                this.d(104);
                return false;
            }
            case 2131624170: {
                this.M();
                this.b(0);
                return false;
            }
            case 2131624166: {
                this.W();
                return false;
            }
            case 2131624092: {
                this.d(101);
                return false;
            }
            case 2131624165: {
                this.J();
                return false;
            }
            case 2131624162: {
                this.O();
                return false;
            }
            case 2131624163: {
                this.d(105);
                return false;
            }
            case 2131624193: {
                if (this.Z.a()) {
                    kg.a((Context)super.C, this.c, this.Z.d, 0, 16);
                }
                else {
                    kg.a((Context)super.C, this.c, this.Z.d, 16, 16);
                    if (gu.a(this.Z)) {
                        this.d(109);
                    }
                }
                this.Y.requery();
                return false;
            }
            case 2131624167: {
                if (this.Z.g() != 0L) {
                    this.d(108);
                    return false;
                }
                this.d(107);
                return false;
            }
            case 2131624168: {
                this.R();
                return false;
            }
        }
    }
    
    @Override
    protected final String ac() {
        return this.at.getText().toString();
    }
    
    @Override
    protected final String ad() {
        String s = this.ac.b();
        if (s.equals("")) {
            s = this.Z();
        }
        return s;
    }
    
    @Override
    protected final void ae() {
        this.at.setText((CharSequence)"");
        this.au.setText((CharSequence)"");
        this.au.setDoNotRestore(true);
        this.at.setDoNotRestore(true);
    }
    
    @Override
    protected final void af() {
        final int c = this.Z.c;
        if (this.aa) {
            this.Y();
            this.ac.a(1);
        }
        else if (c == 16) {
            this.Y();
            this.ac.a(2);
        }
        else if (c == 32) {
            this.Y();
            this.ac.a(3);
            this.aA.setVisibility(0);
        }
        else if (c == 0 && this.b == 3) {
            this.Y();
            this.ac.a(4);
        }
        this.ap.post((Runnable)new qh(this));
    }
    
    @Override
    protected final void ag() {
        final yc a = gr.a((Context)super.C);
        if (this.b()) {
            this.ac.a(1, a, this.Z.j);
            this.au.setTextColor(a.g(this.Z.j));
            this.at.setTextColor(a.g(this.Z.j));
            return;
        }
        if (this.Z.a()) {
            this.ac.a(2, a, this.Z.j);
            this.au.setTextColor(gw.a(102, a.g(this.Z.j)));
            this.at.setTextColor(a.g(this.Z.j));
            return;
        }
        this.ac.a(3, a, this.Z.j);
        this.au.setTextColor(a.g(this.Z.j));
        this.at.setTextColor(a.g(this.Z.j));
    }
    
    @Override
    protected final void ah() {
        gu.a((Context)super.C, this.c);
        this.e(4);
        this.f(8);
        this.at.setText(this.j());
        this.au.setText(this.j());
        this.ad.a();
        this.ac.c();
        this.Y = null;
    }
    
    @Override
    protected final boolean ai() {
        final FragmentActivity c = super.C;
        return jp.a((Context)c, "pref_edit_title", ((Context)c).getResources().getBoolean(2131296258));
    }
    
    @Override
    protected final void aj() {
        this.aB.setVisibility(8);
        this.au.setVisibility(0);
        this.at.setVisibility(8);
        this.aA.setVisibility(8);
        final InputMethodManager inputMethodManager = (InputMethodManager)super.C.getSystemService("input_method");
        inputMethodManager.hideSoftInputFromWindow(this.at.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromInputMethod(this.at.getWindowToken(), 0);
    }
    
    @Override
    protected final void ak() {
        if (jp.e((Context)super.C)) {
            this.aB.setVisibility(0);
        }
        this.au.setVisibility(8);
        this.at.setVisibility(0);
        this.at.requestFocus();
        this.aA.setVisibility(8);
        if (this.ao().equals(this.ac.b())) {
            this.aF = true;
        }
        final InputMethodManager inputMethodManager = (InputMethodManager)super.C.getSystemService("input_method");
        inputMethodManager.showSoftInput((View)this.at, 0);
        inputMethodManager.showSoftInputFromInputMethod(this.at.getWindowToken(), 0);
    }
    
    protected final void al() {
        this.a(this.h, this.g, this.Z.d, this.i, this.Z.m);
        this.Y.requery();
        this.Y();
    }
    
    @Override
    protected final boolean am() {
        final int length = this.at.getText().toString().length();
        final int length2 = this.ac.b().length();
        return length == 0 && length2 == 0;
    }
    
    @Override
    public final void b(final rc rc) {
        if (!this.aa) {
            if (this.b == 1) {
                final Iterator<rf> iterator = (Iterator<rf>)rc.b(2131624092).iterator();
                while (iterator.hasNext()) {
                    iterator.next().a(gw.a((Context)super.C, this.Z.j));
                }
                final boolean h = this.af == null;
                final Iterator<rf> iterator2 = (Iterator<rf>)rc.b(2131624162).iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().h = h;
                }
                final Iterator iterator3 = rc.b(2131624163).iterator();
                while (iterator3.hasNext()) {
                    iterator3.next().h = !h;
                }
            }
            else if (this.b == 3) {
                if (this.Z.c == 0) {
                    for (final rf rf : rc.b(2131624193)) {
                        if (this.Z.a()) {
                            rf.a(2130837620);
                            rf.c = 2131230810;
                        }
                        else {
                            rf.a(2130837590);
                            rf.c = 2131230808;
                        }
                    }
                }
            }
            else if (this.b == 2) {
                final Iterator<rf> iterator5 = (Iterator<rf>)rc.b(2131624092).iterator();
                while (iterator5.hasNext()) {
                    iterator5.next().a(gw.a((Context)super.C, this.Z.j));
                }
                final boolean i = this.af == null;
                final Iterator<rf> iterator6 = (Iterator<rf>)rc.b(2131624162).iterator();
                while (iterator6.hasNext()) {
                    iterator6.next().i = i;
                }
            }
            else if (this.b == 4) {
                return;
            }
            for (final rf rf2 : rc.b(2131624165)) {
                if (this.Z.e == 16) {
                    rf2.i = false;
                }
                else {
                    rf2.i = true;
                }
                if (this.Z.b == 16) {
                    rf2.a(2130837605);
                    rf2.c = 2131230786;
                }
            }
            final boolean h2 = this.Z.e == 16;
            final Iterator<rf> iterator8 = (Iterator<rf>)rc.b(2131624167).iterator();
            while (iterator8.hasNext()) {
                iterator8.next().h = !h2;
            }
            final Iterator iterator9 = rc.b(2131624168).iterator();
            while (iterator9.hasNext()) {
                iterator9.next().h = h2;
            }
        }
    }
    
    protected final void f(final int color) {
        this.as.setBackgroundColor(gr.a((Context)super.C).b(color));
        this.Z.j = color;
        this.ac.b(color);
        this.at.setColor(color);
        this.au.setColor(color);
        this.ad.a(color);
        this.ag();
    }
    
    @Override
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.an();
    }
    
    @Override
    public final void v() {
        super.v();
        final FragmentActivity c = super.C;
        this.aG = (!jn.b() && jp.a((Context)c, "pref_use_auto_select", ((Context)c).getResources().getBoolean(2131296257)));
        final int g = jp.g((Context)super.C);
        this.at.setTextSize((float)g);
        this.au.setTextSize((float)g);
        if (jp.e((Context)super.C)) {
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setClassName("com.socialnmobile.colordict", "com.socialnmobile.colordict.activity.Main");
            if (gw.a((Context)super.C, intent)) {
                this.ax.setVisibility(0);
                this.az.setVisibility(8);
            }
            else {
                this.ax.setVisibility(8);
                this.az.setVisibility(0);
            }
            this.an();
        }
    }
    
    @Override
    public final void w() {
        super.w();
        if (this.aH != null) {
            this.aH.cancel();
        }
    }
}
