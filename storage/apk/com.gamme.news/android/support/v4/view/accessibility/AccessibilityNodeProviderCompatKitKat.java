// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.List;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

class AccessibilityNodeProviderCompatKitKat
{
    public static Object newAccessibilityNodeProviderBridge(final AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(final int n) {
                return (AccessibilityNodeInfo)accessibilityNodeInfoBridge.createAccessibilityNodeInfo(n);
            }
            
            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(final String s, final int n) {
                return (List<AccessibilityNodeInfo>)accessibilityNodeInfoBridge.findAccessibilityNodeInfosByText(s, n);
            }
            
            public AccessibilityNodeInfo findFocus(final int n) {
                return (AccessibilityNodeInfo)accessibilityNodeInfoBridge.findFocus(n);
            }
            
            public boolean performAction(final int n, final int n2, final Bundle bundle) {
                return accessibilityNodeInfoBridge.performAction(n, n2, bundle);
            }
        };
    }
    
    interface AccessibilityNodeInfoBridge
    {
        Object createAccessibilityNodeInfo(int p0);
        
        List<Object> findAccessibilityNodeInfosByText(String p0, int p1);
        
        Object findFocus(int p0);
        
        boolean performAction(int p0, int p1, Bundle p2);
    }
}