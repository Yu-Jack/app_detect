// 
// Decompiled by Procyon v0.5.29
// 

package com.google.a.a;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import com.google.android.gms.internal.en;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public abstract class g
{
    protected void a() {
    }
    
    public void a(final Map<String, String> map) {
        final HashMap<Object, Field> hashMap = new HashMap<Object, Field>();
        for (final Field field : this.getClass().getFields()) {
            final i j = field.getAnnotation(i.class);
            if (j != null) {
                hashMap.put(j.a(), field);
            }
        }
        if (hashMap.isEmpty()) {
            en.e("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (final Map.Entry<String, String> entry : map.entrySet()) {
            final Field field2 = hashMap.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                }
                catch (IllegalAccessException ex) {
                    en.e("Server option \"" + entry.getKey() + "\" could not be set: Illegal Access");
                }
                catch (IllegalArgumentException ex2) {
                    en.e("Server option \"" + entry.getKey() + "\" could not be set: Bad Type");
                }
            }
            else {
                en.a("Unexpected server option: " + entry.getKey() + " = \"" + entry.getValue() + "\"");
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (final Field field3 : hashMap.values()) {
            if (field3.getAnnotation(i.class).b()) {
                en.e("Required server option missing: " + field3.getAnnotation(i.class).a());
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(field3.getAnnotation(i.class).a());
            }
        }
        if (sb.length() > 0) {
            throw new h("Required server option(s) missing: " + sb.toString());
        }
        this.a();
    }
}
