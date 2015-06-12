// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import java.io.File;
import android.content.ComponentName;
import android.widget.Toast;
import android.content.Context;
import com.ogqcorp.bgh.system.c;
import android.net.Uri;
import android.content.Intent;
import org.a.a.a.b;
import com.ogqcorp.bgh.system.o;
import com.ogqcorp.bgh.item.Background;
import java.util.Iterator;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import java.util.List;
import android.app.Activity;

final class e extends d<Activity>
{
    e(final Activity activity) {
        super(activity);
    }
    
    private static ActivityInfo a(final List<ResolveInfo> list) {
        final Iterator<ResolveInfo> iterator = list.iterator();
        while (iterator.hasNext()) {
            final ActivityInfo activityInfo = iterator.next().activityInfo;
            if (activityInfo.packageName.equals("com.android.contacts") && (activityInfo.name.contains(".AttachImage") || activityInfo.name.contains(".AttachPhotoActivity"))) {
                return activityInfo;
            }
            if (activityInfo.packageName.equals("com.android.htccontacts")) {
                return activityInfo;
            }
        }
        return null;
    }
    
    private void a(final Activity activity, final Background background) {
        final File b = o.b().b(background.getId());
        if (!b.exists()) {
            return;
        }
        final File g = o.b().g();
        org.a.a.a.b.a(b, g);
        final Intent intent = new Intent("android.intent.action.ATTACH_DATA");
        intent.setDataAndType(Uri.fromFile(g), "image/*");
        intent.putExtra("mimeType", "image/*");
        final ActivityInfo a = a(activity.getPackageManager().queryIntentActivities(intent, 65536));
        c.a().b((Context)activity, background);
        if (a == null) {
            c.a().a((Context)activity, false);
            Toast.makeText((Context)activity, 2131427478, 0).show();
            return;
        }
        c.a().a((Context)activity, true);
        intent.setComponent(new ComponentName(a.packageName, a.name));
        activity.startActivity(intent);
    }
    
    void a(final Background background) {
        new com.ogqcorp.commons.o().a(background, "background");
        final Activity a = this.a();
        if (a != null) {
            this.a(a, background);
        }
    }
}
