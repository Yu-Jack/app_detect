// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.receiver;

import android.os.AsyncTask;
import android.content.ComponentName;
import com.ogqcorp.bgh.activity.SplashActivity;
import android.content.Intent;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat$BigPictureStyle;
import android.support.v4.app.NotificationCompat$Builder;
import java.util.ArrayList;
import com.ogqcorp.bgh.system.l;
import com.ogqcorp.bgh.b.n;
import com.ogqcorp.bgh.system.r;
import com.ogqcorp.bgh.system.q;
import com.ogqcorp.bgh.item.Backgrounds;
import com.ogqcorp.bgh.system.v;
import android.app.AlarmManager;
import java.util.Random;
import java.util.GregorianCalendar;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Bitmap$Config;
import java.io.File;
import android.graphics.BitmapFactory;
import com.ogqcorp.bgh.system.o;
import android.graphics.Bitmap;
import com.ogqcorp.bgh.item.Background;
import java.util.List;
import android.content.Context;
import android.content.BroadcastReceiver;

public class NotificationReceiver extends BroadcastReceiver
{
    private Bitmap a(final Context context, final List<Background> list, final int n) {
        final int id = list.get(n).getId();
        final String a = o.b().a(context, id);
        final File a2 = o.b().a(id);
        this.a(a, a2);
        return BitmapFactory.decodeFile(a2.getAbsolutePath());
    }
    
    private Bitmap a(final Bitmap bitmap, final Bitmap bitmap2) {
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        final Bitmap bitmap3 = Bitmap.createBitmap(2 * bitmap.getWidth(), bitmap.getHeight(), Bitmap$Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap3);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint)null);
        canvas.drawBitmap(bitmap2, (float)bitmap.getWidth(), 0.0f, (Paint)null);
        return bitmap3;
    }
    
    public static void a(final Context context) {
        final GregorianCalendar gregorianCalendar = new GregorianCalendar();
        final long timeInMillis = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), 1 + gregorianCalendar.get(5), new Random().nextInt(7) + 12, new Random().nextInt(60), new Random().nextInt(60)).getTimeInMillis();
        ((AlarmManager)context.getSystemService("alarm")).setRepeating(0, timeInMillis, 86400000L, c(context));
        v.a().a(context, timeInMillis);
    }
    
    private void a(final Context context, final int n) {
        try {
            final ArrayList<Background> backgroundsList = new q().a(o.b().g(context), r.d).getBackgroundsList();
            if (backgroundsList != null) {
                if (backgroundsList.size() < 2) {
                    return;
                }
                if (((Background)backgroundsList.get(0)).getId() != n) {
                    final Bitmap a = this.a(context, backgroundsList, 0);
                    final Bitmap a2 = this.a(context, backgroundsList, 1);
                    final Bitmap a3 = this.a(a, a2);
                    if (a != null) {
                        a.recycle();
                    }
                    if (a2 != null) {
                        a2.recycle();
                    }
                    n.a(context);
                    this.a(context, a3);
                }
            }
        }
        catch (Exception ex) {
            l.c(ex);
        }
    }
    
    private void a(final Context context, final Bitmap bitmap) {
        final String string = context.getString(2131427418);
        final String string2 = context.getString(2131427461);
        final Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), 2130837705);
        final NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(context);
        notificationCompat$Builder.setContentTitle(string);
        notificationCompat$Builder.setContentText(string2);
        notificationCompat$Builder.setSmallIcon(2130837706).setLargeIcon(decodeResource);
        final Notification build = new NotificationCompat$BigPictureStyle(notificationCompat$Builder).bigPicture(bitmap).setSummaryText(string2).build();
        build.flags |= 0x10;
        build.contentIntent = PendingIntent.getActivity(context, 0, this.d(context), 0);
        ((NotificationManager)context.getSystemService("notification")).notify(0, build);
    }
    
    private void a(final String p0, final File p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_3       
        //     2: new             Ljava/net/URL;
        //     5: dup            
        //     6: aload_1        
        //     7: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    10: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //    13: astore          9
        //    15: aload           9
        //    17: sipush          5000
        //    20: invokevirtual   java/net/URLConnection.setReadTimeout:(I)V
        //    23: aload           9
        //    25: sipush          10000
        //    28: invokevirtual   java/net/URLConnection.setConnectTimeout:(I)V
        //    31: new             Ljava/io/BufferedInputStream;
        //    34: dup            
        //    35: aload           9
        //    37: invokevirtual   java/net/URLConnection.getInputStream:()Ljava/io/InputStream;
        //    40: sipush          30720
        //    43: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;I)V
        //    46: astore          5
        //    48: new             Ljava/io/FileOutputStream;
        //    51: dup            
        //    52: aload_2        
        //    53: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    56: astore          7
        //    58: aload           5
        //    60: aload           7
        //    62: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;Ljava/io/OutputStream;)J
        //    65: pop2           
        //    66: aload           7
        //    68: invokestatic    org/a/a/a/d.a:(Ljava/io/OutputStream;)V
        //    71: aload           5
        //    73: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;)V
        //    76: return         
        //    77: astore          6
        //    79: aconst_null    
        //    80: astore          7
        //    82: aload           6
        //    84: invokestatic    com/ogqcorp/bgh/system/l.c:(Ljava/lang/Throwable;)I
        //    87: pop            
        //    88: aload           7
        //    90: invokestatic    org/a/a/a/d.a:(Ljava/io/OutputStream;)V
        //    93: aload_3        
        //    94: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;)V
        //    97: return         
        //    98: astore          4
        //   100: aconst_null    
        //   101: astore          5
        //   103: aload_3        
        //   104: invokestatic    org/a/a/a/d.a:(Ljava/io/OutputStream;)V
        //   107: aload           5
        //   109: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;)V
        //   112: aload           4
        //   114: athrow         
        //   115: astore          4
        //   117: aconst_null    
        //   118: astore_3       
        //   119: goto            103
        //   122: astore          4
        //   124: aload           7
        //   126: astore_3       
        //   127: goto            103
        //   130: astore          4
        //   132: aload_3        
        //   133: astore          5
        //   135: aload           7
        //   137: astore_3       
        //   138: goto            103
        //   141: astore          6
        //   143: aload           5
        //   145: astore_3       
        //   146: aconst_null    
        //   147: astore          7
        //   149: goto            82
        //   152: astore          6
        //   154: aload           5
        //   156: astore_3       
        //   157: goto            82
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      48     77     82     Ljava/lang/Exception;
        //  2      48     98     103    Any
        //  48     58     141    152    Ljava/lang/Exception;
        //  48     58     115    122    Any
        //  58     66     152    160    Ljava/lang/Exception;
        //  58     66     122    130    Any
        //  82     88     130    141    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 79, Size: 79
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
    
    public static void b(final Context context) {
        ((AlarmManager)context.getSystemService("alarm")).cancel(c(context));
    }
    
    private static PendingIntent c(final Context context) {
        return PendingIntent.getBroadcast(context, 0, new Intent("com.ogqcorp.bgh.action.NOTIFICATION"), 0);
    }
    
    private Intent d(final Context context) {
        final Intent addCategory = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
        addCategory.setFlags(270532608);
        addCategory.setComponent(new ComponentName(context, (Class)SplashActivity.class));
        return addCategory;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        final int a = v.a().a(context);
        if (a == 0) {
            return;
        }
        new AsyncTask<Object, Object, Object>() {
            protected Object doInBackground(final Object... array) {
                NotificationReceiver.this.a(context, a);
                return null;
            }
        }.execute(new Object[0]);
    }
}
