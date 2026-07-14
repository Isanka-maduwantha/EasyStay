/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.ReservationForm;

/**
 *
 * @author orian
 */
public class ReservationController {
    private ReservationForm res;
    
    public ReservationController(ReservationForm res) {
        this.res = res;
    }
    public ReservationController(){}
    
    public boolean addReservation(String cus_id,String room_id,String amount) {
        
        try{
            int cusid = Integer.parseInt(cus_id);
            int roomid = Integer.parseInt(room_id);
            double tamount = Double.parseDouble(amount);
            model.Reservation rese = new model.Reservation();
            rese.setCus_id(cusid);
            rese.setRoom_id(roomid);
            rese.setAmount(tamount);
            
            return new service.ReservationService().makeReservation(rese);
        }
        catch(NumberFormatException ex){
            System.out.println("controller.ReservationController.addReservation()"+ex.toString());
        } catch( Exception pex) {
            System.out.print(pex.toString());
        }
        return false;
    }
    
}
