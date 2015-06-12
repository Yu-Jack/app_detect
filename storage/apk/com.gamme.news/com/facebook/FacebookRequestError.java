// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import org.json.JSONException;
import com.facebook.internal.Utility;
import com.facebook.android.R;
import org.json.JSONObject;
import java.net.HttpURLConnection;

public final class FacebookRequestError
{
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    private static final int EC_APP_NOT_INSTALLED = 458;
    private static final int EC_APP_TOO_MANY_CALLS = 4;
    private static final int EC_EXPIRED = 463;
    private static final int EC_INVALID_SESSION = 102;
    private static final int EC_INVALID_TOKEN = 190;
    private static final int EC_PASSWORD_CHANGED = 460;
    private static final int EC_PERMISSION_DENIED = 10;
    private static final Range EC_RANGE_PERMISSION;
    private static final int EC_SERVICE_UNAVAILABLE = 2;
    private static final int EC_UNCONFIRMED_USER = 464;
    private static final int EC_UNKNOWN_ERROR = 1;
    private static final int EC_USER_CHECKPOINTED = 459;
    private static final int EC_USER_TOO_MANY_CALLS = 17;
    private static final String ERROR_CODE_FIELD_KEY = "code";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_KEY = "error";
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    private static final String ERROR_MSG_KEY = "error_msg";
    private static final String ERROR_REASON_KEY = "error_reason";
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    private static final Range HTTP_RANGE_CLIENT_ERROR;
    private static final Range HTTP_RANGE_SERVER_ERROR;
    private static final Range HTTP_RANGE_SUCCESS;
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    private static final int INVALID_MESSAGE_ID;
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final String errorMessage;
    private final String errorType;
    private final FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final boolean shouldNotifyUser;
    private final int subErrorCode;
    private final int userActionMessageId;
    
    static {
        EC_RANGE_PERMISSION = new Range(200, 299, null);
        HTTP_RANGE_SUCCESS = new Range(200, 299, null);
        HTTP_RANGE_CLIENT_ERROR = new Range(400, 499, null);
        HTTP_RANGE_SERVER_ERROR = new Range(500, 599, null);
    }
    
    private FacebookRequestError(final int n, final int n2, final int n3, final String s, final String s2, final JSONObject jsonObject, final JSONObject jsonObject2, final Object o, final HttpURLConnection httpURLConnection) {
        this(n, n2, n3, s, s2, jsonObject, jsonObject2, o, httpURLConnection, null);
    }
    
    private FacebookRequestError(final int requestStatusCode, final int errorCode, final int subErrorCode, final String errorType, final String errorMessage, final JSONObject requestResultBody, final JSONObject requestResult, final Object batchRequestResult, final HttpURLConnection connection, final FacebookException exception) {
        this.requestStatusCode = requestStatusCode;
        this.errorCode = errorCode;
        this.subErrorCode = subErrorCode;
        this.errorType = errorType;
        this.errorMessage = errorMessage;
        this.requestResultBody = requestResultBody;
        this.requestResult = requestResult;
        this.batchRequestResult = batchRequestResult;
        this.connection = connection;
        int n;
        if (exception != null) {
            this.exception = exception;
            n = 1;
        }
        else {
            this.exception = new FacebookServiceException(this, errorMessage);
            n = 0;
        }
        int userActionMessageId = 0;
        boolean shouldNotifyUser = false;
        Category category = null;
        if (n != 0) {
            category = Category.CLIENT;
            userActionMessageId = 0;
        }
        else {
            Label_0142: {
                if (errorCode == 1 || errorCode == 2) {
                    category = Category.SERVER;
                }
                else if (errorCode == 4 || errorCode == 17) {
                    category = Category.THROTTLING;
                    userActionMessageId = 0;
                    shouldNotifyUser = false;
                }
                else if (errorCode == 10 || FacebookRequestError.EC_RANGE_PERMISSION.contains(errorCode)) {
                    category = Category.PERMISSION;
                    userActionMessageId = R.string.com_facebook_requesterror_permissions;
                    shouldNotifyUser = false;
                }
                else {
                    if (errorCode != 102) {
                        category = null;
                        userActionMessageId = 0;
                        shouldNotifyUser = false;
                        if (errorCode != 190) {
                            break Label_0142;
                        }
                    }
                    if (subErrorCode == 459 || subErrorCode == 464) {
                        category = Category.AUTHENTICATION_RETRY;
                        userActionMessageId = R.string.com_facebook_requesterror_web_login;
                        shouldNotifyUser = true;
                    }
                    else {
                        category = Category.AUTHENTICATION_REOPEN_SESSION;
                        if (subErrorCode == 458 || subErrorCode == 463) {
                            userActionMessageId = R.string.com_facebook_requesterror_relogin;
                            shouldNotifyUser = false;
                        }
                        else if (subErrorCode == 460) {
                            userActionMessageId = R.string.com_facebook_requesterror_password_changed;
                            shouldNotifyUser = false;
                        }
                        else {
                            userActionMessageId = R.string.com_facebook_requesterror_reconnect;
                            shouldNotifyUser = true;
                        }
                    }
                }
            }
            if (category == null) {
                if (FacebookRequestError.HTTP_RANGE_CLIENT_ERROR.contains(requestStatusCode)) {
                    category = Category.BAD_REQUEST;
                }
                else if (FacebookRequestError.HTTP_RANGE_SERVER_ERROR.contains(requestStatusCode)) {
                    category = Category.SERVER;
                }
                else {
                    category = Category.OTHER;
                }
            }
        }
        this.category = category;
        this.userActionMessageId = userActionMessageId;
        this.shouldNotifyUser = shouldNotifyUser;
    }
    
