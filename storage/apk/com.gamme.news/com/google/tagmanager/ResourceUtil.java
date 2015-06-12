// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.analytics.containertag.proto.Serving;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

class ResourceUtil
{
    private static final int BUFFER_SIZE = 1024;
    
    public static void copyStream(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        final byte[] array = new byte[1024];
        while (true) {
            final int read = inputStream.read(array);
            if (read == -1) {
                break;
            }
            outputStream.write(array, 0, read);
        }
    }
    
    private static ExpandedFunctionCall expandFunctionCall(final Serving.FunctionCall functionCall, final Serving.Resource resource, final TypeSystem.Value[] array, final int n) throws InvalidResourceException {
        final ExpandedFunctionCallBuilder builder = ExpandedFunctionCall.newBuilder();
        final int[] property = functionCall.property;
        for (int length = property.length, i = 0; i < length; ++i) {
            final Serving.Property property2 = getWithBoundsCheck(resource.property, Integer.valueOf(property[i]), "properties");
            final String anObject = getWithBoundsCheck(resource.key, property2.key, "keys");
            final TypeSystem.Value pushAfterEvaluate = getWithBoundsCheck(array, property2.value, "values");
            if (Key.PUSH_AFTER_EVALUATE.toString().equals(anObject)) {
                builder.setPushAfterEvaluate(pushAfterEvaluate);
            }
            else {
                builder.addProperty(anObject, pushAfterEvaluate);
            }
        }
        return builder.build();
    }
    
    private static ExpandedRule expandRule(final Serving.Rule rule, final List<ExpandedFunctionCall> list, final List<ExpandedFunctionCall> list2, final List<ExpandedFunctionCall> list3, final Serving.Resource resource) {
        final ExpandedRuleBuilder builder = ExpandedRule.newBuilder();
        final int[] positivePredicate = rule.positivePredicate;
        for (int length = positivePredicate.length, i = 0; i < length; ++i) {
            builder.addPositivePredicate((ExpandedFunctionCall)list3.get(Integer.valueOf(positivePredicate[i])));
        }
        final int[] negativePredicate = rule.negativePredicate;
        for (int length2 = negativePredicate.length, j = 0; j < length2; ++j) {
            builder.addNegativePredicate((ExpandedFunctionCall)list3.get(Integer.valueOf(negativePredicate[j])));
        }
        final int[] addTag = rule.addTag;
        for (int length3 = addTag.length, k = 0; k < length3; ++k) {
            builder.addAddTag((ExpandedFunctionCall)list.get(Integer.valueOf(addTag[k])));
        }
        final int[] addTagRuleName = rule.addTagRuleName;
        for (int length4 = addTagRuleName.length, l = 0; l < length4; ++l) {
            builder.addAddTagRuleName(resource.value[Integer.valueOf(addTagRuleName[l])].string);
        }
        final int[] removeTag = rule.removeTag;
        for (int length5 = removeTag.length, n = 0; n < length5; ++n) {
            builder.addRemoveTag((ExpandedFunctionCall)list.get(Integer.valueOf(removeTag[n])));
        }
        final int[] removeTagRuleName = rule.removeTagRuleName;
        for (int length6 = removeTagRuleName.length, n2 = 0; n2 < length6; ++n2) {
            builder.addRemoveTagRuleName(resource.value[Integer.valueOf(removeTagRuleName[n2])].string);
        }
        final int[] addMacro = rule.addMacro;
        for (int length7 = addMacro.length, n3 = 0; n3 < length7; ++n3) {
            builder.addAddMacro((ExpandedFunctionCall)list2.get(Integer.valueOf(addMacro[n3])));
        }
        final int[] addMacroRuleName = rule.addMacroRuleName;
        for (int length8 = addMacroRuleName.length, n4 = 0; n4 < length8; ++n4) {
            builder.addAddMacroRuleName(resource.value[Integer.valueOf(addMacroRuleName[n4])].string);
        }
        final int[] removeMacro = rule.removeMacro;
        for (int length9 = removeMacro.length, n5 = 0; n5 < length9; ++n5) {
            builder.addRemoveMacro((ExpandedFunctionCall)list2.get(Integer.valueOf(removeMacro[n5])));
        }
        final int[] removeMacroRuleName = rule.removeMacroRuleName;
        for (int length10 = removeMacroRuleName.length, n6 = 0; n6 < length10; ++n6) {
            builder.addRemoveMacroRuleName(resource.value[Integer.valueOf(removeMacroRuleName[n6])].string);
        }
        return builder.build();
    }
    
