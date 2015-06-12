import java.io.IOException;
import android.text.Html;
import android.text.format.DateUtils;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class gt
{
    public static CharSequence a(final Context context) {
        return (CharSequence)Html.fromHtml(String.valueOf(context.getString(2131231057, new Object[] { DateUtils.formatDateTime(context, jp.l(context), 524313) })) + "<br/><font color='red'>" + jp.a(context, "SYNC_ERROR_MESSAGE", "") + "</font>");
    }
    
    public static String a(final Context context, final Exception ex) {
        if (ex instanceof IOException) {
            return context.getString(2131230844);
        }
        if (ex instanceof SecurityException) {
            return context.getString(2131230845);
        }
        if (ex instanceof RuntimeException) {
            return context.getString(2131231044);
        }
        return context.getString(2131231043);
    }
}
