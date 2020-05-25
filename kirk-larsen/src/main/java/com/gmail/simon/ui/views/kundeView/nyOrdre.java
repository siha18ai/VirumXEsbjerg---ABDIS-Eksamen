package com.gmail.simon.ui.views.kundeView;

import com.gmail.simon.backend.Kunde;
import com.gmail.simon.backend.Ordre;
import com.gmail.simon.backend.database.Data;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Uniform;
import com.gmail.simon.ui.util.LumoStyles;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.views.ViewFrameUser;
import com.gmail.simon.ui.views.mainViews.KundeLayout;
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

import java.lang.reflect.Array;
import java.util.ArrayList;


@PageTitle("Ny ordre")
@Route(value = "nyordre", layout = KundeLayout.class)
public class nyOrdre extends ViewFrameUser {


    private TextField brugernavn, emne, beskrivelse, telefon;
    private Button create;
    private String brugernavnS, emneS, beskrivelseS, telefonS;
    private Data data;
    private Registration registration;
    private Kunde currentKunde;
    private Ordre ordre;

    public nyOrdre() {
        this.data = new Data();
        this.ordre = new Ordre();
        initKunde();
        setViewContent(createHeader(), createContent());
        changeButtonSettings("Ordre");
    }
    private Kunde getKunde(){
        ArrayList<Kunde> kunder = data.getKunder();
        Kunde kunde = new Kunde();
        for(Kunde kunde1 : kunder){
            if (kunde1.isLogedin() == true){
                kunde = kunde1;
            }
        }
        return kunde;
    }
    private void initKunde(){
        this.currentKunde = getKunde();
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
        brugernavn = new TextField();
        brugernavn.setValue(currentKunde.getUsername());
        brugernavn.setReadOnly(true);

        emne = new TextField();
        emne.setPlaceholder("Fx. Ejendomsbeskatning");
        emne.setRequired(true);
        emne.addValueChangeListener(event -> ordre.setEmne(event.getValue()));

        beskrivelse = new TextField();
        beskrivelse.setPlaceholder("Fx. Jeg ønsker hjælp til min grundskyld");
        beskrivelse.setWidthFull();
        beskrivelse.setRequired(true);
        beskrivelse.setHeightFull();
        beskrivelse.addValueChangeListener(event -> ordre.setBeskrivelse(event.getValue()));


        telefon = new TextField();
        telefon.setPrefixComponent(new Span("+45 "));
        telefon.setValue(currentKunde.getTelefon());
        telefon.setReadOnly(true);

        FormLayout form = new FormLayout();
        form.addClassNames(LumoStyles.Padding.Bottom.L,
                LumoStyles.Padding.Horizontal.L, LumoStyles.Padding.Top.S);
        form.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("21em", 2,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP));
        form.addFormItem(brugernavn, "Dit brugernavn");
        form.addFormItem(telefon, "Telefon");
        form.addFormItem(emne, "Emne");
        form.addFormItem(beskrivelse, "Beskrivelse");

        return form;
    }

    private Button createButton() {
        create = new Button("Opret");
        return create;
    }
    public void changeButtonSettings(String createString) {
        ordre.setBeskrivelse(beskrivelse.getValue());
        ordre.setTelefon(currentKunde.getTelefon());
        ordre.setKunde(currentKunde.getId());
        create.addClickListener(e -> {
            if (textfields(emne, beskrivelse)) {
                if (data.createOrdre(ordre)) {
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

    public String getBrugernavnS() {
        return brugernavnS;
    }

    public void setBrugernavnS(String brugernavnS) {
        this.brugernavnS = brugernavnS;
    }

    public String getEmneS() {
        return emneS;
    }

    public void setEmneS(String emneS) {
        this.emneS = emneS;
    }

    public String getBeskrivelseS() {
        return beskrivelseS;
    }

    public void setBeskrivelseS(String beskrivelseS) {
        this.beskrivelseS = beskrivelseS;
    }

    public String getTelefonS() {
        return telefonS;
    }

    public void setTelefonS(String telefonS) {
        this.telefonS = telefonS;
    }
}
