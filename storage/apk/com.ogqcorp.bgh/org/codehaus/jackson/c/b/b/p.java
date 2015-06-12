// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import java.net.InetAddress;

public class p extends m<InetAddress>
{
    public p() {
        super(InetAddress.class);
    }
    
    protected InetAddress b(final String host, final org.codehaus.jackson.c.p p2) {
        return InetAddress.getByName(host);
    }
}
