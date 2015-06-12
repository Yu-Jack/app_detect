// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager.protobuf.nano;

import java.util.ArrayList;
import java.util.List;

public abstract class ExtendableMessageNano extends MessageNano
{
    protected List<UnknownFieldData> unknownFieldData;
    
    public <T> T getExtension(final Extension<T> extension) {
        return WireFormatNano.getExtension(extension, this.unknownFieldData);
    }
    
    @Override
    public int getSerializedSize() {
        return this.cachedSize = WireFormatNano.computeWireSize(this.unknownFieldData);
    }
    
    public <T> void setExtension(final Extension<T> extension, final T t) {
        if (this.unknownFieldData == null) {
            this.unknownFieldData = new ArrayList<UnknownFieldData>();
        }
        WireFormatNano.setExtension(extension, t, this.unknownFieldData);
    }
}
