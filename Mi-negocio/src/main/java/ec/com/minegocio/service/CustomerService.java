/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.com.minegocio.service;

import ec.com.minegocio.exception.ControlException;
import ec.com.minegocio.model.Address;
import ec.com.minegocio.model.Customer;
import ec.com.minegocio.presenters.CustomerPresenters;
import ec.com.minegocio.repository.AddressRepository;
import ec.com.minegocio.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    // LIST OF CUSTOMERS
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Customer addCustomer(Customer customer){
        
        return customerRepository.save(customer);
    }
    
    //SEARCH BY NAME
    
    public List<CustomerPresenters> getCustomerByNames(Customer customer) {
        List<Customer> customers = customerRepository.findByNamesContainingIgnoreCase(customer.getNames());
        List<CustomerPresenters> presenters = new ArrayList();
        
        for (Customer currentCustomer : customers) {
            List<Address> addresses = currentCustomer.getAddresses();
            for(Address currentAdresses : addresses){
                CustomerPresenters presenter= new CustomerPresenters();
                if(currentAdresses.getMainAddress()){
                    presenter.setIdentificationType(currentCustomer.getIdentificationType());
                    presenter.setIdentificationNumber(currentCustomer.getIdentificationNumber());
                    presenter.setNames(currentCustomer.getNames());
                    presenter.setEmail(currentCustomer.getEmail());
                    presenter.setCellphone(currentCustomer.getCellphone());
                    presenter.setProvince(currentAdresses.getProvince());
                    presenter.setCity(currentAdresses.getCity());
                    presenter.setAddress(currentAdresses.getAddress());
                    presenters.add(presenter);
                }
            }
           
        }
        return presenters;
    }
    
    //EDIT CUSTOMER DATA
    
    public ResponseEntity<Customer> editCustomer(Customer customer) {
        List<Customer> customers = customerRepository.findAll();
        
        for (Customer currentCustomer : customers) {
            if (!currentCustomer.getId().equals(customer.getId()) && currentCustomer.getIdentificationNumber().equals(customer.getIdentificationNumber())){
                
                throw new ControlException("Customer with the same identification number already exists");
            }
        }  
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getId());
        if (optionalCustomer.isPresent()) {
            // New customer data
            Customer currentCustomer = optionalCustomer.get();
            currentCustomer.setIdentificationType(customer.getIdentificationType());
            currentCustomer.setIdentificationNumber(customer.getIdentificationNumber());
            currentCustomer.setNames(customer.getNames());
            currentCustomer.setEmail(customer.getEmail());
            currentCustomer.setCellphone(customer.getCellphone());
            customerRepository.save(currentCustomer);
            return ResponseEntity.ok(currentCustomer);
        } else{
            throw new ControlException("Customer not found with ID: " + customer.getId());
        }
    }
    
    //DELETE CUSTOMER BY ID
    public ControlException deleteCustomerByID(Long id){
        List<Customer> customers = customerRepository.findAll();
        // Search identification number
        for (Customer currentCustomer : customers) {
            if (currentCustomer.getId().equals(id)) {
                customerRepository.deleteById(id);
                throw new ControlException("Client successfully removed");
            }
        }
        throw new ControlException("Customer not found with ID: " + id);
    }
    
    //LIST OF ADDRESS BY ID CUSTOMER
    public List<Address> getAddress(Long id){
        List<Customer> customers = customerRepository.findAll();
        List<Address> addresses;
        // Search identification number
        for (Customer currentCustomer : customers) {
            if (currentCustomer.getId().equals(id)) {
                return currentCustomer.getAddresses();
            }
        }
        throw new ControlException("Customer not found with ID: " + id);
    }
    
    //ADD ADDRESSES BY ID CUSTOMER
    public ControlException addAddres(Customer customer){
        List<Customer> customers = customerRepository.findAll();
        // Search identification number
        for (Customer currentCustomer : customers) {
            if (currentCustomer.getId().equals(customer.getId())) {
                List<Address> addresses = currentCustomer.getAddresses();
                //Update data
                Address sucursal = customer.getAddresses().get(0);
                sucursal.setMainAddress(false);
                addresses.add(sucursal);
                //New Address
                currentCustomer.setAddresses(addresses);
                customerRepository.save(currentCustomer);
                throw new ControlException("Address successfully saved");
                
            }
        }
        throw new ControlException("Customer not found with ID: " + customer.getId());
    }
    
}
