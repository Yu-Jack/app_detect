// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.gw;
import android.net.Uri;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge
{
    public static final d CREATOR;
    private final int a;
    private int b;
    private String c;
    private String d;
    private Uri e;
    
    static {
        CREATOR = new com.google.android.gms.games.internal.game.c();
    }
    
    GameBadgeEntity(final int a, final int b, final String c, final String d, final Uri e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public GameBadgeEntity(final GameBadge gameBadge) {
        this.a = 1;
        this.b = gameBadge.b();
        this.c = gameBadge.c();
        this.d = gameBadge.d();
        this.e = gameBadge.e();
    }
    
    static int a(final GameBadge gameBadge) {
        return gw.a(gameBadge.b(), gameBadge.c(), gameBadge.d(), gameBadge.e());
    }
    
    static boolean a(final GameBadge gameBadge, final Object o) {
        boolean b = true;
        if (!(o instanceof GameBadge)) {
            b = false;
        }
        else if (gameBadge != o) {
            final GameBadge gameBadge2 = (GameBadge)o;
            if (!gw.a((Object)gameBadge2.b(), gameBadge.c()) || !gw.a(gameBadge2.d(), gameBadge.e())) {
                return false;
            }
        }
        return b;
    }
    
    static String b(final GameBadge gameBadge) {
        return gw.a(gameBadge).a("Type", gameBadge.b()).a("Title", gameBadge.c()).a("Description", gameBadge.d()).a("IconImageUri", gameBadge.e()).toString();
    }
    
    @Override
    public int b() {
        return this.b;
    }
    
    @Override
    public String c() {
        return this.c;
    }
    
    @Override
    public String d() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public Uri e() {
        return this.e;
    }
    
    @Override
    public boolean equals(final Object o) {
        return a(this, o);
    }
    
    public int f() {
        return this.a;
    }
    
    public GameBadge g() {
        return this;
    }
    
    @Override
    public int hashCode() {
        return a(this);
    }
    
    @Override
    public String toString() {
        return b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (!this.C()) {
            com.google.android.gms.games.internal.game.d.a(this, parcel, n);
            return;
        }
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        String string;
        if (this.e == null) {
            string = null;
        }
        else {
            string = this.e.toString();
        }
        parcel.writeString(string);
    }
}
