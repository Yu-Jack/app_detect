// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class aa extends z
{
    private Method a;
    private Field b;
    
    aa() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   android/support/v4/widget/z.<init>:()V
        //     4: aload_0        
        //     5: ldc             Landroid/view/View;.class
        //     7: ldc             "getDisplayList"
        //     9: aconst_null    
        //    10: checkcast       [Ljava/lang/Class;
        //    13: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    16: putfield        android/support/v4/widget/aa.a:Ljava/lang/reflect/Method;
        //    19: aload_0        
        //    20: ldc             Landroid/view/View;.class
        //    22: ldc             "mRecreateDisplayList"
        //    24: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    27: putfield        android/support/v4/widget/aa.b:Ljava/lang/reflect/Field;
        //    30: aload_0        
        //    31: getfield        android/support/v4/widget/aa.b:Ljava/lang/reflect/Field;
        //    34: iconst_1       
        //    35: invokevirtual   java/lang/reflect/Field.setAccessible:(Z)V
        //    38: return         
        //    39: astore_1       
        //    40: ldc             "SlidingPaneLayout"
        //    42: ldc             "Couldn't fetch getDisplayList method; dimming won't work right."
        //    44: aload_1        
        //    45: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    48: pop            
        //    49: goto            19
        //    52: astore_3       
        //    53: ldc             "SlidingPaneLayout"
        //    55: ldc             "Couldn't fetch mRecreateDisplayList field; dimming will be slow."
        //    57: aload_3        
        //    58: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    61: pop            
        //    62: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  4      19     39     52     Ljava/lang/NoSuchMethodException;
        //  19     38     52     63     Ljava/lang/NoSuchFieldException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0019:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:692)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:529)
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
    public void a(final SlidingPaneLayout slidingPaneLayout, final View view) {
        if (this.a != null && this.b != null) {
            while (true) {
                try {
                    this.b.setBoolean(view, true);
                    this.a.invoke(view, (Object[])null);
                    super.a(slidingPaneLayout, view);
                    return;
                }
                catch (Exception ex) {
                    Log.e("SlidingPaneLayout", "Error refreshing display list state", (Throwable)ex);
                    continue;
                }
                break;
            }
        }
        view.invalidate();
    }
}
