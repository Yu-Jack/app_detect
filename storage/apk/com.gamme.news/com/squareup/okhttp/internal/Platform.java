// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal;

import java.lang.reflect.InvocationHandler;
import java.util.List;
import java.util.ArrayList;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URI;
import java.net.URL;
import java.net.SocketException;
import java.lang.reflect.InvocationTargetException;
import java.util.zip.Deflater;
import java.io.OutputStream;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.zip.DeflaterOutputStream;
import java.lang.reflect.Constructor;

public class Platform
{
    private static final Platform PLATFORM;
    private Constructor<DeflaterOutputStream> deflaterConstructor;
    
    static {
        PLATFORM = findPlatform();
    }
    
    private static Platform findPlatform() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: ldc             "com.android.org.conscrypt.OpenSSLSocketImpl"
        //     2: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //     5: astore          17
        //     7: aload           17
        //     9: astore          10
        //    11: iconst_1       
        //    12: anewarray       Ljava/lang/Class;
        //    15: astore          11
        //    17: aload           11
        //    19: iconst_0       
        //    20: getstatic       java/lang/Boolean.TYPE:Ljava/lang/Class;
        //    23: aastore        
        //    24: aload           10
        //    26: ldc             "setUseSessionTickets"
        //    28: aload           11
        //    30: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    33: astore          12
        //    35: aload           10
        //    37: ldc             "setHostname"
        //    39: iconst_1       
        //    40: anewarray       Ljava/lang/Class;
        //    43: dup            
        //    44: iconst_0       
        //    45: ldc             Ljava/lang/String;.class
        //    47: aastore        
        //    48: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    51: astore          13
        //    53: new             Lcom/squareup/okhttp/internal/Platform$Android41;
        //    56: dup            
        //    57: aload           10
        //    59: aload           12
        //    61: aload           13
        //    63: aload           10
        //    65: ldc             "setNpnProtocols"
        //    67: iconst_1       
        //    68: anewarray       Ljava/lang/Class;
        //    71: dup            
        //    72: iconst_0       
        //    73: ldc             [B.class
        //    75: aastore        
        //    76: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    79: aload           10
        //    81: ldc             "getNpnSelectedProtocol"
        //    83: iconst_0       
        //    84: anewarray       Ljava/lang/Class;
        //    87: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    90: aconst_null    
        //    91: invokespecial   com/squareup/okhttp/internal/Platform$Android41.<init>:(Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/squareup/okhttp/internal/Platform$Android41;)V
        //    94: astore          14
        //    96: aload           14
        //    98: areturn        
        //    99: astore          8
        //   101: ldc             "org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl"
        //   103: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   106: astore          10
        //   108: goto            11
        //   111: astore          15
        //   113: new             Lcom/squareup/okhttp/internal/Platform$Android23;
        //   116: dup            
        //   117: aload           10
        //   119: aload           12
        //   121: aload           13
        //   123: aconst_null    
        //   124: aconst_null    
        //   125: invokespecial   com/squareup/okhttp/internal/Platform$Android23.<init>:(Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/squareup/okhttp/internal/Platform$Android23;Lcom/squareup/okhttp/internal/Platform$Android23;)V
        //   128: astore          16
        //   130: aload           16
        //   132: areturn        
        //   133: astore_0       
        //   134: ldc             "org.eclipse.jetty.npn.NextProtoNego"
        //   136: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   139: astore_3       
        //   140: new             Ljava/lang/StringBuilder;
        //   143: dup            
        //   144: ldc             "org.eclipse.jetty.npn.NextProtoNego"
        //   146: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   149: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   152: ldc             "$Provider"
        //   154: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   157: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   160: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   163: astore          4
        //   165: new             Ljava/lang/StringBuilder;
        //   168: dup            
        //   169: ldc             "org.eclipse.jetty.npn.NextProtoNego"
        //   171: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   174: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   177: ldc             "$ClientProvider"
        //   179: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   182: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   185: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   188: astore          5
        //   190: new             Ljava/lang/StringBuilder;
        //   193: dup            
        //   194: ldc             "org.eclipse.jetty.npn.NextProtoNego"
        //   196: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   199: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   202: ldc             "$ServerProvider"
        //   204: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   207: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   210: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   213: astore          6
        //   215: new             Lcom/squareup/okhttp/internal/Platform$JdkWithJettyNpnPlatform;
        //   218: dup            
        //   219: aload_3        
        //   220: ldc             "put"
        //   222: iconst_2       
        //   223: anewarray       Ljava/lang/Class;
        //   226: dup            
        //   227: iconst_0       
        //   228: ldc             Ljavax/net/ssl/SSLSocket;.class
        //   230: aastore        
        //   231: dup            
        //   232: iconst_1       
        //   233: aload           4
        //   235: aastore        
        //   236: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   239: aload_3        
        //   240: ldc             "get"
        //   242: iconst_1       
        //   243: anewarray       Ljava/lang/Class;
        //   246: dup            
        //   247: iconst_0       
        //   248: ldc             Ljavax/net/ssl/SSLSocket;.class
        //   250: aastore        
        //   251: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   254: aload           5
        //   256: aload           6
        //   258: invokespecial   com/squareup/okhttp/internal/Platform$JdkWithJettyNpnPlatform.<init>:(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
        //   261: astore          7
        //   263: aload           7
        //   265: areturn        
        //   266: astore_2       
        //   267: new             Lcom/squareup/okhttp/internal/Platform;
        //   270: dup            
        //   271: invokespecial   com/squareup/okhttp/internal/Platform.<init>:()V
        //   274: areturn        
        //   275: astore_1       
        //   276: goto            267
        //   279: astore          9
        //   281: goto            134
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  0      7      99     111    Ljava/lang/ClassNotFoundException;
        //  0      7      133    134    Ljava/lang/NoSuchMethodException;
        //  11     53     279    284    Ljava/lang/ClassNotFoundException;
        //  11     53     133    134    Ljava/lang/NoSuchMethodException;
        //  53     96     111    133    Ljava/lang/NoSuchMethodException;
        //  53     96     279    284    Ljava/lang/ClassNotFoundException;
        //  101    108    279    284    Ljava/lang/ClassNotFoundException;
        //  101    108    133    134    Ljava/lang/NoSuchMethodException;
        //  113    130    279    284    Ljava/lang/ClassNotFoundException;
        //  113    130    133    134    Ljava/lang/NoSuchMethodException;
        //  134    263    266    267    Ljava/lang/ClassNotFoundException;
        //  134    263    275    279    Ljava/lang/NoSuchMethodException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0011:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    
    public static Platform get() {
        return Platform.PLATFORM;
    }
    
