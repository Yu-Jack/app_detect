// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.widget;

import java.util.Collections;
import com.facebook.bn;
import com.facebook.b.ae;
import java.util.List;
import com.facebook.bm;
import android.os.AsyncTask;
import android.graphics.Canvas;
import com.facebook.ab;
import com.facebook.bb;
import com.facebook.ar;
import com.facebook.Request;
import com.facebook.a.g;
import com.facebook.b.aj;
import android.view.View;
import com.facebook.b.ak;
import android.content.res.TypedArray;
import com.facebook.a.d;
import android.graphics.Typeface;
import com.facebook.a.c;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View$OnClickListener;
import android.support.v4.app.Fragment;
import com.facebook.c.i;
import com.facebook.b.af;
import android.widget.Button;
import com.facebook.bo;
import com.facebook.bc;
import com.facebook.bj;

final class a implements bj
{
    final /* synthetic */ LoginButton a;
    
    private a(final LoginButton a) {
        this.a = a;
    }
    
    @Override
    public final void a(final bc bc, final bo bo, final Exception ex) {
        this.a.d();
        this.a.c();
        if (this.a.l.f != null) {
            this.a.l.f.a(bc, bo, ex);
        }
        else if (ex != null) {
            this.a.a(ex);
        }
    }
}
