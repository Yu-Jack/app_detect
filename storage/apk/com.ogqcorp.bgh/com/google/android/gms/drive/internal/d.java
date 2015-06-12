// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.events.ConflictEvent;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class d implements Parcelable$Creator<OnEventResponse>
{
    static void a(final OnEventResponse onEventResponse, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, onEventResponse.a);
        c.a(parcel, 2, onEventResponse.b);
        c.a(parcel, 3, (Parcelable)onEventResponse.c, n, false);
        c.a(parcel, 4, (Parcelable)onEventResponse.d, n, false);
        c.a(parcel, a);
    }
    
    public OnEventResponse a(final Parcel parcel) {
        ConflictEvent conflictEvent = null;
        int n = 0;
        final int b = a.b(parcel);
        ChangeEvent changeEvent = null;
        int n2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            ConflictEvent conflictEvent2 = null;
            ChangeEvent changeEvent2 = null;
            int n3 = 0;
            int n4 = 0;
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    conflictEvent2 = conflictEvent;
                    changeEvent2 = changeEvent;
                    n3 = n;
                    n4 = n2;
                    break;
                }
                case 1: {
                    final int g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    final ConflictEvent conflictEvent3 = conflictEvent;
                    changeEvent2 = changeEvent;
                    n3 = n;
                    n4 = g;
                    conflictEvent2 = conflictEvent3;
                    break;
                }
                case 2: {
                    final int g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    n4 = n2;
                    final ChangeEvent changeEvent3 = changeEvent;
                    n3 = g2;
                    conflictEvent2 = conflictEvent;
                    changeEvent2 = changeEvent3;
                    break;
                }
                case 3: {
                    final ChangeEvent changeEvent4 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, ChangeEvent.CREATOR);
                    n3 = n;
                    n4 = n2;
                    final ConflictEvent conflictEvent4 = conflictEvent;
                    changeEvent2 = changeEvent4;
                    conflictEvent2 = conflictEvent4;
                    break;
                }
                case 4: {
                    conflictEvent2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, ConflictEvent.CREATOR);
                    changeEvent2 = changeEvent;
                    n3 = n;
                    n4 = n2;
                    break;
                }
            }
            n2 = n4;
            n = n3;
            changeEvent = changeEvent2;
            conflictEvent = conflictEvent2;
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new OnEventResponse(n2, n, changeEvent, conflictEvent);
    }
    
    public OnEventResponse[] a(final int n) {
        return new OnEventResponse[n];
    }
}
