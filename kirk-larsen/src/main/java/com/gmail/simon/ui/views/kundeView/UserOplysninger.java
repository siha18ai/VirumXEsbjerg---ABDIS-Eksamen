package com.gmail.simon.ui.views.kundeView;

import com.gmail.simon.backend.Ejendom2;
import com.gmail.simon.backend.Kunde;
import com.gmail.simon.backend.database.Data;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.layout.size.Bottom;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Left;
import com.gmail.simon.ui.layout.size.Uniform;
import com.gmail.simon.ui.util.LumoStyles;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.BorderRadius;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.util.css.Shadow;
import com.gmail.simon.ui.views.ViewFrameUser;
import com.gmail.simon.ui.views.mainViews.KundeLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;

import java.util.ArrayList;


@Route(value = "kunde", layout = KundeLayout.class)
@PageTitle("Kunde")
public class UserOplysninger extends ViewFrameUser {

    private Button save;
    private TextField brugernavn, navn, telefon, email;
    private PasswordField adgangskode;
    private Ejendom2 currentEjendom;
    private Data data;
    private Kunde currentKunde;


    public UserOplysninger(){
        this.data = new Data();
        setId("startpage");
        initKunde();
        initEjendom();
        setViewContent(createContent(), createAccordionComposition());
        changeButtonSettings();
    }


    private Component createAccordionComposition() {
        Div card = new Div(createDetailContentPerson(), createDetailContentHome(),
                createDetailContentEjendom());
        UIUtils.setBackgroundColor(LumoStyles.Color.BASE_COLOR, card);
        UIUtils.setBorderRadius(BorderRadius.S, card);
        UIUtils.setShadow(Shadow.XS, card);

        FlexBoxLayout accordions = new FlexBoxLayout(card);
        accordions.setFlexDirection(FlexDirection.COLUMN);
        accordions.setPadding(Bottom.XL, Left.RESPONSIVE_L);
        return accordions;
    }
    private Kunde getKunde(){
        ArrayList<Kunde> kunder = Data.getKunder();
        Kunde kunde = new Kunde();
        for(Kunde kunde1 : kunder){
            if(kunde1.isLogedin() == true){
                kunde = kunde1;
            }
        }
        return kunde;
    }
    private void initKunde(){
        this.currentKunde = getKunde();
    }
    private Ejendom2 getEjendom(){
        ArrayList<Ejendom2> ejendomme = data.getEjendomme();
        Ejendom2 ejendom = new Ejendom2();
        for(Ejendom2 ejendom1 : ejendomme){
            if(ejendom1.getEjd_nr() == currentKunde.getEjendom()){
                ejendom = ejendom1;
            }
        }
        return ejendom;
    }
    private void initEjendom(){
        this.currentEjendom = getEjendom();
    }
    private Component createDetailContentPerson(){
        FormLayout content = createDetailsPerson();
        Accordion accordion = new Accordion();

        VerticalLayout informationLayout = new VerticalLayout();
        informationLayout.add(content, createButton());
        accordion.add("Personlig information", informationLayout);
        return accordion;
    }
    private Component createDetailContentHome() {
        FormLayout content = createDetailsHome();
        Accordion accordion = new Accordion();

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(content);
        accordion.add("Adresse information", verticalLayout);
        return accordion;
    }
    private Component createDetailContentEjendom() {
        FormLayout content = createDetailsEjendomme();
        Accordion accordion = new Accordion();

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(content);
        accordion.add("Ejendom detaljer", verticalLayout);
        return accordion;
    }

    private Component createContent() {
        Html oplysninger = new Html("<h2> Dine oplysninger </h2>");

        FlexBoxLayout content = new FlexBoxLayout(oplysninger);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("300px");
        content.setPadding(Uniform.RESPONSIVE_L);
        return content;
    }
    private Component createButton() {
        Button button = saveButton();

        FlexBoxLayout content = new FlexBoxLayout(button);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("300px");
        content.setPadding(Uniform.RESPONSIVE_M);
        return content;
    }

