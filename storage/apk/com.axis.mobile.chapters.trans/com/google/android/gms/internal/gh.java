// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.Cast$MessageReceivedCallback;
import android.os.IBinder;
import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import android.os.Looper;
import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.api.a$d;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast$Listener;

public final class gh extends hb
{
    private static final gn BG;
    private static final Object Ca;
    private static final Object Cb;
    private double AP;
    private boolean AQ;
    private final Cast$Listener Ae;
    private ApplicationMetadata BH;
    private final CastDevice BI;
    private final gm BJ;
    private final Map BK;
    private final long BL;
    private String BM;
    private boolean BN;
    private boolean BO;
    private boolean BP;
    private AtomicBoolean BQ;
    private int BR;
    private final AtomicLong BS;
    private String BT;
    private String BU;
    private Bundle BV;
    private Map BW;
    private gh$b BX;
    private a$d BY;
    private a$d BZ;
    private final Handler mHandler;
    
    static {
        BG = new gn("CastClientImpl");
        Ca = new Object();
        Cb = new Object();
    }
    
    public gh(final Context context, final Looper looper, final CastDevice bi, final long bl, final Cast$Listener ae, final GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, final GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        super(context, looper, googleApiClient$ConnectionCallbacks, googleApiClient$OnConnectionFailedListener, (String[])null);
        this.BI = bi;
        this.Ae = ae;
        this.BL = bl;
        this.mHandler = new Handler(looper);
        this.BK = new HashMap();
        this.BP = false;
        this.BR = -1;
        this.BH = null;
        this.BM = null;
        this.BQ = new AtomicBoolean(false);
        this.AP = 0.0;
        this.AQ = false;
        this.BS = new AtomicLong(0L);
        this.BW = new HashMap();
        this.registerConnectionFailedListener(this.BX = new gh$b(this, null));
        this.BJ = new gh$1(this);
    }
    
    private void a(final ge ge) {
        final String ec = ge.ec();
        boolean b;
        if (!gi.a(ec, this.BM)) {
            this.BM = ec;
            b = true;
        }
        else {
            b = false;
        }
        gh.BG.b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", b, this.BN);
        if (this.Ae != null && (b || this.BN)) {
            this.Ae.onApplicationStatusChanged();
        }
        this.BN = false;
    }
    
    private void a(final gj gj) {
        final double eh = gj.eh();
        boolean b;
        if (eh != Double.NaN && eh != this.AP) {
            this.AP = eh;
            b = true;
        }
        else {
            b = false;
        }
        final boolean en = gj.en();
        if (en != this.AQ) {
            this.AQ = en;
            b = true;
        }
        gh.BG.b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", b, this.BO);
        if (this.Ae != null && (b || this.BO)) {
            this.Ae.onVolumeChanged();
        }
        final int eo = gj.eo();
        boolean b2;
        if (eo != this.BR) {
            this.BR = eo;
            b2 = true;
        }
        else {
            b2 = false;
        }
        gh.BG.b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", b2, this.BO);
        if (this.Ae != null && (b2 || this.BO)) {
            this.Ae.O(this.BR);
        }
        this.BO = false;
    }
    
    private void c(final a$d by) {
        synchronized (gh.Ca) {
            if (this.BY != null) {
                this.BY.a(new gh$a(new Status(2002)));
            }
            this.BY = by;
        }
    }
    
    private void e(final a$d bz) {
        synchronized (gh.Cb) {
            if (this.BZ != null) {
                bz.a(new Status(2001));
                return;
            }
            this.BZ = bz;
        }
    }
    
    private void ei() {
        gh.BG.b("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.BK) {
            this.BK.clear();
        }
    }
    
    private void ej() {
        if (!this.BP || this.BQ.get()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }
    
    protected gl G(final IBinder binder) {
        return gl$a.H(binder);
    }
    
    public void a(final double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((gl)this.ft()).a(d, this.AP, this.AQ);
    }
    
    @Override
    protected void a(int i, final IBinder binder, final Bundle bundle) {
        gh.BG.b("in onPostInitHandler; statusCode=%d", i);
        if (i == 0 || i == 1001) {
            this.BP = true;
            this.BN = true;
            this.BO = true;
        }
        else {
            this.BP = false;
        }
        if (i == 1001) {
            (this.BV = new Bundle()).putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            i = 0;
        }
        super.a(i, binder, bundle);
    }
    
    @Override
    protected void a(final hi hi, final hb$e hb$e) {
        final Bundle bundle = new Bundle();
        gh.BG.b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", this.BT, this.BU);
        this.BI.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.BL);
        if (this.BT != null) {
            bundle.putString("last_application_id", this.BT);
            if (this.BU != null) {
                bundle.putString("last_session_id", this.BU);
            }
        }
        hi.a(hb$e, 5089000, this.getContext().getPackageName(), this.BJ.asBinder(), bundle);
    }
    
    public void a(final String s, final Cast$MessageReceivedCallback cast$MessageReceivedCallback) {
        gi.ak(s);
        this.aj(s);
        if (cast$MessageReceivedCallback == null) {
            return;
        }
        synchronized (this.BK) {
            this.BK.put(s, cast$MessageReceivedCallback);
            // monitorexit(this.BK)
            ((gl)this.ft()).an(s);
        }
    }
    
