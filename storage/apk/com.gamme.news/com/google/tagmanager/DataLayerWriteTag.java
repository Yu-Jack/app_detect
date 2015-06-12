// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Iterator;
import java.util.Map;
import java.util.List;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.common.FunctionType;

class DataLayerWriteTag extends TrackingTag
{
    private static final String CLEAR_PERSISTENT_DATA_LAYER_PREFIX;
    private static final String ID;
    private static final String VALUE;
    private final DataLayer mDataLayer;
    
    static {
        ID = FunctionType.DATA_LAYER_WRITE.toString();
        VALUE = Key.VALUE.toString();
        CLEAR_PERSISTENT_DATA_LAYER_PREFIX = Key.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    }
    
    public DataLayerWriteTag(final DataLayer mDataLayer) {
        super(DataLayerWriteTag.ID, new String[] { DataLayerWriteTag.VALUE });
        this.mDataLayer = mDataLayer;
    }
    
    private void clearPersistent(final TypeSystem.Value value) {
        if (value != null && value != Types.getDefaultObject()) {
            final String valueToString = Types.valueToString(value);
            if (valueToString != Types.getDefaultString()) {
                this.mDataLayer.clearPersistentKeysWithPrefix(valueToString);
            }
        }
    }
    
    public static String getFunctionId() {
        return DataLayerWriteTag.ID;
    }
    
    private void pushToDataLayer(final TypeSystem.Value value) {
        if (value != null && value != Types.getDefaultObject()) {
            final Object valueToObject = Types.valueToObject(value);
            if (valueToObject instanceof List) {
                for (final Map<Object, Object> next : (List<Object>)valueToObject) {
                    if (next instanceof Map) {
                        this.mDataLayer.push(next);
                    }
                }
            }
        }
    }
    
    @Override
    public void evaluateTrackingTag(final Map<String, TypeSystem.Value> map) {
        this.pushToDataLayer(map.get(DataLayerWriteTag.VALUE));
        this.clearPersistent(map.get(DataLayerWriteTag.CLEAR_PERSISTENT_DATA_LAYER_PREFIX));
    }
}
