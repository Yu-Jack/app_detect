import android.content.Context;
import java.util.Date;
import java.text.DateFormat;

// 
// Decompiled by Procyon v0.5.29
// 

public final class gs
{
    private static DateFormat a;
    private static DateFormat b;
    private static Date c;
    
    public gs(final Context context) {
        gs.a = android.text.format.DateFormat.getDateFormat(context);
        gs.b = android.text.format.DateFormat.getTimeFormat(context);
        gs.c = new Date();
    }
    
    public static String a(final Context context, final long date) {
        return android.text.format.DateFormat.getDateFormat(context).format(new Date(date));
    }
    
    public static String b(final Context context, final long date) {
        final DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);
        final DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(context);
        final Date date2 = new Date(date);
        return String.valueOf(dateFormat.format(date2)) + " " + timeFormat.format(date2);
    }
    
    public final String a(final long time) {
        synchronized (this) {
            gs.c.setTime(time);
            return gs.a.format(gs.c);
        }
    }
    
    public final String b(final long time) {
        synchronized (this) {
            gs.c.setTime(time);
            return String.valueOf(gs.a.format(gs.c)) + " " + gs.b.format(gs.c);
        }
    }
}
