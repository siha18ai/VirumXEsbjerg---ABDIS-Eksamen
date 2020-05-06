package com.gmail.simon.ui.views.login_signupView.login.signup;

import com.gmail.simon.ui.views.login_signupView.login.FrontPageLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

import java.text.DecimalFormat;

/**
 * A Designer generated component for the signup-frame template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@PageTitle("Signup Frame")
@Route(value = "sign-up-frame")
public class SignupFrame extends FrontPageLayout {
    private Button back;
    private Button forward;
    private VerticalLayout progressAndLabel;
    private Label label;
    private ProgressBar progressBar;
    private VerticalLayout content;
    private VerticalLayout buttons;
    public Registration registration1;
    public Registration registration2;

    /**
     * Creates a new SignupFrame.
     */
    public SignupFrame() {
        changeProgressAndLabel(initLabel(), initProgressBar());
        changeContent(createLabel(), createTextField());
        changeFooter(initBack(), initForward());
        removeRegistration();
        changeButtonSettings("sign-up-frame", "page1");
        setProgressBar(0);
    }
    public Button initBack(){
        back = new Button("Back", new Icon(VaadinIcon.ARROW_LEFT));
        return back;
    }
    public Button initForward(){
        forward = new Button("Forward", new Icon(VaadinIcon.ARROW_RIGHT));
        forward.setIconAfterText(true);
        return forward;
    }

    public void changeButtonSettings(String backString, String forwardString){
        registration1 = back.addClickListener(e -> back.getUI().ifPresent(ui -> ui.navigate(backString)));
        registration2 = forward.addClickListener(e -> forward.getUI().ifPresent(ui -> ui.navigate(forwardString)));
    }
    public Label createLabel(){
        Label label = new Label();
        label.setText("Hvor gammel er du?");
        return label;
    }
    public TextField createTextField(){
        TextField textField = new TextField();
        textField.setPlaceholder("Skriv din alder");
        return textField;
    }
    public void setProgressBar(double value){
        progressBar.setValue(value);
        double i = value*100;
        String formateretTal = new DecimalFormat("0.00").format(i);
        label.setText("Your progress: " + formateretTal + "%");
    }
    public Label initLabel(){
        label = new Label("hej");
        return label;
    }
    public ProgressBar initProgressBar(){
        progressBar = new ProgressBar();
        progressBar.setValue(0);
        progressBar.setHeight("65px");
        progressBar.setWidth("1300px");
        progressBar.setClassName("progress-bar");
        return progressBar;
    }
    public double getProcent(int progress){
        double antalSider = 3;
        double procent = progress/antalSider;
        return procent;
    }
    public void removeRegistration(){
        if(registration1 != null && registration2 != null) {
            registration1.remove();
            registration2.remove();
        }
    }
}
