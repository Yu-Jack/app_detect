// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal;

import com.actionbarsherlock.ActionBarSherlock$OnActionModeStartedListener;
import com.actionbarsherlock.internal.view.StandaloneActionMode;
import android.view.ViewStub;
import com.actionbarsherlock.view.ActionMode$Callback;
import android.util.AndroidRuntimeException;
import com.actionbarsherlock.app.ActionBar;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import java.util.Iterator;
import java.util.List;
import android.util.Log;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import com.actionbarsherlock.R$bool;
import android.view.View;
import java.util.ArrayList;
import android.view.ContextThemeWrapper;
import com.actionbarsherlock.R$attr;
import android.util.TypedValue;
import android.view.animation.Animation;
import android.content.Context;
import android.view.animation.AnimationUtils;
import android.content.res.TypedArray;
import com.actionbarsherlock.R$id;
import android.view.ViewGroup$LayoutParams;
import com.actionbarsherlock.R$layout;
import com.actionbarsherlock.R$styleable;
import android.app.Activity;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import android.view.MenuItem;
import java.util.HashMap;
import android.os.Bundle;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import android.view.ViewGroup;
import com.actionbarsherlock.internal.widget.IcsProgressBar;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.internal.app.ActionBarImpl;
import com.actionbarsherlock.ActionBarSherlock$Implementation;
import com.actionbarsherlock.view.Window$Callback;
import com.actionbarsherlock.internal.view.menu.MenuPresenter$Callback;
import com.actionbarsherlock.internal.view.menu.MenuBuilder$Callback;
import android.view.MenuItem$OnMenuItemClickListener;
import com.actionbarsherlock.ActionBarSherlock;

@ActionBarSherlock$Implementation(api = 7)
public class ActionBarSherlockCompat extends ActionBarSherlock implements MenuItem$OnMenuItemClickListener, MenuBuilder$Callback, MenuPresenter$Callback, Window$Callback
{
    protected static final int DEFAULT_FEATURES = 0;
    private static final String PANELS_TAG = "sherlock:Panels";
    private ActionBarImpl aActionBar;
    private ActionMode mActionMode;
    private ActionBarContextView mActionModeView;
    private IcsProgressBar mCircularProgressBar;
    private boolean mClosingActionMenu;
    private ViewGroup mContentParent;
    private ViewGroup mDecor;
    private int mFeatures;
    private IcsProgressBar mHorizontalProgressBar;
    private boolean mIsDestroyed;
    private boolean mIsTitleReady;
    private MenuBuilder mMenu;
    private Bundle mMenuFrozenActionViewState;
    private boolean mMenuIsPrepared;
    private boolean mMenuRefreshContent;
    protected HashMap<MenuItem, MenuItemImpl> mNativeItemMap;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private int mUiOptions;
    private ActionBarView wActionBar;
    
    public ActionBarSherlockCompat(final Activity activity, final int n) {
        super(activity, n);
        this.mReserveOverflowSet = false;
        this.mIsTitleReady = false;
        this.mIsDestroyed = false;
        this.mFeatures = 0;
        this.mUiOptions = 0;
    }
    
    public static String cleanActivityName(final String s, String string) {
        if (string.charAt(0) == '.') {
            string = s + string;
        }
        else if (string.indexOf(46, 1) == -1) {
            return s + "." + string;
        }
        return string;
    }
    
