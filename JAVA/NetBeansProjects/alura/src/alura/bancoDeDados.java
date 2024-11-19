/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alura;
import java.sql.*;
/**
 *
 * @author Bavaresco
 */
public class bancoDeDados {
    public Connection getConnection()throws SQLException{
     Connection conexao= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456789");
    return conexao;
}
}
