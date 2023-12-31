/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 *
 * @author hecto
 */
public class Verificaciones {

    public boolean esEntero(String n) {
        try {
            Integer.parseInt(n);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public boolean esEnteroLargo(String n) {
        try {
            Long.parseLong(n);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
     public boolean esReal(String n) {
        try {
            Double.parseDouble(n);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public boolean esVacio(String text){
        return text.isEmpty() || text.isBlank();
    }
    
    
    
}
