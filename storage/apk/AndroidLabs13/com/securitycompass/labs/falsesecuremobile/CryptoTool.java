// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.labs.falsesecuremobile;

import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.Key;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;

public class CryptoTool
{
    public static final String CRYPTO_SPEC = "AES/CBC/PKCS5Padding";
    public static final String DEFAULT_B64_KEY_STRING = "T0xXpDs1lT9q36aPehvDnaX3EgaFlM4JKIGYvqTqld0=";
    public static final int IV_BYTES = 16;
    public static final int KEY_BITS = 256;
    public static final int NUM_ITERATIONS = 1000;
    public static final int SALT_BYTES = 32;
    
    public byte[] decodeB64(final String s) {
        return Base64.decode(s, 0);
    }
    
    public String decryptB64String(final String s, final byte[] key, final byte[] iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        final byte[] decode = Base64.decode(s, 0);
        final SecretKeySpec key2 = new SecretKeySpec(key, "AES");
        final Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, key2, new IvParameterSpec(iv));
        return new String(instance.doFinal(decode));
    }
    
    public String decryptBytes(final byte[] input, final byte[] key, final byte[] iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        final SecretKeySpec key2 = new SecretKeySpec(key, "AES");
        final Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, key2, new IvParameterSpec(iv));
        return new String(instance.doFinal(input));
    }
    
    public byte[] encrypt(final byte[] input, final byte[] key, final byte[] iv) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        final SecretKeySpec key2 = new SecretKeySpec(key, "AES");
        final Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, key2, new IvParameterSpec(iv));
        return instance.doFinal(input);
    }
    
    public String encryptToB64String(final String s, final byte[] key, final byte[] iv) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        final SecretKeySpec key2 = new SecretKeySpec(key, "AES");
        final Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, key2, new IvParameterSpec(iv));
        return new String(Base64.encode(instance.doFinal(s.getBytes()), 0));
    }
    
    public SecretKey genKeyPwkdf2(final String s, final byte[] salt, final int iterationCount) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(s.toCharArray(), salt, iterationCount, 256));
    }
    
    public String genRandomBase64KeyString() throws NoSuchAlgorithmException {
        return new String(Base64.encode(this.genRandomKey().getEncoded(), 0));
    }
    
    public SecretKey genRandomKey() throws NoSuchAlgorithmException {
        final KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(256);
        return instance.generateKey();
    }
    
    public byte[] getIv() {
        final SecureRandom secureRandom = new SecureRandom();
        final byte[] bytes = new byte[16];
        secureRandom.nextBytes(bytes);
        return bytes;
    }
    
    public byte[] getSalt() {
        final SecureRandom secureRandom = new SecureRandom();
        final byte[] bytes = new byte[32];
        secureRandom.nextBytes(bytes);
        return bytes;
    }
}
