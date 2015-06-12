// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import android.content.res.Configuration;
import com.socialnmobile.colornote.dialog.DialogFactory$ConfirmDialogFragment;
import com.socialnmobile.colornote.dialog.DialogFactory$EnterPasswordDialogFragment;
import com.socialnmobile.colornote.dialog.DialogFactory$ColorSelectorDialogFragment;
import android.content.DialogInterface$OnClickListener;
import com.socialnmobile.colornote.dialog.DialogFactory;
import com.socialnmobile.colornote.dialog.DialogFactory$DownloadColorDictDialogFragment;
import android.support.v4.app.DialogFragment;
import android.view.MenuItem;
import android.graphics.drawable.GradientDrawable;
import android.view.View$OnTouchListener;
import android.view.GestureDetector$OnGestureListener;
import android.view.GestureDetector;
import android.view.Menu;
import android.database.DataSetObserver;
import android.database.ContentObserver;
import android.os.Build$VERSION;
import java.util.Map;
import com.socialnmobile.colornote.ColorNote;
import java.util.HashMap;
import android.app.Activity;
import android.widget.Toast;
import com.socialnmobile.colornote.activity.PasswordSetting;
import android.content.Intent;
import com.socialnmobile.colornote.activity.ReminderSettings;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff$Mode;
import android.support.v4.app.FragmentActivity;
import android.content.Context;
import android.content.ContentValues;
import android.os.Parcelable;
import android.os.Bundle;
import android.net.Uri;
import android.view.View$OnClickListener;
import android.content.DialogInterface$OnCancelListener;
import android.view.View;
import android.os.Handler;
import android.database.Cursor;
import android.support.v4.app.Fragment;

public final class mp implements Runnable
{
    final /* synthetic */ AbstractEditorViewer a;
    private final /* synthetic */ int b;
    
    public mp(final AbstractEditorViewer a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        if (this.a.m()) {
            this.a.c(this.b).a(this.a.k(), "dialog");
            return;
        }
        AbstractEditorViewer.a(this.a, this.b);
    }
}