    /*
    Personlige Oplysninger
     */
    private FormLayout createDetailsPerson() {
        email = new TextField();
        email.setValue(currentKunde.getEmail());
        email.setWidthFull();
        email.addValueChangeListener(e -> currentKunde.setEmail(e.getValue()));

        telefon = new TextField();
        telefon.setPrefixComponent(new Span("+45 "));
        telefon.setPattern("[0-9.,]*");
        telefon.setClearButtonVisible(true);
        telefon.setPreventInvalidInput(true);
        telefon.setValue(currentKunde.getTelefon());
        telefon.setWidthFull();
        telefon.addValueChangeListener(e -> currentKunde.setTelefon(e.getValue()));

        navn = new TextField();
        navn.setValue(currentKunde.getFirst_name());
        navn.setWidthFull();
        navn.addValueChangeListener(e -> currentKunde.setFirst_name(e.getValue()));

        brugernavn = new TextField();
        brugernavn.setValue(currentKunde.getUsername());
        brugernavn.setWidthFull();
        brugernavn.addValueChangeListener(e -> currentKunde.setUsername(e.getValue()));

        adgangskode = new PasswordField();
        adgangskode.setValue(currentKunde.getPassword());
        adgangskode.setWidthFull();
        adgangskode.addValueChangeListener(e -> currentKunde.setPassword(e.getValue()));

        FormLayout formLayout = new FormLayout();
        formLayout.addClassNames(LumoStyles.Padding.Bottom.L,
                LumoStyles.Padding.Horizontal.L, LumoStyles.Padding.Top.S);
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("21em", 2,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP));
        formLayout.addFormItem(brugernavn, "Brugernavn");
        formLayout.addFormItem(adgangskode, "Adgangskode");
        FormLayout.FormItem emailItem = formLayout.addFormItem(email, "Email");
        FormLayout.FormItem telefonItem = formLayout.addFormItem(telefon, "Telefon");
        FormLayout.FormItem navnItem = formLayout.addFormItem(navn, "Navn");

        UIUtils.setColSpan(2, emailItem, telefonItem, navnItem);
        return formLayout;
    }
    /*
    Adresse oplysninger
     */
    private FormLayout createDetailsHome(){

        TextField vejnavn = new TextField();
        vejnavn.setValue(currentKunde.getVejnavn());
        vejnavn.setWidthFull();

        TextField etage = new TextField();
        etage.setValue(currentKunde.getEtage());
        etage.setWidthFull();

        IntegerField husnr = new IntegerField();
        husnr.setValue(currentKunde.getHusnummer());
        husnr.setWidthFull();

        FormLayout formLayout = new FormLayout();
        formLayout.addClassNames(LumoStyles.Padding.Bottom.L,
                LumoStyles.Padding.Horizontal.L, LumoStyles.Padding.Top.S);
        FormLayout.FormItem vejnavnItem = formLayout.addFormItem(vejnavn, "Vejnavn");
        FormLayout.FormItem etageItem = formLayout.addFormItem(etage, "Etage");
        FormLayout.FormItem husnrItem = formLayout.addFormItem(husnr, "Husnummer");
        UIUtils.setColSpan(2, vejnavnItem, husnrItem, etageItem);
        return formLayout;

    }

    private FormLayout createDetailsEjendomme() {

        IntegerField id_nr = new IntegerField();
        id_nr.setValue(currentEjendom.getEjd_nr());
        id_nr.setWidthFull();

        NumberField grundvaerdi = new NumberField();
        grundvaerdi.setValue(currentEjendom.getGrundvaerdi());
        grundvaerdi.setWidthFull();

        IntegerField maksimalBebyggelse = new IntegerField();
        maksimalBebyggelse.setValue(currentEjendom.getMaksimalBebyggelse());
        maksimalBebyggelse.setWidthFull();

        IntegerField etageArealPris = new IntegerField();
        etageArealPris.setValue(currentEjendom.getEtageArealPris());
        etageArealPris.setWidthFull();

        IntegerField samletAreal = new IntegerField();
        samletAreal.setValue(currentEjendom.getSamletAreal());
        samletAreal.setWidthFull();

        IntegerField faktiskGrundAreal = new IntegerField();
        faktiskGrundAreal.setValue(currentEjendom.getFaktiskGrundAreal());
        faktiskGrundAreal.setWidthFull();

        IntegerField grundskyldPromille = new IntegerField();
        grundskyldPromille.setValue(currentEjendom.getGrundskyldPromille());
        grundskyldPromille.setWidthFull();

        FormLayout formLayout = new FormLayout();
        formLayout.addClassNames(LumoStyles.Padding.Bottom.L,
                LumoStyles.Padding.Horizontal.L, LumoStyles.Padding
        .Top.S);
        formLayout.addFormItem(id_nr, "Id");
        formLayout.addFormItem(grundvaerdi, "Grundværdi");
        formLayout.addFormItem(maksimalBebyggelse, "Maksimal bebyggelse");
        formLayout.addFormItem(etageArealPris, "Etageareal pris");
        formLayout.addFormItem(samletAreal, "Samlet areal");
        formLayout.addFormItem(faktiskGrundAreal, "Faktisk grundareal");
        formLayout.addFormItem(grundskyldPromille, "Grundskyld promille");
        return formLayout;
    }


    public Button saveButton() {
        save = new Button("Gem", new Icon(VaadinIcon.CHECK));
        return save;
    }

    public void changeButtonSettings() {
        save.addClickListener(e -> {
            if(data.updateKundeInformation(currentKunde)){
                initKunde();
                setViewContent(createContent(), createAccordionComposition());
                Notification.show("User updated");
            }
        });
    }


}