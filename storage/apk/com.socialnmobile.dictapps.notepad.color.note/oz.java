import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.content.ContentValues;
import android.content.Context;
import com.socialnmobile.colornote.fragment.NoteListFragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class oz implements lh
{
    final /* synthetic */ NoteListFragment a;
    
    public oz(final NoteListFragment a) {
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
                final kh kh = new kh();
                kh.a(query);
                query.close();
                final ContentValues contentValues = new ContentValues();
                contentValues.put("note", kh.a((Context)h));
                contentValues.put("encrypted", 0);
                contentValues.put("modified_date", 1L + kh.i);
                ((Context)h).getContentResolver().update(ac, contentValues, (String)null, (String[])null);
            }
            return true;
        }
        return false;
    }
}
