import java.util.Date;
import org.apache.http.RequestLine;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import java.util.LinkedList;
import android.net.Uri;
import org.apache.http.HttpRequest;

// 
// Decompiled by Procyon v0.5.29
// 

public final class tf extends td
{
    final String b;
    final String c;
    final tw d;
    
    public tf(final String b, final tw d, final byte[] array) {
        this.b = b;
        this.d = d;
        this.c = (String)adb.b.c(array);
    }
    
    @Override
    public final void a(final HttpRequest httpRequest) {
        new vr();
        try {
            final RequestLine requestLine = httpRequest.getRequestLine();
            final Uri parse = Uri.parse(requestLine.getUri());
            String s = parse.getPath();
            final String query = parse.getQuery();
            if (query != null) {
                s = String.valueOf(s) + "?" + query;
            }
            final String string = String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(requestLine.getMethod())).append(" ").toString())).append(s).toString()) + " ";
            final LinkedList<BasicNameValuePair> list = new LinkedList<BasicNameValuePair>();
            list.add(new BasicNameValuePair("auth_token", this.b));
            httpRequest.addHeader("X-COLORNOTE-TOKEN", String.valueOf(this.b) + ':' + vr.a(this.b(), String.valueOf(string) + URLEncodedUtils.format((List)list, "utf-8").replace("+", "%20")));
        }
        catch (UnsupportedEncodingException cause) {
            throw new RuntimeException(cause);
        }
    }
    
    @Override
    public final boolean a(final Date when) {
        return this.d.a().before(when);
    }
    
    public final byte[] b() {
        try {
            return (byte[])adb.b.d(this.c);
        }
        catch (ux cause) {
            throw new IllegalStateException(cause);
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        try {
            final tf tf = (tf)o;
            if (!this.b.equals(tf.b)) {
                return false;
            }
            if (this.c.equals(tf.c) && this.d.equals(tf.d)) {
                return true;
            }
        }
        catch (Exception ex) {}
        return false;
    }
}
