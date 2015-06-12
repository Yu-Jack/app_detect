// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.support.v4.a.l;
import android.os.Bundle;

public interface LoaderManager$LoaderCallbacks<D>
{
    l<D> onCreateLoader(int p0, Bundle p1);
    
    void onLoadFinished(l<D> p0, D p1);
    
    void onLoaderReset(l<D> p0);
}
