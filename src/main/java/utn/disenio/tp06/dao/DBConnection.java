/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.disenio.tp06.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author kiriost
 */
public class DBConnection {
    private static final String dbHost = "localhost";
    private static final String dbName = "disenio_tp06";
    private static final String dbUser = "root";
    private static final String dbPass = "poqw2des";
    
    private Connection conn = null;
    
    public DBConnection ()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://" +dbHost + "/" + dbName,
                    dbUser, dbPass);
        }
        catch(SQLException exc) {
            System.out.println(exc);
        }
        catch(Exception exc) {
            System.out.println(exc);
        }
    }
    
    public Connection getConnection() {
        return conn;
    }
}
