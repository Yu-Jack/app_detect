// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.spdy;

import java.util.List;
import java.io.IOException;
import java.io.Closeable;

public interface FrameWriter extends Closeable
{
    void connectionHeader() throws IOException;
    
    void data(boolean p0, int p1, byte[] p2) throws IOException;
    
    void data(boolean p0, int p1, byte[] p2, int p3, int p4) throws IOException;
    
    void flush() throws IOException;
    
    void goAway(int p0, ErrorCode p1) throws IOException;
    
    void headers(int p0, List<String> p1) throws IOException;
    
    void noop() throws IOException;
    
    void ping(boolean p0, int p1, int p2) throws IOException;
    
    void rstStream(int p0, ErrorCode p1) throws IOException;
    
    void settings(Settings p0) throws IOException;
    
    void synReply(boolean p0, int p1, List<String> p2) throws IOException;
    
    void synStream(boolean p0, boolean p1, int p2, int p3, int p4, int p5, List<String> p6) throws IOException;
    
    void windowUpdate(int p0, int p1) throws IOException;
}
