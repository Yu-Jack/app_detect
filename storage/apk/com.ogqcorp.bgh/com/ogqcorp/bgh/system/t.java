// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.view.SurfaceHolder;
import android.view.MotionEvent;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v4.widget.i;
import android.support.v4.view.j;
import android.support.v4.widget.o;
import android.graphics.Bitmap;
import android.view.SurfaceHolder$Callback;
import android.view.GestureDetector$OnGestureListener;
import android.view.SurfaceView;

public abstract class t extends SurfaceView implements GestureDetector$OnGestureListener, SurfaceHolder$Callback
{
    private final Runnable a;
    private Bitmap b;
    private boolean c;
    private boolean d;
    private int e;
    private int f;
    private int g;
    private o h;
    private j i;
    private i[] j;
    private boolean[] k;
    private boolean l;
    private int m;
    
    public t(final Context context) {
        super(context);
        this.a = new Runnable() {
            @Override
            public void run() {
                t.this.b();
            }
        };
        this.d = true;
        this.e = 1;
        this.f = 0;
        this.g = -1;
        this.j = new i[2];
        this.k = new boolean[2];
        this.l = true;
        this.m = 0;
        this.a();
    }
    
    public t(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = new Runnable() {
            @Override
            public void run() {
                t.this.b();
            }
        };
        this.d = true;
        this.e = 1;
        this.f = 0;
        this.g = -1;
        this.j = new i[2];
        this.k = new boolean[2];
        this.l = true;
        this.m = 0;
        this.a();
    }
    
    public t(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.a = new Runnable() {
            @Override
            public void run() {
                t.this.b();
            }
        };
        this.d = true;
        this.e = 1;
        this.f = 0;
        this.g = -1;
        this.j = new i[2];
        this.k = new boolean[2];
        this.l = true;
        this.m = 0;
        this.a();
    }
    
    private void a(final int n) {
        if (this.l && this.j[n].a() && !this.k[n]) {
            this.j[n].a((int)(this.h.f() / 8.0f));
            this.k[n] = true;
        }
    }
    
    private void a(final i i, final float n, final float n2, final float n3, final Canvas canvas, final int n4, final int n5) {
        if (!i.a()) {
            final int save = canvas.save();
            canvas.translate(n, n2);
            canvas.rotate(n3, 0.0f, 0.0f);
            i.a(n5, n4);
            i.a(canvas);
            canvas.restoreToCount(save);
        }
    }
    
    private void c() {
        if (this.b != null) {
            this.b.recycle();
            this.b = null;
        }
        System.gc();
    }
    
    private void d() {
        this.j[0].c();
        this.j[1].c();
        this.k[0] = false;
        this.k[1] = false;
    }
    
    protected void a() {
        this.getHolder().addCallback((SurfaceHolder$Callback)this);
        final Context context = this.getContext();
        this.h = o.a(context);
        (this.i = new j(context, (GestureDetector$OnGestureListener)this)).a(false);
        this.j[0] = new i(context);
        this.j[1] = new i(context);
    }
    
    protected void a(final Canvas canvas) {
        if (this.b != null) {
            final Bitmap b = this.b;
            float n;
            if (this.m > 0) {
                n = -this.f;
            }
            else {
                n = -this.m / 2;
            }
            canvas.drawBitmap(b, n, 0.0f, (Paint)null);
        }
        if (this.l && this.m > 0) {
            final int width = this.getWidth();
            final int height = this.getHeight();
            this.a(this.j[0], 0.0f, height, -90.0f, canvas, width, height);
            this.a(this.j[1], width, 0.0f, 90.0f, canvas, width, height);
        }
    }
    
