package com.gmail.simon.ui.views.login_signupView.login.signup;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("page 3")
@Route(value = "page3")
public class page3 extends SignupFrame{
    public page3() {
        changeContent(createLabel(), createTextField());
        removeRegistration();
        changeButtonSettings("page2", "ejendomme");
        setProgressBar(getProcent(3));
    }
    public Label createLabel(){
        Label label = new Label();
        label.setText("page 3");
        return label;
    }
    public TextField createTextField(){
        TextField textField = new TextField();
        textField.setPlaceholder("Skat");
        return textField;
    }
}
