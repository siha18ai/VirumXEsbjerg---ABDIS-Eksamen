package com.gmail.simon.ui.views.medarbejderView;

import com.gmail.simon.backend.Artikler;
import com.gmail.simon.backend.Kunde;
import com.gmail.simon.backend.Ordre;
import com.gmail.simon.backend.database.Data;
import com.gmail.simon.ui.MainLayout;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Uniform;
import com.gmail.simon.ui.util.LumoStyles;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.views.SplitViewFrame;
import com.gmail.simon.ui.views.mainViews.KundeLayout;
import com.gmail.simon.ui.views.mainViews.MedarbejderLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

import java.util.ArrayList;

@PageTitle("Ny artikel")
@Route(value = "nyartikel", layout = MedarbejderLayout.class)
public class nyArtikel extends SplitViewFrame {
    private TextField tekst, emne;
    private Button create;
    private Data data;
    private Artikler artikel;

    public nyArtikel() {
        this.data = new Data();
        this.artikel = new Artikler();
        setViewContent(createHeader(), createContent());
        changeButtonSettings("artiklerMedarbejder");
    }

    private Component createHeader() {
        Html header = new Html("<h2> Opret en ny ordre </h2>");

        FlexBoxLayout content = new FlexBoxLayout(header);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("600px");
        content.setPadding(Uniform.RESPONSIVE_L);
        return content;
    }
    private Component createButtonLayout() {
        Button button = createButton();

        FlexBoxLayout content = new FlexBoxLayout(button);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("300px");
        content.setPadding(Uniform.RESPONSIVE_M);
        return content;
    }

    private Component createContent() {
        FormLayout formLayout = createDetails();

        FlexBoxLayout content = new FlexBoxLayout(formLayout, createButtonLayout());
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("1000px");

        content.setPadding(Uniform.RESPONSIVE_L);
        return content;
    }

    private FormLayout createDetails() {
        tekst = new TextField();
        tekst.setRequired(true);
        tekst.addValueChangeListener(e -> artikel.setTekst(e.getValue()));

        emne = new TextField();
        emne.setRequired(true);
        emne.addValueChangeListener(e -> artikel.setEmne(e.getValue()));

        FormLayout form = new FormLayout();
        form.addClassNames(LumoStyles.Padding.Bottom.L,
                LumoStyles.Padding.Horizontal.L, LumoStyles.Padding.Top.S);
        form.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("21em", 2,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP));
        form.addFormItem(emne, "Emne");
        form.addFormItem(tekst, "Skriv til artiklen");

        return form;
    }

    private Button createButton() {
        create = new Button("Opret");
        return create;
    }
    public void changeButtonSettings(String createString) {
        create.addClickListener(e -> {
            if (textfields(emne, tekst)) {
                if (data.createArtikel(artikel)) {
                    Notification.show("Ordre oprettet");
                    create.getUI().ifPresent(ui -> ui.navigate(createString));
                } else {
                    Notification.show("Kan ikke oprette ordre");
                }
            }
            else {
                Notification.show("Udfyld venligst alle påkrævede fetler");
            }
        }  );
    }
    public boolean textfields(TextField... textFields){
        boolean isempty = true;
        for(TextField textField : textFields){
            if(textField.getValue() == "")
                isempty = false;
        }
        return isempty;
    }
}
