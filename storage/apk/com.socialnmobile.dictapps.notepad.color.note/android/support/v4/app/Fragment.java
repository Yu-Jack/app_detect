// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import android.content.res.Resources;
import android.os.Parcelable;
import java.util.ArrayList;
import android.view.MenuItem;
import android.view.MenuInflater;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.view.Menu;
import android.content.res.Configuration;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.content.Context;
import android.util.SparseArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View$OnCreateContextMenuListener;
import android.content.ComponentCallbacks;

public class Fragment implements ComponentCallbacks, View$OnCreateContextMenuListener
{
    private static final bg a;
    public int A;
    public o B;
    public FragmentActivity C;
    public o D;
    public Fragment E;
    public int F;
    public int G;
    public String H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public ViewGroup Q;
    public View R;
    public View S;
    public boolean T;
    public boolean U;
    public x V;
    boolean W;
    boolean X;
    public int j;
    public View k;
    public int l;
    public Bundle m;
    public SparseArray n;
    public int o;
    public String p;
    public Bundle q;
    public Fragment r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;
    
    static {
        a = new bg();
    }
    
    public Fragment() {
        this.j = 0;
        this.o = -1;
        this.s = -1;
        this.N = true;
        this.U = true;
    }
    
    public static Fragment a(final Context context, final String s) {
        return a(context, s, null);
    }
    
    public static Fragment a(final Context context, final String s, final Bundle q) {
        try {
            Class<?> loadClass = (Class<?>)Fragment.a.get(s);
            if (loadClass == null) {
                loadClass = context.getClassLoader().loadClass(s);
                Fragment.a.put(s, loadClass);
            }
            final Fragment fragment = (Fragment)loadClass.newInstance();
            if (q != null) {
                q.setClassLoader(fragment.getClass().getClassLoader());
                fragment.q = q;
            }
            return fragment;
        }
        catch (ClassNotFoundException ex) {
            throw new f("Unable to instantiate fragment " + s + ": make sure class name exists, is public, and has an empty constructor that is public", ex);
        }
        catch (InstantiationException ex2) {
            throw new f("Unable to instantiate fragment " + s + ": make sure class name exists, is public, and has an empty constructor that is public", ex2);
        }
        catch (IllegalAccessException ex3) {
            throw new f("Unable to instantiate fragment " + s + ": make sure class name exists, is public, and has an empty constructor that is public", ex3);
        }
    }
    
    static boolean b(final Context context, final String name) {
        try {
            Class<?> loadClass = (Class<?>)Fragment.a.get(name);
            if (loadClass == null) {
                loadClass = context.getClassLoader().loadClass(name);
                Fragment.a.put(name, loadClass);
            }
            return Fragment.class.isAssignableFrom(loadClass);
        }
        catch (ClassNotFoundException ex) {
            return false;
        }
    }
    
    public static void n() {
    }
    
    public static Animation s() {
        return null;
    }
    
    public static void t() {
    }
    
    public static void z() {
    }
    
    public final void A() {
        if (this.D != null) {
            this.D.i();
            this.D.f();
        }
        this.O = false;
        this.c();
        if (!this.O) {
            throw new aa("Fragment " + this + " did not call through to super.onStart()");
        }
        if (this.D != null) {
            this.D.l();
        }
        if (this.V != null) {
            this.V.g();
        }
    }
    
    public final void B() {
        if (this.D != null) {
            this.D.i();
            this.D.f();
        }
        this.O = false;
        this.v();
        if (!this.O) {
            throw new aa("Fragment " + this + " did not call through to super.onResume()");
        }
        if (this.D != null) {
            this.D.m();
            this.D.f();
        }
    }
    
    public final void C() {
        this.onLowMemory();
        if (this.D != null) {
            this.D.s();
        }
    }
    
    public final void D() {
        if (this.D != null) {
            this.D.n();
        }
        this.O = false;
        this.w();
        if (!this.O) {
            throw new aa("Fragment " + this + " did not call through to super.onPause()");
        }
    }
    
