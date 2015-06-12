// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Map;
import java.net.URL;
import java.net.URI;
import java.util.HashMap;

abstract class WebRequest
{
    private static final String CHARSET_KEY = "charset";
    public static final String CHARSET_UTF_16 = "UTF-16";
    public static final String CHARSET_UTF_8 = "UTF-8";
    public static final String CONTENT_TYPE_CSS = "text/css";
    public static final String CONTENT_TYPE_HTML = "text/html";
    public static final String CONTENT_TYPE_JAVASCRIPT = "application/javascript";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_PLAIN_TEXT = "text/plain";
    public static final int DEFAULT_PORT = -1;
    public static final int DEFAULT_TIMEOUT = 20000;
    private static final String HEADER_ACCEPT_KEY = "Accept";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String LOG_TAG;
    private static WebRequest$WebRequestFactory webRequestFactory;
    String acceptContentType;
    String charset;
    String contentType;
    protected final HashMap headers;
    private WebRequest$HttpMethod httpMethod;
    boolean logRequestBodyEnabled;
    boolean logResponseEnabled;
    private String logTag;
    protected boolean logUrlEnabled;
    private MetricsCollector metricsCollector;
    private String nonSecureHost;
    private String path;
    private int port;
    protected HashMap postParameters;
    protected WebRequest$QueryStringParameters queryStringParameters;
    String requestBody;
    protected boolean secure;
    private String secureHost;
    protected Metrics$MetricType serviceCallLatencyMetric;
    private int timeout;
    private String urlString;
    
    static {
        LOG_TAG = WebRequest.class.getSimpleName();
        WebRequest.webRequestFactory = new WebRequest$WebRequestFactory();
    }
    
    protected WebRequest() {
        this.requestBody = null;
        this.acceptContentType = null;
        this.contentType = null;
        this.charset = null;
        this.urlString = null;
        this.secureHost = null;
        this.nonSecureHost = null;
        this.path = null;
        this.port = -1;
        this.httpMethod = WebRequest$HttpMethod.GET;
        this.timeout = 20000;
        this.logRequestBodyEnabled = false;
        this.logResponseEnabled = false;
        this.logUrlEnabled = false;
        this.secure = false;
        this.logTag = WebRequest.LOG_TAG;
        this.queryStringParameters = new WebRequest$QueryStringParameters();
        this.headers = new HashMap();
        this.postParameters = new HashMap();
        this.secure = DebugProperties.getDebugPropertyAsBoolean("debug.tlsEnabled", Settings.getInstance().getBoolean("tlsEnabled", false));
    }
    
    public static final WebRequest createJSONGetWebRequest() {
        final WebRequest newWebRequest = createNewWebRequest();
        newWebRequest.setHttpMethod(WebRequest$HttpMethod.GET);
        newWebRequest.putHeader("Accept", "application/json");
        return newWebRequest;
    }
    
    public static final WebRequest createJSONPostWebRequest() {
        final WebRequest newWebRequest = createNewWebRequest();
        newWebRequest.convertToJSONPostRequest();
        return newWebRequest;
    }
    
    public static final WebRequest createNewWebRequest() {
        return WebRequest.webRequestFactory.createWebRequest();
    }
    
    public static final void executeWebRequestInThread(final String s) {
        ThreadUtils.executeRunnable(new Runnable() {
            @Override
            public final void run() {
                final WebRequest newWebRequest = WebRequest.createNewWebRequest();
                newWebRequest.enableLog(true);
                newWebRequest.setUrlString(s);
                try {
                    newWebRequest.makeCall();
                }
                catch (WebRequest$WebRequestException ex) {}
            }
        });
    }
    
    static void setWebRequestFactory(final WebRequest$WebRequestFactory webRequestFactory) {
        WebRequest.webRequestFactory = webRequestFactory;
    }
    
    protected void appendQuery(final StringBuilder sb) {
        this.queryStringParameters.append(sb);
    }
    
    public void convertToJSONPostRequest() {
        this.setHttpMethod(WebRequest$HttpMethod.POST);
        this.putHeader("Accept", "application/json");
        this.putHeader("Content-Type", "application/json; charset=UTF-8");
    }
    
    protected URI createURI(final String s) {
        return this.createURI(this.createURL(s));
    }
    
    protected URI createURI(final URL url) {
        return url.toURI();
    }
    
    protected URL createURL(final String spec) {
        return new URL(spec);
    }
    
