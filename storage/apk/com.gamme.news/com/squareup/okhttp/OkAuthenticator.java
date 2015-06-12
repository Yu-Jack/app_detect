// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

import java.io.UnsupportedEncodingException;
import com.squareup.okhttp.internal.Base64;
import java.io.IOException;
import java.util.List;
import java.net.URL;
import java.net.Proxy;

public interface OkAuthenticator
{
    Credential authenticate(Proxy p0, URL p1, List<Challenge> p2) throws IOException;
    
    Credential authenticateProxy(Proxy p0, URL p1, List<Challenge> p2) throws IOException;
    
    public static final class Challenge
    {
        private final String realm;
        private final String scheme;
        
        public Challenge(String scheme, String realm) {
            this.scheme = scheme;
            this.realm = realm;
        }
        
        @Override
        public boolean equals(Object o) {
            return o instanceof Challenge && ((Challenge)o).scheme.equals(this.scheme) && ((Challenge)o).realm.equals(this.realm);
        }
        
        public String getRealm() {
            return this.realm;
        }
        
        public String getScheme() {
            return this.scheme;
        }
        
        @Override
        public int hashCode() {
            return this.scheme.hashCode() + 31 * this.realm.hashCode();
        }
        
        @Override
        public String toString() {
            return String.valueOf(this.scheme) + " realm=\"" + this.realm + "\"";
        }
    }
    
    public static final class Credential
    {
        private final String headerValue;
        
        private Credential(String headerValue) {
            this.headerValue = headerValue;
        }
        
        public static Credential basic(String obj, String str) {
            try {
                return new Credential("Basic " + Base64.encode((String.valueOf(obj) + ":" + str).getBytes("ISO-8859-1")));
            }
            catch (UnsupportedEncodingException ex) {
                throw new AssertionError();
            }
        }
        
        @Override
        public boolean equals(Object o) {
            return o instanceof Credential && ((Credential)o).headerValue.equals(this.headerValue);
        }
        
        public String getHeaderValue() {
            return this.headerValue;
        }
        
        @Override
        public int hashCode() {
            return this.headerValue.hashCode();
        }
        
        @Override
        public String toString() {
            return this.headerValue;
        }
    }
}
