import android.content.pm.PackageManager$NameNotFoundException;
import android.content.Context;

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
import android.content.ServiceConnection;
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
import android.content.Intent;
import com.socialnmobile.colornote.fragment.SideMenuFragment;
import android.support.v4.widget.DrawerLayout;
import android.widget.ImageView;
import com.socialnmobile.colornote.view.MyViewPager;
import android.support.v4.app.Fragment;
import android.view.View;
import android.os.Handler;
import android.view.View$OnClickListener;

public final class hq implements Runnable
{
    final /* synthetic */ Main a;
    
    public hq(final Main a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        Main.b(this.a);
        final to a = jo.a((Context)this.a);
        if (a != null) {
            final Main a2 = this.a;
            final Number g = a.a.g("MARKET");
            while (true) {
                Label_0097: {
                    if (g == null) {
                        break Label_0097;
                    }
                    final Integer value = g.intValue();
                    try {
                        final int versionCode = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionCode;
                        if (value != null && value > versionCode) {
                            this.a.k();
                        }
                        return;
                    }
                    catch (PackageManager$NameNotFoundException ex) {
                        return;
                    }
                }
                final Integer value = null;
                continue;
            }
        }
    }
}
