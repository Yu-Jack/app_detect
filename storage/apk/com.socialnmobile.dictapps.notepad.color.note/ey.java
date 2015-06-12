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

final class ey implements Runnable
{
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ es d;
    
    ey(final es d, final int a, final String b, final String c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        if (this.a == 200) {
            final fh d = em.a().d();
            if (d != null) {
                d.a();
            }
        }
        final es d2 = this.d;
        es.a();
        if (!this.d.d.a(this.b, this.c)) {
            es.f;
            gj.a(6, "Internal error. Block wasn't deleted with id = " + this.b);
        }
        if (!this.d.e.remove(this.b)) {
            es.f;
            gj.a(6, "Internal error. Block with id = " + this.b + " was not in progress state");
        }
    }
}
