package com.gmail.simon.ui.views.login_signupView.login.signup;


import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.*;

@PageTitle("page 1")
@Route(value = "page1")
public class page1 extends SignupFrame {
    private TextField vejnavn, etage;
    private NumberField husnr;
    public page1(){
        changeContent(createLabel(), createHorizontal1(), createHorizontal2(), createHorizontal3());
        removeRegistration();
        changeButtonSettings("sign-up-frame", "page2",  vejnavn);
        setProgressBar(getProcent(1));
    }
    public Label createLabel(){
        Label label = new Label();
        label.setText("Adresse: ");
        return label;
    }
    public HorizontalLayout createHorizontal1(){
        HorizontalLayout h1 = new HorizontalLayout();
        vejnavn = new TextField("Vejnavn");
        vejnavn.setClearButtonVisible(true);
        vejnavn.setRequired(true);
        etage = new TextField("Etage");
        etage.setClearButtonVisible(true);
        etage.setPattern("[0-9.,]*");
        etage.setPreventInvalidInput(true);
        h1.add(vejnavn, etage);
        return h1;
    }
    public HorizontalLayout createHorizontal2(){
        HorizontalLayout h1 = new HorizontalLayout();
        husnr = new NumberField("Hus nr.");
        husnr.setHasControls(true);
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
}
