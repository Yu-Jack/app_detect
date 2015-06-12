import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.os.SystemClock;
import android.content.Context;
import android.os.Handler;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class ab extends ae
{
    volatile ac a;
    volatile ac b;
    long c;
    long d;
    Handler e;
    
    public ab(final Context context) {
        super(context);
        this.d = -10000L;
    }
    
    @Override
    protected final void a() {
        super.a();
        this.b();
        this.a = new ac(this);
        this.c();
    }
    
    final void a(final ac ac, final Object o) {
        this.a(o);
        if (this.b == ac) {
            if (super.t) {
                super.s = true;
            }
            this.d = SystemClock.uptimeMillis();
            this.b = null;
            this.c();
        }
    }
    
    public void a(final Object o) {
    }
    
    @Override
    public void a(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.a(s, fileDescriptor, printWriter, array);
        if (this.a != null) {
            printWriter.print(s);
            printWriter.print("mTask=");
            printWriter.print(this.a);
            printWriter.print(" waiting=");
            printWriter.println(this.a.b);
        }
        if (this.b != null) {
            printWriter.print(s);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.b);
            printWriter.print(" waiting=");
            printWriter.println(this.b.b);
        }
        if (this.c != 0L) {
            printWriter.print(s);
            printWriter.print("mUpdateThrottle=");
            bi.formatDuration(this.c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            bi.formatDuration(this.d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
    
    public final boolean b() {
        if (this.a != null) {
            if (this.b != null) {
                if (this.a.b) {
                    this.a.b = false;
                    this.e.removeCallbacks((Runnable)this.a);
                }
                this.a = null;
            }
            else {
                if (this.a.b) {
                    this.a.b = false;
                    this.e.removeCallbacks((Runnable)this.a);
                    this.a = null;
                    return false;
                }
                final boolean d = this.a.d();
                if (d) {
                    this.b = this.a;
                }
                this.a = null;
                return d;
            }
        }
        return false;
    }
    
    final void c() {
        if (this.b == null && this.a != null) {
            if (this.a.b) {
                this.a.b = false;
                this.e.removeCallbacks((Runnable)this.a);
            }
            if (this.c <= 0L || SystemClock.uptimeMillis() >= this.d + this.c) {
                this.a.a(ah.d);
                return;
            }
            this.a.b = true;
            this.e.postAtTime((Runnable)this.a, this.d + this.c);
        }
    }
    
    public abstract Object d();
}
