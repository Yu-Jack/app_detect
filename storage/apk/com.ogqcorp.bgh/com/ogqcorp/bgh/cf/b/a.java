// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.b;

import android.view.View$OnTouchListener;
import android.view.GestureDetector$OnDoubleTapListener;
import android.view.GestureDetector$OnGestureListener;
import com.ogqcorp.bgh.cf.c;
import com.ogqcorp.bgh.cf.annotation.CalledByReflection;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.animation.AnimationUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.view.MotionEvent;
import com.a.a.x;
import java.util.Iterator;
import com.ogqcorp.bgh.cf.data.Size;
import android.content.Context;
import com.ogqcorp.bgh.cf.commons.a;
import android.support.v4.app.FragmentActivity;
import java.util.Locale;
import android.widget.TextView;
import com.ogqcorp.bgh.cf.d;
import com.ogqcorp.bgh.cf.c.b.a.g;
import com.ogqcorp.bgh.cf.c.b.e;
import com.ogqcorp.bgh.cf.data.SizesInfo;
import com.ogqcorp.bgh.cf.data.PhotoInfo;
import android.view.GestureDetector;
import android.view.GestureDetector$SimpleOnGestureListener;
import com.a.a.r;
import com.ogqcorp.bgh.cf.data.Sizes;
import com.ogqcorp.bgh.cf.data.Photo;
import com.a.a.s;
import com.actionbarsherlock.app.SherlockFragment;

public final class a extends SherlockFragment
{
    private s<Photo> a;
    private s<Sizes> b;
    private r c;
    private GestureDetector$SimpleOnGestureListener d;
    private String e;
    private boolean f;
    private GestureDetector g;
    private PhotoInfo h;
    private SizesInfo i;
    
    public a() {
        this.a = new s<Photo>() {
            @Override
            public void a(final Photo photo) {
                if (com.ogqcorp.bgh.cf.b.a.this.getView() != null) {
                    final FragmentActivity activity = com.ogqcorp.bgh.cf.b.a.this.getActivity();
                    if (activity != null && !activity.isFinishing()) {
                        com.ogqcorp.bgh.cf.b.a.this.h = photo.getPhotoInfo();
                        if (com.ogqcorp.bgh.cf.b.a.this.h != null) {
                            com.ogqcorp.bgh.cf.c.b.e.a().a((g)com.ogqcorp.bgh.cf.b.a.this.getView().findViewById(com.ogqcorp.bgh.cf.d.owner_icon), com.ogqcorp.bgh.cf.b.a.this.h.getOwner().getBuddyIconUrl());
                            ((TextView)com.ogqcorp.bgh.cf.b.a.this.getView().findViewById(com.ogqcorp.bgh.cf.d.owner_name)).setText((CharSequence)com.ogqcorp.bgh.cf.b.a.this.h.getOwner().getName().toUpperCase(Locale.US));
                            ((TextView)com.ogqcorp.bgh.cf.b.a.this.getView().findViewById(com.ogqcorp.bgh.cf.d.owner_location)).setText((CharSequence)com.ogqcorp.bgh.cf.b.a.this.h.getOwner().getLocation());
                            final TextView textView = (TextView)com.ogqcorp.bgh.cf.b.a.this.getView().findViewById(com.ogqcorp.bgh.cf.d.license);
                            textView.setText((CharSequence)com.ogqcorp.bgh.cf.b.a.this.a(com.ogqcorp.bgh.cf.b.a.this.h.getLicenseCode()));
                            textView.setTag((Object)com.ogqcorp.bgh.cf.b.a.this.b(com.ogqcorp.bgh.cf.b.a.this.h.getLicenseCode()));
                        }
                    }
                }
            }
        };
        this.b = new s<Sizes>() {
            @Override
            public void a(final Sizes sizes) {
                if (com.ogqcorp.bgh.cf.b.a.this.getView() != null) {
                    final FragmentActivity activity = com.ogqcorp.bgh.cf.b.a.this.getActivity();
                    if (activity != null && !activity.isFinishing()) {
                        com.ogqcorp.bgh.cf.b.a.this.i = sizes.getSizesInfo();
                        if (com.ogqcorp.bgh.cf.b.a.this.i != null) {
                            final int n = com.ogqcorp.bgh.cf.commons.a.a().a((Context)activity).y / 2;
                            int n2 = Integer.MAX_VALUE;
                            Size size = null;
                            for (Size size2 : com.ogqcorp.bgh.cf.b.a.this.i.getSizesList()) {
                                if (size2.getLabel() == null || !size2.getLabel().contains("Square")) {
                                    final int abs = Math.abs(size2.getHeight() - n);
                                    int n3;
                                    if (n2 > abs) {
                                        n3 = abs;
                                    }
                                    else {
                                        size2 = size;
                                        n3 = n2;
                                    }
                                    n2 = n3;
                                    size = size2;
                                }
                            }
                            if (size != null) {
                                com.ogqcorp.bgh.cf.c.b.e.a().a((g)com.ogqcorp.bgh.cf.b.a.this.getView().findViewById(com.ogqcorp.bgh.cf.d.image), size.getSource());
                            }
                        }
                    }
                }
            }
        };
        this.c = new r() {
            @Override
            public void a(final x x) {
            }
        };
        this.d = new GestureDetector$SimpleOnGestureListener() {
            public boolean onDoubleTap(final MotionEvent motionEvent) {
                if (com.ogqcorp.bgh.cf.b.a.this.getView() != null) {
                    final FragmentActivity activity = com.ogqcorp.bgh.cf.b.a.this.getActivity();
                    if (activity != null && !activity.isFinishing()) {
                        final CompoundButton compoundButton = (CompoundButton)com.ogqcorp.bgh.cf.b.a.this.getView().findViewById(com.ogqcorp.bgh.cf.d.like);
                        compoundButton.toggle();
                        com.ogqcorp.bgh.cf.b.a.this.onLike((View)compoundButton);
                        return true;
                    }
                }
                return false;
            }
            
            public boolean onDown(final MotionEvent motionEvent) {
                return true;
            }
            
            public boolean onSingleTapConfirmed(final MotionEvent motionEvent) {
                if (com.ogqcorp.bgh.cf.b.a.this.getView() != null) {
                    final FragmentActivity activity = com.ogqcorp.bgh.cf.b.a.this.getActivity();
                    if (activity != null && !activity.isFinishing()) {
                        final View viewById = com.ogqcorp.bgh.cf.b.a.this.getView().findViewById(com.ogqcorp.bgh.cf.d.extra);
                        if (viewById.getVisibility() == 0) {
                            viewById.startAnimation(AnimationUtils.loadAnimation((Context)com.ogqcorp.bgh.cf.b.a.this.getActivity(), 17432577));
                            viewById.setVisibility(8);
                        }
                        else {
                            viewById.startAnimation(AnimationUtils.loadAnimation((Context)com.ogqcorp.bgh.cf.b.a.this.getActivity(), 17432576));
                            viewById.setVisibility(0);
                        }
                        return true;
                    }
                }
                return false;
            }
        };
    }
    
