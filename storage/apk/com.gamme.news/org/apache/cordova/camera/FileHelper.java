// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.camera;

import android.database.Cursor;
import org.apache.cordova.LOG;
import android.webkit.MimeTypeMap;
import java.util.Locale;
import java.io.IOException;
import java.io.FileInputStream;
import android.net.Uri;
import java.io.InputStream;
import org.apache.cordova.CordovaInterface;

public class FileHelper
{
    private static final String LOG_TAG = "FileUtils";
    private static final String _DATA = "_data";
    
    public static InputStream getInputStreamFromUriString(String substring, final CordovaInterface cordovaInterface) throws IOException {
        if (substring.startsWith("content")) {
            return cordovaInterface.getActivity().getContentResolver().openInputStream(Uri.parse(substring));
        }
        if (!substring.startsWith("file://")) {
            return new FileInputStream(getRealPath(substring, cordovaInterface));
        }
        final int index = substring.indexOf("?");
        if (index > -1) {
            substring = substring.substring(0, index);
        }
        if (substring.startsWith("file:///android_asset/")) {
            return cordovaInterface.getActivity().getAssets().open(Uri.parse(substring).getPath().substring(15));
        }
        return new FileInputStream(getRealPath(substring, cordovaInterface));
    }
    
    public static String getMimeType(final String s, final CordovaInterface cordovaInterface) {
        final Uri parse = Uri.parse(s);
        if (s.startsWith("content://")) {
            return cordovaInterface.getActivity().getContentResolver().getType(parse);
        }
        return getMimeTypeForExtension(parse.getPath());
    }
    
    public static String getMimeTypeForExtension(final String s) {
        String substring = s;
        final int lastIndex = substring.lastIndexOf(46);
        if (lastIndex != -1) {
            substring = substring.substring(lastIndex + 1);
        }
        final String lowerCase = substring.toLowerCase(Locale.getDefault());
        if (lowerCase.equals("3ga")) {
            return "audio/3gpp";
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
    }
    
    public static String getRealPath(final Uri uri, final CordovaInterface cordovaInterface) {
        return getRealPath(uri.toString(), cordovaInterface);
    }
    
    public static String getRealPath(final String s, final CordovaInterface cordovaInterface) {
        String s2;
        if (s.startsWith("content://")) {
            final Cursor managedQuery = cordovaInterface.getActivity().managedQuery(Uri.parse(s), new String[] { "_data" }, (String)null, (String[])null, (String)null);
            final int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
            managedQuery.moveToFirst();
            s2 = managedQuery.getString(columnIndexOrThrow);
            if (s2 == null) {
                LOG.e("FileUtils", "Could get real path for URI string %s", s);
            }
        }
        else {
            if (!s.startsWith("file://")) {
                return s;
            }
            s2 = s.substring(7);
            if (s2.startsWith("/android_asset/")) {
                LOG.e("FileUtils", "Cannot get real path for URI string %s because it is a file:///android_asset/ URI.", s);
                return null;
            }
        }
        return s2;
    }
    
    public static String stripFileProtocol(String substring) {
        if (substring.startsWith("file://")) {
            substring = substring.substring(7);
        }
        return substring;
    }
}
