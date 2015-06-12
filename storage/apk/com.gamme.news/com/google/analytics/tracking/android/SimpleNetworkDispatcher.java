// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import com.google.android.gms.common.util.VisibleForTesting;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpHost;
import java.util.List;
import java.io.InputStream;
import org.apache.http.Header;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import android.text.TextUtils;
import org.apache.http.HttpEntityEnclosingRequest;
import android.os.Build;
import java.util.Locale;
import android.os.Build$VERSION;
import java.net.URL;
import org.apache.http.client.HttpClient;
import android.content.Context;

class SimpleNetworkDispatcher implements Dispatcher
{
    private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
    private final Context ctx;
    private GoogleAnalytics gaInstance;
    private final HttpClient httpClient;
    private URL mOverrideHostUrl;
    private final String userAgent;
    
    SimpleNetworkDispatcher(final HttpClient httpClient, final Context context) {
        this(httpClient, GoogleAnalytics.getInstance(context), context);
    }
    
    SimpleNetworkDispatcher(final HttpClient httpClient, final GoogleAnalytics gaInstance, final Context context) {
        this.ctx = context.getApplicationContext();
        this.userAgent = this.createUserAgentString("GoogleAnalytics", "3.0", Build$VERSION.RELEASE, Utils.getLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
        this.httpClient = httpClient;
        this.gaInstance = gaInstance;
    }
    
    private HttpEntityEnclosingRequest buildRequest(final String str, final String str2) {
        if (TextUtils.isEmpty((CharSequence)str)) {
            Log.w("Empty hit, discarding.");
            return null;
        }
        final String string = str2 + "?" + str;
        BasicHttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        if (string.length() < 2036) {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", string);
        }
        else {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", str2);
            try {
                ((HttpEntityEnclosingRequest)basicHttpEntityEnclosingRequest).setEntity((HttpEntity)new StringEntity(str));
            }
            catch (UnsupportedEncodingException ex) {
                Log.w("Encoding error, discarding hit");
                return null;
            }
        }
        ((HttpEntityEnclosingRequest)basicHttpEntityEnclosingRequest).addHeader("User-Agent", this.userAgent);
        return (HttpEntityEnclosingRequest)basicHttpEntityEnclosingRequest;
    }
    
    private void logDebugInformation(final HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        final StringBuffer sb = new StringBuffer();
        final Header[] allHeaders = httpEntityEnclosingRequest.getAllHeaders();
        for (int length = allHeaders.length, i = 0; i < length; ++i) {
            sb.append(allHeaders[i].toString()).append("\n");
        }
        sb.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        while (true) {
            if (httpEntityEnclosingRequest.getEntity() == null) {
                break Label_0150;
            }
            try {
                final InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    final int available = content.available();
                    if (available > 0) {
                        final byte[] array = new byte[available];
                        content.read(array);
                        sb.append("POST:\n");
                        sb.append(new String(array)).append("\n");
                    }
                }
                Log.v(sb.toString());
            }
            catch (IOException ex) {
                Log.v("Error Writing hit to log...");
                continue;
            }
            break;
        }
    }
    
    @Override
    public void close() {
        this.httpClient.getConnectionManager().shutdown();
    }
    
    String createUserAgentString(final String s, final String s2, final String s3, final String s4, final String s5, final String s6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", s, s2, s3, s4, s5, s6);
    }
    
    @Override
    public int dispatchHits(final List<Hit> list) {
        int n = 0;
        final int min = Math.min(list.size(), 40);
        int n2 = 1;
        for (int i = 0; i < min; ++i) {
            final Hit hit = list.get(i);
            final URL url = this.getUrl(hit);
            if (url == null) {
                if (Log.isVerbose()) {
                    Log.w("No destination: discarding hit: " + hit.getHitParams());
                }
                else {
                    Log.w("No destination: discarding hit.");
                }
                ++n;
            }
            else {
                final HttpHost httpHost = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
                final String path = url.getPath();
                String postProcessHit;
                if (TextUtils.isEmpty((CharSequence)hit.getHitParams())) {
                    postProcessHit = "";
                }
                else {
                    postProcessHit = HitBuilder.postProcessHit(hit, System.currentTimeMillis());
                }
                final HttpEntityEnclosingRequest buildRequest = this.buildRequest(postProcessHit, path);
                if (buildRequest == null) {
                    ++n;
                }
                else {
                    buildRequest.addHeader("Host", httpHost.toHostString());
                    if (Log.isVerbose()) {
                        this.logDebugInformation(buildRequest);
                    }
                    Label_0226: {
                        if (postProcessHit.length() > 8192) {
                            Log.w("Hit too long (> 8192 bytes)--not sent");
                        }
                        else if (this.gaInstance.isDryRunEnabled()) {
                            Log.i("Dry run enabled. Hit not actually sent.");
                        }
                        else {
                            while (true) {
                                if (n2 != 0) {
                                    try {
                                        GANetworkReceiver.sendRadioPoweredBroadcast(this.ctx);
                                        n2 = 0;
                                        final HttpResponse execute = this.httpClient.execute(httpHost, (HttpRequest)buildRequest);
                                        final int statusCode = execute.getStatusLine().getStatusCode();
                                        final HttpEntity entity = execute.getEntity();
                                        if (entity != null) {
                                            entity.consumeContent();
                                        }
                                        if (statusCode != 200) {
                                            Log.w("Bad response: " + execute.getStatusLine().getStatusCode());
                                        }
                                        break Label_0226;
                                    }
                                    catch (ClientProtocolException ex2) {
                                        Log.w("ClientProtocolException sending hit; discarding hit...");
                                        break Label_0226;
                                    }
                                    catch (IOException ex) {
                                        Log.w("Exception sending hit: " + ex.getClass().getSimpleName());
                                        Log.w(ex.getMessage());
                                    }
                                    break;
                                }
                                continue;
                            }
                        }
                    }
                    ++n;
                }
            }
        }
        return n;
    }
    
    @VisibleForTesting
    URL getUrl(final Hit hit) {
        if (this.mOverrideHostUrl != null) {
            return this.mOverrideHostUrl;
        }
        while (true) {
            final String hitUrlScheme = hit.getHitUrlScheme();
            while (true) {
                try {
                    if ("http:".equals(hitUrlScheme)) {
                        final String spec = "http://www.google-analytics.com/collect";
                        return new URL(spec);
                    }
                }
                catch (MalformedURLException ex) {
                    Log.e("Error trying to parse the hardcoded host url. This really shouldn't happen.");
                    return null;
                }
                final String spec = "https://ssl.google-analytics.com/collect";
                continue;
            }
        }
    }
    
    @Override
    public boolean okToDispatch() {
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)this.ctx.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            Log.v("...no network connectivity");
            return false;
        }
        return true;
    }
    
    @VisibleForTesting
    @Override
    public void overrideHostUrl(final String spec) {
        try {
            this.mOverrideHostUrl = new URL(spec);
        }
        catch (MalformedURLException ex) {
            this.mOverrideHostUrl = null;
        }
    }
}
