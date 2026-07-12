/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Date;
import model.Customer;
import service.CustomerService;
/**
 *
 * @author orian
 */
public class CustomerController {
        public boolean customerRegister(String name,String email,String phone,Date dob,String nic){
                        Customer cus = new Customer();
            cus.setName(name);
            cus.setNic(nic);
            cus.setEmail(email);
            cus.setPhone(phone);
            cus.setDob(dob);
            
            return new CustomerService().IscustomerRegisterSuccessfull(cus);
        }
}