    public void connectSocket(final Socket socket, final InetSocketAddress endpoint, final int timeout) throws IOException {
        socket.connect(endpoint, timeout);
    }
    
    public void enableTlsExtensions(final SSLSocket sslSocket, final String s) {
    }
    
    public byte[] getNpnSelectedProtocol(final SSLSocket sslSocket) {
        return null;
    }
    
    public String getPrefix() {
        return "OkHttp";
    }
    
    public void logW(final String x) {
        System.out.println(x);
    }
    
    public OutputStream newDeflaterOutputStream(final OutputStream outputStream, final Deflater deflater, final boolean b) {
        try {
            Constructor<DeflaterOutputStream> deflaterConstructor = this.deflaterConstructor;
            if (deflaterConstructor == null) {
                deflaterConstructor = DeflaterOutputStream.class.getConstructor(OutputStream.class, Deflater.class, Boolean.TYPE);
                this.deflaterConstructor = deflaterConstructor;
            }
            return deflaterConstructor.newInstance(outputStream, deflater, b);
        }
        catch (NoSuchMethodException ex3) {
            throw new UnsupportedOperationException("Cannot SPDY; no SYNC_FLUSH available");
        }
        catch (InvocationTargetException ex) {
            RuntimeException ex2;
            if (ex.getCause() instanceof RuntimeException) {
                ex2 = (RuntimeException)ex.getCause();
            }
            else {
                ex2 = new RuntimeException(ex.getCause());
            }
            throw ex2;
        }
        catch (InstantiationException cause) {
            throw new RuntimeException(cause);
        }
        catch (IllegalAccessException ex4) {
            throw new AssertionError();
        }
    }
    
    public void setNpnProtocols(final SSLSocket sslSocket, final byte[] array) {
    }
    
    public void supportTlsIntolerantServer(final SSLSocket sslSocket) {
        sslSocket.setEnabledProtocols(new String[] { "SSLv3" });
    }
    
    public void tagSocket(final Socket socket) throws SocketException {
    }
    
    public URI toUriLenient(final URL url) throws URISyntaxException {
        return url.toURI();
    }
    
    public void untagSocket(final Socket socket) throws SocketException {
    }
    
    private static class Android23 extends Platform
    {
        protected final Class<?> openSslSocketClass;
        private final Method setHostname;
        private final Method setUseSessionTickets;
        
        private Android23(final Class<?> openSslSocketClass, final Method setUseSessionTickets, final Method setHostname) {
            this.openSslSocketClass = openSslSocketClass;
            this.setUseSessionTickets = setUseSessionTickets;
            this.setHostname = setHostname;
        }
        
        @Override
        public void connectSocket(final Socket socket, final InetSocketAddress endpoint, final int timeout) throws IOException {
            try {
                socket.connect(endpoint, timeout);
            }
            catch (SecurityException cause) {
                final IOException ex = new IOException("Exception in connect");
                ex.initCause(cause);
                throw ex;
            }
        }
        
