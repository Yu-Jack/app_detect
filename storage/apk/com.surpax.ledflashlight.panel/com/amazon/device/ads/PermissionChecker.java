// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build$VERSION;
import android.content.Context;

class PermissionChecker
{
    private static PermissionChecker INSTANCE;
    private static final String INTERNET_PERMISSION = "android.permission.INTERNET";
    private static final String LOG_TAG;
    private boolean isInternetPermissionPresent;
    
    static {
        LOG_TAG = PermissionChecker.class.getSimpleName();
        PermissionChecker.INSTANCE = new PermissionChecker();
    }
    
    protected PermissionChecker() {
        this.isInternetPermissionPresent = false;
    }
    
    static PermissionChecker getInstance() {
        return PermissionChecker.INSTANCE;
    }
    
    private static final boolean permissionCheckErrorCondition() {
        Log.d(PermissionChecker.LOG_TAG, "App permissions were not read.");
        return true;
    }
    
    protected static void setInstance(final PermissionChecker instance) {
        PermissionChecker.INSTANCE = instance;
    }
    
    public final boolean passesInternetPermissionCheck(final Context context) {
        return this.passesInternetPermissionCheck(context, null);
    }
    
    public final boolean passesInternetPermissionCheck(final Context context, final String s) {
        if (this.isInternetPermissionPresent) {
            return true;
        }
        if (Build$VERSION.SDK_INT < 8) {
            return permissionCheckErrorCondition();
        }
        final String packageCodePath = AndroidTargetUtils.getPackageCodePath(context);
        if (packageCodePath == null) {
            return permissionCheckErrorCondition();
        }
        final PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return permissionCheckErrorCondition();
        }
        final PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(packageCodePath, 4096);
        if (packageArchiveInfo == null) {
            return permissionCheckErrorCondition();
        }
        final String[] requestedPermissions = packageArchiveInfo.requestedPermissions;
        if (requestedPermissions == null) {
            return permissionCheckErrorCondition();
        }
        for (int length = requestedPermissions.length, i = 0; i < length; ++i) {
            if (requestedPermissions[i].equals("android.permission.INTERNET")) {
                return this.isInternetPermissionPresent = true;
            }
        }
        if (s != null) {
            Log.e(s, "Network task cannot commence because the INTERNET permission is missing from the app's manifest.");
        }
        return false;
    }
}
