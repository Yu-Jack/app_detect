// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.os.Bundle;
import android.content.DialogInterface$OnCancelListener;
import android.widget.Toast;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.content.Context;
import com.ogqcorp.bgh.b;
import com.ogqcorp.bgh.a;
import android.app.Activity;

public final class s
{
    public static void a(final Activity activity) {
        if (a.a != b.a) {
            final int d = v.a().d((Context)activity);
            if (d >= 0) {
                if (d < 9) {
                    v.a().c((Context)activity, d + 1);
                    return;
                }
                try {
                    c(activity);
                }
                catch (Exception ex) {
                    l.c(ex);
                }
            }
        }
    }
    
    private static void a(final Activity activity, final AlertDialog$Builder alertDialog$Builder) {
        alertDialog$Builder.setPositiveButton(2131427469, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                try {
                    v.a().c((Context)activity, -1);
                    d(activity);
                }
                catch (Exception ex) {
                    Toast.makeText((Context)activity, 2131427481, 0).show();
                }
            }
        });
    }
    
    private static void b(final Activity activity, final AlertDialog$Builder alertDialog$Builder) {
        alertDialog$Builder.setNegativeButton(2131427467, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                v.a().c((Context)activity, -1);
            }
        });
    }
    
    private static void c(final Activity activity) {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)activity);
        alertDialog$Builder.setIcon(17301659).setTitle(2131427468).setMessage((CharSequence)activity.getString(2131427466).replace("$APP_STORE_NAME$", a.a((Context)activity)).replace("$APP_STORE_LINK$", a.b((Context)activity)));
        a(activity, alertDialog$Builder);
        b(activity, alertDialog$Builder);
        c(activity, alertDialog$Builder);
        alertDialog$Builder.setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
            public void onCancel(final DialogInterface dialogInterface) {
                v.a().c((Context)activity, -1);
            }
        });
        alertDialog$Builder.show();
    }
    
    private static void c(final Activity activity, final AlertDialog$Builder alertDialog$Builder) {
    }
    
    private static void d(final Activity activity) {
        switch (s$4.a[a.a.ordinal()]) {
            default: {}
            case 1: {
                ac.a(activity, "market://details?id=" + activity.getPackageName(), null);
            }
            case 2:
            case 3: {
                ac.a(activity, a.b((Context)activity), null);
            }
        }
    }
}
