// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.androidlabs.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;

public class SummaryActivity extends BankingListActivity
{
    private static final int LAUNCH_ACCOUNTS = 0;
    private static final int LAUNCH_STATEMENT = 1;
    private static final int LAUNCH_TRANSFER = 2;
    private Context mCtx;
    private final String[] optionNames;
    
    public SummaryActivity() {
        this.optionNames = new String[] { "Accounts", "Statement", "Transfer" };
    }
    
    private void launchAccountsScreen() {
        this.startActivity(new Intent(this.mCtx, (Class)AccountsActivity.class));
    }
    
    private void launchSelectedScreen(final int n) {
        if (n == 0) {
            this.launchAccountsScreen();
        }
        else {
            if (n == 1) {
                this.launchStatementScreen();
                return;
            }
            if (n == 2) {
                this.launchTransferScreen();
            }
        }
    }
    
    private void launchStatementScreen() {
        this.startActivity(new Intent(this.mCtx, (Class)StatementActivity.class));
    }
    
    private void launchTransferScreen() {
        this.startActivity(new Intent(this.mCtx, (Class)TransferActivity.class));
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903046);
        this.setAppropriateVisibility();
        ((SummaryActivity)(this.mCtx = (Context)this)).setListAdapter((ListAdapter)new ArrayAdapter(this.mCtx, 17367043, (Object[])this.optionNames));
        this.getListView().setOnItemClickListener((AdapterView$OnItemClickListener)new AdapterView$OnItemClickListener() {
            public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                SummaryActivity.this.launchSelectedScreen(n);
            }
        });
    }
}
