// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.midtier.proto.containertag;

import java.util.ArrayList;
import com.google.tagmanager.protobuf.nano.UnknownFieldData;
import java.util.List;
import com.google.tagmanager.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Arrays;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;
import java.io.IOException;
import com.google.tagmanager.protobuf.nano.CodedInputByteBufferNano;
import com.google.tagmanager.protobuf.nano.WireFormatNano;
import com.google.tagmanager.protobuf.nano.ExtendableMessageNano;

public interface TypeSystem
{
    public static final class Value extends ExtendableMessageNano
    {
        public static final Value[] EMPTY_ARRAY;
        public boolean boolean_;
        public boolean containsReferences;
        public int[] escaping;
        public String functionId;
        public long integer;
        public Value[] listItem;
        public String macroReference;
        public Value[] mapKey;
        public Value[] mapValue;
        public String string;
        public String tagReference;
        public Value[] templateToken;
        public int type;
        
        static {
            EMPTY_ARRAY = new Value[0];
        }
        
        public Value() {
            this.type = 1;
            this.string = "";
            this.listItem = Value.EMPTY_ARRAY;
            this.mapKey = Value.EMPTY_ARRAY;
            this.mapValue = Value.EMPTY_ARRAY;
            this.macroReference = "";
            this.functionId = "";
            this.integer = 0L;
            this.boolean_ = false;
            this.templateToken = Value.EMPTY_ARRAY;
            this.tagReference = "";
            this.escaping = WireFormatNano.EMPTY_INT_ARRAY;
            this.containsReferences = false;
        }
        
        public static Value parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new Value().mergeFrom(codedInputByteBufferNano);
        }
        
