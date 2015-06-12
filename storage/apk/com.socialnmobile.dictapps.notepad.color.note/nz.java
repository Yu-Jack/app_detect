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
import java.util.ArrayList;
import android.widget.TextView;
import com.socialnmobile.colornote.view.DragDropListView;
import android.widget.ListView;
import android.view.View;

final class nz implements Runnable
{
    final /* synthetic */ ny a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    
    nz(final ny a, final int b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        if (-1 + this.b < ListEditor.a(this.a.a).size()) {
            ListEditor.a(this.a.a).add(-1 + this.c, ListEditor.a(this.a.a).remove(-1 + this.b));
        }
        this.a.a.aq();
        ListEditor.d(this.a.a).invalidateViews();
    }
}
