// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.ads.b;

import com.google.android.gms.internal.gz;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.common.e;
import java.io.IOException;
import android.content.ServiceConnection;
import android.content.Intent;
import com.google.android.gms.common.g;
import com.google.android.gms.common.i;
import android.content.Context;

public final class a
{
    static b a(final Context p0, final i p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: invokevirtual   com/google/android/gms/common/i.a:()Landroid/os/IBinder;
        //     4: invokestatic    com/google/android/gms/internal/lf.a:(Landroid/os/IBinder;)Lcom/google/android/gms/internal/le;
        //     7: astore          8
        //     9: new             Lcom/google/android/gms/ads/b/b;
        //    12: dup            
        //    13: aload           8
        //    15: invokeinterface com/google/android/gms/internal/le.a:()Ljava/lang/String;
        //    20: aload           8
        //    22: iconst_1       
        //    23: invokeinterface com/google/android/gms/internal/le.a:(Z)Z
        //    28: invokespecial   com/google/android/gms/ads/b/b.<init>:(Ljava/lang/String;Z)V
        //    31: astore          9
        //    33: aload_0        
        //    34: aload_1        
        //    35: invokevirtual   android/content/Context.unbindService:(Landroid/content/ServiceConnection;)V
        //    38: aload           9
        //    40: areturn        
        //    41: astore          10
        //    43: ldc             "AdvertisingIdClient"
        //    45: ldc             "getAdvertisingIdInfo unbindService failed."
        //    47: aload           10
        //    49: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    52: pop            
        //    53: aload           9
        //    55: areturn        
        //    56: astore          6
        //    58: ldc             "AdvertisingIdClient"
        //    60: ldc             "GMS remote exception "
        //    62: aload           6
        //    64: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    67: pop            
        //    68: new             Ljava/io/IOException;
        //    71: dup            
        //    72: ldc             "Remote exception"
        //    74: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    77: athrow         
        //    78: astore_3       
        //    79: aload_0        
        //    80: aload_1        
        //    81: invokevirtual   android/content/Context.unbindService:(Landroid/content/ServiceConnection;)V
        //    84: aload_3        
        //    85: athrow         
        //    86: astore_2       
        //    87: new             Ljava/io/IOException;
        //    90: dup            
        //    91: ldc             "Interrupted exception"
        //    93: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    96: athrow         
        //    97: astore          4
        //    99: ldc             "AdvertisingIdClient"
        //   101: ldc             "getAdvertisingIdInfo unbindService failed."
        //   103: aload           4
        //   105: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   108: pop            
        //   109: goto            84
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  0      33     56     78     Landroid/os/RemoteException;
        //  0      33     86     97     Ljava/lang/InterruptedException;
        //  0      33     78     86     Any
        //  33     38     41     56     Ljava/lang/IllegalArgumentException;
        //  58     78     78     86     Any
        //  79     84     97     112    Ljava/lang/IllegalArgumentException;
        //  87     97     78     86     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0084:
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
    
    static i a(final Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            final Context context2 = context;
            g.b(context2);
            final i i = new i();
            final String s = "com.google.android.gms.ads.identifier.service.START";
            final Intent intent = new Intent(s);
            final Intent intent3;
            final Intent intent2 = intent3 = intent;
            final String s2 = "com.google.android.gms";
            intent3.setPackage(s2);
            final Context context3 = context;
            final Intent intent4 = intent2;
            final Object o = i;
            final int n = 1;
            final boolean b = context3.bindService(intent4, (ServiceConnection)o, n);
            if (b) {
                return i;
            }
            throw new IOException("Connection failure");
        }
        catch (PackageManager$NameNotFoundException ex) {
            throw new e(9);
        }
        try {
            final Context context2 = context;
            g.b(context2);
            final i i = new i();
            final String s = "com.google.android.gms.ads.identifier.service.START";
            final Intent intent = new Intent(s);
            final Intent intent3;
            final Intent intent2 = intent3 = intent;
            final String s2 = "com.google.android.gms";
            intent3.setPackage(s2);
            final Context context3 = context;
            final Intent intent4 = intent2;
            final Object o = i;
            final int n = 1;
            final boolean b = context3.bindService(intent4, (ServiceConnection)o, n);
            if (b) {
                return i;
            }
        }
        catch (e cause) {
            throw new IOException(cause);
        }
        throw new IOException("Connection failure");
    }
    
    public static b b(final Context context) {
        gz.c("Calling this from your main thread can lead to deadlock");
        return a(context, a(context));
    }
}
