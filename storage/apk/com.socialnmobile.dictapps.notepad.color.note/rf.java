import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.socialnmobile.colornote.view.MyImageButton;
import android.graphics.drawable.Drawable;

// 
// Decompiled by Procyon v0.5.29
// 

public final class rf
{
    public int a;
    public int b;
    public int c;
    public String d;
    boolean e;
    Drawable f;
    boolean g;
    public boolean h;
    public boolean i;
    
    public rf(final int n, final int n2, final int n3) {
        this(n, n2, n3, null);
    }
    
    public rf(final int a, final int b, final int c, final String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        if (b == 0) {
            this.e = false;
        }
        else {
            this.e = true;
        }
        this.g = false;
        this.h = true;
        this.i = true;
    }
    
    public final void a(final int b) {
        this.b = b;
        this.g = false;
    }
    
    public final void a(final Drawable f) {
        this.f = f;
        this.g = true;
        this.e = true;
    }
    
    public final void a(final MyImageButton myImageButton) {
        myImageButton.setVisibility(0);
        myImageButton.setBlockLayout(true);
        if (this.g) {
            ((ImageView)myImageButton).setImageDrawable(this.f);
        }
        else {
            gw.a(((ImageView)myImageButton).getResources(), (ImageView)myImageButton, this.b);
            if (((ImageView)myImageButton).getDrawable() instanceof BitmapDrawable) {
                final float density = ((ImageView)myImageButton).getResources().getDisplayMetrics().density;
                ((ImageView)myImageButton).setImageDrawable((Drawable)new BitmapDrawable(((ImageView)myImageButton).getResources(), Bitmap.createScaledBitmap(((BitmapDrawable)((ImageView)myImageButton).getDrawable()).getBitmap(), (int)(36.0f * density), (int)(density * 36.0f), true)));
            }
        }
        myImageButton.setBlockLayout(false);
        myImageButton.setTitle(this.c);
    }
}
