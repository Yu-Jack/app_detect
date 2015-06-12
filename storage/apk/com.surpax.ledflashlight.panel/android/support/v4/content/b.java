// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.content;

import android.text.TextUtils;
import java.io.IOException;
import java.io.File;
import android.net.Uri;
import java.util.HashMap;

final class b implements a
{
    private final String a;
    private final HashMap b;
    
    public b(final String a) {
        this.b = new HashMap();
        this.a = a;
    }
    
    @Override
    public final File a(final Uri obj) {
        final String encodedPath = obj.getEncodedPath();
        final int index = encodedPath.indexOf(47, 1);
        final String decode = Uri.decode(encodedPath.substring(1, index));
        final String decode2 = Uri.decode(encodedPath.substring(index + 1));
        final File parent = this.b.get(decode);
        if (parent == null) {
            throw new IllegalArgumentException("Unable to find configured root for " + obj);
        }
        final File obj2 = new File(parent, decode2);
        File canonicalFile;
        try {
            canonicalFile = obj2.getCanonicalFile();
            if (!canonicalFile.getPath().startsWith(parent.getPath())) {
                throw new SecurityException("Resolved path jumped beyond configured root");
            }
        }
        catch (IOException ex) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + obj2);
        }
        return canonicalFile;
    }
    
    public final void a(final String key, final File obj) {
        if (TextUtils.isEmpty((CharSequence)key)) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        try {
            this.b.put(key, obj.getCanonicalFile());
        }
        catch (IOException cause) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + obj, cause);
        }
    }
}
