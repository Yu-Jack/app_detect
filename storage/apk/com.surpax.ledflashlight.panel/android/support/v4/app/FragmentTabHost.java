// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import java.util.ArrayList;
import android.widget.TabHost$OnTabChangeListener;
import android.widget.TabHost;

public class FragmentTabHost extends TabHost implements TabHost$OnTabChangeListener
{
    private final ArrayList a;
    private Context b;
    private h c;
    private int d;
    private TabHost$OnTabChangeListener e;
    private j f;
    private boolean g;
    
    public FragmentTabHost(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = new ArrayList();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, new int[] { 16842995 }, 0, 0);
        this.d = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener((TabHost$OnTabChangeListener)this);
    }
    
    private k a(final String s, k a) {
        j f = null;
        j j;
        for (int i = 0; i < this.a.size(); ++i, f = j) {
            j = this.a.get(i);
            if (!j.a.equals(s)) {
                j = f;
            }
        }
        if (f == null) {
            throw new IllegalStateException("No tab known for tag " + s);
        }
        if (this.f != f) {
            if (a == null) {
                a = this.c.a();
            }
            if (this.f != null && this.f.d != null) {
                a.b(this.f.d);
            }
            if (f != null) {
                if (f.d == null) {
                    f.d = Fragment.instantiate(this.b, f.b.getName(), f.c);
                    a.a(this.d, f.d, f.a);
                }
                else {
                    a.c(f.d);
                }
            }
            this.f = f;
        }
        return a;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final String currentTabTag = this.getCurrentTabTag();
        k a = null;
        for (int i = 0; i < this.a.size(); ++i) {
            final j f = this.a.get(i);
            f.d = this.c.a(f.a);
            if (f.d != null && !f.d.isDetached()) {
                if (f.a.equals(currentTabTag)) {
                    this.f = f;
                }
                else {
                    if (a == null) {
                        a = this.c.a();
                    }
                    a.b(f.d);
                }
            }
        }
        this.g = true;
        final k a2 = this.a(currentTabTag, a);
        if (a2 != null) {
            a2.a();
            this.c.b();
        }
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        final FragmentTabHost$SavedState fragmentTabHost$SavedState = (FragmentTabHost$SavedState)parcelable;
        super.onRestoreInstanceState(fragmentTabHost$SavedState.getSuperState());
        this.setCurrentTabByTag(fragmentTabHost$SavedState.a);
    }
    
    protected Parcelable onSaveInstanceState() {
        final FragmentTabHost$SavedState fragmentTabHost$SavedState = new FragmentTabHost$SavedState(super.onSaveInstanceState());
        fragmentTabHost$SavedState.a = this.getCurrentTabTag();
        return (Parcelable)fragmentTabHost$SavedState;
    }
    
    public void onTabChanged(final String s) {
        if (this.g) {
            final k a = this.a(s, null);
            if (a != null) {
                a.a();
            }
        }
        if (this.e != null) {
            this.e.onTabChanged(s);
        }
    }
    
    public void setOnTabChangedListener(final TabHost$OnTabChangeListener e) {
        this.e = e;
    }
    
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}
