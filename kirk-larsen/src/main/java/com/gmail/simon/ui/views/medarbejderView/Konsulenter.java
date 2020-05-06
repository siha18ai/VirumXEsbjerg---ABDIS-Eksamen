package com.gmail.simon.ui.views.medarbejderView;

import com.gmail.simon.backend.DummyData;
import com.gmail.simon.backend.Person;
import com.gmail.simon.ui.views.mainViews.MainLayout;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.components.Initials;
import com.gmail.simon.ui.components.ListItem;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Right;
import com.gmail.simon.ui.layout.size.Top;
import com.gmail.simon.ui.layout.size.Vertical;
import com.gmail.simon.ui.util.css.BoxSizing;
import com.gmail.simon.ui.views.SplitViewFrame;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "medarbejder", layout = MainLayout.class)
@PageTitle("Konsulenter")
public class Konsulenter extends SplitViewFrame {

    private Grid<Person> grid;
    private ListDataProvider<Person> dataProvider;

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
        dataProvider = DataProvider.ofCollection(DummyData.getPersons());
        grid.setDataProvider(dataProvider);
        grid.setSizeFull();

        grid.addColumn(Person::getId)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setFrozen(true)
                .setHeader("ID")
                .setSortable(true);
        grid.addColumn(new ComponentRenderer<>(this::createUserInfo))
                .setAutoWidth(true)
                .setHeader("Name");
        return grid;
    }

    private Component createUserInfo(Person person) {
        ListItem item = new ListItem(
                new Initials(person.getInitials()), person.getName(), person.getEmail());
        item.setPadding(Vertical.XS);
        item.setSpacing(Right.M);
        return item;

    }
    private void filter() {
        dataProvider.setFilterByValue(Person::getRole, Person.Role.TRADER);
    }

}
