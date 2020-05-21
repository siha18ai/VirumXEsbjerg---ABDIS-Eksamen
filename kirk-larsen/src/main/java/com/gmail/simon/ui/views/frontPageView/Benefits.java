package com.gmail.simon.ui.views.frontPageView;

import com.gmail.simon.ui.views.ViewFrame;
import com.gmail.simon.ui.MainLayout;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Uniform;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "Benefits", layout = MainLayout.class)
@PageTitle("Benefits")
public class Benefits extends ViewFrame {

    public Benefits() {
        setId("Benefits");
        setViewContent(benefitContent());
    }
    private Component benefitContent() {

        Html header = new Html("<h1> <b>Ydelser</b> </h1>");
        Html intro = new Html("<p>Med Kirk Larsen bag dig, står du stærkt og trygt som ejer. " +
                "Vi kan hjælpe dig igennem en lang række uberettiget konflikter, der kan opstå mellem dig og skat. " +
                "Vi har set lidt af det hele, og derfor kan vi med sikkerhed sige, at du er i trygge hænder hos os.\n" +
                "Vi går op i, at det skal være nemt og simplet for dig at få hjælp til din sag. " +
                "Det bedste af det hele er, at du kun betaler os, hvis vi kan se du kan få en skattenedsættelse, " +
                "det er da til at forholde sig til.</p>");
        Html header2 = new Html("<h2> Ekspertise områder </h2>");
        Html body = new Html("<p> <b>Beskatning fast ejendom:</b> " +
                "\nEt af virksomhedens specialer er beskatning af fast ejendom, hvor vi arbejder for en " +
                "lang række institutioner og virksomheder, herunder flere børsnoterede selskaber." +
                "\nSkattetrykket på fast ejendom har været stigende gennem de senere år. Stigningen skyldes, " +
                "dels forhøjelser af de offentlige ejendomsvurderinger, dels forhøjelser af de procentsatser, " +
                "hvorved ejendomsskatterne opkræves. Udviklingen aktualiserer virksomhedernes kontrol med, " +
                "at der ikke opkræves større skatter end lovgivningen tillader.\n" +
                "\n" +
                "Vi er altid indstillet på at foretage en uforpligtende gennemgang af kundens ejendomme med " +
                "henblik på at vurdere, om der er forhold, som potentielt kan begrunde en reduktion af ejendomsskatterne. " +
                "Det er vores erfaring, at dette ofte er tilfældet.\n" +
                "\n" +
                "Såfremt kunden ønsker det, er vi indstillet på at drøfte en succesbaseret " +
                "honoraraftale med et loft over vores honorar.");

        FlexBoxLayout content = new FlexBoxLayout(header, intro, header2, body);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("840px");
        content.setPadding(Uniform.RESPONSIVE_L);

        return content;
    }



}
