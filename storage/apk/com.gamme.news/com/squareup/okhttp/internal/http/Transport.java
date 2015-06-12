// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.io.InputStream;
import java.net.CacheRequest;
import java.io.IOException;
import java.io.OutputStream;

interface Transport
{
    OutputStream createRequestBody() throws IOException;
    
    void flushRequest() throws IOException;
    
    InputStream getTransferStream(CacheRequest p0) throws IOException;
    
    boolean makeReusable(boolean p0, OutputStream p1, InputStream p2);
    
    ResponseHeaders readResponseHeaders() throws IOException;
    
    void writeRequestBody(RetryableOutputStream p0) throws IOException;
    
    void writeRequestHeaders() throws IOException;
}
