// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.List;
import android.text.TextUtils;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;
import java.util.Collections;
import java.util.Locale;
import java.util.HashMap;
import java.util.Map;

public final class bk implements k
{
    private static final String a;
    private static final Map b;
    
    static {
        a = bk.class.getSimpleName();
        b = a();
    }
    
    private static k a(final String s) {
        return bk.b.get(s);
    }
    
    private static Map a() {
        final HashMap<String, bn> m = new HashMap<String, bn>();
        m.put("AdMob".toUpperCase(Locale.US), new bq());
        m.put("Millennial Media".toUpperCase(Locale.US), (bq)new bw());
        m.put("InMobi".toUpperCase(Locale.US), (bq)new bs());
        m.put("Facebook Audience Network".toUpperCase(Locale.US), (bq)new bn());
        return Collections.unmodifiableMap((Map<?, ?>)m);
    }
    
    @Override
    public final i a(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit) {
        i a;
        if (context == null || flurryAdModule == null || e == null || adUnit == null) {
            a = null;
        }
        else {
            final List d = adUnit.d();
            if (d == null || d.isEmpty()) {
                return null;
            }
            final AdFrame adFrame = d.get(0);
            if (adFrame == null) {
                return null;
            }
            final String string = adFrame.d().toString();
            if (TextUtils.isEmpty((CharSequence)string)) {
                return null;
            }
            final k a2 = a(string.toUpperCase(Locale.US));
            if (a2 == null) {
                return null;
            }
            eo.a(3, bk.a, "Creating ad network view for type: " + string);
            a = a2.a(context, flurryAdModule, e, adUnit);
            if (a == null) {
                eo.b(bk.a, "Cannot create ad network view for type: " + string);
                return null;
            }
            if (a != null) {
                a.setAdUnit(adUnit);
                return a;
            }
        }
        return a;
    }
}
