import android.net.Uri;
import com.socialnmobile.colornote.util.LinkText;
import java.util.regex.Matcher;
import android.text.util.Linkify$TransformFilter;

// 
// Decompiled by Procyon v0.5.29
// 

public final class yj implements Linkify$TransformFilter
{
    public final String transformUrl(final Matcher matcher, String a) {
        if (a.startsWith("[[")) {
            a = LinkText.a(a);
        }
        return Uri.encode(a);
    }
}
