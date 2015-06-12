// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.ArrayList;
import com.google.analytics.containertag.proto.Serving;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import com.google.analytics.containertag.common.Key;
import java.util.List;
import java.util.HashMap;
import java.util.Collection;
import java.util.HashSet;
import android.content.Context;
import java.util.Set;
import java.util.Map;
import com.google.analytics.midtier.proto.containertag.TypeSystem;

class Runtime
{
    static final String DEFAULT_RULE_NAME = "Unknown";
    private static final ObjectAndStatic<TypeSystem.Value> DEFAULT_VALUE_AND_STATIC;
    static final String EXPERIMENT_SUPPLEMENTAL_NAME_PREFIX = "gaExperiment:";
    private static final int MAX_CACHE_SIZE = 1048576;
    private final EventInfoDistributor eventInfoDistributor;
    private volatile String mCurrentEventName;
    private final DataLayer mDataLayer;
    private final Cache<ResourceUtil.ExpandedFunctionCall, ObjectAndStatic<TypeSystem.Value>> mFunctionCallCache;
    private final Cache<String, CachedMacro> mMacroEvaluationCache;
    private final Map<String, MacroInfo> mMacroLookup;
    private final Map<String, FunctionCallImplementation> mMacroMap;
    private final Map<String, FunctionCallImplementation> mPredicateMap;
    private final ResourceUtil.ExpandedResource mResource;
    private final Set<ResourceUtil.ExpandedRule> mRules;
    private final Map<String, FunctionCallImplementation> mTrackingTagMap;
    
    static {
        DEFAULT_VALUE_AND_STATIC = new ObjectAndStatic<TypeSystem.Value>(Types.getDefaultValue(), true);
    }
    
    public Runtime(final Context context, final ResourceUtil.ExpandedResource expandedResource, final DataLayer dataLayer, final CustomFunctionCall.CustomEvaluator customEvaluator, final CustomFunctionCall.CustomEvaluator customEvaluator2) {
        this(context, expandedResource, dataLayer, customEvaluator, customEvaluator2, new NoopEventInfoDistributor());
    }
    
