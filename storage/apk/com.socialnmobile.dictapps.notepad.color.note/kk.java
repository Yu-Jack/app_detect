import java.util.Iterator;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.data;

import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;
import android.database.SQLException;
import java.util.UUID;
import android.database.ContentObserver;
import android.os.Process;
import android.os.Binder;
import android.content.ContentUris;
import android.content.Context;
import android.database.MatrixCursor;
import android.database.Cursor;
import java.util.Collection;
import java.util.Arrays;
import android.text.TextUtils;
import java.util.Map;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Handler;
import java.util.ArrayList;
import android.content.UriMatcher;
import java.util.HashMap;
import android.content.ContentProvider;

public final class kk implements Runnable
{
    final /* synthetic */ NoteProvider a;
    
    public kk(final NoteProvider a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        synchronized (NoteProvider.a(this.a)) {
            final Iterator<km> iterator = NoteProvider.a(this.a).iterator();
            while (iterator.hasNext()) {
                iterator.next().a();
            }
        }
    }
}
