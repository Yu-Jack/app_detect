import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;

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
import android.view.View$OnFocusChangeListener;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.net.Uri;
import android.view.inputmethod.InputMethodManager;
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

public final class qo implements AdapterView$OnItemClickListener
{
    final /* synthetic */ TextEditor a;
    
    public qo(final TextEditor a) {
        this.a = a;
    }
    
    public final void onItemClick(final AdapterView adapterView, final View view, final int n, final long n2) {
        final Cursor cursor = (Cursor)TextEditor.e(this.a).getItemAtPosition(n);
        TextEditor.h(this.a).setText((CharSequence)cursor.getString(cursor.getColumnIndex("suggest_text_1")));
        TextEditor.b(this.a).requestFocus();
    }
}
