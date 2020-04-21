package com.gmail.simon.ui.views;

import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.components.navigation.bar.OuterBar;
import com.gmail.simon.ui.components.navigation.drawer.NaviDrawer;
import com.gmail.simon.ui.components.navigation.drawer.NaviItem;
import com.gmail.simon.ui.components.navigation.drawer.NaviMenu;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.util.css.Overflow;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the front-page-again template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("front-page-again")
@JsModule("./front-page-again.js")
@PageTitle("Forside")
@Route(value = "front-page-again")

public class FrontPageAgain extends PolymerTemplate<FrontPageAgain.FrontPageAgainModel> {

    @Id("vaadinVerticalLayout")
    private VerticalLayout vaadinVerticalLayout;
    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;
    @Id("login")
    private Button loingButton;

    /**
     * Creates a new FrontPageAgain.
     */
    public FrontPageAgain() {
        vaadinHorizontalLayout.add(createHeader());
        loingButton.addClickListener(e -> loingButton.getUI().ifPresent(ui -> ui.navigate("login-again")));
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
    public Div routerLink(){
        Div menu = new Div();
        menu.add(new Button(""));
        return menu;
    }
    private Component createcontentHeader(){
        //Html html = new Html("<h1>Hej Esbjerg</h1>");
        NaviMenu naviMenu = new NaviMenu();
        Image image = new Image();
        image.setSrc(UIUtils.IMG_PATH + "logos/Kirk-Larsen-logo.png");
        naviMenu.addNaviItem(image, "", FrontPageAgain.class);
        FlexBoxLayout flexBoxLayout = new FlexBoxLayout(naviMenu);
        flexBoxLayout.setFlexDirection(FlexDirection.COLUMN);
        flexBoxLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        flexBoxLayout.setAlignSelf(FlexComponent.Alignment.CENTER);
        flexBoxLayout.setHeight("100PX");
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

    /**
     * This model binds properties between FrontPageAgain and front-page-again
     */
    public interface FrontPageAgainModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
