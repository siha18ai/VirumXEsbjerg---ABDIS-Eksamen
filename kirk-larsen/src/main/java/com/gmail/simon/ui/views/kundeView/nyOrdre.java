package com.gmail.simon.ui.views.kundeView;

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
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;


@PageTitle("Ny ordre")
@Route(value = "nyordre", layout = KundeLayout.class)
public class nyOrdre extends ViewFrameUser {


    private TextField brugernavn, emne, beskrivelse, telefon;
    private Button create;
    private String brugernavnS, emneS, beskrivelseS, telefonS;
    private Data data;
    private Registration registration;

    public nyOrdre() {
        setViewContent(createHeader(), createContent());
        removeRegistration();
        changeButtonSettings("Ordre");
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
        brugernavn.setPlaceholder("Sir");
        brugernavn.setPreventInvalidInput(true);
        brugernavn.setClearButtonVisible(true);
        brugernavn.addValueChangeListener(event -> setBrugernavnS(
                event.getValue()));

        emne = new TextField();
        emne.setPlaceholder("Fx. Ejendomsbeskatning");
        emne.addValueChangeListener(event -> setEmneS(event.getValue()));

        beskrivelse= new TextField();
        beskrivelse.setPlaceholder("Fx. Jeg ønsker hjælp til min grundskyld");
        beskrivelse.setWidthFull();
        beskrivelse.setHeightFull();
        beskrivelse.addValueChangeListener(event -> setBeskrivelseS(event.getValue()));

        telefon = new TextField();
        telefon.setPlaceholder("Skriv dit Telefonnummer her");
        telefon.setPattern("[0-9.,]*");
        telefon.setClearButtonVisible(true);
        telefon.setPreventInvalidInput(true);
        telefon.addValueChangeListener(event -> setTelefonS(event.getValue()));


        FormLayout form = new FormLayout();
        form.addClassNames(LumoStyles.Padding.Bottom.L,
                LumoStyles.Padding.Horizontal.L, LumoStyles.Padding.Top.S);
        form.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("21em", 2,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP));
        form.addFormItem(brugernavn, "Dit brugernavn");
        form.addFormItem(emne, "Emne");
        form.addFormItem(beskrivelse, "Beskrivelse");
        form.addFormItem(telefon, "Telefon");

        return form;
    }

    private Button createButton() {
        create = new Button("Opret");
        return create;
    }
    public void changeButtonSettings(String createString) {
        Ordre ordre = new Ordre();
        ordre.setNavn(getBrugernavnS());
        ordre.setEmne(getEmneS());
        ordre.setBeskrivelse(getBeskrivelseS());
        ordre.setTelefon(getTelefonS());

        registration = create.addClickListener(e -> {
            if (data.createOrdre(ordre)) {
                Notification.show("Ordre oprettet");
                create.getUI().ifPresent(ui -> ui.navigate(createString));
            } else {
                Notification.show("Kan ikke oprette ordre");
            }
        });
    }
    public void removeRegistration(){
        if(registration != null) {
            registration.remove();
        }
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
