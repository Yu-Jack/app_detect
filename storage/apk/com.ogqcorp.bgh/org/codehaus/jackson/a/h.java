// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.a;

import org.codehaus.jackson.a;
import java.io.IOException;
import org.codehaus.jackson.p;
import org.codehaus.jackson.g.l;
import org.codehaus.jackson.b.c;
import org.codehaus.jackson.q;
import java.io.Reader;

public final class h extends d
{
    protected Reader M;
    protected char[] N;
    protected q O;
    protected final org.codehaus.jackson.e.d P;
    protected boolean Q;
    
    public h(final c c, final int n, final Reader m, final q o, final org.codehaus.jackson.e.d p5) {
        super(c, n);
        this.Q = false;
        this.M = m;
        this.N = c.g();
        this.O = o;
        this.P = p5;
    }
    
    private String a(final int n, int n2, final int n3) {
        this.p.a(this.N, n, this.f - n);
        char[] array = this.p.j();
        int l = this.p.l();
    Label_0130_Outer:
        while (true) {
            if (this.f >= this.g && !this.G()) {
                this.c(": was expecting closing '" + (char)n3 + "' for name");
            }
            final char c = this.N[this.f++];
            while (true) {
                Label_0252: {
                    if (c > '\\') {
                        break Label_0252;
                    }
                    final char s;
                    if (c == '\\') {
                        s = this.S();
                    }
                    else {
                        if (c > n3) {
                            break Label_0252;
                        }
                        if (c == n3) {
                            break;
                        }
                        if (c < ' ') {
                            this.c(c, "name");
                        }
                        break Label_0252;
                    }
                    n2 = c + n2 * 31;
                    final int n4 = l + 1;
                    array[l] = s;
                    if (n4 >= array.length) {
                        array = this.p.m();
                        l = 0;
                        continue Label_0130_Outer;
                    }
                    l = n4;
                    continue Label_0130_Outer;
                }
                char s = c;
                continue;
            }
        }
        this.p.a(l);
        final l p3 = this.p;
        return this.P.a(p3.e(), p3.d(), p3.c(), n2);
    }
    
    private String a(final int n, int n2, final int[] array) {
        this.p.a(this.N, n, this.f - n);
        char[] array2 = this.p.j();
        int l = this.p.l();
        final int length = array.length;
        while (this.f < this.g || this.G()) {
            final char ch = this.N[this.f];
            if (ch <= length) {
                if (array[ch] != 0) {
                    break;
                }
            }
            else if (!Character.isJavaIdentifierPart(ch)) {
                break;
            }
            ++this.f;
            n2 = ch + n2 * 31;
            final int n3 = l + 1;
            array2[l] = ch;
            if (n3 >= array2.length) {
                array2 = this.p.m();
                l = 0;
            }
            else {
                l = n3;
            }
        }
        this.p.a(l);
        final l p3 = this.p;
        return this.P.a(p3.e(), p3.d(), p3.c(), n2);
    }
    
