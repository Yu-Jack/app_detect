import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ub
{
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    
    private ub(final String a, final String b, final String c, final String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static ub a(final Context context) {
        final String a = wk.a(context);
        final int a2 = gv.a(context);
        String s;
        if (a2 >= 720) {
            s = "tablet-large";
        }
        else if (a2 >= 600) {
            s = "tablet-small";
        }
        else if (a2 >= 320) {
            s = "phone";
        }
        else {
            s = "wearable";
        }
        return new ub("android", s, a, wk.a(a));
    }
    
    public final xj a() {
        final xj xj = new xj();
        xj.a("platform", this.a);
        xj.a("type", this.b);
        xj.a("colornote_version", this.c);
        xj.a("user_agent", this.d);
        return xj;
    }
}