        public static Value parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new Value(), array);
        }
        
        public final Value clear() {
            this.type = 1;
            this.string = "";
            this.listItem = Value.EMPTY_ARRAY;
            this.mapKey = Value.EMPTY_ARRAY;
            this.mapValue = Value.EMPTY_ARRAY;
            this.macroReference = "";
            this.functionId = "";
            this.integer = 0L;
            this.boolean_ = false;
            this.templateToken = Value.EMPTY_ARRAY;
            this.tagReference = "";
            this.escaping = WireFormatNano.EMPTY_INT_ARRAY;
            this.containsReferences = false;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            Value value;
            if (o != this) {
                if (!(o instanceof Value)) {
                    return false;
                }
                value = (Value)o;
                if (this.type == value.type) {
                    if (this.string == null) {
                        if (value.string != null) {
                            return false;
                        }
                    }
                    else if (!this.string.equals(value.string)) {
                        return false;
                    }
                    if (Arrays.equals(this.listItem, value.listItem) && Arrays.equals(this.mapKey, value.mapKey) && Arrays.equals(this.mapValue, value.mapValue)) {
                        if (this.macroReference == null) {
                            if (value.macroReference != null) {
                                return false;
                            }
                        }
                        else if (!this.macroReference.equals(value.macroReference)) {
                            return false;
                        }
                        if (this.functionId == null) {
                            if (value.functionId != null) {
                                return false;
                            }
                        }
                        else if (!this.functionId.equals(value.functionId)) {
                            return false;
                        }
                        if (this.integer == value.integer && this.boolean_ == value.boolean_ && Arrays.equals(this.templateToken, value.templateToken)) {
                            if (this.tagReference == null) {
                                if (value.tagReference != null) {
                                    return false;
                                }
                            }
                            else if (!this.tagReference.equals(value.tagReference)) {
                                return false;
                            }
                            if (Arrays.equals(this.escaping, value.escaping) && this.containsReferences == value.containsReferences) {
                                if (this.unknownFieldData == null) {
                                    if (value.unknownFieldData == null) {
                                        return true;
                                    }
                                }
                                else if (this.unknownFieldData.equals(value.unknownFieldData)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            int n;
            Value[] listItem;
            int length;
            int i;
            Value[] mapKey;
            int length2;
            int j;
            Value[] mapValue;
            int length3;
            int k;
            int n2;
            int[] escaping;
            int length4;
            int l;
            Value[] templateToken;
            int length5;
            int n3;
            n = 0 + CodedOutputByteBufferNano.computeInt32Size(1, this.type);
            if (!this.string.equals("")) {
                n += CodedOutputByteBufferNano.computeStringSize(2, this.string);
            }
            if (this.listItem != null) {
                listItem = this.listItem;
                for (int length = listItem.length, i = 0; i < length; ++i) {
                    n += CodedOutputByteBufferNano.computeMessageSize(3, listItem[i]);
                }
            }
            if (this.mapKey != null) {
                mapKey = this.mapKey;
                for (int length2 = mapKey.length, j = 0; j < length2; ++j) {
                    n += CodedOutputByteBufferNano.computeMessageSize(4, mapKey[j]);
                }
            }
            if (this.mapValue != null) {
                mapValue = this.mapValue;
                for (int length3 = mapValue.length, k = 0; k < length3; ++k) {
                    n += CodedOutputByteBufferNano.computeMessageSize(5, mapValue[k]);
                }
            }
            if (!this.macroReference.equals("")) {
                n += CodedOutputByteBufferNano.computeStringSize(6, this.macroReference);
            }
            if (!this.functionId.equals("")) {
                n += CodedOutputByteBufferNano.computeStringSize(7, this.functionId);
            }
            if (this.integer != 0L) {
                n += CodedOutputByteBufferNano.computeInt64Size(8, this.integer);
            }
            if (this.containsReferences) {
                n += CodedOutputByteBufferNano.computeBoolSize(9, this.containsReferences);
            }
            if (this.escaping != null && this.escaping.length > 0) {
                n2 = 0;
                escaping = this.escaping;
                for (int length4 = escaping.length, l = 0; l < length4; ++l) {
                    n2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(escaping[l]);
                }
                n = n + n2 + 1 * this.escaping.length;
            }
            if (this.templateToken != null) {
                templateToken = this.templateToken;
                for (int length5 = templateToken.length, n3 = 0; n3 < length5; ++n3) {
                    n += CodedOutputByteBufferNano.computeMessageSize(11, templateToken[n3]);
                }
            }
            if (this.boolean_) {
                n += CodedOutputByteBufferNano.computeBoolSize(12, this.boolean_);
            }
            if (!this.tagReference.equals("")) {
                n += CodedOutputByteBufferNano.computeStringSize(13, this.tagReference);
            }
            return this.cachedSize = n + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int n;
            int n2;
            int hashCode;
            int n3;
            int i;
            int n4;
            int hashCode2;
            int j;
            int n5;
            int hashCode3;
            int k;
            int n6;
            int hashCode4;
            int n7;
            int hashCode5;
            int n8;
            int hashCode6;
            int n9;
            int n10;
            int n11;
            int l;
            int n12;
            int hashCode7;
            int n13;
            int hashCode8;
            int n14;
            int n15;
            int n16;
            int n17;
            List<UnknownFieldData> unknownFieldData;
            int hashCode9;
            n = 1;
            n2 = 31 * (527 + this.type);
            if (this.string == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.string.hashCode();
            }
            n3 = n2 + hashCode;
            if (this.listItem == null) {
                n3 *= 31;
            }
            else {
                for (int i = 0; i < this.listItem.length; ++i) {
                    n4 = n3 * 31;
                    if (this.listItem[i] == null) {
                        hashCode2 = 0;
                    }
                    else {
                        hashCode2 = this.listItem[i].hashCode();
                    }
                    n3 = n4 + hashCode2;
                }
            }
            if (this.mapKey == null) {
                n3 *= 31;
            }
            else {
                for (int j = 0; j < this.mapKey.length; ++j) {
                    n5 = n3 * 31;
                    if (this.mapKey[j] == null) {
                        hashCode3 = 0;
                    }
                    else {
                        hashCode3 = this.mapKey[j].hashCode();
                    }
                    n3 = n5 + hashCode3;
                }
            }
            if (this.mapValue == null) {
                n3 *= 31;
            }
            else {
                for (int k = 0; k < this.mapValue.length; ++k) {
                    n6 = n3 * 31;
                    if (this.mapValue[k] == null) {
                        hashCode4 = 0;
                    }
                    else {
                        hashCode4 = this.mapValue[k].hashCode();
                    }
                    n3 = n6 + hashCode4;
                }
            }
            n7 = n3 * 31;
            if (this.macroReference == null) {
                hashCode5 = 0;
            }
            else {
                hashCode5 = this.macroReference.hashCode();
            }
            n8 = 31 * (n7 + hashCode5);
            if (this.functionId == null) {
                hashCode6 = 0;
            }
            else {
                hashCode6 = this.functionId.hashCode();
            }
            n9 = 31 * (31 * (n8 + hashCode6) + (int)(this.integer ^ this.integer >>> 32));
            if (this.boolean_) {
                n10 = n;
            }
            else {
                n10 = 2;
            }
            n11 = n9 + n10;
            if (this.templateToken == null) {
                n11 *= 31;
            }
            else {
                for (int l = 0; l < this.templateToken.length; ++l) {
                    n12 = n11 * 31;
                    if (this.templateToken[l] == null) {
                        hashCode7 = 0;
                    }
                    else {
                        hashCode7 = this.templateToken[l].hashCode();
                    }
                    n11 = n12 + hashCode7;
                }
            }
            n13 = n11 * 31;
            if (this.tagReference == null) {
                hashCode8 = 0;
            }
            else {
                hashCode8 = this.tagReference.hashCode();
            }
            n14 = n13 + hashCode8;
            if (this.escaping == null) {
                n14 *= 31;
            }
            else {
                for (int n15 = 0; n15 < this.escaping.length; ++n15) {
                    n14 = n14 * 31 + this.escaping[n15];
                }
            }
            n16 = n14 * 31;
            if (!this.containsReferences) {
                n = 2;
            }
            n17 = 31 * (n16 + n);
            unknownFieldData = this.unknownFieldData;
            hashCode9 = 0;
            if (unknownFieldData != null) {
                hashCode9 = this.unknownFieldData.hashCode();
            }
            return n17 + hashCode9;
        }
        
        @Override
        public Value mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int int32;
            int repeatedFieldArrayLength;
            int i;
            Value[] listItem;
            int repeatedFieldArrayLength2;
            int j;
            Value[] mapKey;
            int repeatedFieldArrayLength3;
            int k;
            Value[] mapValue;
            int repeatedFieldArrayLength4;
            int l;
            int[] escaping;
            int repeatedFieldArrayLength5;
            int length;
            Value[] templateToken;
        Label_0158:
            while (true) {
                tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    default: {
                        if (this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList<UnknownFieldData>();
                        }
                        if (!WireFormatNano.storeUnknownField(this.unknownFieldData, codedInputByteBufferNano, tag)) {
                            break Label_0158;
                        }
                        continue;
                    }
                    case 0: {
                        break Label_0158;
                    }
                    case 8: {
                        int32 = codedInputByteBufferNano.readInt32();
                        if (int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4 || int32 == 5 || int32 == 6 || int32 == 7 || int32 == 8 || int32 == 9) {
                            this.type = int32;
                            continue;
                        }
                        this.type = 1;
                        continue;
                    }
                    case 18: {
                        this.string = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 26: {
                        repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        if (this.listItem == null) {
                            i = 0;
                        }
                        else {
                            i = this.listItem.length;
                        }
                        listItem = new Value[i + repeatedFieldArrayLength];
                        if (this.listItem != null) {
                            System.arraycopy(this.listItem, 0, listItem, 0, i);
                        }
                        this.listItem = listItem;
                        while (i < -1 + this.listItem.length) {
                            codedInputByteBufferNano.readMessage(this.listItem[i] = new Value());
                            codedInputByteBufferNano.readTag();
                            ++i;
                        }
                        codedInputByteBufferNano.readMessage(this.listItem[i] = new Value());
                        continue;
                    }
                    case 34: {
                        repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        if (this.mapKey == null) {
                            j = 0;
                        }
                        else {
                            j = this.mapKey.length;
                        }
                        mapKey = new Value[j + repeatedFieldArrayLength2];
                        if (this.mapKey != null) {
                            System.arraycopy(this.mapKey, 0, mapKey, 0, j);
                        }
                        this.mapKey = mapKey;
                        while (j < -1 + this.mapKey.length) {
                            codedInputByteBufferNano.readMessage(this.mapKey[j] = new Value());
                            codedInputByteBufferNano.readTag();
                            ++j;
                        }
                        codedInputByteBufferNano.readMessage(this.mapKey[j] = new Value());
                        continue;
                    }
                    case 42: {
                        repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        if (this.mapValue == null) {
                            k = 0;
                        }
                        else {
                            k = this.mapValue.length;
                        }
                        mapValue = new Value[k + repeatedFieldArrayLength3];
                        if (this.mapValue != null) {
                            System.arraycopy(this.mapValue, 0, mapValue, 0, k);
                        }
                        this.mapValue = mapValue;
                        while (k < -1 + this.mapValue.length) {
                            codedInputByteBufferNano.readMessage(this.mapValue[k] = new Value());
                            codedInputByteBufferNano.readTag();
                            ++k;
                        }
                        codedInputByteBufferNano.readMessage(this.mapValue[k] = new Value());
                        continue;
                    }
                    case 50: {
                        this.macroReference = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 58: {
                        this.functionId = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 64: {
                        this.integer = codedInputByteBufferNano.readInt64();
                        continue;
                    }
                    case 72: {
                        this.containsReferences = codedInputByteBufferNano.readBool();
                        continue;
                    }
                    case 80: {
                        repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 80);
                        l = this.escaping.length;
                        escaping = new int[l + repeatedFieldArrayLength4];
                        System.arraycopy(this.escaping, 0, escaping, 0, l);
                        this.escaping = escaping;
                        while (l < -1 + this.escaping.length) {
                            this.escaping[l] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            ++l;
                        }
                        this.escaping[l] = codedInputByteBufferNano.readInt32();
                        continue;
                    }
                    case 90: {
                        repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                        if (this.templateToken == null) {
                            length = 0;
                        }
                        else {
                            length = this.templateToken.length;
                        }
                        templateToken = new Value[length + repeatedFieldArrayLength5];
                        if (this.templateToken != null) {
                            System.arraycopy(this.templateToken, 0, templateToken, 0, length);
                        }
                        this.templateToken = templateToken;
                        while (length < -1 + this.templateToken.length) {
                            codedInputByteBufferNano.readMessage(this.templateToken[length] = new Value());
                            codedInputByteBufferNano.readTag();
                            ++length;
                        }
                        codedInputByteBufferNano.readMessage(this.templateToken[length] = new Value());
                        continue;
                    }
                    case 96: {
                        this.boolean_ = codedInputByteBufferNano.readBool();
                        continue;
                    }
                    case 106: {
                        this.tagReference = codedInputByteBufferNano.readString();
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Value[] listItem;
            int length;
            int i;
            Value[] mapKey;
            int length2;
            int j;
            Value[] mapValue;
            int length3;
            int k;
            int[] escaping;
            int length4;
            int l;
            Value[] templateToken;
            int length5;
            int n;
            codedOutputByteBufferNano.writeInt32(1, this.type);
            if (!this.string.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.string);
            }
            if (this.listItem != null) {
                listItem = this.listItem;
                for (int length = listItem.length, i = 0; i < length; ++i) {
                    codedOutputByteBufferNano.writeMessage(3, listItem[i]);
                }
            }
            if (this.mapKey != null) {
                mapKey = this.mapKey;
                for (int length2 = mapKey.length, j = 0; j < length2; ++j) {
                    codedOutputByteBufferNano.writeMessage(4, mapKey[j]);
                }
            }
            if (this.mapValue != null) {
                mapValue = this.mapValue;
                for (int length3 = mapValue.length, k = 0; k < length3; ++k) {
                    codedOutputByteBufferNano.writeMessage(5, mapValue[k]);
                }
            }
            if (!this.macroReference.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.macroReference);
            }
            if (!this.functionId.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.functionId);
            }
            if (this.integer != 0L) {
                codedOutputByteBufferNano.writeInt64(8, this.integer);
            }
            if (this.containsReferences) {
                codedOutputByteBufferNano.writeBool(9, this.containsReferences);
            }
            if (this.escaping != null && this.escaping.length > 0) {
                escaping = this.escaping;
                for (int length4 = escaping.length, l = 0; l < length4; ++l) {
                    codedOutputByteBufferNano.writeInt32(10, escaping[l]);
                }
            }
            if (this.templateToken != null) {
                templateToken = this.templateToken;
                for (int length5 = templateToken.length, n = 0; n < length5; ++n) {
                    codedOutputByteBufferNano.writeMessage(11, templateToken[n]);
                }
            }
            if (this.boolean_) {
                codedOutputByteBufferNano.writeBool(12, this.boolean_);
            }
            if (!this.tagReference.equals("")) {
                codedOutputByteBufferNano.writeString(13, this.tagReference);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
        
        public interface Escaping
        {
            public static final int CONVERT_JS_VALUE_TO_EXPRESSION = 16;
            public static final int ESCAPE_CSS_STRING = 10;
            public static final int ESCAPE_HTML = 1;
            public static final int ESCAPE_HTML_ATTRIBUTE = 3;
            public static final int ESCAPE_HTML_ATTRIBUTE_NOSPACE = 4;
            public static final int ESCAPE_HTML_RCDATA = 2;
            public static final int ESCAPE_JS_REGEX = 9;
            public static final int ESCAPE_JS_STRING = 7;
            public static final int ESCAPE_JS_VALUE = 8;
            public static final int ESCAPE_URI = 12;
            public static final int FILTER_CSS_VALUE = 11;
            public static final int FILTER_HTML_ATTRIBUTES = 6;
            public static final int FILTER_HTML_ELEMENT_NAME = 5;
            public static final int FILTER_NORMALIZE_URI = 14;
            public static final int NORMALIZE_URI = 13;
            public static final int NO_AUTOESCAPE = 15;
            public static final int TEXT = 17;
        }
        
        public interface Type
        {
            public static final int BOOLEAN = 8;
            public static final int FUNCTION_ID = 5;
            public static final int INTEGER = 6;
            public static final int LIST = 2;
            public static final int MACRO_REFERENCE = 4;
            public static final int MAP = 3;
            public static final int STRING = 1;
            public static final int TAG_REFERENCE = 9;
            public static final int TEMPLATE = 7;
        }
    }
}
