package com.gmail.simon.ui.views.login_signupView.login;

import com.gmail.simon.backend.Brugere;
import com.gmail.simon.backend.Konsulenter2;
import com.gmail.simon.backend.Kunde;
import com.gmail.simon.backend.database.Data;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * A Designer generated component for the login-again template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@PageTitle("Login")
@Route(value = "login")
public class Login extends FrontPageLayout {

    private ArrayList<Brugere> brugere;
    private ArrayList<Konsulenter2> konsulenters;
    private ArrayList<Kunde> kunder;
    private Span span;
    private LoginForm loginForm;
    private Button back;
    private Data data;
    /**
     * Creates a new LoginAgain.
     */
    public Login() throws SQLException {
        this.data = new Data();
        initLogin();
        initLogin2();
        changeContent(initButton(), backButton());
    }
    public LoginForm initButton(){
        loginForm = new LoginForm();
        span = new Span("Clicked");
        loginForm.addForgotPasswordListener(e->{
            Notification.show("We don't have a solution yet :(");
                });
        loginForm.setForgotPasswordButtonVisible(true);
        loginForm.addLoginListener(e -> {
            boolean isAuthenticated = false;
            boolean brugerAuthenticate = false;

            Kunde kunde = new Kunde();

            ArrayList<Kunde> kunder = data.getKunder();
            for(Kunde kunde1 : kunder){
                data.setLoggedin(kunde1, false);
            }
            kunde = getKunde(e, kunder);

            isAuthenticated = authenticate(e);
            brugerAuthenticate = authenticate2(e);

            if(isAuthenticated){
                Notification.show("Successfully logged in");
              loginForm.getUI().ifPresent(ui -> ui.navigate("ejendomme"));

           }
            else if(brugerAuthenticate && data.setLoggedin(kunde, true)){
                Notification.show("User logged in");
                loginForm.getUI().ifPresent(ui -> ui.navigate("kunde"));
            }
            else{
                loginForm.setError(true);
            }
        });
        return loginForm;
    }
    public Button backButton(){
        back = new Button("Back");
        back.addClickListener(e -> back.getUI().ifPresent(ui -> ui.navigate("front-page-again")));
        return back;
    }
    public void initLogin2(){
        konsulenters = data.getmedarbejdere();
    }
    public void initLogin(){
        kunder = data.getKunder();
    }

    public boolean authenticate(AbstractLogin.LoginEvent loginEvent){
        boolean loginEventboolean = false;
        if(konsulenters.size() == 0){
            Notification.show("Ingen konsulenter");
        }
        for(Konsulenter2 konsulenter : konsulenters){
            if(konsulenter.getUsername().equals(loginEvent.getUsername()) &&
            konsulenter.getPassword().equals(loginEvent.getPassword())) {
                loginEventboolean = true;
            }
        }
        return loginEventboolean;
    }
    public Kunde getKunde(AbstractLogin.LoginEvent loginEvent, ArrayList<Kunde> kunder){
        Kunde kunde = new Kunde();
        for(Kunde kunde1 : kunder){
            if(kunde1.getUsername().toLowerCase().equals(loginEvent.getUsername().toLowerCase())){
                kunde = kunde1;
            }
        }
        return kunde;
    }
    public boolean authenticate2(AbstractLogin.LoginEvent loginEvent){
        boolean brugerLogin = false;
        if(kunder.size() == 0){
            Notification.show("Ingen kunder");
        }
        for(Kunde kunde : kunder){
            if(kunde.getUsername().equals(loginEvent.getUsername()) &&
            kunde.getPassword().equals(loginEvent.getPassword())){
                brugerLogin = true;
            }
        }
        return brugerLogin;
    }

}
