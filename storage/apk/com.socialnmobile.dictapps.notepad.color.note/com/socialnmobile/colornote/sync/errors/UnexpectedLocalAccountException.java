// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.sync.errors;

public class UnexpectedLocalAccountException extends Exception
{
    private static final long serialVersionUID = 3563710859278507387L;
    private final rt unexpectedAccount;
    
    public UnexpectedLocalAccountException() {
        super("Login: Local account should exists");
        this.unexpectedAccount = null;
    }
    
    public UnexpectedLocalAccountException(final rt unexpectedAccount) {
        super("Sign Up/Sign In: Unexpected local account is detected");
        this.unexpectedAccount = unexpectedAccount;
    }
    
    public rt getUnexpectedAccount() {
        return this.unexpectedAccount;
    }
}
