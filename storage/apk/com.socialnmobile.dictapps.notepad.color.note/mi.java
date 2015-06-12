import android.widget.Toast;
import android.content.Context;
import android.content.DialogInterface;
import com.socialnmobile.colornote.fragment.AbstractEditorViewer;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class mi implements DialogInterface$OnClickListener
{
    final /* synthetic */ AbstractEditorViewer a;
    
    public mi(final AbstractEditorViewer a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        if (!this.a.aa) {
            kg.a((Context)this.a.h(), this.a.c);
            this.a.Y.requery();
            return;
        }
        if (kg.f((Context)this.a.h(), this.a.c)) {
            Toast.makeText((Context)this.a.h(), 2131230858, 0).show();
            return;
        }
        Toast.makeText((Context)this.a.h(), 2131230839, 0).show();
    }
}
