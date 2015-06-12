// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.g;
import android.os.RemoteException;
import android.util.Log;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.c;
import com.google.android.gms.internal.fy$com.google.android.gms.internal.gf;
import com.google.android.gms.internal.fy$com.google.android.gms.internal.gb;
import java.util.ArrayList;
import android.os.Looper;
import android.os.Handler;
import android.content.Context;
import com.google.android.gms.common.b;
import android.os.IInterface;

public abstract class gb<TListener>
{
    final /* synthetic */ fy a;
    private TListener b;
    private boolean c;
    
    public gb(final fy a, final TListener b) {
        this.a = a;
        this.b = b;
        this.c = false;
    }
    
    protected abstract void a();
    
    protected abstract void a(final TListener p0);
    
    public void b() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: monitorenter   
        //     2: aload_0        
        //     3: getfield        com/google/android/gms/internal/gb.b:Ljava/lang/Object;
        //     6: astore_2       
        //     7: aload_0        
        //     8: getfield        com/google/android/gms/internal/gb.c:Z
        //    11: ifeq            44
        //    14: ldc             "GmsClient"
        //    16: new             Ljava/lang/StringBuilder;
        //    19: dup            
        //    20: invokespecial   java/lang/StringBuilder.<init>:()V
        //    23: ldc             "Callback proxy "
        //    25: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    28: aload_0        
        //    29: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    32: ldc             " being reused. This is not safe."
        //    34: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    37: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    40: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //    43: pop            
        //    44: aload_0        
        //    45: monitorexit    
        //    46: aload_2        
        //    47: ifnull          83
        //    50: aload_0        
        //    51: aload_2        
        //    52: invokevirtual   com/google/android/gms/internal/gb.a:(Ljava/lang/Object;)V
        //    55: aload_0        
        //    56: monitorenter   
        //    57: aload_0        
        //    58: iconst_1       
        //    59: putfield        com/google/android/gms/internal/gb.c:Z
        //    62: aload_0        
        //    63: monitorexit    
        //    64: aload_0        
        //    65: invokevirtual   com/google/android/gms/internal/gb.c:()V
        //    68: return         
        //    69: astore_1       
        //    70: aload_0        
        //    71: monitorexit    
        //    72: aload_1        
        //    73: athrow         
        //    74: astore          4
        //    76: aload_0        
        //    77: invokevirtual   com/google/android/gms/internal/gb.a:()V
        //    80: aload           4
        //    82: athrow         
        //    83: aload_0        
        //    84: invokevirtual   com/google/android/gms/internal/gb.a:()V
        //    87: goto            55
        //    90: astore_3       
        //    91: aload_0        
        //    92: monitorexit    
        //    93: aload_3        
        //    94: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  2      44     69     74     Any
        //  44     46     69     74     Any
        //  50     55     74     83     Ljava/lang/RuntimeException;
        //  57     64     90     95     Any
        //  70     72     69     74     Any
        //  91     93     90     95     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 56, Size: 56
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
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
    
    public void c() {
        this.d();
        synchronized (this.a.g) {
            this.a.g.remove(this);
        }
    }
    
    public void d() {
        synchronized (this) {
            this.b = null;
        }
    }
}
