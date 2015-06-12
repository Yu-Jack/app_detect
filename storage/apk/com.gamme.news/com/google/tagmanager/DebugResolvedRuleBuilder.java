// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.proto.Debug;

class DebugResolvedRuleBuilder implements ResolvedRuleBuilder
{
    ResolvedFunctionCallTranslatorList addMacrosHolder;
    ResolvedFunctionCallTranslatorList addTagsHolder;
    ResolvedFunctionCallTranslatorList removeMacrosHolder;
    ResolvedFunctionCallTranslatorList removeTagsHolder;
    Debug.ResolvedRule resolvedRule;
    
    public DebugResolvedRuleBuilder(final Debug.ResolvedRule resolvedRule) {
        this.resolvedRule = resolvedRule;
        this.addMacrosHolder = new DebugResolvedFunctionCallListTranslator(1);
        this.removeMacrosHolder = new DebugResolvedFunctionCallListTranslator(2);
        this.addTagsHolder = new DebugResolvedFunctionCallListTranslator(3);
        this.removeTagsHolder = new DebugResolvedFunctionCallListTranslator(4);
    }
    
    public static Debug.ResolvedFunctionCall translateExpandedFunctionCall(final ResourceUtil.ExpandedFunctionCall expandedFunctionCall) {
        final Debug.ResolvedFunctionCall resolvedFunctionCall = new Debug.ResolvedFunctionCall();
        for (final Map.Entry<String, TypeSystem.Value> entry : expandedFunctionCall.getProperties().entrySet()) {
            final Debug.ResolvedProperty resolvedProperty = new Debug.ResolvedProperty();
            resolvedProperty.key = entry.getKey();
            resolvedProperty.value = DebugValueBuilder.copyImmutableValue(entry.getValue());
            resolvedFunctionCall.properties = ArrayUtils.appendToArray(resolvedFunctionCall.properties, resolvedProperty);
        }
        return resolvedFunctionCall;
    }
    
    @Override
    public ResolvedFunctionCallBuilder createNegativePredicate() {
        final Debug.ResolvedFunctionCall resolvedFunctionCall = new Debug.ResolvedFunctionCall();
        this.resolvedRule.negativePredicates = ArrayUtils.appendToArray(this.resolvedRule.negativePredicates, resolvedFunctionCall);
        return new DebugResolvedFunctionCallBuilder(resolvedFunctionCall);
    }
    
    @Override
    public ResolvedFunctionCallBuilder createPositivePredicate() {
        final Debug.ResolvedFunctionCall resolvedFunctionCall = new Debug.ResolvedFunctionCall();
        this.resolvedRule.positivePredicates = ArrayUtils.appendToArray(this.resolvedRule.positivePredicates, resolvedFunctionCall);
        return new DebugResolvedFunctionCallBuilder(resolvedFunctionCall);
    }
    
    @Override
    public ResolvedFunctionCallTranslatorList getAddedMacroFunctions() {
        return this.addMacrosHolder;
    }
    
    @Override
    public ResolvedFunctionCallTranslatorList getAddedTagFunctions() {
        return this.addTagsHolder;
    }
    
    @Override
    public ResolvedFunctionCallTranslatorList getRemovedMacroFunctions() {
        return this.removeMacrosHolder;
    }
    
    @Override
    public ResolvedFunctionCallTranslatorList getRemovedTagFunctions() {
        return this.removeTagsHolder;
    }
    
    @Override
    public void setValue(final TypeSystem.Value value) {
        this.resolvedRule.result = DebugValueBuilder.copyImmutableValue(value);
    }
    
    class DebugResolvedFunctionCallListTranslator implements ResolvedFunctionCallTranslatorList
    {
        private final int type;
        
        DebugResolvedFunctionCallListTranslator(final int type) {
            this.type = type;
        }
        
        @Override
        public void translateAndAddAll(final List<ResourceUtil.ExpandedFunctionCall> list, final List<String> list2) {
            final ArrayList list3 = new ArrayList<Object>(list.size());
            for (int i = 0; i < list.size(); ++i) {
                list3.add(DebugResolvedRuleBuilder.translateExpandedFunctionCall(list.get(i)));
                if (i < list2.size()) {
                    ((Debug.ResolvedFunctionCall)list3.get(i)).associatedRuleName = list2.get(i);
                }
                else {
                    ((Debug.ResolvedFunctionCall)list3.get(i)).associatedRuleName = "Unknown";
                }
            }
            final Debug.ResolvedFunctionCall[] array = list3.toArray(new Debug.ResolvedFunctionCall[0]);
            switch (this.type) {
                default: {
                    Log.e("unknown type in translateAndAddAll: " + this.type);
                }
                case 1: {
                    DebugResolvedRuleBuilder.this.resolvedRule.addMacros = array;
                }
                case 2: {
                    DebugResolvedRuleBuilder.this.resolvedRule.removeMacros = array;
                }
                case 3: {
                    DebugResolvedRuleBuilder.this.resolvedRule.addTags = array;
                }
                case 4: {
                    DebugResolvedRuleBuilder.this.resolvedRule.removeTags = array;
                }
            }
        }
        
        class Type
        {
            static final int ADD_MACROS = 1;
            static final int ADD_TAGS = 3;
            static final int REMOVE_MACROS = 2;
            static final int REMOVE_TAGS = 4;
        }
    }
}
