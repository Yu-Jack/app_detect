import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.GestureDetector$SimpleOnGestureListener;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import android.content.res.Configuration;
import java.util.Iterator;
import android.text.SpannableString;
import android.widget.TextView$BufferType;
import android.text.method.LinkMovementMethod;
import android.os.Build$VERSION;
import com.socialnmobile.colornote.util.LinkText;
import android.app.Activity;
import android.widget.ListAdapter;
import android.widget.FilterQueryProvider;
import android.view.GestureDetector$OnDoubleTapListener;
import android.view.View$OnKeyListener;
import android.text.TextWatcher;
import android.widget.AdapterView$OnItemClickListener;
import android.view.View$OnFocusChangeListener;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.net.Uri;
import android.view.inputmethod.InputMethodManager;
import android.content.Intent;
import android.widget.Filter$FilterListener;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.EditText;
import com.socialnmobile.colornote.view.LinedTextView;
import com.socialnmobile.colornote.view.LinedEditText;
import android.os.Handler;
import android.view.View;

public final class pz extends GestureDetector$SimpleOnGestureListener
{
    final /* synthetic */ TextEditor a;
    
    public pz(final TextEditor a) {
        this.a = a;
    }
    
    public final boolean onDoubleTap(final MotionEvent motionEvent) {
        if (this.a.aa()) {
            if (jo.a((Context)this.a.h(), "DTAP_EDIT_COUNT") < 5) {
                final FragmentActivity h = this.a.h();
                jo.a((Context)h, "DTAP_EDIT_COUNT", 1 + jo.a((Context)h, "DTAP_EDIT_COUNT"));
            }
            int selection = TextEditor.a(this.a).a((int)motionEvent.getX(), (int)motionEvent.getY());
            if (selection > TextEditor.b(this.a).length()) {
                selection = TextEditor.b(this.a).length();
            }
            TextEditor.b(this.a).setSelection(selection);
            this.a.a(false, "TAP");
        }
        return true;
    }
    
    public final boolean onSingleTapConfirmed(final MotionEvent motionEvent) {
        final boolean aa = this.a.aa();
        boolean b = false;
        if (aa) {
            final boolean m = this.a.m();
            b = false;
            if (m) {
                final int a = jo.a((Context)this.a.h(), "DTAP_EDIT_COUNT");
                b = false;
                if (a < 5) {
                    if (TextEditor.c(this.a) == null) {
                        TextEditor.a(this.a, Toast.makeText((Context)this.a.h(), 2131230851, 0));
                    }
                    TextEditor.c(this.a).show();
                    b = true;
                }
            }
        }
        return b;
    }
}
