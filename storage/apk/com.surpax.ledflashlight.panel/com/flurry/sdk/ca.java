// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.io.OutputStream;
import java.io.InputStream;

public class ca implements ex
{
    private Class a;
    
    public ca(final Class a) {
        this.a = a;
    }
    
    @Override
    public Object a(final InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        final jq jq = new jq();
        final oc oc = new oc("AvroJsonObjectSerializerModule", new hq(1, 0, 0, null));
        oc.a(CharSequence.class, new ca$a(null));
        jq.a(oc);
        return jq.a(inputStream, this.a);
    }
    
    @Override
    public void a(final OutputStream outputStream, final Object o) {
        if (outputStream == null || o == null) {
            return;
        }
        final jq jq = new jq();
        jq.a(ju$a.m, false);
        jq.a(ju$a.b, false);
        jq.a(ju$a.c, false);
        jq.a(outputStream, o);
    }
}
