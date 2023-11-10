/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Actividad;

/**
 *
 * @author HJVM
 */
public class daoActividad {
    public List<Actividad> listarActividades(){
        List<Actividad> actividades = new ArrayList<>();
        String sql = "select  * from actividad;";
        Connection con = null;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Actividad a = new Actividad();
                a.setCodActividad(rs.getInt(1));
                a.setCodNombreActividad(rs.getString(2));
                a.setPrecioUnitarioActividad(rs.getDouble(3));
                a.setDescripcionActividad(rs.getString(4));

                actividades.add(a);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }

        return actividades;
    }
    
    
    
    public Actividad buscarActividad(int codActividad){
        String sql = "select  * from actividad where codActividad = ?;";
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        Actividad a = null;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codActividad);
            rs = ps.executeQuery();
            if (rs.next()) {
                a = new Actividad();
                a.setCodActividad(rs.getInt(1));
                a.setCodNombreActividad(rs.getString(2));
                a.setPrecioUnitarioActividad(rs.getDouble(3));
                a.setDescripcionActividad(rs.getString(4));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }

        return a;
    }
}
