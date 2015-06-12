// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.webkit.WebView;
import android.os.Build$VERSION;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import android.webkit.WebViewClient;
import java.util.Iterator;
import java.util.List;
import android.net.Uri;
import android.content.Context;

class AdWebViewClient$AmazonMobileExecutor implements AdWebViewClient$UrlExecutor
{
    private final AdView adView;
    private final Context context;
    
    AdWebViewClient$AmazonMobileExecutor(final AdView adView, final Context context) {
        this.adView = adView;
        this.context = context;
    }
    
    @Override
    public boolean execute(final String s) {
        this.specialUrlClicked(s);
        return true;
    }
    
    protected void handleApplicationDefinedSpecialURL(final String s) {
        Log.i(AdWebViewClient.LOG_TAG, "Special url clicked, but was not handled by SDK. Url: %s", s);
    }
    
    protected boolean launchExternalActivity(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Landroid/content/Intent;
        //     3: dup            
        //     4: invokespecial   android/content/Intent.<init>:()V
        //     7: astore_2       
        //     8: aload_1        
        //     9: ldc             "intent:"
        //    11: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    14: ifeq            51
        //    17: aload_1        
        //    18: iconst_1       
        //    19: invokestatic    android/content/Intent.parseUri:(Ljava/lang/String;I)Landroid/content/Intent;
        //    22: astore          8
        //    24: aload           8
        //    26: astore_2       
        //    27: aload_2        
        //    28: ldc             "android.intent.action.VIEW"
        //    30: invokevirtual   android/content/Intent.setAction:(Ljava/lang/String;)Landroid/content/Intent;
        //    33: pop            
        //    34: aload_2        
        //    35: ldc             268435456
        //    37: invokevirtual   android/content/Intent.addFlags:(I)Landroid/content/Intent;
        //    40: pop            
        //    41: aload_0        
        //    42: getfield        com/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor.context:Landroid/content/Context;
        //    45: aload_2        
        //    46: invokevirtual   android/content/Context.startActivity:(Landroid/content/Intent;)V
        //    49: iconst_1       
        //    50: ireturn        
        //    51: aload_2        
        //    52: aload_1        
        //    53: invokestatic    android/net/Uri.parse:(Ljava/lang/String;)Landroid/net/Uri;
        //    56: invokevirtual   android/content/Intent.setData:(Landroid/net/Uri;)Landroid/content/Intent;
        //    59: pop            
        //    60: goto            27
        //    63: astore          7
        //    65: iconst_0       
        //    66: ireturn        
        //    67: astore          4
        //    69: iconst_0       
        //    70: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                       
        //  -----  -----  -----  -----  -------------------------------------------
        //  17     24     63     67     Ljava/net/URISyntaxException;
        //  27     49     67     71     Landroid/content/ActivityNotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0027:
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
    
    public void specialUrlClicked(final String s) {
        if (this.adView == null || !this.adView.isAdViewRenderable()) {
            Log.d(AdWebViewClient.LOG_TAG, "AdView is Null");
        }
        else {
            Log.d(AdWebViewClient.LOG_TAG, "Executing AmazonMobile Intent");
            final Uri parse = Uri.parse(s);
            Label_0118: {
            Label_0112:
                while (true) {
                    try {
                        final List<String> queryParameters = (List<String>)parse.getQueryParameters("intent");
                        if (queryParameters != null && queryParameters.size() > 0) {
                            final Iterator<String> iterator = queryParameters.iterator();
                            while (iterator.hasNext()) {
                                if (this.launchExternalActivity(iterator.next())) {
                                    return;
                                }
                            }
                            break Label_0112;
                        }
                        break Label_0118;
                    }
                    catch (UnsupportedOperationException ex) {
                        final List<String> queryParameters = null;
                        continue;
                    }
                    break;
                }
                this.handleApplicationDefinedSpecialURL(s);
                return;
            }
            if (!AmazonDeviceLauncher.isWindowshopPresent(this.context)) {
                this.handleApplicationDefinedSpecialURL(s);
                return;
            }
            if (parse.getHost().equals("shopping")) {
                final String queryParameter = parse.getQueryParameter("app-action");
                if (queryParameter != null && queryParameter.length() != 0) {
                    if (queryParameter.equals("detail")) {
                        final String queryParameter2 = parse.getQueryParameter("asin");
                        if (queryParameter2 != null && queryParameter2.length() != 0) {
                            AmazonDeviceLauncher.launchWindowshopDetailPage(this.context, queryParameter2);
                        }
                    }
                    else if (queryParameter.equals("search")) {
                        final String queryParameter3 = parse.getQueryParameter("keyword");
                        if (queryParameter3 != null && queryParameter3.length() != 0) {
                            AmazonDeviceLauncher.launchWindowshopSearchPage(this.context, queryParameter3);
                        }
                    }
                    else if (queryParameter.equals("webview")) {
                        this.handleApplicationDefinedSpecialURL(s);
                    }
                }
            }
        }
    }
}
