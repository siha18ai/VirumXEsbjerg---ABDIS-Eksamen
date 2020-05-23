package com.gmail.simon.ui.views.kundeView;

import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Uniform;
import com.gmail.simon.ui.util.LumoStyles;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.views.ViewFrameUser;
import com.gmail.simon.ui.views.mainViews.KundeLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value = "kunde", layout = KundeLayout.class)
@PageTitle("Kunde")
public class UserOplysninger extends ViewFrameUser {

    private Button save;

    public UserOplysninger(){
        setId("startpage");

        setViewContent(createContent(), createDetailContentPerson(), createDetailContentHome());
        //setViewContent(createContent(), createDetails(), createButton());
        changeButtonSettings();
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

    private FormLayout createDetailsPerson() {
        TextField email = new TextField();
        //email.setValue(kunde.getEmail());
        email.setWidthFull();

        FlexLayout telefon = UIUtils.createPhoneLayout();

        TextField navn = new TextField();
        //navn.setValue(kunde.getUsername());
        navn.setWidthFull();

        TextField brugernavn = new TextField();
        //brugernavn.setValue(kunde.getUsername());
        brugernavn.setWidthFull();

        PasswordField adgangskode = new PasswordField();
        //adgangskode.setValue(kunde.getPassword());
        adgangskode.setWidthFull();

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
    private FormLayout createDetailsHome(){

        TextField vejnavn = new TextField();
        //vejnavn.setValue(kunde.getVejnavn());
        vejnavn.setWidthFull();

        IntegerField etage = new IntegerField();
        //etage.setValue(kunde.getEtage());
        etage.setWidthFull();

        IntegerField husnr = new IntegerField();
        //husnr.setValue(kunde.getHusnummer());
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



    public Button saveButton() {
        save = new Button("Gem", new Icon(VaadinIcon.CHECK));
        return save;
    }

    public void changeButtonSettings() {
        save.addClickListener(e -> {
            save.getElement().setAttribute("open", false);
            UIUtils.showNotification("Ændringer gemt");
        });
    }


}