import android.view.animation.AnimationUtils;
import android.view.View;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

final class le implements View$OnClickListener
{
    final /* synthetic */ ld a;
    
    le(final ld a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        if (this.a.d.a(this.a.b.getText().toString().trim())) {
            this.a.dismiss();
            return;
        }
        this.a.b.startAnimation(AnimationUtils.loadAnimation(this.a.getContext(), 2130968583));
        this.a.b.setText((CharSequence)"");
    }
}
