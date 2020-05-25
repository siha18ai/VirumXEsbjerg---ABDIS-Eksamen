package com.gmail.simon.backend;

import com.vaadin.flow.component.button.Button;

import java.sql.Timestamp;

public class Artikler {

    private int artikel_id;
    private String emne;
    private String tekst;
    private Timestamp dato;

    public Artikler(int artikel_id, String emne, String tekst, Timestamp dato) {
        this.artikel_id = artikel_id;
        this.emne = emne;
        this.tekst = tekst;
        this.dato = dato;
    }

    public Artikler() {
    }

    public int getArtikel_id() {
        return artikel_id;
    }

    public void setArtikel_id(int artikel_id) {
        this.artikel_id = artikel_id;
    }

    public String getEmne() {
        return emne;
    }

    public void setEmne(String emne) {
        this.emne = emne;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Timestamp getDato() {
        return dato;
    }

    public void setDato(Timestamp dato) {
        this.dato = dato;
    }
}
