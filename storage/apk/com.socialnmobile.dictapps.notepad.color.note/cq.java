import android.view.View;

// 
// Decompiled by Procyon v0.5.29
// 

final class cq
{
    public static void a(final View view) {
        view.postInvalidateOnAnimation();
    }
    
    public static void a(final View view, final int importantForAccessibility) {
        view.setImportantForAccessibility(importantForAccessibility);
    }
}
