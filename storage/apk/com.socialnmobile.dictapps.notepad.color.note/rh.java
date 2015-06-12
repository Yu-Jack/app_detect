import android.support.v4.app.FragmentActivity;
import com.socialnmobile.colornote.fragment.ScreenFragment;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class rh
{
    public static TopBarSubMenuInfo a(final Context context, final rg rg) {
        final TopBarSubMenuInfo topBarSubMenuInfo = new TopBarSubMenuInfo(context, context.getString(2131230804), rg);
        topBarSubMenuInfo.a(1, 2130837625, 2131230827);
        topBarSubMenuInfo.a(3, 2130837622, 2131230828);
        topBarSubMenuInfo.a(2, 2130837623, 2131230829);
        topBarSubMenuInfo.a(4, 2130837624, 2131230830);
        return topBarSubMenuInfo;
    }
    
    public static TopBarSubMenuInfo a(final Context context, final rg rg, final String s) {
        TopBarSubMenuInfo topBarSubMenuInfo;
        if (s == null) {
            topBarSubMenuInfo = new TopBarSubMenuInfo(context, context.getString(2131230806), rg);
        }
        else {
            topBarSubMenuInfo = new TopBarSubMenuInfo(context, s, rg);
        }
        topBarSubMenuInfo.a(0, 2130837593, 2131230774);
        topBarSubMenuInfo.a(16, 2130837604, 2131230775);
        return topBarSubMenuInfo;
    }
    
    public static TopBarSubMenuInfo a(final ScreenFragment screenFragment, final rg rg) {
        final FragmentActivity h = screenFragment.h();
        final int i = screenFragment.I();
        final TopBarSubMenuInfo topBarSubMenuInfo = new TopBarSubMenuInfo((Context)h, ((Context)h).getString(2131230737), rg);
        if (i != 3) {
            topBarSubMenuInfo.a(1, 2130837597, 2131230998);
        }
        else {
            topBarSubMenuInfo.a(6, 2130837597, 2131231002);
        }
        topBarSubMenuInfo.a(5, 2130837594, 2131230997);
        topBarSubMenuInfo.a(2, 2130837616, 2131230999);
        topBarSubMenuInfo.a(3, 2130837617, 2131231000);
        if (i == 1) {
            topBarSubMenuInfo.a(4, 2130837610, 2131231001);
        }
        else if (i == 4) {
            topBarSubMenuInfo.a(7, 2130837605, 2131231003);
            return topBarSubMenuInfo;
        }
        return topBarSubMenuInfo;
    }
}
