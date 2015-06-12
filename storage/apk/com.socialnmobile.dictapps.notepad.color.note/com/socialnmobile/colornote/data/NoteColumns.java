// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.data;

public final class NoteColumns
{
    public static acb[] a;
    public static acb[] b;
    
    static {
        NoteColumns.a = new acb[] { new act("_id"), new acv("title"), new acv("note"), new acr("encrypted"), new act("modified_date"), new acr("active_state"), new acr("folder_id"), new acr("status"), new acr("space"), new acr("type"), new acv("note_ext"), new acr("note_type"), new acr("color_index"), new acr("importance"), new act("created_date"), new act("minor_modified_date"), new acr("reminder_type"), new acr("reminder_repeat"), new act("reminder_date"), new act("reminder_base"), new act("reminder_last"), new act("reminder_repeat_ends"), new acr("reminder_duration"), new acr("reminder_option"), new acp("latitude"), new acp("longitude"), new acv("tags"), new act("account_id") };
        NoteColumns.b = new acb[] { new acr("dirty"), new acr("staged"), new acv("uuid"), new acr("revision") };
    }
}
