/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.com.minegocio.controller;


import ec.com.minegocio.exception.ControlException;
import ec.com.minegocio.model.Address;
import ec.com.minegocio.model.Customer;
import ec.com.minegocio.presenters.CustomerPresenters;
import ec.com.minegocio.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Maycol
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CustomerController {
    
    @Autowired
    CustomerService customerService;
    
    @GetMapping("customers")
    public List<Customer> getAllCustomers(){
        return  customerService.getAllCustomers();
    }
    
    @GetMapping("searchCustomer")
    public List<CustomerPresenters> getCustomerByNames(@RequestBody Customer name){
        return customerService.getCustomerByNames(name);
    }
    
    @PostMapping("addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    
    @PutMapping("editCustomer")
    public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer) {
        return customerService.editCustomer(customer);
    }
    
    @DeleteMapping("deleteCustomer")
    public ControlException deleteCustomerById(@RequestBody Customer customer) {
        return customerService.deleteCustomerByID(customer.getId());
    }
    
    @GetMapping("getAddress")
    public List<Address> getAddress(@RequestBody Customer customer) {
        return customerService.getAddress(customer.getId());
    }
    
    @PostMapping("addAddress")
    public ControlException addAddress( @RequestBody Customer customer) {
        return customerService.addAddres(customer);
    }
     
}