    protected void b() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/ogqcorp/bgh/system/t.m:I
        //     4: ifle            79
        //     7: aload_0        
        //     8: getfield        com/ogqcorp/bgh/system/t.h:Landroid/support/v4/widget/o;
        //    11: invokevirtual   android/support/v4/widget/o.a:()Z
        //    14: ifne            36
        //    17: aload_0        
        //    18: getfield        com/ogqcorp/bgh/system/t.h:Landroid/support/v4/widget/o;
        //    21: invokevirtual   android/support/v4/widget/o.g:()Z
        //    24: pop            
        //    25: aload_0        
        //    26: aload_0        
        //    27: getfield        com/ogqcorp/bgh/system/t.h:Landroid/support/v4/widget/o;
        //    30: invokevirtual   android/support/v4/widget/o.b:()I
        //    33: putfield        com/ogqcorp/bgh/system/t.f:I
        //    36: aload_0        
        //    37: getfield        com/ogqcorp/bgh/system/t.f:I
        //    40: ifge            225
        //    43: aload_0        
        //    44: iconst_0       
        //    45: putfield        com/ogqcorp/bgh/system/t.f:I
        //    48: aload_0        
        //    49: iconst_1       
        //    50: putfield        com/ogqcorp/bgh/system/t.e:I
        //    53: aload_0        
        //    54: iconst_0       
        //    55: invokespecial   com/ogqcorp/bgh/system/t.a:(I)V
        //    58: aload_0        
        //    59: getfield        com/ogqcorp/bgh/system/t.d:Z
        //    62: iconst_1       
        //    63: if_icmpne       79
        //    66: aload_0        
        //    67: aload_0        
        //    68: getfield        com/ogqcorp/bgh/system/t.f:I
        //    71: aload_0        
        //    72: getfield        com/ogqcorp/bgh/system/t.e:I
        //    75: iadd           
        //    76: putfield        com/ogqcorp/bgh/system/t.f:I
        //    79: aload_0        
        //    80: getfield        com/ogqcorp/bgh/system/t.j:[Landroid/support/v4/widget/i;
        //    83: iconst_0       
        //    84: aaload         
        //    85: invokevirtual   android/support/v4/widget/i.a:()Z
        //    88: istore_1       
        //    89: iconst_0       
        //    90: istore_2       
        //    91: iload_1        
        //    92: ifeq            115
        //    95: aload_0        
        //    96: getfield        com/ogqcorp/bgh/system/t.j:[Landroid/support/v4/widget/i;
        //    99: iconst_1       
        //   100: aaload         
        //   101: invokevirtual   android/support/v4/widget/i.a:()Z
        //   104: istore          9
        //   106: iconst_0       
        //   107: istore_2       
        //   108: iload           9
        //   110: ifeq            115
        //   113: iconst_1       
        //   114: istore_2       
        //   115: aload_0        
        //   116: getfield        com/ogqcorp/bgh/system/t.g:I
        //   119: iconst_m1      
        //   120: if_icmpeq       138
        //   123: aload_0        
        //   124: getfield        com/ogqcorp/bgh/system/t.g:I
        //   127: aload_0        
        //   128: getfield        com/ogqcorp/bgh/system/t.f:I
        //   131: if_icmpne       138
        //   134: iload_2        
        //   135: ifne            195
        //   138: aload_0        
        //   139: invokevirtual   com/ogqcorp/bgh/system/t.getHolder:()Landroid/view/SurfaceHolder;
        //   142: invokeinterface android/view/SurfaceHolder.lockCanvas:()Landroid/graphics/Canvas;
        //   147: astore          5
        //   149: aload           5
        //   151: ifnull          171
        //   154: aload           5
        //   156: invokevirtual   android/graphics/Canvas.save:()I
        //   159: pop            
        //   160: aload_0        
        //   161: aload           5
        //   163: invokevirtual   com/ogqcorp/bgh/system/t.a:(Landroid/graphics/Canvas;)V
        //   166: aload           5
        //   168: invokevirtual   android/graphics/Canvas.restore:()V
        //   171: aload           5
        //   173: ifnull          187
        //   176: aload_0        
        //   177: invokevirtual   com/ogqcorp/bgh/system/t.getHolder:()Landroid/view/SurfaceHolder;
        //   180: aload           5
        //   182: invokeinterface android/view/SurfaceHolder.unlockCanvasAndPost:(Landroid/graphics/Canvas;)V
        //   187: aload_0        
        //   188: aload_0        
        //   189: getfield        com/ogqcorp/bgh/system/t.f:I
        //   192: putfield        com/ogqcorp/bgh/system/t.g:I
        //   195: aload_0        
        //   196: aload_0        
        //   197: getfield        com/ogqcorp/bgh/system/t.a:Ljava/lang/Runnable;
        //   200: invokevirtual   com/ogqcorp/bgh/system/t.removeCallbacks:(Ljava/lang/Runnable;)Z
        //   203: pop            
        //   204: aload_0        
        //   205: getfield        com/ogqcorp/bgh/system/t.c:Z
        //   208: iconst_1       
        //   209: if_icmpne       224
        //   212: aload_0        
        //   213: aload_0        
        //   214: getfield        com/ogqcorp/bgh/system/t.a:Ljava/lang/Runnable;
        //   217: ldc2_w          10
        //   220: invokevirtual   com/ogqcorp/bgh/system/t.postDelayed:(Ljava/lang/Runnable;J)Z
        //   223: pop            
        //   224: return         
        //   225: aload_0        
        //   226: getfield        com/ogqcorp/bgh/system/t.f:I
        //   229: aload_0        
        //   230: getfield        com/ogqcorp/bgh/system/t.m:I
        //   233: if_icmple       58
        //   236: aload_0        
        //   237: aload_0        
        //   238: getfield        com/ogqcorp/bgh/system/t.m:I
        //   241: putfield        com/ogqcorp/bgh/system/t.f:I
        //   244: aload_0        
        //   245: iconst_m1      
        //   246: putfield        com/ogqcorp/bgh/system/t.e:I
        //   249: aload_0        
        //   250: iconst_1       
        //   251: invokespecial   com/ogqcorp/bgh/system/t.a:(I)V
        //   254: goto            58
        //   257: astore_3       
        //   258: aconst_null    
        //   259: astore          4
        //   261: aload           4
        //   263: ifnull          277
        //   266: aload_0        
        //   267: invokevirtual   com/ogqcorp/bgh/system/t.getHolder:()Landroid/view/SurfaceHolder;
        //   270: aload           4
        //   272: invokeinterface android/view/SurfaceHolder.unlockCanvasAndPost:(Landroid/graphics/Canvas;)V
        //   277: aload_3        
        //   278: athrow         
        //   279: astore_3       
        //   280: aload           5
        //   282: astore          4
        //   284: goto            261
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  138    149    257    261    Any
        //  154    171    279    287    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0171:
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
    
