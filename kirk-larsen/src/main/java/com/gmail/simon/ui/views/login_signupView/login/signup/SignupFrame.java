package com.gmail.simon.ui.views.login_signupView.login.signup;

import com.gmail.simon.backend.Kunde;
import com.gmail.simon.backend.database.Data;
import com.gmail.simon.ui.views.frontPageView.Home;
import com.gmail.simon.ui.views.login_signupView.login.FrontPageLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.*;
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
    public Button back1, forward1,back2, forward2,back3, forward3,back4, submit;
    private Label label;
    public TextField fornavn, efternavn, telefon, vejnavn, etage, brugernavn;
    public PasswordField adgangskode;
    public String fornavnS, efternavnS, telefonS, vejnavnS, etageS, brugernavnS, adgangskodeS, emailS;
    public String password;
    public int husnrS;
    private ProgressBar progressBar;
    public Registration registration1;
    public Registration registration2;
    private EmailField email;
    public IntegerField husnr;
    private Span span;
    public Data data;
    /**
     * Creates a new SignupFrame.
     */
    public SignupFrame() {
        data = new Data();
        changeProgressAndLabel(initLabel(), initProgressBar());
        changeContent(createLabel(), createHorizonatal1(), createHorizonatal2());
        changeFooter(initBack(), initForward());
        changeButtonSettings(Home.class, page1.class, email, fornavn, efternavn, telefon);
        setProgressBar(0);
        initTextfields();
        initSpan();
    }
    public void initTextfields(){
        brugernavn = new TextField("Brugernavn");
        brugernavnS = "";
        brugernavn.setValue(brugernavnS);
        brugernavn.setClearButtonVisible(true);
        brugernavn.setRequired(true);
        brugernavn.addValueChangeListener(e -> {
            setBrugernavnS(e.getValue());
            brugernavn.setValue(e.getValue());
        });
        adgangskode = new PasswordField("Adgangskode");
        adgangskode.setClearButtonVisible(true);
        adgangskode.setRequired(true);
        adgangskode.addValueChangeListener(e ->
                setPassword(e.getValue()));
    }
    public String password(){
        if(brugernavnS == null){
            brugernavnS = "";
            return brugernavnS;
        }
        else
            return password;
    }

    public Button initBack() {
        back1 = new Button("Tilbage", new Icon(VaadinIcon.ARROW_LEFT));
        return back1;
    }

    public Button initForward() {
        forward1 = new Button("Videre", new Icon(VaadinIcon.ARROW_RIGHT));
        forward1.setIconAfterText(true);
        return forward1;
    }

    public void changeButtonSettings(Class<? extends Component> navigationTarget, Class<? extends Component> forwardString, EmailField email,
                                     TextField... textFields) {
        back1.addClickListener(e -> UI.getCurrent().navigate(navigationTarget));
        forward1.addClickListener(e -> {
            if (textfields(email, textFields)) {
                Kunde kunde = new Kunde();
                kunde.setEmail(email.getValue());
                kunde.setFirst_name(fornavn.getValue());
                kunde.setLast_name(efternavn.getValue());
                kunde.setTelefon(telefon.getValue());
                kunde.setEjendom(1);
                if(data.createKunde(kunde)){
                    Notification.show("user created");
                }
                forward1.getUI().ifPresent(ui -> UI.getCurrent().navigate(forwardString));
            } else {
                getCenter1().add(span);
            }
        });
    }

    public boolean textfields(EmailField email, TextField... textFields){
        boolean isempty = true;
        if(email != null){
            if(email.getValue() == ""){
                isempty = false;
            }
        }
        for(TextField textField : textFields){
            if(textField == telefon){
                if(textField.getValue().length() == 8){
                }
                else
                    isempty = false;
            }
            if(textField.getValue() == "")
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
        email.addValueChangeListener(evenet ->
                setEmailS(evenet.getValue()));
        telefon = new TextField("Telefon");
        telefon.setPrefixComponent(new Span("+45 "));
        telefon.setClearButtonVisible(true);
        telefon.setErrorMessage("Indast venligst et gyldigt telefonnummer");
        telefon.setRequired(true);
        telefon.setPattern("[0-9.,]*");
        telefon.setPreventInvalidInput(true);
        telefon.setWidth("200PX");
        telefon.setMaxLength(8);
        telefon.addValueChangeListener(event ->
                setTelefonS(event.getValue()));
        h1.add(email, telefon);
        return h1;
    }
    public HorizontalLayout createHorizonatal2(){
        HorizontalLayout h1 = new HorizontalLayout();
        fornavn = new TextField("Fornavn");
        fornavn.setClearButtonVisible(true);
        fornavn.setRequired(true);
        fornavn.setErrorMessage("Udfyld venligst alle påkrævede texbokse");
        fornavn.addValueChangeListener(evenet ->
                setFornavnS(evenet.getValue()));
        efternavn = new TextField("Efternavn");
        efternavn.setClearButtonVisible(true);
        efternavn.setClearButtonVisible(true);
        efternavn.setRequired(true);
        efternavn.addValueChangeListener(event ->
                setEfternavnS(event.getValue()));
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
    public void initSpan(){
        span = new Span("Please fill all required textfields or lease enter a valid phone number");
    }
    public String getFornavnS() {
        return fornavnS;
    }

    public void setFornavnS(String fornavnS) {
        this.fornavnS = fornavnS;
    }

    public String getEfternavnS() {
        return efternavnS;
    }

    public void setEfternavnS(String efternavnS) {
        this.efternavnS = efternavnS;
    }

    public String getTelefonS() {
        return telefonS;
    }

    public void setTelefonS(String telefonS) {
        this.telefonS = telefonS;
    }

    public String getVejnavnS() {
        return vejnavnS;
    }

    public void setVejnavnS(String vejnavnS) {
        this.vejnavnS = vejnavnS;
    }

    public String getEtageS() {
        return etageS;
    }

    public void setEtageS(String etageS) {
        this.etageS = etageS;
    }

    public String getBrugernavnS() {
        return brugernavnS;
    }

    public void setBrugernavnS(String brugernavnS) {
        this.brugernavnS = brugernavnS;
    }

    public String getAdgangskodeS() {
        return adgangskodeS;
    }

    public void setAdgangskodeS(String adgangskodeS) {
        this.adgangskodeS = adgangskodeS;
    }

    public String getEmailS() {
        return emailS;
    }

    public void setEmailS(String emailS) {
        this.emailS = emailS;
    }

    public int getHusnrS() {
        return husnrS;
    }

    public void setHusnrS(int husnrS) {
        this.husnrS = husnrS;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
