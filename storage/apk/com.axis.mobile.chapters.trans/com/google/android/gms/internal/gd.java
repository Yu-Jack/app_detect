// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public enum gd
{
    yZ("SUCCESS", 0, "Ok"), 
    zA("USERNAME_UNAVAILABLE", 27, "UsernameUnavailable"), 
    zB("DELETED_GMAIL", 28, "DeletedGmail"), 
    zC("SOCKET_TIMEOUT", 29, "SocketTimeout"), 
    zD("EXISTING_USERNAME", 30, "ExistingUsername"), 
    zE("NEEDS_BROWSER", 31, "NeedsBrowser"), 
    zF("GPLUS_OTHER", 32, "GPlusOther"), 
    zG("GPLUS_NICKNAME", 33, "GPlusNickname"), 
    zH("GPLUS_INVALID_CHAR", 34, "GPlusInvalidChar"), 
    zI("GPLUS_INTERSTITIAL", 35, "GPlusInterstitial"), 
    zJ("GPLUS_PROFILE_ERROR", 36, "ProfileUpgradeError"), 
    zK("INVALID_SCOPE", 37, "INVALID_SCOPE");
    
    public static String zL;
    public static String zM;
    
    za("BAD_AUTHENTICATION", 1, "BadAuthentication"), 
    zb("NEEDS_2F", 2, "InvalidSecondFactor"), 
    zc("NOT_VERIFIED", 3, "NotVerified"), 
    zd("TERMS_NOT_AGREED", 4, "TermsNotAgreed"), 
    ze("UNKNOWN", 5, "Unknown"), 
    zf("UNKNOWN_ERROR", 6, "UNKNOWN_ERR"), 
    zg("ACCOUNT_DELETED", 7, "AccountDeleted"), 
    zh("ACCOUNT_DISABLED", 8, "AccountDisabled"), 
    zi("SERVICE_DISABLED", 9, "ServiceDisabled"), 
    zj("SERVICE_UNAVAILABLE", 10, "ServiceUnavailable"), 
    zk("CAPTCHA", 11, "CaptchaRequired"), 
    zl("NETWORK_ERROR", 12, "NetworkError"), 
    zm("USER_CANCEL", 13, "UserCancel"), 
    zn("PERMISSION_DENIED", 14, "PermissionDenied"), 
    zo("DEVICE_MANAGEMENT_REQUIRED", 15, "DeviceManagementRequiredOrSyncDisabled"), 
    zp("CLIENT_LOGIN_DISABLED", 16, "ClientLoginDisabled"), 
    zq("NEED_PERMISSION", 17, "NeedPermission"), 
    zr("BAD_PASSWORD", 18, "WeakPassword"), 
    zs("ALREADY_HAS_GMAIL", 19, "ALREADY_HAS_GMAIL"), 
    zt("BAD_REQUEST", 20, "BadRequest"), 
    zu("BAD_USERNAME", 21, "BadUsername"), 
    zv("LOGIN_FAIL", 22, "LoginFail"), 
    zw("NOT_LOGGED_IN", 23, "NotLoggedIn"), 
    zx("NO_GMAIL", 24, "NoGmail"), 
    zy("REQUEST_DENIED", 25, "RequestDenied"), 
    zz("SERVER_ERROR", 26, "ServerError");
    
    private final String zN;
    
    static {
        gd.zL = "Error";
        gd.zM = "status";
    }
    
    private gd(final String name, final int ordinal, final String zn) {
        this.zN = zn;
    }
}
