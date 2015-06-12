import java.io.PrintWriter;
import java.io.PrintStream;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class gm implements Runnable
{
    private static final String a;
    PrintStream c;
    PrintWriter d;
    
    static {
        a = gm.class.getSimpleName();
    }
    
    public abstract void a();
    
    @Override
    public final void run() {
        try {
            this.a();
        }
        catch (Throwable t) {
            if (this.c != null) {
                t.printStackTrace(this.c);
            }
            else if (this.d != null) {
                t.printStackTrace(this.d);
            }
            else {
                t.printStackTrace();
            }
            final String a = gm.a;
            gj.b("", t);
        }
    }
}
