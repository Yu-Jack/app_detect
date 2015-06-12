// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.file;

import android.provider.MediaStore$Images$Media;
import java.io.InputStream;
import org.json.JSONArray;
import android.net.Uri;
import java.io.FileNotFoundException;
import android.database.Cursor;
import org.json.JSONException;
import java.io.OutputStream;
import java.io.IOException;
import org.json.JSONObject;
import java.io.File;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.CordovaInterface;

public class ContentFilesystem extends Filesystem
{
    private CordovaInterface cordova;
    private CordovaResourceApi resourceApi;
    
    public ContentFilesystem(final String name, final CordovaInterface cordova, final CordovaWebView cordovaWebView) {
        this.name = name;
        this.cordova = cordova;
        this.resourceApi = new CordovaResourceApi(cordovaWebView.getContext(), cordovaWebView.pluginManager);
    }
    
    public LocalFilesystemURL URLforFilesystemPath(final String s) {
        return null;
    }
    
    public boolean canRemoveFileAtLocalURL(final LocalFilesystemURL localFilesystemURL) {
        return new File(this.filesystemPathForURL(localFilesystemURL)).exists();
    }
    
    public JSONObject copyFileToURL(final LocalFilesystemURL localFilesystemURL, final String s, final Filesystem filesystem, final LocalFilesystemURL localFilesystemURL2, final boolean b) throws IOException, InvalidModificationException, JSONException, NoModificationAllowedException, FileExistsException {
        if (LocalFilesystem.class.isInstance(filesystem)) {
            final LocalFilesystemURL destinationURL = this.makeDestinationURL(s, localFilesystemURL2, localFilesystemURL);
            final OutputStream openOutputStream = this.resourceApi.openOutputStream(localFilesystemURL.URL);
            final CordovaResourceApi.OpenForReadResult openForRead = this.resourceApi.openForRead(localFilesystemURL2.URL);
            if (b && !filesystem.canRemoveFileAtLocalURL(localFilesystemURL2)) {
                throw new NoModificationAllowedException("Cannot move file at source URL");
            }
            try {
                this.resourceApi.copyResource(openForRead, openOutputStream);
                if (b) {
                    filesystem.removeFileAtLocalURL(localFilesystemURL2);
                }
                return Filesystem.makeEntryForURL(destinationURL, false, destinationURL.URL.toString());
            }
            catch (IOException ex) {
                throw new IOException("Cannot read file at source URL");
            }
        }
        return super.copyFileToURL(localFilesystemURL, s, filesystem, localFilesystemURL2, b);
    }
    
    protected String filesystemPathForCursor(final Cursor cursor) {
        final int columnIndex = cursor.getColumnIndex((new String[] { "_data" })[0]);
        if (columnIndex != -1) {
            return cursor.getString(columnIndex);
        }
        return null;
    }
    
    public String filesystemPathForURL(final LocalFilesystemURL localFilesystemURL) {
        final Cursor openCursorForURL = this.openCursorForURL(localFilesystemURL);
        if (openCursorForURL != null) {
            try {
                if (openCursorForURL.moveToFirst()) {
                    return this.filesystemPathForCursor(openCursorForURL);
                }
            }
            finally {
                if (openCursorForURL != null) {
                    openCursorForURL.close();
                }
            }
        }
        if (openCursorForURL != null) {
            openCursorForURL.close();
        }
        return null;
    }
    
    public JSONObject getEntryForLocalURL(final LocalFilesystemURL localFilesystemURL) throws IOException {
        if ("/".equals(localFilesystemURL.fullPath)) {
            try {
                return Filesystem.makeEntryForURL(localFilesystemURL, true, localFilesystemURL.URL.toString());
            }
            catch (JSONException ex) {
                throw new IOException();
            }
        }
        final Cursor openCursorForURL = this.openCursorForURL(localFilesystemURL);
        Label_0061: {
            if (openCursorForURL == null) {
                break Label_0061;
            }
            try {
                if (!openCursorForURL.moveToFirst()) {
                    throw new FileNotFoundException();
                }
            }
            finally {
                if (openCursorForURL != null) {
                    openCursorForURL.close();
                }
            }
        }
        final String filesystemPathForCursor = this.filesystemPathForCursor(openCursorForURL);
        if (openCursorForURL != null) {
            openCursorForURL.close();
        }
        Label_0135: {
            if (filesystemPathForCursor != null) {
                break Label_0135;
            }
            String s = localFilesystemURL.URL.toString();
            try {
                return Filesystem.makeEntryForPath(localFilesystemURL.fullPath, localFilesystemURL.filesystemName, false, s);
                s = "file://" + filesystemPathForCursor;
                return Filesystem.makeEntryForPath(localFilesystemURL.fullPath, localFilesystemURL.filesystemName, false, s);
            }
            catch (JSONException ex2) {
                throw new IOException();
            }
        }
    }
    
