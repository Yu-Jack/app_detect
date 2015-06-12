import android.content.Context;
import android.content.DialogInterface;
import com.socialnmobile.colornote.fragment.AbstractEditorViewer;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class mm implements DialogInterface$OnClickListener
{
    final /* synthetic */ AbstractEditorViewer a;
    
    public mm(final AbstractEditorViewer a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.P();
        kg.a((Context)this.a.h(), this.a.c, this.a.Z.m);
        this.a.Y.requery();
    }
}
