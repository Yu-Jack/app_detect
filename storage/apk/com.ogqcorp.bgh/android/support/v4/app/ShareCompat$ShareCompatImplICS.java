// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.view.MenuItem;

class ShareCompat$ShareCompatImplICS extends ShareCompat$ShareCompatImplBase
{
    @Override
    public void configureMenuItem(final MenuItem menuItem, final ShareCompat$IntentBuilder shareCompat$IntentBuilder) {
        ShareCompatICS.configureMenuItem(menuItem, shareCompat$IntentBuilder.getActivity(), shareCompat$IntentBuilder.getIntent());
        if (this.shouldAddChooserIntent(menuItem)) {
            menuItem.setIntent(shareCompat$IntentBuilder.createChooserIntent());
        }
    }
    
    boolean shouldAddChooserIntent(final MenuItem menuItem) {
        return !menuItem.hasSubMenu();
    }
}
