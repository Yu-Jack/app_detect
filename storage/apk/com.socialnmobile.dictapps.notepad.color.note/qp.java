import android.text.Editable;
import android.view.View;
import android.view.View$OnClickListener;

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

public final class qp implements View$OnClickListener
{
    final /* synthetic */ TextEditor a;
    
    public qp(final TextEditor a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        int selectionStart = TextEditor.b(this.a).getSelectionStart();
        int selectionEnd = TextEditor.b(this.a).getSelectionEnd();
        final Editable editableText = TextEditor.b(this.a).getEditableText();
        if (selectionStart <= selectionEnd) {
            final int n = selectionEnd;
            selectionEnd = selectionStart;
            selectionStart = n;
        }
        editableText.replace(selectionEnd, selectionStart, (CharSequence)TextEditor.h(this.a).getText().toString());
        TextEditor.b(this.a).setSelection(TextEditor.b(this.a).getSelectionEnd());
        TextEditor.b(this.a).requestFocus();
    }
}
