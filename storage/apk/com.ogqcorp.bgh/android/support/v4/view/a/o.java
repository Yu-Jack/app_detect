// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view.a;

import android.os.Bundle;
import java.util.List;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

class o
{
    public static Object a(final p p) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(final int n) {
                return (AccessibilityNodeInfo)p.a(n);
            }
            
            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(final String s, final int n) {
                return (List<AccessibilityNodeInfo>)p.a(s, n);
            }
            
            public boolean performAction(final int n, final int n2, final Bundle bundle) {
                return p.a(n, n2, bundle);
            }
        };
    }
}
