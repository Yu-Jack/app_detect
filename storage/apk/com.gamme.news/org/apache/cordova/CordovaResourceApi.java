// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import java.io.FileNotFoundException;
import android.database.Cursor;
import java.io.File;
import java.net.URL;
import java.net.HttpURLConnection;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.IOException;
import android.content.res.AssetFileDescriptor;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.apache.http.util.EncodingUtils;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import java.util.Locale;
import android.net.Uri;
import android.os.Looper;
import android.content.Context;
import android.content.ContentResolver;
import android.content.res.AssetManager;
import com.squareup.okhttp.OkHttpClient;

public class CordovaResourceApi
{
    private static final String[] LOCAL_FILE_PROJECTION;
    private static final String LOG_TAG = "CordovaResourceApi";
    public static final int URI_TYPE_ASSET = 1;
    public static final int URI_TYPE_CONTENT = 2;
    public static final int URI_TYPE_DATA = 4;
    public static final int URI_TYPE_FILE = 0;
    public static final int URI_TYPE_HTTP = 5;
    public static final int URI_TYPE_HTTPS = 6;
    public static final int URI_TYPE_RESOURCE = 3;
    public static final int URI_TYPE_UNKNOWN = -1;
    private static OkHttpClient httpClient;
    static Thread jsThread;
    private final AssetManager assetManager;
    private final ContentResolver contentResolver;
    private final PluginManager pluginManager;
    private boolean threadCheckingEnabled;
    
    static {
        LOCAL_FILE_PROJECTION = new String[] { "_data" };
        CordovaResourceApi.httpClient = new OkHttpClient();
    }
    
    public CordovaResourceApi(final Context context, final PluginManager pluginManager) {
        this.threadCheckingEnabled = true;
        this.contentResolver = context.getContentResolver();
        this.assetManager = context.getAssets();
        this.pluginManager = pluginManager;
    }
    
    private void assertBackgroundThread() {
        if (this.threadCheckingEnabled) {
            final Thread currentThread = Thread.currentThread();
            if (currentThread == Looper.getMainLooper().getThread()) {
                throw new IllegalStateException("Do not perform IO operations on the UI thread. Use CordovaInterface.getThreadPool() instead.");
            }
            if (currentThread == CordovaResourceApi.jsThread) {
                throw new IllegalStateException("Tried to perform an IO operation on the WebCore thread. Use CordovaInterface.getThreadPool() instead.");
            }
        }
    }
    
    private static void assertNonRelative(final Uri uri) {
        if (!uri.isAbsolute()) {
            throw new IllegalArgumentException("Relative URIs are not supported.");
        }
    }
    
    private String getDataUriMimeType(final Uri uri) {
        final String schemeSpecificPart = uri.getSchemeSpecificPart();
        final int index = schemeSpecificPart.indexOf(44);
        if (index != -1) {
            final String[] split = schemeSpecificPart.substring(0, index).split(";");
            if (split.length > 0) {
                return split[0];
            }
        }
        return null;
    }
    
