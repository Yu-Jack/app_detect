import android.content.DialogInterface;
import com.socialnmobile.colornote.fragment.ListEditor;
import com.socialnmobile.colornote.fragment.ListEditor$EditDialogFragment;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class og implements DialogInterface$OnClickListener
{
    final /* synthetic */ ListEditor$EditDialogFragment a;
    private final /* synthetic */ ListEditor b;
    
    public og(final ListEditor$EditDialogFragment a, final ListEditor b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        final String i = this.a.I();
        this.b.c(i);
        if (!"".equals(i)) {
            this.a.aa = false;
        }
        else {
            this.a.aa = true;
        }
        this.b.ar = true;
    }
}
