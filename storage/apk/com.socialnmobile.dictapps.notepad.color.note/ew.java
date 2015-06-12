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

final class ew implements fd
{
    final /* synthetic */ es a;
    
    ew(final es a) {
        this.a = a;
    }
    
    @Override
    public final void a(final int i, final String str, final String str2, final String s) {
        es.f;
        gj.a(5, "--onReport " + str2 + " sent. HTTP response: " + i + " : " + str);
        if (gj.b() <= 3) {
            fq.a.c.post((Runnable)new ex(this, i));
        }
        es.a(this.a, str2, s, i);
        this.a.c();
    }
    
    @Override
    public final void a(final String str) {
        es.f;
        gj.a(5, "--onServerError " + str);
        es.a(this.a, str);
    }
}
