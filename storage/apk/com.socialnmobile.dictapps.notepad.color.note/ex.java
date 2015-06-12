import android.widget.Toast;

// 
// Decompiled by Procyon v0.5.29
// 

final class ex implements Runnable
{
    final /* synthetic */ int a;
    final /* synthetic */ ew b;
    
    ex(final ew b, final int a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void run() {
        Toast.makeText(fq.a.b, (CharSequence)("SD HTTP Response Code: " + this.a), 0).show();
    }
}
