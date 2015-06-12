import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

final class lw implements DialogInterface$OnClickListener
{
    final /* synthetic */ lv a;
    
    lw(final lv a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.b.a(this.a.a.getText().toString().trim());
    }
}
