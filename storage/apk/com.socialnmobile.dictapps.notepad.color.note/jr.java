import java.util.Comparator;
import java.util.Collection;
import android.os.Build$VERSION;
import java.util.ArrayList;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import com.socialnmobile.colornote.data.NoteProvider;
import java.util.List;
import java.util.Collections;
import org.json.JSONException;
import com.socialnmobile.colornote.ColorNote;
import java.util.Iterator;
import java.util.Arrays;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.io.File;
import org.json.JSONObject;
import android.content.ContentValues;
import android.os.Environment;
import java.io.IOException;
import java.io.DataInputStream;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class jr
{
    public Context a;
    private jz b;
    private jz c;
    
    public jr(final Context a) {
        this.a = a;
    }
    
    private static int a(final int n, final DataInputStream dataInputStream) {
        final int int1 = dataInputStream.readInt();
        if (dataInputStream.readInt() != 4 || n != int1) {
            throw new IOException();
        }
        return dataInputStream.readInt();
    }
    
    public static String a() {
        return String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()) + "/data/colornote/backup/";
    }
    
    private static void a(final int p0, final String p1, final hj p2, final kj p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_3        
        //     1: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //     4: invokevirtual   android/database/sqlite/SQLiteDatabase.beginTransaction:()V
        //     7: new             Ljava/io/DataInputStream;
        //    10: dup            
        //    11: new             Ljava/io/BufferedInputStream;
        //    14: dup            
        //    15: new             Ljava/io/FileInputStream;
        //    18: dup            
        //    19: aload_1        
        //    20: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
        //    23: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //    26: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    29: astore          5
        //    31: aload           5
        //    33: invokevirtual   java/io/DataInputStream.readInt:()I
        //    36: iconst_1       
        //    37: if_icmpeq       72
        //    40: new             Ljava/io/IOException;
        //    43: dup            
        //    44: ldc             "Invalid Data Type : AccountTable"
        //    46: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    49: athrow         
        //    50: astore          4
        //    52: aload_3        
        //    53: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //    56: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //    59: aload           5
        //    61: ifnull          69
        //    64: aload           5
        //    66: invokevirtual   java/io/DataInputStream.close:()V
        //    69: aload           4
        //    71: athrow         
        //    72: aload           5
        //    74: invokevirtual   java/io/DataInputStream.readInt:()I
        //    77: istore          7
        //    79: iconst_0       
        //    80: istore          8
        //    82: iload           8
        //    84: iload           7
        //    86: if_icmplt       108
        //    89: aload           5
        //    91: invokevirtual   java/io/DataInputStream.readInt:()I
        //    94: iconst_2       
        //    95: if_icmpeq       226
        //    98: new             Ljava/io/IOException;
        //   101: dup            
        //   102: ldc             "Invalid Data Type : NoteTable"
        //   104: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   107: athrow         
        //   108: iload_0        
        //   109: iconst_4       
        //   110: if_icmpne       176
        //   113: aload           5
        //   115: invokevirtual   java/io/DataInputStream.readUTF:()Ljava/lang/String;
        //   118: astore          24
        //   120: new             Lorg/json/JSONObject;
        //   123: dup            
        //   124: aload           24
        //   126: invokespecial   org/json/JSONObject.<init>:(Ljava/lang/String;)V
        //   129: astore          25
        //   131: new             Landroid/content/ContentValues;
        //   134: dup            
        //   135: invokespecial   android/content/ContentValues.<init>:()V
        //   138: astore          26
        //   140: getstatic       com/socialnmobile/colornote/sync/AccountColumns.COLUMNS:[Lacb;
        //   143: astore          27
        //   145: aload           27
        //   147: arraylength    
        //   148: istore          28
        //   150: iconst_0       
        //   151: istore          29
        //   153: iload           29
        //   155: iload           28
        //   157: if_icmplt       208
        //   160: aload_3        
        //   161: ldc             "SyncAccount"
        //   163: aconst_null    
        //   164: aload           26
        //   166: invokevirtual   kj.a:(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
        //   169: pop2           
        //   170: iinc            8, 1
        //   173: goto            82
        //   176: aload           5
        //   178: invokevirtual   java/io/DataInputStream.readInt:()I
        //   181: newarray        B
        //   183: astore          32
        //   185: aload           5
        //   187: aload           32
        //   189: invokevirtual   java/io/DataInputStream.readFully:([B)V
        //   192: new             Ljava/lang/String;
        //   195: dup            
        //   196: aload           32
        //   198: ldc             "UTF-8"
        //   200: invokespecial   java/lang/String.<init>:([BLjava/lang/String;)V
        //   203: astore          24
        //   205: goto            120
        //   208: aload           27
        //   210: iload           29
        //   212: aaload         
        //   213: aload           26
        //   215: aload           25
        //   217: invokestatic    jr.a:(Lacb;Landroid/content/ContentValues;Lorg/json/JSONObject;)V
        //   220: iinc            29, 1
        //   223: goto            153
        //   226: aload           5
        //   228: invokevirtual   java/io/DataInputStream.readInt:()I
        //   231: istore          9
        //   233: aload_2        
        //   234: ifnull          490
        //   237: aload_2        
        //   238: iload           9
        //   240: invokeinterface hj.a:(I)V
        //   245: goto            490
        //   248: iload           10
        //   250: iload           9
        //   252: if_icmplt       294
        //   255: aload_2        
        //   256: ifnull          274
        //   259: iload           9
        //   261: ifle            274
        //   264: aload_2        
        //   265: iload           9
        //   267: iconst_1       
        //   268: isub           
        //   269: invokeinterface hj.b:(I)V
        //   274: aload_3        
        //   275: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //   278: invokevirtual   android/database/sqlite/SQLiteDatabase.setTransactionSuccessful:()V
        //   281: aload_3        
        //   282: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //   285: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //   288: aload           5
        //   290: invokevirtual   java/io/DataInputStream.close:()V
        //   293: return         
        //   294: iload_0        
        //   295: iconst_4       
        //   296: if_icmpne       406
        //   299: aload           5
        //   301: invokevirtual   java/io/DataInputStream.readUTF:()Ljava/lang/String;
        //   304: astore          12
        //   306: new             Lorg/json/JSONObject;
        //   309: dup            
        //   310: aload           12
        //   312: invokespecial   org/json/JSONObject.<init>:(Ljava/lang/String;)V
        //   315: astore          13
        //   317: new             Landroid/content/ContentValues;
        //   320: dup            
        //   321: invokespecial   android/content/ContentValues.<init>:()V
        //   324: astore          14
        //   326: getstatic       com/socialnmobile/colornote/data/NoteColumns.a:[Lacb;
        //   329: astore          15
        //   331: aload           15
        //   333: arraylength    
        //   334: istore          16
        //   336: iconst_0       
        //   337: istore          17
        //   339: iload           17
        //   341: iload           16
        //   343: if_icmplt       438
        //   346: getstatic       com/socialnmobile/colornote/data/NoteColumns.b:[Lacb;
        //   349: astore          18
        //   351: aload           18
        //   353: arraylength    
        //   354: istore          19
        //   356: iconst_0       
        //   357: istore          20
        //   359: iload           20
        //   361: iload           19
        //   363: if_icmplt       456
        //   366: aload           14
        //   368: ldc             "_id"
        //   370: invokevirtual   android/content/ContentValues.remove:(Ljava/lang/String;)V
        //   373: aload_3        
        //   374: ldc             "notes"
        //   376: aconst_null    
        //   377: aload           14
        //   379: invokevirtual   kj.a:(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
        //   382: pop2           
        //   383: iload           10
        //   385: bipush          32
        //   387: irem           
        //   388: ifne            496
        //   391: aload_2        
        //   392: ifnull          496
        //   395: aload_2        
        //   396: iload           10
        //   398: invokeinterface hj.b:(I)V
        //   403: goto            496
        //   406: aload           5
        //   408: invokevirtual   java/io/DataInputStream.readInt:()I
        //   411: newarray        B
        //   413: astore          11
        //   415: aload           5
        //   417: aload           11
        //   419: invokevirtual   java/io/DataInputStream.readFully:([B)V
        //   422: new             Ljava/lang/String;
        //   425: dup            
        //   426: aload           11
        //   428: ldc             "UTF-8"
        //   430: invokespecial   java/lang/String.<init>:([BLjava/lang/String;)V
        //   433: astore          12
        //   435: goto            306
        //   438: aload           15
        //   440: iload           17
        //   442: aaload         
        //   443: aload           14
        //   445: aload           13
        //   447: invokestatic    jr.a:(Lacb;Landroid/content/ContentValues;Lorg/json/JSONObject;)V
        //   450: iinc            17, 1
        //   453: goto            339
        //   456: aload           18
        //   458: iload           20
        //   460: aaload         
        //   461: aload           14
        //   463: aload           13
        //   465: invokestatic    jr.a:(Lacb;Landroid/content/ContentValues;Lorg/json/JSONObject;)V
        //   468: iinc            20, 1
        //   471: goto            359
        //   474: astore          6
        //   476: goto            69
        //   479: astore          23
        //   481: return         
        //   482: astore          4
        //   484: aconst_null    
        //   485: astore          5
        //   487: goto            52
        //   490: iconst_0       
        //   491: istore          10
        //   493: goto            248
        //   496: iinc            10, 1
        //   499: goto            248
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      31     482    490    Any
        //  31     50     50     52     Any
        //  64     69     474    479    Ljava/io/IOException;
        //  72     79     50     52     Any
        //  89     108    50     52     Any
        //  113    120    50     52     Any
        //  120    150    50     52     Any
        //  160    170    50     52     Any
        //  176    205    50     52     Any
        //  208    220    50     52     Any
        //  226    233    50     52     Any
        //  237    245    50     52     Any
        //  264    274    50     52     Any
        //  274    281    50     52     Any
        //  288    293    479    482    Ljava/io/IOException;
        //  299    306    50     52     Any
        //  306    336    50     52     Any
        //  346    356    50     52     Any
        //  366    383    50     52     Any
        //  395    403    50     52     Any
        //  406    435    50     52     Any
        //  438    450    50     52     Any
        //  456    468    50     52     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0294:
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
    
    private static void a(final acb acb, final ContentValues contentValues, final JSONObject jsonObject) {
        if (jsonObject.has(acb.a())) {
            if (acb instanceof acr) {
                acb.a(contentValues, jsonObject.getInt(acb.a()));
            }
            else {
                if (acb instanceof acp) {
                    acb.a(contentValues, jsonObject.getDouble(acb.a()));
                    return;
                }
                if (acb instanceof act) {
                    acb.a(contentValues, jsonObject.getLong(acb.a()));
                    return;
                }
                acb.a(contentValues, jsonObject.get(acb.a()));
            }
        }
    }
    
    private static void a(final File parent) {
        final String[] list = parent.list();
        for (int n = 0; n < list.length && new File(parent, list[n]).delete(); ++n) {}
    }
    
    public static void a(final String s, final String s2) {
        new File(String.valueOf(s) + s2 + ".idx").delete();
        new File(String.valueOf(s) + s2 + ".dat").delete();
    }
    
    private void a(final HashMap hashMap, final String pathname) {
        final String[] list = new File(pathname).list(new ju(this));
        if (list != null) {
            final Iterator<String> iterator = Arrays.asList(list).iterator();
            while (iterator.hasNext()) {
                final jv c = c(pathname, iterator.next());
                if (c != null && c.a >= 0) {
                    if (!hashMap.containsKey(c.f)) {
                        hashMap.put(c.f, c);
                    }
                    else {
                        hashMap.get(c.f).g.add(c.e);
                    }
                }
            }
        }
    }
    
    private boolean a(final int n, int n2, final boolean b, final DataInputStream dataInputStream, final DataInputStream dataInputStream2, final hj hj) {
        if (n >= 2) {
            final String[] array = { null, dataInputStream.readUTF(), dataInputStream.readUTF(), dataInputStream.readUTF(), dataInputStream.readUTF(), dataInputStream.readUTF(), dataInputStream.readUTF(), dataInputStream.readUTF(), dataInputStream.readUTF(), dataInputStream.readUTF() };
            if (!b) {
                kr.a();
                jq.a(this.a, 0, 1, array[1]);
                jq.a(this.a, 0, 2, array[2]);
                jq.a(this.a, 0, 3, array[3]);
                jq.a(this.a, 0, 4, array[4]);
                jq.a(this.a, 0, 5, array[5]);
                jq.a(this.a, 0, 6, array[6]);
                jq.a(this.a, 0, 7, array[7]);
                jq.a(this.a, 0, 8, array[8]);
                jq.a(this.a, 0, 9, array[9]);
            }
        }
        if (b && n2 > 100) {
            n2 = 100;
        }
        if (hj != null) {
            hj.a(n2);
        }
        for (int i = 0; i < n2; ++i) {
            dataInputStream.readInt();
            dataInputStream.readInt();
            String c = "";
            long b2 = 0L;
            long b3 = 0L;
            long b4 = 0L;
            int a = a(1, dataInputStream2);
            int a2 = a(2, dataInputStream2);
            int a3 = a(3, dataInputStream2);
            final long b5 = b(4, dataInputStream2);
            final long b6 = b(5, dataInputStream2);
            final String c2 = this.c(6, dataInputStream2);
            final int a4 = a(7, dataInputStream2);
            final int a5 = a(8, dataInputStream2);
            final String c3 = this.c(9, dataInputStream2);
            if (n == 1) {
                if (a3 <= 5) {
                    ++a3;
                }
                if (a == 1) {
                    a = 16;
                }
                if (a2 == 1) {
                    a2 = 16;
                }
            }
            int a6 = 0;
            int a7 = 0;
            int a8 = 0;
            int a9 = 0;
            int a10 = 0;
            int a11 = 0;
            int a12 = 0;
            if (n >= 2) {
                a11 = a(10, dataInputStream2);
                a12 = a(11, dataInputStream2);
                c = this.c(12, dataInputStream2);
                a10 = a(13, dataInputStream2);
                a9 = a(14, dataInputStream2);
                b2 = b(15, dataInputStream2);
                b3 = b(16, dataInputStream2);
                b4 = b(17, dataInputStream2);
                a8 = a(18, dataInputStream2);
                a7 = a(19, dataInputStream2);
                a6 = a(20, dataInputStream2);
            }
            final ContentValues contentValues = new ContentValues();
            contentValues.put("folder_id", a11);
            contentValues.put("status", a);
            contentValues.put("type", a2);
            contentValues.put("color_index", a3);
            contentValues.put("created_date", b5);
            contentValues.put("modified_date", b6);
            contentValues.put("title", c2);
            contentValues.put("note_type", a4);
            contentValues.put("encrypted", a5);
            contentValues.put("note", c3);
            contentValues.put("active_state", a12);
            contentValues.put("note_ext", c);
            contentValues.put("importance", a10);
            contentValues.put("reminder_type", a9);
            contentValues.put("reminder_date", b2);
            contentValues.put("reminder_base", b3);
            contentValues.put("reminder_last", b4);
            contentValues.put("reminder_duration", a8);
            contentValues.put("reminder_option", a7);
            contentValues.put("reminder_repeat", a6);
            if (!b) {
                kg.a(this.a, contentValues);
            }
            if ((i & 0x3) == 0x0 && hj != null) {
                hj.b(i);
            }
        }
        if (!b) {
            ColorNote.g();
        }
        return true;
    }
    
    private boolean a(final int n, final String obj, final String s, final kj kj, final hj hj, final boolean b) {
        final String string = String.valueOf(this.f()) + s + ".dat.tmp";
        if (!this.c.b(String.valueOf(obj) + s + ".dat", string)) {
            b(string);
            return false;
        }
        if (b) {
            b(string);
            return true;
        }
        try {
            a(n, string, hj, kj);
            return true;
        }
        catch (JSONException ex) {
            ColorNote.a("restoreDB:JSON" + ex.getMessage());
            return false;
        }
        catch (IOException ex2) {
            ColorNote.a("restoreDB:IO" + ex2.getMessage());
            return false;
        }
        finally {
            b(string);
        }
    }
    
    public static final boolean a(final Context context) {
        final jr jr = new jr(context);
        jr.a(2);
        final boolean a = jr.a(2, kg.a(jr.a));
        for (final String obj : jr.a(false)) {
            final String[] list = new File(obj).list(new js(jr));
            if (list != null) {
                final List<String> list2 = Arrays.asList(list);
                Collections.sort((List<Comparable>)list2);
                if (list2.size() > 60) {
                    for (final String s : list2.subList(0, -60 + list2.size())) {
                        final String substring = s.substring(0, s.indexOf(".idx"));
                        new File(String.valueOf(obj) + substring + ".idx").delete();
                        new File(String.valueOf(obj) + substring + ".dat").delete();
                    }
                }
            }
        }
        return a;
    }
    
    private boolean a(final String obj, final String s, final String s2, final hj hj, final boolean b, final boolean b2) {
        final NoteProvider a = NoteProvider.a(this.a);
        final String string = String.valueOf(this.f()) + s + ".dat.tmp";
        final String string2 = String.valueOf(obj) + s + ".dat";
        if (hj != null) {
            hj.a(4);
        }
        if (!this.c.b(string2, string)) {
            return false;
        }
        if (hj != null) {
            hj.b(1);
        }
        if (b2) {
            b(string);
            return true;
        }
        if (b) {
            ki.c();
        }
        Label_0133: {
            if (!b) {
                break Label_0133;
            }
            try {
                NoteProvider.c();
                b(string, s2);
                if (hj != null) {
                    hj.b(2);
                }
                b(string);
                if (hj != null) {
                    hj.b(3);
                }
                if (b) {
                    a.b();
                }
                if (hj != null) {
                    hj.b(4);
                }
                return true;
            }
            catch (IOException ex) {
                return false;
            }
            finally {
                if (b) {
                    ki.d();
                }
            }
        }
    }
    
    private static boolean a(final String[] array, final String s) {
        int i = 1;
        if (array.length > i) {
            boolean b = i != 0;
        Label_0150_Outer:
            while (i < array.length) {
                while (true) {
                    try {
                        final File file = new File(array[i]);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        b(String.valueOf(array[0]) + s + ".dat", String.valueOf(array[i]) + s + ".dat");
                        b(String.valueOf(array[0]) + s + ".idx", String.valueOf(array[i]) + s + ".idx");
                        ++i;
                        continue Label_0150_Outer;
                    }
                    catch (IOException ex) {
                        ColorNote.a("Backup file copy failed : " + array[i]);
                        b = false;
                        continue;
                    }
                    break;
                }
                return i != 0;
            }
            return b;
        }
        return i != 0;
    }
    
    private static long b(final int n, final DataInputStream dataInputStream) {
        final int int1 = dataInputStream.readInt();
        if (dataInputStream.readInt() != 8 || n != int1) {
            throw new IOException();
        }
        return dataInputStream.readLong();
    }
    
    private static void b(final String pathname) {
        new File(pathname).delete();
    }
    
    private static void b(final String name, final String name2) {
        final FileChannel channel = new FileInputStream(name).getChannel();
        final FileChannel channel2 = new FileOutputStream(name2).getChannel();
        try {
            channel.transferTo(0L, channel.size(), channel2);
        }
        catch (IOException ex) {
            throw ex;
        }
        finally {
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
        }
    }
    
    public static String c() {
        final String a = jl.a();
        if (a == null) {
            return null;
        }
        return String.valueOf(a) + "/data/colornote/backup/";
    }
    
    private String c(final int n, final DataInputStream dataInputStream) {
        if (n != dataInputStream.readInt()) {
            throw new IOException();
        }
        final byte[] b = new byte[dataInputStream.readInt()];
        dataInputStream.read(b);
        return this.c.a(b);
    }
    
    private static jv c(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/io/DataInputStream;
        //     3: dup            
        //     4: new             Ljava/io/BufferedInputStream;
        //     7: dup            
        //     8: new             Ljava/io/FileInputStream;
        //    11: dup            
        //    12: new             Ljava/lang/StringBuilder;
        //    15: dup            
        //    16: aload_0        
        //    17: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    20: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    23: aload_1        
        //    24: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    27: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    30: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
        //    33: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //    36: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    39: astore_2       
        //    40: iconst_4       
        //    41: newarray        C
        //    43: astore          8
        //    45: aload           8
        //    47: iconst_0       
        //    48: aload_2        
        //    49: invokevirtual   java/io/DataInputStream.readChar:()C
        //    52: castore        
        //    53: aload           8
        //    55: iconst_1       
        //    56: aload_2        
        //    57: invokevirtual   java/io/DataInputStream.readChar:()C
        //    60: castore        
        //    61: aload           8
        //    63: iconst_2       
        //    64: aload_2        
        //    65: invokevirtual   java/io/DataInputStream.readChar:()C
        //    68: castore        
        //    69: aload           8
        //    71: iconst_3       
        //    72: aload_2        
        //    73: invokevirtual   java/io/DataInputStream.readChar:()C
        //    76: castore        
        //    77: new             Ljava/lang/String;
        //    80: dup            
        //    81: aload           8
        //    83: invokespecial   java/lang/String.<init>:([C)V
        //    86: ldc_w           "NOTE"
        //    89: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    92: istore          9
        //    94: iload           9
        //    96: ifne            105
        //    99: aload_2        
        //   100: invokevirtual   java/io/DataInputStream.close:()V
        //   103: aconst_null    
        //   104: areturn        
        //   105: new             Ljv;
        //   108: dup            
        //   109: aload_2        
        //   110: invokevirtual   java/io/DataInputStream.readInt:()I
        //   113: aload_2        
        //   114: invokevirtual   java/io/DataInputStream.readInt:()I
        //   117: aload_2        
        //   118: invokevirtual   java/io/DataInputStream.readLong:()J
        //   121: aload_2        
        //   122: invokevirtual   java/io/DataInputStream.readInt:()I
        //   125: aload_0        
        //   126: aload_1        
        //   127: iconst_0       
        //   128: aload_1        
        //   129: ldc             ".idx"
        //   131: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   134: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   137: invokespecial   jv.<init>:(IIJILjava/lang/String;Ljava/lang/String;)V
        //   140: astore          10
        //   142: aload_2        
        //   143: invokevirtual   java/io/DataInputStream.close:()V
        //   146: aload           10
        //   148: areturn        
        //   149: astore          11
        //   151: aload           10
        //   153: areturn        
        //   154: astore          14
        //   156: aconst_null    
        //   157: astore          4
        //   159: aload           4
        //   161: ifnull          169
        //   164: aload           4
        //   166: invokevirtual   java/io/DataInputStream.close:()V
        //   169: aconst_null    
        //   170: areturn        
        //   171: astore          13
        //   173: aconst_null    
        //   174: astore_2       
        //   175: aload           13
        //   177: astore          6
        //   179: aload_2        
        //   180: ifnull          187
        //   183: aload_2        
        //   184: invokevirtual   java/io/DataInputStream.close:()V
        //   187: aload           6
        //   189: athrow         
        //   190: astore          12
        //   192: goto            103
        //   195: astore          5
        //   197: goto            169
        //   200: astore          7
        //   202: goto            187
        //   205: astore          6
        //   207: goto            179
        //   210: astore_3       
        //   211: aload_2        
        //   212: astore          4
        //   214: goto            159
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      40     154    159    Ljava/io/IOException;
        //  0      40     171    179    Any
        //  40     94     210    217    Ljava/io/IOException;
        //  40     94     205    210    Any
        //  99     103    190    195    Ljava/io/IOException;
        //  105    142    210    217    Ljava/io/IOException;
        //  105    142    205    210    Any
        //  142    146    149    154    Ljava/io/IOException;
        //  164    169    195    200    Ljava/io/IOException;
        //  183    187    200    205    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 112, Size: 112
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
    
    private void c(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/io/DataOutputStream;
        //     3: dup            
        //     4: new             Ljava/io/BufferedOutputStream;
        //     7: dup            
        //     8: new             Ljava/io/FileOutputStream;
        //    11: dup            
        //    12: aload_1        
        //    13: invokespecial   java/io/FileOutputStream.<init>:(Ljava/lang/String;)V
        //    16: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    19: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    22: astore_2       
        //    23: aload_0        
        //    24: getfield        jr.a:Landroid/content/Context;
        //    27: invokestatic    com/socialnmobile/colornote/data/NoteProvider.b:(Landroid/content/Context;)Lki;
        //    30: invokevirtual   ki.f:()Lkj;
        //    33: ldc             "SyncAccount"
        //    35: aconst_null    
        //    36: aconst_null    
        //    37: aconst_null    
        //    38: aconst_null    
        //    39: invokevirtual   kj.a:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    42: astore          6
        //    44: aload_2        
        //    45: iconst_1       
        //    46: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //    49: aload_2        
        //    50: aload           6
        //    52: invokeinterface android/database/Cursor.getCount:()I
        //    57: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //    60: new             Ljava/util/ArrayList;
        //    63: dup            
        //    64: invokespecial   java/util/ArrayList.<init>:()V
        //    67: astore          7
        //    69: getstatic       com/socialnmobile/colornote/sync/AccountColumns.COLUMNS:[Lacb;
        //    72: astore          8
        //    74: aload           8
        //    76: arraylength    
        //    77: istore          9
        //    79: iconst_0       
        //    80: istore          10
        //    82: goto            473
        //    85: aload           6
        //    87: invokeinterface android/database/Cursor.moveToNext:()Z
        //    92: ifne            228
        //    95: aload           6
        //    97: invokeinterface android/database/Cursor.close:()V
        //   102: aload_0        
        //   103: getfield        jr.a:Landroid/content/Context;
        //   106: invokestatic    com/socialnmobile/colornote/data/NoteProvider.b:(Landroid/content/Context;)Lki;
        //   109: invokevirtual   ki.f:()Lkj;
        //   112: ldc             "notes"
        //   114: aconst_null    
        //   115: aconst_null    
        //   116: aconst_null    
        //   117: aconst_null    
        //   118: invokevirtual   kj.a:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   121: astore          16
        //   123: aload_2        
        //   124: iconst_2       
        //   125: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   128: aload_2        
        //   129: aload           16
        //   131: invokeinterface android/database/Cursor.getCount:()I
        //   136: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   139: new             Ljava/util/ArrayList;
        //   142: dup            
        //   143: invokespecial   java/util/ArrayList.<init>:()V
        //   146: astore          17
        //   148: getstatic       com/socialnmobile/colornote/data/NoteColumns.a:[Lacb;
        //   151: astore          18
        //   153: aload           18
        //   155: arraylength    
        //   156: istore          19
        //   158: iconst_0       
        //   159: istore          20
        //   161: iload           20
        //   163: iload           19
        //   165: if_icmplt       329
        //   168: getstatic       com/socialnmobile/colornote/data/NoteColumns.b:[Lacb;
        //   171: astore          21
        //   173: aload           21
        //   175: arraylength    
        //   176: istore          22
        //   178: iconst_0       
        //   179: istore          23
        //   181: goto            483
        //   184: aload           16
        //   186: invokeinterface android/database/Cursor.moveToNext:()Z
        //   191: ifne            373
        //   194: aload           16
        //   196: invokeinterface android/database/Cursor.close:()V
        //   201: aload_2        
        //   202: invokevirtual   java/io/DataOutputStream.close:()V
        //   205: return         
        //   206: aload           7
        //   208: aload           8
        //   210: iload           10
        //   212: aaload         
        //   213: aload           6
        //   215: invokevirtual   acb.a:(Landroid/database/Cursor;)Lacd;
        //   218: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //   221: pop            
        //   222: iinc            10, 1
        //   225: goto            473
        //   228: new             Lorg/json/JSONObject;
        //   231: dup            
        //   232: invokespecial   org/json/JSONObject.<init>:()V
        //   235: astore          11
        //   237: aload           7
        //   239: invokevirtual   java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //   242: astore          12
        //   244: aload           12
        //   246: invokeinterface java/util/Iterator.hasNext:()Z
        //   251: ifne            298
        //   254: aload           11
        //   256: invokevirtual   org/json/JSONObject.toString:()Ljava/lang/String;
        //   259: ldc             "UTF-8"
        //   261: invokevirtual   java/lang/String.getBytes:(Ljava/lang/String;)[B
        //   264: astore          15
        //   266: aload_2        
        //   267: aload           15
        //   269: arraylength    
        //   270: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   273: aload_2        
        //   274: aload           15
        //   276: invokevirtual   java/io/DataOutputStream.write:([B)V
        //   279: goto            85
        //   282: astore_3       
        //   283: aload_2        
        //   284: astore          4
        //   286: aload           4
        //   288: ifnull          296
        //   291: aload           4
        //   293: invokevirtual   java/io/DataOutputStream.close:()V
        //   296: aload_3        
        //   297: athrow         
        //   298: aload           12
        //   300: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   305: checkcast       Lacd;
        //   308: astore          13
        //   310: aload           11
        //   312: aload           13
        //   314: invokevirtual   acd.a:()Ljava/lang/String;
        //   317: aload           13
        //   319: invokevirtual   acd.c:()Ljava/lang/Object;
        //   322: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   325: pop            
        //   326: goto            244
        //   329: aload           17
        //   331: aload           18
        //   333: iload           20
        //   335: aaload         
        //   336: aload           16
        //   338: invokevirtual   acb.a:(Landroid/database/Cursor;)Lacd;
        //   341: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //   344: pop            
        //   345: iinc            20, 1
        //   348: goto            161
        //   351: aload           17
        //   353: aload           21
        //   355: iload           23
        //   357: aaload         
        //   358: aload           16
        //   360: invokevirtual   acb.a:(Landroid/database/Cursor;)Lacd;
        //   363: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //   366: pop            
        //   367: iinc            23, 1
        //   370: goto            483
        //   373: new             Lorg/json/JSONObject;
        //   376: dup            
        //   377: invokespecial   org/json/JSONObject.<init>:()V
        //   380: astore          24
        //   382: aload           17
        //   384: invokevirtual   java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //   387: astore          25
        //   389: aload           25
        //   391: invokeinterface java/util/Iterator.hasNext:()Z
        //   396: ifne            427
        //   399: aload           24
        //   401: invokevirtual   org/json/JSONObject.toString:()Ljava/lang/String;
        //   404: ldc             "UTF-8"
        //   406: invokevirtual   java/lang/String.getBytes:(Ljava/lang/String;)[B
        //   409: astore          28
        //   411: aload_2        
        //   412: aload           28
        //   414: arraylength    
        //   415: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   418: aload_2        
        //   419: aload           28
        //   421: invokevirtual   java/io/DataOutputStream.write:([B)V
        //   424: goto            184
        //   427: aload           25
        //   429: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   434: checkcast       Lacd;
        //   437: astore          26
        //   439: aload           24
        //   441: aload           26
        //   443: invokevirtual   acd.a:()Ljava/lang/String;
        //   446: aload           26
        //   448: invokevirtual   acd.c:()Ljava/lang/Object;
        //   451: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   454: pop            
        //   455: goto            389
        //   458: astore          5
        //   460: goto            296
        //   463: astore          29
        //   465: return         
        //   466: astore_3       
        //   467: aconst_null    
        //   468: astore          4
        //   470: goto            286
        //   473: iload           10
        //   475: iload           9
        //   477: if_icmplt       206
        //   480: goto            85
        //   483: iload           23
        //   485: iload           22
        //   487: if_icmplt       351
        //   490: goto            184
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      23     466    473    Any
        //  23     79     282    286    Any
        //  85     158    282    286    Any
        //  168    178    282    286    Any
        //  184    201    282    286    Any
        //  201    205    463    466    Ljava/io/IOException;
        //  206    222    282    286    Any
        //  228    244    282    286    Any
        //  244    279    282    286    Any
        //  291    296    458    463    Ljava/io/IOException;
        //  298    326    282    286    Any
        //  329    345    282    286    Any
        //  351    367    282    286    Any
        //  373    389    282    286    Any
        //  389    424    282    286    Any
        //  427    455    282    286    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0206:
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
    
    private String f() {
        final File externalCacheDir = this.a.getExternalCacheDir();
        if (externalCacheDir != null) {
            return externalCacheDir.getAbsolutePath();
        }
        return String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()) + "/data/colornote/temp/";
    }
    
    public final void a(final int n) {
        String s = null;
        Label_0077: {
            if (n == 2) {
                if (jq.a(this.a)) {
                    final Context a = this.a;
                    if (jp.a(a, "pref_secured_auto_backup", a.getResources().getBoolean(2131296265))) {
                        s = jq.b(this.a);
                        break Label_0077;
                    }
                }
                final Context a2 = this.a;
                final jz b = jz.b(30);
                b.a("0000");
                b.c(1);
                s = b.a();
            }
            else {
                s = jq.b(this.a);
            }
        }
        (this.b = jz.b(20)).b(s);
        this.b.c(1);
        (this.c = jz.b(20)).b(s);
        this.c.c(2);
    }
    
    public final void a(final String s) {
        (this.c = jz.b(20)).a(s);
        this.c.c(2);
    }
    
    public final boolean a(final int p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: invokestatic    java/lang/System.currentTimeMillis:()J
        //     3: lstore_3       
        //     4: lload_3        
        //     5: invokestatic    java/lang/String.valueOf:(J)Ljava/lang/String;
        //     8: astore          5
        //    10: iload_1        
        //    11: tableswitch {
        //                2: 293
        //                3: 319
        //          default: 32
        //        }
        //    32: aload_0        
        //    33: iconst_0       
        //    34: invokevirtual   jr.a:(Z)[Ljava/lang/String;
        //    37: astore          6
        //    39: aload           6
        //    41: arraylength    
        //    42: istore          7
        //    44: iconst_0       
        //    45: istore          8
        //    47: iload           8
        //    49: iload           7
        //    51: if_icmplt       345
        //    54: aload           6
        //    56: iconst_0       
        //    57: aaload         
        //    58: astore          11
        //    60: new             Ljava/lang/StringBuilder;
        //    63: dup            
        //    64: aload           11
        //    66: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    69: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    72: aload           5
        //    74: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    77: ldc_w           ".dat.tmp"
        //    80: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    83: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    86: astore          12
        //    88: new             Ljava/lang/StringBuilder;
        //    91: dup            
        //    92: aload           11
        //    94: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    97: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   100: aload           5
        //   102: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   105: ldc             ".dat"
        //   107: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   110: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   113: astore          13
        //   115: new             Ljava/lang/StringBuilder;
        //   118: dup            
        //   119: aload           11
        //   121: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   124: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   127: aload           5
        //   129: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   132: ldc             ".idx"
        //   134: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   137: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   140: astore          14
        //   142: invokestatic    ki.c:()V
        //   145: new             Ljava/io/File;
        //   148: dup            
        //   149: aload           11
        //   151: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   154: astore          15
        //   156: aload           15
        //   158: invokevirtual   java/io/File.exists:()Z
        //   161: ifne            170
        //   164: aload           15
        //   166: invokevirtual   java/io/File.mkdirs:()Z
        //   169: pop            
        //   170: new             Ljava/io/DataOutputStream;
        //   173: dup            
        //   174: new             Ljava/io/BufferedOutputStream;
        //   177: dup            
        //   178: new             Ljava/io/FileOutputStream;
        //   181: dup            
        //   182: aload           14
        //   184: invokespecial   java/io/FileOutputStream.<init>:(Ljava/lang/String;)V
        //   187: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
        //   190: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //   193: astore          19
        //   195: aload           19
        //   197: bipush          78
        //   199: invokevirtual   java/io/DataOutputStream.writeChar:(I)V
        //   202: aload           19
        //   204: bipush          79
        //   206: invokevirtual   java/io/DataOutputStream.writeChar:(I)V
        //   209: aload           19
        //   211: bipush          84
        //   213: invokevirtual   java/io/DataOutputStream.writeChar:(I)V
        //   216: aload           19
        //   218: bipush          69
        //   220: invokevirtual   java/io/DataOutputStream.writeChar:(I)V
        //   223: aload           19
        //   225: bipush          6
        //   227: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   230: aload           19
        //   232: iload_1        
        //   233: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   236: aload           19
        //   238: lload_3        
        //   239: invokevirtual   java/io/DataOutputStream.writeLong:(J)V
        //   242: aload           19
        //   244: iload_2        
        //   245: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   248: aload           19
        //   250: invokevirtual   java/io/DataOutputStream.close:()V
        //   253: aload_0        
        //   254: aload           12
        //   256: invokespecial   jr.c:(Ljava/lang/String;)V
        //   259: invokestatic    ki.d:()V
        //   262: aload_0        
        //   263: getfield        jr.b:Ljz;
        //   266: aload           12
        //   268: aload           13
        //   270: invokevirtual   jz.a:(Ljava/lang/String;Ljava/lang/String;)Z
        //   273: ifne            446
        //   276: aload           12
        //   278: invokestatic    jr.b:(Ljava/lang/String;)V
        //   281: aload           13
        //   283: invokestatic    jr.b:(Ljava/lang/String;)V
        //   286: aload           14
        //   288: invokestatic    jr.b:(Ljava/lang/String;)V
        //   291: iconst_0       
        //   292: ireturn        
        //   293: new             Ljava/lang/StringBuilder;
        //   296: dup            
        //   297: aload           5
        //   299: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   302: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   305: ldc_w           "-MANUAL"
        //   308: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   311: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   314: astore          5
        //   316: goto            32
        //   319: new             Ljava/lang/StringBuilder;
        //   322: dup            
        //   323: aload           5
        //   325: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   328: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   331: ldc_w           "-AUTO"
        //   334: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   337: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   340: astore          5
        //   342: goto            32
        //   345: aload           6
        //   347: iload           8
        //   349: aaload         
        //   350: astore          9
        //   352: new             Ljava/lang/StringBuilder;
        //   355: dup            
        //   356: ldc_w           "backup dir : "
        //   359: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   362: aload           9
        //   364: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   367: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   370: pop            
        //   371: invokestatic    com/socialnmobile/colornote/ColorNote.a:()V
        //   374: iinc            8, 1
        //   377: goto            47
        //   380: astore          20
        //   382: aconst_null    
        //   383: astore          21
        //   385: aload           21
        //   387: ifnull          395
        //   390: aload           21
        //   392: invokevirtual   java/io/DataOutputStream.close:()V
        //   395: aload           20
        //   397: athrow         
        //   398: astore          18
        //   400: aload           12
        //   402: invokestatic    jr.b:(Ljava/lang/String;)V
        //   405: aload           14
        //   407: invokestatic    jr.b:(Ljava/lang/String;)V
        //   410: invokestatic    com/socialnmobile/colornote/ColorNote.d:()V
        //   413: invokestatic    ki.d:()V
        //   416: iconst_0       
        //   417: ireturn        
        //   418: astore          17
        //   420: aload           12
        //   422: invokestatic    jr.b:(Ljava/lang/String;)V
        //   425: aload           14
        //   427: invokestatic    jr.b:(Ljava/lang/String;)V
        //   430: invokestatic    com/socialnmobile/colornote/ColorNote.d:()V
        //   433: invokestatic    ki.d:()V
        //   436: iconst_0       
        //   437: ireturn        
        //   438: astore          16
        //   440: invokestatic    ki.d:()V
        //   443: aload           16
        //   445: athrow         
        //   446: aload           12
        //   448: invokestatic    jr.b:(Ljava/lang/String;)V
        //   451: aload_0        
        //   452: aload           11
        //   454: aload           5
        //   456: aconst_null    
        //   457: invokevirtual   jr.a:(Ljava/lang/String;Ljava/lang/String;Lhj;)Z
        //   460: ifne            480
        //   463: aload           13
        //   465: invokestatic    jr.b:(Ljava/lang/String;)V
        //   468: aload           12
        //   470: invokestatic    jr.b:(Ljava/lang/String;)V
        //   473: aload           14
        //   475: invokestatic    jr.b:(Ljava/lang/String;)V
        //   478: iconst_0       
        //   479: ireturn        
        //   480: aload           6
        //   482: arraylength    
        //   483: iconst_1       
        //   484: if_icmple       499
        //   487: aload           6
        //   489: aload           5
        //   491: invokestatic    jr.a:([Ljava/lang/String;Ljava/lang/String;)Z
        //   494: ifne            499
        //   497: iconst_0       
        //   498: ireturn        
        //   499: iconst_1       
        //   500: ireturn        
        //   501: astore          22
        //   503: goto            395
        //   506: astore          23
        //   508: goto            253
        //   511: astore          20
        //   513: aload           19
        //   515: astore          21
        //   517: goto            385
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                    
        //  -----  -----  -----  -----  ------------------------
        //  145    170    398    418    Lorg/json/JSONException;
        //  145    170    418    438    Ljava/io/IOException;
        //  145    170    438    446    Any
        //  170    195    380    385    Any
        //  195    248    511    520    Any
        //  248    253    506    511    Ljava/io/IOException;
        //  248    253    398    418    Lorg/json/JSONException;
        //  248    253    438    446    Any
        //  253    259    398    418    Lorg/json/JSONException;
        //  253    259    418    438    Ljava/io/IOException;
        //  253    259    438    446    Any
        //  390    395    501    506    Ljava/io/IOException;
        //  390    395    398    418    Lorg/json/JSONException;
        //  390    395    438    446    Any
        //  395    398    398    418    Lorg/json/JSONException;
        //  395    398    418    438    Ljava/io/IOException;
        //  395    398    438    446    Any
        //  400    413    438    446    Any
        //  420    433    438    446    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0253:
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
    
    public final boolean a(final String p0, final String p1, final hj p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore          4
        //     3: new             Ljava/io/DataInputStream;
        //     6: dup            
        //     7: new             Ljava/io/BufferedInputStream;
        //    10: dup            
        //    11: new             Ljava/io/FileInputStream;
        //    14: dup            
        //    15: new             Ljava/lang/StringBuilder;
        //    18: dup            
        //    19: aload_1        
        //    20: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    23: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    26: aload_2        
        //    27: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    30: ldc             ".idx"
        //    32: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    35: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    38: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
        //    41: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //    44: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    47: astore          5
        //    49: iconst_4       
        //    50: newarray        C
        //    52: astore          10
        //    54: aload           10
        //    56: iconst_0       
        //    57: aload           5
        //    59: invokevirtual   java/io/DataInputStream.readChar:()C
        //    62: castore        
        //    63: aload           10
        //    65: iconst_1       
        //    66: aload           5
        //    68: invokevirtual   java/io/DataInputStream.readChar:()C
        //    71: castore        
        //    72: aload           10
        //    74: iconst_2       
        //    75: aload           5
        //    77: invokevirtual   java/io/DataInputStream.readChar:()C
        //    80: castore        
        //    81: aload           10
        //    83: iconst_3       
        //    84: aload           5
        //    86: invokevirtual   java/io/DataInputStream.readChar:()C
        //    89: castore        
        //    90: new             Ljava/lang/String;
        //    93: dup            
        //    94: aload           10
        //    96: invokespecial   java/lang/String.<init>:([C)V
        //    99: ldc_w           "NOTE"
        //   102: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   105: istore          11
        //   107: iload           11
        //   109: ifne            119
        //   112: aload           5
        //   114: invokevirtual   java/io/DataInputStream.close:()V
        //   117: iconst_0       
        //   118: ireturn        
        //   119: aload           5
        //   121: invokevirtual   java/io/DataInputStream.readInt:()I
        //   124: istore          12
        //   126: aload_0        
        //   127: getfield        jr.a:Landroid/content/Context;
        //   130: invokestatic    kt.a:(Landroid/content/Context;)Lkt;
        //   133: astore          13
        //   135: iload           12
        //   137: bipush          6
        //   139: if_icmple       149
        //   142: aload           5
        //   144: invokevirtual   java/io/DataInputStream.close:()V
        //   147: iconst_0       
        //   148: ireturn        
        //   149: iload           12
        //   151: iconst_4       
        //   152: if_icmpeq       168
        //   155: iload           12
        //   157: iconst_5       
        //   158: if_icmpeq       168
        //   161: iload           12
        //   163: bipush          6
        //   165: if_icmpne       204
        //   168: aload           13
        //   170: iconst_1       
        //   171: invokevirtual   kt.a:(Z)V
        //   174: aload_0        
        //   175: iload           12
        //   177: aload_1        
        //   178: aload_2        
        //   179: aload           13
        //   181: invokevirtual   kt.b:()Lkj;
        //   184: aload_3        
        //   185: iconst_0       
        //   186: invokespecial   jr.a:(ILjava/lang/String;Ljava/lang/String;Lkj;Lhj;Z)Z
        //   189: istore          14
        //   191: aload           5
        //   193: invokevirtual   java/io/DataInputStream.close:()V
        //   196: iload           14
        //   198: ireturn        
        //   199: astore          15
        //   201: iload           14
        //   203: ireturn        
        //   204: iload           12
        //   206: iconst_3       
        //   207: if_icmpne       258
        //   210: aload_0        
        //   211: aload_1        
        //   212: aload_2        
        //   213: aload_0        
        //   214: getfield        jr.a:Landroid/content/Context;
        //   217: ldc_w           "colornote_temp.db"
        //   220: invokevirtual   android/content/Context.getDatabasePath:(Ljava/lang/String;)Ljava/io/File;
        //   223: invokevirtual   java/io/File.getPath:()Ljava/lang/String;
        //   226: aload_3        
        //   227: iconst_0       
        //   228: iconst_0       
        //   229: invokespecial   jr.a:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lhj;ZZ)Z
        //   232: istore          17
        //   234: iload           17
        //   236: ifeq            245
        //   239: aload           13
        //   241: iconst_0       
        //   242: invokevirtual   kt.a:(Z)V
        //   245: aload           5
        //   247: invokevirtual   java/io/DataInputStream.close:()V
        //   250: iload           17
        //   252: ireturn        
        //   253: astore          18
        //   255: iload           17
        //   257: ireturn        
        //   258: aload           5
        //   260: invokevirtual   java/io/DataInputStream.close:()V
        //   263: iconst_0       
        //   264: ireturn        
        //   265: astore          6
        //   267: new             Ljava/lang/StringBuilder;
        //   270: dup            
        //   271: ldc_w           "restoreNote:"
        //   274: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   277: aload           6
        //   279: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   282: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   285: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   288: invokestatic    com/socialnmobile/colornote/ColorNote.a:(Ljava/lang/String;)V
        //   291: aload           4
        //   293: ifnull          301
        //   296: aload           4
        //   298: invokevirtual   java/io/DataInputStream.close:()V
        //   301: iconst_0       
        //   302: ireturn        
        //   303: astore          7
        //   305: aconst_null    
        //   306: astore          5
        //   308: aload           5
        //   310: ifnull          318
        //   313: aload           5
        //   315: invokevirtual   java/io/DataInputStream.close:()V
        //   318: aload           7
        //   320: athrow         
        //   321: astore          20
        //   323: goto            117
        //   326: astore          19
        //   328: goto            147
        //   331: astore          16
        //   333: goto            263
        //   336: astore          9
        //   338: goto            301
        //   341: astore          8
        //   343: goto            318
        //   346: astore          7
        //   348: goto            308
        //   351: astore          7
        //   353: aload           4
        //   355: astore          5
        //   357: goto            308
        //   360: astore          6
        //   362: aload           5
        //   364: astore          4
        //   366: goto            267
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  3      49     265    267    Ljava/io/IOException;
        //  3      49     303    308    Any
        //  49     107    360    369    Ljava/io/IOException;
        //  49     107    346    351    Any
        //  112    117    321    326    Ljava/io/IOException;
        //  119    135    360    369    Ljava/io/IOException;
        //  119    135    346    351    Any
        //  142    147    326    331    Ljava/io/IOException;
        //  168    191    360    369    Ljava/io/IOException;
        //  168    191    346    351    Any
        //  191    196    199    204    Ljava/io/IOException;
        //  210    234    360    369    Ljava/io/IOException;
        //  210    234    346    351    Any
        //  239    245    360    369    Ljava/io/IOException;
        //  239    245    346    351    Any
        //  245    250    253    258    Ljava/io/IOException;
        //  258    263    331    336    Ljava/io/IOException;
        //  267    291    351    360    Any
        //  296    301    336    341    Ljava/io/IOException;
        //  313    318    341    346    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 178, Size: 178
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
    
    public final boolean a(final String p0, final String p1, final hj p2, final boolean p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore          5
        //     3: aconst_null    
        //     4: astore          6
        //     6: new             Ljava/io/DataInputStream;
        //     9: dup            
        //    10: new             Ljava/io/BufferedInputStream;
        //    13: dup            
        //    14: new             Ljava/io/FileInputStream;
        //    17: dup            
        //    18: new             Ljava/lang/StringBuilder;
        //    21: dup            
        //    22: aload_1        
        //    23: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    26: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    29: aload_2        
        //    30: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    33: ldc             ".idx"
        //    35: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    38: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    41: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
        //    44: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //    47: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    50: astore          7
        //    52: iconst_4       
        //    53: newarray        C
        //    55: astore          15
        //    57: aload           15
        //    59: iconst_0       
        //    60: aload           7
        //    62: invokevirtual   java/io/DataInputStream.readChar:()C
        //    65: castore        
        //    66: aload           15
        //    68: iconst_1       
        //    69: aload           7
        //    71: invokevirtual   java/io/DataInputStream.readChar:()C
        //    74: castore        
        //    75: aload           15
        //    77: iconst_2       
        //    78: aload           7
        //    80: invokevirtual   java/io/DataInputStream.readChar:()C
        //    83: castore        
        //    84: aload           15
        //    86: iconst_3       
        //    87: aload           7
        //    89: invokevirtual   java/io/DataInputStream.readChar:()C
        //    92: castore        
        //    93: new             Ljava/lang/String;
        //    96: dup            
        //    97: aload           15
        //    99: invokespecial   java/lang/String.<init>:([C)V
        //   102: ldc_w           "NOTE"
        //   105: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   108: istore          16
        //   110: iload           16
        //   112: ifne            122
        //   115: aload           7
        //   117: invokevirtual   java/io/DataInputStream.close:()V
        //   120: iconst_0       
        //   121: ireturn        
        //   122: aload           7
        //   124: invokevirtual   java/io/DataInputStream.readInt:()I
        //   127: istore          17
        //   129: aload           7
        //   131: invokevirtual   java/io/DataInputStream.readInt:()I
        //   134: pop            
        //   135: aload           7
        //   137: invokevirtual   java/io/DataInputStream.readLong:()J
        //   140: pop2           
        //   141: aload           7
        //   143: invokevirtual   java/io/DataInputStream.readInt:()I
        //   146: istore          21
        //   148: iload           17
        //   150: bipush          6
        //   152: if_icmple       162
        //   155: aload           7
        //   157: invokevirtual   java/io/DataInputStream.close:()V
        //   160: iconst_0       
        //   161: ireturn        
        //   162: iload           17
        //   164: iconst_4       
        //   165: if_icmpeq       181
        //   168: iload           17
        //   170: iconst_5       
        //   171: if_icmpeq       181
        //   174: iload           17
        //   176: bipush          6
        //   178: if_icmpne       244
        //   181: aload_0        
        //   182: getfield        jr.a:Landroid/content/Context;
        //   185: invokestatic    com/socialnmobile/colornote/data/NoteProvider.a:(Landroid/content/Context;)Lcom/socialnmobile/colornote/data/NoteProvider;
        //   188: astore          22
        //   190: aload_0        
        //   191: getfield        jr.a:Landroid/content/Context;
        //   194: invokestatic    com/socialnmobile/colornote/data/NoteProvider.b:(Landroid/content/Context;)Lki;
        //   197: astore          23
        //   199: invokestatic    ki.c:()V
        //   202: aload_0        
        //   203: iload           17
        //   205: aload_1        
        //   206: aload_2        
        //   207: aload           23
        //   209: invokevirtual   ki.f:()Lkj;
        //   212: aload_3        
        //   213: iload           4
        //   215: invokespecial   jr.a:(ILjava/lang/String;Ljava/lang/String;Lkj;Lhj;Z)Z
        //   218: istore          24
        //   220: invokestatic    ki.d:()V
        //   223: aload           22
        //   225: invokevirtual   com/socialnmobile/colornote/data/NoteProvider.a:()V
        //   228: invokestatic    com/socialnmobile/colornote/ColorNote.g:()V
        //   231: aload           7
        //   233: invokevirtual   java/io/DataInputStream.close:()V
        //   236: iload           24
        //   238: ireturn        
        //   239: astore          25
        //   241: iload           24
        //   243: ireturn        
        //   244: iload           17
        //   246: iconst_3       
        //   247: if_icmpne       291
        //   250: aload_0        
        //   251: aload_1        
        //   252: aload_2        
        //   253: aload_0        
        //   254: getfield        jr.a:Landroid/content/Context;
        //   257: ldc_w           "colornote.db"
        //   260: invokevirtual   android/content/Context.getDatabasePath:(Ljava/lang/String;)Ljava/io/File;
        //   263: invokevirtual   java/io/File.getPath:()Ljava/lang/String;
        //   266: aload_3        
        //   267: iconst_1       
        //   268: iload           4
        //   270: invokespecial   jr.a:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lhj;ZZ)Z
        //   273: istore          29
        //   275: invokestatic    com/socialnmobile/colornote/ColorNote.g:()V
        //   278: aload           7
        //   280: invokevirtual   java/io/DataInputStream.close:()V
        //   283: iload           29
        //   285: ireturn        
        //   286: astore          30
        //   288: iload           29
        //   290: ireturn        
        //   291: new             Ljava/io/DataInputStream;
        //   294: dup            
        //   295: new             Ljava/io/BufferedInputStream;
        //   298: dup            
        //   299: new             Ljava/io/FileInputStream;
        //   302: dup            
        //   303: new             Ljava/lang/StringBuilder;
        //   306: dup            
        //   307: aload_1        
        //   308: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   311: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   314: aload_2        
        //   315: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   318: ldc             ".dat"
        //   320: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   323: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   326: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
        //   329: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //   332: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //   335: astore          9
        //   337: aload           7
        //   339: astore          26
        //   341: aload_0        
        //   342: iload           17
        //   344: iload           21
        //   346: iload           4
        //   348: aload           26
        //   350: aload           9
        //   352: aload_3        
        //   353: invokespecial   jr.a:(IIZLjava/io/DataInputStream;Ljava/io/DataInputStream;Lhj;)Z
        //   356: pop            
        //   357: aload           7
        //   359: invokevirtual   java/io/DataInputStream.close:()V
        //   362: aload           9
        //   364: invokevirtual   java/io/DataInputStream.close:()V
        //   367: iconst_1       
        //   368: ireturn        
        //   369: astore          8
        //   371: aconst_null    
        //   372: astore          9
        //   374: new             Ljava/lang/StringBuilder;
        //   377: dup            
        //   378: ldc_w           "restoreNote:"
        //   381: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   384: aload           8
        //   386: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   389: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   392: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   395: invokestatic    com/socialnmobile/colornote/ColorNote.a:(Ljava/lang/String;)V
        //   398: aload           5
        //   400: ifnull          408
        //   403: aload           5
        //   405: invokevirtual   java/io/DataInputStream.close:()V
        //   408: aload           9
        //   410: ifnull          418
        //   413: aload           9
        //   415: invokevirtual   java/io/DataInputStream.close:()V
        //   418: iconst_0       
        //   419: ireturn        
        //   420: astore          13
        //   422: aconst_null    
        //   423: astore          7
        //   425: new             Ljava/lang/StringBuilder;
        //   428: dup            
        //   429: ldc_w           "restoreNote:"
        //   432: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   435: aload           13
        //   437: invokevirtual   java/security/GeneralSecurityException.getMessage:()Ljava/lang/String;
        //   440: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   443: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   446: invokestatic    com/socialnmobile/colornote/ColorNote.a:(Ljava/lang/String;)V
        //   449: aload           7
        //   451: ifnull          459
        //   454: aload           7
        //   456: invokevirtual   java/io/DataInputStream.close:()V
        //   459: aload           6
        //   461: ifnull          469
        //   464: aload           6
        //   466: invokevirtual   java/io/DataInputStream.close:()V
        //   469: iconst_0       
        //   470: ireturn        
        //   471: astore          10
        //   473: aconst_null    
        //   474: astore          7
        //   476: aload           7
        //   478: ifnull          486
        //   481: aload           7
        //   483: invokevirtual   java/io/DataInputStream.close:()V
        //   486: aload           6
        //   488: ifnull          496
        //   491: aload           6
        //   493: invokevirtual   java/io/DataInputStream.close:()V
        //   496: aload           10
        //   498: athrow         
        //   499: astore          32
        //   501: goto            120
        //   504: astore          31
        //   506: goto            160
        //   509: astore          11
        //   511: goto            496
        //   514: astore          10
        //   516: goto            476
        //   519: astore          10
        //   521: aload           9
        //   523: astore          6
        //   525: goto            476
        //   528: astore          10
        //   530: aload           9
        //   532: astore          6
        //   534: aload           5
        //   536: astore          7
        //   538: goto            476
        //   541: astore          14
        //   543: goto            469
        //   546: astore          13
        //   548: aconst_null    
        //   549: astore          6
        //   551: goto            425
        //   554: astore          13
        //   556: aload           9
        //   558: astore          6
        //   560: goto            425
        //   563: astore          12
        //   565: goto            418
        //   568: astore          8
        //   570: aload           7
        //   572: astore          5
        //   574: aconst_null    
        //   575: astore          9
        //   577: goto            374
        //   580: astore          8
        //   582: aload           7
        //   584: astore          5
        //   586: goto            374
        //   589: astore          28
        //   591: goto            367
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                    
        //  -----  -----  -----  -----  ----------------------------------------
        //  6      52     369    374    Ljava/io/IOException;
        //  6      52     420    425    Ljava/security/GeneralSecurityException;
        //  6      52     471    476    Any
        //  52     110    568    580    Ljava/io/IOException;
        //  52     110    546    554    Ljava/security/GeneralSecurityException;
        //  52     110    514    519    Any
        //  115    120    499    504    Ljava/io/IOException;
        //  122    148    568    580    Ljava/io/IOException;
        //  122    148    546    554    Ljava/security/GeneralSecurityException;
        //  122    148    514    519    Any
        //  155    160    504    509    Ljava/io/IOException;
        //  181    231    568    580    Ljava/io/IOException;
        //  181    231    546    554    Ljava/security/GeneralSecurityException;
        //  181    231    514    519    Any
        //  231    236    239    244    Ljava/io/IOException;
        //  250    278    568    580    Ljava/io/IOException;
        //  250    278    546    554    Ljava/security/GeneralSecurityException;
        //  250    278    514    519    Any
        //  278    283    286    291    Ljava/io/IOException;
        //  291    337    568    580    Ljava/io/IOException;
        //  291    337    546    554    Ljava/security/GeneralSecurityException;
        //  291    337    514    519    Any
        //  341    357    580    589    Ljava/io/IOException;
        //  341    357    554    563    Ljava/security/GeneralSecurityException;
        //  341    357    519    528    Any
        //  357    367    589    594    Ljava/io/IOException;
        //  374    398    528    541    Any
        //  403    408    563    568    Ljava/io/IOException;
        //  413    418    563    568    Ljava/io/IOException;
        //  425    449    514    519    Any
        //  454    459    541    546    Ljava/io/IOException;
        //  464    469    541    546    Ljava/io/IOException;
        //  481    486    509    514    Ljava/io/IOException;
        //  491    496    509    514    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:3037)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2446)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:109)
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
    
    public final String[] a(final boolean b) {
        final ArrayList<String> list = new ArrayList<String>();
        list.add(a());
        final String b2 = this.b();
        if (b2 != null) {
            list.add(b2);
        }
        if (Build$VERSION.SDK_INT < 19 || b) {
            final String c = c();
            if (c != null) {
                list.add(c);
            }
        }
        return list.toArray(new String[list.size()]);
    }
    
    public final String b() {
        while (true) {
            if (Build$VERSION.SDK_INT >= 19) {
                try {
                    final File[] externalFilesDirs = this.a.getExternalFilesDirs((String)null);
                    if (externalFilesDirs.length >= 2) {
                        for (int i = 1; i < externalFilesDirs.length; ++i) {
                            if (externalFilesDirs[i] != null) {
                                return String.valueOf(externalFilesDirs[i].getAbsolutePath()) + "/backup/";
                            }
                        }
                        return null;
                    }
                    return null;
                    final String a = jl.a();
                    // iftrue(Label_0141:, a == null)
                    return String.valueOf(a) + ("/Android/data/" + this.a.getPackageName() + "/files") + "/backup/";
                }
                catch (NullPointerException ex) {}
                Label_0141: {
                    return null;
                }
            }
            continue;
        }
    }
    
    public final void d() {
        int i = 0;
        for (String[] a = this.a(false); i < a.length; ++i) {
            final File file = new File(a[i]);
            if (file.isDirectory()) {
                a(file);
            }
        }
    }
    
    public final ArrayList e() {
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        final String[] a = this.a(true);
        for (int length = a.length, i = 0; i < length; ++i) {
            this.a(hashMap, a[i]);
        }
        this.a(hashMap, String.valueOf(jk.a(Environment.DIRECTORY_DOWNLOADS).toString()) + "/");
        final ArrayList list = new ArrayList<Object>(hashMap.values());
        Collections.sort((List<E>)list, new jt(this));
        return list;
    }
}
