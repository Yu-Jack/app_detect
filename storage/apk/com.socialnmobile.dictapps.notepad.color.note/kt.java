import com.socialnmobile.colornote.data.NoteProvider;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class kt
{
    static kt a;
    Context b;
    public kl c;
    public kj d;
    
    private kt(final Context b) {
        this.b = b;
    }
    
    public static kt a(final Context context) {
        if (kt.a == null) {
            kt.a = new kt(context.getApplicationContext());
        }
        return kt.a;
    }
    
    public final void a() {
        this.b.deleteDatabase("colornote_temp.db");
    }
    
    public final void a(final boolean b) {
        if (b) {
            if (this.c == null) {
                this.a();
                this.c = new kl(this.b, "colornote_temp.db");
                this.d = null;
            }
            NoteProvider.c(this.b());
            return;
        }
        this.c = new kl(this.b, "colornote_temp.db");
        this.d = null;
    }
    
    public final kj b() {
        if (this.d == null) {
            if (this.c == null) {
                this.c = new kl(this.b, "colornote_temp.db");
            }
            this.d = new kj(this.c.getWritableDatabase());
        }
        return this.d;
    }
}
