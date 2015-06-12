import android.widget.AbsListView;
import android.widget.AbsListView$OnScrollListener;

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
import android.database.Cursor;
import java.util.ArrayList;
import android.view.animation.Animation$AnimationListener;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.util.AttributeSet;
import android.content.Context;
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

public final class abc implements AbsListView$OnScrollListener
{
    final /* synthetic */ ScreenGridList a;
    
    public abc(final ScreenGridList a) {
        this.a = a;
    }
    
    public final void onScroll(final AbsListView absListView, final int n, final int n2, final int n3) {
        if (ScreenGridList.c(this.a) || ScreenGridList.d(this.a)) {
            ScreenGridList.a(this.a, absListView);
        }
    }
    
    public final void onScrollStateChanged(final AbsListView absListView, final int n) {
        if (n == 0) {
            ScreenGridList.a(this.a, absListView);
            ScreenGridList.b(this.a, false);
        }
        else if (n == 2) {
            ScreenGridList.b(this.a, true);
        }
    }
}