    private final p a(final boolean b) {
        final char[] k = this.p.k();
        int n;
        if (b) {
            k[0] = '-';
            n = 1;
        }
        else {
            n = 0;
        }
        char c;
        if (this.f < this.g) {
            c = this.N[this.f++];
        }
        else {
            c = this.e("No digit following minus sign");
        }
        if (c == '0') {
            c = this.af();
        }
        int n2 = 0;
        final char c2 = c;
        char[] m = k;
        while (true) {
            char c3 = '\0';
            int n3;
        Label_0263_Outer:
            for (c3 = c2; c3 >= '0' && c3 <= '9'; c3 = this.N[this.f++], n = n3) {
                ++n2;
                if (n >= m.length) {
                    m = this.p.m();
                    n = 0;
                }
                n3 = n + 1;
                m[n] = c3;
                if (this.f >= this.g && !this.G()) {
                    final int n4 = 1;
                    final char c4 = '\0';
                    final int n5 = n2;
                    final char[] array = m;
                    final int n6 = n3;
                    if (n5 == 0) {
                        this.b("Missing integer part (next char " + org.codehaus.jackson.a.e.d(c4) + ")");
                    }
                    char c6 = '\0';
                    int n12 = 0;
                    int n13 = 0;
                    char[] array2 = null;
                    int n15 = 0;
                    Label_0296: {
                        if (c4 == '.') {
                            final int n7 = n6 + 1;
                            array[n6] = c4;
                            char[] i = array;
                            int n8 = n7;
                            char c5 = c4;
                            int n9 = 0;
                            while (true) {
                                while (this.f < this.g || this.G()) {
                                    c5 = this.N[this.f++];
                                    int n11;
                                    if (c5 >= '0') {
                                        if (c5 <= '9') {
                                            ++n9;
                                            int n10;
                                            if (n8 >= i.length) {
                                                i = this.p.m();
                                                n10 = 0;
                                            }
                                            else {
                                                n10 = n8;
                                            }
                                            n8 = n10 + 1;
                                            i[n10] = c5;
                                            continue Label_0263_Outer;
                                        }
                                        c6 = c5;
                                        n11 = n4;
                                    }
                                    else {
                                        c6 = c5;
                                        n11 = n4;
                                    }
                                    if (n9 == 0) {
                                        this.a(c6, "Decimal point not followed by a digit");
                                    }
                                    n12 = n9;
                                    n13 = n8;
                                    final int n14 = n11;
                                    array2 = i;
                                    n15 = n14;
                                    break Label_0296;
                                }
                                c6 = c5;
                                int n11 = 1;
                                continue;
                            }
                        }
                        c6 = c4;
                        array2 = array;
                        n13 = n6;
                        n15 = n4;
                        n12 = 0;
                    }
                    int n22 = 0;
                    int n23 = 0;
                    int n24 = 0;
                    Label_0569: {
                        if (c6 == 'e' || c6 == 'E') {
                            if (n13 >= array2.length) {
                                array2 = this.p.m();
                                n13 = 0;
                            }
                            final int n16 = n13 + 1;
                            array2[n13] = c6;
                            char e;
                            if (this.f < this.g) {
                                e = this.N[this.f++];
                            }
                            else {
                                e = this.e("expected a digit for number exponent");
                            }
                            char c7;
                            int n19;
                            int n20;
                            if (e == '-' || e == '+') {
                                int n17;
                                if (n16 >= array2.length) {
                                    array2 = this.p.m();
                                    n17 = 0;
                                }
                                else {
                                    n17 = n16;
                                }
                                final int n18 = n17 + 1;
                                array2[n17] = e;
                                char e2;
                                if (this.f < this.g) {
                                    e2 = this.N[this.f++];
                                }
                                else {
                                    e2 = this.e("expected a digit for number exponent");
                                }
                                c7 = e2;
                                n19 = n18;
                                n20 = 0;
                            }
                            else {
                                c7 = e;
                                n19 = n16;
                                n20 = 0;
                            }
                            while (true) {
                                while (c7 <= '9' && c7 >= '0') {
                                    ++n20;
                                    if (n19 >= array2.length) {
                                        array2 = this.p.m();
                                        n19 = 0;
                                    }
                                    final int n21 = n19 + 1;
                                    array2[n19] = c7;
                                    if (this.f >= this.g && !this.G()) {
                                        n22 = n20;
                                        n23 = 1;
                                        n24 = n21;
                                        if (n22 == 0) {
                                            this.a(c7, "Exponent indicator not followed by a digit");
                                        }
                                        break Label_0569;
                                    }
                                    else {
                                        c7 = this.N[this.f++];
                                        n19 = n21;
                                    }
                                }
                                n22 = n20;
                                n24 = n19;
                                n23 = n15;
                                continue;
                            }
                        }
                        n24 = n13;
                        n23 = n15;
                        n22 = 0;
                    }
                    if (n23 == 0) {
                        --this.f;
                    }
                    this.p.a(n24);
                    return this.a(b, n5, n12, n22);
                }
            }
            final int n5 = n2;
            final int n6 = n;
            final char c4 = c3;
            final char[] array = m;
            final int n4 = 0;
            continue;
        }
    }
    
    private final p ae() {
        this.r = false;
        final p o = this.o;
        this.o = null;
        if (o == org.codehaus.jackson.p.d) {
            this.n = this.n.b(this.l, this.m);
        }
        else if (o == org.codehaus.jackson.p.b) {
            this.n = this.n.c(this.l, this.m);
        }
        return this.b = o;
    }
    
