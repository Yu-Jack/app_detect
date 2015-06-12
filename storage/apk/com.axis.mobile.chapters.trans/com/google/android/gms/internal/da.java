// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.security.KeyFactory;
import android.text.TextUtils;
import java.security.SignatureException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import android.util.Base64;
import java.security.Signature;
import java.security.PublicKey;

public class da
{
    public static boolean a(final PublicKey publicKey, final String s, final String s2) {
        try {
            final Signature instance = Signature.getInstance("SHA1withRSA");
            instance.initVerify(publicKey);
            instance.update(s.getBytes());
            if (!instance.verify(Base64.decode(s2, 0))) {
                eu.A("Signature verification failed.");
                return false;
            }
            return true;
        }
        catch (NoSuchAlgorithmException ex) {
            eu.A("NoSuchAlgorithmException.");
            return false;
        }
        catch (InvalidKeyException ex2) {
            eu.A("Invalid key specification.");
            return false;
        }
        catch (SignatureException ex3) {
            eu.A("Signature exception.");
            return false;
        }
    }
    
    public static boolean b(final String s, final String s2, final String s3) {
        if (TextUtils.isEmpty((CharSequence)s2) || TextUtils.isEmpty((CharSequence)s) || TextUtils.isEmpty((CharSequence)s3)) {
            eu.A("Purchase verification failed: missing data.");
            return false;
        }
        return a(r(s), s2, s3);
    }
    
    public static PublicKey r(final String s) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(s, 0)));
        }
        catch (NoSuchAlgorithmException cause) {
            throw new RuntimeException(cause);
        }
        catch (InvalidKeySpecException cause2) {
            eu.A("Invalid key specification.");
            throw new IllegalArgumentException(cause2);
        }
    }
}
