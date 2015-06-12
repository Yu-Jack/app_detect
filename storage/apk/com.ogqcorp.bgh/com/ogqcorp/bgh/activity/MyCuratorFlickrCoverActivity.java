// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import android.content.Context;
import com.ogqcorp.bgh.system.c;
import android.view.View;
import android.view.View$OnClickListener;
import android.annotation.TargetApi;
import com.ogqcorp.bgh.system.l;
import android.os.Build$VERSION;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MyCuratorFlickrCoverActivity extends SherlockFragmentActivity
{
    @TargetApi(8)
    public static void a(final Activity activity, final String s, final Bundle bundle) {
        try {
            final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
            if (Build$VERSION.SDK_INT >= 8 && bundle != null) {
                intent.putExtra("com.android.browser.headers", bundle);
            }
            activity.startActivityForResult(intent, 10);
        }
        catch (Exception ex) {
            l.c(ex);
        }
    }
    
    @Override
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        this.finish();
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903065);
        this.findViewById(2131099755).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                c.a().c((Context)MyCuratorFlickrCoverActivity.this);
                MyCuratorFlickrCoverActivity.a(MyCuratorFlickrCoverActivity.this, "https://www.flickr.com/groups/backgroundshd", null);
            }
        });
        this.findViewById(2131099756).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                MyCuratorFlickrCoverActivity.this.startActivityForResult(new Intent((Context)MyCuratorFlickrCoverActivity.this, (Class)MyCuratorFlickrActivity.class), 10);
            }
        });
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        c.a().a(this);
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        c.a().b(this);
    }
}
