import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

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

public final class nl implements DialogInterface$OnClickListener
{
    final /* synthetic */ ListEditor a;
    
    public nl(final ListEditor a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        ListEditor.f(this.a);
    }
}
