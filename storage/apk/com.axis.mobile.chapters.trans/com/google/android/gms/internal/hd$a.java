// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.ComponentName;
import android.os.IBinder;
import java.util.HashSet;

final class hd$a
{
    private final HashSet GA;
    private boolean GB;
    private IBinder GC;
    private ComponentName GD;
    final /* synthetic */ hd GE;
    private final String Gy;
    private final hd$a$a Gz;
    private int mState;
    
    public hd$a(final hd ge, final String gy) {
        this.GE = ge;
        this.Gy = gy;
        this.Gz = new hd$a$a(this);
        this.GA = new HashSet();
        this.mState = 0;
    }
    
    public void B(final boolean gb) {
        this.GB = gb;
    }
    
    public void a(final hb$f e) {
        this.GA.add(e);
    }
    
    public void b(final hb$f o) {
        this.GA.remove(o);
    }
    
    public boolean c(final hb$f o) {
        return this.GA.contains(o);
    }
    
    public hd$a$a fx() {
        return this.Gz;
    }
    
    public String fy() {
        return this.Gy;
    }
    
    public boolean fz() {
        return this.GA.isEmpty();
    }
    
    public IBinder getBinder() {
        return this.GC;
    }
    
    public ComponentName getComponentName() {
        return this.GD;
    }
    
    public int getState() {
        return this.mState;
    }
    
    public boolean isBound() {
        return this.GB;
    }
}
