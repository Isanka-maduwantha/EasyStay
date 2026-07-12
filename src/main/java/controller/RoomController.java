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

    public RoomController( Rooms view){
        this.view = view;
//        this.roomTable = table;
    }
    public void handleRoomData(){
        List<Room> rooms = new RoomService().getRoomReport();
          
         DefaultTableModel model = (DefaultTableModel) view.tbl_rooms.getModel();
         
         model.setRowCount(0);
         
         for(Room room: rooms){
             Object[] row = { room.getId(), room.getRoom_num(),room.getRoom_type(),room.getPrice(),room.getStatus_Name()};
             model.addRow(row);
         }
    }
}