    private static TypeSystem.Value expandValue(final int n, final Serving.Resource resource, final TypeSystem.Value[] array, final Set<Integer> obj) throws InvalidResourceException {
        if (obj.contains(n)) {
            logAndThrow("Value cycle detected.  Current value reference: " + n + "." + "  Previous value references: " + obj + ".");
        }
        final TypeSystem.Value obj2 = getWithBoundsCheck(resource.value, n, "values");
        if (array[n] != null) {
            return array[n];
        }
        obj.add(n);
        final int type = obj2.type;
        TypeSystem.Value value = null;
        switch (type) {
            case 2: {
                final Serving.ServingValue servingValue = getServingValue(obj2);
                value = newValueBasedOnValue(obj2);
                value.listItem = new TypeSystem.Value[servingValue.listItem.length];
                final int[] listItem = servingValue.listItem;
                final int length = listItem.length;
                int i = 0;
                int n2 = 0;
                while (i < length) {
                    final int n3 = listItem[i];
                    final TypeSystem.Value[] listItem2 = value.listItem;
                    final int n4 = n2 + 1;
                    listItem2[n2] = expandValue(n3, resource, array, obj);
                    ++i;
                    n2 = n4;
                }
                break;
            }
            case 3: {
                value = newValueBasedOnValue(obj2);
                final Serving.ServingValue servingValue2 = getServingValue(obj2);
                if (servingValue2.mapKey.length != servingValue2.mapValue.length) {
                    logAndThrow("Uneven map keys (" + servingValue2.mapKey.length + ") and map values (" + servingValue2.mapValue.length + ")");
                }
                value.mapKey = new TypeSystem.Value[servingValue2.mapKey.length];
                value.mapValue = new TypeSystem.Value[servingValue2.mapKey.length];
                final int[] mapKey = servingValue2.mapKey;
                final int length2 = mapKey.length;
                int j = 0;
                int n5 = 0;
                while (j < length2) {
                    final int n6 = mapKey[j];
                    final TypeSystem.Value[] mapKey2 = value.mapKey;
                    final int n7 = n5 + 1;
                    mapKey2[n5] = expandValue(n6, resource, array, obj);
                    ++j;
                    n5 = n7;
                }
                final int[] mapValue = servingValue2.mapValue;
                final int length3 = mapValue.length;
                int k = 0;
                int n8 = 0;
                while (k < length3) {
                    final int n9 = mapValue[k];
                    final TypeSystem.Value[] mapValue2 = value.mapValue;
                    final int n10 = n8 + 1;
                    mapValue2[n8] = expandValue(n9, resource, array, obj);
                    ++k;
                    n8 = n10;
                }
                break;
            }
            case 4: {
                value = newValueBasedOnValue(obj2);
                value.macroReference = Types.valueToString(expandValue(getServingValue(obj2).macroNameReference, resource, array, obj));
                break;
            }
            case 7: {
                value = newValueBasedOnValue(obj2);
                final Serving.ServingValue servingValue3 = getServingValue(obj2);
                value.templateToken = new TypeSystem.Value[servingValue3.templateToken.length];
                final int[] templateToken = servingValue3.templateToken;
                final int length4 = templateToken.length;
                int l = 0;
                int n11 = 0;
                while (l < length4) {
                    final int n12 = templateToken[l];
                    final TypeSystem.Value[] templateToken2 = value.templateToken;
                    final int n13 = n11 + 1;
                    templateToken2[n11] = expandValue(n12, resource, array, obj);
                    ++l;
                    n11 = n13;
                }
                break;
            }
            case 1:
            case 5:
            case 6:
            case 8: {
                value = obj2;
                break;
            }
        }
        if (value == null) {
            logAndThrow("Invalid value: " + obj2);
        }
        array[n] = value;
        obj.remove(n);
        return value;
    }
    
