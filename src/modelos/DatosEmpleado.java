/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author hecto
 */
public class DatosEmpleado {

    private String nombreEmpleado, apellidoEmpleado, codFichaEmpleado, areaEmpleado, passwordEmpleado;
    private int codEmpeado;

    private String proceso;
    String area;

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombre) {
        this.nombreEmpleado = nombre;
    }

    public String getCodFichaEmpleado() {
        return codFichaEmpleado;
    }

    public void setCodFichaEmpleado(String codigo) {
        this.codFichaEmpleado = codigo;
    }

    public String getAreaEmpleado() {
        return areaEmpleado;
    }

    public void setAreaEmpleado(String area) {
        this.areaEmpleado = area;
    }

    public String getPasswordEmpleado() {
        return passwordEmpleado;
    }

    public void setPasswordEmpleado(String password) {
        this.passwordEmpleado = password;
    }

    public int getCodEmpeado() {
        return codEmpeado;
    }

    public void setCodEmpeado(int codEmpeado) {
        this.codEmpeado = codEmpeado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
