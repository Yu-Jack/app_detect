import com.nuance.nmdp.speechkit.recognitionresult.b;
import android.os.Handler;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class a
{
    protected final Object a;
    private final Handler b;
    
    public a(final Object o) {
        this.b = (Handler)o;
        this.a = new Object();
    }
    
    protected final void a(final Runnable runnable) {
        Label_0023: {
            if (this.b != null) {
                break Label_0023;
            }
            try {
                runnable.run();
                return;
            }
            catch (Throwable t) {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Exception in application callback", t);
                return;
            }
            try {
                if (!this.b.post(runnable)) {
                    com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to post callback to handler");
                }
            }
            catch (Throwable t2) {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Exception posting callback to handler", t2);
            }
        }
    }
}
