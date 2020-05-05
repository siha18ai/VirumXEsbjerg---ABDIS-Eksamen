package com.gmail.simon.ui.views;

import com.gmail.simon.ui.MainLayout;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Right;
import com.gmail.simon.ui.layout.size.Uniform;
import com.gmail.simon.ui.util.FontSize;
import com.gmail.simon.ui.util.TextColor;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.util.css.Overflow;
import com.gmail.simon.ui.util.css.TextOverflow;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.swing.*;
import java.awt.*;

@Route(value = "About", layout = MainLayout.class)
@PageTitle("Welcome")
public class About extends ViewFrame {

    public About() {
        setId("startpage");
        setViewContent(startPageContent());
    }
    private Component startPageContent() {

        //Header

        Html velkommen = new Html("<h1> Hvorfor vælge Kirk Larsen til at hjælpe dig? </h1>");

        Html intro = new Html("<p>Vi mener selv, at vi er noget helt særligt – men det skal du " +
                " selvfølgelig også synes. Vi har nedenfor beskrevet hvorfor vi mener, at vi er din rigtige " +
                " samarbejdspartner, hvis du ender i skatteretlige problemer.</p>");
        Html velkommen2 = new Html("<h2> Hvorfor skal du vælge os? </h2>");

        Html body = new Html("<p>Kirk Larsen er anderledes end de andre spillere på markedet – " +
                "og det er vi egentlig ret stolte af. Vi er trætte af skattemæssige fordyrelser og" +
                " faktuelt forkerte ejendomsvurderinger der får de civile til at betale regningen. " +
                "Vi er innovative, vi bruger teknologi og " +
                "vi har de dygtigste eksperter inden for beskatning af fast ejendom. Vi råder over følgende advokater" +
                " og konsulenter:");
        Html list = new Html("<ul>" +
                "<li><a href=\"https://www.kirklarsen.dk/medarbejdere/jurister/peter-lorentzen/\">Peter Lorentzen</a></li>" +
                "<li><a href=\"https://www.kirklarsen.dk/medarbejdere/jurister/jens-munch/\">Jens Munch</a></li>" +
                "<li><a href=\"https://www.kirklarsen.dk/medarbejdere/jurister/jacob-ladefoged/\">Jacob Ladefoged</a></li>" +
                "<li><a href=\"https://www.kirklarsen.dk/medarbejdere/konsulenter/emil-torbensen/\">Emil Torbensen</a></li></ul>");

        Html end = new Html("<p>Skal du høre mere og snakke med en af vores advokater " +
                "uden nogen former for forpligtelse?</p>");


        Anchor signUp = new Anchor("http://localhost:8080/sign-up-frame", UIUtils.createButton("Sign Up", VaadinIcon.USER));

        HorizontalLayout header = new HorizontalLayout(signUp);
        header.setAlignItems(FlexComponent.Alignment.CENTER);
        header.setFlexGrow(1, signUp);

        FlexBoxLayout content = new FlexBoxLayout(velkommen, intro, velkommen2, body, list, end, header);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("840px");
        content.setPadding(Uniform.RESPONSIVE_L);




        return content;


    }


}
