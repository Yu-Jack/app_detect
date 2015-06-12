// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.androidlabs.base;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class EditPreferencesActivity extends PreferenceActivity
{
    private BankingApplication mThisApplication;
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.mThisApplication = (BankingApplication)this.getApplication();
        this.addPreferencesFromResource(2130968576);
    }
}
