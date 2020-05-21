package com.gmail.simon.ui.views.kundeView;

import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.layout.size.Bottom;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Right;
import com.gmail.simon.ui.util.IconSize;
import com.gmail.simon.ui.util.LumoStyles;
import com.gmail.simon.ui.util.TextColor;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.BorderRadius;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.util.css.Shadow;
import com.gmail.simon.ui.views.ViewFrameKunde;
import com.gmail.simon.ui.views.mainViews.KundeLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.board.Row;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./styles/views/statistics.css")
@PageTitle("Ordre")
@Route(value = "ordre", layout = KundeLayout.class)
public class Ordre extends ViewFrameKunde {

    private static final String CLASS_NAME = "ordre";
    public static final String MAX_WIDTH = "1024px";

    public Ordre() {
        setViewContent(createContent());
    }

    private Component createContent() {

        Component ordre = createDocs();

        FlexBoxLayout content = new FlexBoxLayout(ordre);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setFlexDirection(FlexDirection.COLUMN);
        return content;
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
        for (String label : new String[]{"Nye", "Gamle"}) {
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
