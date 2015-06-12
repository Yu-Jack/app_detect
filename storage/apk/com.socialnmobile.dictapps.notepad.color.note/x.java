import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.util.Log;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

// 
// Decompiled by Procyon v0.5.29
// 

public final class x extends v
{
    static boolean a;
    final bh b;
    final bh c;
    public final String d;
    FragmentActivity e;
    public boolean f;
    public boolean g;
    boolean h;
    
    static {
        x.a = false;
    }
    
    public x(final String d, final FragmentActivity e, final boolean f) {
        this.b = new bh();
        this.c = new bh();
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    private y b(final int n, final Bundle bundle, final w w) {
        final y y = new y(this, n, bundle, w);
        y.d = w.a_(bundle);
        return y;
    }
    
    private y c(final int n, final Bundle bundle, final w w) {
        try {
            this.h = true;
            final y b = this.b(n, bundle, w);
            this.a(b);
            return b;
        }
        finally {
            this.h = false;
        }
    }
    
    @Override
    public final ae a(final int n, final Bundle obj, final w w) {
        if (this.h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        final y y = (y)this.b.a(n);
        if (x.a) {
            Log.v("LoaderManager", "restartLoader in " + this + ": args=" + obj);
        }
        if (y != null) {
            final y y2 = (y)this.c.a(n);
            if (y2 != null) {
                if (y.e) {
                    if (x.a) {
                        Log.v("LoaderManager", "  Removing last inactive loader: " + y);
                    }
                    y2.f = false;
                    y2.c();
                }
                else {
                    if (!y.h) {
                        if (x.a) {
                            Log.v("LoaderManager", "  Current loader is stopped; replacing");
                        }
                        this.b.a(n, null);
                        y.c();
                        return this.c(n, obj, w).d;
                    }
                    if (y.n != null) {
                        if (x.a) {
                            Log.v("LoaderManager", "  Removing pending loader: " + y.n);
                        }
                        y.n.c();
                        y.n = null;
                    }
                    if (x.a) {
                        Log.v("LoaderManager", "  Enqueuing as new pending loader");
                    }
                    y.n = this.b(n, obj, w);
                    return y.n.d;
                }
            }
            else if (x.a) {
                Log.v("LoaderManager", "  Making last loader inactive: " + y);
            }
            y.d.q = true;
            this.c.a(n, y);
        }
        return this.c(n, obj, w).d;
    }
    
    public final void a(final FragmentActivity e) {
        this.e = e;
    }
    
    public final void a(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        int i = 0;
        if (this.b.a() > 0) {
            printWriter.print(s);
            printWriter.println("Active Loaders:");
            final String string = s + "    ";
            for (int j = 0; j < this.b.a(); ++j) {
                final y y = (y)this.b.d(j);
                printWriter.print(s);
                printWriter.print("  #");
                printWriter.print(this.b.c(j));
                printWriter.print(": ");
                printWriter.println(y.toString());
                y.a(string, fileDescriptor, printWriter, array);
            }
        }
        if (this.c.a() > 0) {
            printWriter.print(s);
            printWriter.println("Inactive Loaders:");
            final String string2 = s + "    ";
            while (i < this.c.a()) {
                final y y2 = (y)this.c.d(i);
                printWriter.print(s);
                printWriter.print("  #");
                printWriter.print(this.c.c(i));
                printWriter.print(": ");
                printWriter.println(y2.toString());
                y2.a(string2, fileDescriptor, printWriter, array);
                ++i;
            }
        }
    }
    
    final void a(final y y) {
        this.b.a(y.a, y);
        if (this.f) {
            y.a();
        }
    }
    
    @Override
    public final boolean a() {
        final int a = this.b.a();
        int i = 0;
        boolean b = false;
        while (i < a) {
            final y y = (y)this.b.d(i);
            b |= (y.h && !y.f);
            ++i;
        }
        return b;
    }
    
    public final void b() {
        if (x.a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f) {
            final RuntimeException ex = new RuntimeException("here");
            ex.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, (Throwable)ex);
        }
        else {
            this.f = true;
            for (int i = -1 + this.b.a(); i >= 0; --i) {
                ((y)this.b.d(i)).a();
            }
        }
    }
    
    public final void c() {
        if (x.a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.f) {
            final RuntimeException ex = new RuntimeException("here");
            ex.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, (Throwable)ex);
            return;
        }
        for (int i = -1 + this.b.a(); i >= 0; --i) {
            ((y)this.b.d(i)).b();
        }
        this.f = false;
    }
    
    public final void d() {
        if (x.a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.f) {
            final RuntimeException ex = new RuntimeException("here");
            ex.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, (Throwable)ex);
        }
        else {
            this.g = true;
            this.f = false;
            for (int i = -1 + this.b.a(); i >= 0; --i) {
                final y obj = (y)this.b.d(i);
                if (x.a) {
                    Log.v("LoaderManager", "  Retaining: " + obj);
                }
                obj.i = true;
                obj.j = obj.h;
                obj.h = false;
                obj.c = null;
            }
        }
    }
    
    public final void e() {
        if (this.g) {
            if (x.a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.g = false;
            for (int i = -1 + this.b.a(); i >= 0; --i) {
                final y obj = (y)this.b.d(i);
                if (obj.i) {
                    if (x.a) {
                        Log.v("LoaderManager", "  Finished Retaining: " + obj);
                    }
                    obj.i = false;
                    if (obj.h != obj.j && !obj.h) {
                        obj.b();
                    }
                }
                if (obj.h && obj.e && !obj.k) {
                    obj.b(obj.d, obj.g);
                }
            }
        }
    }
    
    public final void f() {
        for (int i = -1 + this.b.a(); i >= 0; --i) {
            ((y)this.b.d(i)).k = true;
        }
    }
    
    public final void g() {
        for (int i = -1 + this.b.a(); i >= 0; --i) {
            final y y = (y)this.b.d(i);
            if (y.h && y.k) {
                y.k = false;
                if (y.e) {
                    y.b(y.d, y.g);
                }
            }
        }
    }
    
    public final void h() {
        if (!this.g) {
            if (x.a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int i = -1 + this.b.a(); i >= 0; --i) {
                ((y)this.b.d(i)).c();
            }
            this.b.b();
        }
        if (x.a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int j = -1 + this.c.a(); j >= 0; --j) {
            ((y)this.c.d(j)).c();
        }
        this.c.b();
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        ay.a(this.e, sb);
        sb.append("}}");
        return sb.toString();
    }
}
