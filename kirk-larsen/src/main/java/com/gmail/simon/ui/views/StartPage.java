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

@Route(value = "Forside", layout = MainLayout.class)
@PageTitle("Welcome")
public class StartPage extends ViewFrame {

    public StartPage () {
        setId("startpage");
        setViewContent(startPageContent());
    }
    private Component startPageContent() {

        //Header

        Html velkommen = new Html("<h1> Velkommen til vores portal! </h1>");

        Html intro = new Html("<p>Dette er mere end bare en gude portal, dette er vildere end den" +
                "kontrapsykliske kapital buffer</p>");

        Button signUp = UIUtils.createButton("Sign Up", VaadinIcon.USER);

        HorizontalLayout header = new HorizontalLayout(signUp);
        header.setAlignItems(FlexComponent.Alignment.CENTER);
        header.setFlexGrow(1, signUp);

        FlexBoxLayout content = new FlexBoxLayout(velkommen, intro, header);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("840px");
        content.setPadding(Uniform.RESPONSIVE_L);




        return content;


    }


}
