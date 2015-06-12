// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.file;

import java.io.FilterInputStream;
import org.json.JSONArray;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class Filesystem
{
    public String name;
    
    public static JSONObject makeEntryForPath(final String s, final String anObject, final Boolean b, String string) throws JSONException {
        final JSONObject jsonObject = new JSONObject();
        int n;
        if (s.endsWith("/")) {
            n = 1;
        }
        else {
            n = 0;
        }
        final String[] split = s.substring(0, s.length() - n).split("/");
        final String s2 = split[-1 + split.length];
        jsonObject.put("isFile", !b);
        jsonObject.put("isDirectory", (Object)b);
        jsonObject.put("name", (Object)s2);
        jsonObject.put("fullPath", (Object)s);
        jsonObject.put("filesystemName", (Object)anObject);
        final boolean equals = "temporary".equals(anObject);
        int n2 = 0;
        if (!equals) {
            n2 = 1;
        }
        jsonObject.put("filesystem", n2);
        if (b && !string.endsWith("/")) {
            string = String.valueOf(string) + "/";
        }
        jsonObject.put("nativeURL", (Object)string);
        return jsonObject;
    }
    
    public static JSONObject makeEntryForURL(final LocalFilesystemURL localFilesystemURL, final Boolean b, final String s) throws JSONException {
        return makeEntryForPath(localFilesystemURL.fullPath, localFilesystemURL.filesystemName, b, s);
    }
    
    abstract LocalFilesystemURL URLforFilesystemPath(final String p0);
    
    abstract boolean canRemoveFileAtLocalURL(final LocalFilesystemURL p0);
    
    JSONObject copyFileToURL(final LocalFilesystemURL localFilesystemURL, final String s, final Filesystem filesystem, final LocalFilesystemURL localFilesystemURL2, final boolean b) throws IOException, InvalidModificationException, JSONException, NoModificationAllowedException, FileExistsException {
        if (!b || filesystem.canRemoveFileAtLocalURL(localFilesystemURL2)) {
            final LocalFilesystemURL destinationURL = this.makeDestinationURL(s, localFilesystemURL2, localFilesystemURL);
            filesystem.readFileAtURL(localFilesystemURL2, 0L, -1L, (ReadFileCallback)new ReadFileCallback() {
                @Override
                public void handleData(final InputStream inputStream, final String s) throws IOException {
                    if (inputStream != null) {
                        final OutputStream outputStreamForURL = Filesystem.this.getOutputStreamForURL(destinationURL);
                        final byte[] array = new byte[8192];
                        while (true) {
                            final int read = inputStream.read(array, 0, 8192);
                            if (read <= 0) {
                                break;
                            }
                            outputStreamForURL.write(array, 0, read);
                        }
                        outputStreamForURL.close();
                        return;
                    }
                    throw new IOException("Cannot read file at source URL");
                }
            });
            if (b) {
                filesystem.removeFileAtLocalURL(localFilesystemURL2);
            }
            return this.getEntryForLocalURL(destinationURL);
        }
        throw new NoModificationAllowedException("Cannot move file at source URL");
    }
    
    abstract String filesystemPathForURL(final LocalFilesystemURL p0);
    
    abstract JSONObject getEntryForLocalURL(final LocalFilesystemURL p0) throws IOException;
    
    abstract JSONObject getFileForLocalURL(final LocalFilesystemURL p0, final String p1, final JSONObject p2, final boolean p3) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException;
    
    abstract JSONObject getFileMetadataForLocalURL(final LocalFilesystemURL p0) throws FileNotFoundException;
    
    abstract OutputStream getOutputStreamForURL(final LocalFilesystemURL p0) throws IOException;
    
    public JSONObject getParentForLocalURL(final LocalFilesystemURL localFilesystemURL) throws IOException {
        final LocalFilesystemURL localFilesystemURL2 = new LocalFilesystemURL(localFilesystemURL.URL);
        if (!"".equals(localFilesystemURL.fullPath) && !"/".equals(localFilesystemURL.fullPath)) {
            int n;
            if (localFilesystemURL.fullPath.endsWith("/")) {
                n = 1;
            }
            else {
                n = 0;
            }
            localFilesystemURL2.fullPath = localFilesystemURL2.fullPath.substring(0, 1 + localFilesystemURL.fullPath.lastIndexOf(47, localFilesystemURL.fullPath.length() - n));
        }
        return this.getEntryForLocalURL(localFilesystemURL2);
    }
    
    protected LocalFilesystemURL makeDestinationURL(String lastPathSegment, final LocalFilesystemURL localFilesystemURL, final LocalFilesystemURL localFilesystemURL2) {
        if ("null".equals(lastPathSegment) || "".equals(lastPathSegment)) {
            lastPathSegment = localFilesystemURL.URL.getLastPathSegment();
        }
        final String string = localFilesystemURL2.URL.toString();
        String s;
        if (string.endsWith("/")) {
            s = String.valueOf(string) + lastPathSegment;
        }
        else {
            s = String.valueOf(string) + "/" + lastPathSegment;
        }
        return new LocalFilesystemURL(s);
    }
    
    public JSONObject makeEntryForFile(final File file) throws JSONException {
        return null;
    }
    
    abstract JSONArray readEntriesAtLocalURL(final LocalFilesystemURL p0) throws FileNotFoundException;
    
    abstract void readFileAtURL(final LocalFilesystemURL p0, final long p1, final long p2, final ReadFileCallback p3) throws IOException;
    
    abstract boolean recursiveRemoveFileAtLocalURL(final LocalFilesystemURL p0) throws FileExistsException, NoModificationAllowedException;
    
    abstract boolean removeFileAtLocalURL(final LocalFilesystemURL p0) throws InvalidModificationException, NoModificationAllowedException;
    
    abstract long truncateFileAtURL(final LocalFilesystemURL p0, final long p1) throws IOException, NoModificationAllowedException;
    
    abstract long writeToFileAtURL(final LocalFilesystemURL p0, final String p1, final int p2, final boolean p3) throws NoModificationAllowedException, IOException;
    
    protected class LimitedInputStream extends FilterInputStream
    {
        long numBytesToRead;
        
        public LimitedInputStream(final InputStream in, final long numBytesToRead) {
            super(in);
            this.numBytesToRead = numBytesToRead;
        }
        
        @Override
        public int read() throws IOException {
            if (this.numBytesToRead <= 0L) {
                return -1;
            }
            --this.numBytesToRead;
            return this.in.read();
        }
        
        @Override
        public int read(final byte[] b, final int off, final int n) throws IOException {
            if (this.numBytesToRead <= 0L) {
                return -1;
            }
            int len = n;
            if (n > this.numBytesToRead) {
                len = (int)this.numBytesToRead;
            }
            final int read = this.in.read(b, off, len);
            this.numBytesToRead -= read;
            return read;
        }
    }
    
    public interface ReadFileCallback
    {
        void handleData(InputStream p0, String p1) throws IOException;
    }
}
