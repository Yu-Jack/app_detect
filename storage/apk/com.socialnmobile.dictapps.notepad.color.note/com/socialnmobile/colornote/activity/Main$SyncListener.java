// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import android.content.DialogInterface$OnCancelListener;
import android.app.AlertDialog$Builder;
import android.preference.PreferenceManager;
import android.net.Uri;
import android.view.KeyEvent;
import com.socialnmobile.colornote.service.AutoSyncService;
import android.view.ViewGroup$LayoutParams;
import android.os.Bundle;
import android.content.res.Configuration;
import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import com.socialnmobile.colornote.sync.SyncService;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.fragment.SearchFragment;
import com.socialnmobile.colornote.fragment.ArchiveFragment;
import com.socialnmobile.colornote.fragment.RecycleBinFragment;
import android.support.v4.app.DialogFragment;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo$SubMenuDialogFragment;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo;
import android.content.DialogInterface$OnClickListener;
import com.socialnmobile.colornote.dialog.DialogFactory;
import com.socialnmobile.colornote.fragment.SideMenuFragment;
import android.support.v4.widget.DrawerLayout;
import android.widget.ImageView;
import com.socialnmobile.colornote.view.MyViewPager;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View$OnClickListener;
import android.os.Handler;
import android.os.IBinder;
import android.content.ComponentName;
import android.text.format.DateUtils;
import android.widget.TextView;
import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion;
import android.content.Intent;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import android.content.Context;
import java.lang.ref.WeakReference;
import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;
import android.content.ServiceConnection;

public class Main$SyncListener implements ServiceConnection, SyncJob$Listener
{
    public WeakReference mActivityReference;
    Context mContext;
    boolean mShowMessage;
    
    Main$SyncListener(final Main referent, final boolean mShowMessage) {
        this.mActivityReference = new WeakReference((T)referent);
        this.mContext = referent.getApplicationContext();
        this.mShowMessage = mShowMessage;
    }
    
    public void onError(final AuthRequired authRequired) {
        final Main main = (Main)this.mActivityReference.get();
        if (main != null) {
            main.startActivityForResult(new Intent(this.mContext, (Class)SyncRelogin.class), 1);
            if (this.mShowMessage) {
                main.p.setVisibility(8);
            }
        }
    }
    
    public void onError(final UnsupportedClientVersion unsupportedClientVersion) {
        final Main main = (Main)this.mActivityReference.get();
        if (main == null) {
            return;
        }
        if (this.mShowMessage) {
            this.showErrorMessage(main);
        }
        Main.a(main);
    }
    
    public void onException(final Exception ex) {
        final Main main = (Main)this.mActivityReference.get();
        if (main != null && this.mShowMessage) {
            this.showErrorMessage(main);
        }
    }
    
    public void onFinalize() {
        gw.b();
        final Main main = (Main)this.mActivityReference.get();
        if (main == null) {
            return;
        }
        main.o = false;
    }
    
    public void onFinished(final Object o) {
        final Main main = (Main)this.mActivityReference.get();
        if (main != null && this.mShowMessage) {
            main.findViewById(2131623946).setVisibility(8);
            final TextView textView = (TextView)main.findViewById(2131623948);
            DateUtils.formatDateTime((Context)main, jp.a((Context)main, "LAST_SYNC_TIME_MILLIS"), 524313);
            textView.setText((CharSequence)((Context)main).getString(2131231059));
            main.a(2500L);
        }
    }
    
    public void onInit() {
        gw.a(this.mContext);
        final Main main = (Main)this.mActivityReference.get();
        if (main != null) {
            main.o = true;
            if (this.mShowMessage) {
                main.h();
                main.findViewById(2131623947).setVisibility(8);
                main.findViewById(2131623946).setVisibility(0);
                ((TextView)main.findViewById(2131623948)).setText(2131231056);
            }
        }
    }
    
    public void onProgress(final int n, final int n2) {
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        ((wc)binder).a().a(this);
        new Handler().post((Runnable)new hy(this));
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
    }
    
    void showErrorMessage(final Main main) {
        main.findViewById(2131623946).setVisibility(8);
        main.findViewById(2131623947).setVisibility(0);
        ((TextView)main.findViewById(2131623948)).setText(gt.a((Context)main));
        main.a(5000L);
    }
}
