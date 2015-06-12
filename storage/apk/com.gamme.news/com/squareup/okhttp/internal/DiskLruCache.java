// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal;

import java.util.Arrays;
import java.io.FilterOutputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.io.EOFException;
import java.io.FileInputStream;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.io.Writer;
import java.util.concurrent.ThreadPoolExecutor;
import java.io.File;
import java.util.concurrent.Callable;
import java.io.OutputStream;
import java.util.regex.Pattern;
import java.io.Closeable;

public final class DiskLruCache implements Closeable
{
    static final long ANY_SEQUENCE_NUMBER = -1L;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN;
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final OutputStream NULL_OUTPUT_STREAM;
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable;
    private final File directory;
    final ThreadPoolExecutor executorService;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    
    static {
        LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,64}");
        NULL_OUTPUT_STREAM = new OutputStream() {
            @Override
            public void write(final int n) throws IOException {
            }
        };
    }
    
    private DiskLruCache(final File file, final int appVersion, final int valueCount, final long maxSize) {
        this.size = 0L;
        this.lruEntries = new LinkedHashMap<String, Entry>(0, 0.75f, true);
        this.nextSequenceNumber = 0L;
        this.executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        this.cleanupCallable = new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                synchronized (DiskLruCache.this) {
                    if (DiskLruCache.this.journalWriter == null) {
                        return null;
                    }
                    DiskLruCache.this.trimToSize();
                    if (DiskLruCache.this.journalRebuildRequired()) {
                        DiskLruCache.this.rebuildJournal();
                        DiskLruCache.access$4(DiskLruCache.this, 0);
                    }
                    return null;
                }
            }
        };
        this.directory = file;
        this.appVersion = appVersion;
        this.journalFile = new File(file, "journal");
        this.journalFileTmp = new File(file, "journal.tmp");
        this.journalFileBackup = new File(file, "journal.bkp");
        this.valueCount = valueCount;
        this.maxSize = maxSize;
    }
    
    static /* synthetic */ void access$4(final DiskLruCache diskLruCache, final int redundantOpCount) {
        diskLruCache.redundantOpCount = redundantOpCount;
    }
    
    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }
    
    private void completeEdit(final Editor editor, final boolean b) throws IOException {
        final Entry access$2;
        synchronized (this) {
            access$2 = editor.entry;
            if (access$2.currentEditor != editor) {
                throw new IllegalStateException();
            }
        }
    Label_0201:
        while (true) {
            if (b && !access$2.readable) {
                for (int i = 0; i < this.valueCount; ++i) {
                    if (!editor.written[i]) {
                        editor.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!access$2.getDirtyFile(i).exists()) {
                        editor.abort();
                        break Label_0201;
                    }
                }
            }
            Label_0403: {
                break Label_0403;
                return;
            }
            for (int j = 0; j < this.valueCount; ++j) {
                final File dirtyFile = access$2.getDirtyFile(j);
                if (b) {
                    if (dirtyFile.exists()) {
                        final File cleanFile = access$2.getCleanFile(j);
                        dirtyFile.renameTo(cleanFile);
                        final long n = access$2.lengths[j];
                        final long length = cleanFile.length();
                        access$2.lengths[j] = length;
                        this.size = length + (this.size - n);
                    }
                }
                else {
                    deleteIfExists(dirtyFile);
                }
            }
            ++this.redundantOpCount;
            Entry.access$5(access$2, null);
            if (b | access$2.readable) {
                Entry.access$4(access$2, true);
                this.journalWriter.write("CLEAN " + access$2.key + access$2.getLengths() + '\n');
                if (b) {
                    final long nextSequenceNumber = this.nextSequenceNumber;
                    this.nextSequenceNumber = 1L + nextSequenceNumber;
                    Entry.access$9(access$2, nextSequenceNumber);
                }
            }
            else {
                this.lruEntries.remove(access$2.key);
                this.journalWriter.write("REMOVE " + access$2.key + '\n');
            }
            this.journalWriter.flush();
            if (this.size > this.maxSize || this.journalRebuildRequired()) {
                this.executorService.submit(this.cleanupCallable);
            }
            continue Label_0201;
        }
    }
    // monitorexit(this)
    
    private static void deleteIfExists(final File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }
    
    private Editor edit(final String str, final long n) throws IOException {
        while (true) {
            while (true) {
                Entry value;
                synchronized (this) {
                    this.checkNotClosed();
                    this.validateKey(str);
                    value = this.lruEntries.get(str);
                    Label_0066: {
                        if (n == -1L) {
                            break Label_0066;
                        }
                        Editor editor = null;
                        if (value != null) {
                            final long n2 = lcmp(value.sequenceNumber, n);
                            editor = null;
                            if (n2 == 0) {
                                break Label_0066;
                            }
                        }
                        return editor;
                    }
                    if (value == null) {
                        value = new Entry(str, (Entry)null);
                        this.lruEntries.put(str, value);
                        final Editor editor = new Editor(value, (Editor)null);
                        Entry.access$5(value, editor);
                        this.journalWriter.write("DIRTY " + str + '\n');
                        this.journalWriter.flush();
                        return editor;
                    }
                }
                if (value.currentEditor != null) {
                    return null;
                }
                continue;
            }
        }
    }
    
    private static String inputStreamToString(final InputStream in) throws IOException {
        return Util.readFully(new InputStreamReader(in, Util.UTF_8));
    }
    
    private boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }
    
    public static DiskLruCache open(final File obj, final int n, final int n2, final long n3) throws IOException {
        if (n3 <= 0L) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (n2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        final File file = new File(obj, "journal.bkp");
        Label_0150: {
            if (file.exists()) {
                final File file2 = new File(obj, "journal");
                if (!file2.exists()) {
                    break Label_0150;
                }
                file.delete();
            }
            while (true) {
                final DiskLruCache diskLruCache = new DiskLruCache(obj, n, n2, n3);
                if (!diskLruCache.journalFile.exists()) {
                    break Label_0150;
                }
                try {
                    diskLruCache.readJournal();
                    diskLruCache.processJournal();
                    diskLruCache.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.journalFile, true), Util.US_ASCII));
                    return diskLruCache;
                    final File file2;
                    renameTo(file, file2, false);
                    continue;
                }
                catch (IOException ex) {
                    Platform.get().logW("DiskLruCache " + obj + " is corrupt: " + ex.getMessage() + ", removing");
                    diskLruCache.delete();
                }
                break;
            }
        }
        obj.mkdirs();
        final DiskLruCache diskLruCache2 = new DiskLruCache(obj, n, n2, n3);
        diskLruCache2.rebuildJournal();
        return diskLruCache2;
    }
    
    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        final Iterator<Entry> iterator = this.lruEntries.values().iterator();
        while (iterator.hasNext()) {
            final Entry entry = iterator.next();
            if (entry.currentEditor == null) {
                for (int i = 0; i < this.valueCount; ++i) {
                    this.size += entry.lengths[i];
                }
            }
            else {
                Entry.access$5(entry, null);
                for (int j = 0; j < this.valueCount; ++j) {
                    deleteIfExists(entry.getCleanFile(j));
                    deleteIfExists(entry.getDirtyFile(j));
                }
                iterator.remove();
            }
        }
    }
    
    private void readJournal() throws IOException {
        final StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.journalFile), Util.US_ASCII);
        try {
            final String line = strictLineReader.readLine();
            final String line2 = strictLineReader.readLine();
            final String line3 = strictLineReader.readLine();
            final String line4 = strictLineReader.readLine();
            final String line5 = strictLineReader.readLine();
            if (!"libcore.io.DiskLruCache".equals(line) || !"1".equals(line2) || !Integer.toString(this.appVersion).equals(line3) || !Integer.toString(this.valueCount).equals(line4) || !"".equals(line5)) {
                throw new IOException("unexpected journal header: [" + line + ", " + line2 + ", " + line4 + ", " + line5 + "]");
            }
        }
        finally {
            Util.closeQuietly(strictLineReader);
        }
        int n = 0;
        try {
            while (true) {
                this.readJournalLine(strictLineReader.readLine());
                ++n;
            }
        }
        catch (EOFException ex) {
            this.redundantOpCount = n - this.lruEntries.size();
            Util.closeQuietly(strictLineReader);
        }
    }
    
    private void readJournalLine(final String s) throws IOException {
        final int index = s.indexOf(32);
        if (index == -1) {
            throw new IOException("unexpected journal line: " + s);
        }
        final int beginIndex = index + 1;
        final int index2 = s.indexOf(32, beginIndex);
        String key = null;
        Label_0101: {
            if (index2 != -1) {
                key = s.substring(beginIndex, index2);
                break Label_0101;
            }
            key = s.substring(beginIndex);
            if (index != "REMOVE".length() || !s.startsWith("REMOVE")) {
                break Label_0101;
            }
            this.lruEntries.remove(key);
            return;
        }
        Entry value = this.lruEntries.get(key);
        if (value == null) {
            value = new Entry(key, (Entry)null);
            this.lruEntries.put(key, value);
        }
        if (index2 != -1 && index == "CLEAN".length() && s.startsWith("CLEAN")) {
            final String[] split = s.substring(index2 + 1).split(" ");
            Entry.access$4(value, true);
            Entry.access$5(value, null);
            value.setLengths(split);
            return;
        }
        if (index2 == -1 && index == "DIRTY".length() && s.startsWith("DIRTY")) {
            Entry.access$5(value, new Editor(value, (Editor)null));
            return;
        }
        if (index2 != -1 || index != "READ".length() || !s.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + s);
        }
    }
    
    private void rebuildJournal() throws IOException {
        while (true) {
            while (true) {
                final BufferedWriter bufferedWriter;
                Entry entry = null;
                Label_0289: {
                    synchronized (this) {
                        if (this.journalWriter != null) {
                            this.journalWriter.close();
                        }
                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
                        try {
                            bufferedWriter.write("libcore.io.DiskLruCache");
                            bufferedWriter.write("\n");
                            bufferedWriter.write("1");
                            bufferedWriter.write("\n");
                            bufferedWriter.write(Integer.toString(this.appVersion));
                            bufferedWriter.write("\n");
                            bufferedWriter.write(Integer.toString(this.valueCount));
                            bufferedWriter.write("\n");
                            bufferedWriter.write("\n");
                            final Iterator<Entry> iterator = this.lruEntries.values().iterator();
                            while (iterator.hasNext()) {
                                entry = iterator.next();
                                if (entry.currentEditor == null) {
                                    break Label_0289;
                                }
                                bufferedWriter.write("DIRTY " + entry.key + '\n');
                            }
                            bufferedWriter.close();
                            if (this.journalFile.exists()) {
                                renameTo(this.journalFile, this.journalFileBackup, true);
                            }
                            renameTo(this.journalFileTmp, this.journalFile, false);
                            this.journalFileBackup.delete();
                            this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
                            return;
                        }
                        finally {
                            bufferedWriter.close();
                        }
                    }
                }
                bufferedWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
                continue;
            }
        }
    }
    
    private static void renameTo(final File file, final File dest, final boolean b) throws IOException {
        if (b) {
            deleteIfExists(dest);
        }
        if (!file.renameTo(dest)) {
            throw new IOException();
        }
    }
    
    private void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            this.remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }
    
    private void validateKey(final String s) {
        if (!DiskLruCache.LEGAL_KEY_PATTERN.matcher(s).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + s + "\"");
        }
    }
    
    @Override
    public void close() throws IOException {
        while (true) {
            while (true) {
                final Iterator<Entry> iterator;
                Label_0065: {
                    synchronized (this) {
                        if (this.journalWriter != null) {
                            iterator = new ArrayList<Entry>(this.lruEntries.values()).iterator();
                            if (iterator.hasNext()) {
                                break Label_0065;
                            }
                            this.trimToSize();
                            this.journalWriter.close();
                            this.journalWriter = null;
                        }
                        return;
                    }
                }
                final Entry entry = iterator.next();
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                    continue;
                }
                continue;
            }
        }
    }
    
    public void delete() throws IOException {
        this.close();
        Util.deleteContents(this.directory);
    }
    
    public Editor edit(final String s) throws IOException {
        return this.edit(s, -1L);
    }
    
    public void flush() throws IOException {
        synchronized (this) {
            this.checkNotClosed();
            this.trimToSize();
            this.journalWriter.flush();
        }
    }
    
    public Snapshot get(final String p0) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: monitorenter   
        //     2: aload_0        
        //     3: invokespecial   com/squareup/okhttp/internal/DiskLruCache.checkNotClosed:()V
        //     6: aload_0        
        //     7: aload_1        
        //     8: invokespecial   com/squareup/okhttp/internal/DiskLruCache.validateKey:(Ljava/lang/String;)V
        //    11: aload_0        
        //    12: getfield        com/squareup/okhttp/internal/DiskLruCache.lruEntries:Ljava/util/LinkedHashMap;
        //    15: aload_1        
        //    16: invokevirtual   java/util/LinkedHashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    19: checkcast       Lcom/squareup/okhttp/internal/DiskLruCache$Entry;
        //    22: astore_3       
        //    23: aconst_null    
        //    24: astore          4
        //    26: aload_3        
        //    27: ifnonnull       35
        //    30: aload_0        
        //    31: monitorexit    
        //    32: aload           4
        //    34: areturn        
        //    35: aload_3        
        //    36: invokestatic    com/squareup/okhttp/internal/DiskLruCache$Entry.access$0:(Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
        //    39: istore          5
        //    41: aconst_null    
        //    42: astore          4
        //    44: iload           5
        //    46: ifeq            30
        //    49: aload_0        
        //    50: getfield        com/squareup/okhttp/internal/DiskLruCache.valueCount:I
        //    53: anewarray       Ljava/io/InputStream;
        //    56: astore          6
        //    58: iconst_0       
        //    59: istore          7
        //    61: aload_0        
        //    62: getfield        com/squareup/okhttp/internal/DiskLruCache.valueCount:I
        //    65: istore          12
        //    67: iload           7
        //    69: iload           12
        //    71: if_icmplt       163
        //    74: aload_0        
        //    75: iconst_1       
        //    76: aload_0        
        //    77: getfield        com/squareup/okhttp/internal/DiskLruCache.redundantOpCount:I
        //    80: iadd           
        //    81: putfield        com/squareup/okhttp/internal/DiskLruCache.redundantOpCount:I
        //    84: aload_0        
        //    85: getfield        com/squareup/okhttp/internal/DiskLruCache.journalWriter:Ljava/io/Writer;
        //    88: new             Ljava/lang/StringBuilder;
        //    91: dup            
        //    92: ldc_w           "READ "
        //    95: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    98: aload_1        
        //    99: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   102: bipush          10
        //   104: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   107: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   110: invokevirtual   java/io/Writer.append:(Ljava/lang/CharSequence;)Ljava/io/Writer;
        //   113: pop            
        //   114: aload_0        
        //   115: invokespecial   com/squareup/okhttp/internal/DiskLruCache.journalRebuildRequired:()Z
        //   118: ifeq            133
        //   121: aload_0        
        //   122: getfield        com/squareup/okhttp/internal/DiskLruCache.executorService:Ljava/util/concurrent/ThreadPoolExecutor;
        //   125: aload_0        
        //   126: getfield        com/squareup/okhttp/internal/DiskLruCache.cleanupCallable:Ljava/util/concurrent/Callable;
        //   129: invokevirtual   java/util/concurrent/ThreadPoolExecutor.submit:(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
        //   132: pop            
        //   133: new             Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
        //   136: dup            
        //   137: aload_0        
        //   138: aload_1        
        //   139: aload_3        
        //   140: invokestatic    com/squareup/okhttp/internal/DiskLruCache$Entry.access$8:(Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)J
        //   143: aload           6
        //   145: aload_3        
        //   146: invokestatic    com/squareup/okhttp/internal/DiskLruCache$Entry.access$7:(Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)[J
        //   149: aconst_null    
        //   150: invokespecial   com/squareup/okhttp/internal/DiskLruCache$Snapshot.<init>:(Lcom/squareup/okhttp/internal/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;[JLcom/squareup/okhttp/internal/DiskLruCache$Snapshot;)V
        //   153: astore          4
        //   155: goto            30
        //   158: astore_2       
        //   159: aload_0        
        //   160: monitorexit    
        //   161: aload_2        
        //   162: athrow         
        //   163: aload           6
        //   165: iload           7
        //   167: new             Ljava/io/FileInputStream;
        //   170: dup            
        //   171: aload_3        
        //   172: iload           7
        //   174: invokevirtual   com/squareup/okhttp/internal/DiskLruCache$Entry.getCleanFile:(I)Ljava/io/File;
        //   177: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //   180: aastore        
        //   181: iinc            7, 1
        //   184: goto            61
        //   187: astore          8
        //   189: iconst_0       
        //   190: istore          9
        //   192: aload_0        
        //   193: getfield        com/squareup/okhttp/internal/DiskLruCache.valueCount:I
        //   196: istore          10
        //   198: aconst_null    
        //   199: astore          4
        //   201: iload           9
        //   203: iload           10
        //   205: if_icmpge       30
        //   208: aload           6
        //   210: iload           9
        //   212: aaload         
        //   213: astore          11
        //   215: aconst_null    
        //   216: astore          4
        //   218: aload           11
        //   220: ifnull          30
        //   223: aload           6
        //   225: iload           9
        //   227: aaload         
        //   228: invokestatic    com/squareup/okhttp/internal/Util.closeQuietly:(Ljava/io/Closeable;)V
        //   231: iinc            9, 1
        //   234: goto            192
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  2      23     158    163    Any
        //  35     41     158    163    Any
        //  49     58     158    163    Any
        //  61     67     187    237    Ljava/io/FileNotFoundException;
        //  61     67     158    163    Any
        //  74     133    158    163    Any
        //  133    155    158    163    Any
        //  163    181    187    237    Ljava/io/FileNotFoundException;
        //  163    181    158    163    Any
        //  192    198    158    163    Any
        //  208    215    158    163    Any
        //  223    231    158    163    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0061:
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
    
    public File getDirectory() {
        return this.directory;
    }
    
    public long getMaxSize() {
        return this.maxSize;
    }
    
    public boolean isClosed() {
        return this.journalWriter == null;
    }
    
    public boolean remove(final String key) throws IOException {
        while (true) {
            while (true) {
                final Entry entry;
                int n;
                synchronized (this) {
                    this.checkNotClosed();
                    this.validateKey(key);
                    entry = this.lruEntries.get(key);
                    if (entry == null || entry.currentEditor != null) {
                        return false;
                    }
                    n = 0;
                    if (n >= this.valueCount) {
                        ++this.redundantOpCount;
                        this.journalWriter.append((CharSequence)("REMOVE " + key + '\n'));
                        this.lruEntries.remove(key);
                        if (this.journalRebuildRequired()) {
                            this.executorService.submit(this.cleanupCallable);
                        }
                        return true;
                    }
                    else {
                        final File cleanFile = entry.getCleanFile(n);
                        if (!cleanFile.delete()) {
                            throw new IOException("failed to delete " + cleanFile);
                        }
                    }
                }
                this.size -= entry.lengths[n];
                entry.lengths[n] = 0L;
                ++n;
                continue;
            }
            return true;
        }
    }
    
    public void setMaxSize(final long maxSize) {
        synchronized (this) {
            this.maxSize = maxSize;
            this.executorService.submit(this.cleanupCallable);
        }
    }
    
    public long size() {
        synchronized (this) {
            return this.size;
        }
    }
    
    public final class Editor
    {
        private boolean committed;
        private final Entry entry;
        private boolean hasErrors;
        private final boolean[] written;
        
        private Editor(final Entry entry) {
            this.entry = entry;
            boolean[] written;
            if (entry.readable) {
                written = null;
            }
            else {
                written = new boolean[DiskLruCache.this.valueCount];
            }
            this.written = written;
        }
        
        static /* synthetic */ void access$0(final Editor editor, final boolean hasErrors) {
            editor.hasErrors = hasErrors;
        }
        
        public void abort() throws IOException {
            DiskLruCache.this.completeEdit(this, false);
        }
        
        public void abortUnlessCommitted() {
            if (this.committed) {
                return;
            }
            try {
                this.abort();
            }
            catch (IOException ex) {}
        }
        
        public void commit() throws IOException {
            if (this.hasErrors) {
                DiskLruCache.this.completeEdit(this, false);
                DiskLruCache.this.remove(this.entry.key);
            }
            else {
                DiskLruCache.this.completeEdit(this, true);
            }
            this.committed = true;
        }
        
        public String getString(final int n) throws IOException {
            final InputStream inputStream = this.newInputStream(n);
            if (inputStream != null) {
                return inputStreamToString(inputStream);
            }
            return null;
        }
        
        public InputStream newInputStream(final int n) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
            }
            if (!this.entry.readable) {
                // monitorexit(diskLruCache)
                return null;
            }
            try {
                // monitorexit(diskLruCache)
                return new FileInputStream(this.entry.getCleanFile(n));
            }
            catch (FileNotFoundException ex) {
                // monitorexit(diskLruCache)
                return null;
            }
        }
        
        public OutputStream newOutputStream(final int n) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
            }
            if (!this.entry.readable) {
                this.written[n] = true;
            }
            final File dirtyFile = this.entry.getDirtyFile(n);
            try {
                final FileOutputStream fileOutputStream = new FileOutputStream(dirtyFile);
                // monitorexit(diskLruCache)
                return new FaultHidingOutputStream((OutputStream)fileOutputStream, (FaultHidingOutputStream)null);
            }
            catch (FileNotFoundException ex) {
                DiskLruCache.this.directory.mkdirs();
                try {
                    final FileOutputStream fileOutputStream = new FileOutputStream(dirtyFile);
                }
                catch (FileNotFoundException ex2) {
                    // monitorexit(diskLruCache)
                    return DiskLruCache.NULL_OUTPUT_STREAM;
                }
            }
        }
        
        public void set(final int n, final String s) throws IOException {
            Closeable closeable = null;
            OutputStreamWriter outputStreamWriter;
            try {
                final OutputStreamWriter outputStreamWriter2;
                outputStreamWriter = (outputStreamWriter2 = new OutputStreamWriter(this.newOutputStream(n), Util.UTF_8));
                final String s2 = s;
                outputStreamWriter2.write(s2);
                final OutputStreamWriter outputStreamWriter3 = outputStreamWriter;
                Util.closeQuietly(outputStreamWriter3);
                return;
            }
            finally {
                final Object o2;
                final Object o = o2;
            }
            while (true) {
                try {
                    final OutputStreamWriter outputStreamWriter2 = outputStreamWriter;
                    final String s2 = s;
                    outputStreamWriter2.write(s2);
                    final OutputStreamWriter outputStreamWriter3 = outputStreamWriter;
                    Util.closeQuietly(outputStreamWriter3);
                    return;
                    Util.closeQuietly(closeable);
                    throw;
                }
                finally {
                    closeable = outputStreamWriter;
                    continue;
                }
                break;
            }
        }
        
        private class FaultHidingOutputStream extends FilterOutputStream
        {
            private FaultHidingOutputStream(final OutputStream out) {
                super(out);
            }
            
            @Override
            public void close() {
                try {
                    this.out.close();
                }
                catch (IOException ex) {
                    Editor.access$0(Editor.this, true);
                }
            }
            
            @Override
            public void flush() {
                try {
                    this.out.flush();
                }
                catch (IOException ex) {
                    Editor.access$0(Editor.this, true);
                }
            }
            
            @Override
            public void write(final int n) {
                try {
                    this.out.write(n);
                }
                catch (IOException ex) {
                    Editor.access$0(Editor.this, true);
                }
            }
            
            @Override
            public void write(final byte[] b, final int off, final int len) {
                try {
                    this.out.write(b, off, len);
                }
                catch (IOException ex) {
                    Editor.access$0(Editor.this, true);
                }
            }
        }
    }
    
    private final class Entry
    {
        private Editor currentEditor;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;
        
        private Entry(final String key) {
            this.key = key;
            this.lengths = new long[DiskLruCache.this.valueCount];
        }
        
        static /* synthetic */ void access$4(final Entry entry, final boolean readable) {
            entry.readable = readable;
        }
        
        static /* synthetic */ void access$5(final Entry entry, final Editor currentEditor) {
            entry.currentEditor = currentEditor;
        }
        
        static /* synthetic */ void access$9(final Entry entry, final long sequenceNumber) {
            entry.sequenceNumber = sequenceNumber;
        }
        
        private IOException invalidLengths(final String[] a) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(a));
        }
        
        private void setLengths(final String[] array) throws IOException {
            if (array.length != DiskLruCache.this.valueCount) {
                throw this.invalidLengths(array);
            }
            int i = 0;
            try {
                while (i < array.length) {
                    this.lengths[i] = Long.parseLong(array[i]);
                    ++i;
                }
            }
            catch (NumberFormatException ex) {
                throw this.invalidLengths(array);
            }
        }
        
        public File getCleanFile(final int i) {
            return new File(DiskLruCache.this.directory, String.valueOf(this.key) + "." + i);
        }
        
        public File getDirtyFile(final int i) {
            return new File(DiskLruCache.this.directory, String.valueOf(this.key) + "." + i + ".tmp");
        }
        
        public String getLengths() throws IOException {
            final StringBuilder sb = new StringBuilder();
            final long[] lengths = this.lengths;
            for (int length = lengths.length, i = 0; i < length; ++i) {
                sb.append(' ').append(lengths[i]);
            }
            return sb.toString();
        }
    }
    
    public final class Snapshot implements Closeable
    {
        private final InputStream[] ins;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        
        private Snapshot(final String key, final long sequenceNumber, final InputStream[] ins, final long[] lengths) {
            this.key = key;
            this.sequenceNumber = sequenceNumber;
            this.ins = ins;
            this.lengths = lengths;
        }
        
        @Override
        public void close() {
            final InputStream[] ins = this.ins;
            for (int length = ins.length, i = 0; i < length; ++i) {
                Util.closeQuietly(ins[i]);
            }
        }
        
        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }
        
        public InputStream getInputStream(final int n) {
            return this.ins[n];
        }
        
        public long getLength(final int n) {
            return this.lengths[n];
        }
        
        public String getString(final int n) throws IOException {
            return inputStreamToString(this.getInputStream(n));
        }
    }
}
