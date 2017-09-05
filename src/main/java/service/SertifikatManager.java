/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Sertifikati;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.ProizvodjacDocument;
import org.springframework.stereotype.Service;

import static service.DbConnection.getDBConnection;

/**
 *
 * @author nenad
 */
//@Service
public class SertifikatManager {

    ArrayList<Sertifikati> sertifikatManagerList = new ArrayList<Sertifikati>();
    private Integer Id;
    private DbConnection con;

    public SertifikatManager(Integer Id) {
        this.Id = Id;
    }

    public SertifikatManager() {

        try {
            String query = "select * from sertifikati where aktivan = 1 order by id ";
            query
                    = "select DISTINCT * from sertifikati where sertifikati.aktivan = 1 "
                    + "and sertifikati.id IN (SELECT proizvodjac_id from proizvodjac_document "
                    + " where proizvodjac_document.vazi_do >= CURDATE()) order by sertifikati.id";

            System.out.println(query);
            Class.forName("com.mysql.jdbc.Driver");

            try (Connection con = getDBConnection()) {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.executeQuery();
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Sertifikati d = new Sertifikati(
                            rs.getInt("id"),
                            rs.getString("broj_sertifikata"),
                            rs.getInt("proizvodjac_id"),
                            rs.getString("proizvodjac_sifra"),
                            rs.getString("proizvodjac"),
                            rs.getString("proizvodjac_skraceno"),
                            rs.getString("adresa"),
                            rs.getString("ptt_broj"),
                            rs.getString("mesto"),
                            rs.getString("zemlja_sifra"),
                            rs.getString("zemlja"),
                            rs.getInt("id_vrsta_proizvodnje"),
                            rs.getString("sifra_vrsta_proizvodnje"),
                            rs.getString("naziv_vrsta_proizvodnje"),
                            rs.getDate("datum_kontrole"),
                            rs.getString("mesto_izdavanja"),
                            rs.getDate("datum_izdavanja"),
                            rs.getDate("vazi_do"),
                            rs.getString("asortiman"),
                            rs.getString("asortiman_sifra"),
                            rs.getString("tip_sertifikata"),
                            rs.getString("tip_sertifikata_sifra"),
                            rs.getString("rezerva1"),
                            rs.getString("rezerva2"),
                            rs.getString("rezerva3"),
                            rs.getBoolean("aktivan"),
                            rs.getDate("datum_vreme"),
                            rs.getString("sertifikaticol")
                    );

                    sertifikatManagerList.add(d);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {

            int i = 0;
        }
    }

    public List<Sertifikati> getSertifikatList() {
        return sertifikatManagerList;
    }

    public Sertifikati vratiSertifikat(Integer Id) {
        this.Id = Id;
        Sertifikati d = new Sertifikati();
        try {
            String query = "select * from sertifikati where id = " + Id;
            System.out.println(query);
            Class.forName("com.mysql.jdbc.Driver");

            try (Connection con = getDBConnection()) {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.executeQuery();
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    d = new Sertifikati(
                            rs.getInt("id"),
                            rs.getString("broj_sertifikata"),
                            rs.getInt("proizvodjac_id"),
                            rs.getString("proizvodjac_sifra"),
                            rs.getString("proizvodjac"),
                            rs.getString("proizvodjac_skraceno"),
                            rs.getString("adresa"),
                            rs.getString("ptt_broj"),
                            rs.getString("mesto"),
                            rs.getString("zemlja_sifra"),
                            rs.getString("zemlja"),
                            rs.getInt("id_vrsta_proizvodnje"),
                            rs.getString("sifra_vrsta_proizvodnje"),
                            rs.getString("naziv_vrsta_proizvodnje"),
                            rs.getDate("datum_kontrole"),
                            rs.getString("mesto_izdavanja"),
                            rs.getDate("datum_izdavanja"),
                            rs.getDate("vazi_do"),
                            rs.getString("asortiman"),
                            rs.getString("asortiman_sifra"),
                            rs.getString("tip_sertifikata"),
                            rs.getString("tip_sertifikata_sifra"),
                            rs.getString("rezerva1"),
                            rs.getString("rezerva2"),
                            rs.getString("rezerva3"),
                            rs.getBoolean("aktivan"),
                            rs.getDate("datum_vreme"),
                            rs.getString("sertifikaticol")
                    );

                    //   sertifikatManagerList.add(d);
                    return d;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            int i = 0;
        }
        return d;
    }

    public Map<String, String> vratiSertifikate() {

        Map< String, String> sertifikati = new HashMap<>();

        try {
            String query = "select * from sertifikati where aktivan=1";
            System.out.println(query);
            Class.forName("com.mysql.jdbc.Driver");

            try (Connection con = getDBConnection()) {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.executeQuery();
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    sertifikati.put(rs.getString("id"), rs.getString("proizvodjac"));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            int i = 0;
        }
        return sertifikati;

    }

    List<Sertifikati> vratiSertifikateZaProizvodjaca(Integer proizvodjac_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            String query = "select * from sertifikati where proizvodjac_id = " + proizvodjac_id + " and aktivan=1";
            System.out.println(query);
            Class.forName("com.mysql.jdbc.Driver");

            try (Connection con = getDBConnection()) {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.executeQuery();
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Sertifikati d = new Sertifikati(
                            rs.getInt("id"),
                            rs.getString("broj_sertifikata"),
                            rs.getInt("proizvodjac_id"),
                            rs.getString("proizvodjac_sifra"),
                            rs.getString("proizvodjac"),
                            rs.getString("proizvodjac_skraceno"),
                            rs.getString("adresa"),
                            rs.getString("ptt_broj"),
                            rs.getString("mesto"),
                            rs.getString("zemlja_sifra"),
                            rs.getString("zemlja"),
                            rs.getInt("id_vrsta_proizvodnje"),
                            rs.getString("sifra_vrsta_proizvodnje"),
                            rs.getString("naziv_vrsta_proizvodnje"),
                            rs.getDate("datum_kontrole"),
                            rs.getString("mesto_izdavanja"),
                            rs.getDate("datum_izdavanja"),
                            rs.getDate("vazi_do"),
                            rs.getString("asortiman"),
                            rs.getString("asortiman_sifra"),
                            rs.getString("tip_sertifikata"),
                            rs.getString("tip_sertifikata_sifra"),
                            rs.getString("rezerva1"),
                            rs.getString("rezerva2"),
                            rs.getString("rezerva3"),
                            rs.getBoolean("aktivan"),
                            rs.getDate("datum_vreme"),
                            rs.getString("sertifikaticol")
                    );

                    sertifikatManagerList.add(d);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {

            int i = 0;
        }
        return sertifikatManagerList;
    }

    public Integer vratiBrojSertifikataKojeImaProizvodjac(Integer proizvodjac_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            String query = "select count(*) as broj from proizvodjac_document where proizvodjac_id = "
                    + proizvodjac_id + " and aktivan=1" + " and proizvodjac_document.vazi_do >= CURDATE()";
            System.out.println(query);
            Class.forName("com.mysql.jdbc.Driver");

            try (Connection con = getDBConnection()) {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.executeQuery();
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    return rs.getInt("broj");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {

            return 0;
        }
        return 0;
    }

    public List<Sertifikati> getListaProizvodjacaString(String id) {
        ArrayList<Sertifikati> sertifikatManagerList1 = new ArrayList<>();
        try {
            String query = "select * from sertifikati where id='" + id + "' and aktivan=1";
            System.out.println(query);
            Class.forName("com.mysql.jdbc.Driver");

            try (Connection con = getDBConnection()) {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.executeQuery();
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Sertifikati d = new Sertifikati(
                            rs.getInt("id"),
                            rs.getString("broj_sertifikata"),
                            rs.getInt("proizvodjac_id"),
                            rs.getString("proizvodjac_sifra"),
                            rs.getString("proizvodjac"),
                            rs.getString("proizvodjac_skraceno"),
                            rs.getString("adresa"),
                            rs.getString("ptt_broj"),
                            rs.getString("mesto"),
                            rs.getString("zemlja_sifra"),
                            rs.getString("zemlja"),
                            rs.getInt("id_vrsta_proizvodnje"),
                            rs.getString("sifra_vrsta_proizvodnje"),
                            rs.getString("naziv_vrsta_proizvodnje"),
                            rs.getDate("datum_kontrole"),
                            rs.getString("mesto_izdavanja"),
                            rs.getDate("datum_izdavanja"),
                            rs.getDate("vazi_do"),
                            rs.getString("asortiman"),
                            rs.getString("asortiman_sifra"),
                            rs.getString("tip_sertifikata"),
                            rs.getString("tip_sertifikata_sifra"),
                            rs.getString("rezerva1"),
                            rs.getString("rezerva2"),
                            rs.getString("rezerva3"),
                            rs.getBoolean("aktivan"),
                            rs.getDate("datum_vreme"),
                            rs.getString("sertifikaticol")
                    );

                    sertifikatManagerList1.add(d);

                }
            }
        } catch (ClassNotFoundException | SQLException e) {

            int i = 0;
        }
        return sertifikatManagerList1;
    }

    public List<ProizvodjacDocument> getListaSertifikataZaProizvodjacaString(String id) {
        ArrayList<ProizvodjacDocument> sertifikatManagerList1 = new ArrayList<>();
        try {
            String query = "select * from proizvodjac_document where proizvodjac_id='" + id + "' and aktivan=1"
                    + " and proizvodjac_document.vazi_do >= CURDATE()";

            System.out.println(query);
            Class.forName("com.mysql.jdbc.Driver");

            try (Connection con = getDBConnection()) {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.executeQuery();
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    ProizvodjacDocument d = new ProizvodjacDocument(
                            rs.getLong("id"),
                            rs.getInt("user_id"),
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getString("type"),
                            rs.getBytes("content"),
                            rs.getString("broj_sertifikata"),
                            rs.getInt("proizvodjac_id"),
                            rs.getString("proizvodjac"),
                            rs.getString("sifra_vrsta_proizvodnje"),
                            rs.getString("naziv_vrsta_proizvodnje"),
                            rs.getDate("datum_kontrole"),
                            rs.getString("mesto_izdavanja"),
                            rs.getDate("datum_izdavanja"),
                            rs.getDate("vazi_do"),
                            rs.getString("asortiman_sifra"),
                            rs.getString("asortiman"),
                            rs.getString("tip_sertifikata_sifra"),
                            rs.getString("tip_sertifikata"),
                            rs.getString("rezerva1"),
                            rs.getString("rezerva2"),
                            rs.getString("rezerva3"),
                            rs.getBoolean("aktivan"),
                            rs.getDate("datum_vreme"),
                            rs.getString("kojeupisao")
                    );

                    sertifikatManagerList1.add(d);

                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            int i = 0;
        }
        return sertifikatManagerList1;
    }
}