    protected Bitmap getBitmap() {
        final Bitmap originalBitmap = this.getOriginalBitmap();
        Bitmap scaledBitmap = null;
        if (originalBitmap != null) {
            final float n = this.getHeight() / originalBitmap.getHeight() * originalBitmap.getWidth();
            if (n <= 0.0f) {
                originalBitmap.recycle();
                System.gc();
                return null;
            }
            scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, (int)n, this.getHeight(), true);
            if (originalBitmap != scaledBitmap) {
                originalBitmap.recycle();
                System.gc();
                return scaledBitmap;
            }
        }
        return scaledBitmap;
    }
    
    protected abstract Bitmap getOriginalBitmap();
    
    protected void onDetachedFromWindow() {
        this.c();
        super.onDetachedFromWindow();
    }
    
    public boolean onDown(final MotionEvent motionEvent) {
        this.d();
        this.h.h();
        return true;
    }
    
    public boolean onFling(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
        this.d();
        this.h.a(this.f, 0, (int)(-(0.8f * n)), 0, 0, this.m, 0, 0);
        return true;
    }
    
    public void onLongPress(final MotionEvent motionEvent) {
    }
    
    public boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
        this.f += (int)n;
        if (this.l) {
            if (this.f < 0) {
                this.j[0].a(n / this.getWidth() / 8.0f);
                this.k[0] = true;
            }
            else if (this.f > this.m) {
                this.j[1].a(n / this.getWidth() / 8.0f);
                return this.k[1] = true;
            }
        }
        return true;
    }
    
    public void onShowPress(final MotionEvent motionEvent) {
    }
    
    public boolean onSingleTapUp(final MotionEvent motionEvent) {
        return true;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.m > 0) {
            this.i.a(motionEvent);
        }
        return true;
    }
    
    public void setAutoScrolling(final boolean d) {
        this.d = d;
    }
    
    public void setUseEdgeEffect(final boolean l) {
        this.l = l;
    }
    
    public void surfaceChanged(final SurfaceHolder surfaceHolder, final int n, final int n2, final int n3) {
        this.c();
        this.b = this.getBitmap();
        if (this.b != null) {
            this.f = 0;
            this.g = -1;
            this.m = this.b.getWidth() - n2;
            this.c = true;
            this.post(this.a);
        }
    }
    
    public void surfaceCreated(final SurfaceHolder surfaceHolder) {
    }
    
    public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
        this.c = false;
        this.removeCallbacks(this.a);
        this.c();
        this.h.h();
    }
}
