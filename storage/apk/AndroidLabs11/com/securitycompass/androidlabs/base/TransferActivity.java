// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.androidlabs.base;

import android.widget.AdapterView;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.AdapterView$OnItemSelectedListener;
import java.util.ArrayList;
import android.os.Bundle;
import java.util.Iterator;
import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException;
import android.accounts.AuthenticatorException;
import java.io.IOException;
import org.json.JSONException;
import android.util.Log;
import android.widget.Toast;
import android.widget.SpinnerAdapter;
import android.content.Intent;
import android.widget.Button;
import android.widget.Spinner;
import android.content.Context;
import android.widget.EditText;
import java.util.List;

public class TransferActivity extends BankingActivity
{
    private static final String TAG = "TransferActivity";
    private static final int TRANSFER_FROM = 1;
    private static final int TRANSFER_TO = 2;
    private List<Account> mAccounts;
    private EditText mAmountField;
    private Context mCtx;
    private Account mFromAccount;
    private AccountListAdapter mFromAccountListAdapter;
    private Spinner mFromAccountSpinner;
    private BankingApplication mThisApplication;
    private Account mToAccount;
    private AccountListAdapter mToAccountListAdapter;
    private Spinner mToAccountSpinner;
    private Button mTransferButton;
    
    private String capitalise(final String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    
    private void launchSummaryScreen() {
        final Intent intent = new Intent((Context)this, (Class)SummaryActivity.class);
        intent.addFlags(67108864);
        this.startActivity(intent);
    }
    
    private void performTransfer() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: ldc             "TransferActivity"
        //     2: new             Ljava/lang/StringBuilder;
        //     5: dup            
        //     6: invokespecial   java/lang/StringBuilder.<init>:()V
        //     9: ldc             "Member Accounts ["
        //    11: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    14: aload_0        
        //    15: getfield        com/securitycompass/androidlabs/base/TransferActivity.mFromAccount:Lcom/securitycompass/androidlabs/base/Account;
        //    18: invokevirtual   com/securitycompass/androidlabs/base/Account.toString:()Ljava/lang/String;
        //    21: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    24: ldc             "] ["
        //    26: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    29: aload_0        
        //    30: getfield        com/securitycompass/androidlabs/base/TransferActivity.mToAccount:Lcom/securitycompass/androidlabs/base/Account;
        //    33: invokevirtual   com/securitycompass/androidlabs/base/Account.toString:()Ljava/lang/String;
        //    36: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    39: ldc             "]"
        //    41: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    44: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    47: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //    50: pop            
        //    51: aload_0        
        //    52: getfield        com/securitycompass/androidlabs/base/TransferActivity.mFromAccount:Lcom/securitycompass/androidlabs/base/Account;
        //    55: aload_0        
        //    56: getfield        com/securitycompass/androidlabs/base/TransferActivity.mToAccount:Lcom/securitycompass/androidlabs/base/Account;
        //    59: if_acmpne       76
        //    62: aload_0        
        //    63: getfield        com/securitycompass/androidlabs/base/TransferActivity.mCtx:Landroid/content/Context;
        //    66: ldc             2131034139
        //    68: iconst_0       
        //    69: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;II)Landroid/widget/Toast;
        //    72: invokevirtual   android/widget/Toast.show:()V
        //    75: return         
        //    76: aload_0        
        //    77: getfield        com/securitycompass/androidlabs/base/TransferActivity.mAmountField:Landroid/widget/EditText;
        //    80: invokevirtual   android/widget/EditText.getText:()Landroid/text/Editable;
        //    83: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    86: astore_2       
        //    87: aload_2        
        //    88: invokestatic    java/lang/Double.parseDouble:(Ljava/lang/String;)D
        //    91: dstore          4
        //    93: dload           4
        //    95: dconst_0       
        //    96: dcmpl          
        //    97: ifle            385
        //   100: aload_0        
        //   101: getfield        com/securitycompass/androidlabs/base/TransferActivity.mThisApplication:Lcom/securitycompass/androidlabs/base/BankingApplication;
        //   104: aload_0        
        //   105: getfield        com/securitycompass/androidlabs/base/TransferActivity.mFromAccount:Lcom/securitycompass/androidlabs/base/Account;
        //   108: invokevirtual   com/securitycompass/androidlabs/base/Account.getAccountNumber:()I
        //   111: aload_0        
        //   112: getfield        com/securitycompass/androidlabs/base/TransferActivity.mToAccount:Lcom/securitycompass/androidlabs/base/Account;
        //   115: invokevirtual   com/securitycompass/androidlabs/base/Account.getAccountNumber:()I
        //   118: dload           4
        //   120: invokevirtual   com/securitycompass/androidlabs/base/BankingApplication.transferFunds:(IID)I
        //   123: istore          15
        //   125: ldc             "TransferActivity"
        //   127: new             Ljava/lang/StringBuilder;
        //   130: dup            
        //   131: invokespecial   java/lang/StringBuilder.<init>:()V
        //   134: ldc             "Response code for transfer: "
        //   136: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   139: iload           15
        //   141: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   144: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   147: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //   150: pop            
        //   151: ldc             "TransferActivity"
        //   153: new             Ljava/lang/StringBuilder;
        //   156: dup            
        //   157: invokespecial   java/lang/StringBuilder.<init>:()V
        //   160: ldc             "Transferred $"
        //   162: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   165: dload           4
        //   167: invokevirtual   java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
        //   170: ldc             " from account "
        //   172: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   175: aload_0        
        //   176: getfield        com/securitycompass/androidlabs/base/TransferActivity.mFromAccount:Lcom/securitycompass/androidlabs/base/Account;
        //   179: invokevirtual   com/securitycompass/androidlabs/base/Account.getAccountNumber:()I
        //   182: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   185: ldc             " to account "
        //   187: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   190: aload_0        
        //   191: getfield        com/securitycompass/androidlabs/base/TransferActivity.mToAccount:Lcom/securitycompass/androidlabs/base/Account;
        //   194: invokevirtual   com/securitycompass/androidlabs/base/Account.getAccountNumber:()I
        //   197: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   200: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   203: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //   206: pop            
        //   207: aload_0        
        //   208: invokespecial   com/securitycompass/androidlabs/base/TransferActivity.updateAccounts:()V
        //   211: aload_0        
        //   212: getfield        com/securitycompass/androidlabs/base/TransferActivity.mCtx:Landroid/content/Context;
        //   215: ldc             2131034125
        //   217: iconst_0       
        //   218: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;II)Landroid/widget/Toast;
        //   221: invokevirtual   android/widget/Toast.show:()V
        //   224: aload_0        
        //   225: invokespecial   com/securitycompass/androidlabs/base/TransferActivity.launchSummaryScreen:()V
        //   228: return         
        //   229: astore_3       
        //   230: aload_0        
        //   231: getfield        com/securitycompass/androidlabs/base/TransferActivity.mCtx:Landroid/content/Context;
        //   234: ldc             2131034140
        //   236: iconst_0       
        //   237: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;II)Landroid/widget/Toast;
        //   240: invokevirtual   android/widget/Toast.show:()V
        //   243: return         
        //   244: astore          13
        //   246: aload_0        
        //   247: getfield        com/securitycompass/androidlabs/base/TransferActivity.mCtx:Landroid/content/Context;
        //   250: ldc             2131034144
        //   252: iconst_1       
        //   253: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;II)Landroid/widget/Toast;
        //   256: invokevirtual   android/widget/Toast.show:()V
        //   259: ldc             "TransferActivity"
        //   261: aload           13
        //   263: invokevirtual   java/security/KeyManagementException.toString:()Ljava/lang/String;
        //   266: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   269: pop            
        //   270: goto            151
        //   273: astore          11
        //   275: aload_0        
        //   276: getfield        com/securitycompass/androidlabs/base/TransferActivity.mCtx:Landroid/content/Context;
        //   279: ldc             2131034143
        //   281: iconst_1       
        //   282: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;II)Landroid/widget/Toast;
        //   285: invokevirtual   android/widget/Toast.show:()V
        //   288: ldc             "TransferActivity"
        //   290: aload           11
        //   292: invokevirtual   java/security/NoSuchAlgorithmException.toString:()Ljava/lang/String;
        //   295: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   298: pop            
        //   299: goto            151
        //   302: astore          9
        //   304: aload_0        
        //   305: getfield        com/securitycompass/androidlabs/base/TransferActivity.mCtx:Landroid/content/Context;
        //   308: new             Ljava/lang/StringBuilder;
        //   311: dup            
        //   312: invokespecial   java/lang/StringBuilder.<init>:()V
        //   315: aload_0        
        //   316: ldc             2131034137
        //   318: invokevirtual   com/securitycompass/androidlabs/base/TransferActivity.getString:(I)Ljava/lang/String;
        //   321: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   324: aload           9
        //   326: invokevirtual   com/securitycompass/androidlabs/base/HttpException.getStatusCode:()I
        //   329: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   332: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   335: iconst_0       
        //   336: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
        //   339: invokevirtual   android/widget/Toast.show:()V
        //   342: ldc             "TransferActivity"
        //   344: aload           9
        //   346: invokevirtual   com/securitycompass/androidlabs/base/HttpException.toString:()Ljava/lang/String;
        //   349: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   352: pop            
        //   353: goto            151
        //   356: astore          6
        //   358: aload_0        
        //   359: getfield        com/securitycompass/androidlabs/base/TransferActivity.mCtx:Landroid/content/Context;
        //   362: ldc             2131034136
        //   364: iconst_0       
        //   365: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;II)Landroid/widget/Toast;
        //   368: invokevirtual   android/widget/Toast.show:()V
        //   371: ldc             "TransferActivity"
        //   373: aload           6
        //   375: invokevirtual   java/io/IOException.toString:()Ljava/lang/String;
        //   378: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   381: pop            
        //   382: goto            151
        //   385: aload_0        
        //   386: getfield        com/securitycompass/androidlabs/base/TransferActivity.mCtx:Landroid/content/Context;
        //   389: ldc             2131034140
        //   391: iconst_0       
        //   392: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;II)Landroid/widget/Toast;
        //   395: invokevirtual   android/widget/Toast.show:()V
        //   398: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                
        //  -----  -----  -----  -----  ----------------------------------------------------
        //  87     93     229    244    Ljava/lang/NumberFormatException;
        //  100    151    244    273    Ljava/security/KeyManagementException;
        //  100    151    273    302    Ljava/security/NoSuchAlgorithmException;
        //  100    151    302    356    Lcom/securitycompass/androidlabs/base/HttpException;
        //  100    151    356    385    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0151:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void refreshDisplayInformation() {
        final int selectedItemPosition = this.mFromAccountSpinner.getSelectedItemPosition();
        final int selectedItemPosition2 = this.mToAccountSpinner.getSelectedItemPosition();
        this.mFromAccountListAdapter = new AccountListAdapter();
        this.mToAccountListAdapter = new AccountListAdapter();
        this.mFromAccountSpinner.setAdapter((SpinnerAdapter)this.mFromAccountListAdapter);
        this.mToAccountSpinner.setAdapter((SpinnerAdapter)this.mToAccountListAdapter);
        this.mFromAccountSpinner.setSelection(selectedItemPosition);
        this.mToAccountSpinner.setSelection(selectedItemPosition2);
    }
    
