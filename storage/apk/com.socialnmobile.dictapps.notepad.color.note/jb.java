import android.content.DialogInterface;
import com.socialnmobile.colornote.activity.Today;
import android.content.DialogInterface$OnCancelListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class jb implements DialogInterface$OnCancelListener
{
    final /* synthetic */ Today a;
    
    public jb(final Today a) {
        this.a = a;
    }
    
    public final void onCancel(final DialogInterface dialogInterface) {
        this.a.finish();
    }
}