    public static ExpandedResource getExpandedResource(final Serving.Resource resource) throws InvalidResourceException {
        final TypeSystem.Value[] array = new TypeSystem.Value[resource.value.length];
        for (int i = 0; i < resource.value.length; ++i) {
            expandValue(i, resource, array, new HashSet<Integer>(0));
        }
        final ExpandedResourceBuilder builder = ExpandedResource.newBuilder();
        final ArrayList<ExpandedFunctionCall> list = new ArrayList<ExpandedFunctionCall>();
        for (int j = 0; j < resource.tag.length; ++j) {
            list.add(expandFunctionCall(resource.tag[j], resource, array, j));
        }
        final ArrayList<ExpandedFunctionCall> list2 = new ArrayList<ExpandedFunctionCall>();
        for (int k = 0; k < resource.predicate.length; ++k) {
            list2.add(expandFunctionCall(resource.predicate[k], resource, array, k));
        }
        final ArrayList<ExpandedFunctionCall> list3 = new ArrayList<ExpandedFunctionCall>();
        for (int l = 0; l < resource.macro.length; ++l) {
            final ExpandedFunctionCall expandFunctionCall = expandFunctionCall(resource.macro[l], resource, array, l);
            builder.addMacro(expandFunctionCall);
            list3.add(expandFunctionCall);
        }
        final Serving.Rule[] rule = resource.rule;
        for (int length = rule.length, n = 0; n < length; ++n) {
            builder.addRule(expandRule(rule[n], list, list3, list2, resource));
        }
        builder.setVersion(resource.version);
        builder.setResourceFormatVersion(resource.resourceFormatVersion);
        return builder.build();
    }
    
    private static Serving.ServingValue getServingValue(final TypeSystem.Value obj) throws InvalidResourceException {
        if (obj.getExtension(Serving.ServingValue.ext) == null) {
            logAndThrow("Expected a ServingValue and didn't get one. Value is: " + obj);
        }
        return obj.getExtension(Serving.ServingValue.ext);
    }
    
    private static <T> T getWithBoundsCheck(final List<T> list, final int i, final String str) throws InvalidResourceException {
        if (i < 0 || i >= list.size()) {
            logAndThrow("Index out of bounds detected: " + i + " in " + str);
        }
        return list.get(i);
    }
    
    private static <T> T getWithBoundsCheck(final T[] array, final int i, final String str) throws InvalidResourceException {
        if (i < 0 || i >= array.length) {
            logAndThrow("Index out of bounds detected: " + i + " in " + str);
        }
        return array[i];
    }
    
    private static void logAndThrow(final String s) throws InvalidResourceException {
        Log.e(s);
        throw new InvalidResourceException(s);
    }
    
    public static TypeSystem.Value newValueBasedOnValue(final TypeSystem.Value value) {
        final TypeSystem.Value value2 = new TypeSystem.Value();
        value2.type = value.type;
        value2.escaping = value.escaping.clone();
        if (value.containsReferences) {
            value2.containsReferences = value.containsReferences;
        }
        return value2;
    }
    
    public static class ExpandedFunctionCall
    {
        private final Map<String, TypeSystem.Value> mPropertiesMap;
        private final TypeSystem.Value mPushAfterEvaluate;
        
        private ExpandedFunctionCall(final Map<String, TypeSystem.Value> mPropertiesMap, final TypeSystem.Value mPushAfterEvaluate) {
            this.mPropertiesMap = mPropertiesMap;
            this.mPushAfterEvaluate = mPushAfterEvaluate;
        }
        
        public static ExpandedFunctionCallBuilder newBuilder() {
            return new ExpandedFunctionCallBuilder();
        }
        
        public Map<String, TypeSystem.Value> getProperties() {
            return Collections.unmodifiableMap((Map<? extends String, ? extends TypeSystem.Value>)this.mPropertiesMap);
        }
        
