package br.cefetmg.inf.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlConnection implements ConnectionFactory {

    private final static String dbDriver = "com.mysql.jdbc.Driver";
    private final static String dbURL = "jdbc:mysql://localhost:3306/bookregister";
    private final static String user = "root";
    private final static String pass = "";

    public MySqlConnection() {
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL, user, pass);
    }
    
    public static void main(String[] args) {
        try {
            ConnectionFactory cf = new MySqlConnection();            
            cf.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
