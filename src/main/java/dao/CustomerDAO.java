///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Customer;
import util.DBConnection;
///**
// *
// * @author orian
// */
public class CustomerDAO {

        public boolean saveCustomer(Customer cus){
           try{ 
               
               Connection con = DBConnection.getConnection();
               String sql = "INSERT INTO customer (name,nic,phone,email,dob) VALUES (?,?,?,?,?)";
               
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1,cus.getName());
               ps.setString(2, cus.getNic());
                 ps.setString(3, cus.getPhone());
                   ps.setString(4, cus.getEmail());
                     ps.setDate(5, cus.getDob());
                     
               return ps.executeUpdate() == 1;
           } catch(SQLException ex) {
               System.out.println("dao.CustomerDAO.saveCustomer()"+ ex.toString());
           }
           return false;
        }
}
