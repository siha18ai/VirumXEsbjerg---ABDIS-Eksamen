package com.gmail.simon.ui.views;

import com.gmail.simon.ui.components.navigation.drawer.NaviItem;
import com.gmail.simon.ui.views.kundeView.UserOplysninger;
import com.gmail.simon.ui.views.mainViews.KundeLayout;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;

@CssImport("./styles/components/view-frame.css")
public class ViewFrameUser extends Composite<Div> implements HasStyle {

    private String CLASS_NAME = "view-frame";

    private Div header;
    private Div content;
    private Div footer;
    private Div appHeaderInner;

    public ViewFrameUser() {

        setClassName(CLASS_NAME);

        header = new Div();
        header.setClassName(CLASS_NAME + "__header");

        content = new Div();
        content.setClassName(CLASS_NAME + "__content");

        footer = new Div();
        footer.setClassName(CLASS_NAME + "__footer");

        NaviItem naviItem = new NaviItem(VaadinIcon.HOME, "Ejendomme", UserOplysninger.class);

        setNaviItems(naviItem);

        getContent().add(header, content, footer);

    }
    public void setNaviItems(NaviItem... naviItems) {
        KundeLayout kundeLayout = new KundeLayout();
        kundeLayout.changeNaviItems(naviItems);

    }
    /**
     * Sets the header slot's components.
     */
    public void setViewHeader(Component... components) {
        header.removeAll();
        header.add(components);
    }

    /**
     * Sets the content slot's components.
     */
    public void setViewContent(Component... components) {
        content.removeAll();
        content.add(components);
    }


    /**
     * Sets the footer slot's components.
     */
    public void setViewFooter(Component... components) {
        footer.removeAll();
        footer.add(components);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        KundeLayout.get().getAppBar().reset();
    }

    private void setAppHeaderInner(Component... components) {
        if (appHeaderInner == null) {
            appHeaderInner = new Div();
            appHeaderInner.addClassName("app-header-inner");
        }
        appHeaderInner.removeAll();
        appHeaderInner.add(components);
    }



}
