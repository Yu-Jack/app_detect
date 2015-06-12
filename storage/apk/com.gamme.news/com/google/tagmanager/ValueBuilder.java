// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

interface ValueBuilder
{
    MacroEvaluationInfoBuilder createValueMacroEvaluationInfoExtension();
    
    ValueBuilder getListItem(int p0);
    
    ValueBuilder getMapKey(int p0);
    
    ValueBuilder getMapValue(int p0);
    
    ValueBuilder getTemplateToken(int p0);
}