    private ViewGroup generateLayout() {
        final TypedArray obtainStyledAttributes = this.mActivity.getTheme().obtainStyledAttributes(R$styleable.SherlockTheme);
        if (!obtainStyledAttributes.hasValue(59)) {
            throw new IllegalStateException("You must use Theme.Sherlock, Theme.Sherlock.Light, Theme.Sherlock.Light.DarkActionBar, or a derivative.");
        }
        if (obtainStyledAttributes.getBoolean(58, false)) {
            this.requestFeature(1);
        }
        else if (obtainStyledAttributes.getBoolean(59, false)) {
            this.requestFeature(8);
        }
        if (obtainStyledAttributes.getBoolean(60, false)) {
            this.requestFeature(9);
        }
        if (obtainStyledAttributes.getBoolean(61, false)) {
            this.requestFeature(10);
        }
        obtainStyledAttributes.recycle();
        int n;
        if (!this.hasFeature(1)) {
            if (this.hasFeature(9)) {
                n = R$layout.abs__screen_action_bar_overlay;
            }
            else {
                n = R$layout.abs__screen_action_bar;
            }
        }
        else if (this.hasFeature(10) && !this.hasFeature(1)) {
            n = R$layout.abs__screen_simple_overlay_action_mode;
        }
        else {
            n = R$layout.abs__screen_simple;
        }
        this.mDecor.addView(this.mActivity.getLayoutInflater().inflate(n, (ViewGroup)null), new ViewGroup$LayoutParams(-1, -1));
        final ViewGroup viewGroup = (ViewGroup)this.mDecor.findViewById(R$id.abs__content);
        if (viewGroup == null) {
            throw new RuntimeException("Couldn't find content container view");
        }
        this.mDecor.setId(-1);
        viewGroup.setId(16908290);
        if (this.hasFeature(5)) {
            final IcsProgressBar circularProgressBar = this.getCircularProgressBar(false);
            if (circularProgressBar != null) {
                circularProgressBar.setIndeterminate(true);
            }
        }
        return viewGroup;
    }
    
    private IcsProgressBar getCircularProgressBar(final boolean b) {
        if (this.mCircularProgressBar != null) {
            return this.mCircularProgressBar;
        }
        if (this.mContentParent == null && b) {
            this.installDecor();
        }
        this.mCircularProgressBar = (IcsProgressBar)this.mDecor.findViewById(R$id.abs__progress_circular);
        if (this.mCircularProgressBar != null) {
            this.mCircularProgressBar.setVisibility(4);
        }
        return this.mCircularProgressBar;
    }
    
    private int getFeatures() {
        return this.mFeatures;
    }
    
    private IcsProgressBar getHorizontalProgressBar(final boolean b) {
        if (this.mHorizontalProgressBar != null) {
            return this.mHorizontalProgressBar;
        }
        if (this.mContentParent == null && b) {
            this.installDecor();
        }
        this.mHorizontalProgressBar = (IcsProgressBar)this.mDecor.findViewById(R$id.abs__progress_horizontal);
        if (this.mHorizontalProgressBar != null) {
            this.mHorizontalProgressBar.setVisibility(4);
        }
        return this.mHorizontalProgressBar;
    }
    
    private void hideProgressBars(final IcsProgressBar icsProgressBar, final IcsProgressBar icsProgressBar2) {
        final int mFeatures = this.mFeatures;
        final Animation loadAnimation = AnimationUtils.loadAnimation((Context)this.mActivity, 17432577);
        loadAnimation.setDuration(1000L);
        if ((mFeatures & 0x20) != 0x0 && icsProgressBar2.getVisibility() == 0) {
            icsProgressBar2.startAnimation(loadAnimation);
            icsProgressBar2.setVisibility(4);
        }
        if ((mFeatures & 0x4) != 0x0 && icsProgressBar.getVisibility() == 0) {
            icsProgressBar.startAnimation(loadAnimation);
            icsProgressBar.setVisibility(4);
        }
    }
    
    private void initActionBar() {
        if (this.mDecor == null) {
            this.installDecor();
        }
        if (this.aActionBar == null && this.hasFeature(8) && !this.hasFeature(1) && !this.mActivity.isChild()) {
            this.aActionBar = new ActionBarImpl(this.mActivity, this.mFeatures);
            if (!this.mIsDelegate) {
                this.wActionBar.setWindowTitle(this.mActivity.getTitle());
            }
        }
    }
    
    private boolean initializePanelMenu() {
        final Activity mActivity = this.mActivity;
        while (true) {
            Label_0079: {
                if (this.wActionBar == null) {
                    break Label_0079;
                }
                final TypedValue typedValue = new TypedValue();
                ((Context)mActivity).getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
                final int resourceId = typedValue.resourceId;
                if (resourceId == 0) {
                    break Label_0079;
                }
                final Object o = new ContextThemeWrapper((Context)mActivity, resourceId);
                (this.mMenu = new MenuBuilder((Context)o)).setCallback(this);
                return true;
            }
            final Object o = mActivity;
            continue;
        }
    }
    
