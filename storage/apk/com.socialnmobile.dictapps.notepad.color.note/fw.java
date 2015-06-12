import java.util.Arrays;
import android.telephony.TelephonyManager;

// 
// Decompiled by Procyon v0.5.29
// 

public class fw
{
    private static final String a;
    private static byte[] b;
    
    static {
        a = fw.class.getSimpleName();
    }
    
    public static byte[] a() {
        if (fw.b != null) {
            return fw.b;
        }
        if (fq.a.b.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return null;
        }
        final TelephonyManager telephonyManager = (TelephonyManager)fq.a.b.getSystemService("phone");
    Label_0088:
        while (true) {
            if (telephonyManager == null) {
                break Label_0088;
            }
            final String deviceId = telephonyManager.getDeviceId();
            if (deviceId == null || deviceId.trim().length() <= 0) {
                break Label_0088;
            }
            while (true) {
                try {
                    final byte[] b = gl.b(deviceId);
                    if (b != null && b.length == 20) {
                        fw.b = b;
                    }
                    else {
                        final String a = fw.a;
                        gj.a(6, "sha1 is not 20 bytes long: " + Arrays.toString(b));
                    }
                    return fw.b;
                }
                catch (Exception ex) {
                    final String a2 = fw.a;
                    gj.a(6, "Exception in generateHashedImei()");
                    return fw.b;
                }
                continue Label_0088;
            }
            break;
        }
    }
}
