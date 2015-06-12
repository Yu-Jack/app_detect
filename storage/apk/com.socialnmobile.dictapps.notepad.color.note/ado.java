import com.socialnmobile.util.service.ServiceJob;
import com.socialnmobile.util.service.JobService;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ado implements abk
{
    final /* synthetic */ JobService a;
    private final /* synthetic */ ServiceJob b;
    
    public ado(final JobService a, final ServiceJob b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void a() {
        if (this.b.listener != null) {
            this.b.listener.onInit();
        }
    }
    
    @Override
    public final void b() {
        if (this.b.listener != null) {
            this.b.listener.onFinalize();
        }
    }
}
