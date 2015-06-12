// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.containertag.proto;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.protobuf.nano.Extension;
import java.util.ArrayList;
import com.google.tagmanager.protobuf.nano.UnknownFieldData;
import java.util.List;
import com.google.tagmanager.protobuf.nano.WireFormatNano;
import com.google.tagmanager.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Arrays;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;
import java.io.IOException;
import com.google.tagmanager.protobuf.nano.CodedInputByteBufferNano;
import com.google.tagmanager.protobuf.nano.ExtendableMessageNano;

public interface Debug
{
    public static final class DataLayerEventEvaluationInfo extends ExtendableMessageNano
    {
        public static final DataLayerEventEvaluationInfo[] EMPTY_ARRAY;
        public ResolvedFunctionCall[] results;
        public RuleEvaluationStepInfo rulesEvaluation;
        
        static {
            EMPTY_ARRAY = new DataLayerEventEvaluationInfo[0];
        }
        
        public DataLayerEventEvaluationInfo() {
            this.rulesEvaluation = null;
            this.results = ResolvedFunctionCall.EMPTY_ARRAY;
        }
        
        public static DataLayerEventEvaluationInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new DataLayerEventEvaluationInfo().mergeFrom(codedInputByteBufferNano);
        }
        
        public static DataLayerEventEvaluationInfo parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new DataLayerEventEvaluationInfo(), array);
        }
        
        public final DataLayerEventEvaluationInfo clear() {
            this.rulesEvaluation = null;
            this.results = ResolvedFunctionCall.EMPTY_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            DataLayerEventEvaluationInfo dataLayerEventEvaluationInfo;
            if (o != this) {
                if (!(o instanceof DataLayerEventEvaluationInfo)) {
                    return false;
                }
                dataLayerEventEvaluationInfo = (DataLayerEventEvaluationInfo)o;
                if (this.rulesEvaluation == null) {
                    if (dataLayerEventEvaluationInfo.rulesEvaluation != null) {
                        return false;
                    }
                }
                else if (!this.rulesEvaluation.equals(dataLayerEventEvaluationInfo.rulesEvaluation)) {
                    return false;
                }
                if (Arrays.equals(this.results, dataLayerEventEvaluationInfo.results)) {
                    if (this.unknownFieldData == null) {
                        if (dataLayerEventEvaluationInfo.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(dataLayerEventEvaluationInfo.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            RuleEvaluationStepInfo rulesEvaluation;
            int n;
            ResolvedFunctionCall[] results;
            int length;
            int i;
            rulesEvaluation = this.rulesEvaluation;
            n = 0;
            if (rulesEvaluation != null) {
                n = 0 + CodedOutputByteBufferNano.computeMessageSize(1, this.rulesEvaluation);
            }
            if (this.results != null) {
                results = this.results;
                for (int length = results.length, i = 0; i < length; ++i) {
                    n += CodedOutputByteBufferNano.computeMessageSize(2, results[i]);
                }
            }
            return this.cachedSize = n + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int hashCode;
            int n;
            int i;
            int n2;
            int hashCode2;
            int n3;
            List<UnknownFieldData> unknownFieldData;
            int hashCode3;
            if (this.rulesEvaluation == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.rulesEvaluation.hashCode();
            }
            n = hashCode + 527;
            if (this.results == null) {
                n *= 31;
            }
            else {
                for (int i = 0; i < this.results.length; ++i) {
                    n2 = n * 31;
                    if (this.results[i] == null) {
                        hashCode2 = 0;
                    }
                    else {
                        hashCode2 = this.results[i].hashCode();
                    }
                    n = n2 + hashCode2;
                }
            }
            n3 = n * 31;
            unknownFieldData = this.unknownFieldData;
            hashCode3 = 0;
            if (unknownFieldData != null) {
                hashCode3 = this.unknownFieldData.hashCode();
            }
            return n3 + hashCode3;
        }
        
        @Override
        public DataLayerEventEvaluationInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int repeatedFieldArrayLength;
            int i;
            ResolvedFunctionCall[] results;
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
                    case 10: {
                        codedInputByteBufferNano.readMessage(this.rulesEvaluation = new RuleEvaluationStepInfo());
                        continue;
                    }
                    case 18: {
                        repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        if (this.results == null) {
                            i = 0;
                        }
                        else {
                            i = this.results.length;
                        }
                        results = new ResolvedFunctionCall[i + repeatedFieldArrayLength];
                        if (this.results != null) {
                            System.arraycopy(this.results, 0, results, 0, i);
                        }
                        this.results = results;
                        while (i < -1 + this.results.length) {
                            codedInputByteBufferNano.readMessage(this.results[i] = new ResolvedFunctionCall());
                            codedInputByteBufferNano.readTag();
                            ++i;
                        }
                        codedInputByteBufferNano.readMessage(this.results[i] = new ResolvedFunctionCall());
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            ResolvedFunctionCall[] results;
            int length;
            int i;
            if (this.rulesEvaluation != null) {
                codedOutputByteBufferNano.writeMessage(1, this.rulesEvaluation);
            }
            if (this.results != null) {
                results = this.results;
                for (int length = results.length, i = 0; i < length; ++i) {
                    codedOutputByteBufferNano.writeMessage(2, results[i]);
                }
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public static final class DebugEvents extends ExtendableMessageNano
    {
        public static final DebugEvents[] EMPTY_ARRAY;
        public EventInfo[] event;
        
        static {
            EMPTY_ARRAY = new DebugEvents[0];
        }
        
        public DebugEvents() {
            this.event = EventInfo.EMPTY_ARRAY;
        }
        
        public static DebugEvents parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new DebugEvents().mergeFrom(codedInputByteBufferNano);
        }
        
        public static DebugEvents parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new DebugEvents(), array);
        }
        
        public final DebugEvents clear() {
            this.event = EventInfo.EMPTY_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            DebugEvents debugEvents;
            if (o != this) {
                if (!(o instanceof DebugEvents)) {
                    return false;
                }
                debugEvents = (DebugEvents)o;
                if (Arrays.equals(this.event, debugEvents.event)) {
                    if (this.unknownFieldData == null) {
                        if (debugEvents.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(debugEvents.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            EventInfo[] event;
            int n;
            EventInfo[] event2;
            int length;
            int i;
            event = this.event;
            n = 0;
            if (event != null) {
                event2 = this.event;
                for (int length = event2.length, i = 0; i < length; ++i) {
                    n += CodedOutputByteBufferNano.computeMessageSize(1, event2[i]);
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
            int n3;
            List<UnknownFieldData> unknownFieldData;
            int hashCode2;
            n = 17;
            if (this.event == null) {
                n *= 31;
            }
            else {
                for (int i = 0; i < this.event.length; ++i) {
                    n2 = n * 31;
                    if (this.event[i] == null) {
                        hashCode = 0;
                    }
                    else {
                        hashCode = this.event[i].hashCode();
                    }
                    n = n2 + hashCode;
                }
            }
            n3 = n * 31;
            unknownFieldData = this.unknownFieldData;
            hashCode2 = 0;
            if (unknownFieldData != null) {
                hashCode2 = this.unknownFieldData.hashCode();
            }
            return n3 + hashCode2;
        }
        
        @Override
        public DebugEvents mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int repeatedFieldArrayLength;
            int i;
            EventInfo[] event;
        Label_0062:
            while (true) {
                tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    default: {
                        if (this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList<UnknownFieldData>();
                        }
                        if (!WireFormatNano.storeUnknownField(this.unknownFieldData, codedInputByteBufferNano, tag)) {
                            break Label_0062;
                        }
                        continue;
                    }
                    case 0: {
                        break Label_0062;
                    }
                    case 10: {
                        repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        if (this.event == null) {
                            i = 0;
                        }
                        else {
                            i = this.event.length;
                        }
                        event = new EventInfo[i + repeatedFieldArrayLength];
                        if (this.event != null) {
                            System.arraycopy(this.event, 0, event, 0, i);
                        }
                        this.event = event;
                        while (i < -1 + this.event.length) {
                            codedInputByteBufferNano.readMessage(this.event[i] = new EventInfo());
                            codedInputByteBufferNano.readTag();
                            ++i;
                        }
                        codedInputByteBufferNano.readMessage(this.event[i] = new EventInfo());
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            EventInfo[] event;
            int length;
            int i;
            if (this.event != null) {
                event = this.event;
                for (int length = event.length, i = 0; i < length; ++i) {
                    codedOutputByteBufferNano.writeMessage(1, event[i]);
                }
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public static final class EventInfo extends ExtendableMessageNano
    {
        public static final EventInfo[] EMPTY_ARRAY;
        public String containerId;
        public String containerVersion;
        public DataLayerEventEvaluationInfo dataLayerEventResult;
        public int eventType;
        public String key;
        public MacroEvaluationInfo macroResult;
        
        static {
            EMPTY_ARRAY = new EventInfo[0];
        }
        
        public EventInfo() {
            this.eventType = 1;
            this.containerVersion = "";
            this.containerId = "";
            this.key = "";
            this.macroResult = null;
            this.dataLayerEventResult = null;
        }
        
        public static EventInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new EventInfo().mergeFrom(codedInputByteBufferNano);
        }
        
        public static EventInfo parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new EventInfo(), array);
        }
        
        public final EventInfo clear() {
            this.eventType = 1;
            this.containerVersion = "";
            this.containerId = "";
            this.key = "";
            this.macroResult = null;
            this.dataLayerEventResult = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            EventInfo eventInfo;
            if (o != this) {
                if (!(o instanceof EventInfo)) {
                    return false;
                }
                eventInfo = (EventInfo)o;
                if (this.eventType == eventInfo.eventType) {
                    if (this.containerVersion == null) {
                        if (eventInfo.containerVersion != null) {
                            return false;
                        }
                    }
                    else if (!this.containerVersion.equals(eventInfo.containerVersion)) {
                        return false;
                    }
                    if (this.containerId == null) {
                        if (eventInfo.containerId != null) {
                            return false;
                        }
                    }
                    else if (!this.containerId.equals(eventInfo.containerId)) {
                        return false;
                    }
                    if (this.key == null) {
                        if (eventInfo.key != null) {
                            return false;
                        }
                    }
                    else if (!this.key.equals(eventInfo.key)) {
                        return false;
                    }
                    if (this.macroResult == null) {
                        if (eventInfo.macroResult != null) {
                            return false;
                        }
                    }
                    else if (!this.macroResult.equals(eventInfo.macroResult)) {
                        return false;
                    }
                    if (this.dataLayerEventResult == null) {
                        if (eventInfo.dataLayerEventResult != null) {
                            return false;
                        }
                    }
                    else if (!this.dataLayerEventResult.equals(eventInfo.dataLayerEventResult)) {
                        return false;
                    }
                    if (this.unknownFieldData == null) {
                        if (eventInfo.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(eventInfo.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            int eventType;
            int n;
            eventType = this.eventType;
            n = 0;
            if (eventType != 1) {
                n = 0 + CodedOutputByteBufferNano.computeInt32Size(1, this.eventType);
            }
            if (!this.containerVersion.equals("")) {
                n += CodedOutputByteBufferNano.computeStringSize(2, this.containerVersion);
            }
            if (!this.containerId.equals("")) {
                n += CodedOutputByteBufferNano.computeStringSize(3, this.containerId);
            }
            if (!this.key.equals("")) {
                n += CodedOutputByteBufferNano.computeStringSize(4, this.key);
            }
            if (this.macroResult != null) {
                n += CodedOutputByteBufferNano.computeMessageSize(6, this.macroResult);
            }
            if (this.dataLayerEventResult != null) {
                n += CodedOutputByteBufferNano.computeMessageSize(7, this.dataLayerEventResult);
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
            int hashCode3;
            int n4;
            int hashCode4;
            int n5;
            int hashCode5;
            int n6;
            List<UnknownFieldData> unknownFieldData;
            int hashCode6;
            n = 31 * (527 + this.eventType);
            if (this.containerVersion == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.containerVersion.hashCode();
            }
            n2 = 31 * (n + hashCode);
            if (this.containerId == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = this.containerId.hashCode();
            }
            n3 = 31 * (n2 + hashCode2);
            if (this.key == null) {
                hashCode3 = 0;
            }
            else {
                hashCode3 = this.key.hashCode();
            }
            n4 = 31 * (n3 + hashCode3);
            if (this.macroResult == null) {
                hashCode4 = 0;
            }
            else {
                hashCode4 = this.macroResult.hashCode();
            }
            n5 = 31 * (n4 + hashCode4);
            if (this.dataLayerEventResult == null) {
                hashCode5 = 0;
            }
            else {
                hashCode5 = this.dataLayerEventResult.hashCode();
            }
            n6 = 31 * (n5 + hashCode5);
            unknownFieldData = this.unknownFieldData;
            hashCode6 = 0;
            if (unknownFieldData != null) {
                hashCode6 = this.unknownFieldData.hashCode();
            }
            return n6 + hashCode6;
        }
        
        @Override
        public EventInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int int32;
        Label_0102:
            while (true) {
                tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    default: {
                        if (this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList<UnknownFieldData>();
                        }
                        if (!WireFormatNano.storeUnknownField(this.unknownFieldData, codedInputByteBufferNano, tag)) {
                            break Label_0102;
                        }
                        continue;
                    }
                    case 0: {
                        break Label_0102;
                    }
                    case 8: {
                        int32 = codedInputByteBufferNano.readInt32();
                        if (int32 == 1 || int32 == 2) {
                            this.eventType = int32;
                            continue;
                        }
                        this.eventType = 1;
                        continue;
                    }
                    case 18: {
                        this.containerVersion = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 26: {
                        this.containerId = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 34: {
                        this.key = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 50: {
                        codedInputByteBufferNano.readMessage(this.macroResult = new MacroEvaluationInfo());
                        continue;
                    }
                    case 58: {
                        codedInputByteBufferNano.readMessage(this.dataLayerEventResult = new DataLayerEventEvaluationInfo());
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (this.eventType != 1) {
                codedOutputByteBufferNano.writeInt32(1, this.eventType);
            }
            if (!this.containerVersion.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.containerVersion);
            }
            if (!this.containerId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.containerId);
            }
            if (!this.key.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.key);
            }
            if (this.macroResult != null) {
                codedOutputByteBufferNano.writeMessage(6, this.macroResult);
            }
            if (this.dataLayerEventResult != null) {
                codedOutputByteBufferNano.writeMessage(7, this.dataLayerEventResult);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
        
        public interface EventType
        {
            public static final int DATA_LAYER_EVENT = 1;
            public static final int MACRO_REFERENCE = 2;
        }
    }
    
    public static final class MacroEvaluationInfo extends ExtendableMessageNano
    {
        public static final MacroEvaluationInfo[] EMPTY_ARRAY;
        public static final Extension<MacroEvaluationInfo> macro;
        public ResolvedFunctionCall result;
        public RuleEvaluationStepInfo rulesEvaluation;
        
        static {
            EMPTY_ARRAY = new MacroEvaluationInfo[0];
            macro = Extension.create(47497405, (Extension.TypeLiteral<MacroEvaluationInfo>)new Extension.TypeLiteral<MacroEvaluationInfo>() {});
        }
        
        public MacroEvaluationInfo() {
            this.rulesEvaluation = null;
            this.result = null;
        }
        
        public static MacroEvaluationInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new MacroEvaluationInfo().mergeFrom(codedInputByteBufferNano);
        }
        
        public static MacroEvaluationInfo parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new MacroEvaluationInfo(), array);
        }
        
        public final MacroEvaluationInfo clear() {
            this.rulesEvaluation = null;
            this.result = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            MacroEvaluationInfo macroEvaluationInfo;
            if (o != this) {
                if (!(o instanceof MacroEvaluationInfo)) {
                    return false;
                }
                macroEvaluationInfo = (MacroEvaluationInfo)o;
                if (this.rulesEvaluation == null) {
                    if (macroEvaluationInfo.rulesEvaluation != null) {
                        return false;
                    }
                }
                else if (!this.rulesEvaluation.equals(macroEvaluationInfo.rulesEvaluation)) {
                    return false;
                }
                if (this.result == null) {
                    if (macroEvaluationInfo.result != null) {
                        return false;
                    }
                }
                else if (!this.result.equals(macroEvaluationInfo.result)) {
                    return false;
                }
                if (this.unknownFieldData == null) {
                    if (macroEvaluationInfo.unknownFieldData == null) {
                        return true;
                    }
                }
                else if (this.unknownFieldData.equals(macroEvaluationInfo.unknownFieldData)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            RuleEvaluationStepInfo rulesEvaluation;
            int n;
            rulesEvaluation = this.rulesEvaluation;
            n = 0;
            if (rulesEvaluation != null) {
                n = 0 + CodedOutputByteBufferNano.computeMessageSize(1, this.rulesEvaluation);
            }
            if (this.result != null) {
                n += CodedOutputByteBufferNano.computeMessageSize(3, this.result);
            }
            return this.cachedSize = n + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int hashCode;
            int n;
            int hashCode2;
            int n2;
            List<UnknownFieldData> unknownFieldData;
            int hashCode3;
            if (this.rulesEvaluation == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.rulesEvaluation.hashCode();
            }
            n = 31 * (hashCode + 527);
            if (this.result == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = this.result.hashCode();
            }
            n2 = 31 * (n + hashCode2);
            unknownFieldData = this.unknownFieldData;
            hashCode3 = 0;
            if (unknownFieldData != null) {
                hashCode3 = this.unknownFieldData.hashCode();
            }
            return n2 + hashCode3;
        }
        
        @Override
        public MacroEvaluationInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                    case 10: {
                        codedInputByteBufferNano.readMessage(this.rulesEvaluation = new RuleEvaluationStepInfo());
                        continue;
                    }
                    case 26: {
                        codedInputByteBufferNano.readMessage(this.result = new ResolvedFunctionCall());
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (this.rulesEvaluation != null) {
                codedOutputByteBufferNano.writeMessage(1, this.rulesEvaluation);
            }
            if (this.result != null) {
                codedOutputByteBufferNano.writeMessage(3, this.result);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public static final class ResolvedFunctionCall extends ExtendableMessageNano
    {
        public static final ResolvedFunctionCall[] EMPTY_ARRAY;
        public String associatedRuleName;
        public ResolvedProperty[] properties;
        public TypeSystem.Value result;
        
        static {
            EMPTY_ARRAY = new ResolvedFunctionCall[0];
        }
        
        public ResolvedFunctionCall() {
            this.properties = ResolvedProperty.EMPTY_ARRAY;
            this.result = null;
            this.associatedRuleName = "";
        }
        
        public static ResolvedFunctionCall parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new ResolvedFunctionCall().mergeFrom(codedInputByteBufferNano);
        }
        
        public static ResolvedFunctionCall parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new ResolvedFunctionCall(), array);
        }
        
        public final ResolvedFunctionCall clear() {
            this.properties = ResolvedProperty.EMPTY_ARRAY;
            this.result = null;
            this.associatedRuleName = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            ResolvedFunctionCall resolvedFunctionCall;
            if (o != this) {
                if (!(o instanceof ResolvedFunctionCall)) {
                    return false;
                }
                resolvedFunctionCall = (ResolvedFunctionCall)o;
                if (Arrays.equals(this.properties, resolvedFunctionCall.properties)) {
                    if (this.result == null) {
                        if (resolvedFunctionCall.result != null) {
                            return false;
                        }
                    }
                    else if (!this.result.equals(resolvedFunctionCall.result)) {
                        return false;
                    }
                    if (this.associatedRuleName == null) {
                        if (resolvedFunctionCall.associatedRuleName != null) {
                            return false;
                        }
                    }
                    else if (!this.associatedRuleName.equals(resolvedFunctionCall.associatedRuleName)) {
                        return false;
                    }
                    if (this.unknownFieldData == null) {
                        if (resolvedFunctionCall.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(resolvedFunctionCall.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            ResolvedProperty[] properties;
            int n;
            ResolvedProperty[] properties2;
            int length;
            int i;
            properties = this.properties;
            n = 0;
            if (properties != null) {
                properties2 = this.properties;
                for (int length = properties2.length, i = 0; i < length; ++i) {
                    n += CodedOutputByteBufferNano.computeMessageSize(1, properties2[i]);
                }
            }
            if (this.result != null) {
                n += CodedOutputByteBufferNano.computeMessageSize(2, this.result);
            }
            if (!this.associatedRuleName.equals("")) {
                n += CodedOutputByteBufferNano.computeStringSize(3, this.associatedRuleName);
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
            if (this.properties == null) {
                n *= 31;
            }
            else {
                for (int i = 0; i < this.properties.length; ++i) {
                    n2 = n * 31;
                    if (this.properties[i] == null) {
                        hashCode = 0;
                    }
                    else {
                        hashCode = this.properties[i].hashCode();
                    }
                    n = n2 + hashCode;
                }
            }
            n3 = n * 31;
            if (this.result == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = this.result.hashCode();
            }
            n4 = 31 * (n3 + hashCode2);
            if (this.associatedRuleName == null) {
                hashCode3 = 0;
            }
            else {
                hashCode3 = this.associatedRuleName.hashCode();
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
        public ResolvedFunctionCall mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int repeatedFieldArrayLength;
            int i;
            ResolvedProperty[] properties;
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
                        if (this.properties == null) {
                            i = 0;
                        }
                        else {
                            i = this.properties.length;
                        }
                        properties = new ResolvedProperty[i + repeatedFieldArrayLength];
                        if (this.properties != null) {
                            System.arraycopy(this.properties, 0, properties, 0, i);
                        }
                        this.properties = properties;
                        while (i < -1 + this.properties.length) {
                            codedInputByteBufferNano.readMessage(this.properties[i] = new ResolvedProperty());
                            codedInputByteBufferNano.readTag();
                            ++i;
                        }
                        codedInputByteBufferNano.readMessage(this.properties[i] = new ResolvedProperty());
                        continue;
                    }
                    case 18: {
                        codedInputByteBufferNano.readMessage(this.result = new TypeSystem.Value());
                        continue;
                    }
                    case 26: {
                        this.associatedRuleName = codedInputByteBufferNano.readString();
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            ResolvedProperty[] properties;
            int length;
            int i;
            if (this.properties != null) {
                properties = this.properties;
                for (int length = properties.length, i = 0; i < length; ++i) {
                    codedOutputByteBufferNano.writeMessage(1, properties[i]);
                }
            }
            if (this.result != null) {
                codedOutputByteBufferNano.writeMessage(2, this.result);
            }
            if (!this.associatedRuleName.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.associatedRuleName);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public static final class ResolvedProperty extends ExtendableMessageNano
    {
        public static final ResolvedProperty[] EMPTY_ARRAY;
        public String key;
        public TypeSystem.Value value;
        
        static {
            EMPTY_ARRAY = new ResolvedProperty[0];
        }
        
        public ResolvedProperty() {
            this.key = "";
            this.value = null;
        }
        
        public static ResolvedProperty parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new ResolvedProperty().mergeFrom(codedInputByteBufferNano);
        }
        
        public static ResolvedProperty parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new ResolvedProperty(), array);
        }
        
        public final ResolvedProperty clear() {
            this.key = "";
            this.value = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            ResolvedProperty resolvedProperty;
            if (o != this) {
                if (!(o instanceof ResolvedProperty)) {
                    return false;
                }
                resolvedProperty = (ResolvedProperty)o;
                if (this.key == null) {
                    if (resolvedProperty.key != null) {
                        return false;
                    }
                }
                else if (!this.key.equals(resolvedProperty.key)) {
                    return false;
                }
                if (this.value == null) {
                    if (resolvedProperty.value != null) {
                        return false;
                    }
                }
                else if (!this.value.equals(resolvedProperty.value)) {
                    return false;
                }
                if (this.unknownFieldData == null) {
                    if (resolvedProperty.unknownFieldData == null) {
                        return true;
                    }
                }
                else if (this.unknownFieldData.equals(resolvedProperty.unknownFieldData)) {
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
            equals = this.key.equals("");
            n = 0;
            if (!equals) {
                n = 0 + CodedOutputByteBufferNano.computeStringSize(1, this.key);
            }
            if (this.value != null) {
                n += CodedOutputByteBufferNano.computeMessageSize(2, this.value);
            }
            return this.cachedSize = n + WireFormatNano.computeWireSize(this.unknownFieldData);
        }
        
        @Override
        public int hashCode() {
            int hashCode;
            int n;
            int hashCode2;
            int n2;
            List<UnknownFieldData> unknownFieldData;
            int hashCode3;
            if (this.key == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.key.hashCode();
            }
            n = 31 * (hashCode + 527);
            if (this.value == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = this.value.hashCode();
            }
            n2 = 31 * (n + hashCode2);
            unknownFieldData = this.unknownFieldData;
            hashCode3 = 0;
            if (unknownFieldData != null) {
                hashCode3 = this.unknownFieldData.hashCode();
            }
            return n2 + hashCode3;
        }
        
        @Override
        public ResolvedProperty mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                    case 10: {
                        this.key = codedInputByteBufferNano.readString();
                        continue;
                    }
                    case 18: {
                        codedInputByteBufferNano.readMessage(this.value = new TypeSystem.Value());
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
            if (this.value != null) {
                codedOutputByteBufferNano.writeMessage(2, this.value);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public static final class ResolvedRule extends ExtendableMessageNano
    {
        public static final ResolvedRule[] EMPTY_ARRAY;
        public ResolvedFunctionCall[] addMacros;
        public ResolvedFunctionCall[] addTags;
        public ResolvedFunctionCall[] negativePredicates;
        public ResolvedFunctionCall[] positivePredicates;
        public ResolvedFunctionCall[] removeMacros;
        public ResolvedFunctionCall[] removeTags;
        public TypeSystem.Value result;
        
        static {
            EMPTY_ARRAY = new ResolvedRule[0];
        }
        
        public ResolvedRule() {
            this.positivePredicates = ResolvedFunctionCall.EMPTY_ARRAY;
            this.negativePredicates = ResolvedFunctionCall.EMPTY_ARRAY;
            this.addTags = ResolvedFunctionCall.EMPTY_ARRAY;
            this.removeTags = ResolvedFunctionCall.EMPTY_ARRAY;
            this.addMacros = ResolvedFunctionCall.EMPTY_ARRAY;
            this.removeMacros = ResolvedFunctionCall.EMPTY_ARRAY;
            this.result = null;
        }
        
        public static ResolvedRule parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new ResolvedRule().mergeFrom(codedInputByteBufferNano);
        }
        
        public static ResolvedRule parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new ResolvedRule(), array);
        }
        
        public final ResolvedRule clear() {
            this.positivePredicates = ResolvedFunctionCall.EMPTY_ARRAY;
            this.negativePredicates = ResolvedFunctionCall.EMPTY_ARRAY;
            this.addTags = ResolvedFunctionCall.EMPTY_ARRAY;
            this.removeTags = ResolvedFunctionCall.EMPTY_ARRAY;
            this.addMacros = ResolvedFunctionCall.EMPTY_ARRAY;
            this.removeMacros = ResolvedFunctionCall.EMPTY_ARRAY;
            this.result = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            ResolvedRule resolvedRule;
            if (o != this) {
                if (!(o instanceof ResolvedRule)) {
                    return false;
                }
                resolvedRule = (ResolvedRule)o;
                if (Arrays.equals(this.positivePredicates, resolvedRule.positivePredicates) && Arrays.equals(this.negativePredicates, resolvedRule.negativePredicates) && Arrays.equals(this.addTags, resolvedRule.addTags) && Arrays.equals(this.removeTags, resolvedRule.removeTags) && Arrays.equals(this.addMacros, resolvedRule.addMacros) && Arrays.equals(this.removeMacros, resolvedRule.removeMacros)) {
                    if (this.result == null) {
                        if (resolvedRule.result != null) {
                            return false;
                        }
                    }
                    else if (!this.result.equals(resolvedRule.result)) {
                        return false;
                    }
                    if (this.unknownFieldData == null) {
                        if (resolvedRule.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(resolvedRule.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            ResolvedFunctionCall[] positivePredicates;
            int n;
            ResolvedFunctionCall[] positivePredicates2;
            int length;
            int i;
            ResolvedFunctionCall[] negativePredicates;
            int length2;
            int j;
            ResolvedFunctionCall[] addTags;
            int length3;
            int k;
            ResolvedFunctionCall[] removeTags;
            int length4;
            int l;
            ResolvedFunctionCall[] addMacros;
            int length5;
            int n2;
            ResolvedFunctionCall[] removeMacros;
            int length6;
            int n3;
            positivePredicates = this.positivePredicates;
            n = 0;
            if (positivePredicates != null) {
                positivePredicates2 = this.positivePredicates;
                for (int length = positivePredicates2.length, i = 0; i < length; ++i) {
                    n += CodedOutputByteBufferNano.computeMessageSize(1, positivePredicates2[i]);
                }
            }
            if (this.negativePredicates != null) {
                negativePredicates = this.negativePredicates;
                for (int length2 = negativePredicates.length, j = 0; j < length2; ++j) {
                    n += CodedOutputByteBufferNano.computeMessageSize(2, negativePredicates[j]);
                }
            }
            if (this.addTags != null) {
                addTags = this.addTags;
                for (int length3 = addTags.length, k = 0; k < length3; ++k) {
                    n += CodedOutputByteBufferNano.computeMessageSize(3, addTags[k]);
                }
            }
            if (this.removeTags != null) {
                removeTags = this.removeTags;
                for (int length4 = removeTags.length, l = 0; l < length4; ++l) {
                    n += CodedOutputByteBufferNano.computeMessageSize(4, removeTags[l]);
                }
            }
            if (this.addMacros != null) {
                addMacros = this.addMacros;
                for (int length5 = addMacros.length, n2 = 0; n2 < length5; ++n2) {
                    n += CodedOutputByteBufferNano.computeMessageSize(5, addMacros[n2]);
                }
            }
            if (this.removeMacros != null) {
                removeMacros = this.removeMacros;
                for (int length6 = removeMacros.length, n3 = 0; n3 < length6; ++n3) {
                    n += CodedOutputByteBufferNano.computeMessageSize(6, removeMacros[n3]);
                }
            }
            if (this.result != null) {
                n += CodedOutputByteBufferNano.computeMessageSize(7, this.result);
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
            int hashCode7;
            int n11;
            List<UnknownFieldData> unknownFieldData;
            int hashCode8;
            n = 17;
            if (this.positivePredicates == null) {
                n *= 31;
            }
            else {
                for (int i = 0; i < this.positivePredicates.length; ++i) {
                    n2 = n * 31;
                    if (this.positivePredicates[i] == null) {
                        hashCode = 0;
                    }
                    else {
                        hashCode = this.positivePredicates[i].hashCode();
                    }
                    n = n2 + hashCode;
                }
            }
            if (this.negativePredicates == null) {
                n *= 31;
            }
            else {
                for (int j = 0; j < this.negativePredicates.length; ++j) {
                    n3 = n * 31;
                    if (this.negativePredicates[j] == null) {
                        hashCode2 = 0;
                    }
                    else {
                        hashCode2 = this.negativePredicates[j].hashCode();
                    }
                    n = n3 + hashCode2;
                }
            }
            if (this.addTags == null) {
                n *= 31;
            }
            else {
                for (int k = 0; k < this.addTags.length; ++k) {
                    n4 = n * 31;
                    if (this.addTags[k] == null) {
                        hashCode3 = 0;
                    }
                    else {
                        hashCode3 = this.addTags[k].hashCode();
                    }
                    n = n4 + hashCode3;
                }
            }
            if (this.removeTags == null) {
                n *= 31;
            }
            else {
                for (int l = 0; l < this.removeTags.length; ++l) {
                    n5 = n * 31;
                    if (this.removeTags[l] == null) {
                        hashCode4 = 0;
                    }
                    else {
                        hashCode4 = this.removeTags[l].hashCode();
                    }
                    n = n5 + hashCode4;
                }
            }
            if (this.addMacros == null) {
                n *= 31;
            }
            else {
                for (int n6 = 0; n6 < this.addMacros.length; ++n6) {
                    n7 = n * 31;
                    if (this.addMacros[n6] == null) {
                        hashCode5 = 0;
                    }
                    else {
                        hashCode5 = this.addMacros[n6].hashCode();
                    }
                    n = n7 + hashCode5;
                }
            }
            if (this.removeMacros == null) {
                n *= 31;
            }
            else {
                for (int n8 = 0; n8 < this.removeMacros.length; ++n8) {
                    n9 = n * 31;
                    if (this.removeMacros[n8] == null) {
                        hashCode6 = 0;
                    }
                    else {
                        hashCode6 = this.removeMacros[n8].hashCode();
                    }
                    n = n9 + hashCode6;
                }
            }
            n10 = n * 31;
            if (this.result == null) {
                hashCode7 = 0;
            }
            else {
                hashCode7 = this.result.hashCode();
            }
            n11 = 31 * (n10 + hashCode7);
            unknownFieldData = this.unknownFieldData;
            hashCode8 = 0;
            if (unknownFieldData != null) {
                hashCode8 = this.unknownFieldData.hashCode();
            }
            return n11 + hashCode8;
        }
        
        @Override
        public ResolvedRule mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int repeatedFieldArrayLength;
            int i;
            ResolvedFunctionCall[] positivePredicates;
            int repeatedFieldArrayLength2;
            int j;
            ResolvedFunctionCall[] negativePredicates;
            int repeatedFieldArrayLength3;
            int k;
            ResolvedFunctionCall[] addTags;
            int repeatedFieldArrayLength4;
            int l;
            ResolvedFunctionCall[] removeTags;
            int repeatedFieldArrayLength5;
            int length;
            ResolvedFunctionCall[] addMacros;
            int repeatedFieldArrayLength6;
            int length2;
            ResolvedFunctionCall[] removeMacros;
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
                    case 10: {
                        repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        if (this.positivePredicates == null) {
                            i = 0;
                        }
                        else {
                            i = this.positivePredicates.length;
                        }
                        positivePredicates = new ResolvedFunctionCall[i + repeatedFieldArrayLength];
                        if (this.positivePredicates != null) {
                            System.arraycopy(this.positivePredicates, 0, positivePredicates, 0, i);
                        }
                        this.positivePredicates = positivePredicates;
                        while (i < -1 + this.positivePredicates.length) {
                            codedInputByteBufferNano.readMessage(this.positivePredicates[i] = new ResolvedFunctionCall());
                            codedInputByteBufferNano.readTag();
                            ++i;
                        }
                        codedInputByteBufferNano.readMessage(this.positivePredicates[i] = new ResolvedFunctionCall());
                        continue;
                    }
                    case 18: {
                        repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        if (this.negativePredicates == null) {
                            j = 0;
                        }
                        else {
                            j = this.negativePredicates.length;
                        }
                        negativePredicates = new ResolvedFunctionCall[j + repeatedFieldArrayLength2];
                        if (this.negativePredicates != null) {
                            System.arraycopy(this.negativePredicates, 0, negativePredicates, 0, j);
                        }
                        this.negativePredicates = negativePredicates;
                        while (j < -1 + this.negativePredicates.length) {
                            codedInputByteBufferNano.readMessage(this.negativePredicates[j] = new ResolvedFunctionCall());
                            codedInputByteBufferNano.readTag();
                            ++j;
                        }
                        codedInputByteBufferNano.readMessage(this.negativePredicates[j] = new ResolvedFunctionCall());
                        continue;
                    }
                    case 26: {
                        repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        if (this.addTags == null) {
                            k = 0;
                        }
                        else {
                            k = this.addTags.length;
                        }
                        addTags = new ResolvedFunctionCall[k + repeatedFieldArrayLength3];
                        if (this.addTags != null) {
                            System.arraycopy(this.addTags, 0, addTags, 0, k);
                        }
                        this.addTags = addTags;
                        while (k < -1 + this.addTags.length) {
                            codedInputByteBufferNano.readMessage(this.addTags[k] = new ResolvedFunctionCall());
                            codedInputByteBufferNano.readTag();
                            ++k;
                        }
                        codedInputByteBufferNano.readMessage(this.addTags[k] = new ResolvedFunctionCall());
                        continue;
                    }
                    case 34: {
                        repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        if (this.removeTags == null) {
                            l = 0;
                        }
                        else {
                            l = this.removeTags.length;
                        }
                        removeTags = new ResolvedFunctionCall[l + repeatedFieldArrayLength4];
                        if (this.removeTags != null) {
                            System.arraycopy(this.removeTags, 0, removeTags, 0, l);
                        }
                        this.removeTags = removeTags;
                        while (l < -1 + this.removeTags.length) {
                            codedInputByteBufferNano.readMessage(this.removeTags[l] = new ResolvedFunctionCall());
                            codedInputByteBufferNano.readTag();
                            ++l;
                        }
                        codedInputByteBufferNano.readMessage(this.removeTags[l] = new ResolvedFunctionCall());
                        continue;
                    }
                    case 42: {
                        repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        if (this.addMacros == null) {
                            length = 0;
                        }
                        else {
                            length = this.addMacros.length;
                        }
                        addMacros = new ResolvedFunctionCall[length + repeatedFieldArrayLength5];
                        if (this.addMacros != null) {
                            System.arraycopy(this.addMacros, 0, addMacros, 0, length);
                        }
                        this.addMacros = addMacros;
                        while (length < -1 + this.addMacros.length) {
                            codedInputByteBufferNano.readMessage(this.addMacros[length] = new ResolvedFunctionCall());
                            codedInputByteBufferNano.readTag();
                            ++length;
                        }
                        codedInputByteBufferNano.readMessage(this.addMacros[length] = new ResolvedFunctionCall());
                        continue;
                    }
                    case 50: {
                        repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        if (this.removeMacros == null) {
                            length2 = 0;
                        }
                        else {
                            length2 = this.removeMacros.length;
                        }
                        removeMacros = new ResolvedFunctionCall[length2 + repeatedFieldArrayLength6];
                        if (this.removeMacros != null) {
                            System.arraycopy(this.removeMacros, 0, removeMacros, 0, length2);
                        }
                        this.removeMacros = removeMacros;
                        while (length2 < -1 + this.removeMacros.length) {
                            codedInputByteBufferNano.readMessage(this.removeMacros[length2] = new ResolvedFunctionCall());
                            codedInputByteBufferNano.readTag();
                            ++length2;
                        }
                        codedInputByteBufferNano.readMessage(this.removeMacros[length2] = new ResolvedFunctionCall());
                        continue;
                    }
                    case 58: {
                        codedInputByteBufferNano.readMessage(this.result = new TypeSystem.Value());
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            ResolvedFunctionCall[] positivePredicates;
            int length;
            int i;
            ResolvedFunctionCall[] negativePredicates;
            int length2;
            int j;
            ResolvedFunctionCall[] addTags;
            int length3;
            int k;
            ResolvedFunctionCall[] removeTags;
            int length4;
            int l;
            ResolvedFunctionCall[] addMacros;
            int length5;
            int n;
            ResolvedFunctionCall[] removeMacros;
            int length6;
            int n2;
            if (this.positivePredicates != null) {
                positivePredicates = this.positivePredicates;
                for (int length = positivePredicates.length, i = 0; i < length; ++i) {
                    codedOutputByteBufferNano.writeMessage(1, positivePredicates[i]);
                }
            }
            if (this.negativePredicates != null) {
                negativePredicates = this.negativePredicates;
                for (int length2 = negativePredicates.length, j = 0; j < length2; ++j) {
                    codedOutputByteBufferNano.writeMessage(2, negativePredicates[j]);
                }
            }
            if (this.addTags != null) {
                addTags = this.addTags;
                for (int length3 = addTags.length, k = 0; k < length3; ++k) {
                    codedOutputByteBufferNano.writeMessage(3, addTags[k]);
                }
            }
            if (this.removeTags != null) {
                removeTags = this.removeTags;
                for (int length4 = removeTags.length, l = 0; l < length4; ++l) {
                    codedOutputByteBufferNano.writeMessage(4, removeTags[l]);
                }
            }
            if (this.addMacros != null) {
                addMacros = this.addMacros;
                for (int length5 = addMacros.length, n = 0; n < length5; ++n) {
                    codedOutputByteBufferNano.writeMessage(5, addMacros[n]);
                }
            }
            if (this.removeMacros != null) {
                removeMacros = this.removeMacros;
                for (int length6 = removeMacros.length, n2 = 0; n2 < length6; ++n2) {
                    codedOutputByteBufferNano.writeMessage(6, removeMacros[n2]);
                }
            }
            if (this.result != null) {
                codedOutputByteBufferNano.writeMessage(7, this.result);
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
    
    public static final class RuleEvaluationStepInfo extends ExtendableMessageNano
    {
        public static final RuleEvaluationStepInfo[] EMPTY_ARRAY;
        public ResolvedFunctionCall[] enabledFunctions;
        public ResolvedRule[] rules;
        
        static {
            EMPTY_ARRAY = new RuleEvaluationStepInfo[0];
        }
        
        public RuleEvaluationStepInfo() {
            this.rules = ResolvedRule.EMPTY_ARRAY;
            this.enabledFunctions = ResolvedFunctionCall.EMPTY_ARRAY;
        }
        
        public static RuleEvaluationStepInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new RuleEvaluationStepInfo().mergeFrom(codedInputByteBufferNano);
        }
        
        public static RuleEvaluationStepInfo parseFrom(byte[] array) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new RuleEvaluationStepInfo(), array);
        }
        
        public final RuleEvaluationStepInfo clear() {
            this.rules = ResolvedRule.EMPTY_ARRAY;
            this.enabledFunctions = ResolvedFunctionCall.EMPTY_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }
        
        @Override
        public final boolean equals(Object o) {
            RuleEvaluationStepInfo ruleEvaluationStepInfo;
            if (o != this) {
                if (!(o instanceof RuleEvaluationStepInfo)) {
                    return false;
                }
                ruleEvaluationStepInfo = (RuleEvaluationStepInfo)o;
                if (Arrays.equals(this.rules, ruleEvaluationStepInfo.rules) && Arrays.equals(this.enabledFunctions, ruleEvaluationStepInfo.enabledFunctions)) {
                    if (this.unknownFieldData == null) {
                        if (ruleEvaluationStepInfo.unknownFieldData == null) {
                            return true;
                        }
                    }
                    else if (this.unknownFieldData.equals(ruleEvaluationStepInfo.unknownFieldData)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        
        @Override
        public int getSerializedSize() {
            ResolvedRule[] rules;
            int n;
            ResolvedRule[] rules2;
            int length;
            int i;
            ResolvedFunctionCall[] enabledFunctions;
            int length2;
            int j;
            rules = this.rules;
            n = 0;
            if (rules != null) {
                rules2 = this.rules;
                for (int length = rules2.length, i = 0; i < length; ++i) {
                    n += CodedOutputByteBufferNano.computeMessageSize(1, rules2[i]);
                }
            }
            if (this.enabledFunctions != null) {
                enabledFunctions = this.enabledFunctions;
                for (int length2 = enabledFunctions.length, j = 0; j < length2; ++j) {
                    n += CodedOutputByteBufferNano.computeMessageSize(2, enabledFunctions[j]);
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
            int n4;
            List<UnknownFieldData> unknownFieldData;
            int hashCode3;
            n = 17;
            if (this.rules == null) {
                n *= 31;
            }
            else {
                for (int i = 0; i < this.rules.length; ++i) {
                    n2 = n * 31;
                    if (this.rules[i] == null) {
                        hashCode = 0;
                    }
                    else {
                        hashCode = this.rules[i].hashCode();
                    }
                    n = n2 + hashCode;
                }
            }
            if (this.enabledFunctions == null) {
                n *= 31;
            }
            else {
                for (int j = 0; j < this.enabledFunctions.length; ++j) {
                    n3 = n * 31;
                    if (this.enabledFunctions[j] == null) {
                        hashCode2 = 0;
                    }
                    else {
                        hashCode2 = this.enabledFunctions[j].hashCode();
                    }
                    n = n3 + hashCode2;
                }
            }
            n4 = n * 31;
            unknownFieldData = this.unknownFieldData;
            hashCode3 = 0;
            if (unknownFieldData != null) {
                hashCode3 = this.unknownFieldData.hashCode();
            }
            return n4 + hashCode3;
        }
        
        @Override
        public RuleEvaluationStepInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int tag;
            int repeatedFieldArrayLength;
            int i;
            ResolvedRule[] rules;
            int repeatedFieldArrayLength2;
            int j;
            ResolvedFunctionCall[] enabledFunctions;
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
                    case 10: {
                        repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        if (this.rules == null) {
                            i = 0;
                        }
                        else {
                            i = this.rules.length;
                        }
                        rules = new ResolvedRule[i + repeatedFieldArrayLength];
                        if (this.rules != null) {
                            System.arraycopy(this.rules, 0, rules, 0, i);
                        }
                        this.rules = rules;
                        while (i < -1 + this.rules.length) {
                            codedInputByteBufferNano.readMessage(this.rules[i] = new ResolvedRule());
                            codedInputByteBufferNano.readTag();
                            ++i;
                        }
                        codedInputByteBufferNano.readMessage(this.rules[i] = new ResolvedRule());
                        continue;
                    }
                    case 18: {
                        repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        if (this.enabledFunctions == null) {
                            j = 0;
                        }
                        else {
                            j = this.enabledFunctions.length;
                        }
                        enabledFunctions = new ResolvedFunctionCall[j + repeatedFieldArrayLength2];
                        if (this.enabledFunctions != null) {
                            System.arraycopy(this.enabledFunctions, 0, enabledFunctions, 0, j);
                        }
                        this.enabledFunctions = enabledFunctions;
                        while (j < -1 + this.enabledFunctions.length) {
                            codedInputByteBufferNano.readMessage(this.enabledFunctions[j] = new ResolvedFunctionCall());
                            codedInputByteBufferNano.readTag();
                            ++j;
                        }
                        codedInputByteBufferNano.readMessage(this.enabledFunctions[j] = new ResolvedFunctionCall());
                        continue;
                    }
                }
            }
            return this;
        }
        
        @Override
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            ResolvedRule[] rules;
            int length;
            int i;
            ResolvedFunctionCall[] enabledFunctions;
            int length2;
            int j;
            if (this.rules != null) {
                rules = this.rules;
                for (int length = rules.length, i = 0; i < length; ++i) {
                    codedOutputByteBufferNano.writeMessage(1, rules[i]);
                }
            }
            if (this.enabledFunctions != null) {
                enabledFunctions = this.enabledFunctions;
                for (int length2 = enabledFunctions.length, j = 0; j < length2; ++j) {
                    codedOutputByteBufferNano.writeMessage(2, enabledFunctions[j]);
                }
            }
            WireFormatNano.writeUnknownFields(this.unknownFieldData, codedOutputByteBufferNano);
        }
    }
}
