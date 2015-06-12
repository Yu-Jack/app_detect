// 
// Decompiled by Procyon v0.5.29
// 

package bolts;

import android.net.Uri;

public interface AppLinkResolver
{
    Task<AppLink> getAppLinkFromUrlInBackground(Uri p0);
}
