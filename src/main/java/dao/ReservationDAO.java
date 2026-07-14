/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reservation;
import util.DBConnection;

/**
 *
 * @author orian
 */
public class ReservationDAO {
    public boolean InsertReservation(Reservation res) {
       String sql = "INSERT INTO reservation (customer_id,room_id,total_amount) VALUES (?,?,?) ";
    
    try(Connection con = DBConnection.getConnection() ){
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, res.getCus_id());
        ps.setInt(2, res.getRoom_id());
        ps.setDouble(3, res.getAmount());
        return ps.executeUpdate() == 1;
        
    } catch(SQLException ex){
        System.out.println("dao.ReservationDAO.InsertReservation()"+ ex.toString());
    }
        return false;
    }
    
    public List<Reservation> getReservations(){
        List<Reservation> reservations = new ArrayList<>();
        String sql = "Select reservation_id,customer_id,room_id,check_in,check_out,total_amount FROM reservation";
        
        try(Connection con = DBConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Reservation res = new Reservation();
                res.setReserv_id(rs.getInt("reservation_id"));
                res.setCus_id(rs.getInt("customer_id"));
                res.setRoom_id(rs.getInt("room_id"));
                res.setCheckIn(rs.getDate("check_in"));
                res.setCheckOut(rs.getDate("chcek_out"));
                res.setAmount(rs.getDouble("total_amount"));
                
                reservations.add(res);
            }
        
        }catch (SQLException ex){
            
                 System.out.println(ex.toString());
                 
        }
        return reservations;
    }
}
