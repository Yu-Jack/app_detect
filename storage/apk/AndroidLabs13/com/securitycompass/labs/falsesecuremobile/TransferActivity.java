// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.labs.falsesecuremobile;

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
        //     0: aload_0        
        //     1: getfield        com/securitycompass/labs/falsesecuremobile/TransferActivity.mFromAccount:Lcom/securitycompass/labs/falsesecuremobile/Account;
        //     4: aload_0        
        //     5: getfield        com/securitycompass/labs/falsesecuremobile/TransferActivity.mToAccount:Lcom/securitycompass/labs/falsesecuremobile/Account;
        //     8: if_acmpne       25
        //    11: aload_0        
        //    12: getfield        com/securitycompass/labs/falsesecuremobile/TransferActivity.mCtx:Landroid/content/Context;
        //    15: ldc             2131034139
        //    17: iconst_0       
        //    18: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;II)Landroid/widget/Toast;
        //    21: invokevirtual   android/widget/Toast.show:()V
        //    24: return         
        //    25: aload_0        
        //    26: getfield        com/securitycompass/labs/falsesecuremobile/TransferActivity.mAmountField:Landroid/widget/EditText;
        //    29: invokevirtual   android/widget/EditText.getText:()Landroid/text/Editable;
        //    32: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    35: astore_1       
        //    36: aload_1        
        //    37: invokestatic    java/lang/Double.parseDouble:(Ljava/lang/String;)D
        //    40: dstore_3       
        //    41: dload_3        
        //    42: dconst_0       
        //    43: dcmpl          
        //    44: ifle            275
        //    47: aload_0        
        //    48: getfield        com/securitycompass/labs/falsesecuremobile/TransferActivity.mThisApplication:Lcom/securitycompass/labs/falsesecuremobile/BankingApplication;
        //    51: aload_0        
        //    52: getfield        com/securitycompass/labs/falsesecuremobile/TransferActivity.mFromAccount:Lcom/securitycompass/labs/falsesecuremobile/Account;
        //    55: invokevirtual   com/securitycompass/labs/falsesecuremobile/Account.getAccountNumber:()I
        //    58: aload_0        
        //    59: getfield        com/securitycompass/labs/falsesecuremobile/TransferActivity.mToAccount:Lcom/securitycompass/labs/falsesecuremobile/Account;
        //    62: invokevirtual   com/securitycompass/labs/falsesecuremobile/Account.getAccountNumber:()I
        //    65: dload_3        
        //    66: invokevirtual   com/securitycompass/labs/falsesecuremobile/BankingApplication.transferFunds:(IID)I
        //    69: istore          13
        //    71: ldc             "TransferActivity"
        //    73: new             Ljava/lang/StringBuilder;
        //    76: dup            
        //    77: invokespecial   java/lang/StringBuilder.<init>:()V
        //    80: ldc             "Response code for transfer: "
        //    82: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    85: iload           13
        //    87: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    90: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    93: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //    96: pop            
        //    97: aload_0        
        //    98: invokespecial   com/securitycompass/labs/falsesecuremobile/TransferActivity.updateAccounts:()V
        //   101: aload_0        
        //   102: getfield        com/securitycompass/labs/falsesecuremobile/TransferActivity.mCtx:Landroid/content/Context;
        //   105: ldc             2131034125
        //   107: iconst_0       
        //   108: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;II)Landroid/widget/Toast;
        //   111: invokevirtual   android/widget/Toast.show:()V
        //   114: aload_0        
        //   115: invokespecial   com/securitycompass/labs/falsesecuremobile/TransferActivity.launchSummaryScreen:()V
        //   118: return         
        //   119: astore_2       
        //   120: aload_0        
        //   121: getfield        com/securitycompass/labs/falsesecuremobile/TransferActivity.mCtx:Landroid/content/Context;
        //   124: ldc             2131034140
        //   126: iconst_0       
        //   127: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;II)Landroid/widget/Toast;
        //   130: invokevirtual   android/widget/Toast.show:()V
        //   133: return         
        //   134: astore          11
        //   136: aload_0        
        //   137: getfield        com/securitycompass/labs/falsesecuremobile/TransferActivity.mCtx:Landroid/content/Context;
        //   140: ldc             2131034145
        //   142: iconst_1       
        //   143: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;II)Landroid/widget/Toast;
        //   146: invokevirtual   android/widget/Toast.show:()V
        //   149: ldc             "TransferActivity"
        //   151: aload           11
        //   153: invokevirtual   java/security/KeyManagementException.toString:()Ljava/lang/String;
        //   156: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   159: pop            
        //   160: goto            97
        //   163: astore          9
        //   165: aload_0        
        //   166: getfield        com/securitycompass/labs/falsesecuremobile/TransferActivity.mCtx:Landroid/content/Context;
        //   169: ldc             2131034144
        //   171: iconst_1       
        //   172: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;II)Landroid/widget/Toast;
        //   175: invokevirtual   android/widget/Toast.show:()V
        //   178: ldc             "TransferActivity"
        //   180: aload           9
        //   182: invokevirtual   java/security/NoSuchAlgorithmException.toString:()Ljava/lang/String;
        //   185: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   188: pop            
        //   189: goto            97
        //   192: astore          7
        //   194: aload_0        
        //   195: getfield        com/securitycompass/labs/falsesecuremobile/TransferActivity.mCtx:Landroid/content/Context;
        //   198: new             Ljava/lang/StringBuilder;
        //   201: dup            
        //   202: invokespecial   java/lang/StringBuilder.<init>:()V
        //   205: aload_0        
        //   206: ldc             2131034137
        //   208: invokevirtual   com/securitycompass/labs/falsesecuremobile/TransferActivity.getString:(I)Ljava/lang/String;
        //   211: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   214: aload           7
        //   216: invokevirtual   com/securitycompass/labs/falsesecuremobile/HttpException.getStatusCode:()I
        //   219: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   222: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   225: iconst_0       
        //   226: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
        //   229: invokevirtual   android/widget/Toast.show:()V
        //   232: ldc             "TransferActivity"
        //   234: aload           7
        //   236: invokevirtual   com/securitycompass/labs/falsesecuremobile/HttpException.toString:()Ljava/lang/String;
        //   239: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   242: pop            
        //   243: goto            97
        //   246: astore          5
        //   248: aload_0        
        //   249: getfield        com/securitycompass/labs/falsesecuremobile/TransferActivity.mCtx:Landroid/content/Context;
        //   252: ldc             2131034136
        //   254: iconst_0       
        //   255: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;II)Landroid/widget/Toast;
        //   258: invokevirtual   android/widget/Toast.show:()V
        //   261: ldc             "TransferActivity"
        //   263: aload           5
        //   265: invokevirtual   java/io/IOException.toString:()Ljava/lang/String;
        //   268: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   271: pop            
        //   272: goto            97
        //   275: aload_0        
        //   276: getfield        com/securitycompass/labs/falsesecuremobile/TransferActivity.mCtx:Landroid/content/Context;
        //   279: ldc             2131034140
        //   281: iconst_0       
        //   282: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;II)Landroid/widget/Toast;
        //   285: invokevirtual   android/widget/Toast.show:()V
        //   288: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                      
        //  -----  -----  -----  -----  ----------------------------------------------------------
        //  36     41     119    134    Ljava/lang/NumberFormatException;
        //  47     97     134    163    Ljava/security/KeyManagementException;
        //  47     97     163    192    Ljava/security/NoSuchAlgorithmException;
        //  47     97     192    246    Lcom/securitycompass/labs/falsesecuremobile/HttpException;
        //  47     97     246    275    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0097:
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
            goto Label_0090;
        }
        catch (JSONException ex) {
            Toast.makeText(this.mCtx, 2131034138, 0).show();
            Log.e("TransferActivity", ex.toString());
        }
        catch (IOException ex2) {
            Toast.makeText(this.mCtx, 2131034136, 0).show();
            Log.e("TransferActivity", ex2.toString());
            goto Label_0090;
        }
        catch (AuthenticatorException ex3) {
            Log.e("TransferActivity", ex3.toString());
            this.authenticate();
            goto Label_0090;
        }
        catch (KeyManagementException ex4) {
            Toast.makeText(this.mCtx, 2131034145, 1).show();
            Log.e("TransferActivity", ex4.toString());
            goto Label_0090;
        }
        catch (NoSuchAlgorithmException ex5) {
            Toast.makeText(this.mCtx, 2131034144, 1).show();
            Log.e("TransferActivity", ex5.toString());
            goto Label_0090;
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
            textView.setText((CharSequence)(TransferActivity.this.capitalise(TransferActivity.this.mAccounts.get(n).getAccountType()) + " (" + string.substring(-4 + string.length()) + "): $" + TransferActivity.this.mAccounts.get(n).getBalance()));
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
            textView.setText((CharSequence)(TransferActivity.this.capitalise(TransferActivity.this.mAccounts.get(n).getAccountType()) + " (" + string.substring(-4 + string.length()) + "): $" + TransferActivity.this.mAccounts.get(n).getBalance()));
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
