import android.database.Cursor;
import android.content.Context;
import com.socialnmobile.colornote.fragment.TextEditor;
import android.widget.SimpleCursorAdapter;

// 
// Decompiled by Procyon v0.5.29
// 

public final class qj extends SimpleCursorAdapter
{
    final /* synthetic */ TextEditor a;
    
    public qj(final TextEditor a, final Context context, final String[] array, final int[] array2) {
        this.a = a;
        super(context, 17367043, (Cursor)null, array, array2);
    }
    
    public final CharSequence convertToString(final Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("suggest_text_1"));
    }
}
