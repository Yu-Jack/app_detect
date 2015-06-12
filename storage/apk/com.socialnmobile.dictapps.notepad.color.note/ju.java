import java.io.File;
import java.io.FilenameFilter;

// 
// Decompiled by Procyon v0.5.29
// 

final class ju implements FilenameFilter
{
    final /* synthetic */ jr a;
    
    ju(final jr a) {
        this.a = a;
    }
    
    @Override
    public final boolean accept(final File file, final String s) {
        return s.contains(".idx");
    }
}
