package com.gmail.simon.ui.views.kundeView;

import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Uniform;
import com.gmail.simon.ui.util.LumoStyles;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.views.ViewFrameUser;
import com.gmail.simon.ui.views.mainViews.KundeLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Ny ordre")
@Route(value = "nyordre", layout = KundeLayout.class)
public class nyOrdre extends ViewFrameUser {


    public nyOrdre() {
        setViewContent(createHeader(), createContent());
    }

    private Component createHeader() {
        Html header = new Html("<h2> Opret en ny ordre </h2>");

        FlexBoxLayout content = new FlexBoxLayout(header);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("600px");
        content.setPadding(Uniform.RESPONSIVE_L);
        return content;
    }

    private Component createContent() {
        FormLayout formLayout = createDetails();

        FlexBoxLayout content = new FlexBoxLayout(formLayout);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("1000px");
        content.setPadding(Uniform.RESPONSIVE_L);
        return content;
    }

    private FormLayout createDetails() {
        TextField navn = new TextField();
        navn.setPlaceholder("Sir");

        TextField emne = new TextField();
        emne.setPlaceholder("Fx. Ejendomsbeskatning");

        TextField beskrivelse= new TextField();
        beskrivelse.setPlaceholder("Fx. Jeg ønsker hjælp til min grundskyld");
        beskrivelse.setWidthFull();
        beskrivelse.setHeightFull();

        TextField telefon = new TextField();
        telefon.setPlaceholder("Skriv dit Telefonnummer her");

        FormLayout form = new FormLayout();
        form.addClassNames(LumoStyles.Padding.Bottom.L,
                LumoStyles.Padding.Horizontal.L, LumoStyles.Padding.Top.S);
        form.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("21em", 2,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP));
        form.addFormItem(navn, "Dit navn");
        form.addFormItem(emne, "Emne");
        form.addFormItem(beskrivelse, "Beskrivelse");
        form.addFormItem(telefon, "Telefon");

        return form;
    }
}
