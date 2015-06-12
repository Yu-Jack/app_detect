import java.util.Iterator;
import android.database.Cursor;
import android.content.SharedPreferences$Editor;
import android.content.ContentUris;
import android.net.Uri;
import java.util.ArrayList;
import android.preference.PreferenceManager;
import android.content.Context;
import android.content.DialogInterface;
import com.socialnmobile.colornote.activity.PasswordSetting;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ic implements DialogInterface$OnClickListener
{
    final /* synthetic */ PasswordSetting a;
    
    public ic(final PasswordSetting a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        final PasswordSetting a = this.a;
        final SharedPreferences$Editor edit = kr.a((Context)a, "name_master_password").edit();
        edit.remove("BACKUP_SECRET_KEY");
        edit.remove("BACKUP_ENCRYPTED_DATA");
        edit.remove("CRYPTO_ENCRYPTED_USER_KEY");
        edit.commit();
        if (jp.a((Context)a, "BACKUP_SECRET_KEY", null) != null) {
            final SharedPreferences$Editor edit2 = PreferenceManager.getDefaultSharedPreferences((Context)a).edit();
            edit2.remove("BACKUP_SECRET_KEY");
            edit2.remove("BACKUP_ENCRYPTED_DATA");
            edit2.remove("CRYPTO_ENCRYPTED_USER_KEY");
            edit2.commit();
        }
        final PasswordSetting a2 = this.a;
        final ArrayList<Uri> list = new ArrayList<Uri>();
        final Cursor query = ((Context)a2).getContentResolver().query(kf.a, new String[] { "_id" }, "encrypted <> 0", (String[])null, (String)null);
        final int columnIndex = query.getColumnIndex("_id");
        while (query.moveToNext()) {
            list.add(ContentUris.withAppendedId(kf.a, query.getLong(columnIndex)));
        }
        query.close();
        ((Context)a2).getContentResolver().update(kf.a, kg.a(), "encrypted <> 0", (String[])null);
        final Iterator<Uri> iterator = list.iterator();
        while (iterator.hasNext()) {
            rq.a((Context)a2, iterator.next());
        }
        this.a.finish();
    }
}
