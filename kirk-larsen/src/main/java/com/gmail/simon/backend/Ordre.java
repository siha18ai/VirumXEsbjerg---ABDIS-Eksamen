package com.gmail.simon.backend;

import java.time.LocalDate;

public class Ordre {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getKunde() {
        return kunde;
    }

    public void setKunde(int kunde) {
        this.kunde = kunde;
    }

    public int getMedarbejder() {
        return medarbejder;
    }

    public void setMedarbejder(int medarbejder) {
        this.medarbejder = medarbejder;
    }

    public Ordre(int id, String emne, String beskrivelse, String telefon, int kunde, int medarbejder) {
        this.id = id;
        this.emne = emne;
        this.beskrivelse = beskrivelse;
        this.telefon = telefon;
        this.kunde = kunde;
        this.medarbejder = medarbejder;
    }
    public Ordre(){}

    private int id;
    private String emne;
    private String beskrivelse;
    private String telefon;
    private int kunde;
    private int medarbejder;


}
