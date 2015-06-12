// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Map;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.analytics.containertag.proto.Serving;

public class ExperimentMacroHelper
{
    private static void clearKeys(final DataLayer dataLayer, final Serving.GaExperimentSupplemental gaExperimentSupplemental) {
        final TypeSystem.Value[] valueToClear = gaExperimentSupplemental.valueToClear;
        for (int length = valueToClear.length, i = 0; i < length; ++i) {
            dataLayer.clearPersistentKeysWithPrefix(Types.valueToString(valueToClear[i]));
        }
    }
    
    public static void handleExperimentSupplemental(final DataLayer dataLayer, final Serving.Supplemental supplemental) {
        if (supplemental.experimentSupplemental == null) {
            Log.w("supplemental missing experimentSupplemental");
            return;
        }
        clearKeys(dataLayer, supplemental.experimentSupplemental);
        pushValues(dataLayer, supplemental.experimentSupplemental);
        setRandomValues(dataLayer, supplemental.experimentSupplemental);
    }
    
    private static void pushValues(final DataLayer dataLayer, final Serving.GaExperimentSupplemental gaExperimentSupplemental) {
        final TypeSystem.Value[] valueToPush = gaExperimentSupplemental.valueToPush;
        for (int length = valueToPush.length, i = 0; i < length; ++i) {
            final Map<Object, Object> valueToMap = valueToMap(valueToPush[i]);
            if (valueToMap != null) {
                dataLayer.push(valueToMap);
            }
        }
    }
    
    private static void setRandomValues(final DataLayer dataLayer, final Serving.GaExperimentSupplemental gaExperimentSupplemental) {
        for (final Serving.GaExperimentRandom gaExperimentRandom : gaExperimentSupplemental.experimentRandom) {
            Label_0036: {
                if (gaExperimentRandom.key == null) {
                    Log.w("GaExperimentRandom: No key");
                }
                else {
                    Object o = dataLayer.get(gaExperimentRandom.key);
                    Long value;
                    if (!(o instanceof Number)) {
                        value = null;
                    }
                    else {
                        value = ((Number)o).longValue();
                    }
                    final long minRandom = gaExperimentRandom.minRandom;
                    final long maxRandom = gaExperimentRandom.maxRandom;
                    if (!gaExperimentRandom.retainOriginalValue || value == null || value < minRandom || value > maxRandom) {
                        if (minRandom > maxRandom) {
                            Log.w("GaExperimentRandom: random range invalid");
                            break Label_0036;
                        }
                        o = Math.round(Math.random() * (maxRandom - minRandom) + minRandom);
                    }
                    dataLayer.clearPersistentKeysWithPrefix(gaExperimentRandom.key);
                    final Map<Object, Object> expandKeyValue = dataLayer.expandKeyValue(gaExperimentRandom.key, o);
                    if (gaExperimentRandom.lifetimeInMilliseconds > 0L) {
                        if (!expandKeyValue.containsKey("gtm")) {
                            expandKeyValue.put("gtm", DataLayer.mapOf("lifetime", gaExperimentRandom.lifetimeInMilliseconds));
                        }
                        else {
                            final Object value2 = expandKeyValue.get("gtm");
                            if (value2 instanceof Map) {
                                ((Map<String, Long>)value2).put("lifetime", gaExperimentRandom.lifetimeInMilliseconds);
                            }
                            else {
                                Log.w("GaExperimentRandom: gtm not a map");
                            }
                        }
                    }
                    dataLayer.push(expandKeyValue);
                }
            }
        }
    }
    
    private static Map<Object, Object> valueToMap(final TypeSystem.Value value) {
        final Object valueToObject = Types.valueToObject(value);
        if (!(valueToObject instanceof Map)) {
            Log.w("value: " + valueToObject + " is not a map value, ignored.");
            return null;
        }
        return (Map<Object, Object>)valueToObject;
    }
}
