// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import java.util.ArrayList;
import java.io.Writer;
import java.io.PrintWriter;
import android.support.v4.b.d;
import android.util.Log;

final class a extends k implements Runnable
{
    final i a;
    b b;
    b c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    boolean k;
    boolean l;
    String m;
    boolean n;
    int o;
    int p;
    CharSequence q;
    int r;
    CharSequence s;
    
    public a(final i a) {
        this.l = true;
        this.o = -1;
        this.a = a;
    }
    
    private int b(final boolean b) {
        if (this.n) {
            throw new IllegalStateException("commit already called");
        }
        if (android.support.v4.app.i.a) {
            Log.v("FragmentManager", "Commit: " + this);
            this.a("  ", new PrintWriter(new d("FragmentManager")));
        }
        this.n = true;
        if (this.k) {
            this.o = this.a.a(this);
        }
        else {
            this.o = -1;
        }
        this.a.a(this, b);
        return this.o;
    }
    
    private void b(final int mContainerId, final Fragment d, final String s) {
        d.mFragmentManager = this.a;
        if (s != null) {
            if (d.mTag != null && !s.equals(d.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + d + ": was " + d.mTag + " now " + s);
            }
            d.mTag = s;
        }
        if (mContainerId != 0) {
            if (d.mFragmentId != 0 && d.mFragmentId != mContainerId) {
                throw new IllegalStateException("Can't change container ID of fragment " + d + ": was " + d.mFragmentId + " now " + mContainerId);
            }
            d.mFragmentId = mContainerId;
            d.mContainerId = mContainerId;
        }
        final b b = new b();
        b.c = 1;
        b.d = d;
        this.a(b);
    }
    
    @Override
    public final int a() {
        return this.b(false);
    }
    
    @Override
    public final k a(final int n, final Fragment fragment, final String s) {
        this.b(n, fragment, s);
        return this;
    }
    
    @Override
    public final k a(final Fragment d) {
        final b b = new b();
        b.c = 3;
        b.d = d;
        this.a(b);
        return this;
    }
    
    @Override
    public final k a(final Fragment fragment, final String s) {
        this.b(0, fragment, s);
        return this;
    }
    
