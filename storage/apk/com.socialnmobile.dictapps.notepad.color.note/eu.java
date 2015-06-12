import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import com.flurry.android.monolithic.sdk.impl.jc;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.Set;

// 
// Decompiled by Procyon v0.5.29
// 

final class eu implements Runnable
{
    final /* synthetic */ fa a;
    final /* synthetic */ es b;
    
    eu(final es b) {
        this.b = b;
        this.a = null;
    }
    
    @Override
    public final void run() {
        final es b = this.b;
        es.a();
        try {
            es.a(this.b);
            if (this.a != null) {
                final fa a = this.a;
            }
        }
        catch (Exception ex) {
            es.f;
            gj.b("retransmitNotSentBlocks error", ex);
        }
    }
}
