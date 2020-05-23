package com.gmail.simon.backend.database;
import com.gmail.simon.backend.Artikler;
import com.gmail.simon.backend.Ejendom2;
import com.gmail.simon.backend.Konsulenter2;
import com.gmail.simon.backend.Kunde;

import java.sql.*;
import java.util.*;

public class Data {
    private static Connection myCon;

    public Data(){
        getConnection();
    }

    private static Connection getConnection() {
        try {
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "pass123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myCon;
    }


    public static ArrayList<Konsulenter2> getkonsultner(){
        ResultSet resultSet = null;
        ArrayList<Konsulenter2> konsulenters = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement ps = getConnection().prepareStatement("select * FROM kirk_larsen.medarbejder");
            resultSet = ps.executeQuery();

            while (resultSet.next()){
                Konsulenter2 konsulenter2 = new Konsulenter2();
                konsulenter2.setRolle(resultSet.getString("Role"));
                konsulenter2.setUsername(resultSet.getString("Username"));
                konsulenter2.setPassword(resultSet.getString("Password"));
                konsulenters.add(konsulenter2);
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return konsulenters;
    }
    public static ArrayList<Ejendom2> getEjendomme(){
        ResultSet resultSet = null;
        ArrayList<Ejendom2> ejendomme = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement ps = getConnection().prepareStatement("select * FROM kirk_larsen.adresse");
            resultSet = ps.executeQuery();

            while (resultSet.next()){
                Ejendom2 ejendom = new Ejendom2();
                ejendom.setPerson_id(resultSet.getInt("Person_Id"));
                ejendom.setEjd_nr(resultSet.getInt("Ejd_nr"));
                ejendom.setKommune(resultSet.getString("Kommune"));
                ejendom.setVej_navn(resultSet.getString("Vej_navn"));
                ejendom.setNr(resultSet.getInt("Nr"));
                ejendom.setEtage(resultSet.getInt("Etage"));
                ejendom.setSidedøre_nr(resultSet.getInt("Side_doer_nr"));
                ejendomme.add(ejendom);
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return ejendomme;
    }
    public static ArrayList<Kunde> getKunder(){
        ResultSet resultSet = null;
        ArrayList<Kunde> kunder = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement ps = getConnection().prepareStatement("select * FROM kirk_larsen.kunde");
            resultSet = ps.executeQuery();

            while (resultSet.next()){
                Kunde kunde = new Kunde();
                kunde.setId(resultSet.getInt("Id"));
                kunde.setFirst_name(resultSet.getString("First_name"));
                kunde.setLast_name(resultSet.getString("Last_name"));
                kunde.setEmail(resultSet.getString("Email"));
                kunde.setUsername(resultSet.getString("Username"));
                kunde.setPassword(resultSet.getString("Password"));
                kunder.add(kunde);
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return kunder;
    }
    public static ArrayList<Artikler> getArtikler() {
        ResultSet resultSet = null;
        ArrayList<Artikler> artikler = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement ps = getConnection().prepareStatement("SELECT*FROM kirk_larsen.artikler");
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Artikler artikler1 = new Artikler();
                artikler1.setArtikel_id(resultSet.getInt("artikel_id"));
                artikler1.setEmne(resultSet.getString("emne"));
                artikler1.setTekst(resultSet.getString("tekst"));
                artikler1.setDato(resultSet.getTimestamp("dato"));
                artikler.add(artikler1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return artikler;
    }


}
