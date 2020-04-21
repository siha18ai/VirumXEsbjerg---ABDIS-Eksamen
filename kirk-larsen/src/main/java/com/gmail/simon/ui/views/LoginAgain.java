package com.gmail.simon.ui.views;

import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.components.navigation.drawer.NaviMenu;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import javafx.beans.property.ObjectProperty;

/**
 * A Designer generated component for the login-again template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("login-again")
@JsModule("./styles/login-again.js")
@Route(value = "login-again")
public class LoginAgain extends PolymerTemplate<LoginAgain.LoginAgainModel> {

    @Id("Header")
    private HorizontalLayout header;
    @Id("Center")
    private VerticalLayout center;
    @Id("password")
    private PasswordField password;

    private Span span1;
    private Span span;

    /**
     * Creates a new LoginAgain.
     */
    public LoginAgain() {
        header.add(createHeader());
        initTextField();
        initButton();
    }
    public void initButton(){
        span = new Span("Clicked");
        span1 = new Span(getPlaceHolder());
        Button button1 = new Button("Value fra textfield", click -> {
            center.add(span1);
        });
        center.add(button1);

        Button button = new Button("Click me", click -> {
            center.add(span);
        });
        center.add(button);
    }
    public void initTextField(){
        password = new PasswordField();
    }
    public String getPlaceHolder(){
        return password.getValue();
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
        naviMenu.addNaviItem(image, "", FrontPageAgain.class);
        FlexBoxLayout flexBoxLayout = new FlexBoxLayout(naviMenu);
        flexBoxLayout.setFlexDirection(FlexDirection.COLUMN);
        flexBoxLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        flexBoxLayout.setAlignSelf(FlexComponent.Alignment.CENTER);
        flexBoxLayout.setHeight("100PX");
        flexBoxLayout.setSizeFull();
        return flexBoxLayout;
    }

    /**
     * This model binds properties between LoginAgain and login-again
     */
    public interface LoginAgainModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
