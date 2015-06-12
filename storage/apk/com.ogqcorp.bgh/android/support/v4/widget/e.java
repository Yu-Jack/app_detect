// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.database.Cursor;

interface e
{
    void changeCursor(Cursor p0);
    
    CharSequence convertToString(Cursor p0);
    
    Cursor getCursor();
    
    Cursor runQueryOnBackgroundThread(CharSequence p0);
}
