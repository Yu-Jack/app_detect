// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.MotionEvent;
import android.widget.ViewSwitcher;
import android.view.ViewParent;
import java.util.HashSet;
import java.util.ArrayList;
import android.webkit.WebView;
import com.google.android.gms.a.d;
import android.view.ViewGroup;
import android.os.Build$VERSION;
import android.util.DisplayMetrics;
import android.content.pm.PackageInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Bundle;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.os.RemoteException;
import android.content.res.Configuration;
import android.content.Context;
import android.content.ComponentCallbacks;

public class li extends r implements ag, al, at, bx, cc, cw, ea, lh
{
    private final bb a;
    private final lk b;
    private final lm c;
    private final a d;
    private boolean e;
    private final ComponentCallbacks f;
    
    public li(final Context context, final ak ak, final String s, final bb a, final dx dx) {
        this.f = (ComponentCallbacks)new ComponentCallbacks() {
            public void onConfigurationChanged(final Configuration configuration) {
                if (li.this.b != null && li.this.b.i != null && li.this.b.i.b != null) {
                    li.this.b.i.b.a();
                }
            }
            
            public void onLowMemory() {
            }
        };
        this.b = new lk(context, ak, s, dx);
        this.a = a;
        this.c = new lm(this);
        this.d = new a();
        en.c("Use AdRequest.Builder.addTestDevice(\"" + em.a(context) + "\") to get test ads on this device.");
        eg.b(context);
        this.s();
    }
    
    private void A() {
        if (this.b.i != null) {
            this.b.i.b.destroy();
            this.b.i = null;
        }
    }
    
    private void a(final int i) {
        en.e("Failed to load ad: " + i);
        if (this.b.f == null) {
            return;
        }
        try {
            this.b.f.a(i);
        }
        catch (RemoteException ex) {
            en.c("Could not call AdListener.onAdFailedToLoad().", (Throwable)ex);
        }
    }
    
    private void a(final View view) {
        this.b.a.addView(view, new ViewGroup$LayoutParams(-2, -2));
    }
    
    private void a(final boolean b) {
        if (this.b.i == null) {
            en.e("Ad state was null when trying to ping impression URLs.");
        }
        else {
            en.a("Pinging Impression URLs.");
            this.b.j.a();
            if (this.b.i.e != null) {
                eg.a(this.b.c, this.b.e.b, this.b.i.e);
            }
            if (this.b.i.o != null && this.b.i.o.d != null) {
                az.a(this.b.c, this.b.e.b, this.b.i, this.b.b, b, this.b.i.o.d);
            }
            if (this.b.i.l != null && this.b.i.l.e != null) {
                az.a(this.b.c, this.b.e.b, this.b.i, this.b.b, b, this.b.i.l.e);
            }
        }
    }
    
