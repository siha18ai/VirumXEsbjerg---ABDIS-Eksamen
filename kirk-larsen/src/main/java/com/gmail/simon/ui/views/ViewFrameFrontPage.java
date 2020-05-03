package com.gmail.simon.ui.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.Div;

public class ViewFrameFrontPage extends Composite<Div> implements HasStyle {

    private String CLASS_NAME = "view-frame-frontpage";

    private Div header;
    private Div content;
    private Div footer;

    public ViewFrameFrontPage() {
        setClassName(CLASS_NAME);

        content = new Div();
        content.setClassName(CLASS_NAME + "__content");

        header = new Div();
        header.setClassName(CLASS_NAME + "_header");

        getContent().add(header, content);
    }
    public void setViewContent(Component... components) {
        content.removeAll();
        content.add(components);
    }
    public void setViewHeader(Component... components){
        header.removeAll();
        header.add(components);
    }
}
