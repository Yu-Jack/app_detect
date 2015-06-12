import java.io.FileReader;
import java.util.regex.Pattern;
import android.view.ViewConfiguration;
import android.net.Uri;
import java.util.Locale;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import android.view.ViewGroup$LayoutParams;
import android.widget.ImageView;
import android.content.res.Resources;
import android.os.PowerManager;
import android.content.ActivityNotFoundException;
import android.widget.Toast;
import android.os.Parcelable;
import com.socialnmobile.colornote.activity.SendAsAttachment;
import com.socialnmobile.colornote.activity.SendToClipboard;
import android.content.Intent;
import android.app.Activity;
import android.os.Environment;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import com.socialnmobile.colornote.ColorNote;
import android.text.format.DateUtils;
import android.text.style.StrikethroughSpan;
import android.text.SpannableStringBuilder;
import java.io.File;
import android.view.View;
import android.widget.AbsListView;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.Drawable;
import android.app.AlertDialog$Builder;
import android.app.Dialog;
import android.content.DialogInterface$OnClickListener;
import android.content.Context;
import android.text.format.Time;
import android.graphics.Color;
import android.os.PowerManager$WakeLock;
import java.util.Comparator;

// 
// Decompiled by Procyon v0.5.29
// 

public final class gw
{
    static Comparator a;
    static Comparator b;
    private static PowerManager$WakeLock c;
    
    static {
        gw.a = new gx();
        gw.b = new gy();
    }
    
    public static int a(final int n) {
        switch (n) {
            default: {
                return 0;
            }
            case 1:
            case 6: {
                return 2130837597;
            }
            case 5: {
                return 2130837594;
            }
            case 2: {
                return 2130837616;
            }
            case 3: {
                return 2130837617;
            }
            case 4: {
                return 2130837610;
            }
            case 7: {
                return 2130837605;
            }
        }
    }
    
    public static int a(final int n, final int n2) {
        return Color.argb(n, Color.red(n2), Color.green(n2), Color.blue(n2));
    }
    
    public static long a(final long n) {
        final Time time = new Time();
        time.set(n);
        final int year = time.year;
        final int month = time.month;
        final int monthDay = time.monthDay;
        time.timezone = "UTC";
        time.set(monthDay, month, year);
        return jk.a(time, false);
    }
    
    public static Dialog a(final Context context, final int n, final int title, final int message, final DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(context);
        if (n != 0) {
            alertDialog$Builder.setIcon(2130837583);
        }
        alertDialog$Builder.setTitle(title);
        alertDialog$Builder.setMessage(message);
        alertDialog$Builder.setPositiveButton(17039370, dialogInterface$OnClickListener);
        alertDialog$Builder.setNegativeButton(17039360, (DialogInterface$OnClickListener)null);
        return (Dialog)alertDialog$Builder.create();
    }
    
    public static Dialog a(final Context context, final int n, final int n2, final DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return a(context, 0, n, n2, dialogInterface$OnClickListener);
    }
    
    public static Drawable a(final Context context, final int n) {
        if (n != 0) {
            final GradientDrawable gradientDrawable = (GradientDrawable)context.getResources().getDrawable(2130837529);
            gradientDrawable.setColor(gr.a(context).e(n));
            return (Drawable)gradientDrawable;
        }
        return context.getResources().getDrawable(2130837592);
    }
    
    public static View a(final AbsListView absListView) {
        for (int i = 0; i < absListView.getChildCount(); ++i) {
            final View child = absListView.getChildAt(i);
            if (child == null) {
                return null;
            }
            if (child.getBottom() >= 0) {
                return child;
            }
        }
        return null;
    }
    
