// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.item;

import android.widget.TextView;
import com.ogqcorp.bgh.system.SafeImageView;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.Locale;
import android.os.Parcel;
import com.ogqcorp.bgh.system.j;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Category implements Parcelable, Comparable<Category>
{
    public static final Parcelable$Creator<Category> CREATOR;
    int a;
    String b;
    int c;
    private transient CharSequence d;
    private transient j e;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Category>() {
            public Category a(final Parcel parcel) {
                return new Category(parcel);
            }
            
            public Category[] a(final int n) {
                return new Category[n];
            }
        };
    }
    
    public Category() {
        this.e = new j();
    }
    
    public Category(final Parcel parcel) {
        this.e = new j();
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readInt();
    }
    
    @JsonIgnore
    private CharSequence a() {
        if (this.d == null) {
            this.d = String.format(Locale.US, "(%d)", this.c);
        }
        return this.d;
    }
    
    public int a(final Category category) {
        return this.b.compareTo(category.b);
    }
    
    @JsonIgnore
    public View a(final Context context, View inflate, final ViewGroup viewGroup, final boolean b) {
        if (inflate == null || !(inflate.getTag() instanceof b)) {
            inflate = LayoutInflater.from(context).inflate(2130903094, viewGroup, false);
            inflate.setTag((Object)new b(inflate, null));
        }
        final b b2 = (b)inflate.getTag();
        this.e.d(context, this.a, b2.a);
        b2.b.setText((CharSequence)this.b);
        b2.c.setText(this.a());
        return inflate;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public int getCount() {
        return this.c;
    }
    
    public int getId() {
        return this.a;
    }
    
    public String getName() {
        return this.b;
    }
    
    public void setCount(final int c) {
        this.c = c;
    }
    
    public void setId(final int a) {
        this.a = a;
    }
    
    public void setName(final String b) {
        this.b = b;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
    }
}
