// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.androidlabs.base;

import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.view.View$OnClickListener;
import android.os.Bundle;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException;
import org.json.JSONException;
import android.util.Log;
import android.widget.Toast;
import android.content.SharedPreferences$Editor;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.content.Context;
import android.app.Activity;

public class SetServerCredentialsActivity extends Activity
{
    private static final String TAG = "SetServerCredentialsActivity";
    private Context mCtx;
    private Button mDoneButton;
    private EditText mPasswordField;
    private BankingApplication mThisApplication;
    private EditText mUserField;
    
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
    
    private void setServerCredentials() {
        final String string = this.mUserField.getText().toString();
        final String string2 = this.mPasswordField.getText().toString();
        int performLogin = -2;
        while (true) {
            try {
                performLogin = this.mThisApplication.performLogin(string, string2);
                if (performLogin == -1) {
                    this.mThisApplication.lockApplication();
                    final Intent intent = new Intent(this.mCtx, (Class)SetLocalPasswordActivity.class);
                    intent.putExtra("username", string);
                    intent.putExtra("password", string2);
                    this.startActivity(intent);
                    return;
                }
            }
            catch (JSONException ex) {
                Toast.makeText(this.mCtx, 2131034138, 0).show();
                Log.e("SetServerCredentialsActivity", ex.toString());
                return;
            }
            catch (KeyManagementException ex2) {
                Toast.makeText(this.mCtx, 2131034144, 1).show();
                Log.e("SetServerCredentialsActivity", ex2.toString());
                continue;
            }
            catch (NoSuchAlgorithmException ex3) {
                Toast.makeText(this.mCtx, 2131034143, 1).show();
                Log.e("SetServerCredentialsActivity", ex3.toString());
                continue;
            }
            catch (HttpException ex4) {
                Toast.makeText(this.mCtx, (CharSequence)(this.getString(2131034137) + ex4.getStatusCode()), 0).show();
                Log.e("SetServerCredentialsActivity", ex4.toString());
                continue;
            }
            catch (IOException ex5) {
                Toast.makeText(this.mCtx, 2131034136, 0).show();
                Log.e("SetServerCredentialsActivity", ex5.toString());
                return;
            }
            break;
        }
        Toast.makeText(this.mCtx, 2131034135, 0).show();
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903044);
        this.mCtx = (Context)this;
        this.mThisApplication = (BankingApplication)this.getApplication();
        this.mUserField = (EditText)this.findViewById(2131165193);
        this.mPasswordField = (EditText)this.findViewById(2131165194);
        (this.mDoneButton = (Button)this.findViewById(2131165195)).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                SetServerCredentialsActivity.this.setServerCredentials();
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
