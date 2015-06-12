// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.facebook;

import android.support.v4.app.Fragment;
import java.util.EnumSet;
import android.app.Activity;
import android.content.Intent;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import java.util.Date;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import com.facebook.widget.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.widget.WebDialog;
import java.util.Currency;
import java.math.BigDecimal;
import android.content.Context;
import org.apache.cordova.PluginResult;
import java.util.Arrays;
import com.facebook.FacebookAuthorizationException;
import com.facebook.model.GraphUser;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import com.facebook.Response;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import android.util.Log;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.SessionState;
import java.util.HashSet;
import com.facebook.UiLifecycleHelper;
import android.os.Bundle;
import com.facebook.AppEventsLogger;
import org.apache.cordova.CallbackContext;
import java.util.Set;
import org.apache.cordova.CordovaPlugin;

public class ConnectPlugin extends CordovaPlugin
{
    private static final int INVALID_ERROR_CODE = -2;
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS;
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private final String TAG;
    private String applicationId;
    private CallbackContext graphContext;
    private String graphPath;
    private AppEventsLogger logger;
    private CallbackContext loginContext;
    private String method;
    private Bundle paramBundle;
    private CallbackContext showDialogContext;
    private boolean trackingPendingCall;
    private UiLifecycleHelper uiHelper;
    private String userID;
    
    static {
        OTHER_PUBLISH_PERMISSIONS = new HashSet<String>() {
            {
                this.add("ads_management");
                this.add("create_event");
                this.add("rsvp_event");
            }
        };
    }
    
    public ConnectPlugin() {
        this.TAG = "ConnectPlugin";
        this.applicationId = null;
        this.loginContext = null;
        this.showDialogContext = null;
        this.graphContext = null;
        this.trackingPendingCall = false;
    }
    
    static /* synthetic */ void access$11(final ConnectPlugin connectPlugin, final CallbackContext loginContext) {
        connectPlugin.loginContext = loginContext;
    }
    
    static /* synthetic */ void access$4(final ConnectPlugin connectPlugin, final String userID) {
        connectPlugin.userID = userID;
    }
    
    static /* synthetic */ void access$8(final ConnectPlugin connectPlugin, final String graphPath) {
        connectPlugin.graphPath = graphPath;
    }
    
    static /* synthetic */ void access$9(final ConnectPlugin connectPlugin, final CallbackContext graphContext) {
        connectPlugin.graphContext = graphContext;
    }
    
    private boolean checkActiveSession(final Session session) {
        return session != null && session.isOpened();
    }
    
    private void getUserInfo(final Session session, final Request.GraphUserCallback graphUserCallback) {
        if (this.cordova != null) {
            Request.newMeRequest(session, graphUserCallback).executeAsync();
        }
    }
    
    private void handleError(final Exception ex, final CallbackContext callbackContext) {
        String s = "Facebook error: " + ex.getMessage();
        int n = -2;
        if (ex instanceof FacebookOperationCanceledException) {
            s = "User cancelled dialog";
            n = 4201;
        }
        else if (ex instanceof FacebookDialogException) {
            s = "Dialog error: " + ex.getMessage();
        }
        Log.e("ConnectPlugin", ex.toString());
        callbackContext.error(this.getErrorResponse(ex, s, n));
    }
    
    private void handleSuccess(final Bundle bundle) {
        if (bundle.size() <= 0) {
            Log.e("ConnectPlugin", "User cancelled dialog");
            this.showDialogContext.error("User cancelled dialog");
            return;
        }
        while (true) {
            final JSONObject jsonObject = new JSONObject();
            while (true) {
                Label_0154: {
                    while (true) {
                        String substring = null;
                        Label_0133: {
                            while (true) {
                                try {
                                    for (final String s : bundle.keySet()) {
                                        final int index = s.indexOf("[");
                                        if (index < 0) {
                                            break Label_0154;
                                        }
                                        substring = s.substring(0, index);
                                        if (!jsonObject.has(substring)) {
                                            break Label_0133;
                                        }
                                        final JSONArray jsonArray = (JSONArray)jsonObject.get(substring);
                                        jsonArray.put(jsonArray.length(), bundle.get(s));
                                    }
                                    this.showDialogContext.success(jsonObject);
                                    return;
                                }
                                catch (JSONException ex) {
                                    ex.printStackTrace();
                                    continue;
                                }
                                break;
                            }
                        }
                        final JSONArray jsonArray = new JSONArray();
                        jsonObject.put(substring, (Object)jsonArray);
                        continue;
                    }
                }
                final String s;
                jsonObject.put(s, bundle.get(s));
                continue;
            }
        }
    }
    
