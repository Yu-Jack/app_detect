// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import java.io.File;

public final class ar extends s<File>
{
    public ar() {
        super(File.class);
    }
    
    @Override
    public void a(final File file, final f f, final ax ax) {
        f.b(file.getAbsolutePath());
    }
}
