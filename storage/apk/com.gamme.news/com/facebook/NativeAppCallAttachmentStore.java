// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.io.OutputStream;
import android.graphics.Bitmap$CompressFormat;
import android.graphics.Bitmap;
import java.io.Closeable;
import com.facebook.internal.Utility;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import com.facebook.internal.Validate;
import java.util.Iterator;
import java.io.IOException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import android.content.Context;
import java.io.File;

public final class NativeAppCallAttachmentStore implements AttachmentDataSource
{
    static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
    private static final String TAG;
    private static File attachmentsDirectory;
    
    static {
        TAG = NativeAppCallAttachmentStore.class.getName();
    }
    
    private <T> void addAttachments(final Context context, final UUID uuid, final Map<String, T> map, final ProcessAttachment<T> processAttachment) {
        if (map.size() != 0) {
            if (NativeAppCallAttachmentStore.attachmentsDirectory == null) {
                this.cleanupAllAttachments(context);
            }
            this.ensureAttachmentsDirectoryExists(context);
            final ArrayList<File> list = new ArrayList<File>();
            try {
                for (final Map.Entry<String, T> entry : map.entrySet()) {
                    final String s = entry.getKey();
                    final T value = entry.getValue();
                    final File attachmentFile = this.getAttachmentFile(uuid, s, true);
                    list.add(attachmentFile);
                    processAttachment.processAttachment(value, attachmentFile);
                }
            }
            catch (IOException obj) {
                Log.e(NativeAppCallAttachmentStore.TAG, "Got unexpected exception:" + obj);
                for (final File file : list) {
                    try {
                        file.delete();
                    }
                    catch (Exception ex) {}
                }
                throw new FacebookException(obj);
            }
        }
    }
    
    static File getAttachmentsDirectory(final Context context) {
        synchronized (NativeAppCallAttachmentStore.class) {
            if (NativeAppCallAttachmentStore.attachmentsDirectory == null) {
                NativeAppCallAttachmentStore.attachmentsDirectory = new File(context.getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
            }
            return NativeAppCallAttachmentStore.attachmentsDirectory;
        }
    }
    
    public void addAttachmentFilesForCall(final Context context, final UUID uuid, final Map<String, File> map) {
        Validate.notNull(context, "context");
        Validate.notNull(uuid, "callId");
        Validate.containsNoNulls((Collection<File>)map.values(), "imageAttachmentFiles");
        Validate.containsNoNullOrEmpty(map.keySet(), "imageAttachmentFiles");
        this.addAttachments(context, uuid, (Map<String, T>)map, (ProcessAttachment<T>)new ProcessAttachment<File>() {
            public void processAttachment(final File file, final File file2) throws IOException {
                final FileOutputStream fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    try {
                        final FileInputStream fileInputStream = new FileInputStream(file);
                        FileInputStream fileInputStream2;
                        try {
                            final byte[] array = new byte[1024];
                            while (true) {
                                final int read = fileInputStream.read(array);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream.write(array, 0, read);
                            }
                            Utility.closeQuietly(fileOutputStream);
                            Utility.closeQuietly(fileInputStream);
                            return;
                        }
                        finally {
                            fileInputStream2 = fileInputStream;
                        }
                        Utility.closeQuietly(fileOutputStream);
                        Utility.closeQuietly(fileInputStream2);
                        throw;
                    }
                    finally {
                        final FileInputStream fileInputStream2 = null;
                        continue;
                    }
                    break;
                }
            }
        });
    }
    
    public void addAttachmentsForCall(final Context context, final UUID uuid, final Map<String, Bitmap> map) {
        Validate.notNull(context, "context");
        Validate.notNull(uuid, "callId");
        Validate.containsNoNulls((Collection<Bitmap>)map.values(), "imageAttachments");
        Validate.containsNoNullOrEmpty(map.keySet(), "imageAttachments");
        this.addAttachments(context, uuid, (Map<String, T>)map, (ProcessAttachment<T>)new ProcessAttachment<Bitmap>() {
            public void processAttachment(final Bitmap bitmap, final File file) throws IOException {
                final FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    bitmap.compress(Bitmap$CompressFormat.JPEG, 100, (OutputStream)fileOutputStream);
                }
                finally {
                    Utility.closeQuietly(fileOutputStream);
                }
            }
        });
    }
    
    void cleanupAllAttachments(final Context context) {
        Utility.deleteDirectory(getAttachmentsDirectory(context));
    }
    
    public void cleanupAttachmentsForCall(final Context context, final UUID uuid) {
        Utility.deleteDirectory(this.getAttachmentsDirectoryForCall(uuid, false));
    }
    
    File ensureAttachmentsDirectoryExists(final Context context) {
        final File attachmentsDirectory = getAttachmentsDirectory(context);
        attachmentsDirectory.mkdirs();
        return attachmentsDirectory;
    }
    
    File getAttachmentFile(final UUID uuid, final String s, final boolean b) throws IOException {
        final File attachmentsDirectoryForCall = this.getAttachmentsDirectoryForCall(uuid, b);
        if (attachmentsDirectoryForCall == null) {
            return null;
        }
        try {
            return new File(attachmentsDirectoryForCall, URLEncoder.encode(s, "UTF-8"));
        }
        catch (UnsupportedEncodingException ex) {
            return null;
        }
    }
    
    File getAttachmentsDirectoryForCall(final UUID uuid, final boolean b) {
        File file;
        if (NativeAppCallAttachmentStore.attachmentsDirectory == null) {
            file = null;
        }
        else {
            file = new File(NativeAppCallAttachmentStore.attachmentsDirectory, uuid.toString());
            if (b && !file.exists()) {
                file.mkdirs();
                return file;
            }
        }
        return file;
    }
    
    @Override
    public File openAttachment(final UUID uuid, final String s) throws FileNotFoundException {
        if (Utility.isNullOrEmpty(s) || uuid == null) {
            throw new FileNotFoundException();
        }
        try {
            return this.getAttachmentFile(uuid, s, false);
        }
        catch (IOException ex) {
            throw new FileNotFoundException();
        }
    }
    
    interface ProcessAttachment<T>
    {
        void processAttachment(T p0, File p1) throws IOException;
    }
}
