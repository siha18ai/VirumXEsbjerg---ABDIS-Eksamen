package com.gmail.simon.ui.views.login_signupView.login.signup;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("page 2")
@Route(value = "page2")
public class page2 extends SignupFrame{
    public page2(){
        changeContent(createLabel(), createHorizontal1(), createText());
        removeRegistration();
        changeButtonSettings("page1", "page3", null, adgangskode, brugernavn);
        setProgressBar(getProcent(2));
    }
    public Label createLabel(){
        Label label = new Label();
        label.setText("Opret");
        return label;
    }
    public HorizontalLayout createHorizontal1(){
        HorizontalLayout h1 = new HorizontalLayout();
        brugernavn = new TextField("Brugernavn");
        brugernavn.setClearButtonVisible(true);
        brugernavn.setRequired(true);
        brugernavn.addValueChangeListener(e ->
                setBrugernavnS(e.getValue()));
        adgangskode = new PasswordField("Adgangskode");
        adgangskode.setClearButtonVisible(true);
        adgangskode.setRequired(true);
        adgangskode.addValueChangeListener(e ->{
                adgangskodeS = e.getValue();
                System.out.println(e.getValue());
    });
        h1.add(brugernavn, adgangskode);
        return h1;
    }
    public Label createText(){
        Label label = new Label("Vi følger GDPR's regler og ønsker blot at beholde din information, så vores" +
                " advokater kan kontakte dig");
        return label;
    }
}
