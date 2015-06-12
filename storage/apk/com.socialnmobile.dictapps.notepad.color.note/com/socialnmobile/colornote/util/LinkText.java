// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.util;

import android.text.style.URLSpan;
import java.util.ArrayList;
import java.util.regex.Matcher;
import com.socialnmobile.colornote.ColorNote;
import android.text.Spannable$Factory;
import android.text.SpannableStringBuilder;
import android.text.Spannable;
import android.text.util.Linkify;
import android.text.SpannableString;
import android.content.Context;
import android.text.util.Linkify$MatchFilter;
import android.text.util.Linkify$TransformFilter;
import java.util.regex.Pattern;

public final class LinkText
{
    public static final Pattern a;
    public static final Pattern b;
    public static final Pattern c;
    static final Linkify$TransformFilter d;
    static final Linkify$TransformFilter e;
    static final Linkify$MatchFilter f;
    private static final Pattern g;
    private static final Pattern h;
    private static final Pattern i;
    
    static {
        g = Pattern.compile("\\[\\[(.*?)\\]\\]|\\b[A-Z]+[a-z0-9]+[A-Z][A-Za-z0-9]+\\b");
        h = Pattern.compile("\\[\\[(.*?)\\]\\]");
        i = Pattern.compile("\\[http[s]*://(.+?) (.+?)\\]");
        a = Pattern.compile("(\\+[0-9]+[\\- ]*)?(\\([0-9]+\\)[\\- ]*)?([0-9][0-9\\-][0-9\\-]+[0-9])");
        b = Pattern.compile("(\\+[0-9]+[ \\. ]*)?(\\([0-9]+\\)[ \\.]*)?([0-9][0-9\\.][0-9\\.]+[0-9])");
        c = Pattern.compile("(\\+[0-9]+[ ]*)?(\\([0-9]+\\)[ ]*)?([0-9][0-9 ][0-9 ]+[0-9])");
        d = (Linkify$TransformFilter)new yj();
        e = (Linkify$TransformFilter)new yk();
        f = (Linkify$MatchFilter)new yl();
    }
    
