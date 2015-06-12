// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager.protobuf.nano;

import java.io.UnsupportedEncodingException;

public class InternalNano
{
    public static final byte[] bytesDefaultValue(final String s) {
        try {
            return s.getBytes("ISO-8859-1");
        }
        catch (UnsupportedEncodingException cause) {
            throw new IllegalStateException("Java VM does not support a standard character set.", cause);
        }
    }
    
    public static final byte[] copyFromUtf8(final String s) {
        try {
            return s.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("UTF-8 not supported?");
        }
    }
    
    public static final String stringDefaultValue(final String s) {
        try {
            return new String(s.getBytes("ISO-8859-1"), "UTF-8");
        }
        catch (UnsupportedEncodingException cause) {
            throw new IllegalStateException("Java VM does not support a standard character set.", cause);
        }
    }
}