    private boolean b(final du p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: getfield        com/google/android/gms/internal/du.k:Z
        //     4: ifeq            196
        //     7: aload_1        
        //     8: getfield        com/google/android/gms/internal/du.m:Lcom/google/android/gms/internal/be;
        //    11: invokeinterface com/google/android/gms/internal/be.a:()Lcom/google/android/gms/a/a;
        //    16: invokestatic    com/google/android/gms/a/d.a:(Lcom/google/android/gms/a/a;)Ljava/lang/Object;
        //    19: checkcast       Landroid/view/View;
        //    22: astore          5
        //    24: aload_0        
        //    25: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //    28: getfield        com/google/android/gms/internal/lk.a:Lcom/google/android/gms/internal/lj;
        //    31: invokevirtual   com/google/android/gms/internal/lj.getNextView:()Landroid/view/View;
        //    34: astore          6
        //    36: aload           6
        //    38: ifnull          53
        //    41: aload_0        
        //    42: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //    45: getfield        com/google/android/gms/internal/lk.a:Lcom/google/android/gms/internal/lj;
        //    48: aload           6
        //    50: invokevirtual   com/google/android/gms/internal/lj.removeView:(Landroid/view/View;)V
        //    53: aload_0        
        //    54: aload           5
        //    56: invokespecial   com/google/android/gms/internal/li.a:(Landroid/view/View;)V
        //    59: aload_0        
        //    60: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //    63: getfield        com/google/android/gms/internal/lk.a:Lcom/google/android/gms/internal/lj;
        //    66: invokevirtual   com/google/android/gms/internal/lj.getChildCount:()I
        //    69: iconst_1       
        //    70: if_icmple       83
        //    73: aload_0        
        //    74: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //    77: getfield        com/google/android/gms/internal/lk.a:Lcom/google/android/gms/internal/lj;
        //    80: invokevirtual   com/google/android/gms/internal/lj.showNext:()V
        //    83: aload_0        
        //    84: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //    87: getfield        com/google/android/gms/internal/lk.i:Lcom/google/android/gms/internal/du;
        //    90: ifnull          160
        //    93: aload_0        
        //    94: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //    97: getfield        com/google/android/gms/internal/lk.a:Lcom/google/android/gms/internal/lj;
        //   100: invokevirtual   com/google/android/gms/internal/lj.getNextView:()Landroid/view/View;
        //   103: astore_2       
        //   104: aload_2        
        //   105: instanceof      Lcom/google/android/gms/internal/ep;
        //   108: ifeq            269
        //   111: aload_2        
        //   112: checkcast       Lcom/google/android/gms/internal/ep;
        //   115: aload_0        
        //   116: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //   119: getfield        com/google/android/gms/internal/lk.c:Landroid/content/Context;
        //   122: aload_0        
        //   123: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //   126: getfield        com/google/android/gms/internal/lk.h:Lcom/google/android/gms/internal/ak;
        //   129: invokevirtual   com/google/android/gms/internal/ep.a:(Landroid/content/Context;Lcom/google/android/gms/internal/ak;)V
        //   132: aload_0        
        //   133: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //   136: getfield        com/google/android/gms/internal/lk.i:Lcom/google/android/gms/internal/du;
        //   139: getfield        com/google/android/gms/internal/du.m:Lcom/google/android/gms/internal/be;
        //   142: ifnull          160
        //   145: aload_0        
        //   146: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //   149: getfield        com/google/android/gms/internal/lk.i:Lcom/google/android/gms/internal/du;
        //   152: getfield        com/google/android/gms/internal/du.m:Lcom/google/android/gms/internal/be;
        //   155: invokeinterface com/google/android/gms/internal/be.c:()V
        //   160: aload_0        
        //   161: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //   164: getfield        com/google/android/gms/internal/lk.a:Lcom/google/android/gms/internal/lj;
        //   167: iconst_0       
        //   168: invokevirtual   com/google/android/gms/internal/lj.setVisibility:(I)V
        //   171: iconst_1       
        //   172: ireturn        
        //   173: astore          4
        //   175: ldc             "Could not get View from mediation adapter."
        //   177: aload           4
        //   179: invokestatic    com/google/android/gms/internal/en.c:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   182: iconst_0       
        //   183: ireturn        
        //   184: astore          7
        //   186: ldc_w           "Could not add mediation view to view hierarchy."
        //   189: aload           7
        //   191: invokestatic    com/google/android/gms/internal/en.c:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   194: iconst_0       
        //   195: ireturn        
        //   196: aload_1        
        //   197: getfield        com/google/android/gms/internal/du.r:Lcom/google/android/gms/internal/ak;
        //   200: ifnull          59
        //   203: aload_1        
        //   204: getfield        com/google/android/gms/internal/du.b:Lcom/google/android/gms/internal/ep;
        //   207: aload_1        
        //   208: getfield        com/google/android/gms/internal/du.r:Lcom/google/android/gms/internal/ak;
        //   211: invokevirtual   com/google/android/gms/internal/ep.a:(Lcom/google/android/gms/internal/ak;)V
        //   214: aload_0        
        //   215: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //   218: getfield        com/google/android/gms/internal/lk.a:Lcom/google/android/gms/internal/lj;
        //   221: invokevirtual   com/google/android/gms/internal/lj.removeAllViews:()V
        //   224: aload_0        
        //   225: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //   228: getfield        com/google/android/gms/internal/lk.a:Lcom/google/android/gms/internal/lj;
        //   231: aload_1        
        //   232: getfield        com/google/android/gms/internal/du.r:Lcom/google/android/gms/internal/ak;
        //   235: getfield        com/google/android/gms/internal/ak.g:I
        //   238: invokevirtual   com/google/android/gms/internal/lj.setMinimumWidth:(I)V
        //   241: aload_0        
        //   242: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //   245: getfield        com/google/android/gms/internal/lk.a:Lcom/google/android/gms/internal/lj;
        //   248: aload_1        
        //   249: getfield        com/google/android/gms/internal/du.r:Lcom/google/android/gms/internal/ak;
        //   252: getfield        com/google/android/gms/internal/ak.d:I
        //   255: invokevirtual   com/google/android/gms/internal/lj.setMinimumHeight:(I)V
        //   258: aload_0        
        //   259: aload_1        
        //   260: getfield        com/google/android/gms/internal/du.b:Lcom/google/android/gms/internal/ep;
        //   263: invokespecial   com/google/android/gms/internal/li.a:(Landroid/view/View;)V
        //   266: goto            59
        //   269: aload_2        
        //   270: ifnull          132
        //   273: aload_0        
        //   274: getfield        com/google/android/gms/internal/li.b:Lcom/google/android/gms/internal/lk;
        //   277: getfield        com/google/android/gms/internal/lk.a:Lcom/google/android/gms/internal/lj;
        //   280: aload_2        
        //   281: invokevirtual   com/google/android/gms/internal/lj.removeView:(Landroid/view/View;)V
        //   284: goto            132
        //   287: astore_3       
        //   288: ldc_w           "Could not destroy previous mediation adapter."
        //   291: invokestatic    com/google/android/gms/internal/en.e:(Ljava/lang/String;)V
        //   294: goto            160
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  7      24     173    184    Landroid/os/RemoteException;
        //  53     59     184    196    Ljava/lang/Throwable;
        //  145    160    287    297    Landroid/os/RemoteException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 127, Size: 127
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:114)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private dj c(final ah ah) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo;
        int[] array;
        int n;
        int n2;
        DisplayMetrics displayMetrics;
        int width;
        int height;
        int n3;
        Bundle bundle;
        String b;
        Label_0181_Outer:Label_0241_Outer:
        while (true) {
            applicationInfo = this.b.c.getApplicationInfo();
            while (true) {
                Label_0343: {
                    while (true) {
                        while (true) {
                            try {
                                packageInfo = this.b.c.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
                                if (this.b.h.e || this.b.a.getParent() == null) {
                                    break Label_0343;
                                }
                                array = new int[2];
                                this.b.a.getLocationOnScreen(array);
                                n = array[0];
                                n2 = array[1];
                                displayMetrics = this.b.c.getResources().getDisplayMetrics();
                                width = this.b.a.getWidth();
                                height = this.b.a.getHeight();
                                if (this.b.a.isShown() && n + width > 0 && n2 + height > 0 && n <= displayMetrics.widthPixels && n2 <= displayMetrics.heightPixels) {
                                    n3 = 1;
                                    bundle = new Bundle(5);
                                    bundle.putInt("x", n);
                                    bundle.putInt("y", n2);
                                    bundle.putInt("width", width);
                                    bundle.putInt("height", height);
                                    bundle.putInt("visible", n3);
                                    b = dy.b();
                                    (this.b.j = new dv(b, this.b.b)).a(ah);
                                    return new dj(bundle, ah, this.b.h, this.b.b, applicationInfo, packageInfo, b, dy.a, this.b.e, dy.a(this, b));
                                }
                            }
                            catch (PackageManager$NameNotFoundException ex) {
                                packageInfo = null;
                                continue Label_0181_Outer;
                            }
                            break;
                        }
                        n3 = 0;
                        continue Label_0241_Outer;
                    }
                }
                bundle = null;
                continue;
            }
        }
    }
    
    private void s() {
        if (Build$VERSION.SDK_INT >= 14 && this.b != null && this.b.c != null) {
            this.b.c.registerComponentCallbacks(this.f);
        }
    }
    
    private void t() {
        if (Build$VERSION.SDK_INT >= 14 && this.b != null && this.b.c != null) {
            this.b.c.unregisterComponentCallbacks(this.f);
        }
    }
    
    private void u() {
        en.c("Ad closing.");
        if (this.b.f == null) {
            return;
        }
        try {
            this.b.f.a();
        }
        catch (RemoteException ex) {
            en.c("Could not call AdListener.onAdClosed().", (Throwable)ex);
        }
    }
    
    private void v() {
        en.c("Ad leaving application.");
        if (this.b.f == null) {
            return;
        }
        try {
            this.b.f.b();
        }
        catch (RemoteException ex) {
            en.c("Could not call AdListener.onAdLeftApplication().", (Throwable)ex);
        }
    }
    
    private void w() {
        en.c("Ad opening.");
        if (this.b.f == null) {
            return;
        }
        try {
            this.b.f.d();
        }
        catch (RemoteException ex) {
            en.c("Could not call AdListener.onAdOpened().", (Throwable)ex);
        }
    }
    
    private void x() {
        en.c("Ad finished loading.");
        if (this.b.f == null) {
            return;
        }
        try {
            this.b.f.c();
        }
        catch (RemoteException ex) {
            en.c("Could not call AdListener.onAdLoaded().", (Throwable)ex);
        }
    }
    
    private boolean y() {
        boolean b = true;
        if (!eg.a(this.b.c.getPackageManager(), this.b.c.getPackageName(), "android.permission.INTERNET")) {
            if (!this.b.h.e) {
                em.a((ViewGroup)this.b.a, this.b.h, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            b = false;
        }
        if (!eg.a(this.b.c)) {
            if (!this.b.h.e) {
                em.a((ViewGroup)this.b.a, this.b.h, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            b = false;
        }
        if (!b && !this.b.h.e) {
            this.b.a.setVisibility(0);
        }
        return b;
    }
    
    private void z() {
        if (this.b.i == null) {
            en.e("Ad state was null when trying to ping click URLs.");
        }
        else {
            en.a("Pinging click URLs.");
            this.b.j.b();
            if (this.b.i.c != null) {
                eg.a(this.b.c, this.b.e.b, this.b.i.c);
            }
            if (this.b.i.o != null && this.b.i.o.c != null) {
                az.a(this.b.c, this.b.e.b, this.b.i, this.b.b, false, this.b.i.o.c);
            }
        }
    }
    
    public com.google.android.gms.a.a a() {
        gz.b("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.a.d.a(this.b.a);
    }
    
    public void a(final ak h) {
        gz.b("setAdSize must be called on the main UI thread.");
        this.b.h = h;
        if (this.b.i != null) {
            this.b.i.b.a(h);
        }
        if (this.b.a.getChildCount() > 1) {
            this.b.a.removeView(this.b.a.getNextView());
        }
        this.b.a.setMinimumWidth(h.g);
        this.b.a.setMinimumHeight(h.d);
        this.b.a.requestLayout();
    }
    
    public void a(final cq l) {
        gz.b("setInAppPurchaseListener must be called on the main UI thread.");
        this.b.l = l;
    }
    
    @Override
    public void a(final du i) {
        this.b.g = null;
        if (i.d != -2 && i.d != 3) {
            dy.a(this.b.a());
        }
        if (i.d == -1) {
            return;
        }
        final boolean b = i.a.c != null && i.a.c.getBoolean("_noRefresh", false);
        if (this.b.h.e) {
            eg.a(i.b);
        }
        else if (!b) {
            if (i.h > 0L) {
                this.c.a(i.a, i.h);
            }
            else if (i.o != null && i.o.g > 0L) {
                this.c.a(i.a, i.o.g);
            }
            else if (!i.k && i.d == 2) {
                this.c.a(i.a);
            }
        }
        if (i.d == 3 && i.o != null && i.o.e != null) {
            en.a("Pinging no fill URLs.");
            az.a(this.b.c, this.b.e.b, i, this.b.b, false, i.o.e);
        }
        if (i.d != -2) {
            this.a(i.d);
            return;
        }
        if (!this.b.h.e) {
            if (!this.b(i)) {
                this.a(0);
                return;
            }
            if (this.b.a != null) {
                this.b.a.a.a(i.v);
            }
        }
        if (this.b.i != null && this.b.i.p != null) {
            this.b.i.p.a((at)null);
        }
        if (i.p != null) {
            i.p.a(this);
        }
        this.d.b(this.b.i);
        this.b.i = i;
        if (i.r != null) {
            this.b.h = i.r;
        }
        this.b.j.a(i.t);
        this.b.j.b(i.u);
        this.b.j.a(this.b.h.e);
        this.b.j.b(i.k);
        if (!this.b.h.e) {
            this.a(false);
        }
        if (this.b.m == null) {
            this.b.m = new eb(this.b.b);
        }
        int h;
        int j;
        if (i.o != null) {
            h = i.o.h;
            j = i.o.i;
        }
        else {
            h = 0;
            j = 0;
        }
        this.b.m.a(h, j);
        if (!this.b.h.e && i.b != null && (i.b.f().a() || i.j != null)) {
            final b a = this.d.a(this.b.h, this.b.i);
            if (i.b.f().a() && a != null) {
                a.a(new ll(i.b));
            }
        }
        this.b.i.b.a();
        this.x();
    }
    
    public void a(final n f) {
        gz.b("setAdListener must be called on the main UI thread.");
        this.b.f = f;
    }
    
    public void a(final w k) {
        gz.b("setAppEventListener must be called on the main UI thread.");
        this.b.k = k;
    }
    
    @Override
    public void a(final String s, final String s2) {
        if (this.b.k == null) {
            return;
        }
        try {
            this.b.k.a(s, s2);
        }
        catch (RemoteException ex) {
            en.c("Could not call the AppEventListener.", (Throwable)ex);
        }
    }
    
    @Override
    public void a(final String s, final ArrayList<String> list) {
        if (this.b.l == null) {
            en.e("InAppPurchaseListener is not set");
            return;
        }
        try {
            this.b.l.a(new cm(s, list, this.b.c, this.b.e.b));
        }
        catch (RemoteException ex) {
            en.e("Could not start In-App purchase.");
        }
    }
    
    @Override
    public void a(final HashSet<dv> set) {
        this.b.a(set);
    }
    
    public boolean a(final ah ah) {
        gz.b("loadAd must be called on the main UI thread.");
        if (this.b.g != null) {
            en.e("An ad request is already in progress. Aborting.");
        }
        else {
            if (this.b.h.e && this.b.i != null) {
                en.e("An interstitial is already loading. Aborting.");
                return false;
            }
            if (this.y()) {
                en.c("Starting ad request.");
                this.c.a();
                final dj c = this.c(ah);
                ep ep;
                if (this.b.h.e) {
                    final ep a = com.google.android.gms.internal.ep.a(this.b.c, this.b.h, false, false, this.b.d, this.b.e);
                    a.f().a(this, null, this, this, true, this);
                    ep = a;
                }
                else {
                    final View nextView = this.b.a.getNextView();
                    ep a2;
                    if (nextView instanceof ep) {
                        a2 = (ep)nextView;
                        a2.a(this.b.c, this.b.h);
                    }
                    else {
                        if (nextView != null) {
                            this.b.a.removeView(nextView);
                        }
                        a2 = com.google.android.gms.internal.ep.a(this.b.c, this.b.h, false, false, this.b.d, this.b.e);
                        if (this.b.h.h == null) {
                            this.a((View)a2);
                        }
                    }
                    a2.f().a(this, this, this, this, false, this);
                    ep = a2;
                }
                this.b.g = cv.a(this.b.c, c, this.b.d, ep, this.a, this);
                return true;
            }
        }
        return false;
    }
    
    public void b() {
        gz.b("destroy must be called on the main UI thread.");
        this.t();
        this.b.f = null;
        this.b.k = null;
        this.c.a();
        this.g();
        if (this.b.a != null) {
            this.b.a.removeAllViews();
        }
        if (this.b.i != null && this.b.i.b != null) {
            this.b.i.b.destroy();
        }
        if (this.b.i == null || this.b.i.m == null) {
            return;
        }
        try {
            this.b.i.m.c();
        }
        catch (RemoteException ex) {
            en.e("Could not destroy mediation adapter.");
        }
    }
    
    public void b(final ah ah) {
        final ViewParent parent = this.b.a.getParent();
        if (parent instanceof View && ((View)parent).isShown() && eg.a() && !this.e) {
            this.a(ah);
            return;
        }
        en.c("Ad is not visible. Not refreshing ad.");
        this.c.a(ah);
    }
    
    public boolean c() {
        gz.b("isLoaded must be called on the main UI thread.");
        return this.b.g == null && this.b.i != null;
    }
    
    public void d() {
        gz.b("pause must be called on the main UI thread.");
        if (this.b.i != null) {
            eg.a(this.b.i.b);
        }
        while (true) {
            if (this.b.i == null || this.b.i.m == null) {
                break Label_0067;
            }
            try {
                this.b.i.m.d();
                this.c.b();
            }
            catch (RemoteException ex) {
                en.e("Could not pause mediation adapter.");
                continue;
            }
            break;
        }
    }
    
    public void e() {
        gz.b("resume must be called on the main UI thread.");
        if (this.b.i != null) {
            eg.b(this.b.i.b);
        }
        while (true) {
            if (this.b.i == null || this.b.i.m == null) {
                break Label_0067;
            }
            try {
                this.b.i.m.e();
                this.c.c();
            }
            catch (RemoteException ex) {
                en.e("Could not resume mediation adapter.");
                continue;
            }
            break;
        }
    }
    
    public void f() {
        gz.b("showInterstitial must be called on the main UI thread.");
        if (!this.b.h.e) {
            en.e("Cannot call showInterstitial on a banner ad.");
            return;
        }
        if (this.b.i == null) {
            en.e("The interstitial has not loaded.");
            return;
        }
        if (this.b.i.b.i()) {
            en.e("The interstitial is already showing.");
            return;
        }
        this.b.i.b.a(true);
        if (this.b.i.b.f().a() || this.b.i.j != null) {
            final b a = this.d.a(this.b.h, this.b.i);
            if (this.b.i.b.f().a() && a != null) {
                a.a(new ll(this.b.i.b));
            }
        }
        if (this.b.i.k) {
            try {
                this.b.i.m.b();
                return;
            }
            catch (RemoteException ex) {
                en.c("Could not show interstitial.", (Throwable)ex);
                this.A();
                return;
            }
        }
        bs.a(this.b.c, new ce(this, this, this, this.b.i.b, this.b.i.g, this.b.e, this.b.i.v));
    }
    
    public void g() {
        gz.b("stopLoading must be called on the main UI thread.");
        if (this.b.i != null) {
            this.b.i.b.stopLoading();
            this.b.i = null;
        }
        if (this.b.g != null) {
            this.b.g.f();
        }
    }
    
    public void h() {
        gz.b("recordManualImpression must be called on the main UI thread.");
        if (this.b.i == null) {
            en.e("Ad state was null when trying to ping manual tracking URLs.");
        }
        else {
            en.a("Pinging manual tracking URLs.");
            if (this.b.i.f != null) {
                eg.a(this.b.c, this.b.e.b, this.b.i.f);
            }
        }
    }
    
    public ak i() {
        gz.b("getAdSize must be called on the main UI thread.");
        return this.b.h;
    }
    
    @Override
    public void j() {
        this.r();
    }
    
    @Override
    public void k() {
        this.o();
    }
    
    @Override
    public void l() {
        this.q();
    }
    
    @Override
    public void m() {
        this.p();
    }
    
    @Override
    public void n() {
        if (this.b.i != null) {
            en.e("Mediation adapter " + this.b.i.n + " refreshed, but mediation adapters should never refresh.");
        }
        this.a(true);
        this.x();
    }
    
    @Override
    public void o() {
        this.d.b(this.b.i);
        if (this.b.h.e) {
            this.A();
        }
        this.e = false;
        this.u();
        this.b.j.c();
    }
    
    @Override
    public void p() {
        if (this.b.h.e) {
            this.a(false);
        }
        this.e = true;
        this.w();
    }
    
    @Override
    public void q() {
        this.v();
    }
    
    @Override
    public void r() {
        this.z();
    }
}
