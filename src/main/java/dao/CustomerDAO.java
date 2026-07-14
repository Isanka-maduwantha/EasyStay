///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Customer;
import util.DBConnection;
///**
// *
// * @author orian
// */
public class CustomerDAO {

        public boolean saveCustomer(Customer cus){
            String sql = "INSERT INTO customer (name,nic,phone,email,dob) VALUES (?,?,?,?,?)";
            
            try(Connection con = DBConnection.getConnection()){ 
              
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
        public boolean checkCustomer(int id){
            
            String sql = "SELECT EXISTS(SELECT 1 FROM customer WHERE customer_id = ?) AS id_exists";
            
            try(    Connection con = DBConnection.getConnection() ){
                
                 PreparedStatement ps = con.prepareStatement(sql);
                 
                 ps.setInt(1, id);
                 
                 try (ResultSet rs = ps.executeQuery()){
                     if(rs.next()){
                         return rs.getBoolean("id_exists");
                     }
                 }
                 
            } catch(SQLException ex){
                System.out.println("dao.CustomerDAO.checkCustomer()"+ ex.toString());
                ex.printStackTrace();
            }
            return false;
        }
        
                public Customer getCustomer(int id){
            Customer cus = null;
            String sql = "SELECT  customer_id,name,nic,phone,email from customer where customer_id = ? ";
            
            try(    Connection con = DBConnection.getConnection() ){
                
                 PreparedStatement ps = con.prepareStatement(sql);
                 
                 ps.setInt(1, id);
                 
                 try (ResultSet rs = ps.executeQuery()){
                     
                     if(rs.next()){
                         cus = new Customer();
                         cus.setId(rs.getInt("customer_id"));
                         cus.setName(rs.getString("name"));
                         cus.setNic(rs.getString("nic"));
                         cus.setPhone(rs.getString("phone"));
                         cus.setEmail(rs.getString("email"));
                         cus.setDob(rs.getDate("dob"));
                         return cus;
                     }
                 }
                 
            } catch(SQLException ex){
                System.out.println("dao.CustomerDAO.getCustomer()"+ex.toString());
            }
            return cus;
        }
}