    private boolean isPublishPermission(final String s) {
        return s != null && (s.startsWith("publish") || s.startsWith("manage") || ConnectPlugin.OTHER_PUBLISH_PERMISSIONS.contains(s));
    }
    
    private void makeGraphCall() {
    Label_0084_Outer:
        while (true) {
            final Session activeSession = Session.getActiveSession();
            final Request.Callback callback = new Request.Callback() {
                @Override
                public void onCompleted(final Response response) {
                    if (ConnectPlugin.this.graphContext != null) {
                        if (response.getError() != null) {
                            ConnectPlugin.this.graphContext.error(ConnectPlugin.this.getFacebookRequestErrorResponse(response.getError()));
                        }
                        else {
                            ConnectPlugin.this.graphContext.success(response.getGraphObject().getInnerJSONObject());
                        }
                        ConnectPlugin.access$8(ConnectPlugin.this, null);
                        ConnectPlugin.access$9(ConnectPlugin.this, null);
                    }
                }
            };
            while (true) {
                Bundle parameters = null;
                String[] split2 = null;
                int n = 0;
            Label_0125:
                while (true) {
                    try {
                        this.graphPath = URLDecoder.decode(this.graphPath, "UTF-8");
                        final String[] split = this.graphPath.split("\\?");
                        final Request graphPathRequest = Request.newGraphPathRequest(null, split[0], (Request.Callback)callback);
                        parameters = graphPathRequest.getParameters();
                        if (split.length > 1) {
                            split2 = split[1].split("&");
                            final int length = split2.length;
                            n = 0;
                            if (n < length) {
                                break Label_0125;
                            }
                        }
                        parameters.putString("access_token", activeSession.getAccessToken());
                        graphPathRequest.setParameters(parameters);
                        graphPathRequest.executeAsync();
                        return;
                    }
                    catch (UnsupportedEncodingException ex) {
                        ex.printStackTrace();
                        continue Label_0084_Outer;
                    }
                    break;
                }
                final String s = split2[n];
                final int index = s.indexOf("=");
                if (index > 0) {
                    parameters.putString(s.substring(0, index), s.substring(index + 1, s.length()));
                }
                ++n;
                continue;
            }
        }
    }
    
