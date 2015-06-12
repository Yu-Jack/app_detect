// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import java.io.File;
import com.ogqcorp.bgh.system.i;
import com.ogqcorp.bgh.system.s;
import com.ogqcorp.bgh.system.v;
import android.widget.Toast;
import android.content.Context;
import android.app.WallpaperManager;
import com.ogqcorp.commons.o;
import com.ogqcorp.bgh.item.Background;
import android.content.Intent;
import android.app.Activity;

final class p extends d<Activity>
{
    p(final Activity activity) {
        super(activity);
    }
    
    private void a(final Activity activity, final int n, final int n2, final Intent intent, final Background background) {
        if (n2 != 0) {
            if (n == 88) {
                this.a(activity, intent);
                return;
            }
            if (n == 620) {
                this.a(activity, background);
            }
        }
    }
    
    private void a(final Activity activity, final Intent intent) {
        new o().a(intent, "data");
        final WallpaperManager instance = WallpaperManager.getInstance((Context)activity);
        if (!this.a(instance, com.ogqcorp.bgh.system.o.b().f())) {
            Toast.makeText((Context)activity, 2131427485, 0).show();
        }
        else {
            final int intExtra = intent.getIntExtra("KEY_CX", 0);
            final int intExtra2 = intent.getIntExtra("KEY_CY", 0);
            v.a().d((Context)activity, intExtra);
            v.a().e((Context)activity, intExtra2);
            instance.suggestDesiredDimensions(intExtra, intExtra2);
            Toast.makeText((Context)activity, 2131427486, 0).show();
            final Background background = (Background)intent.getParcelableExtra("KEY_BACKGROUND");
            if (background != null) {
                this.a((Context)activity, background);
                s.a(activity);
            }
        }
    }
    
    private void a(final Activity activity, final Background background) {
        v.a().d((Context)activity, -1);
        v.a().e((Context)activity, -1);
        Toast.makeText((Context)activity, 2131427486, 0).show();
        if (background != null) {
            this.a((Context)activity, background);
            s.a(activity);
        }
    }
    
    private void a(final Context context, final Background background) {
        if (!i.a().a(background)) {
            k.a(context, background);
        }
        i.a().b(background);
    }
    
    private boolean a(final WallpaperManager p0, final File p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/io/FileInputStream;
        //     3: dup            
        //     4: aload_2        
        //     5: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //     8: astore_3       
        //     9: aload_1        
        //    10: aload_3        
        //    11: invokevirtual   android/app/WallpaperManager.setStream:(Ljava/io/InputStream;)V
        //    14: aload_3        
        //    15: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;)V
        //    18: iconst_1       
        //    19: ireturn        
        //    20: astore          4
        //    22: aconst_null    
        //    23: astore_3       
        //    24: aload           4
        //    26: invokestatic    com/ogqcorp/bgh/system/l.b:(Ljava/lang/Throwable;)I
        //    29: pop            
        //    30: aload_3        
        //    31: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;)V
        //    34: iconst_0       
        //    35: ireturn        
        //    36: astore          5
        //    38: aconst_null    
        //    39: astore_3       
        //    40: aload_3        
        //    41: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;)V
        //    44: aload           5
        //    46: athrow         
        //    47: astore          5
        //    49: goto            40
        //    52: astore          4
        //    54: goto            24
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      9      20     24     Ljava/lang/Exception;
        //  0      9      36     40     Any
        //  9      14     52     57     Ljava/lang/Exception;
        //  9      14     47     52     Any
        //  24     30     47     52     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0024:
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
    
    void a(final int n, final int n2, final Intent intent, final Background background) {
        final Activity a = this.a();
        if (a != null) {
            this.a(a, n, n2, intent, background);
        }
    }
}
