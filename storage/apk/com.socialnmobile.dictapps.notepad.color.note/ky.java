import android.view.View;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

final class ky implements View$OnClickListener
{
    final /* synthetic */ kx a;
    
    ky(final kx a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        int n = 8;
        switch (view.getId()) {
            case 2131624011: {
                n = 1;
                break;
            }
            case 2131624013: {
                n = 2;
                break;
            }
            case 2131624015: {
                n = 3;
                break;
            }
            case 2131624017: {
                n = 4;
                break;
            }
            case 2131624019: {
                n = 5;
                break;
            }
            case 2131624021: {
                n = 6;
                break;
            }
            case 2131624023: {
                n = 7;
                break;
            }
            case 2131624027: {
                n = 9;
                break;
            }
        }
        if (this.a.a != null) {
            this.a.a.a(n);
        }
        this.a.dismiss();
    }
}
