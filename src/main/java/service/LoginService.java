/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import model.User;
/**
 *
 * @author orian
 */
public class LoginService {
    public boolean isUserAvialable(String username,String password){
        try {
            User user = new dao.LoginDAO().getUser(username, password);
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                return true;
            }
        } catch (Exception ex) {
            System.out.println("service.LoginService.isUserAvialable()"+ ex.toString());
           
        }
    return false;
    }
}
