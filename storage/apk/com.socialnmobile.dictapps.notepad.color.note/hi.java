import android.widget.Toast;
import android.content.Context;
import android.os.AsyncTask;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnClickListener;
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
import android.content.Intent;
import com.socialnmobile.colornote.sync.SyncService;
import android.widget.AdapterView$OnItemClickListener;
import android.app.Dialog;
import android.widget.ListView;
import android.widget.Button;
import android.app.Activity;

public final class hi extends AsyncTask
{
    final /* synthetic */ BackupLocal a;
    
    public hi(final BackupLocal a) {
        this.a = a;
    }
    
    protected final void onPreExecute() {
        this.a.e = true;
        this.a.a();
    }
}
