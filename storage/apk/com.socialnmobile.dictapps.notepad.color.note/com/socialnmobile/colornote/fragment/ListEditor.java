// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import android.widget.Adapter;
import java.util.Locale;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView$AdapterContextMenuInfo;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import android.content.DialogInterface$OnClickListener;
import com.socialnmobile.colornote.dialog.DialogFactory;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;
import android.text.ClipboardManager;
import com.socialnmobile.colornote.ColorNote;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.view.View$OnCreateContextMenuListener;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo;
import android.app.Activity;
import android.widget.TextView$OnEditorActionListener;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;
import android.widget.ListAdapter;
import java.util.List;
import android.content.Context;
import android.widget.AdapterView$OnItemClickListener;
import android.view.View$OnClickListener;
import android.graphics.drawable.GradientDrawable;
import java.util.ArrayList;
import android.widget.TextView;
import com.socialnmobile.colornote.view.DragDropListView;
import android.widget.ListView;
import android.view.View;

public class ListEditor extends AbstractEditorViewer
{
    private View aA;
    private ListView aB;
    private DragDropListView aC;
    private TextView aD;
    private View aE;
    private View aF;
    private View aG;
    private ArrayList aH;
    private GradientDrawable aI;
    private int aJ;
    private int aK;
    private ze aL;
    private zf aM;
    public yt ap;
    public yr aq;
    public boolean ar;
    ListEditor$EditDialogFragment as;
    jx at;
    int au;
    View$OnClickListener av;
    View$OnClickListener aw;
    View$OnClickListener ax;
    AdapterView$OnItemClickListener ay;
    AdapterView$OnItemClickListener az;
    
    public ListEditor() {
        this.aK = -1;
        this.av = (View$OnClickListener)new nd(this);
        this.aw = (View$OnClickListener)new no(this);
        this.ax = (View$OnClickListener)new nv(this);
        this.ay = (AdapterView$OnItemClickListener)new nw(this);
        this.az = (AdapterView$OnItemClickListener)new nx(this);
        this.aL = new ny(this);
        this.aM = new oa(this);
    }
    
    private void a(final ArrayList list, final String s, final int n, final int n2) {
        final String a = yf.a(list);
        int n3;
        if (b(list)) {
            n3 = kg.a(this.Z.d, 16, 16);
        }
        else {
            n3 = kg.a(this.Z.d, 0, 16);
        }
        this.a(s, a, n3, n, n2);
    }
    
    private void an() {
        if (this.ap == null) {
            this.ap = new yt((Context)super.C, this.aH, this.Z.j, this.aa);
            this.aB.setAdapter((ListAdapter)this.ap);
        }
        this.ap.b(this.aJ);
        this.aq();
    }
    
    private void ao() {
        if (this.aq == null) {
            this.aq = new yr((Context)super.C, this.aH, this.Z.j, this.aw, this.ax, this.av);
            this.aC.setAdapter((ListAdapter)this.aq);
        }
        this.aq.b(this.aJ);
        this.aq();
    }
    
    private void ap() {
        this.a(new nh(this));
    }
    
    private void aq() {
        this.a(new nt(this));
    }
    
