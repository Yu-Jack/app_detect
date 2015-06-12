// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.sync.errors;

public class ColorNoteRpcError extends Exception
{
    private static final long serialVersionUID = 4460001770567208483L;
    protected xn error;
    
    public ColorNoteRpcError(final String message) {
        super(message);
    }
    
    public ColorNoteRpcError(final xn error) {
        super(error.b);
        this.error = error;
    }
}
