// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.print;

import android.os.CancellationSignal$OnCancelListener;
import android.os.AsyncTask;
import android.print.PrintAttributes$Builder;
import android.print.PrintDocumentAdapter$WriteResultCallback;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintDocumentInfo;
import android.print.PrintDocumentInfo$Builder;
import android.os.Bundle;
import android.print.PrintDocumentAdapter$LayoutResultCallback;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintAttributes$MediaSize;
import android.print.PrintManager;
import java.io.InputStream;
import java.io.IOException;
import android.util.Log;
import android.graphics.Rect;
import android.graphics.BitmapFactory;
import java.io.FileNotFoundException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.BitmapFactory$Options;
import android.content.Context;

class PrintHelperKitkat
{
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    private static final String LOG_TAG = "PrintHelperKitkat";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    int mColorMode;
    final Context mContext;
    BitmapFactory$Options mDecodeOptions;
    private final Object mLock;
    int mOrientation;
    int mScaleMode;
    
    PrintHelperKitkat(final Context mContext) {
        this.mDecodeOptions = null;
        this.mLock = new Object();
        this.mScaleMode = 2;
        this.mColorMode = 2;
        this.mOrientation = 1;
        this.mContext = mContext;
    }
    
    private Matrix getMatrix(final int n, final int n2, final RectF rectF, final int n3) {
        final Matrix matrix = new Matrix();
        final float n4 = rectF.width() / n;
        float n5;
        if (n3 == 2) {
            n5 = Math.max(n4, rectF.height() / n2);
        }
        else {
            n5 = Math.min(n4, rectF.height() / n2);
        }
        matrix.postScale(n5, n5);
        matrix.postTranslate((rectF.width() - n5 * n) / 2.0f, (rectF.height() - n5 * n2) / 2.0f);
        return matrix;
    }
    
    private Bitmap loadBitmap(final Uri uri, final BitmapFactory$Options bitmapFactory$Options) throws FileNotFoundException {
        if (uri == null || this.mContext == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        InputStream openInputStream = null;
        try {
            openInputStream = this.mContext.getContentResolver().openInputStream(uri);
            final Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, (Rect)null, bitmapFactory$Options);
            if (openInputStream == null) {
                return decodeStream;
            }
            try {
                openInputStream.close();
                return decodeStream;
            }
            catch (IOException ex) {
                Log.w("PrintHelperKitkat", "close fail ", (Throwable)ex);
                return decodeStream;
            }
        }
        finally {
            Label_0079: {
                if (openInputStream == null) {
                    break Label_0079;
                }
                try {
                    openInputStream.close();
                }
                catch (IOException ex2) {
                    Log.w("PrintHelperKitkat", "close fail ", (Throwable)ex2);
                }
            }
        }
    }
    
