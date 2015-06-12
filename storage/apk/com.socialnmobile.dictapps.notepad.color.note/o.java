import android.support.v4.app.BackStackState;
import android.os.Looper;
import android.os.Handler;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.Menu;
import java.util.Arrays;
import android.view.View;
import android.view.animation.Animation$AnimationListener;
import android.view.ViewGroup;
import android.app.Activity;
import android.support.v4.app.FragmentState;
import android.support.v4.app.FragmentManagerState;
import android.os.Parcelable;
import android.content.res.Configuration;
import android.support.v4.app.Fragment$SavedState;
import java.io.FileDescriptor;
import java.io.Writer;
import java.io.PrintWriter;
import android.util.Log;
import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.os.Build$VERSION;
import android.util.SparseArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import java.util.ArrayList;
import android.view.animation.Interpolator;

// 
// Decompiled by Procyon v0.5.29
// 

public final class o extends m
{
    static final Interpolator A;
    static final Interpolator B;
    static final Interpolator C;
    public static boolean a;
    static final boolean b;
    static final Interpolator z;
    ArrayList c;
    Runnable[] d;
    boolean e;
    public ArrayList f;
    ArrayList g;
    ArrayList h;
    ArrayList i;
    ArrayList j;
    ArrayList k;
    ArrayList l;
    ArrayList m;
    int n;
    FragmentActivity o;
    l p;
    Fragment q;
    boolean r;
    boolean s;
    boolean t;
    String u;
    boolean v;
    Bundle w;
    SparseArray x;
    Runnable y;
    
    static {
        o.a = false;
        final int sdk_INT = Build$VERSION.SDK_INT;
        boolean b2 = false;
        if (sdk_INT >= 11) {
            b2 = true;
        }
        b = b2;
        z = (Interpolator)new DecelerateInterpolator(2.5f);
        A = (Interpolator)new DecelerateInterpolator(1.5f);
        B = (Interpolator)new AccelerateInterpolator(2.5f);
        C = (Interpolator)new AccelerateInterpolator(1.5f);
    }
    
    public o() {
        this.n = 0;
        this.w = null;
        this.x = null;
        this.y = new p(this);
    }
    
    private static Animation a(final float n, final float n2) {
        final AlphaAnimation alphaAnimation = new AlphaAnimation(n, n2);
        alphaAnimation.setInterpolator(o.A);
        alphaAnimation.setDuration(220L);
        return (Animation)alphaAnimation;
    }
    
