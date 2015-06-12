// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.codehaus.jackson.b.g;
import java.text.ParseException;
import java.text.FieldPosition;
import java.util.Date;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.text.DateFormat;

public class y extends DateFormat
{
    protected static final String[] a;
    protected static final DateFormat b;
    protected static final DateFormat c;
    protected static final DateFormat d;
    protected static final DateFormat e;
    public static final y f;
    protected transient DateFormat g;
    protected transient DateFormat h;
    protected transient DateFormat i;
    protected transient DateFormat j;
    
    static {
        a = new String[] { "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd" };
        final TimeZone timeZone = TimeZone.getTimeZone("GMT");
        (b = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz")).setTimeZone(timeZone);
        (c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")).setTimeZone(timeZone);
        (d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")).setTimeZone(timeZone);
        (e = new SimpleDateFormat("yyyy-MM-dd")).setTimeZone(timeZone);
        f = new y();
    }
    
    private static final boolean b(final String s) {
        final int length = s.length();
        if (length >= 6) {
            final char char1 = s.charAt(length - 6);
            if (char1 != '+' && char1 != '-') {
                final char char2 = s.charAt(length - 5);
                if (char2 != '+' && char2 != '-') {
                    final char char3 = s.charAt(length - 3);
                    if (char3 != '+' && char3 != '-') {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    protected Date a(String str, final ParsePosition parsePosition) {
        final int length = str.length();
        final char char1 = str.charAt(length - 1);
        DateFormat dateFormat;
        if (length <= 10 && Character.isDigit(char1)) {
            dateFormat = this.j;
            if (dateFormat == null) {
                dateFormat = (DateFormat)y.e.clone();
                this.j = dateFormat;
            }
        }
        else if (char1 == 'Z') {
            dateFormat = this.i;
            if (dateFormat == null) {
                dateFormat = (DateFormat)y.d.clone();
                this.i = dateFormat;
            }
            if (str.charAt(length - 4) == ':') {
                final StringBuilder sb = new StringBuilder(str);
                sb.insert(length - 1, ".000");
                str = sb.toString();
            }
        }
        else if (b(str)) {
            final char char2 = str.charAt(length - 3);
            if (char2 == ':') {
                final StringBuilder sb2 = new StringBuilder(str);
                sb2.delete(length - 3, length - 2);
                str = sb2.toString();
            }
            else if (char2 == '+' || char2 == '-') {
                str += "00";
            }
            final int length2 = str.length();
            if (Character.isDigit(str.charAt(length2 - 9))) {
                final StringBuilder sb3 = new StringBuilder(str);
                sb3.insert(length2 - 5, ".000");
                str = sb3.toString();
            }
            dateFormat = this.h;
            if (this.h == null) {
                dateFormat = (DateFormat)y.c.clone();
                this.h = dateFormat;
            }
        }
        else {
            final StringBuilder sb4 = new StringBuilder(str);
            if (-1 + (length - str.lastIndexOf(84)) <= 8) {
                sb4.append(".000");
            }
            sb4.append('Z');
            str = sb4.toString();
            dateFormat = this.i;
            if (dateFormat == null) {
                dateFormat = (DateFormat)y.d.clone();
                this.i = dateFormat;
            }
        }
        return dateFormat.parse(str, parsePosition);
    }
    
    public y a() {
        return new y();
    }
    
    protected boolean a(final String s) {
        final int length = s.length();
        boolean b = false;
        if (length >= 5) {
            final boolean digit = Character.isDigit(s.charAt(0));
            b = false;
            if (digit) {
                final boolean digit2 = Character.isDigit(s.charAt(3));
                b = false;
                if (digit2) {
                    final char char1 = s.charAt(4);
                    b = false;
                    if (char1 == '-') {
                        b = true;
                    }
                }
            }
        }
        return b;
    }
    
    protected Date b(final String s, final ParsePosition parsePosition) {
        if (this.g == null) {
            this.g = (DateFormat)y.b.clone();
        }
        return this.g.parse(s, parsePosition);
    }
    
    @Override
    public StringBuffer format(final Date date, final StringBuffer sb, final FieldPosition fieldPosition) {
        if (this.h == null) {
            this.h = (DateFormat)y.c.clone();
        }
        return this.h.format(date, sb, fieldPosition);
    }
    
    @Override
    public Date parse(final String s) {
        final String trim = s.trim();
        final ParsePosition parsePosition = new ParsePosition(0);
        final Date parse = this.parse(trim, parsePosition);
        if (parse != null) {
            return parse;
        }
        final StringBuilder sb = new StringBuilder();
        for (final String str : y.a) {
            if (sb.length() > 0) {
                sb.append("\", \"");
            }
            else {
                sb.append('\"');
            }
            sb.append(str);
        }
        sb.append('\"');
        throw new ParseException(String.format("Can not parse date \"%s\": not compatible with any of standard forms (%s)", trim, sb.toString()), parsePosition.getErrorIndex());
    }
    
    @Override
    public Date parse(final String s, final ParsePosition parsePosition) {
        if (this.a(s)) {
            return this.a(s, parsePosition);
        }
        int length = s.length();
        while (--length >= 0) {
            final char char1 = s.charAt(length);
            if (char1 < '0' || char1 > '9') {
                break;
            }
        }
        if (length < 0 && org.codehaus.jackson.b.g.a(s, false)) {
            return new Date(Long.parseLong(s));
        }
        return this.b(s, parsePosition);
    }
}
