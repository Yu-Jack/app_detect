// 
// Decompiled by Procyon v0.5.29
// 

package com.devspark.robototextview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.SparseArray;

public class c
{
    private static final SparseArray<Typeface> a;
    
    static {
        a = new SparseArray(20);
    }
    
    public static Typeface a(final Context context, final int n) {
        Typeface b = (Typeface)c.a.get(n);
        if (b == null) {
            b = b(context, n);
            c.a.put(n, (Object)b);
        }
        return b;
    }
    
    private static Typeface b(final Context context, final int i) {
        switch (i) {
            default: {
                throw new IllegalArgumentException("Unknown `typeface` attribute value " + i);
            }
            case 0: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Thin.ttf");
            }
            case 1: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-ThinItalic.ttf");
            }
            case 2: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
            }
            case 3: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-LightItalic.ttf");
            }
            case 4: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
            }
            case 5: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Italic.ttf");
            }
            case 6: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf");
            }
            case 7: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-MediumItalic.ttf");
            }
            case 8: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf");
            }
            case 9: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-BoldItalic.ttf");
            }
            case 10: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Black.ttf");
            }
            case 11: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-BlackItalic.ttf");
            }
            case 12: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Light.ttf");
            }
            case 13: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-LightItalic.ttf");
            }
            case 14: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Regular.ttf");
            }
            case 15: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Italic.ttf");
            }
            case 16: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Bold.ttf");
            }
            case 17: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-BoldItalic.ttf");
            }
            case 18: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/RobotoSlab-Thin.ttf");
            }
            case 19: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/RobotoSlab-Light.ttf");
            }
            case 20: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/RobotoSlab-Regular.ttf");
            }
            case 21: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/RobotoSlab-Bold.ttf");
            }
        }
    }
}
