// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.spdy;

import java.util.List;
import java.io.InputStream;
import java.io.IOException;
import java.io.Closeable;

public interface FrameReader extends Closeable
{
    boolean nextFrame(Handler p0) throws IOException;
    
    void readConnectionHeader() throws IOException;
    
    public interface Handler
    {
        void data(boolean p0, int p1, InputStream p2, int p3) throws IOException;
        
        void goAway(int p0, ErrorCode p1);
        
        void headers(boolean p0, boolean p1, int p2, int p3, int p4, List<String> p5, HeadersMode p6);
        
        void noop();
        
        void ping(boolean p0, int p1, int p2);
        
        void priority(int p0, int p1);
        
        void rstStream(int p0, ErrorCode p1);
        
        void settings(boolean p0, Settings p1);
        
        void windowUpdate(int p0, int p1, boolean p2);
    }
}
