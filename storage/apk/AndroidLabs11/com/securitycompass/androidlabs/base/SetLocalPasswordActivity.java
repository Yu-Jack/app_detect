// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.androidlabs.base;

import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.view.View$OnClickListener;
import android.os.Bundle;
import android.content.SharedPreferences$Editor;
import java.io.IOException;
import java.security.KeyManagementException;
import org.json.JSONException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import android.util.Log;
import android.content.Intent;
import android.widget.Toast;
import android.widget.Button;
import android.content.Context;
import android.widget.EditText;
import android.app.Activity;

public class SetLocalPasswordActivity extends Activity
{
    private static final String TAG = "SetLocalPasswordActivity";
    private EditText mConfirmPasswordField;
    private Context mCtx;
    private Button mDoneButton;
    private EditText mPasswordField;
    private BankingApplication mThisApplication;
    
    private void grabAndSetPassword() {
        this.mThisApplication.setServerCredentials(this.getIntent().getStringExtra("username"), this.getIntent().getStringExtra("password"));
        final String string = this.mPasswordField.getText().toString();
        final String string2 = this.mConfirmPasswordField.getText().toString();
        if (!string.equals(string2)) {
            Toast.makeText(this.mCtx, 2131034141, 0).show();
            return;
        }
        while (true) {
            try {
                this.mThisApplication.setLocalPassword(string);
                this.mThisApplication.unlockApplication(string2);
                Toast.makeText(this.mCtx, 2131034147, 0).show();
                final SharedPreferences$Editor edit = this.mThisApplication.getSharedPrefs().edit();
                edit.putBoolean("firstrun", false);
                edit.commit();
                final Intent intent = new Intent(this.mCtx, (Class)SummaryActivity.class);
                intent.addFlags(67108864);
                this.startActivity(intent);
            }
            catch (NoSuchAlgorithmException ex) {
                Toast.makeText(this.mCtx, 2131034142, 1).show();
                Log.e("SetLocalPasswordActivity", ex.toString());
                continue;
            }
            catch (UnsupportedEncodingException ex2) {
                Toast.makeText(this.mCtx, 2131034142, 1).show();
                Log.e("SetLocalPasswordActivity", ex2.toString());
                continue;
            }
            catch (JSONException ex3) {
                Toast.makeText(this.mCtx, 2131034138, 0).show();
                Log.e("SetLocalPasswordActivity", ex3.toString());
                continue;
            }
            catch (HttpException ex4) {
                Toast.makeText(this.mCtx, (CharSequence)(this.getString(2131034137) + ex4.getStatusCode()), 0).show();
                Log.e("SetLocalPasswordActivity", ex4.toString());
                continue;
            }
            catch (KeyManagementException ex5) {
                Toast.makeText(this.mCtx, 2131034144, 1).show();
                Log.e("SetLocalPasswordActivity", ex5.toString());
                continue;
            }
            catch (IOException ex6) {
                Toast.makeText(this.mCtx, 2131034136, 0).show();
                Log.e("SetLocalPasswordActivity", ex6.toString());
                continue;
            }
            break;
        }
    }
    
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
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903043);
        this.mCtx = (Context)this;
        this.mThisApplication = (BankingApplication)this.getApplication();
        this.mPasswordField = (EditText)this.findViewById(2131165190);
        this.mConfirmPasswordField = (EditText)this.findViewById(2131165191);
        (this.mDoneButton = (Button)this.findViewById(2131165192)).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                SetLocalPasswordActivity.this.grabAndSetPassword();
            }
        });
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
}
