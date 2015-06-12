// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.internal;

import com.facebook.Settings;
import java.util.Collection;

public final class ServerProtocol
{
    private static final String DIALOG_AUTHORITY_FORMAT = "m.%s";
    public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";
    public static final String DIALOG_PARAM_APP_ID = "app_id";
    public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";
    public static final String DIALOG_PARAM_CLIENT_ID = "client_id";
    public static final String DIALOG_PARAM_DISPLAY = "display";
    public static final String DIALOG_PARAM_E2E = "e2e";
    public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";
    public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";
    public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";
    public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";
    public static final String DIALOG_PARAM_SCOPE = "scope";
    public static final String DIALOG_PATH = "dialog/";
    public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";
    public static final String DIALOG_RESPONSE_TYPE_TOKEN = "token";
    public static final String DIALOG_RETURN_SCOPES_TRUE = "true";
    public static final String GRAPH_API_VERSION = "v2.0";
    private static final String GRAPH_URL_FORMAT = "https://graph.%s";
    private static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";
    private static final String LEGACY_API_VERSION = "v1.0";
    public static final String REST_METHOD_BASE = "method";
    private static final String REST_URL_FORMAT = "https://api.%s";
    public static final Collection<String> errorsProxyAuthDisabled;
    public static final Collection<String> errorsUserCanceled;
    
    static {
        errorsProxyAuthDisabled = Utility.unmodifiableCollection("service_disabled", "AndroidAuthKillSwitchException");
        errorsUserCanceled = Utility.unmodifiableCollection("access_denied", "OAuthAccessDeniedException");
    }
    
    public static final String getAPIVersion() {
        if (Settings.getPlatformCompatibilityEnabled()) {
            return "v1.0";
        }
        return "v2.0";
    }
    
    public static final String getDialogAuthority() {
        return String.format("m.%s", Settings.getFacebookDomain());
    }
    
    public static final String getGraphUrlBase() {
        return String.format("https://graph.%s", Settings.getFacebookDomain());
    }
    
    public static final String getGraphVideoUrlBase() {
        return String.format("https://graph-video.%s", Settings.getFacebookDomain());
    }
    
    public static final String getRestUrlBase() {
        return String.format("https://api.%s", Settings.getFacebookDomain());
    }
}
