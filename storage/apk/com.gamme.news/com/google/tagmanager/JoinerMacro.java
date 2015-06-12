// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.HashSet;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.common.FunctionType;

class JoinerMacro extends FunctionCallImplementation
{
    private static final String ARG0;
    private static final String DEFAULT_ITEM_SEPARATOR = "";
    private static final String DEFAULT_KEY_VALUE_SEPARATOR = "=";
    private static final String ESCAPE;
    private static final String ID;
    private static final String ITEM_SEPARATOR;
    private static final String KEY_VALUE_SEPARATOR;
    
    static {
        ID = FunctionType.JOINER.toString();
        ARG0 = Key.ARG0.toString();
        ITEM_SEPARATOR = Key.ITEM_SEPARATOR.toString();
        KEY_VALUE_SEPARATOR = Key.KEY_VALUE_SEPARATOR.toString();
        ESCAPE = Key.ESCAPE.toString();
    }
    
    public JoinerMacro() {
        super(JoinerMacro.ID, new String[] { JoinerMacro.ARG0 });
    }
    
    private void addTo(final Set<Character> set, final String s) {
        for (int i = 0; i < s.length(); ++i) {
            set.add(s.charAt(i));
        }
    }
    
    private void append(final StringBuilder sb, final String s, final EscapeType escapeType, final Set<Character> set) {
        sb.append(this.escape(s, escapeType, set));
    }
    
    private String escape(final String s, final EscapeType escapeType, final Set<Character> set) {
        switch (escapeType) {
            default: {
                return s;
            }
            case URL: {
                try {
                    return ValueEscapeUtil.urlEncode(s);
                }
                catch (UnsupportedEncodingException ex) {
                    Log.e("Joiner: unsupported encoding", ex);
                    return s;
                }
            }
            case BACKSLASH: {
                String s2 = s.replace("\\", "\\\\");
                final Iterator<Character> iterator = set.iterator();
                while (iterator.hasNext()) {
                    final String string = iterator.next().toString();
                    s2 = s2.replace(string, "\\" + string);
                }
                return s2;
            }
        }
    }
    
    public static String getFunctionId() {
        return JoinerMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        final TypeSystem.Value value = map.get(JoinerMacro.ARG0);
        if (value == null) {
            return Types.getDefaultValue();
        }
        final TypeSystem.Value value2 = map.get(JoinerMacro.ITEM_SEPARATOR);
        String valueToString;
        if (value2 != null) {
            valueToString = Types.valueToString(value2);
        }
        else {
            valueToString = "";
        }
        final TypeSystem.Value value3 = map.get(JoinerMacro.KEY_VALUE_SEPARATOR);
        String valueToString2;
        if (value3 != null) {
            valueToString2 = Types.valueToString(value3);
        }
        else {
            valueToString2 = "=";
        }
        EscapeType escapeType = EscapeType.NONE;
        final TypeSystem.Value value4 = map.get(JoinerMacro.ESCAPE);
        Set set = null;
        if (value4 != null) {
            final String valueToString3 = Types.valueToString(value4);
            if ("url".equals(valueToString3)) {
                escapeType = EscapeType.URL;
            }
            else {
                if (!"backslash".equals(valueToString3)) {
                    Log.e("Joiner: unsupported escape type: " + valueToString3);
                    return Types.getDefaultValue();
                }
                escapeType = EscapeType.BACKSLASH;
                set = new HashSet<Character>();
                this.addTo(set, valueToString);
                this.addTo(set, valueToString2);
                set.remove('\\');
            }
        }
        final StringBuilder sb = new StringBuilder();
        switch (value.type) {
            default: {
                this.append(sb, Types.valueToString(value), escapeType, set);
                break;
            }
            case 2: {
                int n = 1;
                final TypeSystem.Value[] listItem = value.listItem;
                for (int length = listItem.length, i = 0; i < length; ++i, n = 0) {
                    final TypeSystem.Value value5 = listItem[i];
                    if (n == 0) {
                        sb.append(valueToString);
                    }
                    this.append(sb, Types.valueToString(value5), escapeType, set);
                }
                break;
            }
            case 3: {
                for (int j = 0; j < value.mapKey.length; ++j) {
                    if (j > 0) {
                        sb.append(valueToString);
                    }
                    final String valueToString4 = Types.valueToString(value.mapKey[j]);
                    final String valueToString5 = Types.valueToString(value.mapValue[j]);
                    this.append(sb, valueToString4, escapeType, set);
                    sb.append(valueToString2);
                    this.append(sb, valueToString5, escapeType, set);
                }
                break;
            }
        }
        return Types.objectToValue(sb.toString());
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
    
    private enum EscapeType
    {
        BACKSLASH, 
        NONE, 
        URL;
    }
}
