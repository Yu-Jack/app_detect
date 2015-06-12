// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import android.graphics.drawable.Drawable;
import android.view.View$MeasureSpec;
import android.widget.Toast;
import com.actionbarsherlock.internal.widget.IcsToast;
import android.graphics.Rect;
import com.actionbarsherlock.R$id;
import java.util.Iterator;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.os.Build$VERSION;
import android.view.MotionEvent;
import android.text.TextUtils;
import android.content.res.TypedArray;
import com.actionbarsherlock.R$styleable;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.R$bool;
import java.util.HashSet;
import android.util.AttributeSet;
import android.content.Context;
import com.actionbarsherlock.internal.widget.CapitalizingButton;
import com.actionbarsherlock.internal.view.View_OnAttachStateChangeListener;
import java.util.Set;
import android.widget.ImageButton;
import com.actionbarsherlock.internal.view.View_HasStateListenerSupport;
import android.view.View$OnLongClickListener;
import android.view.View$OnClickListener;
import android.widget.LinearLayout;

public class ActionMenuItemView extends LinearLayout implements View$OnClickListener, View$OnLongClickListener, View_HasStateListenerSupport, ActionMenuView$ActionMenuChildView, MenuView$ItemView
{
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ImageButton mImageButton;
    private MenuItemImpl mItemData;
    private MenuBuilder$ItemInvoker mItemInvoker;
    private final Set<View_OnAttachStateChangeListener> mListeners;
    private int mMinWidth;
    private CapitalizingButton mTextButton;
    private CharSequence mTitle;
    
    public ActionMenuItemView(final Context context) {
        this(context, null);
    }
    
