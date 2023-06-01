/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.com.minegocio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Maycol
 */
@ControllerAdvice
public class DefaultHandlerException extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<String> ControlException(ControlException ex){
      return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);  
    }
}
