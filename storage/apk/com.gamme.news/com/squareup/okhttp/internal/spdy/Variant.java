// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.spdy;

import java.io.OutputStream;
import java.io.InputStream;

interface Variant
{
    public static final Variant HTTP_20_DRAFT_06 = new Http20Draft06();
    public static final Variant SPDY3 = new Spdy3();
    
    FrameReader newReader(InputStream p0, boolean p1);
    
    FrameWriter newWriter(OutputStream p0, boolean p1);
}
