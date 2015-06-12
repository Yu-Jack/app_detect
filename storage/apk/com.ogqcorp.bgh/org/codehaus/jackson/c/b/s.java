// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import java.util.Iterator;
import org.codehaus.jackson.c.b.b.w;
import org.codehaus.jackson.c.b.b.bz;
import org.codehaus.jackson.c.b.b.a;
import org.codehaus.jackson.c.b.b.bb;
import org.codehaus.jackson.c.b.b.m;
import org.codehaus.jackson.c.b.b.by;
import org.codehaus.jackson.c.b.b.ba;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.codehaus.jackson.c.b.b.h;
import org.codehaus.jackson.c.b.b.d;
import org.codehaus.jackson.c.b.b.ap;
import org.codehaus.jackson.c.b.b.ao;
import org.codehaus.jackson.c.b.b.ax;
import org.codehaus.jackson.c.b.b.at;
import org.codehaus.jackson.c.b.b.au;
import org.codehaus.jackson.c.b.b.aw;
import org.codehaus.jackson.c.b.b.av;
import org.codehaus.jackson.c.b.b.as;
import org.codehaus.jackson.c.b.b.az;
import org.codehaus.jackson.c.b.b.ar;
import org.codehaus.jackson.c.b.b.aq;
import org.codehaus.jackson.c.b.b.e;
import org.codehaus.jackson.c.b.b.bw;
import org.codehaus.jackson.c.b.b.an;
import org.codehaus.jackson.c.b.b.ca;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.h.b;
import java.util.HashMap;

class s
{
    final HashMap<b, x<Object>> a;
    
    private s() {
        this.a = new HashMap<b, x<Object>>();
        this.a(new ca());
        final bw bw = new bw();
        this.a(bw, String.class);
        this.a(bw, CharSequence.class);
        this.a(new e());
        this.a(new aq(Boolean.class, null));
        this.a(new ar(Byte.class, null));
        this.a(new az(Short.class, null));
        this.a(new as(Character.class, null));
        this.a(new av(Integer.class, null));
        this.a(new aw(Long.class, null));
        this.a(new au(Float.class, null));
        this.a(new at(Double.class, null));
        this.a(new aq(Boolean.TYPE, Boolean.FALSE));
        this.a(new ar(Byte.TYPE, Byte.valueOf((byte)0)));
        this.a(new az(Short.TYPE, Short.valueOf((short)0)));
        this.a(new as(Character.TYPE, Character.valueOf('\0')));
        this.a(new av(Integer.TYPE, Integer.valueOf(0)));
        this.a(new aw(Long.TYPE, Long.valueOf(0L)));
        this.a(new au(Float.TYPE, Float.valueOf(0.0f)));
        this.a(new at(Double.TYPE, Double.valueOf(0.0)));
        this.a(new ax());
        this.a(new ao());
        this.a(new ap());
        this.a(new d());
        this.a(new h());
        this.a(new d(GregorianCalendar.class), GregorianCalendar.class);
        this.a(new ba());
        this.a(new by());
        final Iterator<m<?>> iterator = m.d().iterator();
        while (iterator.hasNext()) {
            this.a(iterator.next());
        }
        this.a(new bb());
        this.a(new a());
        this.a(new bz());
        this.a(new w());
    }
    
    public static HashMap<b, x<Object>> a() {
        return new s().a;
    }
    
    private void a(final an<?> an) {
        this.a(an, an.f());
    }
    
    private void a(final an<?> value, final Class<?> clazz) {
        this.a.put(new b(clazz), (x<Object>)value);
    }
}
