import java.util.regex.Matcher;
import android.text.util.Linkify$TransformFilter;

// 
// Decompiled by Procyon v0.5.29
// 

public final class yk implements Linkify$TransformFilter
{
    public final String transformUrl(final Matcher matcher, final String s) {
        return s.substring(1, s.indexOf(32));
    }
}
