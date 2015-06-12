// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import java.util.Currency;

public class o extends m<Currency>
{
    public o() {
        super(Currency.class);
    }
    
    protected Currency b(final String currencyCode, final p p2) {
        return Currency.getInstance(currencyCode);
    }
}
