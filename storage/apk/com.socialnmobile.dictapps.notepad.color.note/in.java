// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.app.Dialog;
import android.database.Cursor;
import android.net.Uri;
import android.content.Context;
import android.widget.Toast;
import android.content.ContentUris;
import android.os.Bundle;
import android.content.Intent;
import android.content.DialogInterface$OnCancelListener;

public final class in implements rg
{
    final /* synthetic */ SendToNoteByTitle a;
    
    public in(final SendToNoteByTitle a) {
        this.a = a;
    }
    
    @Override
    public final boolean a(final int n, final String s) {
        SendToNoteByTitle.a(this.a, n, this.a.a);
        this.a.finish();
        return true;
    }
}
