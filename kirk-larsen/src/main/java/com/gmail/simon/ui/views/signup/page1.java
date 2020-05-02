package com.gmail.simon.ui.views.signup;


import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
@PageTitle("page 1")
@Route(value = "page1")
public class page1 extends SignupFrame {
    public page1(){
        changeContent(createLabel(), createTextField());
        removeRegistration();
        changeButtonSettings("sign-up-frame", "page2");
        setProgressBar(getProcent(1));
    }
    public Label createLabel(){
        Label label = new Label();
        label.setText("Page 1");
        return label;
    }
    public TextField createTextField(){
        TextField textField = new TextField();
        textField.setPlaceholder("År");
        return textField;
    }
}
