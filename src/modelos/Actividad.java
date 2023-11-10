/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author HJVM
 */
public class Actividad {

    public Actividad() {
    }

    public Actividad(int codActividad, String codNombreActividad, double precioUnitarioActividad, String descripcionActividad) {
        this.codActividad = codActividad;
        this.codNombreActividad = codNombreActividad;
        this.precioUnitarioActividad = precioUnitarioActividad;
        this.descripcionActividad = descripcionActividad;
    }
    private int codActividad;
    private String codNombreActividad;
    private double precioUnitarioActividad;
    private String descripcionActividad;

    
    
    public String getCodNombreActividad() {
        return codNombreActividad;
    }

    public void setCodNombreActividad(String codActividad) {
        this.codNombreActividad = codActividad;
    }

    public double getPrecioUnitarioActividad() {
        return precioUnitarioActividad;
    }

    public void setPrecioUnitarioActividad(double precioUnitarioActividad) {
        this.precioUnitarioActividad = precioUnitarioActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public int getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(int codActividad) {
        this.codActividad = codActividad;
    }

}
