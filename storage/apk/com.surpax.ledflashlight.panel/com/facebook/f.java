// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.util.Iterator;
import org.json.JSONException;
import com.facebook.b.v;
import com.facebook.b.aj;
import android.os.Bundle;
import android.content.Context;
import org.json.JSONObject;
import java.util.HashSet;
import java.io.Serializable;

final class f implements Serializable
{
    private static final HashSet c;
    private JSONObject a;
    private boolean b;
    private String d;
    
    static {
        c = new HashSet();
    }
    
    public f(final Context context, final String d, final Bundle bundle, final boolean b) {
        while (true) {
            a(d);
            this.d = d;
            this.b = b;
            this.a = new JSONObject();
            while (true) {
                String s = null;
                Object value = null;
                Label_0286: {
                    try {
                        this.a.put("_eventName", (Object)d);
                        this.a.put("_logTime", System.currentTimeMillis() / 1000L);
                        this.a.put("_ui", (Object)aj.d(context));
                        if (this.b) {
                            this.a.put("_implicitlyLogged", (Object)"1");
                        }
                        final String e = bq.e();
                        if (e != null) {
                            this.a.put("_appVersion", (Object)e);
                        }
                        if (bundle != null) {
                            final Iterator<String> iterator = bundle.keySet().iterator();
                            if (iterator.hasNext()) {
                                s = iterator.next();
                                a(s);
                                value = bundle.get(s);
                                if (!(value instanceof String) && !(value instanceof Number)) {
                                    throw new ab(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", value, s));
                                }
                                break Label_0286;
                            }
                        }
                        if (!this.b) {
                            v.a(ak.e, "AppEvents", "Created app event '%s'", this.a.toString());
                            return;
                        }
                        break;
                    }
                    catch (JSONException ex) {
                        v.a(ak.e, "AppEvents", "JSON encoding for app event failed: '%s'", ex.toString());
                        this.a = null;
                        return;
                    }
                }
                this.a.put(s, (Object)value.toString());
                continue;
            }
        }
    }
    
    private static void a(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: ifnull          20
        //     4: aload_0        
        //     5: invokevirtual   java/lang/String.length:()I
        //     8: ifeq            20
        //    11: aload_0        
        //    12: invokevirtual   java/lang/String.length:()I
        //    15: bipush          40
        //    17: if_icmple       58
        //    20: aload_0        
        //    21: ifnonnull       27
        //    24: ldc             "<None Provided>"
        //    26: astore_0       
        //    27: iconst_2       
        //    28: anewarray       Ljava/lang/Object;
        //    31: astore_1       
        //    32: aload_1        
        //    33: iconst_0       
        //    34: aload_0        
        //    35: aastore        
        //    36: aload_1        
        //    37: iconst_1       
        //    38: bipush          40
        //    40: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    43: aastore        
        //    44: new             Lcom/facebook/ab;
        //    47: dup            
        //    48: ldc             "Identifier '%s' must be less than %d characters"
        //    50: aload_1        
        //    51: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    54: invokespecial   com/facebook/ab.<init>:(Ljava/lang/String;)V
        //    57: athrow         
        //    58: getstatic       com/facebook/f.c:Ljava/util/HashSet;
        //    61: astore_2       
        //    62: aload_2        
        //    63: monitorenter   
        //    64: getstatic       com/facebook/f.c:Ljava/util/HashSet;
        //    67: aload_0        
        //    68: invokevirtual   java/util/HashSet.contains:(Ljava/lang/Object;)Z
        //    71: istore          4
        //    73: aload_2        
        //    74: monitorexit    
        //    75: iload           4
        //    77: ifne            108
        //    80: aload_0        
        //    81: ldc             "^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$"
        //    83: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //    86: ifeq            122
        //    89: getstatic       com/facebook/f.c:Ljava/util/HashSet;
        //    92: astore          5
        //    94: aload           5
        //    96: monitorenter   
        //    97: getstatic       com/facebook/f.c:Ljava/util/HashSet;
        //   100: aload_0        
        //   101: invokevirtual   java/util/HashSet.add:(Ljava/lang/Object;)Z
        //   104: pop            
        //   105: aload           5
        //   107: monitorexit    
        //   108: return         
        //   109: astore_3       
        //   110: aload_2        
        //   111: monitorexit    
        //   112: aload_3        
        //   113: athrow         
        //   114: astore          6
        //   116: aload           5
        //   118: monitorexit    
        //   119: aload           6
        //   121: athrow         
        //   122: new             Lcom/facebook/ab;
        //   125: dup            
        //   126: ldc             "Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen."
        //   128: iconst_1       
        //   129: anewarray       Ljava/lang/Object;
        //   132: dup            
        //   133: iconst_0       
        //   134: aload_0        
        //   135: aastore        
        //   136: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   139: invokespecial   com/facebook/ab.<init>:(Ljava/lang/String;)V
        //   142: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  64     75     109    114    Any
        //  97     108    114    122    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0108:
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
    
    public final boolean a() {
        return this.b;
    }
    
    public final JSONObject b() {
        return this.a;
    }
    
    @Override
    public final String toString() {
        return String.format("\"%s\", implicit: %b, json: %s", this.a.optString("_eventName"), this.b, this.a.toString());
    }
}
