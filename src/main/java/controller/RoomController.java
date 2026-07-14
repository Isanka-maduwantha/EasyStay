/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.JTable;
import model.Room;
import service.RoomService;
import view.Rooms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author orian
 */
public class RoomController {
    private JTable roomTable;
    private Rooms view;
    private final RoomService roomService = new RoomService();

    public RoomController( Rooms view){
        this.view = view;
//        this.roomTable = table;
    }
        public RoomController(){
     

    }
    public void handleRoomData(){
        List<Room> rooms = roomService.getRoomReport();
          
         DefaultTableModel model = (DefaultTableModel) view.tbl_rooms.getModel();
         
         model.setRowCount(0);
         
         for(Room room: rooms){
             Object[] row = { room.getId(), room.getRoom_num(),room.getRoom_type(),room.getPrice(),room.getStatus_Name()};
             model.addRow(row);
         }
    }

            public boolean roomExist(String room_id){
            try {
                int id = Integer.parseInt(room_id);
                return roomService.isRoomValid(id);
            }catch(Exception ex){
                System.out.println("controller.RoomController.roomExist()"+ex.toString());
            }
            return false;
        }
            public String roomPrice(String id){
            
               try{ 
                   int roomid = Integer.parseInt(id);
                   return roomService.getRoomPrice(roomid);
               } catch(NumberFormatException ex){
                   System.out.println(ex.toString());
               }
               return "";
            }

}
