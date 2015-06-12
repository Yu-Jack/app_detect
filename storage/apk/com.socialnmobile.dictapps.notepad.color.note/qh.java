import android.view.View;
import android.view.inputmethod.InputMethodManager;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import android.content.res.Configuration;
import java.util.Iterator;
import android.support.v4.app.FragmentActivity;
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
import android.content.Intent;
import android.content.Context;
import android.widget.Filter$FilterListener;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.EditText;
import com.socialnmobile.colornote.view.LinedTextView;
import com.socialnmobile.colornote.view.LinedEditText;
import android.view.GestureDetector$SimpleOnGestureListener;
import android.os.Handler;
import android.widget.Toast;

public final class qh implements Runnable
{
    final /* synthetic */ TextEditor a;
    
    public qh(final TextEditor a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        if (this.a.h() != null) {
            final InputMethodManager inputMethodManager = (InputMethodManager)this.a.h().getSystemService("input_method");
            inputMethodManager.restartInput((View)this.a.ac.c);
            inputMethodManager.restartInput((View)TextEditor.b(this.a));
        }
    }
}
