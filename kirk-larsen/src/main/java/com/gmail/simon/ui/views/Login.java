package com.gmail.simon.ui.views;

import com.gmail.simon.ui.FrontPage;
import com.gmail.simon.ui.MainLayout;
import com.gmail.simon.ui.util.KirklarsenConst;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.*;


@PageTitle(KirklarsenConst.TITLE_LOGIN)
@Route(KirklarsenConst.PAGE_LOGIN)
public class Login extends FrontPage {


    public Login() {

        Label title = new Label("Kirk Larsen");


        HorizontalLayout header = new HorizontalLayout(title);
        header.setAlignItems(FlexComponent.Alignment.CENTER);
        header.setFlexGrow(1, title);
        header.setPadding(true);
        header.setSpacing(true);

        LoginOverlay component = new LoginOverlay();

        component.addLoginListener(e -> component.close());
        Button open = new Button("Open Login Overlay", e -> component.setOpened(true));

        LoginI18n i18n = LoginI18n.createDefault();
        i18n.setAdditionalInformation("To close form");
        component.setI18n(i18n);
    }
/*
    @Override
    public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {

    }

 */
}
