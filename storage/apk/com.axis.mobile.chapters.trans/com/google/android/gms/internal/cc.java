// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import android.content.Intent;
import android.content.Context;

public final class cc
{
    public static boolean a(final Context context, final ce ce, final cl cl) {
        if (ce == null) {
            eu.D("No intent data for launcher overlay.");
            return false;
        }
        final Intent obj = new Intent();
        if (TextUtils.isEmpty((CharSequence)ce.ob)) {
            eu.D("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty((CharSequence)ce.mimeType)) {
            obj.setDataAndType(Uri.parse(ce.ob), ce.mimeType);
        }
        else {
            obj.setData(Uri.parse(ce.ob));
        }
        obj.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty((CharSequence)ce.packageName)) {
            obj.setPackage(ce.packageName);
        }
        if (!TextUtils.isEmpty((CharSequence)ce.oc)) {
            final String[] split = ce.oc.split("/", 2);
            if (split.length < 2) {
                eu.D("Could not parse component name from open GMSG: " + ce.oc);
                return false;
            }
            obj.setClassName(split[0], split[1]);
        }
        try {
            eu.C("Launching an intent: " + obj);
            context.startActivity(obj);
            cl.Y();
            return true;
        }
        catch (ActivityNotFoundException ex) {
            eu.D(ex.getMessage());
            return false;
        }
    }
}
