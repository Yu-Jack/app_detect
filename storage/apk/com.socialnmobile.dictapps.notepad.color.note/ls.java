import android.content.SharedPreferences$Editor;
import android.content.Intent;
import android.net.Uri;
import com.socialnmobile.colornote.ColorNote;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ls implements DialogInterface$OnClickListener
{
    private final /* synthetic */ Context a;
    private final /* synthetic */ SharedPreferences b;
    
    public ls(final Context a, final SharedPreferences b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        ColorNote.a(this.a, "RATE", "SELECTION", "RESULT", "YES");
        final SharedPreferences$Editor edit = this.b.edit();
        edit.putLong("RATING_TIME", 1L);
        edit.commit();
        final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.a.getPackageName()));
        intent.setFlags(524288);
        this.a.startActivity(intent);
    }
}
