import java.io.PrintWriter;
import java.io.FileDescriptor;
import java.lang.reflect.Modifier;
import android.util.Log;
import android.os.Bundle;

// 
// Decompiled by Procyon v0.5.29
// 

final class y implements ag
{
    final int a;
    final Bundle b;
    w c;
    ae d;
    boolean e;
    boolean f;
    Object g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    y n;
    final /* synthetic */ x o;
    
    public y(final x o, final int a, final Bundle b, final w c) {
        this.o = o;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    final void a() {
        if (this.i && this.j) {
            this.h = true;
        }
        else if (!this.h) {
            this.h = true;
            if (x.a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (this.d == null && this.c != null) {
                final w c = this.c;
                final int a = this.a;
                this.d = c.a_(this.b);
            }
            if (this.d != null) {
                if (this.d.getClass().isMemberClass() && !Modifier.isStatic(this.d.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.d);
                }
                if (!this.m) {
                    final ae d = this.d;
                    final int a2 = this.a;
                    if (d.n != null) {
                        throw new IllegalStateException("There is already a listener registered");
                    }
                    d.n = this;
                    d.m = a2;
                    this.m = true;
                }
                this.d.i();
            }
        }
    }
    
    @Override
    public final void a(final ae ae, final Object g) {
        if (x.a) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (this.l) {
            if (x.a) {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
            }
        }
        else if (this.o.b.a(this.a) != this) {
            if (x.a) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
        }
        else {
            final y n = this.n;
            if (n != null) {
                if (x.a) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + n);
                }
                this.n = null;
                this.o.b.a(this.a, null);
                this.c();
                this.o.a(n);
                return;
            }
            if (this.g != g || !this.e) {
                this.g = g;
                this.e = true;
                if (this.h) {
                    this.b(ae, g);
                }
            }
            final y y = (y)this.o.c.a(this.a);
            if (y != null && y != this) {
                y.f = false;
                y.c();
                this.o.c.b(this.a);
            }
            if (this.o.e != null && !this.o.a()) {
                this.o.e.b.e();
            }
        }
    }
    
    public final void a(String string, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        while (true) {
            printWriter.print(string);
            printWriter.print("mId=");
            printWriter.print(this.a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(string);
            printWriter.print("mCallbacks=");
            printWriter.println(this.c);
            printWriter.print(string);
            printWriter.print("mLoader=");
            printWriter.println(this.d);
            if (this.d != null) {
                this.d.a(string + "  ", fileDescriptor, printWriter, array);
            }
            if (this.e || this.f) {
                printWriter.print(string);
                printWriter.print("mHaveData=");
                printWriter.print(this.e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f);
                printWriter.print(string);
                printWriter.print("mData=");
                printWriter.println(this.g);
            }
            printWriter.print(string);
            printWriter.print("mStarted=");
            printWriter.print(this.h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.l);
            printWriter.print(string);
            printWriter.print("mRetaining=");
            printWriter.print(this.i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.m);
            if (this.n == null) {
                break;
            }
            printWriter.print(string);
            printWriter.println("Pending Loader ");
            printWriter.print(this.n);
            printWriter.println(":");
            this = this.n;
            string += "  ";
        }
    }
    
    final void b() {
        if (x.a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.h = false;
        if (!this.i && this.d != null && this.m) {
            this.m = false;
            this.d.a(this);
            this.d.k();
        }
    }
    
    final void b(final ae obj, final Object o) {
        if (this.c == null) {
            return;
        }
        while (true) {
            Label_0192: {
                if (this.o.e == null) {
                    break Label_0192;
                }
                final String u = this.o.e.b.u;
                this.o.e.b.u = "onLoadFinished";
                final String s = u;
                try {
                    if (x.a) {
                        final StringBuilder append = new StringBuilder("  onLoadFinished in ").append(obj).append(": ");
                        final StringBuilder sb = new StringBuilder(64);
                        ay.a(o, sb);
                        sb.append("}");
                        Log.v("LoaderManager", append.append(sb.toString()).toString());
                    }
                    this.c.a(obj, o);
                    if (this.o.e != null) {
                        this.o.e.b.u = s;
                    }
                    this.f = true;
                    return;
                }
                finally {
                    if (this.o.e != null) {
                        this.o.e.b.u = s;
                    }
                }
            }
            final String s = null;
            continue;
        }
    }
    
    final void c() {
        while (true) {
            if (x.a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l = true;
            final boolean f = this.f;
            this.f = false;
            Label_0179: {
                if (this.c == null || this.d == null || !this.e || !f) {
                    break Label_0179;
                }
                if (x.a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                String s;
                if (this.o.e != null) {
                    final String u = this.o.e.b.u;
                    this.o.e.b.u = "onLoaderReset";
                    s = u;
                }
                else {
                    s = null;
                }
                try {
                    this.c.a(this.d);
                    if (this.o.e != null) {
                        this.o.e.b.u = s;
                    }
                    this.c = null;
                    this.g = null;
                    this.e = false;
                    if (this.d != null) {
                        if (this.m) {
                            this.m = false;
                            this.d.a(this);
                        }
                        this.d.l();
                    }
                    if (this.n != null) {
                        this = this.n;
                        continue;
                    }
                }
                finally {
                    if (this.o.e != null) {
                        this.o.e.b.u = s;
                    }
                }
            }
            break;
        }
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder(64);
        sb.append("LoaderInfo{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" #");
        sb.append(this.a);
        sb.append(" : ");
        ay.a(this.d, sb);
        sb.append("}}");
        return sb.toString();
    }
}
