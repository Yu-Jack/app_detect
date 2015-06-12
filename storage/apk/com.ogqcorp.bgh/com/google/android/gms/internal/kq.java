// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.io.IOException;

public class kq extends IOException
{
    kq(final int i, final int j) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + j + ").");
    }
}
