// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view.a;

import android.os.Bundle;
import java.util.List;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

class q
{
    public static Object a(final r r) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(final int n) {
                return (AccessibilityNodeInfo)r.a(n);
            }
            
            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(final String s, final int n) {
                return (List<AccessibilityNodeInfo>)r.a(s, n);
            }
            
            public AccessibilityNodeInfo findFocus(final int n) {
                return (AccessibilityNodeInfo)r.b(n);
            }
            
            public boolean performAction(final int n, final int n2, final Bundle bundle) {
                return r.a(n, n2, bundle);
            }
        };
    }
}
