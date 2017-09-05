/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Kupac;
import static service.DbConnection.getDBConnection;

/**
 *
 * @author ms
 */
public class CustomerManager {

    ArrayList<Kupac> kupacManagerList = new ArrayList<>();
    private Integer Id;

    public CustomerManager() {

        try {
            String query = "select * from kupac";
            System.out.println(query);
            Class.forName("com.mysql.jdbc.Driver");

            try (Connection con = getDBConnection()) {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.executeQuery();
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Kupac d = new Kupac(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("maticni_broj"),
                            rs.getString("pib"),
                            rs.getString("pdv_potvrda"),
                            rs.getString("adresa"),
                            rs.getString("mesto"),
                            rs.getString("racun")
                    );
                    kupacManagerList.add(d);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            int i = 0;
        }
    }

    public List<Kupac> getKupacList() {
        return kupacManagerList;
    }

    public Kupac vratiKupca(Integer Id) {
        this.Id = Id;
        Kupac d = new Kupac();
        try {
            String query = "select * from kupac where id = " + Id;
            System.out.println(query);
            Class.forName("com.mysql.jdbc.Driver");

            try (Connection con = getDBConnection()) {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.executeQuery();
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    d = new Kupac(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("maticni_broj"),
                            rs.getString("pib"),
                            rs.getString("pdv_potvrda"),
                            rs.getString("adresa"),
                            rs.getString("mesto"),
                            rs.getString("racun")
                    );
                    return d;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            int i = 0;
        }
        return d;
    }

    public Map<String, String> vratiKupce() {

        Map< String, String> kupci = new HashMap<>();

        try {
            String query = "select * from kupac";
            System.out.println(query);
            Class.forName("com.mysql.jdbc.Driver");

            try (Connection con = getDBConnection()) {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.executeQuery();
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    kupci.put(rs.getString("id"), rs.getString("name"));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            int i = 0;
        }
        return kupci;
    }

    List<Kupac> vratiKupca(String id) {
        kupacManagerList.clear();
        try {
            String query = "select * from kupac where id = '" + id + "'";
            System.out.println(query);
            Class.forName("com.mysql.jdbc.Driver");

            try (Connection con = getDBConnection()) {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.executeQuery();
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Kupac d = new Kupac(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("maticni_broj"),
                            rs.getString("pib"),
                            rs.getString("pdv_potvrda"),
                            rs.getString("adresa"),
                            rs.getString("mesto"),
                            rs.getString("racun")
                    );
                    kupacManagerList.add(d);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            int i = 0;
        }
        return kupacManagerList;
    }

}