    private final char af() {
        char c;
        if (this.f >= this.g && !this.G()) {
            c = '0';
        }
        else {
            c = this.N[this.f];
            if (c < '0' || c > '9') {
                return '0';
            }
            if (!this.a(org.codehaus.jackson.l.g)) {
                this.b("Leading zeroes not allowed");
            }
            ++this.f;
            if (c == '0') {
                while (this.f < this.g || this.G()) {
                    c = this.N[this.f];
                    if (c < '0' || c > '9') {
                        return '0';
                    }
                    ++this.f;
                    if (c != '0') {
                        return c;
                    }
                }
            }
        }
        return c;
    }
    
    private final int ag() {
        while (this.f < this.g || this.G()) {
            final char c = this.N[this.f++];
            if (c > ' ') {
                if (c != '/') {
                    return c;
                }
                this.ai();
            }
            else {
                if (c == ' ') {
                    continue;
                }
                if (c == '\n') {
                    this.ad();
                }
                else if (c == '\r') {
                    this.ac();
                }
                else {
                    if (c == '\t') {
                        continue;
                    }
                    this.c(c);
                }
            }
        }
        throw this.a("Unexpected end-of-input within/between " + this.n.d() + " entries");
    }
    
    private final int ah() {
        while (this.f < this.g || this.G()) {
            final int n = this.N[this.f++];
            if (n > 32) {
                if (n != 47) {
                    return n;
                }
                this.ai();
            }
            else {
                if (n == 32) {
                    continue;
                }
                if (n == 10) {
                    this.ad();
                }
                else if (n == 13) {
                    this.ac();
                }
                else {
                    if (n == 9) {
                        continue;
                    }
                    this.c(n);
                }
            }
        }
        this.J();
        return -1;
    }
    
    private final void ai() {
        if (!this.a(org.codehaus.jackson.l.b)) {
            this.b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.f >= this.g && !this.G()) {
            this.c(" in a comment");
        }
        final char c = this.N[this.f++];
        if (c == '/') {
            this.ak();
            return;
        }
        if (c == '*') {
            this.aj();
            return;
        }
        this.b(c, "was expecting either '*' or '/' for a comment");
    }
    
    private final void aj() {
        while (this.f < this.g || this.G()) {
            final char c = this.N[this.f++];
            if (c <= '*') {
                if (c == '*') {
                    if (this.f >= this.g && !this.G()) {
                        break;
                    }
                    if (this.N[this.f] == '/') {
                        ++this.f;
                        return;
                    }
                    continue;
                }
                else {
                    if (c >= ' ') {
                        continue;
                    }
                    if (c == '\n') {
                        this.ad();
                    }
                    else if (c == '\r') {
                        this.ac();
                    }
                    else {
                        if (c == '\t') {
                            continue;
                        }
                        this.c(c);
                    }
                }
            }
        }
        this.c(" in a comment");
    }
    
    private final void ak() {
        while (this.f < this.g || this.G()) {
            final char c = this.N[this.f++];
            if (c < ' ') {
                if (c == '\n') {
                    this.ad();
                    break;
                }
                if (c == '\r') {
                    this.ac();
                    return;
                }
                if (c == '\t') {
                    continue;
                }
                this.c(c);
            }
        }
    }
    
    @Override
    protected final boolean G() {
        this.h += this.g;
        this.j -= this.g;
        final Reader m = this.M;
        boolean b = false;
        if (m != null) {
            final int read = this.M.read(this.N, 0, this.N.length);
            if (read > 0) {
                this.f = 0;
                this.g = read;
                b = true;
            }
            else {
                this.H();
                b = false;
                if (read == 0) {
                    throw new IOException("Reader returned 0 characters when trying to read " + this.g);
                }
            }
        }
        return b;
    }
    
    @Override
    protected void H() {
        if (this.M != null) {
            if (this.d.c() || this.a(org.codehaus.jackson.l.a)) {
                this.M.close();
            }
            this.M = null;
        }
    }
    
