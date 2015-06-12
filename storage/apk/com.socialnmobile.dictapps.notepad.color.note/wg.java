import java.util.Iterator;
import android.os.Build;
import android.database.Cursor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class wg
{
    final we a;
    
    wg(final we a) {
        this.a = a;
    }
    
    private static Object a(final kj kj, final String str, final String[] array) {
        final Cursor a = kj.a(str, array);
        if (a != null) {
            while (true) {
                while (true) {
                    int j = 0;
                    Label_0239: {
                        try {
                            final xi xi = new xi();
                            for (int i = 0; i < a.getColumnCount(); ++i) {
                                xi.add(a.getColumnName(i));
                            }
                            final xi xi2 = new xi();
                            j = 0;
                            if (j >= a.getCount()) {
                                final xj xj = new xj();
                                xj.a("columns", xi);
                                xj.a("rows", xi2);
                                return xj;
                            }
                            if (a.moveToPosition(j)) {
                                final xi xi3 = new xi();
                                for (int k = 0; k < a.getColumnCount(); ++k) {
                                    xi3.add(a.getString(k));
                                }
                                xi2.add(xi3);
                                break Label_0239;
                            }
                            xi2.add("row " + j + " is not acccessible");
                            break Label_0239;
                        }
                        finally {
                            a.close();
                        }
                        break;
                    }
                    ++j;
                    continue;
                }
            }
        }
        return "can't execute sql: " + str;
    }
    
    public final Object a(final String s, final xj xj) {
        if (s != null) {
            if (s.equals("forcetostop")) {
                this.a.h = true;
                return null;
            }
            if (s.equals("session_params")) {
                final Number g = xj.g("MAX_CHECKINS_PER_REQUEST");
                if (g != null) {
                    this.a.k.a("MAX_CHECKINS_PER_REQUEST", g.intValue());
                }
                final Number g2 = xj.g("DEBUG");
                if (g2 != null) {
                    this.a.k.a("DEBUG", g2.intValue());
                    return null;
                }
            }
            else {
                if (s.equals("buildinfo")) {
                    final xj xj2 = new xj();
                    try {
                        xj2.a("BOARD", Build.BOARD);
                        xj2.a("BRAND", Build.BRAND);
                        xj2.a("DEVICE", Build.DEVICE);
                        xj2.a("DISPLAY", Build.DISPLAY);
                        xj2.a("FINGERPRINT", Build.FINGERPRINT);
                        xj2.a("ID", Build.ID);
                        xj2.a("MODEL", Build.MODEL);
                        xj2.a("PRODUCT", Build.PRODUCT);
                        return xj2;
                    }
                    catch (Exception ex) {
                        return xj2;
                    }
                }
                if (s.equals("note_indexes")) {
                    return this.a.a.f();
                }
                if (s.equals("note_indexes_with_id0")) {
                    return this.a.a.g();
                }
                if (s.equals("sql_query")) {
                    final String h = xj.h("sql");
                    if (h != null) {
                        final Object a = a(this.a.a.b.f(), h, new String[0]);
                        final xj xj3 = new xj();
                        xj3.a("sql", h);
                        xj3.a("result", a);
                        return xj3;
                    }
                    return "sql is null";
                }
                else if (s.equals("sql_insert")) {
                    final String h2 = xj.h("sql");
                    if (h2 != null) {
                        final Long value = this.a.a.b.f().b(h2, new Object[0]);
                        final xj xj4 = new xj();
                        xj4.a("sql", h2);
                        xj4.a("result", value);
                        return xj4;
                    }
                    return "sql is null";
                }
                else if (s.equals("sql_exec")) {
                    final String h3 = xj.h("sql");
                    if (h3 != null) {
                        final Integer value2 = this.a.a.b.f().a(h3, new Object[0]);
                        final xj xj5 = new xj();
                        xj5.a("sql", h3);
                        xj5.a("result", value2);
                        return xj5;
                    }
                    return "sql is null";
                }
                else {
                    if (s.equals("full_checkin")) {
                        return new ko(this.a.a.b).a((aco)null);
                    }
                    if (s.equals("report_installed_packages")) {
                        final xj xj6 = new xj();
                        for (final String s2 : xj.i("packages")) {
                            xj6.a(s2, gw.a(this.a.a.a, s2));
                        }
                        return xj6;
                    }
                }
            }
        }
        return null;
    }
}
