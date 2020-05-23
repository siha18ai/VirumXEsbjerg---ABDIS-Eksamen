package com.gmail.simon.ui.views.login_signupView.login.signup;

import com.gmail.simon.backend.Ejendom2;
import com.gmail.simon.backend.Kunde;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.DataProviderSeries;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;

@PageTitle("page 3")
@Route(value = "page3")
public class page3 extends SignupFrame{
    public page3() {
        changeContent(createLabel(), createRadioButton());
        removeRegistration();
        changeFooter(initBack(), initSubmit());
        setProgressBar(getProcent(3));
        changeButtonSettings2("ejendomme");
    }
    public Label createLabel(){
        Label label = new Label();
        label.setText("Sagstype");
        return label;
    }
    public HorizontalLayout createRadioButton(){
        HorizontalLayout v = new HorizontalLayout();
        RadioButtonGroup<String> r1 = new RadioButtonGroup<>();
        r1.setItems("Boliger", "Lejligheder");
        r1.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        r1.setValue("Option one");
        v.add(r1);
        return v;
    }
    public Button initSubmit(){
        submit = new Button("Submit");
        return submit;
    }
    public void changeButtonSettings2(String submitString) {
        Kunde kunde = new Kunde();
        System.out.println(getAdgangskodeS());
        System.out.println(emailS);
        kunde.setPassword(getAdgangskodeS());
        kunde.setUsername(getBrugernavnS());
        kunde.setTelefon(getTelefonS());
        kunde.setEtage(getEtageS());
        kunde.setVejnavn(getVejnavnS());
        kunde.setFirst_name(getFornavnS());
        kunde.setLast_name(getEfternavnS());
        kunde.setEmail(getEmailS());
        kunde.setHusnummer(getHusnrS());
        registration3 = submit.addClickListener(e ->{
            if(data.createEjendom()) {
                ArrayList<Ejendom2> ejendomme = data.getEjendomme();
                kunde.setEjendom(ejendomme.get(ejendomme.size()-1).getEjd_nr());
                if (data.createKunde(kunde)) {
                    Notification.show("User created");
                    submit.getUI().ifPresent(ui -> ui.navigate(submitString));
                } else
                    Notification.show("Can't create user");
            }});
    }
    public void removeRegistration(){
        if(registration3 != null) {
            registration3.remove();
        }
    }
}
