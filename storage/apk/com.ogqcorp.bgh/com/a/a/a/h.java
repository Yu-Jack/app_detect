// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a.a;

import java.util.Map;
import com.a.a.c;
import com.a.a.k;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class h
{
    public static long a(final String s) {
        try {
            return DateUtils.parseDate(s).getTime();
        }
        catch (DateParseException ex) {
            return 0L;
        }
    }
    
    public static c a(final k k) {
        final long currentTimeMillis = System.currentTimeMillis();
        final Map<String, String> c = k.c;
        long a = 0L;
        long a2 = 0L;
        long long1 = 0L;
        final String s = c.get("Date");
        if (s != null) {
            a = a(s);
        }
        final String s2 = c.get("Cache-Control");
        boolean b = false;
        while (true) {
            while (true) {
                String[] split = null;
                int n = 0;
                while (true) {
                    Label_0079: {
                        if (s2 != null) {
                            b = true;
                            split = s2.split(",");
                            n = 0;
                            break Label_0079;
                        }
                        break Label_0177;
                    Label_0238_Outer:
                        while (true) {
                        Label_0238:
                            while (true) {
                                final String trim;
                                c c2;
                                String b2;
                                long e;
                                long n2;
                                boolean b3;
                                String s3;
                                Block_9_Outer:Label_0171_Outer:Block_8_Outer:
                                while (true) {
                                    try {
                                        long1 = Long.parseLong(trim.substring(8));
                                        ++n;
                                        break;
                                        c2 = new c();
                                        c2.a = k.b;
                                        c2.b = b2;
                                        c2.e = e;
                                        c2.d = c2.e;
                                        c2.c = a;
                                        c2.f = c;
                                        return c2;
                                        // iftrue(Label_0328:, a <= 0L || a2 < a)
                                        while (true) {
                                            e = currentTimeMillis + (a2 - a);
                                            continue Label_0238;
                                            Label_0296: {
                                                continue Block_9_Outer;
                                            }
                                        }
                                        // iftrue(Label_0296:, !b3)
                                        // iftrue(Label_0145:, !trim.equals((Object)"must-revalidate") && !trim.equals((Object)"proxy-revalidate"))
                                        while (true) {
                                        Label_0210_Outer:
                                            while (true) {
                                                while (true) {
                                                    while (true) {
                                                        e = currentTimeMillis + n2 * 1000L;
                                                        continue Label_0238;
                                                        long1 = 0L;
                                                        continue Label_0238_Outer;
                                                        b2 = c.get("ETag");
                                                        continue Label_0171_Outer;
                                                    }
                                                    a2 = a(s3);
                                                    continue Block_8_Outer;
                                                }
                                                continue Label_0210_Outer;
                                            }
                                            b3 = b;
                                            n2 = long1;
                                            s3 = c.get("Expires");
                                            continue;
                                        }
                                    }
                                    // iftrue(Label_0210:, s3 == null)
                                    catch (Exception ex) {
                                        continue Label_0238_Outer;
                                    }
                                    break;
                                }
                                Label_0328: {
                                    e = 0L;
                                }
                                continue Label_0238;
                            }
                        }
                    }
                    if (n >= split.length) {
                        continue;
                    }
                    break;
                }
                final String trim = split[n].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    public static String a(final Map<String, String> map) {
        final String s = map.get("Content-Type");
        if (s != null) {
            final String[] split = s.split(";");
            for (int i = 1; i < split.length; ++i) {
                final String[] split2 = split[i].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return "ISO-8859-1";
    }
}
