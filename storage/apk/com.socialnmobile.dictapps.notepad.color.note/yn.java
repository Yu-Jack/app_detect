import java.util.Date;
import java.text.ParseException;
import android.content.Context;
import java.text.SimpleDateFormat;

// 
// Decompiled by Procyon v0.5.29
// 

public final class yn
{
    static SimpleDateFormat e;
    static final long[] g;
    static final long[] h;
    public int a;
    public int b;
    public int c;
    public boolean d;
    long[] f;
    
    static {
        yn.e = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5");
        g = new long[] { 19416L, 19168L, 42352L, 21717L, 53856L, 55632L, 91476L, 22176L, 39632L, 21970L, 19168L, 42422L, 42192L, 53840L, 119381L, 46400L, 54944L, 44450L, 38320L, 84343L, 18800L, 42160L, 46261L, 27216L, 27968L, 109396L, 11104L, 38256L, 21234L, 18800L, 25958L, 54432L, 59984L, 28309L, 23248L, 11104L, 100067L, 37600L, 116951L, 51536L, 54432L, 120998L, 46416L, 22176L, 107956L, 9680L, 37584L, 53938L, 43344L, 46423L, 27808L, 46416L, 86869L, 19872L, 42448L, 83315L, 21200L, 43432L, 59728L, 27296L, 44710L, 43856L, 19296L, 43748L, 42352L, 21088L, 62051L, 55632L, 23383L, 22176L, 38608L, 19925L, 19152L, 42192L, 54484L, 53840L, 54616L, 46400L, 46496L, 103846L, 38320L, 18864L, 43380L, 42160L, 45690L, 27216L, 27968L, 44870L, 43872L, 38256L, 19189L, 18800L, 25776L, 29859L, 59984L, 27480L, 21952L, 43872L, 38613L, 37600L, 51552L, 55636L, 54432L, 55888L, 30034L, 22208L, 43959L, 9680L, 37584L, 51893L, 43344L, 46240L, 111779L, 46416L, 21977L, 19360L, 42416L, 38261L, 21168L, 43344L, 31060L, 27296L, 44368L, 23378L, 19296L, 42726L, 42208L, 53856L, 60005L, 54576L, 23200L, 30371L, 38608L, 19415L, 19152L, 42192L, 118966L, 53840L, 54560L, 56645L, 46496L, 22224L, 21938L, 18864L, 42359L, 42160L, 43600L, 111189L, 27936L, 44448L };
        h = new long[] { 19416L, 19168L, 42352L, 21717L, 53856L, 55632L, 91476L, 22176L, 39632L, 21970L, 19168L, 42422L, 42192L, 53840L, 119381L, 46400L, 54944L, 44450L, 38320L, 84343L, 18800L, 42160L, 46261L, 27216L, 27968L, 109396L, 11104L, 38256L, 21234L, 18800L, 25958L, 54432L, 59984L, 28309L, 23248L, 11104L, 100067L, 37600L, 116951L, 51536L, 54432L, 120998L, 46416L, 22176L, 107956L, 9680L, 37584L, 53938L, 43344L, 46423L, 27808L, 46416L, 86869L, 19872L, 42448L, 83315L, 21200L, 43432L, 59728L, 27296L, 44710L, 43856L, 19296L, 43748L, 42352L, 21088L, 62051L, 55632L, 23383L, 22176L, 38608L, 19925L, 19152L, 42192L, 54484L, 53840L, 54616L, 46400L, 46496L, 103846L, 38320L, 18864L, 43380L, 42160L, 45690L, 27216L, 27968L, 44870L, 43872L, 38256L, 19189L, 18800L, 25776L, 29859L, 59984L, 27480L, 21952L, 43872L, 38613L, 37600L, 51552L, 55636L, 54432L, 55888L, 30034L, 22176L, 43959L, 9680L, 37584L, 51893L, 43344L, 46240L, 47780L, 44368L, 21977L, 19360L, 42416L, 86390L, 21168L, 43312L, 31060L, 27296L, 44368L, 23378L, 19296L, 42726L, 42208L, 53856L, 60005L, 54576L, 23200L, 30371L, 38608L, 19415L, 19152L, 42192L, 118966L, 53840L, 54560L, 56645L, 46496L, 22224L, 21938L, 18864L, 42359L, 42160L, 43600L, 111189L, 27936L, 44448L };
    }
    
    public yn(final Context context) {
        if ("KR".equals(jp.j(context))) {
            this.f = yn.g;
            return;
        }
        this.f = yn.h;
    }
    
