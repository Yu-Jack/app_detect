import java.util.ArrayList;
import java.util.Collection;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import android.widget.Adapter;
import java.util.Locale;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView$AdapterContextMenuInfo;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import android.content.DialogInterface$OnClickListener;
import com.socialnmobile.colornote.dialog.DialogFactory;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;
import android.text.ClipboardManager;
import com.socialnmobile.colornote.ColorNote;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.view.View$OnCreateContextMenuListener;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo;
import android.app.Activity;
import android.widget.TextView$OnEditorActionListener;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;
import android.widget.ListAdapter;
import java.util.List;
import android.content.Context;
import android.widget.AdapterView$OnItemClickListener;
import android.view.View$OnClickListener;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.socialnmobile.colornote.view.DragDropListView;
import android.widget.ListView;
import android.view.View;

public final class nf implements Runnable
{
    final /* synthetic */ ListEditor a;
    private final /* synthetic */ String b;
    
    public nf(final ListEditor a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        final ArrayList b = yf.b(this.b);
        ListEditor.a(this.a).clear();
        ListEditor.a(this.a).addAll(b);
        this.a.aq();
    }
}
