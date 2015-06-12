import java.security.spec.InvalidKeySpecException;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchProviderException;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import com.socialnmobile.colornote.ColorNote;
import android.content.Context;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

// 
// Decompiled by Procyon v0.5.29
// 

public final class jz
{
    public int a;
    private String b;
    private String c;
    private int d;
    private boolean e;
    private boolean f;
    private SecretKey g;
    private Cipher h;
    private int i;
    private PBEKeySpec j;
    private SecretKeyFactory k;
    private byte[] l;
    
    private jz(final String b, final String c) {
        this.e = false;
        this.f = false;
        this.l = null;
        this.b = b;
        this.c = c;
        this.d = 20;
    }
    
    public static jz a(final int a) {
        jz jz = null;
        switch (a) {
            case 1: {
                jz = b(10);
                jz.a("ColorNote Password");
                break;
            }
            case 2: {
                jz = b(10);
                break;
            }
        }
        jz.a = a;
        return jz;
    }
    
    public static jz a(final Context context) {
        jz jz;
        if (jq.d(context)) {
            jz = a(2);
            jz.b(jq.c(context));
        }
        else {
            jz = a(1);
            jz.a("ColorNote Password");
        }
        jz.c(1);
        return jz;
    }
    
    private boolean a(final boolean b) {
        this.h = null;
        while (true) {
            try {
                this.h = Cipher.getInstance(this.b, this.c);
                if (this.h == null) {
                    return false;
                }
            }
            catch (NoSuchAlgorithmException ex) {
                ColorNote.a("initCipher(): " + ex.toString());
                continue;
            }
            catch (NoSuchPaddingException ex2) {
                ColorNote.a("initCipher(): " + ex2.toString());
                continue;
            }
            catch (NoSuchProviderException ex3) {
                ColorNote.a("initCipher(): " + ex3.toString());
                continue;
            }
            break;
        }
        Label_0139: {
            if (!b) {
                break Label_0139;
            }
            try {
                this.h.init(1, this.g);
                this.i = 1;
                return this.e = true;
                this.h.init(2, this.g);
                this.i = 2;
                return this.e = true;
            }
            catch (InvalidKeyException ex4) {
                ColorNote.a("encrypt(): " + ex4.toString());
                return false;
            }
        }
    }
    
    public static jz b(final int i) {
        byte[] bytes = null;
        Label_0115: {
            Label_0093: {
                try {
                    bytes = "ColorNote Fixed Salt".getBytes("UTF-8");
                    switch (i) {
                        default: {
                            throw new RuntimeException("No Crypto Set" + i);
                        }
                        case 10: {
                            break;
                        }
                        case 20: {
                            break Label_0093;
                        }
                        case 30: {
                            break Label_0115;
                        }
                    }
                }
                catch (UnsupportedEncodingException ex) {
                    return null;
                }
                final jz jz = new jz("PBEWithSHA256And256BitAES-CBC-BC", "BC");
                jz.b(bytes);
                return jz;
            }
            final jz jz2 = new jz("PBEWITHMD5AND128BITAES-CBC-OPENSSL", "BC");
            jz2.b(bytes);
            return jz2;
        }
        final jz jz3 = new jz("PBEWITHMD5AND128BITAES-CBC-OPENSSL", "BC");
        jz3.b(bytes);
        return jz3;
    }
    
    private void b(final byte[] l) {
        this.l = l;
        this.f = false;
    }
    
    private byte[] e(final String s) {
        if (s == null || !this.e || this.i != 1) {
            return null;
        }
        try {
            return this.h.doFinal(s.getBytes("UTF-8"));
        }
        catch (IllegalBlockSizeException ex) {
            ColorNote.a("encrypt(): " + ex.toString());
            return null;
        }
        catch (BadPaddingException ex2) {
            ColorNote.a("encrypt(): " + ex2.toString());
            return null;
        }
        catch (UnsupportedEncodingException ex3) {
            ColorNote.a("encrypt(): " + ex3.toString());
            return null;
        }
    }
    
