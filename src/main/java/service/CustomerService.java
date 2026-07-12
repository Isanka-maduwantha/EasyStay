/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Customer;
import dao.CustomerDAO;
/**
 *
 * @author orian
 */
public class CustomerService {
        private final CustomerDAO customerDAO = new CustomerDAO();
        public boolean IscustomerRegisterSuccessfull(Customer customer){
            
            return customerDAO.saveCustomer(customer);
            
        }
        public boolean isCustoerValid(int id) {
                return customerDAO.checkCustomer(id);
        }
}
