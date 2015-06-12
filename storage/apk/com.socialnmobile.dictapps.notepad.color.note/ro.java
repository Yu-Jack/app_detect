import org.apache.http.HttpResponse;
import java.io.UnsupportedEncodingException;
import com.socialnmobile.colornote.ColorNote;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import java.util.ArrayList;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.ProtocolVersion;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.HttpVersion;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.impl.client.DefaultHttpClient;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ro
{
    public ea a;
    public String b;
    String c;
    String d;
    String e;
    long f;
    
    public ro(final String b, final String c) {
        if (b == null || c == null) {
            throw new IllegalArgumentException();
        }
        this.b = b;
        this.c = c;
    }
    
    public static String a(final String s) {
        final DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        final BasicHttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion((HttpParams)params, (ProtocolVersion)HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUseExpectContinue((HttpParams)params, false);
        HttpConnectionParams.setConnectionTimeout((HttpParams)params, 10000);
        defaultHttpClient.setParams((HttpParams)params);
        final ArrayList<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        list.add(new BasicNameValuePair("client_id", "908669027715.apps.googleusercontent.com"));
        list.add(new BasicNameValuePair("client_secret", "SNZBS6UfQj4_DJSY1K6S3naw"));
        list.add(new BasicNameValuePair("code", s));
        list.add(new BasicNameValuePair("redirect_uri", "urn:ietf:wg:oauth:2.0:oob"));
        list.add(new BasicNameValuePair("grant_type", "authorization_code"));
        try {
            try {
                final UrlEncodedFormEntity entity = new UrlEncodedFormEntity((List)list, "UTF-8");
                final HttpPost httpPost = new HttpPost("https://accounts.google.com/o/oauth2/token");
                httpPost.setEntity((HttpEntity)entity);
                final HttpResponse execute = defaultHttpClient.execute((HttpUriRequest)httpPost);
                if (execute.getStatusLine().getStatusCode() == 200) {
                    final HttpEntity entity2 = execute.getEntity();
                    if (entity2 != null) {
                        return EntityUtils.toString(entity2);
                    }
                }
            }
            catch (UnsupportedEncodingException ex) {
                ColorNote.a("Unsupported Encoding");
            }
            return null;
        }
        finally {}
    }
}
