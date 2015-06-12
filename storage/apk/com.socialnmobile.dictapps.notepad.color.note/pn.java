import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import android.view.Menu;
import android.widget.AdapterView;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import com.socialnmobile.colornote.ColorNote;
import android.content.ContentUris;
import android.widget.AdapterView$AdapterContextMenuInfo;
import android.view.MenuItem;
import android.support.v4.app.FragmentActivity;
import java.util.Iterator;
import android.app.Activity;
import android.widget.ListAdapter;
import android.database.Cursor;
import android.view.View$OnCreateContextMenuListener;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.support.v4.app.DialogFragment;
import com.socialnmobile.colornote.dialog.DialogFactory;
import android.os.Bundle;
import android.net.Uri;
import android.widget.ListView;
import android.os.Handler;
import android.widget.AdapterView$OnItemClickListener;
import android.view.View$OnClickListener;

public final class pn implements DialogInterface$OnClickListener
{
    final /* synthetic */ RecycleBinFragment a;
    
    public pn(final RecycleBinFragment a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        kg.d((Context)this.a.h(), RecycleBinFragment.a(this.a));
    }
}
