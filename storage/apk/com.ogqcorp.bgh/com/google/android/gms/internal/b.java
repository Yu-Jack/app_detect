// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import org.json.JSONException;
import java.util.Iterator;
import org.json.JSONArray;
import java.util.Map;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.graphics.Rect;
import org.json.JSONObject;
import android.util.DisplayMetrics;
import java.util.concurrent.TimeUnit;
import java.util.HashSet;
import android.content.BroadcastReceiver;
import android.app.KeyguardManager;
import android.os.PowerManager;
import android.view.WindowManager;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import android.view.ViewTreeObserver$OnScrollChangedListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;

public final class b implements ViewTreeObserver$OnGlobalLayoutListener, ViewTreeObserver$OnScrollChangedListener
{
    private static final long m;
    private final Object a;
    private final WeakReference<du> b;
    private WeakReference<ViewTreeObserver> c;
    private final WeakReference<View> d;
    private final lp e;
    private final Context f;
    private final d g;
    private boolean h;
    private final WindowManager i;
    private final PowerManager j;
    private final KeyguardManager k;
    private c l;
    private long n;
    private boolean o;
    private BroadcastReceiver p;
    private HashSet<lo> q;
    
    static {
        m = TimeUnit.MILLISECONDS.toNanos(100L);
    }
    
    public b(final ak ak, final du du) {
        this(ak, du, du.b.h(), (View)du.b, new f(du.b.getContext(), du.b.h()));
    }
    
    public b(final ak ak, final du referent, final dx dx, final View referent2, final d g) {
        this.a = new Object();
        this.n = Long.MIN_VALUE;
        this.q = new HashSet<lo>();
        this.b = new WeakReference<du>(referent);
        this.d = new WeakReference<View>(referent2);
        this.c = new WeakReference<ViewTreeObserver>(null);
        this.o = true;
        this.e = new lp(Integer.toString(referent.hashCode()), dx, ak.b, referent.j);
        this.g = g;
        this.i = (WindowManager)referent2.getContext().getSystemService("window");
        this.j = (PowerManager)referent2.getContext().getApplicationContext().getSystemService("power");
        this.k = (KeyguardManager)referent2.getContext().getSystemService("keyguard");
        this.f = referent2.getContext().getApplicationContext();
        this.a(g);
        this.g.a(new e() {
            @Override
            public void a() {
                com.google.android.gms.internal.b.this.h = true;
                com.google.android.gms.internal.b.this.b(false);
                com.google.android.gms.internal.b.this.a();
            }
        });
        this.b(this.g);
        en.c("Tracking ad unit: " + this.e.d());
    }
    
    protected int a(final int n, final DisplayMetrics displayMetrics) {
        return (int)(n / displayMetrics.density);
    }
    
    protected JSONObject a(final View view) {
        final int[] array = new int[2];
        final int[] array2 = new int[2];
        view.getLocationOnScreen(array);
        view.getLocationInWindow(array2);
        final JSONObject h = this.h();
        final DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        final Rect rect = new Rect();
        rect.left = array[0];
        rect.top = array[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        final Rect rect2 = new Rect();
        rect2.right = this.i.getDefaultDisplay().getWidth();
        rect2.bottom = this.i.getDefaultDisplay().getHeight();
        final Rect rect3 = new Rect();
        final boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, (Point)null);
        final Rect rect4 = new Rect();
        view.getLocalVisibleRect(rect4);
        h.put("viewBox", (Object)new JSONObject().put("top", this.a(rect2.top, displayMetrics)).put("bottom", this.a(rect2.bottom, displayMetrics)).put("left", this.a(rect2.left, displayMetrics)).put("right", this.a(rect2.right, displayMetrics))).put("adBox", (Object)new JSONObject().put("top", this.a(rect.top, displayMetrics)).put("bottom", this.a(rect.bottom, displayMetrics)).put("left", this.a(rect.left, displayMetrics)).put("right", this.a(rect.right, displayMetrics))).put("globalVisibleBox", (Object)new JSONObject().put("top", this.a(rect3.top, displayMetrics)).put("bottom", this.a(rect3.bottom, displayMetrics)).put("left", this.a(rect3.left, displayMetrics)).put("right", this.a(rect3.right, displayMetrics))).put("localVisibleBox", (Object)new JSONObject().put("top", this.a(rect4.top, displayMetrics)).put("bottom", this.a(rect4.bottom, displayMetrics)).put("left", this.a(rect4.left, displayMetrics)).put("right", this.a(rect4.right, displayMetrics))).put("screenDensity", (double)displayMetrics.density).put("isVisible", this.a(view, globalVisibleRect));
        return h;
    }
    
    protected void a() {
        synchronized (this.a) {
            if (this.p != null) {
                return;
            }
            final IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.p = new BroadcastReceiver() {
                public void onReceive(final Context context, final Intent intent) {
                    com.google.android.gms.internal.b.this.b(false);
                }
            };
            this.f.registerReceiver(this.p, intentFilter);
        }
    }
    
    public void a(final c l) {
        synchronized (this.a) {
            this.l = l;
        }
    }
    
