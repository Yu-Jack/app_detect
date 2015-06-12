// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.view;

import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.content.res.TypedArray;
import com.actionbarsherlock.R$styleable;
import android.view.View;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import android.util.Log;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.view.InflateException;
import android.util.Xml;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import android.content.Context;

public class MenuInflater
{
    private static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
    private static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    private static final String LOG_TAG = "MenuInflater";
    private static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    private final Object[] mActionProviderConstructorArguments;
    private final Object[] mActionViewConstructorArguments;
    private Context mContext;
    private Object mRealOwner;
    
    static {
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = new Class[] { Context.class };
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = MenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    }
    
    public MenuInflater(final Context context) {
        this.mContext = context;
        this.mRealOwner = context;
        this.mActionViewConstructorArguments = new Object[] { context };
        this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
    }
    
    public MenuInflater(final Context mContext, final Object mRealOwner) {
        this.mContext = mContext;
        this.mRealOwner = mRealOwner;
        this.mActionViewConstructorArguments = new Object[] { mContext };
        this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
    }
    
    private void parseMenu(final XmlPullParser xmlPullParser, final AttributeSet set, final Menu menu) {
        final MenuInflater$MenuState menuInflater$MenuState = new MenuInflater$MenuState(this, menu);
        int i = xmlPullParser.getEventType();
        String name3;
        while (true) {
            while (i != 2) {
                i = xmlPullParser.next();
                if (i == 1) {
                    Object anObject = null;
                    int n = 0;
                    int n2 = i;
                    int j = 0;
                    while (j == 0) {
                        int n3 = 0;
                        Label_0100: {
                            switch (n2) {
                                case 2: {
                                    if (n != 0) {
                                        n3 = n;
                                        break Label_0100;
                                    }
                                    final String name = xmlPullParser.getName();
                                    if (name.equals("group")) {
                                        menuInflater$MenuState.readGroup(set);
                                        n3 = n;
                                        break Label_0100;
                                    }
                                    if (name.equals("item")) {
                                        menuInflater$MenuState.readItem(set);
                                        n3 = n;
                                        break Label_0100;
                                    }
                                    if (name.equals("menu")) {
                                        this.parseMenu(xmlPullParser, set, menuInflater$MenuState.addSubMenuItem());
                                        n3 = n;
                                        break Label_0100;
                                    }
                                    anObject = name;
                                    n3 = 1;
                                    break Label_0100;
                                }
                                case 3: {
                                    final String name2 = xmlPullParser.getName();
                                    if (n != 0 && name2.equals(anObject)) {
                                        anObject = null;
                                        n3 = 0;
                                        break Label_0100;
                                    }
                                    if (name2.equals("group")) {
                                        menuInflater$MenuState.resetGroup();
                                        n3 = n;
                                        break Label_0100;
                                    }
                                    if (name2.equals("item")) {
                                        if (menuInflater$MenuState.hasAddedItem()) {
                                            break;
                                        }
                                        if (menuInflater$MenuState.itemActionProvider != null && menuInflater$MenuState.itemActionProvider.hasSubMenu()) {
                                            menuInflater$MenuState.addSubMenuItem();
                                            n3 = n;
                                            break Label_0100;
                                        }
                                        menuInflater$MenuState.addItem();
                                        n3 = n;
                                        break Label_0100;
                                    }
                                    else {
                                        if (name2.equals("menu")) {
                                            j = 1;
                                            n3 = n;
                                            break Label_0100;
                                        }
                                        break;
                                    }
                                    break;
                                }
                                case 1: {
                                    throw new RuntimeException("Unexpected end of document");
                                }
                            }
                            n3 = n;
                        }
                        final int next = xmlPullParser.next();
                        final int n4 = n3;
                        n2 = next;
                        n = n4;
                    }
                    return;
                }
            }
            name3 = xmlPullParser.getName();
            if (name3.equals("menu")) {
                i = xmlPullParser.next();
                continue;
            }
            break;
        }
        throw new RuntimeException("Expecting menu, got " + name3);
    }
    
    public void inflate(final int n, final Menu menu) {
        Object layout = null;
        try {
            layout = this.mContext.getResources().getLayout(n);
            this.parseMenu((XmlPullParser)layout, Xml.asAttributeSet((XmlPullParser)layout), menu);
        }
        catch (XmlPullParserException ex) {
            throw new InflateException("Error inflating menu XML", (Throwable)ex);
        }
        catch (IOException ex2) {
            throw new InflateException("Error inflating menu XML", (Throwable)ex2);
        }
        finally {
            if (layout != null) {
                ((XmlResourceParser)layout).close();
            }
        }
    }
}
