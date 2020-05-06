package com.gmail.simon.ui.views;

import com.gmail.simon.backend.DummyData;
import com.gmail.simon.backend.Ejendom;
import com.gmail.simon.backend.Person;
import com.gmail.simon.ui.MainLayout;
import com.gmail.simon.ui.components.Badge;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.components.ListItem;
import com.gmail.simon.ui.components.detailsdrawer.DetailsDrawer;
import com.gmail.simon.ui.components.detailsdrawer.DetailsDrawerHeader;
import com.gmail.simon.ui.components.navigation.bar.AppBar;
import com.gmail.simon.ui.layout.size.Bottom;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Top;
import com.gmail.simon.ui.layout.size.Vertical;
import com.gmail.simon.ui.util.*;
import com.gmail.simon.ui.util.css.BoxSizing;
import com.gmail.simon.ui.util.css.WhiteSpace;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;

@PageTitle("Ejendomme")
@Route(value = "ejendomme", layout = MainLayout.class)
public class Ejendomme extends SplitViewFrame {

    private Grid<Ejendom> grid;
    //private DetailsDrawer detailsDrawer;
    private ListDataProvider<Ejendom> dataProvider;
    //private ListDataProvider<Person> dataProvider;
    private com.vaadin.flow.component.textfield.TextField searchBox;


    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        initAppBar();
        initSearchBar();
        setViewContent(createContent());
        //setViewContent(createDetailsDrawer());
        filter();
    }
    private void initAppBar() {
        AppBar appBar = MainLayout.get().getAppBar();
        for (Ejendom.Status status : Ejendom.Status.values()) {
            appBar.addTab(status.getName());
        }
        appBar.addTabSelectionListener(e -> {
            filter();
            //detailsDrawer.hide();
        });

        appBar.centerTabs();

    }

    private void initSearchBar() {
        searchBox = new TextField();
        searchBox.setPlaceholder("Search");
        searchBox.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
        searchBox.setVisible(false);
    }
    private Component createContent() {
        FlexBoxLayout flexBoxLayout = new FlexBoxLayout(createGrid());
        flexBoxLayout.setBoxSizing(BoxSizing.BORDER_BOX);
        flexBoxLayout.setHeightFull();
        flexBoxLayout.setPadding(Horizontal.RESPONSIVE_X, Top.RESPONSIVE_X);
        return flexBoxLayout;
    }

    private Grid createGrid() {
        dataProvider = DataProvider.ofCollection(DummyData.getEjendom());
        //dataProvider = DataProvider.ofCollection()
        grid = new Grid<>();
        //grid.addSelectionListener(event -> event.getFirstSelectedItem().ifPresent(this::showDetails));
        grid.setDataProvider(dataProvider);
        grid.setHeightFull();


        ComponentRenderer<Badge, Ejendom> badgeEjendomComponentRenderer = new ComponentRenderer<>(
                ejendom -> {
                    Ejendom.Status status = ejendom.getStatus();
                    Badge badge = new Badge(status.getName(), status.getTheme());
                    UIUtils.setTooltip(status.getDesc(), badge);
                    return badge;
                }
        );

        grid.addColumn(badgeEjendomComponentRenderer)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setHeader("Status");
        grid.addColumn(new ComponentRenderer<>(this::createFromInfo))
                .setHeader("Ejer")
                .setWidth("200px");
        grid.addColumn(new ComponentRenderer<>(this::createAreal))
                .setHeader("Areal")
                .setWidth("200px");
        grid.addColumn(new ComponentRenderer<>(this::createAdresse))
                .setHeader("Adresse")
                .setWidth("200px");
        return grid;
    }
    private Component createFromInfo (Ejendom ejendom) {
        ListItem item = new ListItem(ejendom.getEjerNavn(), ejendom.getKommuneNr());
        item.setPadding(Vertical.XS);
        return item;
    }
    private Component createAreal(Ejendom ejendom) {
        ListItem item = new ListItem(ejendom.getGrundAreal(), ejendom.getEjendomsNr());
        item.setPadding(Vertical.XS);
        return item;
    }
    private Component createAdresse(Ejendom ejendom) {
        ListItem item = new ListItem(ejendom.getAdresse());
        item.setPadding(Vertical.XS);
        return item;
    }