        @Override
        public void enableTlsExtensions(final SSLSocket sslSocket, final String s) {
            super.enableTlsExtensions(sslSocket, s);
            if (!this.openSslSocketClass.isInstance(sslSocket)) {
                return;
            }
            try {
                this.setUseSessionTickets.invoke(sslSocket, true);
                this.setHostname.invoke(sslSocket, s);
            }
            catch (InvocationTargetException cause) {
                throw new RuntimeException(cause);
            }
            catch (IllegalAccessException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
    }
    
    private static class Android41 extends Android23
    {
        private final Method getNpnSelectedProtocol;
        private final Method setNpnProtocols;
        
        private Android41(final Class<?> clazz, final Method method, final Method method2, final Method setNpnProtocols, final Method getNpnSelectedProtocol) {
            super(clazz, method, method2, null);
            this.setNpnProtocols = setNpnProtocols;
            this.getNpnSelectedProtocol = getNpnSelectedProtocol;
        }
        
        @Override
        public byte[] getNpnSelectedProtocol(final SSLSocket obj) {
            if (!this.openSslSocketClass.isInstance(obj)) {
                return null;
            }
            try {
                return (byte[])this.getNpnSelectedProtocol.invoke(obj, new Object[0]);
            }
            catch (InvocationTargetException cause) {
                throw new RuntimeException(cause);
            }
            catch (IllegalAccessException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public void setNpnProtocols(final SSLSocket obj, final byte[] array) {
            if (!this.openSslSocketClass.isInstance(obj)) {
                return;
            }
            try {
                this.setNpnProtocols.invoke(obj, array);
            }
            catch (IllegalAccessException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
            catch (InvocationTargetException cause) {
                throw new RuntimeException(cause);
            }
        }
    }
    
    private static class JdkWithJettyNpnPlatform extends Platform
    {
        private final Class<?> clientProviderClass;
        private final Method getMethod;
        private final Method putMethod;
        private final Class<?> serverProviderClass;
        
        public JdkWithJettyNpnPlatform(final Method putMethod, final Method getMethod, final Class<?> clientProviderClass, final Class<?> serverProviderClass) {
            this.putMethod = putMethod;
            this.getMethod = getMethod;
            this.clientProviderClass = clientProviderClass;
            this.serverProviderClass = serverProviderClass;
        }
        
        @Override
        public byte[] getNpnSelectedProtocol(final SSLSocket sslSocket) {
            try {
                final JettyNpnProvider jettyNpnProvider = (JettyNpnProvider)Proxy.getInvocationHandler(this.getMethod.invoke(null, sslSocket));
                if (!jettyNpnProvider.unsupported && jettyNpnProvider.selected == null) {
                    Logger.getLogger("com.squareup.okhttp.OkHttpClient").log(Level.INFO, "NPN callback dropped so SPDY is disabled. Is npn-boot on the boot class path?");
                    return null;
                }
                if (!jettyNpnProvider.unsupported) {
                    return jettyNpnProvider.selected.getBytes("US-ASCII");
                }
            }
            catch (UnsupportedEncodingException ex) {
                throw new AssertionError();
            }
            catch (InvocationTargetException ex2) {
                throw new AssertionError();
            }
            catch (IllegalAccessException ex3) {
                throw new AssertionError();
            }
            return null;
        }
        
        @Override
        public void setNpnProtocols(final SSLSocket sslSocket, final byte[] bytes) {
            try {
                final ArrayList<String> list = new ArrayList<String>();
                int offset;
                byte length;
                for (int i = 0; i < bytes.length; i = offset + length) {
                    offset = i + 1;
                    length = bytes[i];
                    list.add(new String(bytes, offset, length, "US-ASCII"));
                }
                this.putMethod.invoke(null, sslSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[] { this.clientProviderClass, this.serverProviderClass }, new JettyNpnProvider(list)));
            }
            catch (UnsupportedEncodingException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
            catch (InvocationTargetException detailMessage2) {
                throw new AssertionError((Object)detailMessage2);
            }
            catch (IllegalAccessException detailMessage3) {
                throw new AssertionError((Object)detailMessage3);
            }
        }
    }
    
    private static class JettyNpnProvider implements InvocationHandler
    {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;
        
        public JettyNpnProvider(final List<String> protocols) {
            this.protocols = protocols;
        }
        
        @Override
        public Object invoke(final Object o, final Method method, Object[] empty_STRING_ARRAY) throws Throwable {
            final String name = method.getName();
            final Class<?> returnType = method.getReturnType();
            if (empty_STRING_ARRAY == null) {
                empty_STRING_ARRAY = Util.EMPTY_STRING_ARRAY;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.unsupported = true;
                return null;
            }
            if (name.equals("protocols") && empty_STRING_ARRAY.length == 0) {
                return this.protocols;
            }
            if (name.equals("selectProtocol") && String.class == returnType && empty_STRING_ARRAY.length == 1 && (empty_STRING_ARRAY[0] == null || empty_STRING_ARRAY[0] instanceof List)) {
                final List list = (List)empty_STRING_ARRAY[0];
                return this.selected = this.protocols.get(0);
            }
            if (name.equals("protocolSelected") && empty_STRING_ARRAY.length == 1) {
                this.selected = (String)empty_STRING_ARRAY[0];
                return null;
            }
            return method.invoke(this, empty_STRING_ARRAY);
        }
    }
}
