// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.nano.Extension;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Arrays;
import java.util.List;
import com.google.tagmanager.protobuf.nano.UnknownFieldData;
import java.util.ArrayList;
import com.google.tagmanager.protobuf.nano.WireFormatNano;
import com.google.tagmanager.protobuf.nano.CodedOutputByteBufferNano;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;
import java.io.IOException;
import com.google.tagmanager.protobuf.nano.CodedInputByteBufferNano;
import com.google.tagmanager.protobuf.nano.ExtendableMessageNano;

public interface Serving
{
    public static final class CacheOption extends ExtendableMessageNano
    {
        public static final CacheOption[] EMPTY_ARRAY;
        public int expirationSeconds;
        public int gcacheExpirationSeconds;
        public int level;
        
        static {
            EMPTY_ARRAY = new CacheOption[0];
        }
        
        public CacheOption() {
            this.level = 1;
            this.expirationSeconds = 0;
            this.gcacheExpirationSeconds = 0;
        }
        
        public static CacheOption parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new CacheOption().mergeFrom(codedInputByteBufferNano);
        }
        
        public static CacheOption parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new CacheOption(), array);
        }
        
        public final CacheOption clear() {
            this.level = 1;
            this.expirationSeconds = 0;
            this.gcacheExpirationSeconds = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            CacheOption cacheOption;
            if (o != this) {
                if (!(o instanceof CacheOption)) {
                    return false;
                }
                cacheOption = (CacheOption)o;
                if (this.level == cacheOption.level && this.expirationSeconds == cacheOption.expirationSeconds && this.gcacheExpirationSeconds == cacheOption.gcacheExpirationSeconds) {
                    if (this.unknownFieldData == null) {
                        if (cacheOption.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(cacheOption.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            int level;
            int n;
            level = this.level;
            n = 0;
            if (level != 1) {
                n = 0 + CodedOutputByteBufferNano.computeInt32Size(1, this.level);
            }
            if (this.expirationSeconds != 0) {
                n += CodedOutputByteBufferNano.computeInt32Size(2, this.expirationSeconds);
            }
            if (this.gcacheExpirationSeconds != 0) {
                n += CodedOutputByteBufferNano.computeInt32Size(3, this.gcacheExpirationSeconds);
            }
            return this.cachedSize = n + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int n;
            int hashCode;
            n = 31 * (31 * (31 * (527 + this.level) + this.expirationSeconds) + this.gcacheExpirationSeconds);
            if (this.unknownFieldData == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.unknownFieldData.hashCode();
            }
            return n + hashCode;
        }
        
        @Override
        public CacheOption mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int int32;
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
                        int32 = codedInputByteBufferNano.readInt32();
                        if (int32 == 1 || int32 == 2 || int32 == 3) {
                            this.level = int32;
                            continue;
                        }
                        this.level = 1;
                        continue;
                    }
                    case 16: {
                        this.expirationSeconds = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 24: {
                        this.gcacheExpirationSeconds = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (this.level != 1) {
                codedOutputByteBufferNano.writeInt32(1, this.level);
            }
            if (this.expirationSeconds != 0) {
                codedOutputByteBufferNano.writeInt32(2, this.expirationSeconds);
            }
            if (this.gcacheExpirationSeconds != 0) {
                codedOutputByteBufferNano.writeInt32(3, this.gcacheExpirationSeconds);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
        
        public interface CacheLevel
        {
            public static final int NO_CACHE = 1;
            public static final int PRIVATE = 2;
            public static final int PUBLIC = 3;
        }
    }
    
    public static final class Container extends ExtendableMessageNano
    {
        public static final Container[] EMPTY_ARRAY;
        public String containerId;
        public Resource jsResource;
        public int state;
        public String version;
        
        static {
            EMPTY_ARRAY = new Container[0];
        }
        
        public Container() {
            this.jsResource = null;
            this.containerId = "";
            this.state = 1;
            this.version = "";
        }
        
        public static Container parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new Container().mergeFrom(codedInputByteBufferNano);
        }
        
        public static Container parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new Container(), array);
        }
        
        public final Container clear() {
            this.jsResource = null;
            this.containerId = "";
            this.state = 1;
            this.version = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            Container container;
            if (o != this) {
                if (!(o instanceof Container)) {
                    return false;
                }
                container = (Container)o;
                if (this.jsResource == null) {
                    if (container.jsResource != null) {
                        return false;
                    }
                }
                else if (!this.jsResource.equals(container.jsResource)) {
                    return false;
                }
                if (this.containerId == null) {
                    if (container.containerId != null) {
                        return false;
                    }
                }
                else if (!this.containerId.equals(container.containerId)) {
                    return false;
                }
                if (this.state == container.state) {
                    if (this.version == null) {
                        if (container.version != null) {
                            return false;
                        }
                    }
                    else if (!this.version.equals(container.version)) {
                        return false;
                    }
                    if (this.unknownFieldData == null) {
                        if (container.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(container.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            Resource jsResource;
            int n;
            int n2;
            jsResource = this.jsResource;
            n = 0;
            if (jsResource != null) {
                n = 0 + CodedOutputByteBufferNano.computeMessageSize(1, this.jsResource);
            }
            n2 = n + CodedOutputByteBufferNano.computeStringSize(3, this.containerId) + CodedOutputByteBufferNano.computeInt32Size(4, this.state);
            if (!this.version.equals("")) {
                n2 += CodedOutputByteBufferNano.computeStringSize(5, this.version);
            }
            return this.cachedSize = n2 + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int hashCode;
            int n;
            int hashCode2;
            int n2;
            int hashCode3;
            int n3;
            List<UnknownFieldData> unknownFieldData;
            int hashCode4;
            if (this.jsResource == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.jsResource.hashCode();
            }
            n = 31 * (hashCode + 527);
            if (this.containerId == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = this.containerId.hashCode();
            }
            n2 = 31 * (31 * (n + hashCode2) + this.state);
            if (this.version == null) {
                hashCode3 = 0;
            }
            else {
                hashCode3 = this.version.hashCode();
            }
            n3 = 31 * (n2 + hashCode3);
            unknownFieldData = this.unknownFieldData;
            hashCode4 = 0;
            if (unknownFieldData != null) {
                hashCode4 = this.unknownFieldData.hashCode();
            }
            return n3 + hashCode4;
        }
        
        @Override
        public Container mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int int32;
        Label_0086:
            while (true) {
                tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    default: {
                        if (this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList<UnknownFieldData>();
                        }
                        if (!WireFormatNano.storeUnknownField(this.unknownFieldData, codedInputByteBufferNano, tag)) {
                            break Label_0086;
                        }
                        continue;
                    }
                    case 0: {
                        break Label_0086;
                    }
                    case 10: {
                        codedInputByteBufferNano.readMessage(this.jsResource = new Resource());
                        continue;
                    }
                    case 26: {
                        this.containerId = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 32: {
                        int32 = codedInputByteBufferNano.readInt32();
                        if (int32 == 1 || int32 == 2) {
                            this.state = int32;
                            continue;
                        }
                        this.state = 1;
                        continue;
                    }
                    case 42: {
                        this.version = codedInputByteBufferNano.readString();
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (this.jsResource != null) {
                codedOutputByteBufferNano.writeMessage(1, this.jsResource);
            }
            codedOutputByteBufferNano.writeString(3, this.containerId);
            codedOutputByteBufferNano.writeInt32(4, this.state);
            if (!this.version.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.version);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public static final class FunctionCall extends ExtendableMessageNano
    {
        public static final FunctionCall[] EMPTY_ARRAY;
        public int function;
        public boolean liveOnly;
        public int name;
        public int[] property;
        public boolean serverSide;
        
        static {
            EMPTY_ARRAY = new FunctionCall[0];
        }
        
        public FunctionCall() {
            this.property = WireFormatNano.EMPTY_INT_ARRAY;
            this.function = 0;
            this.name = 0;
            this.liveOnly = false;
            this.serverSide = false;
        }
        
        public static FunctionCall parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new FunctionCall().mergeFrom(codedInputByteBufferNano);
        }
        
        public static FunctionCall parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new FunctionCall(), array);
        }
        
        public final FunctionCall clear() {
            this.property = WireFormatNano.EMPTY_INT_ARRAY;
            this.function = 0;
            this.name = 0;
            this.liveOnly = false;
            this.serverSide = false;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            FunctionCall functionCall;
            if (o != this) {
                if (!(o instanceof FunctionCall)) {
                    return false;
                }
                functionCall = (FunctionCall)o;
                if (Arrays.equals(this.property, functionCall.property) && this.function == functionCall.function && this.name == functionCall.name && this.liveOnly == functionCall.liveOnly && this.serverSide == functionCall.serverSide) {
                    if (this.unknownFieldData == null) {
                        if (functionCall.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(functionCall.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            boolean serverSide;
            int n;
            int n2;
            int n3;
            int[] property;
            int length;
            int i;
            serverSide = this.serverSide;
            n = 0;
            if (serverSide) {
                n = 0 + CodedOutputByteBufferNano.computeBoolSize(1, this.serverSide);
            }
            n2 = n + CodedOutputByteBufferNano.computeInt32Size(2, this.function);
            if (this.property != null && this.property.length > 0) {
                n3 = 0;
                property = this.property;
                for (int length = property.length, i = 0; i < length; ++i) {
                    n3 += CodedOutputByteBufferNano.computeInt32SizeNoTag(property[i]);
                }
                n2 = n2 + n3 + 1 * this.property.length;
            }
            if (this.name != 0) {
                n2 += CodedOutputByteBufferNano.computeInt32Size(4, this.name);
            }
            if (this.liveOnly) {
                n2 += CodedOutputByteBufferNano.computeBoolSize(6, this.liveOnly);
            }
            return this.cachedSize = n2 + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int n;
            int n2;
            int i;
            int n3;
            int n4;
            int n5;
            int n6;
            int hashCode;
            n = 1;
            n2 = 17;
            if (this.property == null) {
                n2 *= 31;
            }
            else {
                for (int i = 0; i < this.property.length; ++i) {
                    n2 = n2 * 31 + this.property[i];
                }
            }
            n3 = 31 * (31 * (n2 * 31 + this.function) + this.name);
            if (this.liveOnly) {
                n4 = n;
            }
            else {
                n4 = 2;
            }
            n5 = 31 * (n3 + n4);
            if (!this.serverSide) {
                n = 2;
            }
            n6 = 31 * (n5 + n);
            if (this.unknownFieldData == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.unknownFieldData.hashCode();
            }
            return n6 + hashCode;
        }
        
        @Override
        public FunctionCall mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int repeatedFieldArrayLength;
            int i;
            int[] property;
        Label_0094:
            while (true) {
                tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    default: {
                        if (this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList<UnknownFieldData>();
                        }
                        if (!WireFormatNano.storeUnknownField(this.unknownFieldData, codedInputByteBufferNano, tag)) {
                            break Label_0094;
                        }
                        continue;
                    }
                    case 0: {
                        break Label_0094;
                    }
                    case 8: {
                        this.serverSide = codedInputByteBufferNano.readBool();
                        continue;
                    }
                    case 16: {
                        this.function = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 24: {
                        repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                        i = this.property.length;
                        property = new int[i + repeatedFieldArrayLength];
                        System.arraycopy(this.property, 0, property, 0, i);
                        this.property = property;
                        while (i < -1 + this.property.length) {
                            this.property[i] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++i;
                        }
                        this.property[i] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 32: {
                        this.name = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 48: {
                        this.liveOnly = codedInputByteBufferNano.readBool();
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            int[] property;
            int length;
            int i;
            if (this.serverSide) {
                codedOutputByteBufferNano.writeBool(1, this.serverSide);
            }
            codedOutputByteBufferNano.writeInt32(2, this.function);
            if (this.property != null) {
                property = this.property;
                for (int length = property.length, i = 0; i < length; ++i) {
                    codedOutputByteBufferNano.writeInt32(3, property[i]);
                }
            }
            if (this.name != 0) {
                codedOutputByteBufferNano.writeInt32(4, this.name);
            }
            if (this.liveOnly) {
                codedOutputByteBufferNano.writeBool(6, this.liveOnly);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public static final class GaExperimentRandom extends ExtendableMessageNano
    {
        public static final GaExperimentRandom[] EMPTY_ARRAY;
        public String key;
        public long lifetimeInMilliseconds;
        public long maxRandom;
        public long minRandom;
        public boolean retainOriginalValue;
        
        static {
            EMPTY_ARRAY = new GaExperimentRandom[0];
        }
        
        public GaExperimentRandom() {
            this.key = "";
            this.minRandom = 0L;
            this.maxRandom = 2147483647L;
            this.retainOriginalValue = false;
            this.lifetimeInMilliseconds = 0L;
        }
        
        public static GaExperimentRandom parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new GaExperimentRandom().mergeFrom(codedInputByteBufferNano);
        }
        
        public static GaExperimentRandom parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new GaExperimentRandom(), array);
        }
        
        public final GaExperimentRandom clear() {
            this.key = "";
            this.minRandom = 0L;
            this.maxRandom = 2147483647L;
            this.retainOriginalValue = false;
            this.lifetimeInMilliseconds = 0L;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            GaExperimentRandom gaExperimentRandom;
            if (o != this) {
                if (!(o instanceof GaExperimentRandom)) {
                    return false;
                }
                gaExperimentRandom = (GaExperimentRandom)o;
                if (this.key == null) {
                    if (gaExperimentRandom.key != null) {
                        return false;
                    }
                }
                else if (!this.key.equals(gaExperimentRandom.key)) {
                    return false;
                }
                if (this.minRandom == gaExperimentRandom.minRandom && this.maxRandom == gaExperimentRandom.maxRandom && this.retainOriginalValue == gaExperimentRandom.retainOriginalValue && this.lifetimeInMilliseconds == gaExperimentRandom.lifetimeInMilliseconds) {
                    if (this.unknownFieldData == null) {
                        if (gaExperimentRandom.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(gaExperimentRandom.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            boolean equals;
            int n;
            equals = this.key.equals("");
            n = 0;
            if (!equals) {
                n = 0 + CodedOutputByteBufferNano.computeStringSize(1, this.key);
            }
            if (this.minRandom != 0L) {
                n += CodedOutputByteBufferNano.computeInt64Size(2, this.minRandom);
            }
            if (this.maxRandom != 2147483647L) {
                n += CodedOutputByteBufferNano.computeInt64Size(3, this.maxRandom);
            }
            if (this.retainOriginalValue) {
                n += CodedOutputByteBufferNano.computeBoolSize(4, this.retainOriginalValue);
            }
            if (this.lifetimeInMilliseconds != 0L) {
                n += CodedOutputByteBufferNano.computeInt64Size(5, this.lifetimeInMilliseconds);
            }
            return this.cachedSize = n + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int hashCode;
            int n;
            int n2;
            int n3;
            List<UnknownFieldData> unknownFieldData;
            int hashCode2;
            if (this.key == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.key.hashCode();
            }
            n = 31 * (31 * (31 * (hashCode + 527) + (int)(this.minRandom ^ this.minRandom >>> 32)) + (int)(this.maxRandom ^ this.maxRandom >>> 32));
            if (this.retainOriginalValue) {
                n2 = 1;
            }
            else {
                n2 = 2;
            }
            n3 = 31 * (31 * (n + n2) + (int)(this.lifetimeInMilliseconds ^ this.lifetimeInMilliseconds >>> 32));
            unknownFieldData = this.unknownFieldData;
            hashCode2 = 0;
            if (unknownFieldData != null) {
                hashCode2 = this.unknownFieldData.hashCode();
            }
            return n3 + hashCode2;
        }
        
        @Override
        public GaExperimentRandom mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
        Label_0094:
            while (true) {
                tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    default: {
                        if (this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList<UnknownFieldData>();
                        }
                        if (!WireFormatNano.storeUnknownField(this.unknownFieldData, codedInputByteBufferNano, tag)) {
                            break Label_0094;
                        }
                        continue;
                    }
                    case 0: {
                        break Label_0094;
                    }
                    case 10: {
                        this.key = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 16: {
                        this.minRandom = codedInputByteBufferNano.readInt64();
                        continue;
                    }
                    case 24: {
                        this.maxRandom = codedInputByteBufferNano.readInt64();
                        continue;
                    }
                    case 32: {
                        this.retainOriginalValue = codedInputByteBufferNano.readBool();
                        continue;
                    }
                    case 40: {
                        this.lifetimeInMilliseconds = codedInputByteBufferNano.readInt64();
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.key.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.key);
            }
            if (this.minRandom != 0L) {
                codedOutputByteBufferNano.writeInt64(2, this.minRandom);
            }
            if (this.maxRandom != 2147483647L) {
                codedOutputByteBufferNano.writeInt64(3, this.maxRandom);
            }
            if (this.retainOriginalValue) {
                codedOutputByteBufferNano.writeBool(4, this.retainOriginalValue);
            }
            if (this.lifetimeInMilliseconds != 0L) {
                codedOutputByteBufferNano.writeInt64(5, this.lifetimeInMilliseconds);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public static final class GaExperimentSupplemental extends ExtendableMessageNano
    {
        public static final GaExperimentSupplemental[] EMPTY_ARRAY;
        public GaExperimentRandom[] experimentRandom;
        public TypeSystem.Value[] valueToClear;
        public TypeSystem.Value[] valueToPush;
        
        static {
            EMPTY_ARRAY = new GaExperimentSupplemental[0];
        }
        
        public GaExperimentSupplemental() {
            this.valueToPush = TypeSystem.Value.EMPTY_ARRAY;
            this.valueToClear = TypeSystem.Value.EMPTY_ARRAY;
            this.experimentRandom = GaExperimentRandom.EMPTY_ARRAY;
        }
        
        public static GaExperimentSupplemental parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new GaExperimentSupplemental().mergeFrom(codedInputByteBufferNano);
        }
        
        public static GaExperimentSupplemental parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new GaExperimentSupplemental(), array);
        }
        
        public final GaExperimentSupplemental clear() {
            this.valueToPush = TypeSystem.Value.EMPTY_ARRAY;
            this.valueToClear = TypeSystem.Value.EMPTY_ARRAY;
            this.experimentRandom = GaExperimentRandom.EMPTY_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            GaExperimentSupplemental gaExperimentSupplemental;
            if (o != this) {
                if (!(o instanceof GaExperimentSupplemental)) {
                    return false;
                }
                gaExperimentSupplemental = (GaExperimentSupplemental)o;
                if (Arrays.equals(this.valueToPush, gaExperimentSupplemental.valueToPush) && Arrays.equals(this.valueToClear, gaExperimentSupplemental.valueToClear) && Arrays.equals(this.experimentRandom, gaExperimentSupplemental.experimentRandom)) {
                    if (this.unknownFieldData == null) {
                        if (gaExperimentSupplemental.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(gaExperimentSupplemental.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            TypeSystem.Value[] valueToPush;
            int n;
            TypeSystem.Value[] valueToPush2;
            int length;
            int i;
            TypeSystem.Value[] valueToClear;
            int length2;
            int j;
            GaExperimentRandom[] experimentRandom;
            int length3;
            int k;
            valueToPush = this.valueToPush;
            n = 0;
            if (valueToPush != null) {
                valueToPush2 = this.valueToPush;
                for (int length = valueToPush2.length, i = 0; i < length; ++i) {
                    n += CodedOutputByteBufferNano.computeMessageSize(1, valueToPush2[i]);
                }
            }
            if (this.valueToClear != null) {
                valueToClear = this.valueToClear;
                for (int length2 = valueToClear.length, j = 0; j < length2; ++j) {
                    n += CodedOutputByteBufferNano.computeMessageSize(2, valueToClear[j]);
                }
            }
            if (this.experimentRandom != null) {
                experimentRandom = this.experimentRandom;
                for (int length3 = experimentRandom.length, k = 0; k < length3; ++k) {
                    n += CodedOutputByteBufferNano.computeMessageSize(3, experimentRandom[k]);
                }
            }
            return this.cachedSize = n + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int n;
            int i;
            int n2;
            int hashCode;
            int j;
            int n3;
            int hashCode2;
            int k;
            int n4;
            int hashCode3;
            int n5;
            List<UnknownFieldData> unknownFieldData;
            int hashCode4;
            n = 17;
            if (this.valueToPush == null) {
                n *= 31;
            }
            else {
                for (int i = 0; i < this.valueToPush.length; ++i) {
                    n2 = n * 31;
                    if (this.valueToPush[i] == null) {
                        hashCode = 0;
                    }
                    else {
                        hashCode = this.valueToPush[i].hashCode();
                    }
                    n = n2 + hashCode;
                }
            }
            if (this.valueToClear == null) {
                n *= 31;
            }
            else {
                for (int j = 0; j < this.valueToClear.length; ++j) {
                    n3 = n * 31;
                    if (this.valueToClear[j] == null) {
                        hashCode2 = 0;
                    }
                    else {
                        hashCode2 = this.valueToClear[j].hashCode();
                    }
                    n = n3 + hashCode2;
                }
            }
            if (this.experimentRandom == null) {
                n *= 31;
            }
            else {
                for (int k = 0; k < this.experimentRandom.length; ++k) {
                    n4 = n * 31;
                    if (this.experimentRandom[k] == null) {
                        hashCode3 = 0;
                    }
                    else {
                        hashCode3 = this.experimentRandom[k].hashCode();
                    }
                    n = n4 + hashCode3;
                }
            }
            n5 = n * 31;
            unknownFieldData = this.unknownFieldData;
            hashCode4 = 0;
            if (unknownFieldData != null) {
                hashCode4 = this.unknownFieldData.hashCode();
            }
            return n5 + hashCode4;
        }
        
        @Override
        public GaExperimentSupplemental mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int repeatedFieldArrayLength;
            int i;
            TypeSystem.Value[] valueToPush;
            int repeatedFieldArrayLength2;
            int j;
            TypeSystem.Value[] valueToClear;
            int repeatedFieldArrayLength3;
            int k;
            GaExperimentRandom[] experimentRandom;
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
                    case 10: {
                        repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        if (this.valueToPush == null) {
                            i = 0;
                        }
                        else {
                            i = this.valueToPush.length;
                        }
                        valueToPush = new TypeSystem.Value[i + repeatedFieldArrayLength];
                        if (this.valueToPush != null) {
                            System.arraycopy(this.valueToPush, 0, valueToPush, 0, i);
                        }
                        this.valueToPush = valueToPush;
                        while (i < -1 + this.valueToPush.length) {
                            codedInputByteBufferNano.readMessage(this.valueToPush[i] = new TypeSystem.Value());
                            codedInputByteBufferNano.readTag();
                            ++i;
                        }
                        codedInputByteBufferNano.readMessage(this.valueToPush[i] = new TypeSystem.Value());
                        continue;
                    }
                    case 18: {
                        repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        if (this.valueToClear == null) {
                            j = 0;
                        }
                        else {
                            j = this.valueToClear.length;
                        }
                        valueToClear = new TypeSystem.Value[j + repeatedFieldArrayLength2];
                        if (this.valueToClear != null) {
                            System.arraycopy(this.valueToClear, 0, valueToClear, 0, j);
                        }
                        this.valueToClear = valueToClear;
                        while (j < -1 + this.valueToClear.length) {
                            codedInputByteBufferNano.readMessage(this.valueToClear[j] = new TypeSystem.Value());
                            codedInputByteBufferNano.readTag();
                            ++j;
                        }
                        codedInputByteBufferNano.readMessage(this.valueToClear[j] = new TypeSystem.Value());
                        continue;
                    }
                    case 26: {
                        repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        if (this.experimentRandom == null) {
                            k = 0;
                        }
                        else {
                            k = this.experimentRandom.length;
                        }
                        experimentRandom = new GaExperimentRandom[k + repeatedFieldArrayLength3];
                        if (this.experimentRandom != null) {
                            System.arraycopy(this.experimentRandom, 0, experimentRandom, 0, k);
                        }
                        this.experimentRandom = experimentRandom;
                        while (k < -1 + this.experimentRandom.length) {
                            codedInputByteBufferNano.readMessage(this.experimentRandom[k] = new GaExperimentRandom());
                            codedInputByteBufferNano.readTag();
                            ++k;
                        }
                        codedInputByteBufferNano.readMessage(this.experimentRandom[k] = new GaExperimentRandom());
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            TypeSystem.Value[] valueToPush;
            int length;
            int i;
            TypeSystem.Value[] valueToClear;
            int length2;
            int j;
            GaExperimentRandom[] experimentRandom;
            int length3;
            int k;
            if (this.valueToPush != null) {
                valueToPush = this.valueToPush;
                for (int length = valueToPush.length, i = 0; i < length; ++i) {
                    codedOutputByteBufferNano.writeMessage(1, valueToPush[i]);
                }
            }
            if (this.valueToClear != null) {
                valueToClear = this.valueToClear;
                for (int length2 = valueToClear.length, j = 0; j < length2; ++j) {
                    codedOutputByteBufferNano.writeMessage(2, valueToClear[j]);
                }
            }
            if (this.experimentRandom != null) {
                experimentRandom = this.experimentRandom;
                for (int length3 = experimentRandom.length, k = 0; k < length3; ++k) {
                    codedOutputByteBufferNano.writeMessage(3, experimentRandom[k]);
                }
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public static final class Property extends ExtendableMessageNano
    {
        public static final Property[] EMPTY_ARRAY;
        public int key;
        public int value;
        
        static {
            EMPTY_ARRAY = new Property[0];
        }
        
        public Property() {
            this.key = 0;
            this.value = 0;
        }
        
        public static Property parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new Property().mergeFrom(codedInputByteBufferNano);
        }
        
        public static Property parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new Property(), array);
        }
        
        public final Property clear() {
            this.key = 0;
            this.value = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            Property property;
            if (o != this) {
                if (!(o instanceof Property)) {
                    return false;
                }
                property = (Property)o;
                if (this.key == property.key && this.value == property.value) {
                    if (this.unknownFieldData == null) {
                        if (property.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(property.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            return this.cachedSize = 0 + CodedOutputByteBufferNano.computeInt32Size(1, this.key) + CodedOutputByteBufferNano.computeInt32Size(2, this.value) + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int n;
            int hashCode;
            n = 31 * (31 * (527 + this.key) + this.value);
            if (this.unknownFieldData == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.unknownFieldData.hashCode();
            }
            return n + hashCode;
        }
        
        @Override
        public Property mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
        Label_0070:
            while (true) {
                tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    default: {
                        if (this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList<UnknownFieldData>();
                        }
                        if (!WireFormatNano.storeUnknownField(this.unknownFieldData, codedInputByteBufferNano, tag)) {
                            break Label_0070;
                        }
                        continue;
                    }
                    case 0: {
                        break Label_0070;
                    }
                    case 8: {
                        this.key = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 16: {
                        this.value = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            codedOutputByteBufferNano.writeInt32(1, this.key);
            codedOutputByteBufferNano.writeInt32(2, this.value);
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public static final class Resource extends ExtendableMessageNano
    {
        public static final Resource[] EMPTY_ARRAY;
        private static final String TEMPLATE_VERSION_SET_DEFAULT = "0";
        public String[] key;
        public CacheOption liveJsCacheOption;
        public FunctionCall[] macro;
        public String malwareScanAuthCode;
        public boolean oBSOLETEEnableAutoEventTracking;
        public FunctionCall[] predicate;
        public String previewAuthCode;
        public Property[] property;
        public float reportingSampleRate;
        public int resourceFormatVersion;
        public Rule[] rule;
        public String[] supplemental;
        public FunctionCall[] tag;
        public String templateVersionSet;
        public String[] usageContext;
        public TypeSystem.Value[] value;
        public String version;
        
        static {
            EMPTY_ARRAY = new Resource[0];
        }
        
        public Resource() {
            this.supplemental = WireFormatNano.EMPTY_STRING_ARRAY;
            this.key = WireFormatNano.EMPTY_STRING_ARRAY;
            this.value = TypeSystem.Value.EMPTY_ARRAY;
            this.property = Property.EMPTY_ARRAY;
            this.macro = FunctionCall.EMPTY_ARRAY;
            this.tag = FunctionCall.EMPTY_ARRAY;
            this.predicate = FunctionCall.EMPTY_ARRAY;
            this.rule = Rule.EMPTY_ARRAY;
            this.previewAuthCode = "";
            this.malwareScanAuthCode = "";
            this.templateVersionSet = "0";
            this.version = "";
            this.liveJsCacheOption = null;
            this.reportingSampleRate = 0.0f;
            this.oBSOLETEEnableAutoEventTracking = false;
            this.usageContext = WireFormatNano.EMPTY_STRING_ARRAY;
            this.resourceFormatVersion = 0;
        }
        
        public static Resource parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new Resource().mergeFrom(codedInputByteBufferNano);
        }
        
        public static Resource parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new Resource(), array);
        }
        
        public final Resource clear() {
            this.supplemental = WireFormatNano.EMPTY_STRING_ARRAY;
            this.key = WireFormatNano.EMPTY_STRING_ARRAY;
            this.value = TypeSystem.Value.EMPTY_ARRAY;
            this.property = Property.EMPTY_ARRAY;
            this.macro = FunctionCall.EMPTY_ARRAY;
            this.tag = FunctionCall.EMPTY_ARRAY;
            this.predicate = FunctionCall.EMPTY_ARRAY;
            this.rule = Rule.EMPTY_ARRAY;
            this.previewAuthCode = "";
            this.malwareScanAuthCode = "";
            this.templateVersionSet = "0";
            this.version = "";
            this.liveJsCacheOption = null;
            this.reportingSampleRate = 0.0f;
            this.oBSOLETEEnableAutoEventTracking = false;
            this.usageContext = WireFormatNano.EMPTY_STRING_ARRAY;
            this.resourceFormatVersion = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            Resource resource;
            if (o != this) {
                if (!(o instanceof Resource)) {
                    return false;
                }
                resource = (Resource)o;
                if (Arrays.equals(this.supplemental, resource.supplemental) && Arrays.equals(this.key, resource.key) && Arrays.equals(this.value, resource.value) && Arrays.equals(this.property, resource.property) && Arrays.equals(this.macro, resource.macro) && Arrays.equals(this.tag, resource.tag) && Arrays.equals(this.predicate, resource.predicate) && Arrays.equals(this.rule, resource.rule)) {
                    if (this.previewAuthCode == null) {
                        if (resource.previewAuthCode != null) {
                            return false;
                        }
                    }
                    else if (!this.previewAuthCode.equals(resource.previewAuthCode)) {
                        return false;
                    }
                    if (this.malwareScanAuthCode == null) {
                        if (resource.malwareScanAuthCode != null) {
                            return false;
                        }
                    }
                    else if (!this.malwareScanAuthCode.equals(resource.malwareScanAuthCode)) {
                        return false;
                    }
                    if (this.templateVersionSet == null) {
                        if (resource.templateVersionSet != null) {
                            return false;
                        }
                    }
                    else if (!this.templateVersionSet.equals(resource.templateVersionSet)) {
                        return false;
                    }
                    if (this.version == null) {
                        if (resource.version != null) {
                            return false;
                        }
                    }
                    else if (!this.version.equals(resource.version)) {
                        return false;
                    }
                    if (this.liveJsCacheOption == null) {
                        if (resource.liveJsCacheOption != null) {
                            return false;
                        }
                    }
                    else if (!this.liveJsCacheOption.equals(resource.liveJsCacheOption)) {
                        return false;
                    }
                    if (this.reportingSampleRate == resource.reportingSampleRate && this.oBSOLETEEnableAutoEventTracking == resource.oBSOLETEEnableAutoEventTracking && Arrays.equals(this.usageContext, resource.usageContext) && this.resourceFormatVersion == resource.resourceFormatVersion) {
                        if (this.unknownFieldData == null) {
                            if (resource.unknownFieldData == null) {
                                return true;
                            }
                        }
                        else if (this.unknownFieldData.equals(resource.unknownFieldData)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            String[] key;
            int n;
            int length;
            int n2;
            String[] key2;
            int length2;
            int i;
            TypeSystem.Value[] value;
            int length3;
            int j;
            Property[] property;
            int length4;
            int k;
            FunctionCall[] macro;
            int length5;
            int l;
            FunctionCall[] tag;
            int length6;
            int n3;
            FunctionCall[] predicate;
            int length7;
            int n4;
            Rule[] rule;
            int length8;
            int n5;
            int n6;
            String[] usageContext;
            int length9;
            int n7;
            int n8;
            String[] supplemental;
            int length10;
            int n9;
            key = this.key;
            n = 0;
            if (key != null) {
                length = this.key.length;
                n = 0;
                if (length > 0) {
                    n2 = 0;
                    key2 = this.key;
                    for (int length2 = key2.length, i = 0; i < length2; ++i) {
                        n2 += CodedOutputByteBufferNano.computeStringSizeNoTag(key2[i]);
                    }
                    n = 0 + n2 + 1 * this.key.length;
                }
            }
            if (this.value != null) {
                value = this.value;
                for (int length3 = value.length, j = 0; j < length3; ++j) {
                    n += CodedOutputByteBufferNano.computeMessageSize(2, value[j]);
                }
            }
            if (this.property != null) {
                property = this.property;
                for (int length4 = property.length, k = 0; k < length4; ++k) {
                    n += CodedOutputByteBufferNano.computeMessageSize(3, property[k]);
                }
            }
            if (this.macro != null) {
                macro = this.macro;
                for (int length5 = macro.length, l = 0; l < length5; ++l) {
                    n += CodedOutputByteBufferNano.computeMessageSize(4, macro[l]);
                }
            }
            if (this.tag != null) {
                tag = this.tag;
                for (int length6 = tag.length, n3 = 0; n3 < length6; ++n3) {
                    n += CodedOutputByteBufferNano.computeMessageSize(5, tag[n3]);
                }
            }
            if (this.predicate != null) {
                predicate = this.predicate;
                for (int length7 = predicate.length, n4 = 0; n4 < length7; ++n4) {
                    n += CodedOutputByteBufferNano.computeMessageSize(6, predicate[n4]);
                }
            }
            if (this.rule != null) {
                rule = this.rule;
                for (int length8 = rule.length, n5 = 0; n5 < length8; ++n5) {
                    n += CodedOutputByteBufferNano.computeMessageSize(7, rule[n5]);
                }
            }
            if (!this.previewAuthCode.equals("")) {
                n += CodedOutputByteBufferNano.computeStringSize(9, this.previewAuthCode);
            }
            if (!this.malwareScanAuthCode.equals("")) {
                n += CodedOutputByteBufferNano.computeStringSize(10, this.malwareScanAuthCode);
            }
            if (!this.templateVersionSet.equals("0")) {
                n += CodedOutputByteBufferNano.computeStringSize(12, this.templateVersionSet);
            }
            if (!this.version.equals("")) {
                n += CodedOutputByteBufferNano.computeStringSize(13, this.version);
            }
            if (this.liveJsCacheOption != null) {
                n += CodedOutputByteBufferNano.computeMessageSize(14, this.liveJsCacheOption);
            }
            if (this.reportingSampleRate != 0.0f) {
                n += CodedOutputByteBufferNano.computeFloatSize(15, this.reportingSampleRate);
            }
            if (this.usageContext != null && this.usageContext.length > 0) {
                n6 = 0;
                usageContext = this.usageContext;
                for (int length9 = usageContext.length, n7 = 0; n7 < length9; ++n7) {
                    n6 += CodedOutputByteBufferNano.computeStringSizeNoTag(usageContext[n7]);
                }
                n = n + n6 + 2 * this.usageContext.length;
            }
            if (this.resourceFormatVersion != 0) {
                n += CodedOutputByteBufferNano.computeInt32Size(17, this.resourceFormatVersion);
            }
            if (this.oBSOLETEEnableAutoEventTracking) {
                n += CodedOutputByteBufferNano.computeBoolSize(18, this.oBSOLETEEnableAutoEventTracking);
            }
            if (this.supplemental != null && this.supplemental.length > 0) {
                n8 = 0;
                supplemental = this.supplemental;
                for (int length10 = supplemental.length, n9 = 0; n9 < length10; ++n9) {
                    n8 += CodedOutputByteBufferNano.computeStringSizeNoTag(supplemental[n9]);
                }
                n = n + n8 + 2 * this.supplemental.length;
            }
            return this.cachedSize = n + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int n;
            int i;
            int n2;
            int hashCode;
            int j;
            int n3;
            int hashCode2;
            int k;
            int n4;
            int hashCode3;
            int l;
            int n5;
            int hashCode4;
            int n6;
            int n7;
            int hashCode5;
            int n8;
            int n9;
            int hashCode6;
            int n10;
            int n11;
            int hashCode7;
            int n12;
            int n13;
            int hashCode8;
            int n14;
            int hashCode9;
            int n15;
            int hashCode10;
            int n16;
            int hashCode11;
            int n17;
            int hashCode12;
            int n18;
            int hashCode13;
            int n19;
            int n20;
            int n21;
            int n22;
            int n23;
            int hashCode14;
            int n24;
            List<UnknownFieldData> unknownFieldData;
            int hashCode15;
            n = 17;
            if (this.supplemental == null) {
                n *= 31;
            }
            else {
                for (int i = 0; i < this.supplemental.length; ++i) {
                    n2 = n * 31;
                    if (this.supplemental[i] == null) {
                        hashCode = 0;
                    }
                    else {
                        hashCode = this.supplemental[i].hashCode();
                    }
                    n = n2 + hashCode;
                }
            }
            if (this.key == null) {
                n *= 31;
            }
            else {
                for (int j = 0; j < this.key.length; ++j) {
                    n3 = n * 31;
                    if (this.key[j] == null) {
                        hashCode2 = 0;
                    }
                    else {
                        hashCode2 = this.key[j].hashCode();
                    }
                    n = n3 + hashCode2;
                }
            }
            if (this.value == null) {
                n *= 31;
            }
            else {
                for (int k = 0; k < this.value.length; ++k) {
                    n4 = n * 31;
                    if (this.value[k] == null) {
                        hashCode3 = 0;
                    }
                    else {
                        hashCode3 = this.value[k].hashCode();
                    }
                    n = n4 + hashCode3;
                }
            }
            if (this.property == null) {
                n *= 31;
            }
            else {
                for (int l = 0; l < this.property.length; ++l) {
                    n5 = n * 31;
                    if (this.property[l] == null) {
                        hashCode4 = 0;
                    }
                    else {
                        hashCode4 = this.property[l].hashCode();
                    }
                    n = n5 + hashCode4;
                }
            }
            if (this.macro == null) {
                n *= 31;
            }
            else {
                for (int n6 = 0; n6 < this.macro.length; ++n6) {
                    n7 = n * 31;
                    if (this.macro[n6] == null) {
                        hashCode5 = 0;
                    }
                    else {
                        hashCode5 = this.macro[n6].hashCode();
                    }
                    n = n7 + hashCode5;
                }
            }
            if (this.tag == null) {
                n *= 31;
            }
            else {
                for (int n8 = 0; n8 < this.tag.length; ++n8) {
                    n9 = n * 31;
                    if (this.tag[n8] == null) {
                        hashCode6 = 0;
                    }
                    else {
                        hashCode6 = this.tag[n8].hashCode();
                    }
                    n = n9 + hashCode6;
                }
            }
            if (this.predicate == null) {
                n *= 31;
            }
            else {
                for (int n10 = 0; n10 < this.predicate.length; ++n10) {
                    n11 = n * 31;
                    if (this.predicate[n10] == null) {
                        hashCode7 = 0;
                    }
                    else {
                        hashCode7 = this.predicate[n10].hashCode();
                    }
                    n = n11 + hashCode7;
                }
            }
            if (this.rule == null) {
                n *= 31;
            }
            else {
                for (int n12 = 0; n12 < this.rule.length; ++n12) {
                    n13 = n * 31;
                    if (this.rule[n12] == null) {
                        hashCode8 = 0;
                    }
                    else {
                        hashCode8 = this.rule[n12].hashCode();
                    }
                    n = n13 + hashCode8;
                }
            }
            n14 = n * 31;
            if (this.previewAuthCode == null) {
                hashCode9 = 0;
            }
            else {
                hashCode9 = this.previewAuthCode.hashCode();
            }
            n15 = 31 * (n14 + hashCode9);
            if (this.malwareScanAuthCode == null) {
                hashCode10 = 0;
            }
            else {
                hashCode10 = this.malwareScanAuthCode.hashCode();
            }
            n16 = 31 * (n15 + hashCode10);
            if (this.templateVersionSet == null) {
                hashCode11 = 0;
            }
            else {
                hashCode11 = this.templateVersionSet.hashCode();
            }
            n17 = 31 * (n16 + hashCode11);
            if (this.version == null) {
                hashCode12 = 0;
            }
            else {
                hashCode12 = this.version.hashCode();
            }
            n18 = 31 * (n17 + hashCode12);
            if (this.liveJsCacheOption == null) {
                hashCode13 = 0;
            }
            else {
                hashCode13 = this.liveJsCacheOption.hashCode();
            }
            n19 = 31 * (31 * (n18 + hashCode13) + Float.floatToIntBits(this.reportingSampleRate));
            if (this.oBSOLETEEnableAutoEventTracking) {
                n20 = 1;
            }
            else {
                n20 = 2;
            }
            n21 = n19 + n20;
            if (this.usageContext == null) {
                n21 *= 31;
            }
            else {
                for (int n22 = 0; n22 < this.usageContext.length; ++n22) {
                    n23 = n21 * 31;
                    if (this.usageContext[n22] == null) {
                        hashCode14 = 0;
                    }
                    else {
                        hashCode14 = this.usageContext[n22].hashCode();
                    }
                    n21 = n23 + hashCode14;
                }
            }
            n24 = 31 * (n21 * 31 + this.resourceFormatVersion);
            unknownFieldData = this.unknownFieldData;
            hashCode15 = 0;
            if (unknownFieldData != null) {
                hashCode15 = this.unknownFieldData.hashCode();
            }
            return n24 + hashCode15;
        }
        
        @Override
        public Resource mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int repeatedFieldArrayLength;
            int i;
            String[] key;
            int repeatedFieldArrayLength2;
            int j;
            TypeSystem.Value[] value;
            int repeatedFieldArrayLength3;
            int k;
            Property[] property;
            int repeatedFieldArrayLength4;
            int l;
            FunctionCall[] macro;
            int repeatedFieldArrayLength5;
            int length;
            FunctionCall[] tag2;
            int repeatedFieldArrayLength6;
            int length2;
            FunctionCall[] predicate;
            int repeatedFieldArrayLength7;
            int length3;
            Rule[] rule;
            int repeatedFieldArrayLength8;
            int length4;
            String[] usageContext;
            int repeatedFieldArrayLength9;
            int length5;
            String[] supplemental;
        Label_0190:
            while (true) {
                tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    default: {
                        if (this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList<UnknownFieldData>();
                        }
                        if (!WireFormatNano.storeUnknownField(this.unknownFieldData, codedInputByteBufferNano, tag)) {
                            break Label_0190;
                        }
                        continue;
                    }
                    case 0: {
                        break Label_0190;
                    }
                    case 10: {
                        repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        i = this.key.length;
                        key = new String[i + repeatedFieldArrayLength];
                        System.arraycopy(this.key, 0, key, 0, i);
                        this.key = key;
                        while (i < -1 + this.key.length) {
                            this.key[i] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            ++i;
                        }
                        this.key[i] = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 18: {
                        repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        if (this.value == null) {
                            j = 0;
                        }
                        else {
                            j = this.value.length;
                        }
                        value = new TypeSystem.Value[j + repeatedFieldArrayLength2];
                        if (this.value != null) {
                            System.arraycopy(this.value, 0, value, 0, j);
                        }
                        this.value = value;
                        while (j < -1 + this.value.length) {
                            codedInputByteBufferNano.readMessage(this.value[j] = new TypeSystem.Value());
                            codedInputByteBufferNano.readTag();
                            ++j;
                        }
                        codedInputByteBufferNano.readMessage(this.value[j] = new TypeSystem.Value());
                        continue;
                    }
                    case 26: {
                        repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        if (this.property == null) {
                            k = 0;
                        }
                        else {
                            k = this.property.length;
                        }
                        property = new Property[k + repeatedFieldArrayLength3];
                        if (this.property != null) {
                            System.arraycopy(this.property, 0, property, 0, k);
                        }
                        this.property = property;
                        while (k < -1 + this.property.length) {
                            codedInputByteBufferNano.readMessage(this.property[k] = new Property());
                            codedInputByteBufferNano.readTag();
                            ++k;
                        }
                        codedInputByteBufferNano.readMessage(this.property[k] = new Property());
                        continue;
                    }
                    case 34: {
                        repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        if (this.macro == null) {
                            l = 0;
                        }
                        else {
                            l = this.macro.length;
                        }
                        macro = new FunctionCall[l + repeatedFieldArrayLength4];
                        if (this.macro != null) {
                            System.arraycopy(this.macro, 0, macro, 0, l);
                        }
                        this.macro = macro;
                        while (l < -1 + this.macro.length) {
                            codedInputByteBufferNano.readMessage(this.macro[l] = new FunctionCall());
                            codedInputByteBufferNano.readTag();
                            ++l;
                        }
                        codedInputByteBufferNano.readMessage(this.macro[l] = new FunctionCall());
                        continue;
                    }
                    case 42: {
                        repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        if (this.tag == null) {
                            length = 0;
                        }
                        else {
                            length = this.tag.length;
                        }
                        tag2 = new FunctionCall[length + repeatedFieldArrayLength5];
                        if (this.tag != null) {
                            System.arraycopy(this.tag, 0, tag2, 0, length);
                        }
                        this.tag = tag2;
                        while (length < -1 + this.tag.length) {
                            codedInputByteBufferNano.readMessage(this.tag[length] = new FunctionCall());
                            codedInputByteBufferNano.readTag();
                            ++length;
                        }
                        codedInputByteBufferNano.readMessage(this.tag[length] = new FunctionCall());
                        continue;
                    }
                    case 50: {
                        repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        if (this.predicate == null) {
                            length2 = 0;
                        }
                        else {
                            length2 = this.predicate.length;
                        }
                        predicate = new FunctionCall[length2 + repeatedFieldArrayLength6];
                        if (this.predicate != null) {
                            System.arraycopy(this.predicate, 0, predicate, 0, length2);
                        }
                        this.predicate = predicate;
                        while (length2 < -1 + this.predicate.length) {
                            codedInputByteBufferNano.readMessage(this.predicate[length2] = new FunctionCall());
                            codedInputByteBufferNano.readTag();
                            ++length2;
                        }
                        codedInputByteBufferNano.readMessage(this.predicate[length2] = new FunctionCall());
                        continue;
                    }
                    case 58: {
                        repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                        if (this.rule == null) {
                            length3 = 0;
                        }
                        else {
                            length3 = this.rule.length;
                        }
                        rule = new Rule[length3 + repeatedFieldArrayLength7];
                        if (this.rule != null) {
                            System.arraycopy(this.rule, 0, rule, 0, length3);
                        }
                        this.rule = rule;
                        while (length3 < -1 + this.rule.length) {
                            codedInputByteBufferNano.readMessage(this.rule[length3] = new Rule());
                            codedInputByteBufferNano.readTag();
                            ++length3;
                        }
                        codedInputByteBufferNano.readMessage(this.rule[length3] = new Rule());
                        continue;
                    }
                    case 74: {
                        this.previewAuthCode = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 82: {
                        this.malwareScanAuthCode = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 98: {
                        this.templateVersionSet = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 106: {
                        this.version = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 114: {
                        codedInputByteBufferNano.readMessage(this.liveJsCacheOption = new CacheOption());
                        continue;
                    }
                    case 125: {
                        this.reportingSampleRate = codedInputByteBufferNano.readFloat();
                        continue;
                    }
                    case 130: {
                        repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 130);
                        length4 = this.usageContext.length;
                        usageContext = new String[length4 + repeatedFieldArrayLength8];
                        System.arraycopy(this.usageContext, 0, usageContext, 0, length4);
                        this.usageContext = usageContext;
                        while (length4 < -1 + this.usageContext.length) {
                            this.usageContext[length4] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            ++length4;
                        }
                        this.usageContext[length4] = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 136: {
                        this.resourceFormatVersion = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 144: {
                        this.oBSOLETEEnableAutoEventTracking = codedInputByteBufferNano.readBool();
                        continue;
                    }
                    case 154: {
                        repeatedFieldArrayLength9 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 154);
                        length5 = this.supplemental.length;
                        supplemental = new String[length5 + repeatedFieldArrayLength9];
                        System.arraycopy(this.supplemental, 0, supplemental, 0, length5);
                        this.supplemental = supplemental;
                        while (length5 < -1 + this.supplemental.length) {
                            this.supplemental[length5] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            ++length5;
                        }
                        this.supplemental[length5] = codedInputByteBufferNano.readString();
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            String[] key;
            int length;
            int i;
            TypeSystem.Value[] value;
            int length2;
            int j;
            Property[] property;
            int length3;
            int k;
            FunctionCall[] macro;
            int length4;
            int l;
            FunctionCall[] tag;
            int length5;
            int n;
            FunctionCall[] predicate;
            int length6;
            int n2;
            Rule[] rule;
            int length7;
            int n3;
            String[] usageContext;
            int length8;
            int n4;
            String[] supplemental;
            int length9;
            int n5;
            if (this.key != null) {
                key = this.key;
                for (int length = key.length, i = 0; i < length; ++i) {
                    codedOutputByteBufferNano.writeString(1, key[i]);
                }
            }
            if (this.value != null) {
                value = this.value;
                for (int length2 = value.length, j = 0; j < length2; ++j) {
                    codedOutputByteBufferNano.writeMessage(2, value[j]);
                }
            }
            if (this.property != null) {
                property = this.property;
                for (int length3 = property.length, k = 0; k < length3; ++k) {
                    codedOutputByteBufferNano.writeMessage(3, property[k]);
                }
            }
            if (this.macro != null) {
                macro = this.macro;
                for (int length4 = macro.length, l = 0; l < length4; ++l) {
                    codedOutputByteBufferNano.writeMessage(4, macro[l]);
                }
            }
            if (this.tag != null) {
                tag = this.tag;
                for (int length5 = tag.length, n = 0; n < length5; ++n) {
                    codedOutputByteBufferNano.writeMessage(5, tag[n]);
                }
            }
            if (this.predicate != null) {
                predicate = this.predicate;
                for (int length6 = predicate.length, n2 = 0; n2 < length6; ++n2) {
                    codedOutputByteBufferNano.writeMessage(6, predicate[n2]);
                }
            }
            if (this.rule != null) {
                rule = this.rule;
                for (int length7 = rule.length, n3 = 0; n3 < length7; ++n3) {
                    codedOutputByteBufferNano.writeMessage(7, rule[n3]);
                }
            }
            if (!this.previewAuthCode.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.previewAuthCode);
            }
            if (!this.malwareScanAuthCode.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.malwareScanAuthCode);
            }
            if (!this.templateVersionSet.equals("0")) {
                codedOutputByteBufferNano.writeString(12, this.templateVersionSet);
            }
            if (!this.version.equals("")) {
                codedOutputByteBufferNano.writeString(13, this.version);
            }
            if (this.liveJsCacheOption != null) {
                codedOutputByteBufferNano.writeMessage(14, this.liveJsCacheOption);
            }
            if (this.reportingSampleRate != 0.0f) {
                codedOutputByteBufferNano.writeFloat(15, this.reportingSampleRate);
            }
            if (this.usageContext != null) {
                usageContext = this.usageContext;
                for (int length8 = usageContext.length, n4 = 0; n4 < length8; ++n4) {
                    codedOutputByteBufferNano.writeString(16, usageContext[n4]);
                }
            }
            if (this.resourceFormatVersion != 0) {
                codedOutputByteBufferNano.writeInt32(17, this.resourceFormatVersion);
            }
            if (this.oBSOLETEEnableAutoEventTracking) {
                codedOutputByteBufferNano.writeBool(18, this.oBSOLETEEnableAutoEventTracking);
            }
            if (this.supplemental != null) {
                supplemental = this.supplemental;
                for (int length9 = supplemental.length, n5 = 0; n5 < length9; ++n5) {
                    codedOutputByteBufferNano.writeString(19, supplemental[n5]);
                }
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public interface ResourceState
    {
        public static final int LIVE = 2;
        public static final int PREVIEW = 1;
    }
    
    public interface ResourceType
    {
        public static final int CLEAR_CACHE = 6;
        public static final int GET_COOKIE = 5;
        public static final int JS_RESOURCE = 1;
        public static final int NS_RESOURCE = 2;
        public static final int PIXEL_COLLECTION = 3;
        public static final int RAW_PROTO = 7;
        public static final int SET_COOKIE = 4;
    }
    
    public static final class Rule extends ExtendableMessageNano
    {
        public static final Rule[] EMPTY_ARRAY;
        public int[] addMacro;
        public int[] addMacroRuleName;
        public int[] addTag;
        public int[] addTagRuleName;
        public int[] negativePredicate;
        public int[] positivePredicate;
        public int[] removeMacro;
        public int[] removeMacroRuleName;
        public int[] removeTag;
        public int[] removeTagRuleName;
        
        static {
            EMPTY_ARRAY = new Rule[0];
        }
        
        public Rule() {
            this.positivePredicate = WireFormatNano.EMPTY_INT_ARRAY;
            this.negativePredicate = WireFormatNano.EMPTY_INT_ARRAY;
            this.addTag = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeTag = WireFormatNano.EMPTY_INT_ARRAY;
            this.addTagRuleName = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeTagRuleName = WireFormatNano.EMPTY_INT_ARRAY;
            this.addMacro = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeMacro = WireFormatNano.EMPTY_INT_ARRAY;
            this.addMacroRuleName = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeMacroRuleName = WireFormatNano.EMPTY_INT_ARRAY;
        }
        
        public static Rule parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new Rule().mergeFrom(codedInputByteBufferNano);
        }
        
        public static Rule parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new Rule(), array);
        }
        
        public final Rule clear() {
            this.positivePredicate = WireFormatNano.EMPTY_INT_ARRAY;
            this.negativePredicate = WireFormatNano.EMPTY_INT_ARRAY;
            this.addTag = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeTag = WireFormatNano.EMPTY_INT_ARRAY;
            this.addTagRuleName = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeTagRuleName = WireFormatNano.EMPTY_INT_ARRAY;
            this.addMacro = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeMacro = WireFormatNano.EMPTY_INT_ARRAY;
            this.addMacroRuleName = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeMacroRuleName = WireFormatNano.EMPTY_INT_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            Rule rule;
            if (o != this) {
                if (!(o instanceof Rule)) {
                    return false;
                }
                rule = (Rule)o;
                if (Arrays.equals(this.positivePredicate, rule.positivePredicate) && Arrays.equals(this.negativePredicate, rule.negativePredicate) && Arrays.equals(this.addTag, rule.addTag) && Arrays.equals(this.removeTag, rule.removeTag) && Arrays.equals(this.addTagRuleName, rule.addTagRuleName) && Arrays.equals(this.removeTagRuleName, rule.removeTagRuleName) && Arrays.equals(this.addMacro, rule.addMacro) && Arrays.equals(this.removeMacro, rule.removeMacro) && Arrays.equals(this.addMacroRuleName, rule.addMacroRuleName) && Arrays.equals(this.removeMacroRuleName, rule.removeMacroRuleName)) {
                    if (this.unknownFieldData == null) {
                        if (rule.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(rule.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            int[] positivePredicate;
            int n;
            int length;
            int n2;
            int[] positivePredicate2;
            int length2;
            int i;
            int n3;
            int[] negativePredicate;
            int length3;
            int j;
            int n4;
            int[] addTag;
            int length4;
            int k;
            int n5;
            int[] removeTag;
            int length5;
            int l;
            int n6;
            int[] addTagRuleName;
            int length6;
            int n7;
            int n8;
            int[] removeTagRuleName;
            int length7;
            int n9;
            int n10;
            int[] addMacro;
            int length8;
            int n11;
            int n12;
            int[] removeMacro;
            int length9;
            int n13;
            int n14;
            int[] addMacroRuleName;
            int length10;
            int n15;
            int n16;
            int[] removeMacroRuleName;
            int length11;
            int n17;
            positivePredicate = this.positivePredicate;
            n = 0;
            if (positivePredicate != null) {
                length = this.positivePredicate.length;
                n = 0;
                if (length > 0) {
                    n2 = 0;
                    positivePredicate2 = this.positivePredicate;
                    for (int length2 = positivePredicate2.length, i = 0; i < length2; ++i) {
                        n2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(positivePredicate2[i]);
                    }
                    n = 0 + n2 + 1 * this.positivePredicate.length;
                }
            }
            if (this.negativePredicate != null && this.negativePredicate.length > 0) {
                n3 = 0;
                negativePredicate = this.negativePredicate;
                for (int length3 = negativePredicate.length, j = 0; j < length3; ++j) {
                    n3 += CodedOutputByteBufferNano.computeInt32SizeNoTag(negativePredicate[j]);
                }
                n = n + n3 + 1 * this.negativePredicate.length;
            }
            if (this.addTag != null && this.addTag.length > 0) {
                n4 = 0;
                addTag = this.addTag;
                for (int length4 = addTag.length, k = 0; k < length4; ++k) {
                    n4 += CodedOutputByteBufferNano.computeInt32SizeNoTag(addTag[k]);
                }
                n = n + n4 + 1 * this.addTag.length;
            }
            if (this.removeTag != null && this.removeTag.length > 0) {
                n5 = 0;
                removeTag = this.removeTag;
                for (int length5 = removeTag.length, l = 0; l < length5; ++l) {
                    n5 += CodedOutputByteBufferNano.computeInt32SizeNoTag(removeTag[l]);
                }
                n = n + n5 + 1 * this.removeTag.length;
            }
            if (this.addTagRuleName != null && this.addTagRuleName.length > 0) {
                n6 = 0;
                addTagRuleName = this.addTagRuleName;
                for (int length6 = addTagRuleName.length, n7 = 0; n7 < length6; ++n7) {
                    n6 += CodedOutputByteBufferNano.computeInt32SizeNoTag(addTagRuleName[n7]);
                }
                n = n + n6 + 1 * this.addTagRuleName.length;
            }
            if (this.removeTagRuleName != null && this.removeTagRuleName.length > 0) {
                n8 = 0;
                removeTagRuleName = this.removeTagRuleName;
                for (int length7 = removeTagRuleName.length, n9 = 0; n9 < length7; ++n9) {
                    n8 += CodedOutputByteBufferNano.computeInt32SizeNoTag(removeTagRuleName[n9]);
                }
                n = n + n8 + 1 * this.removeTagRuleName.length;
            }
            if (this.addMacro != null && this.addMacro.length > 0) {
                n10 = 0;
                addMacro = this.addMacro;
                for (int length8 = addMacro.length, n11 = 0; n11 < length8; ++n11) {
                    n10 += CodedOutputByteBufferNano.computeInt32SizeNoTag(addMacro[n11]);
                }
                n = n + n10 + 1 * this.addMacro.length;
            }
            if (this.removeMacro != null && this.removeMacro.length > 0) {
                n12 = 0;
                removeMacro = this.removeMacro;
                for (int length9 = removeMacro.length, n13 = 0; n13 < length9; ++n13) {
                    n12 += CodedOutputByteBufferNano.computeInt32SizeNoTag(removeMacro[n13]);
                }
                n = n + n12 + 1 * this.removeMacro.length;
            }
            if (this.addMacroRuleName != null && this.addMacroRuleName.length > 0) {
                n14 = 0;
                addMacroRuleName = this.addMacroRuleName;
                for (int length10 = addMacroRuleName.length, n15 = 0; n15 < length10; ++n15) {
                    n14 += CodedOutputByteBufferNano.computeInt32SizeNoTag(addMacroRuleName[n15]);
                }
                n = n + n14 + 1 * this.addMacroRuleName.length;
            }
            if (this.removeMacroRuleName != null && this.removeMacroRuleName.length > 0) {
                n16 = 0;
                removeMacroRuleName = this.removeMacroRuleName;
                for (int length11 = removeMacroRuleName.length, n17 = 0; n17 < length11; ++n17) {
                    n16 += CodedOutputByteBufferNano.computeInt32SizeNoTag(removeMacroRuleName[n17]);
                }
                n = n + n16 + 1 * this.removeMacroRuleName.length;
            }
            return this.cachedSize = n + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int n;
            int i;
            int j;
            int k;
            int l;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int hashCode;
            n = 17;
            if (this.positivePredicate == null) {
                n *= 31;
            }
            else {
                for (int i = 0; i < this.positivePredicate.length; ++i) {
                    n = n * 31 + this.positivePredicate[i];
                }
            }
            if (this.negativePredicate == null) {
                n *= 31;
            }
            else {
                for (int j = 0; j < this.negativePredicate.length; ++j) {
                    n = n * 31 + this.negativePredicate[j];
                }
            }
            if (this.addTag == null) {
                n *= 31;
            }
            else {
                for (int k = 0; k < this.addTag.length; ++k) {
                    n = n * 31 + this.addTag[k];
                }
            }
            if (this.removeTag == null) {
                n *= 31;
            }
            else {
                for (int l = 0; l < this.removeTag.length; ++l) {
                    n = n * 31 + this.removeTag[l];
                }
            }
            if (this.addTagRuleName == null) {
                n *= 31;
            }
            else {
                for (int n2 = 0; n2 < this.addTagRuleName.length; ++n2) {
                    n = n * 31 + this.addTagRuleName[n2];
                }
            }
            if (this.removeTagRuleName == null) {
                n *= 31;
            }
            else {
                for (int n3 = 0; n3 < this.removeTagRuleName.length; ++n3) {
                    n = n * 31 + this.removeTagRuleName[n3];
                }
            }
            if (this.addMacro == null) {
                n *= 31;
            }
            else {
                for (int n4 = 0; n4 < this.addMacro.length; ++n4) {
                    n = n * 31 + this.addMacro[n4];
                }
            }
            if (this.removeMacro == null) {
                n *= 31;
            }
            else {
                for (int n5 = 0; n5 < this.removeMacro.length; ++n5) {
                    n = n * 31 + this.removeMacro[n5];
                }
            }
            if (this.addMacroRuleName == null) {
                n *= 31;
            }
            else {
                for (int n6 = 0; n6 < this.addMacroRuleName.length; ++n6) {
                    n = n * 31 + this.addMacroRuleName[n6];
                }
            }
            if (this.removeMacroRuleName == null) {
                n *= 31;
            }
            else {
                for (int n7 = 0; n7 < this.removeMacroRuleName.length; ++n7) {
                    n = n * 31 + this.removeMacroRuleName[n7];
                }
            }
            n8 = n * 31;
            if (this.unknownFieldData == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.unknownFieldData.hashCode();
            }
            return n8 + hashCode;
        }
        
        @Override
        public Rule mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int repeatedFieldArrayLength;
            int i;
            int[] positivePredicate;
            int repeatedFieldArrayLength2;
            int j;
            int[] negativePredicate;
            int repeatedFieldArrayLength3;
            int k;
            int[] addTag;
            int repeatedFieldArrayLength4;
            int l;
            int[] removeTag;
            int repeatedFieldArrayLength5;
            int length;
            int[] addTagRuleName;
            int repeatedFieldArrayLength6;
            int length2;
            int[] removeTagRuleName;
            int repeatedFieldArrayLength7;
            int length3;
            int[] addMacro;
            int repeatedFieldArrayLength8;
            int length4;
            int[] removeMacro;
            int repeatedFieldArrayLength9;
            int length5;
            int[] addMacroRuleName;
            int repeatedFieldArrayLength10;
            int length6;
            int[] removeMacroRuleName;
        Label_0134:
            while (true) {
                tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    default: {
                        if (this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList<UnknownFieldData>();
                        }
                        if (!WireFormatNano.storeUnknownField(this.unknownFieldData, codedInputByteBufferNano, tag)) {
                            break Label_0134;
                        }
                        continue;
                    }
                    case 0: {
                        break Label_0134;
                    }
                    case 8: {
                        repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                        i = this.positivePredicate.length;
                        positivePredicate = new int[i + repeatedFieldArrayLength];
                        System.arraycopy(this.positivePredicate, 0, positivePredicate, 0, i);
                        this.positivePredicate = positivePredicate;
                        while (i < -1 + this.positivePredicate.length) {
                            this.positivePredicate[i] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++i;
                        }
                        this.positivePredicate[i] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 16: {
                        repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                        j = this.negativePredicate.length;
                        negativePredicate = new int[j + repeatedFieldArrayLength2];
                        System.arraycopy(this.negativePredicate, 0, negativePredicate, 0, j);
                        this.negativePredicate = negativePredicate;
                        while (j < -1 + this.negativePredicate.length) {
                            this.negativePredicate[j] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++j;
                        }
                        this.negativePredicate[j] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 24: {
                        repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                        k = this.addTag.length;
                        addTag = new int[k + repeatedFieldArrayLength3];
                        System.arraycopy(this.addTag, 0, addTag, 0, k);
                        this.addTag = addTag;
                        while (k < -1 + this.addTag.length) {
                            this.addTag[k] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++k;
                        }
                        this.addTag[k] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 32: {
                        repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                        l = this.removeTag.length;
                        removeTag = new int[l + repeatedFieldArrayLength4];
                        System.arraycopy(this.removeTag, 0, removeTag, 0, l);
                        this.removeTag = removeTag;
                        while (l < -1 + this.removeTag.length) {
                            this.removeTag[l] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++l;
                        }
                        this.removeTag[l] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 40: {
                        repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 40);
                        length = this.addTagRuleName.length;
                        addTagRuleName = new int[length + repeatedFieldArrayLength5];
                        System.arraycopy(this.addTagRuleName, 0, addTagRuleName, 0, length);
                        this.addTagRuleName = addTagRuleName;
                        while (length < -1 + this.addTagRuleName.length) {
                            this.addTagRuleName[length] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++length;
                        }
                        this.addTagRuleName[length] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 48: {
                        repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 48);
                        length2 = this.removeTagRuleName.length;
                        removeTagRuleName = new int[length2 + repeatedFieldArrayLength6];
                        System.arraycopy(this.removeTagRuleName, 0, removeTagRuleName, 0, length2);
                        this.removeTagRuleName = removeTagRuleName;
                        while (length2 < -1 + this.removeTagRuleName.length) {
                            this.removeTagRuleName[length2] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++length2;
                        }
                        this.removeTagRuleName[length2] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 56: {
                        repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 56);
                        length3 = this.addMacro.length;
                        addMacro = new int[length3 + repeatedFieldArrayLength7];
                        System.arraycopy(this.addMacro, 0, addMacro, 0, length3);
                        this.addMacro = addMacro;
                        while (length3 < -1 + this.addMacro.length) {
                            this.addMacro[length3] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++length3;
                        }
                        this.addMacro[length3] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 64: {
                        repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 64);
                        length4 = this.removeMacro.length;
                        removeMacro = new int[length4 + repeatedFieldArrayLength8];
                        System.arraycopy(this.removeMacro, 0, removeMacro, 0, length4);
                        this.removeMacro = removeMacro;
                        while (length4 < -1 + this.removeMacro.length) {
                            this.removeMacro[length4] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++length4;
                        }
                        this.removeMacro[length4] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 72: {
                        repeatedFieldArrayLength9 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 72);
                        length5 = this.addMacroRuleName.length;
                        addMacroRuleName = new int[length5 + repeatedFieldArrayLength9];
                        System.arraycopy(this.addMacroRuleName, 0, addMacroRuleName, 0, length5);
                        this.addMacroRuleName = addMacroRuleName;
                        while (length5 < -1 + this.addMacroRuleName.length) {
                            this.addMacroRuleName[length5] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++length5;
                        }
                        this.addMacroRuleName[length5] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 80: {
                        repeatedFieldArrayLength10 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 80);
                        length6 = this.removeMacroRuleName.length;
                        removeMacroRuleName = new int[length6 + repeatedFieldArrayLength10];
                        System.arraycopy(this.removeMacroRuleName, 0, removeMacroRuleName, 0, length6);
                        this.removeMacroRuleName = removeMacroRuleName;
                        while (length6 < -1 + this.removeMacroRuleName.length) {
                            this.removeMacroRuleName[length6] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++length6;
                        }
                        this.removeMacroRuleName[length6] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            int[] positivePredicate;
            int length;
            int i;
            int[] negativePredicate;
            int length2;
            int j;
            int[] addTag;
            int length3;
            int k;
            int[] removeTag;
            int length4;
            int l;
            int[] addTagRuleName;
            int length5;
            int n;
            int[] removeTagRuleName;
            int length6;
            int n2;
            int[] addMacro;
            int length7;
            int n3;
            int[] removeMacro;
            int length8;
            int n4;
            int[] addMacroRuleName;
            int length9;
            int n5;
            int[] removeMacroRuleName;
            int length10;
            int n6;
            if (this.positivePredicate != null) {
                positivePredicate = this.positivePredicate;
                for (int length = positivePredicate.length, i = 0; i < length; ++i) {
                    codedOutputByteBufferNano.writeInt32(1, positivePredicate[i]);
                }
            }
            if (this.negativePredicate != null) {
                negativePredicate = this.negativePredicate;
                for (int length2 = negativePredicate.length, j = 0; j < length2; ++j) {
                    codedOutputByteBufferNano.writeInt32(2, negativePredicate[j]);
                }
            }
            if (this.addTag != null) {
                addTag = this.addTag;
                for (int length3 = addTag.length, k = 0; k < length3; ++k) {
                    codedOutputByteBufferNano.writeInt32(3, addTag[k]);
                }
            }
            if (this.removeTag != null) {
                removeTag = this.removeTag;
                for (int length4 = removeTag.length, l = 0; l < length4; ++l) {
                    codedOutputByteBufferNano.writeInt32(4, removeTag[l]);
                }
            }
            if (this.addTagRuleName != null) {
                addTagRuleName = this.addTagRuleName;
                for (int length5 = addTagRuleName.length, n = 0; n < length5; ++n) {
                    codedOutputByteBufferNano.writeInt32(5, addTagRuleName[n]);
                }
            }
            if (this.removeTagRuleName != null) {
                removeTagRuleName = this.removeTagRuleName;
                for (int length6 = removeTagRuleName.length, n2 = 0; n2 < length6; ++n2) {
                    codedOutputByteBufferNano.writeInt32(6, removeTagRuleName[n2]);
                }
            }
            if (this.addMacro != null) {
                addMacro = this.addMacro;
                for (int length7 = addMacro.length, n3 = 0; n3 < length7; ++n3) {
                    codedOutputByteBufferNano.writeInt32(7, addMacro[n3]);
                }
            }
            if (this.removeMacro != null) {
                removeMacro = this.removeMacro;
                for (int length8 = removeMacro.length, n4 = 0; n4 < length8; ++n4) {
                    codedOutputByteBufferNano.writeInt32(8, removeMacro[n4]);
                }
            }
            if (this.addMacroRuleName != null) {
                addMacroRuleName = this.addMacroRuleName;
                for (int length9 = addMacroRuleName.length, n5 = 0; n5 < length9; ++n5) {
                    codedOutputByteBufferNano.writeInt32(9, addMacroRuleName[n5]);
                }
            }
            if (this.removeMacroRuleName != null) {
                removeMacroRuleName = this.removeMacroRuleName;
                for (int length10 = removeMacroRuleName.length, n6 = 0; n6 < length10; ++n6) {
                    codedOutputByteBufferNano.writeInt32(10, removeMacroRuleName[n6]);
                }
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public static final class ServingValue extends ExtendableMessageNano
    {
        public static final ServingValue[] EMPTY_ARRAY;
        public static final Extension<ServingValue> ext;
        public int[] listItem;
        public int macroNameReference;
        public int macroReference;
        public int[] mapKey;
        public int[] mapValue;
        public int tagReference;
        public int[] templateToken;
        
        static {
            EMPTY_ARRAY = new ServingValue[0];
            ext = Extension.create(101, (Extension.TypeLiteral<ServingValue>)new Extension.TypeLiteral<ServingValue>() {});
        }
        
        public ServingValue() {
            this.listItem = WireFormatNano.EMPTY_INT_ARRAY;
            this.mapKey = WireFormatNano.EMPTY_INT_ARRAY;
            this.mapValue = WireFormatNano.EMPTY_INT_ARRAY;
            this.macroReference = 0;
            this.templateToken = WireFormatNano.EMPTY_INT_ARRAY;
            this.macroNameReference = 0;
            this.tagReference = 0;
        }
        
        public static ServingValue parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new ServingValue().mergeFrom(codedInputByteBufferNano);
        }
        
        public static ServingValue parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new ServingValue(), array);
        }
        
        public final ServingValue clear() {
            this.listItem = WireFormatNano.EMPTY_INT_ARRAY;
            this.mapKey = WireFormatNano.EMPTY_INT_ARRAY;
            this.mapValue = WireFormatNano.EMPTY_INT_ARRAY;
            this.macroReference = 0;
            this.templateToken = WireFormatNano.EMPTY_INT_ARRAY;
            this.macroNameReference = 0;
            this.tagReference = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            ServingValue servingValue;
            if (o != this) {
                if (!(o instanceof ServingValue)) {
                    return false;
                }
                servingValue = (ServingValue)o;
                if (Arrays.equals(this.listItem, servingValue.listItem) && Arrays.equals(this.mapKey, servingValue.mapKey) && Arrays.equals(this.mapValue, servingValue.mapValue) && this.macroReference == servingValue.macroReference && Arrays.equals(this.templateToken, servingValue.templateToken) && this.macroNameReference == servingValue.macroNameReference && this.tagReference == servingValue.tagReference) {
                    if (this.unknownFieldData == null) {
                        if (servingValue.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(servingValue.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            int[] listItem;
            int n;
            int length;
            int n2;
            int[] listItem2;
            int length2;
            int i;
            int n3;
            int[] mapKey;
            int length3;
            int j;
            int n4;
            int[] mapValue;
            int length4;
            int k;
            int n5;
            int[] templateToken;
            int length5;
            int l;
            listItem = this.listItem;
            n = 0;
            if (listItem != null) {
                length = this.listItem.length;
                n = 0;
                if (length > 0) {
                    n2 = 0;
                    listItem2 = this.listItem;
                    for (int length2 = listItem2.length, i = 0; i < length2; ++i) {
                        n2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(listItem2[i]);
                    }
                    n = 0 + n2 + 1 * this.listItem.length;
                }
            }
            if (this.mapKey != null && this.mapKey.length > 0) {
                n3 = 0;
                mapKey = this.mapKey;
                for (int length3 = mapKey.length, j = 0; j < length3; ++j) {
                    n3 += CodedOutputByteBufferNano.computeInt32SizeNoTag(mapKey[j]);
                }
                n = n + n3 + 1 * this.mapKey.length;
            }
            if (this.mapValue != null && this.mapValue.length > 0) {
                n4 = 0;
                mapValue = this.mapValue;
                for (int length4 = mapValue.length, k = 0; k < length4; ++k) {
                    n4 += CodedOutputByteBufferNano.computeInt32SizeNoTag(mapValue[k]);
                }
                n = n + n4 + 1 * this.mapValue.length;
            }
            if (this.macroReference != 0) {
                n += CodedOutputByteBufferNano.computeInt32Size(4, this.macroReference);
            }
            if (this.templateToken != null && this.templateToken.length > 0) {
                n5 = 0;
                templateToken = this.templateToken;
                for (int length5 = templateToken.length, l = 0; l < length5; ++l) {
                    n5 += CodedOutputByteBufferNano.computeInt32SizeNoTag(templateToken[l]);
                }
                n = n + n5 + 1 * this.templateToken.length;
            }
            if (this.macroNameReference != 0) {
                n += CodedOutputByteBufferNano.computeInt32Size(6, this.macroNameReference);
            }
            if (this.tagReference != 0) {
                n += CodedOutputByteBufferNano.computeInt32Size(7, this.tagReference);
            }
            return this.cachedSize = n + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int n;
            int i;
            int j;
            int k;
            int n2;
            int l;
            int n3;
            int hashCode;
            n = 17;
            if (this.listItem == null) {
                n *= 31;
            }
            else {
                for (int i = 0; i < this.listItem.length; ++i) {
                    n = n * 31 + this.listItem[i];
                }
            }
            if (this.mapKey == null) {
                n *= 31;
            }
            else {
                for (int j = 0; j < this.mapKey.length; ++j) {
                    n = n * 31 + this.mapKey[j];
                }
            }
            if (this.mapValue == null) {
                n *= 31;
            }
            else {
                for (int k = 0; k < this.mapValue.length; ++k) {
                    n = n * 31 + this.mapValue[k];
                }
            }
            n2 = n * 31 + this.macroReference;
            if (this.templateToken == null) {
                n2 *= 31;
            }
            else {
                for (int l = 0; l < this.templateToken.length; ++l) {
                    n2 = n2 * 31 + this.templateToken[l];
                }
            }
            n3 = 31 * (31 * (n2 * 31 + this.macroNameReference) + this.tagReference);
            if (this.unknownFieldData == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.unknownFieldData.hashCode();
            }
            return n3 + hashCode;
        }
        
        @Override
        public ServingValue mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int repeatedFieldArrayLength;
            int i;
            int[] listItem;
            int repeatedFieldArrayLength2;
            int j;
            int[] mapKey;
            int repeatedFieldArrayLength3;
            int k;
            int[] mapValue;
            int repeatedFieldArrayLength4;
            int l;
            int[] templateToken;
        Label_0110:
            while (true) {
                tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    default: {
                        if (this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList<UnknownFieldData>();
                        }
                        if (!WireFormatNano.storeUnknownField(this.unknownFieldData, codedInputByteBufferNano, tag)) {
                            break Label_0110;
                        }
                        continue;
                    }
                    case 0: {
                        break Label_0110;
                    }
                    case 8: {
                        repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                        i = this.listItem.length;
                        listItem = new int[i + repeatedFieldArrayLength];
                        System.arraycopy(this.listItem, 0, listItem, 0, i);
                        this.listItem = listItem;
                        while (i < -1 + this.listItem.length) {
                            this.listItem[i] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++i;
                        }
                        this.listItem[i] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 16: {
                        repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                        j = this.mapKey.length;
                        mapKey = new int[j + repeatedFieldArrayLength2];
                        System.arraycopy(this.mapKey, 0, mapKey, 0, j);
                        this.mapKey = mapKey;
                        while (j < -1 + this.mapKey.length) {
                            this.mapKey[j] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++j;
                        }
                        this.mapKey[j] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 24: {
                        repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                        k = this.mapValue.length;
                        mapValue = new int[k + repeatedFieldArrayLength3];
                        System.arraycopy(this.mapValue, 0, mapValue, 0, k);
                        this.mapValue = mapValue;
                        while (k < -1 + this.mapValue.length) {
                            this.mapValue[k] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++k;
                        }
                        this.mapValue[k] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 32: {
                        this.macroReference = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 40: {
                        repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 40);
                        l = this.templateToken.length;
                        templateToken = new int[l + repeatedFieldArrayLength4];
                        System.arraycopy(this.templateToken, 0, templateToken, 0, l);
                        this.templateToken = templateToken;
                        while (l < -1 + this.templateToken.length) {
                            this.templateToken[l] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++l;
                        }
                        this.templateToken[l] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 48: {
                        this.macroNameReference = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 56: {
                        this.tagReference = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            int[] listItem;
            int length;
            int i;
            int[] mapKey;
            int length2;
            int j;
            int[] mapValue;
            int length3;
            int k;
            int[] templateToken;
            int length4;
            int l;
            if (this.listItem != null) {
                listItem = this.listItem;
                for (int length = listItem.length, i = 0; i < length; ++i) {
                    codedOutputByteBufferNano.writeInt32(1, listItem[i]);
                }
            }
            if (this.mapKey != null) {
                mapKey = this.mapKey;
                for (int length2 = mapKey.length, j = 0; j < length2; ++j) {
                    codedOutputByteBufferNano.writeInt32(2, mapKey[j]);
                }
            }
            if (this.mapValue != null) {
                mapValue = this.mapValue;
                for (int length3 = mapValue.length, k = 0; k < length3; ++k) {
                    codedOutputByteBufferNano.writeInt32(3, mapValue[k]);
                }
            }
            if (this.macroReference != 0) {
                codedOutputByteBufferNano.writeInt32(4, this.macroReference);
            }
            if (this.templateToken != null) {
                templateToken = this.templateToken;
                for (int length4 = templateToken.length, l = 0; l < length4; ++l) {
                    codedOutputByteBufferNano.writeInt32(5, templateToken[l]);
                }
            }
            if (this.macroNameReference != 0) {
                codedOutputByteBufferNano.writeInt32(6, this.macroNameReference);
            }
            if (this.tagReference != 0) {
                codedOutputByteBufferNano.writeInt32(7, this.tagReference);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public static final class Supplemental extends ExtendableMessageNano
    {
        public static final Supplemental[] EMPTY_ARRAY;
        public GaExperimentSupplemental experimentSupplemental;
        public String name;
        public TypeSystem.Value value;
        
        static {
            EMPTY_ARRAY = new Supplemental[0];
        }
        
        public Supplemental() {
            this.name = "";
            this.value = null;
            this.experimentSupplemental = null;
        }
        
        public static Supplemental parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new Supplemental().mergeFrom(codedInputByteBufferNano);
        }
        
        public static Supplemental parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new Supplemental(), array);
        }
        
        public final Supplemental clear() {
            this.name = "";
            this.value = null;
            this.experimentSupplemental = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            Supplemental supplemental;
            if (o != this) {
                if (!(o instanceof Supplemental)) {
                    return false;
                }
                supplemental = (Supplemental)o;
                if (this.name == null) {
                    if (supplemental.name != null) {
                        return false;
                    }
                }
                else if (!this.name.equals(supplemental.name)) {
                    return false;
                }
                if (this.value == null) {
                    if (supplemental.value != null) {
                        return false;
                    }
                }
                else if (!this.value.equals(supplemental.value)) {
                    return false;
                }
                if (this.experimentSupplemental == null) {
                    if (supplemental.experimentSupplemental != null) {
                        return false;
                    }
                }
                else if (!this.experimentSupplemental.equals(supplemental.experimentSupplemental)) {
                    return false;
                }
                if (this.unknownFieldData == null) {
                    if (supplemental.unknownFieldData == null) {
                        return true;
                    }
                }
                else if (this.unknownFieldData.equals(supplemental.unknownFieldData)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            boolean equals;
            int n;
            equals = this.name.equals("");
            n = 0;
            if (!equals) {
                n = 0 + CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            if (this.value != null) {
                n += CodedOutputByteBufferNano.computeMessageSize(2, this.value);
            }
            if (this.experimentSupplemental != null) {
                n += CodedOutputByteBufferNano.computeMessageSize(3, this.experimentSupplemental);
            }
            return this.cachedSize = n + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int hashCode;
            int n;
            int hashCode2;
            int n2;
            int hashCode3;
            int n3;
            List<UnknownFieldData> unknownFieldData;
            int hashCode4;
            if (this.name == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.name.hashCode();
            }
            n = 31 * (hashCode + 527);
            if (this.value == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = this.value.hashCode();
            }
            n2 = 31 * (n + hashCode2);
            if (this.experimentSupplemental == null) {
                hashCode3 = 0;
            }
            else {
                hashCode3 = this.experimentSupplemental.hashCode();
            }
            n3 = 31 * (n2 + hashCode3);
            unknownFieldData = this.unknownFieldData;
            hashCode4 = 0;
            if (unknownFieldData != null) {
                hashCode4 = this.unknownFieldData.hashCode();
            }
            return n3 + hashCode4;
        }
        
        @Override
        public Supplemental mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                    case 10: {
                        this.name = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 18: {
                        codedInputByteBufferNano.readMessage(this.value = new TypeSystem.Value());
                        continue;
                    }
                    case 26: {
                        codedInputByteBufferNano.readMessage(this.experimentSupplemental = new GaExperimentSupplemental());
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.name.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            if (this.value != null) {
                codedOutputByteBufferNano.writeMessage(2, this.value);
            }
            if (this.experimentSupplemental != null) {
                codedOutputByteBufferNano.writeMessage(3, this.experimentSupplemental);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public static final class SupplementedResource extends ExtendableMessageNano
    {
        public static final SupplementedResource[] EMPTY_ARRAY;
        public String fingerprint;
        public Resource resource;
        public Supplemental[] supplemental;
        
        static {
            EMPTY_ARRAY = new SupplementedResource[0];
        }
        
        public SupplementedResource() {
            this.supplemental = Supplemental.EMPTY_ARRAY;
            this.resource = null;
            this.fingerprint = "";
        }
        
        public static SupplementedResource parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new SupplementedResource().mergeFrom(codedInputByteBufferNano);
        }
        
        public static SupplementedResource parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new SupplementedResource(), array);
        }
        
        public final SupplementedResource clear() {
            this.supplemental = Supplemental.EMPTY_ARRAY;
            this.resource = null;
            this.fingerprint = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            SupplementedResource supplementedResource;
            if (o != this) {
                if (!(o instanceof SupplementedResource)) {
                    return false;
                }
                supplementedResource = (SupplementedResource)o;
                if (Arrays.equals(this.supplemental, supplementedResource.supplemental)) {
                    if (this.resource == null) {
                        if (supplementedResource.resource != null) {
                            return false;
                        }
                    }
                    else if (!this.resource.equals(supplementedResource.resource)) {
                        return false;
                    }
                    if (this.fingerprint == null) {
                        if (supplementedResource.fingerprint != null) {
                            return false;
                        }
                    }
                    else if (!this.fingerprint.equals(supplementedResource.fingerprint)) {
                        return false;
                    }
                    if (this.unknownFieldData == null) {
                        if (supplementedResource.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(supplementedResource.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            Supplemental[] supplemental;
            int n;
            Supplemental[] supplemental2;
            int length;
            int i;
            supplemental = this.supplemental;
            n = 0;
            if (supplemental != null) {
                supplemental2 = this.supplemental;
                for (int length = supplemental2.length, i = 0; i < length; ++i) {
                    n += CodedOutputByteBufferNano.computeMessageSize(1, supplemental2[i]);
                }
            }
            if (this.resource != null) {
                n += CodedOutputByteBufferNano.computeMessageSize(2, this.resource);
            }
            if (!this.fingerprint.equals("")) {
                n += CodedOutputByteBufferNano.computeStringSize(3, this.fingerprint);
            }
            return this.cachedSize = n + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int n;
            int i;
            int n2;
            int hashCode;
            int n3;
            int hashCode2;
            int n4;
            int hashCode3;
            int n5;
            List<UnknownFieldData> unknownFieldData;
            int hashCode4;
            n = 17;
            if (this.supplemental == null) {
                n *= 31;
            }
            else {
                for (int i = 0; i < this.supplemental.length; ++i) {
                    n2 = n * 31;
                    if (this.supplemental[i] == null) {
                        hashCode = 0;
                    }
                    else {
                        hashCode = this.supplemental[i].hashCode();
                    }
                    n = n2 + hashCode;
                }
            }
            n3 = n * 31;
            if (this.resource == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = this.resource.hashCode();
            }
            n4 = 31 * (n3 + hashCode2);
            if (this.fingerprint == null) {
                hashCode3 = 0;
            }
            else {
                hashCode3 = this.fingerprint.hashCode();
            }
            n5 = 31 * (n4 + hashCode3);
            unknownFieldData = this.unknownFieldData;
            hashCode4 = 0;
            if (unknownFieldData != null) {
                hashCode4 = this.unknownFieldData.hashCode();
            }
            return n5 + hashCode4;
        }
        
        @Override
        public SupplementedResource mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int repeatedFieldArrayLength;
            int i;
            Supplemental[] supplemental;
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
                    case 10: {
                        repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        if (this.supplemental == null) {
                            i = 0;
                        }
                        else {
                            i = this.supplemental.length;
                        }
                        supplemental = new Supplemental[i + repeatedFieldArrayLength];
                        if (this.supplemental != null) {
                            System.arraycopy(this.supplemental, 0, supplemental, 0, i);
                        }
                        this.supplemental = supplemental;
                        while (i < -1 + this.supplemental.length) {
                            codedInputByteBufferNano.readMessage(this.supplemental[i] = new Supplemental());
                            codedInputByteBufferNano.readTag();
                            ++i;
                        }
                        codedInputByteBufferNano.readMessage(this.supplemental[i] = new Supplemental());
                        continue;
                    }
                    case 18: {
                        codedInputByteBufferNano.readMessage(this.resource = new Resource());
                        continue;
                    }
                    case 26: {
                        this.fingerprint = codedInputByteBufferNano.readString();
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Supplemental[] supplemental;
            int length;
            int i;
            if (this.supplemental != null) {
                supplemental = this.supplemental;
                for (int length = supplemental.length, i = 0; i < length; ++i) {
                    codedOutputByteBufferNano.writeMessage(1, supplemental[i]);
                }
            }
            if (this.resource != null) {
                codedOutputByteBufferNano.writeMessage(2, this.resource);
            }
            if (!this.fingerprint.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.fingerprint);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
}
