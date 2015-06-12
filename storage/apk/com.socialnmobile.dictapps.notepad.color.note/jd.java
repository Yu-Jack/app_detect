import android.content.DialogInterface;
import com.socialnmobile.colornote.activity.Today;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class jd implements DialogInterface$OnClickListener
{
    final /* synthetic */ Today a;
    
    public jd(final Today a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.b(2);
    }
}
