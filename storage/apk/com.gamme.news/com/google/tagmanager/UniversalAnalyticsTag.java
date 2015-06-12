// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import com.google.analytics.tracking.android.Tracker;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.HashSet;
import android.content.Context;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.common.FunctionType;
import java.util.Set;
import java.util.Map;

class UniversalAnalyticsTag extends TrackingTag
{
    private static final String ACCOUNT;
    private static final String ANALYTICS_FIELDS;
    private static final String ANALYTICS_PASS_THROUGH;
    private static final String DEFAULT_TRACKING_ID = "_GTM_DEFAULT_TRACKER_";
    private static final String ID;
    private static final String TRACK_TRANSACTION;
    private static final String TRANSACTION_DATALAYER_MAP;
    private static final String TRANSACTION_ITEM_DATALAYER_MAP;
    private static Map<String, String> defaultItemMap;
    private static Map<String, String> defaultTransactionMap;
    private final DataLayer mDataLayer;
    private final TrackerProvider mTrackerProvider;
    private final Set<String> mTurnOffAnonymizeIpValues;
    
    static {
        ID = FunctionType.UNIVERSAL_ANALYTICS.toString();
        ACCOUNT = Key.ACCOUNT.toString();
        ANALYTICS_PASS_THROUGH = Key.ANALYTICS_PASS_THROUGH.toString();
        ANALYTICS_FIELDS = Key.ANALYTICS_FIELDS.toString();
        TRACK_TRANSACTION = Key.TRACK_TRANSACTION.toString();
        TRANSACTION_DATALAYER_MAP = Key.TRANSACTION_DATALAYER_MAP.toString();
        TRANSACTION_ITEM_DATALAYER_MAP = Key.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    }
    
    public UniversalAnalyticsTag(final Context context, final DataLayer dataLayer) {
        this(context, dataLayer, new TrackerProvider(context));
    }
    
    UniversalAnalyticsTag(final Context context, final DataLayer mDataLayer, final TrackerProvider mTrackerProvider) {
        super(UniversalAnalyticsTag.ID, new String[0]);
        this.mDataLayer = mDataLayer;
        this.mTrackerProvider = mTrackerProvider;
        (this.mTurnOffAnonymizeIpValues = new HashSet<String>()).add("");
        this.mTurnOffAnonymizeIpValues.add("0");
        this.mTurnOffAnonymizeIpValues.add("false");
    }
    
    private void addParam(final Map<String, String> map, final String s, final String s2) {
        if (s2 != null) {
            map.put(s, s2);
        }
    }
    
    private boolean checkBooleanProperty(final Map<String, TypeSystem.Value> map, final String s) {
        final TypeSystem.Value value = map.get(s);
        return value != null && Types.valueToBoolean(value);
    }
    
    private Map<String, String> convertToGaFields(final TypeSystem.Value value) {
        Map<String, String> valueToMap;
        if (value == null) {
            valueToMap = new HashMap<String, String>();
        }
        else {
            valueToMap = this.valueToMap(value);
            if (valueToMap == null) {
                return new HashMap<String, String>();
            }
            final String s = valueToMap.get("&aip");
            if (s != null && this.mTurnOffAnonymizeIpValues.contains(s.toLowerCase())) {
                valueToMap.remove("&aip");
                return valueToMap;
            }
        }
        return valueToMap;
    }
    
    private String getDataLayerString(final String s) {
        final Object value = this.mDataLayer.get(s);
        if (value == null) {
            return null;
        }
        return value.toString();
    }
    
    public static String getFunctionId() {
        return UniversalAnalyticsTag.ID;
    }
    
    private Map<String, String> getTransactionFields(final Map<String, TypeSystem.Value> map) {
        final TypeSystem.Value value = map.get(UniversalAnalyticsTag.TRANSACTION_DATALAYER_MAP);
        if (value != null) {
            return this.valueToMap(value);
        }
        if (UniversalAnalyticsTag.defaultTransactionMap == null) {
            final HashMap<String, String> defaultTransactionMap = new HashMap<String, String>();
            defaultTransactionMap.put("transactionId", "&ti");
            defaultTransactionMap.put("transactionAffiliation", "&ta");
            defaultTransactionMap.put("transactionTax", "&tt");
            defaultTransactionMap.put("transactionShipping", "&ts");
            defaultTransactionMap.put("transactionTotal", "&tr");
            defaultTransactionMap.put("transactionCurrency", "&cu");
            UniversalAnalyticsTag.defaultTransactionMap = defaultTransactionMap;
        }
        return UniversalAnalyticsTag.defaultTransactionMap;
    }
    
