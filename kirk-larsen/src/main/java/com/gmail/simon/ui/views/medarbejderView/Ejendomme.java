package com.gmail.simon.ui.views.medarbejderView;

import com.gmail.simon.backend.Ejendom;
import com.gmail.simon.backend.Ejendom2;
import com.gmail.simon.backend.Konsulenter2;
import com.gmail.simon.backend.Kunde;
import com.gmail.simon.backend.database.Data;
import com.gmail.simon.ui.components.detailsdrawer.DetailsDrawer;
import com.gmail.simon.ui.components.detailsdrawer.DetailsDrawerFooter;
import com.gmail.simon.ui.components.detailsdrawer.DetailsDrawerHeader;
import com.gmail.simon.ui.util.FontSize;
import com.gmail.simon.ui.util.LumoStyles;
import com.gmail.simon.ui.util.TextColor;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.views.SplitViewFrame;
import com.gmail.simon.ui.MainLayout;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.components.ListItem;
import com.gmail.simon.ui.components.navigation.bar.AppBar;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Top;
import com.gmail.simon.ui.layout.size.Vertical;
import com.gmail.simon.ui.util.css.BoxSizing;
import com.gmail.simon.ui.views.mainViews.MedarbejderLayout;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.contextmenu.GridMenuItem;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@PageTitle("Ejendomme")
@Route(value = "ejendomme", layout = MedarbejderLayout.class)
public class Ejendomme extends SplitViewFrame {

    private Grid<Kunde> grid;
    private Grid<Ejendom2> ejendom2Grid;
    private DetailsDrawer detailsDrawer;
    private DetailsDrawerHeader detailsDrawerHeader;
    private ListDataProvider<Kunde> dataProvider;
    private com.vaadin.flow.component.textfield.TextField searchBox;

    public Ejendomme() {
        setViewContent(createContent());
        setViewDetails(createDetailsDrawer());
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        initAppBar();
        initSearchBar();
        //setViewContent(createDetailsDrawer());

    }

    private void initAppBar() {
        AppBar appBar = MedarbejderLayout.get().getAppBar();
        for (Ejendom.Status status : Ejendom.Status.values()) {
            appBar.addTab(status.getName());
        }
        appBar.addTabSelectionListener(e -> {

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
        ejendom2Grid = new Grid<>();
        grid = new Grid<>();
        ejendom2Grid.addSelectionListener(event -> event.getFirstSelectedItem().ifPresent(this::showDetails));
        dataProvider = DataProvider.ofCollection(Data.getKunder());
        grid.setDataProvider(dataProvider);
        grid.setHeightFull();

        grid.addColumn(Kunde::getUsername)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setFrozen(true)
                .setHeader("Brugernavn")
                .setSortable(true);
        grid.addColumn(new ComponentRenderer<>(this::createFromInfo))
                .setAutoWidth(true)
                .setHeader("Navn");
        grid.addColumn(new ComponentRenderer<>(this::createAccepted))
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setHeader("Accepteret")
                .setTextAlign(ColumnTextAlign.END);
        grid.addColumn(new ComponentRenderer<>(this::createAdresseDetails))
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setHeader("Adresser")
                .setTextAlign(ColumnTextAlign.END);

        return grid;
    }

    private Component createFromInfo(Kunde kunde) {
        ListItem item = new ListItem(kunde.getFirst_name(), kunde.getLast_name());
        item.setPadding(Vertical.XS);
        return item;
    }

    private Component createAccepted(Kunde kunde) {
        Icon icon;
        if (kunde.isEjendomGodkendt()) {
            icon = UIUtils.createPrimaryIcon(VaadinIcon.CHECK);
        } else {
            icon = UIUtils.createDisabledIcon(VaadinIcon.CLOSE);
        }
        return icon;
    }

    private Component createAdresseDetails(Kunde kunde) {
        ListItem item = new ListItem(kunde.getEmail(), kunde.getVejnavn());
        item.setPadding(Vertical.XS);
        return item;
    }

    private DetailsDrawer createDetailsDrawer() {
        detailsDrawer = new DetailsDrawer(DetailsDrawer.Position.RIGHT);

        //Header
        detailsDrawerHeader = new DetailsDrawerHeader("");
        detailsDrawerHeader.addCloseListener(buttonClickEvent -> detailsDrawer.hide());
        detailsDrawer.setHeader(detailsDrawerHeader);

        //Footer
        DetailsDrawerFooter footer = new DetailsDrawerFooter();
        footer.addSaveListener(e -> {
            detailsDrawer.hide();
            UIUtils.showNotification("Ændringer gemt");
        });
        footer.addCancelListener(e -> detailsDrawer.hide());
        detailsDrawer.setFooter(footer);

        return detailsDrawer;
    }

    private void showDetails(Ejendom2 ejendom2) {
        detailsDrawerHeader.setTitle("Ejendom specifikationer");
        detailsDrawer.setContent(createDetails(ejendom2));
        detailsDrawer.show();

    }

    private FormLayout createDetails(Ejendom2 ejendom2) {
        NumberField grundvaerdi = new NumberField();
        grundvaerdi.setValue(ejendom2.getGrundvaerdi());
        grundvaerdi.setWidthFull();

        IntegerField maksimalbebyggelse = new IntegerField();
        maksimalbebyggelse.setValue(ejendom2.getMaksimalBebyggelse());
        maksimalbebyggelse.setWidthFull();

        IntegerField etageArealPris = new IntegerField();
        etageArealPris.setValue(ejendom2.getEtageArealPris());
        etageArealPris.setWidthFull();

        IntegerField samletAreal = new IntegerField();
        samletAreal.setValue(ejendom2.getSamletAreal());
        samletAreal.setWidthFull();

        IntegerField faktiskGrundAreal = new IntegerField();
        faktiskGrundAreal.setValue(ejendom2.getFaktiskGrundAreal());
        faktiskGrundAreal.setWidthFull();

        IntegerField grundskyldsPromille = new IntegerField();
        grundskyldsPromille.setValue(ejendom2.getGrundskyldPromille());
        grundskyldsPromille.setWidthFull();

        FormLayout form = new FormLayout();
        form.addClassNames(LumoStyles.Padding.Bottom.L,
                LumoStyles.Padding.Horizontal.L, LumoStyles.Padding.Top.S);
        form.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("21em", 2,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP)
        );
        form.addFormItem(grundvaerdi, "Grundværdi");
        form.addFormItem(maksimalbebyggelse, "Makismalbebyggelse");
        form.addFormItem(etageArealPris, "Etage areal pris");
        form.addFormItem(samletAreal, "Samle areal");
        form.addFormItem(faktiskGrundAreal, "Faktisk grundareal");
        form.addFormItem(grundskyldsPromille, "Grundskyld promille");
        return form;
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


}
