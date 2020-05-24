package com.gmail.simon.backend;

import java.time.LocalDate;

public class Ordre {

    private String navn;
    private String emne;
    private String beskrivelse;
    private String telefon;

    public Ordre(String navn, String emne, String beskrivelse, String telefon) {
        this.navn = navn;
        this.emne = emne;
        this.beskrivelse = beskrivelse;
        this.telefon = telefon;

    }

    public Ordre() {

    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEmne() {
        return emne;
    }

    public void setEmne(String emne) {
        this.emne = emne;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
