package com.gmail.simon.backend;

public class Ejendom2 {
    public Ejendom2(int person_id1, int ejd_nr, String kommune, String vej_navn, int nr, int sidedøre_nr, int etage) {
        this.person_id = person_id1;
        Ejd_nr = ejd_nr;
        this.kommune = kommune;
        this.vej_navn = vej_navn;
        this.nr = nr;
        this.sidedøre_nr = sidedøre_nr;
        this.etage = etage;
    }

    private int person_id;
    private int Ejd_nr;
    private String kommune;
    private String vej_navn;
    private int nr;
    private int sidedøre_nr;
    private int etage;



    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getEjd_nr() {
        return Ejd_nr;
    }

    public void setEjd_nr(int ejd_nr) {
        Ejd_nr = ejd_nr;
    }

    public String getKommune() {
        return kommune;
    }

    public void setKommune(String kommune) {
        this.kommune = kommune;
    }

    public String getVej_navn() {
        return vej_navn;
    }

    public void setVej_navn(String vej_navn) {
        this.vej_navn = vej_navn;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getSidedøre_nr() {
        return sidedøre_nr;
    }

    public void setSidedøre_nr(int sidedøre_nr) {
        this.sidedøre_nr = sidedøre_nr;
    }
    public Ejendom2(){}

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }
}
