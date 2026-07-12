/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Customer;

/**
 *
 * @author orian
 */
public class CustomerService {
    
        public boolean IscustomerRegisterSuccessfull(Customer customer){
            
            return new dao.CustomerDAO().saveCustomer(customer);
            
        }
}
