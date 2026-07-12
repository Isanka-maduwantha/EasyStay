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
    private final CustomerService cusService =  new CustomerService();
        public boolean customerRegister(String name,String email,String phone,Date dob,String nic){
                        Customer cus = new Customer();
            cus.setName(name);
            cus.setNic(nic);
            cus.setEmail(email);
            cus.setPhone(phone);
            cus.setDob(dob);
            
            return cusService.IscustomerRegisterSuccessfull(cus);
        }
        public boolean customerExist(String cus_id){
            try {
                int id = Integer.parseInt(cus_id);
                return cusService.isCustoerValid(id);
            }catch(Exception ex){
                System.out.println("controller.CustomerController.customerExist()"+ex.toString());
            }
            return false;
        }
}
