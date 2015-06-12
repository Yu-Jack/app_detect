// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.camera;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import android.os.Parcelable;
import org.json.JSONException;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import android.content.ActivityNotFoundException;
import android.util.Log;
import android.content.Intent;
import java.io.OutputStream;
import android.graphics.Bitmap$CompressFormat;
import java.io.FileOutputStream;
import org.apache.cordova.LOG;
import android.provider.MediaStore$Images$Media;
import android.content.ContentValues;
import android.os.Environment;
import java.io.IOException;
import android.graphics.Rect;
import android.graphics.BitmapFactory$Options;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.io.File;
import android.graphics.Bitmap;
import android.database.Cursor;
import android.net.Uri;
import android.media.MediaScannerConnection;
import org.apache.cordova.CallbackContext;
import android.media.MediaScannerConnection$MediaScannerConnectionClient;
import org.apache.cordova.CordovaPlugin;

public class CameraLauncher extends CordovaPlugin implements MediaScannerConnection$MediaScannerConnectionClient
{
    private static final int ALLMEDIA = 2;
    private static final int CAMERA = 1;
    private static final int CROP_CAMERA = 100;
    private static final int DATA_URL = 0;
    private static final int FILE_URI = 1;
    private static final String GET_All = "Get All";
    private static final String GET_PICTURE = "Get Picture";
    private static final String GET_VIDEO = "Get Video";
    private static final int JPEG = 0;
    private static final String LOG_TAG = "CameraLauncher";
    private static final int NATIVE_URI = 2;
    private static final int PHOTOLIBRARY = 0;
    private static final int PICTURE = 0;
    private static final int PNG = 1;
    private static final int SAVEDPHOTOALBUM = 2;
    private static final int VIDEO = 1;
    private boolean allowEdit;
    public CallbackContext callbackContext;
    private MediaScannerConnection conn;
    private boolean correctOrientation;
    private Uri croppedUri;
    private int encodingType;
    private Uri imageUri;
    private int mQuality;
    private int mediaType;
    private int numPics;
    private boolean orientationCorrected;
    private boolean saveToPhotoAlbum;
    private Uri scanMe;
    private int targetHeight;
    private int targetWidth;
    
    public static int calculateSampleSize(final int n, final int n2, final int n3, final int n4) {
        if (n / n2 > n3 / n4) {
            return n / n3;
        }
        return n2 / n4;
    }
    
    private void checkForDuplicateImage(final int n) {
        int n2 = 1;
        final Uri whichContentStore = this.whichContentStore();
        final Cursor queryImgDB = this.queryImgDB(whichContentStore);
        final int count = queryImgDB.getCount();
        if (n == 1 && this.saveToPhotoAlbum) {
            n2 = 2;
        }
        if (count - this.numPics == n2) {
            queryImgDB.moveToLast();
            int intValue = Integer.valueOf(queryImgDB.getString(queryImgDB.getColumnIndex("_id")));
            if (n2 == 2) {
                --intValue;
            }
            this.cordova.getActivity().getContentResolver().delete(Uri.parse(whichContentStore + "/" + intValue), (String)null, (String[])null);
            queryImgDB.close();
        }
    }
    
