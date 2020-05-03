package com.gmail.simon.ui.components.navigation.bar;

import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.components.navigation.tab.NaviTab;
import com.gmail.simon.ui.util.UIUtils;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;

import java.awt.*;

import static com.gmail.simon.ui.util.UIUtils.IMG_PATH;

@CssImport("./styles/components/app-bar.css")

public class OuterBar extends FlexBoxLayout {
    private String CLASS_NAME = "outerBar";

    public Image getKirkLarsen() {
        return kirkLarsen;
    }

    private Image kirkLarsen;

    public enum NaviMode {
        MENU, CONTEXTUAL
    }

    public OuterBar() {
        setClassName(CLASS_NAME);
        initPicture();
    }
    public void initPicture(){
        kirkLarsen = new Image();
        kirkLarsen.setClassName(CLASS_NAME);
        kirkLarsen.setSrc(IMG_PATH+"logos/Kirk-Larsen-logo.png");
        kirkLarsen.setAlt("User menu");
    }
}
