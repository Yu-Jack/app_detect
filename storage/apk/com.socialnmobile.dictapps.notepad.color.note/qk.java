import android.net.Uri;
import android.database.MatrixCursor;
import android.database.Cursor;
import com.socialnmobile.colornote.fragment.TextEditor;
import android.widget.FilterQueryProvider;

// 
// Decompiled by Procyon v0.5.29
// 

public final class qk implements FilterQueryProvider
{
    final /* synthetic */ TextEditor a;
    
    public qk(final TextEditor a) {
        this.a = a;
    }
    
    public final Cursor runQuery(final CharSequence obj) {
        if (obj == null) {
            return null;
        }
        if (obj.length() == 0) {
            return (Cursor)new MatrixCursor(new String[] { "_id", "suggest_text_1" });
        }
        return this.a.h().getContentResolver().query(Uri.parse("content://com.socialnmobile.colordict.colordictprovider/search_suggest_query/" + (Object)obj), (String[])null, (String)null, (String[])null, (String)null);
    }
}
