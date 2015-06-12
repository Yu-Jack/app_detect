// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import android.os.Bundle;
import com.facebook.bq;
import android.text.TextUtils;
import java.util.Collection;
import com.facebook.bm;
import android.content.pm.ResolveInfo;
import android.content.Intent;
import android.database.Cursor;
import android.content.ContentResolver;
import java.util.HashSet;
import android.net.Uri;
import java.util.Iterator;
import android.content.Context;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public final class w
{
    private static final z a;
    private static List b;
    private static Map c;
    private static final List d;
    
    static {
        a = new x((byte)0);
        final ArrayList<aa> b = new ArrayList<aa>();
        b.add((aa)w.a);
        b.add(new aa((byte)0));
        w.b = b;
        final HashMap<String, ArrayList<y>> c = new HashMap<String, ArrayList<y>>();
        final ArrayList<y> list = new ArrayList<y>();
        list.add(new y((byte)0));
        c.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", (ArrayList<y>)w.b);
        c.put("com.facebook.platform.action.request.FEED_DIALOG", (ArrayList<y>)w.b);
        c.put("com.facebook.platform.action.request.MESSAGE_DIALOG", list);
        c.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", list);
        w.c = c;
        d = Arrays.asList(20140701, 20140324, 20140204, 20131107, 20130618, 20130502, 20121101);
    }
    
    public static int a(final Context context, final int n) {
        final List b = w.b;
        if (b == null) {
            return -1;
        }
        final Iterator<z> iterator = b.iterator();
        while (iterator.hasNext()) {
            final int a = a(context, iterator.next(), n);
            if (a != -1) {
                return a;
            }
        }
        return -1;
    }
    
    private static int a(final Context context, final z z, final int n) {
        final ContentResolver contentResolver = context.getContentResolver();
        final String[] array = { "version" };
        final Uri parse = Uri.parse("content://" + z.a() + ".provider.PlatformProvider/versions");
    Label_0174:
        while (true) {
            try {
                final Cursor query = contentResolver.query(parse, array, (String)null, (String[])null, (String)null);
                int intValue;
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    intValue = -1;
                }
                else {
                    while (true) {
                        Integer n2;
                        while (true) {
                            HashSet<Integer> set = null;
                            Iterator<Integer> iterator = null;
                            Label_0189: {
                                try {
                                    set = new HashSet<Integer>();
                                    while (query.moveToNext()) {
                                        set.add(query.getInt(query.getColumnIndex("version")));
                                    }
                                    iterator = (Iterator<Integer>)w.d.iterator();
                                    if (!iterator.hasNext()) {
                                        if (query != null) {
                                            query.close();
                                        }
                                        return -1;
                                    }
                                    break Label_0189;
                                }
                                finally {}
                                break Label_0174;
                            }
                            n2 = iterator.next();
                            if (n2 < n) {
                                if (query != null) {
                                    query.close();
                                }
                                return -1;
                            }
                            if (!set.contains(n2)) {
                                continue;
                            }
                            break;
                        }
                        intValue = n2;
                        if (query != null) {
                            query.close();
                            return intValue;
                        }
                        break;
                        if (query != null) {
                            query.close();
                        }
                        throw;
                    }
                }
                return intValue;
            }
            finally {
                final Cursor query = null;
                continue Label_0174;
            }
            break;
        }
    }
    
    public static Intent a(final Context context) {
        final Iterator<z> iterator = w.b.iterator();
        while (iterator.hasNext()) {
            final Intent a = a(context, new Intent().setClassName(iterator.next().a(), "com.facebook.katana.platform.TokenRefreshService"));
            if (a != null) {
                return a;
            }
        }
        return null;
    }
    
    private static Intent a(final Context context, Intent intent) {
        if (intent == null) {
            intent = null;
        }
        else {
            final ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService == null) {
                return null;
            }
            if (!z.a(context, resolveService.serviceInfo.packageName)) {
                return null;
            }
        }
        return intent;
    }
    
    public static Intent a(final Context context, final String s, final List list, final String s2, final boolean b, final bm bm) {
        final Iterator<z> iterator = w.b.iterator();
        while (iterator.hasNext()) {
            Intent putExtra = new Intent().setClassName(iterator.next().a(), "com.facebook.katana.ProxyAuth").putExtra("client_id", s);
            if (!aj.a(list)) {
                putExtra.putExtra("scope", TextUtils.join((CharSequence)",", (Iterable)list));
            }
            if (!aj.a(s2)) {
                putExtra.putExtra("e2e", s2);
            }
            putExtra.putExtra("response_type", "token");
            putExtra.putExtra("return_scopes", "true");
            putExtra.putExtra("default_audience", bm.a());
            if (!bq.g()) {
                putExtra.putExtra("legacy_override", "v2.1");
                if (b) {
                    putExtra.putExtra("auth_type", "rerequest");
                }
            }
            if (putExtra == null) {
                putExtra = null;
            }
            else {
                final ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(putExtra, 0);
                if (resolveActivity == null) {
                    putExtra = null;
                }
                else if (!z.a(context, resolveActivity.activityInfo.packageName)) {
                    putExtra = null;
                }
            }
            if (putExtra != null) {
                return putExtra;
            }
        }
        return null;
    }
    
    public static boolean a(final Intent intent) {
        final int intExtra = intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
        final boolean contains = w.d.contains(intExtra);
        boolean b = false;
        if (contains) {
            b = false;
            if (intExtra >= 20140701) {
                b = true;
            }
        }
        Bundle bundleExtra;
        if (!b) {
            bundleExtra = null;
        }
        else {
            bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
        }
        if (bundleExtra != null) {
            return bundleExtra.containsKey("error");
        }
        return intent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
    }
    
    public static Intent b(final Context context) {
        final Iterator<z> iterator = w.b.iterator();
        while (iterator.hasNext()) {
            final Intent a = a(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(iterator.next().a()).addCategory("android.intent.category.DEFAULT"));
            if (a != null) {
                return a;
            }
        }
        return null;
    }
}
