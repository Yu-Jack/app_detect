// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.spdy;

import java.util.zip.InflaterInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.Closeable;

class NameValueBlockReader implements Closeable
{
    private int compressedLimit;
    private final FillableInflaterInputStream fillableInflaterInputStream;
    private final DataInputStream nameValueBlockIn;
    
    NameValueBlockReader(final InputStream inputStream) {
        this.fillableInflaterInputStream = new FillableInflaterInputStream(new InputStream() {
            @Override
            public void close() throws IOException {
                inputStream.close();
            }
            
            @Override
            public int read() throws IOException {
                return Util.readSingleByte(this);
            }
            
            @Override
            public int read(final byte[] b, final int off, final int a) throws IOException {
                final int read = inputStream.read(b, off, Math.min(a, NameValueBlockReader.this.compressedLimit));
                final NameValueBlockReader this$0 = NameValueBlockReader.this;
                NameValueBlockReader.access$1(this$0, this$0.compressedLimit - read);
                return read;
            }
        }, new Inflater() {
            @Override
            public int inflate(final byte[] array, final int n, final int n2) throws DataFormatException {
                int n3 = super.inflate(array, n, n2);
                if (n3 == 0 && this.needsDictionary()) {
                    this.setDictionary(Spdy3.DICTIONARY);
                    n3 = super.inflate(array, n, n2);
                }
                return n3;
            }
        });
        this.nameValueBlockIn = new DataInputStream(this.fillableInflaterInputStream);
    }
    
    static /* synthetic */ void access$1(final NameValueBlockReader nameValueBlockReader, final int compressedLimit) {
        nameValueBlockReader.compressedLimit = compressedLimit;
    }
    
    private void doneReading() throws IOException {
        if (this.compressedLimit != 0) {
            this.fillableInflaterInputStream.fill();
            if (this.compressedLimit != 0) {
                throw new IOException("compressedLimit > 0: " + this.compressedLimit);
            }
        }
    }
    
    private String readString() throws DataFormatException, IOException {
        final int int1 = this.nameValueBlockIn.readInt();
        final byte[] bytes = new byte[int1];
        Util.readFully(this.nameValueBlockIn, bytes);
        return new String(bytes, 0, int1, "UTF-8");
    }
    
    @Override
    public void close() throws IOException {
        this.nameValueBlockIn.close();
    }
    
    public List<String> readNameValueBlock(final int n) throws IOException {
        this.compressedLimit += n;
        int int1;
        try {
            int1 = this.nameValueBlockIn.readInt();
            if (int1 < 0) {
                throw new IOException("numberOfPairs < 0: " + int1);
            }
        }
        catch (DataFormatException ex) {
            throw new IOException(ex.getMessage());
        }
        if (int1 > 1024) {
            throw new IOException("numberOfPairs > 1024: " + int1);
        }
        final ArrayList list = new ArrayList<String>(int1 * 2);
        for (int i = 0; i < int1; ++i) {
            final String string = this.readString();
            final String string2 = this.readString();
            if (string.length() == 0) {
                throw new IOException("name.length == 0");
            }
            list.add(string);
            list.add(string2);
        }
        this.doneReading();
        return (List<String>)list;
    }
    
    static class FillableInflaterInputStream extends InflaterInputStream
    {
        public FillableInflaterInputStream(final InputStream in, final Inflater inf) {
            super(in, inf);
        }
        
        public void fill() throws IOException {
            super.fill();
        }
    }
}
