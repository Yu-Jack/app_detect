// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.VelocityTracker;
import android.view.MotionEvent;
import android.view.GestureDetector$OnDoubleTapListener;
import android.view.GestureDetector$OnGestureListener;
import android.os.Message;
import android.os.Handler;

class m extends Handler
{
    final /* synthetic */ l a;
    
    m(final l a) {
        this.a = a;
    }
    
    m(final l a, final Handler handler) {
        this.a = a;
        super(handler.getLooper());
    }
    
    public void handleMessage(final Message obj) {
        switch (obj.what) {
            default: {
                throw new RuntimeException("Unknown message " + obj);
            }
            case 1: {
                this.a.i.onShowPress(this.a.p);
                break;
            }
            case 2: {
                this.a.c();
            }
            case 3: {
                if (this.a.j == null) {
                    break;
                }
                if (!this.a.k) {
                    this.a.j.onSingleTapConfirmed(this.a.p);
                    return;
                }
                this.a.l = true;
            }
        }
    }
}
