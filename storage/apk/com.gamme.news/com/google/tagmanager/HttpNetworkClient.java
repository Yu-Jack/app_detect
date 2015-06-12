// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.client.methods.HttpPost;
import com.google.android.gms.common.util.VisibleForTesting;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.BasicHttpParams;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

class HttpNetworkClient implements NetworkClient
{
    private HttpClient mClient;
    
    private void closeWithClient(final HttpClient httpClient) {
        if (httpClient != null && httpClient.getConnectionManager() != null) {
            httpClient.getConnectionManager().shutdown();
        }
    }
    
    private InputStream handleServerResponse(final HttpClient httpClient, final HttpResponse httpResponse) throws IOException {
        final int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            Log.v("Success response");
            return httpResponse.getEntity().getContent();
        }
        final String string = "Bad response: " + statusCode;
        if (statusCode == 404) {
            throw new FileNotFoundException(string);
        }
        throw new IOException(string);
    }
    
    @Override
    public void close() {
        this.closeWithClient(this.mClient);
    }
    
    @VisibleForTesting
    HttpClient createNewHttpClient() {
        final BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout((HttpParams)basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout((HttpParams)basicHttpParams, 20000);
        return (HttpClient)new DefaultHttpClient((HttpParams)basicHttpParams);
    }
    
    @VisibleForTesting
    HttpPost createPostRequest(final String s, final byte[] array) {
        final HttpPost httpPost = new HttpPost(s);
        httpPost.setEntity((HttpEntity)new ByteArrayEntity(array));
        return httpPost;
    }
    
    @Override
    public InputStream getInputStream(final String s) throws IOException {
        this.mClient = this.createNewHttpClient();
        return this.handleServerResponse(this.mClient, this.mClient.execute((HttpUriRequest)new HttpGet(s)));
    }
    
    @Override
    public void sendPostRequest(final String s, final byte[] array) throws IOException {
        final HttpClient newHttpClient = this.createNewHttpClient();
        this.handleServerResponse(newHttpClient, newHttpClient.execute((HttpUriRequest)this.createPostRequest(s, array)));
        this.closeWithClient(newHttpClient);
    }
}
