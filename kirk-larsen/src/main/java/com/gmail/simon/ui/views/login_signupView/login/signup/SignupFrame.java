package com.gmail.simon.ui.views.login_signupView.login.signup;

import com.gmail.simon.backend.Kunde;
import com.gmail.simon.ui.views.login_signupView.login.FrontPageLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;

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
    private Label label;
    private ProgressBar progressBar;
    public Registration registration1;
    public Registration registration2;
    private TextField fornavn, efternavn, telefon;
    private EmailField email;
    private Span span;
    private Kunde kunde;

    /**
     * Creates a new SignupFrame.
     */
    public SignupFrame() {
        changeProgressAndLabel(initLabel(), initProgressBar());
        changeContent(createLabel(), createHorizonatal1(), createHorizonatal2());
        changeFooter(initBack(), initForward());
        removeRegistration();
        changeButtonSettings("", "page1", fornavn, efternavn);
        setProgressBar(0);
        initSpan();
    }

    public Button initBack() {
        back = new Button("Tilbage", new Icon(VaadinIcon.ARROW_LEFT));
        return back;
    }

    public Button initForward() {
        forward = new Button("Videre", new Icon(VaadinIcon.ARROW_RIGHT));
        forward.setIconAfterText(true);
        return forward;
    }

    public void changeButtonSettings(String backString, String forwardString, TextField... textFields) {
        registration1 = back.addClickListener(e -> back.getUI().ifPresent(ui -> ui.navigate(backString)));
        registration2 = forward.addClickListener(e -> {
            if (textfields(textFields) && telefon.getValue().length() == 8) {
                forward.getUI().ifPresent(ui -> ui.navigate(forwardString));
            } else {
                getCenter1().add(span);
            }
        });
    }
    public void setValuesForKunde(){
        kunde.setEmail(email.getValue());
        kunde.setFirst_name(fornavn.getValue());
        kunde.setLast_name(efternavn.getValue());
    }
    public boolean textfields(TextField... textFields){
        boolean isempty = true;
        for(TextField textField : textFields){
            if(textField.getValue() == "")
                isempty = false;
        }
        if(email.getValue() == ""){
            isempty = false;
        }
        return isempty;
    }
    public Label createLabel(){
        Label label = new Label();
        label.setText("Personlige oplysninger");
        return label;
    }
    public HorizontalLayout createHorizonatal1(){
        HorizontalLayout h1 = new HorizontalLayout();
        email = new EmailField("E-mail");
        email.setClearButtonVisible(true);
        email.setErrorMessage("Indtast venligst en gyldig e-mail adresse");
        email.getElement().setProperty("required", true);
        telefon = new TextField("Telefon");
        telefon.setPrefixComponent(new Span("+45 "));
        telefon.setClearButtonVisible(true);
        telefon.setErrorMessage("Indast venligst et gyldigt telefonnummer");
        telefon.setRequired(true);
        telefon.setPattern("[0-9.,]*");
        telefon.setPreventInvalidInput(true);
        telefon.setWidth("200PX");
        telefon.setMaxLength(8);
        h1.add(email, telefon);
        return h1;
    }
    public HorizontalLayout createHorizonatal2(){
        HorizontalLayout h1 = new HorizontalLayout();
        fornavn = new TextField("Fornavn");
        fornavn.setClearButtonVisible(true);
        fornavn.setClearButtonVisible(true);
        fornavn.setRequired(true);
        fornavn.setErrorMessage("Udfyld venligst alle påkrævede texbokse");
        efternavn = new TextField("Efternavn");
        efternavn.setClearButtonVisible(true);
        efternavn.setClearButtonVisible(true);
        efternavn.setRequired(true);
        h1.add(fornavn, efternavn);
        return h1;
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
    public void initSpan(){
        span = new Span("Please fill all required textfields or lease enter a valid phone number");
    }
    public void initKunde(){
        kunde = new Kunde();
    }
}
