// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import java.net.InetAddress;

public class k extends s<InetAddress>
{
    public static final k a;
    
    static {
        a = new k();
    }
    
    public k() {
        super(InetAddress.class);
    }
    
    @Override
    public void a(final InetAddress inetAddress, final f f, final ax ax) {
        String s = inetAddress.toString().trim();
        final int index = s.indexOf(47);
        if (index >= 0) {
            if (index == 0) {
                s = s.substring(1);
            }
            else {
                s = s.substring(0, index);
            }
        }
        f.b(s);
    }
    
    @Override
    public void a(final InetAddress inetAddress, final f f, final ax ax, final ba ba) {
        ba.a(inetAddress, f, InetAddress.class);
        this.a(inetAddress, f, ax);
        ba.d(inetAddress, f);
    }
}
