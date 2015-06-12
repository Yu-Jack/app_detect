// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Iterator;
import java.util.List;
import android.content.Context;
import android.content.ComponentName;
import android.text.TextUtils;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.annotation.TargetApi;
import android.util.SparseArray;

public final class bb implements bf
{
    private static final String a;
    private static final SparseArray b;
    
    static {
        a = bb.class.getSimpleName();
        b = a();
    }
    
    @TargetApi(13)
    private static SparseArray a() {
        final SparseArray sparseArray = new SparseArray();
        sparseArray.append(1, (Object)"mcc");
        sparseArray.append(2, (Object)"mnc");
        sparseArray.append(4, (Object)"locale");
        sparseArray.append(8, (Object)"touchscreen");
        sparseArray.append(16, (Object)"keyboard");
        sparseArray.append(32, (Object)"keyboardHidden");
        sparseArray.append(64, (Object)"navigation");
        sparseArray.append(128, (Object)"orientation");
        sparseArray.append(256, (Object)"screenLayout");
        sparseArray.append(512, (Object)"uiMode");
        sparseArray.append(1024, (Object)"screenSize");
        sparseArray.append(2048, (Object)"smallestScreenSize");
        return sparseArray;
    }
    
    private boolean a(final String s, final PackageManager packageManager, final String s2, final ActivityInfo activityInfo) {
        if (TextUtils.isEmpty((CharSequence)s) || packageManager == null || TextUtils.isEmpty((CharSequence)s2) || activityInfo == null || TextUtils.isEmpty((CharSequence)activityInfo.name)) {
            return false;
        }
        final ActivityInfo a = cb.a(packageManager, new ComponentName(s2, activityInfo.name));
        if (a == null) {
            eo.b(bb.a, s + ": package=\"" + s2 + "\": AndroidManifest.xml should include activity node with android:name=\"" + activityInfo.name + "\"");
            return false;
        }
        eo.a(3, bb.a, s + ": package=\"" + s2 + "\": AndroidManifest.xml has activity node with android:name=\"" + activityInfo.name + "\"");
        final int configChanges = activityInfo.configChanges;
        boolean b2;
        if (configChanges != 0) {
            final int a2 = cb.a(a);
            final SparseArray b = b();
            int i = 0;
            b2 = true;
            while (i < b.size()) {
                final int key = b.keyAt(i);
                if ((key & configChanges) != 0x0) {
                    if ((key & a2) == 0x0) {
                        eo.b(bb.a, s + ": package=\"" + s2 + "\": AndroidManifest.xml activity node with android:name=\"" + activityInfo.name + "\" should include android:configChanges value=\"" + (String)b.valueAt(i) + "\"");
                        b2 = false;
                    }
                    else {
                        eo.a(3, bb.a, s + ": package=\"" + s2 + "\": AndroidManifest.xml activity node with android:name=\"" + activityInfo.name + "\" has android:configChanges value=\"" + (String)b.valueAt(i) + "\"");
                    }
                }
                ++i;
            }
        }
        else {
            b2 = true;
        }
        return b2;
    }
    
    private static SparseArray b() {
        return bb.b;
    }
    
    @Override
    public final boolean a(final Context context, final bj bj) {
        if (bj != null) {
            final String a = bj.a();
            if (!TextUtils.isEmpty((CharSequence)a)) {
                final List e = bj.e();
                if (e != null) {
                    final PackageManager packageManager = context.getPackageManager();
                    final String packageName = context.getPackageName();
                    final Iterator<ActivityInfo> iterator = e.iterator();
                    boolean b = true;
                    while (iterator.hasNext()) {
                        b = (this.a(a, packageManager, packageName, iterator.next()) && b);
                    }
                    return b;
                }
            }
        }
        return false;
    }
}
