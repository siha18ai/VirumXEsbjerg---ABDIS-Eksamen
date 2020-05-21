package com.gmail.simon.ui.views.kundeView;

import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.components.navigation.drawer.NaviItem;
import com.gmail.simon.ui.layout.size.Bottom;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Right;
import com.gmail.simon.ui.layout.size.Uniform;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.views.SplitViewFrame;
import com.gmail.simon.ui.views.ViewFrame;
import com.gmail.simon.ui.views.ViewFrameKunde;
import com.gmail.simon.ui.views.mainViews.KundeLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.Label;


@Route(value = "kunde", layout = KundeLayout.class)
@PageTitle("Kunde")
public class KundeOplysninger extends ViewFrameKunde {
    public KundeOplysninger(){
        setId("startpage");
        setViewContent(createContent(), createSplitBox(), createSplitBox1());

    }

    private Component createContent() {
        Html oplysninger = new Html("<h2> Personlige oplysninger </h2>");

        FlexBoxLayout content = new FlexBoxLayout(oplysninger);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("300px");
        content.setPadding(Uniform.RESPONSIVE_L);
        return content;
    }

    private Component createSplitBox() {
        Component box = createBox();
        Component box1 = createBox1();


        FlexBoxLayout content = new FlexBoxLayout(box, box1);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);
        content.setPadding(Uniform.RESPONSIVE_L);
        return content;

    }
    private Component createSplitBox1() {
        Component box2 = createBox2();
        Component box3 = createBox3();

        FlexBoxLayout content = new FlexBoxLayout(box2, box3);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);
        content.setPadding(Uniform.RESPONSIVE_L);
        return content;

    }

    private Component createBox() {
        Label header = createLabelEmail();
        TextField field = createEmailField();


        FlexBoxLayout content = new FlexBoxLayout(header, field);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setFlexDirection(FlexDirection.COLUMN);
        return content;
    }
    private Component createBox1() {
        Label header = createTelefon();
        TextField field = createTelefonField();

        FlexBoxLayout content = new FlexBoxLayout(header, field);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setFlexDirection(FlexDirection.COLUMN);
        return content;
    }
    private Component createBox2() {
        Label header = createNavn();
        TextField field = createNavnField();

        FlexBoxLayout content = new FlexBoxLayout(header, field);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setFlexDirection(FlexDirection.COLUMN);
        return content;
    }
    private Component createBox3() {
        Label header = createVejnavn();
        TextField field = createVejnavnField();

        FlexBoxLayout content = new FlexBoxLayout(header, field);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setFlexDirection(FlexDirection.COLUMN);
        return content;
    }



    //E-mail
    public Label createLabelEmail() {
         Label label = new Label();
         label.setText("E-mail");
         return label;
    }
    public TextField createEmailField(){
        TextField textField = new TextField();
        return textField;
    }

    //Telefon
    public Label createTelefon() {
        Label label = new Label();
        label.setText("Telefon");
        return label;
    }
    public TextField  createTelefonField() {
        TextField textField = new TextField();
        return textField;
    }

    //Navn
    public Label createNavn() {
        Label label = new Label();
        label.setText("Navn");
        return label;
    }
    public TextField createNavnField(){
        TextField textField = new TextField();
        return textField;
    }

    //Vejnavn
    public Label createVejnavn() {
        Label label = new Label();
        label.setText("Vejnavn");
        return label;
    }
    public TextField createVejnavnField() {
        TextField textField = new TextField();
        return textField;
    }

    //Husnummer
    //public Label createHusnummer()

}
