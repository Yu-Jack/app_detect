// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;
import com.google.android.gms.appindexing.AppIndexApi$AppIndexingLink;
import android.os.Bundle;
import android.content.ComponentName;
import java.util.ArrayList;
import java.util.List;
import android.net.Uri;
import android.content.Intent;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fr implements SafeParcelable
{
    public static final fs CREATOR;
    public final String mP;
    final int xM;
    final fi yq;
    final long yr;
    final int ys;
    final fg yt;
    
    static {
        CREATOR = new fs();
    }
    
    fr(final int xm, final fi yq, final long yr, final int ys, final String mp, final fg yt) {
        this.xM = xm;
        this.yq = yq;
        this.yr = yr;
        this.ys = ys;
        this.mP = mp;
        this.yt = yt;
    }
    
    public fr(final fi fi, final long n, final int n2) {
        this(1, fi, n, n2, null, null);
    }
    
    public fr(final String s, final Intent intent, final String s2, final Uri uri, final String s3, final List list) {
        this(1, a(s, intent), System.currentTimeMillis(), 0, null, a(intent, s2, uri, s3, list));
    }
    
    static fg a(final Intent intent, final String s, final Uri uri, final String s2, final List list) {
        final ArrayList<fk> list2 = new ArrayList<fk>();
        list2.add(ab(s));
        if (uri != null) {
            list2.add(f(uri));
        }
        if (list != null) {
            list2.add(a(list));
        }
        final String action = intent.getAction();
        if (action != null) {
            list2.add(f("intent_action", action));
        }
        final String dataString = intent.getDataString();
        if (dataString != null) {
            list2.add(f("intent_data", dataString));
        }
        final ComponentName component = intent.getComponent();
        if (component != null) {
            list2.add(f("intent_activity", component.getClassName()));
        }
        final Bundle extras = intent.getExtras();
        if (extras != null) {
            final String string = extras.getString("intent_extra_data_key");
            if (string != null) {
                list2.add(f("intent_extra_data", string));
            }
        }
        return new fg(s2, true, (fk[])list2.toArray(new fk[list2.size()]));
    }
    
    public static fi a(final String s, final Intent intent) {
        return new fi(s, "", f(intent));
    }
    
    private static fk a(final List list) {
        final iv$a iv$a = new iv$a();
        final iv$a$a[] uy = new iv$a$a[list.size()];
        for (int i = 0; i < uy.length; ++i) {
            uy[i] = new iv$a$a();
            final AppIndexApi$AppIndexingLink appIndexApi$AppIndexingLink = list.get(i);
            uy[i].UA = appIndexApi$AppIndexingLink.appIndexingUrl.toString();
            uy[i].UB = appIndexApi$AppIndexingLink.webUrl.toString();
            uy[i].viewId = appIndexApi$AppIndexingLink.viewId;
        }
        iv$a.Uy = uy;
        return new fk(me.d(iv$a), new fp$a("outlinks").w(true).aa(".private:outLinks").Z("blob").dQ());
    }
    
    private static fk ab(final String s) {
        return new fk(s, new fp$a("title").I(1).x(true).aa("name").dQ(), "text1");
    }
    
    private static fk f(final Uri uri) {
        return new fk(uri.toString(), new fp$a("web_url").I(4).w(true).aa("url").dQ());
    }
    
    private static fk f(final String s, final String s2) {
        return new fk(s2, new fp$a(s).w(true).dQ(), s);
    }
    
    private static String f(final Intent intent) {
        final String uri = intent.toUri(1);
        final CRC32 crc32 = new CRC32();
        try {
            crc32.update(uri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        }
        catch (UnsupportedEncodingException cause) {
            throw new IllegalStateException(cause);
        }
    }
    
    public int describeContents() {
        final fs creator = fr.CREATOR;
        return 0;
    }
    
    @Override
    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", this.yq, this.yr, this.ys);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final fs creator = fr.CREATOR;
        fs.a(this, parcel, n);
    }
}
