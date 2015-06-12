// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import java.io.PrintWriter;
import android.util.Log;
import android.support.v4.content.c;
import android.os.Bundle;
import android.support.v4.content.d;

final class o implements d
{
    final int a;
    final Bundle b;
    m c;
    c d;
    boolean e;
    boolean f;
    Object g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    o n;
    final /* synthetic */ n o;
    
    final void a() {
        if (android.support.v4.app.n.a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.h = false;
        if (!this.i && this.d != null && this.m) {
            this.m = false;
            this.d.a(this);
            this.d.b();
        }
    }
    
    final void a(final c obj, final Object o) {
        if (this.c == null) {
            return;
        }
        while (true) {
            Label_0184: {
                if (this.o.e == null) {
                    break Label_0184;
                }
                final String u = this.o.e.b.u;
                this.o.e.b.u = "onLoadFinished";
                final String s = u;
                try {
                    if (android.support.v4.app.n.a) {
                        final StringBuilder append = new StringBuilder("  onLoadFinished in ").append(obj).append(": ");
                        final StringBuilder sb = new StringBuilder(64);
                        android.support.v4.b.c.a(o, sb);
                        sb.append("}");
                        Log.v("LoaderManager", append.append(sb.toString()).toString());
                    }
                    final m c = this.c;
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
    
    public final void a(String string, final PrintWriter printWriter) {
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
                this.d.a(string + "  ", printWriter);
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
        while (true) {
            if (android.support.v4.app.n.a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l = true;
            final boolean f = this.f;
            this.f = false;
            Label_0173: {
                if (this.c == null || this.d == null || !this.e || !f) {
                    break Label_0173;
                }
                if (android.support.v4.app.n.a) {
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
                    final m c = this.c;
                    final c d = this.d;
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
                        this.d.c();
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
        android.support.v4.b.c.a(this.d, sb);
        sb.append("}}");
        return sb.toString();
    }
}
