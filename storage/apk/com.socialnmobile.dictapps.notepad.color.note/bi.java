import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.5.29
// 

public final class bi
{
    private static final Object a;
    private static char[] b;
    
    static {
        a = new Object();
        bi.b = new char[24];
    }
    
    private static int a(final int n, final int n2, final boolean b, final int n3) {
        if (n > 99 || (b && n3 >= 3)) {
            return n2 + 3;
        }
        if (n > 9 || (b && n3 >= 2)) {
            return n2 + 2;
        }
        if (b || n > 0) {
            return n2 + 1;
        }
        return 0;
    }
    
    private static int a(final char[] array, final int n, final char c, int n2, final boolean b, final int n3) {
        if (b || n > 0) {
            int n5;
            int n6;
            if ((b && n3 >= 3) || n > 99) {
                final int n4 = n / 100;
                array[n2] = (char)(n4 + 48);
                n5 = n2 + 1;
                n6 = n - n4 * 100;
            }
            else {
                n5 = n2;
                n6 = n;
            }
            if ((b && n3 >= 2) || n6 > 9 || n2 != n5) {
                final int n7 = n6 / 10;
                array[n5] = (char)(n7 + 48);
                ++n5;
                n6 -= n7 * 10;
            }
            array[n5] = (char)(n6 + 48);
            final int n8 = n5 + 1;
            array[n8] = c;
            n2 = n8 + 1;
        }
        return n2;
    }
    
    public static void formatDuration(final long n, final long n2, final PrintWriter printWriter) {
        if (n == 0L) {
            printWriter.print("--");
            return;
        }
        formatDuration(n - n2, printWriter, 0);
    }
    
    public static void formatDuration(final long n, final PrintWriter printWriter) {
        formatDuration(n, printWriter, 0);
    }
    
    public static void formatDuration(long n, final PrintWriter printWriter, final int n2) {
        // monitorexit(o)
        while (true) {
            final char[] b;
            Label_0580: {
                synchronized (bi.a) {
                    if (bi.b.length < n2) {
                        bi.b = new char[n2];
                    }
                    b = bi.b;
                    if (n != 0L) {
                        break Label_0580;
                    }
                    while (n2 - 1 > 0) {
                        b[0] = ' ';
                    }
                }
                b[0] = '0';
                final int count = 1;
                printWriter.print(new String(bi.b, 0, count));
                return;
            }
            char c;
            if (n > 0L) {
                c = '+';
            }
            else {
                n = -n;
                c = '-';
            }
            final int n3 = (int)(n % 1000L);
            int n4 = (int)Math.floor(n / 1000L);
            int n5 = 0;
            if (n4 > 86400) {
                n5 = n4 / 86400;
                n4 -= 86400 * n5;
            }
            int n8;
            int n9;
            if (n4 > 3600) {
                final int n6 = n4 / 3600;
                final int n7 = n4 - n6 * 3600;
                n8 = n6;
                n9 = n7;
            }
            else {
                n9 = n4;
                n8 = 0;
            }
            int n12;
            int n13;
            if (n9 > 60) {
                final int n10 = n9 / 60;
                final int n11 = n9 - n10 * 60;
                n12 = n10;
                n13 = n11;
            }
            else {
                n13 = n9;
                n12 = 0;
            }
            int n14 = 0;
            if (n2 != 0) {
                final int a = a(n5, 1, false, 0);
                final int n15 = a + a(n8, 1, a > 0, 2);
                final int n16 = n15 + a(n12, 1, n15 > 0, 2);
                final int n17 = n16 + a(n13, 1, n16 > 0, 2);
                int n18;
                if (n17 > 0) {
                    n18 = 3;
                }
                else {
                    n18 = 0;
                }
                int n19;
                for (int i = n17 + (1 + a(n3, 2, true, n18)); i < n2; ++i, n14 = n19) {
                    b[n14] = ' ';
                    n19 = n14 + 1;
                }
            }
            b[n14] = c;
            final int n20 = n14 + 1;
            boolean b2;
            if (n2 != 0) {
                b2 = true;
            }
            else {
                b2 = false;
            }
            final int a2 = a(b, n5, 'd', n20, false, 0);
            final boolean b3 = a2 != n20;
            int n21;
            if (b2) {
                n21 = 2;
            }
            else {
                n21 = 0;
            }
            final int a3 = a(b, n8, 'h', a2, b3, n21);
            final boolean b4 = a3 != n20;
            int n22;
            if (b2) {
                n22 = 2;
            }
            else {
                n22 = 0;
            }
            final int a4 = a(b, n12, 'm', a3, b4, n22);
            final boolean b5 = a4 != n20;
            int n23;
            if (b2) {
                n23 = 2;
            }
            else {
                n23 = 0;
            }
            final int a5 = a(b, n13, 's', a4, b5, n23);
            int n24;
            if (b2 && a5 != n20) {
                n24 = 3;
            }
            else {
                n24 = 0;
            }
            final int a6 = a(b, n3, 'm', a5, true, n24);
            b[a6] = 's';
            final int count = a6 + 1;
            continue;
        }
    }
}
