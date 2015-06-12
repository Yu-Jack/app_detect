import android.widget.Toast;
import com.socialnmobile.colornote.activity.ReminderSettings;
import android.content.Intent;
import com.socialnmobile.colornote.activity.PasswordSetting;
import android.content.Context;
import com.socialnmobile.colornote.ColorNote;
import android.content.ContentUris;
import android.view.MenuItem;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.view.MenuItem$OnMenuItemClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ok implements MenuItem$OnMenuItemClickListener
{
    final /* synthetic */ NoteListFragment a;
    
    public ok(final NoteListFragment a) {
        this.a = a;
    }
    
    public final boolean onMenuItemClick(final MenuItem menuItem) {
        while (true) {
            boolean b = true;
            Label_0653: {
                Label_0644: {
                    Label_0605: {
                        Label_0450: {
                            Label_0393: {
                                Label_0336: {
                                    Label_0324: {
                                        Label_0312: {
                                            Label_0300: {
                                                Label_0288: {
                                                    Label_0256: {
                                                        Label_0188: {
                                                            Label_0176: {
                                                                Label_0200: {
                                                                    try {
                                                                        menuItem.getMenuInfo();
                                                                        this.a.ac = ContentUris.withAppendedId(this.a.O(), this.a.ab.a);
                                                                        switch (menuItem.getItemId()) {
                                                                            default: {
                                                                                b = false;
                                                                                return b;
                                                                            }
                                                                            case 1: {
                                                                                break;
                                                                            }
                                                                            case 1002: {
                                                                                break Label_0188;
                                                                            }
                                                                            case 1004: {
                                                                                break Label_0200;
                                                                            }
                                                                            case 1005: {
                                                                                break Label_0256;
                                                                            }
                                                                            case 1006: {
                                                                                break Label_0288;
                                                                            }
                                                                            case 1007: {
                                                                                break Label_0300;
                                                                            }
                                                                            case 1008: {
                                                                                break Label_0312;
                                                                            }
                                                                            case 1009: {
                                                                                break Label_0324;
                                                                            }
                                                                            case 1010: {
                                                                                break Label_0336;
                                                                            }
                                                                            case 1011: {
                                                                                break Label_0393;
                                                                            }
                                                                            case 1012: {
                                                                                break Label_0450;
                                                                            }
                                                                            case 1013: {
                                                                                break Label_0605;
                                                                            }
                                                                            case 1014: {
                                                                                break Label_0644;
                                                                            }
                                                                            case 1015: {
                                                                                break Label_0653;
                                                                            }
                                                                        }
                                                                    }
                                                                    catch (ClassCastException ex) {
                                                                        ColorNote.a("bad menuInfo");
                                                                        return false;
                                                                    }
                                                                    break Label_0176;
                                                                }
                                                                kg.a((Context)this.a.h(), this.a.ac, this.a.ab.d, 16, 16);
                                                                if (gu.a(this.a.ab)) {
                                                                    this.a.e(1018);
                                                                    return b;
                                                                }
                                                                return b;
                                                            }
                                                            this.a.e(1004);
                                                            return b;
                                                        }
                                                        this.a.e(1005);
                                                        return b;
                                                    }
                                                    kg.a((Context)this.a.h(), this.a.ac, this.a.ab.d, 0, 16);
                                                    return b;
                                                }
                                                this.a.e(1009);
                                                return b;
                                            }
                                            this.a.e(1010);
                                            return b;
                                        }
                                        this.a.e(1011);
                                        return b;
                                    }
                                    this.a.e(1012);
                                    return b;
                                }
                                if (!jq.a((Context)this.a.h())) {
                                    this.a.a(new Intent((Context)this.a.h(), (Class)PasswordSetting.class), 1001);
                                    return b;
                                }
                                this.a.e(1013);
                                return b;
                            }
                            if (!jq.a((Context)this.a.h())) {
                                this.a.a(new Intent((Context)this.a.h(), (Class)PasswordSetting.class), 1001);
                                return b;
                            }
                            this.a.e(1014);
                            return b;
                        }
                        final Intent intent = new Intent((Context)this.a.h(), (Class)ReminderSettings.class);
                        intent.putExtra("_id", this.a.ab.a);
                        intent.putExtra("folder_id", this.a.ab.b);
                        intent.putExtra("reminder_type", this.a.ab.m);
                        intent.putExtra("reminder_repeat", this.a.ab.n);
                        intent.putExtra("reminder_base", this.a.ab.f());
                        intent.putExtra("reminder_date", this.a.ab.g());
                        intent.putExtra("reminder_repeat_ends", this.a.ab.i());
                        this.a.a(intent);
                        return b;
                    }
                    if (this.a.ab.g() != 0L) {
                        this.a.e(1017);
                        return b;
                    }
                    this.a.e(1016);
                    return b;
                }
                this.a.aa();
                return b;
            }
            if (kg.f((Context)this.a.h(), this.a.ac)) {
                Toast.makeText((Context)this.a.h(), 2131230858, 0).show();
                return b;
            }
            Toast.makeText((Context)this.a.h(), 2131230839, 0).show();
            return b;
        }
    }
}
