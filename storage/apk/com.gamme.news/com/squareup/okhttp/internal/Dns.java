// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal;

import java.net.UnknownHostException;
import java.net.InetAddress;

public interface Dns
{
    public static final Dns DEFAULT = new Dns() {
        @Override
        public InetAddress[] getAllByName(String host) throws UnknownHostException {
            return InetAddress.getAllByName(host);
        }
    };
    
    InetAddress[] getAllByName(String p0) throws UnknownHostException;
}
