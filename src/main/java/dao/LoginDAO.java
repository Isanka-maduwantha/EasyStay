/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import model.User;
import util.DBConnection;
/**
 *
 * @author orian
 */
public class LoginDAO {
    Connection con = null;
    public User getUser(String username,String password){
        User user = null;
        try{
             con = DBConnection.getConnection();
             String query = "SELECT user_id,username,password FROM user WHERE username = ? AND password = ?";
             PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1, username);
             ps.setString(2,password);
           try (ResultSet rs =  ps.executeQuery()) {
               if(rs.next()){
                   user = new User();
                   user.setUsername(rs.getString("username"));
                   user.setPassword(rs.getString("password"));
                   user.setId(rs.getInt("user_id"));
                   user.setName(rs.getString("name"));
                } else {
                    
                   System.out.println("No record found with the given Username and Password .");
               }
           } 
           
             
        } catch(SQLException ex){
              ex.printStackTrace();
        }
        return user;
    
    }
}
