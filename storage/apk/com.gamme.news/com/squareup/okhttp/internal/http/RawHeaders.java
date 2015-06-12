// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.util.Locale;
import java.util.HashSet;
import java.util.TreeMap;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.TreeSet;
import java.util.Set;
import java.net.ProtocolException;
import java.util.Iterator;
import java.util.Map;
import java.io.IOException;
import com.squareup.okhttp.internal.Util;
import java.io.InputStream;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public final class RawHeaders
{
    private static final Comparator<String> FIELD_NAME_COMPARATOR;
    private int httpMinorVersion;
    private final List<String> namesAndValues;
    private String requestLine;
    private int responseCode;
    private String responseMessage;
    private String statusLine;
    
    static {
        FIELD_NAME_COMPARATOR = new Comparator<String>() {
            @Override
            public int compare(final String s, final String s2) {
                if (s == s2) {
                    return 0;
                }
                if (s == null) {
                    return -1;
                }
                if (s2 == null) {
                    return 1;
                }
                return String.CASE_INSENSITIVE_ORDER.compare(s, s2);
            }
        };
    }
    
    public RawHeaders() {
        this.namesAndValues = new ArrayList<String>(20);
        this.httpMinorVersion = 1;
        this.responseCode = -1;
    }
    
    public RawHeaders(final RawHeaders rawHeaders) {
        this.namesAndValues = new ArrayList<String>(20);
        this.httpMinorVersion = 1;
        this.responseCode = -1;
        this.namesAndValues.addAll(rawHeaders.namesAndValues);
        this.requestLine = rawHeaders.requestLine;
        this.statusLine = rawHeaders.statusLine;
        this.httpMinorVersion = rawHeaders.httpMinorVersion;
        this.responseCode = rawHeaders.responseCode;
        this.responseMessage = rawHeaders.responseMessage;
    }
    
    private void addLenient(final String s, final String s2) {
        this.namesAndValues.add(s);
        this.namesAndValues.add(s2.trim());
    }
    
    public static RawHeaders fromBytes(final InputStream inputStream) throws IOException {
        RawHeaders rawHeaders;
        do {
            rawHeaders = new RawHeaders();
            rawHeaders.setStatusLine(Util.readAsciiLine(inputStream));
            readHeaders(inputStream, rawHeaders);
        } while (rawHeaders.getResponseCode() == 100);
        return rawHeaders;
    }
    
    public static RawHeaders fromMultimap(final Map<String, List<String>> map, final boolean b) throws IOException {
        if (!b) {
            throw new UnsupportedOperationException();
        }
        final RawHeaders rawHeaders = new RawHeaders();
        for (final Map.Entry<String, List<String>> entry : map.entrySet()) {
            final String s = entry.getKey();
            final List<String> list = entry.getValue();
            if (s != null) {
                final Iterator<String> iterator2 = list.iterator();
                while (iterator2.hasNext()) {
                    rawHeaders.addLenient(s, iterator2.next());
                }
            }
            else {
                if (list.isEmpty()) {
                    continue;
                }
                rawHeaders.setStatusLine(list.get(-1 + list.size()));
            }
        }
        return rawHeaders;
    }
    
    public static RawHeaders fromNameValueBlock(final List<String> obj) throws IOException {
        if (obj.size() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected name value block: " + obj);
        }
        String str = null;
        Object obj2 = null;
        final RawHeaders rawHeaders = new RawHeaders();
        for (int i = 0; i < obj.size(); i += 2) {
            final String s = obj.get(i);
            final String s2 = obj.get(i + 1);
            int endIndex;
            for (int j = 0; j < s2.length(); j = endIndex + 1) {
                endIndex = s2.indexOf(0, j);
                if (endIndex == -1) {
                    endIndex = s2.length();
                }
                final String substring = s2.substring(j, endIndex);
                if (":status".equals(s)) {
                    str = substring;
                }
                else if (":version".equals(s)) {
                    obj2 = substring;
                }
                else {
                    rawHeaders.namesAndValues.add(s);
                    rawHeaders.namesAndValues.add(substring);
                }
            }
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        if (obj2 == null) {
            throw new ProtocolException("Expected ':version' header not present");
        }
        rawHeaders.setStatusLine(String.valueOf(obj2) + " " + str);
        return rawHeaders;
    }
    
    public static void readHeaders(final InputStream inputStream, final RawHeaders rawHeaders) throws IOException {
        while (true) {
            final String asciiLine = Util.readAsciiLine(inputStream);
            if (asciiLine.length() == 0) {
                break;
            }
            rawHeaders.addLine(asciiLine);
        }
    }
    
    public void add(final String str, final String str2) {
        if (str == null) {
            throw new IllegalArgumentException("fieldname == null");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("value == null");
        }
        if (str.length() == 0 || str.indexOf(0) != -1 || str2.indexOf(0) != -1) {
            throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
        }
        this.addLenient(str, str2);
    }
    
    public void addAll(final String s, final List<String> list) {
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.add(s, iterator.next());
        }
    }
    
    public void addLine(final String s) {
        final int index = s.indexOf(":", 1);
        if (index != -1) {
            this.addLenient(s.substring(0, index), s.substring(index + 1));
            return;
        }
        if (s.startsWith(":")) {
            this.addLenient("", s.substring(1));
            return;
        }
        this.addLenient("", s);
    }
    
    public void addSpdyRequestHeaders(final String s, final String s2, final String s3, final String s4, final String s5) {
        this.add(":method", s);
        this.add(":scheme", s5);
        this.add(":path", s2);
        this.add(":version", s3);
        this.add(":host", s4);
    }
    
    public String get(final String s) {
        for (int i = -2 + this.namesAndValues.size(); i >= 0; i -= 2) {
            if (s.equalsIgnoreCase(this.namesAndValues.get(i))) {
                return this.namesAndValues.get(i + 1);
            }
        }
        return null;
    }
    
    public RawHeaders getAll(final Set<String> set) {
        final RawHeaders rawHeaders = new RawHeaders();
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            final String s = this.namesAndValues.get(i);
            if (set.contains(s)) {
                rawHeaders.add(s, this.namesAndValues.get(i + 1));
            }
        }
        return rawHeaders;
    }
    
    public String getFieldName(final int n) {
        final int n2 = n * 2;
        if (n2 < 0 || n2 >= this.namesAndValues.size()) {
            return null;
        }
        return this.namesAndValues.get(n2);
    }
    
    public int getHttpMinorVersion() {
        if (this.httpMinorVersion != -1) {
            return this.httpMinorVersion;
        }
        return 1;
    }
    
    public int getResponseCode() {
        return this.responseCode;
    }
    
    public String getResponseMessage() {
        return this.responseMessage;
    }
    
    public String getStatusLine() {
        return this.statusLine;
    }
    
    public String getValue(final int n) {
        final int n2 = 1 + n * 2;
        if (n2 < 0 || n2 >= this.namesAndValues.size()) {
            return null;
        }
        return this.namesAndValues.get(n2);
    }
    
    public int length() {
        return this.namesAndValues.size() / 2;
    }
    
    public Set<String> names() {
        final TreeSet<String> s = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < this.length(); ++i) {
            s.add(this.getFieldName(i));
        }
        return (Set<String>)Collections.unmodifiableSet((Set<?>)s);
    }
    
    public void removeAll(final String s) {
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            if (s.equalsIgnoreCase(this.namesAndValues.get(i))) {
                this.namesAndValues.remove(i);
                this.namesAndValues.remove(i);
            }
        }
    }
    
    public void set(final String s, final String s2) {
        this.removeAll(s);
        this.add(s, s2);
    }
    
    public void setRequestLine(final String s) {
        this.requestLine = s.trim();
    }
    
    public void setStatusLine(final String s) throws IOException {
        if (this.responseMessage != null) {
            throw new IllegalStateException("statusLine is already set");
        }
        boolean b;
        if (s.length() > 13) {
            b = true;
        }
        else {
            b = false;
        }
        if (!s.startsWith("HTTP/1.") || s.length() < 12 || s.charAt(8) != ' ' || (b && s.charAt(12) != ' ')) {
            throw new ProtocolException("Unexpected status line: " + s);
        }
        final int httpMinorVersion = -48 + s.charAt(7);
        if (httpMinorVersion < 0 || httpMinorVersion > 9) {
            throw new ProtocolException("Unexpected status line: " + s);
        }
        while (true) {
            while (true) {
                try {
                    final int int1 = Integer.parseInt(s.substring(9, 12));
                    if (b) {
                        final String substring = s.substring(13);
                        this.responseMessage = substring;
                        this.responseCode = int1;
                        this.statusLine = s;
                        this.httpMinorVersion = httpMinorVersion;
                        return;
                    }
                }
                catch (NumberFormatException ex) {
                    throw new ProtocolException("Unexpected status line: " + s);
                }
                final String substring = "";
                continue;
            }
        }
    }
    
    public byte[] toBytes() throws UnsupportedEncodingException {
        final StringBuilder sb = new StringBuilder(256);
        sb.append(this.requestLine).append("\r\n");
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            sb.append(this.namesAndValues.get(i)).append(": ").append(this.namesAndValues.get(i + 1)).append("\r\n");
        }
        sb.append("\r\n");
        return sb.toString().getBytes("ISO-8859-1");
    }
    
    public Map<String, List<String>> toMultimap(final boolean b) {
        final TreeMap<Object, Object> m = new TreeMap<Object, Object>((Comparator<? super Object>)RawHeaders.FIELD_NAME_COMPARATOR);
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            final String s = this.namesAndValues.get(i);
            final String s2 = this.namesAndValues.get(i + 1);
            final ArrayList<String> list = new ArrayList<String>();
            final List<Object> list2 = m.get(s);
            if (list2 != null) {
                list.addAll((Collection<?>)list2);
            }
            list.add(s2);
            m.put(s, Collections.unmodifiableList((List<?>)list));
        }
        if (b && this.statusLine != null) {
            m.put(null, Collections.unmodifiableList((List<?>)Collections.singletonList((T)this.statusLine)));
        }
        else if (this.requestLine != null) {
            m.put(null, Collections.unmodifiableList((List<?>)Collections.singletonList((T)this.requestLine)));
        }
        return Collections.unmodifiableMap((Map<? extends String, ? extends List<String>>)m);
    }
    
    public List<String> toNameValueBlock() {
        final HashSet<String> set = new HashSet<String>();
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            final String lowerCase = this.namesAndValues.get(i).toLowerCase(Locale.US);
            final String str = this.namesAndValues.get(i + 1);
            if (!lowerCase.equals("connection") && !lowerCase.equals("host") && !lowerCase.equals("keep-alive") && !lowerCase.equals("proxy-connection") && !lowerCase.equals("transfer-encoding")) {
                if (set.add(lowerCase)) {
                    list.add(lowerCase);
                    list.add(str);
                }
                else {
                    for (int j = 0; j < list.size(); j += 2) {
                        if (lowerCase.equals(list.get(j))) {
                            list.set(j + 1, String.valueOf(list.get(j + 1)) + "\u0000" + str);
                            break;
                        }
                    }
                }
            }
        }
        return list;
    }
    
    public List<String> values(final String s) {
        List<? extends String> list = null;
        for (int i = 0; i < this.length(); ++i) {
            if (s.equalsIgnoreCase(this.getFieldName(i))) {
                if (list == null) {
                    list = new ArrayList<String>(2);
                }
                list.add(this.getValue(i));
            }
        }
        if (list != null) {
            return (List<String>)Collections.unmodifiableList((List<?>)list);
        }
        return Collections.emptyList();
    }
}
