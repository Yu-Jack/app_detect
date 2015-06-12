// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.file;

import java.util.List;
import android.net.Uri;

public class LocalFilesystemURL
{
    public static final String FILESYSTEM_PROTOCOL = "cdvfile";
    Uri URL;
    String filesystemName;
    String fullPath;
    
    public LocalFilesystemURL(final Uri url) {
        this.URL = url;
        this.filesystemName = this.filesystemNameForLocalURL(url);
        this.fullPath = this.fullPathForLocalURL(url);
    }
    
    public LocalFilesystemURL(final String s) {
        this(Uri.parse(s));
    }
    
    private String filesystemNameForLocalURL(final Uri uri) {
        String s;
        if ("cdvfile".equals(uri.getScheme()) && "localhost".equals(uri.getHost())) {
            final List pathSegments = uri.getPathSegments();
            s = null;
            if (pathSegments != null) {
                final int size = pathSegments.size();
                s = null;
                if (size > 0) {
                    s = pathSegments.get(0);
                }
            }
        }
        else {
            final boolean equals = "content".equals(uri.getScheme());
            s = null;
            if (equals) {
                return "content";
            }
        }
        return s;
    }
    
    private String fullPathForLocalURL(final Uri uri) {
        if ("cdvfile".equals(uri.getScheme()) && "localhost".equals(uri.getHost())) {
            String obj = uri.getPath();
            if (uri.getQuery() != null) {
                obj = String.valueOf(obj) + "?" + uri.getQuery();
            }
            return obj.substring(obj.indexOf(47, 1));
        }
        if ("content".equals(uri.getScheme())) {
            return Uri.encode(String.valueOf('/') + uri.getHost() + uri.getPath(), "/");
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "cdvfile://localhost/" + this.filesystemName + this.fullPath;
    }
}
