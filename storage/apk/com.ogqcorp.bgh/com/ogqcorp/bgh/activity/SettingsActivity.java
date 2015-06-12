// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import android.content.SharedPreferences;
import com.actionbarsherlock.view.MenuItem;
import com.ogqcorp.bgh.system.v;
import android.os.Bundle;
import android.app.Activity;
import com.ogqcorp.bgh.d.a;
import com.ogqcorp.bgh.d.e;
import com.ogqcorp.bgh.d.h;
import com.ogqcorp.bgh.d.j;
import com.ogqcorp.bgh.d.f;
import com.ogqcorp.bgh.d.g;
import com.ogqcorp.bgh.d.i;
import com.ogqcorp.bgh.d.b;
import android.content.Intent;
import android.content.Context;
import com.ogqcorp.bgh.d.d;
import android.content.SharedPreferences$OnSharedPreferenceChangeListener;
import com.ogqcorp.bgh.activity.a.c;

public final class SettingsActivity extends c implements SharedPreferences$OnSharedPreferenceChangeListener
{
    private d[] a;
    
    public static Intent a(final Context context) {
        return new Intent(context, (Class)SettingsActivity.class);
    }
    
    private void a() {
        int i = 0;
        this.a = new d[] { new com.ogqcorp.bgh.d.c(), new b(), new i(), new g(), new f(), new j(), new h(), new e(), new a() };
        for (d[] a = this.a; i < a.length; ++i) {
            final d d = a[i];
            d.a((Activity)this, this.findPreference((CharSequence)d.a()));
        }
    }
    
    private void b() {
        for (final d d : this.a) {
            d.a(this.getApplicationContext(), this.findPreference((CharSequence)d.a()));
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        v.a().e((Context)this);
        this.addPreferencesFromResource(2131034113);
        this.a();
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    
    protected void onDestroy() {
        final d[] a = this.a;
        for (int length = a.length, i = 0; i < length; ++i) {
            a[i].b();
        }
        this.a = null;
        super.onDestroy();
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
    
    protected void onPause() {
        this.getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener((SharedPreferences$OnSharedPreferenceChangeListener)this);
        super.onPause();
    }
    
    protected void onResume() {
        this.b();
        this.getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener((SharedPreferences$OnSharedPreferenceChangeListener)this);
        super.onResume();
    }
    
    public void onSharedPreferenceChanged(final SharedPreferences sharedPreferences, final String s) {
        v.a().a(sharedPreferences, s);
        this.b();
    }
}
