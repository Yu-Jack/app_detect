// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import java.util.ArrayList;
import android.util.Log;
import android.text.TextUtils;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class BackStackState implements Parcelable
{
    public static final Parcelable$Creator<BackStackState> CREATOR;
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int mIndex;
    final String mName;
    final int[] mOps;
    final int mTransition;
    final int mTransitionStyle;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<BackStackState>() {
            public BackStackState createFromParcel(final Parcel parcel) {
                return new BackStackState(parcel);
            }
            
            public BackStackState[] newArray(final int n) {
                return new BackStackState[n];
            }
        };
    }
    
    public BackStackState(final Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mTransitionStyle = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }
    
    public BackStackState(final FragmentManagerImpl fragmentManagerImpl, final BackStackRecord backStackRecord) {
        BackStackRecord$Op backStackRecord$Op = backStackRecord.mHead;
        int n = 0;
        while (backStackRecord$Op != null) {
            if (backStackRecord$Op.removed != null) {
                n += backStackRecord$Op.removed.size();
            }
            backStackRecord$Op = backStackRecord$Op.next;
        }
        this.mOps = new int[n + 7 * backStackRecord.mNumOp];
        if (!backStackRecord.mAddToBackStack) {
            throw new IllegalStateException("Not on back stack");
        }
        BackStackRecord$Op backStackRecord$Op2 = backStackRecord.mHead;
        int n2 = 0;
        while (backStackRecord$Op2 != null) {
            final int[] mOps = this.mOps;
            final int n3 = n2 + 1;
            mOps[n2] = backStackRecord$Op2.cmd;
            final int[] mOps2 = this.mOps;
            final int n4 = n3 + 1;
            int mIndex;
            if (backStackRecord$Op2.fragment != null) {
                mIndex = backStackRecord$Op2.fragment.mIndex;
            }
            else {
                mIndex = -1;
            }
            mOps2[n3] = mIndex;
            final int[] mOps3 = this.mOps;
            final int n5 = n4 + 1;
            mOps3[n4] = backStackRecord$Op2.enterAnim;
            final int[] mOps4 = this.mOps;
            final int n6 = n5 + 1;
            mOps4[n5] = backStackRecord$Op2.exitAnim;
            final int[] mOps5 = this.mOps;
            final int n7 = n6 + 1;
            mOps5[n6] = backStackRecord$Op2.popEnterAnim;
            final int[] mOps6 = this.mOps;
            final int n8 = n7 + 1;
            mOps6[n7] = backStackRecord$Op2.popExitAnim;
            if (backStackRecord$Op2.removed != null) {
                final int size = backStackRecord$Op2.removed.size();
                final int[] mOps7 = this.mOps;
                int n9 = n8 + 1;
                mOps7[n8] = size;
                int n10;
                for (int i = 0; i < size; ++i, n9 = n10) {
                    final int[] mOps8 = this.mOps;
                    n10 = n9 + 1;
                    mOps8[n9] = backStackRecord$Op2.removed.get(i).mIndex;
                }
                n2 = n9;
            }
            else {
                final int[] mOps9 = this.mOps;
                n2 = n8 + 1;
                mOps9[n8] = 0;
            }
            backStackRecord$Op2 = backStackRecord$Op2.next;
        }
        this.mTransition = backStackRecord.mTransition;
        this.mTransitionStyle = backStackRecord.mTransitionStyle;
        this.mName = backStackRecord.mName;
        this.mIndex = backStackRecord.mIndex;
        this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
        this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public BackStackRecord instantiate(final FragmentManagerImpl fragmentManagerImpl) {
        final BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i = 0;
        int n7;
        for (int j = 0; j < this.mOps.length; j = n7) {
            final BackStackRecord$Op backStackRecord$Op = new BackStackRecord$Op();
            final int[] mOps = this.mOps;
            final int n = j + 1;
            backStackRecord$Op.cmd = mOps[j];
            if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i + " base fragment #" + this.mOps[n]);
            }
            final int[] mOps2 = this.mOps;
            final int n2 = n + 1;
            final int index = mOps2[n];
            if (index >= 0) {
                backStackRecord$Op.fragment = fragmentManagerImpl.mActive.get(index);
            }
            else {
                backStackRecord$Op.fragment = null;
            }
            final int[] mOps3 = this.mOps;
            final int n3 = n2 + 1;
            backStackRecord$Op.enterAnim = mOps3[n2];
            final int[] mOps4 = this.mOps;
            final int n4 = n3 + 1;
            backStackRecord$Op.exitAnim = mOps4[n3];
            final int[] mOps5 = this.mOps;
            final int n5 = n4 + 1;
            backStackRecord$Op.popEnterAnim = mOps5[n4];
            final int[] mOps6 = this.mOps;
            final int n6 = n5 + 1;
            backStackRecord$Op.popExitAnim = mOps6[n5];
            final int[] mOps7 = this.mOps;
            n7 = n6 + 1;
            final int initialCapacity = mOps7[n6];
            if (initialCapacity > 0) {
                backStackRecord$Op.removed = new ArrayList<Fragment>(initialCapacity);
                int n8;
                for (int k = 0; k < initialCapacity; ++k, n7 = n8) {
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "Instantiate " + backStackRecord + " set remove fragment #" + this.mOps[n7]);
                    }
                    final ArrayList<Fragment> mActive = fragmentManagerImpl.mActive;
                    final int[] mOps8 = this.mOps;
                    n8 = n7 + 1;
                    backStackRecord$Op.removed.add(mActive.get(mOps8[n7]));
                }
            }
            backStackRecord.addOp(backStackRecord$Op);
            ++i;
        }
        backStackRecord.mTransition = this.mTransition;
        backStackRecord.mTransitionStyle = this.mTransitionStyle;
        backStackRecord.mName = this.mName;
        backStackRecord.mIndex = this.mIndex;
        backStackRecord.mAddToBackStack = true;
        backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        backStackRecord.bumpBackStackNesting(1);
        return backStackRecord;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeIntArray(this.mOps);
        parcel.writeInt(this.mTransition);
        parcel.writeInt(this.mTransitionStyle);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
    }
}