    public void a(final String s, final LaunchOptions launchOptions, final a$d a$d) {
        this.c(a$d);
        ((gl)this.ft()).a(s, launchOptions);
    }
    
    public void a(final String s, final a$d a$d) {
        this.e(a$d);
        ((gl)this.ft()).am(s);
    }
    
    public void a(final String s, final String s2, final a$d a$d) {
        if (TextUtils.isEmpty((CharSequence)s2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (s2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        }
        gi.ak(s);
        this.ej();
        final long incrementAndGet = this.BS.incrementAndGet();
        ((gl)this.ft()).a(s, s2, incrementAndGet);
        this.BW.put(incrementAndGet, a$d);
    }
    
    public void a(final String s, final boolean b, final a$d a$d) {
        this.c(a$d);
        ((gl)this.ft()).e(s, b);
    }
    
    public void aj(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //     4: ifeq            18
        //     7: new             Ljava/lang/IllegalArgumentException;
        //    10: dup            
        //    11: ldc_w           "Channel namespace cannot be null or empty"
        //    14: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    17: athrow         
        //    18: aload_0        
        //    19: getfield        com/google/android/gms/internal/gh.BK:Ljava/util/Map;
        //    22: astore_2       
        //    23: aload_2        
        //    24: monitorenter   
        //    25: aload_0        
        //    26: getfield        com/google/android/gms/internal/gh.BK:Ljava/util/Map;
        //    29: aload_1        
        //    30: invokeinterface java/util/Map.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    35: checkcast       Lcom/google/android/gms/cast/Cast$MessageReceivedCallback;
        //    38: astore          4
        //    40: aload_2        
        //    41: monitorexit    
        //    42: aload           4
        //    44: ifnull          60
        //    47: aload_0        
        //    48: invokevirtual   com/google/android/gms/internal/gh.ft:()Landroid/os/IInterface;
        //    51: checkcast       Lcom/google/android/gms/internal/gl;
        //    54: aload_1        
        //    55: invokeinterface com/google/android/gms/internal/gl.ao:(Ljava/lang/String;)V
        //    60: return         
        //    61: astore_3       
        //    62: aload_2        
        //    63: monitorexit    
        //    64: aload_3        
        //    65: athrow         
        //    66: astore          5
        //    68: getstatic       com/google/android/gms/internal/gh.BG:Lcom/google/android/gms/internal/gn;
        //    71: astore          6
        //    73: iconst_2       
        //    74: anewarray       Ljava/lang/Object;
        //    77: astore          7
        //    79: aload           7
        //    81: iconst_0       
        //    82: aload_1        
        //    83: aastore        
        //    84: aload           7
        //    86: iconst_1       
        //    87: aload           5
        //    89: invokevirtual   java/lang/IllegalStateException.getMessage:()Ljava/lang/String;
        //    92: aastore        
        //    93: aload           6
        //    95: aload           5
        //    97: ldc_w           "Error unregistering namespace (%s): %s"
        //   100: aload           7
        //   102: invokevirtual   com/google/android/gms/internal/gn.a:(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   105: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  25     42     61     66     Any
        //  47     60     66     106    Ljava/lang/IllegalStateException;
        //  62     64     61     66     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0060:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    
    public void b(final String s, final String s2, final a$d a$d) {
        this.c(a$d);
        ((gl)this.ft()).h(s, s2);
    }
    
    @Override
    protected String bu() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }
    
    @Override
    protected String bv() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }
    
    public void d(final a$d a$d) {
        this.e(a$d);
        ((gl)this.ft()).ep();
    }
    
    @Override
    public void disconnect() {
        gh.BG.b("disconnect(); mDisconnecting=%b, isConnected=%b", this.BQ.get(), this.isConnected());
        if (this.BQ.getAndSet(true)) {
            gh.BG.b("mDisconnecting is set, so short-circuiting", new Object[0]);
            return;
        }
        this.ei();
        try {
            if (this.isConnected() || this.isConnecting()) {
                ((gl)this.ft()).disconnect();
            }
        }
        catch (RemoteException ex) {
            gh.BG.a((Throwable)ex, "Error while disconnecting the controller interface: %s", ex.getMessage());
        }
        finally {
            super.disconnect();
        }
    }
    
    @Override
    public Bundle ef() {
        if (this.BV != null) {
            final Bundle bv = this.BV;
            this.BV = null;
            return bv;
        }
        return super.ef();
    }
    
    public void eg() {
        ((gl)this.ft()).eg();
    }
    
    public double eh() {
        this.ej();
        return this.AP;
    }
    
    public ApplicationMetadata getApplicationMetadata() {
        this.ej();
        return this.BH;
    }
    
    public String getApplicationStatus() {
        this.ej();
        return this.BM;
    }
    
    public boolean isMute() {
        this.ej();
        return this.AQ;
    }
    
    public void y(final boolean b) {
        ((gl)this.ft()).a(b, this.AP, this.AQ);
    }
}
