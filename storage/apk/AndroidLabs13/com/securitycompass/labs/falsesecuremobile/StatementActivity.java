// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.labs.falsesecuremobile;

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
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
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
    private File[] mIvFiles;
    private File[] mStatements;
    private File mStatementsDir;
    private BankingApplication mThisApplication;
    
    private String decryptStatement(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Lcom/securitycompass/labs/falsesecuremobile/CryptoTool;
        //     3: dup            
        //     4: invokespecial   com/securitycompass/labs/falsesecuremobile/CryptoTool.<init>:()V
        //     7: astore_2       
        //     8: aload_0        
        //     9: getfield        com/securitycompass/labs/falsesecuremobile/StatementActivity.mThisApplication:Lcom/securitycompass/labs/falsesecuremobile/BankingApplication;
        //    12: invokevirtual   com/securitycompass/labs/falsesecuremobile/BankingApplication.getCryptoKey:()[B
        //    15: astore_3       
        //    16: aconst_null    
        //    17: astore          4
        //    19: aload_0        
        //    20: aload_0        
        //    21: getfield        com/securitycompass/labs/falsesecuremobile/StatementActivity.mStatements:[Ljava/io/File;
        //    24: iload_1        
        //    25: aaload         
        //    26: invokespecial   com/securitycompass/labs/falsesecuremobile/StatementActivity.readFile:(Ljava/io/File;)[B
        //    29: astore          4
        //    31: aload_0        
        //    32: aload_0        
        //    33: getfield        com/securitycompass/labs/falsesecuremobile/StatementActivity.mIvFiles:[Ljava/io/File;
        //    36: iload_1        
        //    37: aaload         
        //    38: invokespecial   com/securitycompass/labs/falsesecuremobile/StatementActivity.readFile:(Ljava/io/File;)[B
        //    41: astore          11
        //    43: aload           11
        //    45: astore          7
        //    47: aload_2        
        //    48: aload           4
        //    50: aload_3        
        //    51: aload           7
        //    53: invokevirtual   com/securitycompass/labs/falsesecuremobile/CryptoTool.decryptBytes:([B[B[B)Ljava/lang/String;
        //    56: astore          10
        //    58: aload           10
        //    60: areturn        
        //    61: astore          5
        //    63: aload_0        
        //    64: getfield        com/securitycompass/labs/falsesecuremobile/StatementActivity.mCtx:Landroid/content/Context;
        //    67: ldc             "Error reading statement file"
        //    69: iconst_0       
        //    70: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
        //    73: invokevirtual   android/widget/Toast.show:()V
        //    76: ldc             "StatementActivity"
        //    78: aload           5
        //    80: invokevirtual   java/lang/Exception.toString:()Ljava/lang/String;
        //    83: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //    86: pop            
        //    87: aconst_null    
        //    88: astore          7
        //    90: goto            47
        //    93: astore          8
        //    95: aload_0        
        //    96: getfield        com/securitycompass/labs/falsesecuremobile/StatementActivity.mCtx:Landroid/content/Context;
        //    99: ldc             "Error decrypting"
        //   101: iconst_0       
        //   102: invokestatic    android/widget/Toast.makeText:(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
        //   105: invokevirtual   android/widget/Toast.show:()V
        //   108: ldc             "StatementActivity"
        //   110: aload           8
        //   112: invokevirtual   java/lang/Exception.toString:()Ljava/lang/String;
        //   115: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   118: pop            
        //   119: ldc             ""
        //   121: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  19     43     61     93     Ljava/lang/Exception;
        //  47     58     93     122    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0047:
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
    
    private void downloadStatement() {
        try {
            this.mThisApplication.downloadStatement();
        }
        catch (KeyManagementException ex) {
            Toast.makeText(this.mCtx, 2131034145, 1).show();
            Log.e("StatementActivity", ex.toString());
        }
        catch (NoSuchAlgorithmException ex2) {
            Toast.makeText(this.mCtx, 2131034144, 1).show();
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
        catch (Exception ex5) {
            Toast.makeText(this.mCtx, (CharSequence)"General Error", 0).show();
            Log.e("StatementActivity", ex5.toString());
        }
    }
    
    private byte[] readFile(final File file) throws FileNotFoundException, IOException {
        final FileInputStream fileInputStream = new FileInputStream(file);
        byte[] b;
        int i;
        int read;
        for (b = new byte[(int)file.length()], i = 0; i < b.length; i += read) {
            read = fileInputStream.read(b, i, b.length - i);
            if (read < 0) {
                break;
            }
        }
        if (i < b.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }
        fileInputStream.close();
        return b;
    }
    
    private void readStatementFiles() {
        final File[] listFiles = this.mStatementsDir.listFiles();
        final ArrayList<File> list = new ArrayList<File>();
        final ArrayList<File> list2 = new ArrayList<File>();
        for (final File file : listFiles) {
            if (file.getName().matches("^[0-9]*\\.statement")) {
                final File file2 = new File(file.getPath().replaceAll("\\.statement", "\\.iv"));
                if (file2.exists()) {
                    list.add(file);
                    list2.add(file2);
                }
            }
        }
        Collections.reverse(list);
        Collections.reverse(list2);
        this.mStatements = list.toArray(new File[0]);
        this.mIvFiles = list2.toArray(new File[0]);
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
        this.mStatementsDir = this.getFilesDir();
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
                intent.putExtra("statement_html", StatementActivity.this.decryptStatement(n));
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
            textView.setText((CharSequence)DateUtils.formatDateTime(StatementActivity.this.mCtx, Long.parseLong(StatementActivity.this.mStatements[n].getName().replaceAll("\\.statement", "")), 65685));
            return (View)textView;
        }
    }
}