        public TypeSystem.Value getPushAfterEvaluate() {
            return this.mPushAfterEvaluate;
        }
        
        @Override
        public String toString() {
            return "Properties: " + this.getProperties() + " pushAfterEvaluate: " + this.mPushAfterEvaluate;
        }
        
        public void updateCacheableProperty(final String s, final TypeSystem.Value value) {
            this.mPropertiesMap.put(s, value);
        }
    }
    
    public static class ExpandedFunctionCallBuilder
    {
        private final Map<String, TypeSystem.Value> mPropertiesMap;
        private TypeSystem.Value mPushAfterEvaluate;
        
        private ExpandedFunctionCallBuilder() {
            this.mPropertiesMap = new HashMap<String, TypeSystem.Value>();
        }
        
        public ExpandedFunctionCallBuilder addProperty(final String s, final TypeSystem.Value value) {
            this.mPropertiesMap.put(s, value);
            return this;
        }
        
        public ExpandedFunctionCall build() {
            return new ExpandedFunctionCall((Map)this.mPropertiesMap, this.mPushAfterEvaluate);
        }
        
        public ExpandedFunctionCallBuilder setPushAfterEvaluate(final TypeSystem.Value mPushAfterEvaluate) {
            this.mPushAfterEvaluate = mPushAfterEvaluate;
            return this;
        }
    }
    
    public static class ExpandedResource
    {
        private final Map<String, List<ExpandedFunctionCall>> mMacros;
        private final int mResourceFormatVersion;
        private final List<ExpandedRule> mRules;
        private final String mVersion;
        
        private ExpandedResource(final List<ExpandedRule> list, final Map<String, List<ExpandedFunctionCall>> m, final String mVersion, final int mResourceFormatVersion) {
            this.mRules = Collections.unmodifiableList((List<? extends ExpandedRule>)list);
            this.mMacros = Collections.unmodifiableMap((Map<? extends String, ? extends List<ExpandedFunctionCall>>)m);
            this.mVersion = mVersion;
            this.mResourceFormatVersion = mResourceFormatVersion;
        }
        
        public static ExpandedResourceBuilder newBuilder() {
            return new ExpandedResourceBuilder();
        }
        
        public Map<String, List<ExpandedFunctionCall>> getAllMacros() {
            return this.mMacros;
        }
        
        public List<ExpandedFunctionCall> getMacros(final String s) {
            return this.mMacros.get(s);
        }
        
        public int getResourceFormatVersion() {
            return this.mResourceFormatVersion;
        }
        
        public List<ExpandedRule> getRules() {
            return this.mRules;
        }
        
        public String getVersion() {
            return this.mVersion;
        }
        
        @Override
        public String toString() {
            return "Rules: " + this.getRules() + "  Macros: " + this.mMacros;
        }
    }
    
    public static class ExpandedResourceBuilder
    {
        private final Map<String, List<ExpandedFunctionCall>> mMacros;
        private int mResourceFormatVersion;
        private final List<ExpandedRule> mRules;
        private String mVersion;
        
        private ExpandedResourceBuilder() {
            this.mRules = new ArrayList<ExpandedRule>();
            this.mMacros = new HashMap<String, List<ExpandedFunctionCall>>();
            this.mVersion = "";
            this.mResourceFormatVersion = 0;
        }
        
        public ExpandedResourceBuilder addMacro(final ExpandedFunctionCall expandedFunctionCall) {
            final String valueToString = Types.valueToString(expandedFunctionCall.getProperties().get(Key.INSTANCE_NAME.toString()));
            List<ExpandedFunctionCall> list = this.mMacros.get(valueToString);
            if (list == null) {
                list = new ArrayList<ExpandedFunctionCall>();
                this.mMacros.put(valueToString, list);
            }
            list.add(expandedFunctionCall);
            return this;
        }
        
        public ExpandedResourceBuilder addRule(final ExpandedRule expandedRule) {
            this.mRules.add(expandedRule);
            return this;
        }
        