    private Bitmap loadConstrainedBitmap(final Uri uri, final int n) throws FileNotFoundException {
        if (n <= 0 || uri == null || this.mContext == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        final BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        bitmapFactory$Options.inJustDecodeBounds = true;
        this.loadBitmap(uri, bitmapFactory$Options);
        final int outWidth = bitmapFactory$Options.outWidth;
        final int outHeight = bitmapFactory$Options.outHeight;
        if (outWidth > 0 && outHeight > 0) {
            int i;
            int inSampleSize;
            for (i = Math.max(outWidth, outHeight), inSampleSize = 1; i > n; i >>>= 1, inSampleSize <<= 1) {}
            if (inSampleSize > 0 && Math.min(outWidth, outHeight) / inSampleSize > 0) {
                final Object mLock = this.mLock;
                final BitmapFactory$Options mDecodeOptions;
                synchronized (mLock) {
                    this.mDecodeOptions = new BitmapFactory$Options();
                    this.mDecodeOptions.inMutable = true;
                    this.mDecodeOptions.inSampleSize = inSampleSize;
                    mDecodeOptions = this.mDecodeOptions;
                    // monitorexit(mLock)
                    final PrintHelperKitkat printHelperKitkat = this;
                    final Uri uri2 = uri;
                    final BitmapFactory$Options bitmapFactory$Options2 = mDecodeOptions;
                    final Bitmap bitmap = printHelperKitkat.loadBitmap(uri2, bitmapFactory$Options2);
                    final PrintHelperKitkat printHelperKitkat2 = this;
                    final Object o = printHelperKitkat2.mLock;
                    final Object o3;
                    final Object o2 = o3 = o;
                    synchronized (o3) {
                        final PrintHelperKitkat printHelperKitkat3 = this;
                        final BitmapFactory$Options bitmapFactory$Options3 = null;
                        printHelperKitkat3.mDecodeOptions = bitmapFactory$Options3;
                        return bitmap;
                    }
                }
                try {
                    final PrintHelperKitkat printHelperKitkat = this;
                    final Uri uri2 = uri;
                    final BitmapFactory$Options bitmapFactory$Options2 = mDecodeOptions;
                    final Bitmap bitmap = printHelperKitkat.loadBitmap(uri2, bitmapFactory$Options2);
                    final PrintHelperKitkat printHelperKitkat2 = this;
                    final Object o = printHelperKitkat2.mLock;
                    final Object o3;
                    final Object o2 = o3 = o;
                    // monitorenter(o3)
                    final PrintHelperKitkat printHelperKitkat3 = this;
                    final BitmapFactory$Options bitmapFactory$Options3 = null;
                    printHelperKitkat3.mDecodeOptions = bitmapFactory$Options3;
                    return bitmap;
                }
                finally {
                    synchronized (this.mLock) {
                        this.mDecodeOptions = null;
                    }
                    // monitorexit(this.mLock)
                }
            }
        }
        return null;
    }
    
    public int getColorMode() {
        return this.mColorMode;
    }
    
    public int getOrientation() {
        return this.mOrientation;
    }
    
    public int getScaleMode() {
        return this.mScaleMode;
    }
    
    public void printBitmap(final String s, final Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        final int mScaleMode = this.mScaleMode;
        final PrintManager printManager = (PrintManager)this.mContext.getSystemService("print");
        PrintAttributes$MediaSize mediaSize = PrintAttributes$MediaSize.UNKNOWN_PORTRAIT;
        if (bitmap.getWidth() > bitmap.getHeight()) {
            mediaSize = PrintAttributes$MediaSize.UNKNOWN_LANDSCAPE;
        }
        printManager.print(s, (PrintDocumentAdapter)new PrintDocumentAdapter() {
            private PrintAttributes mAttributes;
            
            public void onLayout(final PrintAttributes printAttributes, final PrintAttributes mAttributes, final CancellationSignal cancellationSignal, final PrintDocumentAdapter$LayoutResultCallback printDocumentAdapter$LayoutResultCallback, final Bundle bundle) {
                int n = 1;
                this.mAttributes = mAttributes;
                final PrintDocumentInfo build = new PrintDocumentInfo$Builder(s).setContentType(n).setPageCount(n).build();
                if (mAttributes.equals((Object)printAttributes)) {
                    n = 0;
                }
                printDocumentAdapter$LayoutResultCallback.onLayoutFinished(build, (boolean)(n != 0));
            }
            
            public void onWrite(final PageRange[] p0, final ParcelFileDescriptor p1, final CancellationSignal p2, final PrintDocumentAdapter$WriteResultCallback p3) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     0: new             Landroid/print/pdf/PrintedPdfDocument;
                //     3: dup            
                //     4: aload_0        
                //     5: getfield        android/support/v4/print/PrintHelperKitkat$1.this$0:Landroid/support/v4/print/PrintHelperKitkat;
                //     8: getfield        android/support/v4/print/PrintHelperKitkat.mContext:Landroid/content/Context;
                //    11: aload_0        
                //    12: getfield        android/support/v4/print/PrintHelperKitkat$1.mAttributes:Landroid/print/PrintAttributes;
                //    15: invokespecial   android/print/pdf/PrintedPdfDocument.<init>:(Landroid/content/Context;Landroid/print/PrintAttributes;)V
                //    18: astore          5
                //    20: aload           5
                //    22: iconst_1       
                //    23: invokevirtual   android/print/pdf/PrintedPdfDocument.startPage:(I)Landroid/graphics/pdf/PdfDocument$Page;
                //    26: astore          8
                //    28: new             Landroid/graphics/RectF;
                //    31: dup            
                //    32: aload           8
                //    34: invokevirtual   android/graphics/pdf/PdfDocument$Page.getInfo:()Landroid/graphics/pdf/PdfDocument$PageInfo;
                //    37: invokevirtual   android/graphics/pdf/PdfDocument$PageInfo.getContentRect:()Landroid/graphics/Rect;
                //    40: invokespecial   android/graphics/RectF.<init>:(Landroid/graphics/Rect;)V
                //    43: astore          9
                //    45: aload_0        
                //    46: getfield        android/support/v4/print/PrintHelperKitkat$1.this$0:Landroid/support/v4/print/PrintHelperKitkat;
                //    49: aload_0        
                //    50: getfield        android/support/v4/print/PrintHelperKitkat$1.val$bitmap:Landroid/graphics/Bitmap;
                //    53: invokevirtual   android/graphics/Bitmap.getWidth:()I
                //    56: aload_0        
                //    57: getfield        android/support/v4/print/PrintHelperKitkat$1.val$bitmap:Landroid/graphics/Bitmap;
                //    60: invokevirtual   android/graphics/Bitmap.getHeight:()I
                //    63: aload           9
                //    65: aload_0        
                //    66: getfield        android/support/v4/print/PrintHelperKitkat$1.val$fittingMode:I
                //    69: invokestatic    android/support/v4/print/PrintHelperKitkat.access$000:(Landroid/support/v4/print/PrintHelperKitkat;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
                //    72: astore          10
                //    74: aload           8
                //    76: invokevirtual   android/graphics/pdf/PdfDocument$Page.getCanvas:()Landroid/graphics/Canvas;
                //    79: aload_0        
                //    80: getfield        android/support/v4/print/PrintHelperKitkat$1.val$bitmap:Landroid/graphics/Bitmap;
                //    83: aload           10
                //    85: aconst_null    
                //    86: invokevirtual   android/graphics/Canvas.drawBitmap:(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
                //    89: aload           5
                //    91: aload           8
                //    93: invokevirtual   android/print/pdf/PrintedPdfDocument.finishPage:(Landroid/graphics/pdf/PdfDocument$Page;)V
                //    96: aload           5
                //    98: new             Ljava/io/FileOutputStream;
                //   101: dup            
                //   102: aload_2        
                //   103: invokevirtual   android/os/ParcelFileDescriptor.getFileDescriptor:()Ljava/io/FileDescriptor;
                //   106: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/FileDescriptor;)V
                //   109: invokevirtual   android/print/pdf/PrintedPdfDocument.writeTo:(Ljava/io/OutputStream;)V
                //   112: iconst_1       
                //   113: anewarray       Landroid/print/PageRange;
                //   116: astore          14
                //   118: aload           14
                //   120: iconst_0       
                //   121: getstatic       android/print/PageRange.ALL_PAGES:Landroid/print/PageRange;
                //   124: aastore        
                //   125: aload           4
                //   127: aload           14
                //   129: invokevirtual   android/print/PrintDocumentAdapter$WriteResultCallback.onWriteFinished:([Landroid/print/PageRange;)V
                //   132: aload           5
                //   134: ifnull          142
                //   137: aload           5
                //   139: invokevirtual   android/print/pdf/PrintedPdfDocument.close:()V
                //   142: aload_2        
                //   143: ifnull          150
                //   146: aload_2        
                //   147: invokevirtual   android/os/ParcelFileDescriptor.close:()V
                //   150: return         
                //   151: astore          11
                //   153: ldc             "PrintHelperKitkat"
                //   155: ldc             "Error writing printed content"
                //   157: aload           11
                //   159: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
                //   162: pop            
                //   163: aload           4
                //   165: aconst_null    
                //   166: invokevirtual   android/print/PrintDocumentAdapter$WriteResultCallback.onWriteFailed:(Ljava/lang/CharSequence;)V
                //   169: goto            132
                //   172: astore          6
                //   174: aload           5
                //   176: ifnull          184
                //   179: aload           5
                //   181: invokevirtual   android/print/pdf/PrintedPdfDocument.close:()V
                //   184: aload_2        
                //   185: ifnull          192
                //   188: aload_2        
                //   189: invokevirtual   android/os/ParcelFileDescriptor.close:()V
                //   192: aload           6
                //   194: athrow         
                //   195: astore          13
                //   197: return         
                //   198: astore          7
                //   200: goto            192
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                 
                //  -----  -----  -----  -----  ---------------------
                //  20     96     172    195    Any
                //  96     132    151    172    Ljava/io/IOException;
                //  96     132    172    195    Any
                //  146    150    195    198    Ljava/io/IOException;
                //  153    169    172    195    Any
                //  188    192    198    203    Ljava/io/IOException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index: 94, Size: 94
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
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1163)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1010)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
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
        }, new PrintAttributes$Builder().setMediaSize(mediaSize).setColorMode(this.mColorMode).build());
    }
    
    public void printBitmap(final String s, final Uri uri) throws FileNotFoundException {
        final PrintDocumentAdapter printDocumentAdapter = new PrintDocumentAdapter() {
            AsyncTask<Uri, Boolean, Bitmap> loadBitmap;
            private PrintAttributes mAttributes;
            Bitmap mBitmap = null;
            final /* synthetic */ int val$fittingMode = PrintHelperKitkat.this.mScaleMode;
            
            private void cancelLoad() {
                synchronized (PrintHelperKitkat.this.mLock) {
                    if (PrintHelperKitkat.this.mDecodeOptions != null) {
                        PrintHelperKitkat.this.mDecodeOptions.requestCancelDecode();
                        PrintHelperKitkat.this.mDecodeOptions = null;
                    }
                }
            }
            
            public void onFinish() {
                super.onFinish();
                this.cancelLoad();
                this.loadBitmap.cancel(true);
            }
            
            public void onLayout(final PrintAttributes printAttributes, final PrintAttributes printAttributes2, final CancellationSignal cancellationSignal, final PrintDocumentAdapter$LayoutResultCallback printDocumentAdapter$LayoutResultCallback, final Bundle bundle) {
                int n = 1;
                if (cancellationSignal.isCanceled()) {
                    printDocumentAdapter$LayoutResultCallback.onLayoutCancelled();
                    this.mAttributes = printAttributes2;
                    return;
                }
                if (this.mBitmap != null) {
                    final PrintDocumentInfo build = new PrintDocumentInfo$Builder(s).setContentType(n).setPageCount(n).build();
                    if (printAttributes2.equals((Object)printAttributes)) {
                        n = 0;
                    }
                    printDocumentAdapter$LayoutResultCallback.onLayoutFinished(build, (boolean)(n != 0));
                    return;
                }
                (this.loadBitmap = new AsyncTask<Uri, Boolean, Bitmap>() {
                    protected Bitmap doInBackground(final Uri... array) {
                        try {
                            return PrintHelperKitkat.this.loadConstrainedBitmap(uri, 3500);
                        }
                        catch (FileNotFoundException ex) {
                            return null;
                        }
                    }
                    
                    protected void onCancelled(final Bitmap bitmap) {
                        printDocumentAdapter$LayoutResultCallback.onLayoutCancelled();
                    }
                    
                    protected void onPostExecute(final Bitmap mBitmap) {
                        int n = 1;
                        super.onPostExecute((Object)mBitmap);
                        PrintDocumentAdapter.this.mBitmap = mBitmap;
                        if (mBitmap != null) {
                            final PrintDocumentInfo build = new PrintDocumentInfo$Builder(s).setContentType(n).setPageCount(n).build();
                            if (printAttributes2.equals((Object)printAttributes)) {
                                n = 0;
                            }
                            printDocumentAdapter$LayoutResultCallback.onLayoutFinished(build, (boolean)(n != 0));
                            return;
                        }
                        printDocumentAdapter$LayoutResultCallback.onLayoutFailed((CharSequence)null);
                    }
                    
                    protected void onPreExecute() {
                        cancellationSignal.setOnCancelListener((CancellationSignal$OnCancelListener)new CancellationSignal$OnCancelListener() {
                            public void onCancel() {
                                PrintDocumentAdapter.this.cancelLoad();
                                AsyncTask.this.cancel(false);
                            }
                        });
                    }
                }).execute((Object[])new Uri[0]);
                this.mAttributes = printAttributes2;
            }
            
            public void onWrite(final PageRange[] p0, final ParcelFileDescriptor p1, final CancellationSignal p2, final PrintDocumentAdapter$WriteResultCallback p3) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     0: new             Landroid/print/pdf/PrintedPdfDocument;
                //     3: dup            
                //     4: aload_0        
                //     5: getfield        android/support/v4/print/PrintHelperKitkat$2.this$0:Landroid/support/v4/print/PrintHelperKitkat;
                //     8: getfield        android/support/v4/print/PrintHelperKitkat.mContext:Landroid/content/Context;
                //    11: aload_0        
                //    12: getfield        android/support/v4/print/PrintHelperKitkat$2.mAttributes:Landroid/print/PrintAttributes;
                //    15: invokespecial   android/print/pdf/PrintedPdfDocument.<init>:(Landroid/content/Context;Landroid/print/PrintAttributes;)V
                //    18: astore          5
                //    20: aload           5
                //    22: iconst_1       
                //    23: invokevirtual   android/print/pdf/PrintedPdfDocument.startPage:(I)Landroid/graphics/pdf/PdfDocument$Page;
                //    26: astore          8
                //    28: new             Landroid/graphics/RectF;
                //    31: dup            
                //    32: aload           8
                //    34: invokevirtual   android/graphics/pdf/PdfDocument$Page.getInfo:()Landroid/graphics/pdf/PdfDocument$PageInfo;
                //    37: invokevirtual   android/graphics/pdf/PdfDocument$PageInfo.getContentRect:()Landroid/graphics/Rect;
                //    40: invokespecial   android/graphics/RectF.<init>:(Landroid/graphics/Rect;)V
                //    43: astore          9
                //    45: aload_0        
                //    46: getfield        android/support/v4/print/PrintHelperKitkat$2.this$0:Landroid/support/v4/print/PrintHelperKitkat;
                //    49: aload_0        
                //    50: getfield        android/support/v4/print/PrintHelperKitkat$2.mBitmap:Landroid/graphics/Bitmap;
                //    53: invokevirtual   android/graphics/Bitmap.getWidth:()I
                //    56: aload_0        
                //    57: getfield        android/support/v4/print/PrintHelperKitkat$2.mBitmap:Landroid/graphics/Bitmap;
                //    60: invokevirtual   android/graphics/Bitmap.getHeight:()I
                //    63: aload           9
                //    65: aload_0        
                //    66: getfield        android/support/v4/print/PrintHelperKitkat$2.val$fittingMode:I
                //    69: invokestatic    android/support/v4/print/PrintHelperKitkat.access$000:(Landroid/support/v4/print/PrintHelperKitkat;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
                //    72: astore          10
                //    74: aload           8
                //    76: invokevirtual   android/graphics/pdf/PdfDocument$Page.getCanvas:()Landroid/graphics/Canvas;
                //    79: aload_0        
                //    80: getfield        android/support/v4/print/PrintHelperKitkat$2.mBitmap:Landroid/graphics/Bitmap;
                //    83: aload           10
                //    85: aconst_null    
                //    86: invokevirtual   android/graphics/Canvas.drawBitmap:(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
                //    89: aload           5
                //    91: aload           8
                //    93: invokevirtual   android/print/pdf/PrintedPdfDocument.finishPage:(Landroid/graphics/pdf/PdfDocument$Page;)V
                //    96: aload           5
                //    98: new             Ljava/io/FileOutputStream;
                //   101: dup            
                //   102: aload_2        
                //   103: invokevirtual   android/os/ParcelFileDescriptor.getFileDescriptor:()Ljava/io/FileDescriptor;
                //   106: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/FileDescriptor;)V
                //   109: invokevirtual   android/print/pdf/PrintedPdfDocument.writeTo:(Ljava/io/OutputStream;)V
                //   112: iconst_1       
                //   113: anewarray       Landroid/print/PageRange;
                //   116: astore          14
                //   118: aload           14
                //   120: iconst_0       
                //   121: getstatic       android/print/PageRange.ALL_PAGES:Landroid/print/PageRange;
                //   124: aastore        
                //   125: aload           4
                //   127: aload           14
                //   129: invokevirtual   android/print/PrintDocumentAdapter$WriteResultCallback.onWriteFinished:([Landroid/print/PageRange;)V
                //   132: aload           5
                //   134: ifnull          142
                //   137: aload           5
                //   139: invokevirtual   android/print/pdf/PrintedPdfDocument.close:()V
                //   142: aload_2        
                //   143: ifnull          150
                //   146: aload_2        
                //   147: invokevirtual   android/os/ParcelFileDescriptor.close:()V
                //   150: return         
                //   151: astore          11
                //   153: ldc             "PrintHelperKitkat"
                //   155: ldc             "Error writing printed content"
                //   157: aload           11
                //   159: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
                //   162: pop            
                //   163: aload           4
                //   165: aconst_null    
                //   166: invokevirtual   android/print/PrintDocumentAdapter$WriteResultCallback.onWriteFailed:(Ljava/lang/CharSequence;)V
                //   169: goto            132
                //   172: astore          6
                //   174: aload           5
                //   176: ifnull          184
                //   179: aload           5
                //   181: invokevirtual   android/print/pdf/PrintedPdfDocument.close:()V
                //   184: aload_2        
                //   185: ifnull          192
                //   188: aload_2        
                //   189: invokevirtual   android/os/ParcelFileDescriptor.close:()V
                //   192: aload           6
                //   194: athrow         
                //   195: astore          13
                //   197: return         
                //   198: astore          7
                //   200: goto            192
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                 
                //  -----  -----  -----  -----  ---------------------
                //  20     96     172    195    Any
                //  96     132    151    172    Ljava/io/IOException;
                //  96     132    172    195    Any
                //  146    150    195    198    Ljava/io/IOException;
                //  153    169    172    195    Any
                //  188    192    198    203    Ljava/io/IOException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index: 94, Size: 94
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
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1163)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1010)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
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
        };
        final PrintManager printManager = (PrintManager)this.mContext.getSystemService("print");
        final PrintAttributes$Builder printAttributes$Builder = new PrintAttributes$Builder();
        printAttributes$Builder.setColorMode(this.mColorMode);
        if (this.mOrientation == 1) {
            printAttributes$Builder.setMediaSize(PrintAttributes$MediaSize.UNKNOWN_LANDSCAPE);
        }
        else if (this.mOrientation == 2) {
            printAttributes$Builder.setMediaSize(PrintAttributes$MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(s, (PrintDocumentAdapter)printDocumentAdapter, printAttributes$Builder.build());
    }
    
    public void setColorMode(final int mColorMode) {
        this.mColorMode = mColorMode;
    }
    
    public void setOrientation(final int mOrientation) {
        this.mOrientation = mOrientation;
    }
    
    public void setScaleMode(final int mScaleMode) {
        this.mScaleMode = mScaleMode;
    }
}
