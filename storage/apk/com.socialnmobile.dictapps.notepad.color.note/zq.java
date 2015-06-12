import android.view.View;
import java.util.Iterator;
import android.util.Log;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment$SavedState;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import java.util.ArrayList;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class zq extends zt
{
    private final m a;
    public ArrayList b;
    public Fragment c;
    zr d;
    private u f;
    private ArrayList g;
    
    public zq(final m a, final zr d) {
        this.f = null;
        this.g = new ArrayList();
        this.b = new ArrayList();
        this.c = null;
        this.a = a;
        this.d = d;
    }
    
    public abstract Fragment a(final int p0);
    
    @Override
    public final Object a(final ViewGroup viewGroup, final int index) {
        if (this.b.size() > index) {
            final Fragment fragment = this.b.get(index);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.f == null) {
            this.f = this.a.a();
        }
        final Fragment a = this.a(index);
        if (this.g.size() > index) {
            final Fragment$SavedState fragment$SavedState = this.g.get(index);
            if (fragment$SavedState != null) {
                a.a(fragment$SavedState);
            }
        }
        while (this.b.size() <= index) {
            this.b.add(null);
        }
        a.b(false);
        this.b.set(index, a);
        this.f.a(viewGroup.getId(), a);
        return a;
    }
    
    @Override
    public final void a() {
        if (this.f != null) {
            this.f.c();
            this.f = null;
            this.a.b();
        }
    }
    
    @Override
    public final void a(final Parcelable parcelable, final ClassLoader classLoader) {
        if (parcelable != null) {
            final Bundle bundle = (Bundle)parcelable;
            bundle.setClassLoader(classLoader);
            final Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.g.clear();
            this.b.clear();
            if (parcelableArray != null) {
                for (int i = 0; i < parcelableArray.length; ++i) {
                    this.g.add(parcelableArray[i]);
                }
            }
            for (final String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    final int int1 = Integer.parseInt(str.substring(1));
                    final Fragment a = this.a.a(bundle, str);
                    if (a != null) {
                        while (this.b.size() <= int1) {
                            this.b.add(null);
                        }
                        a.b(false);
                        this.b.set(int1, a);
                    }
                    else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
    
    @Override
    public final void a(final ViewGroup viewGroup, final int n, final Object o) {
        final Fragment fragment = (Fragment)o;
        if (this.f == null) {
            this.f = this.a.a();
        }
        while (this.g.size() <= n) {
            this.g.add(null);
        }
        this.g.set(n, this.a.a(fragment));
        this.b.set(n, null);
        this.f.a(fragment);
    }
    
    @Override
    public final void a(final Object o) {
        final Fragment c = (Fragment)o;
        if (c != this.c) {
            if (this.c != null) {
                this.c.b(false);
            }
            if ((this.c = c) != null) {
                c.b(true);
                this.d.b(c);
            }
        }
    }
    
    @Override
    public final boolean a(final View view, final Object o) {
        return ((Fragment)o).u() == view;
    }
    
    @Override
    public final Parcelable b() {
        final int size = this.g.size();
        Object o = null;
        if (size > 0) {
            o = new Bundle();
            final Fragment$SavedState[] a = new Fragment$SavedState[this.g.size()];
            this.g.toArray(a);
            ((Bundle)o).putParcelableArray("states", (Parcelable[])a);
        }
        int i = 0;
        Bundle bundle = (Bundle)o;
        while (i < this.b.size()) {
            final Fragment fragment = this.b.get(i);
            if (fragment != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.a.a(bundle, "f" + i, fragment);
            }
            ++i;
        }
        return (Parcelable)bundle;
    }
}
