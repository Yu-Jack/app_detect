import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

final class adm extends Thread
{
    final /* synthetic */ adl a;
    private final /* synthetic */ Context b;
    private final /* synthetic */ xj c;
    
    adm(final adl a, final Context b, final xj c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        try {
            final adl a = this.a;
            adl.a(this.b, this.c);
        }
        catch (SecurityException ex) {}
    }
}
