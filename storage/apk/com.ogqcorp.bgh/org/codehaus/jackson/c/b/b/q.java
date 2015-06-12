// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import java.util.Locale;

public class q extends m<Locale>
{
    public q() {
        super(Locale.class);
    }
    
    protected Locale b(final String language, final p p2) {
        final int index = language.indexOf(95);
        if (index < 0) {
            return new Locale(language);
        }
        final String substring = language.substring(0, index);
        final String substring2 = language.substring(index + 1);
        final int index2 = substring2.indexOf(95);
        if (index2 < 0) {
            return new Locale(substring, substring2);
        }
        return new Locale(substring, substring2.substring(0, index2), substring2.substring(index2 + 1));
    }
}
