// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public abstract class FaultRecoveringOutputStream extends AbstractOutputStream
{
    private final int maxReplayBufferLength;
    private OutputStream out;
    private ByteArrayOutputStream replayBuffer;
    
    public FaultRecoveringOutputStream(final int n, final OutputStream out) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.maxReplayBufferLength = n;
        this.replayBuffer = new ByteArrayOutputStream(n);
        this.out = out;
    }
    
    private boolean recover(final IOException p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/squareup/okhttp/internal/FaultRecoveringOutputStream.replayBuffer:Ljava/io/ByteArrayOutputStream;
        //     4: ifnonnull       16
        //     7: iconst_0       
        //     8: ireturn        
        //     9: astore_3       
        //    10: aload_2        
        //    11: invokestatic    com/squareup/okhttp/internal/Util.closeQuietly:(Ljava/io/Closeable;)V
        //    14: aload_3        
        //    15: astore_1       
        //    16: aconst_null    
        //    17: astore_2       
        //    18: aload_0        
        //    19: aload_1        
        //    20: invokevirtual   com/squareup/okhttp/internal/FaultRecoveringOutputStream.replacementStream:(Ljava/io/IOException;)Ljava/io/OutputStream;
        //    23: astore_2       
        //    24: aload_2        
        //    25: ifnull          7
        //    28: aload_0        
        //    29: aload_2        
        //    30: invokevirtual   com/squareup/okhttp/internal/FaultRecoveringOutputStream.replaceStream:(Ljava/io/OutputStream;)V
        //    33: iconst_1       
        //    34: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  18     24     9      16     Ljava/io/IOException;
        //  28     33     9      16     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:3037)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2446)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:109)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public final void close() throws IOException {
        if (this.closed) {
            return;
        }
        while (true) {
            try {
                this.out.close();
                this.closed = true;
            }
            catch (IOException ex) {
                if (!this.recover(ex)) {
                    throw ex;
                }
                continue;
            }
            break;
        }
    }
    
    @Override
    public final void flush() throws IOException {
        if (this.closed) {
            return;
        }
        while (true) {
            try {
                this.out.flush();
            }
            catch (IOException ex) {
                if (!this.recover(ex)) {
                    throw ex;
                }
                continue;
            }
            break;
        }
    }
    
    public boolean isRecoverable() {
        return this.replayBuffer != null;
    }
    
    public final void replaceStream(final OutputStream outputStream) throws IOException {
        if (!this.isRecoverable()) {
            throw new IllegalStateException();
        }
        if (this.out == outputStream) {
            return;
        }
        this.replayBuffer.writeTo(outputStream);
        Util.closeQuietly(this.out);
        this.out = outputStream;
    }
    
    protected abstract OutputStream replacementStream(final IOException p0) throws IOException;
    
    @Override
    public final void write(final byte[] array, final int n, final int n2) throws IOException {
        if (this.closed) {
            throw new IOException("stream closed");
        }
        Util.checkOffsetAndCount(array.length, n, n2);
        while (true) {
            try {
                this.out.write(array, n, n2);
                if (this.replayBuffer != null) {
                    if (n2 + this.replayBuffer.size() > this.maxReplayBufferLength) {
                        this.replayBuffer = null;
                        return;
                    }
                    this.replayBuffer.write(array, n, n2);
                }
            }
            catch (IOException ex) {
                if (!this.recover(ex)) {
                    throw ex;
                }
                continue;
            }
            break;
        }
    }
}
