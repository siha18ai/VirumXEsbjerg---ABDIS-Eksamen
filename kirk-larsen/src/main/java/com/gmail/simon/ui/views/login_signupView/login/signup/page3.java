package com.gmail.simon.ui.views.login_signupView.login.signup;

import com.gmail.simon.ui.layout.size.Horizontal;
import com.vaadin.flow.component.charts.model.DataProviderSeries;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("page 3")
@Route(value = "page3")
public class page3 extends SignupFrame{
    public page3() {
        changeContent(createLabel(), createRadioButton());
        removeRegistration();
        changeButtonSettings("page2", "ejendomme",null,null);
        setProgressBar(getProcent(3));
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
}
