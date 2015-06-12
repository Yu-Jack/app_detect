import java.util.Calendar;
import java.util.TimeZone;
import android.os.Build$VERSION;
import java.io.File;
import android.content.Context;
import android.text.format.Time;
import android.app.PendingIntent;
import android.app.AlarmManager;
import android.os.Environment;
import android.app.AlertDialog$Builder;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

// 
// Decompiled by Procyon v0.5.29
// 

public final class jk
{
    static Method a;
    static Method b;
    static Method c;
    static Method d;
    static Method e;
    
    static {
        while (true) {
            try {
                jk.a = ViewConfiguration.class.getMethod("hasPermanentMenuKey", (Class<?>[])new Class[0]);
                try {
                    jk.b = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
                    try {
                        jk.c = AlertDialog$Builder.class.getMethod("getContext", (Class<?>[])new Class[0]);
                        try {
                            jk.d = Environment.class.getMethod("getExternalStoragePublicDirectory", String.class);
                            try {
                                jk.e = AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class);
                            }
                            catch (NoSuchMethodException ex) {}
                            catch (SecurityException ex2) {}
                        }
                        catch (NoSuchMethodException ex3) {}
                        catch (SecurityException ex4) {}
                    }
                    catch (NoSuchMethodException ex5) {}
                    catch (SecurityException ex6) {}
                }
                catch (NoSuchMethodException ex7) {}
                catch (SecurityException ex8) {}
            }
            catch (NoSuchMethodException ex9) {
                continue;
            }
            catch (SecurityException ex10) {
                continue;
            }
            break;
        }
    }
    
    public static long a(final Time time) {
        final long normalize = time.normalize(true);
        if (normalize != -1L) {
            return normalize;
        }
        final long b = b(time);
        time.set(b);
        return b;
    }
    
    public static long a(final Time time, final boolean b) {
        long n;
        if (!b) {
            n = time.toMillis(false);
        }
        else {
            try {
                n = time.toMillis(true);
                if (n == -1L) {
                    return b(time);
                }
            }
            catch (IllegalArgumentException ex) {
                return b(time);
            }
        }
        return n;
    }
    
    public static Context a(final AlertDialog$Builder obj) {
        if (jk.c != null) {
            try {
                return (Context)jk.c.invoke(obj, new Object[0]);
            }
            catch (Exception ex) {}
        }
        return null;
    }
    
    public static File a(final String s) {
        if (jk.d != null) {
            try {
                return (File)jk.d.invoke(null, s);
            }
            catch (Exception ex) {}
        }
        return new File(String.valueOf(Environment.getExternalStorageState()) + "/Download");
    }
    
    public static void a(final AlarmManager obj, final long l, final PendingIntent pendingIntent) {
        Label_0056: {
            if (Build$VERSION.SDK_INT < 19 || jk.e == null) {
                break Label_0056;
            }
            try {
                jk.e.invoke(obj, 0, l, pendingIntent);
                return;
                obj.set(0, l, pendingIntent);
            }
            catch (Exception ex) {}
        }
    }
    
    public static void a(final View obj) {
        if (jk.b == null) {
            return;
        }
        try {
            jk.b.invoke(obj, 1, null);
        }
        catch (Exception ex) {}
    }
    
    public static boolean a(final ViewConfiguration obj) {
        if (jk.a != null) {
            try {
                return (boolean)jk.a.invoke(obj, new Object[0]);
            }
            catch (Exception ex) {}
        }
        return Build$VERSION.SDK_INT <= 10 || (Build$VERSION.SDK_INT < 14 && false);
    }
    
    private static long b(final Time time) {
        final Calendar instance = Calendar.getInstance(TimeZone.getTimeZone(time.timezone));
        instance.clear();
        instance.set(time.year, time.month, time.monthDay, time.hour, time.minute, time.second);
        return instance.getTimeInMillis();
    }
}
