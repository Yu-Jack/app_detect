// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.labs.falsesecuremobile;

import android.widget.TextView;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.os.Bundle;
import java.util.ArrayList;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException;
import android.accounts.AuthenticatorException;
import org.json.JSONException;
import android.util.Log;
import android.widget.Toast;
import android.content.Context;
import java.util.List;

public class AccountsActivity extends BankingListActivity
{
    private static final String TAG = "AccountsActivity";
    private List<Account> mAccounts;
    private Context mCtx;
    private BankingApplication mThisApplication;
    
    private String capitalise(final String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    
    private void updateAccounts() {
        while (true) {
            try {
                this.mAccounts = this.mThisApplication.getAccounts();
                if (!this.mThisApplication.isLocked()) {
                    return;
                }
            }
            catch (JSONException ex) {
                Toast.makeText(this.mCtx, 2131034138, 0).show();
                Log.e("AccountsActivity", ex.toString());
                continue;
            }
            catch (AuthenticatorException ex2) {
                Log.e("AccountsActivity", ex2.toString());
                this.authenticate();
                continue;
            }
            catch (KeyManagementException ex3) {
                Toast.makeText(this.mCtx, 2131034145, 1).show();
                Log.e("AccountsActivity", ex3.toString());
                continue;
            }
            catch (NoSuchAlgorithmException ex4) {
                Toast.makeText(this.mCtx, 2131034144, 1).show();
                Log.e("AccountsActivity", ex4.toString());
                continue;
            }
            catch (IOException ex5) {
                Toast.makeText(this.mCtx, 2131034136, 0).show();
                Log.e("AccountsActivity", ex5.toString());
                continue;
            }
            break;
        }
        this.mAccounts = new ArrayList<Account>();
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903041);
        this.setAppropriateVisibility();
        this.mCtx = (Context)this;
        this.mAccounts = new ArrayList<Account>();
        this.mThisApplication = (BankingApplication)this.getApplication();
        this.updateAccounts();
        this.setListAdapter((ListAdapter)new AccountDetailAdapter(this.mCtx, 2130903040, this.mAccounts));
    }
    
    private class AccountDetailAdapter extends ArrayAdapter<Account>
    {
        public AccountDetailAdapter(final Context context, final int n, final List<Account> list) {
            super(context, n, (List)list);
        }
        
        public View getView(final int n, final View view, final ViewGroup viewGroup) {
            View inflate = view;
            if (inflate == null) {
                inflate = AccountsActivity.this.getLayoutInflater().inflate(2130903040, (ViewGroup)null);
            }
            final TextView textView = (TextView)inflate.findViewById(2131165184);
            final TextView textView2 = (TextView)inflate.findViewById(2131165185);
            final TextView textView3 = (TextView)inflate.findViewById(2131165186);
            final Account account = AccountsActivity.this.mAccounts.get(n);
            textView.setText((CharSequence)("Account " + account.getAccountNumber()));
            textView2.setText((CharSequence)(AccountsActivity.this.capitalise(account.getAccountType()) + " Account"));
            textView3.setText((CharSequence)("Balance: $" + account.getBalance()));
            return inflate;
        }
    }
}
