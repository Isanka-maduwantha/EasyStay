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
        

        return rooms;
    }
            public boolean isRoomValid(int id) {
                return roomDAO.checkRoom(id);
        }
    public String  getRoomPrice(int id){
        return roomDAO.getRoom(id).getPrice() +"";
    }
}
