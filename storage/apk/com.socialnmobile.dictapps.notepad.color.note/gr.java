import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class gr
{
    private static yc a;
    
    public static yc a(final Context context) {
        if (gr.a == null) {
            b(context);
        }
        return gr.a;
    }
    
    public static void b(final Context context) {
        if (jp.h(context).equals("COLORTABLE/DEFAULT")) {
            gr.a = new ya();
            return;
        }
        if (jp.h(context).equals("COLORTABLE/DARK")) {
            gr.a = new xz();
            return;
        }
        if (jp.h(context).equals("COLORTABLE/SOFT")) {
            gr.a = new yb();
            return;
        }
        gr.a = new ya();
    }
}
