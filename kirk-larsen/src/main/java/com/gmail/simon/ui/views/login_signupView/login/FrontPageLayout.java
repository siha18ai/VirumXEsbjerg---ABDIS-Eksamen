package com.gmail.simon.ui.views.login_signupView.login;

import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.components.navigation.drawer.NaviMenu;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
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
@Route("forside")
public class FrontPageLayout extends PolymerTemplate<FrontPageLayout.FrontPageAgainModel> {

    @Id("Header")
    private HorizontalLayout header;
    @Id("ProgressAndLabel")
    private HorizontalLayout progressAndLabel;
    @Id("Center1")
    private VerticalLayout center1;
    @Id("footer")
    private HorizontalLayout footer;

    /**
     * Creates a new FrontPageAgain.
     */
    public FrontPageLayout() {
        header.add(createHeader());
        changeFooter(createLoginButton(), createSignupButton());
    }
    public void changeProgressAndLabel(Component... components){
        progressAndLabel.removeAll();
        progressAndLabel.add(components);
    }
    private Component createHeader(){
        Component header = createcontentHeader();
        return header;
    }
    public void changeContent(Component... components){
        center1.removeAll();
        center1.add(components);
    }
    public void changeFooter(Component... components){
        footer.removeAll();
        footer.add(components);
    }
    public Button createLoginButton(){
        Button login = new Button("Login");
        login.addClickListener(e -> login.getUI().ifPresent(ui -> ui.navigate("login-again")));
        return login;
    }
    public Button createSignupButton(){
        Button signUp = new Button("Sign up");
        signUp.addClickListener(e -> signUp.getUI().ifPresent(ui -> ui.navigate("sign-up-frame")));
        return signUp;
    }
    private Component createcontentHeader(){
        NaviMenu naviMenu = new NaviMenu();
        Image image = new Image();
        image.setSrc(UIUtils.IMG_PATH + "logos/Kirk-Larsen-logo.png");
        naviMenu.addNaviItem(image, "", FrontPageLayout.class);
        FlexBoxLayout flexBoxLayout = new FlexBoxLayout(naviMenu);
        flexBoxLayout.setFlexDirection(FlexDirection.COLUMN);
        flexBoxLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        flexBoxLayout.setAlignSelf(FlexComponent.Alignment.CENTER);
        flexBoxLayout.setHeight("100PX");
        flexBoxLayout.setSizeFull();
        flexBoxLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        return flexBoxLayout;
    }

    public interface FrontPageAgainModel extends TemplateModel {
    }
    public VerticalLayout getCenter1() {
        return center1;
    }

    public void setCenter1(VerticalLayout center1) {
        this.center1 = center1;
    }
}
