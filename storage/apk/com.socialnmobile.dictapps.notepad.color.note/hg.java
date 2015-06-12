import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.content.DialogInterface$OnCancelListener;
import android.os.Build$VERSION;
import android.view.Menu;
import android.widget.AdapterView$AdapterContextMenuInfo;
import android.widget.AdapterView;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.View;
import android.view.ContextMenu;
import android.view.View$OnCreateContextMenuListener;
import android.view.View$OnClickListener;
import android.os.Bundle;
import java.io.File;
import android.net.Uri;
import java.util.ArrayList;
import android.view.MenuItem;
import android.widget.ListAdapter;
import java.util.List;
import com.socialnmobile.colornote.ColorNote;
import android.content.ServiceConnection;
import android.content.Context;
import android.content.Intent;
import com.socialnmobile.colornote.sync.SyncService;
import android.widget.AdapterView$OnItemClickListener;
import android.app.Dialog;
import android.widget.ListView;
import android.widget.Button;
import android.app.Activity;

public final class hg implements DialogInterface$OnClickListener
{
    final /* synthetic */ BackupLocal a;
    
    public hg(final BackupLocal a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        int i = 0;
        final jr c = this.a.c;
        final String e = this.a.d.e;
        final String f = this.a.d.f;
        jr.a(e, f);
        for (String[] a = c.a(false); i < a.length; ++i) {
            jr.a(a[i], f);
        }
        this.a.c();
    }
}
