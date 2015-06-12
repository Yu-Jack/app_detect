// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.io.IOException;
import java.io.InputStream;

interface NetworkClient
{
    public static final int DEFAULT_CONNECTION_TIMEOUT_MILLIS = 20000;
    public static final int DEFAULT_SOCKET_TIMEOUT_MILLIS = 20000;
    
    void close();
    
    InputStream getInputStream(String p0) throws IOException;
    
    void sendPostRequest(String p0, byte[] p1) throws IOException;
}