    public FacebookRequestError(final int n, final String s, final String s2) {
        this(-1, n, -1, s, s2, null, null, null, null, null);
    }
    
    FacebookRequestError(final HttpURLConnection httpURLConnection, final Exception ex) {
        FacebookException ex2;
        if (ex instanceof FacebookException) {
            ex2 = (FacebookException)ex;
        }
        else {
            ex2 = new FacebookException(ex);
        }
        this(-1, -1, -1, null, null, null, null, null, httpURLConnection, ex2);
    }
    
    static FacebookRequestError checkResponseAndCreateError(final JSONObject jsonObject, final Object o, final HttpURLConnection httpURLConnection) {
        try {
            if (jsonObject.has("code")) {
                final int int1 = jsonObject.getInt("code");
                final Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jsonObject, "body", "FACEBOOK_NON_JSON_RESULT");
                if (stringPropertyAsJSON != null && stringPropertyAsJSON instanceof JSONObject) {
                    final JSONObject jsonObject2 = (JSONObject)stringPropertyAsJSON;
                    int n = -1;
                    int n2 = -1;
                    String s = null;
                    String s2 = null;
                    int n3 = 0;
                    Label_0119: {
                        if (jsonObject2.has("error")) {
                            final JSONObject jsonObject3 = (JSONObject)Utility.getStringPropertyAsJSON(jsonObject2, "error", null);
                            s = jsonObject3.optString("type", (String)null);
                            s2 = jsonObject3.optString("message", (String)null);
                            n = jsonObject3.optInt("code", -1);
                            n2 = jsonObject3.optInt("error_subcode", -1);
                            n3 = 1;
                        }
                        else {
                            if (!jsonObject2.has("error_code") && !jsonObject2.has("error_msg")) {
                                final boolean has = jsonObject2.has("error_reason");
                                s = null;
                                s2 = null;
                                n3 = 0;
                                if (!has) {
                                    break Label_0119;
                                }
                            }
                            s = jsonObject2.optString("error_reason", (String)null);
                            s2 = jsonObject2.optString("error_msg", (String)null);
                            n = jsonObject2.optInt("error_code", -1);
                            n2 = jsonObject2.optInt("error_subcode", -1);
                            n3 = 1;
                        }
                    }
                    if (n3 != 0) {
                        return new FacebookRequestError(int1, n, n2, s, s2, jsonObject2, jsonObject, o, httpURLConnection);
                    }
                }
                if (!FacebookRequestError.HTTP_RANGE_SUCCESS.contains(int1)) {
                    JSONObject jsonObject4;
                    if (jsonObject.has("body")) {
                        jsonObject4 = (JSONObject)Utility.getStringPropertyAsJSON(jsonObject, "body", "FACEBOOK_NON_JSON_RESULT");
                    }
                    else {
                        jsonObject4 = null;
                    }
                    return new FacebookRequestError(int1, -1, -1, null, null, jsonObject4, jsonObject, o, httpURLConnection);
                }
            }
        }
        catch (JSONException ex) {}
        return null;
    }
    
    public Object getBatchRequestResult() {
        return this.batchRequestResult;
    }
    
    public Category getCategory() {
        return this.category;
    }
    
    public HttpURLConnection getConnection() {
        return this.connection;
    }
    
    public int getErrorCode() {
        return this.errorCode;
    }
    
    public String getErrorMessage() {
        if (this.errorMessage != null) {
            return this.errorMessage;
        }
        return this.exception.getLocalizedMessage();
    }
    
    public String getErrorType() {
        return this.errorType;
    }
    
    public FacebookException getException() {
        return this.exception;
    }
    
    public JSONObject getRequestResult() {
        return this.requestResult;
    }
    
    public JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }
    
    public int getRequestStatusCode() {
        return this.requestStatusCode;
    }
    
    public int getSubErrorCode() {
        return this.subErrorCode;
    }
    
    public int getUserActionMessageId() {
        return this.userActionMessageId;
    }
    
    public boolean shouldNotifyUser() {
        return this.shouldNotifyUser;
    }
    
    @Override
    public String toString() {
        return "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", errorType: " + this.errorType + ", errorMessage: " + this.getErrorMessage() + "}";
    }
    
    public enum Category
    {
        AUTHENTICATION_REOPEN_SESSION("AUTHENTICATION_REOPEN_SESSION", 1), 
        AUTHENTICATION_RETRY("AUTHENTICATION_RETRY", 0), 
        BAD_REQUEST("BAD_REQUEST", 6), 
        CLIENT("CLIENT", 7), 
        OTHER("OTHER", 5), 
        PERMISSION("PERMISSION", 2), 
        SERVER("SERVER", 3), 
        THROTTLING("THROTTLING", 4);
        
        private Category(final String name, final int ordinal) {
        }
    }
    
    private static class Range
    {
        private final int end;
        private final int start;
        
        private Range(final int start, final int end) {
            this.start = start;
            this.end = end;
        }
        
        boolean contains(final int n) {
            return this.start <= n && n <= this.end;
        }
    }
}