    public yn(final Context context, final long n, final int n2) {
        if ("KR".equals(jp.j(context))) {
            this.f = yn.g;
        }
        else {
            this.f = yn.h;
        }
        int n3;
        int a;
        int a2;
        for (n3 = (int)((n - d(n2)) / 86400000L), a = 1900, a2 = 0; a < 2050 && n3 > 0; n3 -= a2, ++a) {
            a2 = this.a(a);
        }
        if (n3 < 0) {
            n3 += a2;
            --a;
        }
        this.a = a;
        final int c = this.c(a);
        this.d = false;
        int n4 = 0;
        int n5;
        int n6;
        int n7;
        for (n5 = 1, n6 = n3; n5 < 13 && n6 > 0; ++n5, n4 = n7) {
            if (c > 0 && n5 == c + 1 && !this.d) {
                --n5;
                this.d = true;
                n7 = this.b(this.a);
            }
            else {
                n7 = this.a(this.a, n5);
            }
            n6 -= n7;
            if (this.d && n5 == c + 1) {
                this.d = false;
            }
            final boolean d = this.d;
        }
        int b;
        if (n6 == 0 && c > 0 && n5 == c + 1) {
            if (this.d) {
                this.d = false;
                b = n5;
            }
            else {
                this.d = true;
                b = n5 - 1;
            }
        }
        else {
            b = n5;
        }
        int n8;
        if (n6 < 0) {
            n8 = n6 + n4;
            --b;
        }
        else {
            n8 = n6;
        }
        this.b = b;
        this.c = n8 + 1;
    }
    
    private final int a(final int n) {
        int n2 = 348;
        for (int i = 32768; i > 8; i >>= 1) {
            if ((this.f[n - 1900] & i) != 0x0L) {
                ++n2;
            }
        }
        return n2 + this.b(n);
    }
    
    private final int a(final int n, final int n2) {
        if ((this.f[n - 1900] & 65536 >> n2) == 0x0L) {
            return 29;
        }
        return 30;
    }
    
    private final int b(final int n) {
        if (this.c(n) == 0) {
            return 0;
        }
        if ((0x10000L & this.f[n - 1900]) != 0x0L) {
            return 30;
        }
        return 29;
    }
    
    private int c(final int n) {
        return (int)(0xFL & this.f[n - 1900]);
    }
    
    private static long d(final int n) {
        if (n == 1) {
            return -2206396800000L;
        }
        try {
            final Date parse = yn.e.parse("1900\u5e741\u670831\u65e5");
            return parse.getTime();
        }
        catch (ParseException ex) {
            ex.printStackTrace();
            final Date parse = null;
            return parse.getTime();
        }
    }
    
    public final long a(final int n, final int n2, final boolean b, final int n3) {
        long d = d(n3);
        for (int i = 1900; i < n; ++i) {
            d += 86400000L * this.a(i);
        }
        final int c = this.c(n);
        long n4 = d;
        for (int j = 1; j < n2; ++j) {
            n4 += 86400000L * this.a(n, j);
            if (c > 0 && j == c) {
                n4 += 86400000L * this.b(n);
            }
        }
        if (b) {
            n4 += 86400000L * this.a(n, n2);
        }
        return n4;
    }
    
    public final long a(final Context context, final long n, final int n2) {
        final long n3 = n % 86400000L;
        final yn yn = new yn(context, n, n2);
        final int c = this.c(yn.a);
        if (c > 0 && c == yn.b && !yn.d) {
            final long n4 = this.a(yn.a, yn.b, false, n2) + 86400000L * this.a(yn.a, yn.b) + 86400000L * (-1 + yn.c);
            final yn yn2 = new yn(context, n4, n2);
            if (yn2.b == yn.b && yn2.c == yn.c && yn2.a > yn.a) {
                return n4 + n3;
            }
        }
        for (int i = 1 + yn.a; i < 2050; ++i) {
            final long n5 = this.a(i, yn.b, false, n2) + 86400000L * (-1 + yn.c);
            final yn yn3 = new yn(context, n5, n2);
            if (yn3.b == yn.b && yn3.c == yn.c && yn3.a > yn.a) {
                return n5 + n3;
            }
        }
        return 0L;
    }
    
    public final Object[] a(int i, final int n, final boolean b, final long n2) {
        final int c = this.c(i);
        boolean b2;
        int b3;
        int j;
        if (n == c && !b) {
            final int a = this.a(i, n);
            b2 = true;
            b3 = a;
            j = n;
        }
        else if (n == c && b) {
            final int n3 = n + 1;
            b3 = this.b(i);
            j = n3;
            b2 = false;
        }
        else {
            final int a2 = this.a(i, n);
            final int n4 = n + 1;
            b3 = a2;
            j = n4;
            b2 = false;
        }
        if (j > 12) {
            ++i;
            j = 1;
        }
        return new Object[] { i, j, b2, n2 + 86400000L * b3 };
    }
}
