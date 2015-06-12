import android.content.Context;
import android.widget.Toast;
import com.socialnmobile.colornote.ColorNote;

// 
// Decompiled by Procyon v0.5.29
// 

public final class gp implements Runnable
{
    private final /* synthetic */ String a;
    
    public gp(final String a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        Toast.makeText((Context)ColorNote.b, (CharSequence)this.a, 1).show();
    }
}
