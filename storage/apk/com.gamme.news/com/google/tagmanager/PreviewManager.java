// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import android.net.Uri;

class PreviewManager
{
    static final String BASE_DEBUG_QUERY = "&gtm_debug=x";
    private static final String CONTAINER_BASE_PATTERN = "^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&";
    private static final String CONTAINER_DEBUG_STRING_PATTERN = ".*?&gtm_debug=x$";
    private static final String CONTAINER_PREVIEW_EXIT_URL_PATTERN = "^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$";
    private static final String CONTAINER_PREVIEW_URL_PATTERN = "^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$";
    static final String CTFE_URL_PATH_PREFIX = "/r?";
    private static PreviewManager sInstance;
    private volatile String mCTFEUrlPath;
    private volatile String mCTFEUrlQuery;
    private volatile String mContainerId;
    private volatile PreviewMode mPreviewMode;
    
    PreviewManager() {
        this.clear();
    }
    
    private String getContainerId(final String s) {
        return s.split("&")[0].split("=")[1];
    }
    
    static PreviewManager getInstance() {
        synchronized (PreviewManager.class) {
            if (PreviewManager.sInstance == null) {
                PreviewManager.sInstance = new PreviewManager();
            }
            return PreviewManager.sInstance;
        }
    }
    
    private String getQueryWithoutDebugParameter(final Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }
    
    void clear() {
        this.mPreviewMode = PreviewMode.NONE;
        this.mCTFEUrlPath = null;
        this.mContainerId = null;
        this.mCTFEUrlQuery = null;
    }
    
    String getCTFEUrlDebugQuery() {
        return this.mCTFEUrlQuery;
    }
    
    String getCTFEUrlPath() {
        return this.mCTFEUrlPath;
    }
    
    String getContainerId() {
        return this.mContainerId;
    }
    
    PreviewMode getPreviewMode() {
        return this.mPreviewMode;
    }
    
    boolean setPreviewData(final Uri uri) {
        while (true) {
            boolean b = true;
            String decode;
            synchronized (this) {
                while (true) {
                    while (true) {
                        try {
                            decode = URLDecoder.decode(uri.toString(), "UTF-8");
                            if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                                break;
                            }
                            Log.v("Container preview url: " + decode);
                            if (decode.matches(".*?&gtm_debug=x$")) {
                                this.mPreviewMode = PreviewMode.CONTAINER_DEBUG;
                                this.mCTFEUrlQuery = this.getQueryWithoutDebugParameter(uri);
                                if (this.mPreviewMode == PreviewMode.CONTAINER || this.mPreviewMode == PreviewMode.CONTAINER_DEBUG) {
                                    this.mCTFEUrlPath = "/r?" + this.mCTFEUrlQuery;
                                }
                                this.mContainerId = this.getContainerId(this.mCTFEUrlQuery);
                                return b;
                            }
                        }
                        catch (UnsupportedEncodingException ex) {
                            b = false;
                            return b;
                        }
                        this.mPreviewMode = PreviewMode.CONTAINER;
                        continue;
                    }
                }
            }
            if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                Log.w("Invalid preview uri: " + decode);
                b = false;
                return b;
            }
            if (this.getContainerId(uri.getQuery()).equals(this.mContainerId)) {
                Log.v("Exit preview mode for container: " + this.mContainerId);
                this.mPreviewMode = PreviewMode.NONE;
                this.mCTFEUrlPath = null;
                return b;
            }
            b = false;
            return b;
        }
    }
    
    enum PreviewMode
    {
        CONTAINER, 
        CONTAINER_DEBUG, 
        NONE;
    }
}
