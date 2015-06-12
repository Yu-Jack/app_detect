// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import com.ogqcorp.bgh.system.l;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.ogqcorp.bgh.item.Background;
import android.app.Activity;
import com.ogqcorp.bgh.a.a;
import android.content.Intent;
import android.net.Uri;
import java.io.File;
import com.ogqcorp.bgh.activity.a.b;

public final class AttachActivity extends b
{
    private File a() {
        final Uri data = this.getIntent().getData();
        if (data.getScheme().equalsIgnoreCase("content")) {
            return new File(this.a(data));
        }
        return new File(data.getPath());
    }
    
    private String a(final Uri p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: invokevirtual   com/ogqcorp/bgh/activity/AttachActivity.getContentResolver:()Landroid/content/ContentResolver;
        //     4: aload_1        
        //     5: aconst_null    
        //     6: aconst_null    
        //     7: aconst_null    
        //     8: aconst_null    
        //     9: invokevirtual   android/content/ContentResolver.query:(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    12: astore          8
        //    14: aload           8
        //    16: astore_3       
        //    17: aload_3        
        //    18: invokeinterface android/database/Cursor.moveToNext:()Z
        //    23: pop            
        //    24: aload_3        
        //    25: aload_3        
        //    26: ldc             "_data"
        //    28: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    33: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    38: astore          11
        //    40: aload_3        
        //    41: ifnull          50
        //    44: aload_3        
        //    45: invokeinterface android/database/Cursor.close:()V
        //    50: aload           11
        //    52: areturn        
        //    53: astore          5
        //    55: aconst_null    
        //    56: astore          6
        //    58: aload           6
        //    60: ifnull          70
        //    63: aload           6
        //    65: invokeinterface android/database/Cursor.close:()V
        //    70: aconst_null    
        //    71: areturn        
        //    72: astore_2       
        //    73: aconst_null    
        //    74: astore_3       
        //    75: aload_3        
        //    76: ifnull          85
        //    79: aload_3        
        //    80: invokeinterface android/database/Cursor.close:()V
        //    85: aload_2        
        //    86: athrow         
        //    87: astore          12
        //    89: aload           11
        //    91: areturn        
        //    92: astore          7
        //    94: goto            70
        //    97: astore          4
        //    99: goto            85
        //   102: astore_2       
        //   103: goto            75
        //   106: astore          9
        //   108: aload_3        
        //   109: astore          6
        //   111: goto            58
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      14     53     58     Ljava/lang/Exception;
        //  0      14     72     75     Any
        //  17     40     106    114    Ljava/lang/Exception;
        //  17     40     102    106    Any
        //  44     50     87     92     Ljava/lang/Exception;
        //  63     70     92     97     Ljava/lang/Exception;
        //  79     85     97     102    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 57, Size: 57
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3419)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:114)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
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
    
    @Override
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n2 == 0) {
            this.setResult(0);
        }
        else {
            a.a(this, n, n2, intent, null);
        }
        this.finish();
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        try {
            a.a(this, this.a());
        }
        catch (Exception ex) {
            l.b(ex);
            this.finish();
        }
    }
}
