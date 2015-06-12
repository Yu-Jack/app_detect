import android.content.Context;
import com.socialnmobile.colornote.fragment.AbstractEditorViewer;

// 
// Decompiled by Procyon v0.5.29
// 

public final class mc implements lh
{
    final /* synthetic */ AbstractEditorViewer a;
    
    public mc(final AbstractEditorViewer a) {
        this.a = a;
    }
    
    @Override
    public final boolean a(final String s) {
        if (this.a.ag) {
            if (jq.a((Context)this.a.h(), s)) {
                this.a.af = s;
                this.a.ah = true;
                this.a.I();
                return true;
            }
        }
        else if (jq.a((Context)this.a.h(), s)) {
            this.a.af = s;
            this.a.Y.requery();
            return true;
        }
        return false;
    }
}