        public ExpandedResource build() {
            return new ExpandedResource((List)this.mRules, (Map)this.mMacros, this.mVersion, this.mResourceFormatVersion);
        }
        
        public ExpandedResourceBuilder setResourceFormatVersion(final int mResourceFormatVersion) {
            this.mResourceFormatVersion = mResourceFormatVersion;
            return this;
        }
        
        public ExpandedResourceBuilder setVersion(final String mVersion) {
            this.mVersion = mVersion;
            return this;
        }
    }
    
    public static class ExpandedRule
    {
        private final List<String> mAddMacroRuleNames;
        private final List<ExpandedFunctionCall> mAddMacros;
        private final List<String> mAddTagRuleNames;
        private final List<ExpandedFunctionCall> mAddTags;
        private final List<ExpandedFunctionCall> mNegativePredicates;
        private final List<ExpandedFunctionCall> mPositivePredicates;
        private final List<String> mRemoveMacroRuleNames;
        private final List<ExpandedFunctionCall> mRemoveMacros;
        private final List<String> mRemoveTagRuleNames;
        private final List<ExpandedFunctionCall> mRemoveTags;
        
        private ExpandedRule(final List<ExpandedFunctionCall> list, final List<ExpandedFunctionCall> list2, final List<ExpandedFunctionCall> list3, final List<ExpandedFunctionCall> list4, final List<ExpandedFunctionCall> list5, final List<ExpandedFunctionCall> list6, final List<String> list7, final List<String> list8, final List<String> list9, final List<String> list10) {
            this.mPositivePredicates = Collections.unmodifiableList((List<? extends ExpandedFunctionCall>)list);
            this.mNegativePredicates = Collections.unmodifiableList((List<? extends ExpandedFunctionCall>)list2);
            this.mAddTags = Collections.unmodifiableList((List<? extends ExpandedFunctionCall>)list3);
            this.mRemoveTags = Collections.unmodifiableList((List<? extends ExpandedFunctionCall>)list4);
            this.mAddMacros = Collections.unmodifiableList((List<? extends ExpandedFunctionCall>)list5);
            this.mRemoveMacros = Collections.unmodifiableList((List<? extends ExpandedFunctionCall>)list6);
            this.mAddMacroRuleNames = Collections.unmodifiableList((List<? extends String>)list7);
            this.mRemoveMacroRuleNames = Collections.unmodifiableList((List<? extends String>)list8);
            this.mAddTagRuleNames = Collections.unmodifiableList((List<? extends String>)list9);
            this.mRemoveTagRuleNames = Collections.unmodifiableList((List<? extends String>)list10);
        }
        
        public static ExpandedRuleBuilder newBuilder() {
            return new ExpandedRuleBuilder();
        }
        
        public List<String> getAddMacroRuleNames() {
            return this.mAddMacroRuleNames;
        }
        
        public List<ExpandedFunctionCall> getAddMacros() {
            return this.mAddMacros;
        }
        
        public List<String> getAddTagRuleNames() {
            return this.mAddTagRuleNames;
        }
        
        public List<ExpandedFunctionCall> getAddTags() {
            return this.mAddTags;
        }
        
        public List<ExpandedFunctionCall> getNegativePredicates() {
            return this.mNegativePredicates;
        }
        
        public List<ExpandedFunctionCall> getPositivePredicates() {
            return this.mPositivePredicates;
        }
        
        public List<String> getRemoveMacroRuleNames() {
            return this.mRemoveMacroRuleNames;
        }
        
        public List<ExpandedFunctionCall> getRemoveMacros() {
            return this.mRemoveMacros;
        }
        
        public List<String> getRemoveTagRuleNames() {
            return this.mRemoveTagRuleNames;
        }
        
        public List<ExpandedFunctionCall> getRemoveTags() {
            return this.mRemoveTags;
        }
        
        @Override
        public String toString() {
            return "Positive predicates: " + this.getPositivePredicates() + "  Negative predicates: " + this.getNegativePredicates() + "  Add tags: " + this.getAddTags() + "  Remove tags: " + this.getRemoveTags() + "  Add macros: " + this.getAddMacros() + "  Remove macros: " + this.getRemoveMacros();
        }
    }
    