    public static Fragment a(final String s, final boolean b) {
        final a a = new a();
        final Bundle arguments = new Bundle();
        arguments.putString("KEY_ID", s);
        arguments.putBoolean("KEY_IS_LIKE", b);
        a.setArguments(arguments);
        return a;
    }
    
    private String a(final String s) {
        if (s.equals("4")) {
            return "CC BY";
        }
        if (s.equals("6")) {
            return "CC BY-ND";
        }
        if (s.equals("3")) {
            return "CC BY-NC-ND";
        }
        if (s.equals("2")) {
            return "CC BY-NC";
        }
        if (s.equals("1")) {
            return "CC BY-NC-SA";
        }
        if (s.equals("5")) {
            return "CC BY-SA";
        }
        if (s.equals("0")) {
            return "All Rights Reserved";
        }
        return "";
    }
    
    private void a(final Activity activity, final String s) {
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
        }
        catch (Exception ex) {}
    }
    
    private String b(final String s) {
        if (s.equals("4")) {
            return "http://creativecommons.org/licenses/by/2.0/";
        }
        if (s.equals("6")) {
            return "http://creativecommons.org/licenses/by-nd/2.0/";
        }
        if (s.equals("3")) {
            return "http://creativecommons.org/licenses/by-nc-nd/2.0/";
        }
        if (s.equals("2")) {
            return "http://creativecommons.org/licenses/by-nc/2.0/";
        }
        if (s.equals("1")) {
            return "http://creativecommons.org/licenses/by-nc-sa/2.0/";
        }
        if (s.equals("5")) {
            return "http://creativecommons.org/licenses/by-sa/2.0/";
        }
        if (s.equals("0")) {
            return "http://www.ogqcorp.com/copyright";
        }
        return "";
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.e = this.getArguments().getString("KEY_ID");
        this.f = this.getArguments().getBoolean("KEY_IS_LIKE");
    }
    
    @Override
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        return layoutInflater.inflate(com.ogqcorp.bgh.cf.e.bcf_fragment_flickr_page, viewGroup, false);
    }
    
    @CalledByReflection
    public void onDownload(final View view) {
        if (this.h != null && this.i != null) {
            final CompoundButton compoundButton = (CompoundButton)this.getView().findViewById(com.ogqcorp.bgh.cf.d.like);
            if (!compoundButton.isChecked()) {
                com.ogqcorp.bgh.cf.c.a.a(this.e, new s<String>() {
                    @Override
                    public void a(final String s) {
                    }
                }, null);
                ((b)this.getSherlockActivity()).a(this.e, true);
            }
            compoundButton.setChecked(true);
            final FragmentActivity activity = this.getActivity();
            if (activity != null && !activity.isFinishing()) {
                final int y = com.ogqcorp.bgh.cf.commons.a.a().a((Context)activity).y;
                int n = Integer.MAX_VALUE;
                final Iterator<Size> iterator = this.i.getSizesList().iterator();
                Size size = null;
                while (iterator.hasNext()) {
                    Size size2 = iterator.next();
                    if (size2.getLabel() == null || !size2.getLabel().contains("Square")) {
                        final int abs = Math.abs(size2.getHeight() - y);
                        int n2;
                        if (n > abs) {
                            n2 = abs;
                        }
                        else {
                            size2 = size;
                            n2 = n;
                        }
                        n = n2;
                        size = size2;
                    }
                }
                ((b)this.getSherlockActivity()).a(size.getSource(), this.e, this.h.getTitle());
            }
        }
    }
    
    @CalledByReflection
    public void onLicense(final View view) {
        final String s = (String)view.getTag();
        if (s != null) {
            this.a(this.getActivity(), s);
        }
    }
    
    @CalledByReflection
    public void onLike(final View view) {
        final CompoundButton compoundButton = (CompoundButton)view;
        final View viewById = this.getView().findViewById(com.ogqcorp.bgh.cf.d.like_mark);
        if (!compoundButton.isChecked()) {
            viewById.startAnimation(AnimationUtils.loadAnimation((Context)this.getActivity(), com.ogqcorp.bgh.cf.c.bcf_anim_like_mark_off));
            viewById.setVisibility(0);
            com.ogqcorp.bgh.cf.c.a.b(this.e, new s<String>() {
                @Override
                public void a(final String s) {
                }
            }, null);
            ((b)this.getSherlockActivity()).a(this.e, false);
            return;
        }
        viewById.startAnimation(AnimationUtils.loadAnimation((Context)this.getActivity(), com.ogqcorp.bgh.cf.c.bcf_anim_like_mark_on));
        viewById.setVisibility(0);
        com.ogqcorp.bgh.cf.c.a.a(this.e, new s<String>() {
            @Override
            public void a(final String s) {
            }
        }, null);
        ((b)this.getSherlockActivity()).a(this.e, true);
    }
    
    @Override
    public void onViewCreated(final View view, final Bundle bundle) {
        (this.g = new GestureDetector((Context)this.getActivity(), (GestureDetector$OnGestureListener)this.d)).setOnDoubleTapListener((GestureDetector$OnDoubleTapListener)this.d);
        this.getView().findViewById(com.ogqcorp.bgh.cf.d.image).setOnTouchListener((View$OnTouchListener)new View$OnTouchListener() {
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                return com.ogqcorp.bgh.cf.b.a.this.g.onTouchEvent(motionEvent);
            }
        });
        com.ogqcorp.bgh.cf.commons.b.a(this.getView(), com.ogqcorp.bgh.cf.d.download, this, "onDownload");
        com.ogqcorp.bgh.cf.commons.b.a(this.getView(), com.ogqcorp.bgh.cf.d.wallpaper, this, "onWallpaper");
        final CompoundButton compoundButton = (CompoundButton)this.getView().findViewById(com.ogqcorp.bgh.cf.d.like);
        compoundButton.setChecked(this.f);
        com.ogqcorp.bgh.cf.commons.b.a((View)compoundButton, this, "onLike");
        this.getView().findViewById(com.ogqcorp.bgh.cf.d.async_progress).startAnimation(AnimationUtils.loadAnimation((Context)this.getActivity(), com.ogqcorp.bgh.cf.c.bcf_anim_async_progress));
        com.ogqcorp.bgh.cf.c.a.c(this.e, this.a, this.c);
        com.ogqcorp.bgh.cf.c.a.d(this.e, this.b, this.c);
        com.ogqcorp.bgh.cf.commons.b.a(this.getView(), com.ogqcorp.bgh.cf.d.license, this, "onLicense");
    }
    
    @CalledByReflection
    public void onWallpaper(final View view) {
        if (this.h != null && this.i != null) {
            final CompoundButton compoundButton = (CompoundButton)this.getView().findViewById(com.ogqcorp.bgh.cf.d.like);
            if (!compoundButton.isChecked()) {
                com.ogqcorp.bgh.cf.c.a.a(this.e, new s<String>() {
                    @Override
                    public void a(final String s) {
                    }
                }, null);
                ((b)this.getSherlockActivity()).a(this.e, true);
            }
            compoundButton.setChecked(true);
            final FragmentActivity activity = this.getActivity();
            if (activity != null && !activity.isFinishing()) {
                final int y = com.ogqcorp.bgh.cf.commons.a.a().a((Context)activity).y;
                int n = Integer.MAX_VALUE;
                final Iterator<Size> iterator = this.i.getSizesList().iterator();
                Size size = null;
                while (iterator.hasNext()) {
                    Size size2 = iterator.next();
                    if (size2.getLabel() == null || !size2.getLabel().contains("Square")) {
                        final int abs = Math.abs(size2.getHeight() - y);
                        int n2;
                        if (n > abs) {
                            n2 = abs;
                        }
                        else {
                            size2 = size;
                            n2 = n;
                        }
                        n = n2;
                        size = size2;
                    }
                }
                ((b)this.getSherlockActivity()).b(size.getSource(), this.e, this.h.getTitle());
            }
        }
    }
    
    @Override
    public void setMenuVisibility(final boolean menuVisibility) {
        super.setMenuVisibility(menuVisibility);
        if (menuVisibility) {
            return;
        }
    }
}
