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
import android.content.Context;
import android.content.Intent;
import com.socialnmobile.colornote.fragment.SideMenuFragment;
import android.support.v4.widget.DrawerLayout;
import android.widget.ImageView;
import com.socialnmobile.colornote.view.MyViewPager;
import android.support.v4.app.Fragment;
import android.view.View;
import android.os.Handler;
import android.view.View$OnClickListener;

public class Main extends ThemeFragmentActivity implements aac, n, py, rb, zr
{
    boolean A;
    boolean B;
    View$OnClickListener C;
    Runnable D;
    ye E;
    protected Handler n;
    boolean o;
    public View p;
    public Fragment q;
    public MyViewPager r;
    ImageView s;
    DrawerLayout t;
    View u;
    public abi v;
    boolean w;
    public boolean x;
    public boolean y;
    public SideMenuFragment z;
    
    public Main() {
        this.n = new Handler();
        this.o = false;
        this.w = false;
        this.x = false;
        this.A = false;
        this.B = false;
        this.C = (View$OnClickListener)new hm(this);
        this.D = new ho(this);
        this.E = new hp(this);
    }
    
    private static int b(final Intent intent) {
        if (intent.getAction() != null) {
            if (intent.getAction().equals("note.socialnmobile.intent.action.VIEW_CALENDAR") || intent.getAction().equals("note.socialnmobile.intent.action.VIEW_TODAY_CALENDAR")) {
                return 1;
            }
            if (intent.getAction().equals("note.socialnmobile.intent.action.VIEW_NOTES")) {
                return 0;
            }
            if (intent.getAction().equals("note.socialnmobile.intent.action.LAUNCH_APP")) {
                return 0;
            }
        }
        return -1;
    }
    
    private void c(final Fragment q) {
        final Fragment n = this.n();
        if (n != null) {
            n.b(false);
        }
        final u a = super.b.a();
        a.a(2131623937, q, "sub");
        a.a(4099);
        a.a();
        a.b();
        this.q = q;
        this.m();
        super.b.b();
    }
    
    private void d(final int n) {
        DialogFragment a = null;
        switch (n) {
            case 20: {
                a = DialogFactory.a((DialogInterface$OnClickListener)new hs(this));
                break;
            }
            case 1: {
                final TopBarSubMenuInfo topBarSubMenuInfo = new TopBarSubMenuInfo((Context)this, ((Context)this).getString(2131230778), new ht(this));
                topBarSubMenuInfo.a(2130837634, 2131230792, "COLORTABLE/DEFAULT");
                topBarSubMenuInfo.a(2130837635, 2131230794, "COLORTABLE/SOFT");
                topBarSubMenuInfo.a(2130837633, 2131230793, "COLORTABLE/DARK");
                a = new TopBarSubMenuInfo$SubMenuDialogFragment(topBarSubMenuInfo);
                break;
            }
        }
        a.a(super.b, "dialog");
    }
    
    private void m() {
        gw.a(this.getResources(), this.s, 2130837615);
    }
    
    private Fragment n() {
        return ((zq)this.r.a()).c;
    }
    
    private Fragment o() {
        if (this.q != null) {
            return this.q;
        }
        return this.n();
    }
    
    private boolean p() {
        return this.u.getVisibility() == 0;
    }
    
    @Override
    public final void a() {
        if (super.b.d() == 0) {
            this.q = null;
            this.m();
            final Fragment n = this.n();
            n.b(true);
            if (n instanceof pr) {
                ((pr)n).L();
            }
        }
        this.z.I();
    }
    
    @Override
    public final void a(final int n) {
        switch (n) {
            default: {}
            case 13: {
                this.startActivity(gw.e((Context)this));
            }
            case 12: {
                this.startActivity(new Intent((Context)this, (Class)Settings.class));
            }
            case 11: {
                this.d(1);
            }
            case 5: {
                this.onSearchRequested();
                this.t.a();
            }
            case 3: {
                this.g();
                this.c(new RecycleBinFragment());
                this.t.a();
            }
            case 4: {
                this.g();
                this.c(new ArchiveFragment());
                this.t.a();
            }
            case 2: {
                this.g();
                this.r.setCurrentItem(1, false);
                this.t.a();
            }
            case 1: {
                this.g();
                this.r.setCurrentItem(0, false);
                this.t.a();
            }
        }
    }
    
    final void a(final long n) {
        this.n.postDelayed(this.D, n);
    }
    
    public final void a(final Intent intent) {
        if (intent.getAction() != null) {
            if (intent.getAction().equals("note.socialnmobile.intent.action.SEARCH")) {
                this.onSearchRequested();
                return;
            }
            if (intent.getAction().equals("android.intent.action.SEARCH")) {
                this.c(SearchFragment.a(intent.getStringExtra("query")));
                return;
            }
            final int b = b(intent);
            if (b != -1) {
                if (b == 0) {
                    if (this.r.b() != 0) {
                        this.r.setCurrentItem(0, false);
                    }
                }
                else if (b == 1 && this.r.b() != 1) {
                    this.r.setCurrentItem(1, false);
                }
            }
        }
    }
    
