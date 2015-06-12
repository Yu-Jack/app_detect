// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.content.Context;
import android.app.AlertDialog$Builder;
import android.app.Activity;

public class PreviewActivity extends Activity
{
    private void displayAlert(final String title, final String message, final String s) {
        final AlertDialog create = new AlertDialog$Builder((Context)this).create();
        create.setTitle((CharSequence)title);
        create.setMessage((CharSequence)message);
        create.setButton(-1, (CharSequence)s, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
            }
        });
        create.show();
    }
    
    public void onCreate(final Bundle bundle) {
        try {
            super.onCreate(bundle);
            Log.i("Preview activity");
            final Uri data = this.getIntent().getData();
            if (!TagManager.getInstance((Context)this).setPreviewData(data)) {
                final String string = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                Log.w(string);
                this.displayAlert("Preview failure", string, "Continue");
            }
            final Intent launchIntentForPackage = this.getPackageManager().getLaunchIntentForPackage(this.getPackageName());
            if (launchIntentForPackage != null) {
                Log.i("Invoke the launch activity for package name: " + this.getPackageName());
                this.startActivity(launchIntentForPackage);
                return;
            }
            Log.i("No launch activity found for package name: " + this.getPackageName());
        }
        catch (Exception ex) {
            Log.e("Calling preview threw an exception: " + ex.getMessage());
        }
    }
}
