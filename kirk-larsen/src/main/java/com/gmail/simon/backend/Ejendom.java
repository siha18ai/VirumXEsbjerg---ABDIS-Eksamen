package com.gmail.simon.backend;

import com.gmail.simon.ui.util.UIUtils;
import com.gmail.simon.ui.util.css.lumo.BadgeColor;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class Ejendom {

    private Status status;
    private String ejerNavn;
    private String kommuneNr;
    private String adresse;
    private String ejendomsNr;
    private String grundAreal;

    public enum Status {
        VENTER(VaadinIcon.CLOCK,
                "Venter", "Bruger oprettet, men ikke godkendt.",
                BadgeColor.CONTRAST),
        GODKENDT(VaadinIcon.CHECK,
                "Godkendt", "Bruger godkendt succesfuldt",
                BadgeColor.SUCCESS),
        FEJLET(VaadinIcon.WARNING,
				"Fejlet", "Payment failed.",
               BadgeColor.ERROR);

        private VaadinIcon icon;
        private String name;
        private String desc;
        private BadgeColor theme;

        Status(VaadinIcon icon, String name, String desc, BadgeColor theme) {
            this.icon = icon;
            this.name = name;
            this.desc = desc;
            this.theme = theme;
        }
        public Icon getIcon() {
            Icon icon;
            switch (this) {
                case VENTER:
                    icon = UIUtils.createSecondaryIcon(this.icon);
                    break;
                case GODKENDT:
                    icon = UIUtils.createSuccessIcon(this.icon);
                    break;
                default:
                    icon = UIUtils.createErrorIcon(this.icon);
            }
            return icon;
        }

        public String getName() {
            return name;
        }

        public String getDesc() {
            return desc;
        }

        public BadgeColor getTheme() {
            return theme;
        }
    }
    public Ejendom(Status status, String ejerNavn, String kommuneNr, String adresse, String ejendomsNr, String grundAreal) {
        this.status = status;
        this.ejerNavn = ejerNavn;
        this.kommuneNr = kommuneNr;
        this.adresse = adresse;
        this.ejendomsNr = ejendomsNr;
        this.grundAreal = grundAreal;
    }

    public String getAdresse() {
        return adresse;
    }

    public Status getStatus() {
        return status;
    }

    public String getEjerNavn() {
        return ejerNavn;
    }

    public String getKommuneNr() {
        return kommuneNr;
    }

    public String getEjendomsNr() {
        return ejendomsNr;
    }

    public String getGrundAreal() {
        return grundAreal;
    }
}
