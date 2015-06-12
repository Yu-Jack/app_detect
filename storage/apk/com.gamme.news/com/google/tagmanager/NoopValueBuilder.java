// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

class NoopValueBuilder implements ValueBuilder
{
    @Override
    public MacroEvaluationInfoBuilder createValueMacroEvaluationInfoExtension() {
        return new NoopMacroEvaluationInfoBuilder();
    }
    
    @Override
    public ValueBuilder getListItem(final int n) {
        return new NoopValueBuilder();
    }
    
    @Override
    public ValueBuilder getMapKey(final int n) {
        return new NoopValueBuilder();
    }
    
    @Override
    public ValueBuilder getMapValue(final int n) {
        return new NoopValueBuilder();
    }
    
    @Override
    public ValueBuilder getTemplateToken(final int n) {
        return new NoopValueBuilder();
    }
}
