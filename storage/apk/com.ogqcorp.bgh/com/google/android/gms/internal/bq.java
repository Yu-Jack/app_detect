// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import android.content.Intent;
import android.content.Context;

public final class bq
{
    public static boolean a(final Context context, final cb cb, final cc cc) {
        if (cb == null) {
            en.e("No intent data for launcher overlay.");
            return false;
        }
        final Intent obj = new Intent();
        if (TextUtils.isEmpty((CharSequence)cb.c)) {
            en.e("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty((CharSequence)cb.d)) {
            obj.setDataAndType(Uri.parse(cb.c), cb.d);
        }
        else {
            obj.setData(Uri.parse(cb.c));
        }
        obj.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty((CharSequence)cb.e)) {
            obj.setPackage(cb.e);
        }
        if (!TextUtils.isEmpty((CharSequence)cb.f)) {
            final String[] split = cb.f.split("/", 2);
            if (split.length < 2) {
                en.e("Could not parse component name from open GMSG: " + cb.f);
                return false;
            }
            obj.setClassName(split[0], split[1]);
        }
        try {
            en.d("Launching an intent: " + obj);
            context.startActivity(obj);
            cc.q();
            return true;
        }
        catch (ActivityNotFoundException ex) {
            en.e(ex.getMessage());
            return false;
        }
    }
}
