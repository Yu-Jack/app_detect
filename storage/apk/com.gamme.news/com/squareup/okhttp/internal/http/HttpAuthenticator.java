// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.util.ArrayList;
import java.net.PasswordAuthentication;
import java.util.Iterator;
import java.net.Authenticator;
import java.util.List;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.InetAddress;
import java.net.URL;
import java.net.Proxy;
import com.squareup.okhttp.OkAuthenticator;

public final class HttpAuthenticator
{
    public static final OkAuthenticator SYSTEM_DEFAULT;
    
    static {
        SYSTEM_DEFAULT = new OkAuthenticator() {
            private InetAddress getConnectToInetAddress(final Proxy proxy, final URL url) throws IOException {
                if (proxy != null && proxy.type() != Proxy.Type.DIRECT) {
                    return ((InetSocketAddress)proxy.address()).getAddress();
                }
                return InetAddress.getByName(url.getHost());
            }
            
            @Override
            public Credential authenticate(final Proxy proxy, final URL url, final List<Challenge> list) throws IOException {
                for (final Challenge challenge : list) {
                    if ("Basic".equalsIgnoreCase(challenge.getScheme())) {
                        final PasswordAuthentication requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(url.getHost(), this.getConnectToInetAddress(proxy, url), url.getPort(), url.getProtocol(), challenge.getRealm(), challenge.getScheme(), url, Authenticator.RequestorType.SERVER);
                        if (requestPasswordAuthentication != null) {
                            return Credential.basic(requestPasswordAuthentication.getUserName(), new String(requestPasswordAuthentication.getPassword()));
                        }
                        continue;
                    }
                }
                return null;
            }
            
            @Override
            public Credential authenticateProxy(final Proxy proxy, final URL url, final List<Challenge> list) throws IOException {
                for (final Challenge challenge : list) {
                    if ("Basic".equalsIgnoreCase(challenge.getScheme())) {
                        final InetSocketAddress inetSocketAddress = (InetSocketAddress)proxy.address();
                        final PasswordAuthentication requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), this.getConnectToInetAddress(proxy, url), inetSocketAddress.getPort(), url.getProtocol(), challenge.getRealm(), challenge.getScheme(), url, Authenticator.RequestorType.PROXY);
                        if (requestPasswordAuthentication != null) {
                            return Credential.basic(requestPasswordAuthentication.getUserName(), new String(requestPasswordAuthentication.getPassword()));
                        }
                        continue;
                    }
                }
                return null;
            }
        };
    }
    
    private static List<OkAuthenticator.Challenge> parseChallenges(final RawHeaders rawHeaders, final String s) {
        final ArrayList<OkAuthenticator.Challenge> list = new ArrayList<OkAuthenticator.Challenge>();
        for (int i = 0; i < rawHeaders.length(); ++i) {
            if (s.equalsIgnoreCase(rawHeaders.getFieldName(i))) {
                final String value = rawHeaders.getValue(i);
                int j = 0;
                while (j < value.length()) {
                    final int beginIndex = j;
                    final int skipUntil = HeaderParser.skipUntil(value, j, " ");
                    final String trim = value.substring(beginIndex, skipUntil).trim();
                    final int skipWhitespace = HeaderParser.skipWhitespace(value, skipUntil);
                    if (!value.regionMatches(true, skipWhitespace, "realm=\"", 0, "realm=\"".length())) {
                        break;
                    }
                    final int beginIndex2 = skipWhitespace + "realm=\"".length();
                    final int skipUntil2 = HeaderParser.skipUntil(value, beginIndex2, "\"");
                    final String substring = value.substring(beginIndex2, skipUntil2);
                    j = HeaderParser.skipWhitespace(value, 1 + HeaderParser.skipUntil(value, skipUntil2 + 1, ","));
                    list.add(new OkAuthenticator.Challenge(trim, substring));
                }
            }
        }
        return list;
    }
    
    public static boolean processAuthHeader(final OkAuthenticator okAuthenticator, final int n, final RawHeaders rawHeaders, final RawHeaders rawHeaders2, final Proxy proxy, final URL url) throws IOException {
        String s;
        String s2;
        if (n == 401) {
            s = "WWW-Authenticate";
            s2 = "Authorization";
        }
        else {
            if (n != 407) {
                throw new IllegalArgumentException();
            }
            s = "Proxy-Authenticate";
            s2 = "Proxy-Authorization";
        }
        final List<OkAuthenticator.Challenge> challenges = parseChallenges(rawHeaders, s);
        if (!challenges.isEmpty()) {
            OkAuthenticator.Credential credential;
            if (rawHeaders.getResponseCode() == 407) {
                credential = okAuthenticator.authenticateProxy(proxy, url, challenges);
            }
            else {
                credential = okAuthenticator.authenticate(proxy, url, challenges);
            }
            if (credential != null) {
                rawHeaders2.set(s2, credential.getHeaderValue());
                return true;
            }
        }
        return false;
    }
}