    private void installDecor() {
        if (this.mDecor == null) {
            this.mDecor = (ViewGroup)this.mActivity.getWindow().getDecorView().findViewById(16908290);
        }
        if (this.mContentParent == null) {
            final int childCount = this.mDecor.getChildCount();
            List<View> list = null;
            if (childCount > 0) {
                list = new ArrayList<View>(1);
                for (int childCount2 = this.mDecor.getChildCount(), i = 0; i < childCount2; ++i) {
                    final View child = this.mDecor.getChildAt(0);
                    this.mDecor.removeView(child);
                    list.add(child);
                }
            }
            this.mContentParent = this.generateLayout();
            if (list != null) {
                final Iterator<View> iterator = list.iterator();
                while (iterator.hasNext()) {
                    this.mContentParent.addView((View)iterator.next());
                }
            }
            this.wActionBar = (ActionBarView)this.mDecor.findViewById(R$id.abs__action_bar);
            if (this.wActionBar != null) {
                this.wActionBar.setWindowCallback(this);
                if (this.wActionBar.getTitle() == null) {
                    this.wActionBar.setWindowTitle(this.mActivity.getTitle());
                }
                if (this.hasFeature(2)) {
                    this.wActionBar.initProgress();
                }
                if (this.hasFeature(5)) {
                    this.wActionBar.initIndeterminateProgress();
                }
                final int loadUiOptionsFromManifest = loadUiOptionsFromManifest(this.mActivity);
                if (loadUiOptionsFromManifest != 0) {
                    this.mUiOptions = loadUiOptionsFromManifest;
                }
                final boolean b = (0x1 & this.mUiOptions) != 0x0;
                boolean b2;
                if (b) {
                    b2 = ResourcesCompat.getResources_getBoolean((Context)this.mActivity, R$bool.abs__split_action_bar_is_narrow);
                }
                else {
                    b2 = this.mActivity.getTheme().obtainStyledAttributes(R$styleable.SherlockTheme).getBoolean(62, false);
                }
                final ActionBarContainer actionBarContainer = (ActionBarContainer)this.mDecor.findViewById(R$id.abs__split_action_bar);
                if (actionBarContainer != null) {
                    this.wActionBar.setSplitView(actionBarContainer);
                    this.wActionBar.setSplitActionBar(b2);
                    this.wActionBar.setSplitWhenNarrow(b);
                    (this.mActionModeView = (ActionBarContextView)this.mDecor.findViewById(R$id.abs__action_context_bar)).setSplitView(actionBarContainer);
                    this.mActionModeView.setSplitActionBar(b2);
                    this.mActionModeView.setSplitWhenNarrow(b);
                }
                else if (b2) {
                    Log.e("ActionBarSherlock", "Requested split action bar with incompatible window decor! Ignoring request.");
                }
                this.mDecor.post((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (!ActionBarSherlockCompat.this.mIsDestroyed && !ActionBarSherlockCompat.this.mActivity.isFinishing() && ActionBarSherlockCompat.this.mMenu == null) {
                            ActionBarSherlockCompat.this.dispatchInvalidateOptionsMenu();
                        }
                    }
                });
            }
        }
    }
    
    private boolean isReservingOverflow() {
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = ActionMenuPresenter.reserveOverflow((Context)this.mActivity);
            this.mReserveOverflowSet = true;
        }
        return this.mReserveOverflow;
    }
    
    private static int loadUiOptionsFromManifest(final Activity p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //     4: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //     7: astore          4
        //     9: aload_0        
        //    10: invokevirtual   android/app/Activity.getApplicationInfo:()Landroid/content/pm/ApplicationInfo;
        //    13: getfield        android/content/pm/ApplicationInfo.packageName:Ljava/lang/String;
        //    16: astore          5
        //    18: aload_0        
        //    19: aload           5
        //    21: iconst_0       
        //    22: invokevirtual   android/app/Activity.createPackageContext:(Ljava/lang/String;I)Landroid/content/Context;
        //    25: invokevirtual   android/content/Context.getAssets:()Landroid/content/res/AssetManager;
        //    28: ldc_w           "AndroidManifest.xml"
        //    31: invokevirtual   android/content/res/AssetManager.openXmlResourceParser:(Ljava/lang/String;)Landroid/content/res/XmlResourceParser;
        //    34: astore          6
        //    36: aload           6
        //    38: invokeinterface android/content/res/XmlResourceParser.getEventType:()I
        //    43: istore          7
        //    45: iload           7
        //    47: istore          8
        //    49: iconst_0       
        //    50: istore_3       
        //    51: iload           8
        //    53: iconst_1       
        //    54: if_icmpeq       298
        //    57: iload           8
        //    59: iconst_2       
        //    60: if_icmpne       332
        //    63: aload           6
        //    65: invokeinterface android/content/res/XmlResourceParser.getName:()Ljava/lang/String;
        //    70: astore          12
        //    72: ldc_w           "application"
        //    75: aload           12
        //    77: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    80: ifeq            160
        //    83: iconst_m1      
        //    84: aload           6
        //    86: invokeinterface android/content/res/XmlResourceParser.getAttributeCount:()I
        //    91: iadd           
        //    92: istore          19
        //    94: iload           19
        //    96: iflt            132
        //    99: ldc_w           "uiOptions"
        //   102: aload           6
        //   104: iload           19
        //   106: invokeinterface android/content/res/XmlResourceParser.getAttributeName:(I)Ljava/lang/String;
        //   111: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   114: ifeq            154
        //   117: aload           6
        //   119: iload           19
        //   121: iconst_0       
        //   122: invokeinterface android/content/res/XmlResourceParser.getAttributeIntValue:(II)I
        //   127: istore          20
        //   129: iload           20
        //   131: istore_3       
        //   132: iload_3        
        //   133: istore          9
        //   135: aload           6
        //   137: invokeinterface android/content/res/XmlResourceParser.nextToken:()I
        //   142: istore          11
        //   144: iload           9
        //   146: istore_3       
        //   147: iload           11
        //   149: istore          8
        //   151: goto            51
        //   154: iinc            19, -1
        //   157: goto            94
        //   160: ldc_w           "activity"
        //   163: aload           12
        //   165: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   168: ifeq            332
        //   171: iconst_m1      
        //   172: aload           6
        //   174: invokeinterface android/content/res/XmlResourceParser.getAttributeCount:()I
        //   179: iadd           
        //   180: istore          13
        //   182: iconst_0       
        //   183: istore          14
        //   185: aconst_null    
        //   186: astore          15
        //   188: aconst_null    
        //   189: astore          16
        //   191: iload           13
        //   193: iflt            293
        //   196: aload           6
        //   198: iload           13
        //   200: invokeinterface android/content/res/XmlResourceParser.getAttributeName:(I)Ljava/lang/String;
        //   205: astore          17
        //   207: ldc_w           "uiOptions"
        //   210: aload           17
        //   212: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   215: ifeq            252
        //   218: aload           6
        //   220: iload           13
        //   222: iconst_0       
        //   223: invokeinterface android/content/res/XmlResourceParser.getAttributeIntValue:(II)I
        //   228: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   231: astore          16
        //   233: aload           16
        //   235: ifnull          338
        //   238: aload           15
        //   240: ifnull          338
        //   243: aload           16
        //   245: invokevirtual   java/lang/Integer.intValue:()I
        //   248: istore_3       
        //   249: goto            338
        //   252: ldc_w           "name"
        //   255: aload           17
        //   257: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   260: ifeq            233
        //   263: aload           5
        //   265: aload           6
        //   267: iload           13
        //   269: invokeinterface android/content/res/XmlResourceParser.getAttributeValue:(I)Ljava/lang/String;
        //   274: invokestatic    com/actionbarsherlock/internal/ActionBarSherlockCompat.cleanActivityName:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   277: astore          15
        //   279: aload           4
        //   281: aload           15
        //   283: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   286: istore          18
        //   288: iload           18
        //   290: ifne            300
        //   293: iload           14
        //   295: ifeq            332
        //   298: iload_3        
        //   299: ireturn        
        //   300: iconst_1       
        //   301: istore          14
        //   303: goto            233
        //   306: astore_1       
        //   307: aload_1        
        //   308: astore_2       
        //   309: iconst_0       
        //   310: istore_3       
        //   311: aload_2        
        //   312: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   315: iload_3        
        //   316: ireturn        
        //   317: astore_2       
        //   318: goto            311
        //   321: astore          10
        //   323: iload           9
        //   325: istore_3       
        //   326: aload           10
        //   328: astore_2       
        //   329: goto            311
        //   332: iload_3        
        //   333: istore          9
        //   335: goto            135
        //   338: iinc            13, -1
        //   341: goto            191
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      45     306    311    Ljava/lang/Exception;
        //  63     94     317    321    Ljava/lang/Exception;
        //  99     129    317    321    Ljava/lang/Exception;
        //  135    144    321    332    Ljava/lang/Exception;
        //  160    182    317    321    Ljava/lang/Exception;
        //  196    233    317    321    Ljava/lang/Exception;
        //  243    249    317    321    Ljava/lang/Exception;
        //  252    288    317    321    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 152, Size: 152
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
    
    private void onIntChanged(final int n, final int n2) {
        if (n == 2 || n == 5) {
            this.updateProgressBars(n2);
        }
    }
    
    private boolean preparePanel() {
        boolean b;
        if (this.mMenuIsPrepared) {
            b = true;
        }
        else {
            if (this.mMenu == null || this.mMenuRefreshContent) {
                if (this.mMenu == null) {
                    final boolean initializePanelMenu = this.initializePanelMenu();
                    b = false;
                    if (!initializePanelMenu) {
                        return b;
                    }
                    final MenuBuilder mMenu = this.mMenu;
                    b = false;
                    if (mMenu == null) {
                        return b;
                    }
                }
                if (this.wActionBar != null) {
                    this.wActionBar.setMenu(this.mMenu, this);
                }
                this.mMenu.stopDispatchingItemsChanged();
                if (!this.callbackCreateOptionsMenu(this.mMenu)) {
                    this.mMenu = null;
                    final ActionBarView wActionBar = this.wActionBar;
                    b = false;
                    if (wActionBar != null) {
                        this.wActionBar.setMenu(null, this);
                        return false;
                    }
                    return b;
                }
                else {
                    this.mMenuRefreshContent = false;
                }
            }
            this.mMenu.stopDispatchingItemsChanged();
            if (this.mMenuFrozenActionViewState != null) {
                this.mMenu.restoreActionViewStates(this.mMenuFrozenActionViewState);
                this.mMenuFrozenActionViewState = null;
            }
            if (!this.callbackPrepareOptionsMenu(this.mMenu)) {
                if (this.wActionBar != null) {
                    this.wActionBar.setMenu(null, this);
                }
                this.mMenu.startDispatchingItemsChanged();
                return false;
            }
            final KeyCharacterMap load = KeyCharacterMap.load(-1);
            final MenuBuilder mMenu2 = this.mMenu;
            final int keyboardType = load.getKeyboardType();
            boolean qwertyMode = false;
            if (keyboardType != 1) {
                qwertyMode = true;
            }
            mMenu2.setQwertyMode(qwertyMode);
            this.mMenu.startDispatchingItemsChanged();
            return this.mMenuIsPrepared = true;
        }
        return b;
    }
    
    private void reopenMenu(final boolean b) {
        if (this.wActionBar != null && this.wActionBar.isOverflowReserved()) {
            if (this.wActionBar.isOverflowMenuShowing() && b) {
                this.wActionBar.hideOverflowMenu();
                return;
            }
            if (this.wActionBar.getVisibility() == 0 && this.callbackPrepareOptionsMenu(this.mMenu)) {
                this.wActionBar.showOverflowMenu();
            }
        }
    }
    
    private void setFeatureInt(final int n, final int n2) {
        this.updateInt(n, n2, false);
    }
    
    private void showProgressBars(final IcsProgressBar icsProgressBar, final IcsProgressBar icsProgressBar2) {
        final int mFeatures = this.mFeatures;
        if ((mFeatures & 0x20) != 0x0 && icsProgressBar2.getVisibility() == 4) {
            icsProgressBar2.setVisibility(0);
        }
        if ((mFeatures & 0x4) != 0x0 && icsProgressBar.getProgress() < 10000) {
            icsProgressBar.setVisibility(0);
        }
    }
    
    private void updateInt(final int n, final int n2, final boolean b) {
        if (this.mContentParent != null && ((1 << n & this.getFeatures()) != 0x0 || b)) {
            this.onIntChanged(n, n2);
        }
    }
    
    private void updateProgressBars(final int n) {
        final IcsProgressBar circularProgressBar = this.getCircularProgressBar(true);
        final IcsProgressBar horizontalProgressBar = this.getHorizontalProgressBar(true);
        final int mFeatures = this.mFeatures;
        if (n == -1) {
            if ((mFeatures & 0x4) != 0x0) {
                final int progress = horizontalProgressBar.getProgress();
                int visibility;
                if (horizontalProgressBar.isIndeterminate() || progress < 10000) {
                    visibility = 0;
                }
                else {
                    visibility = 4;
                }
                horizontalProgressBar.setVisibility(visibility);
            }
            if ((mFeatures & 0x20) != 0x0) {
                circularProgressBar.setVisibility(0);
            }
        }
        else if (n == -2) {
            if ((mFeatures & 0x4) != 0x0) {
                horizontalProgressBar.setVisibility(8);
            }
            if ((mFeatures & 0x20) != 0x0) {
                circularProgressBar.setVisibility(8);
            }
        }
        else {
            if (n == -3) {
                horizontalProgressBar.setIndeterminate(true);
                return;
            }
            if (n == -4) {
                horizontalProgressBar.setIndeterminate(false);
                return;
            }
            if (n >= 0 && n <= 10000) {
                horizontalProgressBar.setProgress(n + 0);
                if (n < 10000) {
                    this.showProgressBars(horizontalProgressBar, circularProgressBar);
                    return;
                }
                this.hideProgressBars(horizontalProgressBar, circularProgressBar);
            }
            else if (20000 <= n && n <= 30000) {
                horizontalProgressBar.setSecondaryProgress(n - 20000);
                this.showProgressBars(horizontalProgressBar, circularProgressBar);
            }
        }
    }
    
    @Override
    public void addContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (this.mContentParent == null) {
            this.installDecor();
        }
        this.mContentParent.addView(view, viewGroup$LayoutParams);
        this.initActionBar();
    }
    
    void checkCloseActionMenu(final Menu menu) {
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        this.wActionBar.dismissPopupMenus();
        this.mClosingActionMenu = false;
    }
    
    @Override
    public boolean dispatchCloseOptionsMenu() {
        return this.isReservingOverflow() && this.wActionBar != null && this.wActionBar.hideOverflowMenu();
    }
    
    @Override
    public void dispatchConfigurationChanged(final Configuration configuration) {
        if (this.aActionBar != null) {
            this.aActionBar.onConfigurationChanged(configuration);
        }
    }
    
    @Override
    public boolean dispatchCreateOptionsMenu(final android.view.Menu menu) {
        return true;
    }
    
    @Override
    public void dispatchDestroy() {
        this.mIsDestroyed = true;
    }
    
    @Override
    public void dispatchInvalidateOptionsMenu() {
        if (this.mMenu != null) {
            final Bundle mMenuFrozenActionViewState = new Bundle();
            this.mMenu.saveActionViewStates(mMenuFrozenActionViewState);
            if (mMenuFrozenActionViewState.size() > 0) {
                this.mMenuFrozenActionViewState = mMenuFrozenActionViewState;
            }
            this.mMenu.stopDispatchingItemsChanged();
            this.mMenu.clear();
        }
        this.mMenuRefreshContent = true;
        if (this.wActionBar != null) {
            this.mMenuIsPrepared = false;
            this.preparePanel();
        }
    }
    
    @Override
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            final int action = keyEvent.getAction();
            if (this.mActionMode != null) {
                if (action == 1) {
                    this.mActionMode.finish();
                }
            }
            else {
                if (this.wActionBar == null || !this.wActionBar.hasExpandedActionView()) {
                    return false;
                }
                if (action == 1) {
                    this.wActionBar.collapseActionView();
                    return true;
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public boolean dispatchMenuOpened(final int n, final android.view.Menu menu) {
        if (n == 8 || n == 0) {
            if (this.aActionBar != null) {
                this.aActionBar.dispatchMenuVisibilityChanged(true);
            }
            return true;
        }
        return false;
    }
    
    @Override
    public boolean dispatchOpenOptionsMenu() {
        return this.isReservingOverflow() && this.wActionBar.showOverflowMenu();
    }
    
    @Override
    public boolean dispatchOptionsItemSelected(final MenuItem menuItem) {
        throw new IllegalStateException("Native callback invoked. Create a test case and report!");
    }
    
    @Override
    public void dispatchPanelClosed(final int n, final android.view.Menu menu) {
        if ((n == 8 || n == 0) && this.aActionBar != null) {
            this.aActionBar.dispatchMenuVisibilityChanged(false);
        }
    }
    
    @Override
    public void dispatchPause() {
        if (this.wActionBar != null && this.wActionBar.isOverflowMenuShowing()) {
            this.wActionBar.hideOverflowMenu();
        }
    }
    
    @Override
    public void dispatchPostCreate(final Bundle bundle) {
        if (this.mIsDelegate) {
            this.mIsTitleReady = true;
        }
        if (this.mDecor == null) {
            this.initActionBar();
        }
    }
    
    @Override
    public void dispatchPostResume() {
        if (this.aActionBar != null) {
            this.aActionBar.setShowHideAnimationEnabled(true);
        }
    }
    
    @Override
    public boolean dispatchPrepareOptionsMenu(final android.view.Menu menu) {
        if (this.mActionMode == null) {
            this.mMenuIsPrepared = false;
            if (this.preparePanel() && !this.isReservingOverflow()) {
                if (this.mNativeItemMap == null) {
                    this.mNativeItemMap = new HashMap<MenuItem, MenuItemImpl>();
                }
                else {
                    this.mNativeItemMap.clear();
                }
                if (this.mMenu != null) {
                    return this.mMenu.bindNativeOverflow(menu, (MenuItem$OnMenuItemClickListener)this, this.mNativeItemMap);
                }
            }
        }
        return false;
    }
    
    @Override
    public void dispatchRestoreInstanceState(final Bundle bundle) {
        this.mMenuFrozenActionViewState = (Bundle)bundle.getParcelable("sherlock:Panels");
    }
    
    @Override
    public void dispatchSaveInstanceState(final Bundle bundle) {
        if (this.mMenu != null) {
            this.mMenuFrozenActionViewState = new Bundle();
            this.mMenu.saveActionViewStates(this.mMenuFrozenActionViewState);
        }
        bundle.putParcelable("sherlock:Panels", (Parcelable)this.mMenuFrozenActionViewState);
    }
    
    @Override
    public void dispatchStop() {
        if (this.aActionBar != null) {
            this.aActionBar.setShowHideAnimationEnabled(false);
        }
    }
    
    @Override
    public void dispatchTitleChanged(final CharSequence windowTitle, final int n) {
        if ((!this.mIsDelegate || this.mIsTitleReady) && this.wActionBar != null) {
            this.wActionBar.setWindowTitle(windowTitle);
        }
    }
    
    @Override
    public void ensureActionBar() {
        if (this.mDecor == null) {
            this.initActionBar();
        }
    }
    
    @Override
    public ActionBar getActionBar() {
        this.initActionBar();
        return this.aActionBar;
    }
    
    @Override
    protected Context getThemedContext() {
        return this.aActionBar.getThemedContext();
    }
    
    @Override
    public boolean hasFeature(final int n) {
        return (this.mFeatures & 1 << n) != 0x0;
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        this.checkCloseActionMenu(menuBuilder);
    }
    
    public boolean onMenuItemClick(final MenuItem menuItem) {
        final MenuItemImpl menuItemImpl = this.mNativeItemMap.get(menuItem);
        if (menuItemImpl != null) {
            menuItemImpl.invoke();
        }
        else {
            Log.e("ActionBarSherlock", "Options item \"" + menuItem + "\" not found in mapping");
        }
        return true;
    }
    
    public boolean onMenuItemSelected(final int n, final com.actionbarsherlock.view.MenuItem menuItem) {
        return this.callbackOptionsItemSelected(menuItem);
    }
    
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final com.actionbarsherlock.view.MenuItem menuItem) {
        return this.callbackOptionsItemSelected(menuItem);
    }
    
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
        this.reopenMenu(true);
    }
    
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        return true;
    }
    
    @Override
    public boolean requestFeature(final int n) {
        if (this.mContentParent != null) {
            throw new AndroidRuntimeException("requestFeature() must be called before adding content");
        }
        switch (n) {
            default: {
                return false;
            }
            case 1:
            case 2:
            case 5:
            case 8:
            case 9:
            case 10: {
                this.mFeatures |= 1 << n;
                return true;
            }
        }
    }
    
    @Override
    public void setContentView(final int n) {
        if (this.mContentParent == null) {
            this.installDecor();
        }
        else {
            this.mContentParent.removeAllViews();
        }
        this.mActivity.getLayoutInflater().inflate(n, this.mContentParent);
        final android.view.Window$Callback callback = this.mActivity.getWindow().getCallback();
        if (callback != null) {
            callback.onContentChanged();
        }
        this.initActionBar();
    }
    
    @Override
    public void setContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (this.mContentParent == null) {
            this.installDecor();
        }
        else {
            this.mContentParent.removeAllViews();
        }
        this.mContentParent.addView(view, viewGroup$LayoutParams);
        final android.view.Window$Callback callback = this.mActivity.getWindow().getCallback();
        if (callback != null) {
            callback.onContentChanged();
        }
        this.initActionBar();
    }
    
    @Override
    public void setProgress(final int n) {
        this.setFeatureInt(2, n + 0);
    }
    
    @Override
    public void setProgressBarIndeterminate(final boolean b) {
        int n;
        if (b) {
            n = -3;
        }
        else {
            n = -4;
        }
        this.setFeatureInt(2, n);
    }
    
    @Override
    public void setProgressBarIndeterminateVisibility(final boolean b) {
        int n;
        if (b) {
            n = -1;
        }
        else {
            n = -2;
        }
        this.setFeatureInt(5, n);
    }
    
    @Override
    public void setProgressBarVisibility(final boolean b) {
        int n;
        if (b) {
            n = -1;
        }
        else {
            n = -2;
        }
        this.setFeatureInt(2, n);
    }
    
    @Override
    public void setSecondaryProgress(final int n) {
        this.setFeatureInt(2, n + 20000);
    }
    
    @Override
    public void setTitle(final CharSequence charSequence) {
        this.dispatchTitleChanged(charSequence, 0);
    }
    
    @Override
    public void setUiOptions(final int mUiOptions) {
        this.mUiOptions = mUiOptions;
    }
    
    @Override
    public void setUiOptions(final int n, final int n2) {
        this.mUiOptions = ((this.mUiOptions & ~n2) | (n & n2));
    }
    
    @Override
    public ActionMode startActionMode(final ActionMode$Callback actionMode$Callback) {
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        final ActionBarSherlockCompat$ActionModeCallbackWrapper actionBarSherlockCompat$ActionModeCallbackWrapper = new ActionBarSherlockCompat$ActionModeCallbackWrapper(this, actionMode$Callback);
        this.initActionBar();
        ActionMode startActionMode;
        if (this.aActionBar != null) {
            startActionMode = this.aActionBar.startActionMode(actionBarSherlockCompat$ActionModeCallbackWrapper);
        }
        else {
            startActionMode = null;
        }
        if (startActionMode != null) {
            this.mActionMode = startActionMode;
        }
        else {
            if (this.mActionModeView == null) {
                final ViewStub viewStub = (ViewStub)this.mDecor.findViewById(R$id.abs__action_mode_bar_stub);
                if (viewStub != null) {
                    this.mActionModeView = (ActionBarContextView)viewStub.inflate();
                }
            }
            if (this.mActionModeView != null) {
                this.mActionModeView.killMode();
                final StandaloneActionMode mActionMode = new StandaloneActionMode((Context)this.mActivity, this.mActionModeView, actionBarSherlockCompat$ActionModeCallbackWrapper, true);
                if (actionMode$Callback.onCreateActionMode(mActionMode, mActionMode.getMenu())) {
                    mActionMode.invalidate();
                    this.mActionModeView.initForMode(mActionMode);
                    this.mActionModeView.setVisibility(0);
                    this.mActionMode = mActionMode;
                    this.mActionModeView.sendAccessibilityEvent(32);
                }
                else {
                    this.mActionMode = null;
                }
            }
        }
        if (this.mActionMode != null && this.mActivity instanceof ActionBarSherlock$OnActionModeStartedListener) {
            ((ActionBarSherlock$OnActionModeStartedListener)this.mActivity).onActionModeStarted(this.mActionMode);
        }
        return this.mActionMode;
    }
}
