// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.view.MenuItem;
import android.view.View;
import android.content.res.Configuration;
import android.os.Build$VERSION;
import android.support.v4.widget.DrawerLayout;
import android.graphics.drawable.Drawable;
import android.app.Activity;
import android.support.v4.widget.f;

public class ActionBarDrawerToggle implements f
{
    private static final int ID_HOME = 16908332;
    private static final ActionBarDrawerToggle$ActionBarDrawerToggleImpl IMPL;
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    private final Activity mActivity;
    private final ActionBarDrawerToggle$Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private final int mOpenDrawerContentDescRes;
    private Object mSetIndicatorInfo;
    private ActionBarDrawerToggle$SlideDrawable mSlider;
    private Drawable mThemeImage;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 18) {
            IMPL = new ActionBarDrawerToggle$ActionBarDrawerToggleImplJellybeanMR2(null);
            return;
        }
        if (sdk_INT >= 11) {
            IMPL = new ActionBarDrawerToggle$ActionBarDrawerToggleImplHC(null);
            return;
        }
        IMPL = new ActionBarDrawerToggle$ActionBarDrawerToggleImplBase(null);
    }
    
    public ActionBarDrawerToggle(final Activity mActivity, final DrawerLayout mDrawerLayout, final int mDrawerImageResource, final int mOpenDrawerContentDescRes, final int mCloseDrawerContentDescRes) {
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = mActivity;
        if (mActivity instanceof ActionBarDrawerToggle$DelegateProvider) {
            this.mActivityImpl = ((ActionBarDrawerToggle$DelegateProvider)mActivity).getDrawerToggleDelegate();
        }
        else {
            this.mActivityImpl = null;
        }
        this.mDrawerLayout = mDrawerLayout;
        this.mDrawerImageResource = mDrawerImageResource;
        this.mOpenDrawerContentDescRes = mOpenDrawerContentDescRes;
        this.mCloseDrawerContentDescRes = mCloseDrawerContentDescRes;
        this.mThemeImage = this.getThemeUpIndicator();
        this.mDrawerImage = mActivity.getResources().getDrawable(mDrawerImageResource);
        (this.mSlider = new ActionBarDrawerToggle$SlideDrawable(this, this.mDrawerImage, null)).setOffset(0.33333334f);
    }
    
    Drawable getThemeUpIndicator() {
        if (this.mActivityImpl != null) {
            return this.mActivityImpl.getThemeUpIndicator();
        }
        return ActionBarDrawerToggle.IMPL.getThemeUpIndicator(this.mActivity);
    }
    
    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        this.mThemeImage = this.getThemeUpIndicator();
        this.mDrawerImage = this.mActivity.getResources().getDrawable(this.mDrawerImageResource);
        this.syncState();
    }
    
    @Override
    public void onDrawerClosed(final View view) {
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            this.setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }
    
    @Override
    public void onDrawerOpened(final View view) {
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            this.setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }
    
    @Override
    public void onDrawerSlide(final View view, final float n) {
        final float position = this.mSlider.getPosition();
        float position2;
        if (n > 0.5f) {
            position2 = Math.max(position, 2.0f * Math.max(0.0f, n - 0.5f));
        }
        else {
            position2 = Math.min(position, n * 2.0f);
        }
        this.mSlider.setPosition(position2);
    }
    
    @Override
    public void onDrawerStateChanged(final int n) {
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332 && this.mDrawerIndicatorEnabled) {
            if (this.mDrawerLayout.f(8388611)) {
                this.mDrawerLayout.d(8388611);
            }
            else {
                this.mDrawerLayout.c(8388611);
            }
            return true;
        }
        return false;
    }
    
    void setActionBarDescription(final int actionBarDescription) {
        if (this.mActivityImpl != null) {
            this.mActivityImpl.setActionBarDescription(actionBarDescription);
            return;
        }
        this.mSetIndicatorInfo = ActionBarDrawerToggle.IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, actionBarDescription);
    }
    
    void setActionBarUpIndicator(final Drawable drawable, final int n) {
        if (this.mActivityImpl != null) {
            this.mActivityImpl.setActionBarUpIndicator(drawable, n);
            return;
        }
        this.mSetIndicatorInfo = ActionBarDrawerToggle.IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, drawable, n);
    }
    
    public void setDrawerIndicatorEnabled(final boolean mDrawerIndicatorEnabled) {
        if (mDrawerIndicatorEnabled != this.mDrawerIndicatorEnabled) {
            if (mDrawerIndicatorEnabled) {
                final ActionBarDrawerToggle$SlideDrawable mSlider = this.mSlider;
                int n;
                if (this.mDrawerLayout.e(8388611)) {
                    n = this.mCloseDrawerContentDescRes;
                }
                else {
                    n = this.mOpenDrawerContentDescRes;
                }
                this.setActionBarUpIndicator((Drawable)mSlider, n);
            }
            else {
                this.setActionBarUpIndicator(this.mThemeImage, 0);
            }
            this.mDrawerIndicatorEnabled = mDrawerIndicatorEnabled;
        }
    }
    
    public void syncState() {
        if (this.mDrawerLayout.e(8388611)) {
            this.mSlider.setPosition(1.0f);
        }
        else {
            this.mSlider.setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            final ActionBarDrawerToggle$SlideDrawable mSlider = this.mSlider;
            int n;
            if (this.mDrawerLayout.e(8388611)) {
                n = this.mCloseDrawerContentDescRes;
            }
            else {
                n = this.mOpenDrawerContentDescRes;
            }
            this.setActionBarUpIndicator((Drawable)mSlider, n);
        }
    }
}
