// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Iterator;
import android.net.Uri$Builder;
import java.util.List;
import android.net.Uri;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashSet;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.common.FunctionType;
import android.content.Context;
import java.util.Set;

class ArbitraryPixelTag extends TrackingTag
{
    private static final String ADDITIONAL_PARAMS;
    static final String ARBITRARY_PIXEL_UNREPEATABLE;
    private static final String ID;
    private static final String UNREPEATABLE;
    private static final String URL;
    private static final Set<String> unrepeatableIds;
    private final Context mContext;
    private final HitSenderProvider mHitSenderProvider;
    
    static {
        ID = FunctionType.ARBITRARY_PIXEL.toString();
        URL = Key.URL.toString();
        ADDITIONAL_PARAMS = Key.ADDITIONAL_PARAMS.toString();
        UNREPEATABLE = Key.UNREPEATABLE.toString();
        ARBITRARY_PIXEL_UNREPEATABLE = "gtm_" + ArbitraryPixelTag.ID + "_unrepeatable";
        unrepeatableIds = new HashSet<String>();
    }
    
    public ArbitraryPixelTag(final Context context) {
        this(context, (HitSenderProvider)new HitSenderProvider() {
            @Override
            public HitSender get() {
                return DelayedHitSender.getInstance(context);
            }
        });
    }
    
    ArbitraryPixelTag(final Context mContext, final HitSenderProvider mHitSenderProvider) {
        super(ArbitraryPixelTag.ID, new String[] { ArbitraryPixelTag.URL });
        this.mHitSenderProvider = mHitSenderProvider;
        this.mContext = mContext;
    }
    
    public static String getFunctionId() {
        return ArbitraryPixelTag.ID;
    }
    
    private boolean idProcessed(final String s) {
        while (true) {
            boolean b = true;
            synchronized (this) {
                if (!this.idInCache(s)) {
                    if (!this.idInSharedPreferences(s)) {
                        return false;
                    }
                    ArbitraryPixelTag.unrepeatableIds.add(s);
                }
                return b;
            }
            b = false;
            return b;
        }
    }
    
    @VisibleForTesting
    void clearCache() {
        ArbitraryPixelTag.unrepeatableIds.clear();
    }
    
    @Override
    public void evaluateTrackingTag(final Map<String, TypeSystem.Value> map) {
        String valueToString;
        if (map.get(ArbitraryPixelTag.UNREPEATABLE) != null) {
            valueToString = Types.valueToString(map.get(ArbitraryPixelTag.UNREPEATABLE));
        }
        else {
            valueToString = null;
        }
        if (valueToString == null || !this.idProcessed(valueToString)) {
            final Uri$Builder buildUpon = Uri.parse(Types.valueToString(map.get(ArbitraryPixelTag.URL))).buildUpon();
            final TypeSystem.Value value = map.get(ArbitraryPixelTag.ADDITIONAL_PARAMS);
            if (value != null) {
                final Object valueToObject = Types.valueToObject(value);
                if (!(valueToObject instanceof List)) {
                    Log.e("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                    return;
                }
                for (final Map<Object, V> next : (List<Object>)valueToObject) {
                    if (!(next instanceof Map)) {
                        Log.e("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                        return;
                    }
                    for (final Map.Entry<Object, V> entry : next.entrySet()) {
                        buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
            }
            final String string = buildUpon.build().toString();
            this.mHitSenderProvider.get().sendHit(string);
            Log.v("ArbitraryPixel: url = " + string);
            if (valueToString != null) {
                synchronized (ArbitraryPixelTag.class) {
                    ArbitraryPixelTag.unrepeatableIds.add(valueToString);
                    SharedPreferencesUtil.saveAsync(this.mContext, ArbitraryPixelTag.ARBITRARY_PIXEL_UNREPEATABLE, valueToString, "true");
                }
            }
        }
    }
    
    @VisibleForTesting
    boolean idInCache(final String s) {
        return ArbitraryPixelTag.unrepeatableIds.contains(s);
    }
    
    @VisibleForTesting
    boolean idInSharedPreferences(final String s) {
        return this.mContext.getSharedPreferences(ArbitraryPixelTag.ARBITRARY_PIXEL_UNREPEATABLE, 0).contains(s);
    }
    
    public interface HitSenderProvider
    {
        HitSender get();
    }
}
