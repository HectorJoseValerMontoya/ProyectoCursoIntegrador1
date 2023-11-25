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
import modelos.Personal;

/**
 *
 * @author HJVM
 */
public class daoEmpleado {

    public List<Personal> listarEmpleados() {
        List<Personal> empleados = new ArrayList<>();
        String sql = "select  * from empleado;";
        Connection con = null;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Personal p = new Personal();
                p.setCodEmpeado(rs.getInt(1));
                p.setCodFichaEmpleado(rs.getString(2));
                p.setApellidoEmpleado(rs.getString(3));
                p.setNombreEmpleado(rs.getString(4));
                p.setProceso(rs.getString(5));
                p.setAreaEmpleado(rs.getString(6));
                p.setPasswordEmpleado(rs.getString(7));

                empleados.add(p);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }

        return empleados;
    }

    public Personal buscarEmpleado(String codFichaEmpleado) {
        Personal p = null;
        String sql = "select  * from empleado where codFichaEmpleado = ?;";
        Connection con = null;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, codFichaEmpleado);
            rs = ps.executeQuery();
            if (rs.next()) {
                p = new Personal();
                p.setCodEmpeado(rs.getInt(1));
                p.setCodFichaEmpleado(rs.getString(2));
                p.setApellidoEmpleado(rs.getString(3));
                p.setNombreEmpleado(rs.getString(4));
                p.setProceso(rs.getString(5));
                p.setAreaEmpleado(rs.getString(6));
                p.setPasswordEmpleado(rs.getString(7));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }

        return p;
    }

    public Personal buscarEmpleado(int codEmpleado) {
        Personal p = null;
        String sql = "select  * from empleado where codEmpleado = ?;";
        Connection con = null;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codEmpleado);
            rs = ps.executeQuery();
            if (rs.next()) {
                p = new Personal();
                p.setCodEmpeado(rs.getInt(1));
                p.setCodFichaEmpleado(rs.getString(2));
                p.setApellidoEmpleado(rs.getString(3));
                p.setNombreEmpleado(rs.getString(4));
                p.setProceso(rs.getString(5));
                p.setAreaEmpleado(rs.getString(6));
                p.setPasswordEmpleado(rs.getString(7));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }

        return p;
    }

    public void AgregarEmpleado(Personal p) {
        String sql = "insert into empleado values (null, ?,?,?,?,?,?);";
        Connection con = null;
        PreparedStatement ps;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, "SD" + p.getCodFichaEmpleado());
            ps.setString(2, p.getApellidoEmpleado());
            ps.setString(3, p.getNombreEmpleado());
            ps.setString(4, p.getProceso());
            ps.setString(5, p.getAreaEmpleado());
            ps.setString(6, p.getPasswordEmpleado());

            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }

    }

    public void EliminarEmpleado(Personal p) {
        String sql = "delete from empleado where codEmpleado = ?;";
        Connection con;
        PreparedStatement ps;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCodEmpeado());

            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }
    }
    
    public void actualizarEmpleado(Personal p){
        String sql = "update empleado set proceso = ?, area = ?, contra = ? where codEmpleado = ?;";
        Connection con;
        PreparedStatement ps;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getProceso());
            ps.setString(2, p.getAreaEmpleado());
            ps.setString(3, p.getPasswordEmpleado());
            ps.setInt(4, p.getCodEmpeado());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }
    }
}
