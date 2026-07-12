/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Room;
import util.DBConnection;
/**
 *
 * @author orian
 */
public class RoomDAO {
    
    public List<Room> getAllRooms(){
        List<Room> roomList = new ArrayList<>();
        try{
            Connection con = DBConnection.getConnection();
            String sql = "SELECT  room_id,room_number,room_type,price,room_status FROM room";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
             ResultSet rs = ps.executeQuery();
             
             while(rs.next()){
                 Room room = new Room();
                 room.setId(rs.getInt("room_id"));
                 room.setPrice(rs.getDouble("price"));
                 room.setRoom_num(rs.getString("room_number"));
                 room.setRoom_type(rs.getString("room_type"));
                 room.setStatus(rs.getBoolean("room_status"));
                 
                 roomList.add(room);
             }
       
        } catch(SQLException ex ){
            System.out.println("dao.RoomDAO.getAllRooms()");
            ex.printStackTrace();
        
        }
        return roomList;
    
    }
    
    public boolean checkRoom(int id){
            
            String sql = "SELECT EXISTS(SELECT 1 FROM room WHERE room_id = ?) AS id_exists";
            
            try(    Connection con = DBConnection.getConnection() ){
                
                 PreparedStatement ps = con.prepareStatement(sql);
                 
                 ps.setInt(1, id);
                 
                 try (ResultSet rs = ps.executeQuery()){
                     if(rs.next()){
                         return rs.getBoolean("id_exists");
                     }
                 }
                 
            } catch(SQLException ex){
                System.out.println("dao.RoomDAO.checkRoom()"+ex.toString());
                ex.printStackTrace();
            }
            return false;
        }
}
