// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import android.widget.ImageView;
import com.actionbarsherlock.internal.widget.IcsAdapterView;
import android.widget.AdapterView;
import android.view.ViewGroup;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.View;
import android.support.v4.app.Fragment;
import android.app.Activity;

public final class t
{
    public static void a(final Activity activity) {
        a(activity.getWindow().getDecorView());
    }
    
    public static void a(final Fragment fragment) {
        a(fragment.getView());
    }
    
    private static void a(final View view) {
        if (view != null) {
            view.setAnimation((Animation)null);
            view.setBackgroundDrawable((Drawable)null);
            if (view instanceof ViewGroup) {
                final ViewGroup viewGroup = (ViewGroup)view;
                for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
                    a(viewGroup.getChildAt(i));
                }
                if (view instanceof AdapterView || view instanceof IcsAdapterView) {
                    return;
                }
                try {
                    viewGroup.removeAllViews();
                    return;
                }
                catch (Exception ex) {
                    n.b(ex);
                    return;
                }
            }
            if (view instanceof ImageView) {
                final ImageView imageView = (ImageView)view;
                imageView.destroyDrawingCache();
                imageView.setImageDrawable((Drawable)null);
            }
        }
    }
}
