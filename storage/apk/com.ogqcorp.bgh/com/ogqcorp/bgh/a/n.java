// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import android.database.Cursor;
import android.content.ContentValues;
import android.provider.MediaStore$Images$Media;
import com.ogqcorp.bgh.activity.AdjustActivity;
import com.ogqcorp.bgh.system.v;
import com.ogqcorp.bgh.system.e;
import com.ogqcorp.bgh.system.h;
import android.os.Parcelable;
import android.widget.Toast;
import com.ogqcorp.commons.u;
import com.ogqcorp.bgh.system.c;
import com.ogqcorp.bgh.item.Background;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import android.content.pm.LabeledIntent;
import android.net.Uri;
import android.os.Build$VERSION;
import android.content.ComponentName;
import android.content.Intent;
import java.io.File;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager;
import android.content.Context;
import android.support.v4.app.FragmentActivity;

final class n extends d<FragmentActivity>
{
    n(final FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    
    private Intent a(final Context context, final PackageManager packageManager, final ResolveInfo resolveInfo, final ActivityInfo activityInfo, final File file) {
        final Intent intent = new Intent("android.intent.action.ATTACH_DATA");
        intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
        intent.setPackage(activityInfo.packageName);
        if (Build$VERSION.SDK_INT >= 19) {
            intent.setDataAndType(this.a(context, file.getAbsolutePath() + ""), "image/jpeg");
        }
        else {
            intent.setDataAndType(Uri.parse("file://" + file.getAbsolutePath() + ""), "image/jpeg");
        }
        intent.putExtra("mimeType", "image/jpeg");
        return (Intent)new LabeledIntent(intent, activityInfo.packageName, resolveInfo.loadLabel(packageManager), resolveInfo.icon);
    }
    
    private List<Intent> a(final Context context, final File file) {
        final Intent intent = new Intent("android.intent.action.ATTACH_DATA");
        intent.setDataAndType(Uri.fromFile(file), "image/*");
        final List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if (queryIntentActivities.isEmpty()) {
            return null;
        }
        final ArrayList<Intent> list = new ArrayList<Intent>();
        for (final ResolveInfo resolveInfo : queryIntentActivities) {
            final ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (this.a(activityInfo)) {
                list.add(this.a(context, context.getPackageManager(), resolveInfo, activityInfo, file));
            }
        }
        this.a(list);
        return list;
    }
    
    private void a(final FragmentActivity fragmentActivity, final Background background) {
        c.a().g((Context)fragmentActivity, background);
        new o(this, fragmentActivity).a(background, false, null, null);
    }
    
    private void a(final FragmentActivity fragmentActivity, final Background background, final File file) {
        final List<Intent> a = this.a((Context)fragmentActivity, file);
        if (a == null || a.size() == 0) {
            Toast.makeText((Context)fragmentActivity, 2131427479, 0).show();
            return;
        }
        final Intent chooser = Intent.createChooser(new Intent((Intent)a.remove(0)), (CharSequence)fragmentActivity.getString(2131427474));
        chooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])a.toArray(new Parcelable[0]));
        fragmentActivity.startActivityForResult(chooser, 620);
    }
    
    private void a(final FragmentActivity fragmentActivity, final File file) {
        c.a().b((Context)fragmentActivity);
        this.a((Background)null, file);
    }
    
    private void a(final Background background, final File file) {
        final FragmentActivity fragmentActivity = this.a();
        if (fragmentActivity == null) {
            return;
        }
        if (!h.a().e()) {
            final boolean a = e.a((Context)fragmentActivity);
            if (v.a().h((Context)fragmentActivity) || a) {
                this.a(fragmentActivity, background, file);
                return;
            }
        }
        fragmentActivity.startActivityForResult(AdjustActivity.a((Context)fragmentActivity, file, com.ogqcorp.bgh.system.o.b().f(), background), 88);
    }
    
    private void a(final List<Intent> list) {
        if (!list.isEmpty()) {
            final Iterator<Intent> iterator = list.iterator();
            final Intent intent = iterator.next();
            while (intent != null && iterator.hasNext()) {
                final Intent intent2 = iterator.next();
                if (intent.getPackage().equals(intent2.getPackage()) && intent.getComponent().equals((Object)intent2.getComponent())) {
                    iterator.remove();
                }
            }
        }
    }
    
    private boolean a(final ActivityInfo activityInfo) {
        final String[] array = { "com.android.contacts", "com.android.htccontacts", "com.ogqcorp.backgrounds", "com.ogqcorp.bgh" };
        for (int length = array.length, i = 0; i < length; ++i) {
            if (activityInfo.packageName.startsWith(array[i])) {
                return false;
            }
        }
        return true;
    }
    
    public Uri a(final Context context, final String s) {
        final Cursor query = context.getContentResolver().query(MediaStore$Images$Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=? ", new String[] { s }, (String)null);
        Uri withAppendedPath;
        if (query != null && query.moveToFirst()) {
            withAppendedPath = Uri.withAppendedPath(MediaStore$Images$Media.EXTERNAL_CONTENT_URI, Integer.toString(query.getInt(query.getColumnIndex("_id"))));
        }
        else {
            final int length = s.length();
            withAppendedPath = null;
            if (length != 0) {
                final ContentValues contentValues = new ContentValues();
                contentValues.put("_data", s);
                return context.getContentResolver().insert(MediaStore$Images$Media.EXTERNAL_CONTENT_URI, contentValues);
            }
        }
        return withAppendedPath;
    }
    
    void a(final Background background) {
        new com.ogqcorp.commons.o().a(background, "background");
        final FragmentActivity fragmentActivity = this.a();
        if (fragmentActivity != null) {
            this.a(fragmentActivity, background);
        }
    }
    
    void a(final File file) {
        new com.ogqcorp.commons.o().a(file, "file");
        final FragmentActivity fragmentActivity = this.a();
        if (fragmentActivity != null) {
            this.a(fragmentActivity, file);
        }
    }
}
