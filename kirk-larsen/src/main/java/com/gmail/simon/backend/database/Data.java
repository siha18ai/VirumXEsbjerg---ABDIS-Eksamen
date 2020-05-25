package com.gmail.simon.backend.database;
import com.gmail.simon.backend.*;
import com.vaadin.flow.component.html.Pre;

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

    public static ArrayList<Konsulenter2> getmedarbejdere(){
        ResultSet resultSet = null;
        ArrayList<Konsulenter2> konsulenters = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement ps = getConnection().prepareStatement("select * FROM kirk_larsen.medarbejder");
            resultSet = ps.executeQuery();

            while (resultSet.next()){
                Konsulenter2 konsulenter2 = new Konsulenter2();
                konsulenter2.setUsername(resultSet.getString("username"));
                konsulenter2.setPassword(resultSet.getString("password"));
                konsulenter2.setAnsat(resultSet.getBoolean("ansat"));
                konsulenter2.setArtikel(resultSet.getInt("artikel"));
                konsulenter2.setKonsulentEllerAdvokat(resultSet.getBoolean("konsulentEllerAdvokat"));
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
                kunde.setLogedin(resultSet.getBoolean("logedin"));
                kunde.setVejnavn(resultSet.getString("vejnavn"));
                kunder.add(kunde);
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return kunder;
    }
    public boolean updateKunde(Kunde kunde) throws IllegalArgumentException{
        try{
            PreparedStatement updateCustomer = getConnection().prepareStatement("UPDATE `kirk_larsen`.`kunde` SET " +
                    "`vejnavn` = ?, `etage` = ?, `husnr` = ? WHERE (`id` = ?);");
            updateCustomer.setString(1, kunde.getVejnavn());
            updateCustomer.setString(2, kunde.getEtage());
            updateCustomer.setInt(3, kunde.getHusnummer());
            updateCustomer.setInt(4, kunde.getId());
            int roweffected = updateCustomer.executeUpdate();
            if(roweffected == 1){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateKunde2(Kunde kunde) throws IllegalArgumentException{
        try{
            PreparedStatement updateCustomer = getConnection().prepareStatement("UPDATE `kirk_larsen`.`kunde` SET " +
                    "`username` = ?, `password` = ? WHERE (`id` = ?);");
            updateCustomer.setString(1, kunde.getUsername());
            updateCustomer.setString(2, kunde.getPassword());
            updateCustomer.setInt(3, kunde.getId());
            int roweffected = updateCustomer.executeUpdate();
            if(roweffected == 1){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateKunde3(Kunde kunde) throws IllegalArgumentException{
        try {
            PreparedStatement setEjendom = getConnection().prepareStatement("UPDATE `kirk_larsen`.`kunde` SET " +
                    "`ejendom` = ? WHERE (`id` = ?);");
            setEjendom.setInt(1, kunde.getEjendom());
            setEjendom.setInt(2, kunde.getId());
            int rowaffected = setEjendom.executeUpdate();
            if(rowaffected == 1){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean setLoggedin (Kunde kunde, boolean logedin) {
        try {
            PreparedStatement setLogedIn = getConnection().prepareStatement("UPDATE `kirk_larsen`.`kunde` SET " +
                    "`logedin` = ? WHERE (`id` = ?);");
            setLogedIn.setBoolean(1, logedin);
            setLogedIn.setInt(2, kunde.getId());
            int rowAffected = setLogedIn.executeUpdate();
            if(rowAffected == 1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
                    "`boligLejlighed`, `ejendomGodkendt`, `ejendom`, `logedin`) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);");

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
            createKunde.setBoolean(13, kunde.isLogedin());
            int rowAffected = createKunde.executeUpdate();
            if (rowAffected == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean createOrdre(Ordre ordre) throws IllegalArgumentException {
        try {
            PreparedStatement createOrdre = getConnection().prepareStatement("INSERT INTO `kirk_larsen`.`ordre` " +
                    "(`emne`, `beskrivelse`, `telefon`, `kunde`) VALUES (?,?,?,?);");

            createOrdre.setString(1, ordre.getEmne());
            createOrdre.setString(2, ordre.getBeskrivelse());
            createOrdre.setString(3, ordre.getTelefon());
            createOrdre.setInt(4, ordre.getKunde());

            int rowAffected = createOrdre.executeUpdate();

            if (rowAffected == 1 ) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static ArrayList<Ejendom2> getEjendom() {
        ResultSet resultSet = null;
        ArrayList<Ejendom2> ejendom2s = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement ps = getConnection().prepareStatement("SELECT ejendomme.ejendom_nr, ejendomme.grundvaerdi, " +
                    "ejendomme.maksimalBebyggelse, ejendomme.etageArealPris, ejendomme.samletAreal, ejendomme.faktiskGrundAreal, " +
                    "ejendomme.grundskyldPromille" +
                    "\nFROM ejendomme" +
                    "\nINNER JOIN kunde" +
                    "\nON ejendomme.ejendom_nr = kunde.id" +
                    "\nWHERE kunde.id = ?");
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Ejendom2 ejendom2 = new Ejendom2();
                ejendom2.setEjd_nr(resultSet.getInt("Ejendom_nr"));
                ejendom2.setGrundvaerdi(resultSet.getDouble("grundvaerdi"));
                ejendom2.setMaksimalBebyggelse(resultSet.getInt("maksimalBebyggelse"));
                ejendom2.setEtageArealPris(resultSet.getInt("etageArealPris"));
                ejendom2.setSamletAreal(resultSet.getInt("samletAreal"));
                ejendom2.setFaktiskGrundAreal(resultSet.getInt("faktiskGrundAreal"));
                ejendom2.setGrundskyldPromille(resultSet.getInt("grundskyldPromille"));
                ejendom2s.add(ejendom2);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ejendom2s;

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

    public static ArrayList<Ordre> getOrdre(){
        ResultSet resultSet = null;
        ArrayList<Ordre> ordres = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement ps = getConnection().prepareStatement("SELECT*FROM kirk_larsen.ordre");
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Ordre ordre = new Ordre();
                ordre.setId(resultSet.getInt("ordre_nr"));
                ordre.setEmne(resultSet.getString("emne"));
                ordre.setBeskrivelse(resultSet.getString("beskrivelse"));
                ordre.setTelefon(resultSet.getString("telefon"));
                ordre.setKunde(resultSet.getInt("kunde"));
                ordre.setMedarbejder(resultSet.getInt("medarbejder"));
                ordres.add(ordre);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ordres;
    }
    public static ArrayList<Ordre> getOrdreforKunde(Kunde kunde){
        ResultSet resultSet = null;
        ArrayList<Ordre> ordres = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement ps = getConnection().prepareStatement("SELECT*FROM kirk_larsen.ordre WHERE kunde = ?");
            ps.setInt(1, kunde.getId());
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Ordre ordre = new Ordre();
                ordre.setId(resultSet.getInt("ordre_nr"));
                ordre.setEmne(resultSet.getString("emne"));
                ordre.setBeskrivelse(resultSet.getString("beskrivelse"));
                ordre.setTelefon(resultSet.getString("telefon"));
                ordre.setKunde(resultSet.getInt("kunde"));
                ordre.setMedarbejder(resultSet.getInt("medarbejder"));
                ordres.add(ordre);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ordres;
    }
    public boolean createArtikel(Artikler artikel)throws IllegalArgumentException{
        try {
            PreparedStatement createArtikel = getConnection().prepareStatement("INSERT INTO `kirk_larsen`.`artikler` " +
                    "(`emne`, `tekst`, `dato`) VALUES (?, ?, CURDATE());");

            createArtikel.setString(1, artikel.getEmne());
            createArtikel.setString(2, artikel.getTekst());

            int rowAffected = createArtikel.executeUpdate();

            if(rowAffected == 1){
                return true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteArtikel(Artikler artikler) throws IllegalArgumentException{
        try {
            PreparedStatement deleteArtikel = getConnection().prepareStatement("DELETE FROM artikler where artikel_id = ?;");

            deleteArtikel.setInt(1, artikler.getArtikel_id());

            int rowAffected = deleteArtikel.executeUpdate();

            if(rowAffected == 1){
                return true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateKundeInformation(Kunde kunde)throws IllegalArgumentException{
        try {
            PreparedStatement updateKunde = getConnection().prepareStatement("UPDATE `kirk_larsen`.`kunde` SET " +
                    "`username` = ?, `password` = ?, `fornavn` = ?, `telefon` = ?, `email` " +
                    "= ? WHERE (`id` = ?);");

            updateKunde.setString(1, kunde.getUsername());
            updateKunde.setString(2, kunde.getPassword());
            updateKunde.setString(3, kunde.getFirst_name());
            updateKunde.setString(4, kunde.getTelefon());
            updateKunde.setString(5, kunde.getEmail());
            updateKunde.setInt(6, kunde.getId());

            int rowAffected = updateKunde.executeUpdate();
            if(rowAffected == 1){
                return true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
