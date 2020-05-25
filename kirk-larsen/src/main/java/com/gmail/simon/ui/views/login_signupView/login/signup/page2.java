package com.gmail.simon.ui.views.login_signupView.login.signup;

import com.gmail.simon.backend.Kunde;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;

@PageTitle("page 2")
@Route(value = "page2")
public class page2 extends SignupFrame{
    private Span span2;
    public page2(){
        changeFooter(initBack2(), initForward2());
        changeContent(createLabel(), createHorizontal1(), createText());
        changeButtonSettings2(page1.class, page3.class, adgangskode, brugernavn);
        setProgressBar(getProcent(2));
        initSpan2();
    }
    public Label createLabel(){
        Label label = new Label();
        label.setText("Opret");
        return label;
    }
    public Button initBack2() {
        back3 = new Button("Tilbage", new Icon(VaadinIcon.ARROW_LEFT));
        return back3;
    }

    public Button initForward2() {
        forward3 = new Button("Videre", new Icon(VaadinIcon.ARROW_RIGHT));
        forward3.setIconAfterText(true);
        return forward3;
    }
    public void changeButtonSettings2(Class<? extends Component> navigationTarget, Class<? extends Component> forwardString, PasswordField passwordField,
                                      TextField... textFields) {
        registration1 = back3.addClickListener(e -> UI.getCurrent().navigate(navigationTarget));
        registration2 = forward3.addClickListener(e -> {
            if (textfields2(passwordField, textFields)) {
                ArrayList<Kunde> kunder = data.getKunder();
                Kunde kunde = kunder.get(kunder.size()-1);
                kunde.setPassword(adgangskode.getValue());
                kunde.setUsername(brugernavn.getValue());
                data.updateKunde2(kunde);
                forward3.getUI().ifPresent(ui -> UI.getCurrent().navigate(forwardString));
            } else {
                getCenter1().add(span2);
            }
        });
    }
    public boolean textfields2(PasswordField passwordField, TextField... textFields) {
        boolean isempty = true;
        if (passwordField.getValue() == "") {
            isempty = false;
        }
        for (TextField textField : textFields) {
            if (textField.getValue() == "")
                isempty = false;
        }
        return isempty;
    }
    public HorizontalLayout createHorizontal1(){
        HorizontalLayout h1 = new HorizontalLayout();
        brugernavn = new TextField("Brugernavn");
        brugernavn.setValue(brugernavnS);
        brugernavn.setClearButtonVisible(true);
        brugernavn.setRequired(true);
        brugernavn.addValueChangeListener(e ->
            brugernavnS = e.getValue());
        adgangskode = new PasswordField("Adgangskode");
        adgangskode.setClearButtonVisible(true);
        adgangskode.setRequired(true);
        adgangskode.addValueChangeListener(e ->
            adgangskodeS = e.getValue());
        h1.add(brugernavn, adgangskode);
        return h1;
    }
    public Label createText(){
        Label label = new Label("Vi følger GDPR's regler og ønsker blot at beholde din information, så vores" +
                " advokater kan kontakte dig");
        return label;
    }
    public void initSpan2(){
        span2 = new Span("Please fill all required textfields or lease enter a valid phone number");
    }
}
