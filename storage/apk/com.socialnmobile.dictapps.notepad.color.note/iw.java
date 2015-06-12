import android.view.View;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.view.MenuItem;
import android.view.Menu;
import android.content.DialogInterface$OnClickListener;
import com.socialnmobile.colornote.dialog.DialogFactory;
import com.socialnmobile.colornote.dialog.DialogFactory$ConfirmDialogFragment;
import android.app.Dialog;
import android.os.Bundle;
import android.content.Intent;
import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;
import com.socialnmobile.colornote.ColorNote;
import android.widget.Toast;
import android.content.Context;
import android.widget.TextView;

public final class iw implements View$OnClickListener
{
    final /* synthetic */ SyncStatus a;
    
    public iw(final SyncStatus a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        this.a.g();
    }
}
