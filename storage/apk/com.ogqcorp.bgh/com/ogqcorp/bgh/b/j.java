// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.b;

import android.content.DialogInterface;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import android.content.DialogInterface$OnClickListener;
import android.content.Context;
import android.app.AlertDialog$Builder;
import android.view.ViewGroup;
import android.app.Dialog;
import android.os.Bundle;
import java.net.MalformedURLException;
import java.net.URL;
import com.ogqcorp.bgh.system.l;
import com.ogqcorp.commons.u;
import java.io.File;
import android.support.v4.app.FragmentManager;
import java.io.RandomAccessFile;
import java.io.InputStream;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockDialogFragment;
import com.ogqcorp.bgh.system.ac;
import android.os.AsyncTask;

abstract class j extends AsyncTask<Object, Long, Exception>
{
    final /* synthetic */ i e;
    
    private j(final i e) {
        this.e = e;
    }
    
    protected Exception a(final Object... p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_2       
        //     2: aload_1        
        //     3: iconst_0       
        //     4: aaload         
        //     5: checkcast       Ljava/net/URL;
        //     8: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //    11: checkcast       Ljava/net/HttpURLConnection;
        //    14: astore          12
        //    16: aload           12
        //    18: sipush          5000
        //    21: invokevirtual   java/net/HttpURLConnection.setReadTimeout:(I)V
        //    24: aload           12
        //    26: sipush          10000
        //    29: invokevirtual   java/net/HttpURLConnection.setConnectTimeout:(I)V
        //    32: aload_1        
        //    33: iconst_1       
        //    34: aaload         
        //    35: checkcast       Ljava/io/File;
        //    38: astore          13
        //    40: aload_0        
        //    41: getfield        com/ogqcorp/bgh/b/j.e:Lcom/ogqcorp/bgh/b/i;
        //    44: aload           13
        //    46: invokevirtual   java/io/File.length:()J
        //    49: invokestatic    com/ogqcorp/bgh/b/i.a:(Lcom/ogqcorp/bgh/b/i;J)J
        //    52: pop2           
        //    53: aload           12
        //    55: ldc             "Range"
        //    57: new             Ljava/lang/StringBuilder;
        //    60: dup            
        //    61: invokespecial   java/lang/StringBuilder.<init>:()V
        //    64: ldc             "bytes="
        //    66: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    69: aload_0        
        //    70: getfield        com/ogqcorp/bgh/b/j.e:Lcom/ogqcorp/bgh/b/i;
        //    73: invokestatic    com/ogqcorp/bgh/b/i.a:(Lcom/ogqcorp/bgh/b/i;)J
        //    76: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //    79: ldc             "-"
        //    81: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    84: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    87: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //    90: aload_0        
        //    91: getfield        com/ogqcorp/bgh/b/j.e:Lcom/ogqcorp/bgh/b/i;
        //    94: aload_0        
        //    95: getfield        com/ogqcorp/bgh/b/j.e:Lcom/ogqcorp/bgh/b/i;
        //    98: invokestatic    com/ogqcorp/bgh/b/i.a:(Lcom/ogqcorp/bgh/b/i;)J
        //   101: aload           12
        //   103: invokevirtual   java/net/HttpURLConnection.getContentLength:()I
        //   106: i2l            
        //   107: ladd           
        //   108: invokestatic    com/ogqcorp/bgh/b/i.b:(Lcom/ogqcorp/bgh/b/i;J)J
        //   111: pop2           
        //   112: new             Ljava/io/BufferedInputStream;
        //   115: dup            
        //   116: aload           12
        //   118: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //   121: sipush          30720
        //   124: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;I)V
        //   127: astore          4
        //   129: new             Ljava/io/RandomAccessFile;
        //   132: dup            
        //   133: aload           13
        //   135: ldc             "rw"
        //   137: invokespecial   java/io/RandomAccessFile.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   140: astore          18
        //   142: aload           18
        //   144: aload_0        
        //   145: getfield        com/ogqcorp/bgh/b/j.e:Lcom/ogqcorp/bgh/b/i;
        //   148: invokestatic    com/ogqcorp/bgh/b/i.a:(Lcom/ogqcorp/bgh/b/i;)J
        //   151: invokevirtual   java/io/RandomAccessFile.seek:(J)V
        //   154: aload_0        
        //   155: aload_0        
        //   156: getfield        com/ogqcorp/bgh/b/j.e:Lcom/ogqcorp/bgh/b/i;
        //   159: invokestatic    com/ogqcorp/bgh/b/i.b:(Lcom/ogqcorp/bgh/b/i;)J
        //   162: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   165: aload_0        
        //   166: getfield        com/ogqcorp/bgh/b/j.e:Lcom/ogqcorp/bgh/b/i;
        //   169: invokestatic    com/ogqcorp/bgh/b/i.a:(Lcom/ogqcorp/bgh/b/i;)J
        //   172: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   175: invokevirtual   com/ogqcorp/bgh/b/j.a:(Ljava/lang/Long;Ljava/lang/Long;)V
        //   178: aload_0        
        //   179: getfield        com/ogqcorp/bgh/b/j.e:Lcom/ogqcorp/bgh/b/i;
        //   182: aload           4
        //   184: aload           18
        //   186: invokestatic    com/ogqcorp/bgh/b/i.a:(Lcom/ogqcorp/bgh/b/i;Ljava/io/InputStream;Ljava/io/RandomAccessFile;)Z
        //   189: ifne            224
        //   192: new             Ljava/lang/InterruptedException;
        //   195: dup            
        //   196: invokespecial   java/lang/InterruptedException.<init>:()V
        //   199: astore          7
        //   201: aload           18
        //   203: ifnull          211
        //   206: aload           18
        //   208: invokevirtual   java/io/RandomAccessFile.close:()V
        //   211: aload           4
        //   213: ifnull          221
        //   216: aload           4
        //   218: invokevirtual   java/io/InputStream.close:()V
        //   221: aload           7
        //   223: areturn        
        //   224: aload           18
        //   226: ifnull          234
        //   229: aload           18
        //   231: invokevirtual   java/io/RandomAccessFile.close:()V
        //   234: aload           4
        //   236: ifnull          244
        //   239: aload           4
        //   241: invokevirtual   java/io/InputStream.close:()V
        //   244: aconst_null    
        //   245: areturn        
        //   246: astore          7
        //   248: aconst_null    
        //   249: astore          8
        //   251: aload           7
        //   253: invokestatic    com/ogqcorp/bgh/system/l.b:(Ljava/lang/Throwable;)I
        //   256: pop            
        //   257: aload_2        
        //   258: ifnull          265
        //   261: aload_2        
        //   262: invokevirtual   java/io/RandomAccessFile.close:()V
        //   265: aload           8
        //   267: ifnull          221
        //   270: aload           8
        //   272: invokevirtual   java/io/InputStream.close:()V
        //   275: aload           7
        //   277: areturn        
        //   278: astore          10
        //   280: aload           7
        //   282: areturn        
        //   283: astore_3       
        //   284: aconst_null    
        //   285: astore          4
        //   287: aload_2        
        //   288: ifnull          295
        //   291: aload_2        
        //   292: invokevirtual   java/io/RandomAccessFile.close:()V
        //   295: aload           4
        //   297: ifnull          305
        //   300: aload           4
        //   302: invokevirtual   java/io/InputStream.close:()V
        //   305: aload_3        
        //   306: athrow         
        //   307: astore          20
        //   309: goto            211
        //   312: astore          19
        //   314: aload           7
        //   316: areturn        
        //   317: astore          22
        //   319: goto            234
        //   322: astore          21
        //   324: goto            244
        //   327: astore          11
        //   329: goto            265
        //   332: astore          6
        //   334: goto            295
        //   337: astore          5
        //   339: goto            305
        //   342: astore_3       
        //   343: aconst_null    
        //   344: astore_2       
        //   345: goto            287
        //   348: astore_3       
        //   349: aload           18
        //   351: astore_2       
        //   352: goto            287
        //   355: astore_3       
        //   356: aload           8
        //   358: astore          4
        //   360: goto            287
        //   363: astore          7
        //   365: aload           4
        //   367: astore          8
        //   369: aconst_null    
        //   370: astore_2       
        //   371: goto            251
        //   374: astore          7
        //   376: aload           18
        //   378: astore_2       
        //   379: aload           4
        //   381: astore          8
        //   383: goto            251
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      129    246    251    Ljava/lang/Exception;
        //  2      129    283    287    Any
        //  129    142    363    374    Ljava/lang/Exception;
        //  129    142    342    348    Any
        //  142    201    374    386    Ljava/lang/Exception;
        //  142    201    348    355    Any
        //  206    211    307    312    Ljava/lang/Exception;
        //  216    221    312    317    Ljava/lang/Exception;
        //  229    234    317    322    Ljava/lang/Exception;
        //  239    244    322    327    Ljava/lang/Exception;
        //  251    257    355    363    Any
        //  261    265    327    332    Ljava/lang/Exception;
        //  270    275    278    283    Ljava/lang/Exception;
        //  291    295    332    337    Ljava/lang/Exception;
        //  300    305    337    342    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 181, Size: 181
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3419)
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
    
    public void a(final Long n, final Long n2) {
        this.publishProgress((Object[])new Long[] { n, n2 });
    }
    
    protected void a(final Long... array) {
        if (this.e.getActivity() == null) {
            return;
        }
        final int n = (int)Math.round(array[0] / 1024.0);
        final int n2 = (int)Math.round(array[1] / 1024.0);
        this.e.c.setMax(n);
        this.e.c.setProgress(n2);
        this.e.d.setText((CharSequence)this.e.getString(2131427436, n2 * 100 / n, ac.a((Object)n), ac.a((Object)n2)));
    }
}
