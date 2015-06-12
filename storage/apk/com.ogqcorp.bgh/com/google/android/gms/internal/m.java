// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.res.TypedArray;
import android.text.TextUtils;
import com.google.android.gms.c;
import android.util.AttributeSet;
import android.content.Context;
import com.google.android.gms.ads.d;

public final class m
{
    private final d[] a;
    private final String b;
    
    public m(final Context context, final AttributeSet set) {
        int n = 1;
        final TypedArray obtainAttributes = context.getResources().obtainAttributes(set, c.AdsAttrs);
        final String string = obtainAttributes.getString(0);
        final String string2 = obtainAttributes.getString(n);
        int n2;
        if (!TextUtils.isEmpty((CharSequence)string)) {
            n2 = n;
        }
        else {
            n2 = 0;
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            n = 0;
        }
        if (n2 != 0 && n == 0) {
            this.a = a(string);
        }
        else if (n2 == 0 && n != 0) {
            this.a = a(string2);
        }
        else {
            if (n2 != 0 && n != 0) {
                throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
            }
            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        }
        this.b = obtainAttributes.getString(2);
        if (TextUtils.isEmpty((CharSequence)this.b)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }
    
    private static d[] a(final String str) {
        final String[] split = str.split("\\s*,\\s*");
        final d[] array = new d[split.length];
        int i = 0;
    Label_0119_Outer:
        while (i < split.length) {
            final String trim = split[i].trim();
            while (true) {
                Label_0183: {
                    if (!trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                        break Label_0183;
                    }
                    final String[] split2 = trim.split("[xX]");
                    split2[0] = split2[0].trim();
                    split2[1] = split2[1].trim();
                    try {
                        int int1;
                        if ("FULL_WIDTH".equals(split2[0])) {
                            int1 = -1;
                        }
                        else {
                            int1 = Integer.parseInt(split2[0]);
                        }
                        int int2;
                        if ("AUTO_HEIGHT".equals(split2[1])) {
                            int2 = -2;
                        }
                        else {
                            int2 = Integer.parseInt(split2[1]);
                        }
                        array[i] = new d(int1, int2);
                        ++i;
                        continue Label_0119_Outer;
                    }
                    catch (NumberFormatException ex) {
                        throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + trim);
                    }
                }
                if ("BANNER".equals(trim)) {
                    array[i] = d.a;
                    continue;
                }
                if ("LARGE_BANNER".equals(trim)) {
                    array[i] = d.c;
                    continue;
                }
                if ("FULL_BANNER".equals(trim)) {
                    array[i] = d.b;
                    continue;
                }
                if ("LEADERBOARD".equals(trim)) {
                    array[i] = d.d;
                    continue;
                }
                if ("MEDIUM_RECTANGLE".equals(trim)) {
                    array[i] = d.e;
                    continue;
                }
                if ("SMART_BANNER".equals(trim)) {
                    array[i] = d.g;
                    continue;
                }
                if ("WIDE_SKYSCRAPER".equals(trim)) {
                    array[i] = d.f;
                    continue;
                }
                break;
            }
            throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + trim);
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + str);
        }
        return array;
    }
    
    public String a() {
        return this.b;
    }
    
    public d[] a(final boolean b) {
        if (!b && this.a.length != 1) {
            throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
        }
        return this.a;
    }
}
