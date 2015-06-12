// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.content.SharedPreferences;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Build$VERSION;
import com.socialnmobile.colornote.view.MyIntentPreference;
import android.os.Bundle;
import java.util.UnknownFormatConversionException;
import android.preference.ListPreference;
import android.preference.Preference;
import android.content.Context;
import android.content.SharedPreferences$OnSharedPreferenceChangeListener;
import android.preference.PreferenceActivity;

public class Settings extends PreferenceActivity implements SharedPreferences$OnSharedPreferenceChangeListener
{
    private void a(final String s) {
        if (s.equals("pref_default_screen") || s.equals("ALL")) {
            this.b("pref_default_screen");
        }
        if (s.equals("pref_default_font_size") || s.equals("ALL")) {
            this.b("pref_default_font_size");
        }
        if (s.equals("pref_default_sort_option") || s.equals("ALL")) {
            this.b("pref_default_sort_option");
        }
        if (s.equals("pref_list_item_height") || s.equals("ALL")) {
            jp.c((Context)this);
            this.b("pref_list_item_height");
        }
        if (s.equals("pref_sort_order_in_color") || s.equals("ALL")) {
            this.b("pref_sort_order_in_color");
        }
        if (s.equals("pref_widget_transparency") || s.equals("ALL")) {
            this.b("pref_widget_transparency");
        }
        if (s.equals("pref_first_day_of_week") || s.equals("ALL")) {
            this.b("pref_first_day_of_week");
        }
        if (s.equals("pref_show_lunar_date_str") || s.equals("ALL")) {
            this.b("pref_show_lunar_date_str");
        }
        if (s.equals("pref_autolink_phone_type") || s.equals("ALL")) {
            this.b("pref_autolink_phone_type");
        }
        if (s.equals("pref_base_style") || s.equals("ALL")) {
            this.b("pref_base_style");
        }
        if (s.equals("ALL")) {
            final Preference preference = this.getPreferenceScreen().findPreference((CharSequence)"pref_online_sync");
            final Preference preference2 = this.getPreferenceScreen().findPreference((CharSequence)"pref_sync_on_launch");
            final rt c = rt.c((Context)this);
            String a;
            if (c != null) {
                a = SyncStatus.a(c);
                preference2.setEnabled(true);
            }
            else {
                a = "";
                preference2.setEnabled(false);
            }
            preference.setSummary((CharSequence)a);
        }
        if (s.equals("pref_show_all_day_reminder")) {
            gu.b((Context)this, System.currentTimeMillis());
        }
    }
    
    private void b(final String s) {
        final ListPreference listPreference = (ListPreference)this.getPreferenceScreen().findPreference((CharSequence)s);
        try {
            listPreference.setSummary(listPreference.getEntry());
            listPreference.getSummary();
        }
        catch (UnknownFormatConversionException ex) {
            listPreference.setSummary((CharSequence)"%s");
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.addPreferencesFromResource(2131034113);
        final MyIntentPreference myIntentPreference = (MyIntentPreference)this.getPreferenceScreen().findPreference((CharSequence)"pref_faq");
        myIntentPreference.setIntent(gw.e("http://www.colornote.com/help/faq.html"));
        String string = "";
        while (true) {
            try {
                string = this.getString(2131230755, new Object[] { this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName });
                myIntentPreference.setSummary((CharSequence)string);
                myIntentPreference.a(2130837524);
                final MyIntentPreference myIntentPreference2 = (MyIntentPreference)this.getPreferenceScreen().findPreference((CharSequence)"pref_privacy");
                myIntentPreference2.setIntent(gw.e("http://www.colornote.com/help/privacy.html"));
                myIntentPreference2.a(2130837524);
                final MyIntentPreference myIntentPreference3 = (MyIntentPreference)this.getPreferenceScreen().findPreference((CharSequence)"pref_trans");
                myIntentPreference3.setIntent(gw.e("http://www.colornote.com/help/translation.html"));
                myIntentPreference3.a(2130837524);
                final MyIntentPreference myIntentPreference4 = (MyIntentPreference)this.getPreferenceScreen().findPreference((CharSequence)"pref_facebook");
                myIntentPreference4.setIntent(gw.e((Context)this));
                myIntentPreference4.a(2130837561);
                if (jn.b()) {
                    this.findPreference((CharSequence)"pref_use_auto_select").setEnabled(false);
                }
                if (!jn.c()) {
                    this.findPreference((CharSequence)"pref_base_style").setEnabled(false);
                }
                int n;
                if (Build$VERSION.SDK_INT > 10) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                if (n == 0) {
                    this.findPreference((CharSequence)"pref_gpu_rendering").setEnabled(false);
                }
            }
            catch (PackageManager$NameNotFoundException ex) {
                continue;
            }
            break;
        }
    }
    
    protected void onPause() {
        super.onPause();
        this.getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener((SharedPreferences$OnSharedPreferenceChangeListener)this);
    }
    
    protected void onResume() {
        super.onResume();
        this.a("ALL");
        this.getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener((SharedPreferences$OnSharedPreferenceChangeListener)this);
    }
    
    public void onSharedPreferenceChanged(final SharedPreferences sharedPreferences, final String s) {
        this.a(s);
        if (s.equals("pref_widget_transparency")) {
            rq.a((Context)this);
            rq.b((Context)this);
        }
    }
}
