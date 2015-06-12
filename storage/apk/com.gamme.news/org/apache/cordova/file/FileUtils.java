// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.file;

import java.util.HashSet;
import android.util.Log;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import android.content.Context;
import java.util.HashMap;
import org.apache.cordova.PluginResult;
import android.net.Uri;
import org.apache.cordova.CallbackContext;
import java.net.URLDecoder;
import android.app.Activity;
import android.os.Environment;
import java.io.File;
import java.util.Iterator;
import org.json.JSONObject;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONArray;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.apache.cordova.CordovaPlugin;

public class FileUtils extends CordovaPlugin
{
    public static int ABORT_ERR = 0;
    public static int ENCODING_ERR = 0;
    public static int INVALID_MODIFICATION_ERR = 0;
    public static int INVALID_STATE_ERR = 0;
    private static final String LOG_TAG = "FileUtils";
    public static int NOT_FOUND_ERR;
    public static int NOT_READABLE_ERR;
    public static int NO_MODIFICATION_ALLOWED_ERR;
    public static int PATH_EXISTS_ERR;
    public static int QUOTA_EXCEEDED_ERR;
    public static int SECURITY_ERR;
    public static int SYNTAX_ERR;
    public static int TYPE_MISMATCH_ERR;
    public static int UNKNOWN_ERR;
    private static FileUtils filePlugin;
    private boolean configured;
    private ArrayList<Filesystem> filesystems;
    
    static {
        FileUtils.NOT_FOUND_ERR = 1;
        FileUtils.SECURITY_ERR = 2;
        FileUtils.ABORT_ERR = 3;
        FileUtils.NOT_READABLE_ERR = 4;
        FileUtils.ENCODING_ERR = 5;
        FileUtils.NO_MODIFICATION_ALLOWED_ERR = 6;
        FileUtils.INVALID_STATE_ERR = 7;
        FileUtils.SYNTAX_ERR = 8;
        FileUtils.INVALID_MODIFICATION_ERR = 9;
        FileUtils.QUOTA_EXCEEDED_ERR = 10;
        FileUtils.TYPE_MISMATCH_ERR = 11;
        FileUtils.PATH_EXISTS_ERR = 12;
        FileUtils.UNKNOWN_ERR = 1000;
    }
    
    public FileUtils() {
        this.configured = false;
    }
    
    private Filesystem filesystemForName(final String anObject) {
        for (final Filesystem filesystem : this.filesystems) {
            if (filesystem != null && filesystem.name != null && filesystem.name.equals(anObject)) {
                return filesystem;
            }
        }
        return null;
    }
    
    private Filesystem filesystemForURL(final LocalFilesystemURL localFilesystemURL) {
        if (localFilesystemURL == null) {
            return null;
        }
        return this.filesystemForName(localFilesystemURL.filesystemName);
    }
    
    @Deprecated
    public static JSONObject getEntry(final File file) throws JSONException {
        if (getFilePlugin() != null) {
            return getFilePlugin().getEntryForFile(file);
        }
        return null;
    }
    
