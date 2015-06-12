// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.support.v4.b.c;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.Menu;
import java.util.Arrays;
import android.view.View;
import android.view.animation.Animation$AnimationListener;
import android.view.ViewGroup;
import android.app.Activity;
import android.os.Parcelable;
import android.content.res.Configuration;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.Writer;
import java.io.PrintWriter;
import android.support.v4.b.d;
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
import java.util.ArrayList;
import android.view.animation.Interpolator;

final class i extends h
{
    static final Interpolator A;
    static final Interpolator B;
    static final Interpolator C;
    static boolean a;
    static final boolean b;
    static final Interpolator z;
    ArrayList c;
    Runnable[] d;
    boolean e;
    ArrayList f;
    ArrayList g;
    ArrayList h;
    ArrayList i;
    ArrayList j;
    ArrayList k;
    ArrayList l;
    ArrayList m;
    int n;
    FragmentActivity o;
    g p;
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
        i.a = false;
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
    
    i() {
        this.n = 0;
        this.w = null;
        this.x = null;
        this.y = new Runnable() {
            @Override
            public final void run() {
                android.support.v4.app.i.this.d();
            }
        };
    }
    
    private Fragment a(final Bundle bundle, final String s) {
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
    
    private static Animation a(final float n, final float n2) {
        final AlphaAnimation alphaAnimation = new AlphaAnimation(n, n2);
        alphaAnimation.setInterpolator(i.A);
        alphaAnimation.setDuration(220L);
        return (Animation)alphaAnimation;
    }
    
    private static Animation a(final float n, final float n2, final float n3, final float n4) {
        final AnimationSet set = new AnimationSet(false);
        final ScaleAnimation scaleAnimation = new ScaleAnimation(n, n2, n, n2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(i.z);
        scaleAnimation.setDuration(220L);
        set.addAnimation((Animation)scaleAnimation);
        final AlphaAnimation alphaAnimation = new AlphaAnimation(n3, n4);
        alphaAnimation.setInterpolator(i.A);
        alphaAnimation.setDuration(220L);
        set.addAnimation((Animation)alphaAnimation);
        return (Animation)set;
    }
    
    private Animation a(final Fragment fragment, final int n, final boolean b, int windowAnimations) {
        Animation animation = fragment.onCreateAnimation(n, b, fragment.mNextAnim);
        if (animation == null) {
            if (fragment.mNextAnim != 0) {
                animation = AnimationUtils.loadAnimation((Context)this.o, fragment.mNextAnim);
                if (animation != null) {
                    return animation;
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
        return animation;
    }
    
    private void a(final int i, final a a) {
        synchronized (this) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            int j = this.k.size();
            if (i < j) {
                if (i.a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + a);
                }
                this.k.set(i, a);
            }
            else {
                while (j < i) {
                    this.k.add(null);
                    if (this.l == null) {
                        this.l = new ArrayList();
                    }
                    if (i.a) {
                        Log.v("FragmentManager", "Adding available back stack index " + j);
                    }
                    this.l.add(j);
                    ++j;
                }
                if (i.a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + a);
                }
                this.k.add(a);
            }
        }
    }
    
    private void a(final RuntimeException ex) {
        Log.e("FragmentManager", ex.getMessage());
        Log.e("FragmentManager", "Activity state:");
        final PrintWriter printWriter = new PrintWriter(new d("FragmentManager"));
        while (true) {
            Label_0079: {
                if (this.o == null) {
                    break Label_0079;
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
        if (fragment.mInnerView != null) {
            if (this.x == null) {
                this.x = new SparseArray();
            }
            else {
                this.x.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.x);
            if (this.x.size() > 0) {
                fragment.mSavedViewState = this.x;
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
    
    private void e(final int n) {
        this.a(n, 0, 0, false);
    }
    
    private void r() {
        if (this.f != null) {
            for (int i = 0; i < this.f.size(); ++i) {
                final Fragment fragment = this.f.get(i);
                if (fragment != null) {
                    this.a(fragment);
                }
            }
        }
    }
    
    private void s() {
        if (this.s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.u);
        }
    }
    
    private void t() {
        if (this.m != null) {
            for (int i = 0; i < this.m.size(); ++i) {
                this.m.get(i);
            }
        }
    }
    
    public final int a(final a a) {
        synchronized (this) {
            if (this.l == null || this.l.size() <= 0) {
                if (this.k == null) {
                    this.k = new ArrayList();
                }
                final int size = this.k.size();
                if (android.support.v4.app.i.a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + a);
                }
                this.k.add(a);
                return size;
            }
            final int intValue = this.l.remove(-1 + this.l.size());
            if (android.support.v4.app.i.a) {
                Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + a);
            }
            this.k.set(intValue, a);
            return intValue;
        }
    }
    
    @Override
    public final Fragment a(final String s) {
        if (this.g != null && s != null) {
            for (int i = -1 + this.g.size(); i >= 0; --i) {
                final Fragment fragment = this.g.get(i);
                if (fragment != null && s.equals(fragment.mTag)) {
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
                if (fragment != null && s.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        return null;
    }
    
    @Override
    public final k a() {
        return new a(this);
    }
    
    @Override
    public final void a(final int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        this.a(new Runnable() {
            final /* synthetic */ int b;
            
            @Override
            public final void run() {
                final i c = android.support.v4.app.i.this;
                final Handler a = android.support.v4.app.i.this.o.a;
                c.a(i, this.b);
            }
        }, false);
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
                            if (fragment.mLoaderManager == null) {
                                break Label_0170;
                            }
                            final boolean b3 = b2 | fragment.mLoaderManager.a();
                            ++i;
                            b2 = b3;
                            continue Label_0116_Outer;
                        }
                        final boolean b3 = b2;
                        continue;
                    }
                }
                if (!b2) {
                    this.r();
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
                    fragment.performConfigurationChanged(configuration);
                }
            }
        }
    }
    
    final void a(final Parcelable parcelable, final ArrayList list) {
        if (parcelable != null) {
            final FragmentManagerState fragmentManagerState = (FragmentManagerState)parcelable;
            if (fragmentManagerState.a != null) {
                if (list != null) {
                    for (int i = 0; i < list.size(); ++i) {
                        final Fragment fragment = list.get(i);
                        if (android.support.v4.app.i.a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        final FragmentState fragmentState = fragmentManagerState.a[fragment.mIndex];
                        fragmentState.k = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.j != null) {
                            fragmentState.j.setClassLoader(this.o.getClassLoader());
                            fragment.mSavedViewState = fragmentState.j.getSparseParcelableArray("android:view_state");
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
                        if (android.support.v4.app.i.a) {
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
                        if (android.support.v4.app.i.a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + j);
                        }
                        this.h.add(j);
                    }
                }
                if (list != null) {
                    for (int k = 0; k < list.size(); ++k) {
                        final Fragment obj = list.get(k);
                        if (obj.mTargetIndex >= 0) {
                            if (obj.mTargetIndex < this.f.size()) {
                                obj.mTarget = (Fragment)this.f.get(obj.mTargetIndex);
                            }
                            else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + obj + " target no longer exists: " + obj.mTargetIndex);
                                obj.mTarget = null;
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
                        e.mAdded = true;
                        if (android.support.v4.app.i.a) {
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
                    final a a2 = fragmentManagerState.c[m].a(this);
                    if (android.support.v4.app.i.a) {
                        Log.v("FragmentManager", "restoreAllState: back stack #" + m + " (index " + a2.o + "): " + a2);
                        a2.a("  ", new PrintWriter(new d("FragmentManager")), false);
                    }
                    this.i.add(a2);
                    if (a2.o >= 0) {
                        this.a(a2.o, a2);
                    }
                }
            }
        }
    }
    
    public final void a(final Fragment fragment) {
        if (fragment.mDeferStart) {
            if (!this.e) {
                fragment.mDeferStart = false;
                this.a(fragment, this.n, 0, 0, false);
                return;
            }
            this.v = true;
        }
    }
    
    public final void a(final Fragment fragment, final int n, final int n2) {
        if (android.support.v4.app.i.a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean b;
        if (!fragment.isInBackStack()) {
            b = true;
        }
        else {
            b = false;
        }
        if (!fragment.mDetached || b) {
            if (this.g != null) {
                this.g.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.r = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
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
    
    final void a(final Fragment obj, int mState, final int n, final int n2, final boolean b) {
        if ((!obj.mAdded || obj.mDetached) && mState > 1) {
            mState = 1;
        }
        if (obj.mRemoving && mState > obj.mState) {
            mState = obj.mState;
        }
        if (obj.mDeferStart && obj.mState < 4 && mState > 3) {
            mState = 3;
        }
        if (obj.mState < mState) {
            if (obj.mFromLayout && !obj.mInLayout) {
                return;
            }
            if (obj.mAnimatingAway != null) {
                obj.mAnimatingAway = null;
                this.a(obj, obj.mStateAfterAnimating, 0, 0, true);
            }
            Label_0493: {
                switch (obj.mState) {
                    case 0: {
                        if (android.support.v4.app.i.a) {
                            Log.v("FragmentManager", "moveto CREATED: " + obj);
                        }
                        if (obj.mSavedFragmentState != null) {
                            obj.mSavedViewState = obj.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                            obj.mTarget = this.a(obj.mSavedFragmentState, "android:target_state");
                            if (obj.mTarget != null) {
                                obj.mTargetRequestCode = obj.mSavedFragmentState.getInt("android:target_req_state", 0);
                            }
                            if (!(obj.mUserVisibleHint = obj.mSavedFragmentState.getBoolean("android:user_visible_hint", true))) {
                                obj.mDeferStart = true;
                                if (mState > 3) {
                                    mState = 3;
                                }
                            }
                        }
                        obj.mActivity = this.o;
                        obj.mParentFragment = this.q;
                        i mFragmentManager;
                        if (this.q != null) {
                            mFragmentManager = this.q.mChildFragmentManager;
                        }
                        else {
                            mFragmentManager = this.o.b;
                        }
                        obj.mFragmentManager = mFragmentManager;
                        obj.mCalled = false;
                        obj.onAttach(this.o);
                        if (!obj.mCalled) {
                            throw new q("Fragment " + obj + " did not call through to super.onAttach()");
                        }
                        if (obj.mParentFragment == null) {
                            final FragmentActivity o = this.o;
                            FragmentActivity.c();
                        }
                        if (!obj.mRetaining) {
                            obj.performCreate(obj.mSavedFragmentState);
                        }
                        obj.mRetaining = false;
                        if (!obj.mFromLayout) {
                            break Label_0493;
                        }
                        obj.mView = obj.performCreateView(obj.getLayoutInflater(obj.mSavedFragmentState), null, obj.mSavedFragmentState);
                        if (obj.mView != null) {
                            obj.mInnerView = obj.mView;
                            obj.mView = (View)android.support.v4.app.p.a(obj.mView);
                            if (obj.mHidden) {
                                obj.mView.setVisibility(8);
                            }
                            obj.onViewCreated(obj.mView, obj.mSavedFragmentState);
                            break Label_0493;
                        }
                        obj.mInnerView = null;
                        break Label_0493;
                    }
                    case 1: {
                        if (mState > 1) {
                            if (android.support.v4.app.i.a) {
                                Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + obj);
                            }
                            if (!obj.mFromLayout) {
                                ViewGroup mContainer;
                                if (obj.mContainerId != 0) {
                                    mContainer = (ViewGroup)this.p.a(obj.mContainerId);
                                    if (mContainer == null && !obj.mRestored) {
                                        this.a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(obj.mContainerId) + " (" + obj.getResources().getResourceName(obj.mContainerId) + ") for fragment " + obj));
                                    }
                                }
                                else {
                                    mContainer = null;
                                }
                                obj.mContainer = mContainer;
                                obj.mView = obj.performCreateView(obj.getLayoutInflater(obj.mSavedFragmentState), mContainer, obj.mSavedFragmentState);
                                if (obj.mView != null) {
                                    obj.mInnerView = obj.mView;
                                    obj.mView = (View)android.support.v4.app.p.a(obj.mView);
                                    if (mContainer != null) {
                                        final Animation a = this.a(obj, n, true, n2);
                                        if (a != null) {
                                            obj.mView.startAnimation(a);
                                        }
                                        mContainer.addView(obj.mView);
                                    }
                                    if (obj.mHidden) {
                                        obj.mView.setVisibility(8);
                                    }
                                    obj.onViewCreated(obj.mView, obj.mSavedFragmentState);
                                }
                                else {
                                    obj.mInnerView = null;
                                }
                            }
                            obj.performActivityCreated(obj.mSavedFragmentState);
                            if (obj.mView != null) {
                                obj.restoreViewState(obj.mSavedFragmentState);
                            }
                            obj.mSavedFragmentState = null;
                        }
                    }
                    case 2:
                    case 3: {
                        if (mState > 3) {
                            if (android.support.v4.app.i.a) {
                                Log.v("FragmentManager", "moveto STARTED: " + obj);
                            }
                            obj.performStart();
                        }
                    }
                    case 4: {
                        if (mState > 4) {
                            if (android.support.v4.app.i.a) {
                                Log.v("FragmentManager", "moveto RESUMED: " + obj);
                            }
                            obj.mResumed = true;
                            obj.performResume();
                            obj.mSavedFragmentState = null;
                            obj.mSavedViewState = null;
                            break;
                        }
                        break;
                    }
                }
            }
        }
        else if (obj.mState > mState) {
            switch (obj.mState) {
                case 3: {
                    if (mState < 3) {
                        if (android.support.v4.app.i.a) {
                            Log.v("FragmentManager", "movefrom STOPPED: " + obj);
                        }
                        obj.performReallyStop();
                    }
                }
                case 2: {
                    if (mState < 2) {
                        if (android.support.v4.app.i.a) {
                            Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + obj);
                        }
                        if (obj.mView != null && !this.o.isFinishing() && obj.mSavedViewState == null) {
                            this.c(obj);
                        }
                        obj.performDestroyView();
                        if (obj.mView != null && obj.mContainer != null) {
                            Animation a2;
                            if (this.n > 0 && !this.t) {
                                a2 = this.a(obj, n, false, n2);
                            }
                            else {
                                a2 = null;
                            }
                            if (a2 != null) {
                                obj.mAnimatingAway = obj.mView;
                                obj.mStateAfterAnimating = mState;
                                a2.setAnimationListener((Animation$AnimationListener)new Animation$AnimationListener() {
                                    public final void onAnimationEnd(final Animation animation) {
                                        if (obj.mAnimatingAway != null) {
                                            obj.mAnimatingAway = null;
                                            android.support.v4.app.i.this.a(obj, obj.mStateAfterAnimating, 0, 0, false);
                                        }
                                    }
                                    
                                    public final void onAnimationRepeat(final Animation animation) {
                                    }
                                    
                                    public final void onAnimationStart(final Animation animation) {
                                    }
                                });
                                obj.mView.startAnimation(a2);
                            }
                            obj.mContainer.removeView(obj.mView);
                        }
                        obj.mContainer = null;
                        obj.mView = null;
                        obj.mInnerView = null;
                    }
                }
                case 1: {
                    if (mState > 0) {
                        break;
                    }
                    if (this.t && obj.mAnimatingAway != null) {
                        final View mAnimatingAway = obj.mAnimatingAway;
                        obj.mAnimatingAway = null;
                        mAnimatingAway.clearAnimation();
                    }
                    if (obj.mAnimatingAway != null) {
                        obj.mStateAfterAnimating = mState;
                        mState = 1;
                        break;
                    }
                    if (android.support.v4.app.i.a) {
                        Log.v("FragmentManager", "movefrom CREATED: " + obj);
                    }
                    if (!obj.mRetaining) {
                        obj.performDestroy();
                    }
                    obj.mCalled = false;
                    obj.onDetach();
                    if (!obj.mCalled) {
                        throw new q("Fragment " + obj + " did not call through to super.onDetach()");
                    }
                    if (b) {
                        break;
                    }
                    if (obj.mRetaining) {
                        obj.mActivity = null;
                        obj.mParentFragment = null;
                        obj.mFragmentManager = null;
                        obj.mChildFragmentManager = null;
                        break;
                    }
                    if (obj.mIndex >= 0) {
                        if (android.support.v4.app.i.a) {
                            Log.v("FragmentManager", "Freeing fragment index " + obj);
                        }
                        this.f.set(obj.mIndex, null);
                        if (this.h == null) {
                            this.h = new ArrayList();
                        }
                        this.h.add(obj.mIndex);
                        this.o.a(obj.mWho);
                        obj.initState();
                        break;
                    }
                    break;
                }
                case 5: {
                    if (mState < 5) {
                        if (android.support.v4.app.i.a) {
                            Log.v("FragmentManager", "movefrom RESUMED: " + obj);
                        }
                        obj.performPause();
                        obj.mResumed = false;
                    }
                }
                case 4: {
                    if (mState < 4) {
                        if (android.support.v4.app.i.a) {
                            Log.v("FragmentManager", "movefrom STARTED: " + obj);
                        }
                        obj.performStop();
                    }
                }
            }
        }
        obj.mState = mState;
    }
    
    public final void a(final Fragment e, final boolean b) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        if (android.support.v4.app.i.a) {
            Log.v("FragmentManager", "add: " + e);
        }
        if (e.mIndex < 0) {
            if (this.h == null || this.h.size() <= 0) {
                if (this.f == null) {
                    this.f = new ArrayList();
                }
                e.setIndex(this.f.size(), this.q);
                this.f.add(e);
            }
            else {
                e.setIndex(this.h.remove(-1 + this.h.size()), this.q);
                this.f.set(e.mIndex, e);
            }
            if (android.support.v4.app.i.a) {
                Log.v("FragmentManager", "Allocated fragment index " + e);
            }
        }
        if (!e.mDetached) {
            if (this.g.contains(e)) {
                throw new IllegalStateException("Fragment already added: " + e);
            }
            this.g.add(e);
            e.mAdded = true;
            e.mRemoving = false;
            if (e.mHasMenu && e.mMenuVisible) {
                this.r = true;
            }
            if (b) {
                this.b(e);
            }
        }
    }
    
    public final void a(final FragmentActivity o, final g p3, final Fragment q) {
        if (this.o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.o = o;
        this.p = p3;
        this.q = q;
    }
    
    public final void a(final Runnable e, final boolean b) {
        if (!b) {
            this.s();
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
                        x.dump(string, fileDescriptor, printWriter, array);
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
                    final a a = this.i.get(n);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(n);
                    printWriter.print(": ");
                    printWriter.println(a.toString());
                    a.a(string, printWriter);
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
                        final a x2 = this.k.get(n2);
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
    
    final boolean a(final int n, final int n2) {
        if (this.i != null) {
            if (n < 0 && (n2 & 0x1) == 0x0) {
                final int index = -1 + this.i.size();
                if (index < 0) {
                    return false;
                }
                ((a)this.i.remove(index)).a(true);
            }
            else {
                int n3 = -1;
                if (n >= 0) {
                    int i;
                    for (i = -1 + this.i.size(); i >= 0; --i) {
                        final a a = this.i.get(i);
                        if (n >= 0 && n == a.o) {
                            break;
                        }
                    }
                    if (i < 0) {
                        return false;
                    }
                    if ((n2 & 0x1) != 0x0) {
                        --i;
                        while (i >= 0) {
                            final a a2 = this.i.get(i);
                            if (n < 0 || n != a2.o) {
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
                final ArrayList<a> list = new ArrayList<a>();
                for (int j = -1 + this.i.size(); j > n3; --j) {
                    list.add((a)this.i.remove(j));
                }
                for (int n4 = -1 + list.size(), k = 0; k <= n4; ++k) {
                    if (android.support.v4.app.i.a) {
                        Log.v("FragmentManager", "Popping back stack state: " + list.get(k));
                    }
                    list.get(k).a(k == n4);
                }
            }
            this.t();
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
                if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
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
                if (e != null && e.performCreateOptionsMenu(menu, menuInflater)) {
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
                    o.onDestroyOptionsMenu();
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
                if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                    b = true;
                    break;
                }
                ++index;
            }
        }
        return b;
    }
    
    public final Fragment b(final int n) {
        if (this.g != null) {
            for (int i = -1 + this.g.size(); i >= 0; --i) {
                final Fragment fragment = this.g.get(i);
                if (fragment != null && fragment.mFragmentId == n) {
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
                if (fragment != null && fragment.mFragmentId == n) {
                    return fragment;
                }
            }
        }
        return null;
    }
    
    public final Fragment b(final String s) {
        if (this.f != null && s != null) {
            for (int i = -1 + this.f.size(); i >= 0; --i) {
                final Fragment fragment = this.f.get(i);
                if (fragment != null) {
                    final Fragment fragmentByWho = fragment.findFragmentByWho(s);
                    if (fragmentByWho != null) {
                        return fragmentByWho;
                    }
                }
            }
        }
        return null;
    }
    
    final void b(final Fragment fragment) {
        this.a(fragment, this.n, 0, 0, false);
    }
    
    public final void b(final Fragment obj, final int n, final int n2) {
        if (android.support.v4.app.i.a) {
            Log.v("FragmentManager", "hide: " + obj);
        }
        if (!obj.mHidden) {
            obj.mHidden = true;
            if (obj.mView != null) {
                final Animation a = this.a(obj, n, false, n2);
                if (a != null) {
                    obj.mView.startAnimation(a);
                }
                obj.mView.setVisibility(8);
            }
            if (obj.mAdded && obj.mHasMenu && obj.mMenuVisible) {
                this.r = true;
            }
            obj.onHiddenChanged(true);
        }
    }
    
    final void b(final a e) {
        if (this.i == null) {
            this.i = new ArrayList();
        }
        this.i.add(e);
        this.t();
    }
    
    public final void b(final Menu menu) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); ++i) {
                final Fragment fragment = this.g.get(i);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }
    
    @Override
    public final boolean b() {
        return this.d();
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
                if (fragment != null && fragment.performContextItemSelected(menuItem)) {
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
            if (i.a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.l.add(i);
        }
    }
    
    public final void c(final Fragment obj, final int n, final int n2) {
        if (android.support.v4.app.i.a) {
            Log.v("FragmentManager", "show: " + obj);
        }
        if (obj.mHidden) {
            obj.mHidden = false;
            if (obj.mView != null) {
                final Animation a = this.a(obj, n, true, n2);
                if (a != null) {
                    obj.mView.startAnimation(a);
                }
                obj.mView.setVisibility(0);
            }
            if (obj.mAdded && obj.mHasMenu && obj.mMenuVisible) {
                this.r = true;
            }
            obj.onHiddenChanged(false);
        }
    }
    
    public final boolean c() {
        this.s();
        this.d();
        final Handler a = this.o.a;
        return this.a(-1, 0);
    }
    
    public final void d(final Fragment o, final int n, final int n2) {
        if (android.support.v4.app.i.a) {
            Log.v("FragmentManager", "detach: " + o);
        }
        if (!o.mDetached) {
            o.mDetached = true;
            if (o.mAdded) {
                if (this.g != null) {
                    if (android.support.v4.app.i.a) {
                        Log.v("FragmentManager", "remove from detach: " + o);
                    }
                    this.g.remove(o);
                }
                if (o.mHasMenu && o.mMenuVisible) {
                    this.r = true;
                }
                this.a(o, 1, n, n2, o.mAdded = false);
            }
        }
    }
    
    public final boolean d() {
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
                                if (fragment != null && fragment.mLoaderManager != null) {
                                    b2 |= fragment.mLoaderManager.a();
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
                this.r();
                break;
            }
            break;
        }
        return b;
    }
    
    final ArrayList e() {
        final ArrayList f = this.f;
        ArrayList<Fragment> list = null;
        if (f != null) {
            for (int i = 0; i < this.f.size(); ++i) {
                final Fragment fragment = this.f.get(i);
                if (fragment != null && fragment.mRetainInstance) {
                    if (list == null) {
                        list = new ArrayList<Fragment>();
                    }
                    list.add(fragment);
                    fragment.mRetaining = true;
                    int mIndex;
                    if (fragment.mTarget != null) {
                        mIndex = fragment.mTarget.mIndex;
                    }
                    else {
                        mIndex = -1;
                    }
                    fragment.mTargetIndex = mIndex;
                    if (android.support.v4.app.i.a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return list;
    }
    
    public final void e(final Fragment e, final int n, final int n2) {
        if (android.support.v4.app.i.a) {
            Log.v("FragmentManager", "attach: " + e);
        }
        if (e.mDetached) {
            e.mDetached = false;
            if (!e.mAdded) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                if (this.g.contains(e)) {
                    throw new IllegalStateException("Fragment already added: " + e);
                }
                if (android.support.v4.app.i.a) {
                    Log.v("FragmentManager", "add from attach: " + e);
                }
                this.g.add(e);
                e.mAdded = true;
                if (e.mHasMenu && e.mMenuVisible) {
                    this.r = true;
                }
                this.a(e, this.n, n, n2, false);
            }
        }
    }
    
    final Parcelable f() {
        this.d();
        if (android.support.v4.app.i.b) {
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
                    if (obj.mIndex < 0) {
                        this.a(new IllegalStateException("Failure saving state: active " + obj + " has cleared index: " + obj.mIndex));
                    }
                    final FragmentState fragmentState = new FragmentState(obj);
                    a[i] = fragmentState;
                    if (obj.mState > 0 && fragmentState.j == null) {
                        if (this.w == null) {
                            this.w = new Bundle();
                        }
                        obj.performSaveInstanceState(this.w);
                        Bundle w;
                        if (!this.w.isEmpty()) {
                            w = this.w;
                            this.w = null;
                        }
                        else {
                            w = null;
                        }
                        if (obj.mView != null) {
                            this.c(obj);
                        }
                        if (obj.mSavedViewState != null) {
                            if (w == null) {
                                w = new Bundle();
                            }
                            w.putSparseParcelableArray("android:view_state", obj.mSavedViewState);
                        }
                        if (!obj.mUserVisibleHint) {
                            if (w == null) {
                                w = new Bundle();
                            }
                            w.putBoolean("android:user_visible_hint", obj.mUserVisibleHint);
                        }
                        fragmentState.j = w;
                        if (obj.mTarget != null) {
                            if (obj.mTarget.mIndex < 0) {
                                this.a(new IllegalStateException("Failure saving state: " + obj + " has target not in fragment manager: " + obj.mTarget));
                            }
                            if (fragmentState.j == null) {
                                fragmentState.j = new Bundle();
                            }
                            final Bundle j = fragmentState.j;
                            final Fragment mTarget = obj.mTarget;
                            if (mTarget.mIndex < 0) {
                                this.a(new IllegalStateException("Fragment " + mTarget + " is not currently in the FragmentManager"));
                            }
                            j.putInt("android:target_state", mTarget.mIndex);
                            if (obj.mTargetRequestCode != 0) {
                                fragmentState.j.putInt("android:target_req_state", obj.mTargetRequestCode);
                            }
                        }
                    }
                    else {
                        fragmentState.j = obj.mSavedFragmentState;
                    }
                    if (android.support.v4.app.i.a) {
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
                Label_0742: {
                    if (this.g != null) {
                        final int size2 = this.g.size();
                        if (size2 > 0) {
                            b = new int[size2];
                            for (int k = 0; k < size2; ++k) {
                                b[k] = ((Fragment)this.g.get(k)).mIndex;
                                if (b[k] < 0) {
                                    this.a(new IllegalStateException("Failure saving state: active " + this.g.get(k) + " has cleared index: " + b[k]));
                                }
                                if (android.support.v4.app.i.a) {
                                    Log.v("FragmentManager", "saveAllState: adding fragment #" + k + ": " + this.g.get(k));
                                }
                            }
                            break Label_0742;
                        }
                    }
                    b = null;
                }
                final ArrayList l = this.i;
                BackStackState[] c = null;
                if (l != null) {
                    final int size3 = this.i.size();
                    c = null;
                    if (size3 > 0) {
                        c = new BackStackState[size3];
                        for (int index = 0; index < size3; ++index) {
                            c[index] = new BackStackState((a)this.i.get(index));
                            if (android.support.v4.app.i.a) {
                                Log.v("FragmentManager", "saveAllState: adding back stack #" + index + ": " + this.i.get(index));
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
            if (android.support.v4.app.i.a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
                return null;
            }
        }
        return null;
    }
    
    public final void g() {
        this.s = false;
    }
    
    public final void h() {
        this.s = false;
        this.e(1);
    }
    
    public final void i() {
        this.s = false;
        this.e(2);
    }
    
    public final void j() {
        this.s = false;
        this.e(4);
    }
    
    public final void k() {
        this.s = false;
        this.e(5);
    }
    
    public final void l() {
        this.e(4);
    }
    
    public final void m() {
        this.s = true;
        this.e(3);
    }
    
    public final void n() {
        this.e(2);
    }
    
    public final void o() {
        this.e(1);
    }
    
    public final void p() {
        this.t = true;
        this.d();
        this.e(0);
        this.o = null;
        this.p = null;
        this.q = null;
    }
    
    public final void q() {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); ++i) {
                final Fragment fragment = this.g.get(i);
                if (fragment != null) {
                    fragment.performLowMemory();
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
            android.support.v4.b.c.a(this.q, sb);
        }
        else {
            android.support.v4.b.c.a(this.o, sb);
        }
        sb.append("}}");
        return sb.toString();
    }
}