    private void updateAccounts() {
        try {
            final List<Account> accounts = this.mThisApplication.getAccounts();
            this.mAccounts.clear();
            final Iterator<Account> iterator = accounts.iterator();
            while (iterator.hasNext()) {
                this.mAccounts.add(iterator.next());
            }
            goto Label_0091;
        }
        catch (JSONException ex) {
            Toast.makeText(this.mCtx, 2131034138, 0).show();
            Log.e("TransferActivity", ex.toString());
        }
        catch (IOException ex2) {
            Toast.makeText(this.mCtx, 2131034136, 0).show();
            Log.e("TransferActivity", ex2.toString());
            goto Label_0091;
        }
        catch (AuthenticatorException ex3) {
            Log.e("TransferActivity", ex3.toString());
            this.authenticate();
            goto Label_0091;
        }
        catch (KeyManagementException ex4) {
            Toast.makeText(this.mCtx, 2131034144, 1).show();
            Log.e("TransferActivity", ex4.toString());
            goto Label_0091;
        }
        catch (NoSuchAlgorithmException ex5) {
            Toast.makeText(this.mCtx, 2131034143, 1).show();
            Log.e("TransferActivity", ex5.toString());
            goto Label_0091;
        }
        this.mAccounts.clear();
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903047);
        this.setAppropriateVisibility();
        this.mCtx = (Context)this;
        this.mThisApplication = (BankingApplication)this.getApplication();
        this.mAccounts = new ArrayList<Account>();
        this.mFromAccountSpinner = (Spinner)this.findViewById(2131165197);
        this.mToAccountSpinner = (Spinner)this.findViewById(2131165198);
        this.mFromAccountListAdapter = new AccountListAdapter();
        this.mToAccountListAdapter = new AccountListAdapter();
        this.updateAccounts();
        this.mFromAccountSpinner.setAdapter((SpinnerAdapter)this.mFromAccountListAdapter);
        this.mToAccountSpinner.setAdapter((SpinnerAdapter)this.mToAccountListAdapter);
        this.mFromAccountSpinner.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)new AccountSelectionListener(1));
        this.mToAccountSpinner.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)new AccountSelectionListener(2));
        (this.mTransferButton = (Button)this.findViewById(2131165200)).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                TransferActivity.this.performTransfer();
            }
        });
        this.mAmountField = (EditText)this.findViewById(2131165199);
        if (this.mAccounts.size() >= 2) {
            this.mToAccountSpinner.setSelection(1);
        }
        this.refreshDisplayInformation();
    }
    
    private class AccountListAdapter extends BaseAdapter implements SpinnerAdapter
    {
        public int getCount() {
            return TransferActivity.this.mAccounts.size();
        }
        
        public View getDropDownView(final int n, final View view, final ViewGroup viewGroup) {
            TextView textView;
            if (view == null) {
                textView = (TextView)TransferActivity.this.getLayoutInflater().inflate(17367049, (ViewGroup)null);
            }
            else {
                textView = (TextView)view;
            }
            final String string = Integer.toString(TransferActivity.this.mAccounts.get(n).getAccountNumber());
            textView.setText((CharSequence)(TransferActivity.this.capitalise(TransferActivity.this.mAccounts.get(n).getAccountType()) + " (" + string.substring(string.length() - 4) + "): $" + TransferActivity.this.mAccounts.get(n).getBalance()));
            return (View)textView;
        }
        
        public Object getItem(final int n) {
            return TransferActivity.this.mAccounts.get(n);
        }
        
        public long getItemId(final int n) {
            return n;
        }
        
        public View getView(final int n, final View view, final ViewGroup viewGroup) {
            TextView textView;
            if (view == null) {
                textView = (TextView)TransferActivity.this.getLayoutInflater().inflate(17367048, (ViewGroup)null);
            }
            else {
                textView = (TextView)view;
            }
            final String string = Integer.toString(TransferActivity.this.mAccounts.get(n).getAccountNumber());
            textView.setText((CharSequence)(TransferActivity.this.capitalise(TransferActivity.this.mAccounts.get(n).getAccountType()) + " (" + string.substring(string.length() - 4) + "): $" + TransferActivity.this.mAccounts.get(n).getBalance()));
            return (View)textView;
        }
    }
    
    private class AccountSelectionListener implements AdapterView$OnItemSelectedListener
    {
        private int transferDirection;
        
        public AccountSelectionListener(final int transferDirection) {
            this.transferDirection = transferDirection;
        }
        
        public void onItemSelected(final AdapterView<?> adapterView, final View view, final int n, final long n2) throws IndexOutOfBoundsException {
            if (this.transferDirection == 1) {
                TransferActivity.this.mFromAccount = TransferActivity.this.mAccounts.get(n);
                return;
            }
            if (this.transferDirection == 2) {
                TransferActivity.this.mToAccount = TransferActivity.this.mAccounts.get(n);
                return;
            }
            throw new IndexOutOfBoundsException("From/To indicator int out of bounds in AccountSelectionListener");
        }
        
        public void onNothingSelected(final AdapterView<?> adapterView) {
        }
    }
}
