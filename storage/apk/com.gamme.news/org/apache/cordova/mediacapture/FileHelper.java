// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.mediacapture;

import android.webkit.MimeTypeMap;
import java.util.Locale;
import org.apache.cordova.CordovaInterface;
import android.net.Uri;

public class FileHelper
{
    public static String getMimeType(final Uri uri, final CordovaInterface cordovaInterface) {
        if ("content".equals(uri.getScheme())) {
            return cordovaInterface.getActivity().getContentResolver().getType(uri);
        }
        return getMimeTypeForExtension(uri.getPath());
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
}
