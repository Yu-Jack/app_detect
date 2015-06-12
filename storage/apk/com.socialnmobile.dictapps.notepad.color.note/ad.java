import android.database.ContentObserver;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

// 
// Decompiled by Procyon v0.5.29
// 

public class ad extends ab
{
    final af f;
    Uri g;
    String[] h;
    String i;
    String[] j;
    String k;
    Cursor l;
    
    public ad(final Context context) {
        super(context);
        this.f = new af(this);
    }
    
    private void a(final Cursor l) {
        if (super.r) {
            if (l != null) {
                l.close();
            }
        }
        else {
            final Cursor i = this.l;
            this.l = l;
            if (super.p) {
                super.b(l);
            }
            if (i != null && i != l && !i.isClosed()) {
                i.close();
            }
        }
    }
    
    @Override
    public final void a(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.a(s, fileDescriptor, printWriter, array);
        printWriter.print(s);
        printWriter.print("mUri=");
        printWriter.println(this.g);
        printWriter.print(s);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.h));
        printWriter.print(s);
        printWriter.print("mSelection=");
        printWriter.println(this.i);
        printWriter.print(s);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.j));
        printWriter.print(s);
        printWriter.print("mSortOrder=");
        printWriter.println(this.k);
        printWriter.print(s);
        printWriter.print("mCursor=");
        printWriter.println(this.l);
        printWriter.print(s);
        printWriter.print("mContentChanged=");
        printWriter.println(this.s);
    }
    
    public Cursor e() {
        final Cursor query = super.o.getContentResolver().query(this.g, this.h, this.i, this.j, this.k);
        if (query != null) {
            query.getCount();
            query.registerContentObserver((ContentObserver)this.f);
        }
        return query;
    }
    
    @Override
    protected final void f() {
        if (this.l != null) {
            this.a(this.l);
        }
        final boolean s = super.s;
        super.s = false;
        super.t |= s;
        if (s || this.l == null) {
            this.j();
        }
    }
    
    @Override
    protected final void g() {
        this.b();
    }
    
    @Override
    protected final void h() {
        super.h();
        this.b();
        if (this.l != null && !this.l.isClosed()) {
            this.l.close();
        }
        this.l = null;
    }
}