    private static Animation a(final float n, final float n2, final float n3, final float n4) {
        final AnimationSet set = new AnimationSet(false);
        final ScaleAnimation scaleAnimation = new ScaleAnimation(n, n2, n, n2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(o.z);
        scaleAnimation.setDuration(220L);
        set.addAnimation((Animation)scaleAnimation);
        final AlphaAnimation alphaAnimation = new AlphaAnimation(n3, n4);
        alphaAnimation.setInterpolator(o.A);
        alphaAnimation.setDuration(220L);
        set.addAnimation((Animation)alphaAnimation);
        return (Animation)set;
    }
    
    private Animation a(final Fragment fragment, final int n, final boolean b, int windowAnimations) {
        final int p4 = fragment.P;
        Fragment.s();
        if (fragment.P != 0) {
            final Animation loadAnimation = AnimationUtils.loadAnimation((Context)this.o, fragment.P);
            if (loadAnimation != null) {
                return loadAnimation;
            }
        }
        if (n == 0) {
            return null;
        }
        int n2 = -1;
        switch (n) {
            case 4097: {
                if (b) {
                    n2 = 1;
                    break;
                }
                n2 = 2;
                break;
            }
            case 8194: {
                if (b) {
                    n2 = 3;
                    break;
                }
                n2 = 4;
                break;
            }
            case 4099: {
                if (b) {
                    n2 = 5;
                    break;
                }
                n2 = 6;
                break;
            }
        }
        if (n2 < 0) {
            return null;
        }
        switch (n2) {
            default: {
                if (windowAnimations == 0 && this.o.getWindow() != null) {
                    windowAnimations = this.o.getWindow().getAttributes().windowAnimations;
                }
                if (windowAnimations == 0) {
                    return null;
                }
                return null;
            }
            case 1: {
                final FragmentActivity o = this.o;
                return a(1.125f, 1.0f, 0.0f, 1.0f);
            }
            case 2: {
                final FragmentActivity o2 = this.o;
                return a(1.0f, 0.975f, 1.0f, 0.0f);
            }
            case 3: {
                final FragmentActivity o3 = this.o;
                return a(0.975f, 1.0f, 0.0f, 1.0f);
            }
            case 4: {
                final FragmentActivity o4 = this.o;
                return a(1.0f, 1.075f, 1.0f, 0.0f);
            }
            case 5: {
                final FragmentActivity o5 = this.o;
                return a(0.0f, 1.0f);
            }
            case 6: {
                final FragmentActivity o6 = this.o;
                return a(1.0f, 0.0f);
            }
        }
    }
    
    private void a(final int i, final b b) {
        synchronized (this) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            int j = this.k.size();
            if (i < j) {
                if (o.a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + b);
                }
                this.k.set(i, b);
            }
            else {
                while (j < i) {
                    this.k.add(null);
                    if (this.l == null) {
                        this.l = new ArrayList();
                    }
                    if (o.a) {
                        Log.v("FragmentManager", "Adding available back stack index " + j);
                    }
                    this.l.add(j);
                    ++j;
                }
                if (o.a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + b);
                }
                this.k.add(b);
            }
        }
    }
    
    private void a(final RuntimeException ex) {
        Log.e("FragmentManager", ex.getMessage());
        Log.e("FragmentManager", "Activity state:");
        final PrintWriter printWriter = new PrintWriter(new az("FragmentManager"));
        while (true) {
            Label_0076: {
                if (this.o == null) {
                    break Label_0076;
                }
                try {
                    this.o.dump("  ", null, printWriter, new String[0]);
                    throw ex;
                }
                catch (Exception ex2) {
                    Log.e("FragmentManager", "Failed dumping state", (Throwable)ex2);
                    throw ex;
                }
                try {
                    this.a("  ", null, printWriter, new String[0]);
                    continue;
                }
                catch (Exception ex3) {
                    Log.e("FragmentManager", "Failed dumping state", (Throwable)ex3);
                    continue;
                }
            }
            continue;
        }
    }
    
    private void c(final Fragment fragment) {
        if (fragment.S != null) {
            if (this.x == null) {
                this.x = new SparseArray();
            }
            else {
                this.x.clear();
            }
            fragment.S.saveHierarchyState(this.x);
            if (this.x.size() > 0) {
                fragment.n = this.x;
                this.x = null;
            }
        }
    }
    
    public static int d(final int n) {
        switch (n) {
            default: {
                return 0;
            }
            case 4097: {
                return 8194;
            }
            case 8194: {
                return 4097;
            }
            case 4099: {
                return 4099;
            }
        }
    }
    
    private Bundle d(final Fragment fragment) {
        if (this.w == null) {
            this.w = new Bundle();
        }
        fragment.h(this.w);
        Bundle w;
        if (!this.w.isEmpty()) {
            w = this.w;
            this.w = null;
        }
        else {
            w = null;
        }
        if (fragment.R != null) {
            this.c(fragment);
        }
        if (fragment.n != null) {
            if (w == null) {
                w = new Bundle();
            }
            w.putSparseParcelableArray("android:view_state", fragment.n);
        }
        if (!fragment.U) {
            if (w == null) {
                w = new Bundle();
            }
            w.putBoolean("android:user_visible_hint", fragment.U);
        }
        return w;
    }
    
    private void e(final int n) {
        this.a(n, 0, 0, false);
    }
    
    private void t() {
        if (this.s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.u);
        }
    }
    
    private void u() {
        if (this.m != null) {
            for (int i = 0; i < this.m.size(); ++i) {
                ((n)this.m.get(i)).a();
            }
        }
    }
    
    public final int a(final b b) {
        synchronized (this) {
            if (this.l == null || this.l.size() <= 0) {
                if (this.k == null) {
                    this.k = new ArrayList();
                }
                final int size = this.k.size();
                if (o.a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + b);
                }
                this.k.add(b);
                return size;
            }
            final int intValue = this.l.remove(-1 + this.l.size());
            if (o.a) {
                Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + b);
            }
            this.k.set(intValue, b);
            return intValue;
        }
    }
    
    @Override
    public final Fragment$SavedState a(final Fragment obj) {
        if (obj.o < 0) {
            this.a(new IllegalStateException("Fragment " + obj + " is not currently in the FragmentManager"));
        }
        final int j = obj.j;
        Fragment$SavedState fragment$SavedState = null;
        if (j > 0) {
            final Bundle d = this.d(obj);
            fragment$SavedState = null;
            if (d != null) {
                fragment$SavedState = new Fragment$SavedState(d);
            }
        }
        return fragment$SavedState;
    }
    
    @Override
    public final Fragment a(final int n) {
        if (this.g != null) {
            for (int i = -1 + this.g.size(); i >= 0; --i) {
                final Fragment fragment = this.g.get(i);
                if (fragment != null && fragment.F == n) {
                    return fragment;
                }
            }
        }
        Label_0056: {
            break Label_0056;
        }
        if (this.f != null) {
            for (int j = -1 + this.f.size(); j >= 0; --j) {
                final Fragment fragment = (Fragment)this.f.get(j);
                if (fragment != null && fragment.F == n) {
                    return fragment;
                }
            }
        }
        return null;
    }
    
    @Override
    public final Fragment a(final Bundle bundle, final String s) {
        final int int1 = bundle.getInt(s, -1);
        Fragment fragment;
        if (int1 == -1) {
            fragment = null;
        }
        else {
            if (int1 >= this.f.size()) {
                this.a(new IllegalStateException("Fragment no longer exists for key " + s + ": index " + int1));
            }
            fragment = this.f.get(int1);
            if (fragment == null) {
                this.a(new IllegalStateException("Fragment no longer exists for key " + s + ": index " + int1));
                return fragment;
            }
        }
        return fragment;
    }
    
    @Override
    public final Fragment a(final String s) {
        if (this.g != null && s != null) {
            for (int i = -1 + this.g.size(); i >= 0; --i) {
                final Fragment fragment = this.g.get(i);
                if (fragment != null && s.equals(fragment.H)) {
                    return fragment;
                }
            }
        }
        Label_0063: {
            break Label_0063;
        }
        if (this.f != null && s != null) {
            for (int j = -1 + this.f.size(); j >= 0; --j) {
                final Fragment fragment = (Fragment)this.f.get(j);
                if (fragment != null && s.equals(fragment.H)) {
                    return fragment;
                }
            }
        }
        return null;
    }
    
    @Override
    public final u a() {
        return new b(this);
    }
    
    final void a(final int n, final int n2, final int n3, final boolean b) {
        if (this.o == null && n != 0) {
            throw new IllegalStateException("No activity");
        }
        if (b || this.n != n) {
            this.n = n;
            if (this.f != null) {
                int i = 0;
                boolean b2 = false;
            Label_0116_Outer:
                while (i < this.f.size()) {
                    final Fragment fragment = this.f.get(i);
                    while (true) {
                        Label_0170: {
                            if (fragment == null) {
                                break Label_0170;
                            }
                            this.a(fragment, n, n2, n3, false);
                            if (fragment.V == null) {
                                break Label_0170;
                            }
                            final boolean b3 = b2 | fragment.V.a();
                            ++i;
                            b2 = b3;
                            continue Label_0116_Outer;
                        }
                        final boolean b3 = b2;
                        continue;
                    }
                }
                if (!b2) {
                    this.e();
                }
                if (this.r && this.o != null && this.n == 5) {
                    this.o.b();
                    this.r = false;
                }
            }
        }
    }
    
    public final void a(final Configuration configuration) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); ++i) {
                final Fragment fragment = this.g.get(i);
                if (fragment != null) {
                    fragment.a(configuration);
                }
            }
        }
    }
    
    @Override
    public final void a(final Bundle bundle, final String s, final Fragment obj) {
        if (obj.o < 0) {
            this.a(new IllegalStateException("Fragment " + obj + " is not currently in the FragmentManager"));
        }
        bundle.putInt(s, obj.o);
    }
    
    public final void a(final Parcelable parcelable, final ArrayList list) {
        if (parcelable != null) {
            final FragmentManagerState fragmentManagerState = (FragmentManagerState)parcelable;
            if (fragmentManagerState.a != null) {
                if (list != null) {
                    for (int i = 0; i < list.size(); ++i) {
                        final Fragment fragment = list.get(i);
                        if (o.a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        final FragmentState fragmentState = fragmentManagerState.a[fragment.o];
                        fragmentState.k = fragment;
                        fragment.n = null;
                        fragment.A = 0;
                        fragment.y = false;
                        fragment.u = false;
                        fragment.r = null;
                        if (fragmentState.j != null) {
                            fragmentState.j.setClassLoader(this.o.getClassLoader());
                            fragment.n = fragmentState.j.getSparseParcelableArray("android:view_state");
                        }
                    }
                }
                this.f = new ArrayList(fragmentManagerState.a.length);
                if (this.h != null) {
                    this.h.clear();
                }
                for (int j = 0; j < fragmentManagerState.a.length; ++j) {
                    final FragmentState fragmentState2 = fragmentManagerState.a[j];
                    if (fragmentState2 != null) {
                        final Fragment a = fragmentState2.a(this.o, this.q);
                        if (o.a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + j + ": " + a);
                        }
                        this.f.add(a);
                        fragmentState2.k = null;
                    }
                    else {
                        this.f.add(null);
                        if (this.h == null) {
                            this.h = new ArrayList();
                        }
                        if (o.a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + j);
                        }
                        this.h.add(j);
                    }
                }
                if (list != null) {
                    for (int k = 0; k < list.size(); ++k) {
                        final Fragment obj = list.get(k);
                        if (obj.s >= 0) {
                            if (obj.s < this.f.size()) {
                                obj.r = (Fragment)this.f.get(obj.s);
                            }
                            else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + obj + " target no longer exists: " + obj.s);
                                obj.r = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.b != null) {
                    this.g = new ArrayList(fragmentManagerState.b.length);
                    for (int l = 0; l < fragmentManagerState.b.length; ++l) {
                        final Fragment e = this.f.get(fragmentManagerState.b[l]);
                        if (e == null) {
                            this.a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[l]));
                        }
                        e.u = true;
                        if (o.a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + l + ": " + e);
                        }
                        if (this.g.contains(e)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.g.add(e);
                    }
                }
                else {
                    this.g = null;
                }
                if (fragmentManagerState.c == null) {
                    this.i = null;
                    return;
                }
                this.i = new ArrayList(fragmentManagerState.c.length);
                for (int m = 0; m < fragmentManagerState.c.length; ++m) {
                    final b a2 = fragmentManagerState.c[m].a(this);
                    if (o.a) {
                        Log.v("FragmentManager", "restoreAllState: back stack #" + m + " (index " + a2.o + "): " + a2);
                        a2.a("  ", new PrintWriter(new az("FragmentManager")), false);
                    }
                    this.i.add(a2);
                    if (a2.o >= 0) {
                        this.a(a2.o, a2);
                    }
                }
            }
        }
    }
    
    public final void a(final Fragment fragment, final int n, final int n2) {
        if (o.a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.A);
        }
        boolean b;
        if (!fragment.g()) {
            b = true;
        }
        else {
            b = false;
        }
        if (!fragment.J || b) {
            if (this.g != null) {
                this.g.remove(fragment);
            }
            if (fragment.M && fragment.N) {
                this.r = true;
            }
            fragment.u = false;
            fragment.v = true;
            int n3;
            if (b) {
                n3 = 0;
            }
            else {
                n3 = 1;
            }
            this.a(fragment, n3, n, n2, false);
        }
    }
    
    final void a(final Fragment obj, int j, final int n, final int n2, final boolean b) {
        if ((!obj.u || obj.J) && j > 1) {
            j = 1;
        }
        if (obj.v && j > obj.j) {
            j = obj.j;
        }
        if (obj.T && obj.j < 4 && j > 3) {
            j = 3;
        }
        if (obj.j < j) {
            if (obj.x && !obj.y) {
                return;
            }
            if (obj.k != null) {
                obj.k = null;
                this.a(obj, obj.l, 0, 0, true);
            }
            Label_0493: {
                switch (obj.j) {
                    case 0: {
                        if (o.a) {
                            Log.v("FragmentManager", "moveto CREATED: " + obj);
                        }
                        if (obj.m != null) {
                            obj.n = obj.m.getSparseParcelableArray("android:view_state");
                            obj.r = this.a(obj.m, "android:target_state");
                            if (obj.r != null) {
                                obj.t = obj.m.getInt("android:target_req_state", 0);
                            }
                            if (!(obj.U = obj.m.getBoolean("android:user_visible_hint", true))) {
                                obj.T = true;
                                if (j > 3) {
                                    j = 3;
                                }
                            }
                        }
                        obj.C = this.o;
                        obj.E = this.q;
                        o b2;
                        if (this.q != null) {
                            b2 = this.q.D;
                        }
                        else {
                            b2 = this.o.b;
                        }
                        obj.B = b2;
                        obj.O = false;
                        obj.a(this.o);
                        if (!obj.O) {
                            throw new aa("Fragment " + obj + " did not call through to super.onAttach()");
                        }
                        if (obj.E == null) {
                            final FragmentActivity o = this.o;
                            FragmentActivity.c();
                        }
                        if (!obj.L) {
                            obj.f(obj.m);
                        }
                        obj.L = false;
                        if (!obj.x) {
                            break Label_0493;
                        }
                        obj.R = obj.b(obj.b(obj.m), obj.m);
                        if (obj.R != null) {
                            obj.S = obj.R;
                            obj.R = (View)z.a(obj.R);
                            if (obj.I) {
                                obj.R.setVisibility(8);
                            }
                            final View r = obj.R;
                            final Bundle m = obj.m;
                            Fragment.t();
                            break Label_0493;
                        }
                        obj.S = null;
                        break Label_0493;
                    }
                    case 1: {
                        if (j > 1) {
                            if (o.a) {
                                Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + obj);
                            }
                            if (!obj.x) {
                                ViewGroup q;
                                if (obj.G != 0) {
                                    q = (ViewGroup)this.p.a(obj.G);
                                    if (q == null && !obj.z) {
                                        this.a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(obj.G) + " (" + obj.i().getResourceName(obj.G) + ") for fragment " + obj));
                                    }
                                }
                                else {
                                    q = null;
                                }
                                obj.Q = q;
                                obj.R = obj.b(obj.b(obj.m), obj.m);
                                if (obj.R != null) {
                                    obj.S = obj.R;
                                    obj.R = (View)z.a(obj.R);
                                    if (q != null) {
                                        final Animation a = this.a(obj, n, true, n2);
                                        if (a != null) {
                                            obj.R.startAnimation(a);
                                        }
                                        q.addView(obj.R);
                                    }
                                    if (obj.I) {
                                        obj.R.setVisibility(8);
                                    }
                                    final View r2 = obj.R;
                                    final Bundle i = obj.m;
                                    Fragment.t();
                                }
                                else {
                                    obj.S = null;
                                }
                            }
                            obj.g(obj.m);
                            if (obj.R != null) {
                                final Bundle k = obj.m;
                                obj.f();
                            }
                            obj.m = null;
                        }
                    }
                    case 2:
                    case 3: {
                        if (j > 3) {
                            if (o.a) {
                                Log.v("FragmentManager", "moveto STARTED: " + obj);
                            }
                            obj.A();
                        }
                    }
                    case 4: {
                        if (j > 4) {
                            if (o.a) {
                                Log.v("FragmentManager", "moveto RESUMED: " + obj);
                            }
                            obj.w = true;
                            obj.B();
                            obj.m = null;
                            obj.n = null;
                            break;
                        }
                        break;
                    }
                }
            }
        }
        else if (obj.j > j) {
            switch (obj.j) {
                case 3: {
                    if (j < 3) {
                        if (o.a) {
                            Log.v("FragmentManager", "movefrom STOPPED: " + obj);
                        }
                        obj.F();
                    }
                }
                case 2: {
                    if (j < 2) {
                        if (o.a) {
                            Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + obj);
                        }
                        if (obj.R != null && !this.o.isFinishing() && obj.n == null) {
                            this.c(obj);
                        }
                        obj.G();
                        if (obj.R != null && obj.Q != null) {
                            Animation a2;
                            if (this.n > 0 && !this.t) {
                                a2 = this.a(obj, n, false, n2);
                            }
                            else {
                                a2 = null;
                            }
                            if (a2 != null) {
                                obj.k = obj.R;
                                obj.l = j;
                                a2.setAnimationListener((Animation$AnimationListener)new r(this, obj));
                                obj.R.startAnimation(a2);
                            }
                            obj.Q.removeView(obj.R);
                        }
                        obj.Q = null;
                        obj.R = null;
                        obj.S = null;
                    }
                }
                case 1: {
                    if (j > 0) {
                        break;
                    }
                    if (this.t && obj.k != null) {
                        final View l = obj.k;
                        obj.k = null;
                        l.clearAnimation();
                    }
                    if (obj.k != null) {
                        obj.l = j;
                        j = 1;
                        break;
                    }
                    if (o.a) {
                        Log.v("FragmentManager", "movefrom CREATED: " + obj);
                    }
                    if (!obj.L) {
                        obj.H();
                    }
                    obj.O = false;
                    obj.b_();
                    if (!obj.O) {
                        throw new aa("Fragment " + obj + " did not call through to super.onDetach()");
                    }
                    if (b) {
                        break;
                    }
                    if (obj.L) {
                        obj.C = null;
                        obj.E = null;
                        obj.B = null;
                        obj.D = null;
                        break;
                    }
                    if (obj.o >= 0) {
                        if (o.a) {
                            Log.v("FragmentManager", "Freeing fragment index " + obj);
                        }
                        this.f.set(obj.o, null);
                        if (this.h == null) {
                            this.h = new ArrayList();
                        }
                        this.h.add(obj.o);
                        this.o.a(obj.p);
                        obj.y();
                        break;
                    }
                    break;
                }
                case 5: {
                    if (j < 5) {
                        if (o.a) {
                            Log.v("FragmentManager", "movefrom RESUMED: " + obj);
                        }
                        obj.D();
                        obj.w = false;
                    }
                }
                case 4: {
                    if (j < 4) {
                        if (o.a) {
                            Log.v("FragmentManager", "movefrom STARTED: " + obj);
                        }
                        obj.E();
                    }
                }
            }
        }
        obj.j = j;
    }
    
    public final void a(final Fragment e, final boolean b) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        if (o.a) {
            Log.v("FragmentManager", "add: " + e);
        }
        if (e.o < 0) {
            if (this.h == null || this.h.size() <= 0) {
                if (this.f == null) {
                    this.f = new ArrayList();
                }
                e.a(this.f.size(), this.q);
                this.f.add(e);
            }
            else {
                e.a(this.h.remove(-1 + this.h.size()), this.q);
                this.f.set(e.o, e);
            }
            if (o.a) {
                Log.v("FragmentManager", "Allocated fragment index " + e);
            }
        }
        if (!e.J) {
            if (this.g.contains(e)) {
                throw new IllegalStateException("Fragment already added: " + e);
            }
            this.g.add(e);
            e.u = true;
            e.v = false;
            if (e.M && e.N) {
                this.r = true;
            }
            if (b) {
                this.b(e);
            }
        }
    }
    
    public final void a(final FragmentActivity o, final l p3, final Fragment q) {
        if (this.o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.o = o;
        this.p = p3;
        this.q = q;
    }
    
    public final void a(final Runnable e, final boolean b) {
        if (!b) {
            this.t();
        }
        synchronized (this) {
            if (this.t || this.o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(e);
        if (this.c.size() == 1) {
            this.o.a.removeCallbacks(this.y);
            this.o.a.post(this.y);
        }
    }
    // monitorexit(this)
    
    public final void a(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        int i = 0;
        final String string = s + "    ";
        if (this.f != null) {
            final int size = this.f.size();
            if (size > 0) {
                printWriter.print(s);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (int j = 0; j < size; ++j) {
                    final Fragment x = this.f.get(j);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(j);
                    printWriter.print(": ");
                    printWriter.println(x);
                    if (x != null) {
                        x.a(string, fileDescriptor, printWriter, array);
                    }
                }
            }
        }
        if (this.g != null) {
            final int size2 = this.g.size();
            if (size2 > 0) {
                printWriter.print(s);
                printWriter.println("Added Fragments:");
                for (int k = 0; k < size2; ++k) {
                    final Fragment fragment = this.g.get(k);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(k);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.j != null) {
            final int size3 = this.j.size();
            if (size3 > 0) {
                printWriter.print(s);
                printWriter.println("Fragments Created Menus:");
                for (int l = 0; l < size3; ++l) {
                    final Fragment fragment2 = this.j.get(l);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(l);
                    printWriter.print(": ");
                    printWriter.println(fragment2.toString());
                }
            }
        }
        if (this.i != null) {
            final int size4 = this.i.size();
            if (size4 > 0) {
                printWriter.print(s);
                printWriter.println("Back Stack:");
                for (int n = 0; n < size4; ++n) {
                    final b b = this.i.get(n);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(n);
                    printWriter.print(": ");
                    printWriter.println(b.toString());
                    b.a(string, printWriter);
                }
            }
        }
        synchronized (this) {
            if (this.k != null) {
                final int size5 = this.k.size();
                if (size5 > 0) {
                    printWriter.print(s);
                    printWriter.println("Back Stack Indices:");
                    for (int n2 = 0; n2 < size5; ++n2) {
                        final b x2 = this.k.get(n2);
                        printWriter.print(s);
                        printWriter.print("  #");
                        printWriter.print(n2);
                        printWriter.print(": ");
                        printWriter.println(x2);
                    }
                }
            }
            if (this.l != null && this.l.size() > 0) {
                printWriter.print(s);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.l.toArray()));
            }
            // monitorexit(this)
            if (this.c != null) {
                final int size6 = this.c.size();
                if (size6 > 0) {
                    printWriter.print(s);
                    printWriter.println("Pending Actions:");
                    while (i < size6) {
                        final Runnable x3 = this.c.get(i);
                        printWriter.print(s);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(x3);
                        ++i;
                    }
                }
            }
        }
        printWriter.print(s);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(s);
        printWriter.print("  mActivity=");
        printWriter.println(this.o);
        printWriter.print(s);
        printWriter.print("  mContainer=");
        printWriter.println(this.p);
        if (this.q != null) {
            printWriter.print(s);
            printWriter.print("  mParent=");
            printWriter.println(this.q);
        }
        printWriter.print(s);
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.t);
        if (this.r) {
            printWriter.print(s);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.u != null) {
            printWriter.print(s);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.u);
        }
        if (this.h != null && this.h.size() > 0) {
            printWriter.print(s);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.h.toArray()));
        }
    }
    
    @Override
    public final void a(final n e) {
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(e);
    }
    
    final boolean a(final int n, final int n2) {
        if (this.i != null) {
            if (n < 0 && (n2 & 0x1) == 0x0) {
                final int index = -1 + this.i.size();
                if (index < 0) {
                    return false;
                }
                ((b)this.i.remove(index)).a(true);
            }
            else {
                int n3 = -1;
                if (n >= 0) {
                    int i;
                    for (i = -1 + this.i.size(); i >= 0; --i) {
                        final b b = this.i.get(i);
                        if (n >= 0 && n == b.o) {
                            break;
                        }
                    }
                    if (i < 0) {
                        return false;
                    }
                    if ((n2 & 0x1) != 0x0) {
                        --i;
                        while (i >= 0) {
                            final b b2 = this.i.get(i);
                            if (n < 0 || n != b2.o) {
                                break;
                            }
                            --i;
                        }
                    }
                    n3 = i;
                }
                if (n3 == -1 + this.i.size()) {
                    return false;
                }
                final ArrayList<b> list = new ArrayList<b>();
                for (int j = -1 + this.i.size(); j > n3; --j) {
                    list.add((b)this.i.remove(j));
                }
                for (int n4 = -1 + list.size(), k = 0; k <= n4; ++k) {
                    if (o.a) {
                        Log.v("FragmentManager", "Popping back stack state: " + list.get(k));
                    }
                    list.get(k).a(k == n4);
                }
            }
            this.u();
            return true;
        }
        return false;
    }
    
    public final boolean a(final Menu menu) {
        boolean b;
        if (this.g != null) {
            int i = 0;
            b = false;
            while (i < this.g.size()) {
                final Fragment fragment = this.g.get(i);
                if (fragment != null && fragment.b(menu)) {
                    b = true;
                }
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    public final boolean a(final Menu menu, final MenuInflater menuInflater) {
        ArrayList<Fragment> j = null;
        boolean b;
        if (this.g != null) {
            int i = 0;
            b = false;
            while (i < this.g.size()) {
                final Fragment e = this.g.get(i);
                if (e != null && e.a(menu, menuInflater)) {
                    b = true;
                    if (j == null) {
                        j = new ArrayList<Fragment>();
                    }
                    j.add(e);
                }
                final boolean b2 = b;
                ++i;
                b = b2;
            }
        }
        else {
            b = false;
        }
        final ArrayList k = this.j;
        int l = 0;
        if (k != null) {
            while (l < this.j.size()) {
                final Fragment o = this.j.get(l);
                if (j == null || !j.contains(o)) {
                    Fragment.z();
                }
                ++l;
            }
        }
        this.j = j;
        return b;
    }
    
    public final boolean a(final MenuItem menuItem) {
        final ArrayList g = this.g;
        boolean b = false;
        if (g != null) {
            int index = 0;
            while (true) {
                final int size = this.g.size();
                b = false;
                if (index >= size) {
                    break;
                }
                final Fragment fragment = this.g.get(index);
                if (fragment != null && fragment.c(menuItem)) {
                    b = true;
                    break;
                }
                ++index;
            }
        }
        return b;
    }
    
    @Override
    public final void b(final int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        this.a(new q(this, i), false);
    }
    
    public final void b(final Fragment fragment) {
        this.a(fragment, this.n, 0, 0, false);
    }
    
    public final void b(final Fragment obj, final int n, final int n2) {
        if (o.a) {
            Log.v("FragmentManager", "hide: " + obj);
        }
        if (!obj.I) {
            obj.I = true;
            if (obj.R != null) {
                final Animation a = this.a(obj, n, false, n2);
                if (a != null) {
                    obj.R.startAnimation(a);
                }
                obj.R.setVisibility(8);
            }
            if (obj.u && obj.M && obj.N) {
                this.r = true;
            }
            Fragment.n();
        }
    }
    
    public final void b(final Menu menu) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); ++i) {
                final Fragment fragment = this.g.get(i);
                if (fragment != null) {
                    fragment.c(menu);
                }
            }
        }
    }
    
    final void b(final b e) {
        if (this.i == null) {
            this.i = new ArrayList();
        }
        this.i.add(e);
        this.u();
    }
    
    @Override
    public final boolean b() {
        return this.f();
    }
    
    public final boolean b(final MenuItem menuItem) {
        final ArrayList g = this.g;
        boolean b = false;
        if (g != null) {
            int index = 0;
            while (true) {
                final int size = this.g.size();
                b = false;
                if (index >= size) {
                    break;
                }
                final Fragment fragment = this.g.get(index);
                if (fragment != null && fragment.d(menuItem)) {
                    b = true;
                    break;
                }
                ++index;
            }
        }
        return b;
    }
    
    public final void c(final int i) {
        synchronized (this) {
            this.k.set(i, null);
            if (this.l == null) {
                this.l = new ArrayList();
            }
            if (o.a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.l.add(i);
        }
    }
    
    public final void c(final Fragment obj, final int n, final int n2) {
        if (o.a) {
            Log.v("FragmentManager", "show: " + obj);
        }
        if (obj.I) {
            obj.I = false;
            if (obj.R != null) {
                final Animation a = this.a(obj, n, true, n2);
                if (a != null) {
                    obj.R.startAnimation(a);
                }
                obj.R.setVisibility(0);
            }
            if (obj.u && obj.M && obj.N) {
                this.r = true;
            }
            Fragment.n();
        }
    }
    
    @Override
    public final boolean c() {
        this.t();
        this.f();
        final Handler a = this.o.a;
        return this.a(-1, 0);
    }
    
    @Override
    public final int d() {
        if (this.i != null) {
            return this.i.size();
        }
        return 0;
    }
    
    public final void d(final Fragment o, final int n, final int n2) {
        if (o.a) {
            Log.v("FragmentManager", "detach: " + o);
        }
        if (!o.J) {
            o.J = true;
            if (o.u) {
                if (this.g != null) {
                    if (o.a) {
                        Log.v("FragmentManager", "remove from detach: " + o);
                    }
                    this.g.remove(o);
                }
                if (o.M && o.N) {
                    this.r = true;
                }
                this.a(o, 1, n, n2, o.u = false);
            }
        }
    }
    
    final void e() {
        if (this.f != null) {
            for (int i = 0; i < this.f.size(); ++i) {
                final Fragment fragment = this.f.get(i);
                if (fragment != null && fragment.T) {
                    if (this.e) {
                        this.v = true;
                    }
                    else {
                        fragment.T = false;
                        this.a(fragment, this.n, 0, 0, false);
                    }
                }
            }
        }
    }
    
    public final void e(final Fragment e, final int n, final int n2) {
        if (o.a) {
            Log.v("FragmentManager", "attach: " + e);
        }
        if (e.J) {
            e.J = false;
            if (!e.u) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                if (this.g.contains(e)) {
                    throw new IllegalStateException("Fragment already added: " + e);
                }
                if (o.a) {
                    Log.v("FragmentManager", "add from attach: " + e);
                }
                this.g.add(e);
                e.u = true;
                if (e.M && e.N) {
                    this.r = true;
                }
                this.a(e, this.n, n, n2, false);
            }
        }
    }
    
    public final boolean f() {
        if (this.e) {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        if (Looper.myLooper() != this.o.a.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of process");
        }
        boolean b = false;
        while (true) {
            boolean b2 = false;
            Label_0262: {
                synchronized (this) {
                    if (this.c == null || this.c.size() == 0) {
                        // monitorexit(this)
                        if (this.v) {
                            int i = 0;
                            b2 = false;
                            while (i < this.f.size()) {
                                final Fragment fragment = this.f.get(i);
                                if (fragment != null && fragment.V != null) {
                                    b2 |= fragment.V.a();
                                }
                                ++i;
                            }
                            break Label_0262;
                        }
                        break;
                    }
                    else {
                        final int size = this.c.size();
                        if (this.d == null || this.d.length < size) {
                            this.d = new Runnable[size];
                        }
                        this.c.toArray(this.d);
                        this.c.clear();
                        this.o.a.removeCallbacks(this.y);
                        // monitorexit(this)
                        this.e = true;
                        for (int j = 0; j < size; ++j) {
                            this.d[j].run();
                            this.d[j] = null;
                        }
                    }
                }
                this.e = false;
                b = true;
                continue;
            }
            if (!b2) {
                this.v = false;
                this.e();
                break;
            }
            break;
        }
        return b;
    }
    
    public final ArrayList g() {
        final ArrayList f = this.f;
        ArrayList<Fragment> list = null;
        if (f != null) {
            for (int i = 0; i < this.f.size(); ++i) {
                final Fragment fragment = this.f.get(i);
                if (fragment != null && fragment.K) {
                    if (list == null) {
                        list = new ArrayList<Fragment>();
                    }
                    list.add(fragment);
                    fragment.L = true;
                    int o;
                    if (fragment.r != null) {
                        o = fragment.r.o;
                    }
                    else {
                        o = -1;
                    }
                    fragment.s = o;
                    if (o.a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return list;
    }
    
    public final Parcelable h() {
        this.f();
        if (o.b) {
            this.s = true;
        }
        if (this.f != null && this.f.size() > 0) {
            final int size = this.f.size();
            final FragmentState[] a = new FragmentState[size];
            int i = 0;
            int n = 0;
            while (i < size) {
                final Fragment obj = this.f.get(i);
                int n2;
                if (obj != null) {
                    if (obj.o < 0) {
                        this.a(new IllegalStateException("Failure saving state: active " + obj + " has cleared index: " + obj.o));
                    }
                    final FragmentState fragmentState = new FragmentState(obj);
                    a[i] = fragmentState;
                    if (obj.j > 0 && fragmentState.j == null) {
                        fragmentState.j = this.d(obj);
                        if (obj.r != null) {
                            if (obj.r.o < 0) {
                                this.a(new IllegalStateException("Failure saving state: " + obj + " has target not in fragment manager: " + obj.r));
                            }
                            if (fragmentState.j == null) {
                                fragmentState.j = new Bundle();
                            }
                            this.a(fragmentState.j, "android:target_state", obj.r);
                            if (obj.t != 0) {
                                fragmentState.j.putInt("android:target_req_state", obj.t);
                            }
                        }
                    }
                    else {
                        fragmentState.j = obj.m;
                    }
                    if (o.a) {
                        Log.v("FragmentManager", "Saved state of " + obj + ": " + fragmentState.j);
                    }
                    n2 = 1;
                }
                else {
                    n2 = n;
                }
                ++i;
                n = n2;
            }
            if (n != 0) {
                int[] b = null;
                Label_0561: {
                    if (this.g != null) {
                        final int size2 = this.g.size();
                        if (size2 > 0) {
                            b = new int[size2];
                            for (int j = 0; j < size2; ++j) {
                                b[j] = ((Fragment)this.g.get(j)).o;
                                if (b[j] < 0) {
                                    this.a(new IllegalStateException("Failure saving state: active " + this.g.get(j) + " has cleared index: " + b[j]));
                                }
                                if (o.a) {
                                    Log.v("FragmentManager", "saveAllState: adding fragment #" + j + ": " + this.g.get(j));
                                }
                            }
                            break Label_0561;
                        }
                    }
                    b = null;
                }
                final ArrayList k = this.i;
                BackStackState[] c = null;
                if (k != null) {
                    final int size3 = this.i.size();
                    c = null;
                    if (size3 > 0) {
                        c = new BackStackState[size3];
                        for (int l = 0; l < size3; ++l) {
                            c[l] = new BackStackState((b)this.i.get(l));
                            if (o.a) {
                                Log.v("FragmentManager", "saveAllState: adding back stack #" + l + ": " + this.i.get(l));
                            }
                        }
                    }
                }
                final FragmentManagerState fragmentManagerState = new FragmentManagerState();
                fragmentManagerState.a = a;
                fragmentManagerState.b = b;
                fragmentManagerState.c = c;
                return (Parcelable)fragmentManagerState;
            }
            if (o.a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
                return null;
            }
        }
        return null;
    }
    
    public final void i() {
        this.s = false;
    }
    
    public final void j() {
        this.s = false;
        this.e(1);
    }
    
    public final void k() {
        this.s = false;
        this.e(2);
    }
    
    public final void l() {
        this.s = false;
        this.e(4);
    }
    
    public final void m() {
        this.s = false;
        this.e(5);
    }
    
    public final void n() {
        this.e(4);
    }
    
    public final void o() {
        this.s = true;
        this.e(3);
    }
    
    public final void p() {
        this.e(2);
    }
    
    public final void q() {
        this.e(1);
    }
    
    public final void r() {
        this.t = true;
        this.f();
        this.e(0);
        this.o = null;
        this.p = null;
        this.q = null;
    }
    
    public final void s() {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); ++i) {
                final Fragment fragment = this.g.get(i);
                if (fragment != null) {
                    fragment.C();
                }
            }
        }
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.q != null) {
            ay.a(this.q, sb);
        }
        else {
            ay.a(this.o, sb);
        }
        sb.append("}}");
        return sb.toString();
    }
}
