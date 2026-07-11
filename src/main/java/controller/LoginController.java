/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import service.LoginService;
/**
 *
 * @author orian
 */
public class LoginController {
    
    public boolean validateLogin(String username,String password) {
        return new LoginService().isUserAvialable(username, password);
        
    }
    
}
