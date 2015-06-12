// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Iterator;
import java.util.ArrayList;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;
import java.io.DataInput;

public final class d
{
    private static final String a;
    
    static {
        a = d.class.getSimpleName();
    }
    
    public static List a(final DataInput dataInput) {
        if (46586 != dataInput.readUnsignedShort()) {
            throw new IOException("Unexpected data format");
        }
        return b(dataInput);
    }
    
    public static void a(final List list, final DataOutput dataOutput) {
        dataOutput.writeShort(46586);
        b(list, dataOutput);
        dataOutput.writeShort(0);
    }
    
    private static List b(final DataInput dataInput) {
        final ArrayList<e> list = new ArrayList<e>();
        try {
            while (1 == dataInput.readUnsignedShort()) {
                list.add(new e(dataInput));
            }
            return list;
        }
        catch (IOException ex) {
            eo.a(3, d.a, "unable to read adLog: ", ex);
            return list;
        }
    }
    
    private static void b(final List list, final DataOutput dataOutput) {
        for (final e e : list) {
            try {
                dataOutput.writeShort(1);
                e.a(dataOutput);
                continue;
            }
            catch (IOException ex) {
                eo.a(3, d.a, "unable to write adLog with GUID: " + e.b(), ex);
            }
            break;
        }
    }
}