    public ActionMenuItemView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ActionMenuItemView(final Context context, final AttributeSet set, final int n) {
        super(context, set);
        this.mListeners = new HashSet<View_OnAttachStateChangeListener>();
        this.mAllowTextWithIcon = ResourcesCompat.getResources_getBoolean(context, R$bool.abs__config_allowActionMenuItemTextWithIcon);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R$styleable.SherlockActionMenuItemView, 0, 0);
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
    }
    
    private void updateTextButtonVisibility() {
        int n = 1;
        int n2;
        if (!TextUtils.isEmpty(this.mTextButton.getText())) {
            n2 = n;
        }
        else {
            n2 = 0;
        }
        if (this.mImageButton.getDrawable() != null && (!this.mItemData.showsTextAsAction() || (!this.mAllowTextWithIcon && !this.mExpandedFormat))) {
            n = 0;
        }
        final int n3 = n2 & n;
        final CapitalizingButton mTextButton = this.mTextButton;
        int visibility = 0;
        if (n3 == 0) {
            visibility = 8;
        }
        mTextButton.setVisibility(visibility);
    }
    
    public void addOnAttachStateChangeListener(final View_OnAttachStateChangeListener view_OnAttachStateChangeListener) {
        this.mListeners.add(view_OnAttachStateChangeListener);
    }
    
    public boolean dispatchHoverEvent(final MotionEvent motionEvent) {
        return Build$VERSION.SDK_INT >= 14 && this.onHoverEvent(motionEvent);
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        this.onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }
    
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }
    
    public boolean hasText() {
        return this.mTextButton.getVisibility() != 8;
    }
    
    public void initialize(final MenuItemImpl mItemData, final int n) {
        this.mItemData = mItemData;
        this.setIcon(mItemData.getIcon());
        this.setTitle(mItemData.getTitleForItemView(this));
        this.setId(mItemData.getItemId());
        int visibility;
        if (mItemData.isVisible()) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        this.setVisibility(visibility);
        this.setEnabled(mItemData.isEnabled());
    }
    
    public boolean needsDividerAfter() {
        return this.hasText();
    }
    
    public boolean needsDividerBefore() {
        return this.hasText() && this.mItemData.getIcon() == null;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final Iterator<View_OnAttachStateChangeListener> iterator = this.mListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().onViewAttachedToWindow((View)this);
        }
    }
    
    public void onClick(final View view) {
        if (this.mItemInvoker != null) {
            this.mItemInvoker.invokeItem(this.mItemData);
        }
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final Iterator<View_OnAttachStateChangeListener> iterator = this.mListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().onViewDetachedFromWindow((View)this);
        }
    }
    
    public void onFinishInflate() {
        this.mImageButton = (ImageButton)this.findViewById(R$id.abs__imageButton);
        this.mTextButton = (CapitalizingButton)this.findViewById(R$id.abs__textButton);
        this.mImageButton.setOnClickListener((View$OnClickListener)this);
        this.mTextButton.setOnClickListener((View$OnClickListener)this);
        this.mImageButton.setOnLongClickListener((View$OnLongClickListener)this);
        this.setOnClickListener((View$OnClickListener)this);
        this.setOnLongClickListener((View$OnLongClickListener)this);
    }
    
    public boolean onLongClick(final View view) {
        if (this.hasText()) {
            return false;
        }
        final int[] array = new int[2];
        final Rect rect = new Rect();
        this.getLocationOnScreen(array);
        this.getWindowVisibleDisplayFrame(rect);
        final Context context = this.getContext();
        final int width = this.getWidth();
        final int height = this.getHeight();
        final int n = array[1] + height / 2;
        final int widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        final Toast text = IcsToast.makeText(context, this.mItemData.getTitle(), 0);
        if (n < rect.height()) {
            text.setGravity(53, widthPixels - array[0] - width / 2, height);
        }
        else {
            text.setGravity(81, 0, height);
        }
        text.show();
        return true;
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        final int mode = View$MeasureSpec.getMode(n);
        final int size = View$MeasureSpec.getSize(n);
        final int measuredWidth = this.getMeasuredWidth();
        int n3;
        if (mode == Integer.MIN_VALUE) {
            n3 = Math.min(size, this.mMinWidth);
        }
        else {
            n3 = this.mMinWidth;
        }
        if (mode != 1073741824 && this.mMinWidth > 0 && measuredWidth < n3) {
            super.onMeasure(View$MeasureSpec.makeMeasureSpec(n3, 1073741824), n2);
        }
    }
    
    public void onPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        if (Build$VERSION.SDK_INT >= 14) {
            super.onPopulateAccessibilityEvent(accessibilityEvent);
        }
        final CharSequence contentDescription = this.getContentDescription();
        if (!TextUtils.isEmpty(contentDescription)) {
            accessibilityEvent.getText().add(contentDescription);
        }
    }
    
    public boolean prefersCondensedTitle() {
        return true;
    }
    
    public void removeOnAttachStateChangeListener(final View_OnAttachStateChangeListener view_OnAttachStateChangeListener) {
        this.mListeners.remove(view_OnAttachStateChangeListener);
    }
    
    public void setCheckable(final boolean b) {
    }
    
    public void setChecked(final boolean b) {
    }
    
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);
        this.mImageButton.setEnabled(enabled);
        this.mTextButton.setEnabled(enabled);
    }
    
    public void setExpandedFormat(final boolean mExpandedFormat) {
        if (this.mExpandedFormat != mExpandedFormat) {
            this.mExpandedFormat = mExpandedFormat;
            if (this.mItemData != null) {
                this.mItemData.actionFormatChanged();
            }
        }
    }
    
    public void setIcon(final Drawable imageDrawable) {
        this.mImageButton.setImageDrawable(imageDrawable);
        if (imageDrawable != null) {
            this.mImageButton.setVisibility(0);
        }
        else {
            this.mImageButton.setVisibility(8);
        }
        this.updateTextButtonVisibility();
    }
    
    public void setItemInvoker(final MenuBuilder$ItemInvoker mItemInvoker) {
        this.mItemInvoker = mItemInvoker;
    }
    
    public void setShortcut(final boolean b, final char c) {
    }
    
    public void setTitle(final CharSequence mTitle) {
        this.mTitle = mTitle;
        this.mTextButton.setTextCompat(this.mTitle);
        this.setContentDescription(this.mTitle);
        this.updateTextButtonVisibility();
    }
    
    public boolean showsIcon() {
        return true;
    }
}
