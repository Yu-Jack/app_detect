import java.util.HashMap;

// 
// Decompiled by Procyon v0.5.29
// 

public final class vk
{
    public static final vk d;
    public final HashMap a;
    public final HashMap b;
    public final HashMap c;
    
    static {
        d = new vk();
    }
    
    public vk() {
        final HashMap<String, Integer> a = new HashMap<String, Integer>();
        a.put("text", 0);
        a.put("list", 16);
        a.put("pref", 256);
        a.put("none", -1);
        this.a = a;
        final HashMap<String, Integer> b = new HashMap<String, Integer>();
        b.put("normal", 0);
        b.put("archived", 0);
        b.put("recyclebin", 16);
        b.put("deleted", 32);
        b.put("hidden", 256);
        this.b = b;
        final HashMap<String, Integer> c = new HashMap<String, Integer>();
        c.put("normal", 0);
        c.put("archived", 16);
        c.put("recyclebin", 0);
        c.put("deleted", 0);
        c.put("hidden", 0);
        this.c = c;
    }
    
    public static void a(final vi vi, final xj xj) {
        xj.a("color", (int)vi.g.c());
        xj.a("created", vi.h.c(), tw.d);
        xj.a("flags", (int)vi.b.c());
        xj.a("folder", (int)vi.c.c());
        xj.a("modified_minor", vi.i.c(), tw.d);
        final int intValue = (int)vi.e.c();
        String s = null;
        if ((int)vi.a.c() == 16) {
            s = "archived";
        }
        else {
            switch (intValue) {
                default: {
                    s = "normal";
                    break;
                }
                case 0: {
                    s = "normal";
                    break;
                }
                case 16: {
                    s = "recyclebin";
                    break;
                }
                case 32: {
                    s = "deleted";
                    break;
                }
                case 256: {
                    s = "hidden";
                    break;
                }
            }
        }
        xj.a("state", s);
        final int intValue2 = (int)vi.f.c();
        String s2 = null;
        switch (intValue2) {
            default: {
                throw new IllegalStateException("type: " + intValue2);
            }
            case 0: {
                s2 = "text";
                break;
            }
            case 16: {
                s2 = "list";
                break;
            }
            case 256: {
                s2 = "pref";
                break;
            }
            case -1: {
                s2 = "none";
                break;
            }
        }
        xj.a("type", s2);
        xj.a("version", (int)vi.j.c());
        final vl k = vi.k;
        xj xj2;
        if ((int)k.a.c() == 0) {
            xj2 = null;
        }
        else {
            xj2 = new xj();
            final vm a = vm.a;
            vm.a(k, xj2);
        }
        xj.a("reminder", xj2);
    }
    
    public final void b(final vi vi, final xj xj) {
        try {
            vi.g.a(xj.c("color").intValue());
            vi.h.a(xj.a("created", tw.d));
            vi.b.a(xj.c("flags").intValue());
            vi.c.a(xj.c("folder").intValue());
            vi.i.a(xj.a("modified_minor", tw.d));
            final String h = xj.h("state");
            Label_0340: {
                if (h == null) {
                    break Label_0340;
                }
                final Integer n = this.b.get(h);
                if (n == null) {
                    break Label_0340;
                }
                int i = n;
                vi.e.a(i);
                final String h2 = xj.h("state");
                Label_0354: {
                    if (h2 == null) {
                        break Label_0354;
                    }
                    final Integer n2 = this.c.get(h2);
                    if (n2 == null) {
                        break Label_0354;
                    }
                    int j = n2;
                Label_0270_Outer:
                    while (true) {
                        vi.a.a(j);
                        final String h3 = xj.h("type");
                        Label_0368: {
                            if (h3 == null) {
                                break Label_0368;
                            }
                            final Integer n3 = this.a.get(h3);
                            if (n3 == null) {
                                break Label_0368;
                            }
                            int k = n3;
                            while (true) {
                                vi.f.a(k);
                                final Number g = xj.g("version");
                                if (g != null) {
                                    vi.j.a(g.intValue());
                                }
                                final vl l = vi.k;
                                final xj m = xj.j("reminder");
                                try {
                                    final vm a = vm.a;
                                    vm.b(l, m);
                                    return;
                                    k = xj.c("type").intValue();
                                    continue;
                                    j = xj.c("state").intValue();
                                    continue Label_0270_Outer;
                                    i = xj.c("state").intValue();
                                }
                                catch (ux ux) {
                                    throw new ux("reminder", ux);
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        catch (xg xg) {
            throw new ux(xg);
        }
        catch (xh xh) {
            throw new ux(xh);
        }
        catch (ux ux2) {
            throw new ux(ux2);
        }
    }
}
