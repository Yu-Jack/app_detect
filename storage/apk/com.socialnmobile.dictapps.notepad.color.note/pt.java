import android.database.Cursor;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class pt extends ad
{
    String u;
    
    public pt(final Context context, final String u) {
        super(context);
        this.u = u;
    }
    
    @Override
    public final Cursor e() {
        final Context o = super.o;
        final String u = this.u;
        return o.getContentResolver().query(kf.a, (String[])null, "active_state <> 32 AND active_state <> 256 AND (title like ? OR note like ? )", new String[] { "%" + u + "%", "%" + u + "%" }, "modified_date DESC");
    }
}
