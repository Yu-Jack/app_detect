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

final class et implements Runnable
{
    final /* synthetic */ es a;
    
    et(final es a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        final es a = this.a;
        es.a();
        try {
            this.a.d = new fe();
        }
        catch (Exception ex) {
            es.f;
            gj.b("initialization of FlurryDataSenderIndex error", ex);
        }
    }
}
