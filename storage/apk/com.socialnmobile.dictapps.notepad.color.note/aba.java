import android.widget.AbsListView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;

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
import android.widget.AbsListView$OnScrollListener;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.ListAdapter;
import android.os.Handler;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.GridView;
import android.widget.ListView;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.view.animation.LayoutAnimationController;
import android.widget.FrameLayout;

public final class aba implements View$OnTouchListener
{
    final /* synthetic */ ScreenGridList a;
    
    public aba(final ScreenGridList a) {
        this.a = a;
    }
    
    public final boolean onTouch(final View view, final MotionEvent motionEvent) {
        final int n = (int)motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0: {
                ScreenGridList.a(this.a, n);
                ScreenGridList.a(this.a, false);
                this.a.l = null;
                return false;
            }
            case 2: {
                if (Math.abs(n - ScreenGridList.a(this.a)) > ScreenGridList.b(this.a) || ScreenGridList.c(this.a)) {
                    ScreenGridList.a(this.a, true);
                    ScreenGridList.a(this.a, (AbsListView)view);
                    return false;
                }
                break;
            }
            case 1: {
                ScreenGridList.a(this.a, false);
                return false;
            }
        }
        return false;
    }
}
