// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import android.database.Cursor;
import android.content.ContentValues;
import android.provider.MediaStore$Images$Media;
import com.ogqcorp.bgh.activity.AdjustActivity;
import com.ogqcorp.bgh.system.o;
import com.ogqcorp.bgh.system.v;
import com.ogqcorp.bgh.system.e;
import com.ogqcorp.bgh.system.h;
import android.os.Parcelable;
import android.widget.Toast;
import com.ogqcorp.bgh.system.c;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import android.content.pm.LabeledIntent;
import android.net.Uri;
import android.os.Build$VERSION;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager;
import android.content.Context;
import com.ogqcorp.commons.u;
import java.io.File;
import com.ogqcorp.bgh.item.Background;
import android.support.v4.app.FragmentActivity;

class o extends k
{
    final /* synthetic */ n a;
    
    public o(final n a, final FragmentActivity fragmentActivity) {
        this.a = a;
        super(fragmentActivity);
    }
    
    @Override
    protected void a(final Background background, final File file, final u<File> u, final boolean b) {
        this.a.a(background, file);
    }
}
