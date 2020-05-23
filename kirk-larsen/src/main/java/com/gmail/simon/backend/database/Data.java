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
            PreparedStatement ps = getConnection().prepareStatement("select * FROM kirk_larsen.ejendomme");
            resultSet = ps.executeQuery();

            while (resultSet.next()){
                Ejendom2 ejendom = new Ejendom2();
                ejendom.setEjd_nr(resultSet.getInt("ejendom_nr"));
                ejendom.setRegistrering(resultSet.getBoolean("registrering"));
                ejendom.setGrundvaerdi(resultSet.getInt("grundvaerdi"));
                ejendom.setMaksimalBebyggelse(resultSet.getInt("maksimalBebyggelse"));
                ejendom.setEtageArealPris(resultSet.getInt("etageArealPris"));
                ejendom.setSamletAreal(resultSet.getInt("samletAreal"));
                ejendom.setFaktiskGrundAreal(resultSet.getInt("faktiskGrundAreal"));
                ejendom.setGrundskyldPromille(resultSet.getInt("grundskyldPromille"));
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
                kunde.setId(resultSet.getInt("id"));
                kunde.setFirst_name(resultSet.getString("fornavn"));
                kunde.setLast_name(resultSet.getString("efternavn"));
                kunde.setEmail(resultSet.getString("email"));
                kunde.setUsername(resultSet.getString("username"));
                kunde.setPassword(resultSet.getString("password"));
                kunde.setEtage(resultSet.getString("etage"));
                kunde.setHusnummer(resultSet.getInt("husnr"));
                kunde.setBoligLejlighed(resultSet.getBoolean("boligLejlighed"));
                kunde.setEjendomGodkendt(resultSet.getBoolean("ejendomGodkendt"));
                kunde.setEjendom(resultSet.getInt("ejendom"));
                kunde.setTelefon(resultSet.getString("telefon"));
                kunder.add(kunde);
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return kunder;
    }

    public boolean createEjendom() throws IllegalArgumentException {
        try {
            PreparedStatement createEjendom = getConnection().prepareStatement("INSERT INTO `kirk_larsen`.`ejendomme` " +
                    "(`registrering`, `grundvaerdi`, `maksimalBebyggelse`, `etageArealPris`, `samletAreal`, " +
                    "`faktiskGrundAreal`, `grundskyldPromille`) VALUES ('0', '0', '0', '0', '0', '0', '0');");

            int rowAffected = createEjendom.executeUpdate();
            if (rowAffected == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean createKunde(Kunde kunde) throws IllegalArgumentException {
        try {
            PreparedStatement createKunde = getConnection().prepareStatement("INSERT INTO `kirk_larsen`.`kunde` " +
                    "(`username`, `password`, `fornavn`, `efternavn`, `telefon`, `vejnavn`, `email`, `etage`, `husnr`, " +
                    "`boligLejlighed`, `ejendomGodkendt`, `ejendom`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

            createKunde.setString(1, kunde.getUsername());
            createKunde.setString(2, kunde.getPassword());
            createKunde.setString(3, kunde.getFirst_name());
            createKunde.setString(4, kunde.getLast_name());
            createKunde.setString(5, kunde.getTelefon());
            createKunde.setString(6, kunde.getVejnavn());
            createKunde.setString(7, kunde.getEmail());
            createKunde.setString(8, kunde.getEtage());
            createKunde.setInt(9, kunde.getHusnummer());
            createKunde.setBoolean(10, kunde.isBoligLejlighed());
            createKunde.setBoolean(11, kunde.isEjendomGodkendt());
            createKunde.setInt(12, kunde.getEjendom());
            int rowAffected = createKunde.executeUpdate();
            if (rowAffected == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