    @Override
    public final void a(final rc rc) {
        this.v.a(rc);
    }
    
    public final void a(final boolean b, final boolean b2, final String s) {
        if (!this.o) {
            if (b) {
                ColorNote.a(this.getApplicationContext(), "SYNC", "MANUAL_SYNC", "Source", "Main", "FROM", s);
            }
            if (!this.bindService(new Intent((Context)this, (Class)SyncService.class), (ServiceConnection)new Main$SyncListener(this, b2), 1)) {
                ColorNote.a("NoteList bind SyncService FAILED");
            }
        }
    }
    
    @Override
    public final boolean a(final Fragment fragment) {
        if (this.q == null) {
            if (this.n() != fragment) {
                return false;
            }
        }
        else if (this.q != fragment) {
            return false;
        }
        return true;
    }
    
    @Override
    public final void b(final int n) {
        if (n == 2) {
            this.closeOptionsMenu();
        }
    }
    
    @Override
    public final void b(final Fragment fragment) {
        if (fragment instanceof pr) {
            this.r.a();
            final pr pr = (pr)fragment;
            pr.K();
            this.z.I();
            if (this.q == null) {
                pr.L();
            }
        }
    }
    
    @Override
    public final void c(final int index) {
        if (this.B && index != b(this.getIntent())) {
            this.B = false;
        }
        final Fragment n = this.n();
        if (n != null && ((zq)this.r.a()).b.indexOf(n) != index) {
            n.b(false);
        }
        this.r.a();
        final ArrayList b = ((zq)this.r.a()).b;
        if (index < b.size()) {
            final Fragment fragment = b.get(index);
            if (fragment instanceof pr) {
                final pr pr = (pr)fragment;
                pr.K();
                if (this.q == null) {
                    pr.L();
                }
            }
        }
    }
    
    @Override
    public final abi e() {
        return this.v;
    }
    
    public final int f() {
        return ((pr)this.o()).I();
    }
    
    public final void g() {
        if (super.b.d() > 0) {
            super.b.c();
        }
    }
    
    final void h() {
        this.n.removeCallbacks(this.D);
        this.p.setVisibility(0);
        this.p.startAnimation(AnimationUtils.loadAnimation((Context)this.getApplication(), 17432576));
    }
    
    public final void i() {
        this.t.b();
    }
    
    public final void j() {
        this.t.a();
    }
    