    protected URI createUri() {
        return new URL(this.getUrlString()).toURI();
    }
    
    protected abstract WebRequest$WebResponse doHttpNetworkCall(final URL p0);
    
    public void enableLog(final boolean b) {
        this.enableLogUrl(b);
        this.enableLogRequestBody(b);
        this.enableLogResponse(b);
    }
    
    public void enableLogRequestBody(final boolean logRequestBodyEnabled) {
        this.logRequestBodyEnabled = logRequestBodyEnabled;
    }
    
    public void enableLogResponse(final boolean logResponseEnabled) {
        this.logResponseEnabled = logResponseEnabled;
    }
    
    public void enableLogUrl(final boolean logUrlEnabled) {
        this.logUrlEnabled = logUrlEnabled;
    }
    
    public String getAcceptContentType() {
        return this.acceptContentType;
    }
    
    public String getCharset() {
        return this.charset;
    }
    
    public String getContentType() {
        return this.contentType;
    }
    
    public String getHeader(final String key) {
        if (Utils.isNullOrWhiteSpace(key)) {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        }
        return this.headers.get(key);
    }
    
    public String getHost() {
        if (this.secure) {
            return this.secureHost;
        }
        return this.nonSecureHost;
    }
    
    public WebRequest$HttpMethod getHttpMethod() {
        return this.httpMethod;
    }
    
    protected String getLogTag() {
        return this.logTag;
    }
    
    public String getPath() {
        return this.path;
    }
    
    public int getPort() {
        return this.port;
    }
    
    public String getPostParameter(final String key) {
        if (Utils.isNullOrWhiteSpace(key)) {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        }
        return this.postParameters.get(key);
    }
    
    public String getQueryParameter(final String s) {
        return this.queryStringParameters.get(s);
    }
    
