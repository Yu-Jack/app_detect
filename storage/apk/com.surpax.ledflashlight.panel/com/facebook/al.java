// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.io.IOException;
import java.io.FileNotFoundException;
import com.facebook.b.aj;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;
import java.io.File;

public final class al implements am
{
    private static final String a;
    private static File b;
    
    static {
        a = al.class.getName();
    }
    
    private static File b(final UUID uuid, final String s) {
        File parent;
        if (al.b == null) {
            parent = null;
        }
        else {
            parent = new File(al.b, uuid.toString());
        }
        if (parent == null) {
            return null;
        }
        try {
            return new File(parent, URLEncoder.encode(s, "UTF-8"));
        }
        catch (UnsupportedEncodingException ex) {
            return null;
        }
    }
    
    @Override
    public final File a(final UUID uuid, final String s) {
        if (aj.a(s) || uuid == null) {
            throw new FileNotFoundException();
        }
        try {
            return b(uuid, s);
        }
        catch (IOException ex) {
            throw new FileNotFoundException();
        }
    }
}
