package com.gmail.simon.ui.views.kundeView;

import com.gmail.simon.backend.Ejendom2;
import com.gmail.simon.ui.views.ViewFrameUser;
import com.gmail.simon.ui.views.mainViews.KundeLayout;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;

@PageTitle("Bruger ejendom")
@Route(value = "brugerejendom", layout = KundeLayout.class)
public class UserEjendom extends ViewFrameUser {

    private Ejendom2 ejendom;

    public UserEjendom() {

    }
/*
    private FormLayout createDetails() {
        IntegerField id = new IntegerField();
        id.setValue(ejendom.getPerson_id());
        id.setWidthFull();
    }
*/
}
