/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 *
 * @author HJVM
 */
public class Controlar {
    
    public String completarCod(String cod){
        String temp = "";
        
        
        for (int i = cod.length(); i < 6; i++) {
            temp += "0";
        }
        temp += cod;
        
        return temp;
        
    }
}
