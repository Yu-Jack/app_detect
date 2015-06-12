// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.content;

import android.support.v4.b.c;
import java.io.PrintWriter;

public final class c
{
    int a;
    d b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    
    public final void a() {
        this.c = true;
        this.e = false;
        this.d = false;
    }
    
    public final void a(final int a, final d b) {
        if (this.b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.b = b;
        this.a = a;
    }
    
    public final void a(final d d) {
        if (this.b == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.b != d) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.b = null;
    }
    
    public final void a(final String s, final PrintWriter printWriter) {
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
    
    public final void b() {
        this.c = false;
    }
    
    public final void c() {
        this.e = true;
        this.c = false;
        this.d = false;
        this.f = false;
        this.g = false;
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder(64);
        android.support.v4.b.c.a(this, sb);
        sb.append(" id=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
}
