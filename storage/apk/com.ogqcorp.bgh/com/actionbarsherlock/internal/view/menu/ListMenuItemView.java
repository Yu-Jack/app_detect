// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import android.widget.CompoundButton;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import com.actionbarsherlock.R$id;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.R$layout;
import android.content.res.TypedArray;
import com.actionbarsherlock.R$styleable;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.RadioButton;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.content.Context;
import android.widget.CheckBox;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;

public class ListMenuItemView extends LinearLayout implements MenuView$ItemView
{
    private Drawable mBackground;
    private CheckBox mCheckBox;
    final Context mContext;
    private boolean mForceShowIcon;
    private ImageView mIconView;
    private LayoutInflater mInflater;
    private MenuItemImpl mItemData;
    private boolean mPreserveIconSpacing;
    private RadioButton mRadioButton;
    private TextView mShortcutView;
    private int mTextAppearance;
    private Context mTextAppearanceContext;
    private TextView mTitleView;
    
    public ListMenuItemView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ListMenuItemView(final Context context, final AttributeSet set, final int n) {
        super(context, set);
        this.mContext = context;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R$styleable.SherlockMenuView, n, 0);
        this.mBackground = obtainStyledAttributes.getDrawable(4);
        this.mTextAppearance = obtainStyledAttributes.getResourceId(0, -1);
        this.mPreserveIconSpacing = obtainStyledAttributes.getBoolean(7, false);
        this.mTextAppearanceContext = context;
        obtainStyledAttributes.recycle();
    }
    
    private LayoutInflater getInflater() {
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(this.mContext);
        }
        return this.mInflater;
    }
    
    private void insertCheckBox() {
        this.addView((View)(this.mCheckBox = (CheckBox)this.getInflater().inflate(R$layout.abs__list_menu_item_checkbox, (ViewGroup)this, false)));
    }
    
    private void insertIconView() {
        this.addView((View)(this.mIconView = (ImageView)this.getInflater().inflate(R$layout.abs__list_menu_item_icon, (ViewGroup)this, false)), 0);
    }
    
    private void insertRadioButton() {
        this.addView((View)(this.mRadioButton = (RadioButton)this.getInflater().inflate(R$layout.abs__list_menu_item_radio, (ViewGroup)this, false)));
    }
    
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }
    
    public void initialize(final MenuItemImpl mItemData, final int n) {
        this.mItemData = mItemData;
        int visibility;
        if (mItemData.isVisible()) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        this.setVisibility(visibility);
        this.setTitle(mItemData.getTitleForItemView(this));
        this.setCheckable(mItemData.isCheckable());
        this.setShortcut(mItemData.shouldShowShortcut(), mItemData.getShortcut());
        this.setIcon(mItemData.getIcon());
        this.setEnabled(mItemData.isEnabled());
    }
    
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.setBackgroundDrawable(this.mBackground);
        this.mTitleView = (TextView)this.findViewById(R$id.abs__title);
        if (this.mTextAppearance != -1) {
            this.mTitleView.setTextAppearance(this.mTextAppearanceContext, this.mTextAppearance);
        }
        this.mShortcutView = (TextView)this.findViewById(R$id.abs__shortcut);
    }
    
    protected void onMeasure(final int n, final int n2) {
        if (this.mIconView != null && this.mPreserveIconSpacing) {
            final ViewGroup$LayoutParams layoutParams = this.getLayoutParams();
            final LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams)this.mIconView.getLayoutParams();
            if (layoutParams.height > 0 && linearLayout$LayoutParams.width <= 0) {
                linearLayout$LayoutParams.width = layoutParams.height;
            }
        }
        super.onMeasure(n, n2);
    }
    
    public boolean prefersCondensedTitle() {
        return false;
    }
    
    public void setCheckable(final boolean b) {
        if (b || this.mRadioButton != null || this.mCheckBox != null) {
            if (this.mRadioButton == null) {
                this.insertRadioButton();
            }
            if (this.mCheckBox == null) {
                this.insertCheckBox();
            }
            Object o;
            Object o2;
            if (this.mItemData.isExclusiveCheckable()) {
                final RadioButton mRadioButton = this.mRadioButton;
                final CheckBox mCheckBox = this.mCheckBox;
                o = mRadioButton;
                o2 = mCheckBox;
            }
            else {
                final CheckBox mCheckBox2 = this.mCheckBox;
                final RadioButton mRadioButton2 = this.mRadioButton;
                o = mCheckBox2;
                o2 = mRadioButton2;
            }
            if (!b) {
                this.mCheckBox.setVisibility(8);
                this.mRadioButton.setVisibility(8);
                return;
            }
            ((CompoundButton)o).setChecked(this.mItemData.isChecked());
            int visibility;
            if (b) {
                visibility = 0;
            }
            else {
                visibility = 8;
            }
            if (((CompoundButton)o).getVisibility() != visibility) {
                ((CompoundButton)o).setVisibility(visibility);
            }
            if (((CompoundButton)o2).getVisibility() != 8) {
                ((CompoundButton)o2).setVisibility(8);
            }
        }
    }
    
    public void setChecked(final boolean checked) {
        Object o;
        if (this.mItemData.isExclusiveCheckable()) {
            if (this.mRadioButton == null) {
                this.insertRadioButton();
            }
            o = this.mRadioButton;
        }
        else {
            if (this.mCheckBox == null) {
                this.insertCheckBox();
            }
            o = this.mCheckBox;
        }
        ((CompoundButton)o).setChecked(checked);
    }
    
    public void setForceShowIcon(final boolean b) {
        this.mForceShowIcon = b;
        this.mPreserveIconSpacing = b;
    }
    
    public void setIcon(Drawable imageDrawable) {
        boolean b;
        if (this.mItemData.shouldShowIcon() || this.mForceShowIcon) {
            b = true;
        }
        else {
            b = false;
        }
        if ((b || this.mPreserveIconSpacing) && (this.mIconView != null || imageDrawable != null || this.mPreserveIconSpacing)) {
            if (this.mIconView == null) {
                this.insertIconView();
            }
            if (imageDrawable == null && !this.mPreserveIconSpacing) {
                this.mIconView.setVisibility(8);
                return;
            }
            final ImageView mIconView = this.mIconView;
            if (!b) {
                imageDrawable = null;
            }
            mIconView.setImageDrawable(imageDrawable);
            if (this.mIconView.getVisibility() != 0) {
                this.mIconView.setVisibility(0);
            }
        }
    }
    
    public void setShortcut(final boolean b, final char c) {
        int visibility;
        if (b && this.mItemData.shouldShowShortcut()) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        if (visibility == 0) {
            this.mShortcutView.setText((CharSequence)this.mItemData.getShortcutLabel());
        }
        if (this.mShortcutView.getVisibility() != visibility) {
            this.mShortcutView.setVisibility(visibility);
        }
    }
    
    public void setTitle(final CharSequence text) {
        if (text != null) {
            this.mTitleView.setText(text);
            if (this.mTitleView.getVisibility() != 0) {
                this.mTitleView.setVisibility(0);
            }
        }
        else if (this.mTitleView.getVisibility() != 8) {
            this.mTitleView.setVisibility(8);
        }
    }
    
    public boolean showsIcon() {
        return this.mForceShowIcon;
    }
}
