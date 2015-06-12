import android.view.View;
import com.socialnmobile.colornote.fragment.AbstractEditorViewer;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class mr implements View$OnClickListener
{
    final /* synthetic */ AbstractEditorViewer a;
    
    public mr(final AbstractEditorViewer a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        if (this.a.aa) {
            this.a.d(102);
        }
        else {
            switch (this.a.b) {
                default: {}
                case 1:
                case 2: {
                    this.a.S();
                }
                case 3: {
                    if (this.a.Z.c == 0) {
                        this.a.a(false, "BUTTON");
                        return;
                    }
                    if (this.a.Z.c == 16) {
                        this.a.d(102);
                        return;
                    }
                    break;
                }
            }
        }
    }
}
