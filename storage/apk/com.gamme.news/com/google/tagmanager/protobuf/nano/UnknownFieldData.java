// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager.protobuf.nano;

import java.util.Arrays;

public final class UnknownFieldData
{
    final byte[] bytes;
    final int tag;
    
    UnknownFieldData(final int tag, final byte[] bytes) {
        this.tag = tag;
        this.bytes = bytes;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof UnknownFieldData)) {
                return false;
            }
            final UnknownFieldData unknownFieldData = (UnknownFieldData)o;
            if (this.tag != unknownFieldData.tag || !Arrays.equals(this.bytes, unknownFieldData.bytes)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int n = 527 + this.tag;
        for (int i = 0; i < this.bytes.length; ++i) {
            n = n * 31 + this.bytes[i];
        }
        return n;
    }
}
