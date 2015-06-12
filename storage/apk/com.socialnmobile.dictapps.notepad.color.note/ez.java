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

final class ez implements Runnable
{
    final /* synthetic */ String a;
    final /* synthetic */ es b;
    
    ez(final es b, final String a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void run() {
        final es b = this.b;
        es.a();
        if (!this.b.e.remove(this.a)) {
            es.f;
            gj.a(6, "Internal error. Block with id = " + this.a + " was not in progress state");
        }
    }
}