    public JSONObject getFileForLocalURL(final LocalFilesystemURL localFilesystemURL, final String s, final JSONObject jsonObject, final boolean b) throws IOException, TypeMismatchException, JSONException {
        if (jsonObject != null && jsonObject.optBoolean("create")) {
            throw new IOException("Cannot create content url");
        }
        final LocalFilesystemURL localFilesystemURL2 = new LocalFilesystemURL(Uri.withAppendedPath(localFilesystemURL.URL, s));
        final File file = new File(this.filesystemPathForURL(localFilesystemURL2));
        if (!file.exists()) {
            throw new FileNotFoundException("path does not exist");
        }
        if (b) {
            if (file.isFile()) {
                throw new TypeMismatchException("path doesn't exist or is file");
            }
        }
        else if (file.isDirectory()) {
            throw new TypeMismatchException("path doesn't exist or is directory");
        }
        return Filesystem.makeEntryForPath(localFilesystemURL2.fullPath, localFilesystemURL2.filesystemName, b, Uri.fromFile(file).toString());
    }
    
    public JSONObject getFileMetadataForLocalURL(final LocalFilesystemURL p0) throws FileNotFoundException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: aload_1        
        //     2: invokevirtual   org/apache/cordova/file/ContentFilesystem.openCursorForURL:(Lorg/apache/cordova/file/LocalFilesystemURL;)Landroid/database/Cursor;
        //     5: astore_2       
        //     6: aload_2        
        //     7: ifnull          118
        //    10: aload_2        
        //    11: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    16: ifeq            118
        //    19: aload_0        
        //    20: aload_2        
        //    21: invokevirtual   org/apache/cordova/file/ContentFilesystem.resourceSizeForCursor:(Landroid/database/Cursor;)Ljava/lang/Integer;
        //    24: astore          4
        //    26: aload_0        
        //    27: aload_2        
        //    28: invokevirtual   org/apache/cordova/file/ContentFilesystem.lastModifiedDateForCursor:(Landroid/database/Cursor;)Ljava/lang/Integer;
        //    31: astore          5
        //    33: aload_2        
        //    34: ifnull          43
        //    37: aload_2        
        //    38: invokeinterface android/database/Cursor.close:()V
        //    43: new             Lorg/json/JSONObject;
        //    46: dup            
        //    47: invokespecial   org/json/JSONObject.<init>:()V
        //    50: astore          6
        //    52: aload           6
        //    54: ldc             "size"
        //    56: aload           4
        //    58: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //    61: pop            
        //    62: aload           6
        //    64: ldc             "type"
        //    66: aload_0        
        //    67: getfield        org/apache/cordova/file/ContentFilesystem.resourceApi:Lorg/apache/cordova/CordovaResourceApi;
        //    70: aload_1        
        //    71: getfield        org/apache/cordova/file/LocalFilesystemURL.URL:Landroid/net/Uri;
        //    74: invokevirtual   org/apache/cordova/CordovaResourceApi.getMimeType:(Landroid/net/Uri;)Ljava/lang/String;
        //    77: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //    80: pop            
        //    81: aload           6
        //    83: ldc             "name"
        //    85: aload_1        
        //    86: getfield        org/apache/cordova/file/LocalFilesystemURL.filesystemName:Ljava/lang/String;
        //    89: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //    92: pop            
        //    93: aload           6
        //    95: ldc             "fullPath"
        //    97: aload_1        
        //    98: getfield        org/apache/cordova/file/LocalFilesystemURL.fullPath:Ljava/lang/String;
        //   101: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   104: pop            
        //   105: aload           6
        //   107: ldc             "lastModifiedDate"
        //   109: aload           5
        //   111: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   114: pop            
        //   115: aload           6
        //   117: areturn        
        //   118: new             Ljava/io/FileNotFoundException;
        //   121: dup            
        //   122: invokespecial   java/io/FileNotFoundException.<init>:()V
        //   125: athrow         
        //   126: astore_3       
        //   127: aload_2        
        //   128: ifnull          137
        //   131: aload_2        
        //   132: invokeinterface android/database/Cursor.close:()V
        //   137: aload_3        
        //   138: athrow         
        //   139: astore          7
        //   141: aconst_null    
        //   142: areturn        
        //    Exceptions:
        //  throws java.io.FileNotFoundException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                    
        //  -----  -----  -----  -----  ------------------------
        //  10     33     126    139    Any
        //  52     115    139    143    Lorg/json/JSONException;
        //  118    126    126    139    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0118:
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
    
