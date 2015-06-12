// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class hm implements SafeParcelable
{
    public static final hm A;
    public static final hm B;
    public static final hm C;
    public static final iy CREATOR;
    public static final hm D;
    public static final hm E;
    public static final hm F;
    public static final hm G;
    public static final hm H;
    public static final hm I;
    public static final hm J;
    public static final hm K;
    public static final hm L;
    public static final hm M;
    public static final hm N;
    public static final hm O;
    public static final hm P;
    public static final hm Q;
    public static final hm R;
    public static final hm S;
    public static final hm T;
    public static final hm U;
    public static final hm V;
    public static final hm W;
    public static final hm X;
    public static final hm Y;
    public static final hm Z;
    public static final hm a;
    public static final hm aA;
    public static final hm aB;
    public static final hm aC;
    public static final hm aD;
    public static final hm aE;
    public static final hm aF;
    public static final hm aG;
    public static final hm aH;
    public static final hm aI;
    public static final hm aJ;
    public static final hm aK;
    public static final hm aL;
    public static final hm aM;
    public static final hm aN;
    public static final hm aO;
    public static final hm aP;
    public static final hm aQ;
    public static final hm aR;
    public static final hm aS;
    public static final hm aT;
    public static final hm aU;
    public static final hm aV;
    public static final hm aW;
    public static final hm aX;
    public static final hm aY;
    public static final hm aZ;
    public static final hm aa;
    public static final hm ab;
    public static final hm ac;
    public static final hm ad;
    public static final hm ae;
    public static final hm af;
    public static final hm ag;
    public static final hm ah;
    public static final hm ai;
    public static final hm aj;
    public static final hm ak;
    public static final hm al;
    public static final hm am;
    public static final hm an;
    public static final hm ao;
    public static final hm ap;
    public static final hm aq;
    public static final hm ar;
    public static final hm as;
    public static final hm at;
    public static final hm au;
    public static final hm av;
    public static final hm aw;
    public static final hm ax;
    public static final hm ay;
    public static final hm az;
    public static final hm b;
    public static final hm ba;
    public static final hm bb;
    public static final hm bc;
    public static final hm bd;
    public static final hm be;
    public static final hm bf;
    public static final hm bg;
    public static final hm bh;
    public static final hm bi;
    public static final hm bj;
    public static final hm bk;
    public static final hm bl;
    public static final hm bm;
    public static final hm bn;
    public static final hm bo;
    public static final hm bp;
    public static final hm bq;
    public static final hm br;
    public static final hm bs;
    public static final hm bt;
    public static final hm bu;
    public static final hm bv;
    public static final hm c;
    public static final hm d;
    public static final hm e;
    public static final hm f;
    public static final hm g;
    public static final hm h;
    public static final hm i;
    public static final hm j;
    public static final hm k;
    public static final hm l;
    public static final hm m;
    public static final hm n;
    public static final hm o;
    public static final hm p;
    public static final hm q;
    public static final hm r;
    public static final hm s;
    public static final hm t;
    public static final hm u;
    public static final hm v;
    public static final hm w;
    public static final hm x;
    public static final hm y;
    public static final hm z;
    final int bw;
    final String bx;
    
    static {
        a = a("accounting");
        b = a("airport");
        c = a("amusement_park");
        d = a("aquarium");
        e = a("art_gallery");
        f = a("atm");
        g = a("bakery");
        h = a("bank");
        i = a("bar");
        j = a("beauty_salon");
        k = a("bicycle_store");
        l = a("book_store");
        m = a("bowling_alley");
        n = a("bus_station");
        o = a("cafe");
        p = a("campground");
        q = a("car_dealer");
        r = a("car_rental");
        s = a("car_repair");
        t = a("car_wash");
        u = a("casino");
        v = a("cemetery");
        w = a("church");
        x = a("city_hall");
        y = a("clothing_store");
        z = a("convenience_store");
        A = a("courthouse");
        B = a("dentist");
        C = a("department_store");
        D = a("doctor");
        E = a("electrician");
        F = a("electronics_store");
        G = a("embassy");
        H = a("establishment");
        I = a("finance");
        J = a("fire_station");
        K = a("florist");
        L = a("food");
        M = a("funeral_home");
        N = a("furniture_store");
        O = a("gas_station");
        P = a("general_contractor");
        Q = a("grocery_or_supermarket");
        R = a("gym");
        S = a("hair_care");
        T = a("hardware_store");
        U = a("health");
        V = a("hindu_temple");
        W = a("home_goods_store");
        X = a("hospital");
        Y = a("insurance_agency");
        Z = a("jewelry_store");
        aa = a("laundry");
        ab = a("lawyer");
        ac = a("library");
        ad = a("liquor_store");
        ae = a("local_government_office");
        af = a("locksmith");
        ag = a("lodging");
        ah = a("meal_delivery");
        ai = a("meal_takeaway");
        aj = a("mosque");
        ak = a("movie_rental");
        al = a("movie_theater");
        am = a("moving_company");
        an = a("museum");
        ao = a("night_club");
        ap = a("painter");
        aq = a("park");
        ar = a("parking");
        as = a("pet_store");
        at = a("pharmacy");
        au = a("physiotherapist");
        av = a("place_of_worship");
        aw = a("plumber");
        ax = a("police");
        ay = a("post_office");
        az = a("real_estate_agency");
        aA = a("restaurant");
        aB = a("roofing_contractor");
        aC = a("rv_park");
        aD = a("school");
        aE = a("shoe_store");
        aF = a("shopping_mall");
        aG = a("spa");
        aH = a("stadium");
        aI = a("storage");
        aJ = a("store");
        aK = a("subway_station");
        aL = a("synagogue");
        aM = a("taxi_stand");
        aN = a("train_station");
        aO = a("travel_agency");
        aP = a("university");
        aQ = a("veterinary_care");
        aR = a("zoo");
        aS = a("administrative_area_level_1");
        aT = a("administrative_area_level_2");
        aU = a("administrative_area_level_3");
        aV = a("colloquial_area");
        aW = a("country");
        aX = a("floor");
        aY = a("geocode");
        aZ = a("intersection");
        ba = a("locality");
        bb = a("natural_feature");
        bc = a("neighborhood");
        bd = a("political");
        be = a("point_of_interest");
        bf = a("post_box");
        bg = a("postal_code");
        bh = a("postal_code_prefix");
        bi = a("postal_town");
        bj = a("premise");
        bk = a("room");
        bl = a("route");
        bm = a("street_address");
        bn = a("sublocality");
        bo = a("sublocality_level_1");
        bp = a("sublocality_level_2");
        bq = a("sublocality_level_3");
        br = a("sublocality_level_4");
        bs = a("sublocality_level_5");
        bt = a("subpremise");
        bu = a("transit_station");
        bv = a("other");
        CREATOR = new iy();
    }
    
    hm(final int bw, final String bx) {
        gz.a(bx);
        this.bw = bw;
        this.bx = bx;
    }
    
    public static hm a(final String s) {
        return new hm(0, s);
    }
    
    public int describeContents() {
        final iy creator = hm.CREATOR;
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof hm && this.bx.equals(((hm)o).bx);
    }
    
    @Override
    public int hashCode() {
        return this.bx.hashCode();
    }
    
    @Override
    public String toString() {
        return this.bx;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final iy creator = hm.CREATOR;
        iy.a(this, parcel, n);
    }
}
