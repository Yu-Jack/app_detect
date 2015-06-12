import com.socialnmobile.colornote.ColorNote;
import android.app.Notification;
import com.socialnmobile.util.service.JobService;

// 
// Decompiled by Procyon v0.5.29
// 

public final class adn implements abk
{
    final /* synthetic */ JobService a;
    private final /* synthetic */ int b;
    private final /* synthetic */ Notification c;
    
    public adn(final JobService a, final Notification c) {
        this.a = a;
        this.b = 20;
        this.c = c;
    }
    
    @Override
    public final void a() {
        ColorNote.a();
        this.a.f.a(this.b, this.c);
    }
    
    @Override
    public final void b() {
        ColorNote.a();
        this.a.f.a(this.b);
    }
}
