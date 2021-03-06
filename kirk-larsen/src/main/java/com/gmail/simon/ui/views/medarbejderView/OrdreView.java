package com.gmail.simon.ui.views.medarbejderView;

import com.gmail.simon.backend.Konsulenter2;
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
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;

@Route(value = "ordreView", layout = MedarbejderLayout.class)
@PageTitle("ordre")
public class OrdreView extends SplitViewFrame {
    private Grid<Ordre> grid;
    private ListDataProvider<Ordre> dataProvider;

    private static final String CLASS_NAME = "ordre";
    public static final String MAX_WIDTH = "1024px";
    private Data data;

    public OrdreView() {
        this.data = new Data();
        setViewContent(createContent(), createContentGrid());
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
        dataProvider = DataProvider.ofCollection(Data.getOrdre());
        grid.setDataProvider(dataProvider);
        grid.setHeightFull();

        grid.addColumn(Ordre::getEmne)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setFrozen(true)
                .setHeader("Emne")
                .setSortable(true);
        grid.addColumn(Ordre::getBeskrivelse)
                .setAutoWidth(true)
                .setHeader("Beskrivelse");
        grid.addColumn(Ordre::getTelefon)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setFrozen(true)
                .setHeader("Telefon")
                .setSortable(true);
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
        FlexBoxLayout header = createHeader(VaadinIcon.EDIT, "Ordre");
        Tabs tabs = new Tabs();
        for (String label : new String[]{"Nye", "Accepteret"}) {
            tabs.add(new Tab(label));
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