    private void cleanup(final int n, final Uri uri, final Uri uri2, final Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.recycle();
        }
        new File(FileHelper.stripFileProtocol(uri.toString())).delete();
        this.checkForDuplicateImage(n);
        if (this.saveToPhotoAlbum && uri2 != null) {
            this.scanForGallery(uri2);
        }
        System.gc();
    }
    
    private File createCaptureFile(final int i) {
        if (i == 0) {
            return new File(this.getTempDirectoryPath(), ".Pic.jpg");
        }
        if (i == 1) {
            return new File(this.getTempDirectoryPath(), ".Pic.png");
        }
        throw new IllegalArgumentException("Invalid Encoding Type: " + i);
    }
    
    private int getImageOrientation(final Uri uri) {
        int int1 = 0;
        final String[] array = { "orientation" };
        try {
            final Cursor query = this.cordova.getActivity().getContentResolver().query(uri, array, (String)null, (String[])null, (String)null);
            int1 = 0;
            if (query != null) {
                query.moveToPosition(0);
                int1 = query.getInt(0);
                query.close();
            }
            return int1;
        }
        catch (Exception ex) {
            return int1;
        }
    }
    
    private Bitmap getRotatedBitmap(final int n, Bitmap bitmap, final ExifHelper exifHelper) {
        final Matrix matrix = new Matrix();
        Label_0055: {
            if (n != 180) {
                break Label_0055;
            }
            matrix.setRotate((float)n);
            try {
                while (true) {
                    bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    exifHelper.resetOrientation();
                    return bitmap;
                    matrix.setRotate((float)n, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
                    continue;
                }
            }
            catch (OutOfMemoryError outOfMemoryError) {
                return bitmap;
            }
        }
    }
    
    private Bitmap getScaledBitmap(final String s) throws IOException {
        Bitmap decodeStream;
        if (this.targetWidth <= 0 && this.targetHeight <= 0) {
            decodeStream = BitmapFactory.decodeStream(FileHelper.getInputStreamFromUriString(s, this.cordova));
        }
        else {
            final BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
            bitmapFactory$Options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(FileHelper.getInputStreamFromUriString(s, this.cordova), (Rect)null, bitmapFactory$Options);
            final int outWidth = bitmapFactory$Options.outWidth;
            decodeStream = null;
            if (outWidth != 0) {
                final int outHeight = bitmapFactory$Options.outHeight;
                decodeStream = null;
                if (outHeight != 0) {
                    final int[] calculateAspectRatio = this.calculateAspectRatio(bitmapFactory$Options.outWidth, bitmapFactory$Options.outHeight);
                    bitmapFactory$Options.inJustDecodeBounds = false;
                    bitmapFactory$Options.inSampleSize = calculateSampleSize(bitmapFactory$Options.outWidth, bitmapFactory$Options.outHeight, this.targetWidth, this.targetHeight);
                    final Bitmap decodeStream2 = BitmapFactory.decodeStream(FileHelper.getInputStreamFromUriString(s, this.cordova), (Rect)null, bitmapFactory$Options);
                    decodeStream = null;
                    if (decodeStream2 != null) {
                        return Bitmap.createScaledBitmap(decodeStream2, calculateAspectRatio[0], calculateAspectRatio[1], true);
                    }
                }
            }
        }
        return decodeStream;
    }
    
    private String getTempDirectoryPath() {
        File cacheDir;
        if (Environment.getExternalStorageState().equals("mounted")) {
            cacheDir = new File(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()) + "/Android/data/" + this.cordova.getActivity().getPackageName() + "/cache/");
        }
        else {
            cacheDir = this.cordova.getActivity().getCacheDir();
        }
        cacheDir.mkdirs();
        return cacheDir.getAbsolutePath();
    }
    
    private Uri getUriFromMediaStore() {
        final ContentValues contentValues = new ContentValues();
        contentValues.put("mime_type", "image/jpeg");
        try {
            return this.cordova.getActivity().getContentResolver().insert(MediaStore$Images$Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        catch (UnsupportedOperationException ex) {
            LOG.d("CameraLauncher", "Can't write to external media storage.");
            try {
                return this.cordova.getActivity().getContentResolver().insert(MediaStore$Images$Media.INTERNAL_CONTENT_URI, contentValues);
            }
            catch (UnsupportedOperationException ex2) {
                LOG.d("CameraLauncher", "Can't write to internal media storage.");
                return null;
            }
        }
    }
    
    private String ouputModifiedBitmap(final Bitmap bitmap, final Uri uri) throws IOException {
        final String string = String.valueOf(this.getTempDirectoryPath()) + "/modified.jpg";
        final FileOutputStream fileOutputStream = new FileOutputStream(string);
        bitmap.compress(Bitmap$CompressFormat.JPEG, this.mQuality, (OutputStream)fileOutputStream);
        fileOutputStream.close();
        final String realPath = FileHelper.getRealPath(uri, this.cordova);
        final ExifHelper exifHelper = new ExifHelper();
        if (realPath == null || this.encodingType != 0) {
            return string;
        }
        try {
            exifHelper.createInFile(realPath);
            exifHelper.readExifData();
            if (this.correctOrientation && this.orientationCorrected) {
                exifHelper.resetOrientation();
            }
            exifHelper.createOutFile(string);
            exifHelper.writeExifData();
            return string;
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return string;
        }
    }
    
    private void performCrop(final Uri uri) {
        try {
            final Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(uri, "image/*");
            intent.putExtra("crop", "true");
            if (this.targetWidth > 0) {
                intent.putExtra("outputX", this.targetWidth);
            }
            if (this.targetHeight > 0) {
                intent.putExtra("outputY", this.targetHeight);
            }
            if (this.targetHeight > 0 && this.targetWidth > 0 && this.targetWidth == this.targetHeight) {
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
            }
            intent.putExtra("return-data", true);
            if (this.cordova != null) {
                this.cordova.startActivityForResult(this, intent, 100);
            }
        }
        catch (ActivityNotFoundException ex) {
            Log.e("CameraLauncher", "Crop operation not supported on this device");
            this.callbackContext.success(uri.toString());
        }
    }
    
    private void processResultFromCamera(final int n, final Intent intent) throws IOException {
        final ExifHelper exifHelper = new ExifHelper();
        while (true) {
            int orientation = 0;
            Label_0192: {
                Bitmap bitmap;
                Uri uri;
                while (true) {
                    try {
                        final int encodingType = this.encodingType;
                        orientation = 0;
                        if (encodingType == 0) {
                            exifHelper.createInFile(String.valueOf(this.getTempDirectoryPath()) + "/.Pic.jpg");
                            exifHelper.readExifData();
                            orientation = exifHelper.getOrientation();
                        }
                        bitmap = null;
                        uri = null;
                        if (n != 0) {
                            break Label_0192;
                        }
                        bitmap = this.getScaledBitmap(FileHelper.stripFileProtocol(this.imageUri.toString()));
                        if (bitmap == null) {
                            bitmap = (Bitmap)intent.getExtras().get("data");
                        }
                        if (bitmap == null) {
                            Log.d("CameraLauncher", "I either have a null image path or bitmap");
                            this.failPicture("Unable to create bitmap!");
                            return;
                        }
                    }
                    catch (IOException ex) {
                        ex.printStackTrace();
                        orientation = 0;
                        continue;
                    }
                    break;
                }
                if (orientation != 0 && this.correctOrientation) {
                    bitmap = this.getRotatedBitmap(orientation, bitmap, exifHelper);
                }
                this.processPicture(bitmap);
                this.checkForDuplicateImage(0);
                this.cleanup(1, this.imageUri, uri, bitmap);
                return;
            }
            if (n != 1) {
                final Bitmap bitmap = null;
                final Uri uri = null;
                if (n != 2) {
                    continue;
                }
            }
            Uri uri;
            if (this.saveToPhotoAlbum) {
                uri = Uri.fromFile(new File(FileHelper.getRealPath(this.getUriFromMediaStore(), this.cordova)));
            }
            else {
                uri = Uri.fromFile(new File(this.getTempDirectoryPath(), String.valueOf(System.currentTimeMillis()) + ".jpg"));
            }
            if (uri == null) {
                this.failPicture("Error capturing image - no media storage found.");
            }
            if (this.targetHeight == -1 && this.targetWidth == -1 && this.mQuality == 100 && !this.correctOrientation) {
                this.writeUncompressedImage(uri);
                this.callbackContext.success(uri.toString());
            }
            else {
                Bitmap bitmap = this.getScaledBitmap(FileHelper.stripFileProtocol(this.imageUri.toString()));
                if (orientation != 0 && this.correctOrientation) {
                    bitmap = this.getRotatedBitmap(orientation, bitmap, exifHelper);
                }
                final OutputStream openOutputStream = this.cordova.getActivity().getContentResolver().openOutputStream(uri);
                bitmap.compress(Bitmap$CompressFormat.JPEG, this.mQuality, openOutputStream);
                openOutputStream.close();
                if (this.encodingType == 0) {
                    String s;
                    if (this.saveToPhotoAlbum) {
                        s = FileHelper.getRealPath(uri, this.cordova);
                    }
                    else {
                        s = uri.getPath();
                    }
                    exifHelper.createOutFile(s);
                    exifHelper.writeExifData();
                }
                if (this.allowEdit) {
                    this.performCrop(uri);
                }
                else {
                    this.callbackContext.success(uri.toString());
                }
            }
            this.callbackContext.success(uri.toString());
            continue;
        }
    }
    
    private void processResultFromGallery(final int n, final Intent intent) {
        Uri uri = intent.getData();
        if (uri == null) {
            if (this.croppedUri == null) {
                this.failPicture("null data from photo library");
                return;
            }
            uri = this.croppedUri;
        }
        if (this.mediaType != 0) {
            this.callbackContext.success(uri.toString());
            return;
        }
        if (this.targetHeight == -1 && this.targetWidth == -1 && (n == 1 || n == 2) && !this.correctOrientation) {
            this.callbackContext.success(uri.toString());
            return;
        }
        final String string = uri.toString();
        final String mimeType = FileHelper.getMimeType(string, this.cordova);
        if (!"image/jpeg".equalsIgnoreCase(mimeType) && !"image/png".equalsIgnoreCase(mimeType)) {
            Log.d("CameraLauncher", "I either have a null image path or bitmap");
            this.failPicture("Unable to retrieve path to picture!");
            return;
        }
        Bitmap bitmap;
        while (true) {
            try {
                bitmap = this.getScaledBitmap(string);
                if (bitmap == null) {
                    Log.d("CameraLauncher", "I either have a null image path or bitmap");
                    this.failPicture("Unable to create bitmap!");
                    return;
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
                bitmap = null;
                continue;
            }
            break;
        }
    Label_0259:
        while (true) {
            if (!this.correctOrientation) {
                break Label_0259;
            }
            final int imageOrientation = this.getImageOrientation(uri);
            if (imageOrientation == 0) {
                break Label_0259;
            }
            while (true) {
                final Matrix matrix = new Matrix();
                matrix.setRotate((float)imageOrientation);
                while (true) {
                    try {
                        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                        this.orientationCorrected = true;
                        if (n == 0) {
                            this.processPicture(bitmap);
                            if (bitmap != null) {
                                bitmap.recycle();
                            }
                            System.gc();
                            return;
                        }
                    }
                    catch (OutOfMemoryError outOfMemoryError) {
                        this.orientationCorrected = false;
                        continue Label_0259;
                    }
                    if (n == 1 || n == 2) {
                        if (this.targetHeight <= 0 || this.targetWidth <= 0) {
                            if (!this.correctOrientation || !this.orientationCorrected) {
                                this.callbackContext.success(uri.toString());
                                continue;
                            }
                        }
                        try {
                            this.callbackContext.success("file://" + this.ouputModifiedBitmap(bitmap, uri) + "?" + System.currentTimeMillis());
                            continue;
                        }
                        catch (Exception ex2) {
                            ex2.printStackTrace();
                            this.failPicture("Error retrieving image.");
                            continue;
                        }
                        continue;
                    }
                    continue;
                }
            }
            break;
        }
    }
    
    private Cursor queryImgDB(final Uri uri) {
        return this.cordova.getActivity().getContentResolver().query(uri, new String[] { "_id" }, (String)null, (String[])null, (String)null);
    }
    
    private void scanForGallery(final Uri scanMe) {
        this.scanMe = scanMe;
        if (this.conn != null) {
            this.conn.disconnect();
        }
        (this.conn = new MediaScannerConnection(this.cordova.getActivity().getApplicationContext(), (MediaScannerConnection$MediaScannerConnectionClient)this)).connect();
    }
    
    private Uri whichContentStore() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return MediaStore$Images$Media.EXTERNAL_CONTENT_URI;
        }
        return MediaStore$Images$Media.INTERNAL_CONTENT_URI;
    }
    
    private void writeUncompressedImage(final Uri uri) throws FileNotFoundException, IOException {
        final FileInputStream fileInputStream = new FileInputStream(FileHelper.stripFileProtocol(this.imageUri.toString()));
        final OutputStream openOutputStream = this.cordova.getActivity().getContentResolver().openOutputStream(uri);
        final byte[] array = new byte[4096];
        while (true) {
            final int read = fileInputStream.read(array);
            if (read == -1) {
                break;
            }
            openOutputStream.write(array, 0, read);
        }
        openOutputStream.flush();
        openOutputStream.close();
        fileInputStream.close();
    }
    
    public int[] calculateAspectRatio(final int n, final int n2) {
        int targetWidth = this.targetWidth;
        int targetHeight = this.targetHeight;
        if (targetWidth <= 0 && targetHeight <= 0) {
            targetWidth = n;
            targetHeight = n2;
        }
        else if (targetWidth > 0 && targetHeight <= 0) {
            targetHeight = targetWidth * n2 / n;
        }
        else if (targetWidth <= 0 && targetHeight > 0) {
            targetWidth = targetHeight * n / n2;
        }
        else {
            final double n3 = targetWidth / targetHeight;
            final double n4 = n / n2;
            if (n4 > n3) {
                targetHeight = targetWidth * n2 / n;
            }
            else if (n4 < n3) {
                targetWidth = targetHeight * n / n2;
            }
        }
        return new int[] { targetWidth, targetHeight };
    }
    
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext callbackContext) throws JSONException {
        this.callbackContext = callbackContext;
        if (s.equals("takePicture")) {
            this.saveToPhotoAlbum = false;
            this.targetHeight = 0;
            this.targetWidth = 0;
            this.encodingType = 0;
            this.mediaType = 0;
            this.mQuality = 80;
            this.mQuality = jsonArray.getInt(0);
            final int int1 = jsonArray.getInt(1);
            final int int2 = jsonArray.getInt(2);
            this.targetWidth = jsonArray.getInt(3);
            this.targetHeight = jsonArray.getInt(4);
            this.encodingType = jsonArray.getInt(5);
            this.mediaType = jsonArray.getInt(6);
            this.allowEdit = jsonArray.getBoolean(7);
            this.correctOrientation = jsonArray.getBoolean(8);
            this.saveToPhotoAlbum = jsonArray.getBoolean(9);
            if (this.targetWidth < 1) {
                this.targetWidth = -1;
            }
            if (this.targetHeight < 1) {
                this.targetHeight = -1;
            }
            Label_0204: {
                if (int2 != 1) {
                    break Label_0204;
                }
                try {
                    this.takePicture(int1, this.encodingType);
                    while (true) {
                        while (true) {
                            final PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT);
                            pluginResult.setKeepCallback(true);
                            callbackContext.sendPluginResult(pluginResult);
                            return true;
                            this.getImage(int2, int1, this.encodingType);
                            continue;
                        }
                        continue;
                    }
                }
                // iftrue(Label_0178:, int2 != 0 && int2 != 2)
                catch (IllegalArgumentException ex) {
                    callbackContext.error("Illegal Argument Exception");
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR));
                    return true;
                }
            }
        }
        return false;
    }
    
    public void failPicture(final String s) {
        this.callbackContext.error(s);
    }
    
    public void getImage(final int n, final int n2, final int n3) {
        final Intent intent = new Intent();
        String original = "Get Picture";
        this.croppedUri = null;
        if (this.mediaType == 0) {
            intent.setType("image/*");
            if (this.allowEdit) {
                intent.setAction("android.intent.action.PICK");
                intent.putExtra("crop", "true");
                if (this.targetWidth > 0) {
                    intent.putExtra("outputX", this.targetWidth);
                }
                if (this.targetHeight > 0) {
                    intent.putExtra("outputY", this.targetHeight);
                }
                if (this.targetHeight > 0 && this.targetWidth > 0 && this.targetWidth == this.targetHeight) {
                    intent.putExtra("aspectX", 1);
                    intent.putExtra("aspectY", 1);
                }
                intent.putExtra("output", (Parcelable)(this.croppedUri = Uri.fromFile(this.createCaptureFile(n3))));
            }
            else {
                intent.setAction("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
            }
        }
        else if (this.mediaType == 1) {
            intent.setType("video/*");
            original = "Get Video";
            intent.setAction("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
        }
        else if (this.mediaType == 2) {
            intent.setType("*/*");
            original = "Get All";
            intent.setAction("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
        }
        if (this.cordova != null) {
            this.cordova.startActivityForResult(this, Intent.createChooser(intent, (CharSequence)new String(original)), 1 + (n2 + 16 * (n + 1)));
        }
    }
    
    @Override
    public void onActivityResult(final int p0, final int p1, final Intent p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: iconst_m1      
        //     1: iload_1        
        //     2: bipush          16
        //     4: idiv           
        //     5: iadd           
        //     6: istore          4
        //     8: iconst_m1      
        //     9: iload_1        
        //    10: bipush          16
        //    12: irem           
        //    13: iadd           
        //    14: istore          5
        //    16: iload_1        
        //    17: bipush          100
        //    19: if_icmpne       147
        //    22: iload_2        
        //    23: iconst_m1      
        //    24: if_icmpne       201
        //    27: aload_3        
        //    28: invokevirtual   android/content/Intent.getExtras:()Landroid/os/Bundle;
        //    31: ldc_w           "data"
        //    34: invokevirtual   android/os/Bundle.getParcelable:(Ljava/lang/String;)Landroid/os/Parcelable;
        //    37: checkcast       Landroid/graphics/Bitmap;
        //    40: astore          7
        //    42: aload           7
        //    44: ifnonnull       55
        //    47: aload_0        
        //    48: ldc_w           "Crop returned no data."
        //    51: invokevirtual   org/apache/cordova/camera/CameraLauncher.failPicture:(Ljava/lang/String;)V
        //    54: return         
        //    55: new             Ljava/io/File;
        //    58: dup            
        //    59: aload_0        
        //    60: invokespecial   org/apache/cordova/camera/CameraLauncher.getTempDirectoryPath:()Ljava/lang/String;
        //    63: new             Ljava/lang/StringBuilder;
        //    66: dup            
        //    67: invokestatic    java/lang/System.currentTimeMillis:()J
        //    70: invokestatic    java/lang/String.valueOf:(J)Ljava/lang/String;
        //    73: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    76: ldc_w           ".jpg"
        //    79: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    82: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    85: invokespecial   java/io/File.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //    88: astore          8
        //    90: aload           8
        //    92: invokevirtual   java/io/File.createNewFile:()Z
        //    95: pop            
        //    96: new             Ljava/io/FileOutputStream;
        //    99: dup            
        //   100: aload           8
        //   102: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   105: astore          12
        //   107: aload           7
        //   109: getstatic       android/graphics/Bitmap$CompressFormat.JPEG:Landroid/graphics/Bitmap$CompressFormat;
        //   112: aload_0        
        //   113: getfield        org/apache/cordova/camera/CameraLauncher.mQuality:I
        //   116: aload           12
        //   118: invokevirtual   android/graphics/Bitmap.compress:(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   121: pop            
        //   122: aload           12
        //   124: invokevirtual   java/io/OutputStream.flush:()V
        //   127: aload           12
        //   129: invokevirtual   java/io/OutputStream.close:()V
        //   132: aload_0        
        //   133: getfield        org/apache/cordova/camera/CameraLauncher.callbackContext:Lorg/apache/cordova/CallbackContext;
        //   136: aload           8
        //   138: invokestatic    android/net/Uri.fromFile:(Ljava/io/File;)Landroid/net/Uri;
        //   141: invokevirtual   android/net/Uri.toString:()Ljava/lang/String;
        //   144: invokevirtual   org/apache/cordova/CallbackContext.success:(Ljava/lang/String;)V
        //   147: iload           4
        //   149: iconst_1       
        //   150: if_icmpne       245
        //   153: iload_2        
        //   154: iconst_m1      
        //   155: if_icmpne       225
        //   158: aload_0        
        //   159: iload           5
        //   161: aload_3        
        //   162: invokespecial   org/apache/cordova/camera/CameraLauncher.processResultFromCamera:(ILandroid/content/Intent;)V
        //   165: return         
        //   166: astore          6
        //   168: aload           6
        //   170: invokevirtual   java/io/IOException.printStackTrace:()V
        //   173: aload_0        
        //   174: ldc_w           "Error capturing image."
        //   177: invokevirtual   org/apache/cordova/camera/CameraLauncher.failPicture:(Ljava/lang/String;)V
        //   180: return         
        //   181: astore          10
        //   183: aload           10
        //   185: invokevirtual   java/io/FileNotFoundException.printStackTrace:()V
        //   188: goto            132
        //   191: astore          9
        //   193: aload           9
        //   195: invokevirtual   java/io/IOException.printStackTrace:()V
        //   198: goto            132
        //   201: iload_2        
        //   202: ifne            215
        //   205: aload_0        
        //   206: ldc_w           "Camera cancelled."
        //   209: invokevirtual   org/apache/cordova/camera/CameraLauncher.failPicture:(Ljava/lang/String;)V
        //   212: goto            147
        //   215: aload_0        
        //   216: ldc_w           "Did not complete!"
        //   219: invokevirtual   org/apache/cordova/camera/CameraLauncher.failPicture:(Ljava/lang/String;)V
        //   222: goto            147
        //   225: iload_2        
        //   226: ifne            237
        //   229: aload_0        
        //   230: ldc_w           "Camera cancelled."
        //   233: invokevirtual   org/apache/cordova/camera/CameraLauncher.failPicture:(Ljava/lang/String;)V
        //   236: return         
        //   237: aload_0        
        //   238: ldc_w           "Did not complete!"
        //   241: invokevirtual   org/apache/cordova/camera/CameraLauncher.failPicture:(Ljava/lang/String;)V
        //   244: return         
        //   245: iload           4
        //   247: ifeq            256
        //   250: iload           4
        //   252: iconst_2       
        //   253: if_icmpne       54
        //   256: iload_2        
        //   257: iconst_m1      
        //   258: if_icmpne       269
        //   261: aload_0        
        //   262: iload           5
        //   264: aload_3        
        //   265: invokespecial   org/apache/cordova/camera/CameraLauncher.processResultFromGallery:(ILandroid/content/Intent;)V
        //   268: return         
        //   269: iload_2        
        //   270: ifne            281
        //   273: aload_0        
        //   274: ldc_w           "Selection cancelled."
        //   277: invokevirtual   org/apache/cordova/camera/CameraLauncher.failPicture:(Ljava/lang/String;)V
        //   280: return         
        //   281: aload_0        
        //   282: ldc_w           "Selection did not complete!"
        //   285: invokevirtual   org/apache/cordova/camera/CameraLauncher.failPicture:(Ljava/lang/String;)V
        //   288: return         
        //   289: astore          9
        //   291: goto            193
        //   294: astore          10
        //   296: goto            183
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  90     107    181    183    Ljava/io/FileNotFoundException;
        //  90     107    191    193    Ljava/io/IOException;
        //  107    132    294    299    Ljava/io/FileNotFoundException;
        //  107    132    289    294    Ljava/io/IOException;
        //  158    165    166    181    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0132:
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
    
    public void onMediaScannerConnected() {
        try {
            this.conn.scanFile(this.scanMe.toString(), "image/*");
        }
        catch (IllegalStateException ex) {
            LOG.e("CameraLauncher", "Can't scan file in MediaScanner after taking picture");
        }
    }
    
    public void onScanCompleted(final String s, final Uri uri) {
        this.conn.disconnect();
    }
    
    public void processPicture(final Bitmap bitmap) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            if (bitmap.compress(Bitmap$CompressFormat.JPEG, this.mQuality, (OutputStream)byteArrayOutputStream)) {
                this.callbackContext.success(new String(Base64.encode(byteArrayOutputStream.toByteArray(), 2)));
            }
        }
        catch (Exception ex) {
            this.failPicture("Error compressing image.");
        }
    }
    
    public void takePicture(final int n, final int n2) {
        this.numPics = this.queryImgDB(this.whichContentStore()).getCount();
        final Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        final File captureFile = this.createCaptureFile(n2);
        intent.putExtra("output", (Parcelable)Uri.fromFile(captureFile));
        this.imageUri = Uri.fromFile(captureFile);
        if (this.cordova != null) {
            this.cordova.startActivityForResult(this, intent, 1 + (n + 32));
        }
    }
}
