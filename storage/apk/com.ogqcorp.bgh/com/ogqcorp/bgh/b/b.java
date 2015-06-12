// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.b;

import com.ogqcorp.commons.t;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.Menu;
import com.ogqcorp.bgh.item.Effect;
import com.ogqcorp.bgh.system.r;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.Arrays;
import com.ogqcorp.bgh.system.TagsLayout;
import com.ogqcorp.bgh.system.MeasuredImageView;
import com.ogqcorp.commons.x;
import com.ogqcorp.bgh.system.ac;
import android.widget.Button;
import com.ogqcorp.bgh.item.License;
import android.widget.ImageButton;
import com.ogqcorp.bgh.system.g;
import com.ogqcorp.bgh.item.Author;
import android.widget.ImageView;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import com.ogqcorp.bgh.item.Link;
import android.content.Context;
import com.ogqcorp.bgh.system.f;
import com.ogqcorp.commons.o;
import android.os.Parcelable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.ogqcorp.bgh.system.l;
import android.view.View$OnClickListener;
import android.widget.TextView;
import android.view.View;
import java.util.HashSet;
import com.ogqcorp.bgh.system.q;
import com.ogqcorp.bgh.system.j;
import java.util.Set;
import com.ogqcorp.bgh.item.Background;
import com.ogqcorp.bgh.b.a.a;

public final class b extends a<Background>
{
    private Background a;
    private Set<Integer> b;
    private j c;
    private j d;
    private q e;
    
    public b() {
        this.b = new HashSet<Integer>();
        this.c = new j();
        this.d = new j();
        this.setHasOptionsMenu(true);
    }
    
    private View a(final View view, final int n, final boolean b) {
        if (!this.b.contains(n) || !b) {
            final View viewById = view.findViewById(n);
            viewById.setVisibility(0);
            this.b.add(n);
            return viewById;
        }
        return null;
    }
    
    private TextView a(final View view, final int n, final CharSequence text, final boolean b) {
        TextView textView;
        if (text == null || text.length() == 0 || text.equals("@null")) {
            textView = null;
        }
        else {
            textView = (TextView)this.a(view, n, b);
            if (textView != null) {
                textView.setText(text);
                return textView;
            }
        }
        return textView;
    }
    
