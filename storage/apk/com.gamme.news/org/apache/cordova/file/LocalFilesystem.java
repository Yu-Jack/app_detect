// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.file;

import java.io.ByteArrayInputStream;
import android.util.Base64;
import java.io.RandomAccessFile;
import java.io.InputStream;
import org.json.JSONArray;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.OutputStream;
import android.net.Uri;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import org.apache.cordova.CordovaInterface;

public class LocalFilesystem extends Filesystem
{
    private CordovaInterface cordova;
    private String fsRoot;
    
    public LocalFilesystem(final String name, final CordovaInterface cordova, final String fsRoot) {
        this.name = name;
        this.fsRoot = fsRoot;
        this.cordova = cordova;
    }
    
    private void copyAction(final File file, final File file2) throws FileNotFoundException, IOException {
        final FileInputStream fileInputStream = new FileInputStream(file);
        final FileOutputStream fileOutputStream = new FileOutputStream(file2);
        final FileChannel channel = fileInputStream.getChannel();
        final FileChannel channel2 = fileOutputStream.getChannel();
        try {
            channel.transferTo(0L, channel.size(), channel2);
        }
        finally {
            fileInputStream.close();
            fileOutputStream.close();
            channel.close();
            channel2.close();
        }
    }
    
    private JSONObject copyDirectory(final File file, final File file2) throws JSONException, IOException, NoModificationAllowedException, InvalidModificationException {
        if (file2.exists() && file2.isFile()) {
            throw new InvalidModificationException("Can't rename a file to a directory");
        }
        if (this.isCopyOnItself(file.getAbsolutePath(), file2.getAbsolutePath())) {
            throw new InvalidModificationException("Can't copy itself into itself");
        }
        if (!file2.exists() && !file2.mkdir()) {
            throw new NoModificationAllowedException("Couldn't create the destination directory");
        }
        for (final File file3 : file.listFiles()) {
            final File file4 = new File(file2.getAbsoluteFile() + File.separator + file3.getName());
            if (file3.isDirectory()) {
                this.copyDirectory(file3, file4);
            }
            else {
                this.copyFile(file3, file4);
            }
        }
        return this.makeEntryForFile(file2);
    }
    
    private JSONObject copyFile(final File file, final File file2) throws IOException, InvalidModificationException, JSONException {
        if (file2.exists() && file2.isDirectory()) {
            throw new InvalidModificationException("Can't rename a file to a directory");
        }
        this.copyAction(file, file2);
        return this.makeEntryForFile(file2);
    }
    
    private String fullPathForFilesystemPath(final String s) {
        if (s != null && s.startsWith(this.fsRoot)) {
            return s.substring(this.fsRoot.length());
        }
        return null;
    }
    
    private boolean isCopyOnItself(final String prefix, final String s) {
        return s.startsWith(prefix) && s.indexOf(File.separator, -1 + prefix.length()) != -1;
    }
    
    private JSONObject moveDirectory(final File file, final File dest) throws IOException, JSONException, InvalidModificationException, NoModificationAllowedException, FileExistsException {
        if (dest.exists() && dest.isFile()) {
            throw new InvalidModificationException("Can't rename a file to a directory");
        }
        if (this.isCopyOnItself(file.getAbsolutePath(), dest.getAbsolutePath())) {
            throw new InvalidModificationException("Can't move itself into itself");
        }
        if (dest.exists() && dest.list().length > 0) {
            throw new InvalidModificationException("directory is not empty");
        }
        if (!file.renameTo(dest)) {
            this.copyDirectory(file, dest);
            if (!dest.exists()) {
                throw new IOException("moved failed");
            }
            this.removeDirRecursively(file);
        }
        return this.makeEntryForFile(dest);
    }
    
    private JSONObject moveFile(final File file, final File dest) throws IOException, JSONException, InvalidModificationException {
        if (dest.exists() && dest.isDirectory()) {
            throw new InvalidModificationException("Can't rename a file to a directory");
        }
        if (!file.renameTo(dest)) {
            this.copyAction(file, dest);
            if (!dest.exists()) {
                throw new IOException("moved failed");
            }
            file.delete();
        }
        return this.makeEntryForFile(dest);
    }
    
    public LocalFilesystemURL URLforFilesystemPath(final String s) {
        return this.URLforFullPath(this.fullPathForFilesystemPath(s));
    }
    
    protected LocalFilesystemURL URLforFullPath(final String s) {
        if (s == null) {
            return null;
        }
        if (s.startsWith("/")) {
            return new LocalFilesystemURL("cdvfile://localhost/" + this.name + s);
        }
        return new LocalFilesystemURL("cdvfile://localhost/" + this.name + "/" + s);
    }
    
    public boolean canRemoveFileAtLocalURL(final LocalFilesystemURL localFilesystemURL) {
        return new File(this.filesystemPathForURL(localFilesystemURL)).exists();
    }
    
