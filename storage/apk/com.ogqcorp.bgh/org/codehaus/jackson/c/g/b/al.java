// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import java.io.File;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.UUID;
import java.util.Currency;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.c.i.w;

public class al implements w<Map.Entry<Class<?>, Object>>
{
    @Override
    public Collection<Map.Entry<Class<?>, Object>> a() {
        final HashMap<Class<URL>, ba> hashMap = new HashMap<Class<URL>, ba>();
        final ba a = ba.a;
        hashMap.put(URL.class, a);
        hashMap.put((Class<URL>)URI.class, a);
        hashMap.put((Class<URL>)Currency.class, a);
        hashMap.put((Class<URL>)UUID.class, a);
        hashMap.put((Class<URL>)Pattern.class, a);
        hashMap.put((Class<URL>)Locale.class, a);
        hashMap.put((Class<URL>)Locale.class, a);
        hashMap.put((Class<URL>)AtomicReference.class, (ba)ap.class);
        hashMap.put((Class<URL>)AtomicBoolean.class, (ba)am.class);
        hashMap.put((Class<URL>)AtomicInteger.class, (ba)an.class);
        hashMap.put((Class<URL>)AtomicLong.class, (ba)ao.class);
        hashMap.put((Class<URL>)File.class, (ba)ar.class);
        hashMap.put((Class<URL>)Class.class, (ba)aq.class);
        hashMap.put((Class<URL>)Void.TYPE, (ba)p.class);
        return (Collection<Map.Entry<Class<?>, Object>>)hashMap.entrySet();
    }
}
