import java.util.Iterator;
import java.util.Collections;
import android.os.SystemClock;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import android.text.TextUtils;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import android.os.Handler;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

final class fk extends gm
{
    final /* synthetic */ Context a;
    final /* synthetic */ fh b;
    
    fk(final fh b, final Context a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void a() {
        this.b.m.add(this.b.g());
        this.b.i();
        final fh b = this.b;
        final Context a = this.a;
        fh.g(b);
    }
}
