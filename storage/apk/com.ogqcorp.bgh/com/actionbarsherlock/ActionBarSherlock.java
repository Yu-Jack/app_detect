// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock;

import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode$Callback;
import android.content.Context;
import com.actionbarsherlock.app.ActionBar;
import android.os.Bundle;
import android.view.KeyEvent;
import android.content.res.Configuration;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Menu;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import java.util.Iterator;
import java.lang.reflect.InvocationTargetException;
import android.os.Build$VERSION;
import java.util.Map;
import com.actionbarsherlock.internal.ActionBarSherlockNative;
import com.actionbarsherlock.internal.ActionBarSherlockCompat;
import com.actionbarsherlock.view.MenuInflater;
import android.app.Activity;
import java.util.HashMap;

public abstract class ActionBarSherlock
{
    private static final Class<?>[] CONSTRUCTOR_ARGS;
    public static final boolean DEBUG = false;
    public static final int FLAG_DELEGATE = 1;
    private static final HashMap<ActionBarSherlock$Implementation, Class<? extends ActionBarSherlock>> IMPLEMENTATIONS;
    protected static final String TAG = "ActionBarSherlock";
    protected final Activity mActivity;
    protected final boolean mIsDelegate;
    protected MenuInflater mMenuInflater;
    
    static {
        CONSTRUCTOR_ARGS = new Class[] { Activity.class, Integer.TYPE };
        IMPLEMENTATIONS = new HashMap<ActionBarSherlock$Implementation, Class<? extends ActionBarSherlock>>();
        registerImplementation(ActionBarSherlockCompat.class);
        registerImplementation(ActionBarSherlockNative.class);
    }
    
    protected ActionBarSherlock(final Activity mActivity, final int n) {
        this.mActivity = mActivity;
        this.mIsDelegate = ((n & 0x1) != 0x0);
    }
    
