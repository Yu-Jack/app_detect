// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.text.ParseException;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import com.google.android.gms.common.images.WebImage;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class gs
{
    private static final gn BG;
    private static final String[] CO;
    private static final String CP;
    
    static {
        BG = new gn("MetadataUtils");
        CO = new String[] { "Z", "+hh", "+hhmm", "+hh:mm" };
        CP = "yyyyMMdd'T'HHmmss" + gs.CO[0];
    }
    
    public static String a(final Calendar calendar) {
        String format;
        if (calendar == null) {
            gs.BG.b("Calendar object cannot be null", new Object[0]);
            format = null;
        }
        else {
            String cp = gs.CP;
            if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
                cp = "yyyyMMdd";
            }
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(cp);
            simpleDateFormat.setTimeZone(calendar.getTimeZone());
            format = simpleDateFormat.format(calendar.getTime());
            if (format.endsWith("+0000")) {
                return format.replace("+0000", gs.CO[0]);
            }
        }
        return format;
    }
    
    public static void a(final List p0, final JSONObject p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: invokeinterface java/util/List.clear:()V
        //     6: aload_1        
        //     7: ldc             "images"
        //     9: invokevirtual   org/json/JSONObject.getJSONArray:(Ljava/lang/String;)Lorg/json/JSONArray;
        //    12: astore_3       
        //    13: aload_3        
        //    14: invokevirtual   org/json/JSONArray.length:()I
        //    17: istore          4
        //    19: iconst_0       
        //    20: istore          5
        //    22: iload           5
        //    24: iload           4
        //    26: if_icmpge       60
        //    29: aload_3        
        //    30: iload           5
        //    32: invokevirtual   org/json/JSONArray.getJSONObject:(I)Lorg/json/JSONObject;
        //    35: astore          6
        //    37: aload_0        
        //    38: new             Lcom/google/android/gms/common/images/WebImage;
        //    41: dup            
        //    42: aload           6
        //    44: invokespecial   com/google/android/gms/common/images/WebImage.<init>:(Lorg/json/JSONObject;)V
        //    47: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    52: pop            
        //    53: iinc            5, 1
        //    56: goto            22
        //    59: astore_2       
        //    60: return         
        //    61: astore          7
        //    63: goto            53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  0      19     59     60     Lorg/json/JSONException;
        //  29     37     59     60     Lorg/json/JSONException;
        //  37     53     61     66     Ljava/lang/IllegalArgumentException;
        //  37     53     59     60     Lorg/json/JSONException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0053:
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
    
    public static void a(final JSONObject jsonObject, final List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        final JSONArray jsonArray = new JSONArray();
        final Iterator<WebImage> iterator = list.iterator();
        while (iterator.hasNext()) {
            jsonArray.put((Object)iterator.next().dZ());
        }
        try {
            jsonObject.put("images", (Object)jsonArray);
        }
        catch (JSONException ex) {}
    }
    
    public static Calendar aq(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            gs.BG.b("Input string is empty or null", new Object[0]);
            return null;
        }
        String s2 = ar(s);
        if (TextUtils.isEmpty((CharSequence)s2)) {
            gs.BG.b("Invalid date format", new Object[0]);
            return null;
        }
        final String as = as(s);
        String cp = "yyyyMMdd";
        Label_0130: {
            if (!TextUtils.isEmpty((CharSequence)as)) {
                s2 = s2 + "T" + as;
                if (as.length() != "HHmmss".length()) {
                    break Label_0130;
                }
                cp = "yyyyMMdd'T'HHmmss";
            }
            while (true) {
                final Calendar instance = Calendar.getInstance();
                try {
                    instance.setTime(new SimpleDateFormat(cp).parse(s2));
                    return instance;
                    cp = gs.CP;
                }
                catch (ParseException ex) {
                    gs.BG.b("Error parsing string: %s", ex.getMessage());
                    return null;
                }
            }
        }
    }
    
    private static String ar(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            gs.BG.b("Input string is empty or null", new Object[0]);
            return null;
        }
        try {
            return s.substring(0, "yyyyMMdd".length());
        }
        catch (IndexOutOfBoundsException ex) {
            gs.BG.c("Error extracting the date: %s", ex.getMessage());
            return null;
        }
    }
    
    private static String as(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            gs.BG.b("string is empty or null", new Object[0]);
        }
        else {
            final int index = s.indexOf(84);
            final int beginIndex = index + 1;
            if (index != "yyyyMMdd".length()) {
                gs.BG.b("T delimeter is not found", new Object[0]);
                return null;
            }
            String substring;
            try {
                substring = s.substring(beginIndex);
                if (substring.length() == "HHmmss".length()) {
                    return substring;
                }
            }
            catch (IndexOutOfBoundsException ex) {
                gs.BG.b("Error extracting the time substring: %s", ex.getMessage());
                return null;
            }
            switch (substring.charAt("HHmmss".length())) {
                default: {
                    return null;
                }
                case '+':
                case '-': {
                    if (at(substring)) {
                        return substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
                    }
                    break;
                }
                case 'Z': {
                    if (substring.length() == "HHmmss".length() + gs.CO[0].length()) {
                        return substring.substring(0, -1 + substring.length()) + "+0000";
                    }
                    break;
                }
            }
        }
        return null;
    }
    
    private static boolean at(final String s) {
        final int length = s.length();
        final int length2 = "HHmmss".length();
        return length == length2 + gs.CO[1].length() || length == length2 + gs.CO[2].length() || length == length2 + gs.CO[3].length();
    }
}
