// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.net.Uri;
import android.media.MediaScannerConnection;
import android.os.Handler;
import java.io.File;
import android.media.MediaScannerConnection$MediaScannerConnectionClient;

class x implements MediaScannerConnection$MediaScannerConnectionClient
{
    private final File a;
    private final Handler b;
    private MediaScannerConnection c;
    
    private x(final File a, final Handler b) {
        this.a = a;
        this.b = b;
    }
    
    public void a(final MediaScannerConnection c) {
        this.c = c;
    }
    
    public void onMediaScannerConnected() {
        this.c.scanFile(this.a.getAbsolutePath(), (String)null);
    }
    
    public void onScanCompleted(final String s, final Uri uri) {
        this.c.disconnect();
        if (this.b != null) {
            this.b.sendEmptyMessage(0);
        }
    }
}
