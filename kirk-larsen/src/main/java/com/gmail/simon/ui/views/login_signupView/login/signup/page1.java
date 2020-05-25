package com.gmail.simon.ui.views.login_signupView.login.signup;


import com.gmail.simon.backend.Kunde;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import java.util.*;

@PageTitle("page 1")
@Route(value = "page1")
public class page1 extends SignupFrame {
    private Span span1;
    public page1(){
        changeContent(createLabel(), createHorizontal1(), createHorizontal2(), createHorizontal3());
        changeFooter(initBack1(), initForward1());
        changeButtonSettings1(SignupFrame.class, page2.class, husnr, vejnavn, etage);
        setProgressBar(getProcent(1));
        initSpan1();
    }
    public Label createLabel(){
        Label label = new Label();
        label.setText("Adresse: ");
        return label;
    }
    public Button initBack1() {
        back2 = new Button("Tilbage", new Icon(VaadinIcon.ARROW_LEFT));
        return back2;
    }

    public Button initForward1() {
        forward2 = new Button("Videre", new Icon(VaadinIcon.ARROW_RIGHT));
        forward2.setIconAfterText(true);
        return forward2;
    }
    public void changeButtonSettings1(Class<? extends Component> navigationTarget, Class<? extends Component> forwardString, IntegerField integerField,
                                     TextField... textFields) {
        back2.addClickListener(e -> UI.getCurrent().navigate(navigationTarget));
        forward2.addClickListener(e -> {
            if (textfields1(integerField, textFields)) {
                ArrayList<Kunde> kunder = data.getKunder();
                Kunde kunde = kunder.get(kunder.size()-1);
                kunde.setVejnavn(vejnavn.getValue());
                kunde.setEtage(etage.getValue());
                kunde.setHusnummer(husnr.getValue());
                data.updateKunde(kunde);
                forward2.getUI().ifPresent(ui -> UI.getCurrent().navigate(forwardString));
            } else {
                getCenter1().add(span1);
            }
        });
    }
    public boolean textfields1(IntegerField integerField, TextField... textFields) {
        boolean isempty = true;
        if (integerField.getValue() == 0) {
            isempty = false;
        }
        for (TextField textField : textFields) {
            if (textField.getValue() == "")
                isempty = false;
        }
        return isempty;
    }
    public HorizontalLayout createHorizontal1(){
        HorizontalLayout h1 = new HorizontalLayout();
        vejnavn = new TextField("Vejnavn");
        vejnavn.setClearButtonVisible(true);
        vejnavn.setRequired(true);
        vejnavn.addValueChangeListener(e ->
                setVejnavnS(e.getValue()));
        etage = new TextField("Etage");
        etage.setClearButtonVisible(true);
        etage.setPattern("[0-9.,]*");
        etage.setPreventInvalidInput(true);
        etage.addValueChangeListener(e ->
                setEtageS(e.getValue()));
        h1.add(vejnavn, etage);
        return h1;
    }
    public HorizontalLayout createHorizontal2(){
        HorizontalLayout h1 = new HorizontalLayout();
        husnr = new IntegerField("Hus nr.");
        husnr.setHasControls(true);
        husnr.addValueChangeListener(e ->
                setHusnrS(e.getValue()));
        ComboBox<String> kommune = new ComboBox("Kommune");
        List<String> kommuner = Arrays.asList("Brønderslev", "Frederikshavn", "Hjørring","Jammerbugt","Læsø","Mariagerfjord","Morsø",
                "Rebild","Thisted","Vesthimmerlands", "Aalborg", "Favrskov","Hedensted","Herning","Holstebro","Horsens",
                "Ikast-Brande", "Lemvig","Norddjurs","Odder","Randers","Ringkøbing-Skjern","Samsø","Silkeborg","Skanderborg",
                "Skive","Struer","Syddjurs","Viborg","Århus","Faxe","Greve","Guldborgsund","Holbæk","Kalundborg","Køge",
                "Lejre","Lolland","Næstved","Odsherred","Ringsted","Roskilde","Slagelse","Solrød","Sorø", "Stevns",
                "Vordingborg","Albertslund","Allerød","Ballerup","Bornholms","Brøndby","Dragør","Egedal","Fredensborg",
                "Frederiksberg","Frederikssund","Furesø","Gentofte","Gladsaxe","Glostrup","Gribskov","Halsnæs",
                "Helsingør","Herlev","Hillerød","Hvidovre","Høje-Taastrup","Hørsholm","Ishøj","København",
                "Lyngby-Taarbæk", "Rudersdal","Rødovre","Tårnby","Vallensbæk");
        kommune.setItems(sortKommuner(kommuner));
        h1.add(husnr, kommune);
        return h1;
    }
    public HorizontalLayout createHorizontal3(){
        HorizontalLayout h1 = new HorizontalLayout();
        TextField dørnr = new TextField("Dør nr.");
        h1.add(dørnr);
        return h1;
    }
    public List<String> sortKommuner(List<String> kommuner){
        Collections.sort(kommuner, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.toLowerCase().equals(s1) && s2.toUpperCase().equals(s2)) {
                    return 1;
                }

                if (s1.toUpperCase().equals(s1) && s2.toLowerCase().equals(s2)) {
                    return -1;
                }

                return s1.compareTo(s2);
            }
        });
        return kommuner;
    }
    public void initSpan1(){
        span1 = new Span("Please fill all required textfields or lease enter a valid phone number");
    }
}
