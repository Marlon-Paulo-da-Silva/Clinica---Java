/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
//import java.sql.Statement;
 import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marlon Paulo
 */
public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/dbClinica";
    private static final String USER = "root";
    private static final String PASS = "";
    //public Connection con;
    //public Statement stm;
    public ResultSet rs;
    
    
    public static Connection getConnection(){
        
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
                    
                    
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("ERRO na conexão",ex);
        }
    }
    
    
    
    
    
    public static void closeConnection(Connection con){
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
     public static void closeConnection(Connection con, PreparedStatement stm){
        
         closeConnection(con);
         
         try {
             if(stm != null)
             {
                 stm.close();
             }
            
        } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
     
     public static void closeConnection(Connection con, PreparedStatement stm, ResultSet rs){
        
         closeConnection(con, stm);
         
         try {
             if(rs != null)
             {
                 rs.close();
             }
            
        } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}
