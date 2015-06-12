// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.view.MenuItem;
import android.view.KeyEvent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.view.Menu;
import java.util.ArrayList;
import android.os.Parcelable;
import android.view.LayoutInflater$Factory;
import android.os.Bundle;
import android.content.res.Configuration;
import android.util.Log;
import java.io.FileDescriptor;
import android.os.Build$VERSION;
import android.content.Intent;
import android.view.ViewGroup;
import java.io.PrintWriter;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import android.view.View;
import android.os.Message;
import android.support.v4.b.l;
import android.os.Handler;
import android.app.Activity;

public class FragmentActivity extends Activity
{
    final Handler a;
    final i b;
    final g c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    l l;
    n m;
    
    public FragmentActivity() {
        this.a = new Handler() {
            public final void handleMessage(final Message message) {
                switch (message.what) {
                    default: {
                        super.handleMessage(message);
                        break;
                    }
                    case 1: {
                        if (FragmentActivity.this.f) {
                            FragmentActivity.this.a(false);
                            return;
                        }
                        break;
                    }
                    case 2: {
                        FragmentActivity.this.a();
                        FragmentActivity.this.b.d();
                    }
                }
            }
        };
        this.b = new i();
        this.c = new g() {
            @Override
            public final View a(final int n) {
                return FragmentActivity.this.findViewById(n);
            }
        };
    }
    