    public static SpannableString a(final Context context, final boolean b, final String s) {
        final int intValue = Integer.valueOf(jp.a(context, "pref_autolink_phone_type", context.getString(2131230726)));
        while (true) {
            while (true) {
                Label_0049: {
                    if (b) {
                        final String s2 = String.valueOf(kf.e.toString()) + "/";
                        break Label_0049;
                    }
                Label_0084:
                    while (true) {
                        SpannableString spannableString = null;
                        Block_3: {
                            Label_0288: {
                                break Label_0288;
                                while (true) {
                                    String s2 = null;
                                    int n = 0;
                                    int n2 = 0;
                                    int n3;
                                    SpannableStringBuilder spannableStringBuilder = null;
                                    Matcher matcher = null;
                                    int n4;
                                    int n5;
                                    int n6;
                                    SpannableStringBuilder spannableStringBuilder2 = null;
                                    Matcher matcher2 = null;
                                    int n7;
                                    int start;
                                    int end;
                                    String group;
                                    Label_0172_Outer:Label_0202_Outer:
                                    while (true) {
                                        Label_0691: {
                                            while (true) {
                                                Label_0684: {
                                                    while (true) {
                                                        Label_0674: {
                                                            while (true) {
                                                            Label_0605:
                                                                while (true) {
                                                                    Label_0566: {
                                                                        Label_0540: {
                                                                            try {
                                                                                if (!Linkify.addLinks((Spannable)spannableString, 15)) {
                                                                                    break Label_0172_Outer;
                                                                                }
                                                                                n = 1;
                                                                                if (jp.a(context, "pref_use_note_link", context.getResources().getBoolean(2131296263))) {
                                                                                    if (!jp.a(context, "pref_autolink_wiki_word", context.getResources().getBoolean(2131296264))) {
                                                                                        break Label_0540;
                                                                                    }
                                                                                    if (!Linkify.addLinks((Spannable)spannableString, LinkText.g, s2, (Linkify$MatchFilter)null, LinkText.d)) {
                                                                                        break Label_0691;
                                                                                    }
                                                                                    n2 = 1;
                                                                                    n3 = 1;
                                                                                    if (n3 == 0) {
                                                                                        break Label_0684;
                                                                                    }
                                                                                    spannableStringBuilder = new SpannableStringBuilder((CharSequence)spannableString);
                                                                                    matcher = LinkText.h.matcher((CharSequence)spannableStringBuilder);
                                                                                    n4 = 0;
                                                                                    if (matcher.find()) {
                                                                                        break Label_0566;
                                                                                    }
                                                                                    if (n4 == 0) {
                                                                                        break Label_0684;
                                                                                    }
                                                                                    spannableString = (SpannableString)Spannable$Factory.getInstance().newSpannable((CharSequence)spannableStringBuilder);
                                                                                    n = n2;
                                                                                }
                                                                                if (!Linkify.addLinks((Spannable)spannableString, LinkText.i, "", (Linkify$MatchFilter)null, LinkText.e)) {
                                                                                    break Label_0674;
                                                                                }
                                                                                n5 = 1;
                                                                                n6 = 1;
                                                                                if (n6 != 0) {
                                                                                    spannableStringBuilder2 = new SpannableStringBuilder((CharSequence)spannableString);
                                                                                    matcher2 = LinkText.i.matcher((CharSequence)spannableStringBuilder2);
                                                                                    n7 = 0;
                                                                                    if (matcher2.find()) {
                                                                                        break Label_0605;
                                                                                    }
                                                                                    if (n7 != 0) {
                                                                                        spannableString = (SpannableString)Spannable$Factory.getInstance().newSpannable((CharSequence)spannableStringBuilder2);
                                                                                    }
                                                                                }
                                                                                if (n5 != 0) {
                                                                                    return spannableString;
                                                                                }
                                                                                break;
                                                                                s2 = String.valueOf(kf.b.toString()) + "/";
                                                                                break Label_0049;
                                                                            }
                                                                            catch (RuntimeException ex) {
                                                                                ColorNote.a("addLinks RuntimeError");
                                                                                try {
                                                                                    spannableString = (SpannableString)Spannable$Factory.getInstance().newSpannable((CharSequence)s);
                                                                                    if (!Linkify.addLinks((Spannable)spannableString, 7)) {
                                                                                        break Label_0172_Outer;
                                                                                    }
                                                                                    n = 1;
                                                                                }
                                                                                catch (RuntimeException ex2) {
                                                                                    n = 0;
                                                                                }
                                                                                continue Label_0084;
                                                                            }
                                                                            break Block_3;
                                                                        }
                                                                        if (Linkify.addLinks((Spannable)spannableString, LinkText.h, s2, (Linkify$MatchFilter)null, LinkText.d)) {
                                                                            n2 = 1;
                                                                            n3 = 1;
                                                                            continue Label_0172_Outer;
                                                                        }
                                                                        break Label_0691;
                                                                    }
                                                                    spannableStringBuilder.replace(matcher.start(), matcher.end(), (CharSequence)a(matcher.group(0)));
                                                                    matcher.reset((CharSequence)spannableStringBuilder);
                                                                    n4 = 1;
                                                                    continue Label_0202_Outer;
                                                                }
                                                                start = matcher2.start();
                                                                end = matcher2.end();
                                                                group = matcher2.group(0);
                                                                spannableStringBuilder2.replace(start, end, (CharSequence)group.substring(1 + group.indexOf(32), -1 + group.length()));
                                                                matcher2.reset((CharSequence)spannableStringBuilder2);
                                                                n7 = 1;
                                                                continue;
                                                            }
                                                        }
                                                        n5 = n;
                                                        n6 = 0;
                                                        continue;
                                                    }
                                                }
                                                n = n2;
                                                continue;
                                            }
                                        }
                                        n2 = n;
                                        n3 = 0;
                                        continue;
                                    }
                                    n = 0;
                                    continue Label_0084;
                                }
                            }
                            return null;
                        }
                        Label_0515: {
                        Label_0490:
                            while (true) {
                                while (true) {
                                    try {
                                        if (Linkify.addLinks((Spannable)spannableString, 11)) {
                                            int n = 1;
                                            if (intValue == 0) {
                                                continue Label_0084;
                                            }
                                            switch (intValue) {
                                                default: {
                                                    continue Label_0084;
                                                }
                                                case 1: {
                                                    if (Linkify.addLinks((Spannable)spannableString, LinkText.a, "tel:", LinkText.f, Linkify.sPhoneNumberTransformFilter)) {
                                                        n = 1;
                                                        continue Label_0084;
                                                    }
                                                    continue Label_0084;
                                                }
                                                case 2: {
                                                    break Label_0490;
                                                }
                                                case 4: {
                                                    break Label_0515;
                                                }
                                            }
                                        }
                                    }
                                    catch (RuntimeException ex3) {
                                        ColorNote.a("addLinks RuntimeError");
                                        try {
                                            spannableString = (SpannableString)Spannable$Factory.getInstance().newSpannable((CharSequence)s);
                                            if (Linkify.addLinks((Spannable)spannableString, 3)) {
                                                final int n = 1;
                                                continue;
                                            }
                                        }
                                        catch (RuntimeException ex4) {}
                                    }
                                    int n = 0;
                                    continue;
                                }
                            }
                            if (Linkify.addLinks((Spannable)spannableString, LinkText.b, "tel:", LinkText.f, Linkify.sPhoneNumberTransformFilter)) {
                                final int n = 1;
                                continue Label_0084;
                            }
                            continue Label_0084;
                        }
                        if (Linkify.addLinks((Spannable)spannableString, LinkText.c, "tel:", LinkText.f, Linkify.sPhoneNumberTransformFilter)) {
                            final int n = 1;
                            continue Label_0084;
                        }
                        continue Label_0084;
                    }
                }
                SpannableString spannableString = (SpannableString)Spannable$Factory.getInstance().newSpannable((CharSequence)s);
                if (intValue == 7) {
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    public static String a(final String s) {
        return s.substring(2, -2 + s.length());
    }
    
    public static ArrayList a(final SpannableString spannableString) {
        final URLSpan[] array = (URLSpan[])spannableString.getSpans(0, -1 + spannableString.length(), (Class)URLSpan.class);
        final ArrayList<ym> list = new ArrayList<ym>();
        for (final URLSpan urlSpan : array) {
            final ym e = new ym();
            e.b = urlSpan.getURL();
            e.c = spannableString.subSequence(spannableString.getSpanStart((Object)urlSpan), spannableString.getSpanEnd((Object)urlSpan)).toString();
            final String b = e.b;
            int a;
            if (b.startsWith("tel:")) {
                a = 1;
            }
            else if (b.startsWith("geo:")) {
                a = 4;
            }
            else if (b.startsWith("mailto:")) {
                a = 3;
            }
            else if (b.startsWith("http") || b.startsWith("rstp")) {
                a = 2;
            }
            else if (b.startsWith("content://note")) {
                a = 5;
            }
            else {
                a = 0;
            }
            e.a = a;
            list.add(e);
        }
        return list;
    }
    
    public static void a(final Spannable spannable) {
        for (final URLSpan urlSpan : (URLSpan[])spannable.getSpans(0, spannable.length(), (Class)URLSpan.class)) {
            final int spanStart = spannable.getSpanStart((Object)urlSpan);
            final int spanEnd = spannable.getSpanEnd((Object)urlSpan);
            spannable.removeSpan((Object)urlSpan);
            spannable.setSpan((Object)new LinkText$URLSpanNoUnderline(urlSpan.getURL()), spanStart, spanEnd, 0);
        }
    }
}
