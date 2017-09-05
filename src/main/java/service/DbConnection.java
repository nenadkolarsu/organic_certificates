/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ms
 */
public class DbConnection {

    private static Connection instance;

    public static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                    "jdbc:mysql://127.3.169.2:3306/organic?useUnicode=true&characterEncoding=utf-8", "adminlKgsNmf", "mCuhn2Wl6-CE");
//                        "jdbc:mysql://127.7.70.130:3306/organic?zeroDateTimeBehavior=convertToNull", "adminBe57pC3","Tn981skMvl47");
//                 "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root","");
            //      useUnicode=true&characterEncoding=utf-8 
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

    public static Connection getInstance() {
        Connection aa = null;
        if (instance == null) {
            aa = getDBConnection();
        }

        return aa;
    }
}
