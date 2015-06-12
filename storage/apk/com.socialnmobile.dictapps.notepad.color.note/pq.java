import android.database.Cursor;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class pq extends ad
{
    int u;
    
    public pq(final Context context, final int u) {
        super(context);
        this.u = u;
    }
    
    @Override
    public final Cursor e() {
        final Context o = super.o;
        String s = null;
        switch (this.u) {
            default: {
                s = null;
                break;
            }
            case 6: {
                s = "minor_modified_date DESC";
                break;
            }
            case 5: {
                s = "created_date DESC";
                break;
            }
            case 2: {
                s = "title ASC";
                break;
            }
            case 3: {
                s = "color_index ASC, modified_date DESC";
                break;
            }
        }
        return o.getContentResolver().query(kf.a, (String[])null, "active_state = 16 AND account_id = 0", (String[])null, s);
    }
}
