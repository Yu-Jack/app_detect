import android.content.SharedPreferences$Editor;
import com.socialnmobile.colornote.ColorNote;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.DialogInterface$OnCancelListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class lu implements DialogInterface$OnCancelListener
{
    private final /* synthetic */ Context a;
    private final /* synthetic */ SharedPreferences b;
    
    public lu(final Context a, final SharedPreferences b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onCancel(final DialogInterface dialogInterface) {
        ColorNote.a(this.a, "RATE", "SELECTION", "RESULT", "CANCEL");
        final SharedPreferences$Editor edit = this.b.edit();
        edit.putLong("RATING_TIME", 3456000000L + System.currentTimeMillis());
        edit.commit();
    }
}
