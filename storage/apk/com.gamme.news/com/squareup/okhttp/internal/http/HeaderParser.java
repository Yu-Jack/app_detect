// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

final class HeaderParser
{
    public static void parseCacheControl(final String s, final CacheControlHandler cacheControlHandler) {
        int i = 0;
        while (i < s.length()) {
            final int beginIndex = i;
            final int skipUntil = skipUntil(s, i, "=,;");
            final String trim = s.substring(beginIndex, skipUntil).trim();
            if (skipUntil == s.length() || s.charAt(skipUntil) == ',' || s.charAt(skipUntil) == ';') {
                i = skipUntil + 1;
                cacheControlHandler.handle(trim, null);
            }
            else {
                final int skipWhitespace = skipWhitespace(s, skipUntil + 1);
                String s2;
                if (skipWhitespace < s.length() && s.charAt(skipWhitespace) == '\"') {
                    final int beginIndex2 = skipWhitespace + 1;
                    final int skipUntil2 = skipUntil(s, beginIndex2, "\"");
                    s2 = s.substring(beginIndex2, skipUntil2);
                    i = skipUntil2 + 1;
                }
                else {
                    i = skipUntil(s, skipWhitespace, ",;");
                    s2 = s.substring(skipWhitespace, i).trim();
                }
                cacheControlHandler.handle(trim, s2);
            }
        }
    }
    
    public static int parseSeconds(final String s) {
        try {
            final long long1 = Long.parseLong(s);
            if (long1 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (long1 < 0L) {
                return 0;
            }
            return (int)long1;
        }
        catch (NumberFormatException ex) {
            return -1;
        }
    }
    
    public static int skipUntil(final String s, int index, final String s2) {
        while (index < s.length() && s2.indexOf(s.charAt(index)) == -1) {
            ++index;
        }
        return index;
    }
    
    public static int skipWhitespace(final String s, int i) {
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            if (char1 != ' ' && char1 != '\t') {
                break;
            }
            ++i;
        }
        return i;
    }
    
    public interface CacheControlHandler
    {
        void handle(String p0, String p1);
    }
}
