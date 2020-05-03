package com.gmail.simon.ui.views;

import com.gmail.simon.ui.EndUserLayout;
import com.gmail.simon.ui.MainLayout;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Forside")
@Route(value = "EndUserFrontPage", layout = MainLayout.class)

public class EndUserFrontPage extends ViewFrameFrontPage{
    private static final String CLASS_NAME = "esbjerg";
    public static final String MAX_WIDTH = "1024px";

    public EndUserFrontPage() {
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
        Html html = new Html("<h1>Hej Esbjerg</h1>");
        Html html1 = new Html("<p>Hvordan går det? </p>");
        FlexBoxLayout flexBoxLayout = new FlexBoxLayout(html, html1);
        return flexBoxLayout;
    }

}