    private void a(final View view, final String s) {
        view.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                if (com.ogqcorp.bgh.b.b.this.e()) {
                    return;
                }
                try {
                    com.ogqcorp.bgh.b.b.this.getActivity().getClass().getMethod(s, Background.class, View.class).invoke(com.ogqcorp.bgh.b.b.this.getActivity(), com.ogqcorp.bgh.b.b.this.b(), view);
                }
                catch (Exception ex) {
                    l.a(ex);
                }
            }
        });
    }
    
    public static Fragment b(final Background background) {
        final b b = new b();
        final Bundle arguments = new Bundle();
        arguments.putParcelable("KEY_BACKGROUND", (Parcelable)background);
        b.setArguments(arguments);
        return b;
    }
    
    private void c(final Background background) {
        new o().a(background, "background");
        final List<Link> linksList = background.getLinksList();
        if (linksList != null && !linksList.isEmpty()) {
            final String f = com.ogqcorp.bgh.system.f.a().f((Context)this.getActivity());
            final Iterator<Link> iterator = linksList.iterator();
            while (iterator.hasNext()) {
                final Link link = iterator.next();
                final Set<String> whiteCountriesSet = link.getWhiteCountriesSet();
                if (whiteCountriesSet != null && !whiteCountriesSet.isEmpty() && !whiteCountriesSet.contains(f)) {
                    iterator.remove();
                }
                else {
                    final Set<String> blackCountriesSet = link.getBlackCountriesSet();
                    if (blackCountriesSet == null || blackCountriesSet.isEmpty() || !blackCountriesSet.contains(f)) {
                        continue;
                    }
                    iterator.remove();
                }
            }
            Collections.sort((List<Comparable>)linksList);
        }
    }
    
    @c
    private void constructActions(final View view, final Background background) {
        final View a = this.a(view, 2131099769, true);
        if (a != null) {
            this.a(a, "onWallpaperClick");
        }
        final View a2 = this.a(view, 2131099791, true);
        if (a2 != null) {
            this.a(a2, "onSaveClick");
        }
        final View a3 = this.a(view, 2131099792, true);
        if (a3 != null) {
            this.a(a3, "onFavoriteClick");
        }
    }
    
    @c
    private void constructAuthor(final View view, final Background background) {
        final Author author = background.getAuthor();
        if (author != null) {
            final View a = this.a(view, 2131099816, true);
            if (a != null) {
                this.a(a, "onAuthorClick");
            }
            this.d.c((Context)this.getActivity(), author.getId(), (ImageView)view.findViewById(2131099818));
            this.a(view, 2131099819, author.getName(), true);
            this.a(view, 2131099821, author.getDescription(), true);
            this.a(view, 2131099823, author.getLocation(), true);
            final TextView a2 = this.a(view, 2131099820, author.getHomepage(), true);
            if (a2 != null) {
                this.a((View)a2, "onAuthorHomepageClick");
            }
        }
    }
    
    @c
    private void constructDescription(final View view, final Background background) {
        this.a(view, 2131099824, background.getDescription(), true);
    }
    
    @c
    private void constructFavorite(final View view, final Background background) {
        final boolean a = g.a().a(background);
        final View viewById = view.findViewById(2131099835);
        int visibility;
        if (a) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        viewById.setVisibility(visibility);
        final ImageButton imageButton = (ImageButton)view.findViewById(2131099792);
        int imageResource;
        if (a) {
            imageResource = 2130837703;
        }
        else {
            imageResource = 2130837702;
        }
        imageButton.setImageResource(imageResource);
    }
    
    @c
    private void constructLicense(final View view, final Background background) {
        final License license = background.getLicense();
        if (license != null) {
            final View a = this.a(view, 2131099774, true);
            if (a != null) {
                final TextView textView = (TextView)view.findViewById(2131099831);
                final String type = license.getType();
                if (type.startsWith("copy")) {
                    view.findViewById(2131099825).setVisibility(0);
                    textView.setText(2131427452);
                }
                else if (type.equals("public")) {
                    view.findViewById(2131099830).setVisibility(0);
                    textView.setText(2131427453);
                }
                else if (type.startsWith("cc")) {
                    view.findViewById(2131099826).setVisibility(0);
                    for (final String s : type.split("-")) {
                        if (s.equals("nc")) {
                            view.findViewById(2131099827).setVisibility(0);
                        }
                        if (s.equals("nd")) {
                            view.findViewById(2131099828).setVisibility(0);
                        }
                        if (s.equals("sa")) {
                            view.findViewById(2131099829).setVisibility(0);
                        }
                    }
                    textView.setText(2131427451);
                }
                this.a(a, "onLicenseClick");
            }
        }
    }
    
    @c
    private void constructLinks(final View view, final Background background) {
        final List<Link> linksList = background.getLinksList();
        if (linksList != null && !linksList.isEmpty()) {
            final Button button = (Button)this.a(view, 2131099790, true);
            if (button != null) {
                try {
                    x.a((View)button, linksList.get(0).a(ac.a((Context)this.getActivity()).toString()));
                    this.a((View)button, "onLinkClick");
                }
                catch (Exception ex) {
                    button.setVisibility(8);
                }
            }
        }
    }
    
    @c
    private void constructPreview(final View view, final Background background) {
        final double imageRatio = background.getImageRatio();
        if (imageRatio != 0.0 && !Double.isNaN(imageRatio)) {
            final MeasuredImageView measuredImageView = (MeasuredImageView)this.a(view, 2131099834, true);
            if (measuredImageView != null) {
                measuredImageView.setImageRatio(imageRatio);
                this.a((View)measuredImageView, "onPreviewClick");
            }
        }
    }
    
    @c
    private void constructScore(final View view, final Background background) {
        final int score = background.getScore();
        if (score == 0) {
            return;
        }
        final View a = this.a(view, 2131099832, true);
        if (a != null) {
            this.a(a, "onScoreClick");
        }
        this.a(view, 2131099832, ac.a((Object)score), false);
    }
    
    @c
    private void constructTags(final View view, final Background background) {
        final String tags = background.getTags();
        if (tags != null && tags.length() != 0 && !tags.equals("@null")) {
            final TagsLayout tagsLayout = (TagsLayout)this.a(view, 2131099836, true);
            if (tagsLayout != null) {
                final LayoutInflater layoutInflater = this.getActivity().getLayoutInflater();
                final String[] split = tags.trim().split(" ");
                Arrays.sort(split);
                for (final String text : split) {
                    final Button button = (Button)layoutInflater.inflate(2130903092, (ViewGroup)tagsLayout, false);
                    button.setText((CharSequence)text);
                    this.a((View)button, "onTagClick");
                    tagsLayout.addView((View)button);
                }
            }
        }
    }
    
    @c
    private void constructTitle(final View view, final Background background) {
        this.a(view, 2131099795, background.getTitle(), true);
    }
    
    private void constructViews(final View view, final Background background) {
        final Method[] declaredMethods = this.getClass().getDeclaredMethods();
        final int length = declaredMethods.length;
        int i = 0;
    Label_0059_Outer:
        while (i < length) {
            final Method method = declaredMethods[i];
            while (true) {
                if (method.isAnnotationPresent(c.class)) {
                    try {
                        method.invoke(this, view, background);
                        ++i;
                        continue Label_0059_Outer;
                    }
                    catch (Exception ex) {
                        l.a(ex);
                        continue;
                    }
                    break;
                }
                continue;
            }
        }
    }
    
    private boolean e() {
        return this.getActivity() == null || this.getActivity().isFinishing();
    }
    
    private void f() {
        com.ogqcorp.commons.c.a(this.getActivity(), 0, com.ogqcorp.bgh.system.o.b().e(this.a.getId()), this.g(), r.c, this);
    }
    
    private q g() {
        if (this.e == null) {
            this.e = new q();
        }
        return this.e;
    }
    
    @Override
    protected int a() {
        return 2130903077;
    }
    
    @Override
    protected void a(final View view) {
        if (this.e()) {
            return;
        }
        this.c.b((Context)this.getActivity(), this.a.getId(), (ImageView)view.findViewById(2131099834));
        this.constructViews(view, this.a);
    }
    
    @Override
    protected void a(final View view, final Background background) {
        if (this.e()) {
            return;
        }
        view.findViewById(2131099763).setVisibility(8);
        this.constructViews(view, background);
    }
    
    @Override
    public void a(final Background background) {
        if (this.e()) {
            return;
        }
        if (background != null) {
            if (this.a != null) {
                final Effect effect = this.a.getEffect();
                if (effect != null) {
                    background.setEffect(effect);
                }
            }
            this.c(background);
        }
        super.a(background);
    }
    
    @Override
    public void a(final Exception ex) {
        if (!this.e()) {
            final View view = this.getView();
            if (view != null) {
                view.findViewById(2131099763).setVisibility(8);
                final View viewById = view.findViewById(2131099789);
                viewById.setVisibility(0);
                viewById.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                    public void onClick(final View view) {
                        if (com.ogqcorp.bgh.b.b.this.e()) {
                            return;
                        }
                        view.findViewById(2131099763).setVisibility(0);
                        view.findViewById(2131099789).setVisibility(8);
                        com.ogqcorp.bgh.b.b.this.f();
                    }
                });
            }
        }
    }
    
    public Background b() {
        final Background background = this.d();
        if (background != null) {
            return background;
        }
        return this.a;
    }
    
    public void c() {
        if (this.e()) {
            return;
        }
        this.constructFavorite(this.getView(), this.b());
    }
    
    @Override
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.e()) {
            return;
        }
        this.f();
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.a = (Background)this.getArguments().getParcelable("KEY_BACKGROUND");
    }
    
    @Override
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater) {
        if (ac.f((Context)this.getActivity())) {
            menuInflater.inflate(2131623942, menu);
            return;
        }
        menuInflater.inflate(2131623941, menu);
    }
    
    @Override
    public void onDestroy() {
        if (this.e != null) {
            this.e.a(true);
            this.e = null;
        }
        this.a = null;
        super.onDestroy();
    }
    
    @Override
    public void onDestroyView() {
        t.a(this);
        System.gc();
        super.onDestroyView();
    }
}
