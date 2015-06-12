// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

class ActionMenuPresenter$PopupPresenterCallback implements MenuPresenter$Callback
{
    final /* synthetic */ ActionMenuPresenter this$0;
    
    private ActionMenuPresenter$PopupPresenterCallback(final ActionMenuPresenter this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        if (menuBuilder instanceof SubMenuBuilder) {
            ((SubMenuBuilder)menuBuilder).getRootMenu().close(false);
        }
    }
    
    @Override
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            return false;
        }
        this.this$0.mOpenSubMenuId = ((SubMenuBuilder)menuBuilder).getItem().getItemId();
        return false;
    }
}
