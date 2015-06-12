import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

// 
// Decompiled by Procyon v0.5.29
// 

public final class adc extends acx
{
    public static final TimeZone a;
    public static final adc b;
    private final SimpleDateFormat c;
    
    static {
        a = TimeZone.getTimeZone("UTC");
        b = new adc();
    }
    
    public adc() {
        (this.c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US)).setTimeZone(adc.a);
    }
    
    private String a(final Date date) {
        synchronized (this) {
            String s = this.c.format(date);
            if (!c(s)) {
                final Calendar instance = Calendar.getInstance(adc.a, Locale.US);
                instance.setTime(date);
                final int value = instance.get(1);
                final int i = 1 + instance.get(2);
                final int value2 = instance.get(5);
                final int value3 = instance.get(11);
                final int value4 = instance.get(12);
                final int value5 = instance.get(13);
                final int value6 = instance.get(14);
                final StringBuffer sb = new StringBuffer();
                sb.append(String.format(null, "%04d", value));
                sb.append('-');
                sb.append(String.format(null, "%02d", i));
                sb.append('-');
                sb.append(String.format(null, "%02d", value2));
                sb.append(' ');
                sb.append(String.format(null, "%02d", value3));
                sb.append(':');
                sb.append(String.format(null, "%02d", value4));
                sb.append(':');
                sb.append(String.format(null, "%02d", value5));
                sb.append('.');
                sb.append(String.format(null, "%03d", value6));
                s = sb.toString();
            }
            return s;
        }
    }
    
    private static void a(final char c, final char c2) {
        if (c != c2) {
            throw new RuntimeException();
        }
    }
    
    private Date b(final String source) {
        synchronized (this) {
            try {
                return this.c.parse(source);
            }
            catch (ParseException ex) {
                return d(source);
            }
        }
    }
    
    private static boolean c(final String s) {
        try {
            Integer.parseInt(s.substring(0, 4));
            a('-', s.charAt(4));
            Integer.parseInt(s.substring(5, 7));
            a('-', s.charAt(7));
            Integer.parseInt(s.substring(8, 10));
            a(' ', s.charAt(10));
            Integer.parseInt(s.substring(11, 13));
            a(':', s.charAt(13));
            Integer.parseInt(s.substring(14, 16));
            a(':', s.charAt(16));
            Integer.parseInt(s.substring(17, 19));
            a('.', s.charAt(19));
            Integer.parseInt(s.substring(20, 23));
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    private static Date d(final String s) {
        try {
            final int int1 = Integer.parseInt(s.substring(0, 4));
            final int int2 = Integer.parseInt(s.substring(5, 7));
            final int int3 = Integer.parseInt(s.substring(8, 10));
            final int int4 = Integer.parseInt(s.substring(11, 13));
            final int int5 = Integer.parseInt(s.substring(14, 16));
            final int int6 = Integer.parseInt(s.substring(17, 19));
            final int int7 = Integer.parseInt(s.substring(20, 23));
            final Calendar instance = Calendar.getInstance(adc.a, Locale.US);
            instance.setTimeInMillis(0L);
            instance.set(int1, int2 - 1, int3, int4, int5, int6);
            instance.set(14, int7);
            return new Date(instance.getTimeInMillis());
        }
        catch (Exception ex) {
            throw new ux(ex);
        }
    }
}
