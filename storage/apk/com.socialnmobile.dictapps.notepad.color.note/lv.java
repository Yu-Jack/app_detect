import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.Context;
import android.content.DialogInterface$OnClickListener;
import android.widget.EditText;
import android.app.AlertDialog;

// 
// Decompiled by Procyon v0.5.29
// 

public final class lv extends AlertDialog
{
    EditText a;
    ma b;
    String c;
    DialogInterface$OnClickListener d;
    DialogInterface$OnClickListener e;
    
    public lv(final Context context, final ma b) {
        super(context);
        this.c = "";
        this.d = (DialogInterface$OnClickListener)new lw(this);
        this.e = (DialogInterface$OnClickListener)new lx(this);
        this.setTitle(2131230780);
        this.setView(LayoutInflater.from(context).inflate(2130903055, (ViewGroup)null));
        this.b = b;
        this.setButton(-1, context.getText(17039370), this.d);
        this.setButton(-2, context.getText(17039360), this.e);
    }
    
    public final void a(final String c) {
        this.c = c;
    }
    
    protected final void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.a = (EditText)this.findViewById(2131624032);
    }
    
    public final boolean onSearchRequested() {
        return false;
    }
    
    protected final void onStart() {
        super.onStart();
        this.getWindow().setSoftInputMode(4);
        this.a.setText((CharSequence)this.c);
        this.a.post((Runnable)new ly(this));
    }
    
    protected final void onStop() {
        super.onStop();
        this.a.post((Runnable)new lz(this));
    }
}
