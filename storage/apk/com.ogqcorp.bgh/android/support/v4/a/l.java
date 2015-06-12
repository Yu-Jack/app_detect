// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.a;

import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.support.v4.c.c;

public class l<D>
{
    int a;
    m<D> b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    
    public String a(final D n) {
        final StringBuilder sb = new StringBuilder(64);
        android.support.v4.c.c.a(n, sb);
        sb.append("}");
        return sb.toString();
    }
    
    public final void a() {
        this.c = true;
        this.e = false;
        this.d = false;
        this.b();
    }
    
    public void a(final int a, final m<D> b) {
        if (this.b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.b = b;
        this.a = a;
    }
    
    public void a(final m<D> m) {
        if (this.b == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.b != m) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.b = null;
    }
    
    public void a(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.print(s);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mListener=");
        printWriter.println(this.b);
        if (this.c || this.f || this.g) {
            printWriter.print(s);
            printWriter.print("mStarted=");
            printWriter.print(this.c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.g);
        }
        if (this.d || this.e) {
            printWriter.print(s);
            printWriter.print("mAbandoned=");
            printWriter.print(this.d);
            printWriter.print(" mReset=");
            printWriter.println(this.e);
        }
    }
    
    protected void b() {
    }
    
    public void c() {
        this.c = false;
        this.d();
    }
    
    protected void d() {
    }
    
    public void e() {
        this.d = true;
        this.f();
    }
    
    protected void f() {
    }
    
    public void g() {
        this.h();
        this.e = true;
        this.c = false;
        this.d = false;
        this.f = false;
        this.g = false;
    }
    
    protected void h() {
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(64);
        android.support.v4.c.c.a(this, sb);
        sb.append(" id=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
}