/*
    private DetailsDrawer createDetailsDrawer() {
        detailsDrawer = new DetailsDrawer(DetailsDrawer.Position.RIGHT);

        //Header
        Tab details = new Tab("Detaljer");
        Tab attachments = new Tab("Vedhæftet");
        Tab history = new Tab("Historie");

        Tabs tabs = new Tabs(details, attachments, history);
        tabs.addThemeVariants(TabsVariant.LUMO_EQUAL_WIDTH_TABS);
        tabs.addSelectedChangeListener(e -> {
            Tab selectedTab = tabs.getSelectedTab();
            if (selectedTab.equals(details)){
                detailsDrawer.setContent(createDetails(grid.getSelectionModel().getFirstSelectedItem().get()));
            } else if (selectedTab.equals(attachments)) {
                detailsDrawer.setContent(createAttachments());
            } else if (selectedTab.equals(history)) {
                detailsDrawer.setContent(createHistory());
            }
        });
        DetailsDrawerHeader detailsDrawerHeader = new DetailsDrawerHeader("Ejendom detaljer", tabs);
        detailsDrawerHeader.addCloseListener(buttonClickEvent -> detailsDrawer.hide());
        detailsDrawer.setHeader(detailsDrawerHeader);

        return detailsDrawer;
    }
*/
    public void filter() {
        Tab selectedTab = MainLayout.get().getAppBar().getSelectedTab();
        if (selectedTab != null) {
            dataProvider.setFilterByValue(Ejendom::getStatus, Ejendom.Status
                    .valueOf(selectedTab.getLabel().toUpperCase()));
        }
    }
    public void filterEjer() {
        Tab selectedTab = MainLayout.get().getAppBar().getSelectedTab();
        if (selectedTab != null) {
            dataProvider.setFilterByValue(Ejendom::getEjerNavn, Ejendom.Status
                    .valueOf(selectedTab.getLabel().toUpperCase()));
        }
    }

/*
    private void showDetails(Ejendom ejendom) {
        detailsDrawer.setContent(createDetails(ejendom));
        detailsDrawer.show();

    }

    private Component createDetails(Ejendom ejendom) {
        ListItem status = new ListItem(ejendom.getStatus().getIcon(),
                ejendom.getStatus().getName(), "Status");
        status.getContent().setAlignItems(FlexComponent.Alignment.BASELINE);
        status.getContent().setSpacing(Bottom.XS);
        UIUtils.setTheme(ejendom.getStatus().getTheme().getThemeName(),
                status.getPrimary());
        UIUtils.setTooltip(ejendom.getStatus().getDesc(), status);

        ListItem from = new ListItem(UIUtils.createTertiaryIcon(VaadinIcon.UPLOAD_ALT), ejendom.getEjerNavn() + "\n"
        + ejendom.getAdresse(), "Potentiel kunde");

        ListItem areal = new ListItem(UIUtils.createTertiaryIcon(VaadinIcon.HOME),
                ejendom.getGrundAreal() + "\n" + ejendom.getKommuneNr(), "Areal");
        ListItem adresse = new ListItem(
                UIUtils.createTertiaryIcon(VaadinIcon.ANGLE_DOUBLE_RIGHT),
                ejendom.getAdresse(), "Adresse");

        for (ListItem item : new ListItem[]{from, areal}) {
            item.setReverse(true);
            item.setWhiteSpace(WhiteSpace.PRE_LINE);
        }
        Div details = new Div(from, areal);
        details.addClassName(LumoStyles.Padding.Vertical.S);
        return details;
    }

    private Component createAttachments() {
        Label message = UIUtils.createLabel(FontSize.S, TextColor.SECONDARY, "Ikke implementeret endnu");
        message.addClassNames(LumoStyles.Padding.Responsive.Horizontal.L, LumoStyles.Padding.Vertical.L);
        return message;
    }
    private Component createHistory() {
        Label message = UIUtils.createLabel(FontSize.S, TextColor.SECONDARY, "Ikke implementeret endnu");
        message.addClassNames(LumoStyles.Padding.Responsive.Horizontal.L, LumoStyles.Padding.Vertical.L);
        return message;
    }

 */
}