    final void a(final int i) {
        if (this.k) {
            if (i.a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (b b = this.b; b != null; b = b.a) {
                if (b.d != null) {
                    final Fragment d = b.d;
                    d.mBackStackNesting += i;
                    if (i.a) {
                        Log.v("FragmentManager", "Bump nesting of " + b.d + " to " + b.d.mBackStackNesting);
                    }
                }
                if (b.i != null) {
                    for (int j = -1 + b.i.size(); j >= 0; --j) {
                        final Fragment obj = b.i.get(j);
                        obj.mBackStackNesting += i;
                        if (i.a) {
                            Log.v("FragmentManager", "Bump nesting of " + obj + " to " + obj.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }
    
    final void a(final b b) {
        if (this.b == null) {
            this.c = b;
            this.b = b;
        }
        else {
            b.b = this.c;
            this.c.a = b;
            this.c = b;
        }
        b.e = this.e;
        b.f = this.f;
        b.g = this.g;
        b.h = this.h;
        ++this.d;
    }
    
    public final void a(final String s, final PrintWriter printWriter) {
        this.a(s, printWriter, true);
    }
    
    public final void a(final String s, final PrintWriter printWriter, final boolean b) {
        if (b) {
            printWriter.print(s);
            printWriter.print("mName=");
            printWriter.print(this.m);
            printWriter.print(" mIndex=");
            printWriter.print(this.o);
            printWriter.print(" mCommitted=");
            printWriter.println(this.n);
            if (this.i != 0) {
                printWriter.print(s);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.i));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.j));
            }
            if (this.e != 0 || this.f != 0) {
                printWriter.print(s);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (this.g != 0 || this.h != 0) {
                printWriter.print(s);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (this.p != 0 || this.q != null) {
                printWriter.print(s);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.q);
            }
            if (this.r != 0 || this.s != null) {
                printWriter.print(s);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.r));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.s);
            }
        }
        if (this.b != null) {
            printWriter.print(s);
            printWriter.println("Operations:");
            final String string = s + "    ";
            final b b2 = this.b;
            int i = 0;
            for (b a = b2; a != null; a = a.a, ++i) {
                String string2 = null;
                switch (a.c) {
                    default: {
                        string2 = "cmd=" + a.c;
                        break;
                    }
                    case 0: {
                        string2 = "NULL";
                        break;
                    }
                    case 1: {
                        string2 = "ADD";
                        break;
                    }
                    case 2: {
                        string2 = "REPLACE";
                        break;
                    }
                    case 3: {
                        string2 = "REMOVE";
                        break;
                    }
                    case 4: {
                        string2 = "HIDE";
                        break;
                    }
                    case 5: {
                        string2 = "SHOW";
                        break;
                    }
                    case 6: {
                        string2 = "DETACH";
                        break;
                    }
                    case 7: {
                        string2 = "ATTACH";
                        break;
                    }
                }
                printWriter.print(s);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(string2);
                printWriter.print(" ");
                printWriter.println(a.d);
                if (b) {
                    if (a.e != 0 || a.f != 0) {
                        printWriter.print(s);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(a.e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(a.f));
                    }
                    if (a.g != 0 || a.h != 0) {
                        printWriter.print(s);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(a.g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(a.h));
                    }
                }
                if (a.i != null && a.i.size() > 0) {
                    for (int j = 0; j < a.i.size(); ++j) {
                        printWriter.print(string);
                        if (a.i.size() == 1) {
                            printWriter.print("Removed: ");
                        }
                        else {
                            if (j == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(string);
                            printWriter.print("  #");
                            printWriter.print(j);
                            printWriter.print(": ");
                        }
                        printWriter.println(a.i.get(j));
                    }
                }
            }
        }
    }
    
    public final void a(final boolean b) {
        if (android.support.v4.app.i.a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            this.a("  ", new PrintWriter(new d("FragmentManager")));
        }
        this.a(-1);
        for (b b2 = this.c; b2 != null; b2 = b2.b) {
            switch (b2.c) {
                default: {
                    throw new IllegalArgumentException("Unknown cmd: " + b2.c);
                }
                case 1: {
                    final Fragment d = b2.d;
                    d.mNextAnim = b2.h;
                    this.a.a(d, android.support.v4.app.i.d(this.i), this.j);
                    break;
                }
                case 2: {
                    final Fragment d2 = b2.d;
                    if (d2 != null) {
                        d2.mNextAnim = b2.h;
                        this.a.a(d2, android.support.v4.app.i.d(this.i), this.j);
                    }
                    if (b2.i != null) {
                        for (int i = 0; i < b2.i.size(); ++i) {
                            final Fragment fragment = b2.i.get(i);
                            fragment.mNextAnim = b2.g;
                            this.a.a(fragment, false);
                        }
                        break;
                    }
                    break;
                }
                case 3: {
                    final Fragment d3 = b2.d;
                    d3.mNextAnim = b2.g;
                    this.a.a(d3, false);
                    break;
                }
                case 4: {
                    final Fragment d4 = b2.d;
                    d4.mNextAnim = b2.g;
                    this.a.c(d4, android.support.v4.app.i.d(this.i), this.j);
                    break;
                }
                case 5: {
                    final Fragment d5 = b2.d;
                    d5.mNextAnim = b2.h;
                    this.a.b(d5, android.support.v4.app.i.d(this.i), this.j);
                    break;
                }
                case 6: {
                    final Fragment d6 = b2.d;
                    d6.mNextAnim = b2.g;
                    this.a.e(d6, android.support.v4.app.i.d(this.i), this.j);
                    break;
                }
                case 7: {
                    final Fragment d7 = b2.d;
                    d7.mNextAnim = b2.g;
                    this.a.d(d7, android.support.v4.app.i.d(this.i), this.j);
                    break;
                }
            }
        }
        if (b) {
            this.a.a(this.a.n, android.support.v4.app.i.d(this.i), this.j, true);
        }
        if (this.o >= 0) {
            this.a.c(this.o);
            this.o = -1;
        }
    }
    
    @Override
    public final int b() {
        return this.b(true);
    }
    
    @Override
    public final k b(final Fragment d) {
        final b b = new b();
        b.c = 6;
        b.d = d;
        this.a(b);
        return this;
    }
    
    @Override
    public final k c(final Fragment d) {
        final b b = new b();
        b.c = 7;
        b.d = d;
        this.a(b);
        return this;
    }
    
    @Override
    public final void run() {
        if (android.support.v4.app.i.a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (this.k && this.o < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        this.a(1);
        for (b b = this.b; b != null; b = b.a) {
            switch (b.c) {
                default: {
                    throw new IllegalArgumentException("Unknown cmd: " + b.c);
                }
                case 1: {
                    final Fragment d = b.d;
                    d.mNextAnim = b.e;
                    this.a.a(d, false);
                    break;
                }
                case 2: {
                    final Fragment d2 = b.d;
                    Fragment obj;
                    if (this.a.g != null) {
                        int i = 0;
                        obj = d2;
                        while (i < this.a.g.size()) {
                            final Fragment obj2 = this.a.g.get(i);
                            if (android.support.v4.app.i.a) {
                                Log.v("FragmentManager", "OP_REPLACE: adding=" + obj + " old=" + obj2);
                            }
                            if (obj == null || obj2.mContainerId == obj.mContainerId) {
                                if (obj2 == obj) {
                                    obj = null;
                                    b.d = null;
                                }
                                else {
                                    if (b.i == null) {
                                        b.i = new ArrayList();
                                    }
                                    b.i.add(obj2);
                                    obj2.mNextAnim = b.f;
                                    if (this.k) {
                                        ++obj2.mBackStackNesting;
                                        if (android.support.v4.app.i.a) {
                                            Log.v("FragmentManager", "Bump nesting of " + obj2 + " to " + obj2.mBackStackNesting);
                                        }
                                    }
                                    this.a.a(obj2, this.i, this.j);
                                }
                            }
                            ++i;
                        }
                    }
                    else {
                        obj = d2;
                    }
                    if (obj != null) {
                        obj.mNextAnim = b.e;
                        this.a.a(obj, false);
                        break;
                    }
                    break;
                }
                case 3: {
                    final Fragment d3 = b.d;
                    d3.mNextAnim = b.f;
                    this.a.a(d3, this.i, this.j);
                    break;
                }
                case 4: {
                    final Fragment d4 = b.d;
                    d4.mNextAnim = b.f;
                    this.a.b(d4, this.i, this.j);
                    break;
                }
                case 5: {
                    final Fragment d5 = b.d;
                    d5.mNextAnim = b.e;
                    this.a.c(d5, this.i, this.j);
                    break;
                }
                case 6: {
                    final Fragment d6 = b.d;
                    d6.mNextAnim = b.f;
                    this.a.d(d6, this.i, this.j);
                    break;
                }
                case 7: {
                    final Fragment d7 = b.d;
                    d7.mNextAnim = b.e;
                    this.a.e(d7, this.i, this.j);
                    break;
                }
            }
        }
        this.a.a(this.a.n, this.i, this.j, true);
        if (this.k) {
            this.a.b(this);
        }
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.o >= 0) {
            sb.append(" #");
            sb.append(this.o);
        }
        if (this.m != null) {
            sb.append(" ");
            sb.append(this.m);
        }
        sb.append("}");
        return sb.toString();
    }
}
