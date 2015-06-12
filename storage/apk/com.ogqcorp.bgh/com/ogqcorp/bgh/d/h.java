// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.d;

import android.preference.Preference;
import java.util.Locale;
import com.ogqcorp.bgh.system.f;
import android.content.Context;
import android.os.Build$VERSION;
import android.os.Build;
import com.ogqcorp.bgh.system.ac;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.app.Activity;
import android.preference.Preference$OnPreferenceClickListener;

public final class h implements Preference$OnPreferenceClickListener, d
{
    private Activity a;
    
    private PackageInfo a(final PackageManager packageManager) {
        return ac.a(packageManager, packageManager.resolveActivity(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME"), 65536));
    }
    
    private String c() {
        int i = 0;
        final StringBuilder sb = new StringBuilder(this.a.getString(2131427439));
        for (Object[] array = { Build.BRAND, Build.MODEL, Build$VERSION.RELEASE, Build$VERSION.INCREMENTAL, this.d(), ac.d((Context)this.a), f.a().b() }; i < array.length; ++i) {
            sb.append(array[i]).append("/");
        }
        return sb.toString();
    }
    
    private String d() {
        final PackageInfo a = this.a(this.a.getPackageManager());
        if (a == null) {
            return "";
        }
        return String.format(Locale.US, "%s/%d/%s", a.packageName, a.versionCode, a.versionName);
    }
    
    public String a() {
        return "SEND_FEEDBACK";
    }
    
    public void a(final Activity a, final Preference preference) {
        this.a = a;
        preference.setOnPreferenceClickListener((Preference$OnPreferenceClickListener)this);
    }
    
    public void a(final Context context, final Preference preference) {
    }
    
    public void b() {
        this.a = null;
    }
    
    public boolean onPreferenceClick(final Preference preference) {
        final Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("plain/text");
        intent.putExtra("android.intent.extra.EMAIL", new String[] { this.a.getString(2131427438) });
        intent.putExtra("android.intent.extra.SUBJECT", this.a.getString(2131427440));
        intent.putExtra("android.intent.extra.TEXT", this.c());
        this.a.startActivity(Intent.createChooser(intent, (CharSequence)this.a.getString(2131427474)));
        return true;
    }
}