    @Override
    OutputStream getOutputStreamForURL(final LocalFilesystemURL localFilesystemURL) throws IOException {
        return this.resourceApi.openOutputStream(localFilesystemURL.URL);
    }
    
    protected Integer lastModifiedDateForCursor(final Cursor cursor) {
        final int columnIndex = cursor.getColumnIndex((new String[] { "date_modified" })[0]);
        if (columnIndex != -1) {
            final String string = cursor.getString(columnIndex);
            if (string != null) {
                return Integer.parseInt(string, 10);
            }
        }
        return null;
    }
    
    protected Cursor openCursorForURL(final LocalFilesystemURL localFilesystemURL) {
        return this.cordova.getActivity().getContentResolver().query(localFilesystemURL.URL, (String[])null, (String)null, (String[])null, (String)null);
    }
    
    public JSONArray readEntriesAtLocalURL(final LocalFilesystemURL localFilesystemURL) throws FileNotFoundException {
        return null;
    }
    
    public void readFileAtURL(final LocalFilesystemURL localFilesystemURL, final long n, long length, final ReadFileCallback readFileCallback) throws IOException {
        final CordovaResourceApi.OpenForReadResult openForRead = this.resourceApi.openForRead(localFilesystemURL.URL);
        if (length < 0L) {
            length = openForRead.length;
        }
        final long n2 = length - n;
        Label_0049: {
            if (n <= 0L) {
                break Label_0049;
            }
            try {
                openForRead.inputStream.skip(n);
                readFileCallback.handleData(new LimitedInputStream(this, openForRead.inputStream, n2), openForRead.mimeType);
            }
            finally {
                openForRead.inputStream.close();
            }
        }
    }
    
    public boolean recursiveRemoveFileAtLocalURL(final LocalFilesystemURL localFilesystemURL) throws NoModificationAllowedException {
        throw new NoModificationAllowedException("Cannot remove content url");
    }
    
    public boolean removeFileAtLocalURL(final LocalFilesystemURL localFilesystemURL) throws NoModificationAllowedException {
        final String filesystemPathForURL = this.filesystemPathForURL(localFilesystemURL);
        final File file = new File(filesystemPathForURL);
        try {
            this.cordova.getActivity().getContentResolver().delete(MediaStore$Images$Media.EXTERNAL_CONTENT_URI, "_data = ?", new String[] { filesystemPathForURL });
            return file.delete();
        }
        catch (UnsupportedOperationException ex) {
            return file.delete();
        }
    }
    
    protected Integer resourceSizeForCursor(final Cursor cursor) {
        final int columnIndex = cursor.getColumnIndex("_size");
        if (columnIndex != -1) {
            final String string = cursor.getString(columnIndex);
            if (string != null) {
                return Integer.parseInt(string, 10);
            }
        }
        return null;
    }
    
    public long truncateFileAtURL(final LocalFilesystemURL localFilesystemURL, final long n) throws NoModificationAllowedException {
        throw new NoModificationAllowedException("Couldn't truncate file given its content URI");
    }
    
    public long writeToFileAtURL(final LocalFilesystemURL localFilesystemURL, final String s, final int n, final boolean b) throws NoModificationAllowedException {
        throw new NoModificationAllowedException("Couldn't write to file given its content URI");
    }
}
