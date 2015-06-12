// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.view.animation.Animation;
import android.view.animation.AlphaAnimation;
import android.os.Build$VERSION;
import android.widget.ImageView;
import android.os.Message;
import android.os.Handler;

class k extends Handler
{
    public void handleMessage(final Message message) {
        com.ogqcorp.commons.j j;
        ImageView imageView;
        try {
            j = (com.ogqcorp.commons.j)message.obj;
            if (!j.a.equals(j.d.getTag())) {
                j.b();
                return;
            }
            imageView = (ImageView)j.d;
            if (imageView.getDrawable() != null) {
                j.b();
                return;
            }
        }
        catch (Exception ex) {
            l.c(ex);
            return;
        }
        if (Build$VERSION.SDK_INT >= 11) {
            final AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(200L);
            imageView.startAnimation((Animation)alphaAnimation);
        }
        imageView.setImageBitmap(j.a());
        if (imageView instanceof SafeImageView) {
            ((SafeImageView)imageView).a(j.c, j.e);
        }
    }
}
