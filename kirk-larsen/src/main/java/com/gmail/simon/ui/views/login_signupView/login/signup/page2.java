package com.gmail.simon.ui.views.login_signupView.login.signup;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("page 2")
@Route(value = "page2")
public class page2 extends SignupFrame{
    public page2(){
        changeContent(createLabel(), createTextField());
        removeRegistration();
        changeButtonSettings("page1", "page3");
        setProgressBar(getProcent(2));
    }
    public Label createLabel(){
        Label label = new Label();
        label.setText("Page 2");
        return label;
    }
    public TextField createTextField(){
        TextField textField = new TextField();
        textField.setPlaceholder("Adresse");
        return textField;
    }
}
