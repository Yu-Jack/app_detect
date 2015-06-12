import android.content.SharedPreferences$Editor;
import com.socialnmobile.colornote.ColorNote;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class lt implements DialogInterface$OnClickListener
{
    private final /* synthetic */ Context a;
    private final /* synthetic */ SharedPreferences b;
    
    public lt(final Context a, final SharedPreferences b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        ColorNote.a(this.a, "RATE", "SELECTION", "RESULT", "NO");
        final SharedPreferences$Editor edit = this.b.edit();
        edit.putLong("RATING_TIME", 5184000000L + System.currentTimeMillis());
        edit.commit();
    }
}