    public JSONObject copyFileToURL(final LocalFilesystemURL localFilesystemURL, final String s, final Filesystem filesystem, final LocalFilesystemURL localFilesystemURL2, final boolean b) throws IOException, InvalidModificationException, JSONException, NoModificationAllowedException, FileExistsException {
        if (!new File(this.filesystemPathForURL(localFilesystemURL)).exists()) {
            throw new FileNotFoundException("The source does not exist");
        }
        if (!LocalFilesystem.class.isInstance(filesystem)) {
            return super.copyFileToURL(localFilesystemURL, s, filesystem, localFilesystemURL2, b);
        }
        final LocalFilesystemURL destinationURL = this.makeDestinationURL(s, localFilesystemURL2, localFilesystemURL);
        final File file = new File(filesystem.filesystemPathForURL(localFilesystemURL2));
        final File file2 = new File(this.filesystemPathForURL(destinationURL));
        if (!file.exists()) {
            throw new FileNotFoundException("The source does not exist");
        }
        if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            throw new InvalidModificationException("Can't copy a file onto itself");
        }
        if (file.isDirectory()) {
            if (b) {
                return this.moveDirectory(file, file2);
            }
            return this.copyDirectory(file, file2);
        }
        else {
            if (b) {
                return this.moveFile(file, file2);
            }
            return this.copyFile(file, file2);
        }
    }
    
    public String filesystemPathForFullPath(final String child) {
        String s = new File(this.fsRoot, child).toString();
        final int index = s.indexOf("?");
        if (index >= 0) {
            s = s.substring(0, index);
        }
        if (s.length() > 1 && s.endsWith("/")) {
            s = s.substring(0, -1 + s.length());
        }
        return s;
    }
    
    public String filesystemPathForURL(final LocalFilesystemURL localFilesystemURL) {
        return this.filesystemPathForFullPath(localFilesystemURL.fullPath);
    }
    
    public JSONObject getEntryForLocalURL(final LocalFilesystemURL localFilesystemURL) throws IOException {
        final File file = new File(this.filesystemPathForURL(localFilesystemURL));
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        if (!file.canRead()) {
            throw new IOException();
        }
        try {
            return Filesystem.makeEntryForURL(localFilesystemURL, file.isDirectory(), Uri.fromFile(file).toString());
        }
        catch (JSONException ex) {
            throw new IOException();
        }
    }
    
    public JSONObject getFileForLocalURL(final LocalFilesystemURL localFilesystemURL, final String str, final JSONObject jsonObject, final boolean b) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
        boolean optBoolean = false;
        boolean optBoolean2 = false;
        if (jsonObject != null) {
            optBoolean = jsonObject.optBoolean("create");
            optBoolean2 = false;
            if (optBoolean) {
                optBoolean2 = jsonObject.optBoolean("exclusive");
            }
        }
        if (str.contains(":")) {
            throw new EncodingException("This path has an invalid \":\" in it.");
        }
        LocalFilesystemURL localFilesystemURL2;
        if (str.startsWith("/")) {
            localFilesystemURL2 = this.URLforFilesystemPath(str);
        }
        else {
            localFilesystemURL2 = this.URLforFullPath(this.normalizePath(String.valueOf(localFilesystemURL.fullPath) + "/" + str));
        }
        final File file = new File(this.filesystemPathForURL(localFilesystemURL2));
        if (optBoolean) {
            if (optBoolean2 && file.exists()) {
                throw new FileExistsException("create/exclusive fails");
            }
            if (b) {
                file.mkdir();
            }
            else {
                file.createNewFile();
            }
            if (!file.exists()) {
                throw new FileExistsException("create fails");
            }
        }
        else {
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
        }
        return Filesystem.makeEntryForPath(localFilesystemURL2.fullPath, localFilesystemURL2.filesystemName, b, Uri.fromFile(file).toString());
    }
    
    public JSONObject getFileMetadataForLocalURL(final LocalFilesystemURL localFilesystemURL) throws FileNotFoundException {
        final File file = new File(this.filesystemPathForURL(localFilesystemURL));
        if (!file.exists()) {
            throw new FileNotFoundException("File at " + localFilesystemURL.URL + " does not exist.");
        }
        final JSONObject jsonObject = new JSONObject();
        try {
            long length;
            if (file.isDirectory()) {
                length = 0L;
            }
            else {
                length = file.length();
            }
            jsonObject.put("size", length);
            jsonObject.put("type", (Object)FileHelper.getMimeType(file.getAbsolutePath(), this.cordova));
            jsonObject.put("name", (Object)file.getName());
            jsonObject.put("fullPath", (Object)localFilesystemURL.fullPath);
            jsonObject.put("lastModifiedDate", file.lastModified());
            return jsonObject;
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    @Override
    OutputStream getOutputStreamForURL(final LocalFilesystemURL localFilesystemURL) throws FileNotFoundException {
        return new FileOutputStream(new File(this.filesystemPathForURL(localFilesystemURL)));
    }
    
    @Override
    public JSONObject makeEntryForFile(final File file) throws JSONException {
        final String fullPathForFilesystemPath = this.fullPathForFilesystemPath(file.getAbsolutePath());
        if (fullPathForFilesystemPath != null) {
            return Filesystem.makeEntryForPath(fullPathForFilesystemPath, this.name, file.isDirectory(), Uri.fromFile(file).toString());
        }
        return null;
    }
    
    protected String normalizePath(String substring) {
        final boolean startsWith = substring.startsWith("/");
        if (startsWith) {
            substring = substring.substring(1);
        }
        final ArrayList<String> list = new ArrayList<String>(Arrays.asList(substring.split("/")));
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).equals("..")) {
                list.remove(i);
                if (i > 0) {
                    list.remove(i - 1);
                    --i;
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (final String str : list) {
            sb.append("/");
            sb.append(str);
        }
        if (startsWith) {
            return sb.toString();
        }
        return sb.toString().substring(1);
    }
    
    public JSONArray readEntriesAtLocalURL(final LocalFilesystemURL localFilesystemURL) throws FileNotFoundException {
        final File file = new File(this.filesystemPathForURL(localFilesystemURL));
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        final JSONArray jsonArray = new JSONArray();
        if (file.isDirectory()) {
            final File[] listFiles = file.listFiles();
            int i = 0;
            while (i < listFiles.length) {
                while (true) {
                    if (!listFiles[i].canRead()) {
                        break Label_0119;
                    }
                    try {
                        jsonArray.put((Object)Filesystem.makeEntryForPath(this.fullPathForFilesystemPath(listFiles[i].getAbsolutePath()), localFilesystemURL.filesystemName, listFiles[i].isDirectory(), Uri.fromFile(listFiles[i]).toString()));
                        ++i;
                    }
                    catch (JSONException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
        return jsonArray;
    }
    
    public void readFileAtURL(final LocalFilesystemURL localFilesystemURL, final long n, long length, final ReadFileCallback readFileCallback) throws IOException {
        final File file = new File(this.filesystemPathForURL(localFilesystemURL));
        final String mimeTypeForExtension = FileHelper.getMimeTypeForExtension(file.getAbsolutePath());
        if (length < 0L) {
            length = file.length();
        }
        final long n2 = length - n;
        final FileInputStream fileInputStream = new FileInputStream(file);
        Label_0068: {
            if (n <= 0L) {
                break Label_0068;
            }
            try {
                fileInputStream.skip(n);
                readFileCallback.handleData(new LimitedInputStream(this, fileInputStream, n2), mimeTypeForExtension);
            }
            finally {
                fileInputStream.close();
            }
        }
    }
    
    public boolean recursiveRemoveFileAtLocalURL(final LocalFilesystemURL localFilesystemURL) throws FileExistsException {
        return this.removeDirRecursively(new File(this.filesystemPathForURL(localFilesystemURL)));
    }
    
    protected boolean removeDirRecursively(final File file) throws FileExistsException {
        if (file.isDirectory()) {
            final File[] listFiles = file.listFiles();
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                this.removeDirRecursively(listFiles[i]);
            }
        }
        if (!file.delete()) {
            throw new FileExistsException("could not delete: " + file.getName());
        }
        return true;
    }
    
    public boolean removeFileAtLocalURL(final LocalFilesystemURL localFilesystemURL) throws InvalidModificationException {
        final File file = new File(this.filesystemPathForURL(localFilesystemURL));
        if (file.isDirectory() && file.list().length > 0) {
            throw new InvalidModificationException("You can't delete a directory that is not empty.");
        }
        return file.delete();
    }
    
    public long truncateFileAtURL(final LocalFilesystemURL localFilesystemURL, final long n) throws IOException {
        if (!new File(this.filesystemPathForURL(localFilesystemURL)).exists()) {
            throw new FileNotFoundException("File at " + localFilesystemURL.URL + " does not exist.");
        }
        final RandomAccessFile randomAccessFile = new RandomAccessFile(this.filesystemPathForURL(localFilesystemURL), "rw");
        try {
            if (randomAccessFile.length() >= n) {
                randomAccessFile.getChannel().truncate(n);
                return n;
            }
            return randomAccessFile.length();
        }
        finally {
            randomAccessFile.close();
        }
    }
    
    public long writeToFileAtURL(final LocalFilesystemURL localFilesystemURL, final String s, final int n, final boolean b) throws IOException, NoModificationAllowedException {
        boolean append = false;
        if (n > 0) {
            this.truncateFileAtURL(localFilesystemURL, n);
            append = true;
        }
        Label_0102: {
            if (!b) {
                break Label_0102;
            }
            byte[] buf = Base64.decode(s, 0);
            while (true) {
                final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buf);
                try {
                    final byte[] array = new byte[buf.length];
                    final FileOutputStream fileOutputStream = new FileOutputStream(this.filesystemPathForURL(localFilesystemURL), append);
                    try {
                        byteArrayInputStream.read(array, 0, array.length);
                        fileOutputStream.write(array, 0, buf.length);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return buf.length;
                        buf = s.getBytes();
                    }
                    finally {
                        fileOutputStream.close();
                    }
                }
                catch (NullPointerException ex) {
                    throw new NoModificationAllowedException(localFilesystemURL.toString());
                }
            }
        }
    }
}
