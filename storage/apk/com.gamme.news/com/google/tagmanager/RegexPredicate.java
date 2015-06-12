// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.regex.PatternSyntaxException;
import java.util.regex.Pattern;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.common.FunctionType;

class RegexPredicate extends StringPredicate
{
    private static final String ID;
    private static final String IGNORE_CASE;
    
    static {
        ID = FunctionType.REGEX.toString();
        IGNORE_CASE = Key.IGNORE_CASE.toString();
    }
    
    public RegexPredicate() {
        super(RegexPredicate.ID);
    }
    
    public static String getFunctionId() {
        return RegexPredicate.ID;
    }
    
    public static String getIgnoreCaseKey() {
        return RegexPredicate.IGNORE_CASE;
    }
    
    @Override
    protected boolean evaluateString(final String input, final String regex, final Map<String, TypeSystem.Value> map) {
        int flags = 64;
        if (Types.valueToBoolean(map.get(RegexPredicate.IGNORE_CASE))) {
            flags |= 0x2;
        }
        try {
            return Pattern.compile(regex, flags).matcher(input).find();
        }
        catch (PatternSyntaxException ex) {
            return false;
        }
    }
}
