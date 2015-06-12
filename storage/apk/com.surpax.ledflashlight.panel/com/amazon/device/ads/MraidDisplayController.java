// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.view.View$OnClickListener;
import android.widget.ImageButton;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.KeyEvent;
import android.view.View$OnKeyListener;
import android.content.IntentFilter;
import android.widget.FrameLayout$LayoutParams;
import android.content.ActivityNotFoundException;
import android.os.Parcelable;
import android.os.Bundle;
import android.view.Window;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import java.util.ArrayList;
import android.webkit.URLUtil;
import android.widget.RelativeLayout$LayoutParams;
import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.View;
import android.widget.RelativeLayout;
import android.view.WindowManager;
import android.app.Activity;
import android.content.Intent;
import android.widget.FrameLayout;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.widget.ImageView;

class MraidDisplayController extends MraidAbstractController
{
    private static final int CLOSE_BUTTON_SIZE_DP = 50;
    private static final String LOGTAG = "MraidDisplayController";
    protected int adContainerLayoutId_;
    private boolean mAdWantsCustomCloseButton;
    private ImageView mCloseButton;
    private Context mContext;
    protected float mDensity;
    private final MraidView$ExpansionStyle mExpansionStyle;
    private boolean mIsViewable;
    private final MraidView$NativeCloseButtonStyle mNativeCloseButtonStyle;
    private BroadcastReceiver mOrientationBroadcastReceiver;
    private final int mOriginalRequestedOrientation;
    FrameLayout mPlaceholderView;
    private boolean mRegistered;
    private FrameLayout mRootView;
    protected int mScreenHeight;
    protected int mScreenWidth;
    private MraidView mTwoPartExpansionView;
    private int mViewHeight;
    private int mViewIndexInParent;
    private MraidView$ViewState mViewState;
    private int mViewWidth;
    private int modalContainerLayoutId_;
    private double scalingMultiplier_;
    private AdVideoPlayer vidPlayer_;
    private boolean vidPlaying_;
    private int videoContainerId_;
    private int viewCounterIncrement_;
    private int viewCounter_;
    private int windowHeight_;
    private int windowWidth_;
    
