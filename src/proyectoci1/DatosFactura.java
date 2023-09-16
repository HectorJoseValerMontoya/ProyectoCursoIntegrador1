/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoci1;

//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hecto
 */
public class DatosFactura extends DatosEmpleado {
    //Extiende empleado
    public List<Factura> factura = new ArrayList<>();
    public double costoTotalDeTodo = -1;
    public String responsable;
    String fecha;
}
