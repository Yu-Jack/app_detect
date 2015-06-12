// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.a.l;
import java.io.PrintWriter;
import java.io.FileDescriptor;

public abstract class LoaderManager
{
    public static void enableDebugLogging(final boolean debug) {
        LoaderManagerImpl.DEBUG = debug;
    }
    
    public abstract void destroyLoader(final int p0);
    
    public abstract void dump(final String p0, final FileDescriptor p1, final PrintWriter p2, final String[] p3);
    
    public abstract <D> l<D> getLoader(final int p0);
    
    public boolean hasRunningLoaders() {
        return false;
    }
    
    public abstract <D> l<D> initLoader(final int p0, final Bundle p1, final LoaderManager$LoaderCallbacks<D> p2);
    
    public abstract <D> l<D> restartLoader(final int p0, final Bundle p1, final LoaderManager$LoaderCallbacks<D> p2);
}
