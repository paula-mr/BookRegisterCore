/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.util.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class ConnectionManager {
    private static ConnectionManager conexao;
    private static ConnectionFactory cf;

    private ConnectionManager() {
         ConnectionManager.cf = new MySqlConnection();
    }

    public static ConnectionManager getInstance() {
        if(conexao == null)
            conexao = new ConnectionManager();

        return conexao;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        return ConnectionManager.cf.getConnection();
    }
}
