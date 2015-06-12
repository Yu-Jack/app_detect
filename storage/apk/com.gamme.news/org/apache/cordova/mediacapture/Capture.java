// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.mediacapture;

import java.io.OutputStream;
import org.apache.cordova.LOG;
import java.io.FileInputStream;
import android.content.ContentValues;
import org.apache.cordova.PluginResult;
import android.provider.MediaStore$Images$Media;
import android.os.Environment;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory$Options;
import java.io.IOException;
import android.util.Log;
import android.media.MediaPlayer;
import org.apache.cordova.file.LocalFilesystemURL;
import org.apache.cordova.file.FileUtils;
import org.json.JSONException;
import android.database.Cursor;
import android.os.Build$VERSION;
import android.os.Parcelable;
import java.io.File;
import android.content.Intent;
import org.json.JSONObject;
import android.net.Uri;
import org.json.JSONArray;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

public class Capture extends CordovaPlugin
{
    private static final String AUDIO_3GPP = "audio/3gpp";
    private static final int CAPTURE_AUDIO = 0;
    private static final int CAPTURE_IMAGE = 1;
    private static final int CAPTURE_INTERNAL_ERR = 0;
    private static final int CAPTURE_NO_MEDIA_FILES = 3;
    private static final int CAPTURE_VIDEO = 2;
    private static final String IMAGE_JPEG = "image/jpeg";
    private static final String LOG_TAG = "Capture";
    private static final String VIDEO_3GPP = "video/3gpp";
    private static final String VIDEO_MP4 = "video/mp4";
    private CallbackContext callbackContext;
    private int duration;
    private long limit;
    private int numPics;
    private JSONArray results;
    
    private void captureAudio() {
        this.cordova.startActivityForResult(this, new Intent("android.provider.MediaStore.RECORD_SOUND"), 0);
    }
    
    private void captureImage() {
        this.numPics = this.queryImgDB(this.whichContentStore()).getCount();
        final Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", (Parcelable)Uri.fromFile(new File(this.getTempDirectoryPath(), "Capture.jpg")));
        this.cordova.startActivityForResult(this, intent, 1);
    }
    
    private void captureVideo(final int n) {
        final Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        if (Build$VERSION.SDK_INT > 7) {
            intent.putExtra("android.intent.extra.durationLimit", n);
        }
        this.cordova.startActivityForResult(this, intent, 2);
    }
    
    private void checkForDuplicateImage() {
        final Uri whichContentStore = this.whichContentStore();
        final Cursor queryImgDB = this.queryImgDB(whichContentStore);
        if (queryImgDB.getCount() - this.numPics == 2) {
            queryImgDB.moveToLast();
            this.cordova.getActivity().getContentResolver().delete(Uri.parse(whichContentStore + "/" + (-1 + Integer.valueOf(queryImgDB.getString(queryImgDB.getColumnIndex("_id"))))), (String)null, (String[])null);
        }
    }
    
