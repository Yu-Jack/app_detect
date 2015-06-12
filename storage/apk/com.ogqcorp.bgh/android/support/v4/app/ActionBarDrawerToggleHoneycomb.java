// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.app.ActionBar;
import android.util.Log;
import android.os.Build$VERSION;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.app.Activity;

class ActionBarDrawerToggleHoneycomb
{
    private static final String TAG = "ActionBarDrawerToggleHoneycomb";
    private static final int[] THEME_ATTRS;
    
    static {
        THEME_ATTRS = new int[] { 16843531 };
    }
    
    public static Drawable getThemeUpIndicator(final Activity activity) {
        final TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(ActionBarDrawerToggleHoneycomb.THEME_ATTRS);
        final Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }
    
    public static Object setActionBarDescription(final Object o, final Activity activity, final int i) {
        while (true) {
            Label_0098: {
                if (o != null) {
                    break Label_0098;
                }
                final Object o2 = new ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(activity);
                final ActionBarDrawerToggleHoneycomb$SetIndicatorInfo actionBarDrawerToggleHoneycomb$SetIndicatorInfo = (ActionBarDrawerToggleHoneycomb$SetIndicatorInfo)o2;
                if (actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeAsUpIndicator == null) {
                    return o2;
                }
                try {
                    final ActionBar actionBar = activity.getActionBar();
                    actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeActionContentDescription.invoke(actionBar, i);
                    if (Build$VERSION.SDK_INT <= 19) {
                        actionBar.setSubtitle(actionBar.getSubtitle());
                    }
                    return o2;
                }
                catch (Exception ex) {
                    Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", (Throwable)ex);
                    return o2;
                }
            }
            final Object o2 = o;
            continue;
        }
    }
    
    public static Object setActionBarUpIndicator(final Object o, final Activity activity, final Drawable imageDrawable, final int i) {
        Object o2;
        if (o == null) {
            o2 = new ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(activity);
        }
        else {
            o2 = o;
        }
        final ActionBarDrawerToggleHoneycomb$SetIndicatorInfo actionBarDrawerToggleHoneycomb$SetIndicatorInfo = (ActionBarDrawerToggleHoneycomb$SetIndicatorInfo)o2;
        if (actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeAsUpIndicator != null) {
            try {
                final ActionBar actionBar = activity.getActionBar();
                actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeAsUpIndicator.invoke(actionBar, imageDrawable);
                actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeActionContentDescription.invoke(actionBar, i);
                return o2;
            }
            catch (Exception ex) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", (Throwable)ex);
                return o2;
            }
        }
        if (actionBarDrawerToggleHoneycomb$SetIndicatorInfo.upIndicatorView != null) {
            actionBarDrawerToggleHoneycomb$SetIndicatorInfo.upIndicatorView.setImageDrawable(imageDrawable);
            return o2;
        }
        Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
        return o2;
    }
}
