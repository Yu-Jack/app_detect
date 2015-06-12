// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.labs.falsesecuremobile;

import android.view.View;
import android.view.View$OnClickListener;
import android.os.Bundle;
import java.security.GeneralSecurityException;
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
    private String restPass;
    private String restUser;
    
    private void grabAndSetPassword() {
        final String string = this.mPasswordField.getText().toString();
        final String string2 = this.mConfirmPasswordField.getText().toString();
        if (!string.equals(string2)) {
            Toast.makeText(this.mCtx, 2131034141, 0).show();
            return;
        }
        if (!this.isValidPassword(string2)) {
            Toast.makeText(this.mCtx, 2131034142, 1).show();
            return;
        }
        while (true) {
            try {
                this.mThisApplication.setCredentials(string2, this.restUser, this.restPass);
                this.mThisApplication.unlockApplication(string2);
                Toast.makeText(this.mCtx, 2131034148, 0).show();
                final Intent intent = new Intent(this.mCtx, (Class)SummaryActivity.class);
                intent.addFlags(67108864);
                this.startActivity(intent);
            }
            catch (NoSuchAlgorithmException ex) {
                Toast.makeText(this.mCtx, 2131034143, 1).show();
                Log.e("SetLocalPasswordActivity", ex.toString());
                continue;
            }
            catch (UnsupportedEncodingException ex2) {
                Toast.makeText(this.mCtx, 2131034143, 1).show();
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
                Toast.makeText(this.mCtx, 2131034145, 1).show();
                Log.e("SetLocalPasswordActivity", ex5.toString());
                continue;
            }
            catch (IOException ex6) {
                Toast.makeText(this.mCtx, 2131034136, 0).show();
                Log.e("SetLocalPasswordActivity", ex6.toString());
                continue;
            }
            catch (GeneralSecurityException ex7) {
                Toast.makeText(this.mCtx, (CharSequence)"Crypto failure", 0).show();
                Log.e("SetLocalPasswordActivity", ex7.toString());
                continue;
            }
            break;
        }
    }
    
    public boolean isValidPassword(final String s) {
        return s.matches(".*[A-Z].*") && s.matches(".*[a-z].*") && s.matches(".*[0-9].*") && s.matches(".*[@#$%\\^&+=].*") && s.length() >= 6;
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903043);
        this.mCtx = (Context)this;
        this.mThisApplication = (BankingApplication)this.getApplication();
        this.restUser = this.getIntent().getStringExtra("restUser");
        this.restPass = this.getIntent().getStringExtra("restPass");
        this.mPasswordField = (EditText)this.findViewById(2131165190);
        this.mConfirmPasswordField = (EditText)this.findViewById(2131165191);
        (this.mDoneButton = (Button)this.findViewById(2131165192)).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                SetLocalPasswordActivity.this.grabAndSetPassword();
            }
        });
    }
}
