import android.database.Cursor;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.view.View$OnCreateContextMenuListener;
import android.widget.Toast;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.database.DataSetObserver;
import android.database.ContentObserver;
import java.util.List;
import android.content.SharedPreferences$Editor;
import android.preference.PreferenceManager;
import android.widget.Adapter;
import java.util.ArrayList;
import android.widget.AbsListView;
import android.view.animation.Animation$AnimationListener;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.util.AttributeSet;
import android.widget.AbsListView$OnScrollListener;
import android.view.View$OnTouchListener;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.ListAdapter;
import android.os.Handler;
import android.widget.AdapterView;
import android.widget.TextView;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.view.animation.LayoutAnimationController;
import android.widget.FrameLayout;

public final class abg extends ad
{
    boolean u;
    pg v;
    
    public abg(final Context context, final ScreenGridList list) {
        super(context);
        this.v = list.k;
        this.u = ScreenGridList.e(list);
    }
    
    @Override
    public final Cursor e() {
        if (this.v.c == 0) {
            return kg.a(super.o, this.u, this.v.b, 2, 10000, this.v.e, this.v.f, this.v.g);
        }
        return kg.a(super.o, this.u, this.v.b, 1, this.v.c, this.v.e, this.v.f, this.v.g);
    }
}
