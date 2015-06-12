// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.lang.reflect.Field;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class Controller$ReflectedParcelable implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator() {
            public final Controller$ReflectedParcelable createFromParcel(final Parcel parcel) {
                return new Controller$ReflectedParcelable(parcel);
            }
            
            public final Controller$ReflectedParcelable[] newArray(final int n) {
                return new Controller$ReflectedParcelable[n];
            }
        };
    }
    
    public Controller$ReflectedParcelable() {
    }
    
    protected Controller$ReflectedParcelable(final Parcel parcel) {
        final Field[] declaredFields = this.getClass().getDeclaredFields();
        final int length = declaredFields.length;
        int i = 0;
    Label_0053_Outer:
        while (i < length) {
            final Field field = declaredFields[i];
            while (true) {
                try {
                    if (!(field.get(this) instanceof Parcelable$Creator)) {
                        field.set(this, parcel.readValue((ClassLoader)null));
                    }
                    ++i;
                    continue Label_0053_Outer;
                }
                catch (IllegalAccessException ex) {
                    Log.e(Controller.LOG_TAG, "Error: Could not create object from parcel: %s", ex.getMessage());
                    continue;
                }
                catch (IllegalArgumentException ex2) {
                    Log.e(Controller.LOG_TAG, "Error: Could not create object from parcel: %s", ex2.getMessage());
                    continue;
                }
                break;
            }
            break;
        }
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final Field[] declaredFields = this.getClass().getDeclaredFields();
        final int length = declaredFields.length;
        int i = 0;
    Label_0050_Outer:
        while (i < length) {
            final Field field = declaredFields[i];
            while (true) {
                try {
                    final Object value = field.get(this);
                    if (!(value instanceof Parcelable$Creator)) {
                        parcel.writeValue(value);
                    }
                    ++i;
                    continue Label_0050_Outer;
                }
                catch (IllegalAccessException ex) {
                    Log.e(Controller.LOG_TAG, "Error: Could not write to parcel: %s", ex.getMessage());
                    continue;
                }
                catch (IllegalArgumentException ex2) {
                    Log.e(Controller.LOG_TAG, "Error: Could not write to parcel: %s", ex2.getMessage());
                    continue;
                }
                break;
            }
            break;
        }
    }
}
