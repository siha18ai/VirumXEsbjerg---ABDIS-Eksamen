package com.gmail.simon.ui.views.medarbejderView;

import com.gmail.simon.backend.Konsulenter2;
import com.gmail.simon.backend.database.Data;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.components.Initials;
import com.gmail.simon.ui.components.ListItem;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Right;
import com.gmail.simon.ui.layout.size.Top;
import com.gmail.simon.ui.layout.size.Vertical;
import com.gmail.simon.ui.util.css.BoxSizing;
import com.gmail.simon.ui.views.SplitViewFrame;
import com.gmail.simon.ui.views.mainViews.MedarbejderLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "medarbejder", layout = MedarbejderLayout.class)
@PageTitle("Konsulenter")
public class Konsulenter extends SplitViewFrame {

    private Grid<Konsulenter2> grid;
    private ListDataProvider<Konsulenter2> dataProvider;

    public Konsulenter() {
        setViewContent(createContent());
        filter();

    }
    private Component createContent() {
        FlexBoxLayout content = new FlexBoxLayout(createGrid());
        content.setBoxSizing(BoxSizing.BORDER_BOX);
        content.setHeightFull();
        content.setPadding(Horizontal.RESPONSIVE_X, Top.RESPONSIVE_X);
        return content;
    }

    private Grid createGrid() {
        grid = new Grid<>();
        dataProvider = DataProvider.ofCollection(Data.getmedarbejdere());
        grid.setDataProvider(dataProvider);
        grid.setSizeFull();

        grid.addColumn(Konsulenter2::getUsername)
                .setAutoWidth(true)
                .setHeader("Username");
        grid.addColumn(Konsulenter2::getPassword)
                .setAutoWidth(true)
                .setHeader("Password");
        grid.addColumn(new ComponentRenderer<>(this::createUserInfo))
                .setAutoWidth(true)
                .setHeader("Name");
        return grid;
    }

    private Component createUserInfo(Konsulenter2 konsulenter2) {
            ListItem item = new ListItem(
                    new Initials(konsulenter2.getUsername()), konsulenter2.getPassword());
            item.setPadding(Vertical.XS);
            item.setSpacing(Right.M);
            return item;

    }
    private void filter() {
        //dataProvider.setFilterByValue(Konsulenter2::getRolle, Konsulenter2.Role.ADVOKAT);
    }

}
