// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import java.io.InputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import org.codehaus.jackson.c.p;
import java.util.UUID;

public class v extends m<UUID>
{
    public v() {
        super(UUID.class);
    }
    
    protected UUID b(final Object o, final p p2) {
        if (o instanceof byte[]) {
            final byte[] buf = (byte[])o;
            if (buf.length != 16) {
                p2.b("Can only construct UUIDs from 16 byte arrays; got " + buf.length + " bytes");
            }
            final DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(buf));
            return new UUID(dataInputStream.readLong(), dataInputStream.readLong());
        }
        super.a(o, p2);
        return null;
    }
    
    protected UUID b(final String name, final p p2) {
        return UUID.fromString(name);
    }
}
