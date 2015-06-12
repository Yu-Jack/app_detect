// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.androidlabs.base;

import android.text.format.DateUtils;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import android.view.View;
import android.view.View$OnClickListener;
import android.os.Bundle;
import android.widget.ListAdapter;
import java.util.ArrayList;
import java.io.IOException;
import android.accounts.AuthenticatorException;
import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException;
import android.util.Log;
import android.widget.Toast;
import java.io.File;
import android.content.Context;
import android.widget.Button;

public class StatementActivity extends BankingListActivity
{
    private static final String TAG = "StatementActivity";
    private StatementAdapter mAdapter;
    private Button mClearButton;
    private Context mCtx;
    private File[] mStatements;
    private File mStatementsDir;
    private BankingApplication mThisApplication;
    
    private void downloadStatement() {
        try {
            this.mThisApplication.downloadStatement();
        }
        catch (KeyManagementException ex) {
            Toast.makeText(this.mCtx, 2131034144, 1).show();
            Log.e("StatementActivity", ex.toString());
        }
        catch (NoSuchAlgorithmException ex2) {
            Toast.makeText(this.mCtx, 2131034143, 1).show();
            Log.e("StatementActivity", ex2.toString());
        }
        catch (AuthenticatorException ex3) {
            Log.e("StatementActivity", ex3.toString());
            this.authenticate();
        }
        catch (IOException ex4) {
            Toast.makeText(this.mCtx, 2131034136, 0).show();
            Log.e("StatementActivity", ex4.toString());
        }
    }
    
    private void readStatementFiles() {
        final File[] listFiles = this.mStatementsDir.listFiles();
        final ArrayList<File> list = new ArrayList<File>();
        for (final File file : listFiles) {
            if (file.getName().matches("^[0-9]*\\.html")) {
                list.add(file);
            }
        }
        this.mStatements = list.toArray(new File[0]);
    }
    
    private void refreshView() {
        this.downloadStatement();
        this.readStatementFiles();
        this.setListAdapter((ListAdapter)(this.mAdapter = new StatementAdapter(this.mCtx, 17367043, this.mStatements)));
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903045);
        this.setAppropriateVisibility();
        this.mCtx = (Context)this;
        this.mThisApplication = (BankingApplication)this.getApplication();
        this.mClearButton = (Button)this.findViewById(2131165196);
        this.mStatementsDir = new File(this.mThisApplication.getStatementDir());
        this.downloadStatement();
        this.readStatementFiles();
        this.setListAdapter((ListAdapter)(this.mAdapter = new StatementAdapter(this.mCtx, 17367043, this.mStatements)));
        this.mClearButton.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                StatementActivity.this.mThisApplication.clearStatements();
                StatementActivity.this.refreshView();
            }
        });
        this.getListView().setOnItemClickListener((AdapterView$OnItemClickListener)new AdapterView$OnItemClickListener() {
            public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                final Intent intent = new Intent(StatementActivity.this.mCtx, (Class)ViewStatementActivity.class);
                intent.putExtra("statement_filename", StatementActivity.this.mStatements[n].getAbsolutePath());
                StatementActivity.this.startActivity(intent);
            }
        });
    }
    
    private class StatementAdapter extends ArrayAdapter<File>
    {
        public StatementAdapter(final Context context, final int n, final File[] array) {
            super(context, n, (Object[])array);
        }
        
        public View getView(final int n, final View view, final ViewGroup viewGroup) {
            TextView textView;
            if (view != null) {
                textView = (TextView)view;
            }
            else {
                textView = (TextView)StatementActivity.this.getLayoutInflater().inflate(17367043, (ViewGroup)null);
            }
            textView.setText((CharSequence)DateUtils.formatDateTime(StatementActivity.this.mCtx, Long.parseLong(StatementActivity.this.mStatements[n].getName().replaceAll("\\.html", "")), 65685));
            return (View)textView;
        }
    }
}
