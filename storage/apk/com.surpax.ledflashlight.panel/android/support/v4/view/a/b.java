// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view.a;

import android.view.View;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

class b extends g
{
    @Override
    public final Object a(final Object o) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)o);
    }
    
    @Override
    public final void a(final Object o, final int n) {
        ((AccessibilityNodeInfo)o).addAction(n);
    }
    
    @Override
    public final void a(final Object o, final Rect rect) {
        ((AccessibilityNodeInfo)o).getBoundsInParent(rect);
    }
    
    @Override
    public final void a(final Object o, final View view) {
        ((AccessibilityNodeInfo)o).addChild(view);
    }
    
    @Override
    public final void a(final Object o, final CharSequence className) {
        ((AccessibilityNodeInfo)o).setClassName(className);
    }
    
    @Override
    public final void a(final Object o, final boolean clickable) {
        ((AccessibilityNodeInfo)o).setClickable(clickable);
    }
    
    @Override
    public final int b(final Object o) {
        return ((AccessibilityNodeInfo)o).getActions();
    }
    
    @Override
    public final void b(final Object o, final Rect rect) {
        ((AccessibilityNodeInfo)o).getBoundsInScreen(rect);
    }
    
    @Override
    public final void b(final Object o, final View parent) {
        ((AccessibilityNodeInfo)o).setParent(parent);
    }
    
    @Override
    public final void b(final Object o, final CharSequence contentDescription) {
        ((AccessibilityNodeInfo)o).setContentDescription(contentDescription);
    }
    
    @Override
    public final void b(final Object o, final boolean enabled) {
        ((AccessibilityNodeInfo)o).setEnabled(enabled);
    }
    
    @Override
    public final CharSequence c(final Object o) {
        return ((AccessibilityNodeInfo)o).getClassName();
    }
    
    @Override
    public final void c(final Object o, final Rect boundsInParent) {
        ((AccessibilityNodeInfo)o).setBoundsInParent(boundsInParent);
    }
    
    @Override
    public final void c(final Object o, final View source) {
        ((AccessibilityNodeInfo)o).setSource(source);
    }
    
    @Override
    public final void c(final Object o, final CharSequence packageName) {
        ((AccessibilityNodeInfo)o).setPackageName(packageName);
    }
    
    @Override
    public final void c(final Object o, final boolean focusable) {
        ((AccessibilityNodeInfo)o).setFocusable(focusable);
    }
    
    @Override
    public final CharSequence d(final Object o) {
        return ((AccessibilityNodeInfo)o).getContentDescription();
    }
    
    @Override
    public final void d(final Object o, final Rect boundsInScreen) {
        ((AccessibilityNodeInfo)o).setBoundsInScreen(boundsInScreen);
    }
    
    @Override
    public final void d(final Object o, final boolean focused) {
        ((AccessibilityNodeInfo)o).setFocused(focused);
    }
    
    @Override
    public final CharSequence e(final Object o) {
        return ((AccessibilityNodeInfo)o).getPackageName();
    }
    
    @Override
    public final void e(final Object o, final boolean longClickable) {
        ((AccessibilityNodeInfo)o).setLongClickable(longClickable);
    }
    
    @Override
    public final CharSequence f(final Object o) {
        return ((AccessibilityNodeInfo)o).getText();
    }
    
    @Override
    public final void f(final Object o, final boolean scrollable) {
        ((AccessibilityNodeInfo)o).setScrollable(scrollable);
    }
    
    @Override
    public final void g(final Object o, final boolean selected) {
        ((AccessibilityNodeInfo)o).setSelected(selected);
    }
    
    @Override
    public final boolean g(final Object o) {
        return ((AccessibilityNodeInfo)o).isCheckable();
    }
    
    @Override
    public final boolean h(final Object o) {
        return ((AccessibilityNodeInfo)o).isChecked();
    }
    
    @Override
    public final boolean i(final Object o) {
        return ((AccessibilityNodeInfo)o).isClickable();
    }
    
    @Override
    public final boolean j(final Object o) {
        return ((AccessibilityNodeInfo)o).isEnabled();
    }
    
    @Override
    public final boolean k(final Object o) {
        return ((AccessibilityNodeInfo)o).isFocusable();
    }
    
    @Override
    public final boolean l(final Object o) {
        return ((AccessibilityNodeInfo)o).isFocused();
    }
    
    @Override
    public final boolean m(final Object o) {
        return ((AccessibilityNodeInfo)o).isLongClickable();
    }
    
    @Override
    public final boolean n(final Object o) {
        return ((AccessibilityNodeInfo)o).isPassword();
    }
    
    @Override
    public final boolean o(final Object o) {
        return ((AccessibilityNodeInfo)o).isScrollable();
    }
    
    @Override
    public final boolean p(final Object o) {
        return ((AccessibilityNodeInfo)o).isSelected();
    }
    
    @Override
    public final void q(final Object o) {
        ((AccessibilityNodeInfo)o).recycle();
    }
}
