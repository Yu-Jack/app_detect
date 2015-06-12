// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class aw implements SafeParcelable
{
    public static final ax CREATOR;
    public final int backgroundColor;
    public final int mD;
    public final int mE;
    public final int mF;
    public final int mG;
    public final int mH;
    public final int mI;
    public final int mJ;
    public final String mK;
    public final int mL;
    public final String mM;
    public final int mN;
    public final int mO;
    public final String mP;
    public final int versionCode;
    
    static {
        CREATOR = new ax();
    }
    
    aw(final int versionCode, final int md, final int backgroundColor, final int me, final int mf, final int mg, final int mh, final int mi, final int mj, final String mk, final int ml, final String mm, final int mn, final int mo, final String mp) {
        this.versionCode = versionCode;
        this.mD = md;
        this.backgroundColor = backgroundColor;
        this.mE = me;
        this.mF = mf;
        this.mG = mg;
        this.mH = mh;
        this.mI = mi;
        this.mJ = mj;
        this.mK = mk;
        this.mL = ml;
        this.mM = mm;
        this.mN = mn;
        this.mO = mo;
        this.mP = mp;
    }
    
    public aw(final SearchAdRequest searchAdRequest) {
        this.versionCode = 1;
        this.mD = searchAdRequest.getAnchorTextColor();
        this.backgroundColor = searchAdRequest.getBackgroundColor();
        this.mE = searchAdRequest.getBackgroundGradientBottom();
        this.mF = searchAdRequest.getBackgroundGradientTop();
        this.mG = searchAdRequest.getBorderColor();
        this.mH = searchAdRequest.getBorderThickness();
        this.mI = searchAdRequest.getBorderType();
        this.mJ = searchAdRequest.getCallButtonColor();
        this.mK = searchAdRequest.getCustomChannels();
        this.mL = searchAdRequest.getDescriptionTextColor();
        this.mM = searchAdRequest.getFontFace();
        this.mN = searchAdRequest.getHeaderTextColor();
        this.mO = searchAdRequest.getHeaderTextSize();
        this.mP = searchAdRequest.getQuery();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ax.a(this, parcel, n);
    }
}