    MraidDisplayController(final MraidView mraidView, final MraidView$ExpansionStyle mExpansionStyle, final MraidView$NativeCloseButtonStyle mNativeCloseButtonStyle) {
        int requestedOrientation = -1;
        super(mraidView);
        this.mViewState = MraidView$ViewState.HIDDEN;
        this.vidPlaying_ = false;
        this.mOrientationBroadcastReceiver = new BroadcastReceiver() {
            private int mLastRotation;
            
            public void onReceive(final Context context, final Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED")) {
                        final int access$000 = MraidDisplayController.this.getDisplayRotation();
                        if (access$000 != this.mLastRotation) {
                            this.mLastRotation = access$000;
                            MraidDisplayController.this.onOrientationChanged(this.mLastRotation);
                        }
                    }
                }
                catch (Exception ex) {
                    Log.d("MraidDisplayController", "Orientation broadcast receiver got exception while executing: %s", ex.getLocalizedMessage());
                }
            }
        };
        this.mScreenWidth = requestedOrientation;
        this.mScreenHeight = requestedOrientation;
        this.mRegistered = false;
        this.modalContainerLayoutId_ = 0;
        this.adContainerLayoutId_ = 0;
        this.videoContainerId_ = 0;
        this.viewCounter_ = 1131261513;
        this.viewCounterIncrement_ = 50;
        this.mExpansionStyle = mExpansionStyle;
        this.mNativeCloseButtonStyle = mNativeCloseButtonStyle;
        this.windowHeight_ = mraidView.getWindowHeight();
        this.windowWidth_ = mraidView.getWindowWidth();
        this.scalingMultiplier_ = mraidView.getScalingMultiplier();
        this.mContext = this.getView().getContext();
        if (this.mContext instanceof Activity) {
            requestedOrientation = ((Activity)this.mContext).getRequestedOrientation();
        }
        this.mOriginalRequestedOrientation = requestedOrientation;
        this.initialize();
    }
    
    private void establishViewIds() {
        if (this.modalContainerLayoutId_ != 0) {
            return;
        }
        this.modalContainerLayoutId_ = this.getUniqueViewId();
        this.adContainerLayoutId_ = this.getUniqueViewId();
        this.videoContainerId_ = this.getUniqueViewId();
    }
    
    private int getDisplayRotation() {
        return AndroidTargetUtils.getOrientation(((WindowManager)this.getView().getContext().getSystemService("window")).getDefaultDisplay());
    }
    
    private int getUniqueViewId() {
        int n = 0;
        if (this.mRootView == null) {
            Log.w("MraidDisplayController", "Could not find root view. View ID may not be unique.");
            return this.viewCounter_++;
        }
        ++this.viewCounter_;
        for (int n2 = 0; n2 < 100 && n == 0; ++n2) {
            if (this.mRootView.findViewById(this.viewCounter_) == null) {
                n = 1;
            }
            else {
                this.viewCounter_ += this.viewCounterIncrement_;
            }
        }
        if (n == 0) {
            throw new IllegalArgumentException();
        }
        return this.viewCounter_;
    }
    
    private void onOrientationChanged(final int n) {
        this.initializeScreenMetrics();
        if (this.mRegistered) {
            this.getView().fireChangeEventForProperty(MraidScreenSizeProperty.createWithSize(this.mScreenWidth, this.mScreenHeight));
        }
    }
    
    private void resetViewToDefaultState() {
        final FrameLayout frameLayout = (FrameLayout)this.findViewByIdInRootView(this.adContainerLayoutId_);
        final RelativeLayout relativeLayout = (RelativeLayout)this.findViewByIdInRootView(this.modalContainerLayoutId_);
        this.setNativeCloseButtonEnabled(false);
        frameLayout.removeAllViewsInLayout();
        this.mRootView.removeView((View)relativeLayout);
        this.getView().requestLayout();
        final ViewGroup viewGroup = (ViewGroup)this.mPlaceholderView.getParent();
        viewGroup.addView((View)this.getView(), this.mViewIndexInParent, new ViewGroup$LayoutParams(this.mViewWidth, this.mViewHeight));
        viewGroup.removeView((View)this.mPlaceholderView);
        viewGroup.invalidate();
    }
    
    private void setOrientationLockEnabled(final boolean b) {
        final Context context = this.getView().getContext();
        try {
            final Activity activity = (Activity)context;
            int requestedOrientation;
            if (b) {
                requestedOrientation = Utils.determineCanonicalScreenOrientation();
            }
            else {
                requestedOrientation = this.mOriginalRequestedOrientation;
            }
            activity.setRequestedOrientation(requestedOrientation);
        }
        catch (Exception ex) {
            Log.d("MraidDisplayController", "Unable to modify device orientation.");
        }
    }
    
    private void swapViewWithPlaceholderView() {
        final ViewGroup parentOfView = this.getParentOfView();
        if (parentOfView == null) {
            return;
        }
        this.mPlaceholderView = new FrameLayout(this.getView().getContext());
        int childCount;
        int mViewIndexInParent;
        for (childCount = parentOfView.getChildCount(), mViewIndexInParent = 0; mViewIndexInParent < childCount && parentOfView.getChildAt(mViewIndexInParent) != this.getView(); ++mViewIndexInParent) {}
        this.mViewIndexInParent = mViewIndexInParent;
        this.mViewHeight = this.getViewHeight();
        this.mViewWidth = this.getViewWidth();
        parentOfView.addView((View)this.mPlaceholderView, mViewIndexInParent, new ViewGroup$LayoutParams(this.getView().getWidth(), this.getView().getHeight()));
        parentOfView.removeView((View)this.getView());
    }
    
    protected void addViewToRootView(final ViewGroup viewGroup, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.mRootView.addView((View)viewGroup, viewGroup$LayoutParams);
    }
    
    protected boolean checkViewable() {
        return true;
    }
    
    protected void close() {
        if (this.vidPlaying_) {
            this.vidPlayer_.releasePlayer();
            this.vidPlaying_ = false;
        }
        this.removeKeyListenerFromWebView();
        if (this.mViewState == MraidView$ViewState.EXPANDED) {
            this.resetViewToDefaultState();
            this.setOrientationLockEnabled(false);
            this.mViewState = MraidView$ViewState.DEFAULT;
            this.getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
        }
        else if (this.mViewState == MraidView$ViewState.DEFAULT) {
            this.getView().setVisibility(4);
            this.mViewState = MraidView$ViewState.HIDDEN;
            this.getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
        }
        if (this.getView().getOnCloseListener() != null) {
            this.getView().getOnCloseListener().onClose(this.getView(), this.mViewState);
        }
    }
    
    protected ViewGroup createExpansionViewContainer(final View view, int n, int n2) {
        final int n3 = (int)(0.5f + 50.0f * this.mDensity);
        if (n < n3) {
            n = n3;
        }
        if (n2 < n3) {
            n2 = n3;
        }
        final RelativeLayout relativeLayout = new RelativeLayout(this.getView().getContext());
        relativeLayout.setId(this.modalContainerLayoutId_);
        final View view2 = new View(this.getView().getContext());
        view2.setBackgroundColor(0);
        view2.setOnTouchListener((View$OnTouchListener)new View$OnTouchListener() {
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                return true;
            }
        });
        relativeLayout.addView(view2, (ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -1));
        final FrameLayout frameLayout = new FrameLayout(this.getView().getContext());
        frameLayout.setId(this.adContainerLayoutId_);
        frameLayout.addView(view, (ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -1));
        final RelativeLayout$LayoutParams relativeLayout$LayoutParams = new RelativeLayout$LayoutParams(n, n2);
        relativeLayout$LayoutParams.addRule(13);
        relativeLayout.addView((View)frameLayout, (ViewGroup$LayoutParams)relativeLayout$LayoutParams);
        return (ViewGroup)relativeLayout;
    }
    
    public void destroy() {
        while (true) {
            try {
                this.getView().getContext().unregisterReceiver(this.mOrientationBroadcastReceiver);
                if (this.mTwoPartExpansionView != null) {
                    this.mTwoPartExpansionView.destroy();
                    this.mTwoPartExpansionView = null;
                }
            }
            catch (IllegalArgumentException ex) {
                if (!ex.getMessage().contains("Receiver not registered")) {
                    throw ex;
                }
                continue;
            }
            break;
        }
    }
    
    protected void detachExpandedView() {
        if (this.mViewState == MraidView$ViewState.EXPANDED) {
            Log.d("MraidDisplayController", "Ad is currently expanded. Detaching the expanded view and returning ad to its default state.");
            final RelativeLayout relativeLayout = (RelativeLayout)this.mRootView.findViewById(this.modalContainerLayoutId_);
            if (relativeLayout != null) {
                if (relativeLayout.isShown()) {
                    this.mRootView.removeView((View)relativeLayout);
                }
                else {
                    relativeLayout.removeAllViews();
                }
            }
            final ViewGroup viewGroup = (ViewGroup)this.mPlaceholderView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView((View)this.mPlaceholderView);
                this.setOrientationLockEnabled(false);
                this.mViewState = MraidView$ViewState.DEFAULT;
                this.getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
            }
        }
    }
    
    protected void expand(final String s, final int n, final int n2, final boolean b, final boolean orientationLockEnabled) {
        if (this.mExpansionStyle != MraidView$ExpansionStyle.DISABLED && this.mViewState != MraidView$ViewState.EXPANDED) {
            if (this.isAdLoading()) {
                Log.e("MraidDisplayController", "Expansion failed because ad loading is currently in progress.");
                return;
            }
            if (s != null && !URLUtil.isValidUrl(s)) {
                this.getView().fireErrorEvent("expand", "URL passed to expand() was invalid.");
                return;
            }
            if (!this.obtainRootView()) {
                this.getView().fireErrorEvent("expand", "Root view could not be found.");
                Log.e("MraidDisplayController", "Expansion failed because root view could not be found.");
                return;
            }
            try {
                this.establishViewIds();
                this.useCustomClose(b);
                this.setOrientationLockEnabled(orientationLockEnabled);
                this.swapViewWithPlaceholderView();
                MraidView keyListenerToClose = this.getView();
                keyListenerToClose.setWebViewLayoutParams(-1, -1);
                if (s != null) {
                    final MraidRenderer mraidRenderer = (MraidRenderer)keyListenerToClose.getAdView();
                    (this.mTwoPartExpansionView = new MraidView(mraidRenderer, this.windowWidth_, this.windowHeight_, this.scalingMultiplier_, mraidRenderer.context, WebViewFactory.getInstance().createWebView(mraidRenderer.context), MraidView$ExpansionStyle.DISABLED, MraidView$NativeCloseButtonStyle.AD_CONTROLLED, MraidView$PlacementType.INLINE)).setOnCloseListener(new MraidView$OnCloseListener() {
                        @Override
                        public void onClose(final MraidView mraidView, final MraidView$ViewState mraidView$ViewState) {
                            MraidDisplayController.this.close();
                        }
                    });
                    this.mTwoPartExpansionView.loadUrlForTwoPartExpansionView(s);
                    keyListenerToClose = this.mTwoPartExpansionView;
                }
                this.addViewToRootView(this.createExpansionViewContainer((View)keyListenerToClose, (int)(n * this.mDensity), (int)(n2 * this.mDensity)), (ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -1));
                this.setKeyListenerToClose(keyListenerToClose);
                if (this.mNativeCloseButtonStyle == MraidView$NativeCloseButtonStyle.ALWAYS_VISIBLE || (!this.mAdWantsCustomCloseButton && this.mNativeCloseButtonStyle != MraidView$NativeCloseButtonStyle.ALWAYS_HIDDEN)) {
                    this.setNativeCloseButtonEnabled(true);
                }
                this.mViewState = MraidView$ViewState.EXPANDED;
                this.getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
                if (this.getView().getOnExpandListener() != null) {
                    this.getView().getOnExpandListener().onExpand(this.getView());
                }
            }
            catch (IllegalArgumentException ex) {
                this.getView().fireErrorEvent("expand", "Could not find available view ID.");
                Log.e("MraidDisplayController", "Expansion failed because available view ID could not be found.");
            }
        }
    }
    
    protected View findViewByIdInRootView(final int n) {
        return this.mRootView.findViewById(n);
    }
    
    protected ViewGroup getParentOfView() {
        return (ViewGroup)this.getView().getParent();
    }
    
    protected int getViewHeight() {
        return this.getView().getHeight();
    }
    
    protected int getViewWidth() {
        return this.getView().getWidth();
    }
    
    protected void initialize() {
        this.mViewState = MraidView$ViewState.LOADING;
        this.initializeScreenMetrics();
        this.registerReceivers();
    }
    
    protected void initializeJavaScriptState() {
        final ArrayList<MraidScreenSizeProperty> list = new ArrayList<MraidScreenSizeProperty>();
        list.add(MraidScreenSizeProperty.createWithSize(this.mScreenWidth, this.mScreenHeight));
        list.add((MraidScreenSizeProperty)MraidViewableProperty.createWithViewable(this.mIsViewable));
        this.getView().fireChangeEventForProperties(list);
        this.mViewState = MraidView$ViewState.DEFAULT;
        this.getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
    }
    
    protected void initializeScreenMetrics() {
        final Context context = this.getView().getContext();
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.mDensity = displayMetrics.density;
        int top;
        int n;
        if (context instanceof Activity) {
            final Window window = ((Activity)context).getWindow();
            final Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            top = rect.top;
            n = window.findViewById(16908290).getTop() - top;
        }
        else {
            n = 0;
            top = 0;
        }
        final int widthPixels = displayMetrics.widthPixels;
        final int n2 = displayMetrics.heightPixels - top - n;
        this.mScreenWidth = (int)(widthPixels * (160.0 / displayMetrics.densityDpi));
        this.mScreenHeight = (int)(n2 * (160.0 / displayMetrics.densityDpi));
    }
    
    protected boolean isAdLoading() {
        return ((MraidRenderer)this.getView().getAdView()).controller.isAdLoading();
    }
    
    protected boolean isExpanded() {
        return this.mViewState == MraidView$ViewState.EXPANDED;
    }
    
    protected boolean obtainRootView() {
        this.mRootView = (FrameLayout)this.getView().getRootView().findViewById(16908290);
        return this.mRootView != null;
    }
    
    protected void playVideo(final String s, final Controller$Dimensions controller$Dimensions, final Controller$PlayerProperties controller$PlayerProperties) {
        Log.d("MraidDisplayController", "in playVideo");
        if (this.vidPlaying_) {
            return;
        }
        if (controller$PlayerProperties.isFullScreen()) {
            final Bundle bundle = new Bundle();
            bundle.putString("url", s);
            bundle.putParcelable("player_dimensions", (Parcelable)controller$Dimensions);
            bundle.putParcelable("player_properties", (Parcelable)controller$PlayerProperties);
            try {
                final Intent intent = new Intent(this.getView().getContext(), (Class)AdActivity.class);
                intent.putExtra("adapter", VideoActionHandler.class.getName());
                intent.putExtras(bundle);
                this.getView().getContext().startActivity(intent);
                return;
            }
            catch (ActivityNotFoundException ex) {
                Log.e("MraidDisplayController", "Failed to open VideoAction activity");
                return;
            }
        }
        if (this.vidPlayer_ == null) {
            this.vidPlayer_ = new AdVideoPlayer(this.mContext);
        }
        this.vidPlayer_.setPlayData(new Controller$PlayerProperties(), s);
        this.vidPlayer_.setListener(new AdVideoPlayer$AdVideoPlayerListener() {
            @Override
            public void onComplete() {
                Log.d("MraidDisplayController", "videoplayback complete");
                MraidDisplayController.this.vidPlaying_ = false;
                final FrameLayout frameLayout = (FrameLayout)MraidDisplayController.this.mRootView.findViewById(MraidDisplayController.this.videoContainerId_);
                frameLayout.setVisibility(4);
                MraidDisplayController.this.mRootView.removeView((View)frameLayout);
            }
            
            @Override
            public void onError() {
                this.onComplete();
            }
        });
        final FrameLayout$LayoutParams layoutParams = new FrameLayout$LayoutParams(controller$Dimensions.width, controller$Dimensions.height);
        layoutParams.topMargin = controller$Dimensions.x;
        layoutParams.bottomMargin = controller$Dimensions.y;
        this.vidPlayer_.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        final FrameLayout viewGroup = new FrameLayout(this.getView().getContext());
        viewGroup.setId(this.videoContainerId_);
        viewGroup.setPadding(controller$Dimensions.x, controller$Dimensions.y, 0, 0);
        this.vidPlayer_.setViewGroup((ViewGroup)viewGroup);
        this.mRootView.addView((View)viewGroup, -1, -1);
        this.vidPlaying_ = true;
        this.vidPlayer_.playVideo();
    }
    
    protected void registerReceivers() {
        if (!this.mRegistered) {
            this.mRegistered = true;
            this.getView().getContext().registerReceiver(this.mOrientationBroadcastReceiver, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
    }
    
    protected void removeKeyListenerFromWebView() {
        this.getView().getWebView().setOnKeyListener((View$OnKeyListener)null);
    }
    
    protected void setKeyListenerToClose(final MraidView mraidView) {
        mraidView.getWebView().requestFocus();
        mraidView.getWebView().setOnKeyListener((View$OnKeyListener)new View$OnKeyListener() {
            public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
                if (n == 4 && keyEvent.getRepeatCount() == 0) {
                    MraidDisplayController.this.close();
                    return true;
                }
                return false;
            }
        });
    }
    
    protected void setNativeCloseButtonEnabled(final boolean b) {
        if (this.mRootView != null) {
            final FrameLayout frameLayout = (FrameLayout)this.mRootView.findViewById(this.adContainerLayoutId_);
            if (b) {
                if (this.mCloseButton == null) {
                    final StateListDrawable imageDrawable = new StateListDrawable();
                    imageDrawable.addState(new int[] { -16842919 }, (Drawable)AndroidTargetUtils.getNewBitmapDrawable(this.mContext.getResources(), Assets.getInstance().getFilePath("amazon_ads_close_button_normal.png")));
                    imageDrawable.addState(new int[] { 16842919 }, (Drawable)AndroidTargetUtils.getNewBitmapDrawable(this.mContext.getResources(), Assets.getInstance().getFilePath("amazon_ads_close_button_pressed.png")));
                    (this.mCloseButton = (ImageView)new ImageButton(this.getView().getContext())).setImageDrawable((Drawable)imageDrawable);
                    AndroidTargetUtils.setBackgroundDrawable((View)this.mCloseButton, null);
                    this.mCloseButton.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                        public void onClick(final View view) {
                            MraidDisplayController.this.close();
                        }
                    });
                }
                final int n = (int)(0.5f + 50.0f * this.mDensity);
                frameLayout.addView((View)this.mCloseButton, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(n, n, 5));
            }
            else {
                frameLayout.removeView((View)this.mCloseButton);
            }
            final MraidView view = this.getView();
            if (view.getOnCloseButtonStateChangeListener() != null) {
                view.getOnCloseButtonStateChangeListener().onCloseButtonStateChange(view, b);
            }
        }
    }
    
    protected void setRootView(final FrameLayout mRootView) {
        this.mRootView = mRootView;
    }
    
    protected void surfaceAd() {
        this.getView().fireChangeEventForProperty(MraidViewableProperty.createWithViewable(true));
    }
    
    protected void unregisterReceivers() {
        if (!this.mRegistered) {
            return;
        }
        this.mRegistered = false;
        try {
            this.getView().getContext().unregisterReceiver(this.mOrientationBroadcastReceiver);
        }
        catch (IllegalArgumentException ex) {}
    }
    
    protected void useCustomClose(final boolean mAdWantsCustomCloseButton) {
        this.mAdWantsCustomCloseButton = mAdWantsCustomCloseButton;
        final MraidView view = this.getView();
        final boolean b = !mAdWantsCustomCloseButton;
        if (view.getOnCloseButtonStateChangeListener() != null) {
            view.getOnCloseButtonStateChangeListener().onCloseButtonStateChange(view, b);
        }
    }
}
