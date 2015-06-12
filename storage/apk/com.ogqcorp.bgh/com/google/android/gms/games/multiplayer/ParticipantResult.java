// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.games.internal.a.a;
import com.google.android.gms.internal.gz;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ParticipantResult implements SafeParcelable
{
    public static final e CREATOR;
    private final int a;
    private final String b;
    private final int c;
    private final int d;
    
    static {
        CREATOR = new e();
    }
    
    public ParticipantResult(final int a, final String s, final int c, final int d) {
        this.a = a;
        this.b = gz.a(s);
        gz.a(com.google.android.gms.games.internal.a.a.a(c));
        this.c = c;
        this.d = d;
    }
    
    public ParticipantResult(final String s, final int n, final int n2) {
        this(1, s, n, n2);
    }
    
    public int a() {
        return this.a;
    }
    
    public String b() {
        return this.b;
    }
    
    public int c() {
        return this.c;
    }
    
    public int d() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        e.a(this, parcel, n);
    }
}
