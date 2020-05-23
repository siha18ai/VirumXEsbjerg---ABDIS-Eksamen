package com.gmail.simon.backend;

public class Ejendom2 {

    public int getEjd_nr() {
        return Ejd_nr;
    }

    public void setEjd_nr(int ejd_nr) {
        Ejd_nr = ejd_nr;
    }

    public boolean isRegistrering() {
        return registrering;
    }

    public void setRegistrering(boolean registrering) {
        this.registrering = registrering;
    }

    public double getGrundvaerdi() {
        return grundvaerdi;
    }

    public void setGrundvaerdi(double grundvaerdi) {
        this.grundvaerdi = grundvaerdi;
    }

    public int getMaksimalBebyggelse() {
        return maksimalBebyggelse;
    }

    public void setMaksimalBebyggelse(int maksimalBebyggelse) {
        this.maksimalBebyggelse = maksimalBebyggelse;
    }

    public int getEtageArealPris() {
        return etageArealPris;
    }

    public void setEtageArealPris(int etageArealPris) {
        this.etageArealPris = etageArealPris;
    }

    public int getSamletAreal() {
        return samletAreal;
    }

    public void setSamletAreal(int samletAreal) {
        this.samletAreal = samletAreal;
    }

    public int getFaktiskGrundAreal() {
        return faktiskGrundAreal;
    }

    public void setFaktiskGrundAreal(int faktiskGrundAreal) {
        this.faktiskGrundAreal = faktiskGrundAreal;
    }

    public int getGrundskyldPromille() {
        return grundskyldPromille;
    }

    public void setGrundskyldPromille(int grundskyldPromille) {
        this.grundskyldPromille = grundskyldPromille;
    }

    private int Ejd_nr;
    private boolean registrering;
    private double grundvaerdi;
    private int maksimalBebyggelse;
    private int etageArealPris;
    private int samletAreal;
    private int faktiskGrundAreal;

    public Ejendom2(int ejd_nr, boolean registrering, double grundvaerdi, int maksimalBebyggelse, int etageArealPris, int samletAreal, int faktiskGrundAreal, int grundskyldPromille) {
        Ejd_nr = ejd_nr;
        this.registrering = registrering;
        this.grundvaerdi = grundvaerdi;
        this.maksimalBebyggelse = maksimalBebyggelse;
        this.etageArealPris = etageArealPris;
        this.samletAreal = samletAreal;
        this.faktiskGrundAreal = faktiskGrundAreal;
        this.grundskyldPromille = grundskyldPromille;
    }
    public Ejendom2(){}

    private int grundskyldPromille;


}
