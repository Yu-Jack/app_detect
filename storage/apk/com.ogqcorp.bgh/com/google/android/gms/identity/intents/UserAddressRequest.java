// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.identity.intents;

import android.os.Parcel;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UserAddressRequest implements SafeParcelable
{
    public static final Parcelable$Creator<UserAddressRequest> CREATOR;
    List<CountrySpecification> a;
    private final int b;
    
    static {
        CREATOR = (Parcelable$Creator)new a();
    }
    
    UserAddressRequest() {
        this.b = 1;
    }
    
    UserAddressRequest(final int b, final List<CountrySpecification> a) {
        this.b = b;
        this.a = a;
    }
    
    public int a() {
        return this.b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.identity.intents.a.a(this, parcel, n);
    }
}
