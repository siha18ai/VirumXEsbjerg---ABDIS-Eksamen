package com.gmail.simon.ui.views.medarbejderView;

import com.gmail.simon.backend.Artikler;
import com.gmail.simon.backend.Kunde;
import com.gmail.simon.backend.Ordre;
import com.gmail.simon.backend.database.Data;
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
import com.gmail.simon.ui.views.SplitViewFrame;
import com.gmail.simon.ui.views.mainViews.MedarbejderLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.board.Row;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.data.selection.SingleSelect;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;

@Route(value = "artiklerMedarbejder", layout = MedarbejderLayout.class)
@PageTitle("ArtiklerForMedarbejder")
public class ArtiklerView extends SplitViewFrame {
    private Button artikel;

    private Grid<Artikler> grid;
    private ListDataProvider<Artikler> dataProvider;
    private Button update;

    private static final String CLASS_NAME = "artikel";
    public static final String MAX_WIDTH = "1024px";
    private Kunde currentKunde;
    private Data data;

    public ArtiklerView() {
        this.data = new Data();
        setViewContent(createContent(), createContentGrid());
        changeButtonSettings("nyartikel");
    }

    private Component createContent() {

        Component ordre = createDocs();

        FlexBoxLayout content = new FlexBoxLayout(ordre);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setFlexDirection(FlexDirection.COLUMN);
        return content;
    }
    private Component createContentGrid() {
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
    private Grid createGrid() {
        grid = new Grid<>();
        dataProvider = DataProvider.ofCollection(Data.getArtikler());
        grid.setDataProvider(dataProvider);
        grid.setHeightFull();
        Button button = new Button("Delete");

        grid.addColumn(Artikler::getEmne)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setFrozen(true)
                .setHeader("Emne")
                .setSortable(true);
        grid.addColumn(Artikler::getTekst)
                .setAutoWidth(true)
                .setHeader("Beskrivelse");
        grid.addColumn(Artikler::getDato)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setFrozen(true)
                .setHeader("Dato")
                .setSortable(true);
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        SingleSelect<Grid<Artikler>, Artikler> artikelSelect = grid.asSingleSelect();
        grid.addItemDoubleClickListener(e -> artikelSelect.setEnabled(true));


        return grid;

    }

    private Component createDocs(){
        Component ordre = createOrdre();

        Row docs = new Row(ordre);
        docs.addClassName(LumoStyles.Margin.Top.XL);
        UIUtils.setMaxWidth(MAX_WIDTH, docs);
        docs.setWidthFull();

        return docs;
    }

    private Component createOrdre() {
        FlexBoxLayout header = createHeader(VaadinIcon.EDIT, "Artikel");
        Button nyOrdre = createOrdreButton();

        Tabs tabs = new Tabs();
        for (String label : new String[]{"Nye", "Accepteret"}) {
            tabs.add(new Tab(label));
            tabs.add(nyOrdre);
        }
        Div card = new Div(tabs);
        UIUtils.setBackgroundColor(LumoStyles.Color.BASE_COLOR, card);
        UIUtils.setBorderRadius(BorderRadius.S, card);
        UIUtils.setShadow(Shadow.XS, card);

        FlexBoxLayout ordre = new FlexBoxLayout(header, card);
        ordre.setClassName(CLASS_NAME + "__ordre");
        ordre.setFlexDirection(FlexDirection.COLUMN);
        ordre.setPadding(Bottom.XL, Right.RESPONSIVE_L);
        return ordre;
    }
    public Button createOrdreButton() {
        artikel = new Button("Ny artikel", new Icon(VaadinIcon.PLUS));
        artikel.setIconAfterText(true);
        return artikel;
    }
    public void changeButtonSettings(String ordreString) {
        artikel.addClickListener(e -> artikel.getUI().ifPresent(ui -> ui.navigate(ordreString)));
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
