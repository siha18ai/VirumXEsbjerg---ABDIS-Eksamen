package com.gmail.simon.ui.views.medarbejderView;

import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.layout.size.Bottom;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Left;
import com.gmail.simon.ui.layout.size.Right;
import com.gmail.simon.ui.util.IconSize;
import com.gmail.simon.ui.util.LumoStyles;
import com.gmail.simon.ui.util.TextColor;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.BorderRadius;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.util.css.Shadow;
import com.gmail.simon.ui.views.ViewFrameUser;
import com.gmail.simon.ui.views.mainViews.MedarbejderLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.board.Row;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./styles/views/statistics.css")
@PageTitle("Artikler")
@Route(value = "artiklermedarbejder", layout = MedarbejderLayout.class)
public class ArtiklerMedarbejder extends ViewFrameUser {

    private Button artikel;
    private static final String CLASS_NAME = "artikler";
    public static final String MAX_WIDTH = "1024px";

    public ArtiklerMedarbejder() {
        setViewContent(createContent());
    }
    private Component createContent(){
        Component docs = createDocs();

        FlexBoxLayout content = new FlexBoxLayout(docs);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setFlexDirection(FlexDirection.COLUMN);
        return content;
    }

    private Component createDocs() {
        Component artikler = createArtikler();

        Row docs = new Row(artikler);
        docs.addClassName(LumoStyles.Margin.Top.XL);
        UIUtils.setMaxWidth(MAX_WIDTH, docs);
        docs.setWidthFull();

        return docs;
    }
    private Component createArtikler() {
        FlexBoxLayout header = createHeader(VaadinIcon.RECORDS, "Artikler");

        Tabs tabs = new Tabs();
        for (String label : new String[]{"2020", "2019", "2018"}) {
            tabs.add(new Tab(label));
        }

        Div card = new Div(tabs);
        UIUtils.setBackgroundColor(LumoStyles.Color.BASE_COLOR, card);
        UIUtils.setBorderRadius(BorderRadius.S, card);
        UIUtils.setShadow(Shadow.XS, card);

        FlexBoxLayout artikler = new FlexBoxLayout(header, card);
        artikler.addClassName(CLASS_NAME + "__artikler");
        artikler.setFlexDirection(FlexDirection.COLUMN);
        artikler.setPadding(Bottom.XL, Left.RESPONSIVE_L);
        return artikler;
    }

    private FlexBoxLayout createHeader(VaadinIcon icon, String title) {
        FlexBoxLayout header = new FlexBoxLayout(
                UIUtils.createIcon(IconSize.M, TextColor.TERTIARY, icon),
                UIUtils.createH3Label(title));
        header.setAlignItems(FlexComponent.Alignment.CENTER);
        header.setMargin(Bottom.L, Horizontal.RESPONSIVE_L);
        header.setSpacing(Right.L);
        return header;
    }
/*
    public Button createArtikelButton() {
        artikel = new Button("Ny artikel", new Icon(VaadinIcon.PLUS));
        artikel.setIconAfterText(true);
        return artikel;
    }
    /*
    public void changeButtonSettings() {
        artikel.addClickListener(this)

    }
     */




}
