// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.content;

import android.database.MatrixCursor;
import android.database.Cursor;
import android.os.ParcelFileDescriptor;
import android.content.ContentValues;
import android.webkit.MimeTypeMap;
import android.net.Uri;
import android.content.pm.ProviderInfo;
import android.os.Environment;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import android.content.Context;
import java.util.HashMap;
import java.io.File;
import android.content.ContentProvider;

public class FileProvider extends ContentProvider
{
    private static final String[] a;
    private static final File b;
    private static HashMap c;
    private a d;
    
    static {
        a = new String[] { "_display_name", "_size" };
        b = new File("/");
        FileProvider.c = new HashMap();
    }
    
    private static a a(final Context context, final String key) {
        final HashMap c = FileProvider.c;
        // monitorenter(c)
        a a = null;
        Label_0307: {
            try {
                a = FileProvider.c.get(key);
                if (a != null) {
                    break Label_0307;
                }
                try {
                    a = new b(key);
                    if (context.getPackageManager().resolveContentProvider(key, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS") == null) {
                        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
                    }
                    goto Label_0089;
                }
                catch (IOException cause) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", cause);
                }
                catch (XmlPullParserException cause2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", (Throwable)cause2);
                }
            }
            finally {}
            final String anObject;
            final String s;
            if ("files-path".equals(anObject)) {
                a(context.getFilesDir(), s);
                goto Label_0170;
            }
            if ("cache-path".equals(anObject)) {
                a(context.getCacheDir(), s);
                goto Label_0170;
            }
            if ("external-path".equals(anObject)) {
                a(Environment.getExternalStorageDirectory(), s);
                goto Label_0170;
            }
            goto Label_0170;
        }
        // monitorexit(c)
        return a;
    }
    
    private static File a(final File file, final String... array) {
        final int length = array.length;
        int i = 0;
        File parent = file;
        while (i < length) {
            final String child = array[i];
            File file2;
            if (child != null) {
                file2 = new File(parent, child);
            }
            else {
                file2 = parent;
            }
            ++i;
            parent = file2;
        }
        return parent;
    }
    
    public void attachInfo(final Context context, final ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        this.d = a(context, providerInfo.authority);
    }
    
    public int delete(final Uri uri, final String s, final String[] array) {
        if (this.d.a(uri).delete()) {
            return 1;
        }
        return 0;
    }
    
    public String getType(final Uri uri) {
        final File a = this.d.a(uri);
        final int lastIndex = a.getName().lastIndexOf(46);
        if (lastIndex >= 0) {
            final String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a.getName().substring(lastIndex + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }
    
    public Uri insert(final Uri uri, final ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }
    
    public boolean onCreate() {
        return true;
    }
    
    public ParcelFileDescriptor openFile(final Uri uri, final String str) {
        final File a = this.d.a(uri);
        int n;
        if ("r".equals(str)) {
            n = 268435456;
        }
        else if ("w".equals(str) || "wt".equals(str)) {
            n = 738197504;
        }
        else if ("wa".equals(str)) {
            n = 704643072;
        }
        else if ("rw".equals(str)) {
            n = 939524096;
        }
        else {
            if (!"rwt".equals(str)) {
                throw new IllegalArgumentException("Invalid mode: " + str);
            }
            n = 1006632960;
        }
        return ParcelFileDescriptor.open(a, n);
    }
    
    public Cursor query(final Uri uri, String[] a, final String s, final String[] array, final String s2) {
        final File a2 = this.d.a(uri);
        if (a == null) {
            a = FileProvider.a;
        }
        final String[] array2 = new String[a.length];
        final Object[] array3 = new Object[a.length];
        final int length = a.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final String s3 = a[i];
            int n2;
            if ("_display_name".equals(s3)) {
                array2[n] = "_display_name";
                n2 = n + 1;
                array3[n] = a2.getName();
            }
            else if ("_size".equals(s3)) {
                array2[n] = "_size";
                n2 = n + 1;
                array3[n] = a2.length();
            }
            else {
                n2 = n;
            }
            ++i;
            n = n2;
        }
        final String[] array4 = new String[n];
        System.arraycopy(array2, 0, array4, 0, n);
        final Object[] array5 = new Object[n];
        System.arraycopy(array3, 0, array5, 0, n);
        final MatrixCursor matrixCursor = new MatrixCursor(array4, 1);
        matrixCursor.addRow(array5);
        return (Cursor)matrixCursor;
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        throw new UnsupportedOperationException("No external updates");
    }
}
