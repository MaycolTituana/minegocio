/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.com.minegocio.controller;


import ec.com.minegocio.model.Customer;
import ec.com.minegocio.service.CustomerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("all")
    public ResponseEntity<List<Customer>> getAllCustomers1() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
    
    @GetMapping("search")
    public ResponseEntity<List<Customer>> getCustomerByNames(@RequestParam("name")String name){
        return customerService.getCustomerByNames(name);
    }
    
    @PostMapping("newCustomer")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    
    @PutMapping("editCustomer")
    public ResponseEntity<?> editCustomer(@RequestBody Customer customer) {

            return customerService.editCustomer(customer);
    }
    
}
