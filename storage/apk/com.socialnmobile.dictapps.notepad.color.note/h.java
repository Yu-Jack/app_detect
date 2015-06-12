import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.os.Handler;

// 
// Decompiled by Procyon v0.5.29
// 

public final class h extends Handler
{
    final /* synthetic */ FragmentActivity a;
    
    public h(final FragmentActivity a) {
        this.a = a;
    }
    
    public final void handleMessage(final Message message) {
        switch (message.what) {
            default: {
                super.handleMessage(message);
                break;
            }
            case 1: {
                if (this.a.f) {
                    this.a.a(false);
                    return;
                }
                break;
            }
            case 2: {
                this.a.a_();
                this.a.b.f();
            }
        }
    }
}
