/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituracsv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mauricio
 */
public class bancoDeDados {
    public Connection getConnection()throws SQLException{
     Connection conexao= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
    return conexao;
}
}
