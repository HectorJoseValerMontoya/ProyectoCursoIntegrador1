/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author HJVM
 */
public class DetalleFactura {
    private int codDetalleFactura;
    private int codFactura;
    private int codActividad;
    private long CantidadDeActividad;
    private double costoSubtotal;

    public int getCodDetalleFactura() {
        return codDetalleFactura;
    }

    public void setCodDetalleFactura(int codDetalleFactura) {
        this.codDetalleFactura = codDetalleFactura;
    }

    public int getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(int codFactura) {
        this.codFactura = codFactura;
    }

    public int getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(int codActividad) {
        this.codActividad = codActividad;
    }

    public long getCantidadDeActividad() {
        return CantidadDeActividad;
    }

    public void setCantidadDeActividad(long CantidadDeActividad) {
        this.CantidadDeActividad = CantidadDeActividad;
    }

    public double getCostoSubtotal() {
        return costoSubtotal;
    }

    public void setCostoSubtotal(double costoSubtotal) {
        this.costoSubtotal = costoSubtotal;
    }
    
    
    
}
