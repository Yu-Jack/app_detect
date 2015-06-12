import android.net.Uri;
import com.socialnmobile.colornote.data.NoteColumns$NotesColumns;

// 
// Decompiled by Procyon v0.5.29
// 

public final class kf implements NoteColumns$NotesColumns
{
    public static final Uri a;
    public static final Uri b;
    public static final Uri c;
    public static final Uri d;
    public static final Uri e;
    
    static {
        a = Uri.parse("content://note.socialnmobile.provider.colornote/notes");
        b = Uri.parse("content://note.socialnmobile.provider.colornote/notes/title");
        c = Uri.parse("content://note.socialnmobile.provider.colornote/counts");
        d = Uri.parse("content://note.socialnmobile.provider.colornote/tempnotes");
        e = Uri.parse("content://note.socialnmobile.provider.colornote/tempnotes/title");
    }
}
