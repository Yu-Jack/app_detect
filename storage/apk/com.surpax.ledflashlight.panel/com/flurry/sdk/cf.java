// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import android.net.Uri;
import org.apache.http.client.utils.URIUtils;
import java.net.URISyntaxException;
import java.net.URI;
import android.text.TextUtils;
import java.util.regex.Pattern;

public class cf
{
    private static final Pattern a;
    
    static {
        a = Pattern.compile("/");
    }
    
    public static String a(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            final URI f = f(s);
            if (f != null) {
                return f.toString();
            }
        }
        return null;
    }
    
    public static String a(final String s, final String s2) {
        if (!TextUtils.isEmpty((CharSequence)s) && !TextUtils.isEmpty((CharSequence)s2)) {
            final URI f = f(s);
            if (f != null) {
                final URI normalize = f.normalize();
                final URI f2 = f(s2);
                if (f2 != null) {
                    final URI normalize2 = f2.normalize();
                    if (!normalize.isOpaque() && !normalize2.isOpaque()) {
                        final String scheme = normalize.getScheme();
                        final String scheme2 = normalize2.getScheme();
                        if ((scheme2 != null || scheme == null) && (scheme2 == null || scheme2.equals(scheme))) {
                            final String authority = normalize.getAuthority();
                            final String authority2 = normalize2.getAuthority();
                            if ((authority2 != null || authority == null) && (authority2 == null || authority2.equals(authority))) {
                                final String path = normalize.getPath();
                                final String path2 = normalize2.getPath();
                                String[] split;
                                String[] split2;
                                int length;
                                int length2;
                                int i;
                                for (split = cf.a.split(path, -1), split2 = cf.a.split(path2, -1), length = split.length, length2 = split2.length, i = 0; i < length2 && i < length && split[i].equals(split2[i]); ++i) {}
                                String query = normalize.getQuery();
                                String fragment = normalize.getFragment();
                                final StringBuilder sb = new StringBuilder();
                                if (i == length2 && i == length) {
                                    final String query2 = normalize2.getQuery();
                                    final String fragment2 = normalize2.getFragment();
                                    final boolean equals = TextUtils.equals((CharSequence)query, (CharSequence)query2);
                                    final boolean equals2 = TextUtils.equals((CharSequence)fragment, (CharSequence)fragment2);
                                    if (equals && equals2) {
                                        fragment = null;
                                        query = null;
                                    }
                                    else {
                                        String s3;
                                        if (equals && !TextUtils.isEmpty((CharSequence)fragment)) {
                                            s3 = null;
                                        }
                                        else {
                                            s3 = query;
                                        }
                                        String s4;
                                        if (TextUtils.isEmpty((CharSequence)s3) && TextUtils.isEmpty((CharSequence)fragment)) {
                                            sb.append(split[length - 1]);
                                            s4 = fragment;
                                        }
                                        else {
                                            query = s3;
                                            s4 = fragment;
                                        }
                                        fragment = s4;
                                    }
                                }
                                else {
                                    final int n = length - 1;
                                    for (int n2 = length2 - 1, j = i; j < n2; ++j) {
                                        sb.append("..");
                                        sb.append("/");
                                    }
                                    while (i < n) {
                                        sb.append(split[i]);
                                        sb.append("/");
                                        ++i;
                                    }
                                    if (i < length) {
                                        sb.append(split[i]);
                                    }
                                    if (sb.length() == 0) {
                                        sb.append(".");
                                        sb.append("/");
                                    }
                                }
                                final URI a = a(null, null, sb.toString(), query, fragment);
                                if (a != null) {
                                    return a.toString();
                                }
                            }
                        }
                    }
                }
            }
        }
        return s;
    }
    
    private static URI a(final String s, final String authority, final String path, final String query, final String fragment) {
        try {
            String lowerCase;
            if (TextUtils.isEmpty((CharSequence)s)) {
                lowerCase = s;
            }
            else {
                lowerCase = s.toLowerCase();
            }
            return new URI(lowerCase, authority, path, query, fragment);
        }
        catch (URISyntaxException ex) {
            return null;
        }
    }
    
    public static String b(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            final URI f = f(s);
            if (f != null) {
                final URI normalize = f.normalize();
                if (!normalize.isOpaque()) {
                    final URI a = a(normalize.getScheme(), normalize.getAuthority(), "/", null, null);
                    if (a != null) {
                        return a.toString();
                    }
                }
            }
        }
        return s;
    }
    
    public static String c(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            final URI f = f(s);
            if (f != null) {
                final URI normalize = f.normalize();
                if (!normalize.isOpaque()) {
                    final URI resolve = URIUtils.resolve(normalize, "./");
                    if (resolve != null) {
                        return resolve.toString();
                    }
                }
            }
        }
        return s;
    }
    
    public static boolean d(final String s) {
        final boolean empty = TextUtils.isEmpty((CharSequence)s);
        boolean b = false;
        if (!empty) {
            final Uri parse = Uri.parse(s);
            final String scheme = parse.getScheme();
            b = false;
            if (scheme != null) {
                final boolean equals = parse.getScheme().equals("market");
                b = false;
                if (equals) {
                    b = true;
                }
            }
        }
        return b;
    }
    
    public static boolean e(final String s) {
        final boolean empty = TextUtils.isEmpty((CharSequence)s);
        boolean b = false;
        if (!empty) {
            final Uri parse = Uri.parse(s);
            final String host = parse.getHost();
            b = false;
            if (host != null) {
                final boolean equals = parse.getHost().equals("play.google.com");
                b = false;
                if (equals) {
                    final String scheme = parse.getScheme();
                    b = false;
                    if (scheme != null) {
                        final boolean startsWith = parse.getScheme().startsWith("http");
                        b = false;
                        if (startsWith) {
                            b = true;
                        }
                    }
                }
            }
        }
        return b;
    }
    
    private static URI f(final String str) {
        URI uri;
        try {
            final URI uri2;
            uri = (uri2 = new URI(str));
            final String s = uri2.getScheme();
            final URI uri3 = uri;
            final String s2 = uri3.getAuthority();
            final URI uri4 = uri;
            final String s3 = uri4.getPath();
            final URI uri5 = uri;
            final String s4 = uri5.getQuery();
            final URI uri6 = uri;
            final String s5 = uri6.getFragment();
            final URI a = a(s, s2, s3, s4, s5);
            return a;
        }
        catch (URISyntaxException ex) {
            return null;
        }
        try {
            final URI uri2 = uri;
            final String s = uri2.getScheme();
            final URI uri3 = uri;
            final String s2 = uri3.getAuthority();
            final URI uri4 = uri;
            final String s3 = uri4.getPath();
            final URI uri5 = uri;
            final String s4 = uri5.getQuery();
            final URI uri6 = uri;
            final String s5 = uri6.getFragment();
            final URI a2;
            final URI a = a2 = a(s, s2, s3, s4, s5);
            return a2;
        }
        catch (URISyntaxException ex2) {
            return uri;
        }
    }
}
