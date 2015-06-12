import android.content.DialogInterface;
import android.content.Context;
import android.app.Dialog;
import android.content.DialogInterface$OnCancelListener;
import android.support.v4.app.DialogFragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class lc extends DialogFragment
{
    lh Y;
    DialogInterface$OnCancelListener Z;
    int aa;
    
    public lc(final lh y) {
        this.Y = y;
        this.Z = null;
        this.aa = 0;
        this.o();
    }
    
    @Override
    public final Dialog b() {
        return new ld((Context)super.C, this.Y, null, this.aa);
    }
    
    @Override
    public final void onCancel(final DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        if (this.Z != null) {
            this.Z.onCancel(dialogInterface);
        }
    }
    
    @Override
    public final void w() {
        super.w();
        this.a(false);
    }
}