    private static boolean b(final ArrayList list) {
        if (list.size() == 0) {
            return false;
        }
        final Iterator<jx> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().a()) {
                return false;
            }
        }
        return true;
    }
    
    private void c(final ArrayList list) {
        if (!this.ar) {
            if (this.as != null) {
                this.a(list, this.as.I());
            }
            else {
                this.a(list);
            }
        }
        if (jp.o((Context)super.C)) {
            Collections.sort((List<Object>)list, new oj(this, (byte)0));
        }
        if (list == this.aH) {
            this.aq();
        }
    }
    
    private void c(final boolean b) {
        this.a(new ng(this, b));
    }
    
    @Override
    public final View a(final LayoutInflater layoutInflater, final Bundle bundle) {
        final View inflate = layoutInflater.inflate(2130903062, (ViewGroup)null);
        if (!jp.q((Context)super.C)) {
            jk.a(inflate);
        }
        this.aq = null;
        this.ap = null;
        this.aH = new ArrayList();
        this.aJ = jp.g((Context)super.C);
        this.a(inflate);
        this.aA = inflate.findViewById(2131623959);
        this.aB = (ListView)inflate.findViewById(2131624049);
        this.aC = (DragDropListView)inflate.findViewById(2131624050);
        this.aE = inflate.findViewById(2131624051);
        this.aD = (TextView)inflate.findViewById(2131624033);
        this.aF = layoutInflater.inflate(2130903082, (ViewGroup)null);
        this.aG = layoutInflater.inflate(2130903082, (ViewGroup)null);
        this.aC.addHeaderView(this.aF);
        this.aC.addFooterView(this.aG);
        this.aF.setTag((Object)new ys(null, this.aF, false));
        this.aG.setTag((Object)new ys(null, this.aG, false));
        this.aI = (GradientDrawable)this.i().getDrawable(2130837551).mutate();
        this.aB.setDivider((Drawable)this.aI);
        this.aC.setDivider((Drawable)this.aI);
        this.ac.a(this.am);
        this.ac.b(this.an);
        this.aB.setOnItemClickListener(this.ay);
        this.aC.setOnItemClickListener(this.az);
        this.aC.setDropListener(this.aL);
        this.aC.setRemoveListener(this.aM);
        this.ac.c.setOnEditorActionListener((TextView$OnEditorActionListener)new nj(this));
        this.i(bundle);
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
    protected final void a(final String s) {
        this.a(new nf(this, s));
    }
    
    public final void a(final ArrayList list) {
        if (this.aK < 0 || this.aK >= list.size()) {
            return;
        }
        this.a(new nr(this, list));
    }
    
    final void a(final ArrayList list, final String s) {
        if (this.aK < 0 || this.aK >= list.size()) {
            return;
        }
        this.a(new ns(this, s, list));
    }
    
    public final void a(final jx jx) {
        if (this.Z.c == 0) {
            jx.a(!jx.a());
            this.ag();
            if (b(this.aH) && gu.a(this.Z)) {
                this.d(109);
            }
        }
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
                        AbstractEditorViewer.b(rc, true, 2131624171, 2130837602, 2131230817);
                    }
                    else {
                        AbstractEditorViewer.b(rc, false, 2131624171, 2130837602, 2131230817);
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
        ArrayList ah;
        if (b) {
            ah = (ArrayList)this.aH.clone();
        }
        else {
            ah = this.aH;
        }
        this.c(ah);
        this.ah = false;
        this.a(ah, this.Z.g = this.ad(), this.Z.j, this.Z.m);
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
            case 2131624172: {
                this.ap();
                return false;
            }
            case 2131624173: {
                this.a(new ni(this));
                return false;
            }
            case 2131624174: {
                this.d(8);
                return false;
            }
            case 2131624175: {
                this.d(6);
                return false;
            }
            case 2131624164: {
                this.d(104);
                return false;
            }
            case 2131624176: {
                this.d(9);
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
            case 2131624171: {
                final FragmentActivity c = super.C;
                final TopBarSubMenuInfo topBarSubMenuInfo = new TopBarSubMenuInfo((Context)c, ((Context)c).getString(2131230817), this);
                topBarSubMenuInfo.a(2131624172, 2130837618, 2131230812);
                topBarSubMenuInfo.a(2131624173, 2130837616, 2131230813);
                topBarSubMenuInfo.a(2131624174, 2130837590, 2131230809);
                topBarSubMenuInfo.a(2131624175, 2130837620, 2131230811);
                topBarSubMenuInfo.a(2131624176, 2130837591, 2131230819);
                topBarSubMenuInfo.a(this, super.B, (View)this.ac.f, false);
                return false;
            }
        }
    }
    
    @Override
    protected final String ac() {
        final ArrayList list = (ArrayList)this.aH.clone();
        this.c(list);
        return yf.a(list);
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
        this.a(new ne(this));
    }
    
    @Override
    protected final void af() {
        final int c = this.Z.c;
        if (this.aa) {
            this.Y();
            this.ac.a(1);
            this.aB.setOnItemClickListener((AdapterView$OnItemClickListener)null);
            this.aB.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)this);
            this.aC.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)null);
        }
        else if (c == 16) {
            this.Y();
            this.ac.a(2);
            this.aB.setOnItemClickListener((AdapterView$OnItemClickListener)null);
            this.aB.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)this);
            this.aC.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)null);
        }
        else if (c == 32) {
            this.Y();
            this.ac.a(3);
            this.aE.setVisibility(0);
            this.aB.setOnItemClickListener((AdapterView$OnItemClickListener)null);
            this.aB.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)null);
            this.aC.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)null);
        }
        else if (c == 0) {
            if (this.b == 3) {
                this.Y();
                this.ac.a(4);
            }
            this.aB.setOnItemClickListener(this.ay);
            this.aB.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)this);
            this.aC.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)this);
        }
        if (this.b()) {
            this.ao();
        }
        else {
            this.an();
        }
        this.a.post((Runnable)new nu(this));
    }
    
    public final void ag() {
        final yc a = gr.a((Context)super.C);
        if (this.b()) {
            this.ac.a(1, a, this.Z.j);
            return;
        }
        if (b(this.aH) || (!this.ai && this.Z.a())) {
            this.ac.a(2, a, this.Z.j);
            return;
        }
        this.ac.a(3, a, this.Z.j);
    }
    
    @Override
    protected final void ah() {
        gu.a((Context)super.C, this.c);
        this.b = 4;
        this.f(8);
        this.aB.setVisibility(8);
        this.aC.setVisibility(8);
        this.aD.setVisibility(0);
        this.aD.setText(this.j());
        this.ad.a();
        this.ac.c();
    }
    
    @Override
    protected final boolean ai() {
        return true;
    }
    
    @Override
    protected final void aj() {
        this.aB.setVisibility(0);
        this.aC.setVisibility(8);
        this.aE.setVisibility(8);
        this.an();
        this.aB.setSelection(0);
    }
    
    @Override
    protected final void ak() {
        this.aB.setVisibility(8);
        this.aC.setVisibility(0);
        this.aE.setVisibility(8);
        this.ao();
        final View a = gw.a((AbsListView)this.aB);
        if (a == null) {
            this.aC.setSelection(0);
            return;
        }
        int positionForView = this.aB.getPositionForView(a);
        if (positionForView > 0) {
            ++positionForView;
        }
        this.aC.setSelection(positionForView);
    }
    
    protected final void al() {
        this.a(yf.b(this.g), this.h, this.i, this.Z.m);
        this.Y.requery();
        this.Y();
    }
    
    @Override
    protected final boolean am() {
        final int length = this.ac.b().length();
        return this.aH.size() == 0 && length == 0;
    }
    
    public final void b(final String s) {
        if (this.aK < 0 || this.aK >= this.aH.size()) {
            return;
        }
        this.a(new nn(this, s));
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
                final int c = this.Z.c;
            }
            else if (this.b == 2) {
                final Iterator<rf> iterator4 = (Iterator<rf>)rc.b(2131624092).iterator();
                while (iterator4.hasNext()) {
                    iterator4.next().a(gw.a((Context)super.C, this.Z.j));
                }
                final boolean i = this.af == null;
                final Iterator<rf> iterator5 = (Iterator<rf>)rc.b(2131624162).iterator();
                while (iterator5.hasNext()) {
                    iterator5.next().i = i;
                }
            }
            else if (this.b == 4) {
                return;
            }
            for (final rf rf : rc.b(2131624165)) {
                if (this.Z.e == 16) {
                    rf.i = false;
                }
                else {
                    rf.i = true;
                }
                if (this.Z.b == 16) {
                    rf.a(2130837605);
                    rf.c = 2131230786;
                }
            }
            final boolean h2 = this.Z.e == 16;
            final Iterator<rf> iterator7 = (Iterator<rf>)rc.b(2131624167).iterator();
            while (iterator7.hasNext()) {
                iterator7.next().h = !h2;
            }
            final Iterator iterator8 = rc.b(2131624168).iterator();
            while (iterator8.hasNext()) {
                iterator8.next().h = h2;
            }
        }
    }
    
    @Override
    public final boolean b(final MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            default: {
                return false;
            }
            case 2131624179: {
                ColorNote.a((Context)super.C, "CHECKLIST", "ITEM CLIPBOARD");
                ((ClipboardManager)super.C.getSystemService("clipboard")).setText((CharSequence)this.at.a);
                Toast.makeText((Context)super.C, 2131230849, 1).show();
                return true;
            }
            case 2131624178: {
                ColorNote.a((Context)super.C, "CHECKLIST", "WEB SEARCH");
                final FragmentActivity c = super.C;
                this.a(gw.f(this.at.a));
                return true;
            }
            case 2131624177: {
                ColorNote.a((Context)super.C, "CHECKLIST", "AMAZON SEARCH");
                final FragmentActivity c2 = super.C;
                this.a(gw.g(this.at.a));
                return true;
            }
            case 2131624032: {
                this.a(false, "ITEM MENU");
                this.g(this.au);
                return true;
            }
        }
    }
    
    final DialogFragment c(final int n) {
        switch (n) {
            default: {
                return super.c(n);
            }
            case 2: {
                final String a = this.aH.get(this.aK).a;
                this.aC.requestFocus();
                return ListEditor$EditDialogFragment.a(false, a, this);
            }
            case 3: {
                final String a2 = this.aH.get(this.aK).a;
                this.aC.requestFocus();
                return ListEditor$EditDialogFragment.a(true, a2, this);
            }
            case 9: {
                return DialogFactory.b(2131230819, 2131230919, (DialogInterface$OnClickListener)new nk(this));
            }
            case 8: {
                return DialogFactory.b(2131230809, 2131230916, (DialogInterface$OnClickListener)new nl(this));
            }
            case 6: {
                return DialogFactory.b(2131230811, 2131230915, (DialogInterface$OnClickListener)new nm(this));
            }
        }
    }
    
    public final void c(final String s) {
        if (this.aK < 0 || this.aK >= this.aH.size()) {
            return;
        }
        this.a(new np(this, s));
    }
    
    @Override
    public final void d(final int n) {
        if (n == 2 || n == 3) {
            if (super.w) {
                this.c(n).a(super.B, "list editor");
                super.B.b();
            }
            return;
        }
        super.d(n);
    }
    
    @Override
    public final void d(final Bundle bundle) {
        super.d(bundle);
    }
    
    protected final void f(final int n) {
        final yc a = gr.a((Context)super.C);
        this.Z.j = n;
        this.ac.b(n);
        this.aD.setBackgroundColor(a.b(n));
        this.aB.setBackgroundColor(a.b(n));
        this.aC.setBackgroundColor(a.b(n));
        this.aA.setBackgroundColor(a.b(n));
        this.ad.a(n);
        this.aI.setColor(a.d(n));
        this.aB.setBackgroundColor(a.b(n));
        this.aB.setCacheColorHint(a.b(n));
        this.aC.setBackgroundColor(a.b(n));
        this.aC.setCacheColorHint(0);
        this.aC.setColor(n);
        if (this.ap != null) {
            this.ap.a(n);
        }
        if (this.aq != null) {
            this.aq.a(n);
        }
        this.ag();
    }
    
    public final void g(final int ak) {
        this.aK = ak;
        this.d(2);
    }
    
    @Override
    public void onCreateContextMenu(final ContextMenu contextMenu, final View view, final ContextMenu$ContextMenuInfo contextMenu$ContextMenuInfo) {
        try {
            final AdapterView$AdapterContextMenuInfo adapterView$AdapterContextMenuInfo = (AdapterView$AdapterContextMenuInfo)contextMenu$ContextMenuInfo;
            final Adapter adapter = ((AdapterView)view).getAdapter();
            if (adapter != null && (view == this.aB || view == this.aC)) {
                final jx at = (jx)adapter.getItem(adapterView$AdapterContextMenuInfo.position);
                if (at != null) {
                    this.at = at;
                    this.au = (int)adapter.getItemId(adapterView$AdapterContextMenuInfo.position);
                    contextMenu.setHeaderTitle((CharSequence)at.a);
                    super.C.getMenuInflater().inflate(2131558406, (Menu)contextMenu);
                    if (Locale.getDefault() != null && Locale.getDefault().getCountry() != null && !Locale.getDefault().getCountry().equals(Locale.US.getCountry())) {
                        final MenuItem item = contextMenu.findItem(2131624177);
                        if (item != null) {
                            item.setVisible(false);
                        }
                    }
                    if (this.b() || this.au == -1) {
                        final MenuItem item2 = contextMenu.findItem(2131624032);
                        if (item2 != null) {
                            item2.setVisible(false);
                        }
                    }
                }
            }
        }
        catch (ClassCastException ex) {}
    }
    
    @Override
    public final void v() {
        super.v();
        this.aJ = jp.g((Context)super.C);
        ((TextView)this.aF.findViewById(2131624033)).setTextColor(gr.a((Context)super.C).g(this.Z.j));
        ((TextView)this.aG.findViewById(2131624033)).setTextColor(gr.a((Context)super.C).g(this.Z.j));
    }
}
