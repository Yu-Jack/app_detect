import android.widget.TextView;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageButton;
import android.content.Context;
import android.view.View$OnClickListener;
import android.app.Dialog;

// 
// Decompiled by Procyon v0.5.29
// 

public final class kx extends Dialog
{
    kz a;
    int b;
    int c;
    private View$OnClickListener d;
    
    public kx(final Context context, final int b, final int c) {
        super(context, 2131492871);
        this.d = (View$OnClickListener)new ky(this);
        this.b = b;
        this.c = c;
        this.setContentView(2130903052);
        this.setCanceledOnTouchOutside(true);
        this.a();
    }
    
    private void a(final int n, final int n2, final View$OnClickListener onClickListener, final int n3, final String text) {
        final ImageButton imageButton = (ImageButton)this.findViewById(n);
        imageButton.setOnClickListener(onClickListener);
        final GradientDrawable imageDrawable = (GradientDrawable)this.getContext().getResources().getDrawable(2130837527);
        imageDrawable.setColor(gr.a(this.getContext()).e(n3));
        imageButton.setImageDrawable((Drawable)imageDrawable);
        final TextView textView = (TextView)this.findViewById(n2);
        textView.setTextColor(gr.a(this.getContext()).l(n3));
        textView.setText((CharSequence)text);
        if (n3 == this.c) {
            imageButton.setSelected(true);
            return;
        }
        imageButton.setSelected(false);
    }
    
    public final void a() {
        this.a(2131624011, 2131624012, this.d, 1, jq.a(this.getContext(), this.b, 1));
        this.a(2131624013, 2131624014, this.d, 2, jq.a(this.getContext(), this.b, 2));
        this.a(2131624015, 2131624016, this.d, 3, jq.a(this.getContext(), this.b, 3));
        this.a(2131624017, 2131624018, this.d, 4, jq.a(this.getContext(), this.b, 4));
        this.a(2131624019, 2131624020, this.d, 5, jq.a(this.getContext(), this.b, 5));
        this.a(2131624021, 2131624022, this.d, 6, jq.a(this.getContext(), this.b, 6));
        this.a(2131624023, 2131624024, this.d, 7, jq.a(this.getContext(), this.b, 7));
        this.a(2131624025, 2131624026, this.d, 8, jq.a(this.getContext(), this.b, 8));
        this.a(2131624027, 2131624028, this.d, 9, jq.a(this.getContext(), this.b, 9));
    }
    
    public final void a(final int c) {
        this.c = c;
    }
    
    public final void a(final kz a) {
        this.a = a;
    }
}