    private Map<String, String> getTransactionItemFields(final Map<String, TypeSystem.Value> map) {
        final TypeSystem.Value value = map.get(UniversalAnalyticsTag.TRANSACTION_ITEM_DATALAYER_MAP);
        if (value != null) {
            return this.valueToMap(value);
        }
        if (UniversalAnalyticsTag.defaultItemMap == null) {
            final HashMap<String, String> defaultItemMap = new HashMap<String, String>();
            defaultItemMap.put("name", "&in");
            defaultItemMap.put("sku", "&ic");
            defaultItemMap.put("category", "&iv");
            defaultItemMap.put("price", "&ip");
            defaultItemMap.put("quantity", "&iq");
            defaultItemMap.put("currency", "&cu");
            UniversalAnalyticsTag.defaultItemMap = defaultItemMap;
        }
        return UniversalAnalyticsTag.defaultItemMap;
    }
    
    private List<Map<String, String>> getTransactionItems() {
        final Object value = this.mDataLayer.get("transactionProducts");
        if (value == null) {
            return null;
        }
        if (!(value instanceof List)) {
            throw new IllegalArgumentException("transactionProducts should be of type List.");
        }
        final Iterator<Map<String, String>> iterator = ((List<Map<String, String>>)value).iterator();
        while (iterator.hasNext()) {
            if (!(iterator.next() instanceof Map)) {
                throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
            }
        }
        return (List<Map<String, String>>)value;
    }
    
    private void sendTransaction(final Tracker tracker, final Map<String, TypeSystem.Value> map) {
        final String dataLayerString = this.getDataLayerString("transactionId");
        if (dataLayerString == null) {
            Log.e("Cannot find transactionId in data layer.");
        }
        else {
            final LinkedList<Map<String, String>> list = new LinkedList<Map<String, String>>();
            Map<String, String> convertToGaFields;
            try {
                convertToGaFields = this.convertToGaFields(map.get(UniversalAnalyticsTag.ANALYTICS_FIELDS));
                convertToGaFields.put("&t", "transaction");
                for (final Map.Entry<String, String> entry : this.getTransactionFields(map).entrySet()) {
                    this.addParam(convertToGaFields, entry.getValue(), this.getDataLayerString(entry.getKey()));
                }
            }
            catch (IllegalArgumentException ex) {
                Log.e("Unable to send transaction", ex);
                return;
            }
            list.add(convertToGaFields);
            final List<Map<String, String>> transactionItems = this.getTransactionItems();
            if (transactionItems != null) {
                for (final Map<String, String> map2 : transactionItems) {
                    if (map2.get("name") == null) {
                        Log.e("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    final Map<String, String> convertToGaFields2 = this.convertToGaFields(map.get(UniversalAnalyticsTag.ANALYTICS_FIELDS));
                    convertToGaFields2.put("&t", "item");
                    convertToGaFields2.put("&ti", dataLayerString);
                    for (final Map.Entry<String, String> entry2 : this.getTransactionItemFields(map).entrySet()) {
                        this.addParam(convertToGaFields2, entry2.getValue(), map2.get(entry2.getKey()));
                    }
                    list.add(convertToGaFields2);
                }
            }
            final Iterator<Object> iterator4 = list.iterator();
            while (iterator4.hasNext()) {
                tracker.send(iterator4.next());
            }
        }
    }
    
    private Map<String, String> valueToMap(final TypeSystem.Value value) {
        final Object valueToObject = Types.valueToObject(value);
        Map<String, String> map;
        if (!(valueToObject instanceof Map)) {
            map = null;
        }
        else {
            final Map<Object, V> map2 = (Map<Object, V>)valueToObject;
            map = new LinkedHashMap<String, String>();
            for (final Map.Entry<Object, V> entry : map2.entrySet()) {
                map.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return map;
    }
    
    @Override
    public void evaluateTrackingTag(final Map<String, TypeSystem.Value> map) {
        final Tracker tracker = this.mTrackerProvider.getTracker("_GTM_DEFAULT_TRACKER_");
        if (this.checkBooleanProperty(map, UniversalAnalyticsTag.ANALYTICS_PASS_THROUGH)) {
            tracker.send(this.convertToGaFields(map.get(UniversalAnalyticsTag.ANALYTICS_FIELDS)));
        }
        else if (this.checkBooleanProperty(map, UniversalAnalyticsTag.TRACK_TRANSACTION)) {
            this.sendTransaction(tracker, map);
        }
        else {
            Log.w("Ignoring unknown tag.");
        }
        this.mTrackerProvider.close(tracker);
    }
}
