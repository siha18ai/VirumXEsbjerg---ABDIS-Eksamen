package com.gmail.simon.ui.views;

import com.gmail.simon.ui.FrontPage;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Right;
import com.gmail.simon.ui.layout.size.Uniform;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.util.css.FlexWrap;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Forside")
@Route(value = "forside2", layout = FrontPage.class)

public class FrontPage1 extends ViewFrame{

    public FrontPage1() {
        setId("forside");
        setViewContent(createContent());
    }

    private Component createContent() {
        Html body = new Html("<p>Fremgår der en ustyrlig høj grundskyld af din nye forskudsopgørelse?" +
                "Opret dig <b>gratis</b> og få hjælp fra en af vores yderst professionelle advokater." +
                "<a href=\"https://material.io/design/layout/responsive-layout-grid.html\">Material Design</a>. " +
                "Utilises the <a href=\"https://vaadin.com/themes/lumo\">Lumo</a> theme.</p>");
        Html productivity = new Html("<p>Vi har nogle af Danmarks førende advokater indenfor ejendomsloven" +
                "og har været behjælpelig med skattenedsættelser på ejendomme, heri specielt ejendomme der " +
                "hører under etagearealprincippet i forbindelse med ejendomsvurderingloven.</p>");

        Anchor login = new Anchor("http://localhost:8080/login-again", UIUtils.createButton("Login", VaadinIcon.EXTERNAL_LINK));
        Anchor signup = new Anchor("http://localhost:8080/sign-up-frame", UIUtils.createButton("Signup", VaadinIcon.EXTERNAL_LINK));

        FlexBoxLayout links = new FlexBoxLayout(login, signup);
        links.setFlexWrap(FlexWrap.WRAP);
        links.setSpacing(Right.S);

        FlexBoxLayout flexBoxLayout = new FlexBoxLayout(body, productivity, links);
        flexBoxLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        flexBoxLayout.setFlexDirection(FlexDirection.COLUMN);
        flexBoxLayout.setMargin(Horizontal.AUTO);
        flexBoxLayout.setMaxWidth("840px");
        flexBoxLayout.setPadding(Uniform.RESPONSIVE_L);

        return flexBoxLayout;

    }

}
