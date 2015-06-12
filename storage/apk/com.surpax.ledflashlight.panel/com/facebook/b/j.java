// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import org.json.JSONException;
import java.io.IOException;
import com.facebook.ak;
import org.json.JSONTokener;
import org.json.JSONObject;
import java.io.InputStream;

final class j
{
    static JSONObject a(final InputStream inputStream) {
        int n = 0;
        if (inputStream.read() != 0) {
            return null;
        }
        int n2 = 0;
        int n3 = 0;
        while (true) {
            Label_0099: {
                if (n2 < 3) {
                    break Label_0099;
                }
                final byte[] array = new byte[n3];
                while (true) {
                    Label_0142: {
                        if (n < array.length) {
                            break Label_0142;
                        }
                        final JSONTokener jsonTokener = new JSONTokener(new String(array));
                        try {
                            final Object nextValue = jsonTokener.nextValue();
                            if (!(nextValue instanceof JSONObject)) {
                                v.a(ak.d, c.a, "readHeader: expected JSONObject, got " + ((JSONObject)nextValue).getClass().getCanonicalName());
                                return null;
                            }
                            return (JSONObject)nextValue;
                            final int read = inputStream.read(array, n, array.length - n);
                            // iftrue(Label_0202:, read > 0)
                            // iftrue(Label_0124:, read2 != -1)
                            Block_7: {
                                Block_8: {
                                    break Block_8;
                                    final int read2 = inputStream.read();
                                    break Block_7;
                                }
                                v.a(ak.d, c.a, "readHeader: stream.read stopped at " + (Object)n + " when expected " + array.length);
                                return null;
                                Label_0202: {
                                    n += read;
                                }
                                continue;
                            }
                            v.a(ak.d, c.a, "readHeader: stream.read returned -1 while reading header size");
                            return null;
                            Label_0124: {
                                final int read2;
                                n3 = (n3 << 8) + (read2 & 0xFF);
                            }
                            ++n2;
                        }
                        catch (JSONException ex) {
                            throw new IOException(ex.getMessage());
                        }
                    }
                    break;
                }
            }
        }
    }
}
