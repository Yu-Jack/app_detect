// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.database.Cursor;
import android.util.Log;
import java.io.FileNotFoundException;
import android.os.ParcelFileDescriptor;
import android.content.ContentValues;
import java.util.UUID;
import android.util.Pair;
import android.net.Uri;
import android.content.ContentProvider;

public class NativeAppCallContentProvider extends ContentProvider
{
    private static final String a;
    private final am b;
    
    static {
        a = NativeAppCallContentProvider.class.getName();
    }
    
    public NativeAppCallContentProvider() {
        this(new al());
    }
    
    private NativeAppCallContentProvider(final am b) {
        this.b = b;
    }
    
    private static Pair a(final Uri uri) {
        try {
            final String[] split = uri.getPath().substring(1).split("/");
            return new Pair((Object)UUID.fromString(split[0]), (Object)split[1]);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public int delete(final Uri uri, final String s, final String[] array) {
        return 0;
    }
    
    public String getType(final Uri uri) {
        return null;
    }
    
    public Uri insert(final Uri uri, final ContentValues contentValues) {
        return null;
    }
    
    public boolean onCreate() {
        return true;
    }
    
    public ParcelFileDescriptor openFile(final Uri uri, final String s) {
        final Pair a = a(uri);
        if (a == null) {
            throw new FileNotFoundException();
        }
        try {
            return ParcelFileDescriptor.open(this.b.a((UUID)a.first, (String)a.second), 268435456);
        }
        catch (FileNotFoundException obj) {
            Log.e(NativeAppCallContentProvider.a, "Got unexpected exception:" + obj);
            throw obj;
        }
    }
    
    public Cursor query(final Uri uri, final String[] array, final String s, final String[] array2, final String s2) {
        return null;
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        return 0;
    }
}
