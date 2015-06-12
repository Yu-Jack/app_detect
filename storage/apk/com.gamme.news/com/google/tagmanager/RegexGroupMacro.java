// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;
import java.util.regex.Pattern;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.common.FunctionType;

class RegexGroupMacro extends FunctionCallImplementation
{
    private static final String GROUP;
    private static final String ID;
    private static final String IGNORE_CASE;
    private static final String REGEX;
    private static final String TO_MATCH;
    
    static {
        ID = FunctionType.REGEX_GROUP.toString();
        TO_MATCH = Key.ARG0.toString();
        REGEX = Key.ARG1.toString();
        IGNORE_CASE = Key.IGNORE_CASE.toString();
        GROUP = Key.GROUP.toString();
    }
    
    public RegexGroupMacro() {
        super(RegexGroupMacro.ID, new String[] { RegexGroupMacro.TO_MATCH, RegexGroupMacro.REGEX });
    }
    
    public static String getFunctionId() {
        return RegexGroupMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        final TypeSystem.Value value = map.get(RegexGroupMacro.TO_MATCH);
        final TypeSystem.Value value2 = map.get(RegexGroupMacro.REGEX);
        if (value == null || value == Types.getDefaultValue() || value2 == null || value2 == Types.getDefaultValue()) {
            return Types.getDefaultValue();
        }
        int flags = 64;
        if (Types.valueToBoolean(map.get(RegexGroupMacro.IGNORE_CASE))) {
            flags |= 0x2;
        }
        int intValue = 1;
        final TypeSystem.Value value3 = map.get(RegexGroupMacro.GROUP);
        if (value3 != null) {
            final Long valueToInt64 = Types.valueToInt64(value3);
            if (valueToInt64 == Types.getDefaultInt64()) {
                return Types.getDefaultValue();
            }
            intValue = (int)(Object)valueToInt64;
            if (intValue < 0) {
                return Types.getDefaultValue();
            }
        }
        try {
            final Matcher matcher = Pattern.compile(Types.valueToString(value2), flags).matcher(Types.valueToString(value));
            final boolean find = matcher.find();
            Object group = null;
            if (find) {
                final int groupCount = matcher.groupCount();
                group = null;
                if (groupCount >= intValue) {
                    group = matcher.group(intValue);
                }
            }
            if (group == null) {
                return Types.getDefaultValue();
            }
            return Types.objectToValue(group);
        }
        catch (PatternSyntaxException ex) {
            return Types.getDefaultValue();
        }
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