    @Override
    protected void I() {
        super.I();
        final char[] n = this.N;
        if (n != null) {
            this.N = null;
            this.d.a(n);
        }
    }
    
    @Override
    protected final char S() {
        int n = 0;
        if (this.f >= this.g && !this.G()) {
            this.c(" in character escape sequence");
        }
        char a = this.N[this.f++];
        switch (a) {
            default: {
                a = this.a(a);
                return a;
            }
            case 34:
            case 47:
            case 92: {
                return a;
            }
            case 98: {
                return '\b';
            }
            case 116: {
                return '\t';
            }
            case 110: {
                return '\n';
            }
            case 102: {
                return '\f';
            }
            case 114: {
                return '\r';
            }
            case 117: {
                for (int i = 0; i < 4; ++i) {
                    if (this.f >= this.g && !this.G()) {
                        this.c(" in character escape sequence");
                    }
                    final char c = this.N[this.f++];
                    final int a2 = org.codehaus.jackson.g.e.a(c);
                    if (a2 < 0) {
                        this.b(c, "expected a hex-digit for character escape sequence");
                    }
                    n = (a2 | n << 4);
                }
                return (char)n;
            }
        }
    }
    
    protected final String X() {
        int f = this.f;
        final int g = this.g;
        int n = 0;
        if (f < g) {
            final int[] a = org.codehaus.jackson.g.e.a();
            final int length = a.length;
            do {
                final char c = this.N[f];
                if (c == '\'') {
                    final int f2 = this.f;
                    this.f = f + 1;
                    return this.P.a(this.N, f2, f - f2, n);
                }
                if (c < length && a[c] != 0) {
                    break;
                }
                n = c + n * 31;
            } while (++f < g);
        }
        final int f3 = this.f;
        this.f = f;
        return this.a(f3, n, 39);
    }
    
    protected final p Y() {
        char[] array = this.p.k();
        int l = this.p.l();
        while (true) {
            if (this.f >= this.g && !this.G()) {
                this.c(": was expecting closing quote for a string value");
            }
            char s = this.N[this.f++];
            if (s <= '\\') {
                if (s == '\\') {
                    s = this.S();
                }
                else if (s <= '\'') {
                    if (s == '\'') {
                        break;
                    }
                    if (s < ' ') {
                        this.c(s, "string value");
                    }
                }
            }
            int n;
            if (l >= array.length) {
                array = this.p.m();
                n = 0;
            }
            else {
                n = l;
            }
            l = n + 1;
            array[n] = s;
        }
        this.p.a(l);
        return org.codehaus.jackson.p.h;
    }
    
    protected void Z() {
        int f = this.f;
        final int g = this.g;
        if (f < g) {
            final int[] a = org.codehaus.jackson.g.e.a();
            final int length = a.length;
            do {
                final char c = this.N[f];
                if (c < length && a[c] != 0) {
                    if (c == '\"') {
                        this.p.a(this.N, this.f, f - this.f);
                        this.f = f + 1;
                        return;
                    }
                    break;
                }
            } while (++f < g);
        }
        this.p.b(this.N, this.f, f - this.f);
        this.f = f;
        this.aa();
    }
    
    protected final String a(final p p) {
        if (p == null) {
            return null;
        }
        switch (h$1.a[p.ordinal()]) {
            default: {
                return p.a();
            }
            case 1: {
                return this.n.h();
            }
            case 2:
            case 3:
            case 4: {
                return this.p.f();
            }
        }
    }
    
