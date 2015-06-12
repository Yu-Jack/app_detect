// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.view.View;
import android.view.ViewGroup;
import android.graphics.drawable.Drawable;
import android.app.ActionBar;
import android.app.Activity;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggleHoneycomb$SetIndicatorInfo
{
    public Method setHomeActionContentDescription;
    public Method setHomeAsUpIndicator;
    public ImageView upIndicatorView;
    
    ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(final Activity activity) {
        try {
            this.setHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
            this.setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
        }
        catch (NoSuchMethodException ex) {
            final View viewById = activity.findViewById(16908332);
            if (viewById == null) {
                return;
            }
            final ViewGroup viewGroup = (ViewGroup)viewById.getParent();
            if (viewGroup.getChildCount() != 2) {
                return;
            }
            final View child = viewGroup.getChildAt(0);
            View child2 = viewGroup.getChildAt(1);
            if (child.getId() != 16908332) {
                child2 = child;
            }
            if (child2 instanceof ImageView) {
                this.upIndicatorView = (ImageView)child2;
            }
        }
    }
}
