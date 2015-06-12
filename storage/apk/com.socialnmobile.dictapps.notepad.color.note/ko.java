import android.database.DatabaseUtils;
import android.text.TextUtils;
import java.util.ArrayList;
import android.database.Cursor;
import android.content.ContentValues;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Callable;
import com.socialnmobile.colornote.sync.SyncStateColumns;
import com.socialnmobile.colornote.sync.SyncIndexColumns;
import com.socialnmobile.colornote.data.NoteColumns$NotesColumns;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ko implements NoteColumns$NotesColumns, SyncIndexColumns, SyncStateColumns
{
    static final Object[] b;
    static final aco c;
    static final aco d;
    static final aco e;
    static final aco f;
    static final aco g;
    public static final aco h;
    final ki a;
    
    static {
        b = new Object[0];
        c = new aco("dirty != 0", new String[0]);
        d = new aco("staged != 0", new String[0]);
        e = new aco("revision!=0 or active_state != 32", new String[0]);
        f = new aco("status NOT BETWEEN (16384) AND (32767)", new String[0]);
        g = aco.a("OR", ko.c, ko.d).a(ko.e).a(ko.f);
        h = new aco("staged!=0", new String[0]);
    }
    
    public ko(final ki a) {
        this.a = a;
    }
    
    public static aco a(final long l) {
        return new aco("_id=?", new Object[] { l });
    }
    
    private Object a(final Callable callable) {
        final kj f = this.a.f();
        f.a.beginTransaction();
        try {
            final Object call = callable.call();
            f.a.setTransactionSuccessful();
            return call;
        }
        catch (Exception cause) {
            throw new ExecutionException(cause);
        }
        finally {
            f.a.endTransaction();
        }
    }
    
    public static aco b(final UUID obj) {
        return new aco("uuid=\"" + obj + "\"", new String[0]);
    }
    
    public final int a(final int n, final Set set) {
        try {
            return (int)this.a(new kq(this, n, set));
        }
        catch (ExecutionException cause) {
            cause.printStackTrace();
            throw new RuntimeException(cause);
        }
    }
    
    public final int a(final aco aco) {
        final ContentValues contentValues = new ContentValues();
        contentValues.put("dirty", 1);
        return this.a(contentValues, aco);
    }
    
    public final int a(final ContentValues contentValues, aco aco) {
        if (aco == null) {
            aco = new aco();
        }
        return this.a.f().a("notes", contentValues, aco.a, aco.b);
    }
    
    public final int a(final ContentValues contentValues, final UUID uuid) {
        return this.a(contentValues, new aco("uuid=?", new Object[] { uuid }));
    }
    
    public final long a(final ContentValues contentValues) {
        return this.a.f().b("notes", "title", contentValues);
    }
    
    public final ContentValues a(final UUID uuid) {
        return this.b(new String[] { "_id", "dirty", "staged" }, new aco("uuid=?", new String[] { uuid.toString() }));
    }
    
    public final Cursor a(final String[] array, aco aco) {
        if (aco == null) {
            aco = new aco();
        }
        return this.a.e().a("notes", array, aco.a, aco.b, null);
    }
    
    public final void a() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: iconst_2       
        //     2: anewarray       Ljava/lang/String;
        //     5: dup            
        //     6: iconst_0       
        //     7: ldc             "_id"
        //     9: aastore        
        //    10: dup            
        //    11: iconst_1       
        //    12: ldc             "uuid"
        //    14: aastore        
        //    15: aconst_null    
        //    16: invokevirtual   ko.a:([Ljava/lang/String;Laco;)Landroid/database/Cursor;
        //    19: astore_1       
        //    20: aload_1        
        //    21: ldc             "_id"
        //    23: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //    28: istore_3       
        //    29: aload_1        
        //    30: ldc             "uuid"
        //    32: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //    37: istore          4
        //    39: new             Lkp;
        //    42: dup            
        //    43: aload_0        
        //    44: aload_1        
        //    45: invokespecial   kp.<init>:(Lko;Landroid/database/Cursor;)V
        //    48: astore          5
        //    50: new             Landroid/content/ContentValues;
        //    53: dup            
        //    54: invokespecial   android/content/ContentValues.<init>:()V
        //    57: astore          6
        //    59: aload           5
        //    61: invokevirtual   ace.iterator:()Ljava/util/Iterator;
        //    64: astore          7
        //    66: iconst_0       
        //    67: istore          8
        //    69: aload           7
        //    71: invokeinterface java/util/Iterator.hasNext:()Z
        //    76: istore          9
        //    78: iload           9
        //    80: ifne            110
        //    83: aload_1        
        //    84: invokeinterface android/database/Cursor.close:()V
        //    89: new             Ljava/lang/StringBuilder;
        //    92: dup            
        //    93: ldc             "# of uuid regenerated Note: "
        //    95: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    98: iload           8
        //   100: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   103: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   106: invokestatic    com/socialnmobile/colornote/ColorNote.a:(Ljava/lang/String;)V
        //   109: return         
        //   110: aload           7
        //   112: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   117: checkcast       Landroid/database/Cursor;
        //   120: astore          10
        //   122: aload           10
        //   124: iload_3        
        //   125: invokeinterface android/database/Cursor.getLong:(I)J
        //   130: lstore          11
        //   132: aload           10
        //   134: iload           4
        //   136: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   141: astore          13
        //   143: aconst_null    
        //   144: astore          14
        //   146: aload           13
        //   148: ifnull          162
        //   151: aload           13
        //   153: invokestatic    java/util/UUID.fromString:(Ljava/lang/String;)Ljava/util/UUID;
        //   156: astore          18
        //   158: aload           18
        //   160: astore          14
        //   162: aload           14
        //   164: ifnull          260
        //   167: new             Ljava/lang/StringBuilder;
        //   170: dup            
        //   171: ldc_w           "Note #"
        //   174: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   177: lload           11
        //   179: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   182: ldc_w           " has already uuid: "
        //   185: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   188: aload           14
        //   190: invokevirtual   java/util/UUID.toString:()Ljava/lang/String;
        //   193: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   196: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   199: invokestatic    com/socialnmobile/colornote/ColorNote.a:(Ljava/lang/String;)V
        //   202: goto            69
        //   205: astore_2       
        //   206: aload_1        
        //   207: invokeinterface android/database/Cursor.close:()V
        //   212: aload_2        
        //   213: athrow         
        //   214: astore          17
        //   216: new             Ljava/lang/StringBuilder;
        //   219: dup            
        //   220: ldc_w           "Note #"
        //   223: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   226: lload           11
        //   228: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   231: ldc_w           " ahs invalid uuid: "
        //   234: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   237: aload           13
        //   239: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   242: ldc_w           " / regenerating..."
        //   245: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   248: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   251: invokestatic    com/socialnmobile/colornote/ColorNote.a:(Ljava/lang/String;)V
        //   254: aconst_null    
        //   255: astore          14
        //   257: goto            162
        //   260: invokestatic    java/util/UUID.randomUUID:()Ljava/util/UUID;
        //   263: astore          15
        //   265: aload           6
        //   267: ldc             "uuid"
        //   269: aload           15
        //   271: invokevirtual   java/util/UUID.toString:()Ljava/lang/String;
        //   274: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/String;)V
        //   277: iconst_1       
        //   278: anewarray       Ljava/lang/Object;
        //   281: astore          16
        //   283: aload           16
        //   285: iconst_0       
        //   286: lload           11
        //   288: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   291: aastore        
        //   292: aload_0        
        //   293: aload           6
        //   295: new             Laco;
        //   298: dup            
        //   299: ldc             "_id=?"
        //   301: aload           16
        //   303: invokespecial   aco.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   306: invokevirtual   ko.a:(Landroid/content/ContentValues;Laco;)I
        //   309: iconst_1       
        //   310: if_icmpne       69
        //   313: new             Ljava/lang/StringBuilder;
        //   316: dup            
        //   317: ldc_w           "Note #"
        //   320: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   323: lload           11
        //   325: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   328: ldc_w           " uuid: "
        //   331: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   334: aload           15
        //   336: invokevirtual   java/util/UUID.toString:()Ljava/lang/String;
        //   339: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   342: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   345: invokestatic    com/socialnmobile/colornote/ColorNote.a:(Ljava/lang/String;)V
        //   348: iinc            8, 1
        //   351: goto            69
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  20     66     205    214    Any
        //  69     78     205    214    Any
        //  110    143    205    214    Any
        //  151    158    214    260    Ljava/lang/Exception;
        //  151    158    205    214    Any
        //  167    202    205    214    Any
        //  216    254    205    214    Any
        //  260    348    205    214    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0162:
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
    
    public final int b() {
        final String string = "SELECT COUNT(_ID) FROM notes WHERE " + new aco("dirty!=0", new String[0]).a;
        final Cursor a = this.a.e().a(string, new String[0]);
        try {
            if (a.moveToFirst()) {
                return a.getInt(0);
            }
            throw new RuntimeException("NoteWithSyncInfoTable.getDirtyNoteCount() failed: " + string);
        }
        finally {
            a.close();
        }
    }
    
    final int b(int i, final Set set) {
        final String string = "SELECT _id FROM notes WHERE " + ko.g.a + " ORDER BY modified_date, minor_modified_date LIMIT " + i;
        final ArrayList<String> list = new ArrayList<String>();
        final kj f = this.a.f();
        final Cursor a = f.a(string, new String[0]);
        if (a != null) {
            int count = 0;
            Long value;
            int n;
            Label_0162_Outer:Label_0090_Outer:
            while (true) {
            Label_0090:
                while (true) {
                    Label_0313: {
                        Label_0310: {
                            try {
                                count = a.getCount();
                                if (count > i) {
                                    break Label_0313;
                                }
                                break Label_0310;
                                // iftrue(Label_0191:, list.size() != 0)
                                // iftrue(Label_0173:, !a.moveToPosition(n))
                                // iftrue(Label_0117:, n < i)
                                while (true) {
                                    Block_6: {
                                    Label_0173:
                                        while (true) {
                                            return 0;
                                            list.add(value.toString());
                                            break Label_0173;
                                            Label_0117: {
                                                break Block_6;
                                            }
                                            continue Label_0162_Outer;
                                        }
                                        ++n;
                                        continue Label_0090;
                                    }
                                    value = a.getLong(0);
                                    continue Label_0090_Outer;
                                }
                            }
                            // iftrue(Label_0173:, value == null || set != null && set.contains((Object)value))
                            finally {
                                a.close();
                            }
                            break;
                        }
                        i = count;
                    }
                    n = 0;
                    continue Label_0090;
                }
            }
            Label_0191: {
                a.close();
            }
        }
        return f.a("UPDATE notes SET " + TextUtils.join((CharSequence)", ", (Object[])new String[] { "dirty=0", "staged=(staged|dirty)" }) + " WHERE " + new aco("_id IN (" + TextUtils.join((CharSequence)",", (Iterable)list) + ")", new String[0]).a, ko.b);
    }
    
    public final int b(final ContentValues contentValues, final aco aco) {
        contentValues.remove("uuid");
        contentValues.remove("_id");
        contentValues.put("staged", 0);
        return this.a(contentValues, aco);
    }
    
    public final ContentValues b(final String[] array, final aco aco) {
        final Cursor a = this.a(array, aco);
        try {
            if (a.moveToFirst()) {
                final ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(a, contentValues);
                return contentValues;
            }
            return null;
        }
        finally {
            a.close();
        }
    }
    
    public final Cursor c() {
        return this.a((String[])null, ko.h);
    }
    
    public final void c(final UUID obj) {
        this.a.f().a("UPDATE notes SET " + TextUtils.join((CharSequence)", ", (Object[])new String[] { "uuid=\"" + java.util.UUID.randomUUID() + "\"", "revision=0", "dirty=1", "status=status|4096" }) + " WHERE " + new aco("uuid = \"" + obj + "\"", new String[0]).a(new aco("type != 256", new Object[0])).a, ko.b);
    }
    
    public final int d() {
        return this.a.f().a("UPDATE notes SET " + TextUtils.join((CharSequence)", ", (Object[])new String[] { "dirty=(dirty|staged)", "staged=0" }) + " WHERE " + new aco("staged!=0", new String[0]).a, ko.b);
    }
    
    public final int e() {
        return this.a.f().a("UPDATE notes SET " + TextUtils.join((CharSequence)", ", (Object[])new String[] { "revision=0", "dirty=1" }) + " WHERE " + new aco("revision > 0", new String[0]).a, ko.b);
    }
}
