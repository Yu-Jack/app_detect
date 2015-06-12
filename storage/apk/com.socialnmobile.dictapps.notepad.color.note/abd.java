import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.view.ScreenGridList;

// 
// Decompiled by Procyon v0.5.29
// 

public final class abd implements Runnable
{
    final /* synthetic */ ScreenGridList a;
    
    public abd(final ScreenGridList a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        ColorNote.a("Couldn't load cursor in GridList");
        this.a.setGridListViewOptions(this.a.k.b, this.a.k.c, this.a.k.e, this.a.k.f, this.a.k.g, this.a.k.d, true, true);
    }
}
