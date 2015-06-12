// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.widget.Filter$FilterResults;
import android.database.Cursor;
import android.widget.Filter;

class d extends Filter
{
    e a;
    
    d(final e a) {
        this.a = a;
    }
    
    public CharSequence convertResultToString(final Object o) {
        return this.a.convertToString((Cursor)o);
    }
    
    protected Filter$FilterResults performFiltering(final CharSequence charSequence) {
        final Cursor runQueryOnBackgroundThread = this.a.runQueryOnBackgroundThread(charSequence);
        final Filter$FilterResults filter$FilterResults = new Filter$FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filter$FilterResults.count = runQueryOnBackgroundThread.getCount();
            filter$FilterResults.values = runQueryOnBackgroundThread;
            return filter$FilterResults;
        }
        filter$FilterResults.count = 0;
        filter$FilterResults.values = null;
        return filter$FilterResults;
    }
    
    protected void publishResults(final CharSequence charSequence, final Filter$FilterResults filter$FilterResults) {
        final Cursor cursor = this.a.getCursor();
        if (filter$FilterResults.values != null && filter$FilterResults.values != cursor) {
            this.a.changeCursor((Cursor)filter$FilterResults.values);
        }
    }
}
