// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.sync.errors;

public class PasswordNotMatch extends ColorNoteRpcError
{
    static final String AUTH_SUGGEST = "auth_suggest";
    private static final long serialVersionUID = -5283704965596397740L;
    
    public PasswordNotMatch(final xn xn) {
        super(xn);
    }
    
    public sl getAuthSuggest() {
        try {
            final xj c = xf.c(this.error.c);
            if (c != null) {
                final String h = c.h("auth_suggest");
                if (h != null) {
                    return sl.a(h.toLowerCase());
                }
            }
        }
        catch (xh xh) {}
        return null;
    }
}
