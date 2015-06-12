// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.io.OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.net.URL;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;

class HttpUrlConnectionNetworkClient implements NetworkClient
{
    private HttpURLConnection mConnection;
    
    private void closeURLConnection(final HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
    
    private InputStream handleServerResponse(final HttpURLConnection httpURLConnection) throws IOException {
        final int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            return httpURLConnection.getInputStream();
        }
        final String string = "Bad response: " + responseCode;
        if (responseCode == 404) {
            throw new FileNotFoundException(string);
        }
        throw new IOException(string);
    }
    
    @Override
    public void close() {
        this.closeURLConnection(this.mConnection);
    }
    
    @Override
    public InputStream getInputStream(final String s) throws IOException {
        this.mConnection = this.getUrlConnection(s);
        return this.handleServerResponse(this.mConnection);
    }
    
    @VisibleForTesting
    HttpURLConnection getUrlConnection(final String spec) throws IOException {
        final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(spec).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        return httpURLConnection;
    }
    
    @Override
    public void sendPostRequest(final String s, final byte[] b) throws IOException {
        final HttpURLConnection urlConnection = this.getUrlConnection(s);
        try {
            urlConnection.setRequestProperty("Content-Length", Integer.toString(b.length));
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.connect();
            final OutputStream outputStream = urlConnection.getOutputStream();
            try {
                outputStream.write(b);
                outputStream.flush();
                outputStream.close();
                this.handleServerResponse(urlConnection);
            }
            finally {
                outputStream.close();
            }
        }
        finally {
            this.closeURLConnection(urlConnection);
        }
    }
}