    protected p a(int n, final boolean b) {
        double n2 = Double.NEGATIVE_INFINITY;
        if (n == 73) {
            if (this.f >= this.g && !this.G()) {
                this.V();
            }
            n = this.N[this.f++];
            if (n == 78) {
                String str;
                if (b) {
                    str = "-INF";
                }
                else {
                    str = "+INF";
                }
                this.a(str, 3);
                if (this.a(org.codehaus.jackson.l.h)) {
                    if (!b) {
                        n2 = Double.POSITIVE_INFINITY;
                    }
                    return this.a(str, n2);
                }
                this.d("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
            else if (n == 110) {
                String str2;
                if (b) {
                    str2 = "-Infinity";
                }
                else {
                    str2 = "+Infinity";
                }
                this.a(str2, 3);
                if (this.a(org.codehaus.jackson.l.h)) {
                    if (!b) {
                        n2 = Double.POSITIVE_INFINITY;
                    }
                    return this.a(str2, n2);
                }
                this.d("Non-standard token '" + str2 + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
        }
        this.a(n, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }
    
    @Override
    public q a() {
        return this.O;
    }
    
    protected final void a(final String s, int endIndex) {
        do {
            if (this.f >= this.g && !this.G()) {
                this.V();
            }
            if (this.N[this.f] != s.charAt(endIndex)) {
                this.a(s.substring(0, endIndex), "'null', 'true', 'false' or NaN");
            }
            ++this.f;
        } while (++endIndex < s.length());
        if (this.f < this.g || this.G()) {
            final char ch = this.N[this.f];
            if (ch >= '0' && ch != ']' && ch != '}' && Character.isJavaIdentifierPart(ch)) {
                this.a(s.substring(0, endIndex), "'null', 'true', 'false' or NaN");
            }
        }
    }
    
    protected void a(final String str, final String s) {
        final StringBuilder sb = new StringBuilder(str);
        while (this.f < this.g || this.G()) {
            final char c = this.N[this.f];
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            ++this.f;
            sb.append(c);
        }
        this.d("Unrecognized token '" + sb.toString() + "': was expecting ");
    }
    
    @Override
    public byte[] a(final a obj) {
        if (this.b != org.codehaus.jackson.p.h && (this.b != org.codehaus.jackson.p.g || this.t == null)) {
            this.d("Current token (" + this.b + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        while (true) {
            Label_0125: {
                if (!this.Q) {
                    break Label_0125;
                }
                try {
                    this.t = this.b(obj);
                    this.Q = false;
                    return this.t;
                }
                catch (IllegalArgumentException ex) {
                    throw this.a("Failed to decode VALUE_STRING as base64 (" + obj + "): " + ex.getMessage());
                }
            }
            if (this.t == null) {
                final org.codehaus.jackson.g.d k = this.K();
                this.a(this.k(), k, obj);
                this.t = k.b();
                continue;
            }
            continue;
        }
    }
    
    protected void aa() {
        char[] array = this.p.j();
        int l = this.p.l();
        while (true) {
            if (this.f >= this.g && !this.G()) {
                this.c(": was expecting closing quote for a string value");
            }
            char s = this.N[this.f++];
            if (s <= '\\') {
                if (s == '\\') {
                    s = this.S();
                }
                else if (s <= '\"') {
                    if (s == '\"') {
                        break;
                    }
                    if (s < ' ') {
                        this.c(s, "string value");
                    }
                }
            }
            int n;
            if (l >= array.length) {
                array = this.p.m();
                n = 0;
            }
            else {
                n = l;
            }
            l = n + 1;
            array[n] = s;
        }
        this.p.a(l);
    }
    
    protected void ab() {
        this.Q = false;
        int f = this.f;
        int n = this.g;
        final char[] n2 = this.N;
        int f2;
        while (true) {
            if (f >= n) {
                this.f = f;
                if (!this.G()) {
                    this.c(": was expecting closing quote for a string value");
                }
                f = this.f;
                n = this.g;
            }
            f2 = f + 1;
            final char c = n2[f];
            if (c <= '\\') {
                if (c == '\\') {
                    this.f = f2;
                    this.S();
                    f = this.f;
                    n = this.g;
                    continue;
                }
                if (c <= '\"') {
                    if (c == '\"') {
                        break;
                    }
                    if (c < ' ') {
                        this.f = f2;
                        this.c(c, "string value");
                    }
                }
            }
            f = f2;
        }
        this.f = f2;
    }
    
    protected final void ac() {
        if ((this.f < this.g || this.G()) && this.N[this.f] == '\n') {
            ++this.f;
        }
        ++this.i;
        this.j = this.f;
    }
    
    protected final void ad() {
        ++this.i;
        this.j = this.f;
    }
    
    @Override
    public p b() {
        this.C = 0;
        if (this.b == org.codehaus.jackson.p.f) {
            return this.ae();
        }
        if (this.Q) {
            this.ab();
        }
        int n = this.ah();
        if (n < 0) {
            this.close();
            return this.b = null;
        }
        this.k = this.h + this.f - 1L;
        this.l = this.i;
        this.m = -1 + (this.f - this.j);
        this.t = null;
        if (n == 93) {
            if (!this.n.a()) {
                this.a(n, '}');
            }
            this.n = this.n.i();
            return this.b = org.codehaus.jackson.p.e;
        }
        if (n == 125) {
            if (!this.n.c()) {
                this.a(n, ']');
            }
            this.n = this.n.i();
            return this.b = org.codehaus.jackson.p.c;
        }
        if (this.n.j()) {
            if (n != 44) {
                this.b(n, "was expecting comma to separate " + this.n.d() + " entries");
            }
            n = this.ag();
        }
        final boolean c = this.n.c();
        if (c) {
            this.n.a(this.f(n));
            this.b = org.codehaus.jackson.p.f;
            final int ag = this.ag();
            if (ag != 58) {
                this.b(ag, "was expecting a colon to separate field name and value");
            }
            n = this.ag();
        }
        p p = null;
        switch (n) {
            default: {
                p = this.h(n);
                break;
            }
            case 34: {
                this.Q = true;
                p = org.codehaus.jackson.p.h;
                break;
            }
            case 91: {
                if (!c) {
                    this.n = this.n.b(this.l, this.m);
                }
                p = org.codehaus.jackson.p.d;
                break;
            }
            case 123: {
                if (!c) {
                    this.n = this.n.c(this.l, this.m);
                }
                p = org.codehaus.jackson.p.b;
                break;
            }
            case 93:
            case 125: {
                this.b(n, "expected a value");
            }
            case 116: {
                this.a("true", 1);
                p = org.codehaus.jackson.p.k;
                break;
            }
            case 102: {
                this.a("false", 1);
                p = org.codehaus.jackson.p.l;
                break;
            }
            case 110: {
                this.a("null", 1);
                p = org.codehaus.jackson.p.m;
                break;
            }
            case 45:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57: {
                p = this.e(n);
                break;
            }
        }
        if (c) {
            this.o = p;
            return this.b;
        }
        return this.b = p;
    }
    
    protected byte[] b(final a a) {
        final org.codehaus.jackson.g.d k = this.K();
        while (true) {
            if (this.f >= this.g) {
                this.F();
            }
            final char c = this.N[this.f++];
            if (c > ' ') {
                int n = a.b(c);
                if (n < 0) {
                    if (c == '\"') {
                        return k.b();
                    }
                    n = this.a(a, c, 0);
                    if (n < 0) {
                        continue;
                    }
                }
                if (this.f >= this.g) {
                    this.F();
                }
                final char c2 = this.N[this.f++];
                int n2 = a.b(c2);
                if (n2 < 0) {
                    n2 = this.a(a, c2, 1);
                }
                final int n3 = n2 | n << 6;
                if (this.f >= this.g) {
                    this.F();
                }
                final char c3 = this.N[this.f++];
                int n4 = a.b(c3);
                if (n4 < 0) {
                    if (n4 != -2) {
                        if (c3 == '\"' && !a.a()) {
                            k.a(n3 >> 4);
                            return k.b();
                        }
                        n4 = this.a(a, c3, 2);
                    }
                    if (n4 == -2) {
                        if (this.f >= this.g) {
                            this.F();
                        }
                        final char c4 = this.N[this.f++];
                        if (!a.a(c4)) {
                            throw this.a(a, (int)c4, 3, "expected padding character '" + a.b() + "'");
                        }
                        k.a(n3 >> 4);
                        continue;
                    }
                }
                final int n5 = n4 | n3 << 6;
                if (this.f >= this.g) {
                    this.F();
                }
                final char c5 = this.N[this.f++];
                int n6 = a.b(c5);
                if (n6 < 0) {
                    if (n6 != -2) {
                        if (c5 == '\"' && !a.a()) {
                            k.b(n5 >> 2);
                            return k.b();
                        }
                        n6 = this.a(a, c5, 3);
                    }
                    if (n6 == -2) {
                        k.b(n5 >> 2);
                        continue;
                    }
                }
                k.c(n6 | n5 << 6);
            }
        }
    }
    
    @Override
    public void close() {
        super.close();
        this.P.b();
    }
    
    protected char e(final String s) {
        if (this.f >= this.g && !this.G()) {
            this.c(s);
        }
        return this.N[this.f++];
    }
    
    protected final p e(int n) {
        int n2 = 1;
        int n3 = 0;
        int n4;
        if (n == 45) {
            n4 = n2;
        }
        else {
            n4 = 0;
        }
        final int f = this.f;
        final int n5 = f - 1;
        final int g = this.g;
    Label_0045:
        while (true) {
            int i = 0;
            Label_0122: {
                if (n4 == 0) {
                    i = f;
                    break Label_0122;
                }
                if (f < this.g) {
                    final char[] n6 = this.N;
                    i = f + 1;
                    n = n6[f];
                    if (n > 57 || n < 48) {
                        this.f = i;
                        return this.a(n, n2 != 0);
                    }
                    break Label_0122;
                }
                int f2;
                if (n4 != 0) {
                    f2 = n5 + 1;
                }
                else {
                    f2 = n5;
                }
                this.f = f2;
                return this.a(n4 != 0);
            }
            if (n != 48) {
                while (i < this.g) {
                    final char[] n7 = this.N;
                    final int n8 = i + 1;
                    final char c = n7[i];
                    if (c < '0' || c > '9') {
                        int n13 = 0;
                        char c3 = '\0';
                        int n14 = 0;
                        Label_0253: {
                            if (c == '.') {
                                int n9 = 0;
                                int n11;
                                for (int j = n8; j < g; j = n11) {
                                    final char[] n10 = this.N;
                                    n11 = j + 1;
                                    final char c2 = n10[j];
                                    if (c2 < '0' || c2 > '9') {
                                        if (n9 == 0) {
                                            this.a(c2, "Decimal point not followed by a digit");
                                        }
                                        final int n12 = n9;
                                        n13 = n11;
                                        c3 = c2;
                                        n14 = n12;
                                        break Label_0253;
                                    }
                                    ++n9;
                                }
                                break;
                            }
                            c3 = c;
                            n13 = n8;
                            n14 = 0;
                        }
                        Label_0417: {
                            if (c3 != 'e') {
                                n3 = 0;
                                if (c3 != 'E') {
                                    break Label_0417;
                                }
                            }
                            if (n13 >= g) {
                                break;
                            }
                            final char[] n15 = this.N;
                            final int n16 = n13 + 1;
                            final char c4 = n15[n13];
                            char c5;
                            if (c4 == '-' || c4 == '+') {
                                if (n16 >= g) {
                                    break;
                                }
                                final char[] n17 = this.N;
                                n13 = n16 + 1;
                                c5 = n17[n16];
                            }
                            else {
                                c5 = c4;
                                n13 = n16;
                                n3 = 0;
                            }
                            while (c5 <= '9' && c5 >= '0') {
                                ++n3;
                                if (n13 >= g) {
                                    continue Label_0045;
                                }
                                final char[] n18 = this.N;
                                final int n19 = n13 + 1;
                                c5 = n18[n13];
                                n13 = n19;
                            }
                            if (n3 == 0) {
                                this.a(c5, "Exponent indicator not followed by a digit");
                            }
                        }
                        final int f3 = n13 - 1;
                        this.f = f3;
                        this.p.a(this.N, n5, f3 - n5);
                        return this.a(n4 != 0, n2, n14, n3);
                    }
                    ++n2;
                    i = n8;
                }
            }
            continue Label_0045;
        }
    }
    
    protected final String f(final int n) {
        if (n != 34) {
            return this.g(n);
        }
        int f = this.f;
        final int g = this.g;
        int n2 = 0;
        if (f < g) {
            final int[] a = org.codehaus.jackson.g.e.a();
            final int length = a.length;
            do {
                final char c = this.N[f];
                if (c < length && a[c] != 0) {
                    if (c == '\"') {
                        final int f2 = this.f;
                        this.f = f + 1;
                        return this.P.a(this.N, f2, f - f2, n2);
                    }
                    break;
                }
                else {
                    n2 = c + n2 * 31;
                }
            } while (++f < g);
        }
        final int f3 = this.f;
        this.f = f;
        return this.a(f3, n2, 34);
    }
    
    protected final String g(final int n) {
        if (n == 39 && this.a(org.codehaus.jackson.l.d)) {
            return this.X();
        }
        if (!this.a(org.codehaus.jackson.l.c)) {
            this.b(n, "was expecting double-quote to start field name");
        }
        final int[] c = org.codehaus.jackson.g.e.c();
        final int length = c.length;
        int javaIdentifierPart;
        if (n < length) {
            if (c[n] == 0 && (n < 48 || n > 57)) {
                javaIdentifierPart = 1;
            }
            else {
                javaIdentifierPart = 0;
            }
        }
        else {
            javaIdentifierPart = (Character.isJavaIdentifierPart((char)n) ? 1 : 0);
        }
        if (javaIdentifierPart == 0) {
            this.b(n, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int f = this.f;
        final int g = this.g;
        int n2 = 0;
        if (f < g) {
            do {
                final char ch = this.N[f];
                if (ch < length) {
                    if (c[ch] != 0) {
                        final int n3 = -1 + this.f;
                        this.f = f;
                        return this.P.a(this.N, n3, f - n3, n2);
                    }
                }
                else if (!Character.isJavaIdentifierPart(ch)) {
                    final int n4 = -1 + this.f;
                    this.f = f;
                    return this.P.a(this.N, n4, f - n4, n2);
                }
                n2 = ch + n2 * 31;
            } while (++f < g);
        }
        final int n5 = -1 + this.f;
        this.f = f;
        return this.a(n5, n2, c);
    }
    
    protected final p h(final int n) {
        switch (n) {
            case 39: {
                if (this.a(org.codehaus.jackson.l.d)) {
                    return this.Y();
                }
                break;
            }
            case 78: {
                this.a("NaN", 1);
                if (this.a(org.codehaus.jackson.l.h)) {
                    return this.a("NaN", Double.NaN);
                }
                this.d("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                break;
            }
            case 43: {
                if (this.f >= this.g && !this.G()) {
                    this.V();
                }
                return this.a(this.N[this.f++], false);
            }
        }
        this.b(n, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }
    
    @Override
    public final String k() {
        final p b = this.b;
        if (b == org.codehaus.jackson.p.h) {
            if (this.Q) {
                this.Q = false;
                this.Z();
            }
            return this.p.f();
        }
        return this.a(b);
    }
    
    @Override
    public char[] l() {
        if (this.b == null) {
            return null;
        }
        switch (h$1.a[this.b.ordinal()]) {
            default: {
                return this.b.b();
            }
            case 1: {
                if (!this.r) {
                    final String h = this.n.h();
                    final int length = h.length();
                    if (this.q == null) {
                        this.q = this.d.a(length);
                    }
                    else if (this.q.length < length) {
                        this.q = new char[length];
                    }
                    h.getChars(0, length, this.q, 0);
                    this.r = true;
                }
                return this.q;
            }
            case 2: {
                if (this.Q) {
                    this.Q = false;
                    this.Z();
                    return this.p.e();
                }
                return this.p.e();
            }
            case 3:
            case 4: {
                return this.p.e();
            }
        }
    }
    
    @Override
    public int m() {
        final p b = this.b;
        int length = 0;
        if (b != null) {
            switch (h$1.a[this.b.ordinal()]) {
                default: {
                    length = this.b.b().length;
                    break;
                }
                case 1: {
                    return this.n.h().length();
                }
                case 2: {
                    if (this.Q) {
                        this.Q = false;
                        this.Z();
                        return this.p.c();
                    }
                    return this.p.c();
                }
                case 3:
                case 4: {
                    return this.p.c();
                }
            }
        }
        return length;
    }
    
    @Override
    public int n() {
        if (this.b != null) {
            switch (h$1.a[this.b.ordinal()]) {
                case 2: {
                    if (this.Q) {
                        this.Q = false;
                        this.Z();
                        return this.p.d();
                    }
                    return this.p.d();
                }
                case 3:
                case 4: {
                    return this.p.d();
                }
            }
        }
        return 0;
    }
}
