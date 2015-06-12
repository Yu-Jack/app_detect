import com.socialnmobile.colornote.view.ScreenGridList;

// 
// Decompiled by Procyon v0.5.29
// 

public final class abb implements Runnable
{
    final /* synthetic */ ScreenGridList a;
    
    public abb(final ScreenGridList a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        this.a.setMainTitle();
    }
}
