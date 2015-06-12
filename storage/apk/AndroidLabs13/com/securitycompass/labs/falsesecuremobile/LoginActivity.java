// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.labs.falsesecuremobile;

import android.view.View;
import android.view.View$OnClickListener;
import android.os.Bundle;
import java.security.GeneralSecurityException;
import java.io.IOException;
import javax.net.ssl.SSLException;
import java.security.KeyManagementException;
import org.json.JSONException;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import android.util.Log;
import android.widget.Toast;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Button;
import android.content.Context;

public class LoginActivity extends BankingActivity
{
    private static final String TAG = "LoginActivity";
    private Context mCtx;
    private Button mLoginButton;
    private EditText mPasswordField;
    private SharedPreferences mSharedPrefs;
    
    private void checkFirstRun() {
        if (this.mSharedPrefs.getBoolean("firstrun", true)) {
            final Intent intent = new Intent(this.mCtx, (Class)SetServerCredentialsActivity.class);
            intent.addFlags(1073741824);
            this.startActivity(intent);
        }
    }
    
    private void performLogin() {
        final String string = this.mPasswordField.getText().toString();
        int unlockApplication = -2;
        while (true) {
            try {
                unlockApplication = this.mThisApplication.unlockApplication(string);
                if (unlockApplication == -1) {
                    final Intent intent = new Intent(this.mCtx, (Class)SummaryActivity.class);
                    intent.addFlags(67108864);
                    this.startActivity(intent);
                    return;
                }
            }
            catch (UnsupportedEncodingException ex) {
                Toast.makeText(this.mCtx, 2131034143, 1).show();
                Log.e("LoginActivity", ex.toString());
                continue;
            }
            catch (NoSuchAlgorithmException ex2) {
                if (ex2.toString().matches(".*SSL.*")) {
                    Toast.makeText(this.mCtx, 2131034144, 1).show();
                }
                else {
                    Toast.makeText(this.mCtx, 2131034143, 1).show();
                }
                Log.e("LoginActivity", ex2.toString());
                continue;
            }
            catch (JSONException ex3) {
                Toast.makeText(this.mCtx, 2131034138, 0).show();
                Log.e("LoginActivity", ex3.toString());
                continue;
            }
            catch (KeyManagementException ex4) {
                Toast.makeText(this.mCtx, 2131034145, 1).show();
                Log.e("LoginActivity", ex4.toString());
                continue;
            }
            catch (SSLException ex5) {
                Toast.makeText(this.mCtx, 2131034146, 0).show();
                Log.e("LoginActivity", ex5.toString());
                continue;
            }
            catch (HttpException ex6) {
                Toast.makeText(this.mCtx, (CharSequence)(this.getString(2131034137) + ex6.getStatusCode()), 0).show();
                Log.e("LoginActivity", ex6.toString());
                continue;
            }
            catch (IOException ex7) {
                Toast.makeText(this.mCtx, 2131034136, 0).show();
                Log.e("LoginActivity", ex7.toString());
                continue;
            }
            catch (GeneralSecurityException ex8) {
                Toast.makeText(this.mCtx, (CharSequence)"Crypto failure", 0).show();
                Log.e("LoginActivity", ex8.toString());
                continue;
            }
            break;
        }
        Toast.makeText(this.mCtx, 2131034135, 0).show();
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.mCtx = (Context)this;
        this.mSharedPrefs = this.mThisApplication.getSharedPrefs();
        this.checkFirstRun();
        this.setContentView(2130903042);
        this.mLoginButton = (Button)this.findViewById(2131165189);
        this.mPasswordField = (EditText)this.findViewById(2131165188);
        this.mLoginButton.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                LoginActivity.this.performLogin();
            }
        });
    }
}
