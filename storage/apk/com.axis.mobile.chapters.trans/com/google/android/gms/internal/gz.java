// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.util.Log;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.content.DialogInterface$OnClickListener;

public class gz implements DialogInterface$OnClickListener
{
    private final Fragment FV;
    private final int FW;
    private final Intent mIntent;
    private final Activity og;
    
    public gz(final Activity og, final Intent mIntent, final int fw) {
        this.og = og;
        this.FV = null;
        this.mIntent = mIntent;
        this.FW = fw;
    }
    
    public gz(final Fragment fv, final Intent mIntent, final int fw) {
        this.og = null;
        this.FV = fv;
        this.mIntent = mIntent;
        this.FW = fw;
    }
    
    public void onClick(final DialogInterface dialogInterface, final int n) {
        try {
            if (this.mIntent != null && this.FV != null) {
                this.FV.startActivityForResult(this.mIntent, this.FW);
            }
            else if (this.mIntent != null) {
                this.og.startActivityForResult(this.mIntent, this.FW);
            }
            dialogInterface.dismiss();
        }
        catch (ActivityNotFoundException ex) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
