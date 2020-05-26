package com.gmail.simon.ui.views.frontPageView;


import com.gmail.simon.ui.MainLayout;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Uniform;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.views.ViewFrame;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "Grundskyld", layout = MainLayout.class)
@PageTitle("Grundskyld")
public class Grundskyld extends ViewFrame {

    public Grundskyld() {
        setId("grundskyld");
        setViewContent(grundskyldContent());

    }

    private Component grundskyldContent(){
        //Header
        Html velkommen = new Html("<h1> Hvad er grundskyld? </h1>");
        Html grundskyld = new Html("<p> \n" +
                "Grundskyld, også kaldet ejendomsskat eller grundskat, er en skat på jord. Det er altså ikke en beskatning af boligen – men af selve den grund, du ejer.\n" +
                "\n" +
                "Grundskyld opkræves af kommunerne og udgør en promilledel af den afgiftspligtige grundværdi. Udover grundskyld betaler du også ejendomsværdiskat for din bolig.\n" +
                "\n" +
                "I slutningen af året modtager du en opkrævning fra kommunen for næste års grundskyld. Betalingen forfalder typisk over to rater.\n" +
                "\n" +
                "Et begrænset antal ejendomme er fritaget for grundskyld efter reglerne i  \"Lov om kommunal ejendomsskat\" § 7. Fritagelsen for grundskyld omfatter bl.a fredede ejendomme.</p>");

        FlexBoxLayout content = new FlexBoxLayout(velkommen, grundskyld);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("840px");
        content.setPadding(Uniform.RESPONSIVE_L);


        return content;
    }
}
