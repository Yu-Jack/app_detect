import android.text.Spannable;
import com.socialnmobile.colornote.util.LinkText;
import android.content.Context;
import java.util.ArrayList;
import android.text.SpannableString;

// 
// Decompiled by Procyon v0.5.29
// 

public final class jx
{
    public String a;
    public SpannableString b;
    int c;
    public int d;
    public ArrayList e;
    
    public jx(final String s, final boolean b) {
        this.a(s);
        this.a(b);
    }
    
    public final void a(final Context context, final boolean b) {
        if (this.d == 0) {
            this.b = LinkText.a(context, b, this.a);
            if (this.b == null) {
                this.d = 2;
                return;
            }
            this.e = LinkText.a(this.b);
            if (this.e.size() <= 0) {
                this.d = 2;
                return;
            }
            LinkText.a((Spannable)this.b);
            this.d = 1;
        }
    }
    
    public final void a(final String a) {
        this.a = a;
        this.d = 0;
        this.b = null;
        this.e = null;
    }
    
    public final void a(final boolean b) {
        if (b) {
            this.c = 0;
            return;
        }
        this.c = 1;
    }
    
    public final boolean a() {
        return this.c == 0;
    }
}
