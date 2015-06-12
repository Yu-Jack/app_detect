// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.a;

import java.lang.reflect.Field;
import android.os.IBinder;

public final class d<T> extends b
{
    private final T a;
    
    private d(final T a) {
        this.a = a;
    }
    
    public static <T> a a(final T t) {
        return new d<Object>(t);
    }
    
    public static <T> T a(final a a) {
        if (a instanceof d) {
            return (T)((d)a).a;
        }
        final IBinder binder = a.asBinder();
        final Field[] declaredFields = binder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            final Field field = declaredFields[0];
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return (T)field.get(binder);
                }
                catch (NullPointerException cause) {
                    throw new IllegalArgumentException("Binder object is null.", cause);
                }
                catch (IllegalArgumentException cause2) {
                    throw new IllegalArgumentException("remoteBinder is the wrong class.", cause2);
                }
                catch (IllegalAccessException cause3) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", cause3);
                }
            }
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
}
