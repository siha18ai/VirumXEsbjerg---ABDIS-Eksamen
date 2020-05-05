package com.gmail.simon.ui.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.gmail.simon.ui.MainLayout;
import com.gmail.simon.ui.components.FlexBoxLayout;
import com.gmail.simon.ui.layout.size.Horizontal;
import com.gmail.simon.ui.layout.size.Right;
import com.gmail.simon.ui.layout.size.Uniform;
import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.FlexDirection;
import com.gmail.simon.ui.util.css.FlexWrap;

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
public class Home extends ViewFrame {

	public Home() {
		setId("home");
		setViewContent(createContent());
	}

	private Component createContent() {
		Html velkommen = new Html("<h1> Velkommen - Undrer du dig over din grundskyld?</h1>");

		Html body = new Html("<p>Opret dig <b>gratis</b> og få hjælp fra en af vores yderst professionelle advokater," +
				" der har flere års erfaring på ejendomsområdet.");

		Html productivity = new Html("<p>Vi har nogle af Danmarks førende advokater indenfor ejendomsloven" +
				" og har været behjælpelig med skattenedsættelser på ejendomme, heri specielt ejendomme der " +
				"hører under etagearealprincippet i forbindelse med ejendomsvurderingloven.</p>");

		Html features = new Html("<p>Vi er topmotiveret for at yde en indsats for din ejendom, og du må endelig" +
				" gerne rette henvendelse til os. Vores oplysninger kan findes ved at trykke på ovenstående navne du vil" +
				" rette henvendelse til." +
				"\nØnsker du at vide mere om \t<a href=\"http://localhost:8080/About\">os</a> er du mere end velkommen" +
				" til at læse om os. For at vi kan hjælpe dig må du oprette en bruger:</p>");

		Anchor documentation = new Anchor("http://localhost:8080/login-again", UIUtils.createButton("Login", VaadinIcon.EXTERNAL_LINK));
		Anchor starter = new Anchor("http://localhost:8080/sign-up-frame", UIUtils.createButton("Opret dig", VaadinIcon.EXTERNAL_LINK));

		FlexBoxLayout links = new FlexBoxLayout(documentation, starter);
		links.setFlexWrap(FlexWrap.WRAP);
		links.setSpacing(Right.S);

		FlexBoxLayout content = new FlexBoxLayout(velkommen, body, productivity, features, links);
		content.setFlexDirection(FlexDirection.COLUMN);
		content.setMargin(Horizontal.AUTO);
		content.setMaxWidth("840px");
		content.setPadding(Uniform.RESPONSIVE_L);
		return content;
	}

}
