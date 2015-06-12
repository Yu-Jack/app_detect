// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.item;

import com.ogqcorp.bgh.system.MeasuredImageView;
import org.codehaus.jackson.annotate.JsonProperty;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.codehaus.jackson.annotate.JsonIgnore;
import android.widget.TextView;
import com.ogqcorp.bgh.system.g;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import java.util.ArrayList;
import android.os.Parcel;
import com.ogqcorp.bgh.system.j;
import java.util.List;
import android.os.Parcelable$Creator;
import com.ogqcorp.bgh.c.c;
import android.os.Parcelable;

public final class Background implements Parcelable, c
{
    public static final Parcelable$Creator<Background> CREATOR;
    int a;
    String b;
    String c;
    String d;
    String e;
    int f;
    int g;
    double h;
    int i;
    long j;
    long k;
    Author l;
    Effect m;
    License n;
    List<Link> o;
    private transient CharSequence p;
    private transient j q;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Background>() {
            public Background a(final Parcel parcel) {
                return new Background(parcel);
            }
            
            public Background[] a(final int n) {
                return new Background[n];
            }
        };
    }
    
    public Background() {
        this.h = Double.NaN;
        this.q = new j();
    }
    
    public Background(final Parcel parcel) {
        this.h = Double.NaN;
        this.q = new j();
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readDouble();
        this.i = parcel.readInt();
        this.j = parcel.readLong();
        this.k = parcel.readLong();
        this.l = (Author)parcel.readParcelable(Author.class.getClassLoader());
        this.m = (Effect)parcel.readParcelable(Effect.class.getClassLoader());
        this.n = (License)parcel.readParcelable(License.class.getClassLoader());
        parcel.readTypedList((List)(this.o = new ArrayList<Link>()), (Parcelable$Creator)Link.CREATOR);
    }
    
    @JsonIgnore
    public View a(final Context context, View inflate, final ViewGroup viewGroup, final boolean b) {
        if (inflate == null || !(inflate.getTag() instanceof a)) {
            inflate = LayoutInflater.from(context).inflate(2130903093, viewGroup, false);
            inflate.setTag((Object)new a(inflate, null));
        }
        final a a = (a)inflate.getTag();
        a.a.setImageRatio(1.0);
        if (!b) {
            this.q.a(context, this.a, a.a);
            final boolean a2 = com.ogqcorp.bgh.system.g.a().a(this);
            final ImageView b2 = a.b;
            int visibility;
            if (a2) {
                visibility = 0;
            }
            else {
                visibility = 8;
            }
            b2.setVisibility(visibility);
            a.c.setText(this.p);
            final TextView c = a.c;
            final CharSequence p4 = this.p;
            int visibility2 = 0;
            if (p4 == null) {
                visibility2 = 8;
            }
            c.setVisibility(visibility2);
        }
        return inflate;
    }
    
    public void a() {
        this.p = null;
    }
    
    public boolean a(final Pattern pattern) {
        return pattern.matcher(this.d).find();
    }
    
    public void b(final Pattern pattern) {
        final String string = " " + this.d + " ";
        final Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            final int start = matcher.start();
            this.p = string.substring(1 + string.lastIndexOf(32, start), string.indexOf(32, start));
        }
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this.a == ((Background)o).a;
    }
    
    public Author getAuthor() {
        return this.l;
    }
    
    public String getDescription() {
        return this.c;
    }
    
    public Effect getEffect() {
        return this.m;
    }
    
    @JsonIgnore
    public CharSequence getExtra() {
        return this.p;
    }
    
    public String getHashKey() {
        return this.e;
    }
    
    public int getHeight() {
        return this.g;
    }
    
    public long getHistoryDate() {
        return this.k;
    }
    
    public int getId() {
        return this.a;
    }
    
    public double getImageRatio() {
        if (Double.isNaN(this.h)) {
            return this.f / this.g;
        }
        return this.h;
    }
    
    public License getLicense() {
        return this.n;
    }
    
    @JsonProperty("links")
    public List<Link> getLinksList() {
        return this.o;
    }
    
    public long getRegDate() {
        return this.j;
    }
    
    public int getScore() {
        return this.i;
    }
    
    public String getTags() {
        return this.d;
    }
    
    public String getTitle() {
        return this.b;
    }
    
    public int getWidth() {
        return this.f;
    }
    
    @Override
    public int hashCode() {
        return this.a;
    }
    
    public void setAuthor(final Author l) {
        this.l = l;
    }
    
    public void setDescription(final String c) {
        this.c = c;
    }
    
    public void setEffect(final Effect m) {
        this.m = m;
    }
    
    @JsonIgnore
    public void setExtra(final CharSequence p) {
        this.p = p;
    }
    
    public void setHashKey(final String e) {
        this.e = e;
    }
    
    public void setHeight(final int g) {
        this.g = g;
    }
    
    public void setHistoryDate(final long k) {
        this.k = k;
    }
    
    public void setId(final int a) {
        this.a = a;
    }
    
    public void setImageRatio(final double h) {
        this.h = h;
    }
    
    public void setLicense(final License n) {
        this.n = n;
    }
    
    @JsonProperty("links")
    public void setLinksList(final List<Link> o) {
        this.o = o;
    }
    
    public void setRegDate(final long j) {
        this.j = j;
    }
    
    public void setScore(final int i) {
        this.i = i;
    }
    
    public void setTags(final String d) {
        this.d = d;
    }
    
    public void setTitle(final String b) {
        this.b = b;
    }
    
    public void setWidth(final int f) {
        this.f = f;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeDouble(this.h);
        parcel.writeInt(this.i);
        parcel.writeLong(this.j);
        parcel.writeLong(this.k);
        parcel.writeParcelable((Parcelable)this.l, 0);
        parcel.writeParcelable((Parcelable)this.m, 0);
        parcel.writeParcelable((Parcelable)this.n, 0);
        parcel.writeTypedList((List)this.o);
    }
}
