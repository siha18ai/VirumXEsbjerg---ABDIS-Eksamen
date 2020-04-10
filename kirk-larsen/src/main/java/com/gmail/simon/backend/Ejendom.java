package com.gmail.simon.backend;

public class Ejendom {

    private long id;
    private int kommuneNr;
    private String adresse;
    private long ejendomsNr;
    private int grundAreal;

    public Ejendom(long id, int kommuneNr, String adresse, long ejendomsNr, int grundAreal) {
        this.id = id;
        this.kommuneNr = kommuneNr;
        this.adresse = adresse;
        this.ejendomsNr = ejendomsNr;
        this.grundAreal = grundAreal;
    }

    public long getId() {
        return id;
    }

    public int getKommuneNr() {
        return kommuneNr;
    }

    public String getAdresse() {
        return adresse;
    }

    public long getEjendomsNr() {
        return ejendomsNr;
    }

    public int getGrundAreal() {
        return grundAreal;
    }
}
