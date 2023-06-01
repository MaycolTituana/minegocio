/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.com.minegocio.service;

import ec.com.minegocio.exception.ControlException;
import ec.com.minegocio.model.Address;
import ec.com.minegocio.model.Customer;
import ec.com.minegocio.repository.AddressRepository;
import ec.com.minegocio.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maycol
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;
    
    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Customer addCustomer(Customer customer){
        
        return customerRepository.save(customer);
    }
    
    
    
    public ResponseEntity<List<Customer>> getAllCustomers3() {
        List<Customer> customers = customerRepository.findAll();
        List<Customer> customerDtoList = new ArrayList<>();

        for (Customer customer : customers) {
            Customer customerDto = new Customer();
            customerDto.setId(customer.getId());
            customerDto.setIdentificationType(customer.getIdentificationType());
            customerDto.setIdentificationNumber(customer.getIdentificationNumber());
            customerDto.setNames(customer.getNames());
            customerDto.setEmail(customer.getEmail());
            customerDto.setCellphone(customer.getCellphone());
                
            /*Address address = customer.getAddress();
            Address addressDto = new Address();
            addressDto.setId(address.getId());
            addressDto.setProvince(address.getProvince());
            addressDto.setCity(address.getCity());
            addressDto.setAddress(address.getAddress());
            addressDto.setMainAddress(address.getMainAddress());
            //addressDto.setCustomer(address.getCustomer());*/

            //customerDto.setAddress(addressDto);

            customerDtoList.add(customerDto);
        }

        return ResponseEntity.ok(customerDtoList);
    }

    public ResponseEntity<List<Customer>> getCustomerByNames(String names) {
        List<Customer> customers = customerRepository.findByNamesContainingIgnoreCase(names);

        if (!customers.isEmpty()) {
            return ResponseEntity.ok(customers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //Edit customer data
    public ResponseEntity<Customer> editCustomer(Customer customer) {
        //try {
            
            List<Customer> customers = customerRepository.findAll();
            for (int i = 0; i < customers.size(); i++) {
                Customer currentCustomer = customers.get(i);
                if (!currentCustomer.getId().equals(customer.getId())) {
                    throw new ControlException("ID not exits");
                    
                }else{
                    // New customer data
                    currentCustomer.setIdentificationType(customer.getIdentificationType());
                    currentCustomer.setIdentificationNumber(customer.getIdentificationNumber());
                    currentCustomer.setNames(customer.getNames());
                    currentCustomer.setEmail(customer.getEmail());
                    currentCustomer.setCellphone(customer.getCellphone());
                    
                    // Update customer
                    customerRepository.save(currentCustomer);
                    return ResponseEntity.ok(currentCustomer);
                }
            }
            
            return ResponseEntity.notFound().build();
       // } catch (Exception e) {
         //   throw new CustomException("Error al editar el cliente: " + e.getMessage());
        //}
    }

 
}
