package com.gmail.simon.backend;

public class Konsulenter2 {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAnsat() {
        return ansat;
    }

    public void setAnsat(boolean ansat) {
        this.ansat = ansat;
    }

    public int getArtikel() {
        return artikel;
    }

    public void setArtikel(int artikel) {
        this.artikel = artikel;
    }

    public boolean isKonsulentEllerAdvokat() {
        return konsulentEllerAdvokat;
    }

    public void setKonsulentEllerAdvokat(boolean konsulentEllerAdvokat) {
        this.konsulentEllerAdvokat = konsulentEllerAdvokat;
    }

    public Konsulenter2(int id, String password, String username, boolean ansat, int artikel, boolean konsulentEllerAdvokat) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.ansat = ansat;
        this.artikel = artikel;
        this.konsulentEllerAdvokat = konsulentEllerAdvokat;
    }
    public Konsulenter2(){}

    private int id;
    private String password;
    private String username;
    private boolean ansat;
    private int artikel;
    private boolean konsulentEllerAdvokat;
}
