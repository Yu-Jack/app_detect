import android.content.Intent;
import android.content.ContentUris;
import android.content.DialogInterface;
import com.socialnmobile.colornote.activity.Today;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ja implements DialogInterface$OnClickListener
{
    final /* synthetic */ Today a;
    
    public ja(final Today a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.a.moveToPosition(n);
        final Intent intent = new Intent("android.intent.action.VIEW", ContentUris.withAppendedId(kf.a, this.a.a.getLong(this.a.a.getColumnIndex("_id"))));
        intent.putExtra("EXTRA_VIEW_FROM", "TODAY");
        this.a.startActivity(intent);
    }
}
