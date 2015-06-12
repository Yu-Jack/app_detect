import java.io.RandomAccessFile;
import java.util.UUID;
import java.io.FileOutputStream;
import java.io.IOException;
import com.socialnmobile.colornote.ColorNote;
import android.os.Environment;
import java.util.Locale;
import java.util.Scanner;
import android.text.TextUtils;
import java.util.ArrayList;
import java.io.File;

// 
// Decompiled by Procyon v0.5.29
// 

public final class jl
{
    static String[] a;
    static String[] b;
    private static String c;
    
    static {
        jl.c = null;
        jl.a = new String[] { "/storage/extSdCard", "/mnt/ext_card", "/mnt/sdcard2", "/mnt/external1", "/mnt/sdcard-ext", "/storage/external_SD", "/storage/ext_sd", "/storage/removable/sdcard1", "/mnt/extSdCard", "/mnt/sdextcard" };
        jl.b = new String[] { "/mnt/sdcard/external_sd", "/mnt/sdcard/ext_sd", "/mnt/sdcard/_ExternalSD" };
    }
    
    public static final String a() {
        int i = 0;
        for (final String c : jl.a) {
            final File file = new File(c);
            if (file.exists() && file.canWrite() && file.isDirectory()) {
                return c;
            }
        }
        String c = c();
        if (c != null) {
            final File file2 = new File(c);
            if (file2.exists() && file2.canWrite() && file2.isDirectory()) {
                return c;
            }
        }
        for (String[] b = jl.b; i < b.length; ++i) {
            c = b[i];
            final File file3 = new File(c);
            if (file3.exists() && file3.canWrite() && file3.isDirectory()) {
                return c;
            }
        }
        return null;
    }
    
    public static String b() {
        if (jl.c != null) {
            return jl.c;
        }
        return jl.c = d();
    }
    
    private static final String c() {
        String pathname = null;
    Label_0451_Outer:
        while (true) {
            final ArrayList<String> list = new ArrayList<String>();
            final ArrayList list2 = new ArrayList();
            String getenv;
            String[] split;
            int length;
            int n;
            Scanner scanner;
            String nextLine;
            String lowerCase;
            String[] split2;
            String s;
            File file;
            File source;
            boolean exists;
            int n2 = 0;
            Scanner scanner2;
            File file2;
            int n3;
            Label_0052_Outer:Label_0158_Outer:
            while (true) {
                while (true) {
                Label_0133_Outer:
                    while (true) {
                        while (true) {
                            Label_0406: {
                                try {
                                    getenv = System.getenv("SECONDARY_STORAGE");
                                    if (!TextUtils.isEmpty((CharSequence)getenv)) {
                                        split = getenv.split(File.pathSeparator);
                                        length = split.length;
                                        n = 0;
                                        break Label_0451;
                                    }
                                    scanner = new Scanner(new File("/proc/mounts"));
                                    while (scanner.hasNext()) {
                                        nextLine = scanner.nextLine();
                                        lowerCase = nextLine.toLowerCase(Locale.US);
                                        if (lowerCase.contains("/vold/") && !lowerCase.contains("asec")) {
                                            split2 = nextLine.split(" ");
                                            if (split2.length < 2) {
                                                continue Label_0451_Outer;
                                            }
                                            s = split2[1];
                                            if (s.equals(Environment.getExternalStorageDirectory().getAbsolutePath())) {
                                                continue Label_0451_Outer;
                                            }
                                            file = new File(s);
                                            if (!file.exists() || !file.canWrite() || !file.isDirectory()) {
                                                continue Label_0451_Outer;
                                            }
                                            list.add(s);
                                        }
                                    }
                                    scanner.close();
                                    source = new File("/system/etc/vold.fstab");
                                    exists = source.exists();
                                    n2 = 0;
                                    if (exists) {
                                        scanner2 = new Scanner(source);
                                        if (scanner2.hasNext()) {
                                            goto Label_0333;
                                        }
                                        scanner2.close();
                                    }
                                    if (n2 < list.size()) {
                                        break Label_0406;
                                    }
                                    if (list.size() > 0) {
                                        return list.get(0);
                                    }
                                    goto Label_0331;
                                    pathname = split[n];
                                    file2 = new File(pathname);
                                    // iftrue(Label_0464:, !file2.exists() || !file2.canWrite() || !file2.isDirectory())
                                    break;
                                }
                                catch (IOException ex) {
                                    ColorNote.a("Exception in detect sd card");
                                    ex.printStackTrace();
                                }
                                catch (RuntimeException ex2) {
                                    ColorNote.a("Exception in detect sd card");
                                    ex2.printStackTrace();
                                    goto Label_0331;
                                }
                            }
                            if (!list2.contains(list.get(n2))) {
                                n3 = n2 - 1;
                                list.remove(n2);
                            }
                            else {
                                n3 = n2;
                            }
                            n2 = n3 + 1;
                            continue Label_0158_Outer;
                        }
                        if (n >= length) {
                            continue Label_0133_Outer;
                        }
                        break;
                    }
                    continue;
                }
                Label_0464: {
                    ++n;
                }
                continue Label_0052_Outer;
            }
        }
        return pathname;
    }
    
    private static String d() {
        synchronized (jl.class) {
            final File parent = new File(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()) + "/data/colornote/info/");
            if (!parent.exists()) {
                parent.mkdirs();
            }
            final File file = new File(parent, "DEVICE");
            try {
                if (!file.exists()) {
                    final FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(UUID.randomUUID().toString().getBytes());
                    fileOutputStream.close();
                }
                final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                final byte[] array = new byte[(int)randomAccessFile.length()];
                randomAccessFile.readFully(array);
                randomAccessFile.close();
                return new String(array);
            }
            catch (Exception cause) {
                throw new RuntimeException(cause);
            }
        }
    }
}
