// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.sync;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.SharedPreferences$OnSharedPreferenceChangeListener;
import android.preference.PreferenceActivity;

public class SyncDevSettingsActivity extends PreferenceActivity implements SharedPreferences$OnSharedPreferenceChangeListener
{
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.finish();
    }
    
    protected void onPause() {
        super.onPause();
        this.getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener((SharedPreferences$OnSharedPreferenceChangeListener)this);
    }
    
    protected void onResume() {
        super.onResume();
        this.getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener((SharedPreferences$OnSharedPreferenceChangeListener)this);
    }
    
    public void onSharedPreferenceChanged(final SharedPreferences sharedPreferences, final String s) {
    }
}
