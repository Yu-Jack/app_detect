import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;

// 
// Decompiled by Procyon v0.5.29
// 

public final class tw
{
    static long b;
    public static final TimeZone c;
    public static final ty d;
    public static final tx e;
    public final long a;
    
    static {
        tw.b = 0L;
        c = adc.a;
        d = new ty();
        e = new tx();
    }
    
    public tw(final long a) {
        this.a = a;
    }
    
    public static tw b() {
        if (tw.b != 0L) {
            return new tw(tw.b);
        }
        return new tw(Calendar.getInstance(tw.c).getTime().getTime());
    }
    
    public final Date a() {
        return new Date(this.a);
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            if (this.a != ((tw)o).a) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        return 31 + (int)(this.a ^ this.a >>> 32);
    }
    
    @Override
    public final String toString() {
        return "DateTime(" + (String)tw.d.c(this) + ")";
    }
}
