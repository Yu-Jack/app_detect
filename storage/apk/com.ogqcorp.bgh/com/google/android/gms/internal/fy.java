// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.g;
import android.os.RemoteException;
import android.util.Log;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.c;
import com.google.android.gms.internal.fy$com.google.android.gms.internal.gf;
import com.google.android.gms.internal.fy$com.google.android.gms.internal.gb;
import java.util.ArrayList;
import android.os.Looper;
import android.os.Handler;
import android.content.Context;
import com.google.android.gms.common.b;
import android.os.IInterface;

public abstract class fy<T extends IInterface> implements b, gl
{
    public static final String[] d;
    private final Context a;
    final Handler b;
    boolean c;
    private final Looper e;
    private T f;
    private final ArrayList<gb<?>> g;
    private gf h;
    private volatile int i;
    private final String[] j;
    private final gj k;
    
    static {
        d = new String[] { "service_esmobile", "service_googleme" };
    }
    
    protected fy(final Context context, final Looper looper, final c c, final d d, final String... j) {
        this.g = new ArrayList<gb<?>>();
        this.i = 1;
        this.c = false;
        this.a = gz.a(context);
        this.e = gz.a(looper, "Looper must not be null");
        this.k = new gj(context, looper, this);
        this.b = new fz(this, looper);
        this.a(j);
        this.j = j;
        this.a(gz.a(c));
        this.a(gz.a(d));
    }
    
    protected fy(final Context context, final com.google.android.gms.common.c c, final com.google.android.gms.common.d d, final String... array) {
        this(context, context.getMainLooper(), new gc(c), new gh(d), array);
    }
    
    private void a(final int i) {
        final int j = this.i;
        this.i = i;
        if (j != i) {
            if (i == 3) {
                this.d();
            }
            else if (j == 3 && i == 1) {
                this.e();
            }
        }
    }
    
    protected abstract String a();
    
    protected void a(final int p0, final IBinder p1, final Bundle p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/google/android/gms/internal/fy.b:Landroid/os/Handler;
        //     4: aload_0        
        //     5: getfield        com/google/android/gms/internal/fy.b:Landroid/os/Handler;
        //     8: iconst_1       
        //     9: new             new            !!! ERROR
        //    12: dup            
        //    13: aload_0        
        //    14: iload_1        
        //    15: aload_2        
        //    16: aload_3        
        //    17: invokespecial   invokespecial  !!! ERROR
        //    20: invokevirtual   android/os/Handler.obtainMessage:(ILjava/lang/Object;)Landroid/os/Message;
        //    23: invokevirtual   android/os/Handler.sendMessage:(Landroid/os/Message;)Z
        //    26: pop            
        //    27: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalArgumentException: Argument 'typeArguments' must not have any null elements.
        //     at com.strobel.core.VerifyArgument.noNullElementsAndNotEmpty(VerifyArgument.java:145)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedType.makeGenericType(CoreMetadataFactory.java:566)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory.makeParameterizedType(CoreMetadataFactory.java:154)
        //     at com.strobel.assembler.metadata.signatures.Reifier.visitClassTypeSignature(Reifier.java:125)
        //     at com.strobel.assembler.metadata.signatures.ClassTypeSignature.accept(ClassTypeSignature.java:46)
        //     at com.strobel.assembler.metadata.MetadataParser.parseClassSignature(MetadataParser.java:394)
        //     at com.strobel.assembler.metadata.ClassFileReader.populateBaseTypes(ClassFileReader.java:665)
        //     at com.strobel.assembler.metadata.ClassFileReader.readClass(ClassFileReader.java:438)
        //     at com.strobel.assembler.metadata.ClassFileReader.readClass(ClassFileReader.java:366)
        //     at com.strobel.assembler.metadata.MetadataSystem.resolveType(MetadataSystem.java:124)
        //     at com.strobel.decompiler.NoRetryMetadataSystem.resolveType(DecompilerDriver.java:460)
        //     at com.strobel.assembler.metadata.MetadataSystem.resolveCore(MetadataSystem.java:76)
        //     at com.strobel.assembler.metadata.MetadataResolver.resolve(MetadataResolver.java:104)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedType.resolve(CoreMetadataFactory.java:576)
        //     at com.strobel.assembler.metadata.MetadataResolver.resolve(MetadataResolver.java:128)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedType.resolve(CoreMetadataFactory.java:586)
        //     at com.strobel.assembler.metadata.MethodReference.resolve(MethodReference.java:172)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2420)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1029)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:672)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:655)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:365)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:109)
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
    
    public void a(final c c) {
        this.k.a(c);
    }
    
    public void a(final d d) {
        this.k.a(d);
    }
    
    protected abstract void a(final gt p0, final ge p1);
    
    protected void a(final String... array) {
    }
    
    protected abstract T b(final IBinder p0);
    
    protected abstract String b();
    
    protected final void c(final IBinder binder) {
        try {
            this.a(gu.a(binder), new ge(this));
        }
        catch (RemoteException ex) {
            Log.w("GmsClient", "service died");
        }
    }
    
    protected void d() {
    }
    
    protected void e() {
    }
    
    public void f() {
        this.c = true;
        this.a(2);
        final int a = com.google.android.gms.common.g.a(this.a);
        if (a != 0) {
            this.a(1);
            this.b.sendMessage(this.b.obtainMessage(3, (Object)a));
        }
        else {
            if (this.h != null) {
                Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
                this.f = null;
                gm.a(this.a).b(this.a(), this.h);
            }
            this.h = new com.google.android.gms.internal.gf(this);
            if (!gm.a(this.a).a(this.a(), this.h)) {
                Log.e("GmsClient", "unable to connect to service: " + this.a());
                this.b.sendMessage(this.b.obtainMessage(3, (Object)9));
            }
        }
    }
    
    @Override
    public boolean g() {
        return this.i == 3;
    }
    
    public boolean h() {
        return this.i == 2;
    }
    
    public void i() {
        this.c = false;
        synchronized (this.g) {
            for (int size = this.g.size(), i = 0; i < size; ++i) {
                ((com.google.android.gms.internal.gb)this.g.get(i)).d();
            }
            this.g.clear();
            // monitorexit(this.g)
            this.a(1);
            this.f = null;
            if (this.h != null) {
                gm.a(this.a).b(this.a(), this.h);
                this.h = null;
            }
        }
    }
    
    public final Context j() {
        return this.a;
    }
    
    protected final void k() {
        if (!this.g()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }
    
    @Override
    public Bundle l() {
        return null;
    }
    
    protected final T m() {
        this.k();
        return this.f;
    }
    
    @Override
    public boolean n() {
        return this.c;
    }
}
