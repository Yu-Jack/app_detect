// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import android.os.Build$VERSION;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import android.content.Context;
import android.view.WindowManager;

class Utils
{
    private static final String DISABLED_APP_SERVER_MESSAGE = "DISABLED_APP";
    private static final String LOG_TAG;
    private static int[][] rotationArray;
    
    static {
        LOG_TAG = Utils.class.getSimpleName();
        Utils.rotationArray = new int[][] { { 1, 0, 9, 8 }, { 0, 9, 8, 1 } };
    }
    
    public static final long convertToMillisecondsFromNanoseconds(final long n) {
        return n / 1000000L;
    }
    
    public static final long convertToNsFromS(final long n) {
        return 1000000000L * n;
    }
    
    public static int determineCanonicalScreenOrientation() {
        final Context applicationContext = InternalAdRegistration.getInstance().getApplicationContext();
        final int orientation = AndroidTargetUtils.getOrientation(((WindowManager)applicationContext.getSystemService("window")).getDefaultDisplay());
        final int orientation2 = applicationContext.getResources().getConfiguration().orientation;
        int n;
        if (orientation2 == 1) {
            if (orientation == 0 || orientation == 2) {
                n = 1;
            }
            else {
                n = 0;
            }
        }
        else if (orientation2 == 2) {
            if (orientation == 1 || orientation == 3) {
                n = 1;
            }
            else {
                n = 0;
            }
        }
        else {
            n = 1;
        }
        int n2 = 0;
        if (n == 0) {
            n2 = 1;
        }
        return Utils.rotationArray[n2][orientation];
    }
    
    public static final String getDisabledAppServerMessage() {
        return "DISABLED_APP";
    }
    
    public static final String getURLDecodedString(final String s) {
        if (s == null) {
            return null;
        }
        try {
            return URLDecoder.decode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            Log.d(Utils.LOG_TAG, "getURLDecodedString threw: %s", ex);
            return s;
        }
    }
    
    public static final String getURLEncodedString(final String s) {
        if (s == null) {
            return null;
        }
        try {
            return URLEncoder.encode(s, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        }
        catch (UnsupportedEncodingException ex) {
            Log.d(Utils.LOG_TAG, "getURLEncodedString threw: %s", ex);
            return s;
        }
    }
    
    public static boolean isAtLeastAndroidAPI(final int n) {
        return Build$VERSION.SDK_INT >= n;
    }
    
    public static final boolean isNullOrEmpty(final String s) {
        return s == null || s.equals("");
    }
    
    public static final boolean isNullOrWhiteSpace(final String s) {
        return isNullOrEmpty(s) || s.trim().equals("");
    }
    
    public static int parseInt(final String s, final int n) {
        try {
            return Integer.parseInt(s);
        }
        catch (NumberFormatException ex) {
            return n;
        }
    }
    
    public static String sha1(final String s) {
        try {
            final MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(s.getBytes());
            final byte[] digest = instance.digest();
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; ++i) {
                sb.append(Integer.toHexString(0x100 | (0xFF & digest[i])).substring(1));
            }
            return sb.toString();
        }
        catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }
}
