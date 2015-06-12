// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.widget;

import java.util.Collections;
import com.facebook.bn;
import java.util.List;
import com.facebook.bm;
import android.os.AsyncTask;
import android.graphics.Canvas;
import com.facebook.ab;
import com.facebook.bb;
import com.facebook.ar;
import com.facebook.Request;
import com.facebook.bj;
import com.facebook.b.aj;
import com.facebook.b.ak;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import com.facebook.a.c;
import android.util.AttributeSet;
import android.support.v4.app.Fragment;
import com.facebook.c.i;
import com.facebook.b.af;
import android.widget.Button;
import android.content.Context;
import android.os.Bundle;
import com.facebook.d;
import com.facebook.b.ae;
import android.app.Activity;
import com.facebook.bg;
import com.facebook.bf;
import android.content.DialogInterface;
import com.facebook.bc;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import com.facebook.a.g;
import android.view.View;
import android.view.View$OnClickListener;

final class c implements View$OnClickListener
{
    final /* synthetic */ LoginButton a;
    
    private c(final LoginButton a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        final Context context = this.a.getContext();
        final bc b = this.a.c.b();
        if (b != null) {
            if (this.a.f) {
                final String string = this.a.getResources().getString(g.f);
                final String string2 = this.a.getResources().getString(g.d);
                String message;
                if (this.a.d != null && this.a.d.g() != null) {
                    message = String.format(this.a.getResources().getString(g.h), this.a.d.g());
                }
                else {
                    message = this.a.getResources().getString(g.i);
                }
                final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(context);
                alertDialog$Builder.setMessage((CharSequence)message).setCancelable(true).setPositiveButton((CharSequence)string, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                    public final void onClick(final DialogInterface dialogInterface, final int n) {
                        b.e();
                    }
                }).setNegativeButton((CharSequence)string2, (DialogInterface$OnClickListener)null);
                alertDialog$Builder.create().show();
            }
            else {
                b.e();
            }
        }
        else {
            bc bc = this.a.c.a();
            if (bc == null || bc.b().b()) {
                this.a.c.c();
                bc = new bf(context).a(this.a.b).a();
                com.facebook.bc.a(bc);
            }
            if (!bc.a()) {
                bg bg;
                if (this.a.k != null) {
                    bg = new bg(this.a.k);
                }
                else if (context instanceof Activity) {
                    bg = new bg((Activity)context);
                }
                else {
                    bg = null;
                }
                if (bg != null) {
                    bg.b(this.a.l.a);
                    bg.b(this.a.l.b);
                    bg.b(this.a.l.e);
                    if (ae.b.equals(this.a.l.c)) {
                        bc.b(bg);
                    }
                    else {
                        bc.a(bg);
                    }
                }
            }
        }
        final d a = d.a(this.a.getContext());
        final Bundle bundle = new Bundle();
        int n;
        if (b != null) {
            n = 0;
        }
        else {
            n = 1;
        }
        bundle.putInt("logging_in", n);
        a.b(this.a.m, bundle);
        if (this.a.n != null) {
            this.a.n.onClick(view);
        }
    }
}
