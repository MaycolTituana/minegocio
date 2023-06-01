/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.com.minegocio.exception;

/**
 *
 * @author Maycol
 */
public class ControlException extends RuntimeException {
    public static final long serialVersionUID = 8852049938063608993L;
    private String message;

    public ControlException(String message) {
        super();
        this.message = message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
