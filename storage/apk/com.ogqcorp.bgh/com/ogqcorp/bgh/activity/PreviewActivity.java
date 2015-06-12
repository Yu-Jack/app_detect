// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import android.app.Activity;
import com.ogqcorp.commons.t;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.view.View$OnSystemUiVisibilityChangeListener;
import android.os.Build$VERSION;
import com.ogqcorp.bgh.system.PreviewSurfaceView;
import java.io.Serializable;
import android.content.Intent;
import java.io.File;
import android.content.Context;
import com.ogqcorp.bgh.activity.a.a;

public final class PreviewActivity extends a
{
    public static Intent a(final Context context, final File file) {
        final Intent intent = new Intent(context.getApplicationContext(), (Class)PreviewActivity.class);
        intent.putExtra("KEY_PREVIEW_FILE", (Serializable)file);
        return intent;
    }
    
    @TargetApi(14)
    private void a(final PreviewSurfaceView previewSurfaceView) {
        if (Build$VERSION.SDK_INT < 14) {
            return;
        }
        previewSurfaceView.setOnSystemUiVisibilityChangeListener((View$OnSystemUiVisibilityChangeListener)new View$OnSystemUiVisibilityChangeListener() {
            public void onSystemUiVisibilityChange(final int n) {
                if (n == 0) {
                    previewSurfaceView.post((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            previewSurfaceView.setSystemUiVisibility(1);
                        }
                    });
                }
            }
        });
        previewSurfaceView.setSystemUiVisibility(1);
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903067);
        final File bitmapFile = (File)this.getIntent().getSerializableExtra("KEY_PREVIEW_FILE");
        final PreviewSurfaceView previewSurfaceView = (PreviewSurfaceView)this.findViewById(2131099762);
        this.a(previewSurfaceView);
        previewSurfaceView.setBitmapFile(bitmapFile);
        previewSurfaceView.setVisibility(0);
    }
    
    @Override
    protected void onDestroy() {
        t.a(this);
        System.gc();
        super.onDestroy();
    }
}
