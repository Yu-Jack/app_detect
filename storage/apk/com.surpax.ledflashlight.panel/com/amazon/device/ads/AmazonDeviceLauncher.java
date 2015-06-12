// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.Context;

class AmazonDeviceLauncher
{
    static boolean isWindowshopPresent(final Context context) {
        return context.getPackageManager().getLaunchIntentForPackage("com.amazon.windowshop") != null;
    }
    
    static void launchWindowshopDetailPage(final Context context, final String s) {
        final Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.amazon.windowshop");
        if (launchIntentForPackage != null) {
            launchIntentForPackage.putExtra("com.amazon.windowshop.refinement.asin", s);
            context.startActivity(launchIntentForPackage);
        }
    }
    
    static void launchWindowshopSearchPage(final Context context, final String s) {
        final Intent intent = new Intent("android.intent.action.SEARCH");
        intent.setComponent(new ComponentName("com.amazon.windowshop", "com.amazon.windowshop.search.SearchResultsGridActivity"));
        intent.putExtra("query", s);
        try {
            context.startActivity(intent);
        }
        catch (RuntimeException ex) {}
    }
}
