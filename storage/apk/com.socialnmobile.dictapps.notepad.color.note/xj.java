import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.AbstractMap;

// 
// Decompiled by Procyon v0.5.29
// 

public class xj extends AbstractMap
{
    final JSONObject a;
    
    public xj() {
        this(new JSONObject());
    }
    
    public xj(final JSONObject a) {
        if (a == null) {
            throw new IllegalArgumentException();
        }
        this.a = a;
    }
    
    public xj(final xj xj) {
        this(xj.a);
    }
    
    public static xj a(final String s) {
        return xf.e(s, xf.a(add.a.d(s)));
    }
    
    public final Object a(final String s, final ada ada) {
        return xf.a(s, xf.a(s, xf.c(s, this.b(s)), ada));
    }
    
    public final Object a(final String s, final adi adi) {
        final xj j = this.j(s);
        try {
            return adi.d(j);
        }
        catch (ux ux) {
            return null;
        }
    }
    
    public final Object a(final String s, Object c) {
        if (c instanceof acf) {
            c = ((acf)c).c();
        }
        final Object value = this.get(s);
        try {
            xf.a(this.a, s, c);
            return value;
        }
        catch (JSONException cause) {
            throw new IllegalArgumentException((Throwable)cause);
        }
    }
    
    public final void a(final String s, final Object o, final adk adk) {
        this.a(s, adk.c(o));
    }
    
    public final Object b(final String s) {
        return xf.a(this.a, s);
    }
    
    public final Object b(final String s, final adi adi) {
        return adi.d(this.f(s));
    }
    
    public final Number c(final String s) {
        return (Number)xf.a(s, xf.b(s, this.b(s)));
    }
    
    @Override
    public void clear() {
        final ArrayList<String> list = new ArrayList<String>();
        final Iterator keys = this.a.keys();
        while (keys.hasNext()) {
            list.add(keys.next());
        }
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.a.remove((String)iterator.next());
        }
    }
    
    public final String d(final String s) {
        return (String)xf.a(s, xf.c(s, this.b(s)));
    }
    
    public final xi e(final String s) {
        return (xi)xf.a(s, xf.d(s, this.b(s)));
    }
    
    @Override
    public Set entrySet() {
        final HashSet<xk> set = new HashSet<xk>();
        final Iterator keys = this.a.keys();
        while (keys.hasNext()) {
            set.add(new xk(this, keys.next()));
        }
        return set;
    }
    
    public final xj f(final String s) {
        return (xj)xf.a(s, xf.e(s, this.b(s)));
    }
    
    public final Number g(final String s) {
        try {
            return xf.b(s, this.get(s));
        }
        catch (xh xh) {
            xh.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Object get(final Object o) {
        try {
            return this.b((String)o);
        }
        catch (xg xg) {
            return null;
        }
    }
    
    public final String h(final String s) {
        try {
            return xf.c(s, this.get(s));
        }
        catch (xh xh) {
            xh.printStackTrace();
            return null;
        }
    }
    
    public final xi i(final String s) {
        try {
            return xf.d(s, this.get(s));
        }
        catch (xh xh) {
            xh.printStackTrace();
            return null;
        }
    }
    
    public final xj j(final String s) {
        try {
            return xf.e(s, this.get(s));
        }
        catch (xh xh) {
            xh.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Object remove(final Object o) {
        return this.a.remove((String)o);
    }
    
    @Override
    public final String toString() {
        return this.a.toString();
    }
}
