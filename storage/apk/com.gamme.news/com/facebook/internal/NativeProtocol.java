// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.internal;

import android.content.pm.Signature;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Build;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.content.ContentResolver;
import java.util.HashSet;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.Settings;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Iterator;
import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import java.util.List;

public final class NativeProtocol
{
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
    public static final String ACTION_FEED_DIALOG_REPLY = "com.facebook.platform.action.reply.FEED_DIALOG";
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
    public static final String ACTION_MESSAGE_DIALOG_REPLY = "com.facebook.platform.action.reply.MESSAGE_DIALOG";
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    public static final String ACTION_OGACTIONPUBLISH_DIALOG_REPLY = "com.facebook.platform.action.reply.OGACTIONPUBLISH_DIALOG";
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG_REPLY = "com.facebook.platform.action.reply.OGMESSAGEPUBLISH_DIALOG";
    public static final String AUDIENCE_EVERYONE = "EVERYONE";
    public static final String AUDIENCE_FRIENDS = "ALL_FRIENDS";
    public static final String AUDIENCE_ME = "SELF";
    private static final String CONTENT_SCHEME = "content://";
    public static final int DIALOG_REQUEST_CODE = 64207;
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
    public static final String ERROR_NETWORK_ERROR = "NetworkError";
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
    public static final String ERROR_USER_CANCELED = "UserCanceled";
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
    public static final String EXTRA_ACTION = "com.facebook.platform.extra.ACTION";
    public static final String EXTRA_ACTION_TYPE = "com.facebook.platform.extra.ACTION_TYPE";
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
    public static final String EXTRA_DATA_FAILURES_FATAL = "com.facebook.platform.extra.DATA_FAILURES_FATAL";
    public static final String EXTRA_DESCRIPTION = "com.facebook.platform.extra.DESCRIPTION";
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
    public static final String EXTRA_FRIEND_TAGS = "com.facebook.platform.extra.FRIENDS";
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
    public static final String EXTRA_IMAGE = "com.facebook.platform.extra.IMAGE";
    public static final String EXTRA_LINK = "com.facebook.platform.extra.LINK";
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
    public static final String EXTRA_PHOTOS = "com.facebook.platform.extra.PHOTOS";
    public static final String EXTRA_PLACE_TAG = "com.facebook.platform.extra.PLACE";
    public static final String EXTRA_PREVIEW_PROPERTY_NAME = "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME";
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
    static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
    public static final String EXTRA_REF = "com.facebook.platform.extra.REF";
    public static final String EXTRA_SUBTITLE = "com.facebook.platform.extra.SUBTITLE";
    public static final String EXTRA_TITLE = "com.facebook.platform.extra.TITLE";
    private static final NativeAppInfo FACEBOOK_APP_INFO;
    private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
    public static final String IMAGE_URL_KEY = "url";
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
    static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
    static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
    private static final List<Integer> KNOWN_PROTOCOL_VERSIONS;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
    static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
    static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
    public static final int NO_PROTOCOL_AVAILABLE = -1;
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
    private static final String PLATFORM_ASYNC_APPCALL_ACTION = "com.facebook.platform.AppCallResultBroadcast";
    private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
    private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
    public static final int PROTOCOL_VERSION_20121101 = 20121101;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
    private static Map<String, List<NativeAppInfo>> actionToAppInfoMap;
    private static List<NativeAppInfo> facebookAppInfoList;
    
    static {
        FACEBOOK_APP_INFO = (NativeAppInfo)new KatanaAppInfo((KatanaAppInfo)null);
        NativeProtocol.facebookAppInfoList = buildFacebookAppList();
        NativeProtocol.actionToAppInfoMap = buildActionToAppInfoMap();
        KNOWN_PROTOCOL_VERSIONS = Arrays.asList(20140324, 20140204, 20131107, 20130618, 20130502, 20121101);
    }
    
