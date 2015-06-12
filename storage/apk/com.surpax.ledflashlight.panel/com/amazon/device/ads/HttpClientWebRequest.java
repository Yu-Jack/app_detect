// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import java.net.URI;
import org.apache.http.client.methods.HttpGet;
import java.net.URISyntaxException;
import org.apache.http.client.methods.HttpRequestBase;
import java.net.URL;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.entity.StringEntity;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import java.util.ArrayList;
import org.apache.http.client.methods.HttpPost;

class HttpClientWebRequest extends WebRequest
{
    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static final String LOG_TAG;
    
    static {
        LOG_TAG = HttpClientWebRequest.class.getSimpleName();
    }
    
    private void prepareFormRequestBody(final HttpPost httpPost, final String s) {
        final ArrayList<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        for (final Map.Entry<String, V> entry : this.postParameters.entrySet()) {
            list.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
        }
        try {
            httpPost.setEntity((HttpEntity)new UrlEncodedFormEntity((List)list, "UTF-8"));
        }
        catch (UnsupportedEncodingException ex) {
            Log.e(this.getLogTag(), "Unsupported character encoding used while creating the request: %s", ex.getMessage());
            throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.UNSUPPORTED_ENCODING, "Unsupported character encoding used while creating the request", ex);
        }
    }
    
    private void prepareRequestBody(final HttpPost httpPost) {
        String charset = this.charset;
        if (charset == null) {
            charset = "UTF-8";
        }
        String contentType = this.contentType;
        if (contentType == null) {
            contentType = "text/plain";
        }
        if (this.requestBody != null) {
            this.prepareStringRequestBody(httpPost, contentType, charset);
            return;
        }
        this.prepareFormRequestBody(httpPost, charset);
    }
    
    private void prepareStringRequestBody(final HttpPost httpPost, final String contentType, final String s) {
        try {
            final StringEntity entity = new StringEntity(this.requestBody, s);
            entity.setContentType(contentType);
            httpPost.setEntity((HttpEntity)entity);
        }
        catch (UnsupportedEncodingException ex) {
            Log.e(this.getLogTag(), "Unsupported character encoding used while creating the request. ", ex.getMessage());
            throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.UNSUPPORTED_ENCODING, "Unsupported character encoding used while creating the request.", ex);
        }
    }
    
    protected HttpParams createHttpParams() {
        final BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout((HttpParams)basicHttpParams, this.getTimeout());
        HttpConnectionParams.setSoTimeout((HttpParams)basicHttpParams, this.getTimeout());
        HttpConnectionParams.setSocketBufferSize((HttpParams)basicHttpParams, 8192);
        return (HttpParams)basicHttpParams;
    }
    
    protected HttpRequestBase createHttpRequest(final URL url) {
        URI uri = null;
        Object o = null;
    Label_0219:
        while (true) {
            while (true) {
                Label_0192: {
                    try {
                        uri = this.createURI(url);
                        switch (this.getHttpMethod()) {
                            default: {
                                o = null;
                                for (final Map.Entry<K, Object> entry : this.headers.entrySet()) {
                                    if (entry.getValue() != null && !entry.getValue().equals("")) {
                                        ((HttpRequestBase)o).addHeader((String)entry.getKey(), (String)entry.getValue());
                                    }
                                }
                                break Label_0219;
                            }
                            case GET: {
                                break;
                            }
                            case POST: {
                                break Label_0192;
                            }
                        }
                    }
                    catch (URISyntaxException ex) {
                        Log.e(this.getLogTag(), "Problem with URI syntax: %s", ex.getMessage());
                        throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.MALFORMED_URL, "Problem with URI syntax", ex);
                    }
                    o = new HttpGet(uri);
                    continue;
                }
                final HttpPost httpPost = new HttpPost(uri);
                this.prepareRequestBody(httpPost);
                o = httpPost;
                continue;
            }
        }
        this.logUrl(uri.toString());
        if (this.logRequestBodyEnabled && this.getRequestBody() != null) {
            Log.d(this.getLogTag(), "Request Body: %s", this.getRequestBody());
        }
        return (HttpRequestBase)o;
    }
    
    @Override
    protected WebRequest$WebResponse doHttpNetworkCall(final URL url) {
        final HttpRequestBase httpRequest = this.createHttpRequest(url);
        final DefaultHttpClient defaultHttpClient = new DefaultHttpClient(this.createHttpParams());
        try {
            return this.parseResponse(((HttpClient)defaultHttpClient).execute((HttpUriRequest)httpRequest));
        }
        catch (ClientProtocolException ex) {
            Log.e(this.getLogTag(), "Invalid client protocol: %s", ex.getMessage());
            throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.INVALID_CLIENT_PROTOCOL, "Invalid client protocol", (Throwable)ex);
        }
        catch (IOException ex2) {
            Log.e(this.getLogTag(), "IOException during client execution: %s", ex2.getMessage());
            throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.NETWORK_FAILURE, "IOException during client execution", ex2);
        }
    }
    
    @Override
    protected String getSubLogTag() {
        return HttpClientWebRequest.LOG_TAG;
    }
    
    protected WebRequest$WebResponse parseResponse(final HttpResponse httpResponse) {
        final WebRequest$WebResponse webRequest$WebResponse = new WebRequest$WebResponse(this);
        webRequest$WebResponse.setLogTag(this.getLogTag());
        webRequest$WebResponse.enableLog(this.logResponseEnabled);
        webRequest$WebResponse.setHttpStatusCode(httpResponse.getStatusLine().getStatusCode());
        webRequest$WebResponse.setHttpStatus(httpResponse.getStatusLine().getReasonPhrase());
        if (webRequest$WebResponse.getHttpStatusCode() != 200) {
            return webRequest$WebResponse;
        }
        final HttpEntity entity = httpResponse.getEntity();
        if (entity == null || entity.getContentLength() == 0L) {
            return webRequest$WebResponse;
        }
        try {
            webRequest$WebResponse.setInputStream(entity.getContent());
            return webRequest$WebResponse;
        }
        catch (IOException ex) {
            Log.e(this.getLogTag(), "IOException while reading the input stream from response: %s", ex.getMessage());
            throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.NETWORK_FAILURE, "IOException while reading the input stream from response", ex);
        }
    }
}
