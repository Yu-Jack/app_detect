// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;
import com.google.analytics.midtier.proto.containertag.TypeSystem;

class DebugValueBuilder implements ValueBuilder
{
    private TypeSystem.Value value;
    
    public DebugValueBuilder(final TypeSystem.Value value) {
        this.value = value;
    }
    
    public static TypeSystem.Value copyImmutableValue(final TypeSystem.Value value) {
        final TypeSystem.Value value2 = new TypeSystem.Value();
        try {
            MessageNano.mergeFrom(value2, MessageNano.toByteArray(value));
            return value2;
        }
        catch (InvalidProtocolBufferNanoException ex) {
            Log.e("Failed to copy runtime value into debug value");
            return value2;
        }
    }
    
    private void validateType(final int n, final int n2, final String s) {
        if (n != n2) {
            throw new TypeMismatchException(s, n2);
        }
    }
    
    @Override
    public MacroEvaluationInfoBuilder createValueMacroEvaluationInfoExtension() {
        this.validateType(4, this.value.type, "set macro evaluation extension");
        final Debug.MacroEvaluationInfo macroEvaluationInfo = new Debug.MacroEvaluationInfo();
        this.value.setExtension(Debug.MacroEvaluationInfo.macro, macroEvaluationInfo);
        return new DebugMacroEvaluationInfoBuilder(macroEvaluationInfo);
    }
    
    @Override
    public ValueBuilder getListItem(final int n) {
        this.validateType(2, this.value.type, "add new list item");
        return new DebugValueBuilder(this.value.listItem[n]);
    }
    
    @Override
    public ValueBuilder getMapKey(final int n) {
        this.validateType(3, this.value.type, "add new map key");
        return new DebugValueBuilder(this.value.mapKey[n]);
    }
    
    @Override
    public ValueBuilder getMapValue(final int n) {
        this.validateType(3, this.value.type, "add new map value");
        return new DebugValueBuilder(this.value.mapValue[n]);
    }
    
    @Override
    public ValueBuilder getTemplateToken(final int n) {
        this.validateType(7, this.value.type, "add template token");
        return new DebugValueBuilder(this.value.templateToken[n]);
    }
    
    private static class TypeMismatchException extends IllegalStateException
    {
        public TypeMismatchException(final String str, final int i) {
            super("Attempted operation: " + str + " on object of type: " + i);
        }
    }
}
