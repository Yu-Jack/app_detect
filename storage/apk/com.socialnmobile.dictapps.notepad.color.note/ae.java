import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public class ae
{
    public int m;
    public ag n;
    public Context o;
    boolean p;
    public boolean q;
    boolean r;
    boolean s;
    boolean t;
    
    public ae(final Context context) {
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = false;
        this.t = false;
        this.o = context.getApplicationContext();
    }
    
    protected void a() {
    }
    
    public final void a(final ag ag) {
        if (this.n == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.n != ag) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.n = null;
    }
    
    public void a(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.print(s);
        printWriter.print("mId=");
        printWriter.print(this.m);
        printWriter.print(" mListener=");
        printWriter.println(this.n);
        if (this.p || this.s || this.t) {
            printWriter.print(s);
            printWriter.print("mStarted=");
            printWriter.print(this.p);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.s);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.t);
        }
        if (this.q || this.r) {
            printWriter.print(s);
            printWriter.print("mAbandoned=");
            printWriter.print(this.q);
            printWriter.print(" mReset=");
            printWriter.println(this.r);
        }
    }
    
    public void b(final Object o) {
        if (this.n != null) {
            this.n.a(this, o);
        }
    }
    
    protected void f() {
    }
    
    protected void g() {
    }
    
    protected void h() {
    }
    
    public final void i() {
        this.p = true;
        this.r = false;
        this.q = false;
        this.f();
    }
    
    public final void j() {
        this.a();
    }
    
    public final void k() {
        this.p = false;
        this.g();
    }
    
    public final void l() {
        this.h();
        this.r = true;
        this.p = false;
        this.q = false;
        this.s = false;
        this.t = false;
    }
    
    public final void m() {
        if (this.p) {
            this.a();
            return;
        }
        this.s = true;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(64);
        ay.a(this, sb);
        sb.append(" id=");
        sb.append(this.m);
        sb.append("}");
        return sb.toString();
    }
}
