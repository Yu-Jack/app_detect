// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

final class k extends l
{
    @Override
    public final Object a(final h h) {
        return new AccessibilityNodeProvider() {
            final /* synthetic */ p a;
            
            public final AccessibilityNodeInfo createAccessibilityNodeInfo(final int n) {
                this.a.c();
                return null;
            }
            
            public final List findAccessibilityNodeInfosByText(final String s, final int n) {
                return this.a.b();
            }
            
            public final AccessibilityNodeInfo findFocus(final int n) {
                this.a.d();
                return null;
            }
            
            public final boolean performAction(final int n, final int n2, final Bundle bundle) {
                return this.a.a();
            }
        };
    }
}
