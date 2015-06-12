// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.support.v4.b.c;
import android.os.Bundle;
import android.support.v4.content.d;
import java.lang.reflect.Modifier;
import android.util.Log;
import java.io.PrintWriter;
import android.support.v4.b.m;

final class n extends l
{
    static boolean a;
    final m b;
    final m c;
    final String d;
    FragmentActivity e;
    boolean f;
    boolean g;
    
    static {
        n.a = false;
    }
    
    n(final String d, final FragmentActivity e, final boolean f) {
        this.b = new m();
        this.c = new m();
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    final void a(final FragmentActivity e) {
        this.e = e;
    }
    
    public final void a(final String s, final PrintWriter printWriter) {
        int i = 0;
        if (this.b.a() > 0) {
            printWriter.print(s);
            printWriter.println("Active Loaders:");
            final String string = s + "    ";
            for (int j = 0; j < this.b.a(); ++j) {
                final o o = (o)this.b.b(j);
                printWriter.print(s);
                printWriter.print("  #");
                printWriter.print(this.b.a(j));
                printWriter.print(": ");
                printWriter.println(o.toString());
                o.a(string, printWriter);
            }
        }
        if (this.c.a() > 0) {
            printWriter.print(s);
            printWriter.println("Inactive Loaders:");
            final String string2 = s + "    ";
            while (i < this.c.a()) {
                final o o2 = (o)this.c.b(i);
                printWriter.print(s);
                printWriter.print("  #");
                printWriter.print(this.c.a(i));
                printWriter.print(": ");
                printWriter.println(o2.toString());
                o2.a(string2, printWriter);
                ++i;
            }
        }
    }
    
    @Override
    public final boolean a() {
        final int a = this.b.a();
        int i = 0;
        boolean b = false;
        while (i < a) {
            final o o = (o)this.b.b(i);
            b |= (o.h && !o.f);
            ++i;
        }
        return b;
    }
    
    final void b() {
        if (n.a) {
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
                final o obj = (o)this.b.b(i);
                if (obj.i && obj.j) {
                    obj.h = true;
                }
                else if (!obj.h) {
                    obj.h = true;
                    if (n.a) {
                        Log.v("LoaderManager", "  Starting: " + obj);
                    }
                    if (obj.d == null && obj.c != null) {
                        final android.support.v4.app.m c = obj.c;
                        final int a = obj.a;
                        final Bundle b = obj.b;
                        obj.d = c.a();
                    }
                    if (obj.d != null) {
                        if (obj.d.getClass().isMemberClass() && !Modifier.isStatic(obj.d.getClass().getModifiers())) {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + obj.d);
                        }
                        if (!obj.m) {
                            obj.d.a(obj.a, obj);
                            obj.m = true;
                        }
                        obj.d.a();
                    }
                }
            }
        }
    }
    
    final void c() {
        if (n.a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.f) {
            final RuntimeException ex = new RuntimeException("here");
            ex.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, (Throwable)ex);
            return;
        }
        for (int i = -1 + this.b.a(); i >= 0; --i) {
            ((o)this.b.b(i)).a();
        }
        this.f = false;
    }
    
    final void d() {
        if (n.a) {
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
                final o obj = (o)this.b.b(i);
                if (n.a) {
                    Log.v("LoaderManager", "  Retaining: " + obj);
                }
                obj.i = true;
                obj.j = obj.h;
                obj.h = false;
                obj.c = null;
            }
        }
    }
    
    final void e() {
        if (this.g) {
            if (n.a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.g = false;
            for (int i = -1 + this.b.a(); i >= 0; --i) {
                final o obj = (o)this.b.b(i);
                if (obj.i) {
                    if (n.a) {
                        Log.v("LoaderManager", "  Finished Retaining: " + obj);
                    }
                    obj.i = false;
                    if (obj.h != obj.j && !obj.h) {
                        obj.a();
                    }
                }
                if (obj.h && obj.e && !obj.k) {
                    obj.a(obj.d, obj.g);
                }
            }
        }
    }
    
    final void f() {
        for (int i = -1 + this.b.a(); i >= 0; --i) {
            ((o)this.b.b(i)).k = true;
        }
    }
    
    final void g() {
        for (int i = -1 + this.b.a(); i >= 0; --i) {
            final o o = (o)this.b.b(i);
            if (o.h && o.k) {
                o.k = false;
                if (o.e) {
                    o.a(o.d, o.g);
                }
            }
        }
    }
    
    final void h() {
        if (!this.g) {
            if (n.a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int i = -1 + this.b.a(); i >= 0; --i) {
                ((o)this.b.b(i)).b();
            }
            this.b.b();
        }
        if (n.a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int j = -1 + this.c.a(); j >= 0; --j) {
            ((o)this.c.b(j)).b();
        }
        this.c.b();
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        android.support.v4.b.c.a(this.e, sb);
        sb.append("}}");
        return sb.toString();
    }
}
