// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class u extends t
{
    private Method a;
    private Field b;
    
    u() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   android/support/v4/widget/t.<init>:()V
        //     4: aload_0        
        //     5: ldc             Landroid/view/View;.class
        //     7: ldc             "getDisplayList"
        //     9: aconst_null    
        //    10: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    13: putfield        android/support/v4/widget/u.a:Ljava/lang/reflect/Method;
        //    16: aload_0        
        //    17: ldc             Landroid/view/View;.class
        //    19: ldc             "mRecreateDisplayList"
        //    21: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    24: putfield        android/support/v4/widget/u.b:Ljava/lang/reflect/Field;
        //    27: aload_0        
        //    28: getfield        android/support/v4/widget/u.b:Ljava/lang/reflect/Field;
        //    31: iconst_1       
        //    32: invokevirtual   java/lang/reflect/Field.setAccessible:(Z)V
        //    35: return         
        //    36: astore_1       
        //    37: ldc             "SlidingPaneLayout"
        //    39: ldc             "Couldn't fetch getDisplayList method; dimming won't work right."
        //    41: aload_1        
        //    42: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    45: pop            
        //    46: goto            16
        //    49: astore_3       
        //    50: ldc             "SlidingPaneLayout"
        //    52: ldc             "Couldn't fetch mRecreateDisplayList field; dimming will be slow."
        //    54: aload_3        
        //    55: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    58: pop            
        //    59: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  4      16     36     49     Ljava/lang/NoSuchMethodException;
        //  16     35     49     60     Ljava/lang/NoSuchFieldException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0016:
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
    public final void a(final SlidingPaneLayout slidingPaneLayout, final View view) {
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
