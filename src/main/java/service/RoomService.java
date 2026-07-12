/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.RoomDAO;
import java.util.List;
import model.Room;

/**
 *
 * @author orian
 */
public class RoomService {
    private final RoomDAO roomDAO = new RoomDAO();
    
    public List<Room> getRoomReport() {
        List <Room> rooms = roomDAO.getAllRooms();
        
        for(Room room: rooms) {
            if(room.isStatus() == true) {
                room.setStatus_Name("Avialiable");
            } else room.setStatus_Name("Reserved");
        }
        return rooms;
    }
}
