// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.res.Resources$NotFoundException;
import android.util.Log;
import android.util.TypedValue;
import android.util.AttributeSet;
import android.content.Context;

public class hp
{
    public static String a(final String s, final String str, final Context context, final AttributeSet set, final boolean b, final boolean b2, final String s2) {
    Label_0109:
        while (true) {
            while (true) {
                String str2 = null;
                Label_0007: {
                    if (set == null) {
                        str2 = null;
                        break Label_0007;
                    }
                    Label_0152: {
                        break Label_0152;
                        while (true) {
                            final String substring = str2.substring("@string/".length());
                            final String packageName = context.getPackageName();
                            final TypedValue obj = new TypedValue();
                        Label_0205:
                            while (true) {
                                try {
                                    context.getResources().getValue(packageName + ":string/" + substring, obj, true);
                                    if (obj.string != null) {
                                        str2 = obj.string.toString();
                                        if (b2 && str2 == null) {
                                            Log.w(s2, "Required XML attribute \"" + str + "\" missing");
                                        }
                                        return str2;
                                    }
                                    break Label_0205;
                                    str2 = set.getAttributeValue(s, str);
                                    break;
                                }
                                catch (Resources$NotFoundException ex) {
                                    Log.w(s2, "Could not find resource for " + str + ": " + str2);
                                    continue;
                                }
                                break;
                            }
                            Log.w(s2, "Resource " + str + " was not a string: " + obj);
                            continue Label_0109;
                        }
                    }
                }
                if (str2 != null && str2.startsWith("@string/") && b) {
                    continue;
                }
                break;
            }
            continue Label_0109;
        }
    }
}
