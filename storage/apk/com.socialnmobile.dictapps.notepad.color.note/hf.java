import android.content.DialogInterface;
import com.socialnmobile.colornote.activity.BackupLocal;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class hf implements DialogInterface$OnClickListener
{
    final /* synthetic */ BackupLocal a;
    
    public hf(final BackupLocal a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.a(3, this.a.j);
    }
}
