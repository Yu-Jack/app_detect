import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable$Orientation;
import android.content.Context;
import android.view.View$OnClickListener;
import com.socialnmobile.colornote.view.MyImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

// 
// Decompiled by Procyon v0.5.29
// 

public final class abi
{
    public View a;
    View b;
    public TextView c;
    public TextView d;
    ImageView e;
    public MyImageButton[] f;
    public int[] g;
    public View$OnClickListener h;
    
    public abi(final View a) {
        this.f = new MyImageButton[3];
        this.g = new int[3];
        this.a = a;
        this.d = (TextView)a.findViewById(2131624086);
        this.e = (ImageView)a.findViewById(2131624087);
        this.f[0] = (MyImageButton)a.findViewById(2131624089);
        this.f[1] = (MyImageButton)a.findViewById(2131624090);
        this.f[2] = (MyImageButton)a.findViewById(2131624091);
        this.b = a.findViewById(2131624084);
        this.c = (TextView)a.findViewById(2131624088);
        this.b.setOnClickListener((View$OnClickListener)new abj(this));
    }
    
    public final void a(final rc rc) {
        final Context context = this.a.getContext();
        this.g = new int[3];
        if (rc.f.equals(context.getString(2131230728))) {
            this.d.setVisibility(4);
            this.e.setVisibility(0);
        }
        else {
            this.d.setVisibility(0);
            this.e.setVisibility(4);
            this.d.setText((CharSequence)rc.f);
        }
        rc.d.get(0).a(this.f[0]);
        this.g[0] = rc.d.get(0).a;
        switch (rc.g) {
            case 1: {
                this.f[1].setVisibility(8);
                break;
            }
            case 2:
            case 3: {
                if (rc.d.size() == 1) {
                    this.f[1].setVisibility(8);
                    break;
                }
                rc.d.get(1).a(this.f[1]);
                this.g[1] = rc.d.get(1).a;
                break;
            }
        }
        if (rc.c.size() > 0) {
            this.f[2].setVisibility(0);
            if (rc.a()) {
                rc.b().a(this.f[2]);
            }
            else {
                gw.a(context.getResources(), (ImageView)this.f[2], 2130837606);
                this.f[2].setTitle(0);
            }
        }
        else {
            this.f[2].setVisibility(8);
        }
        for (final MyImageButton myImageButton : this.f) {
            myImageButton.setOnClickListener(rc.h);
            gw.b((View)myImageButton, (int)(56.0f * context.getResources().getDisplayMetrics().density));
        }
    }
    
    public final void a(final yc yc) {
        this.a.setBackgroundDrawable((Drawable)new GradientDrawable(GradientDrawable$Orientation.TOP_BOTTOM, new int[] { yc.n(6), yc.n(7) }));
        this.d.setTextColor(yc.n(8));
        this.a.findViewById(2131624083).setBackgroundColor(yc.n(9));
        this.e.setImageResource(yc.b());
    }
}
