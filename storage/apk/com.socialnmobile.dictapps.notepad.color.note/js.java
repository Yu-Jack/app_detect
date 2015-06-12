import java.io.File;
import java.io.FilenameFilter;

// 
// Decompiled by Procyon v0.5.29
// 

final class js implements FilenameFilter
{
    final /* synthetic */ jr a;
    
    js(final jr a) {
        this.a = a;
    }
    
    @Override
    public final boolean accept(final File file, final String s) {
        return s.contains(".idx") && s.contains("AUTO");
    }
}
