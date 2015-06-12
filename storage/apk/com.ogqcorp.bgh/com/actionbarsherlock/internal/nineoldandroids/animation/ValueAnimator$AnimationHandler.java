// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.view.animation.LinearInterpolator;
import java.util.Iterator;
import android.util.AndroidRuntimeException;
import android.os.Looper;
import android.view.animation.AccelerateDecelerateInterpolator;
import java.util.HashMap;
import android.view.animation.Interpolator;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import android.os.Message;
import android.os.Handler;

class ValueAnimator$AnimationHandler extends Handler
{
    public void handleMessage(final Message message) {
        final ArrayList<ValueAnimator> list = ValueAnimator.sAnimations.get();
        final ArrayList<ValueAnimator> list2 = ValueAnimator.sDelayedAnims.get();
        int n = 0;
        switch (message.what) {
            default: {
                return;
            }
            case 0: {
                final ArrayList list3 = ValueAnimator.sPendingAnimations.get();
                if (list.size() > 0 || list2.size() > 0) {
                    n = 0;
                }
                else {
                    n = 1;
                }
                while (list3.size() > 0) {
                    final ArrayList list4 = (ArrayList)list3.clone();
                    list3.clear();
                    for (int size = list4.size(), i = 0; i < size; ++i) {
                        final ValueAnimator e = list4.get(i);
                        if (e.mStartDelay == 0L) {
                            e.startAnimation();
                        }
                        else {
                            list2.add(e);
                        }
                    }
                }
                break;
            }
            case 1: {
                n = 1;
                break;
            }
        }
        final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        final ArrayList<ValueAnimator> list5 = ValueAnimator.sReadyAnims.get();
        final ArrayList<ValueAnimator> list6 = ValueAnimator.sEndingAnims.get();
        for (int size2 = list2.size(), j = 0; j < size2; ++j) {
            final ValueAnimator e2 = list2.get(j);
            if (e2.delayedAnimationFrame(currentAnimationTimeMillis)) {
                list5.add(e2);
            }
        }
        final int size3 = list5.size();
        if (size3 > 0) {
            for (int k = 0; k < size3; ++k) {
                final ValueAnimator o = list5.get(k);
                o.startAnimation();
                o.mRunning = true;
                list2.remove(o);
            }
            list5.clear();
        }
        int n2;
        int n3;
        for (int size4 = list.size(), l = 0; l < size4; size4 = n3, l = n2) {
            final ValueAnimator valueAnimator = list.get(l);
            if (valueAnimator.animationFrame(currentAnimationTimeMillis)) {
                list6.add(valueAnimator);
            }
            if (list.size() == size4) {
                n2 = l + 1;
                n3 = size4;
            }
            else {
                final int n4 = size4 - 1;
                list6.remove(valueAnimator);
                n2 = l;
                n3 = n4;
            }
        }
        if (list6.size() > 0) {
            for (int index = 0; index < list6.size(); ++index) {
                list6.get(index).endAnimation();
            }
            list6.clear();
        }
        if (n != 0 && (!list.isEmpty() || !list2.isEmpty())) {
            this.sendEmptyMessageDelayed(1, Math.max(0L, ValueAnimator.sFrameDelay - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
        }
    }
}
