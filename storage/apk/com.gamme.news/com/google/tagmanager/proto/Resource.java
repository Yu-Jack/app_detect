// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager.proto;

import java.util.ArrayList;
import com.google.tagmanager.protobuf.nano.UnknownFieldData;
import java.util.List;
import com.google.tagmanager.protobuf.nano.WireFormatNano;
import com.google.tagmanager.protobuf.nano.CodedOutputByteBufferNano;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;
import java.io.IOException;
import com.google.tagmanager.protobuf.nano.CodedInputByteBufferNano;
import com.google.analytics.containertag.proto.Serving;
import com.google.tagmanager.protobuf.nano.ExtendableMessageNano;

public interface Resource
{
    public static final class ResourceWithMetadata extends ExtendableMessageNano
    {
        public static final ResourceWithMetadata[] EMPTY_ARRAY;
        public Serving.Resource resource;
        public Serving.SupplementedResource supplementedResource;
        public long timeStamp;
        
        static {
            EMPTY_ARRAY = new ResourceWithMetadata[0];
        }
        
        public ResourceWithMetadata() {
            this.timeStamp = 0L;
            this.resource = null;
            this.supplementedResource = null;
        }
        
        public static ResourceWithMetadata parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new ResourceWithMetadata().mergeFrom(codedInputByteBufferNano);
        }
        
        public static ResourceWithMetadata parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new ResourceWithMetadata(), array);
        }
        
        public final ResourceWithMetadata clear() {
            this.timeStamp = 0L;
            this.resource = null;
            this.supplementedResource = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            ResourceWithMetadata resourceWithMetadata;
            if (o != this) {
                if (!(o instanceof ResourceWithMetadata)) {
                    return false;
                }
                resourceWithMetadata = (ResourceWithMetadata)o;
                if (this.timeStamp == resourceWithMetadata.timeStamp) {
                    if (this.resource == null) {
                        if (resourceWithMetadata.resource != null) {
                            return false;
                        }
                    }
                    else if (!this.resource.equals(resourceWithMetadata.resource)) {
                        return false;
                    }
                    if (this.supplementedResource == null) {
                        if (resourceWithMetadata.supplementedResource != null) {
                            return false;
                        }
                    }
                    else if (!this.supplementedResource.equals(resourceWithMetadata.supplementedResource)) {
                        return false;
                    }
                    if (this.unknownFieldData == null) {
                        if (resourceWithMetadata.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(resourceWithMetadata.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            int n;
            n = 0 + CodedOutputByteBufferNano.computeInt64Size(1, this.timeStamp);
            if (this.resource != null) {
                n += CodedOutputByteBufferNano.computeMessageSize(2, this.resource);
            }
            if (this.supplementedResource != null) {
                n += CodedOutputByteBufferNano.computeMessageSize(3, this.supplementedResource);
            }
            return this.cachedSize = n + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int n;
            int hashCode;
            int n2;
            int hashCode2;
            int n3;
            List<UnknownFieldData> unknownFieldData;
            int hashCode3;
            n = 31 * (527 + (int)(this.timeStamp ^ this.timeStamp >>> 32));
            if (this.resource == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.resource.hashCode();
            }
            n2 = 31 * (n + hashCode);
            if (this.supplementedResource == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = this.supplementedResource.hashCode();
            }
            n3 = 31 * (n2 + hashCode2);
            unknownFieldData = this.unknownFieldData;
            hashCode3 = 0;
            if (unknownFieldData != null) {
                hashCode3 = this.unknownFieldData.hashCode();
            }
            return n3 + hashCode3;
        }
        
        @Override
        public ResourceWithMetadata mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
        Label_0078:
            while (true) {
                tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    default: {
                        if (this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList<UnknownFieldData>();
                        }
                        if (!WireFormatNano.storeUnknownField(this.unknownFieldData, codedInputByteBufferNano, tag)) {
                            break Label_0078;
                        }
                        continue;
                    }
                    case 0: {
                        break Label_0078;
                    }
                    case 8: {
                        this.timeStamp = codedInputByteBufferNano.readInt64();
                        continue;
                    }
                    case 18: {
                        codedInputByteBufferNano.readMessage(this.resource = new Serving.Resource());
                        continue;
                    }
                    case 26: {
                        codedInputByteBufferNano.readMessage(this.supplementedResource = new Serving.SupplementedResource());
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            codedOutputByteBufferNano.writeInt64(1, this.timeStamp);
            if (this.resource != null) {
                codedOutputByteBufferNano.writeMessage(2, this.resource);
            }
            if (this.supplementedResource != null) {
                codedOutputByteBufferNano.writeMessage(3, this.supplementedResource);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
}