    private JSONObject getFile(final String s, final String s2, final JSONObject jsonObject, final boolean b) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
        LocalFilesystemURL localFilesystemURL;
        Filesystem filesystemForURL;
        try {
            localFilesystemURL = new LocalFilesystemURL(s);
            filesystemForURL = this.filesystemForURL(localFilesystemURL);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
        }
        catch (IllegalArgumentException ex) {
            throw new MalformedURLException("Unrecognized filesystem URL");
        }
        return filesystemForURL.getFileForLocalURL(localFilesystemURL, s2, jsonObject, b);
    }
    
    private JSONObject getFileMetadata(final String s) throws FileNotFoundException, JSONException, MalformedURLException {
        LocalFilesystemURL localFilesystemURL;
        Filesystem filesystemForURL;
        try {
            localFilesystemURL = new LocalFilesystemURL(s);
            filesystemForURL = this.filesystemForURL(localFilesystemURL);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
        }
        catch (IllegalArgumentException ex) {
            throw new MalformedURLException("Unrecognized filesystem URL");
        }
        return filesystemForURL.getFileMetadataForLocalURL(localFilesystemURL);
    }
    
    public static FileUtils getFilePlugin() {
        return FileUtils.filePlugin;
    }
    
    private JSONObject getParent(final String s) throws JSONException, IOException {
        LocalFilesystemURL localFilesystemURL;
        Filesystem filesystemForURL;
        try {
            localFilesystemURL = new LocalFilesystemURL(s);
            filesystemForURL = this.filesystemForURL(localFilesystemURL);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
        }
        catch (IllegalArgumentException ex) {
            throw new MalformedURLException("Unrecognized filesystem URL");
        }
        return filesystemForURL.getParentForLocalURL(localFilesystemURL);
    }
    
    private JSONArray readEntries(final String s) throws FileNotFoundException, JSONException, MalformedURLException {
        LocalFilesystemURL localFilesystemURL;
        Filesystem filesystemForURL;
        try {
            localFilesystemURL = new LocalFilesystemURL(s);
            filesystemForURL = this.filesystemForURL(localFilesystemURL);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
        }
        catch (IllegalArgumentException ex) {
            throw new MalformedURLException("Unrecognized filesystem URL");
        }
        return filesystemForURL.readEntriesAtLocalURL(localFilesystemURL);
    }
    
    private boolean remove(final String s) throws NoModificationAllowedException, InvalidModificationException, MalformedURLException {
        LocalFilesystemURL localFilesystemURL;
        try {
            localFilesystemURL = new LocalFilesystemURL(s);
            if ("".equals(localFilesystemURL.fullPath) || "/".equals(localFilesystemURL.fullPath)) {
                throw new NoModificationAllowedException("You can't delete the root directory");
            }
        }
        catch (IllegalArgumentException ex) {
            throw new MalformedURLException("Unrecognized filesystem URL");
        }
        final Filesystem filesystemForURL = this.filesystemForURL(localFilesystemURL);
        if (filesystemForURL == null) {
            throw new MalformedURLException("No installed handlers for this URL");
        }
        return filesystemForURL.removeFileAtLocalURL(localFilesystemURL);
    }
    
    private boolean removeRecursively(final String s) throws FileExistsException, NoModificationAllowedException, MalformedURLException {
        LocalFilesystemURL localFilesystemURL;
        try {
            localFilesystemURL = new LocalFilesystemURL(s);
            if ("".equals(localFilesystemURL.fullPath) || "/".equals(localFilesystemURL.fullPath)) {
                throw new NoModificationAllowedException("You can't delete the root directory");
            }
        }
        catch (IllegalArgumentException ex) {
            throw new MalformedURLException("Unrecognized filesystem URL");
        }
        final Filesystem filesystemForURL = this.filesystemForURL(localFilesystemURL);
        if (filesystemForURL == null) {
            throw new MalformedURLException("No installed handlers for this URL");
        }
        return filesystemForURL.recursiveRemoveFileAtLocalURL(localFilesystemURL);
    }
    
    private JSONArray requestAllFileSystems() throws IOException, JSONException {
        final JSONArray jsonArray = new JSONArray();
        for (final Filesystem filesystem : this.filesystems) {
            jsonArray.put((Object)filesystem.getEntryForLocalURL(new LocalFilesystemURL("cdvfile://localhost/" + filesystem.name + "/")));
        }
        return jsonArray;
    }
    
    private JSONObject requestAllPaths() throws JSONException {
        final Activity activity = this.cordova.getActivity();
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("applicationDirectory", (Object)"file:///android_asset/");
        jsonObject.put("applicationStorageDirectory", (Object)toDirUrl(((Context)activity).getFilesDir().getParentFile()));
        jsonObject.put("dataDirectory", (Object)toDirUrl(((Context)activity).getFilesDir()));
        jsonObject.put("cacheDirectory", (Object)toDirUrl(((Context)activity).getCacheDir()));
        jsonObject.put("externalApplicationStorageDirectory", (Object)toDirUrl(((Context)activity).getExternalFilesDir((String)null).getParentFile()));
        jsonObject.put("externalDataDirectory", (Object)toDirUrl(((Context)activity).getExternalFilesDir((String)null)));
        jsonObject.put("externalCacheDirectory", (Object)toDirUrl(((Context)activity).getExternalCacheDir()));
        jsonObject.put("externalRootDirectory", (Object)toDirUrl(Environment.getExternalStorageDirectory()));
        return jsonObject;
    }
    
    private JSONObject requestFileSystem(final int index) throws IOException, JSONException {
        final JSONObject jsonObject = new JSONObject();
        while (true) {
            try {
                final Filesystem filesystem = this.filesystems.get(index);
                if (filesystem == null) {
                    throw new IOException("No filesystem of type requested");
                }
                final LocalFilesystemURL localFilesystemURL = new LocalFilesystemURL("cdvfile://localhost/" + filesystem.name + "/");
                jsonObject.put("name", (Object)filesystem.name);
                jsonObject.put("root", (Object)filesystem.getEntryForLocalURL(localFilesystemURL));
                return jsonObject;
            }
            catch (ArrayIndexOutOfBoundsException ex) {
                final Filesystem filesystem = null;
                continue;
            }
            break;
        }
    }
    
    private JSONObject resolveLocalFileSystemURI(String string) throws IOException, JSONException {
        if (string == null) {
            throw new MalformedURLException("Unrecognized filesystem URL");
        }
        while (true) {
            final int index;
            Label_0122: {
                if (!string.startsWith("file:/")) {
                    final LocalFilesystemURL filesystemURLforLocalPath = new LocalFilesystemURL(string);
                    break Label_0122;
                }
                if (!string.startsWith("file://")) {
                    string = "file:///" + string.substring(6);
                }
                final String decode = URLDecoder.decode(string, "UTF-8");
                index = decode.indexOf("?");
                if (index >= 0) {
                    break Label_0122;
                }
                final int length = decode.length();
                final int index2 = decode.indexOf("/", 7);
                String substring;
                if (index2 < 0 || index2 > length) {
                    substring = "";
                }
                else {
                    substring = decode.substring(index2, length);
                }
                final LocalFilesystemURL filesystemURLforLocalPath = this.filesystemURLforLocalPath(substring);
                try {
                    final Filesystem filesystemForURL = this.filesystemForURL(filesystemURLforLocalPath);
                    if (filesystemForURL == null) {
                        throw new MalformedURLException("No installed handlers for this URL");
                    }
                    return filesystemForURL.getEntryForLocalURL(filesystemURLforLocalPath);
                }
                catch (IllegalArgumentException ex) {
                    throw new MalformedURLException("Unrecognized filesystem URL");
                }
            }
            final int length = index;
            continue;
        }
    }
    
    private void threadhelper(final FileOp fileOp, final CallbackContext callbackContext) {
        this.cordova.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    fileOp.run();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    if (ex instanceof EncodingException) {
                        callbackContext.error(FileUtils.ENCODING_ERR);
                        return;
                    }
                    if (ex instanceof FileNotFoundException) {
                        callbackContext.error(FileUtils.NOT_FOUND_ERR);
                        return;
                    }
                    if (ex instanceof FileExistsException) {
                        callbackContext.error(FileUtils.PATH_EXISTS_ERR);
                        return;
                    }
                    if (ex instanceof NoModificationAllowedException) {
                        callbackContext.error(FileUtils.NO_MODIFICATION_ALLOWED_ERR);
                        return;
                    }
                    if (ex instanceof InvalidModificationException) {
                        callbackContext.error(FileUtils.INVALID_MODIFICATION_ERR);
                        return;
                    }
                    if (ex instanceof MalformedURLException) {
                        callbackContext.error(FileUtils.ENCODING_ERR);
                        return;
                    }
                    if (ex instanceof IOException) {
                        callbackContext.error(FileUtils.INVALID_MODIFICATION_ERR);
                        return;
                    }
                    if (ex instanceof EncodingException) {
                        callbackContext.error(FileUtils.ENCODING_ERR);
                        return;
                    }
                    if (ex instanceof TypeMismatchException) {
                        callbackContext.error(FileUtils.TYPE_MISMATCH_ERR);
                        return;
                    }
                    callbackContext.error(FileUtils.UNKNOWN_ERR);
                }
            }
        });
    }
    
    private static String toDirUrl(final File file) {
        return String.valueOf(Uri.fromFile(file).toString()) + '/';
    }
    
    private JSONObject transferTo(final String s, final String s2, final String s3, final boolean b) throws JSONException, NoModificationAllowedException, IOException, InvalidModificationException, EncodingException, FileExistsException {
        if (s == null || s2 == null) {
            throw new FileNotFoundException();
        }
        final LocalFilesystemURL localFilesystemURL = new LocalFilesystemURL(s);
        final LocalFilesystemURL localFilesystemURL2 = new LocalFilesystemURL(s2);
        final Filesystem filesystemForURL = this.filesystemForURL(localFilesystemURL);
        final Filesystem filesystemForURL2 = this.filesystemForURL(localFilesystemURL2);
        if (s3 != null && s3.contains(":")) {
            throw new EncodingException("Bad file name");
        }
        return filesystemForURL2.copyFileToURL(localFilesystemURL2, s3, filesystemForURL, localFilesystemURL, b);
    }
    
    private long truncateFile(final String s, final long n) throws FileNotFoundException, IOException, NoModificationAllowedException {
        LocalFilesystemURL localFilesystemURL;
        Filesystem filesystemForURL;
        try {
            localFilesystemURL = new LocalFilesystemURL(s);
            filesystemForURL = this.filesystemForURL(localFilesystemURL);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
        }
        catch (IllegalArgumentException ex) {
            throw new MalformedURLException("Unrecognized filesystem URL");
        }
        return filesystemForURL.truncateFileAtURL(localFilesystemURL, n);
    }
    
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext callbackContext) throws JSONException {
        if (!this.configured) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, "File plugin is not configured. Please see the README.md file for details on how to update config.xml"));
            return true;
        }
        if (s.equals("testSaveLocationExists")) {
            this.threadhelper((FileOp)new FileOp() {
                @Override
                public void run() {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, DirectoryManager.testSaveLocationExists()));
                }
            }, callbackContext);
        }
        else if (s.equals("getFreeDiskSpace")) {
            this.threadhelper((FileOp)new FileOp() {
                @Override
                public void run() {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, DirectoryManager.getFreeDiskSpace(false)));
                }
            }, callbackContext);
        }
        else if (s.equals("testFileExists")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                
                @Override
                public void run() {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, DirectoryManager.testFileExists(this.val$fname)));
                }
            }, callbackContext);
        }
        else if (s.equals("testDirectoryExists")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                
                @Override
                public void run() {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, DirectoryManager.testFileExists(this.val$fname)));
                }
            }, callbackContext);
        }
        else if (s.equals("readAsText")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$encoding = jsonArray.getString(1);
                private final /* synthetic */ int val$end = jsonArray.getInt(3);
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                private final /* synthetic */ int val$start = jsonArray.getInt(2);
                
                @Override
                public void run() throws MalformedURLException {
                    FileUtils.this.readFileAs(this.val$fname, this.val$start, this.val$end, callbackContext, this.val$encoding, 1);
                }
            }, callbackContext);
        }
        else if (s.equals("readAsDataURL")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ int val$end = jsonArray.getInt(2);
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                private final /* synthetic */ int val$start = jsonArray.getInt(1);
                
                @Override
                public void run() throws MalformedURLException {
                    FileUtils.this.readFileAs(this.val$fname, this.val$start, this.val$end, callbackContext, null, -1);
                }
            }, callbackContext);
        }
        else if (s.equals("readAsArrayBuffer")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ int val$end = jsonArray.getInt(2);
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                private final /* synthetic */ int val$start = jsonArray.getInt(1);
                
                @Override
                public void run() throws MalformedURLException {
                    FileUtils.this.readFileAs(this.val$fname, this.val$start, this.val$end, callbackContext, null, 6);
                }
            }, callbackContext);
        }
        else if (s.equals("readAsBinaryString")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ int val$end = jsonArray.getInt(2);
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                private final /* synthetic */ int val$start = jsonArray.getInt(1);
                
                @Override
                public void run() throws MalformedURLException {
                    FileUtils.this.readFileAs(this.val$fname, this.val$start, this.val$end, callbackContext, null, 7);
                }
            }, callbackContext);
        }
        else if (s.equals("write")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$data = jsonArray.getString(1);
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                private final /* synthetic */ Boolean val$isBinary = jsonArray.getBoolean(3);
                private final /* synthetic */ int val$offset = jsonArray.getInt(2);
                
                @Override
                public void run() throws FileNotFoundException, IOException, NoModificationAllowedException {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, FileUtils.this.write(this.val$fname, this.val$data, this.val$offset, this.val$isBinary)));
                }
            }, callbackContext);
        }
        else if (s.equals("truncate")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                private final /* synthetic */ int val$offset = jsonArray.getInt(1);
                
                @Override
                public void run() throws FileNotFoundException, IOException, NoModificationAllowedException {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, FileUtils.this.truncateFile(this.val$fname, this.val$offset)));
                }
            }, callbackContext);
        }
        else if (s.equals("requestAllFileSystems")) {
            this.threadhelper((FileOp)new FileOp() {
                @Override
                public void run() throws IOException, JSONException {
                    callbackContext.success(FileUtils.this.requestAllFileSystems());
                }
            }, callbackContext);
        }
        else if (s.equals("requestAllPaths")) {
            callbackContext.success(this.requestAllPaths());
        }
        else if (s.equals("requestFileSystem")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ int val$fstype = jsonArray.getInt(0);
                private final /* synthetic */ long val$size = jsonArray.optLong(1);
                
                @Override
                public void run() throws IOException, JSONException {
                    if (this.val$size != 0L && this.val$size > 1024L * DirectoryManager.getFreeDiskSpace(true)) {
                        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, FileUtils.QUOTA_EXCEEDED_ERR));
                        return;
                    }
                    callbackContext.success(FileUtils.this.requestFileSystem(this.val$fstype));
                }
            }, callbackContext);
        }
        else if (s.equals("resolveLocalFileSystemURI")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                
                @Override
                public void run() throws IOException, JSONException {
                    callbackContext.success(FileUtils.this.resolveLocalFileSystemURI(this.val$fname));
                }
            }, callbackContext);
        }
        else if (s.equals("getMetadata") || s.equals("getFileMetadata")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                
                @Override
                public void run() throws FileNotFoundException, JSONException, MalformedURLException {
                    callbackContext.success(FileUtils.this.getFileMetadata(this.val$fname));
                }
            }, callbackContext);
        }
        else if (s.equals("getParent")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                
                @Override
                public void run() throws JSONException, IOException {
                    callbackContext.success(FileUtils.this.getParent(this.val$fname));
                }
            }, callbackContext);
        }
        else if (s.equals("getDirectory")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$dirname = jsonArray.getString(0);
                private final /* synthetic */ String val$path = jsonArray.getString(1);
                
                @Override
                public void run() throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
                    callbackContext.success(FileUtils.this.getFile(this.val$dirname, this.val$path, jsonArray.optJSONObject(2), true));
                }
            }, callbackContext);
        }
        else if (s.equals("getFile")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$dirname = jsonArray.getString(0);
                private final /* synthetic */ String val$path = jsonArray.getString(1);
                
                @Override
                public void run() throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
                    callbackContext.success(FileUtils.this.getFile(this.val$dirname, this.val$path, jsonArray.optJSONObject(2), false));
                }
            }, callbackContext);
        }
        else if (s.equals("remove")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                
                @Override
                public void run() throws NoModificationAllowedException, InvalidModificationException, MalformedURLException {
                    if (FileUtils.this.remove(this.val$fname)) {
                        callbackContext.success();
                        return;
                    }
                    callbackContext.error(FileUtils.NO_MODIFICATION_ALLOWED_ERR);
                }
            }, callbackContext);
        }
        else if (s.equals("removeRecursively")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                
                @Override
                public void run() throws FileExistsException, MalformedURLException, NoModificationAllowedException {
                    if (FileUtils.this.removeRecursively(this.val$fname)) {
                        callbackContext.success();
                        return;
                    }
                    callbackContext.error(FileUtils.NO_MODIFICATION_ALLOWED_ERR);
                }
            }, callbackContext);
        }
        else if (s.equals("moveTo")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                private final /* synthetic */ String val$newName = jsonArray.getString(2);
                private final /* synthetic */ String val$newParent = jsonArray.getString(1);
                
                @Override
                public void run() throws JSONException, NoModificationAllowedException, IOException, InvalidModificationException, EncodingException, FileExistsException {
                    callbackContext.success(FileUtils.this.transferTo(this.val$fname, this.val$newParent, this.val$newName, true));
                }
            }, callbackContext);
        }
        else if (s.equals("copyTo")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                private final /* synthetic */ String val$newName = jsonArray.getString(2);
                private final /* synthetic */ String val$newParent = jsonArray.getString(1);
                
                @Override
                public void run() throws JSONException, NoModificationAllowedException, IOException, InvalidModificationException, EncodingException, FileExistsException {
                    callbackContext.success(FileUtils.this.transferTo(this.val$fname, this.val$newParent, this.val$newName, false));
                }
            }, callbackContext);
        }
        else if (s.equals("readEntries")) {
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$fname = jsonArray.getString(0);
                
                @Override
                public void run() throws FileNotFoundException, JSONException, MalformedURLException {
                    callbackContext.success(FileUtils.this.readEntries(this.val$fname));
                }
            }, callbackContext);
        }
        else {
            if (!s.equals("_getLocalFilesystemPath")) {
                return false;
            }
            this.threadhelper((FileOp)new FileOp() {
                private final /* synthetic */ String val$localURLstr = jsonArray.getString(0);
                
                @Override
                public void run() throws FileNotFoundException, JSONException, MalformedURLException {
                    callbackContext.success(FileUtils.this.filesystemPathForURL(this.val$localURLstr));
                }
            }, callbackContext);
        }
        return true;
    }
    
    public String filesystemPathForURL(final String s) throws MalformedURLException {
        LocalFilesystemURL localFilesystemURL;
        Filesystem filesystemForURL;
        try {
            localFilesystemURL = new LocalFilesystemURL(s);
            filesystemForURL = this.filesystemForURL(localFilesystemURL);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
        }
        catch (IllegalArgumentException ex) {
            throw new MalformedURLException("Unrecognized filesystem URL");
        }
        return filesystemForURL.filesystemPathForURL(localFilesystemURL);
    }
    
    public LocalFilesystemURL filesystemURLforLocalPath(final String s) {
        LocalFilesystemURL localFilesystemURL = null;
        int length = 0;
        for (final Filesystem filesystem : this.filesystems) {
            if (filesystem != null) {
                final LocalFilesystemURL urLforFilesystemPath = filesystem.URLforFilesystemPath(s);
                if (urLforFilesystemPath == null || (localFilesystemURL != null && urLforFilesystemPath.fullPath.length() >= length)) {
                    continue;
                }
                localFilesystemURL = urLforFilesystemPath;
                length = urLforFilesystemPath.fullPath.length();
            }
        }
        return localFilesystemURL;
    }
    
    protected HashMap<String, String> getAvailableFileSystems(final Activity activity) {
        final Context applicationContext = activity.getApplicationContext();
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("files", applicationContext.getFilesDir().getAbsolutePath());
        hashMap.put("files-external", applicationContext.getExternalFilesDir((String)null).getAbsolutePath());
        hashMap.put("documents", new File(applicationContext.getFilesDir(), "Documents").getAbsolutePath());
        hashMap.put("sdcard", Environment.getExternalStorageDirectory().getAbsolutePath());
        hashMap.put("cache", applicationContext.getCacheDir().getAbsolutePath());
        hashMap.put("cache-external", applicationContext.getExternalCacheDir().getAbsolutePath());
        hashMap.put("root", "/");
        return hashMap;
    }
    
    public JSONObject getEntryForFile(final File file) throws JSONException {
        final Iterator<Filesystem> iterator = this.filesystems.iterator();
        while (iterator.hasNext()) {
            final JSONObject entryForFile = iterator.next().makeEntryForFile(file);
            if (entryForFile != null) {
                return entryForFile;
            }
        }
        return null;
    }
    
    protected String[] getExtraFileSystemsPreference(final Activity activity) {
        String stringExtra = activity.getIntent().getStringExtra("androidextrafilesystems");
        if (stringExtra == null) {
            stringExtra = "files,files-external,documents,sdcard,cache,cache-external,root";
        }
        return stringExtra.split(",");
    }
    
    @Override
    public void initialize(final CordovaInterface cordovaInterface, final CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        this.filesystems = new ArrayList<Filesystem>();
        final Activity activity = cordovaInterface.getActivity();
        final String packageName = activity.getPackageName();
        String stringExtra = activity.getIntent().getStringExtra("androidpersistentfilelocation");
        if (stringExtra == null) {
            stringExtra = "compatibility";
        }
        String pathname = activity.getCacheDir().getAbsolutePath();
        String pathname2;
        if ("internal".equalsIgnoreCase(stringExtra)) {
            pathname2 = String.valueOf(activity.getFilesDir().getAbsolutePath()) + "/files/";
            this.configured = true;
        }
        else {
            final boolean equalsIgnoreCase = "compatibility".equalsIgnoreCase(stringExtra);
            pathname2 = null;
            if (equalsIgnoreCase) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    pathname2 = Environment.getExternalStorageDirectory().getAbsolutePath();
                    pathname = String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()) + "/Android/data/" + packageName + "/cache/";
                }
                else {
                    pathname2 = "/data/data/" + packageName;
                }
                this.configured = true;
            }
        }
        if (this.configured) {
            new File(pathname).mkdirs();
            new File(pathname2).mkdirs();
            this.registerFilesystem(new LocalFilesystem("temporary", cordovaInterface, pathname));
            this.registerFilesystem(new LocalFilesystem("persistent", cordovaInterface, pathname2));
            this.registerFilesystem(new ContentFilesystem("content", cordovaInterface, cordovaWebView));
            this.registerExtraFileSystems(this.getExtraFileSystemsPreference(activity), this.getAvailableFileSystems(activity));
            if (FileUtils.filePlugin == null) {
                FileUtils.filePlugin = this;
            }
            return;
        }
        Log.e("FileUtils", "File plugin configuration error: Please set AndroidPersistentFileLocation in config.xml to one of \"internal\" (for new applications) or \"compatibility\" (for compatibility with previous versions)");
        activity.finish();
    }
    
    public void readFileAs(final String s, final int n, final int n2, final CallbackContext callbackContext, final String s2, final int n3) throws MalformedURLException {
        try {
            if (this.filesystemForURL(new LocalFilesystemURL(s)) == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
            goto Label_0045;
        }
        catch (IllegalArgumentException ex2) {
            throw new MalformedURLException("Unrecognized filesystem URL");
        }
        catch (FileNotFoundException ex3) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, FileUtils.NOT_FOUND_ERR));
        }
        catch (IOException ex) {
            Log.d("FileUtils", ex.getLocalizedMessage());
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, FileUtils.NOT_READABLE_ERR));
        }
    }
    
    protected void registerExtraFileSystems(final String[] array, final HashMap<String, String> hashMap) {
        final HashSet<String> set = new HashSet<String>();
        for (final String str : array) {
            if (!set.contains(str)) {
                final String pathname = hashMap.get(str);
                if (pathname != null) {
                    final File file = new File(pathname);
                    if (file.mkdirs() || file.isDirectory()) {
                        this.registerFilesystem(new LocalFilesystem(str, this.cordova, pathname));
                        set.add(str);
                    }
                    else {
                        Log.d("FileUtils", "Unable to create root dir for fileystem \"" + str + "\", skipping");
                    }
                }
                else {
                    Log.d("FileUtils", "Unrecognized extra filesystem identifier: " + str);
                }
            }
        }
    }
    
    public void registerFilesystem(final Filesystem e) {
        if (e != null && this.filesystemForName(e.name) == null) {
            this.filesystems.add(e);
        }
    }
    
    @Override
    public Uri remapUri(final Uri uri) {
        try {
            final LocalFilesystemURL localFilesystemURL = new LocalFilesystemURL(uri);
            final Filesystem filesystemForURL = this.filesystemForURL(localFilesystemURL);
            if (filesystemForURL == null) {
                return null;
            }
            if (filesystemForURL.filesystemPathForURL(localFilesystemURL) != null) {
                return Uri.parse("file:///" + filesystemForURL.filesystemPathForURL(localFilesystemURL));
            }
        }
        catch (IllegalArgumentException ex) {}
        return null;
    }
    
    public long write(final String obj, final String s, final int n, final boolean b) throws FileNotFoundException, IOException, NoModificationAllowedException {
        LocalFilesystemURL localFilesystemURL;
        Filesystem filesystemForURL;
        try {
            localFilesystemURL = new LocalFilesystemURL(obj);
            filesystemForURL = this.filesystemForURL(localFilesystemURL);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
        }
        catch (IllegalArgumentException ex) {
            throw new MalformedURLException("Unrecognized filesystem URL");
        }
        final long writeToFileAtURL = filesystemForURL.writeToFileAtURL(localFilesystemURL, s, n, b);
        Log.d("TEST", String.valueOf(obj) + ": " + writeToFileAtURL);
        return writeToFileAtURL;
    }
    
    private interface FileOp
    {
        void run() throws Exception;
    }
}
