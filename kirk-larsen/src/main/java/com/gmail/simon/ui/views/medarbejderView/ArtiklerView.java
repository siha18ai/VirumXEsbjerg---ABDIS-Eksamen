package com.gmail.simon.ui.views.medarbejderView;

import com.gmail.simon.ui.views.SplitViewFrame;
import com.gmail.simon.ui.views.mainViews.MedarbejderLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "artikler", layout = MedarbejderLayout.class)
@PageTitle("Artikler")
public class ArtiklerView extends SplitViewFrame {
}
