// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.tls;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import java.util.Locale;
import java.util.Iterator;
import java.util.Collection;
import java.security.cert.CertificateParsingException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.security.cert.X509Certificate;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;

public final class OkHostnameVerifier implements HostnameVerifier
{
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE;
    private static final Pattern VERIFY_AS_IP_ADDRESS;
    
    static {
        INSTANCE = new OkHostnameVerifier();
        VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }
    
    private List<String> getSubjectAltNames(final X509Certificate x509Certificate, final int n) {
        List<String> emptyList = new ArrayList<String>();
        try {
            final Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (final List<Integer> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2) {
                    final Integer n2 = list.get(0);
                    if (n2 == null || n2 != n) {
                        continue;
                    }
                    final String s = (String)list.get(1);
                    if (s == null) {
                        continue;
                    }
                    emptyList.add(s);
                }
            }
        }
        catch (CertificateParsingException ex) {
            emptyList = Collections.emptyList();
        }
        return emptyList;
    }
    
    static boolean verifyAsIpAddress(final String input) {
        return OkHostnameVerifier.VERIFY_AS_IP_ADDRESS.matcher(input).matches();
    }
    
    private boolean verifyHostName(final String s, final X509Certificate x509Certificate) {
        final String lowerCase = s.toLowerCase(Locale.US);
        int n = 0;
        for (final String s2 : this.getSubjectAltNames(x509Certificate, 2)) {
            n = 1;
            if (this.verifyHostName(lowerCase, s2)) {
                return true;
            }
        }
        if (n == 0) {
            final String mostSpecific = new DistinguishedNameParser(x509Certificate.getSubjectX500Principal()).findMostSpecific("cn");
            if (mostSpecific != null) {
                return this.verifyHostName(lowerCase, mostSpecific);
            }
        }
        return false;
    }
    
    private boolean verifyIpAddress(final String s, final X509Certificate x509Certificate) {
        final Iterator<String> iterator = this.getSubjectAltNames(x509Certificate, 7).iterator();
        while (iterator.hasNext()) {
            if (s.equalsIgnoreCase(iterator.next())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean verify(final String s, final X509Certificate x509Certificate) {
        if (verifyAsIpAddress(s)) {
            return this.verifyIpAddress(s, x509Certificate);
        }
        return this.verifyHostName(s, x509Certificate);
    }
    
    @Override
    public boolean verify(final String s, final SSLSession sslSession) {
        try {
            return this.verify(s, (X509Certificate)sslSession.getPeerCertificates()[0]);
        }
        catch (SSLException ex) {
            return false;
        }
    }
    
    public boolean verifyHostName(final String s, final String s2) {
        boolean b = true;
        if (s == null || s.length() == 0 || s2 == null || s2.length() == 0) {
            b = false;
        }
        else {
            final String lowerCase = s2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return s.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || !s.regionMatches(0, lowerCase, 2, -2 + lowerCase.length())) {
                final int index = lowerCase.indexOf(42);
                if (index > lowerCase.indexOf(46)) {
                    return false;
                }
                if (!s.regionMatches(0, lowerCase, 0, index)) {
                    return false;
                }
                final int len = lowerCase.length() - (index + 1);
                final int toffset = s.length() - len;
                if (s.indexOf(46, index) < toffset && !s.endsWith(".clients.google.com")) {
                    return false;
                }
                if (!s.regionMatches(toffset, lowerCase, index + 1, len)) {
                    return false;
                }
            }
        }
        return b;
    }
}