    private String getMimeTypeFromPath(final String s) {
        String substring = s;
        final int lastIndex = substring.lastIndexOf(46);
        if (lastIndex != -1) {
            substring = substring.substring(lastIndex + 1);
        }
        final String lowerCase = substring.toLowerCase(Locale.getDefault());
        if (lowerCase.equals("3ga")) {
            return "audio/3gpp";
        }
        if (lowerCase.equals("js")) {
            return "text/javascript";
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
    }
    
    public static int getUriType(final Uri uri) {
        assertNonRelative(uri);
        final String scheme = uri.getScheme();
        if ("content".equals(scheme)) {
            return 2;
        }
        if ("android.resource".equals(scheme)) {
            return 3;
        }
        if ("file".equals(scheme)) {
            if (uri.getPath().startsWith("/android_asset/")) {
                return 1;
            }
            return 0;
        }
        else {
            if ("data".equals(scheme)) {
                return 4;
            }
            if ("http".equals(scheme)) {
                return 5;
            }
            if ("https".equals(scheme)) {
                return 6;
            }
            return -1;
        }
    }
    
    private OpenForReadResult readDataUri(final Uri uri) {
        final String schemeSpecificPart = uri.getSchemeSpecificPart();
        final int index = schemeSpecificPart.indexOf(44);
        if (index == -1) {
            return null;
        }
        final String[] split = schemeSpecificPart.substring(0, index).split(";");
        int n = 0;
        final int length = split.length;
        String s = null;
        if (length > 0) {
            s = split[0];
        }
        for (int i = 1; i < split.length; ++i) {
            if ("base64".equalsIgnoreCase(split[i])) {
                n = 1;
            }
        }
        final String substring = schemeSpecificPart.substring(index + 1);
        byte[] buf;
        if (n != 0) {
            buf = Base64.decode(substring, 0);
        }
        else {
            buf = EncodingUtils.getBytes(substring, "UTF-8");
        }
        return new OpenForReadResult(uri, new ByteArrayInputStream(buf), s, buf.length, null);
    }
    
    public void copyResource(final Uri uri, final Uri uri2) throws IOException {
        this.copyResource(this.openForRead(uri), this.openOutputStream(uri2));
    }
    
    public void copyResource(final Uri uri, final OutputStream outputStream) throws IOException {
        this.copyResource(this.openForRead(uri), outputStream);
    }
    
    public void copyResource(final OpenForReadResult openForReadResult, final OutputStream outputStream) throws IOException {
        this.assertBackgroundThread();
        try {
            final InputStream inputStream = openForReadResult.inputStream;
            if (inputStream instanceof FileInputStream && outputStream instanceof FileOutputStream) {
                final FileChannel channel = ((FileInputStream)openForReadResult.inputStream).getChannel();
                final FileChannel channel2 = ((FileOutputStream)outputStream).getChannel();
                long startOffset = 0L;
                final long length = openForReadResult.length;
                if (openForReadResult.assetFd != null) {
                    startOffset = openForReadResult.assetFd.getStartOffset();
                }
                channel2.transferFrom(channel, startOffset, length);
            }
            else {
                final byte[] array = new byte[8192];
                while (true) {
                    final int read = inputStream.read(array, 0, 8192);
                    if (read <= 0) {
                        break;
                    }
                    outputStream.write(array, 0, read);
                }
            }
        }
        finally {
            openForReadResult.inputStream.close();
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    
    public HttpURLConnection createHttpConnection(final Uri uri) throws IOException {
        this.assertBackgroundThread();
        return CordovaResourceApi.httpClient.open(new URL(uri.toString()));
    }
    
    public String getMimeType(final Uri uri) {
        switch (getUriType(uri)) {
            case 0:
            case 1: {
                return this.getMimeTypeFromPath(uri.getPath());
            }
            case 2:
            case 3: {
                return this.contentResolver.getType(uri);
            }
            case 4: {
                return this.getDataUriMimeType(uri);
            }
            case 5:
            case 6: {
                try {
                    final HttpURLConnection open = CordovaResourceApi.httpClient.open(new URL(uri.toString()));
                    open.setDoInput(false);
                    open.setRequestMethod("HEAD");
                    return open.getHeaderField("Content-Type");
                }
                catch (IOException ex) {
                    break;
                }
                break;
            }
        }
        return null;
    }
    
    public boolean isThreadCheckingEnabled() {
        return this.threadCheckingEnabled;
    }
    
    public File mapUriToFile(final Uri uri) {
        this.assertBackgroundThread();
        switch (getUriType(uri)) {
            case 0: {
                return new File(uri.getPath());
            }
            case 2: {
                final Cursor query = this.contentResolver.query(uri, CordovaResourceApi.LOCAL_FILE_PROJECTION, (String)null, (String[])null, (String)null);
                if (query != null) {
                    try {
                        final int columnIndex = query.getColumnIndex(CordovaResourceApi.LOCAL_FILE_PROJECTION[0]);
                        if (columnIndex != -1 && query.getCount() > 0) {
                            query.moveToFirst();
                            final String string = query.getString(columnIndex);
                            if (string != null) {
                                return new File(string);
                            }
                        }
                    }
                    finally {
                        query.close();
                    }
                    query.close();
                    return null;
                }
                break;
            }
        }
        return null;
    }
    
    public OpenForReadResult openForRead(final Uri uri) throws IOException {
        return this.openForRead(uri, false);
    }
    
    public OpenForReadResult openForRead(final Uri obj, final boolean b) throws IOException {
        if (!b) {
            this.assertBackgroundThread();
        }
        switch (getUriType(obj)) {
            case 0: {
                final FileInputStream fileInputStream = new FileInputStream(obj.getPath());
                return new OpenForReadResult(obj, fileInputStream, this.getMimeTypeFromPath(obj.getPath()), fileInputStream.getChannel().size(), null);
            }
            case 1: {
                final String substring = obj.getPath().substring(15);
                AssetFileDescriptor openFd = null;
                long length = -1L;
                try {
                    openFd = this.assetManager.openFd(substring);
                    final InputStream inputStream = openFd.createInputStream();
                    length = openFd.getLength();
                    return new OpenForReadResult(obj, inputStream, this.getMimeTypeFromPath(substring), length, openFd);
                }
                catch (FileNotFoundException ex) {
                    final InputStream inputStream = this.assetManager.open(substring);
                    return new OpenForReadResult(obj, inputStream, this.getMimeTypeFromPath(substring), length, openFd);
                }
            }
            case 2:
            case 3: {
                final String type = this.contentResolver.getType(obj);
                final AssetFileDescriptor openAssetFileDescriptor = this.contentResolver.openAssetFileDescriptor(obj, "r");
                return new OpenForReadResult(obj, openAssetFileDescriptor.createInputStream(), type, openAssetFileDescriptor.getLength(), openAssetFileDescriptor);
            }
            case 4: {
                final OpenForReadResult dataUri = this.readDataUri(obj);
                if (dataUri != null) {
                    return dataUri;
                }
                break;
            }
            case 5:
            case 6: {
                final HttpURLConnection open = CordovaResourceApi.httpClient.open(new URL(obj.toString()));
                open.setDoInput(true);
                return new OpenForReadResult(obj, open.getInputStream(), open.getHeaderField("Content-Type"), open.getContentLength(), null);
            }
        }
        throw new FileNotFoundException("URI not supported by CordovaResourceApi: " + obj);
    }
    
    public OutputStream openOutputStream(final Uri uri) throws IOException {
        return this.openOutputStream(uri, false);
    }
    
    public OutputStream openOutputStream(final Uri obj, final boolean append) throws IOException {
        this.assertBackgroundThread();
        switch (getUriType(obj)) {
            default: {
                throw new FileNotFoundException("URI not supported by CordovaResourceApi: " + obj);
            }
            case 0: {
                final File file = new File(obj.getPath());
                final File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                return new FileOutputStream(file, append);
            }
            case 2:
            case 3: {
                final ContentResolver contentResolver = this.contentResolver;
                String s;
                if (append) {
                    s = "wa";
                }
                else {
                    s = "w";
                }
                return contentResolver.openAssetFileDescriptor(obj, s).createOutputStream();
            }
        }
    }
    
    public String remapPath(final String pathname) {
        return this.remapUri(Uri.fromFile(new File(pathname))).getPath();
    }
    
    public Uri remapUri(final Uri uri) {
        assertNonRelative(uri);
        final Uri remapUri = this.pluginManager.remapUri(uri);
        if (remapUri != null) {
            return remapUri;
        }
        return uri;
    }
    
    public void setThreadCheckingEnabled(final boolean threadCheckingEnabled) {
        this.threadCheckingEnabled = threadCheckingEnabled;
    }
    
    public static final class OpenForReadResult
    {
        public final AssetFileDescriptor assetFd;
        public final InputStream inputStream;
        public final long length;
        public final String mimeType;
        public final Uri uri;
        
        OpenForReadResult(final Uri uri, final InputStream inputStream, final String mimeType, final long length, final AssetFileDescriptor assetFd) {
            this.uri = uri;
            this.inputStream = inputStream;
            this.mimeType = mimeType;
            this.length = length;
            this.assetFd = assetFd;
        }
    }
}
