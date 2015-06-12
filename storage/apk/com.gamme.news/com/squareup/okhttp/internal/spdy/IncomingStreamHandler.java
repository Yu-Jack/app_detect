// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.spdy;

import java.io.IOException;

public interface IncomingStreamHandler
{
    public static final IncomingStreamHandler REFUSE_INCOMING_STREAMS = new IncomingStreamHandler() {
        @Override
        public void receive(SpdyStream spdyStream) throws IOException {
            spdyStream.close(ErrorCode.REFUSED_STREAM);
        }
    };
    
    void receive(SpdyStream p0) throws IOException;
}