    public final String a() {
        return String.valueOf(jw.a(this.g.getEncoded()));
    }
    
    public final String a(final byte[] input) {
        if (input == null || !this.e || this.i != 2) {
            return null;
        }
        final byte[] doFinal = this.h.doFinal(input);
        try {
            return new String(doFinal, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            return null;
        }
    }
    
    public final boolean a(final String s) {
        this.e = false;
        if (s == null) {
            throw new RuntimeException("no password");
        }
        if (this.l == null) {
            throw new RuntimeException("no salt");
        }
        try {
            this.k = SecretKeyFactory.getInstance(this.b, this.c);
            this.j = new PBEKeySpec(s.toCharArray(), this.l, this.d);
            final jz jz = this;
            final SecretKeyFactory secretKeyFactory = jz.k;
            final jz jz2 = this;
            final PBEKeySpec pbeKeySpec = jz2.j;
            final SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
            final jz jz3 = this;
            final SecretKey secretKey2 = secretKey;
            final byte[] array = secretKey2.getEncoded();
            final jz jz4 = this;
            final String s2 = jz4.b;
            final SecretKeySpec secretKeySpec = new SecretKeySpec(array, s2);
            jz3.g = secretKeySpec;
            return true;
        }
        catch (NoSuchAlgorithmException ex) {
            ColorNote.a("Crypto : " + ex.toString());
            return false;
        }
        catch (NoSuchProviderException ex2) {
            ColorNote.a("Crypto : " + ex2.toString());
            return false;
        }
        try {
            final jz jz = this;
            final SecretKeyFactory secretKeyFactory = jz.k;
            final jz jz2 = this;
            final PBEKeySpec pbeKeySpec = jz2.j;
            final SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
            final jz jz3 = this;
            final SecretKey secretKey2 = secretKey;
            final byte[] array = secretKey2.getEncoded();
            final jz jz4 = this;
            final String s2 = jz4.b;
            final SecretKeySpec secretKeySpec = new SecretKeySpec(array, s2);
            jz3.g = secretKeySpec;
            return true;
        }
        catch (InvalidKeySpecException ex3) {
            ColorNote.a("setPassword(): " + ex3.toString());
            return false;
        }
    }
    
    public final boolean a(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_3       
        //     2: sipush          10240
        //     5: newarray        B
        //     7: astore          4
        //     9: new             Ljava/io/FileInputStream;
        //    12: dup            
        //    13: aload_1        
        //    14: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
        //    17: astore          5
        //    19: new             Ljavax/crypto/CipherOutputStream;
        //    22: dup            
        //    23: new             Ljava/io/FileOutputStream;
        //    26: dup            
        //    27: aload_2        
        //    28: invokespecial   java/io/FileOutputStream.<init>:(Ljava/lang/String;)V
        //    31: aload_0        
        //    32: getfield        jz.h:Ljavax/crypto/Cipher;
        //    35: invokespecial   javax/crypto/CipherOutputStream.<init>:(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
        //    38: astore          6
        //    40: aload           5
        //    42: aload           4
        //    44: invokevirtual   java/io/FileInputStream.read:([B)I
        //    47: istore          13
        //    49: iload           13
        //    51: ifge            70
        //    54: aload           5
        //    56: invokevirtual   java/io/FileInputStream.close:()V
        //    59: aload           6
        //    61: invokevirtual   javax/crypto/CipherOutputStream.close:()V
        //    64: iconst_1       
        //    65: istore          11
        //    67: iload           11
        //    69: ireturn        
        //    70: aload           6
        //    72: aload           4
        //    74: iconst_0       
        //    75: iload           13
        //    77: invokevirtual   javax/crypto/CipherOutputStream.write:([BII)V
        //    80: goto            40
        //    83: astore          9
        //    85: aload           5
        //    87: astore          10
        //    89: invokestatic    com/socialnmobile/colornote/ColorNote.d:()V
        //    92: aload           10
        //    94: ifnull          102
        //    97: aload           10
        //    99: invokevirtual   java/io/FileInputStream.close:()V
        //   102: iconst_0       
        //   103: istore          11
        //   105: aload           6
        //   107: ifnull          67
        //   110: aload           6
        //   112: invokevirtual   javax/crypto/CipherOutputStream.close:()V
        //   115: iconst_0       
        //   116: ireturn        
        //   117: astore          12
        //   119: iconst_0       
        //   120: ireturn        
        //   121: astore          7
        //   123: aconst_null    
        //   124: astore          5
        //   126: aload           5
        //   128: ifnull          136
        //   131: aload           5
        //   133: invokevirtual   java/io/FileInputStream.close:()V
        //   136: aload_3        
        //   137: ifnull          144
        //   140: aload_3        
        //   141: invokevirtual   javax/crypto/CipherOutputStream.close:()V
        //   144: aload           7
        //   146: athrow         
        //   147: astore          8
        //   149: goto            144
        //   152: astore          7
        //   154: aconst_null    
        //   155: astore_3       
        //   156: goto            126
        //   159: astore          7
        //   161: aload           6
        //   163: astore_3       
        //   164: goto            126
        //   167: astore          7
        //   169: aload           10
        //   171: astore          5
        //   173: aload           6
        //   175: astore_3       
        //   176: goto            126
        //   179: astore          16
        //   181: aconst_null    
        //   182: astore          6
        //   184: aconst_null    
        //   185: astore          10
        //   187: goto            89
        //   190: astore          15
        //   192: aload           5
        //   194: astore          10
        //   196: aconst_null    
        //   197: astore          6
        //   199: goto            89
        //   202: astore          14
        //   204: goto            64
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  9      19     179    190    Ljava/io/IOException;
        //  9      19     121    126    Any
        //  19     40     190    202    Ljava/io/IOException;
        //  19     40     152    159    Any
        //  40     49     83     89     Ljava/io/IOException;
        //  40     49     159    167    Any
        //  54     64     202    207    Ljava/io/IOException;
        //  70     80     83     89     Ljava/io/IOException;
        //  70     80     159    167    Any
        //  89     92     167    179    Any
        //  97     102    117    121    Ljava/io/IOException;
        //  110    115    117    121    Ljava/io/IOException;
        //  131    136    147    152    Ljava/io/IOException;
        //  140    144    147    152    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 102, Size: 102
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:114)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final boolean b(final String s) {
        this.e = false;
        if (s == null) {
            throw new RuntimeException("no key");
        }
        if (this.l == null) {
            throw new RuntimeException("no salt");
        }
        this.g = new SecretKeySpec(jw.a(s), this.b);
        return true;
    }
    
    public final boolean b(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_3       
        //     2: sipush          10240
        //     5: newarray        B
        //     7: astore          4
        //     9: new             Ljava/io/FileInputStream;
        //    12: dup            
        //    13: aload_1        
        //    14: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
        //    17: astore          5
        //    19: new             Ljava/io/FileOutputStream;
        //    22: dup            
        //    23: aload_2        
        //    24: invokespecial   java/io/FileOutputStream.<init>:(Ljava/lang/String;)V
        //    27: astore          6
        //    29: new             Ljavax/crypto/CipherInputStream;
        //    32: dup            
        //    33: aload           5
        //    35: aload_0        
        //    36: getfield        jz.h:Ljavax/crypto/Cipher;
        //    39: invokespecial   javax/crypto/CipherInputStream.<init>:(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
        //    42: astore          7
        //    44: aload           7
        //    46: aload           4
        //    48: invokevirtual   javax/crypto/CipherInputStream.read:([B)I
        //    51: istore          15
        //    53: iload           15
        //    55: ifge            74
        //    58: aload           5
        //    60: invokevirtual   java/io/FileInputStream.close:()V
        //    63: aload           7
        //    65: invokevirtual   javax/crypto/CipherInputStream.close:()V
        //    68: iconst_1       
        //    69: istore          13
        //    71: iload           13
        //    73: ireturn        
        //    74: aload           6
        //    76: aload           4
        //    78: iconst_0       
        //    79: iload           15
        //    81: invokevirtual   java/io/FileOutputStream.write:([BII)V
        //    84: goto            44
        //    87: astore          10
        //    89: aload           6
        //    91: astore          11
        //    93: aload           5
        //    95: astore          12
        //    97: aload           11
        //    99: ifnull          107
        //   102: aload           12
        //   104: invokevirtual   java/io/FileInputStream.close:()V
        //   107: iconst_0       
        //   108: istore          13
        //   110: aload           7
        //   112: ifnull          71
        //   115: aload           7
        //   117: invokevirtual   javax/crypto/CipherInputStream.close:()V
        //   120: iconst_0       
        //   121: ireturn        
        //   122: astore          14
        //   124: iconst_0       
        //   125: ireturn        
        //   126: astore          8
        //   128: aconst_null    
        //   129: astore          6
        //   131: aconst_null    
        //   132: astore          5
        //   134: aload           6
        //   136: ifnull          144
        //   139: aload           5
        //   141: invokevirtual   java/io/FileInputStream.close:()V
        //   144: aload_3        
        //   145: ifnull          152
        //   148: aload_3        
        //   149: invokevirtual   javax/crypto/CipherInputStream.close:()V
        //   152: aload           8
        //   154: athrow         
        //   155: astore          9
        //   157: goto            152
        //   160: astore          8
        //   162: aconst_null    
        //   163: astore_3       
        //   164: aconst_null    
        //   165: astore          6
        //   167: goto            134
        //   170: astore          8
        //   172: aconst_null    
        //   173: astore_3       
        //   174: goto            134
        //   177: astore          8
        //   179: aload           7
        //   181: astore_3       
        //   182: goto            134
        //   185: astore          19
        //   187: aconst_null    
        //   188: astore          7
        //   190: aconst_null    
        //   191: astore          11
        //   193: aconst_null    
        //   194: astore          12
        //   196: goto            97
        //   199: astore          18
        //   201: aload           5
        //   203: astore          12
        //   205: aconst_null    
        //   206: astore          7
        //   208: aconst_null    
        //   209: astore          11
        //   211: goto            97
        //   214: astore          17
        //   216: aload           6
        //   218: astore          11
        //   220: aload           5
        //   222: astore          12
        //   224: aconst_null    
        //   225: astore          7
        //   227: goto            97
        //   230: astore          16
        //   232: goto            68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  9      19     185    199    Ljava/io/IOException;
        //  9      19     126    134    Any
        //  19     29     199    214    Ljava/io/IOException;
        //  19     29     160    170    Any
        //  29     44     214    230    Ljava/io/IOException;
        //  29     44     170    177    Any
        //  44     53     87     97     Ljava/io/IOException;
        //  44     53     177    185    Any
        //  58     68     230    235    Ljava/io/IOException;
        //  74     84     87     97     Ljava/io/IOException;
        //  74     84     177    185    Any
        //  102    107    122    126    Ljava/io/IOException;
        //  115    120    122    126    Ljava/io/IOException;
        //  139    144    155    160    Ljava/io/IOException;
        //  148    152    155    160    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 119, Size: 119
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:114)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final String c(final String s) {
        final byte[] e = this.e(s);
        if (e == null) {
            return null;
        }
        return String.valueOf(jw.a(e));
    }
    
    public final boolean c(final int n) {
        if (n == 1) {
            return this.a(true);
        }
        return this.a(false);
    }
    
    public final String d(final String s) {
        return this.a(jw.a(s));
    }
}