    private void onSessionStateChange(final SessionState sessionState, final Exception ex) {
        Log.d("ConnectPlugin", "onSessionStateChange:" + sessionState.toString());
        if (ex != null && ex instanceof FacebookOperationCanceledException) {
            Log.e("ConnectPlugin", "exception:" + ex.toString());
            this.handleError(ex, this.loginContext);
        }
        else {
            final Session activeSession = Session.getActiveSession();
            if (sessionState.isOpened()) {
                if (this.loginContext != null) {
                    this.getUserInfo(activeSession, new Request.GraphUserCallback() {
                        @Override
                        public void onCompleted(final GraphUser graphUser, final Response response) {
                            if (ConnectPlugin.this.loginContext == null) {
                                ConnectPlugin.access$4(ConnectPlugin.this, graphUser.getId());
                                return;
                            }
                            if (response.getError() != null) {
                                ConnectPlugin.this.loginContext.error(ConnectPlugin.this.getFacebookRequestErrorResponse(response.getError()));
                                return;
                            }
                            Log.d("ConnectPlugin", "returning login object " + response.getGraphObject().getInnerJSONObject().toString());
                            ConnectPlugin.access$4(ConnectPlugin.this, graphUser.getId());
                            ConnectPlugin.this.loginContext.success(ConnectPlugin.this.getResponse());
                            ConnectPlugin.access$11(ConnectPlugin.this, null);
                        }
                    });
                    return;
                }
                if (this.graphContext != null) {
                    this.makeGraphCall();
                }
            }
            else if (sessionState == SessionState.CLOSED_LOGIN_FAILED && this.loginContext != null) {
                this.handleError(new FacebookAuthorizationException("Session was closed and was not closed normally"), this.loginContext);
            }
        }
    }
    
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext graphContext) throws JSONException {
        if (s.equals("login")) {
            Log.d("ConnectPlugin", "login FB");
            final String[] a = new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); ++i) {
                a[i] = jsonArray.getString(i);
            }
            final int length = a.length;
            List<String> list = null;
            if (length > 0) {
                list = Arrays.asList(a);
            }
            final Session activeSession = Session.getActiveSession();
            this.loginContext = graphContext;
            final PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT);
            pluginResult.setKeepCallback(true);
            this.loginContext.sendPluginResult(pluginResult);
            if (this.checkActiveSession(activeSession)) {
                boolean b = false;
                boolean b2 = false;
                if (list == null) {
                    b2 = true;
                }
                for (int length2 = a.length, j = 0; j < length2; ++j) {
                    if (this.isPublishPermission(a[j])) {
                        b = true;
                    }
                    else {
                        b2 = true;
                    }
                    if (b && b2) {
                        break;
                    }
                }
                if (b && b2) {
                    graphContext.error("Cannot ask for both read and publish permissions.");
                }
                else {
                    final Session.NewPermissionsRequest newPermissionsRequest = new Session.NewPermissionsRequest(this.cordova.getActivity(), list);
                    this.cordova.setActivityResultCallback(this);
                    if (b) {
                        activeSession.requestNewPublishPermissions(newPermissionsRequest);
                    }
                    else {
                        activeSession.requestNewReadPermissions(newPermissionsRequest);
                    }
                }
            }
            else {
                final Session build = new Session.Builder((Context)this.cordova.getActivity()).setApplicationId(this.applicationId).build();
                this.cordova.setActivityResultCallback(this);
                Session.setActiveSession(build);
                final Session.OpenRequest openRequest = new Session.OpenRequest(this.cordova.getActivity());
                openRequest.setPermissions(list);
                openRequest.setCallback(new Session.StatusCallback() {
                    @Override
                    public void call(final Session session, final SessionState sessionState, final Exception ex) {
                        ConnectPlugin.this.onSessionStateChange(sessionState, ex);
                    }
                });
                build.openForRead(openRequest);
            }
            return true;
        }
        if (s.equals("logout")) {
            final Session activeSession2 = Session.getActiveSession();
            if (this.checkActiveSession(activeSession2)) {
                activeSession2.closeAndClearTokenInformation();
                this.userID = null;
                graphContext.success();
            }
            else if (activeSession2 != null) {
                graphContext.error("Session not open.");
            }
            else {
                graphContext.error("No valid session found, must call init and login before logout.");
            }
            return true;
        }
        if (s.equals("getLoginStatus")) {
            final Session activeSession3 = Session.getActiveSession();
            if (this.userID == null && Session.getActiveSession() != null && activeSession3.isOpened()) {
                this.getUserInfo(activeSession3, new Request.GraphUserCallback() {
                    @Override
                    public void onCompleted(final GraphUser graphUser, final Response response) {
                        if (response.getError() != null) {
                            graphContext.error(ConnectPlugin.this.getFacebookRequestErrorResponse(response.getError()));
                            return;
                        }
                        ConnectPlugin.access$4(ConnectPlugin.this, graphUser.getId());
                        graphContext.success(ConnectPlugin.this.getResponse());
                    }
                });
            }
            else {
                graphContext.success(this.getResponse());
            }
            return true;
        }
        if (s.equals("getAccessToken")) {
            final Session activeSession4 = Session.getActiveSession();
            if (this.checkActiveSession(activeSession4)) {
                graphContext.success(activeSession4.getAccessToken());
            }
            else if (activeSession4 == null) {
                graphContext.error("No valid session found, must call init and login before logout.");
            }
            else {
                graphContext.error("Session not open.");
            }
            return true;
        }
        Label_0829: {
            if (s.equals("logEvent")) {
                if (jsonArray.length() == 0) {
                    graphContext.error("Invalid arguments");
                    return true;
                }
                final String string = jsonArray.getString(0);
                if (jsonArray.length() == 1) {
                    this.logger.logEvent(string);
                }
                else {
                    final JSONObject jsonObject = jsonArray.getJSONObject(1);
                    final Bundle bundle = new Bundle();
                    final Iterator keys = jsonObject.keys();
                    while (keys.hasNext()) {
                        try {
                            final String s2 = keys.next();
                            bundle.putString(s2, jsonObject.getString(s2));
                            continue;
                        }
                        catch (Exception ex) {
                            Log.w("ConnectPlugin", "Type in AppEvent parameters was not String for key: " + keys.next());
                            try {
                                final String s3 = keys.next();
                                bundle.putInt(s3, jsonObject.getInt(s3));
                            }
                            catch (Exception ex2) {
                                Log.e("ConnectPlugin", "Unsupported type in AppEvent parameters for key: " + keys.next());
                            }
                            continue;
                        }
                        break Label_0829;
                    }
                    if (jsonArray.length() == 2) {
                        this.logger.logEvent(string, bundle);
                    }
                    if (jsonArray.length() == 3) {
                        this.logger.logEvent(string, jsonArray.getDouble(2), bundle);
                    }
                }
                graphContext.success();
                return true;
            }
        }
        if (s.equals("logPurchase")) {
            if (jsonArray.length() != 2) {
                graphContext.error("Invalid arguments");
                return true;
            }
            this.logger.logPurchase(BigDecimal.valueOf(jsonArray.getInt(0)), Currency.getInstance(jsonArray.getString(1)));
            graphContext.success();
            return true;
        }
        else if (s.equals("showDialog")) {
            if (!this.checkActiveSession(Session.getActiveSession())) {
                graphContext.error("No active session");
                return true;
            }
        Label_0950_Outer:
            while (true) {
                final Bundle bundle2 = new Bundle();
                WebDialog.OnCompleteListener onCompleteListener = null;
            Label_1157:
                while (true) {
                    JSONObject jsonObject2;
                    Iterator keys2;
                    while (true) {
                        try {
                            jsonObject2 = jsonArray.getJSONObject(0);
                            keys2 = jsonObject2.keys();
                            if (!keys2.hasNext()) {
                                this.paramBundle = new Bundle(bundle2);
                                this.showDialogContext = graphContext;
                                final PluginResult pluginResult2 = new PluginResult(PluginResult.Status.NO_RESULT);
                                pluginResult2.setKeepCallback(true);
                                this.showDialogContext.sendPluginResult(pluginResult2);
                                onCompleteListener = new WebDialog.OnCompleteListener() {
                                    @Override
                                    public void onComplete(final Bundle bundle, final FacebookException ex) {
                                        if (ex != null) {
                                            ConnectPlugin.this.handleError(ex, ConnectPlugin.this.showDialogContext);
                                            return;
                                        }
                                        ConnectPlugin.this.handleSuccess(bundle);
                                    }
                                };
                                if (this.method.equalsIgnoreCase("feed")) {
                                    this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
                                        @Override
                                        public void run() {
                                            ((WebDialog.FeedDialogBuilder)new WebDialog.FeedDialogBuilder((Context)ConnectPlugin.this.cordova.getActivity(), Session.getActiveSession(), ConnectPlugin.this.paramBundle).setOnCompleteListener(onCompleteListener)).build().show();
                                        }
                                    });
                                    return true;
                                }
                                break Label_1157;
                            }
                        }
                        catch (JSONException ex3) {
                            jsonObject2 = new JSONObject();
                            continue Label_0950_Outer;
                        }
                        break;
                    }
                    final String s4 = keys2.next();
                    if (s4.equals("method")) {
                        try {
                            this.method = jsonObject2.getString(s4);
                            continue;
                        }
                        catch (JSONException ex4) {
                            Log.w("ConnectPlugin", "Nonstring method parameter provided to dialog");
                            continue;
                        }
                        continue;
                    }
                    try {
                        bundle2.putString(s4, jsonObject2.getString(s4));
                        continue;
                    }
                    catch (JSONException ex5) {
                        Log.w("ConnectPlugin", "Nonstring parameter provided to dialog discarded");
                        continue;
                    }
                    continue;
                }
                if (this.method.equalsIgnoreCase("apprequests")) {
                    this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            ((WebDialog.RequestsDialogBuilder)new WebDialog.RequestsDialogBuilder((Context)ConnectPlugin.this.cordova.getActivity(), Session.getActiveSession(), ConnectPlugin.this.paramBundle).setOnCompleteListener(onCompleteListener)).build().show();
                        }
                    });
                    return true;
                }
                if (!this.method.equalsIgnoreCase("share") && !this.method.equalsIgnoreCase("share_open_graph")) {
                    graphContext.error("Unsupported dialog method.");
                    return true;
                }
                if (FacebookDialog.canPresentShareDialog((Context)this.cordova.getActivity(), FacebookDialog.ShareDialogFeature.SHARE_DIALOG)) {
                    final Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            ConnectPlugin.this.uiHelper.trackPendingDialogCall(((FacebookDialog.ShareDialogBuilder)((FacebookDialog.ShareDialogBuilder)((FacebookDialog.ShareDialogBuilder)((FacebookDialog.ShareDialogBuilder)((FacebookDialog.ShareDialogBuilder)new FacebookDialog.ShareDialogBuilder(ConnectPlugin.this.cordova.getActivity()).setName(ConnectPlugin.this.paramBundle.getString("name"))).setCaption(ConnectPlugin.this.paramBundle.getString("caption"))).setDescription(ConnectPlugin.this.paramBundle.getString("description"))).setLink(ConnectPlugin.this.paramBundle.getString("href"))).setPicture(ConnectPlugin.this.paramBundle.getString("picture"))).build().present());
                        }
                    };
                    this.trackingPendingCall = true;
                    this.cordova.getActivity().runOnUiThread((Runnable)runnable);
                    return true;
                }
                this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        ((WebDialog.FeedDialogBuilder)new WebDialog.FeedDialogBuilder((Context)ConnectPlugin.this.cordova.getActivity(), Session.getActiveSession(), ConnectPlugin.this.paramBundle).setOnCompleteListener(onCompleteListener)).build().show();
                    }
                });
                return true;
            }
        }
        else {
            if (s.equals("graphApi")) {
                this.graphContext = graphContext;
                final PluginResult pluginResult3 = new PluginResult(PluginResult.Status.NO_RESULT);
                pluginResult3.setKeepCallback(true);
                this.graphContext.sendPluginResult(pluginResult3);
                this.graphPath = jsonArray.getString(0);
                final JSONArray jsonArray2 = jsonArray.getJSONArray(1);
                final ArrayList<Object> list2 = new ArrayList<Object>();
                for (int k = 0; k < jsonArray2.length(); ++k) {
                    list2.add(jsonArray2.getString(k));
                }
                boolean b3 = false;
                boolean b4 = false;
                if (list2.size() > 0) {
                    final Iterator<String> iterator = list2.iterator();
                    while (iterator.hasNext()) {
                        if (this.isPublishPermission(iterator.next())) {
                            b3 = true;
                        }
                        else {
                            b4 = true;
                        }
                        if (b3 && b4) {
                            break;
                        }
                    }
                    if (b3 && b4) {
                        this.graphContext.error("Cannot ask for both read and publish permissions.");
                    }
                    else {
                        final Session activeSession5 = Session.getActiveSession();
                        if (activeSession5.getPermissions().containsAll(list2)) {
                            this.makeGraphCall();
                        }
                        else {
                            final Session.NewPermissionsRequest newPermissionsRequest2 = new Session.NewPermissionsRequest(this.cordova.getActivity(), (List<String>)list2);
                            this.cordova.setActivityResultCallback(this);
                            if (b3) {
                                activeSession5.requestNewPublishPermissions(newPermissionsRequest2);
                            }
                            else {
                                activeSession5.requestNewReadPermissions(newPermissionsRequest2);
                            }
                        }
                    }
                }
                else {
                    this.makeGraphCall();
                }
                return true;
            }
            return false;
        }
    }
    
    public JSONObject getErrorResponse(final Exception ex, String message, int errorCode) {
        if (ex instanceof FacebookServiceException) {
            return this.getFacebookRequestErrorResponse(((FacebookServiceException)ex).getRequestError());
        }
        String string = "{";
        if (ex instanceof FacebookDialogException) {
            errorCode = ((FacebookDialogException)ex).getErrorCode();
        }
        if (errorCode != -2) {
            string = String.valueOf(string) + "\"errorCode\": \"" + errorCode + "\",";
        }
        if (message == null) {
            message = ex.getMessage();
        }
        final String string2 = String.valueOf(string) + "\"errorMessage\": \"" + message + "\"}";
        try {
            return new JSONObject(string2);
        }
        catch (JSONException ex2) {
            ex2.printStackTrace();
            return new JSONObject();
        }
    }
    
    public JSONObject getFacebookRequestErrorResponse(final FacebookRequestError facebookRequestError) {
        String s = "{\"errorCode\": \"" + facebookRequestError.getErrorCode() + "\"," + "\"errorType\": \"" + facebookRequestError.getErrorType() + "\"," + "\"errorMessage\": \"" + facebookRequestError.getErrorMessage() + "\"";
        final int userActionMessageId = facebookRequestError.getUserActionMessageId();
        if (userActionMessageId != 0 && this.cordova.getActivity().getResources().getString(userActionMessageId) != null) {
            s = String.valueOf(s) + ",\"errorUserMessage\": \"" + this.cordova.getActivity().getResources().getString(facebookRequestError.getUserActionMessageId()) + "\"";
        }
        final String string = String.valueOf(s) + "}";
        try {
            return new JSONObject(string);
        }
        catch (JSONException ex) {
            ex.printStackTrace();
            return new JSONObject();
        }
    }
    
    public JSONObject getResponse() {
        long lng = 0L;
        final Session activeSession = Session.getActiveSession();
        Label_0153: {
            if (!this.checkActiveSession(activeSession)) {
                break Label_0153;
            }
            final long n = (activeSession.getExpirationDate().getTime() - new Date().getTime()) / 1000L;
            if (n > lng) {
                lng = n;
            }
            String string = "{\"status\": \"connected\",\"authResponse\": {\"accessToken\": \"" + activeSession.getAccessToken() + "\"," + "\"expiresIn\": \"" + lng + "\"," + "\"session_key\": true," + "\"sig\": \"...\"," + "\"userID\": \"" + this.userID + "\"" + "}" + "}";
            try {
                return new JSONObject(string);
                string = "{\"status\": \"unknown\"}";
                return new JSONObject(string);
            }
            catch (JSONException ex) {
                ex.printStackTrace();
                return new JSONObject();
            }
        }
    }
    
    @Override
    public void initialize(final CordovaInterface cordovaInterface, final CordovaWebView cordovaWebView) {
        this.uiHelper = new UiLifecycleHelper(cordovaInterface.getActivity(), null);
        this.logger = AppEventsLogger.newLogger((Context)cordovaInterface.getActivity());
        this.applicationId = cordovaInterface.getActivity().getString(cordovaInterface.getActivity().getResources().getIdentifier("fb_app_id", "string", cordovaInterface.getActivity().getPackageName()));
        cordovaInterface.setActivityResultCallback(this);
        final Session build = new Session.Builder((Context)cordovaInterface.getActivity()).setApplicationId(this.applicationId).build();
        if (build.getState() == SessionState.CREATED_TOKEN_LOADED) {
            Session.setActiveSession(build);
            final Session.OpenRequest openRequest = new Session.OpenRequest(cordovaInterface.getActivity());
            openRequest.setCallback(new Session.StatusCallback() {
                @Override
                public void call(final Session session, final SessionState sessionState, final Exception ex) {
                    ConnectPlugin.this.onSessionStateChange(sessionState, ex);
                }
            });
            build.openForRead(openRequest);
        }
        if (this.checkActiveSession(build)) {
            this.onSessionStateChange(build.getState(), null);
        }
        super.initialize(cordovaInterface, cordovaWebView);
    }
    
    @Override
    public void onActivityResult(final int i, final int j, final Intent intent) {
        super.onActivityResult(i, j, intent);
        Log.d("ConnectPlugin", "activity result in plugin: requestCode(" + i + "), resultCode(" + j + ")");
        if (this.trackingPendingCall) {
            this.uiHelper.onActivityResult(i, j, intent, new FacebookDialog.Callback() {
                @Override
                public void onComplete(final PendingCall pendingCall, final Bundle bundle) {
                    Log.i("Activity", "Success!");
                    ConnectPlugin.this.handleSuccess(bundle);
                }
                
                @Override
                public void onError(final PendingCall pendingCall, final Exception ex, final Bundle bundle) {
                    Log.e("Activity", String.format("Error: %s", ex.toString()));
                    ConnectPlugin.this.handleError(ex, ConnectPlugin.this.showDialogContext);
                }
            });
        }
        else {
            final Session activeSession = Session.getActiveSession();
            if (activeSession != null && this.loginContext != null) {
                activeSession.onActivityResult(this.cordova.getActivity(), i, j, intent);
            }
        }
        this.trackingPendingCall = false;
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.uiHelper.onDestroy();
    }
    
    public void onPause() {
        this.uiHelper.onPause();
    }
    
    @Override
    public void onResume(final boolean b) {
        super.onResume(b);
        this.uiHelper.onResume();
        AppEventsLogger.activateApp((Context)this.cordova.getActivity());
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        this.uiHelper.onSaveInstanceState(bundle);
    }
}
