/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author orian
 */
public class DBConnection {
    private static final String username  = "root";
    private static final String password = "RootPass123!";
    private static  final String url = "jdbc:mysql://localhost:3306/easystay?useSSL=false";
    private static Connection con = null;
    public static Connection getConnection() throws SQLException {
        if (con == null || con.isClosed())
        {
            try{ 
                con = DriverManager.getConnection(url,username, password);  
                System.out.println("New Database Connection Created");
            }
            catch (SQLException ex){
                System.err.println("Sql Error :" + ex.toString());
            } 
            catch (Exception ex) {
                System.err.println("Error "+ ex.toString());
            }
        }
        else {
            System.out.println("Existing Database Connection Shared");
        }
        return  con;    } 
    
    public static boolean closeConnection(){
        try {
            con.close();
            System.err.println("Database Connection Closing Successfull...!");
            return true;
        } catch (SQLException ex) 
        {
            System.err.println("Database Connection Closing Error"+ ex.toString());
            return false;
        }
    }
}