    public static void registerImplementation(final Class<? extends ActionBarSherlock> clazz) {
        if (!clazz.isAnnotationPresent(ActionBarSherlock$Implementation.class)) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " is not annotated with @Implementation");
        }
        if (ActionBarSherlock.IMPLEMENTATIONS.containsValue(clazz)) {
            return;
        }
        ActionBarSherlock.IMPLEMENTATIONS.put(clazz.getAnnotation(ActionBarSherlock$Implementation.class), clazz);
    }
    
    public static boolean unregisterImplementation(final Class<? extends ActionBarSherlock> clazz) {
        return ActionBarSherlock.IMPLEMENTATIONS.values().remove(clazz);
    }
    
    public static ActionBarSherlock wrap(final Activity activity) {
        return wrap(activity, 0);
    }
    
    public static ActionBarSherlock wrap(final Activity activity, final int i) {
        int n = 0;
        final HashMap<ActionBarSherlock$Implementation, Object> hashMap = new HashMap<ActionBarSherlock$Implementation, Object>(ActionBarSherlock.IMPLEMENTATIONS);
        final Iterator<ActionBarSherlock$Implementation> iterator = hashMap.keySet().iterator();
        while (true) {
        Label_0205_Outer:
            while (iterator.hasNext()) {
                if (iterator.next().dpi() == 213) {
                    final int n2 = 1;
                    if (n2 != 0) {
                        boolean b;
                        if (activity.getResources().getDisplayMetrics().densityDpi == 213) {
                            b = true;
                        }
                        else {
                            b = false;
                        }
                        final Iterator<ActionBarSherlock$Implementation> iterator2 = hashMap.keySet().iterator();
                        while (iterator2.hasNext()) {
                            final int dpi = iterator2.next().dpi();
                            if ((b && dpi != 213) || (!b && dpi == 213)) {
                                iterator2.remove();
                            }
                        }
                    }
                    final Iterator<ActionBarSherlock$Implementation> iterator3 = hashMap.keySet().iterator();
                    while (true) {
                        while (iterator3.hasNext()) {
                            if (iterator3.next().api() != -1) {
                                final int n3 = 1;
                                if (n3 != 0) {
                                    final int sdk_INT = Build$VERSION.SDK_INT;
                                    final Iterator<ActionBarSherlock$Implementation> iterator4 = hashMap.keySet().iterator();
                                    while (iterator4.hasNext()) {
                                        final int api = iterator4.next().api();
                                        if (api > sdk_INT) {
                                            iterator4.remove();
                                        }
                                        else {
                                            if (api <= n) {
                                                continue Label_0205_Outer;
                                            }
                                            n = api;
                                        }
                                    }
                                    final Iterator<ActionBarSherlock$Implementation> iterator5 = hashMap.keySet().iterator();
                                    while (iterator5.hasNext()) {
                                        if (iterator5.next().api() != n) {
                                            iterator5.remove();
                                        }
                                    }
                                }
                                if (hashMap.size() > 1) {
                                    throw new IllegalStateException("More than one implementation matches configuration.");
                                }
                                if (hashMap.isEmpty()) {
                                    throw new IllegalStateException("No implementations match configuration.");
                                }
                                final Class<ActionBarSherlock> clazz = hashMap.values().iterator().next();
                                try {
                                    return clazz.getConstructor(ActionBarSherlock.CONSTRUCTOR_ARGS).newInstance(activity, i);
                                }
                                catch (NoSuchMethodException cause) {
                                    throw new RuntimeException(cause);
                                }
                                catch (IllegalArgumentException cause2) {
                                    throw new RuntimeException(cause2);
                                }
                                catch (InstantiationException cause3) {
                                    throw new RuntimeException(cause3);
                                }
                                catch (IllegalAccessException cause4) {
                                    throw new RuntimeException(cause4);
                                }
                                catch (InvocationTargetException cause5) {
                                    throw new RuntimeException(cause5);
                                }
                                break;
                            }
                        }
                        final int n3 = 0;
                        continue;
                    }
                }
            }
            final int n2 = 0;
            continue;
        }
    }
    
    public abstract void addContentView(final View p0, final ViewGroup$LayoutParams p1);
    
    protected final boolean callbackCreateOptionsMenu(final Menu menu) {
        boolean onCreatePanelMenu = true;
        if (this.mActivity instanceof ActionBarSherlock$OnCreatePanelMenuListener) {
            onCreatePanelMenu = ((ActionBarSherlock$OnCreatePanelMenuListener)this.mActivity).onCreatePanelMenu(0, menu);
        }
        else if (this.mActivity instanceof ActionBarSherlock$OnCreateOptionsMenuListener) {
            return ((ActionBarSherlock$OnCreateOptionsMenuListener)this.mActivity).onCreateOptionsMenu(menu);
        }
        return onCreatePanelMenu;
    }
    
    protected final boolean callbackOptionsItemSelected(final MenuItem menuItem) {
        if (this.mActivity instanceof ActionBarSherlock$OnMenuItemSelectedListener) {
            return ((ActionBarSherlock$OnMenuItemSelectedListener)this.mActivity).onMenuItemSelected(0, menuItem);
        }
        return this.mActivity instanceof ActionBarSherlock$OnOptionsItemSelectedListener && ((ActionBarSherlock$OnOptionsItemSelectedListener)this.mActivity).onOptionsItemSelected(menuItem);
    }
    
    protected final boolean callbackPrepareOptionsMenu(final Menu menu) {
        boolean onPreparePanel = true;
        if (this.mActivity instanceof ActionBarSherlock$OnPreparePanelListener) {
            onPreparePanel = ((ActionBarSherlock$OnPreparePanelListener)this.mActivity).onPreparePanel(0, null, menu);
        }
        else if (this.mActivity instanceof ActionBarSherlock$OnPrepareOptionsMenuListener) {
            return ((ActionBarSherlock$OnPrepareOptionsMenuListener)this.mActivity).onPrepareOptionsMenu(menu);
        }
        return onPreparePanel;
    }
    
    public boolean dispatchCloseOptionsMenu() {
        return false;
    }
    
    public void dispatchConfigurationChanged(final Configuration configuration) {
    }
    
    public abstract boolean dispatchCreateOptionsMenu(final android.view.Menu p0);
    
    public void dispatchDestroy() {
    }
    
    public abstract void dispatchInvalidateOptionsMenu();
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return false;
    }
    
    public boolean dispatchMenuOpened(final int n, final android.view.Menu menu) {
        return false;
    }
    
    public boolean dispatchOpenOptionsMenu() {
        return false;
    }
    
    public abstract boolean dispatchOptionsItemSelected(final android.view.MenuItem p0);
    
    public void dispatchPanelClosed(final int n, final android.view.Menu menu) {
    }
    
    public void dispatchPause() {
    }
    
    public void dispatchPostCreate(final Bundle bundle) {
    }
    
    public void dispatchPostResume() {
    }
    
    public abstract boolean dispatchPrepareOptionsMenu(final android.view.Menu p0);
    
    public void dispatchRestoreInstanceState(final Bundle bundle) {
    }
    
    public void dispatchSaveInstanceState(final Bundle bundle) {
    }
    
    public void dispatchStop() {
    }
    
    public void dispatchTitleChanged(final CharSequence charSequence, final int n) {
    }
    
    public void ensureActionBar() {
    }
    
    public abstract ActionBar getActionBar();
    
    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater == null) {
            if (this.getActionBar() != null) {
                this.mMenuInflater = new MenuInflater(this.getThemedContext(), this.mActivity);
            }
            else {
                this.mMenuInflater = new MenuInflater((Context)this.mActivity);
            }
        }
        return this.mMenuInflater;
    }
    
    protected abstract Context getThemedContext();
    
    public abstract boolean hasFeature(final int p0);
    
    public abstract boolean requestFeature(final int p0);
    
    public abstract void setContentView(final int p0);
    
    public void setContentView(final View view) {
        this.setContentView(view, new ViewGroup$LayoutParams(-1, -1));
    }
    
    public abstract void setContentView(final View p0, final ViewGroup$LayoutParams p1);
    
    public abstract void setProgress(final int p0);
    
    public abstract void setProgressBarIndeterminate(final boolean p0);
    
    public abstract void setProgressBarIndeterminateVisibility(final boolean p0);
    
    public abstract void setProgressBarVisibility(final boolean p0);
    
    public abstract void setSecondaryProgress(final int p0);
    
    public void setTitle(final int n) {
        this.setTitle(this.mActivity.getString(n));
    }
    
    public abstract void setTitle(final CharSequence p0);
    
    public abstract void setUiOptions(final int p0);
    
    public abstract void setUiOptions(final int p0, final int p1);
    
    public abstract ActionMode startActionMode(final ActionMode$Callback p0);
}