    public Runtime(final Context context, final ResourceUtil.ExpandedResource mResource, final DataLayer mDataLayer, final CustomFunctionCall.CustomEvaluator customEvaluator, final CustomFunctionCall.CustomEvaluator customEvaluator2, final EventInfoDistributor eventInfoDistributor) {
        if (mResource == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.mResource = mResource;
        this.mRules = new HashSet<ResourceUtil.ExpandedRule>(mResource.getRules());
        this.mDataLayer = mDataLayer;
        this.eventInfoDistributor = eventInfoDistributor;
        this.mFunctionCallCache = new CacheFactory<ResourceUtil.ExpandedFunctionCall, ObjectAndStatic<TypeSystem.Value>>().createCache(1048576, (CacheFactory.CacheSizeManager<ResourceUtil.ExpandedFunctionCall, ObjectAndStatic<TypeSystem.Value>>)new CacheFactory.CacheSizeManager<ResourceUtil.ExpandedFunctionCall, ObjectAndStatic<TypeSystem.Value>>() {
            public int sizeOf(final ResourceUtil.ExpandedFunctionCall expandedFunctionCall, final ObjectAndStatic<TypeSystem.Value> objectAndStatic) {
                return objectAndStatic.getObject().getCachedSize();
            }
        });
        this.mMacroEvaluationCache = new CacheFactory<String, CachedMacro>().createCache(1048576, (CacheFactory.CacheSizeManager<String, CachedMacro>)new CacheFactory.CacheSizeManager<String, CachedMacro>() {
            public int sizeOf(final String s, final CachedMacro cachedMacro) {
                return s.length() + cachedMacro.getSize();
            }
        });
        this.mTrackingTagMap = new HashMap<String, FunctionCallImplementation>();
        this.addTrackingTag(new ArbitraryPixelTag(context));
        this.addTrackingTag(new CustomFunctionCall(customEvaluator2));
        this.addTrackingTag(new DataLayerWriteTag(mDataLayer));
        this.addTrackingTag(new UniversalAnalyticsTag(context, mDataLayer));
        this.mPredicateMap = new HashMap<String, FunctionCallImplementation>();
        this.addPredicate(new ContainsPredicate());
        this.addPredicate(new EndsWithPredicate());
        this.addPredicate(new EqualsPredicate());
        this.addPredicate(new GreaterEqualsPredicate());
        this.addPredicate(new GreaterThanPredicate());
        this.addPredicate(new LessEqualsPredicate());
        this.addPredicate(new LessThanPredicate());
        this.addPredicate(new RegexPredicate());
        this.addPredicate(new StartsWithPredicate());
        this.mMacroMap = new HashMap<String, FunctionCallImplementation>();
        this.addMacro(new AdvertiserIdMacro(context));
        this.addMacro(new AdvertisingTrackingEnabledMacro());
        this.addMacro(new AdwordsClickReferrerMacro(context));
        this.addMacro(new AppIdMacro(context));
        this.addMacro(new AppNameMacro(context));
        this.addMacro(new AppVersionMacro(context));
        this.addMacro(new ConstantMacro());
        this.addMacro(new ContainerVersionMacro(this));
        this.addMacro(new CustomFunctionCall(customEvaluator));
        this.addMacro(new DataLayerMacro(mDataLayer));
        this.addMacro(new DeviceIdMacro(context));
        this.addMacro(new DeviceNameMacro());
        this.addMacro(new EncodeMacro());
        this.addMacro(new EventMacro(this));
        this.addMacro(new GtmVersionMacro());
        this.addMacro(new HashMacro());
        this.addMacro(new InstallReferrerMacro(context));
        this.addMacro(new JoinerMacro());
        this.addMacro(new LanguageMacro());
        this.addMacro(new MobileAdwordsUniqueIdMacro(context));
        this.addMacro(new OsVersionMacro());
        this.addMacro(new PlatformMacro());
        this.addMacro(new RandomMacro());
        this.addMacro(new RegexGroupMacro());
        this.addMacro(new ResolutionMacro(context));
        this.addMacro(new RuntimeVersionMacro());
        this.addMacro(new SdkVersionMacro());
        this.addMacro(new TimeMacro());
        this.mMacroLookup = new HashMap<String, MacroInfo>();
        for (final ResourceUtil.ExpandedRule expandedRule : this.mRules) {
            if (eventInfoDistributor.debugMode()) {
                verifyFunctionAndNameListSizes(expandedRule.getAddMacros(), expandedRule.getAddMacroRuleNames(), "add macro");
                verifyFunctionAndNameListSizes(expandedRule.getRemoveMacros(), expandedRule.getRemoveMacroRuleNames(), "remove macro");
                verifyFunctionAndNameListSizes(expandedRule.getAddTags(), expandedRule.getAddTagRuleNames(), "add tag");
                verifyFunctionAndNameListSizes(expandedRule.getRemoveTags(), expandedRule.getRemoveTagRuleNames(), "remove tag");
            }
            for (int i = 0; i < expandedRule.getAddMacros().size(); ++i) {
                final ResourceUtil.ExpandedFunctionCall expandedFunctionCall = expandedRule.getAddMacros().get(i);
                String s = "Unknown";
                if (eventInfoDistributor.debugMode() && i < expandedRule.getAddMacroRuleNames().size()) {
                    s = expandedRule.getAddMacroRuleNames().get(i);
                }
                final MacroInfo orAddMacroInfo = getOrAddMacroInfo(this.mMacroLookup, getFunctionName(expandedFunctionCall));
                orAddMacroInfo.addRule(expandedRule);
                orAddMacroInfo.addAddMacroForRule(expandedRule, expandedFunctionCall);
                orAddMacroInfo.addAddMacroRuleNameForRule(expandedRule, s);
            }
            for (int j = 0; j < expandedRule.getRemoveMacros().size(); ++j) {
                final ResourceUtil.ExpandedFunctionCall expandedFunctionCall2 = expandedRule.getRemoveMacros().get(j);
                String s2 = "Unknown";
                if (eventInfoDistributor.debugMode() && j < expandedRule.getRemoveMacroRuleNames().size()) {
                    s2 = expandedRule.getRemoveMacroRuleNames().get(j);
                }
                final MacroInfo orAddMacroInfo2 = getOrAddMacroInfo(this.mMacroLookup, getFunctionName(expandedFunctionCall2));
                orAddMacroInfo2.addRule(expandedRule);
                orAddMacroInfo2.addRemoveMacroForRule(expandedRule, expandedFunctionCall2);
                orAddMacroInfo2.addRemoveMacroRuleNameForRule(expandedRule, s2);
            }
        }
        for (final Map.Entry<String, List<ResourceUtil.ExpandedFunctionCall>> entry : this.mResource.getAllMacros().entrySet()) {
            for (final ResourceUtil.ExpandedFunctionCall default1 : entry.getValue()) {
                if (!Types.valueToBoolean(default1.getProperties().get(Key.NOT_DEFAULT_MACRO.toString()))) {
                    getOrAddMacroInfo(this.mMacroLookup, entry.getKey()).setDefault(default1);
                }
            }
        }
    }
    
    private static void addFunctionImplToMap(final Map<String, FunctionCallImplementation> map, final FunctionCallImplementation functionCallImplementation) {
        if (map.containsKey(functionCallImplementation.getInstanceFunctionId())) {
            throw new IllegalArgumentException("Duplicate function type name: " + functionCallImplementation.getInstanceFunctionId());
        }
        map.put(functionCallImplementation.getInstanceFunctionId(), functionCallImplementation);
    }
    
    private ObjectAndStatic<Set<ResourceUtil.ExpandedFunctionCall>> calculateGenericToRun(final Set<ResourceUtil.ExpandedRule> set, final Set<String> set2, final AddRemoveSetPopulator addRemoveSetPopulator, final RuleEvaluationStepInfoBuilder ruleEvaluationStepInfoBuilder) {
        final HashSet<ResourceUtil.ExpandedFunctionCall> enabledFunctions = new HashSet<ResourceUtil.ExpandedFunctionCall>();
        final HashSet<ResourceUtil.ExpandedFunctionCall> set3 = new HashSet<ResourceUtil.ExpandedFunctionCall>();
        boolean b = true;
        for (final ResourceUtil.ExpandedRule expandedRule : set) {
            final ResolvedRuleBuilder resolvedRuleBuilder = ruleEvaluationStepInfoBuilder.createResolvedRuleBuilder();
            final ObjectAndStatic<Boolean> evaluatePredicatesInRule = this.evaluatePredicatesInRule(expandedRule, set2, resolvedRuleBuilder);
            if (evaluatePredicatesInRule.getObject()) {
                addRemoveSetPopulator.rulePassed(expandedRule, enabledFunctions, set3, resolvedRuleBuilder);
            }
            b = (b && evaluatePredicatesInRule.isStatic());
        }
        enabledFunctions.removeAll(set3);
        ruleEvaluationStepInfoBuilder.setEnabledFunctions(enabledFunctions);
        return new ObjectAndStatic<Set<ResourceUtil.ExpandedFunctionCall>>(enabledFunctions, b);
    }
    
    private ObjectAndStatic<TypeSystem.Value> evaluateMacroReferenceCycleDetection(final String s, final Set<String> set, final MacroEvaluationInfoBuilder macroEvaluationInfoBuilder) {
        final CachedMacro cachedMacro = this.mMacroEvaluationCache.get(s);
        if (cachedMacro != null && !this.eventInfoDistributor.debugMode()) {
            this.pushUnevaluatedValueToDataLayer(cachedMacro.getPushAfterEvaluate(), set);
            return cachedMacro.getObjectAndStatic();
        }
        final MacroInfo macroInfo = this.mMacroLookup.get(s);
        if (macroInfo == null) {
            Log.e("Invalid macro: " + s);
            return Runtime.DEFAULT_VALUE_AND_STATIC;
        }
        final ObjectAndStatic<Set<ResourceUtil.ExpandedFunctionCall>> calculateMacrosToRun = this.calculateMacrosToRun(s, macroInfo.getRules(), macroInfo.getAddMacros(), macroInfo.getAddMacroRuleNames(), macroInfo.getRemoveMacros(), macroInfo.getRemoveMacroRuleNames(), set, macroEvaluationInfoBuilder.createRulesEvaluation());
        ResourceUtil.ExpandedFunctionCall default1;
        if (calculateMacrosToRun.getObject().isEmpty()) {
            default1 = macroInfo.getDefault();
        }
        else {
            if (calculateMacrosToRun.getObject().size() > 1) {
                Log.w("Multiple macros active for macroName " + s);
            }
            default1 = calculateMacrosToRun.getObject().iterator().next();
        }
        if (default1 == null) {
            return Runtime.DEFAULT_VALUE_AND_STATIC;
        }
        final ObjectAndStatic<TypeSystem.Value> executeFunction = this.executeFunction(this.mMacroMap, default1, set, macroEvaluationInfoBuilder.createResult());
        final boolean b = calculateMacrosToRun.isStatic() && executeFunction.isStatic();
        ObjectAndStatic<TypeSystem.Value> default_VALUE_AND_STATIC;
        if (executeFunction == Runtime.DEFAULT_VALUE_AND_STATIC) {
            default_VALUE_AND_STATIC = Runtime.DEFAULT_VALUE_AND_STATIC;
        }
        else {
            default_VALUE_AND_STATIC = new ObjectAndStatic<TypeSystem.Value>(executeFunction.getObject(), b);
        }
        final TypeSystem.Value pushAfterEvaluate = default1.getPushAfterEvaluate();
        if (default_VALUE_AND_STATIC.isStatic()) {
            this.mMacroEvaluationCache.put(s, new CachedMacro(default_VALUE_AND_STATIC, pushAfterEvaluate));
        }
        this.pushUnevaluatedValueToDataLayer(pushAfterEvaluate, set);
        return default_VALUE_AND_STATIC;
    }
    
    private ObjectAndStatic<TypeSystem.Value> executeFunction(final Map<String, FunctionCallImplementation> map, final ResourceUtil.ExpandedFunctionCall expandedFunctionCall, final Set<String> set, final ResolvedFunctionCallBuilder resolvedFunctionCallBuilder) {
        final TypeSystem.Value value = expandedFunctionCall.getProperties().get(Key.FUNCTION.toString());
        ObjectAndStatic<TypeSystem.Value> default_VALUE_AND_STATIC;
        if (value == null) {
            Log.e("No function id in properties");
            default_VALUE_AND_STATIC = Runtime.DEFAULT_VALUE_AND_STATIC;
        }
        else {
            final String functionId = value.functionId;
            final FunctionCallImplementation functionCallImplementation = map.get(functionId);
            if (functionCallImplementation == null) {
                Log.e(functionId + " has no backing implementation.");
                return Runtime.DEFAULT_VALUE_AND_STATIC;
            }
            default_VALUE_AND_STATIC = this.mFunctionCallCache.get(expandedFunctionCall);
            if (default_VALUE_AND_STATIC == null || this.eventInfoDistributor.debugMode()) {
                final HashMap<String, Object> hashMap = new HashMap<String, Object>();
                boolean b = true;
                for (final Map.Entry<String, TypeSystem.Value> entry : expandedFunctionCall.getProperties().entrySet()) {
                    final ObjectAndStatic<TypeSystem.Value> macroExpandValue = this.macroExpandValue(entry.getValue(), set, resolvedFunctionCallBuilder.createResolvedPropertyBuilder(entry.getKey()).createPropertyValueBuilder(entry.getValue()));
                    if (macroExpandValue == Runtime.DEFAULT_VALUE_AND_STATIC) {
                        return Runtime.DEFAULT_VALUE_AND_STATIC;
                    }
                    if (macroExpandValue.isStatic()) {
                        expandedFunctionCall.updateCacheableProperty(entry.getKey(), macroExpandValue.getObject());
                    }
                    else {
                        b = false;
                    }
                    hashMap.put(entry.getKey(), macroExpandValue.getObject());
                }
                if (!functionCallImplementation.hasRequiredKeys(hashMap.keySet())) {
                    Log.e("Incorrect keys for function " + functionId + " required " + functionCallImplementation.getRequiredKeys() + " had " + hashMap.keySet());
                    return Runtime.DEFAULT_VALUE_AND_STATIC;
                }
                final boolean b2 = b && functionCallImplementation.isCacheable();
                final ObjectAndStatic objectAndStatic = new ObjectAndStatic<TypeSystem.Value>(functionCallImplementation.evaluate((Map<String, TypeSystem.Value>)hashMap), b2);
                if (b2) {
                    this.mFunctionCallCache.put(expandedFunctionCall, (ObjectAndStatic<TypeSystem.Value>)objectAndStatic);
                }
                resolvedFunctionCallBuilder.setFunctionResult(objectAndStatic.getObject());
                return (ObjectAndStatic<TypeSystem.Value>)objectAndStatic;
            }
        }
        return default_VALUE_AND_STATIC;
    }
    
    private static String getFunctionName(final ResourceUtil.ExpandedFunctionCall expandedFunctionCall) {
        return Types.valueToString(expandedFunctionCall.getProperties().get(Key.INSTANCE_NAME.toString()));
    }
    
    private static MacroInfo getOrAddMacroInfo(final Map<String, MacroInfo> map, final String s) {
        MacroInfo macroInfo = map.get(s);
        if (macroInfo == null) {
            macroInfo = new MacroInfo();
            map.put(s, macroInfo);
        }
        return macroInfo;
    }
    
    private ObjectAndStatic<TypeSystem.Value> macroExpandValue(final TypeSystem.Value value, final Set<String> set, final ValueBuilder valueBuilder) {
        if (!value.containsReferences) {
            return new ObjectAndStatic<TypeSystem.Value>(value, true);
        }
        switch (value.type) {
            default: {
                Log.e("Unknown type: " + value.type);
                return Runtime.DEFAULT_VALUE_AND_STATIC;
            }
            case 2: {
                final TypeSystem.Value valueBasedOnValue = ResourceUtil.newValueBasedOnValue(value);
                valueBasedOnValue.listItem = new TypeSystem.Value[value.listItem.length];
                for (int i = 0; i < value.listItem.length; ++i) {
                    final ObjectAndStatic<TypeSystem.Value> macroExpandValue = this.macroExpandValue(value.listItem[i], set, valueBuilder.getListItem(i));
                    if (macroExpandValue == Runtime.DEFAULT_VALUE_AND_STATIC) {
                        return Runtime.DEFAULT_VALUE_AND_STATIC;
                    }
                    valueBasedOnValue.listItem[i] = (TypeSystem.Value)macroExpandValue.getObject();
                }
                return new ObjectAndStatic<TypeSystem.Value>(valueBasedOnValue, false);
            }
            case 3: {
                final TypeSystem.Value valueBasedOnValue2 = ResourceUtil.newValueBasedOnValue(value);
                if (value.mapKey.length != value.mapValue.length) {
                    Log.e("Invalid serving value: " + value.toString());
                    return Runtime.DEFAULT_VALUE_AND_STATIC;
                }
                valueBasedOnValue2.mapKey = new TypeSystem.Value[value.mapKey.length];
                valueBasedOnValue2.mapValue = new TypeSystem.Value[value.mapKey.length];
                for (int j = 0; j < value.mapKey.length; ++j) {
                    final ObjectAndStatic<TypeSystem.Value> macroExpandValue2 = this.macroExpandValue(value.mapKey[j], set, valueBuilder.getMapKey(j));
                    final ObjectAndStatic<TypeSystem.Value> macroExpandValue3 = this.macroExpandValue(value.mapValue[j], set, valueBuilder.getMapValue(j));
                    if (macroExpandValue2 == Runtime.DEFAULT_VALUE_AND_STATIC || macroExpandValue3 == Runtime.DEFAULT_VALUE_AND_STATIC) {
                        return Runtime.DEFAULT_VALUE_AND_STATIC;
                    }
                    valueBasedOnValue2.mapKey[j] = (TypeSystem.Value)macroExpandValue2.getObject();
                    valueBasedOnValue2.mapValue[j] = (TypeSystem.Value)macroExpandValue3.getObject();
                }
                return new ObjectAndStatic<TypeSystem.Value>(valueBasedOnValue2, false);
            }
            case 4: {
                if (set.contains(value.macroReference)) {
                    Log.e("Macro cycle detected.  Current macro reference: " + value.macroReference + "." + "  Previous macro references: " + set.toString() + ".");
                    return Runtime.DEFAULT_VALUE_AND_STATIC;
                }
                set.add(value.macroReference);
                final ObjectAndStatic<TypeSystem.Value> applyEscapings = ValueEscapeUtil.applyEscapings(this.evaluateMacroReferenceCycleDetection(value.macroReference, set, valueBuilder.createValueMacroEvaluationInfoExtension()), value.escaping);
                set.remove(value.macroReference);
                return applyEscapings;
            }
            case 7: {
                final TypeSystem.Value valueBasedOnValue3 = ResourceUtil.newValueBasedOnValue(value);
                valueBasedOnValue3.templateToken = new TypeSystem.Value[value.templateToken.length];
                for (int k = 0; k < value.templateToken.length; ++k) {
                    final ObjectAndStatic<TypeSystem.Value> macroExpandValue4 = this.macroExpandValue(value.templateToken[k], set, valueBuilder.getTemplateToken(k));
                    if (macroExpandValue4 == Runtime.DEFAULT_VALUE_AND_STATIC) {
                        return Runtime.DEFAULT_VALUE_AND_STATIC;
                    }
                    valueBasedOnValue3.templateToken[k] = (TypeSystem.Value)macroExpandValue4.getObject();
                }
                return new ObjectAndStatic<TypeSystem.Value>(valueBasedOnValue3, false);
            }
        }
    }
    
    private void pushUnevaluatedValueToDataLayer(final TypeSystem.Value value, final Set<String> set) {
        if (value != null) {
            final ObjectAndStatic<TypeSystem.Value> macroExpandValue = this.macroExpandValue(value, set, new NoopValueBuilder());
            if (macroExpandValue != Runtime.DEFAULT_VALUE_AND_STATIC) {
                final Object valueToObject = Types.valueToObject(macroExpandValue.getObject());
                if (valueToObject instanceof Map) {
                    this.mDataLayer.push((Map<Object, Object>)valueToObject);
                    return;
                }
                if (!(valueToObject instanceof List)) {
                    Log.w("pushAfterEvaluate: value not a Map or List");
                    return;
                }
                for (final Map<Object, Object> next : (List<Object>)valueToObject) {
                    if (next instanceof Map) {
                        this.mDataLayer.push(next);
                    }
                    else {
                        Log.w("pushAfterEvaluate: value not a Map");
                    }
                }
            }
        }
    }
    
    private static void verifyFunctionAndNameListSizes(final List<ResourceUtil.ExpandedFunctionCall> list, final List<String> list2, final String str) {
        if (list.size() != list2.size()) {
            Log.i("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }
    
    @VisibleForTesting
    void addMacro(final FunctionCallImplementation functionCallImplementation) {
        addFunctionImplToMap(this.mMacroMap, functionCallImplementation);
    }
    
    @VisibleForTesting
    void addPredicate(final FunctionCallImplementation functionCallImplementation) {
        addFunctionImplToMap(this.mPredicateMap, functionCallImplementation);
    }
    
    @VisibleForTesting
    void addTrackingTag(final FunctionCallImplementation functionCallImplementation) {
        addFunctionImplToMap(this.mTrackingTagMap, functionCallImplementation);
    }
    
    @VisibleForTesting
    ObjectAndStatic<Set<ResourceUtil.ExpandedFunctionCall>> calculateMacrosToRun(final String s, final Set<ResourceUtil.ExpandedRule> set, final Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> map, final Map<ResourceUtil.ExpandedRule, List<String>> map2, final Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> map3, final Map<ResourceUtil.ExpandedRule, List<String>> map4, final Set<String> set2, final RuleEvaluationStepInfoBuilder ruleEvaluationStepInfoBuilder) {
        return this.calculateGenericToRun(set, set2, (AddRemoveSetPopulator)new AddRemoveSetPopulator() {
            @Override
            public void rulePassed(final ResourceUtil.ExpandedRule expandedRule, final Set<ResourceUtil.ExpandedFunctionCall> set, final Set<ResourceUtil.ExpandedFunctionCall> set2, final ResolvedRuleBuilder resolvedRuleBuilder) {
                final List<? extends ResourceUtil.ExpandedFunctionCall> list = map.get(expandedRule);
                final List<String> list2 = map2.get(expandedRule);
                if (list != null) {
                    set.addAll(list);
                    resolvedRuleBuilder.getAddedMacroFunctions().translateAndAddAll((List<ResourceUtil.ExpandedFunctionCall>)list, list2);
                }
                final List<? extends ResourceUtil.ExpandedFunctionCall> list3 = map3.get(expandedRule);
                final List<String> list4 = map4.get(expandedRule);
                if (list3 != null) {
                    set2.addAll(list3);
                    resolvedRuleBuilder.getRemovedMacroFunctions().translateAndAddAll((List<ResourceUtil.ExpandedFunctionCall>)list3, list4);
                }
            }
        }, ruleEvaluationStepInfoBuilder);
    }
    
    @VisibleForTesting
    ObjectAndStatic<Set<ResourceUtil.ExpandedFunctionCall>> calculateTagsToRun(final Set<ResourceUtil.ExpandedRule> set, final RuleEvaluationStepInfoBuilder ruleEvaluationStepInfoBuilder) {
        return this.calculateGenericToRun(set, new HashSet<String>(), (AddRemoveSetPopulator)new AddRemoveSetPopulator() {
            @Override
            public void rulePassed(final ResourceUtil.ExpandedRule expandedRule, final Set<ResourceUtil.ExpandedFunctionCall> set, final Set<ResourceUtil.ExpandedFunctionCall> set2, final ResolvedRuleBuilder resolvedRuleBuilder) {
                set.addAll(expandedRule.getAddTags());
                set2.addAll(expandedRule.getRemoveTags());
                resolvedRuleBuilder.getAddedTagFunctions().translateAndAddAll(expandedRule.getAddTags(), expandedRule.getAddTagRuleNames());
                resolvedRuleBuilder.getRemovedTagFunctions().translateAndAddAll(expandedRule.getRemoveTags(), expandedRule.getRemoveTagRuleNames());
            }
        }, ruleEvaluationStepInfoBuilder);
    }
    
    public ObjectAndStatic<TypeSystem.Value> evaluateMacroReference(final String s) {
        final EventInfoBuilder macroEvalutionEventInfo = this.eventInfoDistributor.createMacroEvalutionEventInfo(s);
        final ObjectAndStatic<TypeSystem.Value> evaluateMacroReferenceCycleDetection = this.evaluateMacroReferenceCycleDetection(s, new HashSet<String>(), macroEvalutionEventInfo.createMacroEvaluationInfoBuilder());
        macroEvalutionEventInfo.processEventInfo();
        return evaluateMacroReferenceCycleDetection;
    }
    
    @VisibleForTesting
    ObjectAndStatic<Boolean> evaluatePredicate(final ResourceUtil.ExpandedFunctionCall expandedFunctionCall, final Set<String> set, final ResolvedFunctionCallBuilder resolvedFunctionCallBuilder) {
        final ObjectAndStatic<TypeSystem.Value> executeFunction = this.executeFunction(this.mPredicateMap, expandedFunctionCall, set, resolvedFunctionCallBuilder);
        final Boolean valueToBoolean = Types.valueToBoolean(executeFunction.getObject());
        resolvedFunctionCallBuilder.setFunctionResult(Types.objectToValue(valueToBoolean));
        return new ObjectAndStatic<Boolean>(valueToBoolean, executeFunction.isStatic());
    }
    
    @VisibleForTesting
    ObjectAndStatic<Boolean> evaluatePredicatesInRule(final ResourceUtil.ExpandedRule expandedRule, final Set<String> set, final ResolvedRuleBuilder resolvedRuleBuilder) {
        boolean b = true;
        final Iterator<ResourceUtil.ExpandedFunctionCall> iterator = expandedRule.getNegativePredicates().iterator();
        while (iterator.hasNext()) {
            final ObjectAndStatic<Boolean> evaluatePredicate = this.evaluatePredicate(iterator.next(), set, resolvedRuleBuilder.createNegativePredicate());
            if (evaluatePredicate.getObject()) {
                resolvedRuleBuilder.setValue(Types.objectToValue(false));
                return new ObjectAndStatic<Boolean>(false, evaluatePredicate.isStatic());
            }
            b = (b && evaluatePredicate.isStatic());
        }
        final Iterator<ResourceUtil.ExpandedFunctionCall> iterator2 = expandedRule.getPositivePredicates().iterator();
        while (iterator2.hasNext()) {
            final ObjectAndStatic<Boolean> evaluatePredicate2 = this.evaluatePredicate(iterator2.next(), set, resolvedRuleBuilder.createPositivePredicate());
            if (!evaluatePredicate2.getObject()) {
                resolvedRuleBuilder.setValue(Types.objectToValue(false));
                return new ObjectAndStatic<Boolean>(false, evaluatePredicate2.isStatic());
            }
            b = (b && evaluatePredicate2.isStatic());
        }
        resolvedRuleBuilder.setValue(Types.objectToValue(true));
        return new ObjectAndStatic<Boolean>(true, b);
    }
    
    public void evaluateTags(final String currentEventName) {
        final EventInfoBuilder dataLayerEventEvaluationEventInfo;
        synchronized (this) {
            this.setCurrentEventName(currentEventName);
            dataLayerEventEvaluationEventInfo = this.eventInfoDistributor.createDataLayerEventEvaluationEventInfo(currentEventName);
            final DataLayerEventEvaluationInfoBuilder dataLayerEventEvaluationInfoBuilder = dataLayerEventEvaluationEventInfo.createDataLayerEventEvaluationInfoBuilder();
            final Iterator<ResourceUtil.ExpandedFunctionCall> iterator = this.calculateTagsToRun(this.mRules, dataLayerEventEvaluationInfoBuilder.createRulesEvaluation()).getObject().iterator();
            while (iterator.hasNext()) {
                this.executeFunction(this.mTrackingTagMap, iterator.next(), new HashSet<String>(), dataLayerEventEvaluationInfoBuilder.createAndAddResult());
            }
        }
        dataLayerEventEvaluationEventInfo.processEventInfo();
        this.setCurrentEventName(null);
    }
    // monitorexit(this)
    
    String getCurrentEventName() {
        synchronized (this) {
            return this.mCurrentEventName;
        }
    }
    
    public ResourceUtil.ExpandedResource getResource() {
        return this.mResource;
    }
    
    @VisibleForTesting
    void setCurrentEventName(final String mCurrentEventName) {
        synchronized (this) {
            this.mCurrentEventName = mCurrentEventName;
        }
    }
    
    public void setSupplementals(final List<Serving.Supplemental> list) {
        while (true) {
            while (true) {
                Serving.Supplemental obj = null;
                Label_0082: {
                    synchronized (this) {
                        final Iterator<Serving.Supplemental> iterator = list.iterator();
                        while (iterator.hasNext()) {
                            obj = iterator.next();
                            if (obj.name != null && obj.name.startsWith("gaExperiment:")) {
                                break Label_0082;
                            }
                            Log.v("Ignored supplemental: " + obj);
                        }
                        break;
                    }
                }
                ExperimentMacroHelper.handleExperimentSupplemental(this.mDataLayer, obj);
                continue;
            }
        }
    }
    // monitorexit(this)
    
    interface AddRemoveSetPopulator
    {
        void rulePassed(ResourceUtil.ExpandedRule p0, Set<ResourceUtil.ExpandedFunctionCall> p1, Set<ResourceUtil.ExpandedFunctionCall> p2, ResolvedRuleBuilder p3);
    }
    
    private static class CachedMacro
    {
        private ObjectAndStatic<TypeSystem.Value> mObjectAndStatic;
        private TypeSystem.Value mPushAfterEvaluate;
        
        public CachedMacro(final ObjectAndStatic<TypeSystem.Value> objectAndStatic) {
            this(objectAndStatic, null);
        }
        
        public CachedMacro(final ObjectAndStatic<TypeSystem.Value> mObjectAndStatic, final TypeSystem.Value mPushAfterEvaluate) {
            this.mObjectAndStatic = mObjectAndStatic;
            this.mPushAfterEvaluate = mPushAfterEvaluate;
        }
        
        public ObjectAndStatic<TypeSystem.Value> getObjectAndStatic() {
            return this.mObjectAndStatic;
        }
        
        public TypeSystem.Value getPushAfterEvaluate() {
            return this.mPushAfterEvaluate;
        }
        
        public int getSize() {
            final int cachedSize = this.mObjectAndStatic.getObject().getCachedSize();
            int cachedSize2;
            if (this.mPushAfterEvaluate == null) {
                cachedSize2 = 0;
            }
            else {
                cachedSize2 = this.mPushAfterEvaluate.getCachedSize();
            }
            return cachedSize2 + cachedSize;
        }
    }
    
    private static class MacroInfo
    {
        private final Map<ResourceUtil.ExpandedRule, List<String>> mAddMacroNames;
        private final Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> mAddMacros;
        private ResourceUtil.ExpandedFunctionCall mDefault;
        private final Map<ResourceUtil.ExpandedRule, List<String>> mRemoveMacroNames;
        private final Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> mRemoveMacros;
        private final Set<ResourceUtil.ExpandedRule> mRules;
        
        public MacroInfo() {
            this.mRules = new HashSet<ResourceUtil.ExpandedRule>();
            this.mAddMacros = new HashMap<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>>();
            this.mAddMacroNames = new HashMap<ResourceUtil.ExpandedRule, List<String>>();
            this.mRemoveMacros = new HashMap<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>>();
            this.mRemoveMacroNames = new HashMap<ResourceUtil.ExpandedRule, List<String>>();
        }
        
        public void addAddMacroForRule(final ResourceUtil.ExpandedRule expandedRule, final ResourceUtil.ExpandedFunctionCall expandedFunctionCall) {
            List<ResourceUtil.ExpandedFunctionCall> list = this.mAddMacros.get(expandedRule);
            if (list == null) {
                list = new ArrayList<ResourceUtil.ExpandedFunctionCall>();
                this.mAddMacros.put(expandedRule, list);
            }
            list.add(expandedFunctionCall);
        }
        
        public void addAddMacroRuleNameForRule(final ResourceUtil.ExpandedRule expandedRule, final String s) {
            List<String> list = this.mAddMacroNames.get(expandedRule);
            if (list == null) {
                list = new ArrayList<String>();
                this.mAddMacroNames.put(expandedRule, list);
            }
            list.add(s);
        }
        
        public void addRemoveMacroForRule(final ResourceUtil.ExpandedRule expandedRule, final ResourceUtil.ExpandedFunctionCall expandedFunctionCall) {
            List<ResourceUtil.ExpandedFunctionCall> list = this.mRemoveMacros.get(expandedRule);
            if (list == null) {
                list = new ArrayList<ResourceUtil.ExpandedFunctionCall>();
                this.mRemoveMacros.put(expandedRule, list);
            }
            list.add(expandedFunctionCall);
        }
        
        public void addRemoveMacroRuleNameForRule(final ResourceUtil.ExpandedRule expandedRule, final String s) {
            List<String> list = this.mRemoveMacroNames.get(expandedRule);
            if (list == null) {
                list = new ArrayList<String>();
                this.mRemoveMacroNames.put(expandedRule, list);
            }
            list.add(s);
        }
        
        public void addRule(final ResourceUtil.ExpandedRule expandedRule) {
            this.mRules.add(expandedRule);
        }
        
        public Map<ResourceUtil.ExpandedRule, List<String>> getAddMacroRuleNames() {
            return this.mAddMacroNames;
        }
        
        public Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> getAddMacros() {
            return this.mAddMacros;
        }
        
        public ResourceUtil.ExpandedFunctionCall getDefault() {
            return this.mDefault;
        }
        
        public Map<ResourceUtil.ExpandedRule, List<String>> getRemoveMacroRuleNames() {
            return this.mRemoveMacroNames;
        }
        
        public Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> getRemoveMacros() {
            return this.mRemoveMacros;
        }
        
        public Set<ResourceUtil.ExpandedRule> getRules() {
            return this.mRules;
        }
        
        public void setDefault(final ResourceUtil.ExpandedFunctionCall mDefault) {
            this.mDefault = mDefault;
        }
    }
}
