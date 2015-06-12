// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import com.ogqcorp.bgh.system.c;
import android.app.Activity;
import com.ogqcorp.bgh.system.b;
import android.os.Bundle;
import com.ogqcorp.bgh.system.ac;
import com.ogqcorp.bgh.system.w;
import com.ogqcorp.bgh.system.y;
import android.os.Environment;
import android.database.Cursor;
import android.content.ContentValues;
import android.provider.MediaStore$Images$Media;
import com.ogqcorp.commons.u;
import android.os.Parcelable;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import com.ogqcorp.bgh.b.i;
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
import com.ogqcorp.bgh.cf.a.a;

public class MyCuratorFlickrActivity extends a
{
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
    
    private i a(final String s) {
        final i i = new i();
        i.a(s);
        return i;
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
    
    private void a(final FragmentActivity fragmentActivity, final File file) {
        final List<Intent> a = this.a((Context)fragmentActivity, file);
        if (a == null || a.size() == 0) {
            Toast.makeText((Context)fragmentActivity, 2131427479, 0).show();
            return;
        }
        final Intent chooser = Intent.createChooser(new Intent((Intent)a.remove(0)), (CharSequence)fragmentActivity.getString(2131427474));
        chooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])a.toArray(new Parcelable[0]));
        this.startActivity(chooser);
    }
    
    private void a(final FragmentActivity fragmentActivity, final String s, final String str, final String s2, final u<File> u, final u<Exception> u2) {
        this.a().mkdirs();
        final File file = new File(this.a(), str + ".jpg");
        if (file.exists()) {
            this.a(str, file, u, false);
            return;
        }
        this.a(s2).a(fragmentActivity.getSupportFragmentManager(), s, file, new u<Exception>() {
            @Override
            public void a(final Exception ex) {
                if (ex == null) {
                    MyCuratorFlickrActivity.this.a(str, file, u, true);
                    return;
                }
                MyCuratorFlickrActivity.this.a(str, ex, u2);
            }
        });
    }
    
    private void a(final String s, final String s2, final String s3, final u<File> u, final u<Exception> u2) {
        if (!this.isFinishing()) {
            this.a(this, s, s2, s3, u, u2);
        }
    }
    
    private void a(final List<Intent> list) {
        if (!list.isEmpty()) {
            final Iterator<Intent> iterator = list.iterator();
            final Intent intent = iterator.next();
            while (intent != null && iterator.hasNext()) {
                if (intent.getPackage().equals(iterator.next().getPackage())) {
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
    
    private void b(final FragmentActivity fragmentActivity, final String s, final String str, final String s2, final u<File> u, final u<Exception> u2) {
        this.a().mkdirs();
        final File file = new File(this.a(), str + ".jpg");
        if (file.exists()) {
            this.b(str, file, u, false);
            return;
        }
        this.a(s2).a(fragmentActivity.getSupportFragmentManager(), s, file, new u<Exception>() {
            @Override
            public void a(final Exception ex) {
                if (ex == null) {
                    MyCuratorFlickrActivity.this.b(str, file, u, true);
                    return;
                }
                MyCuratorFlickrActivity.this.a(str, ex, u2);
            }
        });
    }
    
    private void b(final String s, final String s2, final String s3, final u<File> u, final u<Exception> u2) {
        if (!this.isFinishing()) {
            this.b(this, s, s2, s3, u, u2);
        }
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
    
    public File a() {
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Backgrounds");
    }
    
    protected void a(final String s, final File file, final u<File> u, final boolean b) {
        if (!this.isFinishing()) {
            Toast.makeText((Context)this, 2131427484, 0).show();
            if (b) {
                w.a((Context)this, file, new y() {
                    @Override
                    public void a() {
                        if (u != null) {
                            u.a(file);
                        }
                    }
                });
                return;
            }
            if (u != null) {
                u.a(file);
            }
        }
    }
    
    protected void a(final String s, final Exception ex, final u<Exception> u) {
        if (!this.isFinishing()) {
            if (ex instanceof InterruptedException) {
                ac.a((Context)this, 0, 2131427482, new Object[0]).show();
            }
            else {
                ac.a((Context)this, 0, 2131427483, ex.toString()).show();
            }
            if (u != null) {
                u.a(ex);
            }
        }
    }
    
    @Override
    public void a(final String s, final String s2, final String s3) {
        this.a(s, s2, s3, null, null);
    }
    
    protected void b(final String s, final File file, final u<File> u, final boolean b) {
        if (this.isFinishing()) {
            return;
        }
        Toast.makeText((Context)this, 2131427484, 0).show();
        if (b) {
            w.a((Context)this, file, new y() {
                @Override
                public void a() {
                    MyCuratorFlickrActivity.this.a(MyCuratorFlickrActivity.this, file);
                }
            });
            return;
        }
        this.a(this, file);
    }
    
    @Override
    public void b(final String s, final String s2, final String s3) {
        this.b(s, s2, s3, null, null);
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        com.ogqcorp.bgh.system.b.a().a(this, 2131099753);
    }
    
    @Override
    protected void onDestroy() {
        com.ogqcorp.bgh.system.b.a().d(this, 2131099753);
        super.onDestroy();
    }
    
    public void onPause() {
        com.ogqcorp.bgh.system.b.a().c(this, 2131099753);
        super.onPause();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        com.ogqcorp.bgh.system.b.a().b(this, 2131099753);
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        com.ogqcorp.bgh.system.c.a().a(this);
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        com.ogqcorp.bgh.system.c.a().b(this);
    }
}
