package com.gmail.simon.ui.views.login;

import com.gmail.simon.backend.Brugere;
import com.gmail.simon.backend.DummyData;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.components.navigation.drawer.NaviMenu;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

import java.util.ArrayList;

/**
 * A Designer generated component for the login-again template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@PageTitle("Login")
@Route(value = "login-again")
public class LoginAgain extends FrontPageAgain{

    private ArrayList<Brugere> brugere;
    private Span span;
    private LoginForm loginForm;
    private Button back;
    /**
     * Creates a new LoginAgain.
     */
    public LoginAgain() {
        initLogin();
        changeContent(initButton(), backButton());
    }
    public LoginForm initButton(){
        loginForm = new LoginForm();
        span = new Span("Clicked");
        loginForm.addLoginListener(e -> {
           boolean isAuthenticated = authenticate(e);
           if(isAuthenticated){
               Notification.show("Successfully logged in");
              loginForm.getUI().ifPresent(ui -> ui.navigate("Home"));

           } else
               loginForm.setError(true);
        });
        return loginForm;
    }
    public Button backButton(){
        back = new Button("Back");
        back.addClickListener(e -> back.getUI().ifPresent(ui -> ui.navigate("front-page-again")));
        return back;
    }
    public void initLogin(){
        brugere = DummyData.getBrugere();
    }

    public boolean authenticate(AbstractLogin.LoginEvent loginEvent){
        boolean loginEventboolean = false;
        for(Brugere brugere : brugere){
            if(brugere.getFirstName().equals(loginEvent.getUsername()) &&
            brugere.getPassword().equals(loginEvent.getPassword())) {
                loginEventboolean = true;
            }
        }
        return loginEventboolean;
    }

}
