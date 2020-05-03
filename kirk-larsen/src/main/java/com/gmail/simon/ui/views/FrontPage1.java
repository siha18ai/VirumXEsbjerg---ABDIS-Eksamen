package com.gmail.simon.ui.views;

import com.gmail.simon.ui.FrontPage;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Uniform;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Forside")
@Route(value = "", layout = FrontPage.class)

public class FrontPage1 extends ViewFrame{
    private static final String CLASS_NAME = "esbjerg";
    public static final String MAX_WIDTH = "1024px";

    public FrontPage1() {
        setViewContent(createContent());
    }

    private Component createContent() {
        Component payments = createPayments();

        FlexBoxLayout content = new FlexBoxLayout(payments);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setFlexDirection(FlexDirection.COLUMN);
        return content;
    }
    private Component createPayments(){
        Html overskrift = new Html("<h1>Hej Esbjerg</h1>");
        Html body = new Html("<p>Hvordan går det? </p>");

        FlexBoxLayout flexBoxLayout = new FlexBoxLayout(overskrift, body);
        flexBoxLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        flexBoxLayout.setFlexDirection(FlexDirection.COLUMN);
        flexBoxLayout.setMargin(Horizontal.AUTO);
        flexBoxLayout.setMaxWidth("840px");
        flexBoxLayout.setPadding(Uniform.RESPONSIVE_L);

        return flexBoxLayout;
    }

}