    private static File a(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/lang/StringBuilder;
        //     3: dup            
        //     4: invokestatic    android/os/Environment.getExternalStorageDirectory:()Ljava/io/File;
        //     7: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //    10: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    13: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    16: ldc             "/data/colornote/temp/"
        //    18: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    21: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    24: astore_2       
        //    25: new             Ljava/io/File;
        //    28: dup            
        //    29: aload_2        
        //    30: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //    33: astore_3       
        //    34: aload_3        
        //    35: invokevirtual   java/io/File.exists:()Z
        //    38: ifne            46
        //    41: aload_3        
        //    42: invokevirtual   java/io/File.mkdirs:()Z
        //    45: pop            
        //    46: new             Ljava/lang/StringBuilder;
        //    49: dup            
        //    50: ldc             "note"
        //    52: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    55: invokestatic    java/lang/System.currentTimeMillis:()J
        //    58: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //    61: ldc             ".html"
        //    63: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    66: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    69: astore          4
        //    71: new             Ljava/io/File;
        //    74: dup            
        //    75: new             Ljava/lang/StringBuilder;
        //    78: dup            
        //    79: aload_2        
        //    80: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    83: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    86: aload           4
        //    88: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    91: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    94: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //    97: astore          5
        //    99: new             Ljava/lang/StringBuilder;
        //   102: dup            
        //   103: ldc             "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\"/><title>"
        //   105: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   108: aload_0        
        //   109: invokestatic    android/text/TextUtils.htmlEncode:(Ljava/lang/String;)Ljava/lang/String;
        //   112: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   115: ldc             "</title></head><body>"
        //   117: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   120: new             Landroid/text/SpannableString;
        //   123: dup            
        //   124: aload_1        
        //   125: invokespecial   android/text/SpannableString.<init>:(Ljava/lang/CharSequence;)V
        //   128: invokestatic    android/text/Html.toHtml:(Landroid/text/Spanned;)Ljava/lang/String;
        //   131: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   134: ldc             "</body></html>"
        //   136: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   139: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   142: astore          6
        //   144: new             Ljava/io/BufferedWriter;
        //   147: dup            
        //   148: new             Ljava/io/FileWriter;
        //   151: dup            
        //   152: aload           5
        //   154: invokespecial   java/io/FileWriter.<init>:(Ljava/io/File;)V
        //   157: invokespecial   java/io/BufferedWriter.<init>:(Ljava/io/Writer;)V
        //   160: astore          7
        //   162: aload           7
        //   164: aload           6
        //   166: invokevirtual   java/io/BufferedWriter.write:(Ljava/lang/String;)V
        //   169: aload           7
        //   171: invokevirtual   java/io/BufferedWriter.close:()V
        //   174: aload           5
        //   176: areturn        
        //   177: astore          10
        //   179: aconst_null    
        //   180: astore          7
        //   182: aload           7
        //   184: ifnull          174
        //   187: aload           7
        //   189: invokevirtual   java/io/BufferedWriter.close:()V
        //   192: aload           5
        //   194: areturn        
        //   195: astore          9
        //   197: aload           5
        //   199: areturn        
        //   200: astore          8
        //   202: goto            182
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  144    162    177    182    Ljava/io/IOException;
        //  162    174    200    205    Ljava/io/IOException;
        //  187    192    195    200    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0174:
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
    
    public static CharSequence a(final String s) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)s);
        spannableStringBuilder.setSpan((Object)new StrikethroughSpan(), 0, spannableStringBuilder.length(), 33);
        return (CharSequence)spannableStringBuilder;
    }
    
    public static String a(final Context context, final long n) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - n) < 604800000L) {
            try {
                return DateUtils.getRelativeTimeSpanString(n, currentTimeMillis, 0L, 327680).toString();
            }
            catch (RuntimeException ex) {
                ColorNote.a("Can't format time");
            }
        }
        return DateUtils.formatDateRange(context, n, n, 327680);
    }
    
    public static String a(final InputStream in) {
        try {
            return a(new InputStreamReader(in));
        }
        catch (IOException ex) {
            ColorNote.a("readFile error" + ex.getMessage());
            return "";
        }
    }
    
    private static String a(final Reader p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/io/BufferedReader;
        //     3: dup            
        //     4: aload_0        
        //     5: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //     8: astore_1       
        //     9: new             Ljava/lang/StringBuffer;
        //    12: dup            
        //    13: invokespecial   java/lang/StringBuffer.<init>:()V
        //    16: astore_2       
        //    17: sipush          1024
        //    20: newarray        C
        //    22: astore          5
        //    24: aload_1        
        //    25: aload           5
        //    27: invokevirtual   java/io/BufferedReader.read:([C)I
        //    30: istore          6
        //    32: iload           6
        //    34: iconst_m1      
        //    35: if_icmpne       51
        //    38: aload_2        
        //    39: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //    42: astore          7
        //    44: aload_1        
        //    45: invokevirtual   java/io/BufferedReader.close:()V
        //    48: aload           7
        //    50: areturn        
        //    51: aload_2        
        //    52: aload           5
        //    54: iconst_0       
        //    55: iload           6
        //    57: invokevirtual   java/lang/StringBuffer.append:([CII)Ljava/lang/StringBuffer;
        //    60: pop            
        //    61: goto            24
        //    64: astore_3       
        //    65: aload_1        
        //    66: ifnull          73
        //    69: aload_1        
        //    70: invokevirtual   java/io/BufferedReader.close:()V
        //    73: aload_3        
        //    74: athrow         
        //    75: astore          8
        //    77: aload           7
        //    79: areturn        
        //    80: astore          4
        //    82: goto            73
        //    85: astore_3       
        //    86: aconst_null    
        //    87: astore_1       
        //    88: goto            65
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      9      85     91     Any
        //  9      24     64     65     Any
        //  24     32     64     65     Any
        //  38     44     64     65     Any
        //  44     48     75     80     Ljava/io/IOException;
        //  51     61     64     65     Any
        //  69     73     80     85     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0051:
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
    
    public static void a() {
        a(new File(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()) + "/data/colornote/temp/"));
    }
    
    public static void a(final Activity activity, final String s, final String s2) {
        final Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", s2);
        intent.putExtra("android.intent.extra.SUBJECT", s);
        try {
            final Intent chooser = Intent.createChooser(intent, (CharSequence)activity.getString(2131230847));
            final Intent intent2 = new Intent((Context)activity, (Class)SendToClipboard.class);
            intent2.putExtra("android.intent.extra.TEXT", s2);
            intent2.putExtra("android.intent.extra.SUBJECT", s);
            final Intent intent3 = new Intent((Context)activity, (Class)SendAsAttachment.class);
            intent3.putExtra("android.intent.extra.TEXT", s2);
            intent3.putExtra("android.intent.extra.SUBJECT", s);
            chooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])new Intent[] { intent2, intent3 });
            activity.startActivity(chooser);
        }
        catch (ActivityNotFoundException ex) {
            Toast.makeText((Context)activity, 2131230852, 0).show();
        }
    }
    
    public static void a(final Context context) {
        if (gw.c != null) {
            return;
        }
        (gw.c = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "ColorNote")).acquire();
        ColorNote.c();
    }
    
    public static void a(final Resources resources, final ImageView imageView, final int n) {
        imageView.setImageDrawable(resources.getDrawable(n));
    }
    
    public static void a(final Time time) {
        final int year = time.year;
        final int month = time.month;
        final int monthDay = time.monthDay;
        time.timezone = "UTC";
        time.set(monthDay, month, year);
    }
    
    public static void a(final View view, final int height) {
        final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.height != height) {
            layoutParams.height = height;
            view.setLayoutParams(layoutParams);
        }
    }
    
    public static void a(final ArrayList list) {
        Collections.sort((List<Object>)list, gw.b);
    }
    
    public static boolean a(final Context context, final Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
    
    public static boolean a(final Context context, final String s) {
        final PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo(s, 256);
            return true;
        }
        catch (PackageManager$NameNotFoundException ex) {
            return false;
        }
    }
    
    private static boolean a(final File parent) {
        if (parent != null) {
            if (parent.isDirectory()) {
                final String[] list = parent.list();
                for (int i = 0; i < list.length; ++i) {
                    if (!a(new File(parent, list[i]))) {
                        return false;
                    }
                }
            }
            return parent.delete();
        }
        return false;
    }
    
    public static boolean a(final Locale locale) {
        if (locale.getDisplayName().length() > 0) {
            final byte directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
            if (directionality == 1 || directionality == 2) {
                return true;
            }
        }
        return false;
    }
    
    public static int b(final int n) {
        switch (n) {
            default: {
                return 0;
            }
            case -1: {
                return 2130837588;
            }
            case 0: {
                return 2130837593;
            }
            case 16: {
                return 2130837604;
            }
        }
    }
    
    public static long b(final long n) {
        final Time time = new Time();
        time.set(n);
        ++time.monthDay;
        time.hour = 0;
        time.minute = 0;
        time.second = 0;
        return jk.a(time);
    }
    
    public static Drawable b(final Context context, final int n) {
        if (n == 0) {
            final GradientDrawable gradientDrawable = (GradientDrawable)context.getResources().getDrawable(2130837528);
            gradientDrawable.setColor(0);
            return new aaf((Drawable)gradientDrawable, c(context, 1));
        }
        final GradientDrawable gradientDrawable2 = (GradientDrawable)context.getResources().getDrawable(2130837528);
        gradientDrawable2.setColor(gr.a(context).e(n));
        return (Drawable)gradientDrawable2;
    }
    
    public static String b(final Context context, final long n) {
        final long currentTimeMillis = System.currentTimeMillis();
        final Time time = new Time();
        final Time time2 = new Time();
        time.set(n);
        time2.set(currentTimeMillis);
        time.set(time.monthDay, time.month, time.year);
        jk.a(time);
        time2.set(time2.monthDay, time2.month, time2.year);
        jk.a(time2);
        final int n2 = Time.getJulianDay(jk.a(time, true), time.gmtoff) - Time.getJulianDay(jk.a(time2, true), time2.gmtoff);
        if (n2 == 0) {
            return context.getResources().getString(2131230874);
        }
        if (n2 == 1) {
            return context.getResources().getString(2131230875);
        }
        if (n2 == -1) {
            return context.getResources().getString(2131230876);
        }
        if (n2 < 0) {
            return context.getResources().getString(2131230886, new Object[] { Math.abs(n2) });
        }
        if (n2 > 6) {
            return context.getResources().getString(2131230885, new Object[] { n2 });
        }
        return DateUtils.getDayOfWeekString(1 + time.weekDay, 10);
    }
    
    public static String b(final String s) {
        return s.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&#39;", "\\").replaceAll("&quot;", "\"");
    }
    
    public static void b() {
        if (gw.c != null) {
            gw.c.release();
            gw.c = null;
            ColorNote.c();
        }
    }
    
    public static void b(final Activity activity, final String s, final String s2) {
        final Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/html");
        intent.putExtra("android.intent.extra.SUBJECT", s);
        intent.putExtra("android.intent.extra.TEXT", "\n\n" + activity.getString(2131231071));
        intent.putExtra("android.intent.extra.STREAM", (Parcelable)Uri.fromFile(a(s, s2)));
        try {
            activity.startActivity(Intent.createChooser(intent, (CharSequence)activity.getString(2131230847)));
        }
        catch (ActivityNotFoundException ex) {
            Toast.makeText((Context)activity, 2131230852, 0).show();
        }
    }
    
    public static void b(final View view, final int width) {
        final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.width != width) {
            layoutParams.width = width;
            view.setLayoutParams(layoutParams);
        }
    }
    
    public static void b(final ArrayList list) {
        Collections.sort((List<Object>)list, gw.a);
    }
    
    public static boolean b(final Context context) {
        return jk.a(ViewConfiguration.get(context));
    }
    
    public static int c(final Context context, final int n) {
        return (int)(n * context.getResources().getDisplayMetrics().density);
    }
    
    public static void c(final Context context) {
        final Intent d = d();
        if (d == null) {
            return;
        }
        context.startActivity(d);
    }
    
    public static boolean c() {
        final Locale default1 = Locale.getDefault();
        return default1 != null && "CN".equals(default1.getCountry());
    }
    
    public static boolean c(final String input) {
        return Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$").matcher(input).matches();
    }
    
    private static Intent d() {
        final Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=com.socialnmobile.dictapps.notepad.color.note"));
        intent.addFlags(335544320);
        return intent;
    }
    
    public static String d(final String fileName) {
        try {
            return a(new FileReader(fileName));
        }
        catch (IOException ex) {
            ColorNote.a("readFile error" + ex.getMessage());
            return "";
        }
    }
    
    public static boolean d(final Context context) {
        final Intent d = d();
        return d != null && a(context, d);
    }
    
    public static Intent e(final Context context) {
        final Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("fb://page/195606680452466"));
        intent.setFlags(268435456);
        if (!a(context, intent)) {
            intent.setData(Uri.parse("http://www.facebook.com/ColorNote"));
        }
        return intent;
    }
    
    public static Intent e(final String s) {
        return new Intent("android.intent.action.VIEW", Uri.parse(s)).setFlags(268435456);
    }
    
    public static Intent f(final String s) {
        return i("http://www.google.com/cse?cx=partner-pub-2353536094017743:1302913524&ie=UTF-8&sa=Search&q=" + Uri.encode(s));
    }
    
    public static Intent g(final String s) {
        return i(String.format("http://www.amazon.com/gp/aw/s?tag=colornotenotepa-20&linkCode=da4&i=aps&k=%s&sort=&p_lbr_brands_browse-bin=", Uri.encode(s)));
    }
    
    public static String h(final String s) {
        final String trim = s.trim();
        final int index = trim.indexOf(10);
        int min;
        if (index >= 0) {
            min = Math.min(50, index);
        }
        else {
            min = 50;
        }
        String s2 = trim.substring(0, Math.min(min, trim.length()));
        if (s2.length() >= 50) {
            final int lastIndex = s2.lastIndexOf(32);
            if (lastIndex > 0) {
                s2 = s2.substring(0, lastIndex);
            }
        }
        return s2.trim();
    }
    
    private static Intent i(final String s) {
        final Uri parse = Uri.parse(s);
        final Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(parse);
        intent.setFlags(524288);
        return intent;
    }
}
