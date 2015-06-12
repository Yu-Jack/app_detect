// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.androidlabs.base;

import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.os.Bundle;
import android.content.SharedPreferences$Editor;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;

public class BankingActivity extends Activity
{
    protected BankingApplication mThisApplication;
    
    private void launchLoginScreen() {
        final Intent intent = new Intent((Context)this, (Class)LoginActivity.class);
        intent.addFlags(67108864);
        this.startActivity(intent);
    }
    
    private void launchPreferenceScreen() {
        this.startActivity(new Intent((Context)this, (Class)EditPreferencesActivity.class));
    }
    
    private void resetApplication() {
        final BankingApplication bankingApplication = (BankingApplication)this.getApplication();
        bankingApplication.clearStatements();
        final SharedPreferences$Editor edit = bankingApplication.getSharedPrefs().edit();
        edit.clear();
        edit.commit();
        bankingApplication.lockApplication();
        this.launchLoginScreen();
    }
    
    protected void authenticate() {
        final Intent intent = new Intent((Context)this, (Class)LoginActivity.class);
        intent.addFlags(67108864);
        this.startActivity(intent);
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.mThisApplication = (BankingApplication)this.getApplication();
        if (this.mThisApplication.isLocked() && this.getClass() != LoginActivity.class) {
            this.launchLoginScreen();
        }
        else {
            final View viewById = this.findViewById(2131165187);
            if (viewById != null) {
                viewById.setVisibility(0);
            }
        }
    }
    
    public boolean onCreateOptionsMenu(final Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.getMenuInflater().inflate(2131099648, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            default: {
                return super.onOptionsItemSelected(menuItem);
            }
            case 2131165202: {
                this.resetApplication();
                return true;
            }
            case 2131165203: {
                this.launchPreferenceScreen();
                return true;
            }
        }
    }
    
    protected void onPause() {
        super.onPause();
        this.setInvisible();
        this.mThisApplication.registerActivityBackgrounded();
    }
    
    protected void onResume() {
        super.onResume();
        this.setAppropriateVisibility();
        this.mThisApplication.registerActivityForegrounded();
        if (this.mThisApplication.isLocked() && this.getClass() != LoginActivity.class) {
            final Intent intent = new Intent((Context)this, (Class)LoginActivity.class);
            intent.addFlags(67108864);
            this.startActivity(intent);
        }
    }
    
    public void setAppropriateVisibility() {
        final View viewById = this.findViewById(2131165187);
        if (viewById != null) {
            if (!this.mThisApplication.isLocked()) {
                viewById.setVisibility(0);
                return;
            }
            viewById.setVisibility(8);
        }
    }
    
    public void setInvisible() {
        final View viewById = this.findViewById(2131165187);
        if (viewById != null) {
            viewById.setVisibility(8);
        }
    }
}
