// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.os.Bundle;
import android.app.Activity;

public class AdActivity extends Activity
{
    protected static final String ADAPTER_KEY = "adapter";
    private static final String LOG_TAG = "AdAdapter";
    private IAdActivityAdapter adapter;
    
    IAdActivityAdapter createAdapter() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/amazon/device/ads/AdActivity.getIntent:()Landroid/content/Intent;
        //     4: ldc             "adapter"
        //     6: invokevirtual   android/content/Intent.getStringExtra:(Ljava/lang/String;)Ljava/lang/String;
        //     9: astore_1       
        //    10: aload_1        
        //    11: ifnonnull       23
        //    14: ldc             "AdAdapter"
        //    16: ldc             "Unable to launch the AdActivity due to an internal error."
        //    18: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;)V
        //    21: aconst_null    
        //    22: areturn        
        //    23: aload_1        
        //    24: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //    27: astore_3       
        //    28: aload_3        
        //    29: iconst_0       
        //    30: anewarray       Ljava/lang/Class;
        //    33: invokevirtual   java/lang/Class.getDeclaredConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //    36: astore          6
        //    38: aload           6
        //    40: iconst_0       
        //    41: anewarray       Ljava/lang/Object;
        //    44: invokevirtual   java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
        //    47: checkcast       Lcom/amazon/device/ads/IAdActivityAdapter;
        //    50: astore          11
        //    52: aload           11
        //    54: areturn        
        //    55: astore_2       
        //    56: ldc             "AdAdapter"
        //    58: ldc             "Unable to get the adapter class."
        //    60: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;)V
        //    63: aconst_null    
        //    64: areturn        
        //    65: astore          5
        //    67: ldc             "AdAdapter"
        //    69: ldc             "Security exception when trying to get the default constructor."
        //    71: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;)V
        //    74: aconst_null    
        //    75: areturn        
        //    76: astore          4
        //    78: ldc             "AdAdapter"
        //    80: ldc             "No default constructor exists for the adapter."
        //    82: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;)V
        //    85: aconst_null    
        //    86: areturn        
        //    87: astore          10
        //    89: ldc             "AdAdapter"
        //    91: ldc             "Illegal arguments given to the default constructor."
        //    93: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;)V
        //    96: aconst_null    
        //    97: areturn        
        //    98: astore          9
        //   100: ldc             "AdAdapter"
        //   102: ldc             "Instantiation exception when instantiating the adapter."
        //   104: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;)V
        //   107: aconst_null    
        //   108: areturn        
        //   109: astore          8
        //   111: ldc             "AdAdapter"
        //   113: ldc             "Illegal access exception when instantiating the adapter."
        //   115: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;)V
        //   118: aconst_null    
        //   119: areturn        
        //   120: astore          7
        //   122: ldc             "AdAdapter"
        //   124: ldc             "Invocation target exception when instantiating the adapter."
        //   126: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;)V
        //   129: aconst_null    
        //   130: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                         
        //  -----  -----  -----  -----  ---------------------------------------------
        //  23     28     55     65     Ljava/lang/ClassNotFoundException;
        //  28     38     65     76     Ljava/lang/SecurityException;
        //  28     38     76     87     Ljava/lang/NoSuchMethodException;
        //  38     52     87     98     Ljava/lang/IllegalArgumentException;
        //  38     52     98     109    Ljava/lang/InstantiationException;
        //  38     52     109    120    Ljava/lang/IllegalAccessException;
        //  38     52     120    131    Ljava/lang/reflect/InvocationTargetException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 70, Size: 70
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
    
    public void onCreate(final Bundle bundle) {
        InternalAdRegistration.getInstance().contextReceived(this.getApplicationContext());
        this.adapter = this.createAdapter();
        if (this.adapter == null) {
            this.finish();
            return;
        }
        this.adapter.setActivity(this);
        this.adapter.preOnCreate();
        super.onCreate(bundle);
        this.adapter.onCreate();
    }
    
    public void onPause() {
        super.onPause();
        this.adapter.onPause();
    }
    
    public void onResume() {
        super.onResume();
        this.adapter.onResume();
    }
    
    public void onStop() {
        this.adapter.onStop();
        super.onStop();
    }
}
