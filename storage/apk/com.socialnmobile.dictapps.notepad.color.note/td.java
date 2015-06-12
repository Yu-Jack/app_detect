import java.util.Date;
import java.util.Calendar;
import org.apache.http.HttpRequest;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class td
{
    public static final te a;
    
    static {
        a = new te();
    }
    
    public abstract void a(final HttpRequest p0);
    
    public final boolean a() {
        return this.a(Calendar.getInstance(tw.c).getTime());
    }
    
    public abstract boolean a(final Date p0);
}
