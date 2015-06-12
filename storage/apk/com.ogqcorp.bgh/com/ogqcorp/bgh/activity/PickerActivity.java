// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import android.support.v4.app.FragmentActivity;
import com.ogqcorp.bgh.a.a;
import android.net.Uri;
import java.io.File;
import com.ogqcorp.commons.u;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import com.ogqcorp.bgh.item.Background;
import com.ogqcorp.bgh.activity.a.b;

public final class PickerActivity extends b
{
    private static String a;
    private static Background b;
    
    public static String a() {
        return PickerActivity.a;
    }
    
    public static void a(final Background b) {
        PickerActivity.b = b;
    }
    
    public static Background b() {
        return PickerActivity.b;
    }
    
    @Override
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (PickerActivity.b == null) {
            this.setResult(0, (Intent)null);
            this.finish();
        }
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        PickerActivity.a = this.getIntent().getAction();
        this.startActivityForResult(SplashActivity.a((Context)this), 0);
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        PickerActivity.a = null;
        PickerActivity.b = null;
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        if (PickerActivity.b == null) {
            return;
        }
        com.ogqcorp.bgh.a.a.a(this, PickerActivity.b, true, new u<File>() {
            @Override
            public void a(final File file) {
                if (PickerActivity.this.isFinishing()) {
                    return;
                }
                PickerActivity.this.setResult(-1, new Intent().setData(Uri.fromFile(file)));
                PickerActivity.this.finish();
            }
        }, null);
    }
}
