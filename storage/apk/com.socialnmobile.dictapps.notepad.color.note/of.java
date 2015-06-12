import android.content.DialogInterface;
import com.socialnmobile.colornote.fragment.ListEditor;
import com.socialnmobile.colornote.fragment.ListEditor$EditDialogFragment;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class of implements DialogInterface$OnClickListener
{
    final /* synthetic */ ListEditor$EditDialogFragment a;
    private final /* synthetic */ ListEditor b;
    
    public of(final ListEditor$EditDialogFragment a, final ListEditor b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.aa = true;
        this.b.b(this.a.I());
        this.b.ar = true;
    }
}
