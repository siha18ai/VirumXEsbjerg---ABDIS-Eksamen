package com.gmail.simon.ui.views.kundeView;

import com.gmail.simon.backend.Artikler;
import com.gmail.simon.backend.database.Data;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.layout.size.*;
import com.gmail.simon.ui.util.IconSize;
import com.gmail.simon.ui.util.LumoStyles;
import com.gmail.simon.ui.util.TextColor;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.BorderRadius;
import com.gmail.simon.ui.util.css.BoxSizing;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.util.css.Shadow;
import com.gmail.simon.ui.views.ViewFrameUser;
import com.gmail.simon.ui.views.mainViews.KundeLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.board.Row;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./styles/views/statistics.css")
@PageTitle("Artikler")
@Route(value = "artikler", layout = KundeLayout.class)
public class ArtiklerUser extends ViewFrameUser {

    private static final String CLASS_NAME = "artikler";
    public static final String MAX_WIDTH = "1024px";

    private Grid<Artikler> grid;
    private ListDataProvider<Artikler> dataProvider;

    public ArtiklerUser() {
        setViewContent(createContent(), createGridContent());
    }
    private Component createContent(){
        Component docs = createDocs();

        FlexBoxLayout content = new FlexBoxLayout(docs);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setFlexDirection(FlexDirection.COLUMN);
        return content;
    }

    private Component createGridContent() {
        FlexBoxLayout content = new FlexBoxLayout(createGrid());
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setHeightFull();
        content.setPadding(Bottom.XL, Left.RESPONSIVE_L, Right.RESPONSIVE_L);
        content.setMargin(Left.RESPONSIVE_X, Right.RESPONSIVE_X);
        UIUtils.setBackgroundColor(LumoStyles.Color.BASE_COLOR, content);
        UIUtils.setBorderRadius(BorderRadius.S, content);
        UIUtils.setShadow(Shadow.XS, content);
        UIUtils.setMaxWidth(MAX_WIDTH, content);
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
    private Grid createGrid() {
        grid = new Grid<>();
        dataProvider = DataProvider.ofCollection(Data.getArtikler());
        grid.setDataProvider(dataProvider);
        grid.setHeightFull();


        grid.addColumn(Artikler::getArtikel_id)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setFrozen(true)
                .setHeader("ID")
                .setSortable(true);
        grid.addColumn(Artikler::getEmne)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setFrozen(true)
                .setHeader("Emne")
                .setSortable(true);
        grid.addColumn(Artikler::getTekst)
                .setAutoWidth(true)
                .setHeader("Tekst");
        grid.addColumn(Artikler::getDato)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setFrozen(true)
                .setHeader("Dato")
                .setSortable(true);
        return grid;
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


}