    protected void a(final d d) {
        d.a("http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    }
    
    protected void a(final ep ep, final Map<String, String> map) {
        this.b(false);
    }
    
    public void a(final lo e) {
        this.q.add(e);
    }
    
    protected void a(final JSONObject jsonObject) {
        final JSONArray jsonArray = new JSONArray();
        final JSONObject jsonObject2 = new JSONObject();
        jsonArray.put((Object)jsonObject);
        jsonObject2.put("units", (Object)jsonArray);
        this.g.a("AFMA_updateActiveView", jsonObject2);
    }
    
    protected void a(final boolean b) {
        final Iterator<lo> iterator = this.q.iterator();
        while (iterator.hasNext()) {
            iterator.next().a(this, b);
        }
    }
    
    protected boolean a(final View view, final boolean b) {
        return view.getVisibility() == 0 && b && view.isShown() && this.j.isScreenOn() && !this.k.inKeyguardRestrictedInputMode();
    }
    
    protected void b() {
        synchronized (this.a) {
            if (this.p != null) {
                this.f.unregisterReceiver(this.p);
                this.p = null;
            }
        }
    }
    
    protected void b(final d d) {
        d.a("/updateActiveView", new aj() {
            @Override
            public void a(final ep ep, final Map<String, String> map) {
                com.google.android.gms.internal.b.this.a(ep, map);
            }
        });
        d.a("/activeViewPingSent", new aj() {
            @Override
            public void a(final ep ep, final Map<String, String> map) {
                if (map.containsKey("pingType") && "unloadPing".equals(map.get("pingType"))) {
                    com.google.android.gms.internal.b.this.c(com.google.android.gms.internal.b.this.g);
                    en.c("Unregistered GMSG handlers for: " + com.google.android.gms.internal.b.this.e.d());
                }
            }
        });
        d.a("/visibilityChanged", new aj() {
            @Override
            public void a(final ep ep, final Map<String, String> map) {
                if (!map.containsKey("isVisible")) {
                    return;
                }
                com.google.android.gms.internal.b.this.a(Boolean.valueOf("1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"))));
            }
        });
        d.a("/viewabilityChanged", ai.a);
    }
    
    protected void b(final boolean b) {
        final long nanoTime;
        synchronized (this.a) {
            if (!this.h || !this.o) {
                return;
            }
            nanoTime = System.nanoTime();
            if (b && this.n + b.m > nanoTime) {
                return;
            }
        }
        this.n = nanoTime;
        final du du = this.b.get();
        final View view = this.d.get();
        while (true) {
            Label_0150: {
                if (view == null) {
                    break Label_0150;
                }
                if (du == null) {
                    break Label_0150;
                }
                final int n = 0;
                if (n != 0) {
                    this.c();
                    // monitorexit(o)
                    return;
                }
                while (true) {
                    try {
                        this.a(this.a(view));
                        this.f();
                        this.d();
                        // monitorexit(o)
                        return;
                    }
                    catch (JSONException ex) {
                        en.b("Active view update failed.", (Throwable)ex);
                        continue;
                    }
                    break;
                }
            }
            final int n = 1;
            continue;
        }
    }
    
    public void c() {
        synchronized (this.a) {
            if (!this.o) {
                return;
            }
            this.g();
            this.b();
            try {
                this.a(this.i());
                this.o = false;
                this.d();
                en.c("Untracked ad unit: " + this.e.d());
            }
            catch (JSONException ex) {
                en.b("JSON Failure while processing active view data.", (Throwable)ex);
            }
        }
    }
    
    protected void c(final d d) {
        d.b("/viewabilityChanged");
        d.b("/visibilityChanged");
        d.b("/activeViewPingSent");
        d.b("/updateActiveView");
    }
    
    protected void d() {
        if (this.l != null) {
            this.l.a(this);
        }
    }
    
    public boolean e() {
        synchronized (this.a) {
            return this.o;
        }
    }
    
    protected void f() {
        final View view = this.d.get();
        if (view != null) {
            final ViewTreeObserver viewTreeObserver = this.c.get();
            final ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                this.c = new WeakReference<ViewTreeObserver>(viewTreeObserver2);
                viewTreeObserver2.addOnScrollChangedListener((ViewTreeObserver$OnScrollChangedListener)this);
                viewTreeObserver2.addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)this);
            }
        }
    }
    
    protected void g() {
        final ViewTreeObserver viewTreeObserver = this.c.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener((ViewTreeObserver$OnScrollChangedListener)this);
        viewTreeObserver.removeGlobalOnLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)this);
    }
    
    protected JSONObject h() {
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("afmaVersion", (Object)this.e.b()).put("activeViewJSON", (Object)this.e.c()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", (Object)this.e.a()).put("hashCode", (Object)this.e.d());
        return jsonObject;
    }
    
    protected JSONObject i() {
        final JSONObject h = this.h();
        h.put("doneReasonCode", (Object)"u");
        return h;
    }
    
    public void onGlobalLayout() {
        this.b(false);
    }
    
    public void onScrollChanged() {
        this.b(true);
    }
}