    private JSONObject createErrorObject(final int n, final String s) {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("code", n);
            jsonObject.put("message", (Object)s);
            return jsonObject;
        }
        catch (JSONException ex) {
            return jsonObject;
        }
    }
    
    private JSONObject createMediaFile(final Uri uri) {
        while (true) {
            final File mapUriToFile = this.webView.getResourceApi().mapUriToFile(uri);
            final JSONObject jsonObject = new JSONObject();
            final LocalFilesystemURL filesystemURLforLocalPath = ((FileUtils)this.webView.pluginManager.getPlugin("File")).filesystemURLforLocalPath(mapUriToFile.getAbsolutePath());
            while (true) {
                try {
                    jsonObject.put("name", (Object)mapUriToFile.getName());
                    jsonObject.put("fullPath", (Object)mapUriToFile.toURI().toString());
                    if (filesystemURLforLocalPath != null) {
                        jsonObject.put("localURL", (Object)filesystemURLforLocalPath.toString());
                    }
                    if (mapUriToFile.getAbsoluteFile().toString().endsWith(".3gp") || mapUriToFile.getAbsoluteFile().toString().endsWith(".3gpp")) {
                        if (uri.toString().contains("/audio/")) {
                            jsonObject.put("type", (Object)"audio/3gpp");
                        }
                        else {
                            jsonObject.put("type", (Object)"video/3gpp");
                        }
                        jsonObject.put("lastModifiedDate", mapUriToFile.lastModified());
                        jsonObject.put("size", mapUriToFile.length());
                        return jsonObject;
                    }
                }
                catch (JSONException ex) {
                    ex.printStackTrace();
                    return jsonObject;
                }
                jsonObject.put("type", (Object)FileHelper.getMimeType(Uri.fromFile(mapUriToFile), this.cordova));
                continue;
            }
        }
    }
    
    private JSONObject getAudioVideoData(final String dataSource, final JSONObject jsonObject, final boolean b) throws JSONException {
        final MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(dataSource);
            mediaPlayer.prepare();
            jsonObject.put("duration", mediaPlayer.getDuration() / 1000);
            if (b) {
                jsonObject.put("height", mediaPlayer.getVideoHeight());
                jsonObject.put("width", mediaPlayer.getVideoWidth());
            }
            return jsonObject;
        }
        catch (IOException ex) {
            Log.d("Capture", "Error: loading video file");
            return jsonObject;
        }
    }
    
    private JSONObject getFormatData(final String pathname, String mimeType) throws JSONException {
        Uri uri;
        if (pathname.startsWith("file:")) {
            uri = Uri.parse(pathname);
        }
        else {
            uri = Uri.fromFile(new File(pathname));
        }
        JSONObject imageData = new JSONObject();
        imageData.put("height", 0);
        imageData.put("width", 0);
        imageData.put("bitrate", 0);
        imageData.put("duration", 0);
        imageData.put("codecs", (Object)"");
        if (mimeType == null || mimeType.equals("") || "null".equals(mimeType)) {
            mimeType = FileHelper.getMimeType(uri, this.cordova);
        }
        Log.d("Capture", "Mime type = " + mimeType);
        if (mimeType.equals("image/jpeg") || pathname.endsWith(".jpg")) {
            imageData = this.getImageData(uri, imageData);
        }
        else {
            if (mimeType.endsWith("audio/3gpp")) {
                return this.getAudioVideoData(pathname, imageData, false);
            }
            if (mimeType.equals("video/3gpp") || mimeType.equals("video/mp4")) {
                return this.getAudioVideoData(pathname, imageData, true);
            }
        }
        return imageData;
    }
    
    private JSONObject getImageData(final Uri uri, final JSONObject jsonObject) throws JSONException {
        final BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        bitmapFactory$Options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(uri.getPath(), bitmapFactory$Options);
        jsonObject.put("height", bitmapFactory$Options.outHeight);
        jsonObject.put("width", bitmapFactory$Options.outWidth);
        return jsonObject;
    }
    
    private String getTempDirectoryPath() {
        final File cacheDir = this.cordova.getActivity().getCacheDir();
        cacheDir.mkdirs();
        return cacheDir.getAbsolutePath();
    }
    
    private Cursor queryImgDB(final Uri uri) {
        return this.cordova.getActivity().getContentResolver().query(uri, new String[] { "_id" }, (String)null, (String[])null, (String)null);
    }
    
    private Uri whichContentStore() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return MediaStore$Images$Media.EXTERNAL_CONTENT_URI;
        }
        return MediaStore$Images$Media.INTERNAL_CONTENT_URI;
    }
    
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext callbackContext) throws JSONException {
        this.callbackContext = callbackContext;
        this.limit = 1L;
        this.duration = 0;
        this.results = new JSONArray();
        final JSONObject optJSONObject = jsonArray.optJSONObject(0);
        if (optJSONObject != null) {
            this.limit = optJSONObject.optLong("limit", 1L);
            this.duration = optJSONObject.optInt("duration", 0);
        }
        if (s.equals("getFormatData")) {
            callbackContext.success(this.getFormatData(jsonArray.getString(0), jsonArray.getString(1)));
            return true;
        }
        if (s.equals("captureAudio")) {
            this.captureAudio();
            return true;
        }
        if (s.equals("captureImage")) {
            this.captureImage();
            return true;
        }
        if (s.equals("captureVideo")) {
            this.captureVideo(this.duration);
            return true;
        }
        return false;
    }
    
    public void fail(final JSONObject jsonObject) {
        this.callbackContext.error(jsonObject);
    }
    
    @Override
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n2 == -1) {
            if (n == 0) {
                this.cordova.getThreadPool().execute(new Runnable() {
                    @Override
                    public void run() {
                        Capture.this.results.put((Object)Capture.this.createMediaFile(intent.getData()));
                        if (Capture.this.results.length() >= Capture.this.limit) {
                            Capture.this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, Capture.this.results));
                            return;
                        }
                        Capture.this.captureAudio();
                    }
                });
            }
            else {
                if (n == 1) {
                    this.cordova.getThreadPool().execute(new Runnable() {
                        @Override
                        public void run() {
                            while (true) {
                                while (true) {
                                    OutputStream openOutputStream = null;
                                    byte[] array = null;
                                    int read = 0;
                                    Label_0303: {
                                        try {
                                            final ContentValues contentValues = new ContentValues();
                                            contentValues.put("mime_type", "image/jpeg");
                                            try {
                                                final Uri uri = Capture.this.cordova.getActivity().getContentResolver().insert(MediaStore$Images$Media.EXTERNAL_CONTENT_URI, contentValues);
                                                final FileInputStream fileInputStream = new FileInputStream(String.valueOf(Capture.this.getTempDirectoryPath()) + "/Capture.jpg");
                                                openOutputStream = Capture.this.cordova.getActivity().getContentResolver().openOutputStream(uri);
                                                array = new byte[4096];
                                                read = fileInputStream.read(array);
                                                if (read != -1) {
                                                    break Label_0303;
                                                }
                                                openOutputStream.flush();
                                                openOutputStream.close();
                                                fileInputStream.close();
                                                Capture.this.results.put((Object)Capture.this.createMediaFile(uri));
                                                Capture.this.checkForDuplicateImage();
                                                if (Capture.this.results.length() >= Capture.this.limit) {
                                                    Capture.this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, Capture.this.results));
                                                    return;
                                                }
                                                break;
                                            }
                                            catch (UnsupportedOperationException ex2) {
                                                LOG.d("Capture", "Can't write to external media storage.");
                                                try {
                                                    final Uri uri = Capture.this.cordova.getActivity().getContentResolver().insert(MediaStore$Images$Media.INTERNAL_CONTENT_URI, contentValues);
                                                }
                                                catch (UnsupportedOperationException ex3) {
                                                    LOG.d("Capture", "Can't write to internal media storage.");
                                                    Capture.this.fail(Capture.this.createErrorObject(0, "Error capturing image - no media storage found."));
                                                    return;
                                                }
                                            }
                                        }
                                        catch (IOException ex) {
                                            ex.printStackTrace();
                                            Capture.this.fail(Capture.this.createErrorObject(0, "Error capturing image."));
                                            return;
                                        }
                                    }
                                    openOutputStream.write(array, 0, read);
                                    continue;
                                }
                            }
                            Capture.this.captureImage();
                        }
                    });
                    return;
                }
                if (n == 2) {
                    this.cordova.getThreadPool().execute(new Runnable() {
                        @Override
                        public void run() {
                            final Intent val$intent = intent;
                            Uri uri = null;
                            if (val$intent != null) {
                                uri = intent.getData();
                            }
                            if (uri == null) {
                                uri = Uri.fromFile(new File(Capture.this.getTempDirectoryPath(), "Capture.avi"));
                            }
                            if (uri == null) {
                                Capture.this.fail(Capture.this.createErrorObject(3, "Error: data is null"));
                                return;
                            }
                            Capture.this.results.put((Object)Capture.this.createMediaFile(uri));
                            if (Capture.this.results.length() >= Capture.this.limit) {
                                Capture.this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, Capture.this.results));
                                return;
                            }
                            Capture.this.captureVideo(Capture.this.duration);
                        }
                    });
                }
            }
            return;
        }
        if (n2 == 0) {
            if (this.results.length() > 0) {
                this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, this.results));
                return;
            }
            this.fail(this.createErrorObject(3, "Canceled."));
        }
        else {
            if (this.results.length() > 0) {
                this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, this.results));
                return;
            }
            this.fail(this.createErrorObject(3, "Did not complete!"));
        }
    }
}