    public final void E() {
        if (this.D != null) {
            this.D.o();
        }
        this.O = false;
        this.d();
        if (!this.O) {
            throw new aa("Fragment " + this + " did not call through to super.onStop()");
        }
    }
    
    public final void F() {
        if (this.D != null) {
            this.D.p();
        }
        if (this.W) {
            this.W = false;
            if (!this.X) {
                this.X = true;
                this.V = this.C.a(this.p, this.W, false);
            }
            if (this.V != null) {
                if (this.C.h) {
                    this.V.d();
                    return;
                }
                this.V.c();
            }
        }
    }
    
    public final void G() {
        if (this.D != null) {
            this.D.q();
        }
        this.O = false;
        this.e();
        if (!this.O) {
            throw new aa("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        if (this.V != null) {
            this.V.f();
        }
    }
    
    public final void H() {
        if (this.D != null) {
            this.D.r();
        }
        this.O = false;
        this.x();
        if (!this.O) {
            throw new aa("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }
    
    public View a(final LayoutInflater layoutInflater, final Bundle bundle) {
        return null;
    }
    
    public final String a(final int n) {
        return this.i().getString(n);
    }
    
    public void a(final int n, final int n2, final Intent intent) {
    }
    
    public final void a(final int o, final Fragment fragment) {
        this.o = o;
        if (fragment != null) {
            this.p = fragment.p + ":" + this.o;
            return;
        }
        this.p = "android:fragment:" + this.o;
    }
    
    public void a(final Activity activity) {
        this.O = true;
    }
    
    public final void a(final Intent intent) {
        if (this.C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.C.a(this, intent, -1);
    }
    
    public final void a(final Intent intent, final int n) {
        if (this.C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.C.a(this, intent, n);
    }
    
    public final void a(final Configuration configuration) {
        this.onConfigurationChanged(configuration);
        if (this.D != null) {
            this.D.a(configuration);
        }
    }
    
    public void a(final Bundle bundle) {
        this.O = true;
    }
    
    public final void a(final Fragment$SavedState fragment$SavedState) {
        if (this.o >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        Bundle a;
        if (fragment$SavedState != null && fragment$SavedState.a != null) {
            a = fragment$SavedState.a;
        }
        else {
            a = null;
        }
        this.m = a;
    }
    
    public final void a(final Fragment r) {
        this.r = r;
        this.t = 0;
    }
    
    public void a(final Menu menu) {
    }
    
    public final void a(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.print(s);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.F));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.G));
        printWriter.print(" mTag=");
        printWriter.println(this.H);
        printWriter.print(s);
        printWriter.print("mState=");
        printWriter.print(this.j);
        printWriter.print(" mIndex=");
        printWriter.print(this.o);
        printWriter.print(" mWho=");
        printWriter.print(this.p);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.A);
        printWriter.print(s);
        printWriter.print("mAdded=");
        printWriter.print(this.u);
        printWriter.print(" mRemoving=");
        printWriter.print(this.v);
        printWriter.print(" mResumed=");
        printWriter.print(this.w);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.x);
        printWriter.print(" mInLayout=");
        printWriter.println(this.y);
        printWriter.print(s);
        printWriter.print("mHidden=");
        printWriter.print(this.I);
        printWriter.print(" mDetached=");
        printWriter.print(this.J);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.N);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.M);
        printWriter.print(s);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.K);
        printWriter.print(" mRetaining=");
        printWriter.print(this.L);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.U);
        if (this.B != null) {
            printWriter.print(s);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.B);
        }
        if (this.C != null) {
            printWriter.print(s);
            printWriter.print("mActivity=");
            printWriter.println(this.C);
        }
        if (this.E != null) {
            printWriter.print(s);
            printWriter.print("mParentFragment=");
            printWriter.println(this.E);
        }
        if (this.q != null) {
            printWriter.print(s);
            printWriter.print("mArguments=");
            printWriter.println(this.q);
        }
        if (this.m != null) {
            printWriter.print(s);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.m);
        }
        if (this.n != null) {
            printWriter.print(s);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.n);
        }
        if (this.r != null) {
            printWriter.print(s);
            printWriter.print("mTarget=");
            printWriter.print(this.r);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.t);
        }
        if (this.P != 0) {
            printWriter.print(s);
            printWriter.print("mNextAnim=");
            printWriter.println(this.P);
        }
        if (this.Q != null) {
            printWriter.print(s);
            printWriter.print("mContainer=");
            printWriter.println(this.Q);
        }
        if (this.R != null) {
            printWriter.print(s);
            printWriter.print("mView=");
            printWriter.println(this.R);
        }
        if (this.S != null) {
            printWriter.print(s);
            printWriter.print("mInnerView=");
            printWriter.println(this.R);
        }
        if (this.k != null) {
            printWriter.print(s);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.k);
            printWriter.print(s);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.l);
        }
        if (this.V != null) {
            printWriter.print(s);
            printWriter.println("Loader Manager:");
            this.V.a(s + "  ", fileDescriptor, printWriter, array);
        }
        if (this.D != null) {
            printWriter.print(s);
            printWriter.println("Child " + this.D + ":");
            this.D.a(s + "  ", fileDescriptor, printWriter, array);
        }
    }
    
    public final boolean a(final Menu menu, final MenuInflater menuInflater) {
        final boolean i = this.I;
        boolean b = false;
        if (!i) {
            final boolean m = this.M;
            b = false;
            if (m) {
                final boolean n = this.N;
                b = false;
                if (n) {
                    b = true;
                }
            }
            if (this.D != null) {
                b |= this.D.a(menu, menuInflater);
            }
        }
        return b;
    }
    
    public boolean a(final MenuItem menuItem) {
        return false;
    }
    
    public LayoutInflater b(final Bundle bundle) {
        return this.C.getLayoutInflater();
    }
    
    public final View b(final LayoutInflater layoutInflater, final Bundle bundle) {
        if (this.D != null) {
            this.D.i();
        }
        return this.a(layoutInflater, bundle);
    }
    
    public final void b(final boolean n) {
        if (this.N != n) {
            this.N = n;
            if (this.M && this.l() && !this.I) {
                this.C.b();
            }
        }
    }
    
    public final boolean b(final Menu menu) {
        final boolean i = this.I;
        boolean b = false;
        if (!i) {
            final boolean m = this.M;
            b = false;
            if (m) {
                final boolean n = this.N;
                b = false;
                if (n) {
                    b = true;
                    this.a(menu);
                }
            }
            if (this.D != null) {
                b |= this.D.a(menu);
            }
        }
        return b;
    }
    
    public boolean b(final MenuItem menuItem) {
        return false;
    }
    
    public void b_() {
        this.O = true;
    }
    
    public void c() {
        this.O = true;
        if (!this.W) {
            this.W = true;
            if (!this.X) {
                this.X = true;
                this.V = this.C.a(this.p, this.W, false);
            }
            if (this.V != null) {
                this.V.b();
            }
        }
    }
    
    public void c(final Bundle bundle) {
        this.O = true;
    }
    
    public final void c(final Menu menu) {
        if (!this.I) {
            if (this.M) {
                final boolean n = this.N;
            }
            if (this.D != null) {
                this.D.b(menu);
            }
        }
    }
    
    public final boolean c(final MenuItem menuItem) {
        return !this.I && ((this.M && this.N && this.a(menuItem)) || (this.D != null && this.D.a(menuItem)));
    }
    
    public void d() {
        this.O = true;
    }
    
    public void d(final Bundle bundle) {
    }
    
    public final boolean d(final MenuItem menuItem) {
        return !this.I && (this.b(menuItem) || (this.D != null && this.D.b(menuItem)));
    }
    
    public void e() {
        this.O = true;
    }
    
    public final void e(final Bundle q) {
        if (this.o >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.q = q;
    }
    
    @Override
    public final boolean equals(final Object obj) {
        return super.equals(obj);
    }
    
    public final void f() {
        if (this.n != null) {
            this.S.restoreHierarchyState(this.n);
            this.n = null;
        }
        this.O = false;
        if (!(this.O = true)) {
            throw new aa("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }
    
    public final void f(final Bundle bundle) {
        if (this.D != null) {
            this.D.i();
        }
        this.O = false;
        this.a(bundle);
        if (!this.O) {
            throw new aa("Fragment " + this + " did not call through to super.onCreate()");
        }
        if (bundle != null) {
            final Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.D == null) {
                    (this.D = new o()).a(this.C, new e(this), this);
                }
                this.D.a(parcelable, null);
                this.D.j();
            }
        }
    }
    
    public final void g(final Bundle bundle) {
        if (this.D != null) {
            this.D.i();
        }
        this.O = false;
        this.c(bundle);
        if (!this.O) {
            throw new aa("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        if (this.D != null) {
            this.D.k();
        }
    }
    
    public final boolean g() {
        return this.A > 0;
    }
    
    public final FragmentActivity h() {
        return this.C;
    }
    
    public final void h(final Bundle bundle) {
        this.d(bundle);
        if (this.D != null) {
            final Parcelable h = this.D.h();
            if (h != null) {
                bundle.putParcelable("android:support:fragments", h);
            }
        }
    }
    
    @Override
    public final int hashCode() {
        return super.hashCode();
    }
    
    public final Resources i() {
        if (this.C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        return this.C.getResources();
    }
    
    public final CharSequence j() {
        return this.i().getText(2131230842);
    }
    
    public final m k() {
        return this.B;
    }
    
    public final boolean l() {
        return this.C != null && this.u;
    }
    
    public final boolean m() {
        return this.w;
    }
    
    public final void o() {
        if (this.E != null) {
            throw new IllegalStateException("Can't retain fragements that are nested in other fragments");
        }
        this.K = true;
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        this.O = true;
    }
    
    public void onCreateContextMenu(final ContextMenu contextMenu, final View view, final ContextMenu$ContextMenuInfo contextMenu$ContextMenuInfo) {
        this.C.onCreateContextMenu(contextMenu, view, contextMenu$ContextMenuInfo);
    }
    
    public void onLowMemory() {
        this.O = true;
    }
    
    public final void p() {
        if (!this.M) {
            this.M = true;
            if (this.l() && !this.I) {
                this.C.b();
            }
        }
    }
    
    public final v q() {
        if (this.V != null) {
            return this.V;
        }
        if (this.C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.X = true;
        return this.V = this.C.a(this.p, this.W, true);
    }
    
    public final void r() {
        this.O = true;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        ay.a(this, sb);
        if (this.o >= 0) {
            sb.append(" #");
            sb.append(this.o);
        }
        if (this.F != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.F));
        }
        if (this.H != null) {
            sb.append(" ");
            sb.append(this.H);
        }
        sb.append('}');
        return sb.toString();
    }
    
    public final View u() {
        return this.R;
    }
    
    public void v() {
        this.O = true;
    }
    
    public void w() {
        this.O = true;
    }
    
    public void x() {
        this.O = true;
        if (!this.X) {
            this.X = true;
            this.V = this.C.a(this.p, this.W, false);
        }
        if (this.V != null) {
            this.V.h();
        }
    }
    
    public final void y() {
        this.o = -1;
        this.p = null;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = 0;
        this.B = null;
        this.D = null;
        this.C = null;
        this.F = 0;
        this.G = 0;
        this.H = null;
        this.I = false;
        this.J = false;
        this.L = false;
        this.V = null;
        this.W = false;
        this.X = false;
    }
}
