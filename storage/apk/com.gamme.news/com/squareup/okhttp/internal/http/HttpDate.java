// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.text.DateFormat;

final class HttpDate
{
    private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS;
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
    private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT;
    
    static {
        STANDARD_DATE_FORMAT = new ThreadLocal<DateFormat>() {
            @Override
            protected DateFormat initialValue() {
                final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                return simpleDateFormat;
            }
        };
        BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = new String[] { "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z" };
        BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[HttpDate.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length];
    }
    
    public static String format(final Date date) {
        return HttpDate.STANDARD_DATE_FORMAT.get().format(date);
    }
    
    public static Date parse(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       com/squareup/okhttp/internal/http/HttpDate.STANDARD_DATE_FORMAT:Ljava/lang/ThreadLocal;
        //     3: invokevirtual   java/lang/ThreadLocal.get:()Ljava/lang/Object;
        //     6: checkcast       Ljava/text/DateFormat;
        //     9: aload_0        
        //    10: invokevirtual   java/text/DateFormat.parse:(Ljava/lang/String;)Ljava/util/Date;
        //    13: astore          9
        //    15: aload           9
        //    17: areturn        
        //    18: astore_1       
        //    19: getstatic       com/squareup/okhttp/internal/http/HttpDate.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS:[Ljava/lang/String;
        //    22: astore_2       
        //    23: aload_2        
        //    24: monitorenter   
        //    25: iconst_0       
        //    26: istore_3       
        //    27: getstatic       com/squareup/okhttp/internal/http/HttpDate.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS:[Ljava/lang/String;
        //    30: arraylength    
        //    31: istore          5
        //    33: iload_3        
        //    34: iload           5
        //    36: if_icmplt       43
        //    39: aload_2        
        //    40: monitorexit    
        //    41: aconst_null    
        //    42: areturn        
        //    43: getstatic       com/squareup/okhttp/internal/http/HttpDate.BROWSER_COMPATIBLE_DATE_FORMATS:[Ljava/text/DateFormat;
        //    46: iload_3        
        //    47: aaload         
        //    48: astore          6
        //    50: aload           6
        //    52: ifnonnull       79
        //    55: new             Ljava/text/SimpleDateFormat;
        //    58: dup            
        //    59: getstatic       com/squareup/okhttp/internal/http/HttpDate.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS:[Ljava/lang/String;
        //    62: iload_3        
        //    63: aaload         
        //    64: getstatic       java/util/Locale.US:Ljava/util/Locale;
        //    67: invokespecial   java/text/SimpleDateFormat.<init>:(Ljava/lang/String;Ljava/util/Locale;)V
        //    70: astore          6
        //    72: getstatic       com/squareup/okhttp/internal/http/HttpDate.BROWSER_COMPATIBLE_DATE_FORMATS:[Ljava/text/DateFormat;
        //    75: iload_3        
        //    76: aload           6
        //    78: aastore        
        //    79: aload           6
        //    81: aload_0        
        //    82: invokevirtual   java/text/DateFormat.parse:(Ljava/lang/String;)Ljava/util/Date;
        //    85: astore          8
        //    87: aload_2        
        //    88: monitorexit    
        //    89: aload           8
        //    91: areturn        
        //    92: astore          4
        //    94: aload_2        
        //    95: monitorexit    
        //    96: aload           4
        //    98: athrow         
        //    99: astore          7
        //   101: iinc            3, 1
        //   104: goto            33
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                      
        //  -----  -----  -----  -----  --------------------------
        //  0      15     18     107    Ljava/text/ParseException;
        //  27     33     92     99     Any
        //  39     41     92     99     Any
        //  43     50     92     99     Any
        //  55     79     92     99     Any
        //  79     87     99     107    Ljava/text/ParseException;
        //  79     87     92     99     Any
        //  87     89     92     99     Any
        //  94     96     92     99     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0079:
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
}