    private static String a(final View view) {
        char c = 'F';
        char c2 = '.';
        final StringBuilder sb = new StringBuilder(128);
        sb.append(view.getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(view)));
        sb.append(' ');
        Resources resources;
        int id = 0;
        String resourcePackageName;
        String resourceTypeName;
        String resourceEntryName;
        char c3 = '\0';
        char c4 = '\0';
        char c5 = '\0';
        char c6 = '\0';
        char c7 = '\0';
        char c8 = '\0';
        char c9 = '\0';
        char c10 = '\0';
        Label_0485_Outer:Label_0581_Outer:
        while (true) {
        Label_0588_Outer:
            while (true) {
                while (true) {
                    Label_0539_Outer:Label_0552_Outer:Label_0558_Outer:Label_0575_Outer:
                    while (true) {
                        Label_0253: {
                            while (true) {
                                Label_0236:Label_0564_Outer:
                                while (true) {
                                    Label_0215: {
                                        while (true) {
                                            Label_0197: {
                                                while (true) {
                                                    Label_0179: {
                                                    Label_0546_Outer:
                                                        while (true) {
                                                            Label_0161: {
                                                                while (true) {
                                                                    Label_0143: {
                                                                        while (true) {
                                                                            Label_0126: {
                                                                                while (true) {
                                                                                    Label_0108: {
                                                                                        while (true) {
                                                                                            while (true) {
                                                                                                while (true) {
                                                                                                    switch (view.getVisibility()) {
                                                                                                        default: {
                                                                                                            sb.append(c2);
                                                                                                            break;
                                                                                                        }
                                                                                                        case 0: {
                                                                                                            Label_0497: {
                                                                                                                break Label_0497;
                                                                                                                try {
                                                                                                                    resourcePackageName = resources.getResourcePackageName(id);
                                                                                                                    while (true) {
                                                                                                                        resourceTypeName = resources.getResourceTypeName(id);
                                                                                                                        resourceEntryName = resources.getResourceEntryName(id);
                                                                                                                        sb.append(" ");
                                                                                                                        sb.append(resourcePackageName);
                                                                                                                        sb.append(":");
                                                                                                                        sb.append(resourceTypeName);
                                                                                                                        sb.append("/");
                                                                                                                        sb.append(resourceEntryName);
                                                                                                                        sb.append("}");
                                                                                                                        return sb.toString();
                                                                                                                        c3 = 'D';
                                                                                                                        break Label_0143;
                                                                                                                        sb.append('G');
                                                                                                                        break;
                                                                                                                        c4 = c2;
                                                                                                                        break Label_0179;
                                                                                                                        c5 = c2;
                                                                                                                        break Label_0197;
                                                                                                                        resourcePackageName = "app";
                                                                                                                        continue Label_0485_Outer;
                                                                                                                        c6 = c2;
                                                                                                                        break Label_0108;
                                                                                                                        c7 = c2;
                                                                                                                        break Label_0253;
                                                                                                                        sb.append('V');
                                                                                                                        break;
                                                                                                                        sb.append('I');
                                                                                                                        break;
                                                                                                                        c8 = c2;
                                                                                                                        break Label_0161;
                                                                                                                        resourcePackageName = "android";
                                                                                                                        continue Label_0485_Outer;
                                                                                                                    }
                                                                                                                    c = c2;
                                                                                                                    break Label_0236;
                                                                                                                    c9 = c2;
                                                                                                                    break Label_0126;
                                                                                                                    c10 = c2;
                                                                                                                    break Label_0215;
                                                                                                                }
                                                                                                                catch (Resources$NotFoundException ex) {
                                                                                                                    continue Label_0539_Outer;
                                                                                                                }
                                                                                                            }
                                                                                                            break;
                                                                                                        }
                                                                                                        case 4: {
                                                                                                            continue Label_0546_Outer;
                                                                                                        }
                                                                                                        case 8: {
                                                                                                            continue Label_0552_Outer;
                                                                                                        }
                                                                                                    }
                                                                                                    break;
                                                                                                }
                                                                                                break;
                                                                                            }
                                                                                            if (!view.isFocusable()) {
                                                                                                continue Label_0575_Outer;
                                                                                            }
                                                                                            break;
                                                                                        }
                                                                                        c6 = c;
                                                                                    }
                                                                                    sb.append(c6);
                                                                                    if (!view.isEnabled()) {
                                                                                        continue Label_0564_Outer;
                                                                                    }
                                                                                    break;
                                                                                }
                                                                                c9 = 'E';
                                                                            }
                                                                            sb.append(c9);
                                                                            if (!view.willNotDraw()) {
                                                                                continue Label_0552_Outer;
                                                                            }
                                                                            break;
                                                                        }
                                                                        c3 = c2;
                                                                    }
                                                                    sb.append(c3);
                                                                    if (!view.isHorizontalScrollBarEnabled()) {
                                                                        continue Label_0588_Outer;
                                                                    }
                                                                    break;
                                                                }
                                                                c8 = 'H';
                                                            }
                                                            sb.append(c8);
                                                            if (!view.isVerticalScrollBarEnabled()) {
                                                                continue Label_0558_Outer;
                                                            }
                                                            break;
                                                        }
                                                        c4 = 'V';
                                                    }
                                                    sb.append(c4);
                                                    if (!view.isClickable()) {
                                                        continue Label_0581_Outer;
                                                    }
                                                    break;
                                                }
                                                c5 = 'C';
                                            }
                                            sb.append(c5);
                                            if (!view.isLongClickable()) {
                                                continue;
                                            }
                                            break;
                                        }
                                        c10 = 'L';
                                    }
                                    sb.append(c10);
                                    sb.append(' ');
                                    if (!view.isFocused()) {
                                        continue Label_0564_Outer;
                                    }
                                    break;
                                }
                                sb.append(c);
                                if (!view.isSelected()) {
                                    continue Label_0588_Outer;
                                }
                                break;
                            }
                            c7 = 'S';
                        }
                        sb.append(c7);
                        if (view.isPressed()) {
                            c2 = 'P';
                        }
                        sb.append(c2);
                        sb.append(' ');
                        sb.append(view.getLeft());
                        sb.append(',');
                        sb.append(view.getTop());
                        sb.append('-');
                        sb.append(view.getRight());
                        sb.append(',');
                        sb.append(view.getBottom());
                        id = view.getId();
                        if (id == -1) {
                            continue Label_0539_Outer;
                        }
                        sb.append(" #");
                        sb.append(Integer.toHexString(id));
                        resources = view.getResources();
                        if (id == 0 || resources == null) {
                            continue Label_0539_Outer;
                        }
                        break;
                    }
                    switch (0xFF000000 & id) {
                        default: {
                            continue Label_0485_Outer;
                        }
                        case 2130706432: {
                            continue Label_0588_Outer;
                        }
                        case 16777216: {
                            continue;
                        }
                    }
                    break;
                }
                break;
            }
            break;
        }
    }
    
    private void a(final String s, final PrintWriter printWriter, final View view) {
        printWriter.print(s);
        if (view == null) {
            printWriter.println("null");
        }
        else {
            printWriter.println(a(view));
            if (view instanceof ViewGroup) {
                final ViewGroup viewGroup = (ViewGroup)view;
                final int childCount = viewGroup.getChildCount();
                if (childCount > 0) {
                    final String string = s + "  ";
                    for (int i = 0; i < childCount; ++i) {
                        this.a(string, printWriter, viewGroup.getChildAt(i));
                    }
                }
            }
        }
    }
    
    public static void c() {
    }
    
    final n a(final String s, final boolean b, final boolean b2) {
        if (this.l == null) {
            this.l = new l();
        }
        n n = (n)this.l.get(s);
        if (n == null) {
            if (b2) {
                n = new n(s, this, b);
                this.l.put(s, n);
            }
            return n;
        }
        n.a(this);
        return n;
    }
    
    protected final void a() {
        this.b.k();
    }
    
    public final void a(final Fragment fragment, final Intent intent, final int n) {
        if (n == -1) {
            super.startActivityForResult(intent, -1);
            return;
        }
        if ((0xFFFF0000 & n) != 0x0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, (1 + fragment.mIndex << 16) + (0xFFFF & n));
    }
    
    final void a(final String s) {
        if (this.l != null) {
            final n n = (n)this.l.get(s);
            if (n != null && !n.g) {
                n.h();
                this.l.remove(s);
            }
        }
    }
    
    final void a(final boolean h) {
        if (!this.g) {
            this.g = true;
            this.h = h;
            this.a.removeMessages(1);
            if (this.k) {
                this.k = false;
                if (this.m != null) {
                    if (!this.h) {
                        this.m.c();
                    }
                    else {
                        this.m.d();
                    }
                }
            }
            this.b.n();
        }
    }
    
    public final void b() {
        if (Build$VERSION.SDK_INT >= 11) {
            this.invalidateOptionsMenu();
            return;
        }
        this.i = true;
    }
    
    public final h d() {
        return this.b;
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        printWriter.print(s);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        final String string = s + "  ";
        printWriter.print(string);
        printWriter.print("mCreated=");
        printWriter.print(this.d);
        printWriter.print("mResumed=");
        printWriter.print(this.e);
        printWriter.print(" mStopped=");
        printWriter.print(this.f);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.g);
        printWriter.print(string);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.k);
        if (this.m != null) {
            printWriter.print(s);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.m)));
            printWriter.println(":");
            this.m.a(s + "  ", printWriter);
        }
        this.b.a(s, fileDescriptor, printWriter, array);
        printWriter.print(s);
        printWriter.println("View Hierarchy:");
        this.a(s + "  ", printWriter, this.getWindow().getDecorView());
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        this.b.g();
        final int n3 = n >> 16;
        if (n3 == 0) {
            super.onActivityResult(n, n2, intent);
            return;
        }
        final int index = n3 - 1;
        if (this.b.f == null || index < 0 || index >= this.b.f.size()) {
            Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(n));
            return;
        }
        final Fragment fragment = this.b.f.get(index);
        if (fragment == null) {
            Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(n));
            return;
        }
        fragment.onActivityResult(0xFFFF & n, n2, intent);
    }
    
    public void onBackPressed() {
        if (!this.b.c()) {
            this.finish();
        }
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b.a(configuration);
    }
    
    protected void onCreate(final Bundle bundle) {
        this.b.a(this, this.c, null);
        if (this.getLayoutInflater().getFactory() == null) {
            this.getLayoutInflater().setFactory((LayoutInflater$Factory)this);
        }
        super.onCreate(bundle);
        final f f = (f)this.getLastNonConfigurationInstance();
        if (f != null) {
            this.l = f.e;
        }
        if (bundle != null) {
            final Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            final i b = this.b;
            ArrayList d;
            if (f != null) {
                d = f.d;
            }
            else {
                d = null;
            }
            b.a(parcelable, d);
        }
        this.b.h();
    }
    
    public boolean onCreatePanelMenu(final int n, final Menu menu) {
        if (n == 0) {
            final boolean b = super.onCreatePanelMenu(n, menu) | this.b.a(menu, this.getMenuInflater());
            return Build$VERSION.SDK_INT < 11 || b;
        }
        return super.onCreatePanelMenu(n, menu);
    }
    
    public View onCreateView(final String anObject, final Context context, final AttributeSet set) {
        if (!"fragment".equals(anObject)) {
            return super.onCreateView(anObject, context, set);
        }
        String str = set.getAttributeValue((String)null, "class");
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, android.support.v4.app.e.a);
        if (str == null) {
            str = obtainStyledAttributes.getString(0);
        }
        final int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        final String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass((Context)this, str)) {
            return super.onCreateView(anObject, context, set);
        }
        Fragment obj = null;
        if (resourceId != -1) {
            obj = this.b.b(resourceId);
        }
        if (obj == null && string != null) {
            obj = this.b.a(string);
        }
        if (obj == null) {
            obj = this.b.b(0);
        }
        if (android.support.v4.app.i.a) {
            Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str + " existing=" + obj);
        }
        if (obj == null) {
            final Fragment instantiate = Fragment.instantiate((Context)this, str);
            instantiate.mFromLayout = true;
            int mFragmentId;
            if (resourceId != 0) {
                mFragmentId = resourceId;
            }
            else {
                mFragmentId = 0;
            }
            instantiate.mFragmentId = mFragmentId;
            instantiate.mContainerId = 0;
            instantiate.mTag = string;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = this.b;
            instantiate.onInflate(this, set, instantiate.mSavedFragmentState);
            this.b.a(instantiate, true);
            obj = instantiate;
        }
        else {
            if (obj.mInLayout) {
                throw new IllegalArgumentException(set.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(0) + " with another fragment for " + str);
            }
            obj.mInLayout = true;
            if (!obj.mRetaining) {
                obj.onInflate(this, set, obj.mSavedFragmentState);
            }
            this.b.b(obj);
        }
        if (obj.mView == null) {
            throw new IllegalStateException("Fragment " + str + " did not create a view.");
        }
        if (resourceId != 0) {
            obj.mView.setId(resourceId);
        }
        if (obj.mView.getTag() == null) {
            obj.mView.setTag((Object)string);
        }
        return obj.mView;
    }
    
    protected void onDestroy() {
        super.onDestroy();
        this.a(false);
        this.b.p();
        if (this.m != null) {
            this.m.h();
        }
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (Build$VERSION.SDK_INT < 5 && n == 4 && keyEvent.getRepeatCount() == 0) {
            this.onBackPressed();
            return true;
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public void onLowMemory() {
        super.onLowMemory();
        this.b.q();
    }
    
    public boolean onMenuItemSelected(final int n, final MenuItem menuItem) {
        if (super.onMenuItemSelected(n, menuItem)) {
            return true;
        }
        switch (n) {
            default: {
                return false;
            }
            case 0: {
                return this.b.a(menuItem);
            }
            case 6: {
                return this.b.b(menuItem);
            }
        }
    }
    
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        this.b.g();
    }
    
    public void onPanelClosed(final int n, final Menu menu) {
        switch (n) {
            case 0: {
                this.b.b(menu);
                break;
            }
        }
        super.onPanelClosed(n, menu);
    }
    
    protected void onPause() {
        super.onPause();
        this.e = false;
        if (this.a.hasMessages(2)) {
            this.a.removeMessages(2);
            this.b.k();
        }
        this.b.l();
    }
    
    protected void onPostResume() {
        super.onPostResume();
        this.a.removeMessages(2);
        this.b.k();
        this.b.d();
    }
    
    public boolean onPreparePanel(final int n, final View view, final Menu menu) {
        if (n == 0 && menu != null) {
            if (this.i) {
                this.i = false;
                menu.clear();
                this.onCreatePanelMenu(n, menu);
            }
            return super.onPreparePanel(0, view, menu) | this.b.a(menu);
        }
        return super.onPreparePanel(n, view, menu);
    }
    
    protected void onResume() {
        super.onResume();
        this.a.sendEmptyMessage(2);
        this.e = true;
        this.b.d();
    }
    
    public final Object onRetainNonConfigurationInstance() {
        int i = 0;
        if (this.f) {
            this.a(true);
        }
        final ArrayList e = this.b.e();
        boolean b;
        if (this.l != null) {
            final int size = this.l.size();
            final n[] array = new n[size];
            for (int j = size - 1; j >= 0; --j) {
                array[j] = (n)this.l.b(j);
            }
            b = false;
            while (i < size) {
                final n n = array[i];
                if (n.g) {
                    b = true;
                }
                else {
                    n.h();
                    this.l.remove(n.d);
                }
                ++i;
            }
        }
        else {
            b = false;
        }
        if (e == null && !b) {
            return null;
        }
        final f f = new f();
        f.a = null;
        f.b = null;
        f.c = null;
        f.d = e;
        f.e = this.l;
        return f;
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        final Parcelable f = this.b.f();
        if (f != null) {
            bundle.putParcelable("android:support:fragments", f);
        }
    }
    
    protected void onStart() {
        super.onStart();
        this.f = false;
        this.g = false;
        this.a.removeMessages(1);
        if (!this.d) {
            this.d = true;
            this.b.i();
        }
        this.b.g();
        this.b.d();
        if (!this.k) {
            this.k = true;
            if (this.m != null) {
                this.m.b();
            }
            else if (!this.j) {
                this.m = this.a("(root)", this.k, false);
                if (this.m != null && !this.m.f) {
                    this.m.b();
                }
            }
            this.j = true;
        }
        this.b.j();
        if (this.l != null) {
            final int size = this.l.size();
            final n[] array = new n[size];
            for (int i = size - 1; i >= 0; --i) {
                array[i] = (n)this.l.b(i);
            }
            for (final n n : array) {
                n.e();
                n.g();
            }
        }
    }
    
    protected void onStop() {
        super.onStop();
        this.f = true;
        this.a.sendEmptyMessage(1);
        this.b.m();
    }
    
    public void startActivityForResult(final Intent intent, final int n) {
        if (n != -1 && (0xFFFF0000 & n) != 0x0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, n);
    }
}
