import java.util.Set;
import java.util.WeakHashMap;
import java.util.Map;

// 
// Decompiled by Procyon v0.5.29
// 

public final class gc
{
    private static gc c;
    final Thread.UncaughtExceptionHandler a;
    final Map b;
    
    private gc() {
        this.b = new WeakHashMap();
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new gd(this, (byte)0));
    }
    
    public static gc a() {
        synchronized (gc.class) {
            if (gc.c == null) {
                gc.c = new gc();
            }
            return gc.c;
        }
    }
    
    final Set b() {
        synchronized (this.b) {
            return this.b.keySet();
        }
    }
}
