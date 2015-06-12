import java.util.ArrayList;
import java.io.Writer;
import java.io.PrintWriter;
import android.util.Log;
import android.support.v4.app.Fragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class b extends u implements Runnable
{
    final o a;
    public c b;
    c c;
    public int d;
    int e;
    int f;
    int g;
    int h;
    public int i;
    public int j;
    public boolean k;
    boolean l;
    public String m;
    boolean n;
    public int o;
    public int p;
    public CharSequence q;
    public int r;
    public CharSequence s;
    
    public b(final o a) {
        this.l = true;
        this.o = -1;
        this.a = a;
    }
    
    private void a(final int g, final Fragment d, final String s, final int c) {
        d.B = this.a;
        if (s != null) {
            if (d.H != null && !s.equals(d.H)) {
                throw new IllegalStateException("Can't change tag of fragment " + d + ": was " + d.H + " now " + s);
            }
            d.H = s;
        }
        if (g != 0) {
            if (d.F != 0 && d.F != g) {
                throw new IllegalStateException("Can't change container ID of fragment " + d + ": was " + d.F + " now " + g);
            }
            d.F = g;
            d.G = g;
        }
        final c c2 = new c();
        c2.c = c;
        c2.d = d;
        this.a(c2);
    }
    
    private int b(final boolean b) {
        if (this.n) {
            throw new IllegalStateException("commit already called");
        }
        if (o.a) {
            Log.v("FragmentManager", "Commit: " + this);
            this.a("  ", new PrintWriter(new az("FragmentManager")));
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
    
    @Override
    public final u a() {
        if (!this.l) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.k = true;
        this.m = null;
        return this;
    }
    
    @Override
    public final u a(final int i) {
        this.i = i;
        return this;
    }
    
    @Override
    public final u a(final int n, final Fragment fragment) {
        this.a(n, fragment, null, 1);
        return this;
    }
    
    @Override
    public final u a(final int n, final Fragment fragment, final String s) {
        if (n == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        this.a(n, fragment, s, 2);
        return this;
    }
    
    @Override
    public final u a(final Fragment d) {
        final c c = new c();
        c.c = 3;
        c.d = d;
        this.a(c);
        return this;
    }
    
    @Override
    public final u a(final Fragment fragment, final String s) {
        this.a(0, fragment, s, 1);
        return this;
    }
    
    public final void a(final c c) {
        if (this.b == null) {
            this.c = c;
            this.b = c;
        }
        else {
            c.b = this.c;
            this.c.a = c;
            this.c = c;
        }
        c.e = this.e;
        c.f = this.f;
        c.g = this.g;
        c.h = this.h;
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
            final c b2 = this.b;
            int i = 0;
            for (c a = b2; a != null; a = a.a, ++i) {
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
        if (o.a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            this.a("  ", new PrintWriter(new az("FragmentManager")));
        }
        this.b(-1);
        for (c c = this.c; c != null; c = c.b) {
            switch (c.c) {
                default: {
                    throw new IllegalArgumentException("Unknown cmd: " + c.c);
                }
                case 1: {
                    final Fragment d = c.d;
                    d.P = c.h;
                    this.a.a(d, o.d(this.i), this.j);
                    break;
                }
                case 2: {
                    final Fragment d2 = c.d;
                    if (d2 != null) {
                        d2.P = c.h;
                        this.a.a(d2, o.d(this.i), this.j);
                    }
                    if (c.i != null) {
                        for (int i = 0; i < c.i.size(); ++i) {
                            final Fragment fragment = c.i.get(i);
                            fragment.P = c.g;
                            this.a.a(fragment, false);
                        }
                        break;
                    }
                    break;
                }
                case 3: {
                    final Fragment d3 = c.d;
                    d3.P = c.g;
                    this.a.a(d3, false);
                    break;
                }
                case 4: {
                    final Fragment d4 = c.d;
                    d4.P = c.g;
                    this.a.c(d4, o.d(this.i), this.j);
                    break;
                }
                case 5: {
                    final Fragment d5 = c.d;
                    d5.P = c.h;
                    this.a.b(d5, o.d(this.i), this.j);
                    break;
                }
                case 6: {
                    final Fragment d6 = c.d;
                    d6.P = c.g;
                    this.a.e(d6, o.d(this.i), this.j);
                    break;
                }
                case 7: {
                    final Fragment d7 = c.d;
                    d7.P = c.g;
                    this.a.d(d7, o.d(this.i), this.j);
                    break;
                }
            }
        }
        if (b) {
            this.a.a(this.a.n, o.d(this.i), this.j, true);
        }
        if (this.o >= 0) {
            this.a.c(this.o);
            this.o = -1;
        }
    }
    
    @Override
    public final int b() {
        return this.b(false);
    }
    
    @Override
    public final u b(final int n, final Fragment fragment) {
        return this.a(n, fragment, null);
    }
    
    public final void b(final int i) {
        if (this.k) {
            if (o.a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (c c = this.b; c != null; c = c.a) {
                if (c.d != null) {
                    final Fragment d = c.d;
                    d.A += i;
                    if (o.a) {
                        Log.v("FragmentManager", "Bump nesting of " + c.d + " to " + c.d.A);
                    }
                }
                if (c.i != null) {
                    for (int j = -1 + c.i.size(); j >= 0; --j) {
                        final Fragment obj = c.i.get(j);
                        obj.A += i;
                        if (o.a) {
                            Log.v("FragmentManager", "Bump nesting of " + obj + " to " + obj.A);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public final int c() {
        return this.b(true);
    }
    
    @Override
    public final void run() {
        if (o.a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (this.k && this.o < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        this.b(1);
        for (c c = this.b; c != null; c = c.a) {
            switch (c.c) {
                default: {
                    throw new IllegalArgumentException("Unknown cmd: " + c.c);
                }
                case 1: {
                    final Fragment d = c.d;
                    d.P = c.e;
                    this.a.a(d, false);
                    break;
                }
                case 2: {
                    final Fragment d2 = c.d;
                    Fragment obj;
                    if (this.a.g != null) {
                        int i = 0;
                        obj = d2;
                        while (i < this.a.g.size()) {
                            final Fragment obj2 = this.a.g.get(i);
                            if (o.a) {
                                Log.v("FragmentManager", "OP_REPLACE: adding=" + obj + " old=" + obj2);
                            }
                            if (obj == null || obj2.G == obj.G) {
                                if (obj2 == obj) {
                                    obj = null;
                                    c.d = null;
                                }
                                else {
                                    if (c.i == null) {
                                        c.i = new ArrayList();
                                    }
                                    c.i.add(obj2);
                                    obj2.P = c.f;
                                    if (this.k) {
                                        ++obj2.A;
                                        if (o.a) {
                                            Log.v("FragmentManager", "Bump nesting of " + obj2 + " to " + obj2.A);
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
                        obj.P = c.e;
                        this.a.a(obj, false);
                        break;
                    }
                    break;
                }
                case 3: {
                    final Fragment d3 = c.d;
                    d3.P = c.f;
                    this.a.a(d3, this.i, this.j);
                    break;
                }
                case 4: {
                    final Fragment d4 = c.d;
                    d4.P = c.f;
                    this.a.b(d4, this.i, this.j);
                    break;
                }
                case 5: {
                    final Fragment d5 = c.d;
                    d5.P = c.e;
                    this.a.c(d5, this.i, this.j);
                    break;
                }
                case 6: {
                    final Fragment d6 = c.d;
                    d6.P = c.f;
                    this.a.d(d6, this.i, this.j);
                    break;
                }
                case 7: {
                    final Fragment d7 = c.d;
                    d7.P = c.e;
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
