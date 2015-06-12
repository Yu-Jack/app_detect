import java.util.Iterator;
import android.database.Cursor;
import android.content.ContentValues;
import android.support.v4.app.FragmentActivity;
import android.content.ContentUris;
import android.net.Uri;
import java.util.ArrayList;
import android.content.Context;
import com.socialnmobile.colornote.ColorNote;
import android.content.DialogInterface;
import com.socialnmobile.colornote.fragment.RecycleBinFragment;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class pm implements DialogInterface$OnClickListener
{
    final /* synthetic */ RecycleBinFragment a;
    
    public pm(final RecycleBinFragment a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        final FragmentActivity h = this.a.h();
        ColorNote.a((Context)h, "NOTE", "EMPTY_RECYCLEBIN");
        final ContentValues a = kg.a();
        final ArrayList<Uri> list = new ArrayList<Uri>();
        final Cursor query = ((Context)h).getContentResolver().query(kf.a, new String[] { "_id" }, "active_state = 16", (String[])null, (String)null);
        final int columnIndex = query.getColumnIndex("_id");
        while (query.moveToNext()) {
            list.add(ContentUris.withAppendedId(kf.a, query.getLong(columnIndex)));
        }
        query.close();
        ((Context)h).getContentResolver().update(kf.a, a, "active_state = ?", new String[] { String.valueOf(16) });
        ((Context)h).getContentResolver().delete(kf.a, "active_state = 32 AND revision = 0", (String[])null);
        final Iterator<Uri> iterator = list.iterator();
        while (iterator.hasNext()) {
            rq.a((Context)h, iterator.next());
        }
    }
}
