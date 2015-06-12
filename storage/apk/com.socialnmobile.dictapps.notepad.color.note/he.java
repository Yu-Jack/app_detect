import android.content.Intent;
import com.socialnmobile.colornote.activity.PasswordSetting;
import android.content.Context;
import android.view.View;
import com.socialnmobile.colornote.activity.BackupLocal;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class he implements View$OnClickListener
{
    final /* synthetic */ BackupLocal a;
    
    public he(final BackupLocal a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        if (!jq.a((Context)this.a)) {
            this.a.startActivityForResult(new Intent((Context)this.a, (Class)PasswordSetting.class), 1);
            return;
        }
        this.a.showDialog(4);
    }
}
