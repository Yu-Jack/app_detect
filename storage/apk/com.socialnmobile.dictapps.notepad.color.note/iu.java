import com.socialnmobile.colornote.sync.errors.UnexpectedLocalAccountException;
import com.socialnmobile.colornote.ColorNote;
import android.content.Context;
import android.os.AsyncTask;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.os.Bundle;
import android.widget.Toast;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleSignupListener;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookSignupListener;
import android.view.View$OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public final class iu extends AsyncTask
{
    ur a;
    uu b;
    int c;
    final /* synthetic */ SyncSignUp d;
    
    public iu(final SyncSignUp d, final ur a) {
        this.d = d;
        this.c = 2;
        this.a = a;
    }
    
    public iu(final SyncSignUp d, final uu b) {
        this.d = d;
        this.c = 3;
        this.b = b;
    }
    
    protected final void onPreExecute() {
        this.d.b(this.d.getString(2131230985));
    }
}
