/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import dao.ReservationDAO;
import model.Reservation;
/**
 *
 * @author orian
 */
public class ReservationService {
    private final ReservationDAO resDAO = new ReservationDAO();
    public boolean makeReservation(Reservation res){
       
        return resDAO.InsertReservation(res);
        
    }
}
