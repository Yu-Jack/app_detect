import android.os.Build$VERSION;

// 
// Decompiled by Procyon v0.5.29
// 

public final class jn
{
    public static boolean a() {
        return Build$VERSION.SDK_INT < 14;
    }
    
    public static boolean b() {
        return Build$VERSION.SDK_INT > 10;
    }
    
    public static boolean c() {
        return Build$VERSION.SDK_INT >= 14;
    }
}
