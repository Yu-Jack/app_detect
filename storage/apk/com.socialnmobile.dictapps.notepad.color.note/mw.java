import android.content.Context;
import android.os.Handler;
import android.database.Cursor;
import com.socialnmobile.colornote.fragment.AbstractEditorViewer;
import android.database.ContentObserver;

// 
// Decompiled by Procyon v0.5.29
// 

public final class mw extends ContentObserver
{
    final /* synthetic */ AbstractEditorViewer a;
    private final /* synthetic */ Cursor b;
    
    public mw(final AbstractEditorViewer a, final Handler handler, final Cursor b) {
        this.a = a;
        this.b = b;
        super(handler);
    }
    
    public final void onChange(final boolean b) {
        if (!this.b.isClosed() && this.a.Z != null && this.a.h() != null && this.a.c != null) {
            final long o = this.a.Z.o;
            final Cursor query = ((Context)this.a.h()).getContentResolver().query(this.a.c, (String[])null, (String)null, (String[])null, (String)null);
            long long1 = 0L;
            if (query.moveToNext()) {
                long1 = query.getLong(query.getColumnIndex("revision"));
            }
            query.close();
            if (o < long1) {
                this.b.requery();
            }
        }
    }
}
