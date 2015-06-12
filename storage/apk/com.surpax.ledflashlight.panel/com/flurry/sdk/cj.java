// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cj
{
    public static int a(final String input) {
        if (input != null) {
            final Matcher matcher = Pattern.compile("<VAST version=\"(.+?)\">").matcher(input);
            if (matcher.find() && matcher.groupCount() == 1) {
                try {
                    final int round = Math.round(Float.parseFloat(matcher.group(1)));
                    if (round > 0 && round <= 3) {
                        return round;
                    }
                    return 0;
                }
                catch (NumberFormatException ex) {
                    return 0;
                }
            }
            return 0;
        }
        return 0;
    }
    
    static cv a(final List list) {
        cv cv;
        if (list != null) {
            final Iterator<cv> iterator = list.iterator();
            cv = null;
        Label_0100_Outer:
            while (iterator.hasNext()) {
                cv cv2 = iterator.next();
                while (true) {
                    Label_0109: {
                        if (cv2.b() > 500 || cv2.a() == null || ((cv2.c() == null || !cv2.c().equalsIgnoreCase("video/mp4")) && !cv2.a().endsWith("mp4"))) {
                            break Label_0109;
                        }
                        if (cv == null) {
                            cv = cv2;
                            continue Label_0100_Outer;
                        }
                        if (cv.b() >= cv2.b()) {
                            break Label_0109;
                        }
                        cv = cv2;
                        continue Label_0100_Outer;
                    }
                    cv2 = cv;
                    continue;
                }
            }
        }
        else {
            cv = null;
        }
        return cv;
    }
    
    static int b(final String input) {
        int n = 0;
        if (input == null) {
            return n;
        }
        final Matcher matcher = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})").matcher(input);
        final boolean find = matcher.find();
        n = 0;
        if (!find) {
            return n;
        }
        final int groupCount = matcher.groupCount();
        n = 0;
        if (groupCount != 3) {
            return n;
        }
        try {
            n = Integer.parseInt(matcher.group(3)) + (60 * (Integer.parseInt(matcher.group(1)) * 60) + Integer.parseInt(matcher.group(2)) * 60);
            return n;
        }
        catch (NumberFormatException ex) {
            return 0;
        }
    }
}
