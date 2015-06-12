// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v13.app;

import android.app.Fragment;
import android.os.Build$VERSION;

public class FragmentCompat
{
    static final FragmentCompatImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 15) {
            IMPL = (FragmentCompatImpl)new ICSMR1FragmentCompatImpl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = (FragmentCompatImpl)new ICSFragmentCompatImpl();
            return;
        }
        IMPL = (FragmentCompatImpl)new BaseFragmentCompatImpl();
    }
    
    public static void setMenuVisibility(final Fragment fragment, final boolean b) {
        FragmentCompat.IMPL.setMenuVisibility(fragment, b);
    }
    
    public static void setUserVisibleHint(final Fragment fragment, final boolean b) {
        FragmentCompat.IMPL.setUserVisibleHint(fragment, b);
    }
    
    static class BaseFragmentCompatImpl implements FragmentCompatImpl
    {
        @Override
        public void setMenuVisibility(final Fragment fragment, final boolean b) {
        }
        
        @Override
        public void setUserVisibleHint(final Fragment fragment, final boolean b) {
        }
    }
    
    interface FragmentCompatImpl
    {
        void setMenuVisibility(Fragment p0, boolean p1);
        
        void setUserVisibleHint(Fragment p0, boolean p1);
    }
    
    static class ICSFragmentCompatImpl extends BaseFragmentCompatImpl
    {
        @Override
        public void setMenuVisibility(final Fragment fragment, final boolean b) {
            FragmentCompatICS.setMenuVisibility(fragment, b);
        }
    }
    
    static class ICSMR1FragmentCompatImpl extends ICSFragmentCompatImpl
    {
        @Override
        public void setUserVisibleHint(final Fragment fragment, final boolean b) {
            FragmentCompatICSMR1.setUserVisibleHint(fragment, b);
        }
    }
}
