import java.io.File;

// 
// Decompiled by Procyon v0.5.29
// 

public final class gf
{
    static String a;
    
    static {
        gf.a = gf.class.getSimpleName();
    }
    
    public static boolean a(final File file) {
        if (file == null) {
            return false;
        }
        final File parentFile = file.getParentFile();
        if (!parentFile.mkdirs() && !parentFile.exists()) {
            final String a = gf.a;
            gj.a(6, "Unable to create persistent dir: " + parentFile);
            return false;
        }
        return true;
    }
}
