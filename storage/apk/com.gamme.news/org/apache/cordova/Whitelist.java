// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import java.net.MalformedURLException;
import java.util.regex.Pattern;
import java.util.Iterator;
import android.net.Uri;
import java.util.ArrayList;

public class Whitelist
{
    public static final String TAG = "Whitelist";
    private ArrayList<URLPattern> whiteList;
    
    public Whitelist() {
        this.whiteList = new ArrayList<URLPattern>();
    }
    
    public void addWhiteListEntry(final String p0, final boolean p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        org/apache/cordova/Whitelist.whiteList:Ljava/util/ArrayList;
        //     4: ifnull          197
        //     7: aload_1        
        //     8: ldc             "*"
        //    10: invokevirtual   java/lang/String.compareTo:(Ljava/lang/String;)I
        //    13: ifne            29
        //    16: ldc             "Whitelist"
        //    18: ldc             "Unlimited access to network resources"
        //    20: invokestatic    org/apache/cordova/LOG.d:(Ljava/lang/String;Ljava/lang/String;)V
        //    23: aload_0        
        //    24: aconst_null    
        //    25: putfield        org/apache/cordova/Whitelist.whiteList:Ljava/util/ArrayList;
        //    28: return         
        //    29: ldc             "^((\\*|[A-Za-z-]+):(//)?)?(\\*|((\\*\\.)?[^*/:]+))?(:(\\d+))?(/.*)?"
        //    31: invokestatic    java/util/regex/Pattern.compile:(Ljava/lang/String;)Ljava/util/regex/Pattern;
        //    34: aload_1        
        //    35: invokevirtual   java/util/regex/Pattern.matcher:(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
        //    38: astore          4
        //    40: aload           4
        //    42: invokevirtual   java/util/regex/Matcher.matches:()Z
        //    45: ifeq            197
        //    48: aload           4
        //    50: iconst_2       
        //    51: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //    54: astore          5
        //    56: aload           4
        //    58: iconst_4       
        //    59: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //    62: astore          6
        //    64: ldc             "file"
        //    66: aload           5
        //    68: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    71: ifne            198
        //    74: ldc             "content"
        //    76: aload           5
        //    78: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    81: ifeq            87
        //    84: goto            198
        //    87: aload           4
        //    89: bipush          8
        //    91: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //    94: astore          7
        //    96: aload           4
        //    98: bipush          9
        //   100: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   103: astore          8
        //   105: aload           5
        //   107: ifnonnull       174
        //   110: aload_0        
        //   111: getfield        org/apache/cordova/Whitelist.whiteList:Ljava/util/ArrayList;
        //   114: new             Lorg/apache/cordova/Whitelist$URLPattern;
        //   117: dup            
        //   118: ldc             "http"
        //   120: aload           6
        //   122: aload           7
        //   124: aload           8
        //   126: invokespecial   org/apache/cordova/Whitelist$URLPattern.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   129: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //   132: pop            
        //   133: aload_0        
        //   134: getfield        org/apache/cordova/Whitelist.whiteList:Ljava/util/ArrayList;
        //   137: new             Lorg/apache/cordova/Whitelist$URLPattern;
        //   140: dup            
        //   141: ldc             "https"
        //   143: aload           6
        //   145: aload           7
        //   147: aload           8
        //   149: invokespecial   org/apache/cordova/Whitelist$URLPattern.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   152: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //   155: pop            
        //   156: return         
        //   157: astore_3       
        //   158: ldc             "Whitelist"
        //   160: ldc             "Failed to add origin %s"
        //   162: iconst_1       
        //   163: anewarray       Ljava/lang/Object;
        //   166: dup            
        //   167: iconst_0       
        //   168: aload_1        
        //   169: aastore        
        //   170: invokestatic    org/apache/cordova/LOG.d:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   173: return         
        //   174: aload_0        
        //   175: getfield        org/apache/cordova/Whitelist.whiteList:Ljava/util/ArrayList;
        //   178: new             Lorg/apache/cordova/Whitelist$URLPattern;
        //   181: dup            
        //   182: aload           5
        //   184: aload           6
        //   186: aload           7
        //   188: aload           8
        //   190: invokespecial   org/apache/cordova/Whitelist$URLPattern.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   193: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //   196: pop            
        //   197: return         
        //   198: aload           6
        //   200: ifnonnull       87
        //   203: ldc             "*"
        //   205: astore          6
        //   207: goto            87
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  7      28     157    174    Ljava/lang/Exception;
        //  29     84     157    174    Ljava/lang/Exception;
        //  87     105    157    174    Ljava/lang/Exception;
        //  110    156    157    174    Ljava/lang/Exception;
        //  174    197    157    174    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: cmpeq:boolean(var_6_3E:String, aconstnull:String())
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.GotoRemoval.traverseGraph(GotoRemoval.java:88)
        //     at com.strobel.decompiler.ast.GotoRemoval.removeGotos(GotoRemoval.java:52)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:276)
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
    
    public boolean isUrlWhiteListed(final String s) {
        if (this.whiteList == null) {
            return true;
        }
        final Uri parse = Uri.parse(s);
        final Iterator<URLPattern> iterator = this.whiteList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().matches(parse)) {
                return true;
            }
        }
        return false;
    }
    
    private static class URLPattern
    {
        public Pattern host;
        public Pattern path;
        public Integer port;
        public Pattern scheme;
        
        public URLPattern(final String anObject, final String anObject2, final String s, final String anObject3) throws MalformedURLException {
            while (true) {
                if (anObject != null) {
                Label_0054_Outer:
                    while (true) {
                        while (true) {
                        Label_0166:
                            while (true) {
                                try {
                                    if ("*".equals(anObject)) {
                                        this.scheme = null;
                                    }
                                    else {
                                        this.scheme = Pattern.compile(this.regexFromPattern(anObject, false), 2);
                                    }
                                    if ("*".equals(anObject2)) {
                                        this.host = null;
                                        if (s != null && !"*".equals(s)) {
                                            break Label_0166;
                                        }
                                        this.port = null;
                                        if (anObject3 == null || "/*".equals(anObject3)) {
                                            this.path = null;
                                            return;
                                        }
                                        break;
                                    }
                                }
                                catch (NumberFormatException ex) {
                                    throw new MalformedURLException("Port must be a number");
                                }
                                if (anObject2.startsWith("*.")) {
                                    this.host = Pattern.compile("([a-z0-9.-]*\\.)?" + this.regexFromPattern(anObject2.substring(2), false), 2);
                                    continue Label_0054_Outer;
                                }
                                this.host = Pattern.compile(this.regexFromPattern(anObject2, false), 2);
                                continue Label_0054_Outer;
                            }
                            this.port = Integer.parseInt(s, 10);
                            continue;
                        }
                    }
                    this.path = Pattern.compile(this.regexFromPattern(anObject3, true));
                    return;
                }
                continue;
            }
        }
        
        private String regexFromPattern(final String s, final boolean b) {
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); ++i) {
                final char char1 = s.charAt(i);
                if (char1 == '*' && b) {
                    sb.append(".");
                }
                else if ("\\.[]{}()^$?+|".indexOf(char1) > -1) {
                    sb.append('\\');
                }
                sb.append(char1);
            }
            return sb.toString();
        }
        
        public boolean matches(final Uri uri) {
            try {
                if (this.scheme != null) {
                    final boolean matches = this.scheme.matcher(uri.getScheme()).matches();
                    final boolean b = false;
                    if (!matches) {
                        return b;
                    }
                }
                if (this.host != null) {
                    final boolean matches2 = this.host.matcher(uri.getHost()).matches();
                    final boolean b = false;
                    if (!matches2) {
                        return b;
                    }
                }
                if (this.port != null) {
                    final boolean equals = this.port.equals(uri.getPort());
                    final boolean b = false;
                    if (!equals) {
                        return b;
                    }
                }
                if (this.path != null) {
                    final boolean matches3 = this.path.matcher(uri.getPath()).matches();
                    final boolean b = false;
                    if (!matches3) {
                        return b;
                    }
                }
                return true;
            }
            catch (Exception ex) {
                LOG.d("Whitelist", ex.toString());
                return false;
            }
        }
    }
}