    public final void k() {
        if (!gw.d((Context)this)) {
            ColorNote.a(this.getApplicationContext(), "INSTALL", "UPDATE_NOT_AVAILABLE");
            return;
        }
        ColorNote.a(this.getApplicationContext(), "INSTALL", "UPDATE_AVAILABLE", "METHOD", "BANNER");
        final View viewById = this.findViewById(2131623949);
        final View viewById2 = this.findViewById(2131623951);
        final Animation loadAnimation = AnimationUtils.loadAnimation((Context)this, 2130968580);
        loadAnimation.setDuration(1000L);
        loadAnimation.setAnimationListener((Animation$AnimationListener)new hu(this, viewById));
        viewById.setVisibility(0);
        viewById2.setOnClickListener((View$OnClickListener)new hv(this, viewById, loadAnimation));
        final Animation loadAnimation2 = AnimationUtils.loadAnimation((Context)this, 2130968581);
        loadAnimation2.setDuration(1000L);
        viewById.startAnimation(loadAnimation2);
        final hn hn = new hn(this, viewById, loadAnimation);
        viewById.setOnClickListener((View$OnClickListener)hn);
        this.findViewById(2131623950).setOnClickListener((View$OnClickListener)hn);
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 1 && n2 == -1) {
            this.a(false, true, "AUTH");
        }
    }
    
    @Override
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final Fragment o = this.o();
        if (o != null) {
            final ra ae = ((pr)o).ae();
            ae.a((Context)this);
            this.a(ae.ab());
        }
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903042);
        this.p = this.findViewById(2131623945);
        this.r = (MyViewPager)this.findViewById(2131623942);
        this.s = (ImageView)this.findViewById(2131624085);
        (this.t = (DrawerLayout)this.findViewById(2131623940)).setDrawerShadow(2130837558, 3);
        this.u = this.findViewById(2131623943);
        this.v = new abi(this.findViewById(2131623936));
        final ViewGroup$LayoutParams layoutParams = this.u.getLayoutParams();
        layoutParams.width = Math.min(((Context)this).getResources().getDisplayMetrics().widthPixels - gw.c((Context)this, 56), gw.c((Context)this, 304));
        this.u.setLayoutParams(layoutParams);
        if (jo.a((Context)this, "PREF_TITLE_NOTI_NUMBER") <= 0) {
            this.v.c.setText((CharSequence)"N");
        }
        this.v.h = this.C;
        this.a(1, this.E);
        this.setDefaultKeyMode(2);
        ColorNote.f();
        super.b.a(this);
        this.z = (SideMenuFragment)super.b.a(2131623944);
        if (this.z == null) {
            this.z = new SideMenuFragment();
            final u a = super.b.a();
            a.b(2131623944, this.z);
            a.a(0);
            a.b();
        }
        this.q = super.b.a(2131623937);
        if (this.q != null) {
            this.m();
        }
        final Intent intent = this.getIntent();
        if (intent.getData() == null) {
            intent.setData(kf.a);
        }
        this.r.setAdapter(new hw(this, super.b, this));
        this.r.setPageMargin(this.getResources().getDimensionPixelSize(2131361809));
        this.r.setOnPageChangeListener(this);
        if (jp.f((Context)this) == 1) {
            this.r.setCurrentItem(1, false);
        }
        else {
            this.r.setCurrentItem(0, false);
        }
        this.a(intent);
        if (b(intent) != -1) {
            this.B = true;
        }
        this.n.postDelayed((Runnable)new hq(this), 50L);
    }
    
    protected void onDestroy() {
        if (rt.a((Context)this)) {
            if (!jp.n((Context)this)) {
                rt.b((Context)this);
            }
            else if (rt.d((Context)this)) {
                AutoSyncService.b(this.getApplicationContext());
            }
        }
        super.onDestroy();
    }
    
    @Override
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            if (this.p()) {
                return this.A = true;
            }
            if (this.q == null) {
                if (((pr)this.n()).M() || (this.r.b() != jp.f((Context)this) && !this.B)) {
                    return this.A = true;
                }
                if (this.x) {
                    return this.A = true;
                }
            }
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (n == 4 && this.A) {
            this.A = false;
            if (this.p()) {
                this.t.a();
            }
            else if (this.q == null) {
                final pr pr = (pr)this.n();
                if (pr.M()) {
                    pr.N();
                }
                else if (this.r.b() != jp.f((Context)this)) {
                    if (jp.f((Context)this) == 1) {
                        this.r.setCurrentItem(1, true);
                    }
                    else {
                        this.r.setCurrentItem(0, true);
                    }
                }
                else if (this.x) {
                    this.x = false;
                    int n2;
                    if (((Context)this).getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + ((Context)this).getPackageName())), 65536).size() > 0) {
                        n2 = 1;
                    }
                    else {
                        n2 = 0;
                    }
                    int n3;
                    if (n2 == 0) {
                        n3 = 0;
                    }
                    else {
                        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)this);
                        if (!defaultSharedPreferences.contains("RATING_INSTALL_TIME")) {
                            final SharedPreferences$Editor edit = defaultSharedPreferences.edit();
                            edit.putLong("RATING_INSTALL_TIME", System.currentTimeMillis());
                            edit.commit();
                            n3 = 0;
                        }
                        else {
                            final long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - defaultSharedPreferences.getLong("RATING_INSTALL_TIME", currentTimeMillis) < 691200000L) {
                                n3 = 0;
                            }
                            else {
                                final long long1 = defaultSharedPreferences.getLong("RATING_TIME", 0L);
                                if (long1 > currentTimeMillis || long1 == 1L) {
                                    n3 = 0;
                                }
                                else {
                                    final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this);
                                    alertDialog$Builder.setTitle(2131231073);
                                    alertDialog$Builder.setMessage(2131231074);
                                    alertDialog$Builder.setPositiveButton(2131231075, (DialogInterface$OnClickListener)new ls((Context)this, defaultSharedPreferences));
                                    alertDialog$Builder.setNegativeButton(2131231076, (DialogInterface$OnClickListener)new lt((Context)this, defaultSharedPreferences));
                                    alertDialog$Builder.setOnCancelListener((DialogInterface$OnCancelListener)new lu((Context)this, defaultSharedPreferences));
                                    alertDialog$Builder.create().show();
                                    n3 = 1;
                                }
                            }
                        }
                    }
                    if (n3 == 0) {
                        this.finish();
                    }
                }
            }
        }
        return super.onKeyUp(n, keyEvent);
    }
    
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        if ("android.intent.action.MAIN".equals(intent.getAction())) {
            return;
        }
        this.n.post((Runnable)new hr(this, intent));
    }
    
    protected void onPause() {
        super.onPause();
        this.y = false;
        if (this.isFinishing()) {
            ColorNote.a(this.getApplicationContext(), "APP", "MAIN_FINISH");
        }
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        this.y = true;
    }
    
    public boolean onSearchRequested() {
        ColorNote.a((Context)this, "LIST", "SEARCH");
        return super.onSearchRequested();
    }
    
    @Override
    protected void onStart() {
        boolean w = true;
        super.onStart();
        if (!this.w) {
            this.w = w;
            int n;
            if (jo.b((Context)this, "APP_INSTALL_TIME_MILLIS") == 0L) {
                jo.a((Context)this, "APP_INSTALL_TIME_MILLIS", System.currentTimeMillis());
                n = (w ? 1 : 0);
            }
            else {
                n = 0;
            }
            if (n != 0) {
                ColorNote.a(this.getApplicationContext(), "INSTALL", "FIRST_LAUNCH");
            }
            final long long1 = PreferenceManager.getDefaultSharedPreferences((Context)this).getLong("RATING_TIME", 0L);
            if (long1 > System.currentTimeMillis() || long1 == 1L) {
                w = false;
            }
            if (w) {
                new hx(this, (byte)0).execute((Object[])new String[0]);
            }
        }
    }
}
