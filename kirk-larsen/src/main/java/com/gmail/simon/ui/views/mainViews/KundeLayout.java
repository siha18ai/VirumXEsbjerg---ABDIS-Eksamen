package com.gmail.simon.ui.views.mainViews;

import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.components.navigation.bar.AppBar;
import com.gmail.simon.ui.components.navigation.bar.TabBar;
import com.gmail.simon.ui.components.navigation.drawer.NaviDrawer;
import com.gmail.simon.ui.components.navigation.drawer.NaviItem;
import com.gmail.simon.ui.components.navigation.drawer.NaviMenu;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.util.css.Overflow;
import com.gmail.simon.ui.views.kundeView.ArtiklerUser;
import com.gmail.simon.ui.views.kundeView.UserEjendom;
import com.gmail.simon.ui.views.kundeView.UserOplysninger;
import com.gmail.simon.ui.views.kundeView.BrugerOrdre;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.*;
import com.vaadin.flow.theme.lumo.Lumo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CssImport(value = "./styles/components/charts.css", themeFor = "vaadin-chart", include = "vaadin-chart-default-theme")
@CssImport(value = "./styles/components/floating-action-button.css", themeFor = "vaadin-button")
@CssImport(value = "./styles/components/grid.css", themeFor = "vaadin-grid")
@CssImport("./styles/lumo/border-radius.css")
@CssImport("./styles/lumo/icon-size.css")
@CssImport("./styles/lumo/margin.css")
@CssImport("./styles/lumo/padding.css")
@CssImport("./styles/lumo/shadow.css")
@CssImport("./styles/lumo/spacing.css")
@CssImport("./styles/lumo/typography.css")
@CssImport("./styles/misc/box-shadow-borders.css")
@CssImport(value = "./styles/styles.css", include = "lumo-badge")
@JsModule("@vaadin/vaadin-lumo-styles/badge")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
public class KundeLayout extends FlexBoxLayout
        implements RouterLayout, PageConfigurator, AfterNavigationObserver {

    private static final Logger log = LoggerFactory.getLogger(KundeLayout.class);
    private static final String CLASS_NAME = "kunde";

    private Div appHeaderOuter;

    private FlexBoxLayout row;
    private NaviDrawer naviDrawer;
    private FlexBoxLayout column;

    private Div appHeaderInner;
    private FlexBoxLayout viewContainer;
    private Div appFooterInner;

    private Div appFooterOuter;

    private TabBar tabBar;
    private boolean navigationTabs = false;
    private AppBar appBar;

    public KundeLayout() {
        VaadinSession.getCurrent()
                .setErrorHandler((ErrorHandler) errorEvent -> {
                    log.error("Uncaught UI exception",
                            errorEvent.getThrowable());
                    Notification.show("We are sorry, but an internal error occurred");
                });

        addClassName(CLASS_NAME);
        setFlexDirection(FlexDirection.COLUMN);
        setSizeFull();

        // Initialise the UI building blocks
        initStructure();

        // Populate the navigation drawer
        initNaviItems();

        // Configure the headers and footers (optional)
        initHeaderAndFooters();

    }
    private void initStructure() {
        naviDrawer = new NaviDrawer();

        viewContainer = new FlexBoxLayout();
        viewContainer.addClassName(CLASS_NAME + "__view-container");
        viewContainer.setOverflow(Overflow.HIDDEN);

        column = new FlexBoxLayout(viewContainer);
        column.addClassName(CLASS_NAME + "__column");
        column.setFlexDirection(FlexDirection.COLUMN);
        column.setFlexGrow(1, viewContainer);
        column.setOverflow(Overflow.HIDDEN);

        row = new FlexBoxLayout(naviDrawer, column);
        row.addClassName(CLASS_NAME + "__row");
        row.setFlexGrow(1, column);
        row.setOverflow(Overflow.HIDDEN);
        add(row);
        setFlexGrow(1, row);
    }

    /*
    Initialise the navigation items.
     */

    public void changeNaviItems(NaviItem... naviItems) {
        naviDrawer.getMenu().removeAll();
        NaviMenu menu = naviDrawer.getMenu();
        for (NaviItem naviItem : naviItems) {
            menu.addNaviItem(naviItem);
        }
    }
    private void initNaviItems() {
        NaviMenu menu = naviDrawer.getMenu();
        menu.addNaviItem(VaadinIcon.INFO, "Oplysninger", UserOplysninger.class);
        menu.addNaviItem(VaadinIcon.HOME, "Ejendom", UserEjendom.class);
        menu.addNaviItem(VaadinIcon.RECORDS, "Artikler", ArtiklerUser.class);
        menu.addNaviItem(VaadinIcon.CASH, "Ordre", BrugerOrdre.class);
    }
    private void initHeaderAndFooters(){
        setAppHeaderOuter();
        setAppFooterInner();
        setAppFooterOuter();

        // Default inner header setup:
        // - When using tabbed navigation the view title, user avatar and main menu button will appear in the TabBar.
        // - When tabbed navigation is turned off they appear in the AppBar.
        appBar = new AppBar("");

        // Tabbed navigation
        if (navigationTabs) {
            tabBar = new TabBar();
            UIUtils.setTheme(Lumo.DARK, tabBar);

            // Shift-click to add a new tab
            for (NaviItem item : naviDrawer.getMenu().getNaviItems()) {
                item.addClickListener(e -> {
                    if (e.getButton() == 0 && e.isShiftKey()) {
                        tabBar.setSelectedTab(tabBar.addClosableTab(item.getText(),
                                item.getNavigationTarget()));
                    }
                });
            }
            appBar.getAvatar().setVisible(false);
            setAppHeaderInner(tabBar, appBar);
        } else {
            UIUtils.setTheme(Lumo.DARK, appBar);
            setAppHeaderInner(appBar);
        }

    }

    @Override
    public void configurePage(InitialPageSettings initialPageSettings) {
        initialPageSettings.addMetaTag("apple-mobile-web-app-capable", "yes");
        initialPageSettings.addMetaTag("apple-mobile-web-app-status-bar-style", "black");

        initialPageSettings.addFavIcon("icon", "frontend/images/favicons/favicon.ico",
                "256x256");
    }
    @Override
    public void showRouterLayoutContent(HasElement content) {
        this.viewContainer.getElement().appendChild(content.getElement());
    }
    public NaviDrawer getNaviDrawer() {
        return naviDrawer;
    }

    public static KundeLayout get() {
        return (KundeLayout) UI.getCurrent().getChildren()
                .filter(component -> component.getClass() == KundeLayout.class)
                .findFirst().get();
    }
    public AppBar getAppBar() {
        return appBar;
    }
    @Override
    public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {
        if (navigationTabs) {
            afterNavigationWithTabs(afterNavigationEvent);
        } else {
            afterNavigationWithoutTabs(afterNavigationEvent);
        }
    }
    private void afterNavigationWithTabs(AfterNavigationEvent e) {
        NaviItem naviItem = getActiveItem(e);
        if (naviItem == null) {
            if (tabBar.getTabCount() == 0) {
                tabBar.addClosableTab("", UserOplysninger.class);
            }
        } else {
            if (tabBar.getTabCount() > 0) {
                tabBar.updateSelectedTab(naviItem.getText(),
                        naviItem.getNavigationTarget());
            } else {
                tabBar.addClosableTab(naviItem.getText(),
                        naviItem.getNavigationTarget());
            }
        }
        appBar.getMenuIcon().setVisible(false);
    }

    private NaviItem getActiveItem(AfterNavigationEvent e) {
        for (NaviItem item : naviDrawer.getMenu().getNaviItems()) {
            if (item.isHighlighted(e)) {
                return item;
            }
        }
        return null;
    }
    private void afterNavigationWithoutTabs (AfterNavigationEvent e) {
        NaviItem active = getActiveItem(e);
        if (active != null) {
            getAppBar().setTitle(active.getText());
        }
    }

    private void setAppHeaderOuter(Component... components) {
        if (appHeaderOuter == null) {
            appHeaderOuter = new Div();
            appHeaderOuter.addClassName("app-header-outer");
            getElement().insertChild(0, appHeaderOuter.getElement());
        }
        appHeaderOuter.removeAll();
        appHeaderOuter.add(components);
    }
    private void setAppHeaderInner(Component... components) {
        if (appHeaderInner == null) {
            appHeaderInner = new Div();
            appHeaderInner.addClassName("app-header-inner");
            column.getElement().insertChild(0, appHeaderInner.getElement());
        }
        appHeaderInner.removeAll();
        appHeaderInner.add(components);
    }
    private void setAppFooterInner(Component... components) {
        if (appFooterInner == null) {
            appFooterInner = new Div();
            appFooterInner.addClassName("app-footer-inner");
            column.getElement().insertChild(column.getElement().getChildCount(),
                    appFooterInner.getElement());
        }
        appFooterInner.removeAll();
        appFooterInner.add(components);
    }
    private void setAppFooterOuter(Component... components) {
        if (appFooterOuter == null) {
            appFooterOuter = new Div();
            appFooterOuter.addClassName("app-footer-outer");
            getElement().insertChild(getElement().getChildCount(),
                    appFooterOuter.getElement());
        }
        appFooterOuter.removeAll();
        appFooterOuter.add(components);
    }

}