    private static Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
        final HashMap<String, ArrayList<MessengerAppInfo>> hashMap = (HashMap<String, ArrayList<MessengerAppInfo>>)new HashMap<String, List<MessengerAppInfo>>();
        final ArrayList<MessengerAppInfo> list = new ArrayList<MessengerAppInfo>();
        list.add(new MessengerAppInfo((MessengerAppInfo)null));
        hashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", (List<MessengerAppInfo>)NativeProtocol.facebookAppInfoList);
        hashMap.put("com.facebook.platform.action.request.FEED_DIALOG", NativeProtocol.facebookAppInfoList);
        hashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", list);
        hashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", list);
        return (Map<String, List<NativeAppInfo>>)hashMap;
    }
    
    private static List<NativeAppInfo> buildFacebookAppList() {
        final ArrayList<WakizashiAppInfo> list = new ArrayList<WakizashiAppInfo>();
        list.add(NativeProtocol.FACEBOOK_APP_INFO);
        list.add(new WakizashiAppInfo((WakizashiAppInfo)null));
        return (List<NativeAppInfo>)list;
    }
    
    private static Uri buildPlatformProviderVersionURI(final NativeAppInfo nativeAppInfo) {
        return Uri.parse("content://" + nativeAppInfo.getPackage() + ".provider.PlatformProvider/versions");
    }
    
    public static Intent createPlatformActivityIntent(final Context context, final String s, final int n, final Bundle bundle) {
        final Intent activityIntent = findActivityIntent(context, "com.facebook.platform.PLATFORM_ACTIVITY", s);
        if (activityIntent == null) {
            return null;
        }
        activityIntent.putExtras(bundle).putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", n).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", s);
        return activityIntent;
    }
    
    public static Intent createPlatformServiceIntent(final Context context) {
        for (final NativeAppInfo nativeAppInfo : NativeProtocol.facebookAppInfoList) {
            final Intent validateServiceIntent = validateServiceIntent(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
            if (validateServiceIntent != null) {
                return validateServiceIntent;
            }
        }
        return null;
    }
    
    public static Intent createProxyAuthIntent(final Context context, final String s, final List<String> list, final String s2, final boolean b) {
        for (final NativeAppInfo nativeAppInfo : NativeProtocol.facebookAppInfoList) {
            final Intent putExtra = new Intent().setClassName(nativeAppInfo.getPackage(), "com.facebook.katana.ProxyAuth").putExtra("client_id", s);
            if (!Utility.isNullOrEmpty((Collection<Object>)list)) {
                putExtra.putExtra("scope", TextUtils.join((CharSequence)",", (Iterable)list));
            }
            if (!Utility.isNullOrEmpty(s2)) {
                putExtra.putExtra("e2e", s2);
            }
            putExtra.putExtra("response_type", "token");
            putExtra.putExtra("return_scopes", "true");
            if (!Settings.getPlatformCompatibilityEnabled()) {
                putExtra.putExtra("legacy_override", "v2.0");
                if (b) {
                    putExtra.putExtra("auth_type", "rerequest");
                }
            }
            final Intent validateActivityIntent = validateActivityIntent(context, putExtra, nativeAppInfo);
            if (validateActivityIntent != null) {
                return validateActivityIntent;
            }
        }
        return null;
    }
    
    public static Intent createTokenRefreshIntent(final Context context) {
        for (final NativeAppInfo nativeAppInfo : NativeProtocol.facebookAppInfoList) {
            final Intent validateServiceIntent = validateServiceIntent(context, new Intent().setClassName(nativeAppInfo.getPackage(), "com.facebook.katana.platform.TokenRefreshService"), nativeAppInfo);
            if (validateServiceIntent != null) {
                return validateServiceIntent;
            }
        }
        return null;
    }
    
    private static Intent findActivityIntent(final Context context, final String action, final String s) {
        final List<NativeAppInfo> list = NativeProtocol.actionToAppInfoMap.get(s);
        Intent validateActivityIntent;
        if (list == null) {
            validateActivityIntent = null;
        }
        else {
            validateActivityIntent = null;
            for (final NativeAppInfo nativeAppInfo : list) {
                validateActivityIntent = validateActivityIntent(context, new Intent().setAction(action).setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
                if (validateActivityIntent != null) {
                    return validateActivityIntent;
                }
            }
        }
        return validateActivityIntent;
    }
    
    public static Exception getErrorFromResult(final Intent intent) {
        if (!isErrorResult(intent)) {
            return null;
        }
        final String stringExtra = intent.getStringExtra("com.facebook.platform.status.ERROR_TYPE");
        final String stringExtra2 = intent.getStringExtra("com.facebook.platform.status.ERROR_DESCRIPTION");
        if (stringExtra.equalsIgnoreCase("UserCanceled")) {
            return new FacebookOperationCanceledException(stringExtra2);
        }
        return new FacebookException(stringExtra2);
    }
    
    public static int getLatestAvailableProtocolVersionForAction(final Context context, final String s, final int n) {
        return getLatestAvailableProtocolVersionForAppInfoList(context, NativeProtocol.actionToAppInfoMap.get(s), n);
    }
    
    private static int getLatestAvailableProtocolVersionForAppInfo(final Context context, final NativeAppInfo nativeAppInfo, final int n) {
        while (true) {
            final ContentResolver contentResolver = context.getContentResolver();
            final String[] array = { "version" };
            final Uri buildPlatformProviderVersionURI = buildPlatformProviderVersionURI(nativeAppInfo);
            Cursor query = null;
            Integer n2;
            while (true) {
                HashSet<Integer> set;
                Iterator<Integer> iterator;
                try {
                    query = contentResolver.query(buildPlatformProviderVersionURI, array, (String)null, (String[])null, (String)null);
                    if (query == null) {
                        if (query != null) {
                            query.close();
                        }
                        return -1;
                    }
                    set = new HashSet<Integer>();
                    while (query.moveToNext()) {
                        set.add(query.getInt(query.getColumnIndex("version")));
                    }
                    iterator = NativeProtocol.KNOWN_PROTOCOL_VERSIONS.iterator();
                    if (!iterator.hasNext()) {
                        return -1;
                    }
                }
                finally {
                    if (query != null) {
                        query.close();
                    }
                }
                n2 = iterator.next();
                if (n2 < n) {
                    if (query != null) {
                        query.close();
                    }
                    return -1;
                }
                if (!set.contains(n2)) {
                    continue;
                }
                break;
            }
            final int intValue = n2;
            if (query != null) {
                query.close();
                return intValue;
            }
            return intValue;
        }
    }
    
    private static int getLatestAvailableProtocolVersionForAppInfoList(final Context context, final List<NativeAppInfo> list, final int n) {
        if (list == null) {
            return -1;
        }
        final Iterator<NativeAppInfo> iterator = list.iterator();
        while (iterator.hasNext()) {
            final int latestAvailableProtocolVersionForAppInfo = getLatestAvailableProtocolVersionForAppInfo(context, iterator.next(), n);
            if (latestAvailableProtocolVersionForAppInfo != -1) {
                return latestAvailableProtocolVersionForAppInfo;
            }
        }
        return -1;
    }
    
    public static int getLatestAvailableProtocolVersionForService(final Context context, final int n) {
        return getLatestAvailableProtocolVersionForAppInfoList(context, NativeProtocol.facebookAppInfoList, n);
    }
    
    public static boolean isErrorResult(final Intent intent) {
        return intent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
    }
    
    static Intent validateActivityIntent(final Context context, Intent intent, final NativeAppInfo nativeAppInfo) {
        if (intent == null) {
            intent = null;
        }
        else {
            final ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity == null) {
                return null;
            }
            if (!nativeAppInfo.validateSignature(context, resolveActivity.activityInfo.packageName)) {
                return null;
            }
        }
        return intent;
    }
    
    static Intent validateServiceIntent(final Context context, Intent intent, final NativeAppInfo nativeAppInfo) {
        if (intent == null) {
            intent = null;
        }
        else {
            final ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService == null) {
                return null;
            }
            if (!nativeAppInfo.validateSignature(context, resolveService.serviceInfo.packageName)) {
                return null;
            }
        }
        return intent;
    }
    
    private static class KatanaAppInfo extends NativeAppInfo
    {
        static final String KATANA_PACKAGE = "com.facebook.katana";
        
        private KatanaAppInfo() {
            super(null);
        }
        
        @Override
        protected String getPackage() {
            return "com.facebook.katana";
        }
    }
    
    private static class MessengerAppInfo extends NativeAppInfo
    {
        static final String MESSENGER_PACKAGE = "com.facebook.orca";
        
        private MessengerAppInfo() {
            super(null);
        }
        
        @Override
        protected String getPackage() {
            return "com.facebook.orca";
        }
    }
    
    private abstract static class NativeAppInfo
    {
        private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
        private static final String FBL_HASH = "5e8f16062ea3cd2c4a0d547876baa6f38cabf625";
        private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
        private static final HashSet<String> validAppSignatureHashes;
        
        static {
            validAppSignatureHashes = buildAppSignatureHashes();
        }
        
        private static HashSet<String> buildAppSignatureHashes() {
            final HashSet<String> set = new HashSet<String>();
            set.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
            set.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
            set.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
            return set;
        }
        
        protected abstract String getPackage();
        
        public boolean validateSignature(final Context context, final String s) {
            final String brand = Build.BRAND;
            final int flags = context.getApplicationInfo().flags;
            if (!brand.startsWith("generic") || (flags & 0x2) == 0x0) {
                while (true) {
                    while (true) {
                        Signature[] signatures;
                        int n;
                        try {
                            signatures = context.getPackageManager().getPackageInfo(s, 64).signatures;
                            final int length = signatures.length;
                            n = 0;
                            if (n >= length) {
                                return false;
                            }
                        }
                        catch (PackageManager$NameNotFoundException ex) {
                            return false;
                        }
                        if (!NativeAppInfo.validAppSignatureHashes.contains(Utility.sha1hash(signatures[n].toByteArray()))) {
                            ++n;
                            continue;
                        }
                        break;
                    }
                    break;
                }
            }
            return true;
        }
    }
    
    private static class WakizashiAppInfo extends NativeAppInfo
    {
        static final String WAKIZASHI_PACKAGE = "com.facebook.wakizashi";
        
        private WakizashiAppInfo() {
            super(null);
        }
        
        @Override
        protected String getPackage() {
            return "com.facebook.wakizashi";
        }
    }
}
