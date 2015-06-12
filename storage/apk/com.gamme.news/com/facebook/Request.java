// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.graphics.Bitmap$CompressFormat;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.facebook.model.GraphMultiResult;
import java.net.URLEncoder;
import android.util.Pair;
import org.json.JSONException;
import java.util.HashMap;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import com.facebook.model.GraphObjectList;
import java.util.Map;
import java.text.SimpleDateFormat;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import com.facebook.model.OpenGraphObject;
import com.facebook.model.OpenGraphAction;
import com.facebook.model.GraphPlace;
import com.facebook.model.GraphUser;
import com.facebook.internal.AttributionIdentifiers;
import android.content.Context;
import java.util.Date;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.File;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Handler;
import java.util.HashSet;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collection;
import com.facebook.internal.Validate;
import java.io.IOException;
import java.util.Locale;
import java.net.HttpURLConnection;
import java.util.Iterator;
import android.net.Uri$Builder;
import android.util.Log;
import com.facebook.internal.Utility;
import com.facebook.internal.Logger;
import java.util.List;
import java.net.URL;
import com.facebook.internal.ServerProtocol;
import android.os.Bundle;
import com.facebook.model.GraphObject;
import java.util.regex.Pattern;

public class Request
{
    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
    private static final String ACCESS_TOKEN_PARAM = "access_token";
    private static final String ATTACHED_FILES_PARAM = "attached_files";
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";
    private static final String BATCH_BODY_PARAM = "body";
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    private static final String BATCH_ENTRY_NAME_PARAM = "name";
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    private static final String BATCH_METHOD_PARAM = "method";
    private static final String BATCH_PARAM = "batch";
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String FORMAT_JSON = "json";
    private static final String FORMAT_PARAM = "format";
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    private static final String ME = "me";
    private static final String MIME_BOUNDARY = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
    private static final String MY_ACTION_FORMAT = "me/%s";
    private static final String MY_FEED = "me/feed";
    private static final String MY_FRIENDS = "me/friends";
    private static final String MY_OBJECTS_FORMAT = "me/objects/%s";
    private static final String MY_PHOTOS = "me/photos";
    private static final String MY_STAGING_RESOURCES = "me/staging_resources";
    private static final String MY_VIDEOS = "me/videos";
    private static final String OBJECT_PARAM = "object";
    private static final String PICTURE_PARAM = "picture";
    private static final String SDK_ANDROID = "android";
    private static final String SDK_PARAM = "sdk";
    private static final String SEARCH = "search";
    private static final String STAGING_PARAM = "file";
    public static final String TAG;
    private static final String USER_AGENT_BASE = "FBAndroidSDK";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static final String VIDEOS_SUFFIX = "/videos";
    private static String defaultBatchApplicationId;
    private static volatile String userAgent;
    private static Pattern versionPattern;
    private String batchEntryDependsOn;
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;
    private Callback callback;
    private GraphObject graphObject;
    private String graphPath;
    private HttpMethod httpMethod;
    private String overriddenURL;
    private Bundle parameters;
    private String restMethod;
    private Session session;
    private Object tag;
    private String version;
    
    static {
        TAG = Request.class.getSimpleName();
        Request.versionPattern = Pattern.compile("^v\\d+\\.\\d+/.*");
    }
    
    public Request() {
        this(null, null, null, null, null);
    }
    
    public Request(final Session session, final String s) {
        this(session, s, null, null, null);
    }
    
    public Request(final Session session, final String s, final Bundle bundle, final HttpMethod httpMethod) {
        this(session, s, bundle, httpMethod, null);
    }
    
    public Request(final Session session, final String s, final Bundle bundle, final HttpMethod httpMethod, final Callback callback) {
        this(session, s, bundle, httpMethod, callback, null);
    }
    
