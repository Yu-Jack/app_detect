import android.content.Intent;
import com.socialnmobile.colornote.activity.Main;

// 
// Decompiled by Procyon v0.5.29
// 

public final class hr implements Runnable
{
    final /* synthetic */ Main a;
    private final /* synthetic */ Intent b;
    
    public hr(final Main a, final Intent b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        if (this.a.y) {
            this.a.g();
            this.a.a(this.b);
        }
    }
}
