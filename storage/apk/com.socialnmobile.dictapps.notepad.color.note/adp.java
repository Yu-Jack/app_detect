import android.content.Context;
import com.socialnmobile.util.service.ServiceJob;
import com.socialnmobile.util.service.JobService;

// 
// Decompiled by Procyon v0.5.29
// 

public final class adp implements abr
{
    final /* synthetic */ JobService a;
    private final /* synthetic */ ServiceJob b;
    
    public adp(final JobService a, final ServiceJob b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void a() {
        this.b.onJobFinally();
    }
    
    @Override
    public final void a(final Exception ex) {
        if (!this.b.onJobException(ex)) {
            if (this.b.listener != null) {
                this.b.listener.onException(ex);
            }
            else {
                ex.printStackTrace();
            }
            if (ex instanceof RuntimeException) {
                adl.a.a((Context)this.a, ex);
            }
        }
    }
    
    @Override
    public final void a(final Object o) {
        this.b.onJobResult(o);
        if (this.b.listener != null) {
            this.b.listener.onFinished(o);
        }
    }
}
