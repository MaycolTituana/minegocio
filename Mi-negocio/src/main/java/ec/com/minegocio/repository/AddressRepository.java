/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.com.minegocio.repository;

import ec.com.minegocio.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Maycol
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
