import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import android.content.Context;
import java.util.Map;

// 
// Decompiled by Procyon v0.5.29
// 

public final class el
{
    public final String a;
    public final Map b;
    public final Context c;
    public final AdUnit d;
    public final gn e;
    public final int f;
    
    public el(final String a, final Map b, final Context c, final AdUnit d, final gn e, final int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("event=").append(this.a);
        sb.append(",params=").append(this.b);
        sb.append(",adspace=").append(this.d.b());
        return sb.toString();
    }
}
