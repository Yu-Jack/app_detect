// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import java.util.regex.Pattern;

public class r extends m<Pattern>
{
    public r() {
        super(Pattern.class);
    }
    
    protected Pattern b(final String regex, final p p2) {
        return Pattern.compile(regex);
    }
}