    public String getRequestBody() {
        if (this.getRequestBodyString() != null) {
            return this.getRequestBodyString();
        }
        if (this.postParameters.isEmpty()) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<String, V> entry : this.postParameters.entrySet()) {
            sb.append(entry.getKey()).append('=').append((String)entry.getValue()).append(";\n");
        }
        return sb.toString();
    }
    
    public String getRequestBodyString() {
        return this.requestBody;
    }
    
    protected String getScheme() {
        if (this.getUseSecure()) {
            return "https";
        }
        return "http";
    }
    
    protected abstract String getSubLogTag();
    
    public int getTimeout() {
        return this.timeout;
    }
    
    protected String getUrl() {
        if (this.urlString != null) {
            return this.urlString;
        }
        final StringBuilder sb = new StringBuilder(this.getScheme());
        sb.append("://");
        sb.append(this.getHost());
        if (this.getPort() != -1) {
            sb.append(":");
            sb.append(this.getPort());
        }
        sb.append(this.getPath());
        this.appendQuery(sb);
        return sb.toString();
    }
    
    public String getUrlString() {
        return this.urlString;
    }
    
    public boolean getUseSecure() {
        return this.secure;
    }
    
    protected void logUrl(final String s) {
        if (this.logUrlEnabled) {
            Log.d(this.getLogTag(), "%s %s", this.getHttpMethod(), s);
        }
    }
    
    public WebRequest$WebResponse makeCall() {
        if (ThreadUtils.isOnMainThread()) {
            Log.e(this.logTag, "The network request should not be performed on the main thread.");
        }
        this.setContentTypeHeaders();
        final String url = this.getUrl();
        URL url2;
        try {
            url2 = this.createURL(url);
            this.writeMetricStart(this.serviceCallLatencyMetric);
            final WebRequest webRequest = this;
            final URL url3 = url2;
            final WebRequest$WebResponse doHttpNetworkCall = webRequest.doHttpNetworkCall(url3);
            return doHttpNetworkCall;
        }
        catch (MalformedURLException ex) {
            Log.e(this.logTag, "Problem with URI syntax: %s", ex.getMessage());
            throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.MALFORMED_URL, "Could not construct URL from String " + url, ex);
        }
        try {
            final WebRequest webRequest = this;
            final URL url3 = url2;
            final WebRequest$WebResponse doHttpNetworkCall2;
            final WebRequest$WebResponse doHttpNetworkCall = doHttpNetworkCall2 = webRequest.doHttpNetworkCall(url3);
            return doHttpNetworkCall2;
        }
        catch (WebRequest$WebRequestException ex2) {
            throw ex2;
        }
        finally {
            this.writeMetricStop(this.serviceCallLatencyMetric);
        }
    }
    
    public void putHeader(final String key, final String value) {
        if (Utils.isNullOrWhiteSpace(key)) {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        }
        this.headers.put(key, value);
    }
    
    public void putPostParameter(final String s, final String value) {
        if (Utils.isNullOrWhiteSpace(s)) {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        }
        if (value == null) {
            this.postParameters.remove(s);
            return;
        }
        this.postParameters.put(s, value);
    }
    
    public String putUnencodedQueryParameter(final String s, final String s2) {
        return this.queryStringParameters.putUnencoded(s, s2);
    }
    
    public void putUrlEncodedQueryParameter(final String s, final String s2) {
        this.queryStringParameters.putUrlEncoded(s, s2);
    }
    
    public void setAcceptContentType(final String s) {
        this.acceptContentType = this.contentType;
    }
    
    public void setAdditionalQueryParamsString(final String rawAppendage) {
        this.queryStringParameters.setRawAppendage(rawAppendage);
    }
    
    public void setCharset(final String charset) {
        this.charset = charset;
    }
    
    public void setContentType(final String contentType) {
        this.contentType = contentType;
    }
    
    protected void setContentTypeHeaders() {
        if (this.acceptContentType != null) {
            this.putHeader("Accept", this.contentType);
        }
        if (this.contentType != null) {
            String str = this.contentType;
            if (this.charset != null) {
                str = str + "; charset=" + this.charset;
            }
            this.putHeader("Content-Type", str);
        }
    }
    
    public void setExternalLogTag(final String str) {
        if (str == null) {
            this.logTag = WebRequest.LOG_TAG + " " + this.getSubLogTag();
            return;
        }
        this.logTag = str + " " + WebRequest.LOG_TAG + " " + this.getSubLogTag();
    }
    
    public void setHost(final String s) {
        if (Utils.isNullOrWhiteSpace(s)) {
            throw new IllegalArgumentException("The host must not be null.");
        }
        this.secureHost = s;
        this.nonSecureHost = s;
    }
    
    public void setHttpMethod(final WebRequest$HttpMethod httpMethod) {
        if (httpMethod == null) {
            throw new IllegalArgumentException("The httpMethod must not be null.");
        }
        this.httpMethod = httpMethod;
    }
    
    public void setMetricsCollector(final MetricsCollector metricsCollector) {
        this.metricsCollector = metricsCollector;
    }
    
    public void setNonSecureHost(final String nonSecureHost) {
        if (Utils.isNullOrWhiteSpace(nonSecureHost)) {
            throw new IllegalArgumentException("The host must not be null.");
        }
        this.nonSecureHost = nonSecureHost;
    }
    
    public void setPath(final String path) {
        this.path = path;
    }
    
    public void setPort(final int port) {
        this.port = port;
    }
    
    public void setQueryStringParameters(final WebRequest$QueryStringParameters queryStringParameters) {
        this.queryStringParameters = queryStringParameters;
    }
    
    public void setRequestBodyString(final String requestBody) {
        this.requestBody = requestBody;
    }
    
    public void setSecureHost(final String secureHost) {
        if (Utils.isNullOrWhiteSpace(secureHost)) {
            throw new IllegalArgumentException("The host must not be null.");
        }
        this.secureHost = secureHost;
    }
    
    public void setServiceCallLatencyMetric(final Metrics$MetricType serviceCallLatencyMetric) {
        this.serviceCallLatencyMetric = serviceCallLatencyMetric;
    }
    
    public void setTimeout(final int timeout) {
        this.timeout = timeout;
    }
    
    public void setUrlString(String replaceFirst) {
        if (replaceFirst != null && this.secure && replaceFirst.startsWith("http:")) {
            replaceFirst = replaceFirst.replaceFirst("http", "https");
        }
        this.urlString = replaceFirst;
    }
    
    public void setUseSecure(final boolean secure) {
        this.secure = secure;
    }
    
    @Override
    public String toString() {
        return this.getUrl();
    }
    
    protected void writeMetricStart(final Metrics$MetricType metrics$MetricType) {
        if (metrics$MetricType != null && this.metricsCollector != null) {
            this.metricsCollector.startMetric(metrics$MetricType);
        }
    }
    
    protected void writeMetricStop(final Metrics$MetricType metrics$MetricType) {
        if (metrics$MetricType != null && this.metricsCollector != null) {
            this.metricsCollector.stopMetric(metrics$MetricType);
        }
    }
}
