import java.io.File;
import java.io.FilenameFilter;

// 
// Decompiled by Procyon v0.5.29
// 

final class ga implements FilenameFilter
{
    @Override
    public final boolean accept(final File file, final String s) {
        return s.startsWith(".flurryagent.");
    }
}
