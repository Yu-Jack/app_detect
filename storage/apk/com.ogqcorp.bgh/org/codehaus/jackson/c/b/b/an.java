// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.b.g;
import org.codehaus.jackson.m;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.t;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.c.az;
import java.util.Date;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.x;

public abstract class an<T> extends x<T>
{
    protected final Class<?> q;
    
    protected an(final Class<?> q) {
        this.q = q;
    }
    
    protected an(final a a) {
        Class<?> p;
        if (a == null) {
            p = null;
        }
        else {
            p = a.p();
        }
        this.q = p;
    }
    
    protected static final double b(final String s) {
        if ("2.2250738585072012e-308".equals(s)) {
            return Double.MIN_NORMAL;
        }
        return Double.parseDouble(s);
    }
    
    protected final double A(final k k, final p p2) {
        double x = 0.0;
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.i || e == org.codehaus.jackson.p.j) {
            x = k.x();
        }
        else {
            if (e == org.codehaus.jackson.p.h) {
                final String trim = k.k().trim();
                if (trim.length() == 0) {
                    return x;
                }
                Label_0130: {
                    switch (trim.charAt(0)) {
                        default: {
                            break Label_0130;
                        }
                        case 'I': {
                            break Label_0130;
                        }
                        case 'N': {
                            break Label_0130;
                        }
                        case '-': {
                            Label_0144: {
                                break Label_0144;
                                try {
                                    return b(trim);
                                    // iftrue(Label_0096:, !"Infinity".equals((Object)trim) && !"INF".equals((Object)trim))
                                    return Double.POSITIVE_INFINITY;
                                    // iftrue(Label_0096:, !"-Infinity".equals((Object)trim) && !"-INF".equals((Object)trim))
                                    return Double.NEGATIVE_INFINITY;
                                    // iftrue(Label_0096:, !"NaN".equals((Object)trim))
                                    return Double.NaN;
                                }
                                catch (IllegalArgumentException ex) {
                                    throw p2.b(this.q, "not a valid double value");
                                }
                            }
                            break;
                        }
                    }
                }
            }
            if (e != org.codehaus.jackson.p.m) {
                throw p2.a(this.q, e);
            }
        }
        return x;
    }
    
    protected Date B(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.i) {
            return new Date(k.u());
        }
        if (e == org.codehaus.jackson.p.m) {
            return this.b();
        }
        if (e == org.codehaus.jackson.p.h) {
            try {
                final String trim = k.k().trim();
                if (trim.length() == 0) {
                    return this.c();
                }
                return p2.a(trim);
            }
            catch (IllegalArgumentException ex) {
                throw p2.b(this.q, "not a valid representation (error: " + ex.getMessage() + ")");
            }
        }
        throw p2.a(this.q, e);
    }
    
    @Override
    public Object a(final k k, final p p3, final az az) {
        return az.d(k, p3);
    }
    
    protected x<Object> a(final n n, final t t, final a a, final f f) {
        return t.a(n, a, f);
    }
    
    protected void a(final p p3, final Object o, final String s) {
        if (p3.a(o.k)) {
            throw p3.a(o, s);
        }
    }
    
    protected void a(final k k, final p p4, Object f, final String s) {
        if (f == null) {
            f = this.f();
        }
        if (p4.a(k, this, f, s)) {
            return;
        }
        this.a(p4, f, s);
        k.d();
    }
    
    protected boolean a(final x<?> x) {
        return x != null && x.getClass().getAnnotation(b.class) != null;
    }
    
    public Class<?> f() {
        return this.q;
    }
    
    protected final boolean n(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e != org.codehaus.jackson.p.k) {
            if (e == org.codehaus.jackson.p.l) {
                return false;
            }
            if (e == org.codehaus.jackson.p.m) {
                return false;
            }
            if (e == org.codehaus.jackson.p.i) {
                if (k.q() != m.a) {
                    return this.p(k, p2);
                }
                if (k.t() == 0) {
                    return false;
                }
            }
            else {
                if (e != org.codehaus.jackson.p.h) {
                    throw p2.a(this.q, e);
                }
                final String trim = k.k().trim();
                if (!"true".equals(trim)) {
                    if ("false".equals(trim) || trim.length() == 0) {
                        return Boolean.FALSE;
                    }
                    throw p2.b(this.q, "only \"true\" or \"false\" recognized");
                }
            }
        }
        return true;
    }
    
    protected final Boolean o(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.k) {
            return Boolean.TRUE;
        }
        if (e == org.codehaus.jackson.p.l) {
            return Boolean.FALSE;
        }
        if (e == org.codehaus.jackson.p.i) {
            if (k.q() != m.a) {
                return this.p(k, p2);
            }
            if (k.t() == 0) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        else {
            if (e == org.codehaus.jackson.p.m) {
                return this.b();
            }
            if (e != org.codehaus.jackson.p.h) {
                throw p2.a(this.q, e);
            }
            final String trim = k.k().trim();
            if ("true".equals(trim)) {
                return Boolean.TRUE;
            }
            if ("false".equals(trim)) {
                return Boolean.FALSE;
            }
            if (trim.length() == 0) {
                return this.c();
            }
            throw p2.b(this.q, "only \"true\" or \"false\" recognized");
        }
    }
    
    protected final boolean p(final k k, final p p2) {
        if (k.q() == m.b) {
            Boolean b;
            if (k.u() == 0L) {
                b = Boolean.FALSE;
            }
            else {
                b = Boolean.TRUE;
            }
            return b;
        }
        final String i = k.k();
        if ("0.0".equals(i) || "0".equals(i)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    
    protected Byte q(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.i || e == org.codehaus.jackson.p.j) {
            return k.r();
        }
        if (e == org.codehaus.jackson.p.h) {
            final String trim = k.k().trim();
            int a;
            try {
                if (trim.length() == 0) {
                    return this.c();
                }
                a = g.a(trim);
                if (a < -128 || a > 255) {
                    throw p2.b(this.q, "overflow, value can not be represented as 8-bit value");
                }
            }
            catch (IllegalArgumentException ex) {
                throw p2.b(this.q, "not a valid Byte value");
            }
            return (byte)a;
        }
        if (e == org.codehaus.jackson.p.m) {
            return this.b();
        }
        throw p2.a(this.q, e);
    }
    
    protected Short r(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.i || e == org.codehaus.jackson.p.j) {
            return k.s();
        }
        if (e == org.codehaus.jackson.p.h) {
            final String trim = k.k().trim();
            int a;
            try {
                if (trim.length() == 0) {
                    return this.c();
                }
                a = g.a(trim);
                if (a < -32768 || a > 32767) {
                    throw p2.b(this.q, "overflow, value can not be represented as 16-bit value");
                }
            }
            catch (IllegalArgumentException ex) {
                throw p2.b(this.q, "not a valid Short value");
            }
            return (short)a;
        }
        if (e == org.codehaus.jackson.p.m) {
            return this.b();
        }
        throw p2.a(this.q, e);
    }
    
    protected final short s(final k k, final p p2) {
        final int t = this.t(k, p2);
        if (t < -32768 || t > 32767) {
            throw p2.b(this.q, "overflow, value can not be represented as 16-bit value");
        }
        return (short)t;
    }
    
    protected final int t(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        int t;
        if (e == org.codehaus.jackson.p.i || e == org.codehaus.jackson.p.j) {
            t = k.t();
        }
        else if (e == org.codehaus.jackson.p.h) {
            final String trim = k.k().trim();
            int length = 0;
            Label_0160: {
                long long1;
                try {
                    length = trim.length();
                    if (length <= 9) {
                        break Label_0160;
                    }
                    long1 = Long.parseLong(trim);
                    if (long1 < -2147483648L || long1 > 2147483647L) {
                        throw p2.b(this.q, "Overflow: numeric value (" + trim + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
                    }
                }
                catch (IllegalArgumentException ex) {
                    throw p2.b(this.q, "not a valid int value");
                }
                return (int)long1;
            }
            t = 0;
            if (length != 0) {
                return g.a(trim);
            }
        }
        else {
            final org.codehaus.jackson.p m = org.codehaus.jackson.p.m;
            t = 0;
            if (e != m) {
                throw p2.a(this.q, e);
            }
        }
        return t;
    }
    
    protected final Integer u(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.i || e == org.codehaus.jackson.p.j) {
            return k.t();
        }
        if (e == org.codehaus.jackson.p.h) {
            final String trim = k.k().trim();
            int length = 0;
            Label_0166: {
                long long1;
                try {
                    length = trim.length();
                    if (length <= 9) {
                        break Label_0166;
                    }
                    long1 = Long.parseLong(trim);
                    if (long1 < -2147483648L || long1 > 2147483647L) {
                        throw p2.b(this.q, "Overflow: numeric value (" + trim + ") out of range of Integer (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
                    }
                }
                catch (IllegalArgumentException ex) {
                    throw p2.b(this.q, "not a valid Integer value");
                }
                return (int)long1;
            }
            if (length == 0) {
                return this.c();
            }
            return g.a(trim);
        }
        else {
            if (e == org.codehaus.jackson.p.m) {
                return this.b();
            }
            throw p2.a(this.q, e);
        }
    }
    
    protected final Long v(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.i || e == org.codehaus.jackson.p.j) {
            return k.u();
        }
        if (e == org.codehaus.jackson.p.h) {
            final String trim = k.k().trim();
            if (trim.length() == 0) {
                return this.c();
            }
            try {
                return g.b(trim);
            }
            catch (IllegalArgumentException ex) {
                throw p2.b(this.q, "not a valid Long value");
            }
        }
        if (e == org.codehaus.jackson.p.m) {
            return this.b();
        }
        throw p2.a(this.q, e);
    }
    
    protected final long w(final k k, final p p2) {
        long u = 0L;
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.i || e == org.codehaus.jackson.p.j) {
            u = k.u();
        }
        else {
            if (e == org.codehaus.jackson.p.h) {
                final String trim = k.k().trim();
                if (trim.length() == 0) {
                    return u;
                }
                try {
                    return g.b(trim);
                }
                catch (IllegalArgumentException ex) {
                    throw p2.b(this.q, "not a valid long value");
                }
            }
            if (e != org.codehaus.jackson.p.m) {
                throw p2.a(this.q, e);
            }
        }
        return u;
    }
    
    protected final Float x(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.i || e == org.codehaus.jackson.p.j) {
            return k.w();
        }
        if (e == org.codehaus.jackson.p.h) {
            final String trim = k.k().trim();
            if (trim.length() == 0) {
                return this.c();
            }
            Label_0140: {
                switch (trim.charAt(0)) {
                    default: {
                        break Label_0140;
                    }
                    case 'I': {
                        break Label_0140;
                    }
                    case 'N': {
                        break Label_0140;
                    }
                    case '-': {
                        Label_0157: {
                            break Label_0157;
                            try {
                                return Float.parseFloat(trim);
                                // iftrue(Label_0100:, !"NaN".equals((Object)trim))
                                return Float.NaN;
                                // iftrue(Label_0100:, !"-Infinity".equals((Object)trim) && !"-INF".equals((Object)trim))
                                return Float.NEGATIVE_INFINITY;
                                // iftrue(Label_0100:, !"Infinity".equals((Object)trim) && !"INF".equals((Object)trim))
                                return Float.POSITIVE_INFINITY;
                            }
                            catch (IllegalArgumentException ex) {
                                throw p2.b(this.q, "not a valid Float value");
                            }
                        }
                        break;
                    }
                }
            }
        }
        if (e == org.codehaus.jackson.p.m) {
            return this.b();
        }
        throw p2.a(this.q, e);
    }
    
    protected final float y(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        float w;
        if (e == org.codehaus.jackson.p.i || e == org.codehaus.jackson.p.j) {
            w = k.w();
        }
        else {
            if (e == org.codehaus.jackson.p.h) {
                final String trim = k.k().trim();
                final int length = trim.length();
                w = 0.0f;
                if (length == 0) {
                    return w;
                }
                Label_0134: {
                    switch (trim.charAt(0)) {
                        default: {
                            break Label_0134;
                        }
                        case 'I': {
                            break Label_0134;
                        }
                        case 'N': {
                            break Label_0134;
                        }
                        case '-': {
                            Label_0148: {
                                break Label_0148;
                                try {
                                    return Float.parseFloat(trim);
                                    // iftrue(Label_0100:, !"NaN".equals((Object)trim))
                                    return Float.NaN;
                                    // iftrue(Label_0100:, !"-Infinity".equals((Object)trim) && !"-INF".equals((Object)trim))
                                    return Float.NEGATIVE_INFINITY;
                                    // iftrue(Label_0100:, !"Infinity".equals((Object)trim) && !"INF".equals((Object)trim))
                                    return Float.POSITIVE_INFINITY;
                                }
                                catch (IllegalArgumentException ex) {
                                    throw p2.b(this.q, "not a valid float value");
                                }
                            }
                            break;
                        }
                    }
                }
            }
            final org.codehaus.jackson.p m = org.codehaus.jackson.p.m;
            w = 0.0f;
            if (e != m) {
                throw p2.a(this.q, e);
            }
        }
        return w;
    }
    
    protected final Double z(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.i || e == org.codehaus.jackson.p.j) {
            return k.x();
        }
        if (e == org.codehaus.jackson.p.h) {
            final String trim = k.k().trim();
            if (trim.length() == 0) {
                return this.c();
            }
            Label_0140: {
                switch (trim.charAt(0)) {
                    default: {
                        break Label_0140;
                    }
                    case 'I': {
                        break Label_0140;
                    }
                    case 'N': {
                        break Label_0140;
                    }
                    case '-': {
                        Label_0157: {
                            break Label_0157;
                            try {
                                return b(trim);
                                // iftrue(Label_0100:, !"NaN".equals((Object)trim))
                                return Double.NaN;
                                // iftrue(Label_0100:, !"Infinity".equals((Object)trim) && !"INF".equals((Object)trim))
                                return Double.POSITIVE_INFINITY;
                                // iftrue(Label_0100:, !"-Infinity".equals((Object)trim) && !"-INF".equals((Object)trim))
                                return Double.NEGATIVE_INFINITY;
                            }
                            catch (IllegalArgumentException ex) {
                                throw p2.b(this.q, "not a valid Double value");
                            }
                        }
                        break;
                    }
                }
            }
        }
        if (e == org.codehaus.jackson.p.m) {
            return this.b();
        }
        throw p2.a(this.q, e);
    }
}
