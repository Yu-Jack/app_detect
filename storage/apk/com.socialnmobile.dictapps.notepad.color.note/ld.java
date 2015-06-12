import android.view.View$OnClickListener;
import android.content.DialogInterface$OnCancelListener;
import android.content.Context;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.app.Dialog;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ld extends Dialog
{
    Button a;
    EditText b;
    TextView c;
    lh d;
    
    public ld(final Context context, final lh d, final DialogInterface$OnCancelListener onCancelListener, final int text) {
        super(context);
        this.setTitle(2131230983);
        this.setContentView(2130903054);
        this.a = (Button)this.findViewById(2131624035);
        this.b = (EditText)this.findViewById(2131624034);
        this.c = (TextView)this.findViewById(2131624033);
        if (text != 0) {
            this.c.setText(text);
        }
        else {
            this.c.setVisibility(8);
        }
        this.d = d;
        if (onCancelListener != null) {
            this.setOnCancelListener(onCancelListener);
        }
        this.a.setOnClickListener((View$OnClickListener)new le(this));
    }
    
    public final boolean onSearchRequested() {
        return false;
    }
    
    protected final void onStart() {
        super.onStart();
        this.getWindow().setSoftInputMode(4);
        this.b.setText((CharSequence)"");
        this.b.post((Runnable)new lf(this));
    }
    
    protected final void onStop() {
        super.onStop();
        this.b.post((Runnable)new lg(this));
    }
}
