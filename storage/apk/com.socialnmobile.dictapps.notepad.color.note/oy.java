import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.content.ContentValues;
import android.content.Context;
import com.socialnmobile.colornote.fragment.NoteListFragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class oy implements lh
{
    final /* synthetic */ NoteListFragment a;
    
    public oy(final NoteListFragment a) {
        this.a = a;
    }
    
    @Override
    public final boolean a(final String s) {
        if (jq.a((Context)this.a.h(), s)) {
            final FragmentActivity h = this.a.h();
            final Uri ac = this.a.ac;
            final Cursor query = ((Context)h).getContentResolver().query(ac, (String[])null, (String)null, (String[])null, (String)null);
            if (!query.moveToNext()) {
                query.close();
            }
            else {
                final String string = query.getString(query.getColumnIndex("note"));
                final long long1 = query.getLong(query.getColumnIndex("modified_date"));
                query.close();
                final jz a = jz.a((Context)h);
                final int a2 = a.a;
                final String c = a.c(string);
                final ContentValues contentValues = new ContentValues();
                contentValues.put("note", c);
                contentValues.put("encrypted", a2);
                contentValues.put("modified_date", long1 + 1L);
                ((Context)h).getContentResolver().update(ac, contentValues, (String)null, (String[])null);
            }
            return true;
        }
        return false;
    }
}
