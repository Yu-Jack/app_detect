// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.media.MediaScannerConnection$MediaScannerConnectionClient;
import android.media.MediaScannerConnection;
import android.os.Message;
import android.os.Handler;
import java.io.File;
import android.content.Context;

public final class w
{
    public static void a(final Context context, final File file, final y y) {
        final x x = new x(file, new Handler() {
            public void handleMessage(final Message message) {
                y.a();
            }
        }, null);
        final MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(context, (MediaScannerConnection$MediaScannerConnectionClient)x);
        x.a(mediaScannerConnection);
        mediaScannerConnection.connect();
    }
}
