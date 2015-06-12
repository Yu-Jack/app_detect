// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import com.google.android.gms.common.util.VisibleForTesting;
import java.net.MalformedURLException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpHost;
import java.util.List;
import java.io.InputStream;
import org.apache.http.Header;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.HttpEntityEnclosingRequest;
import java.net.URL;
import android.os.Build;
import java.util.Locale;
import android.os.Build$VERSION;
import org.apache.http.client.HttpClient;
import android.content.Context;

class SimpleNetworkDispatcher implements Dispatcher
{
    private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
    private final Context ctx;
    private DispatchListener dispatchListener;
    private final HttpClient httpClient;
    private final String userAgent;
    
    SimpleNetworkDispatcher(final HttpClient httpClient, final Context context, final DispatchListener dispatchListener) {
        this.ctx = context.getApplicationContext();
        this.userAgent = this.createUserAgentString("GoogleTagManager", "3.02", Build$VERSION.RELEASE, getUserAgentLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
        this.httpClient = httpClient;
        this.dispatchListener = dispatchListener;
    }
    
    private HttpEntityEnclosingRequest constructGtmRequest(final URL url) {
        HttpEntityEnclosingRequest httpEntityEnclosingRequest = null;
        BasicHttpEntityEnclosingRequest basicHttpEntityEnclosingRequest = null;
        try {
            final Object o;
            basicHttpEntityEnclosingRequest = (BasicHttpEntityEnclosingRequest)(o = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString()));
            final String s = "User-Agent";
            final SimpleNetworkDispatcher simpleNetworkDispatcher = this;
            final String s2 = simpleNetworkDispatcher.userAgent;
            ((HttpEntityEnclosingRequest)o).addHeader(s, s2);
            final BasicHttpEntityEnclosingRequest basicHttpEntityEnclosingRequest2 = basicHttpEntityEnclosingRequest;
            return (HttpEntityEnclosingRequest)basicHttpEntityEnclosingRequest2;
        }
        catch (URISyntaxException ex2) {}
        while (true) {
            try {
                final Object o = basicHttpEntityEnclosingRequest;
                final String s = "User-Agent";
                final SimpleNetworkDispatcher simpleNetworkDispatcher = this;
                final String s2 = simpleNetworkDispatcher.userAgent;
                ((HttpEntityEnclosingRequest)o).addHeader(s, s2);
                final BasicHttpEntityEnclosingRequest basicHttpEntityEnclosingRequest2 = basicHttpEntityEnclosingRequest;
                return (HttpEntityEnclosingRequest)basicHttpEntityEnclosingRequest2;
                final URISyntaxException ex;
                Log.w("Exception sending hit: " + ex.getClass().getSimpleName());
                Log.w(ex.getMessage());
                return httpEntityEnclosingRequest;
            }
            catch (URISyntaxException ex) {
                httpEntityEnclosingRequest = (HttpEntityEnclosingRequest)basicHttpEntityEnclosingRequest;
                continue;
            }
            break;
        }
    }
    
    static String getUserAgentLanguage(final Locale locale) {
        if (locale != null && locale.getLanguage() != null && locale.getLanguage().length() != 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append(locale.getLanguage().toLowerCase());
            if (locale.getCountry() != null && locale.getCountry().length() != 0) {
                sb.append("-").append(locale.getCountry().toLowerCase());
            }
            return sb.toString();
        }
        return null;
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
    public void dispatchHits(final List<Hit> list) {
        final int min = Math.min(list.size(), 40);
        int n = 1;
        for (int i = 0; i < min; ++i) {
            final Hit hit = list.get(i);
            final URL url = this.getUrl(hit);
            if (url == null) {
                Log.w("No destination: discarding hit.");
                this.dispatchListener.onHitPermanentDispatchFailure(hit);
            }
            else {
                final HttpEntityEnclosingRequest constructGtmRequest = this.constructGtmRequest(url);
                if (constructGtmRequest == null) {
                    this.dispatchListener.onHitPermanentDispatchFailure(hit);
                }
                else {
                    final HttpHost httpHost = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
                    constructGtmRequest.addHeader("Host", httpHost.toHostString());
                    this.logDebugInformation(constructGtmRequest);
                    Label_0156: {
                        if (n == 0) {
                            break Label_0156;
                        }
                        try {
                            NetworkReceiver.sendRadioPoweredBroadcast(this.ctx);
                            n = 0;
                            final HttpResponse execute = this.httpClient.execute(httpHost, (HttpRequest)constructGtmRequest);
                            final int statusCode = execute.getStatusLine().getStatusCode();
                            final HttpEntity entity = execute.getEntity();
                            if (entity != null) {
                                entity.consumeContent();
                            }
                            if (statusCode == 200) {
                                goto Label_0284;
                            }
                            Log.w("Bad response: " + execute.getStatusLine().getStatusCode());
                            this.dispatchListener.onHitTransientDispatchFailure(hit);
                        }
                        catch (ClientProtocolException ex2) {
                            Log.w("ClientProtocolException sending hit; discarding hit...");
                            this.dispatchListener.onHitPermanentDispatchFailure(hit);
                        }
                        catch (IOException ex) {
                            Log.w("Exception sending hit: " + ex.getClass().getSimpleName());
                            Log.w(ex.getMessage());
                            this.dispatchListener.onHitTransientDispatchFailure(hit);
                        }
                    }
                }
            }
        }
    }
    
    @VisibleForTesting
    URL getUrl(final Hit hit) {
        final String hitUrl = hit.getHitUrl();
        try {
            return new URL(hitUrl);
        }
        catch (MalformedURLException ex) {
            Log.e("Error trying to parse the GTM url.");
            return null;
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
    
    public interface DispatchListener
    {
        void onHitDispatched(Hit p0);
        
        void onHitPermanentDispatchFailure(Hit p0);
        
        void onHitTransientDispatchFailure(Hit p0);
    }
}
