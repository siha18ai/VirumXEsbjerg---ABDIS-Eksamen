package com.gmail.simon.ui.views.kundeView;

import com.gmail.simon.ui.components.navigation.drawer.NaviItem;
import com.gmail.simon.ui.views.ViewFrame;
import com.gmail.simon.ui.views.mainViews.MainLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

@Route(value = "kunde-ejendom")
public class KundeEjendom extends ViewFrame {
    public KundeEjendom (){
        NaviItem naviItem1 = new NaviItem(VaadinIcon.ARROW_LEFT, "ejendom", KundeEjendom.class);
        setNaviItems(naviItem1);
    }
}
