import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.view.MenuItem;
import android.view.Menu;
import com.socialnmobile.colornote.dialog.DialogFactory;
import com.socialnmobile.colornote.dialog.DialogFactory$ConfirmDialogFragment;
import android.app.Dialog;
import android.view.View$OnClickListener;
import android.os.Bundle;
import android.content.Intent;
import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;
import com.socialnmobile.colornote.ColorNote;
import android.widget.Toast;
import android.content.Context;
import android.widget.TextView;

public final class iy implements DialogInterface$OnClickListener
{
    final /* synthetic */ SyncStatus a;
    
    public iy(final SyncStatus a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.h();
    }
}
