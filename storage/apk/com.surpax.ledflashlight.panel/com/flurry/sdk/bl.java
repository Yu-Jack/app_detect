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

public final class bl implements ak
{
    private static final String a;
    private static final Map b;
    
    static {
        a = bl.class.getSimpleName();
        b = a();
    }
    
    private static ak a(final String s) {
        return bl.b.get(s);
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
    public final aj a_(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit) {
        aj a_;
        if (context == null || flurryAdModule == null || e == null || adUnit == null) {
            a_ = null;
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
            final ak a = a(string.toUpperCase(Locale.US));
            if (a == null) {
                return null;
            }
            eo.a(3, bl.a, "Creating ad network takeover launcher: " + a.getClass().getSimpleName() + " for type: " + string);
            a_ = a.a_(context, flurryAdModule, e, adUnit);
            if (a_ == null) {
                eo.b(bl.a, "Cannot create ad network takeover launcher for type: " + string);
                return a_;
            }
        }
        return a_;
    }
}