    public Request(final Session session, final String graphPath, final Bundle bundle, final HttpMethod httpMethod, final Callback callback, final String version) {
        this.batchEntryOmitResultOnSuccess = true;
        this.session = session;
        this.graphPath = graphPath;
        this.callback = callback;
        this.version = version;
        this.setHttpMethod(httpMethod);
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        }
        else {
            this.parameters = new Bundle();
        }
        if (this.version == null) {
            this.version = ServerProtocol.getAPIVersion();
        }
    }
    
    Request(final Session session, final URL url) {
        this.batchEntryOmitResultOnSuccess = true;
        this.session = session;
        this.overriddenURL = url.toString();
        this.setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
    }
    
    private void addCommonParameters() {
        if (this.session != null) {
            if (!this.session.isOpened()) {
                throw new FacebookException("Session provided to a Request in un-opened state.");
            }
            if (!this.parameters.containsKey("access_token")) {
                final String accessToken = this.session.getAccessToken();
                Logger.registerAccessToken(accessToken);
                this.parameters.putString("access_token", accessToken);
            }
        }
        else if (!this.parameters.containsKey("access_token")) {
            final String applicationId = Settings.getApplicationId();
            final String clientToken = Settings.getClientToken();
            if (!Utility.isNullOrEmpty(applicationId) && !Utility.isNullOrEmpty(clientToken)) {
                this.parameters.putString("access_token", String.valueOf(applicationId) + "|" + clientToken);
            }
            else {
                Log.d(Request.TAG, "Warning: Sessionless Request needs token but missing either application ID or client token.");
            }
        }
        this.parameters.putString("sdk", "android");
        this.parameters.putString("format", "json");
    }
    
    private String appendParametersToBaseUrl(final String s) {
        final Uri$Builder encodedPath = new Uri$Builder().encodedPath(s);
        for (final String s2 : this.parameters.keySet()) {
            Object value = this.parameters.get(s2);
            if (value == null) {
                value = "";
            }
            if (isSupportedParameterType(value)) {
                encodedPath.appendQueryParameter(s2, parameterToString(value).toString());
            }
            else {
                if (this.httpMethod == HttpMethod.GET) {
                    throw new IllegalArgumentException(String.format("Unsupported parameter type for GET request: %s", value.getClass().getSimpleName()));
                }
                continue;
            }
        }
        return encodedPath.toString();
    }
    
    static HttpURLConnection createConnection(final URL url) throws IOException {
        final HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("Content-Type", getMimeContentType());
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }
    
    public static Response executeAndWait(final Request request) {
        final List<Response> executeBatchAndWait = executeBatchAndWait(request);
        if (executeBatchAndWait == null || executeBatchAndWait.size() != 1) {
            throw new FacebookException("invalid state: expected a single response");
        }
        return executeBatchAndWait.get(0);
    }
    
    public static List<Response> executeBatchAndWait(final RequestBatch requestBatch) {
        Validate.notEmptyAndContainsNoNulls((Collection<Object>)requestBatch, "requests");
        try {
            return executeConnectionAndWait(toHttpConnection(requestBatch), requestBatch);
        }
        catch (Exception ex) {
            final List<Response> constructErrorResponses = Response.constructErrorResponses(requestBatch.getRequests(), null, new FacebookException(ex));
            runCallbacks(requestBatch, constructErrorResponses);
            return constructErrorResponses;
        }
    }
    
    public static List<Response> executeBatchAndWait(final Collection<Request> collection) {
        return executeBatchAndWait(new RequestBatch(collection));
    }
    
    public static List<Response> executeBatchAndWait(final Request... a) {
        Validate.notNull(a, "requests");
        return executeBatchAndWait(Arrays.asList(a));
    }
    
    public static RequestAsyncTask executeBatchAsync(final RequestBatch requestBatch) {
        Validate.notEmptyAndContainsNoNulls((Collection<Object>)requestBatch, "requests");
        final RequestAsyncTask requestAsyncTask = new RequestAsyncTask(requestBatch);
        requestAsyncTask.executeOnSettingsExecutor();
        return requestAsyncTask;
    }
    
    public static RequestAsyncTask executeBatchAsync(final Collection<Request> collection) {
        return executeBatchAsync(new RequestBatch(collection));
    }
    
    public static RequestAsyncTask executeBatchAsync(final Request... a) {
        Validate.notNull(a, "requests");
        return executeBatchAsync(Arrays.asList(a));
    }
    
    public static List<Response> executeConnectionAndWait(final HttpURLConnection httpURLConnection, final RequestBatch requestBatch) {
        final List<Response> fromHttpConnection = Response.fromHttpConnection(httpURLConnection, requestBatch);
        Utility.disconnectQuietly(httpURLConnection);
        final int size = requestBatch.size();
        if (size != fromHttpConnection.size()) {
            throw new FacebookException(String.format("Received %d responses while expecting %d", fromHttpConnection.size(), size));
        }
        runCallbacks(requestBatch, fromHttpConnection);
        final HashSet<Session> set = new HashSet<Session>();
        for (final Request request : requestBatch) {
            if (request.session != null) {
                set.add(request.session);
            }
        }
        final Iterator<Session> iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().extendAccessTokenIfNeeded();
        }
        return fromHttpConnection;
    }
    
    public static List<Response> executeConnectionAndWait(final HttpURLConnection httpURLConnection, final Collection<Request> collection) {
        return executeConnectionAndWait(httpURLConnection, new RequestBatch(collection));
    }
    
    public static RequestAsyncTask executeConnectionAsync(final Handler callbackHandler, final HttpURLConnection httpURLConnection, final RequestBatch requestBatch) {
        Validate.notNull(httpURLConnection, "connection");
        final RequestAsyncTask requestAsyncTask = new RequestAsyncTask(httpURLConnection, requestBatch);
        requestBatch.setCallbackHandler(callbackHandler);
        requestAsyncTask.executeOnSettingsExecutor();
        return requestAsyncTask;
    }
    
    public static RequestAsyncTask executeConnectionAsync(final HttpURLConnection httpURLConnection, final RequestBatch requestBatch) {
        return executeConnectionAsync(null, httpURLConnection, requestBatch);
    }
    
    @Deprecated
    public static RequestAsyncTask executeGraphPathRequestAsync(final Session session, final String s, final Callback callback) {
        return newGraphPathRequest(session, s, callback).executeAsync();
    }
    
    @Deprecated
    public static RequestAsyncTask executeMeRequestAsync(final Session session, final GraphUserCallback graphUserCallback) {
        return newMeRequest(session, graphUserCallback).executeAsync();
    }
    
    @Deprecated
    public static RequestAsyncTask executeMyFriendsRequestAsync(final Session session, final GraphUserListCallback graphUserListCallback) {
        return newMyFriendsRequest(session, graphUserListCallback).executeAsync();
    }
    
    @Deprecated
    public static RequestAsyncTask executePlacesSearchRequestAsync(final Session session, final Location location, final int n, final int n2, final String s, final GraphPlaceListCallback graphPlaceListCallback) {
        return newPlacesSearchRequest(session, location, n, n2, s, graphPlaceListCallback).executeAsync();
    }
    
    @Deprecated
    public static RequestAsyncTask executePostRequestAsync(final Session session, final String s, final GraphObject graphObject, final Callback callback) {
        return newPostRequest(session, s, graphObject, callback).executeAsync();
    }
    
    @Deprecated
    public static RequestAsyncTask executeRestRequestAsync(final Session session, final String s, final Bundle bundle, final HttpMethod httpMethod) {
        return newRestRequest(session, s, bundle, httpMethod).executeAsync();
    }
    
    @Deprecated
    public static RequestAsyncTask executeStatusUpdateRequestAsync(final Session session, final String s, final Callback callback) {
        return newStatusUpdateRequest(session, s, callback).executeAsync();
    }
    
    @Deprecated
    public static RequestAsyncTask executeUploadPhotoRequestAsync(final Session session, final Bitmap bitmap, final Callback callback) {
        return newUploadPhotoRequest(session, bitmap, callback).executeAsync();
    }
    
    @Deprecated
    public static RequestAsyncTask executeUploadPhotoRequestAsync(final Session session, final File file, final Callback callback) throws FileNotFoundException {
        return newUploadPhotoRequest(session, file, callback).executeAsync();
    }
    
    private static String getBatchAppId(final RequestBatch requestBatch) {
        if (!Utility.isNullOrEmpty(requestBatch.getBatchApplicationId())) {
            return requestBatch.getBatchApplicationId();
        }
        final Iterator<Request> iterator = requestBatch.iterator();
        while (iterator.hasNext()) {
            final Session session = iterator.next().session;
            if (session != null) {
                return session.getApplicationId();
            }
        }
        return Request.defaultBatchApplicationId;
    }
    
    public static final String getDefaultBatchApplicationId() {
        return Request.defaultBatchApplicationId;
    }
    
    private String getGraphPathWithVersion() {
        if (Request.versionPattern.matcher(this.graphPath).matches()) {
            return this.graphPath;
        }
        return String.format("%s/%s", this.version, this.graphPath);
    }
    
    private static String getMimeContentType() {
        return String.format("multipart/form-data; boundary=%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
    }
    
    private String getRestPathWithVersion() {
        if (Request.versionPattern.matcher(this.restMethod).matches()) {
            return this.restMethod;
        }
        return String.format("%s/%s/%s", this.version, "method", this.restMethod);
    }
    
    private static String getUserAgent() {
        if (Request.userAgent == null) {
            Request.userAgent = String.format("%s.%s", "FBAndroidSDK", "3.15.0");
        }
        return Request.userAgent;
    }
    
    private static boolean hasOnProgressCallbacks(final RequestBatch requestBatch) {
        final Iterator<RequestBatch.Callback> iterator = requestBatch.getCallbacks().iterator();
        while (iterator.hasNext()) {
            if (((RequestBatch.Callback)iterator.next()) instanceof RequestBatch.OnProgressCallback) {
                return true;
            }
        }
        final Iterator<Request> iterator2 = requestBatch.iterator();
        while (iterator2.hasNext()) {
            if (iterator2.next().getCallback() instanceof OnProgressCallback) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean isSupportedAttachmentType(final Object o) {
        return o instanceof Bitmap || o instanceof byte[] || o instanceof ParcelFileDescriptor || o instanceof ParcelFileDescriptorWithMimeType;
    }
    
    private static boolean isSupportedParameterType(final Object o) {
        return o instanceof String || o instanceof Boolean || o instanceof Number || o instanceof Date;
    }
    
    public static Request newCustomAudienceThirdPartyIdRequest(final Session session, final Context context, final Callback callback) {
        return newCustomAudienceThirdPartyIdRequest(session, context, null, callback);
    }
    
    public static Request newCustomAudienceThirdPartyIdRequest(Session activeSession, final Context context, String obj, final Callback callback) {
        if (activeSession == null) {
            activeSession = Session.getActiveSession();
        }
        if (activeSession != null && !activeSession.isOpened()) {
            activeSession = null;
        }
        if (obj == null) {
            if (activeSession != null) {
                obj = activeSession.getApplicationId();
            }
            else {
                obj = Utility.getMetadataApplicationId(context);
            }
        }
        if (obj == null) {
            throw new FacebookException("Facebook App ID cannot be determined");
        }
        final String string = String.valueOf(obj) + "/custom_audience_third_party_id";
        final AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        final Bundle bundle = new Bundle();
        if (activeSession == null) {
            String s;
            if (attributionIdentifiers.getAttributionId() != null) {
                s = attributionIdentifiers.getAttributionId();
            }
            else {
                s = attributionIdentifiers.getAndroidAdvertiserId();
            }
            if (attributionIdentifiers.getAttributionId() != null) {
                bundle.putString("udid", s);
            }
        }
        if (Settings.getLimitEventAndDataUsage(context) || attributionIdentifiers.isTrackingLimited()) {
            bundle.putString("limit_event_usage", "1");
        }
        return new Request(activeSession, string, bundle, HttpMethod.GET, callback);
    }
    
    public static Request newDeleteObjectRequest(final Session session, final String s, final Callback callback) {
        return new Request(session, s, null, HttpMethod.DELETE, callback);
    }
    
    public static Request newGraphPathRequest(final Session session, final String s, final Callback callback) {
        return new Request(session, s, null, null, callback);
    }
    
    public static Request newMeRequest(final Session session, final GraphUserCallback graphUserCallback) {
        return new Request(session, "me", null, null, (Callback)new Callback() {
            @Override
            public void onCompleted(final Response response) {
                if (graphUserCallback != null) {
                    graphUserCallback.onCompleted(response.getGraphObjectAs(GraphUser.class), response);
                }
            }
        });
    }
    
    public static Request newMyFriendsRequest(final Session session, final GraphUserListCallback graphUserListCallback) {
        return new Request(session, "me/friends", null, null, (Callback)new Callback() {
            @Override
            public void onCompleted(final Response response) {
                if (graphUserListCallback != null) {
                    graphUserListCallback.onCompleted(typedListFromResponse(response, (Class<GraphObject>)GraphUser.class), response);
                }
            }
        });
    }
    
    public static Request newPlacesSearchRequest(final Session session, final Location location, final int n, final int n2, final String s, final GraphPlaceListCallback graphPlaceListCallback) {
        if (location == null && Utility.isNullOrEmpty(s)) {
            throw new FacebookException("Either location or searchText must be specified.");
        }
        final Bundle bundle = new Bundle(5);
        bundle.putString("type", "place");
        bundle.putInt("limit", n2);
        if (location != null) {
            bundle.putString("center", String.format(Locale.US, "%f,%f", location.getLatitude(), location.getLongitude()));
            bundle.putInt("distance", n);
        }
        if (!Utility.isNullOrEmpty(s)) {
            bundle.putString("q", s);
        }
        return new Request(session, "search", bundle, HttpMethod.GET, (Callback)new Callback() {
            @Override
            public void onCompleted(final Response response) {
                if (graphPlaceListCallback != null) {
                    graphPlaceListCallback.onCompleted(typedListFromResponse(response, (Class<GraphObject>)GraphPlace.class), response);
                }
            }
        });
    }
    
    public static Request newPostOpenGraphActionRequest(final Session session, final OpenGraphAction openGraphAction, final Callback callback) {
        if (openGraphAction == null) {
            throw new FacebookException("openGraphAction cannot be null");
        }
        if (Utility.isNullOrEmpty(openGraphAction.getType())) {
            throw new FacebookException("openGraphAction must have non-null 'type' property");
        }
        return newPostRequest(session, String.format("me/%s", openGraphAction.getType()), openGraphAction, callback);
    }
    
    public static Request newPostOpenGraphObjectRequest(final Session session, final OpenGraphObject openGraphObject, final Callback callback) {
        if (openGraphObject == null) {
            throw new FacebookException("openGraphObject cannot be null");
        }
        if (Utility.isNullOrEmpty(openGraphObject.getType())) {
            throw new FacebookException("openGraphObject must have non-null 'type' property");
        }
        if (Utility.isNullOrEmpty(openGraphObject.getTitle())) {
            throw new FacebookException("openGraphObject must have non-null 'title' property");
        }
        final String format = String.format("me/objects/%s", openGraphObject.getType());
        final Bundle bundle = new Bundle();
        bundle.putString("object", openGraphObject.getInnerJSONObject().toString());
        return new Request(session, format, bundle, HttpMethod.POST, callback);
    }
    
    public static Request newPostOpenGraphObjectRequest(final Session session, final String s, final String s2, final String s3, final String s4, final String s5, final GraphObject data, final Callback callback) {
        final OpenGraphObject forPost = OpenGraphObject.Factory.createForPost(OpenGraphObject.class, s, s2, s3, s4, s5);
        if (data != null) {
            forPost.setData(data);
        }
        return newPostOpenGraphObjectRequest(session, forPost, callback);
    }
    
    public static Request newPostRequest(final Session session, final String s, final GraphObject graphObject, final Callback callback) {
        final Request request = new Request(session, s, null, HttpMethod.POST, callback);
        request.setGraphObject(graphObject);
        return request;
    }
    
    public static Request newRestRequest(final Session session, final String restMethod, final Bundle bundle, final HttpMethod httpMethod) {
        final Request request = new Request(session, null, bundle, httpMethod);
        request.setRestMethod(restMethod);
        return request;
    }
    
    public static Request newStatusUpdateRequest(final Session session, final String s, final Callback callback) {
        return newStatusUpdateRequest(session, s, null, (List<String>)null, callback);
    }
    
    public static Request newStatusUpdateRequest(final Session session, final String s, final GraphPlace graphPlace, final List<GraphUser> list, final Callback callback) {
        List<String> list2 = null;
        if (list != null) {
            list2 = new ArrayList<String>(list.size());
            final Iterator<GraphUser> iterator = list.iterator();
            while (iterator.hasNext()) {
                list2.add(iterator.next().getId());
            }
        }
        String id;
        if (graphPlace == null) {
            id = null;
        }
        else {
            id = graphPlace.getId();
        }
        return newStatusUpdateRequest(session, s, id, list2, callback);
    }
    
    private static Request newStatusUpdateRequest(final Session session, final String s, final String s2, final List<String> list, final Callback callback) {
        final Bundle bundle = new Bundle();
        bundle.putString("message", s);
        if (s2 != null) {
            bundle.putString("place", s2);
        }
        if (list != null && list.size() > 0) {
            bundle.putString("tags", TextUtils.join((CharSequence)",", (Iterable)list));
        }
        return new Request(session, "me/feed", bundle, HttpMethod.POST, callback);
    }
    
    public static Request newUpdateOpenGraphObjectRequest(final Session session, final OpenGraphObject openGraphObject, final Callback callback) {
        if (openGraphObject == null) {
            throw new FacebookException("openGraphObject cannot be null");
        }
        final String id = openGraphObject.getId();
        if (id == null) {
            throw new FacebookException("openGraphObject must have an id");
        }
        final Bundle bundle = new Bundle();
        bundle.putString("object", openGraphObject.getInnerJSONObject().toString());
        return new Request(session, id, bundle, HttpMethod.POST, callback);
    }
    
    public static Request newUpdateOpenGraphObjectRequest(final Session session, final String id, final String s, final String s2, final String s3, final String s4, final GraphObject data, final Callback callback) {
        final OpenGraphObject forPost = OpenGraphObject.Factory.createForPost(OpenGraphObject.class, null, s, s2, s3, s4);
        forPost.setId(id);
        forPost.setData(data);
        return newUpdateOpenGraphObjectRequest(session, forPost, callback);
    }
    
    public static Request newUploadPhotoRequest(final Session session, final Bitmap bitmap, final Callback callback) {
        final Bundle bundle = new Bundle(1);
        bundle.putParcelable("picture", (Parcelable)bitmap);
        return new Request(session, "me/photos", bundle, HttpMethod.POST, callback);
    }
    
    public static Request newUploadPhotoRequest(final Session session, final File file, final Callback callback) throws FileNotFoundException {
        final ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
        final Bundle bundle = new Bundle(1);
        bundle.putParcelable("picture", (Parcelable)open);
        return new Request(session, "me/photos", bundle, HttpMethod.POST, callback);
    }
    
    public static Request newUploadStagingResourceWithImageRequest(final Session session, final Bitmap bitmap, final Callback callback) {
        final Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", (Parcelable)bitmap);
        return new Request(session, "me/staging_resources", bundle, HttpMethod.POST, callback);
    }
    
    public static Request newUploadStagingResourceWithImageRequest(final Session session, final File file, final Callback callback) throws FileNotFoundException {
        final ParcelFileDescriptorWithMimeType parcelFileDescriptorWithMimeType = new ParcelFileDescriptorWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
        final Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", (Parcelable)parcelFileDescriptorWithMimeType);
        return new Request(session, "me/staging_resources", bundle, HttpMethod.POST, callback);
    }
    
    public static Request newUploadVideoRequest(final Session session, final File file, final Callback callback) throws FileNotFoundException {
        final ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
        final Bundle bundle = new Bundle(1);
        bundle.putParcelable(file.getName(), (Parcelable)open);
        return new Request(session, "me/videos", bundle, HttpMethod.POST, callback);
    }
    
    private static String parameterToString(final Object obj) {
        if (obj instanceof String) {
            return (String)obj;
        }
        if (obj instanceof Boolean || obj instanceof Number) {
            return obj.toString();
        }
        if (obj instanceof Date) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(obj);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }
    
    private static void processGraphObject(final GraphObject graphObject, final String s, final KeyValueSerializer keyValueSerializer) throws IOException {
        boolean b = false;
        Label_0064: {
            if (!s.startsWith("me/")) {
                final boolean startsWith = s.startsWith("/me/");
                b = false;
                if (!startsWith) {
                    break Label_0064;
                }
            }
            final int index = s.indexOf(":");
            final int index2 = s.indexOf("?");
            b = (index > 3 && (index2 == -1 || index < index2));
        }
        for (final Map.Entry<String, Object> entry : graphObject.asMap().entrySet()) {
            processGraphObjectProperty(entry.getKey(), entry.getValue(), keyValueSerializer, b && entry.getKey().equalsIgnoreCase("image"));
        }
    }
    
    private static void processGraphObjectProperty(final String s, Object o, final KeyValueSerializer keyValueSerializer, final boolean b) throws IOException {
        Class<?> clazz = o.getClass();
        if (GraphObject.class.isAssignableFrom(clazz)) {
            o = ((GraphObject)o).getInnerJSONObject();
            clazz = o.getClass();
        }
        else if (GraphObjectList.class.isAssignableFrom(clazz)) {
            o = ((GraphObjectList)o).getInnerJSONArray();
            clazz = o.getClass();
        }
        if (JSONObject.class.isAssignableFrom(clazz)) {
            final JSONObject jsonObject = (JSONObject)o;
            if (b) {
                final Iterator keys = jsonObject.keys();
                while (keys.hasNext()) {
                    final String s2 = keys.next();
                    processGraphObjectProperty(String.format("%s[%s]", s, s2), jsonObject.opt(s2), keyValueSerializer, b);
                }
            }
            else {
                if (jsonObject.has("id")) {
                    processGraphObjectProperty(s, jsonObject.optString("id"), keyValueSerializer, b);
                    return;
                }
                if (jsonObject.has("url")) {
                    processGraphObjectProperty(s, jsonObject.optString("url"), keyValueSerializer, b);
                }
            }
        }
        else if (JSONArray.class.isAssignableFrom(clazz)) {
            final JSONArray jsonArray = (JSONArray)o;
            for (int length = jsonArray.length(), i = 0; i < length; ++i) {
                processGraphObjectProperty(String.format("%s[%d]", s, i), jsonArray.opt(i), keyValueSerializer, b);
            }
        }
        else {
            if (String.class.isAssignableFrom(clazz) || Number.class.isAssignableFrom(clazz) || Boolean.class.isAssignableFrom(clazz)) {
                keyValueSerializer.writeString(s, o.toString());
                return;
            }
            if (Date.class.isAssignableFrom(clazz)) {
                keyValueSerializer.writeString(s, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date)o));
            }
        }
    }
    
    private static void processRequest(final RequestBatch requestBatch, final Logger logger, final int n, final URL url, final OutputStream outputStream) throws IOException, JSONException {
        final Serializer serializer = new Serializer(outputStream, logger);
        if (n == 1) {
            final Request value = requestBatch.get(0);
            final HashMap<String, Attachment> hashMap = new HashMap<String, Attachment>();
            for (final String s : value.parameters.keySet()) {
                final Object value2 = value.parameters.get(s);
                if (isSupportedAttachmentType(value2)) {
                    hashMap.put(s, new Attachment(value, value2));
                }
            }
            if (logger != null) {
                logger.append("  Parameters:\n");
            }
            serializeParameters(value.parameters, serializer, value);
            if (logger != null) {
                logger.append("  Attachments:\n");
            }
            serializeAttachments(hashMap, serializer);
            if (value.graphObject != null) {
                processGraphObject(value.graphObject, url.getPath(), (KeyValueSerializer)serializer);
            }
            return;
        }
        final String batchAppId = getBatchAppId(requestBatch);
        if (Utility.isNullOrEmpty(batchAppId)) {
            throw new FacebookException("At least one request in a batch must have an open Session, or a default app ID must be specified.");
        }
        serializer.writeString("batch_app_id", batchAppId);
        final HashMap<String, Attachment> hashMap2 = new HashMap<String, Attachment>();
        serializeRequestsAsJSON(serializer, requestBatch, hashMap2);
        if (logger != null) {
            logger.append("  Attachments:\n");
        }
        serializeAttachments(hashMap2, serializer);
    }
    
    static void runCallbacks(final RequestBatch requestBatch, final List<Response> list) {
        final int size = requestBatch.size();
        final ArrayList<Pair> list2 = new ArrayList<Pair>();
        for (int i = 0; i < size; ++i) {
            final Request value = requestBatch.get(i);
            if (value.callback != null) {
                list2.add(new Pair((Object)value.callback, (Object)list.get(i)));
            }
        }
        if (list2.size() > 0) {
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for (final Pair pair : list2) {
                        ((Callback)pair.first).onCompleted((Response)pair.second);
                    }
                    final Iterator<RequestBatch.Callback> iterator2 = requestBatch.getCallbacks().iterator();
                    while (iterator2.hasNext()) {
                        ((RequestBatch.Callback)iterator2.next()).onBatchCompleted(requestBatch);
                    }
                }
            };
            final Handler callbackHandler = requestBatch.getCallbackHandler();
            if (callbackHandler != null) {
                callbackHandler.post((Runnable)runnable);
                return;
            }
            runnable.run();
        }
    }
    
    private static void serializeAttachments(final Map<String, Attachment> map, final Serializer serializer) throws IOException {
        for (final String s : map.keySet()) {
            final Attachment attachment = map.get(s);
            if (isSupportedAttachmentType(attachment.getValue())) {
                serializer.writeObject(s, attachment.getValue(), attachment.getRequest());
            }
        }
    }
    
    private static void serializeParameters(final Bundle bundle, final Serializer serializer, final Request request) throws IOException {
        for (final String s : bundle.keySet()) {
            final Object value = bundle.get(s);
            if (isSupportedParameterType(value)) {
                serializer.writeObject(s, value, request);
            }
        }
    }
    
    private static void serializeRequestsAsJSON(final Serializer serializer, final Collection<Request> collection, final Map<String, Attachment> map) throws JSONException, IOException {
        final JSONArray jsonArray = new JSONArray();
        final Iterator<Request> iterator = collection.iterator();
        while (iterator.hasNext()) {
            iterator.next().serializeToBatch(jsonArray, map);
        }
        serializer.writeRequestsAsJson("batch", jsonArray, collection);
    }
    
    private void serializeToBatch(final JSONArray jsonArray, final Map<String, Attachment> map) throws JSONException, IOException {
        final JSONObject jsonObject = new JSONObject();
        if (this.batchEntryName != null) {
            jsonObject.put("name", (Object)this.batchEntryName);
            jsonObject.put("omit_response_on_success", this.batchEntryOmitResultOnSuccess);
        }
        if (this.batchEntryDependsOn != null) {
            jsonObject.put("depends_on", (Object)this.batchEntryDependsOn);
        }
        final String urlForBatchedRequest = this.getUrlForBatchedRequest();
        jsonObject.put("relative_url", (Object)urlForBatchedRequest);
        jsonObject.put("method", (Object)this.httpMethod);
        if (this.session != null) {
            Logger.registerAccessToken(this.session.getAccessToken());
        }
        final ArrayList<String> list = new ArrayList<String>();
        final Iterator<String> iterator = this.parameters.keySet().iterator();
        while (iterator.hasNext()) {
            final Object value = this.parameters.get((String)iterator.next());
            if (isSupportedAttachmentType(value)) {
                final String format = String.format("%s%d", "file", map.size());
                list.add(format);
                map.put(format, new Attachment(this, value));
            }
        }
        if (!list.isEmpty()) {
            jsonObject.put("attached_files", (Object)TextUtils.join((CharSequence)",", (Iterable)list));
        }
        if (this.graphObject != null) {
            final ArrayList list2 = new ArrayList();
            processGraphObject(this.graphObject, urlForBatchedRequest, (KeyValueSerializer)new KeyValueSerializer() {
                @Override
                public void writeString(final String s, final String s2) throws IOException {
                    list2.add(String.format("%s=%s", s, URLEncoder.encode(s2, "UTF-8")));
                }
            });
            jsonObject.put("body", (Object)TextUtils.join((CharSequence)"&", (Iterable)list2));
        }
        jsonArray.put((Object)jsonObject);
    }
    
    static final void serializeToUrlConnection(final RequestBatch p0, final HttpURLConnection p1) throws IOException, JSONException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Lcom/facebook/internal/Logger;
        //     3: dup            
        //     4: getstatic       com/facebook/LoggingBehavior.REQUESTS:Lcom/facebook/LoggingBehavior;
        //     7: ldc_w           "Request"
        //    10: invokespecial   com/facebook/internal/Logger.<init>:(Lcom/facebook/LoggingBehavior;Ljava/lang/String;)V
        //    13: astore_2       
        //    14: aload_0        
        //    15: invokevirtual   com/facebook/RequestBatch.size:()I
        //    18: istore_3       
        //    19: iload_3        
        //    20: iconst_1       
        //    21: if_icmpne       155
        //    24: aload_0        
        //    25: iconst_0       
        //    26: invokevirtual   com/facebook/RequestBatch.get:(I)Lcom/facebook/Request;
        //    29: getfield        com/facebook/Request.httpMethod:Lcom/facebook/HttpMethod;
        //    32: astore          4
        //    34: aload_1        
        //    35: aload           4
        //    37: invokevirtual   com/facebook/HttpMethod.name:()Ljava/lang/String;
        //    40: invokevirtual   java/net/HttpURLConnection.setRequestMethod:(Ljava/lang/String;)V
        //    43: aload_1        
        //    44: invokevirtual   java/net/HttpURLConnection.getURL:()Ljava/net/URL;
        //    47: astore          5
        //    49: aload_2        
        //    50: ldc_w           "Request:\n"
        //    53: invokevirtual   com/facebook/internal/Logger.append:(Ljava/lang/String;)V
        //    56: aload_2        
        //    57: ldc_w           "Id"
        //    60: aload_0        
        //    61: invokevirtual   com/facebook/RequestBatch.getId:()Ljava/lang/String;
        //    64: invokevirtual   com/facebook/internal/Logger.appendKeyValue:(Ljava/lang/String;Ljava/lang/Object;)V
        //    67: aload_2        
        //    68: ldc_w           "URL"
        //    71: aload           5
        //    73: invokevirtual   com/facebook/internal/Logger.appendKeyValue:(Ljava/lang/String;Ljava/lang/Object;)V
        //    76: aload_2        
        //    77: ldc_w           "Method"
        //    80: aload_1        
        //    81: invokevirtual   java/net/HttpURLConnection.getRequestMethod:()Ljava/lang/String;
        //    84: invokevirtual   com/facebook/internal/Logger.appendKeyValue:(Ljava/lang/String;Ljava/lang/Object;)V
        //    87: aload_2        
        //    88: ldc             "User-Agent"
        //    90: aload_1        
        //    91: ldc             "User-Agent"
        //    93: invokevirtual   java/net/HttpURLConnection.getRequestProperty:(Ljava/lang/String;)Ljava/lang/String;
        //    96: invokevirtual   com/facebook/internal/Logger.appendKeyValue:(Ljava/lang/String;Ljava/lang/Object;)V
        //    99: aload_2        
        //   100: ldc             "Content-Type"
        //   102: aload_1        
        //   103: ldc             "Content-Type"
        //   105: invokevirtual   java/net/HttpURLConnection.getRequestProperty:(Ljava/lang/String;)Ljava/lang/String;
        //   108: invokevirtual   com/facebook/internal/Logger.appendKeyValue:(Ljava/lang/String;Ljava/lang/Object;)V
        //   111: aload_1        
        //   112: aload_0        
        //   113: invokevirtual   com/facebook/RequestBatch.getTimeout:()I
        //   116: invokevirtual   java/net/HttpURLConnection.setConnectTimeout:(I)V
        //   119: aload_1        
        //   120: aload_0        
        //   121: invokevirtual   com/facebook/RequestBatch.getTimeout:()I
        //   124: invokevirtual   java/net/HttpURLConnection.setReadTimeout:(I)V
        //   127: getstatic       com/facebook/HttpMethod.POST:Lcom/facebook/HttpMethod;
        //   130: astore          6
        //   132: iconst_0       
        //   133: istore          7
        //   135: aload           4
        //   137: aload           6
        //   139: if_acmpne       145
        //   142: iconst_1       
        //   143: istore          7
        //   145: iload           7
        //   147: ifne            163
        //   150: aload_2        
        //   151: invokevirtual   com/facebook/internal/Logger.log:()V
        //   154: return         
        //   155: getstatic       com/facebook/HttpMethod.POST:Lcom/facebook/HttpMethod;
        //   158: astore          4
        //   160: goto            34
        //   163: aload_1        
        //   164: iconst_1       
        //   165: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //   168: aload_0        
        //   169: invokestatic    com/facebook/Request.hasOnProgressCallbacks:(Lcom/facebook/RequestBatch;)Z
        //   172: ifeq            258
        //   175: new             Lcom/facebook/ProgressNoopOutputStream;
        //   178: dup            
        //   179: aload_0        
        //   180: invokevirtual   com/facebook/RequestBatch.getCallbackHandler:()Landroid/os/Handler;
        //   183: invokespecial   com/facebook/ProgressNoopOutputStream.<init>:(Landroid/os/Handler;)V
        //   186: astore          10
        //   188: aload_0        
        //   189: aconst_null    
        //   190: iload_3        
        //   191: aload           5
        //   193: aload           10
        //   195: invokestatic    com/facebook/Request.processRequest:(Lcom/facebook/RequestBatch;Lcom/facebook/internal/Logger;ILjava/net/URL;Ljava/io/OutputStream;)V
        //   198: aload           10
        //   200: invokevirtual   com/facebook/ProgressNoopOutputStream.getMaxProgress:()I
        //   203: istore          11
        //   205: aload           10
        //   207: invokevirtual   com/facebook/ProgressNoopOutputStream.getProgressMap:()Ljava/util/Map;
        //   210: astore          12
        //   212: new             Lcom/facebook/ProgressOutputStream;
        //   215: dup            
        //   216: new             Ljava/io/BufferedOutputStream;
        //   219: dup            
        //   220: aload_1        
        //   221: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //   224: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
        //   227: aload_0        
        //   228: aload           12
        //   230: iload           11
        //   232: i2l            
        //   233: invokespecial   com/facebook/ProgressOutputStream.<init>:(Ljava/io/OutputStream;Lcom/facebook/RequestBatch;Ljava/util/Map;J)V
        //   236: astore          9
        //   238: aload_0        
        //   239: aload_2        
        //   240: iload_3        
        //   241: aload           5
        //   243: aload           9
        //   245: invokestatic    com/facebook/Request.processRequest:(Lcom/facebook/RequestBatch;Lcom/facebook/internal/Logger;ILjava/net/URL;Ljava/io/OutputStream;)V
        //   248: aload           9
        //   250: invokevirtual   java/io/OutputStream.close:()V
        //   253: aload_2        
        //   254: invokevirtual   com/facebook/internal/Logger.log:()V
        //   257: return         
        //   258: new             Ljava/io/BufferedOutputStream;
        //   261: dup            
        //   262: aload_1        
        //   263: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //   266: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
        //   269: astore          9
        //   271: goto            238
        //   274: astore          8
        //   276: aconst_null    
        //   277: astore          9
        //   279: aload           9
        //   281: invokevirtual   java/io/OutputStream.close:()V
        //   284: aload           8
        //   286: athrow         
        //   287: astore          8
        //   289: goto            279
        //    Exceptions:
        //  throws java.io.IOException
        //  throws org.json.JSONException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  168    238    274    279    Any
        //  238    248    287    292    Any
        //  258    271    274    279    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0238:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static final void setDefaultBatchApplicationId(final String defaultBatchApplicationId) {
        Request.defaultBatchApplicationId = defaultBatchApplicationId;
    }
    
    public static HttpURLConnection toHttpConnection(final RequestBatch p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: invokevirtual   com/facebook/RequestBatch.iterator:()Ljava/util/Iterator;
        //     4: astore_1       
        //     5: aload_1        
        //     6: invokeinterface java/util/Iterator.hasNext:()Z
        //    11: ifne            53
        //    14: aload_0        
        //    15: invokevirtual   com/facebook/RequestBatch.size:()I
        //    18: iconst_1       
        //    19: if_icmpne       68
        //    22: new             Ljava/net/URL;
        //    25: dup            
        //    26: aload_0        
        //    27: iconst_0       
        //    28: invokevirtual   com/facebook/RequestBatch.get:(I)Lcom/facebook/Request;
        //    31: invokevirtual   com/facebook/Request.getUrlForSingleRequest:()Ljava/lang/String;
        //    34: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    37: astore_3       
        //    38: aload_3        
        //    39: invokestatic    com/facebook/Request.createConnection:(Ljava/net/URL;)Ljava/net/HttpURLConnection;
        //    42: astore          6
        //    44: aload_0        
        //    45: aload           6
        //    47: invokestatic    com/facebook/Request.serializeToUrlConnection:(Lcom/facebook/RequestBatch;Ljava/net/HttpURLConnection;)V
        //    50: aload           6
        //    52: areturn        
        //    53: aload_1        
        //    54: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    59: checkcast       Lcom/facebook/Request;
        //    62: invokespecial   com/facebook/Request.validate:()V
        //    65: goto            5
        //    68: new             Ljava/net/URL;
        //    71: dup            
        //    72: invokestatic    com/facebook/internal/ServerProtocol.getGraphUrlBase:()Ljava/lang/String;
        //    75: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    78: astore_3       
        //    79: goto            38
        //    82: astore_2       
        //    83: new             Lcom/facebook/FacebookException;
        //    86: dup            
        //    87: ldc_w           "could not construct URL for request"
        //    90: aload_2        
        //    91: invokespecial   com/facebook/FacebookException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //    94: athrow         
        //    95: astore          5
        //    97: new             Lcom/facebook/FacebookException;
        //   100: dup            
        //   101: ldc_w           "could not construct request body"
        //   104: aload           5
        //   106: invokespecial   com/facebook/FacebookException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   109: athrow         
        //   110: astore          4
        //   112: new             Lcom/facebook/FacebookException;
        //   115: dup            
        //   116: ldc_w           "could not construct request body"
        //   119: aload           4
        //   121: invokespecial   com/facebook/FacebookException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   124: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  14     38     82     95     Ljava/net/MalformedURLException;
        //  38     50     95     110    Ljava/io/IOException;
        //  38     50     110    125    Lorg/json/JSONException;
        //  68     79     82     95     Ljava/net/MalformedURLException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0038:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static HttpURLConnection toHttpConnection(final Collection<Request> collection) {
        Validate.notEmptyAndContainsNoNulls((Collection<Object>)collection, "requests");
        return toHttpConnection(new RequestBatch(collection));
    }
    
    public static HttpURLConnection toHttpConnection(final Request... a) {
        return toHttpConnection(Arrays.asList(a));
    }
    
    private static <T extends GraphObject> List<T> typedListFromResponse(final Response response, final Class<T> clazz) {
        final GraphMultiResult graphMultiResult = response.getGraphObjectAs(GraphMultiResult.class);
        if (graphMultiResult != null) {
            final GraphObjectList<GraphObject> data = graphMultiResult.getData();
            if (data != null) {
                return data.castToListOf(clazz);
            }
        }
        return null;
    }
    
    private void validate() {
        if (this.graphPath != null && this.restMethod != null) {
            throw new IllegalArgumentException("Only one of a graph path or REST method may be specified per request.");
        }
    }
    
    public final Response executeAndWait() {
        return executeAndWait(this);
    }
    
    public final RequestAsyncTask executeAsync() {
        return executeBatchAsync(this);
    }
    
    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }
    
    public final String getBatchEntryName() {
        return this.batchEntryName;
    }
    
    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }
    
    public final Callback getCallback() {
        return this.callback;
    }
    
    public final GraphObject getGraphObject() {
        return this.graphObject;
    }
    
    public final String getGraphPath() {
        return this.graphPath;
    }
    
    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }
    
    public final Bundle getParameters() {
        return this.parameters;
    }
    
    public final String getRestMethod() {
        return this.restMethod;
    }
    
    public final Session getSession() {
        return this.session;
    }
    
    public final Object getTag() {
        return this.tag;
    }
    
    final String getUrlForBatchedRequest() {
        if (this.overriddenURL != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        String s;
        if (this.restMethod != null) {
            s = this.getRestPathWithVersion();
        }
        else {
            s = this.getGraphPathWithVersion();
        }
        this.addCommonParameters();
        return this.appendParametersToBaseUrl(s);
    }
    
    final String getUrlForSingleRequest() {
        if (this.overriddenURL != null) {
            return this.overriddenURL.toString();
        }
        String s;
        if (this.restMethod != null) {
            s = String.format("%s/%s", ServerProtocol.getRestUrlBase(), this.getRestPathWithVersion());
        }
        else {
            String s2;
            if (this.getHttpMethod() == HttpMethod.POST && this.graphPath != null && this.graphPath.endsWith("/videos")) {
                s2 = ServerProtocol.getGraphVideoUrlBase();
            }
            else {
                s2 = ServerProtocol.getGraphUrlBase();
            }
            s = String.format("%s/%s", s2, this.getGraphPathWithVersion());
        }
        this.addCommonParameters();
        return this.appendParametersToBaseUrl(s);
    }
    
    public final String getVersion() {
        return this.version;
    }
    
    public final void setBatchEntryDependsOn(final String batchEntryDependsOn) {
        this.batchEntryDependsOn = batchEntryDependsOn;
    }
    
    public final void setBatchEntryName(final String batchEntryName) {
        this.batchEntryName = batchEntryName;
    }
    
    public final void setBatchEntryOmitResultOnSuccess(final boolean batchEntryOmitResultOnSuccess) {
        this.batchEntryOmitResultOnSuccess = batchEntryOmitResultOnSuccess;
    }
    
    public final void setCallback(final Callback callback) {
        this.callback = callback;
    }
    
    public final void setGraphObject(final GraphObject graphObject) {
        this.graphObject = graphObject;
    }
    
    public final void setGraphPath(final String graphPath) {
        this.graphPath = graphPath;
    }
    
    public final void setHttpMethod(HttpMethod get) {
        if (this.overriddenURL != null && get != HttpMethod.GET) {
            throw new FacebookException("Can't change HTTP method on request with overridden URL.");
        }
        if (get == null) {
            get = HttpMethod.GET;
        }
        this.httpMethod = get;
    }
    
    public final void setParameters(final Bundle parameters) {
        this.parameters = parameters;
    }
    
    public final void setRestMethod(final String restMethod) {
        this.restMethod = restMethod;
    }
    
    public final void setSession(final Session session) {
        this.session = session;
    }
    
    public final void setTag(final Object tag) {
        this.tag = tag;
    }
    
    public final void setVersion(final String version) {
        this.version = version;
    }
    
    @Override
    public String toString() {
        return "{Request: " + " session: " + this.session + ", graphPath: " + this.graphPath + ", graphObject: " + this.graphObject + ", restMethod: " + this.restMethod + ", httpMethod: " + this.httpMethod + ", parameters: " + this.parameters + "}";
    }
    
    private static class Attachment
    {
        private final Request request;
        private final Object value;
        
        public Attachment(final Request request, final Object value) {
            this.request = request;
            this.value = value;
        }
        
        public Request getRequest() {
            return this.request;
        }
        
        public Object getValue() {
            return this.value;
        }
    }
    
    public interface Callback
    {
        void onCompleted(Response p0);
    }
    
    public interface GraphPlaceListCallback
    {
        void onCompleted(List<GraphPlace> p0, Response p1);
    }
    
    public interface GraphUserCallback
    {
        void onCompleted(GraphUser p0, Response p1);
    }
    
    public interface GraphUserListCallback
    {
        void onCompleted(List<GraphUser> p0, Response p1);
    }
    
    private interface KeyValueSerializer
    {
        void writeString(String p0, String p1) throws IOException;
    }
    
    public interface OnProgressCallback extends Callback
    {
        void onProgress(long p0, long p1);
    }
    
    private static class ParcelFileDescriptorWithMimeType implements Parcelable
    {
        public static final Parcelable$Creator<ParcelFileDescriptorWithMimeType> CREATOR;
        private final ParcelFileDescriptor fileDescriptor;
        private final String mimeType;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<ParcelFileDescriptorWithMimeType>() {
                public ParcelFileDescriptorWithMimeType createFromParcel(final Parcel parcel) {
                    return new ParcelFileDescriptorWithMimeType(parcel, null);
                }
                
                public ParcelFileDescriptorWithMimeType[] newArray(final int n) {
                    return new ParcelFileDescriptorWithMimeType[n];
                }
            };
        }
        
        private ParcelFileDescriptorWithMimeType(final Parcel parcel) {
            this.mimeType = parcel.readString();
            this.fileDescriptor = parcel.readFileDescriptor();
        }
        
        public ParcelFileDescriptorWithMimeType(final ParcelFileDescriptor fileDescriptor, final String mimeType) {
            this.mimeType = mimeType;
            this.fileDescriptor = fileDescriptor;
        }
        
        public int describeContents() {
            return 1;
        }
        
        public ParcelFileDescriptor getFileDescriptor() {
            return this.fileDescriptor;
        }
        
        public String getMimeType() {
            return this.mimeType;
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeString(this.mimeType);
            parcel.writeFileDescriptor(this.fileDescriptor.getFileDescriptor());
        }
    }
    
    private static class Serializer implements KeyValueSerializer
    {
        private boolean firstWrite;
        private final Logger logger;
        private final OutputStream outputStream;
        
        public Serializer(final OutputStream outputStream, final Logger logger) {
            this.firstWrite = true;
            this.outputStream = outputStream;
            this.logger = logger;
        }
        
        public void write(final String format, final Object... args) throws IOException {
            if (this.firstWrite) {
                this.outputStream.write("--".getBytes());
                this.outputStream.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
                this.outputStream.write("\r\n".getBytes());
                this.firstWrite = false;
            }
            this.outputStream.write(String.format(format, args).getBytes());
        }
        
        public void writeBitmap(final String str, final Bitmap bitmap) throws IOException {
            this.writeContentDisposition(str, str, "image/png");
            bitmap.compress(Bitmap$CompressFormat.PNG, 100, this.outputStream);
            this.writeLine("", new Object[0]);
            this.writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    " + str, "<Image>");
            }
        }
        
        public void writeBytes(final String str, final byte[] b) throws IOException {
            this.writeContentDisposition(str, str, "content/unknown");
            this.outputStream.write(b);
            this.writeLine("", new Object[0]);
            this.writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    " + str, String.format("<Data: %d>", b.length));
            }
        }
        
        public void writeContentDisposition(final String s, final String s2, final String s3) throws IOException {
            this.write("Content-Disposition: form-data; name=\"%s\"", s);
            if (s2 != null) {
                this.write("; filename=\"%s\"", s2);
            }
            this.writeLine("", new Object[0]);
            if (s3 != null) {
                this.writeLine("%s: %s", "Content-Type", s3);
            }
            this.writeLine("", new Object[0]);
        }
        
        public void writeFile(final String p0, final ParcelFileDescriptor p1, final String p2) throws IOException {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     0: aload_3        
            //     1: ifnonnull       7
            //     4: ldc             "content/unknown"
            //     6: astore_3       
            //     7: aload_0        
            //     8: aload_1        
            //     9: aload_1        
            //    10: aload_3        
            //    11: invokevirtual   com/facebook/Request$Serializer.writeContentDisposition:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
            //    14: iconst_0       
            //    15: istore          4
            //    17: aload_0        
            //    18: getfield        com/facebook/Request$Serializer.outputStream:Ljava/io/OutputStream;
            //    21: instanceof      Lcom/facebook/ProgressNoopOutputStream;
            //    24: ifeq            116
            //    27: aload_0        
            //    28: getfield        com/facebook/Request$Serializer.outputStream:Ljava/io/OutputStream;
            //    31: checkcast       Lcom/facebook/ProgressNoopOutputStream;
            //    34: aload_2        
            //    35: invokevirtual   android/os/ParcelFileDescriptor.getStatSize:()J
            //    38: invokevirtual   com/facebook/ProgressNoopOutputStream.addProgress:(J)V
            //    41: aload_0        
            //    42: ldc             ""
            //    44: iconst_0       
            //    45: anewarray       Ljava/lang/Object;
            //    48: invokevirtual   com/facebook/Request$Serializer.writeLine:(Ljava/lang/String;[Ljava/lang/Object;)V
            //    51: aload_0        
            //    52: invokevirtual   com/facebook/Request$Serializer.writeRecordBoundary:()V
            //    55: aload_0        
            //    56: getfield        com/facebook/Request$Serializer.logger:Lcom/facebook/internal/Logger;
            //    59: ifnull          115
            //    62: aload_0        
            //    63: getfield        com/facebook/Request$Serializer.logger:Lcom/facebook/internal/Logger;
            //    66: astore          12
            //    68: new             Ljava/lang/StringBuilder;
            //    71: dup            
            //    72: ldc             "    "
            //    74: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
            //    77: aload_1        
            //    78: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    81: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //    84: astore          13
            //    86: iconst_1       
            //    87: anewarray       Ljava/lang/Object;
            //    90: astore          14
            //    92: aload           14
            //    94: iconst_0       
            //    95: iload           4
            //    97: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
            //   100: aastore        
            //   101: aload           12
            //   103: aload           13
            //   105: ldc             "<Data: %d>"
            //   107: aload           14
            //   109: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
            //   112: invokevirtual   com/facebook/internal/Logger.appendKeyValue:(Ljava/lang/String;Ljava/lang/Object;)V
            //   115: return         
            //   116: aconst_null    
            //   117: astore          5
            //   119: aconst_null    
            //   120: astore          6
            //   122: new             Landroid/os/ParcelFileDescriptor$AutoCloseInputStream;
            //   125: dup            
            //   126: aload_2        
            //   127: invokespecial   android/os/ParcelFileDescriptor$AutoCloseInputStream.<init>:(Landroid/os/ParcelFileDescriptor;)V
            //   130: astore          7
            //   132: new             Ljava/io/BufferedInputStream;
            //   135: dup            
            //   136: aload           7
            //   138: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
            //   141: astore          8
            //   143: sipush          8192
            //   146: newarray        B
            //   148: astore          10
            //   150: aload           8
            //   152: aload           10
            //   154: invokevirtual   java/io/BufferedInputStream.read:([B)I
            //   157: istore          11
            //   159: iload           11
            //   161: iconst_m1      
            //   162: if_icmpne       188
            //   165: aload           8
            //   167: ifnull          175
            //   170: aload           8
            //   172: invokevirtual   java/io/BufferedInputStream.close:()V
            //   175: aload           7
            //   177: ifnull          41
            //   180: aload           7
            //   182: invokevirtual   android/os/ParcelFileDescriptor$AutoCloseInputStream.close:()V
            //   185: goto            41
            //   188: aload_0        
            //   189: getfield        com/facebook/Request$Serializer.outputStream:Ljava/io/OutputStream;
            //   192: aload           10
            //   194: iconst_0       
            //   195: iload           11
            //   197: invokevirtual   java/io/OutputStream.write:([BII)V
            //   200: iload           4
            //   202: iload           11
            //   204: iadd           
            //   205: istore          4
            //   207: goto            150
            //   210: astore          9
            //   212: aload           6
            //   214: ifnull          222
            //   217: aload           6
            //   219: invokevirtual   java/io/BufferedInputStream.close:()V
            //   222: aload           5
            //   224: ifnull          232
            //   227: aload           5
            //   229: invokevirtual   android/os/ParcelFileDescriptor$AutoCloseInputStream.close:()V
            //   232: aload           9
            //   234: athrow         
            //   235: astore          9
            //   237: aload           7
            //   239: astore          5
            //   241: aconst_null    
            //   242: astore          6
            //   244: goto            212
            //   247: astore          9
            //   249: aload           8
            //   251: astore          6
            //   253: aload           7
            //   255: astore          5
            //   257: goto            212
            //    Exceptions:
            //  throws java.io.IOException
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type
            //  -----  -----  -----  -----  ----
            //  122    132    210    212    Any
            //  132    143    235    247    Any
            //  143    150    247    260    Any
            //  150    159    247    260    Any
            //  188    200    247    260    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IndexOutOfBoundsException: Index: 124, Size: 124
            //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
            //     at java.util.ArrayList.get(ArrayList.java:411)
            //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
            //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:114)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:556)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        public void writeFile(final String s, final ParcelFileDescriptorWithMimeType parcelFileDescriptorWithMimeType) throws IOException {
            this.writeFile(s, parcelFileDescriptorWithMimeType.getFileDescriptor(), parcelFileDescriptorWithMimeType.getMimeType());
        }
        
        public void writeLine(final String s, final Object... array) throws IOException {
            this.write(s, array);
            this.write("\r\n", new Object[0]);
        }
        
        public void writeObject(final String s, final Object o, final Request currentRequest) throws IOException {
            if (this.outputStream instanceof RequestOutputStream) {
                ((RequestOutputStream)this.outputStream).setCurrentRequest(currentRequest);
            }
            if (isSupportedParameterType(o)) {
                this.writeString(s, parameterToString(o));
                return;
            }
            if (o instanceof Bitmap) {
                this.writeBitmap(s, (Bitmap)o);
                return;
            }
            if (o instanceof byte[]) {
                this.writeBytes(s, (byte[])o);
                return;
            }
            if (o instanceof ParcelFileDescriptor) {
                this.writeFile(s, (ParcelFileDescriptor)o, null);
                return;
            }
            if (o instanceof ParcelFileDescriptorWithMimeType) {
                this.writeFile(s, (ParcelFileDescriptorWithMimeType)o);
                return;
            }
            throw new IllegalArgumentException("value is not a supported type: String, Bitmap, byte[]");
        }
        
        public void writeRecordBoundary() throws IOException {
            this.writeLine("--%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
        }
        
        public void writeRequestsAsJson(final String str, final JSONArray jsonArray, final Collection<Request> collection) throws IOException, JSONException {
            if (!(this.outputStream instanceof RequestOutputStream)) {
                this.writeString(str, jsonArray.toString());
            }
            else {
                final RequestOutputStream requestOutputStream = (RequestOutputStream)this.outputStream;
                this.writeContentDisposition(str, null, null);
                this.write("[", new Object[0]);
                int n = 0;
                for (final Request currentRequest : collection) {
                    final JSONObject jsonObject = jsonArray.getJSONObject(n);
                    requestOutputStream.setCurrentRequest(currentRequest);
                    if (n > 0) {
                        this.write(",%s", jsonObject.toString());
                    }
                    else {
                        this.write("%s", jsonObject.toString());
                    }
                    ++n;
                }
                this.write("]", new Object[0]);
                if (this.logger != null) {
                    this.logger.appendKeyValue("    " + str, jsonArray.toString());
                }
            }
        }
        
        @Override
        public void writeString(final String str, final String s) throws IOException {
            this.writeContentDisposition(str, null, null);
            this.writeLine("%s", s);
            this.writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    " + str, s);
            }
        }
    }
}
