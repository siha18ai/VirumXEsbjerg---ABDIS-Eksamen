package com.gmail.simon.backend;

public class Kunde {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Kunde(int id, String first_name, String last_name, String email, String username, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public Kunde(){}

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    private String password;
    private String telefon;
    private String vejnavn;
    private String etage;
    private int husnummer;
    private boolean boligLejlighed;
    private int ejendom;
    private boolean randomBoolean;

    public boolean isLogedin() {
        return logedin;
    }

    public void setLogedin(boolean logedin) {
        this.logedin = logedin;
    }

    private boolean logedin;


    public Kunde(int id, String first_name, String last_name, String email, String username, String password,
                 String telefon, String vejnavn, String etage, int husnummer, boolean boligLejlighed,
                 boolean ejendomGodkendt, int ejendom, boolean logedin) {

    }

    public Kunde(int id, String first_name, String last_name, String email, String username, String password,
                 String telefon, String vejnavn, int etage, int husnummer, boolean boligLejlighed,
                 boolean ejendomGodkendt, int ejendom, boolean logedin, boolean randomBoolean) {

        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.telefon = telefon;
        this.vejnavn = vejnavn;
        this.husnummer = husnummer;
        this.boligLejlighed = boligLejlighed;
        this.ejendomGodkendt = ejendomGodkendt;
        this.ejendom = ejendom;
        this.logedin = logedin;
        this.randomBoolean = randomBoolean;
    }

    private boolean ejendomGodkendt;

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getVejnavn() {
        return vejnavn;
    }

    public void setVejnavn(String vejnavn) {
        this.vejnavn = vejnavn;
    }

    public String getEtage() {
        return etage;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public int getHusnummer() {
        return husnummer;
    }

    public void setHusnummer(int husnummer) {
        this.husnummer = husnummer;
    }

    public boolean isBoligLejlighed() {
        return boligLejlighed;
    }

    public void setBoligLejlighed(boolean boligLejlighed) {
        this.boligLejlighed = boligLejlighed;
    }

    public boolean isEjendomGodkendt() {
        return ejendomGodkendt;
    }

    public void setEjendomGodkendt(boolean ejendomGodkendt) {
        this.ejendomGodkendt = ejendomGodkendt;
    }

    public int getEjendom() {
        return ejendom;
    }

    public void setEjendom(int ejendom) {
        this.ejendom = ejendom;
    }

    public boolean isRandomBoolean() {
        return randomBoolean;
    }
}
