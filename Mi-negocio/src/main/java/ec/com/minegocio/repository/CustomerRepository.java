/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.com.minegocio.repository;

import ec.com.minegocio.model.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Maycol
 */
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    List<Customer> findByNamesContainingIgnoreCase(String name);
    Customer findByIdentificationNumber(String identificationNumber);
}
