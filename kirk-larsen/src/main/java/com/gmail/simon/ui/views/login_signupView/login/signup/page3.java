package com.gmail.simon.ui.views.login_signupView.login.signup;

import com.gmail.simon.backend.Ejendom2;
import com.gmail.simon.backend.Kunde;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.views.kundeView.UserOplysninger;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.DataProviderSeries;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
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
    private Span span3;
    public page3() {
        changeContent(createLabel(), createRadioButton());
        changeFooter(initBack3(), initSubmit());
        setProgressBar(getProcent(3));
        changeButtonSettings4("kunde");
    }
    public Button initBack3() {
        back4 = new Button("Tilbage", new Icon(VaadinIcon.ARROW_LEFT));
        return back4;
    }
    public Button initSubmit(){
        submit = new Button("Submit");
        return submit;
    }
    public Label createLabel(){
        Label label = new Label();
        label.setText("Sagstype");
        return label;
    }
    public void changeButtonSettings4(String submitString) {
        submit.addClickListener(e ->{
            if(data.createEjendom()) {
                ArrayList<Ejendom2> ejendomme = data.getEjendomme();
                ArrayList<Kunde> kunder = data.getKunder();
                for(Kunde kunde : kunder){
                    data.setLoggedin(kunde, false);
                }
                Kunde kunde = kunder.get(kunder.size()-1);
                kunde.setEjendom(ejendomme.get(ejendomme.size()-1).getEjd_nr());
                if (data.updateKunde3(kunde) && data.setLoggedin(kunde, true)) {
                    Notification.show("User updated");
                    submit.getUI().ifPresent(ui -> ui.navigate(submitString));
                //} else
                    Notification.show("Can't create user");
            }}});
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
}
