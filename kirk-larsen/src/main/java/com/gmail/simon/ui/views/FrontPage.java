package com.gmail.simon.ui.views;

import com.gmail.simon.ui.MainLayout;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.components.navigation.bar.OuterBar;
import com.gmail.simon.ui.components.navigation.drawer.NaviMenu;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Size;
import com.gmail.simon.ui.layout.size.Vertical;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.BoxSizing;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Forside")
@Route(value = "frontpage1")

public class FrontPage extends ViewFrameFrontPage{

    private static final String CLASS_NAME = "frontPage";
    public static final String MAX_WIDTH = "1024px";
    private Div content;
    private OuterBar outerBar;

    public FrontPage() {
        setViewContent(createContent());
        setViewHeader(createHeader());
    }

    private Component createContent() {

        Component payments = createPayments();

        FlexBoxLayout content = new FlexBoxLayout(payments);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setFlexDirection(FlexDirection.COLUMN);

        return content;
    }
    private Component createHeader(){
        Component header = createcontentHeader();
        return header;
    }
    private Component createcontentHeader(){
        //Html html = new Html("<h1>Hej Esbjerg</h1>");
        NaviMenu naviMenu = new NaviMenu();
        Image image = new Image();
        image.setSrc(UIUtils.IMG_PATH + "logos/Kirk-Larsen-logo.png");
        naviMenu.addNaviItem(image, "", FrontPage.class);
        FlexBoxLayout flexBoxLayout = new FlexBoxLayout(naviMenu);
        flexBoxLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        flexBoxLayout.setFlexDirection(FlexDirection.COLUMN);
        flexBoxLayout.setBackgroundColor("#DDDDDD");
        flexBoxLayout.setSizeFull();
        return flexBoxLayout;
    }
    private Component createPayments(){
        Html html = new Html("<h1></h1>");
        Html html1 = new Html("<p>Her skal vi indsætte en masse ting!</p>");
        Button button = new Button("hej");
        FlexBoxLayout flexBoxLayout = new FlexBoxLayout(html, html1, button);
        flexBoxLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        flexBoxLayout.setFlexDirection(FlexDirection.COLUMN);
        return flexBoxLayout;
    }
    private OuterBar initOuterBar() {
        outerBar = new OuterBar();
        outerBar.getKirkLarsen().setVisible(true);
        setViewHeader(outerBar);
        return outerBar;
    }
}