    public static class ExpandedRuleBuilder
    {
        private final List<String> mAddMacroRuleNames;
        private final List<ExpandedFunctionCall> mAddMacros;
        private final List<String> mAddTagRuleNames;
        private final List<ExpandedFunctionCall> mAddTags;
        private final List<ExpandedFunctionCall> mNegativePredicates;
        private final List<ExpandedFunctionCall> mPositivePredicates;
        private final List<String> mRemoveMacroRuleNames;
        private final List<ExpandedFunctionCall> mRemoveMacros;
        private final List<String> mRemoveTagRuleNames;
        private final List<ExpandedFunctionCall> mRemoveTags;
        
        private ExpandedRuleBuilder() {
            this.mPositivePredicates = new ArrayList<ExpandedFunctionCall>();
            this.mNegativePredicates = new ArrayList<ExpandedFunctionCall>();
            this.mAddTags = new ArrayList<ExpandedFunctionCall>();
            this.mRemoveTags = new ArrayList<ExpandedFunctionCall>();
            this.mAddMacros = new ArrayList<ExpandedFunctionCall>();
            this.mRemoveMacros = new ArrayList<ExpandedFunctionCall>();
            this.mAddMacroRuleNames = new ArrayList<String>();
            this.mRemoveMacroRuleNames = new ArrayList<String>();
            this.mAddTagRuleNames = new ArrayList<String>();
            this.mRemoveTagRuleNames = new ArrayList<String>();
        }
        
        public ExpandedRuleBuilder addAddMacro(final ExpandedFunctionCall expandedFunctionCall) {
            this.mAddMacros.add(expandedFunctionCall);
            return this;
        }
        
        public ExpandedRuleBuilder addAddMacroRuleName(final String s) {
            this.mAddMacroRuleNames.add(s);
            return this;
        }
        
        public ExpandedRuleBuilder addAddTag(final ExpandedFunctionCall expandedFunctionCall) {
            this.mAddTags.add(expandedFunctionCall);
            return this;
        }
        
        public ExpandedRuleBuilder addAddTagRuleName(final String s) {
            this.mAddTagRuleNames.add(s);
            return this;
        }
        
        public ExpandedRuleBuilder addNegativePredicate(final ExpandedFunctionCall expandedFunctionCall) {
            this.mNegativePredicates.add(expandedFunctionCall);
            return this;
        }
        
        public ExpandedRuleBuilder addPositivePredicate(final ExpandedFunctionCall expandedFunctionCall) {
            this.mPositivePredicates.add(expandedFunctionCall);
            return this;
        }
        
        public ExpandedRuleBuilder addRemoveMacro(final ExpandedFunctionCall expandedFunctionCall) {
            this.mRemoveMacros.add(expandedFunctionCall);
            return this;
        }
        
        public ExpandedRuleBuilder addRemoveMacroRuleName(final String s) {
            this.mRemoveMacroRuleNames.add(s);
            return this;
        }
        
        public ExpandedRuleBuilder addRemoveTag(final ExpandedFunctionCall expandedFunctionCall) {
            this.mRemoveTags.add(expandedFunctionCall);
            return this;
        }
        
        public ExpandedRuleBuilder addRemoveTagRuleName(final String s) {
            this.mRemoveTagRuleNames.add(s);
            return this;
        }
        
        public ExpandedRule build() {
            return new ExpandedRule((List)this.mPositivePredicates, (List)this.mNegativePredicates, (List)this.mAddTags, (List)this.mRemoveTags, (List)this.mAddMacros, (List)this.mRemoveMacros, (List)this.mAddMacroRuleNames, (List)this.mRemoveMacroRuleNames, (List)this.mAddTagRuleNames, (List)this.mRemoveTagRuleNames);
        }
    }
    
    public static class InvalidResourceException extends Exception
    {
        public InvalidResourceException(final String message) {
            super(message);
        }
    }
}
